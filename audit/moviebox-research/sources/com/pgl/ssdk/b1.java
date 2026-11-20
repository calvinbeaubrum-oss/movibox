package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.hisavana.common.tracking.TrackingKey;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f48718a = 504;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f48719b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f48720c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f48721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f48722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Context f48723f;

    public static synchronized Object a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return com.pgl.ssdk.ces.a.meta(302, f48723f, bArr);
    }

    public static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os", "Android");
            jSONObject.put("version", "6.5.0.0.overseas-rc.1");
            String str = f48720c;
            if (str == null || str.length() <= 0) {
                try {
                    jSONObject.put("token_id", b());
                } catch (Throwable unused) {
                    jSONObject.put("token_id", "");
                }
            } else {
                jSONObject.put("token_id", f48720c);
            }
            jSONObject.put(TrackingKey.CODE, f48718a);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable unused2) {
            r0.a("getGrilock Error");
            return "";
        }
    }

    public static void a(Context context, String str) {
        a(context, str, null);
    }

    public static void a(Context context, String str, d1 d1Var) {
        if (f48723f == null) {
            f48723f = context;
        }
        int i11 = f48718a;
        if (i11 == 102 || i11 == 202 || i11 == 200) {
            return;
        }
        f48722e = System.currentTimeMillis();
        f48721d = false;
        f48719b = str;
        f48718a = 102;
        o0.b(new c1(context, d1Var));
    }

    public static synchronized String b() {
        try {
            if (TextUtils.isEmpty(f48720c)) {
                f48720c = (String) com.pgl.ssdk.ces.a.meta(303, f48723f, null);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f48720c;
    }

    public static void c() {
        Context context = f48723f;
        if (context != null) {
            f48718a = 102;
            o0.b(new c1(context, null));
            com.pgl.ssdk.ces.b.h().a();
            x.a();
        }
    }
}
