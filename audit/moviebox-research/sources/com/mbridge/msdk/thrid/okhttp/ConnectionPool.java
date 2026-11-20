package com.mbridge.msdk.thrid.okhttp;

import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RouteDatabase;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okhttp.internal.platform.Platform;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final RouteDatabase routeDatabase;

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i11, long j11, TimeUnit timeUnit) {
        this.cleanupRunnable = new Runnable() { // from class: com.mbridge.msdk.thrid.okhttp.ConnectionPool.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jCleanup = ConnectionPool.this.cleanup(System.nanoTime());
                    if (jCleanup == -1) {
                        return;
                    }
                    if (jCleanup > 0) {
                        long j12 = jCleanup / 1000000;
                        long j13 = jCleanup - (1000000 * j12);
                        synchronized (ConnectionPool.this) {
                            try {
                                ConnectionPool.this.wait(j12, (int) j13);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = i11;
        this.keepAliveDurationNs = timeUnit.toNanos(j11);
        if (j11 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j11);
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long j11) {
        List<Reference<StreamAllocation>> list = realConnection.allocations;
        int i11 = 0;
        while (i11 < list.size()) {
            Reference<StreamAllocation> reference = list.get(i11);
            if (reference.get() != null) {
                i11++;
            } else {
                Platform.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).callStackTrace);
                list.remove(i11);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j11 - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public long cleanup(long j11) {
        synchronized (this) {
            try {
                RealConnection realConnection = null;
                long j12 = Long.MIN_VALUE;
                int i11 = 0;
                int i12 = 0;
                for (RealConnection realConnection2 : this.connections) {
                    if (pruneAndGetAllocationCount(realConnection2, j11) > 0) {
                        i12++;
                    } else {
                        i11++;
                        long j13 = j11 - realConnection2.idleAtNanos;
                        if (j13 > j12) {
                            realConnection = realConnection2;
                            j12 = j13;
                        }
                    }
                }
                long j14 = this.keepAliveDurationNs;
                if (j12 < j14 && i11 <= this.maxIdleConnections) {
                    if (i11 > 0) {
                        return j14 - j12;
                    }
                    if (i12 > 0) {
                        return j14;
                    }
                    this.cleanupRunning = false;
                    return -1L;
                }
                this.connections.remove(realConnection);
                Util.closeQuietly(realConnection.socket());
                return 0L;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean connectionBecameIdle(RealConnection realConnection) {
        if (realConnection.noNewStreams || this.maxIdleConnections == 0) {
            this.connections.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    public Socket deduplicate(Address address, StreamAllocation streamAllocation) {
        for (RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, null) && realConnection.isMultiplexed() && realConnection != streamAllocation.connection()) {
                return streamAllocation.releaseAndAcquire(realConnection);
            }
        }
        return null;
    }

    public void evictAll() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<RealConnection> it = this.connections.iterator();
                while (it.hasNext()) {
                    RealConnection next = it.next();
                    if (next.allocations.isEmpty()) {
                        next.noNewStreams = true;
                        arrayList.add(next);
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Util.closeQuietly(((RealConnection) it2.next()).socket());
        }
    }

    public RealConnection get(Address address, StreamAllocation streamAllocation, Route route) {
        for (RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, route)) {
                streamAllocation.acquire(realConnection, true);
                return realConnection;
            }
        }
        return null;
    }

    public synchronized int idleConnectionCount() {
        int i11;
        Iterator<RealConnection> it = this.connections.iterator();
        i11 = 0;
        while (it.hasNext()) {
            if (it.next().allocations.isEmpty()) {
                i11++;
            }
        }
        return i11;
    }

    public void put(RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }
}
