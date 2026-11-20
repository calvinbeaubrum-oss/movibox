package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class p extends PKWareExtraHeader {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f72594d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PKWareExtraHeader.HashAlgorithm f72595f;

    public p() {
        super(new ZipShort(21));
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.w
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        a(4, i12);
        super.parseFromCentralDirectoryData(bArr, i11, i12);
        this.f72594d = ZipShort.getValue(bArr, i11);
        this.f72595f = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i11 + 2));
    }
}
