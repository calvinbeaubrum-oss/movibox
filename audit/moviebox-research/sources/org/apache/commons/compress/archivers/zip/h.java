package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h implements w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ZipShort f72576d = new ZipShort(41246);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f72577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f72578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f72579c = 0;

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getCentralDirectoryData() {
        return ZipShort.getBytes(this.f72577a | (this.f72578b ? Short.MIN_VALUE : (short) 0));
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getCentralDirectoryLength() {
        return new ZipShort(2);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getHeaderId() {
        return f72576d;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getLocalFileDataData() {
        byte[] bArr = new byte[this.f72579c + 2];
        ZipShort.putShort(this.f72577a | (this.f72578b ? Short.MIN_VALUE : (short) 0), bArr, 0);
        return bArr;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.f72579c + 2);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        if (i12 >= 2) {
            int value = ZipShort.getValue(bArr, i11);
            this.f72577a = (short) (value & 32767);
            this.f72578b = (value & 32768) != 0;
        } else {
            throw new ZipException("Too short content for ResourceAlignmentExtraField (0xa11e): " + i12);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        parseFromCentralDirectoryData(bArr, i11, i12);
        this.f72579c = i12 - 2;
    }
}
