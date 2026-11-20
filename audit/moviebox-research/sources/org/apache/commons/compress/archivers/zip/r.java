package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class r extends PKWareExtraHeader {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f72598d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PKWareExtraHeader.EncryptionAlgorithm f72599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f72600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f72601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f72602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PKWareExtraHeader.HashAlgorithm f72603j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f72604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f72605l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f72606m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f72607n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public byte[] f72608o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public byte[] f72609p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public byte[] f72610q;

    public r() {
        super(new ZipShort(23));
    }

    public final void d(String str, int i11, int i12, int i13) throws ZipException {
        if (i12 + i11 <= i13) {
            return;
        }
        throw new ZipException("Invalid X0017_StrongEncryptionHeader: " + str + " " + i11 + " doesn't fit into " + i13 + " bytes of data at position " + i12);
    }

    public void e(byte[] bArr, int i11, int i12) throws ZipException {
        a(12, i12);
        this.f72598d = ZipShort.getValue(bArr, i11);
        this.f72599f = PKWareExtraHeader.EncryptionAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i11 + 2));
        this.f72600g = ZipShort.getValue(bArr, i11 + 4);
        this.f72601h = ZipShort.getValue(bArr, i11 + 6);
        long value = ZipLong.getValue(bArr, i11 + 8);
        this.f72602i = value;
        if (value > 0) {
            a(16, i12);
            this.f72603j = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i11 + 12));
            this.f72604k = ZipShort.getValue(bArr, i11 + 14);
            for (long j11 = 0; j11 < this.f72602i; j11++) {
                for (int i13 = 0; i13 < this.f72604k; i13++) {
                }
            }
        }
    }

    public void f(byte[] bArr, int i11, int i12) throws ZipException {
        a(4, i12);
        int value = ZipShort.getValue(bArr, i11);
        d("ivSize", value, 4, i12);
        this.f72605l = Arrays.copyOfRange(bArr, i11 + 4, value);
        int i13 = value + 16;
        a(i13, i12);
        int i14 = i11 + value;
        this.f72598d = ZipShort.getValue(bArr, i14 + 6);
        this.f72599f = PKWareExtraHeader.EncryptionAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i14 + 8));
        this.f72600g = ZipShort.getValue(bArr, i14 + 10);
        this.f72601h = ZipShort.getValue(bArr, i14 + 12);
        int value2 = ZipShort.getValue(bArr, i14 + 14);
        d("erdSize", value2, i13, i12);
        int i15 = i14 + 16;
        this.f72606m = Arrays.copyOfRange(bArr, i15, value2);
        int i16 = value + 20 + value2;
        a(i16, i12);
        long value3 = ZipLong.getValue(bArr, i15 + value2);
        this.f72602i = value3;
        if (value3 == 0) {
            a(i16 + 2, i12);
            int value4 = ZipShort.getValue(bArr, i14 + 20 + value2);
            d("vSize", value4, value + 22 + value2, i12);
            if (value4 >= 4) {
                int i17 = i14 + 22 + value2;
                this.f72609p = Arrays.copyOfRange(bArr, i17, value4 - 4);
                this.f72610q = Arrays.copyOfRange(bArr, (i17 + value4) - 4, 4);
                return;
            } else {
                throw new ZipException("Invalid X0017_StrongEncryptionHeader: vSize " + value4 + " is too small to hold CRC");
            }
        }
        a(i16 + 6, i12);
        this.f72603j = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i14 + 20 + value2));
        int i18 = i14 + 22 + value2;
        this.f72604k = ZipShort.getValue(bArr, i18);
        int i19 = i14 + 24 + value2;
        int value5 = ZipShort.getValue(bArr, i19);
        int i21 = this.f72604k;
        this.f72607n = new byte[i21];
        if (value5 < i21) {
            throw new ZipException("Invalid X0017_StrongEncryptionHeader: resize " + value5 + " is too small to hold hashSize" + this.f72604k);
        }
        this.f72608o = new byte[value5 - i21];
        d("resize", value5, value + 24 + value2, i12);
        System.arraycopy(bArr, i19, this.f72607n, 0, this.f72604k);
        int i22 = this.f72604k;
        System.arraycopy(bArr, i19 + i22, this.f72608o, 0, value5 - i22);
        a(value + 26 + value2 + value5 + 2, i12);
        int value6 = ZipShort.getValue(bArr, i14 + 26 + value2 + value5);
        if (value6 < 4) {
            throw new ZipException("Invalid X0017_StrongEncryptionHeader: vSize " + value6 + " is too small to hold CRC");
        }
        d("vSize", value6, value + 22 + value2 + value5, i12);
        int i23 = value6 - 4;
        byte[] bArr2 = new byte[i23];
        this.f72609p = bArr2;
        this.f72610q = new byte[4];
        int i24 = i18 + value5;
        System.arraycopy(bArr, i24, bArr2, 0, i23);
        System.arraycopy(bArr, (i24 + value6) - 4, this.f72610q, 0, 4);
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.w
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        super.parseFromCentralDirectoryData(bArr, i11, i12);
        e(bArr, i11, i12);
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.w
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        super.parseFromLocalFileData(bArr, i11, i12);
        f(bArr, i11, i12);
    }
}
