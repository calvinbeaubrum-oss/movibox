package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.AsyncTimeout;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.Sink;
import com.mbridge.msdk.thrid.okio.Source;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final Http2Connection connection;
    ErrorCode errorCode;
    private boolean hasResponseHeaders;
    private Header.Listener headersListener;
    private final Deque<Headers> headersQueue;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    final int f47330id;
    final StreamTimeout readTimeout;
    final FramingSink sink;
    private final FramingSource source;
    long unacknowledgedBytesRead = 0;
    final StreamTimeout writeTimeout;

    /* JADX INFO: compiled from: source.java */
    public final class FramingSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final Buffer sendBuffer = new Buffer();

        public FramingSink() {
        }

        private void emitFrame(boolean z11) throws IOException {
            Http2Stream http2Stream;
            long jMin;
            Http2Stream http2Stream2;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (true) {
                    try {
                        http2Stream = Http2Stream.this;
                        if (http2Stream.bytesLeftInWriteWindow > 0 || this.finished || this.closed || http2Stream.errorCode != null) {
                            break;
                        } else {
                            http2Stream.waitForIo();
                        }
                    } catch (Throwable th2) {
                        Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                        throw th2;
                    }
                }
                http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed();
                jMin = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                http2Stream2 = Http2Stream.this;
                http2Stream2.bytesLeftInWriteWindow -= jMin;
            }
            http2Stream2.writeTimeout.enter();
            try {
                Http2Stream http2Stream3 = Http2Stream.this;
                http2Stream3.connection.writeData(http2Stream3.f47330id, z11 && jMin == this.sendBuffer.size(), this.sendBuffer, jMin);
            } finally {
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                try {
                    if (this.closed) {
                        return;
                    }
                    if (!Http2Stream.this.sink.finished) {
                        if (this.sendBuffer.size() > 0) {
                            while (this.sendBuffer.size() > 0) {
                                emitFrame(true);
                            }
                        } else {
                            Http2Stream http2Stream = Http2Stream.this;
                            http2Stream.connection.writeData(http2Stream.f47330id, true, null, 0L);
                        }
                    }
                    synchronized (Http2Stream.this) {
                        this.closed = true;
                    }
                    Http2Stream.this.connection.flush();
                    Http2Stream.this.cancelStreamIfNecessary();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink
        public Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink
        public void write(Buffer buffer, long j11) throws IOException {
            this.sendBuffer.write(buffer, j11);
            while (this.sendBuffer.size() >= 16384) {
                emitFrame(false);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class FramingSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        private final Buffer receiveBuffer = new Buffer();
        private final Buffer readBuffer = new Buffer();

        public FramingSource(long j11) {
            this.maxByteCount = j11;
        }

        private void updateConnectionFlowControl(long j11) {
            Http2Stream.this.connection.updateConnectionFlowControl(j11);
        }

        @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            ArrayList arrayList;
            Header.Listener listener;
            synchronized (Http2Stream.this) {
                try {
                    this.closed = true;
                    size = this.readBuffer.size();
                    this.readBuffer.clear();
                    if (Http2Stream.this.headersQueue.isEmpty() || Http2Stream.this.headersListener == null) {
                        arrayList = null;
                        listener = null;
                    } else {
                        arrayList = new ArrayList(Http2Stream.this.headersQueue);
                        Http2Stream.this.headersQueue.clear();
                        listener = Http2Stream.this.headersListener;
                    }
                    Http2Stream.this.notifyAll();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            Http2Stream.this.cancelStreamIfNecessary();
            if (listener != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    listener.onHeaders((Headers) it.next());
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:46:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:48:0x00c9 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:49:0x00cb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:50:0x00cc  */
        @Override // com.mbridge.msdk.thrid.okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            long j12;
            Headers headers;
            Header.Listener listener;
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            while (true) {
                synchronized (Http2Stream.this) {
                    try {
                        Http2Stream.this.readTimeout.enter();
                        try {
                            Http2Stream http2Stream = Http2Stream.this;
                            ErrorCode errorCode = http2Stream.errorCode;
                            if (errorCode == null) {
                                errorCode = null;
                            }
                            if (this.closed) {
                                throw new IOException("stream closed");
                            }
                            if (!http2Stream.headersQueue.isEmpty() && Http2Stream.this.headersListener != null) {
                                headers = (Headers) Http2Stream.this.headersQueue.removeFirst();
                                listener = Http2Stream.this.headersListener;
                            } else if (this.readBuffer.size() > 0) {
                                Buffer buffer2 = this.readBuffer;
                                j12 = buffer2.read(buffer, Math.min(j11, buffer2.size()));
                                Http2Stream http2Stream2 = Http2Stream.this;
                                long j13 = http2Stream2.unacknowledgedBytesRead + j12;
                                http2Stream2.unacknowledgedBytesRead = j13;
                                if (errorCode == null && j13 >= http2Stream2.connection.okHttpSettings.getInitialWindowSize() / 2) {
                                    Http2Stream http2Stream3 = Http2Stream.this;
                                    http2Stream3.connection.writeWindowUpdateLater(http2Stream3.f47330id, http2Stream3.unacknowledgedBytesRead);
                                    Http2Stream.this.unacknowledgedBytesRead = 0L;
                                }
                                headers = null;
                                listener = null;
                                Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                                if (headers != null || listener == null) {
                                    if (j12 != -1) {
                                        updateConnectionFlowControl(j12);
                                        return j12;
                                    }
                                    if (errorCode == null) {
                                        return -1L;
                                    }
                                    throw new StreamResetException(errorCode);
                                }
                                listener.onHeaders(headers);
                            } else if (this.finished || errorCode != null) {
                                headers = null;
                                listener = null;
                            } else {
                                Http2Stream.this.waitForIo();
                                Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                            }
                            j12 = -1;
                            Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                            if (headers != null) {
                            }
                            if (j12 != -1) {
                                updateConnectionFlowControl(j12);
                                return j12;
                            }
                            if (errorCode == null) {
                                return -1L;
                            }
                            throw new StreamResetException(errorCode);
                        } catch (Throwable th2) {
                            Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        }

        public void receive(BufferedSource bufferedSource, long j11) throws IOException {
            boolean z11;
            boolean z12;
            long size;
            while (j11 > 0) {
                synchronized (Http2Stream.this) {
                    z11 = this.finished;
                    z12 = this.readBuffer.size() + j11 > this.maxByteCount;
                }
                if (z12) {
                    bufferedSource.skip(j11);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z11) {
                    bufferedSource.skip(j11);
                    return;
                }
                long j12 = bufferedSource.read(this.receiveBuffer, j11);
                if (j12 == -1) {
                    throw new EOFException();
                }
                j11 -= j12;
                synchronized (Http2Stream.this) {
                    try {
                        if (this.closed) {
                            size = this.receiveBuffer.size();
                            this.receiveBuffer.clear();
                        } else {
                            boolean z13 = this.readBuffer.size() == 0;
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (z13) {
                                Http2Stream.this.notifyAll();
                            }
                            size = 0;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (size > 0) {
                    updateConnectionFlowControl(size);
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Source
        public Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.mbridge.msdk.thrid.okio.AsyncTimeout
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.connection.sendDegradedPingLater();
        }
    }

    public Http2Stream(int i11, Http2Connection http2Connection, boolean z11, boolean z12, Headers headers) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        this.errorCode = null;
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        this.f47330id = i11;
        this.connection = http2Connection;
        this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
        FramingSource framingSource = new FramingSource(http2Connection.okHttpSettings.getInitialWindowSize());
        this.source = framingSource;
        FramingSink framingSink = new FramingSink();
        this.sink = framingSink;
        framingSource.finished = z12;
        framingSink.finished = z11;
        if (headers != null) {
            arrayDeque.add(headers);
        }
        if (isLocallyInitiated() && headers != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!isLocallyInitiated() && headers == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean closeInternal(ErrorCode errorCode) {
        synchronized (this) {
            try {
                if (this.errorCode != null) {
                    return false;
                }
                if (this.source.finished && this.sink.finished) {
                    return false;
                }
                this.errorCode = errorCode;
                notifyAll();
                this.connection.removeStream(this.f47330id);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addBytesToWriteWindow(long j11) {
        this.bytesLeftInWriteWindow += j11;
        if (j11 > 0) {
            notifyAll();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001a  */
    public void cancelStreamIfNecessary() throws IOException {
        boolean z11;
        boolean zIsOpen;
        synchronized (this) {
            try {
                FramingSource framingSource = this.source;
                if (framingSource.finished || !framingSource.closed) {
                    z11 = false;
                } else {
                    FramingSink framingSink = this.sink;
                    if (framingSink.finished || framingSink.closed) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                }
                zIsOpen = isOpen();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            close(ErrorCode.CANCEL);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream(this.f47330id);
        }
    }

    public void checkOutNotClosed() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException("stream closed");
        }
        if (framingSink.finished) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            throw new StreamResetException(this.errorCode);
        }
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (closeInternal(errorCode)) {
            this.connection.writeSynReset(this.f47330id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.f47330id, errorCode);
        }
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.f47330id;
    }

    public Sink getSink() {
        synchronized (this) {
            try {
                if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.sink;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.f47330id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        try {
            if (this.errorCode != null) {
                return false;
            }
            FramingSource framingSource = this.source;
            if (framingSource.finished || framingSource.closed) {
                FramingSink framingSink = this.sink;
                if ((framingSink.finished || framingSink.closed) && this.hasResponseHeaders) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public void receiveData(BufferedSource bufferedSource, int i11) throws IOException {
        this.source.receive(bufferedSource, i11);
    }

    public void receiveFin() {
        boolean zIsOpen;
        synchronized (this) {
            this.source.finished = true;
            zIsOpen = isOpen();
            notifyAll();
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.f47330id);
    }

    public void receiveHeaders(List<Header> list) {
        boolean zIsOpen;
        synchronized (this) {
            this.hasResponseHeaders = true;
            this.headersQueue.add(Util.toHeaders(list));
            zIsOpen = isOpen();
            notifyAll();
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.f47330id);
    }

    public synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public synchronized void setHeadersListener(Header.Listener listener) {
        this.headersListener = listener;
        if (!this.headersQueue.isEmpty() && listener != null) {
            notifyAll();
        }
    }

    public synchronized Headers takeHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th2) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th2;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.headersQueue.isEmpty()) {
            throw new StreamResetException(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public void writeHeaders(List<Header> list, boolean z11) throws IOException {
        boolean z12;
        boolean z13;
        boolean z14;
        if (list == null) {
            throw new NullPointerException("headers == null");
        }
        synchronized (this) {
            z12 = true;
            try {
                this.hasResponseHeaders = true;
                if (z11) {
                    z13 = false;
                    z14 = false;
                } else {
                    this.sink.finished = true;
                    z13 = true;
                    z14 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (!z13) {
            synchronized (this.connection) {
                if (this.connection.bytesLeftInWriteWindow != 0) {
                    z12 = false;
                }
            }
            z13 = z12;
        }
        this.connection.writeSynReply(this.f47330id, z14, list);
        if (z13) {
            this.connection.flush();
        }
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
