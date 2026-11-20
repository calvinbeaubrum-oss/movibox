package com.mbridge.msdk.playercommon.exoplayer2.drm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class DecryptionException extends Exception {
    public final int errorCode;

    public DecryptionException(int i11, String str) {
        super(str);
        this.errorCode = i11;
    }
}
