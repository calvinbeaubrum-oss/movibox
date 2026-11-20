package com.mbridge.msdk.thrid.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    public SegmentedByteString(Buffer buffer, int i11) {
        super(null);
        Util.checkOffsetAndCount(buffer.size, 0L, i11);
        Segment segment = buffer.head;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            int i15 = segment.limit;
            int i16 = segment.pos;
            if (i15 == i16) {
                throw new AssertionError("s.limit == s.pos");
            }
            i13 += i15 - i16;
            i14++;
            segment = segment.next;
        }
        this.segments = new byte[i14][];
        this.directory = new int[i14 * 2];
        Segment segment2 = buffer.head;
        int i17 = 0;
        while (i12 < i11) {
            byte[][] bArr = this.segments;
            bArr[i17] = segment2.data;
            int i18 = segment2.limit;
            int i19 = segment2.pos;
            i12 += i18 - i19;
            if (i12 > i11) {
                i12 = i11;
            }
            int[] iArr = this.directory;
            iArr[i17] = i12;
            iArr[bArr.length + i17] = i19;
            segment2.shared = true;
            i17++;
            segment2 = segment2.next;
        }
    }

    private int segment(int i11) {
        int iBinarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i11 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private Object writeReplace() {
        return toByteString();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
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

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public byte getByte(int i11) {
        Util.checkOffsetAndCount(this.directory[this.segments.length - 1], i11, 1L);
        int iSegment = segment(i11);
        int i12 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[iSegment][(i11 - i12) + iArr[bArr.length + iSegment]];
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public int hashCode() {
        int i11 = this.hashCode;
        if (i11 != 0) {
            return i11;
        }
        int length = this.segments.length;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1;
        while (i12 < length) {
            byte[] bArr = this.segments[i12];
            int[] iArr = this.directory;
            int i15 = iArr[length + i12];
            int i16 = iArr[i12];
            int i17 = (i16 - i13) + i15;
            while (i15 < i17) {
                i14 = (i14 * 31) + bArr[i15];
                i15++;
            }
            i12++;
            i13 = i16;
        }
        this.hashCode = i14;
        return i14;
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        return toByteString().hmacSha1(byteString);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        return toByteString().hmacSha256(byteString);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public int indexOf(byte[] bArr, int i11) {
        return toByteString().indexOf(bArr, i11);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public byte[] internalArray() {
        return toByteArray();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public int lastIndexOf(byte[] bArr, int i11) {
        return toByteString().lastIndexOf(bArr, i11);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString md5() {
        return toByteString().md5();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public boolean rangeEquals(int i11, ByteString byteString, int i12, int i13) {
        if (i11 < 0 || i11 > size() - i13) {
            return false;
        }
        int iSegment = segment(i11);
        while (i13 > 0) {
            int i14 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
            int iMin = Math.min(i13, ((this.directory[iSegment] - i14) + i14) - i11);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i12, bArr[iSegment], (i11 - i14) + iArr[bArr.length + iSegment], iMin)) {
                return false;
            }
            i11 += iMin;
            i12 += iMin;
            i13 -= iMin;
            iSegment++;
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public boolean rangeEquals(int i11, byte[] bArr, int i12, int i13) {
        if (i11 < 0 || i11 > size() - i13 || i12 < 0 || i12 > bArr.length - i13) {
            return false;
        }
        int iSegment = segment(i11);
        while (i13 > 0) {
            int i14 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
            int iMin = Math.min(i13, ((this.directory[iSegment] - i14) + i14) - i11);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!Util.arrayRangeEquals(bArr2[iSegment], (i11 - i14) + iArr[bArr2.length + iSegment], bArr, i12, iMin)) {
                return false;
            }
            i11 += iMin;
            i12 += iMin;
            i13 -= iMin;
            iSegment++;
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString sha1() {
        return toByteString().sha1();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString sha256() {
        return toByteString().sha256();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String string(Charset charset) {
        return toByteString().string(charset);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString substring(int i11) {
        return toByteString().substring(i11);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString substring(int i11, int i12) {
        return toByteString().substring(i11, i12);
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int[] iArr2 = this.directory;
            int i13 = iArr2[length + i11];
            int i14 = iArr2[i11];
            System.arraycopy(this.segments[i11], i13, bArr2, i12, i14 - i12);
            i11++;
            i12 = i14;
        }
        return bArr2;
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public String utf8() {
        return toByteString().utf8();
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public void write(Buffer buffer) {
        int length = this.segments.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int[] iArr = this.directory;
            int i13 = iArr[length + i11];
            int i14 = iArr[i11];
            Segment segment = new Segment(this.segments[i11], i13, (i13 + i14) - i12, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                segment2.prev.push(segment);
            }
            i11++;
            i12 = i14;
        }
        buffer.size += (long) i12;
    }

    @Override // com.mbridge.msdk.thrid.okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int[] iArr = this.directory;
            int i13 = iArr[length + i11];
            int i14 = iArr[i11];
            outputStream.write(this.segments[i11], i13, i14 - i12);
            i11++;
            i12 = i14;
        }
    }
}
