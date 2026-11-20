package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class l implements w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ZipShort f72582c = new ZipShort(44225);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f72583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f72584b;

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.f72584b;
        return bArr == null ? getLocalFileDataData() : x.c(bArr);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getCentralDirectoryLength() {
        return this.f72584b == null ? getLocalFileDataLength() : new ZipShort(this.f72584b.length);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getHeaderId() {
        return f72582c;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getLocalFileDataData() {
        return x.c(this.f72583a);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getLocalFileDataLength() {
        byte[] bArr = this.f72583a;
        return new ZipShort(bArr == null ? 0 : bArr.length);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        this.f72584b = Arrays.copyOfRange(bArr, i11, i11 + i12);
        if (this.f72583a == null) {
            parseFromLocalFileData(bArr, i11, i12);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        this.f72583a = Arrays.copyOfRange(bArr, i11, i12 + i11);
    }
}
