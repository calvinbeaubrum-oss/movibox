package okio;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
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
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.connection.RealConnection;
import okio.internal.BufferKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    @JvmField
    public Segment head;
    private long size;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class UnsafeCursor implements Closeable {

        @JvmField
        public Buffer buffer;

        @JvmField
        public byte[] data;

        @JvmField
        public boolean readWrite;
        private Segment segment;

        @JvmField
        public long offset = -1;

        @JvmField
        public int start = -1;

        @JvmField
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.buffer != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            setSegment$okio(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i11) {
            if (!(i11 > 0)) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i11).toString());
            }
            if (!(i11 <= 8192)) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i11).toString());
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
            }
            long size = buffer.size();
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i11);
            int i12 = 8192 - segmentWritableSegment$okio.limit;
            segmentWritableSegment$okio.limit = 8192;
            long j11 = i12;
            buffer.setSize$okio(size + j11);
            setSegment$okio(segmentWritableSegment$okio);
            this.offset = size;
            this.data = segmentWritableSegment$okio.data;
            this.start = 8192 - i12;
            this.end = 8192;
            return j11;
        }

        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final int next() {
            long j11 = this.offset;
            Buffer buffer = this.buffer;
            Intrinsics.d(buffer);
            if (!(j11 != buffer.size())) {
                throw new IllegalStateException("no more bytes".toString());
            }
            long j12 = this.offset;
            return seek(j12 == -1 ? 0L : j12 + ((long) (this.end - this.start)));
        }

        public final long resizeBuffer(long j11) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long size = buffer.size();
            int i11 = 1;
            if (j11 <= size) {
                if (!(j11 >= 0)) {
                    throw new IllegalArgumentException(("newSize < 0: " + j11).toString());
                }
                long j12 = size - j11;
                while (j12 > 0) {
                    Segment segment = buffer.head;
                    Intrinsics.d(segment);
                    Segment segment2 = segment.prev;
                    Intrinsics.d(segment2);
                    int i12 = segment2.limit;
                    long j13 = i12 - segment2.pos;
                    if (j13 > j12) {
                        segment2.limit = i12 - ((int) j12);
                        break;
                    }
                    buffer.head = segment2.pop();
                    SegmentPool.recycle(segment2);
                    j12 -= j13;
                }
                setSegment$okio(null);
                this.offset = j11;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j11 > size) {
                long j14 = j11 - size;
                boolean z11 = true;
                while (j14 > 0) {
                    Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i11);
                    int iMin = (int) Math.min(j14, 8192 - segmentWritableSegment$okio.limit);
                    segmentWritableSegment$okio.limit += iMin;
                    j14 -= (long) iMin;
                    if (z11) {
                        setSegment$okio(segmentWritableSegment$okio);
                        this.offset = size;
                        this.data = segmentWritableSegment$okio.data;
                        int i13 = segmentWritableSegment$okio.limit;
                        this.start = i13 - iMin;
                        this.end = i13;
                        z11 = false;
                    }
                    i11 = 1;
                }
            }
            buffer.setSize$okio(j11);
            return size;
        }

        public final int seek(long j11) {
            Segment segmentPush;
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (j11 < -1 || j11 > buffer.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j11 + " > size=" + buffer.size());
            }
            if (j11 == -1 || j11 == buffer.size()) {
                setSegment$okio(null);
                this.offset = j11;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long size = buffer.size();
            Segment segment$okio = buffer.head;
            long j12 = 0;
            if (getSegment$okio() != null) {
                long j13 = this.offset;
                int i11 = this.start;
                Segment segment$okio2 = getSegment$okio();
                Intrinsics.d(segment$okio2);
                long j14 = j13 - ((long) (i11 - segment$okio2.pos));
                if (j14 > j11) {
                    segmentPush = segment$okio;
                    segment$okio = getSegment$okio();
                    size = j14;
                } else {
                    segmentPush = getSegment$okio();
                    j12 = j14;
                }
            } else {
                segmentPush = segment$okio;
            }
            if (size - j11 > j11 - j12) {
                while (true) {
                    Intrinsics.d(segmentPush);
                    int i12 = segmentPush.limit;
                    int i13 = segmentPush.pos;
                    if (j11 < ((long) (i12 - i13)) + j12) {
                        break;
                    }
                    j12 += (long) (i12 - i13);
                    segmentPush = segmentPush.next;
                }
            } else {
                while (size > j11) {
                    Intrinsics.d(segment$okio);
                    segment$okio = segment$okio.prev;
                    Intrinsics.d(segment$okio);
                    size -= (long) (segment$okio.limit - segment$okio.pos);
                }
                j12 = size;
                segmentPush = segment$okio;
            }
            if (this.readWrite) {
                Intrinsics.d(segmentPush);
                if (segmentPush.shared) {
                    Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                    if (buffer.head == segmentPush) {
                        buffer.head = segmentUnsharedCopy;
                    }
                    segmentPush = segmentPush.push(segmentUnsharedCopy);
                    Segment segment = segmentPush.prev;
                    Intrinsics.d(segment);
                    segment.pop();
                }
            }
            setSegment$okio(segmentPush);
            this.offset = j11;
            Intrinsics.d(segmentPush);
            this.data = segmentPush.data;
            int i14 = segmentPush.pos + ((int) (j11 - j12));
            this.start = i14;
            int i15 = segmentPush.limit;
            this.end = i15;
            return i15 - i14;
        }

        public final void setSegment$okio(Segment segment) {
            this.segment = segment;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j11, long j12, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        long j13 = j11;
        if ((i11 & 4) != 0) {
            j12 = buffer.size - j13;
        }
        return buffer.copyTo(outputStream, j13, j12);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        return buffer.copyTo(buffer2, j11);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j11, long j12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        return buffer.copyTo(buffer2, j11, j12);
    }

    private final ByteString digest(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i11 = segment.pos;
            messageDigest.update(bArr, i11, segment.limit - i11);
            Segment segment2 = segment.next;
            Intrinsics.d(segment2);
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i12 = segment2.pos;
                messageDigest.update(bArr2, i12, segment2.limit - i12);
                segment2 = segment2.next;
                Intrinsics.d(segment2);
            }
        }
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.f(bArrDigest, "messageDigest.digest()");
        return new ByteString(bArrDigest);
    }

    private final ByteString hmac(String str, ByteString byteString) throws NoSuchAlgorithmException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i11 = segment.pos;
                mac.update(bArr, i11, segment.limit - i11);
                Segment segment2 = segment.next;
                Intrinsics.d(segment2);
                while (segment2 != segment) {
                    byte[] bArr2 = segment2.data;
                    int i12 = segment2.pos;
                    mac.update(bArr2, i12, segment2.limit - i12);
                    segment2 = segment2.next;
                    Intrinsics.d(segment2);
                }
            }
            byte[] bArrDoFinal = mac.doFinal();
            Intrinsics.f(bArrDoFinal, "mac.doFinal()");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    private final void readFrom(InputStream inputStream, long j11, boolean z11) throws IOException {
        while (true) {
            if (j11 <= 0 && !z11) {
                return;
            }
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int i11 = inputStream.read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j11, 8192 - segmentWritableSegment$okio.limit));
            if (i11 == -1) {
                if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                    this.head = segmentWritableSegment$okio.pop();
                    SegmentPool.recycle(segmentWritableSegment$okio);
                }
                if (!z11) {
                    throw new EOFException();
                }
                return;
            }
            segmentWritableSegment$okio.limit += i11;
            long j12 = i11;
            this.size += j12;
            j11 -= j12;
        }
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j11, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            j11 = buffer.size;
        }
        return buffer.writeTo(outputStream, j11);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m312deprecated_getByte(long j11) {
        return getByte(j11);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final long m313deprecated_size() {
        return this.size;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    public final void clear() throws EOFException {
        skip(size());
    }

    public Buffer clone() {
        return copy();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        Intrinsics.d(segment);
        Segment segment2 = segment.prev;
        Intrinsics.d(segment2);
        int i11 = segment2.limit;
        if (i11 < 8192 && segment2.owner) {
            size -= (long) (i11 - segment2.pos);
        }
        return size;
    }

    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            Intrinsics.d(segment);
            Segment segmentSharedCopy = segment.sharedCopy();
            buffer.head = segmentSharedCopy;
            segmentSharedCopy.prev = segmentSharedCopy;
            segmentSharedCopy.next = segmentSharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = segmentSharedCopy.prev;
                Intrinsics.d(segment3);
                Intrinsics.d(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    @JvmOverloads
    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo$default(this, outputStream, 0L, 0L, 6, (Object) null);
    }

    @JvmOverloads
    public final Buffer copyTo(OutputStream outputStream, long j11) throws IOException {
        return copyTo$default(this, outputStream, j11, 0L, 4, (Object) null);
    }

    @JvmOverloads
    public final Buffer copyTo(OutputStream out, long j11, long j12) throws IOException {
        Intrinsics.g(out, "out");
        Util.checkOffsetAndCount(this.size, j11, j12);
        if (j12 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            Intrinsics.d(segment);
            int i11 = segment.limit;
            int i12 = segment.pos;
            if (j11 < i11 - i12) {
                break;
            }
            j11 -= (long) (i11 - i12);
            segment = segment.next;
        }
        while (j12 > 0) {
            Intrinsics.d(segment);
            int i13 = (int) (((long) segment.pos) + j11);
            int iMin = (int) Math.min(segment.limit - i13, j12);
            out.write(segment.data, i13, iMin);
            j12 -= (long) iMin;
            segment = segment.next;
            j11 = 0;
        }
        return this;
    }

    public final Buffer copyTo(Buffer out, long j11) {
        Intrinsics.g(out, "out");
        return copyTo(out, j11, this.size - j11);
    }

    public final Buffer copyTo(Buffer out, long j11, long j12) {
        Intrinsics.g(out, "out");
        Util.checkOffsetAndCount(size(), j11, j12);
        if (j12 != 0) {
            out.setSize$okio(out.size() + j12);
            Segment segment = this.head;
            while (true) {
                Intrinsics.d(segment);
                int i11 = segment.limit;
                int i12 = segment.pos;
                if (j11 < i11 - i12) {
                    break;
                }
                j11 -= (long) (i11 - i12);
                segment = segment.next;
            }
            while (j12 > 0) {
                Intrinsics.d(segment);
                Segment segmentSharedCopy = segment.sharedCopy();
                int i13 = segmentSharedCopy.pos + ((int) j11);
                segmentSharedCopy.pos = i13;
                segmentSharedCopy.limit = Math.min(i13 + ((int) j12), segmentSharedCopy.limit);
                Segment segment2 = out.head;
                if (segment2 == null) {
                    segmentSharedCopy.prev = segmentSharedCopy;
                    segmentSharedCopy.next = segmentSharedCopy;
                    out.head = segmentSharedCopy;
                } else {
                    Intrinsics.d(segment2);
                    Segment segment3 = segment2.prev;
                    Intrinsics.d(segment3);
                    segment3.push(segmentSharedCopy);
                }
                j12 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
                segment = segment.next;
                j11 = 0;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            if (size() == buffer.size()) {
                if (size() == 0) {
                    return true;
                }
                Segment segment = this.head;
                Intrinsics.d(segment);
                Segment segment2 = buffer.head;
                Intrinsics.d(segment2);
                int i11 = segment.pos;
                int i12 = segment2.pos;
                long j11 = 0;
                while (j11 < size()) {
                    long jMin = Math.min(segment.limit - i11, segment2.limit - i12);
                    long j12 = 0;
                    while (j12 < jMin) {
                        int i13 = i11 + 1;
                        int i14 = i12 + 1;
                        if (segment.data[i11] == segment2.data[i12]) {
                            j12++;
                            i11 = i13;
                            i12 = i14;
                        }
                    }
                    if (i11 == segment.limit) {
                        segment = segment.next;
                        Intrinsics.d(segment);
                        i11 = segment.pos;
                    }
                    if (i12 == segment2.limit) {
                        segment2 = segment2.next;
                        Intrinsics.d(segment2);
                        i12 = segment2.pos;
                    }
                    j11 += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer getBuffer() {
        return this;
    }

    @JvmName
    public final byte getByte(long j11) {
        Util.checkOffsetAndCount(size(), j11, 1L);
        Segment segment = this.head;
        if (segment == null) {
            Intrinsics.d(null);
            throw null;
        }
        if (size() - j11 < j11) {
            long size = size();
            while (size > j11) {
                segment = segment.prev;
                Intrinsics.d(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            Intrinsics.d(segment);
            return segment.data[(int) ((((long) segment.pos) + j11) - size)];
        }
        long j12 = 0;
        while (true) {
            long j13 = ((long) (segment.limit - segment.pos)) + j12;
            if (j13 > j11) {
                Intrinsics.d(segment);
                return segment.data[(int) ((((long) segment.pos) + j11) - j12)];
            }
            segment = segment.next;
            Intrinsics.d(segment);
            j12 = j13;
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
            Intrinsics.d(segment);
        } while (segment != this.head);
        return i11;
    }

    public final ByteString hmacSha1(ByteString key) {
        Intrinsics.g(key, "key");
        return hmac("HmacSHA1", key);
    }

    public final ByteString hmacSha256(ByteString key) {
        Intrinsics.g(key, "key");
        return hmac("HmacSHA256", key);
    }

    public final ByteString hmacSha512(ByteString key) {
        Intrinsics.g(key, "key");
        return hmac("HmacSHA512", key);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b11) {
        return indexOf(b11, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b11, long j11) {
        return indexOf(b11, j11, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b11, long j11, long j12) {
        Segment segment;
        int i11;
        long size = 0;
        if (!(0 <= j11 && j12 >= j11)) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j11 + " toIndex=" + j12).toString());
        }
        if (j12 > size()) {
            j12 = size();
        }
        if (j11 == j12 || (segment = this.head) == null) {
            return -1L;
        }
        if (size() - j11 < j11) {
            size = size();
            while (size > j11) {
                segment = segment.prev;
                Intrinsics.d(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            while (size < j12) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j12) - size);
                i11 = (int) ((((long) segment.pos) + j11) - size);
                while (i11 < iMin) {
                    if (bArr[i11] != b11) {
                        i11++;
                    }
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.d(segment);
                j11 = size;
            }
            return -1L;
        }
        while (true) {
            long j13 = ((long) (segment.limit - segment.pos)) + size;
            if (j13 > j11) {
                break;
            }
            segment = segment.next;
            Intrinsics.d(segment);
            size = j13;
        }
        while (size < j12) {
            byte[] bArr2 = segment.data;
            int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + j12) - size);
            i11 = (int) ((((long) segment.pos) + j11) - size);
            while (i11 < iMin2) {
                if (bArr2[i11] != b11) {
                    i11++;
                }
            }
            size += (long) (segment.limit - segment.pos);
            segment = segment.next;
            Intrinsics.d(segment);
            j11 = size;
        }
        return -1L;
        return ((long) (i11 - segment.pos)) + size;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes) throws IOException {
        Intrinsics.g(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes, long j11) throws IOException {
        long j12 = j11;
        Intrinsics.g(bytes, "bytes");
        if (!(bytes.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j13 = 0;
        if (!(j12 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j12).toString());
        }
        Segment segment = this.head;
        if (segment != null) {
            if (size() - j12 < j12) {
                long size = size();
                while (size > j12) {
                    segment = segment.prev;
                    Intrinsics.d(segment);
                    size -= (long) (segment.limit - segment.pos);
                }
                byte[] bArrInternalArray$okio = bytes.internalArray$okio();
                byte b11 = bArrInternalArray$okio[0];
                int size2 = bytes.size();
                long size3 = (size() - ((long) size2)) + 1;
                while (size < size3) {
                    byte[] bArr = segment.data;
                    long j14 = size;
                    int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + size3) - size);
                    for (int i11 = (int) ((((long) segment.pos) + j12) - j14); i11 < iMin; i11++) {
                        if (bArr[i11] == b11 && BufferKt.rangeEquals(segment, i11 + 1, bArrInternalArray$okio, 1, size2)) {
                            return ((long) (i11 - segment.pos)) + j14;
                        }
                    }
                    size = j14 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    Intrinsics.d(segment);
                    j12 = size;
                }
            } else {
                while (true) {
                    long j15 = ((long) (segment.limit - segment.pos)) + j13;
                    if (j15 > j12) {
                        break;
                    }
                    segment = segment.next;
                    Intrinsics.d(segment);
                    j13 = j15;
                }
                byte[] bArrInternalArray$okio2 = bytes.internalArray$okio();
                byte b12 = bArrInternalArray$okio2[0];
                int size4 = bytes.size();
                long size5 = (size() - ((long) size4)) + 1;
                while (j13 < size5) {
                    byte[] bArr2 = segment.data;
                    long j16 = size5;
                    int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + size5) - j13);
                    for (int i12 = (int) ((((long) segment.pos) + j12) - j13); i12 < iMin2; i12++) {
                        if (bArr2[i12] == b12 && BufferKt.rangeEquals(segment, i12 + 1, bArrInternalArray$okio2, 1, size4)) {
                            return ((long) (i12 - segment.pos)) + j13;
                        }
                    }
                    j13 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.d(segment);
                    j12 = j13;
                    size5 = j16;
                }
            }
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes) {
        Intrinsics.g(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes, long j11) {
        int i11;
        int i12;
        Intrinsics.g(targetBytes, "targetBytes");
        long size = 0;
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j11).toString());
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        if (size() - j11 < j11) {
            size = size();
            while (size > j11) {
                segment = segment.prev;
                Intrinsics.d(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            if (targetBytes.size() == 2) {
                byte b11 = targetBytes.getByte(0);
                byte b12 = targetBytes.getByte(1);
                while (size < size()) {
                    byte[] bArr = segment.data;
                    i11 = (int) ((((long) segment.pos) + j11) - size);
                    int i13 = segment.limit;
                    while (true) {
                        if (i11 >= i13) {
                            size += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            Intrinsics.d(segment);
                            j11 = size;
                        } else {
                            byte b13 = bArr[i11];
                            if (b13 == b11 || b13 == b12) {
                                i12 = segment.pos;
                            } else {
                                i11++;
                            }
                        }
                    }
                }
                return -1L;
            }
            byte[] bArrInternalArray$okio = targetBytes.internalArray$okio();
            while (size < size()) {
                byte[] bArr2 = segment.data;
                i11 = (int) ((((long) segment.pos) + j11) - size);
                int i14 = segment.limit;
                while (true) {
                    if (i11 < i14) {
                        byte b14 = bArr2[i11];
                        int length = bArrInternalArray$okio.length;
                        int i15 = 0;
                        while (true) {
                            if (i15 >= length) {
                                i11++;
                            } else if (b14 == bArrInternalArray$okio[i15]) {
                                i12 = segment.pos;
                            } else {
                                i15++;
                            }
                        }
                    } else {
                        size += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.d(segment);
                        j11 = size;
                    }
                }
            }
            return -1L;
        }
        while (true) {
            long j12 = ((long) (segment.limit - segment.pos)) + size;
            if (j12 > j11) {
                break;
            }
            segment = segment.next;
            Intrinsics.d(segment);
            size = j12;
        }
        if (targetBytes.size() == 2) {
            byte b15 = targetBytes.getByte(0);
            byte b16 = targetBytes.getByte(1);
            while (size < size()) {
                byte[] bArr3 = segment.data;
                i11 = (int) ((((long) segment.pos) + j11) - size);
                int i16 = segment.limit;
                while (true) {
                    if (i11 >= i16) {
                        size += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.d(segment);
                        j11 = size;
                    } else {
                        byte b17 = bArr3[i11];
                        if (b17 == b15 || b17 == b16) {
                            i12 = segment.pos;
                        } else {
                            i11++;
                        }
                    }
                }
            }
            return -1L;
        }
        byte[] bArrInternalArray$okio2 = targetBytes.internalArray$okio();
        while (size < size()) {
            byte[] bArr4 = segment.data;
            i11 = (int) ((((long) segment.pos) + j11) - size);
            int i17 = segment.limit;
            while (true) {
                if (i11 < i17) {
                    byte b18 = bArr4[i11];
                    int length2 = bArrInternalArray$okio2.length;
                    int i18 = 0;
                    while (true) {
                        if (i18 >= length2) {
                            i11++;
                        } else if (b18 == bArrInternalArray$okio2[i18]) {
                            i12 = segment.pos;
                        } else {
                            i18++;
                        }
                    }
                } else {
                    size += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.d(segment);
                    j11 = size;
                }
            }
        }
        return -1L;
        return ((long) (i11 - i12)) + size;
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer.inputStream.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), Api.BaseClientBuilder.API_PRIORITY_OTHER);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] sink, int i11, int i12) {
                Intrinsics.g(sink, "sink");
                return Buffer.this.read(sink, i11, i12);
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

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer.outputStream.1
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
                Buffer.this.writeByte(i11);
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int i11, int i12) {
                Intrinsics.g(data, "data");
                Buffer.this.write(data, i11, i12);
            }
        };
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j11, ByteString bytes) {
        Intrinsics.g(bytes, "bytes");
        return rangeEquals(j11, bytes, 0, bytes.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j11, ByteString bytes, int i11, int i12) {
        Intrinsics.g(bytes, "bytes");
        if (j11 < 0 || i11 < 0 || i12 < 0 || size() - j11 < i12 || bytes.size() - i11 < i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (getByte(((long) i13) + j11) != bytes.getByte(i11 + i13)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) throws IOException {
        Intrinsics.g(sink, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), segment.limit - segment.pos);
        sink.put(segment.data, segment.pos, iMin);
        int i11 = segment.pos + iMin;
        segment.pos = i11;
        this.size -= (long) iMin;
        if (i11 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink) {
        Intrinsics.g(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink, int i11, int i12) {
        Intrinsics.g(sink, "sink");
        Util.checkOffsetAndCount(sink.length, i11, i12);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i12, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i13 = segment.pos;
        ArraysKt___ArraysJvmKt.h(bArr, sink, i11, i13, i13 + iMin);
        segment.pos += iMin;
        setSize$okio(size() - ((long) iMin));
        if (segment.pos != segment.limit) {
            return iMin;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return iMin;
    }

    @Override // okio.Source
    public long read(Buffer sink, long j11) {
        Intrinsics.g(sink, "sink");
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j11 > size()) {
            j11 = size();
        }
        sink.write(this, j11);
        return j11;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        Intrinsics.g(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    @JvmOverloads
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @JvmOverloads
    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.g(unsafeCursor, "unsafeCursor");
        return BufferKt.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        Segment segment = this.head;
        Intrinsics.d(segment);
        int i11 = segment.pos;
        int i12 = segment.limit;
        int i13 = i11 + 1;
        byte b11 = segment.data[i11];
        setSize$okio(size() - 1);
        if (i13 == i12) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i13;
        }
        return b11;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j11) throws EOFException {
        if (!(j11 >= 0 && j11 <= ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER))) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        }
        if (size() < j11) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j11];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j11) throws EOFException {
        if (!(j11 >= 0 && j11 <= ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER))) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        }
        if (size() < j11) {
            throw new EOFException();
        }
        if (j11 < 4096) {
            return new ByteString(readByteArray(j11));
        }
        ByteString byteStringSnapshot = snapshot((int) j11);
        skip(j11);
        return byteStringSnapshot;
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        int i11 = 0;
        long j11 = -7;
        boolean z11 = false;
        long j12 = 0;
        boolean z12 = false;
        do {
            Segment segment = this.head;
            Intrinsics.d(segment);
            byte[] bArr = segment.data;
            int i12 = segment.pos;
            int i13 = segment.limit;
            while (i12 < i13) {
                byte b11 = bArr[i12];
                byte b12 = (byte) 48;
                if (b11 >= b12 && b11 <= ((byte) 57)) {
                    int i14 = b12 - b11;
                    if (j12 < BufferKt.OVERFLOW_ZONE || (j12 == BufferKt.OVERFLOW_ZONE && i14 < j11)) {
                        Buffer bufferWriteByte = new Buffer().writeDecimalLong(j12).writeByte((int) b11);
                        if (!z11) {
                            bufferWriteByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + bufferWriteByte.readUtf8());
                    }
                    j12 = (j12 * 10) + ((long) i14);
                } else {
                    if (b11 != ((byte) 45) || i11 != 0) {
                        if (i11 != 0) {
                            z12 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Util.toHexString(b11));
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
        setSize$okio(size() - ((long) i11));
        return z11 ? j12 : -j12;
    }

    public final Buffer readFrom(InputStream input) throws IOException {
        Intrinsics.g(input, "input");
        readFrom(input, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream input, long j11) throws IOException {
        Intrinsics.g(input, "input");
        if (j11 >= 0) {
            readFrom(input, j11, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer sink, long j11) throws EOFException {
        Intrinsics.g(sink, "sink");
        if (size() >= j11) {
            sink.write(this, j11);
        } else {
            sink.write(this, size());
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.g(sink, "sink");
        int i11 = 0;
        while (i11 < sink.length) {
            int i12 = read(sink, i11, sink.length - i11);
            if (i12 == -1) {
                throw new EOFException();
            }
            i11 += i12;
        }
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws EOFException {
        int i11;
        if (size() == 0) {
            throw new EOFException();
        }
        int i12 = 0;
        long j11 = 0;
        boolean z11 = false;
        do {
            Segment segment = this.head;
            Intrinsics.d(segment);
            byte[] bArr = segment.data;
            int i13 = segment.pos;
            int i14 = segment.limit;
            while (i13 < i14) {
                byte b11 = bArr[i13];
                byte b12 = (byte) 48;
                if (b11 < b12 || b11 > ((byte) 57)) {
                    byte b13 = (byte) 97;
                    if ((b11 < b13 || b11 > ((byte) 102)) && (b11 < (b13 = (byte) 65) || b11 > ((byte) 70))) {
                        if (i12 != 0) {
                            z11 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Util.toHexString(b11));
                    }
                    i11 = (b11 - b13) + 10;
                } else {
                    i11 = b11 - b12;
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
        setSize$okio(size() - ((long) i12));
        return j11;
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        Segment segment = this.head;
        Intrinsics.d(segment);
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
        setSize$okio(size() - 4);
        if (i15 == i12) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i15;
        }
        return i16;
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return Util.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        Segment segment = this.head;
        Intrinsics.d(segment);
        int i11 = segment.pos;
        int i12 = segment.limit;
        if (i12 - i11 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = segment.data;
        int i13 = i11 + 7;
        long j11 = ((((long) bArr[i11 + 3]) & 255) << 32) | ((((long) bArr[i11]) & 255) << 56) | ((((long) bArr[i11 + 1]) & 255) << 48) | ((((long) bArr[i11 + 2]) & 255) << 40) | ((((long) bArr[i11 + 4]) & 255) << 24) | ((((long) bArr[i11 + 5]) & 255) << 16) | ((((long) bArr[i11 + 6]) & 255) << 8);
        int i14 = i11 + 8;
        long j12 = j11 | (((long) bArr[i13]) & 255);
        setSize$okio(size() - 8);
        if (i14 == i12) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i14;
        }
        return j12;
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return Util.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        Segment segment = this.head;
        Intrinsics.d(segment);
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
        setSize$okio(size() - 2);
        if (i15 == i12) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i15;
        }
        return (short) i16;
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return Util.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(long j11, Charset charset) throws EOFException {
        Intrinsics.g(charset, "charset");
        if (!(j11 >= 0 && j11 <= ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER))) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        }
        if (this.size < j11) {
            throw new EOFException();
        }
        if (j11 == 0) {
            return "";
        }
        Segment segment = this.head;
        Intrinsics.d(segment);
        int i11 = segment.pos;
        if (((long) i11) + j11 > segment.limit) {
            return new String(readByteArray(j11), charset);
        }
        int i12 = (int) j11;
        String str = new String(segment.data, i11, i12, charset);
        int i13 = segment.pos + i12;
        segment.pos = i13;
        this.size -= j11;
        if (i13 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        Intrinsics.g(charset, "charset");
        return readString(this.size, charset);
    }

    @JvmOverloads
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @JvmOverloads
    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.g(unsafeCursor, "unsafeCursor");
        return BufferKt.commonReadUnsafe(this, unsafeCursor);
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, Charsets.f69091b);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j11) throws EOFException {
        return readString(j11, Charsets.f69091b);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i11;
        int i12;
        int i13;
        if (size() == 0) {
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
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i11 = b11 & 7;
            i12 = 4;
            i13 = 65536;
        }
        long j11 = i12;
        if (size() < j11) {
            throw new EOFException("size < " + i12 + ": " + size() + " (to read code point prefixed 0x" + Util.toHexString(b11) + ')');
        }
        for (int i14 = 1; i14 < i12; i14++) {
            long j12 = i14;
            byte b12 = getByte(j12);
            if ((b12 & 192) != 128) {
                skip(j12);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i11 = (i11 << 6) | (b12 & Utf8.REPLACEMENT_BYTE);
        }
        skip(j11);
        if (i11 > 1114111) {
            return Utf8.REPLACEMENT_CODE_POINT;
        }
        return ((55296 <= i11 && 57343 >= i11) || i11 < i13) ? Utf8.REPLACEMENT_CODE_POINT : i11;
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(this, jIndexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j11) throws EOFException {
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j11).toString());
        }
        long j12 = j11 != Long.MAX_VALUE ? j11 + 1 : Long.MAX_VALUE;
        byte b11 = (byte) 10;
        long jIndexOf = indexOf(b11, 0L, j12);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(this, jIndexOf);
        }
        if (j12 < size() && getByte(j12 - 1) == ((byte) 13) && getByte(j12) == b11) {
            return BufferKt.readUtf8Line(this, j12);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j11) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // okio.BufferedSource
    public boolean request(long j11) {
        return this.size >= j11;
    }

    @Override // okio.BufferedSource
    public void require(long j11) throws EOFException {
        if (this.size < j11) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) throws EOFException {
        Intrinsics.g(options, "options");
        int iSelectPrefix$default = BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[iSelectPrefix$default].size());
        return iSelectPrefix$default;
    }

    public final void setSize$okio(long j11) {
        this.size = j11;
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

    @JvmName
    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j11) throws EOFException {
        while (j11 > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j11, segment.limit - segment.pos);
            long j12 = iMin;
            setSize$okio(size() - j12);
            j11 -= j12;
            int i11 = segment.pos + iMin;
            segment.pos = i11;
            if (i11 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final ByteString snapshot() {
        if (size() <= ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER)) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    public final ByteString snapshot(int i11) {
        if (i11 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(size(), 0L, i11);
        Segment segment = this.head;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            Intrinsics.d(segment);
            int i15 = segment.limit;
            int i16 = segment.pos;
            if (i15 == i16) {
                throw new AssertionError("s.limit == s.pos");
            }
            i13 += i15 - i16;
            i14++;
            segment = segment.next;
        }
        byte[][] bArr = new byte[i14][];
        int[] iArr = new int[i14 * 2];
        Segment segment2 = this.head;
        int i17 = 0;
        while (i12 < i11) {
            Intrinsics.d(segment2);
            bArr[i17] = segment2.data;
            i12 += segment2.limit - segment2.pos;
            iArr[i17] = Math.min(i12, i11);
            iArr[i17 + i14] = segment2.pos;
            segment2.shared = true;
            i17++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final Segment writableSegment$okio(int i11) {
        if (!(i11 >= 1 && i11 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment = this.head;
        if (segment != null) {
            Intrinsics.d(segment);
            Segment segment2 = segment.prev;
            Intrinsics.d(segment2);
            return (segment2.limit + i11 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment segmentTake = SegmentPool.take();
        this.head = segmentTake;
        segmentTake.prev = segmentTake;
        segmentTake.next = segmentTake;
        return segmentTake;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) throws IOException {
        Intrinsics.g(source, "source");
        int iRemaining = source.remaining();
        int i11 = iRemaining;
        while (i11 > 0) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i11, 8192 - segmentWritableSegment$okio.limit);
            source.get(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
            i11 -= iMin;
            segmentWritableSegment$okio.limit += iMin;
        }
        this.size += (long) iRemaining;
        return iRemaining;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        Intrinsics.g(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString, int i11, int i12) {
        Intrinsics.g(byteString, "byteString");
        byteString.write$okio(this, i11, i12);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(Source source, long j11) throws IOException {
        Intrinsics.g(source, "source");
        while (j11 > 0) {
            long j12 = source.read(this, j11);
            if (j12 == -1) {
                throw new EOFException();
            }
            j11 -= j12;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] source) {
        Intrinsics.g(source, "source");
        return write(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] source, int i11, int i12) {
        Intrinsics.g(source, "source");
        long j11 = i12;
        Util.checkOffsetAndCount(source.length, i11, j11);
        int i13 = i12 + i11;
        while (i11 < i13) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i13 - i11, 8192 - segmentWritableSegment$okio.limit);
            int i14 = i11 + iMin;
            ArraysKt___ArraysJvmKt.h(source, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, i11, i14);
            segmentWritableSegment$okio.limit += iMin;
            i11 = i14;
        }
        setSize$okio(size() + j11);
        return this;
    }

    @Override // okio.Sink
    public void write(Buffer source, long j11) {
        Segment segment;
        Intrinsics.g(source, "source");
        if (!(source != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        Util.checkOffsetAndCount(source.size(), 0L, j11);
        while (j11 > 0) {
            Segment segment2 = source.head;
            Intrinsics.d(segment2);
            int i11 = segment2.limit;
            Segment segment3 = source.head;
            Intrinsics.d(segment3);
            if (j11 < i11 - segment3.pos) {
                Segment segment4 = this.head;
                if (segment4 != null) {
                    Intrinsics.d(segment4);
                    segment = segment4.prev;
                } else {
                    segment = null;
                }
                if (segment != null && segment.owner) {
                    if ((((long) segment.limit) + j11) - ((long) (segment.shared ? 0 : segment.pos)) <= 8192) {
                        Segment segment5 = source.head;
                        Intrinsics.d(segment5);
                        segment5.writeTo(segment, (int) j11);
                        source.setSize$okio(source.size() - j11);
                        setSize$okio(size() + j11);
                        return;
                    }
                }
                Segment segment6 = source.head;
                Intrinsics.d(segment6);
                source.head = segment6.split((int) j11);
            }
            Segment segment7 = source.head;
            Intrinsics.d(segment7);
            long j12 = segment7.limit - segment7.pos;
            source.head = segment7.pop();
            Segment segment8 = this.head;
            if (segment8 == null) {
                this.head = segment7;
                segment7.prev = segment7;
                segment7.next = segment7;
            } else {
                Intrinsics.d(segment8);
                Segment segment9 = segment8.prev;
                Intrinsics.d(segment9);
                segment9.push(segment7).compact();
            }
            source.setSize$okio(source.size() - j12);
            setSize$okio(size() + j12);
            j11 -= j12;
        }
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        Intrinsics.g(source, "source");
        long j11 = 0;
        while (true) {
            long j12 = source.read(this, 8192);
            if (j12 == -1) {
                return j11;
            }
            j11 += j12;
        }
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i11) {
        Segment segmentWritableSegment$okio = writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i12 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i12 + 1;
        bArr[i12] = (byte) i11;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
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
        Segment segmentWritableSegment$okio = writableSegment$okio(i11);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i12 = segmentWritableSegment$okio.limit + i11;
        while (j11 != 0) {
            long j12 = 10;
            i12--;
            bArr[i12] = BufferKt.getHEX_DIGIT_BYTES()[(int) (j11 % j12)];
            j11 /= j12;
        }
        if (z11) {
            bArr[i12 - 1] = (byte) 45;
        }
        segmentWritableSegment$okio.limit += i11;
        setSize$okio(size() + ((long) i11));
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j11) {
        if (j11 == 0) {
            return writeByte(48);
        }
        long j12 = (j11 >>> 1) | j11;
        long j13 = j12 | (j12 >>> 2);
        long j14 = j13 | (j13 >>> 4);
        long j15 = j14 | (j14 >>> 8);
        long j16 = j15 | (j15 >>> 16);
        long j17 = j16 | (j16 >>> 32);
        long j18 = j17 - ((j17 >>> 1) & 6148914691236517205L);
        long j19 = ((j18 >>> 2) & 3689348814741910323L) + (j18 & 3689348814741910323L);
        long j21 = ((j19 >>> 4) + j19) & 1085102592571150095L;
        long j22 = j21 + (j21 >>> 8);
        long j23 = j22 + (j22 >>> 16);
        int i11 = (int) ((((j23 & 63) + ((j23 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment segmentWritableSegment$okio = writableSegment$okio(i11);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i12 = segmentWritableSegment$okio.limit;
        for (int i13 = (i12 + i11) - 1; i13 >= i12; i13--) {
            bArr[i13] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j11)];
            j11 >>>= 4;
        }
        segmentWritableSegment$okio.limit += i11;
        setSize$okio(size() + ((long) i11));
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i11) {
        Segment segmentWritableSegment$okio = writableSegment$okio(4);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i12 = segmentWritableSegment$okio.limit;
        bArr[i12] = (byte) ((i11 >>> 24) & 255);
        bArr[i12 + 1] = (byte) ((i11 >>> 16) & 255);
        bArr[i12 + 2] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 3] = (byte) (i11 & 255);
        segmentWritableSegment$okio.limit = i12 + 4;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i11) {
        return writeInt(Util.reverseBytes(i11));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j11) {
        Segment segmentWritableSegment$okio = writableSegment$okio(8);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i11 = segmentWritableSegment$okio.limit;
        bArr[i11] = (byte) ((j11 >>> 56) & 255);
        bArr[i11 + 1] = (byte) ((j11 >>> 48) & 255);
        bArr[i11 + 2] = (byte) ((j11 >>> 40) & 255);
        bArr[i11 + 3] = (byte) ((j11 >>> 32) & 255);
        bArr[i11 + 4] = (byte) ((j11 >>> 24) & 255);
        bArr[i11 + 5] = (byte) ((j11 >>> 16) & 255);
        bArr[i11 + 6] = (byte) ((j11 >>> 8) & 255);
        bArr[i11 + 7] = (byte) (j11 & 255);
        segmentWritableSegment$okio.limit = i11 + 8;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j11) {
        return writeLong(Util.reverseBytes(j11));
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i11) {
        Segment segmentWritableSegment$okio = writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i12 = segmentWritableSegment$okio.limit;
        bArr[i12] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 1] = (byte) (i11 & 255);
        segmentWritableSegment$okio.limit = i12 + 2;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i11) {
        return writeShort((int) Util.reverseBytes((short) i11));
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String string, int i11, int i12, Charset charset) {
        Intrinsics.g(string, "string");
        Intrinsics.g(charset, "charset");
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i11).toString());
        }
        if (!(i12 >= i11)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
        }
        if (!(i12 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + string.length()).toString());
        }
        if (Intrinsics.b(charset, Charsets.f69091b)) {
            return writeUtf8(string, i11, i12);
        }
        String strSubstring = string.substring(i11, i12);
        Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (strSubstring == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strSubstring.getBytes(charset);
        Intrinsics.f(bytes, "(this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String string, Charset charset) {
        Intrinsics.g(string, "string");
        Intrinsics.g(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @JvmOverloads
    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo$default(this, outputStream, 0L, 2, null);
    }

    @JvmOverloads
    public final Buffer writeTo(OutputStream out, long j11) throws IOException {
        Intrinsics.g(out, "out");
        Util.checkOffsetAndCount(this.size, 0L, j11);
        Segment segment = this.head;
        while (j11 > 0) {
            Intrinsics.d(segment);
            int iMin = (int) Math.min(j11, segment.limit - segment.pos);
            out.write(segment.data, segment.pos, iMin);
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

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String string) {
        Intrinsics.g(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String string, int i11, int i12) {
        Intrinsics.g(string, "string");
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i11).toString());
        }
        if (!(i12 >= i11)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
        }
        if (!(i12 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + string.length()).toString());
        }
        while (i11 < i12) {
            char cCharAt = string.charAt(i11);
            if (cCharAt < 128) {
                Segment segmentWritableSegment$okio = writableSegment$okio(1);
                byte[] bArr = segmentWritableSegment$okio.data;
                int i13 = segmentWritableSegment$okio.limit - i11;
                int iMin = Math.min(i12, 8192 - i13);
                int i14 = i11 + 1;
                bArr[i11 + i13] = (byte) cCharAt;
                while (i14 < iMin) {
                    char cCharAt2 = string.charAt(i14);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i14 + i13] = (byte) cCharAt2;
                    i14++;
                }
                int i15 = segmentWritableSegment$okio.limit;
                int i16 = (i13 + i14) - i15;
                segmentWritableSegment$okio.limit = i15 + i16;
                setSize$okio(size() + ((long) i16));
                i11 = i14;
            } else {
                if (cCharAt < 2048) {
                    Segment segmentWritableSegment$okio2 = writableSegment$okio(2);
                    byte[] bArr2 = segmentWritableSegment$okio2.data;
                    int i17 = segmentWritableSegment$okio2.limit;
                    bArr2[i17] = (byte) ((cCharAt >> 6) | PsExtractor.AUDIO_STREAM);
                    bArr2[i17 + 1] = (byte) ((cCharAt & '?') | 128);
                    segmentWritableSegment$okio2.limit = i17 + 2;
                    setSize$okio(size() + 2);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    Segment segmentWritableSegment$okio3 = writableSegment$okio(3);
                    byte[] bArr3 = segmentWritableSegment$okio3.data;
                    int i18 = segmentWritableSegment$okio3.limit;
                    bArr3[i18] = (byte) ((cCharAt >> '\f') | 224);
                    bArr3[i18 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i18 + 2] = (byte) ((cCharAt & '?') | 128);
                    segmentWritableSegment$okio3.limit = i18 + 3;
                    setSize$okio(size() + 3);
                } else {
                    int i19 = i11 + 1;
                    char cCharAt3 = i19 < i12 ? string.charAt(i19) : (char) 0;
                    if (cCharAt > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        writeByte(63);
                        i11 = i19;
                    } else {
                        int i21 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment segmentWritableSegment$okio4 = writableSegment$okio(4);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i22 = segmentWritableSegment$okio4.limit;
                        bArr4[i22] = (byte) ((i21 >> 18) | 240);
                        bArr4[i22 + 1] = (byte) (((i21 >> 12) & 63) | 128);
                        bArr4[i22 + 2] = (byte) (((i21 >> 6) & 63) | 128);
                        bArr4[i22 + 3] = (byte) ((i21 & 63) | 128);
                        segmentWritableSegment$okio4.limit = i22 + 4;
                        setSize$okio(size() + 4);
                        i11 += 2;
                    }
                }
                i11++;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i11) {
        if (i11 < 128) {
            writeByte(i11);
        } else if (i11 < 2048) {
            Segment segmentWritableSegment$okio = writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i12 = segmentWritableSegment$okio.limit;
            bArr[i12] = (byte) ((i11 >> 6) | PsExtractor.AUDIO_STREAM);
            bArr[i12 + 1] = (byte) ((i11 & 63) | 128);
            segmentWritableSegment$okio.limit = i12 + 2;
            setSize$okio(size() + 2);
        } else if (55296 <= i11 && 57343 >= i11) {
            writeByte(63);
        } else if (i11 < 65536) {
            Segment segmentWritableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i13 = segmentWritableSegment$okio2.limit;
            bArr2[i13] = (byte) ((i11 >> 12) | 224);
            bArr2[i13 + 1] = (byte) (((i11 >> 6) & 63) | 128);
            bArr2[i13 + 2] = (byte) ((i11 & 63) | 128);
            segmentWritableSegment$okio2.limit = i13 + 3;
            setSize$okio(size() + 3);
        } else {
            if (i11 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i11));
            }
            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
            byte[] bArr3 = segmentWritableSegment$okio3.data;
            int i14 = segmentWritableSegment$okio3.limit;
            bArr3[i14] = (byte) ((i11 >> 18) | 240);
            bArr3[i14 + 1] = (byte) (((i11 >> 12) & 63) | 128);
            bArr3[i14 + 2] = (byte) (((i11 >> 6) & 63) | 128);
            bArr3[i14 + 3] = (byte) ((i11 & 63) | 128);
            segmentWritableSegment$okio3.limit = i14 + 4;
            setSize$okio(size() + 4);
        }
        return this;
    }
}
