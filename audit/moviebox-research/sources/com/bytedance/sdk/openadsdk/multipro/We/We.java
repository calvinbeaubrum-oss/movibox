package com.bytedance.sdk.openadsdk.multipro.We;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    private static String pFF(String str) {
        return TextUtils.isEmpty(str) ? "tt_sp" : str;
    }

    public static String pFF(String str, String str2, String str3) {
        if (sc()) {
            return str3;
        }
        return com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? sc.pFF(pFF(str), str2, str3) : sc.sc(Xc.sc(), pFF(str), str2, str3);
    }

    public static int sc(String str, String str2, int i11) {
        if (sc()) {
            return i11;
        }
        return com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? sc.sc(pFF(str), str2, i11) : sc.sc(Xc.sc(), pFF(str), str2, i11);
    }

    public static long sc(String str, String str2, long j11) {
        if (sc()) {
            return j11;
        }
        return com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? sc.sc(pFF(str), str2, j11) : sc.sc(Xc.sc(), pFF(str), str2, j11);
    }

    public static void sc(String str) {
        if (sc()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc.sc(pFF(str));
        } else {
            pFF.pFF(Xc.sc(), pFF(str));
        }
    }

    public static void sc(String str, String str2) {
        if (sc()) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                sc.pFF(pFF(str), str2);
            } else {
                pFF.pFF(Xc.sc(), pFF(str), str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void sc(String str, String str2, Boolean bool) {
        if (sc()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc.sc(pFF(str), str2, bool);
        } else {
            sc(pFF(str), str2, bool);
        }
    }

    public static void sc(String str, String str2, Integer num) {
        if (sc()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc.sc(pFF(str), str2, num);
        } else {
            sc(pFF(str), str2, num);
        }
    }

    public static void sc(String str, String str2, Long l11) {
        if (sc()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc.sc(pFF(str), str2, l11);
        } else {
            sc(pFF(str), str2, l11);
        }
    }

    private static <T> void sc(String str, String str2, T t11) {
        String strSc = sc.sc(str, str2);
        if (Ol.qr(strSc)) {
            com.bytedance.sdk.component.pFF.zY zYVarPFF = com.bytedance.sdk.component.pFF.sc(Xc.sc(), pFF(strSc)).pFF();
            pFF.sc(zYVarPFF, str2, (Object) t11);
            zYVarPFF.apply();
        } else {
            SharedPreferences sharedPreferencesSc = pFF.sc(Xc.sc(), pFF(strSc));
            if (sharedPreferencesSc == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesSc.edit();
            pFF.sc(editorEdit, str2, t11);
            editorEdit.apply();
        }
    }

    public static void sc(String str, String str2, String str3) {
        if (sc()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc.sc(pFF(str), str2, str3);
        } else {
            sc(pFF(str), str2, str3);
        }
    }

    private static boolean sc() {
        return Xc.sc() == null;
    }

    public static boolean sc(String str, String str2, boolean z11) {
        if (sc()) {
            return z11;
        }
        return com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? sc.sc(pFF(str), str2, z11) : sc.sc(Xc.sc(), pFF(str), str2, z11);
    }
}
