package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class m implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ZipShort f72585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f72586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f72587c;

    public void a(byte[] bArr) {
        this.f72587c = x.c(bArr);
    }

    public void b(ZipShort zipShort) {
        this.f72585a = zipShort;
    }

    public void c(byte[] bArr) {
        this.f72586b = x.c(bArr);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.f72587c;
        return bArr != null ? x.c(bArr) : getLocalFileDataData();
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getCentralDirectoryLength() {
        return this.f72587c != null ? new ZipShort(this.f72587c.length) : getLocalFileDataLength();
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getHeaderId() {
        return this.f72585a;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getLocalFileDataData() {
        return x.c(this.f72586b);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getLocalFileDataLength() {
        byte[] bArr = this.f72586b;
        return new ZipShort(bArr != null ? bArr.length : 0);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i11, i12 + i11);
        a(bArrCopyOfRange);
        if (this.f72586b == null) {
            c(bArrCopyOfRange);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        c(Arrays.copyOfRange(bArr, i11, i12 + i11));
    }
}
