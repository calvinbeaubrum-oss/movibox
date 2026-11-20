package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class cD {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static String f28764sc;

    public static String pFF() {
        if (TextUtils.isEmpty(f28764sc)) {
            f28764sc = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return f28764sc;
    }

    public static String sc(String str) {
        try {
            if (!sc()) {
                return str;
            }
            String strSfl = com.bytedance.sdk.openadsdk.core.Ol.pFF().Sfl();
            if (TextUtils.isEmpty(strSfl)) {
                return str;
            }
            "AnyDoorId=".concat(String.valueOf(strSfl));
            return Uri.parse(str).buildUpon().appendQueryParameter(pFF(), strSfl).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean sc() {
        return com.bytedance.sdk.component.utils.Tf.We() && com.bytedance.sdk.openadsdk.core.Ol.pFF().Xc() && com.bytedance.sdk.openadsdk.core.Ol.pFF().wjp();
    }

    public static boolean zY() {
        return false;
    }
}
