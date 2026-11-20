package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ZipShort f72567a = new ZipShort(51966);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ZipShort f72568b = new ZipShort(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f72569c = new byte[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f72570d = new f();

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getCentralDirectoryData() {
        return f72569c;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getCentralDirectoryLength() {
        return f72568b;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getHeaderId() {
        return f72567a;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public byte[] getLocalFileDataData() {
        return f72569c;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public ZipShort getLocalFileDataLength() {
        return f72568b;
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        parseFromLocalFileData(bArr, i11, i12);
    }

    @Override // org.apache.commons.compress.archivers.zip.w
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        if (i12 != 0) {
            throw new ZipException("JarMarker doesn't expect any data");
        }
    }
}
