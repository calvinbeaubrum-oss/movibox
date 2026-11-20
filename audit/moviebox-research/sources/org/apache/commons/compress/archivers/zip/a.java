package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f72548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f72549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f72550c;

    public final void a() {
        byte[] bArr = this.f72549b;
        if (bArr == null) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 5];
        this.f72550c = bArr2;
        bArr2[0] = 1;
        System.arraycopy(ZipLong.getBytes(this.f72548a), 0, this.f72550c, 1, 4);
        byte[] bArr3 = this.f72549b;
        System.arraycopy(bArr3, 0, this.f72550c, 5, bArr3.length);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getCentralDirectoryData() {
        if (this.f72550c == null) {
            a();
        }
        byte[] bArr = this.f72550c;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getCentralDirectoryLength() {
        if (this.f72550c == null) {
            a();
        }
        byte[] bArr = this.f72550c;
        return new ZipShort(bArr != null ? bArr.length : 0);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getLocalFileDataData() {
        return getCentralDirectoryData();
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getLocalFileDataLength() {
        return getCentralDirectoryLength();
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        parseFromLocalFileData(bArr, i11, i12);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        if (i12 < 5) {
            throw new ZipException("UniCode path extra data must have at least 5 bytes.");
        }
        byte b11 = bArr[i11];
        if (b11 != 1) {
            throw new ZipException("Unsupported version [" + ((int) b11) + "] for UniCode path extra data.");
        }
        this.f72548a = ZipLong.getValue(bArr, i11 + 1);
        int i13 = i12 - 5;
        byte[] bArr2 = new byte[i13];
        this.f72549b = bArr2;
        System.arraycopy(bArr, i11 + 5, bArr2, 0, i13);
        this.f72550c = null;
    }
}
