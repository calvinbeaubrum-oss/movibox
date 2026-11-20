package com.mbridge.msdk.thrid.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class RealBufferedSource implements BufferedSource {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Source source;

    public RealBufferedSource(Source source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        this.source = source;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource, com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean exhausted() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.buffer.exhausted() && this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b11) throws IOException {
        return indexOf(b11, 0L, Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b11, long j11) throws IOException {
        return indexOf(b11, j11, Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b11, long j11, long j12) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j11 < 0 || j12 < j11) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j11), Long.valueOf(j12)));
        }
        while (j11 < j12) {
            long jIndexOf = this.buffer.indexOf(b11, j11, j12);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            Buffer buffer = this.buffer;
            long j13 = buffer.size;
            if (j13 >= j12 || this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                break;
            }
            j11 = Math.max(j11, j13);
        }
        return -1L;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(ByteString byteString, long j11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOf = this.buffer.indexOf(byteString, j11);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            Buffer buffer = this.buffer;
            long j12 = buffer.size;
            if (this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j11 = Math.max(j11, (j12 - ((long) byteString.size())) + 1);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOfElement = this.buffer.indexOfElement(byteString, j11);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            Buffer buffer = this.buffer;
            long j12 = buffer.size;
            if (this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j11 = Math.max(j11, j12);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.mbridge.msdk.thrid.okio.RealBufferedSource.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(realBufferedSource.buffer.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                Buffer buffer = realBufferedSource.buffer;
                if (buffer.size == 0 && realBufferedSource.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.readByte() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i11, int i12) throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                Util.checkOffsetAndCount(bArr.length, i11, i12);
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                Buffer buffer = realBufferedSource.buffer;
                if (buffer.size == 0 && realBufferedSource.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.read(bArr, i11, i12);
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean rangeEquals(long j11, ByteString byteString) throws IOException {
        return rangeEquals(j11, byteString, 0, byteString.size());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean rangeEquals(long j11, ByteString byteString, int i11, int i12) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j11 < 0 || i11 < 0 || i12 < 0 || byteString.size() - i11 < i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            long j12 = ((long) i13) + j11;
            if (!request(1 + j12) || this.buffer.getByte(j12) != byteString.getByte(i11 + i13)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Buffer buffer = this.buffer;
        if (buffer.size == 0 && this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        long j11 = i12;
        Util.checkOffsetAndCount(bArr.length, i11, j11);
        Buffer buffer = this.buffer;
        if (buffer.size == 0 && this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i11, (int) Math.min(j11, this.buffer.size));
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public long read(Buffer buffer, long j11) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j11);
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer2 = this.buffer;
        if (buffer2.size == 0 && this.source.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.buffer.read(buffer, Math.min(j11, this.buffer.size));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j11 = 0;
        while (this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            long jCompleteSegmentByteCount = this.buffer.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j11 += jCompleteSegmentByteCount;
                sink.write(this.buffer, jCompleteSegmentByteCount);
            }
        }
        if (this.buffer.size() <= 0) {
            return j11;
        }
        long size = j11 + this.buffer.size();
        Buffer buffer = this.buffer;
        sink.write(buffer, buffer.size());
        return size;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte readByte() throws IOException {
        require(1L);
        return this.buffer.readByte();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte[] readByteArray(long j11) throws IOException {
        require(j11);
        return this.buffer.readByteArray(j11);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public ByteString readByteString(long j11) throws IOException {
        require(j11);
        return this.buffer.readByteString(j11);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readDecimalLong() throws IOException {
        require(1L);
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            if (!request(i12)) {
                break;
            }
            byte b11 = this.buffer.getByte(i11);
            if ((b11 < 48 || b11 > 57) && !(i11 == 0 && b11 == 45)) {
                if (i11 != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b11)));
            }
            i11 = i12;
        }
        return this.buffer.readDecimalLong();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void readFully(Buffer buffer, long j11) throws IOException {
        try {
            require(j11);
            this.buffer.readFully(buffer, j11);
        } catch (EOFException e11) {
            buffer.writeAll(this.buffer);
            throw e11;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void readFully(byte[] bArr) throws IOException {
        try {
            require(bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e11) {
            int i11 = 0;
            while (true) {
                Buffer buffer = this.buffer;
                long j11 = buffer.size;
                if (j11 <= 0) {
                    throw e11;
                }
                int i12 = buffer.read(bArr, i11, (int) j11);
                if (i12 == -1) {
                    throw new AssertionError();
                }
                i11 += i12;
            }
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws IOException {
        require(1L);
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            if (!request(i12)) {
                break;
            }
            byte b11 = this.buffer.getByte(i11);
            if ((b11 < 48 || b11 > 57) && ((b11 < 97 || b11 > 102) && (b11 < 65 || b11 > 70))) {
                if (i11 != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(b11)));
            }
            i11 = i12;
        }
        return this.buffer.readHexadecimalUnsignedLong();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readInt() throws IOException {
        require(4L);
        return this.buffer.readInt();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readIntLe() throws IOException {
        require(4L);
        return this.buffer.readIntLe();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readLong() throws IOException {
        require(8L);
        return this.buffer.readLong();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readLongLe() throws IOException {
        require(8L);
        return this.buffer.readLongLe();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public short readShort() throws IOException {
        require(2L);
        return this.buffer.readShort();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public short readShortLe() throws IOException {
        require(2L);
        return this.buffer.readShortLe();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readString(long j11, Charset charset) throws IOException {
        require(j11);
        if (charset != null) {
            return this.buffer.readString(j11, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readString(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.buffer.writeAll(this.source);
        return this.buffer.readString(charset);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8(long j11) throws IOException {
        require(j11);
        return this.buffer.readUtf8(j11);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readUtf8CodePoint() throws IOException {
        require(1L);
        byte b11 = this.buffer.getByte(0L);
        if ((b11 & 224) == 192) {
            require(2L);
        } else if ((b11 & 240) == 224) {
            require(3L);
        } else if ((b11 & 248) == 240) {
            require(4L);
        }
        return this.buffer.readUtf8CodePoint();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws IOException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return this.buffer.readUtf8Line(jIndexOf);
        }
        long j11 = this.buffer.size;
        if (j11 != 0) {
            return readUtf8(j11);
        }
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8LineStrict(long j11) throws IOException {
        if (j11 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j11);
        }
        long j12 = j11 == Long.MAX_VALUE ? Long.MAX_VALUE : j11 + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j12);
        if (jIndexOf != -1) {
            return this.buffer.readUtf8Line(jIndexOf);
        }
        if (j12 < Long.MAX_VALUE && request(j12) && this.buffer.getByte(j12 - 1) == 13 && request(1 + j12) && this.buffer.getByte(j12) == 10) {
            return this.buffer.readUtf8Line(j12);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.buffer;
        buffer2.copyTo(buffer, 0L, Math.min(32L, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.buffer.size(), j11) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean request(long j11) throws IOException {
        Buffer buffer;
        if (j11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j11);
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            buffer = this.buffer;
            if (buffer.size >= j11) {
                return true;
            }
        } while (this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void require(long j11) throws IOException {
        if (!request(j11)) {
            throw new EOFException();
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int select(Options options) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int iSelectPrefix = this.buffer.selectPrefix(options, true);
            if (iSelectPrefix == -1) {
                return -1;
            }
            if (iSelectPrefix != -2) {
                this.buffer.skip(options.byteStrings[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void skip(long j11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j11 > 0) {
            Buffer buffer = this.buffer;
            if (buffer.size == 0 && this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j11, this.buffer.size());
            this.buffer.skip(jMin);
            j11 -= jMin;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ")";
    }
}
