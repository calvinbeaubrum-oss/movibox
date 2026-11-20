package com.mbridge.msdk.thrid.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.connection.RealConnection;
import okio.internal.BufferKt;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;

    @Nullable
    Segment head;
    long size;

    /* JADX INFO: compiled from: source.java */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i11) {
            if (i11 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i11);
            }
            if (i11 > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i11);
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j11 = buffer.size;
            Segment segmentWritableSegment = buffer.writableSegment(i11);
            int i12 = 8192 - segmentWritableSegment.limit;
            segmentWritableSegment.limit = 8192;
            long j12 = i12;
            this.buffer.size = j11 + j12;
            this.segment = segmentWritableSegment;
            this.offset = j11;
            this.data = segmentWritableSegment.data;
            this.start = 8192 - i12;
            this.end = 8192;
            return j12;
        }

        public final int next() {
            long j11 = this.offset;
            if (j11 != this.buffer.size) {
                return j11 == -1 ? seek(0L) : seek(j11 + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException();
        }

        public final long resizeBuffer(long j11) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j12 = buffer.size;
            if (j11 <= j12) {
                if (j11 < 0) {
                    throw new IllegalArgumentException("newSize < 0: " + j11);
                }
                long j13 = j12 - j11;
                while (j13 > 0) {
                    Buffer buffer2 = this.buffer;
                    Segment segment = buffer2.head.prev;
                    int i11 = segment.limit;
                    long j14 = i11 - segment.pos;
                    if (j14 > j13) {
                        segment.limit = (int) (((long) i11) - j13);
                        break;
                    }
                    buffer2.head = segment.pop();
                    SegmentPool.recycle(segment);
                    j13 -= j14;
                }
                this.segment = null;
                this.offset = j11;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j11 > j12) {
                long j15 = j11 - j12;
                boolean z11 = true;
                while (j15 > 0) {
                    Segment segmentWritableSegment = this.buffer.writableSegment(1);
                    int iMin = (int) Math.min(j15, 8192 - segmentWritableSegment.limit);
                    int i12 = segmentWritableSegment.limit + iMin;
                    segmentWritableSegment.limit = i12;
                    j15 -= (long) iMin;
                    if (z11) {
                        this.segment = segmentWritableSegment;
                        this.offset = j12;
                        this.data = segmentWritableSegment.data;
                        this.start = i12 - iMin;
                        this.end = i12;
                        z11 = false;
                    }
                }
            }
            this.buffer.size = j11;
            return j12;
        }

        public final int seek(long j11) {
            if (j11 >= -1) {
                Buffer buffer = this.buffer;
                long j12 = buffer.size;
                if (j11 <= j12) {
                    if (j11 == -1 || j11 == j12) {
                        this.segment = null;
                        this.offset = j11;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    Segment segment = buffer.head;
                    Segment segmentPush = this.segment;
                    long j13 = 0;
                    if (segmentPush != null) {
                        long j14 = this.offset - ((long) (this.start - segmentPush.pos));
                        if (j14 > j11) {
                            j12 = j14;
                            segmentPush = segment;
                            segment = segmentPush;
                        } else {
                            j13 = j14;
                        }
                    } else {
                        segmentPush = segment;
                    }
                    if (j12 - j11 > j11 - j13) {
                        while (true) {
                            int i11 = segmentPush.limit;
                            int i12 = segmentPush.pos;
                            if (j11 < ((long) (i11 - i12)) + j13) {
                                break;
                            }
                            j13 += (long) (i11 - i12);
                            segmentPush = segmentPush.next;
                        }
                    } else {
                        while (j12 > j11) {
                            segment = segment.prev;
                            j12 -= (long) (segment.limit - segment.pos);
                        }
                        segmentPush = segment;
                        j13 = j12;
                    }
                    if (this.readWrite && segmentPush.shared) {
                        Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                        Buffer buffer2 = this.buffer;
                        if (buffer2.head == segmentPush) {
                            buffer2.head = segmentUnsharedCopy;
                        }
                        segmentPush = segmentPush.push(segmentUnsharedCopy);
                        segmentPush.prev.pop();
                    }
                    this.segment = segmentPush;
                    this.offset = j11;
                    this.data = segmentPush.data;
                    int i13 = segmentPush.pos + ((int) (j11 - j13));
                    this.start = i13;
                    int i14 = segmentPush.limit;
                    this.end = i14;
                    return i14 - i13;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j11), Long.valueOf(this.buffer.size)));
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i11 = segment.pos;
                messageDigest.update(bArr, i11, segment.limit - i11);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i12 = segment2.pos;
                    messageDigest.update(bArr2, i12, segment2.limit - i12);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i11 = segment.pos;
                mac.update(bArr, i11, segment.limit - i11);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i12 = segment2.pos;
                    mac.update(bArr2, i12, segment2.limit - i12);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private boolean rangeEquals(Segment segment, int i11, ByteString byteString, int i12, int i13) {
        int i14 = segment.limit;
        byte[] bArr = segment.data;
        while (i12 < i13) {
            if (i11 == i14) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i11 = segment.pos;
                i14 = segment.limit;
            }
            if (bArr[i11] != byteString.getByte(i12)) {
                return false;
            }
            i11++;
            i12++;
        }
        return true;
    }

    private void readFrom(InputStream inputStream, long j11, boolean z11) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j11 <= 0 && !z11) {
                return;
            }
            Segment segmentWritableSegment = writableSegment(1);
            int i11 = inputStream.read(segmentWritableSegment.data, segmentWritableSegment.limit, (int) Math.min(j11, 8192 - segmentWritableSegment.limit));
            if (i11 == -1) {
                if (!z11) {
                    throw new EOFException();
                }
                return;
            } else {
                segmentWritableSegment.limit += i11;
                long j12 = i11;
                this.size += j12;
                j11 -= j12;
            }
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource, com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e11) {
            throw new AssertionError(e11);
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Buffer m157clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment segmentSharedCopy = this.head.sharedCopy();
        buffer.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment == this.head) {
                buffer.size = this.size;
                return buffer;
            }
            buffer.head.prev.push(segment.sharedCopy());
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j11 = this.size;
        if (j11 == 0) {
            return 0L;
        }
        Segment segment = this.head.prev;
        int i11 = segment.limit;
        return (i11 >= 8192 || !segment.owner) ? j11 : j11 - ((long) (i11 - segment.pos));
    }

    public final Buffer copyTo(Buffer buffer, long j11, long j12) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, j11, j12);
        if (j12 == 0) {
            return this;
        }
        buffer.size += j12;
        Segment segment = this.head;
        while (true) {
            int i11 = segment.limit;
            int i12 = segment.pos;
            if (j11 < i11 - i12) {
                break;
            }
            j11 -= (long) (i11 - i12);
            segment = segment.next;
        }
        while (j12 > 0) {
            Segment segmentSharedCopy = segment.sharedCopy();
            int i13 = (int) (((long) segmentSharedCopy.pos) + j11);
            segmentSharedCopy.pos = i13;
            segmentSharedCopy.limit = Math.min(i13 + ((int) j12), segmentSharedCopy.limit);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segmentSharedCopy.prev = segmentSharedCopy;
                segmentSharedCopy.next = segmentSharedCopy;
                buffer.head = segmentSharedCopy;
            } else {
                segment2.prev.push(segmentSharedCopy);
            }
            j12 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
            segment = segment.next;
            j11 = 0;
        }
        return this;
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    public final Buffer copyTo(OutputStream outputStream, long j11, long j12) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, j11, j12);
        if (j12 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            int i11 = segment.limit;
            int i12 = segment.pos;
            if (j11 < i11 - i12) {
                break;
            }
            j11 -= (long) (i11 - i12);
            segment = segment.next;
        }
        while (j12 > 0) {
            int i13 = (int) (((long) segment.pos) + j11);
            int iMin = (int) Math.min(segment.limit - i13, j12);
            outputStream.write(segment.data, i13, iMin);
            j12 -= (long) iMin;
            segment = segment.next;
            j11 = 0;
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j11 = this.size;
        if (j11 != buffer.size) {
            return false;
        }
        long j12 = 0;
        if (j11 == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i11 = segment.pos;
        int i12 = segment2.pos;
        while (j12 < this.size) {
            long jMin = Math.min(segment.limit - i11, segment2.limit - i12);
            int i13 = 0;
            while (i13 < jMin) {
                int i14 = i11 + 1;
                int i15 = i12 + 1;
                if (segment.data[i11] != segment2.data[i12]) {
                    return false;
                }
                i13++;
                i11 = i14;
                i12 = i15;
            }
            if (i11 == segment.limit) {
                segment = segment.next;
                i11 = segment.pos;
            }
            if (i12 == segment2.limit) {
                segment2 = segment2.next;
                i12 = segment2.pos;
            }
            j12 += jMin;
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink, com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
    public void flush() {
    }

    public final byte getByte(long j11) {
        int i11;
        Util.checkOffsetAndCount(this.size, j11, 1L);
        long j12 = this.size;
        if (j12 - j11 <= j11) {
            long j13 = j11 - j12;
            Segment segment = this.head;
            do {
                segment = segment.prev;
                int i12 = segment.limit;
                i11 = segment.pos;
                j13 += (long) (i12 - i11);
            } while (j13 < 0);
            return segment.data[i11 + ((int) j13)];
        }
        Segment segment2 = this.head;
        while (true) {
            int i13 = segment2.limit;
            int i14 = segment2.pos;
            long j14 = i13 - i14;
            if (j11 < j14) {
                return segment2.data[i14 + ((int) j11)];
            }
            j11 -= j14;
            segment2 = segment2.next;
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i11 = 1;
        do {
            int i12 = segment.limit;
            for (int i13 = segment.pos; i13 < i12; i13++) {
                i11 = (i11 * 31) + segment.data[i13];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i11;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b11) {
        return indexOf(b11, 0L, Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b11, long j11) {
        return indexOf(b11, j11, Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b11, long j11, long j12) {
        Segment segment;
        long j13 = 0;
        if (j11 < 0 || j12 < j11) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(j11), Long.valueOf(j12)));
        }
        long j14 = this.size;
        long j15 = j12 > j14 ? j14 : j12;
        if (j11 == j15 || (segment = this.head) == null) {
            return -1L;
        }
        if (j14 - j11 < j11) {
            while (j14 > j11) {
                segment = segment.prev;
                j14 -= (long) (segment.limit - segment.pos);
            }
        } else {
            while (true) {
                long j16 = ((long) (segment.limit - segment.pos)) + j13;
                if (j16 >= j11) {
                    break;
                }
                segment = segment.next;
                j13 = j16;
            }
            j14 = j13;
        }
        long j17 = j11;
        while (j14 < j15) {
            byte[] bArr = segment.data;
            int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j15) - j14);
            for (int i11 = (int) ((((long) segment.pos) + j17) - j14); i11 < iMin; i11++) {
                if (bArr[i11] == b11) {
                    return ((long) (i11 - segment.pos)) + j14;
                }
            }
            j14 += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j17 = j14;
        }
        return -1L;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(ByteString byteString, long j11) throws IOException {
        if (byteString.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j12 = 0;
        if (j11 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        long j13 = -1;
        if (segment == null) {
            return -1L;
        }
        long j14 = this.size;
        if (j14 - j11 < j11) {
            while (j14 > j11) {
                segment = segment.prev;
                j14 -= (long) (segment.limit - segment.pos);
            }
        } else {
            while (true) {
                long j15 = ((long) (segment.limit - segment.pos)) + j12;
                if (j15 >= j11) {
                    break;
                }
                segment = segment.next;
                j12 = j15;
            }
            j14 = j12;
        }
        byte b11 = byteString.getByte(0);
        int size = byteString.size();
        long j16 = 1 + (this.size - ((long) size));
        long j17 = j11;
        Segment segment2 = segment;
        long j18 = j14;
        while (j18 < j16) {
            byte[] bArr = segment2.data;
            int iMin = (int) Math.min(segment2.limit, (((long) segment2.pos) + j16) - j18);
            int i11 = (int) ((((long) segment2.pos) + j17) - j18);
            while (i11 < iMin) {
                if (bArr[i11] == b11) {
                    if (rangeEquals(segment2, i11 + 1, byteString, 1, size)) {
                        return ((long) (i11 - segment2.pos)) + j18;
                    }
                }
                i11++;
                bArr = bArr;
            }
            j18 += (long) (segment2.limit - segment2.pos);
            segment2 = segment2.next;
            j17 = j18;
            j13 = -1;
        }
        return j13;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j11) {
        int i11;
        int i12;
        long j12 = 0;
        if (j11 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long j13 = this.size;
        if (j13 - j11 < j11) {
            while (j13 > j11) {
                segment = segment.prev;
                j13 -= (long) (segment.limit - segment.pos);
            }
        } else {
            while (true) {
                long j14 = ((long) (segment.limit - segment.pos)) + j12;
                if (j14 >= j11) {
                    break;
                }
                segment = segment.next;
                j12 = j14;
            }
            j13 = j12;
        }
        if (byteString.size() == 2) {
            byte b11 = byteString.getByte(0);
            byte b12 = byteString.getByte(1);
            while (j13 < this.size) {
                byte[] bArr = segment.data;
                i11 = (int) ((((long) segment.pos) + j11) - j13);
                int i13 = segment.limit;
                while (i11 < i13) {
                    byte b13 = bArr[i11];
                    if (b13 == b11 || b13 == b12) {
                        i12 = segment.pos;
                        return ((long) (i11 - i12)) + j13;
                    }
                    i11++;
                }
                j13 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j11 = j13;
            }
            return -1L;
        }
        byte[] bArrInternalArray = byteString.internalArray();
        while (j13 < this.size) {
            byte[] bArr2 = segment.data;
            i11 = (int) ((((long) segment.pos) + j11) - j13);
            int i14 = segment.limit;
            while (i11 < i14) {
                byte b14 = bArr2[i11];
                for (byte b15 : bArrInternalArray) {
                    if (b14 == b15) {
                        i12 = segment.pos;
                        return ((long) (i11 - i12)) + j13;
                    }
                }
                i11++;
            }
            j13 += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j11 = j13;
        }
        return -1L;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.mbridge.msdk.thrid.okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.size > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i11, int i12) {
                return Buffer.this.read(bArr, i11, i12);
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.mbridge.msdk.thrid.okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i11) {
                Buffer.this.writeByte((int) ((byte) i11));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i11, int i12) {
                Buffer.this.write(bArr, i11, i12);
            }
        };
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean rangeEquals(long j11, ByteString byteString) {
        return rangeEquals(j11, byteString, 0, byteString.size());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean rangeEquals(long j11, ByteString byteString, int i11, int i12) {
        if (j11 < 0 || i11 < 0 || i12 < 0 || this.size - j11 < i12 || byteString.size() - i11 < i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (getByte(((long) i13) + j11) != byteString.getByte(i11 + i13)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, iMin);
        int i11 = segment.pos + iMin;
        segment.pos = i11;
        this.size -= (long) iMin;
        if (i11 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int read(byte[] bArr, int i11, int i12) {
        Util.checkOffsetAndCount(bArr.length, i11, i12);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i12, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i11, iMin);
        int i13 = segment.pos + iMin;
        segment.pos = i13;
        this.size -= (long) iMin;
        if (i13 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public long read(Buffer buffer, long j11) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j11);
        }
        long j12 = this.size;
        if (j12 == 0) {
            return -1L;
        }
        if (j11 > j12) {
            j11 = j12;
        }
        buffer.write(this, j11);
        return j11;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j11 = this.size;
        if (j11 > 0) {
            sink.write(this, j11);
        }
        return j11;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte readByte() {
        long j11 = this.size;
        if (j11 == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.head;
        int i11 = segment.pos;
        int i12 = segment.limit;
        int i13 = i11 + 1;
        byte b11 = segment.data[i11];
        this.size = j11 - 1;
        if (i13 == i12) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i13;
        }
        return b11;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e11) {
            throw new AssertionError(e11);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte[] readByteArray(long j11) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j11);
        if (j11 <= 2147483647L) {
            byte[] bArr = new byte[(int) j11];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j11);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public ByteString readByteString(long j11) throws EOFException {
        return new ByteString(readByteArray(j11));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readDecimalLong() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i11 = 0;
        long j11 = -7;
        boolean z11 = false;
        long j12 = 0;
        boolean z12 = false;
        do {
            Segment segment = this.head;
            byte[] bArr = segment.data;
            int i12 = segment.pos;
            int i13 = segment.limit;
            while (i12 < i13) {
                byte b11 = bArr[i12];
                if (b11 >= 48 && b11 <= 57) {
                    int i14 = 48 - b11;
                    if (j12 < BufferKt.OVERFLOW_ZONE || (j12 == BufferKt.OVERFLOW_ZONE && i14 < j11)) {
                        Buffer bufferWriteByte = new Buffer().writeDecimalLong(j12).writeByte((int) b11);
                        if (!z11) {
                            bufferWriteByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + bufferWriteByte.readUtf8());
                    }
                    j12 = (j12 * 10) + ((long) i14);
                } else {
                    if (b11 != 45 || i11 != 0) {
                        if (i11 != 0) {
                            z12 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b11));
                    }
                    j11--;
                    z11 = true;
                }
                i12++;
                i11++;
            }
            if (i12 == i13) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i12;
            }
            if (z12) {
                break;
            }
        } while (this.head != null);
        this.size -= (long) i11;
        return z11 ? j12 : -j12;
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream inputStream, long j11) throws IOException {
        if (j11 >= 0) {
            readFrom(inputStream, j11, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j11);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void readFully(Buffer buffer, long j11) throws EOFException {
        long j12 = this.size;
        if (j12 >= j11) {
            buffer.write(this, j11);
        } else {
            buffer.write(this, j12);
            throw new EOFException();
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i11 = 0;
        while (i11 < bArr.length) {
            int i12 = read(bArr, i11, bArr.length - i11);
            if (i12 == -1) {
                throw new EOFException();
            }
            i11 += i12;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        int i11;
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i12 = 0;
        long j11 = 0;
        boolean z11 = false;
        do {
            Segment segment = this.head;
            byte[] bArr = segment.data;
            int i13 = segment.pos;
            int i14 = segment.limit;
            while (i13 < i14) {
                byte b11 = bArr[i13];
                if (b11 >= 48 && b11 <= 57) {
                    i11 = b11 - 48;
                } else if (b11 >= 97 && b11 <= 102) {
                    i11 = b11 - 87;
                } else {
                    if (b11 < 65 || b11 > 70) {
                        if (i12 != 0) {
                            z11 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b11));
                    }
                    i11 = b11 - 55;
                }
                if (((-1152921504606846976L) & j11) != 0) {
                    throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(j11).writeByte((int) b11).readUtf8());
                }
                j11 = (j11 << 4) | ((long) i11);
                i13++;
                i12++;
            }
            if (i13 == i14) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            if (z11) {
                break;
            }
        } while (this.head != null);
        this.size -= (long) i12;
        return j11;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readInt() {
        long j11 = this.size;
        if (j11 < 4) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        Segment segment = this.head;
        int i11 = segment.pos;
        int i12 = segment.limit;
        if (i12 - i11 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i13 = i11 + 3;
        int i14 = ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 2] & 255) << 8);
        int i15 = i11 + 4;
        int i16 = (bArr[i13] & 255) | i14;
        this.size = j11 - 4;
        if (i15 == i12) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i15;
        }
        return i16;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readLong() {
        long j11 = this.size;
        if (j11 < 8) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        Segment segment = this.head;
        int i11 = segment.pos;
        int i12 = segment.limit;
        if (i12 - i11 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = segment.data;
        int i13 = i11 + 7;
        long j12 = ((((long) bArr[i11 + 1]) & 255) << 48) | ((((long) bArr[i11]) & 255) << 56) | ((((long) bArr[i11 + 2]) & 255) << 40) | ((((long) bArr[i11 + 3]) & 255) << 32) | ((((long) bArr[i11 + 4]) & 255) << 24) | ((((long) bArr[i11 + 5]) & 255) << 16) | ((((long) bArr[i11 + 6]) & 255) << 8);
        int i14 = i11 + 8;
        long j13 = j12 | (((long) bArr[i13]) & 255);
        this.size = j11 - 8;
        if (i14 == i12) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i14;
        }
        return j13;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public short readShort() {
        long j11 = this.size;
        if (j11 < 2) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        Segment segment = this.head;
        int i11 = segment.pos;
        int i12 = segment.limit;
        if (i12 - i11 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i13 = i11 + 1;
        int i14 = (bArr[i11] & 255) << 8;
        int i15 = i11 + 2;
        int i16 = (bArr[i13] & 255) | i14;
        this.size = j11 - 2;
        if (i15 == i12) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i15;
        }
        return (short) i16;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readString(long j11, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j11);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j11);
        }
        if (j11 == 0) {
            return "";
        }
        Segment segment = this.head;
        int i11 = segment.pos;
        if (((long) i11) + j11 > segment.limit) {
            return new String(readByteArray(j11), charset);
        }
        String str = new String(segment.data, i11, (int) j11, charset);
        int i12 = (int) (((long) segment.pos) + j11);
        segment.pos = i12;
        this.size -= j11;
        if (i12 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e11) {
            throw new AssertionError(e11);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e11) {
            throw new AssertionError(e11);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8(long j11) throws EOFException {
        return readString(j11, Util.UTF_8);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i11;
        int i12;
        int i13;
        if (this.size == 0) {
            throw new EOFException();
        }
        byte b11 = getByte(0L);
        if ((b11 & 128) == 0) {
            i11 = b11 & Ascii.DEL;
            i12 = 1;
            i13 = 0;
        } else if ((b11 & 224) == 192) {
            i11 = b11 & Ascii.US;
            i12 = 2;
            i13 = 128;
        } else if ((b11 & 240) == 224) {
            i11 = b11 & Ascii.SI;
            i12 = 3;
            i13 = 2048;
        } else {
            if ((b11 & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i11 = b11 & 7;
            i12 = 4;
            i13 = 65536;
        }
        long j11 = i12;
        if (this.size < j11) {
            throw new EOFException("size < " + i12 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b11) + ")");
        }
        for (int i14 = 1; i14 < i12; i14++) {
            long j12 = i14;
            byte b12 = getByte(j12);
            if ((b12 & 192) != 128) {
                skip(j12);
                return 65533;
            }
            i11 = (i11 << 6) | (b12 & okio.Utf8.REPLACEMENT_BYTE);
        }
        skip(j11);
        if (i11 > 1114111) {
            return 65533;
        }
        if ((i11 < 55296 || i11 > 57343) && i11 >= i13) {
            return i11;
        }
        return 65533;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return readUtf8Line(jIndexOf);
        }
        long j11 = this.size;
        if (j11 != 0) {
            return readUtf8(j11);
        }
        return null;
    }

    public String readUtf8Line(long j11) throws EOFException {
        if (j11 > 0) {
            long j12 = j11 - 1;
            if (getByte(j12) == 13) {
                String utf8 = readUtf8(j12);
                skip(2L);
                return utf8;
            }
        }
        String utf9 = readUtf8(j11);
        skip(1L);
        return utf9;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8LineStrict(long j11) throws EOFException {
        if (j11 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j11);
        }
        long j12 = j11 != Long.MAX_VALUE ? j11 + 1 : Long.MAX_VALUE;
        long jIndexOf = indexOf((byte) 10, 0L, j12);
        if (jIndexOf != -1) {
            return readUtf8Line(jIndexOf);
        }
        if (j12 < size() && getByte(j12 - 1) == 13 && getByte(j12) == 10) {
            return readUtf8Line(j12);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j11) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean request(long j11) {
        return this.size >= j11;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void require(long j11) throws EOFException {
        if (this.size < j11) {
            throw new EOFException();
        }
    }

    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.head;
        arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.limit - segment2.pos));
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int select(Options options) {
        int iSelectPrefix = selectPrefix(options, false);
        if (iSelectPrefix == -1) {
            return -1;
        }
        try {
            skip(options.byteStrings[iSelectPrefix].size());
            return iSelectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public int selectPrefix(Options options, boolean z11) {
        int i11;
        int i12;
        Segment segment;
        int i13;
        int i14;
        Segment segment2 = this.head;
        int i15 = -2;
        if (segment2 == null) {
            if (z11) {
                return -2;
            }
            return options.indexOf(ByteString.EMPTY);
        }
        byte[] bArr = segment2.data;
        int i16 = segment2.pos;
        int i17 = segment2.limit;
        int[] iArr = options.trie;
        Segment segment3 = segment2;
        int i18 = 0;
        int i19 = -1;
        loop0: while (true) {
            int i21 = i18 + 1;
            int i22 = iArr[i18];
            int i23 = i18 + 2;
            int i24 = iArr[i21];
            if (i24 != -1) {
                i19 = i24;
            }
            if (segment3 == null) {
                break;
            }
            if (i22 >= 0) {
                int i25 = i16 + 1;
                int i26 = bArr[i16] & 255;
                int i27 = i23 + i22;
                while (i23 != i27) {
                    if (i26 == iArr[i23]) {
                        i11 = iArr[i23 + i22];
                        if (i25 == i17) {
                            segment3 = segment3.next;
                            i12 = segment3.pos;
                            bArr = segment3.data;
                            i17 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        } else {
                            i12 = i25;
                        }
                    } else {
                        i23++;
                    }
                }
                return i19;
            }
            int i28 = i23 + (i22 * (-1));
            while (true) {
                int i29 = i16 + 1;
                int i31 = i23 + 1;
                if ((bArr[i16] & 255) != iArr[i23]) {
                    return i19;
                }
                boolean z12 = i31 == i28;
                if (i29 == i17) {
                    Segment segment4 = segment3.next;
                    i14 = segment4.pos;
                    byte[] bArr2 = segment4.data;
                    i13 = segment4.limit;
                    if (segment4 != segment2) {
                        segment = segment4;
                        bArr = bArr2;
                    } else {
                        if (!z12) {
                            break loop0;
                        }
                        bArr = bArr2;
                        segment = null;
                    }
                } else {
                    segment = segment3;
                    i13 = i17;
                    i14 = i29;
                }
                if (z12) {
                    i11 = iArr[i31];
                    i12 = i14;
                    i17 = i13;
                    segment3 = segment;
                    break;
                }
                i16 = i14;
                i17 = i13;
                segment3 = segment;
                i23 = i31;
            }
            if (i11 >= 0) {
                return i11;
            }
            i18 = -i11;
            i16 = i12;
            i15 = -2;
        }
        return z11 ? i15 : i19;
    }

    public final ByteString sha1() {
        return digest(EncoderUtil.ALGORITHM_SHA_1);
    }

    public final ByteString sha256() {
        return digest(EncoderUtil.ALGORITHM_SHA_256);
    }

    public final ByteString sha512() {
        return digest(EncoderUtil.ALGORITHM_SHA_512);
    }

    public final long size() {
        return this.size;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void skip(long j11) throws EOFException {
        while (j11 > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j11, segment.limit - segment.pos);
            long j12 = iMin;
            this.size -= j12;
            j11 -= j12;
            Segment segment2 = this.head;
            int i11 = segment2.pos + iMin;
            segment2.pos = i11;
            if (i11 == segment2.limit) {
                this.head = segment2.pop();
                SegmentPool.recycle(segment2);
            }
        }
    }

    public final ByteString snapshot() {
        long j11 = this.size;
        if (j11 <= 2147483647L) {
            return snapshot((int) j11);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public final ByteString snapshot(int i11) {
        return i11 == 0 ? ByteString.EMPTY : new SegmentedByteString(this, i11);
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public Segment writableSegment(int i11) {
        if (i11 < 1 || i11 > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.head;
        if (segment != null) {
            Segment segment2 = segment.prev;
            return (segment2.limit + i11 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment segmentTake = SegmentPool.take();
        this.head = segmentTake;
        segmentTake.prev = segmentTake;
        segmentTake.next = segmentTake;
        return segmentTake;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i11 = iRemaining;
        while (i11 > 0) {
            Segment segmentWritableSegment = writableSegment(1);
            int iMin = Math.min(i11, 8192 - segmentWritableSegment.limit);
            byteBuffer.get(segmentWritableSegment.data, segmentWritableSegment.limit, iMin);
            i11 -= iMin;
            segmentWritableSegment.limit += iMin;
        }
        this.size += (long) iRemaining;
        return iRemaining;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer write(byte[] bArr, int i11, int i12) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j11 = i12;
        Util.checkOffsetAndCount(bArr.length, i11, j11);
        int i13 = i12 + i11;
        while (i11 < i13) {
            Segment segmentWritableSegment = writableSegment(1);
            int iMin = Math.min(i13 - i11, 8192 - segmentWritableSegment.limit);
            System.arraycopy(bArr, i11, segmentWritableSegment.data, segmentWritableSegment.limit, iMin);
            i11 += iMin;
            segmentWritableSegment.limit += iMin;
        }
        this.size += j11;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink write(Source source, long j11) throws IOException {
        while (j11 > 0) {
            long j12 = source.read(this, j11);
            if (j12 == -1) {
                throw new EOFException();
            }
            j11 -= j12;
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public void write(Buffer buffer, long j11) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer.size, 0L, j11);
        while (j11 > 0) {
            Segment segment = buffer.head;
            if (j11 < segment.limit - segment.pos) {
                Segment segment2 = this.head;
                Segment segment3 = segment2 != null ? segment2.prev : null;
                if (segment3 != null && segment3.owner) {
                    if ((((long) segment3.limit) + j11) - ((long) (segment3.shared ? 0 : segment3.pos)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        segment.writeTo(segment3, (int) j11);
                        buffer.size -= j11;
                        this.size += j11;
                        return;
                    }
                }
                buffer.head = segment.split((int) j11);
            }
            Segment segment4 = buffer.head;
            long j12 = segment4.limit - segment4.pos;
            buffer.head = segment4.pop();
            Segment segment5 = this.head;
            if (segment5 == null) {
                this.head = segment4;
                segment4.prev = segment4;
                segment4.next = segment4;
            } else {
                segment5.prev.push(segment4).compact();
            }
            buffer.size -= j12;
            this.size += j12;
            j11 -= j12;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j11 = 0;
        while (true) {
            long j12 = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j12 == -1) {
                return j11;
            }
            j11 += j12;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeByte(int i11) {
        Segment segmentWritableSegment = writableSegment(1);
        byte[] bArr = segmentWritableSegment.data;
        int i12 = segmentWritableSegment.limit;
        segmentWritableSegment.limit = i12 + 1;
        bArr[i12] = (byte) i11;
        this.size++;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeDecimalLong(long j11) {
        boolean z11;
        if (j11 == 0) {
            return writeByte(48);
        }
        int i11 = 1;
        if (j11 < 0) {
            j11 = -j11;
            if (j11 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z11 = true;
        } else {
            z11 = false;
        }
        if (j11 < 100000000) {
            if (j11 < 10000) {
                if (j11 >= 100) {
                    i11 = j11 < 1000 ? 3 : 4;
                } else if (j11 >= 10) {
                    i11 = 2;
                }
            } else if (j11 < 1000000) {
                i11 = j11 < 100000 ? 5 : 6;
            } else {
                i11 = j11 < 10000000 ? 7 : 8;
            }
        } else if (j11 < 1000000000000L) {
            if (j11 < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                i11 = j11 < C.NANOS_PER_SECOND ? 9 : 10;
            } else {
                i11 = j11 < 100000000000L ? 11 : 12;
            }
        } else if (j11 < 1000000000000000L) {
            if (j11 < 10000000000000L) {
                i11 = 13;
            } else {
                i11 = j11 < 100000000000000L ? 14 : 15;
            }
        } else if (j11 < 100000000000000000L) {
            i11 = j11 < 10000000000000000L ? 16 : 17;
        } else {
            i11 = j11 < 1000000000000000000L ? 18 : 19;
        }
        if (z11) {
            i11++;
        }
        Segment segmentWritableSegment = writableSegment(i11);
        byte[] bArr = segmentWritableSegment.data;
        int i12 = segmentWritableSegment.limit + i11;
        while (j11 != 0) {
            i12--;
            bArr[i12] = DIGITS[(int) (j11 % 10)];
            j11 /= 10;
        }
        if (z11) {
            bArr[i12 - 1] = 45;
        }
        segmentWritableSegment.limit += i11;
        this.size += (long) i11;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j11) {
        if (j11 == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j11)) / 4) + 1;
        Segment segmentWritableSegment = writableSegment(iNumberOfTrailingZeros);
        byte[] bArr = segmentWritableSegment.data;
        int i11 = segmentWritableSegment.limit;
        for (int i12 = (i11 + iNumberOfTrailingZeros) - 1; i12 >= i11; i12--) {
            bArr[i12] = DIGITS[(int) (15 & j11)];
            j11 >>>= 4;
        }
        segmentWritableSegment.limit += iNumberOfTrailingZeros;
        this.size += (long) iNumberOfTrailingZeros;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeInt(int i11) {
        Segment segmentWritableSegment = writableSegment(4);
        byte[] bArr = segmentWritableSegment.data;
        int i12 = segmentWritableSegment.limit;
        bArr[i12] = (byte) ((i11 >>> 24) & 255);
        bArr[i12 + 1] = (byte) ((i11 >>> 16) & 255);
        bArr[i12 + 2] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 3] = (byte) (i11 & 255);
        segmentWritableSegment.limit = i12 + 4;
        this.size += 4;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeIntLe(int i11) {
        return writeInt(Util.reverseBytesInt(i11));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeLong(long j11) {
        Segment segmentWritableSegment = writableSegment(8);
        byte[] bArr = segmentWritableSegment.data;
        int i11 = segmentWritableSegment.limit;
        bArr[i11] = (byte) ((j11 >>> 56) & 255);
        bArr[i11 + 1] = (byte) ((j11 >>> 48) & 255);
        bArr[i11 + 2] = (byte) ((j11 >>> 40) & 255);
        bArr[i11 + 3] = (byte) ((j11 >>> 32) & 255);
        bArr[i11 + 4] = (byte) ((j11 >>> 24) & 255);
        bArr[i11 + 5] = (byte) ((j11 >>> 16) & 255);
        bArr[i11 + 6] = (byte) ((j11 >>> 8) & 255);
        bArr[i11 + 7] = (byte) (j11 & 255);
        segmentWritableSegment.limit = i11 + 8;
        this.size += 8;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeLongLe(long j11) {
        return writeLong(Util.reverseBytesLong(j11));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeShort(int i11) {
        Segment segmentWritableSegment = writableSegment(2);
        byte[] bArr = segmentWritableSegment.data;
        int i12 = segmentWritableSegment.limit;
        bArr[i12] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 1] = (byte) (i11 & 255);
        segmentWritableSegment.limit = i12 + 2;
        this.size += 2;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeShortLe(int i11) {
        return writeShort((int) Util.reverseBytesShort((short) i11));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeString(String str, int i11, int i12, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i11 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i11);
        }
        if (i12 < i11) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i12 + " < " + i11);
        }
        if (i12 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(Util.UTF_8)) {
                return writeUtf8(str, i11, i12);
            }
            byte[] bytes = str.substring(i11, i12).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i12 + " > " + str.length());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public final Buffer writeTo(OutputStream outputStream, long j11) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, 0L, j11);
        Segment segment = this.head;
        while (j11 > 0) {
            int iMin = (int) Math.min(j11, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, iMin);
            int i11 = segment.pos + iMin;
            segment.pos = i11;
            long j12 = iMin;
            this.size -= j12;
            j11 -= j12;
            if (i11 == segment.limit) {
                Segment segmentPop = segment.pop();
                this.head = segmentPop;
                SegmentPool.recycle(segment);
                segment = segmentPop;
            }
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeUtf8(String str, int i11, int i12) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i11);
        }
        if (i12 < i11) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i12 + " < " + i11);
        }
        if (i12 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i12 + " > " + str.length());
        }
        while (i11 < i12) {
            char cCharAt = str.charAt(i11);
            if (cCharAt < 128) {
                Segment segmentWritableSegment = writableSegment(1);
                byte[] bArr = segmentWritableSegment.data;
                int i13 = segmentWritableSegment.limit - i11;
                int iMin = Math.min(i12, 8192 - i13);
                int i14 = i11 + 1;
                bArr[i11 + i13] = (byte) cCharAt;
                while (i14 < iMin) {
                    char cCharAt2 = str.charAt(i14);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i14 + i13] = (byte) cCharAt2;
                    i14++;
                }
                int i15 = segmentWritableSegment.limit;
                int i16 = (i13 + i14) - i15;
                segmentWritableSegment.limit = i15 + i16;
                this.size += (long) i16;
                i11 = i14;
            } else {
                if (cCharAt < 2048) {
                    writeByte((cCharAt >> 6) | PsExtractor.AUDIO_STREAM);
                    writeByte((cCharAt & '?') | 128);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    writeByte((cCharAt >> '\f') | 224);
                    writeByte(((cCharAt >> 6) & 63) | 128);
                    writeByte((cCharAt & '?') | 128);
                } else {
                    int i17 = i11 + 1;
                    char cCharAt3 = i17 < i12 ? str.charAt(i17) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        writeByte(63);
                        i11 = i17;
                    } else {
                        int i18 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        writeByte((i18 >> 18) | 240);
                        writeByte(((i18 >> 12) & 63) | 128);
                        writeByte(((i18 >> 6) & 63) | 128);
                        writeByte((i18 & 63) | 128);
                        i11 += 2;
                    }
                }
                i11++;
            }
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i11) {
        if (i11 < 128) {
            writeByte(i11);
        } else if (i11 < 2048) {
            writeByte((i11 >> 6) | PsExtractor.AUDIO_STREAM);
            writeByte((i11 & 63) | 128);
        } else if (i11 < 65536) {
            if (i11 < 55296 || i11 > 57343) {
                writeByte((i11 >> 12) | 224);
                writeByte(((i11 >> 6) & 63) | 128);
                writeByte((i11 & 63) | 128);
            } else {
                writeByte(63);
            }
        } else {
            if (i11 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i11));
            }
            writeByte((i11 >> 18) | 240);
            writeByte(((i11 >> 12) & 63) | 128);
            writeByte(((i11 >> 6) & 63) | 128);
            writeByte((i11 & 63) | 128);
        }
        return this;
    }
}
