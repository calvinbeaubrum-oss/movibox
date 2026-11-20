package com.bytedance.sdk.openadsdk.core;

import android.util.Base64;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final String f28475sc = zY();
    private static final String pFF = Xc.We().zY();

    public static String pFF() {
        return new String(Base64.decode(pFF, 0)).substring(2);
    }

    public static String sc() {
        return new String(Base64.decode(f28475sc, 0)).substring(2);
    }

    private static String zY() {
        char[] cArr = {203, 182, 168, 176, 207, 148, 149, 178, 205, 182, 149, 166, 134, 178, 184, 176, 206, 174, 187, 178, 150, 185, 167, 166};
        char[] cArr2 = new char[24];
        for (int i11 = 23; i11 >= 0; i11--) {
            cArr2[23 - i11] = (char) (cArr[i11] ^ 255);
        }
        return new String(cArr2);
    }
}
