package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.cJ;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static String f27717sc;

    public static String ExN() {
        return com.bytedance.sdk.openadsdk.core.Ol.pFF().TRI();
    }

    public static String TRI() {
        return com.bytedance.sdk.component.utils.BT.qr(com.bytedance.sdk.openadsdk.core.Xc.sc());
    }

    public static String We() {
        return cJ.qr();
    }

    public static String pFF() {
        return "1371";
    }

    public static String qr() {
        try {
            if (!TextUtils.isEmpty(f27717sc)) {
                return f27717sc;
            }
            String strSc = com.bytedance.sdk.openadsdk.core.Ol.sc("sdk_app_sha1", 259200000L);
            f27717sc = strSc;
            if (sc(strSc)) {
                return f27717sc;
            }
            String strSc2 = com.bytedance.sdk.component.utils.zY.sc(com.bytedance.sdk.openadsdk.core.Xc.sc());
            f27717sc = strSc2;
            if (!sc(strSc2)) {
                return "";
            }
            String upperCase = f27717sc.toUpperCase();
            f27717sc = upperCase;
            com.bytedance.sdk.openadsdk.core.Ol.sc("sdk_app_sha1", upperCase);
            return f27717sc;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String sc() {
        return "open_news";
    }

    public static String sc(Context context) {
        return com.bytedance.sdk.openadsdk.core.Tf.sc(context);
    }

    private static boolean sc(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split(":")) == null || strArrSplit.length < 20) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (!"00".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String zY() {
        return BuildConfig.VERSION_NAME;
    }
}
