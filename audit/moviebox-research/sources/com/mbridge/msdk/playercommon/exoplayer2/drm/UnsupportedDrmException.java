package com.mbridge.msdk.playercommon.exoplayer2.drm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class UnsupportedDrmException extends Exception {
    public static final int REASON_INSTANTIATION_ERROR = 2;
    public static final int REASON_UNSUPPORTED_SCHEME = 1;
    public final int reason;

    /* JADX INFO: compiled from: source.java */
    public @interface Reason {
    }

    public UnsupportedDrmException(int i11) {
        this.reason = i11;
    }

    public UnsupportedDrmException(int i11, Exception exc) {
        super(exc);
        this.reason = i11;
    }
}
