package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class mo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qo.a f21186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f21188e;

    public mo(boolean z11, String str, int i11, byte[] bArr, int i12, int i13, byte[] bArr2) {
        b1.a((bArr2 == null) ^ (i11 == 0));
        this.f21184a = z11;
        this.f21185b = str;
        this.f21187d = i11;
        this.f21188e = bArr2;
        this.f21186c = new qo.a(a(str), bArr, i12, i13);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        byte b11 = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(C.CENC_TYPE_cbc1)) {
                    b11 = 0;
                }
                break;
            case 3046671:
                if (str.equals(C.CENC_TYPE_cbcs)) {
                    b11 = 1;
                }
                break;
            case 3049879:
                if (str.equals(C.CENC_TYPE_cenc)) {
                    b11 = 2;
                }
                break;
            case 3049895:
                if (str.equals(C.CENC_TYPE_cens)) {
                    b11 = 3;
                }
                break;
        }
        switch (b11) {
            case 0:
            case 1:
                return 2;
            default:
                pc.d("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
