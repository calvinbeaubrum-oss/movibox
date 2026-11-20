package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    public Http2Writer(BufferedSink bufferedSink, boolean z11) {
        this.sink = bufferedSink;
        this.client = z11;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new Hpack.Writer(buffer);
        this.maxFrameSize = 16384;
    }

    private void writeContinuationFrames(int i11, long j11) throws IOException {
        while (j11 > 0) {
            int iMin = (int) Math.min(this.maxFrameSize, j11);
            long j12 = iMin;
            j11 -= j12;
            frameHeader(i11, iMin, (byte) 9, j11 == 0 ? (byte) 4 : (byte) 0);
            this.sink.write(this.hpackBuffer, j12);
        }
    }

    private static void writeMedium(BufferedSink bufferedSink, int i11) throws IOException {
        bufferedSink.writeByte((i11 >>> 16) & 255);
        bufferedSink.writeByte((i11 >>> 8) & 255);
        bufferedSink.writeByte(i11 & 255);
    }

    public synchronized void applyAndAckSettings(Settings settings) throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, (byte) 4, (byte) 1);
            this.sink.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public synchronized void connectionPreface() throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
                }
                this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
                this.sink.flush();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void data(boolean z11, int i11, Buffer buffer, int i12) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        dataFrame(i11, z11 ? (byte) 1 : (byte) 0, buffer, i12);
    }

    public void dataFrame(int i11, byte b11, Buffer buffer, int i12) throws IOException {
        frameHeader(i11, i12, (byte) 0, b11);
        if (i12 > 0) {
            this.sink.write(buffer, i12);
        }
    }

    public synchronized void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public void frameHeader(int i11, int i12, byte b11, byte b12) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.frameLog(false, i11, i12, b11, b12));
        }
        int i13 = this.maxFrameSize;
        if (i12 > i13) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i13), Integer.valueOf(i12));
        }
        if ((Integer.MIN_VALUE & i11) != 0) {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i11));
        }
        writeMedium(this.sink, i12);
        this.sink.writeByte(b11 & 255);
        this.sink.writeByte(b12 & 255);
        this.sink.writeInt(i11 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public synchronized void goAway(int i11, ErrorCode errorCode, byte[] bArr) throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.httpCode == -1) {
                throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            }
            frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.sink.writeInt(i11);
            this.sink.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.sink.write(bArr);
            }
            this.sink.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void headers(int i11, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        headers(false, i11, list);
    }

    public void headers(boolean z11, int i11, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        int iMin = (int) Math.min(this.maxFrameSize, size);
        long j11 = iMin;
        byte b11 = size == j11 ? (byte) 4 : (byte) 0;
        if (z11) {
            b11 = (byte) (b11 | 1);
        }
        frameHeader(i11, iMin, (byte) 1, b11);
        this.sink.write(this.hpackBuffer, j11);
        if (size > j11) {
            writeContinuationFrames(i11, size - j11);
        }
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void ping(boolean z11, int i11, int i12) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, (byte) 6, z11 ? (byte) 1 : (byte) 0);
        this.sink.writeInt(i11);
        this.sink.writeInt(i12);
        this.sink.flush();
    }

    public synchronized void pushPromise(int i11, int i12, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        int iMin = (int) Math.min(this.maxFrameSize - 4, size);
        long j11 = iMin;
        frameHeader(i11, iMin + 4, (byte) 5, size == j11 ? (byte) 4 : (byte) 0);
        this.sink.writeInt(i12 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.sink.write(this.hpackBuffer, j11);
        if (size > j11) {
            writeContinuationFrames(i11, size - j11);
        }
    }

    public synchronized void rstStream(int i11, ErrorCode errorCode) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        frameHeader(i11, 4, (byte) 3, (byte) 0);
        this.sink.writeInt(errorCode.httpCode);
        this.sink.flush();
    }

    public synchronized void settings(Settings settings) throws IOException {
        int i11;
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            int i12 = 0;
            frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
            while (i12 < 10) {
                if (settings.isSet(i12)) {
                    if (i12 == 4) {
                        i11 = 3;
                    } else {
                        i11 = i12 == 7 ? 4 : i12;
                    }
                    this.sink.writeShort(i11);
                    this.sink.writeInt(settings.get(i12));
                }
                i12++;
            }
            this.sink.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void synReply(boolean z11, int i11, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        headers(z11, i11, list);
    }

    public synchronized void synStream(boolean z11, int i11, int i12, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        headers(z11, i11, list);
    }

    public synchronized void windowUpdate(int i11, long j11) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j11 == 0 || j11 > 2147483647L) {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j11));
        }
        frameHeader(i11, 4, (byte) 8, (byte) 0);
        this.sink.writeInt((int) j11);
        this.sink.flush();
    }
}
