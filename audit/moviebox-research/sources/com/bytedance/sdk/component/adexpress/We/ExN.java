package com.bytedance.sdk.component.adexpress.We;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN {
    public static boolean sc(String str) {
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            return TextUtils.equals(str, "embeded_ad") || TextUtils.equals(str, "banner_ad");
        }
        return false;
    }
}
