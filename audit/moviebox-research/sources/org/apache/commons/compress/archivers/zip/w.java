package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface w {
    byte[] getCentralDirectoryData();

    ZipShort getCentralDirectoryLength();

    ZipShort getHeaderId();

    byte[] getLocalFileDataData();

    ZipShort getLocalFileDataLength();

    void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException;

    void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException;
}
