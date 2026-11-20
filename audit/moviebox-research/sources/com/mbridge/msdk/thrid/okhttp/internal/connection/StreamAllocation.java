package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.Address;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.Interceptor;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Route;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpCodec;
import com.mbridge.msdk.thrid.okhttp.internal.http2.ConnectionShutdownException;
import com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode;
import com.mbridge.msdk.thrid.okhttp.internal.http2.StreamResetException;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;

    /* JADX INFO: compiled from: source.java */
    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        public StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new RouteSelector(address, routeDatabase(), call, eventListener);
        this.callStackTrace = obj;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    private Socket deallocate(boolean z11, boolean z12, boolean z13) {
        Socket socket;
        if (z13) {
            this.codec = null;
        }
        if (z12) {
            this.released = true;
        }
        RealConnection realConnection = this.connection;
        if (realConnection == null) {
            return null;
        }
        if (z11) {
            realConnection.noNewStreams = true;
        }
        if (this.codec != null) {
            return null;
        }
        if (!this.released && !realConnection.noNewStreams) {
            return null;
        }
        release(realConnection);
        if (this.connection.allocations.isEmpty()) {
            this.connection.idleAtNanos = System.nanoTime();
            if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                socket = this.connection.socket();
            } else {
                socket = null;
            }
        } else {
            socket = null;
        }
        this.connection = null;
        return socket;
    }

    private RealConnection findConnection(int i11, int i12, int i13, int i14, boolean z11) throws Throwable {
        RealConnection realConnection;
        Socket socketReleaseIfNoNewStreams;
        RealConnection realConnection2;
        Socket socketDeduplicate;
        Route next;
        boolean z12;
        boolean z13;
        RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            try {
                if (this.released) {
                    throw new IllegalStateException("released");
                }
                if (this.codec != null) {
                    throw new IllegalStateException("codec != null");
                }
                if (this.canceled) {
                    throw new IOException("Canceled");
                }
                realConnection = this.connection;
                socketReleaseIfNoNewStreams = releaseIfNoNewStreams();
                realConnection2 = this.connection;
                socketDeduplicate = null;
                if (realConnection2 != null) {
                    realConnection = null;
                } else {
                    realConnection2 = null;
                }
                if (!this.reportedAcquired) {
                    realConnection = null;
                }
                if (realConnection2 == null) {
                    Internal.instance.get(this.connectionPool, this.address, this, null);
                    RealConnection realConnection3 = this.connection;
                    if (realConnection3 != null) {
                        realConnection2 = realConnection3;
                        z12 = true;
                        next = null;
                    } else {
                        next = this.route;
                    }
                } else {
                    next = null;
                }
                z12 = false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Util.closeQuietly(socketReleaseIfNoNewStreams);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z12) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            this.route = this.connection.route();
            return realConnection2;
        }
        if (next != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z13 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z13 = true;
        }
        synchronized (this.connectionPool) {
            try {
                if (this.canceled) {
                    throw new IOException("Canceled");
                }
                if (z13) {
                    List<Route> all = this.routeSelection.getAll();
                    int size = all.size();
                    for (int i15 = 0; i15 < size; i15++) {
                        Route route = all.get(i15);
                        Internal.instance.get(this.connectionPool, this.address, this, route);
                        RealConnection realConnection4 = this.connection;
                        if (realConnection4 != null) {
                            this.route = route;
                            realConnection2 = realConnection4;
                            z12 = true;
                            break;
                        }
                    }
                }
                if (!z12) {
                    if (next == null) {
                        next = this.routeSelection.next();
                    }
                    this.route = next;
                    this.refusedStreamCount = 0;
                    realConnection2 = new RealConnection(this.connectionPool, next);
                    acquire(realConnection2, false);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (z12) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
            return realConnection2;
        }
        realConnection2.connect(i11, i12, i13, i14, z11, this.call, this.eventListener);
        routeDatabase().connected(realConnection2.route());
        synchronized (this.connectionPool) {
            try {
                this.reportedAcquired = true;
                Internal.instance.put(this.connectionPool, realConnection2);
                if (realConnection2.isMultiplexed()) {
                    socketDeduplicate = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                    realConnection2 = this.connection;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        Util.closeQuietly(socketDeduplicate);
        this.eventListener.connectionAcquired(this.call, realConnection2);
        return realConnection2;
    }

    private RealConnection findHealthyConnection(int i11, int i12, int i13, int i14, boolean z11, boolean z12) throws Throwable {
        while (true) {
            RealConnection realConnectionFindConnection = findConnection(i11, i12, i13, i14, z11);
            synchronized (this.connectionPool) {
                try {
                    if (realConnectionFindConnection.successCount == 0 && !realConnectionFindConnection.isMultiplexed()) {
                        return realConnectionFindConnection;
                    }
                    if (realConnectionFindConnection.isHealthy(z12)) {
                        return realConnectionFindConnection;
                    }
                    noNewStreams();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (realConnection.allocations.get(i11).get() == this) {
                realConnection.allocations.remove(i11);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection realConnection = this.connection;
        if (realConnection == null || !realConnection.noNewStreams) {
            return null;
        }
        return deallocate(false, false, true);
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public void acquire(RealConnection realConnection, boolean z11) {
        if (this.connection != null) {
            throw new IllegalStateException();
        }
        this.connection = realConnection;
        this.reportedAcquired = z11;
        realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            httpCodec = this.codec;
            realConnection = this.connection;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public boolean hasMoreRoutes() {
        RouteSelector.Selection selection;
        return this.route != null || ((selection = this.routeSelection) != null && selection.hasNext()) || this.routeSelector.hasNext();
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z11) {
        try {
            HttpCodec httpCodecNewCodec = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z11).newCodec(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = httpCodecNewCodec;
            }
            return httpCodecNewCodec;
        } catch (IOException e11) {
            throw new RouteException(e11);
        }
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket socketDeallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            socketDeallocate = deallocate(true, false, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void release() {
        RealConnection realConnection;
        Socket socketDeallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            socketDeallocate = deallocate(false, true, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            Internal.instance.timeoutExit(this.call, null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (this.codec != null || this.connection.allocations.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<StreamAllocation> reference = this.connection.allocations.get(0);
        Socket socketDeallocate = deallocate(true, false, false);
        this.connection = realConnection;
        realConnection.allocations.add(reference);
        return socketDeallocate;
    }

    public Route route() {
        return this.route;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0048  */
    public void streamFailed(IOException iOException) {
        RealConnection realConnection;
        boolean z11;
        Socket socketDeallocate;
        synchronized (this.connectionPool) {
            try {
                realConnection = null;
                if (iOException instanceof StreamResetException) {
                    ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                    if (errorCode == ErrorCode.REFUSED_STREAM) {
                        int i11 = this.refusedStreamCount + 1;
                        this.refusedStreamCount = i11;
                        if (i11 > 1) {
                            this.route = null;
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                    } else if (errorCode != ErrorCode.CANCEL) {
                        this.route = null;
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    RealConnection realConnection2 = this.connection;
                    if (realConnection2 == null || (realConnection2.isMultiplexed() && !(iOException instanceof ConnectionShutdownException))) {
                        z11 = false;
                    } else {
                        if (this.connection.successCount == 0) {
                            Route route = this.route;
                            if (route != null && iOException != null) {
                                this.routeSelector.connectFailed(route, iOException);
                            }
                            this.route = null;
                        }
                        z11 = true;
                    }
                }
                RealConnection realConnection3 = this.connection;
                socketDeallocate = deallocate(z11, false, true);
                if (this.connection == null && this.reportedAcquired) {
                    realConnection = realConnection3;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void streamFinished(boolean z11, HttpCodec httpCodec, long j11, IOException iOException) {
        RealConnection realConnection;
        Socket socketDeallocate;
        boolean z12;
        this.eventListener.responseBodyEnd(this.call, j11);
        synchronized (this.connectionPool) {
            if (httpCodec != null) {
                try {
                    if (httpCodec == this.codec) {
                        if (!z11) {
                            this.connection.successCount++;
                        }
                        realConnection = this.connection;
                        socketDeallocate = deallocate(z11, false, true);
                        if (this.connection != null) {
                            realConnection = null;
                        }
                        z12 = this.released;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            throw new IllegalStateException("expected " + this.codec + " but was " + httpCodec);
        }
        Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, iOException));
        } else if (z12) {
            Internal.instance.timeoutExit(this.call, null);
            this.eventListener.callEnd(this.call);
        }
    }

    public String toString() {
        RealConnection realConnectionConnection = connection();
        return realConnectionConnection != null ? realConnectionConnection.toString() : this.address.toString();
    }
}
