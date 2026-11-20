package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.SegmentedByteStringKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.EMPTY.getData$okio());
        Intrinsics.g(segments, "segments");
        Intrinsics.g(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        if (byteString != null) {
            return byteString;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.f(byteBufferAsReadOnlyBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    @Override // okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public ByteString digest$okio(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.g(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = getDirectory$okio()[length + i11];
            int i14 = getDirectory$okio()[i11];
            messageDigest.update(getSegments$okio()[i11], i13, i14 - i12);
            i11++;
            i12 = i14;
        }
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.f(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            int i14 = getDirectory$okio()[length + i11];
            int i15 = getDirectory$okio()[i11];
            byte[] bArr = getSegments$okio()[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        setHashCode$okio(i12);
        return i12;
    }

    @Override // okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public ByteString hmac$okio(String algorithm, ByteString key) throws NoSuchAlgorithmException {
        Intrinsics.g(algorithm, "algorithm");
        Intrinsics.g(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments$okio().length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                int i13 = getDirectory$okio()[length + i11];
                int i14 = getDirectory$okio()[i11];
                mac.update(getSegments$okio()[i11], i13, i14 - i12);
                i11++;
                i12 = i14;
            }
            byte[] bArrDoFinal = mac.doFinal();
            Intrinsics.f(bArrDoFinal, "mac.doFinal()");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    @Override // okio.ByteString
    public int indexOf(byte[] other, int i11) {
        Intrinsics.g(other, "other");
        return toByteString().indexOf(other, i11);
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i11) {
        Util.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], i11, 1L);
        int iSegment = SegmentedByteStringKt.segment(this, i11);
        return getSegments$okio()[iSegment][(i11 - (iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1])) + getDirectory$okio()[getSegments$okio().length + iSegment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] other, int i11) {
        Intrinsics.g(other, "other");
        return toByteString().lastIndexOf(other, i11);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i11, ByteString other, int i12, int i13) {
        Intrinsics.g(other, "other");
        if (i11 < 0 || i11 > size() - i13) {
            return false;
        }
        int i14 = i13 + i11;
        int iSegment = SegmentedByteStringKt.segment(this, i11);
        while (i11 < i14) {
            int i15 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i16 = getDirectory$okio()[iSegment] - i15;
            int i17 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i14, i16 + i15) - i11;
            if (!other.rangeEquals(i12, getSegments$okio()[iSegment], i17 + (i11 - i15), iMin)) {
                return false;
            }
            i12 += iMin;
            i11 += iMin;
            iSegment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i11, byte[] other, int i12, int i13) {
        Intrinsics.g(other, "other");
        if (i11 < 0 || i11 > size() - i13 || i12 < 0 || i12 > other.length - i13) {
            return false;
        }
        int i14 = i13 + i11;
        int iSegment = SegmentedByteStringKt.segment(this, i11);
        while (i11 < i14) {
            int i15 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i16 = getDirectory$okio()[iSegment] - i15;
            int i17 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i14, i16 + i15) - i11;
            if (!Util.arrayRangeEquals(getSegments$okio()[iSegment], i17 + (i11 - i15), other, i12, iMin)) {
                return false;
            }
            i12 += iMin;
            i11 += iMin;
            iSegment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        Intrinsics.g(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    public ByteString substring(int i11, int i12) {
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i11 + " < 0").toString());
        }
        if (!(i12 <= size())) {
            throw new IllegalArgumentException(("endIndex=" + i12 + " > length(" + size() + ')').toString());
        }
        int i13 = i12 - i11;
        if (!(i13 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i12 + " < beginIndex=" + i11).toString());
        }
        if (i11 == 0 && i12 == size()) {
            return this;
        }
        if (i11 == i12) {
            return ByteString.EMPTY;
        }
        int iSegment = SegmentedByteStringKt.segment(this, i11);
        int iSegment2 = SegmentedByteStringKt.segment(this, i12 - 1);
        byte[][] bArr = (byte[][]) ArraysKt___ArraysJvmKt.r(getSegments$okio(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i14 = iSegment;
            int i15 = 0;
            while (true) {
                iArr[i15] = Math.min(getDirectory$okio()[i14] - i11, i13);
                int i16 = i15 + 1;
                iArr[i15 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i14];
                if (i14 == iSegment2) {
                    break;
                }
                i14++;
                i15 = i16;
            }
        }
        int i17 = iSegment != 0 ? getDirectory$okio()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i11 - i17);
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            int i14 = getDirectory$okio()[length + i11];
            int i15 = getDirectory$okio()[i11];
            int i16 = i15 - i12;
            ArraysKt___ArraysJvmKt.h(getSegments$okio()[i11], bArr, i13, i14, i14 + i16);
            i13 += i16;
            i11++;
            i12 = i15;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(OutputStream out) throws IOException {
        Intrinsics.g(out, "out");
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = getDirectory$okio()[length + i11];
            int i14 = getDirectory$okio()[i11];
            out.write(getSegments$okio()[i11], i13, i14 - i12);
            i11++;
            i12 = i14;
        }
    }

    @Override // okio.ByteString
    public void write$okio(Buffer buffer, int i11, int i12) {
        Intrinsics.g(buffer, "buffer");
        int i13 = i11 + i12;
        int iSegment = SegmentedByteStringKt.segment(this, i11);
        while (i11 < i13) {
            int i14 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i15 = getDirectory$okio()[iSegment] - i14;
            int i16 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i13, i15 + i14) - i11;
            int i17 = i16 + (i11 - i14);
            Segment segment = new Segment(getSegments$okio()[iSegment], i17, i17 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                Intrinsics.d(segment2);
                Segment segment3 = segment2.prev;
                Intrinsics.d(segment3);
                segment3.push(segment);
            }
            i11 += iMin;
            iSegment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) i12));
    }
}
