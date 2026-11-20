package com.bytedance.sdk.component.adexpress.We;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr {
    public static boolean pFF(String str) {
        return com.bytedance.sdk.component.adexpress.We.pFF() && sc(str);
    }

    public static boolean sc(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }
}
