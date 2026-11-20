package com.bytedance.sdk.component.sc;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class FI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static boolean f26994sc;

    public static String sc() {
        return "";
    }

    public static String sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String strSubstring = f26994sc ? str.substring(1, str.length() - 1) : "";
        String strConcat = "{\"code\":1,\"__data\":".concat(String.valueOf(str));
        if (strSubstring.isEmpty()) {
            return strConcat + "}";
        }
        return strConcat + "," + strSubstring + "}";
    }

    public static String sc(Throwable th2) {
        StringBuilder sb2 = new StringBuilder("{\"code\":");
        sb2.append(th2 instanceof wjp ? ((wjp) th2).f27019sc : 0);
        sb2.append("}");
        return sb2.toString();
    }

    public static void sc(boolean z11) {
        f26994sc = z11;
    }
}
