package com.pgl.ssdk;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f48840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long[][] f48841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f48842c;

    /* JADX INFO: compiled from: source.java */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(u.f48842c)) {
                String unused = u.f48842c = u.d();
                u0.b(x.b(), "romtype", u.f48842c);
            }
        }
    }

    public static String a(Context context) {
        String str = f48840a;
        if (str != null) {
            return str;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            f48840a = Settings.Global.getString(context.getContentResolver(), "boot_count");
        } else {
            f48840a = "lowapi";
        }
        return f48840a;
    }

    public static boolean b(Context context) {
        Object objMeta = com.pgl.ssdk.ces.a.meta(156, context, null);
        if (objMeta instanceof Boolean) {
            return ((Boolean) objMeta).booleanValue();
        }
        return false;
    }

    private static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c() {
        if (!TextUtils.isEmpty(f48842c)) {
            return f48842c;
        }
        String strA = u0.a(x.b(), "romtype", (String) null);
        f48842c = strA;
        if (!TextUtils.isEmpty(strA)) {
            return f48842c;
        }
        o0.b(new a());
        return "";
    }

    private static boolean c(String str) {
        try {
            return new File(str).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONArray[] c(Context context) {
        if (f48841b == null) {
            f48841b = (long[][]) com.pgl.ssdk.ces.a.meta(157, context, null);
        }
        long[][] jArr = f48841b;
        if (jArr == null || jArr.length != 2) {
            f48841b = null;
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        long[][] jArr2 = f48841b;
        long[] jArr3 = jArr2[0];
        long[] jArr4 = jArr2[1];
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (int i11 = 0; i11 < jArr3.length; i11++) {
            try {
                jSONArray.put(i11, jCurrentTimeMillis - jArr3[i11]);
                jSONArray2.put(i11, jCurrentTimeMillis - jArr4[i11]);
            } catch (JSONException unused) {
            }
        }
        return new JSONArray[]{jSONArray, jSONArray2};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d() {
        if (b("com.samsung.android.knox.SemPersonaManager") || b("com.samsung.android.knoxguard.KnoxGuardManager")) {
            return "samsung";
        }
        if (b("androidhnext.Manifest") || b("androidhnext.R")) {
            return "honor";
        }
        if (b("androidhwext.Manifest") || b("androidhwext.R")) {
            return "huawei";
        }
        if (b("oppo.Manifest") || b("oppo.R") || b("oplus.Manifest") || b("oplus.R") || b("com.oneplus.Manifest") || b("com.oneplus.R")) {
            return "oppo";
        }
        if (b("vivo.Manifest") || b("vivo.R")) {
            return "vivo";
        }
        if (b("miui.Manifest") || b("miui.R") || b("miui.os.Build")) {
            return "xiaomi";
        }
        if (b("lineageos.platform.Manifest") || b("lineageos.platform.R")) {
            return "lineage";
        }
        if (c("/system/framework/com.motorola.motosignature.jar")) {
            return "moto";
        }
        return (c("/system/framework/transsion-framework.jar") || c("/system/framework/transsion-services.jar")) ? "transsion" : "other";
    }

    public static boolean d(Context context) {
        Object objMeta = com.pgl.ssdk.ces.a.meta(155, context, null);
        if (objMeta instanceof Boolean) {
            return ((Boolean) objMeta).booleanValue();
        }
        return false;
    }

    public static int e() {
        return ((Integer) com.pgl.ssdk.ces.a.meta(162, null, null)).intValue();
    }
}
