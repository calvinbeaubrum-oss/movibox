package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface c extends k {
    w createExtraField(ZipShort zipShort) throws IllegalAccessException, ZipException, InstantiationException;

    w fill(w wVar, byte[] bArr, int i11, int i12, boolean z11) throws ZipException;
}
