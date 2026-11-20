package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class t implements w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ZipShort f72611g = new ZipShort(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f72612h = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ZipEightByteInteger f72613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ZipEightByteInteger f72614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ZipEightByteInteger f72615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ZipLong f72616d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f72617f;

    public final int a(byte[] bArr) {
        int i11;
        ZipEightByteInteger zipEightByteInteger = this.f72613a;
        if (zipEightByteInteger != null) {
            System.arraycopy(zipEightByteInteger.getBytes(), 0, bArr, 0, 8);
            i11 = 8;
        } else {
            i11 = 0;
        }
        ZipEightByteInteger zipEightByteInteger2 = this.f72614b;
        if (zipEightByteInteger2 == null) {
            return i11;
        }
        System.arraycopy(zipEightByteInteger2.getBytes(), 0, bArr, i11, 8);
        return i11 + 8;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getCentralDirectoryData() {
        byte[] bArr = new byte[getCentralDirectoryLength().getValue()];
        int iA = a(bArr);
        ZipEightByteInteger zipEightByteInteger = this.f72615c;
        if (zipEightByteInteger != null) {
            System.arraycopy(zipEightByteInteger.getBytes(), 0, bArr, iA, 8);
            iA += 8;
        }
        ZipLong zipLong = this.f72616d;
        if (zipLong != null) {
            System.arraycopy(zipLong.getBytes(), 0, bArr, iA, 4);
        }
        return bArr;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getCentralDirectoryLength() {
        return new ZipShort((this.f72613a != null ? 8 : 0) + (this.f72614b != null ? 8 : 0) + (this.f72615c == null ? 0 : 8) + (this.f72616d != null ? 4 : 0));
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getHeaderId() {
        return f72611g;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getLocalFileDataData() {
        ZipEightByteInteger zipEightByteInteger = this.f72613a;
        if (zipEightByteInteger == null && this.f72614b == null) {
            return f72612h;
        }
        if (zipEightByteInteger == null || this.f72614b == null) {
            throw new IllegalArgumentException("Zip64 extended information must contain both size values in the local file header.");
        }
        byte[] bArr = new byte[16];
        a(bArr);
        return bArr;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.f72613a != null ? 16 : 0);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        byte[] bArr2 = new byte[i12];
        this.f72617f = bArr2;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        if (i12 >= 28) {
            parseFromLocalFileData(bArr, i11, i12);
            return;
        }
        if (i12 == 24) {
            this.f72613a = new ZipEightByteInteger(bArr, i11);
            this.f72614b = new ZipEightByteInteger(bArr, i11 + 8);
            this.f72615c = new ZipEightByteInteger(bArr, i11 + 16);
        } else if (i12 % 8 == 4) {
            this.f72616d = new ZipLong(bArr, (i11 + i12) - 4);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        if (i12 == 0) {
            return;
        }
        if (i12 < 16) {
            throw new ZipException("Zip64 extended information must contain both size values in the local file header.");
        }
        this.f72613a = new ZipEightByteInteger(bArr, i11);
        this.f72614b = new ZipEightByteInteger(bArr, i11 + 8);
        int i13 = i11 + 16;
        int i14 = i12 - 16;
        if (i14 >= 8) {
            this.f72615c = new ZipEightByteInteger(bArr, i13);
            i13 = i11 + 24;
            i14 = i12 - 24;
        }
        if (i14 >= 4) {
            this.f72616d = new ZipLong(bArr, i13);
        }
    }
}
