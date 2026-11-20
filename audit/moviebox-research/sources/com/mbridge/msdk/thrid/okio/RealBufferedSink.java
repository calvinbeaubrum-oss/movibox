package com.mbridge.msdk.thrid.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class RealBufferedSink implements BufferedSink {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        if (sink == null) {
            throw new NullPointerException("sink == null");
        }
        this.sink = sink;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        Buffer buffer = this.buffer;
        long j11 = buffer.size;
        if (j11 > 0) {
            this.sink.write(buffer, j11);
        }
        th = null;
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink emit() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.sink.write(this.buffer, size);
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink emitCompleteSegments() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long jCompleteSegmentByteCount = this.buffer.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.sink.write(this.buffer, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink, com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.buffer;
        long j11 = buffer.size;
        if (j11 > 0) {
            this.sink.write(buffer, j11);
        }
        this.sink.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.mbridge.msdk.thrid.okio.RealBufferedSink.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws Throwable {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    return;
                }
                realBufferedSink.flush();
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i11) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink.buffer.writeByte((int) ((byte) i11));
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i11, int i12) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink.buffer.write(bArr, i11, i12);
                RealBufferedSink.this.emitCompleteSegments();
            }
        };
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.buffer.write(byteBuffer);
        emitCompleteSegments();
        return iWrite;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink write(ByteString byteString) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(byteString);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink write(Source source, long j11) throws IOException {
        while (j11 > 0) {
            long j12 = source.read(this.buffer, j11);
            if (j12 == -1) {
                throw new EOFException();
            }
            j11 -= j12;
            emitCompleteSegments();
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(bArr);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i11, int i12) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(bArr, i11, i12);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public void write(Buffer buffer, long j11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(buffer, j11);
        emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j11 = 0;
        while (true) {
            long j12 = source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j12 == -1) {
                return j11;
            }
            j11 += j12;
            emitCompleteSegments();
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeByte(int i11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeByte(i11);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeDecimalLong(long j11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeDecimalLong(j11);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long j11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeHexadecimalUnsignedLong(j11);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeInt(int i11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeInt(i11);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeIntLe(int i11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeIntLe(i11);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeLong(long j11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLong(j11);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeLongLe(long j11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLongLe(j11);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeShort(int i11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShort(i11);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeShortLe(int i11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShortLe(i11);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeString(String str, int i11, int i12, Charset charset) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(str, i11, i12, charset);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeString(String str, Charset charset) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeUtf8(String str) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeUtf8(String str, int i11, int i12) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str, i11, i12);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int i11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8CodePoint(i11);
        return emitCompleteSegments();
    }
}
