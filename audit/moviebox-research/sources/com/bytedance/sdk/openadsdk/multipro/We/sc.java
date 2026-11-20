package com.bytedance.sdk.openadsdk.multipro.We;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.TRI.sc.TRI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static HashSet<String> f28617sc = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.multipro.We.sc.1
        {
            add("app_id");
            add("global_coppa");
            add("tt_gdpr");
            add("global_ccpa");
            add("keywords");
            add("extra_data");
            add("sdk_app_sha1");
            add("uuid");
            add("android_system_ua");
            add("sdk_local_web_ua");
            add("sdk_local_rom_info");
        }
    };

    private static String We() {
        return com.bytedance.sdk.openadsdk.multipro.We.pFF + "/t_sp/";
    }

    private static TRI pFF() {
        try {
            if (sc()) {
                return com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(Xc.sc());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String pFF(String str) {
        return TextUtils.isEmpty(str) ? "" : "?sp_file_name=".concat(String.valueOf(str));
    }

    public static String pFF(String str, String str2, String str3) {
        if (!sc()) {
            return str3;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                return sc(zY(), str, str2, str3);
            }
            TRI triPFF = pFF();
            if (triPFF != null) {
                String strSc = triPFF.sc(Uri.parse(We() + "string/" + str2 + pFF(str)));
                if (strSc != null && !strSc.equals("null")) {
                    return strSc;
                }
            }
            return str3;
        } catch (Throwable unused) {
        }
    }

    public static void pFF(String str, String str2) {
        if (sc()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                    pFF.pFF(zY(), str, str2);
                    return;
                }
                TRI triPFF = pFF();
                if (triPFF != null) {
                    triPFF.sc(Uri.parse(We() + "long/" + str2 + pFF(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static float sc(Context context, String str, String str2, float f11) {
        String strSc = sc(str, str2);
        if (Ol.qr(strSc)) {
            return com.bytedance.sdk.component.pFF.sc(context, strSc).sc(str2, f11);
        }
        SharedPreferences sharedPreferencesSc = pFF.sc(context, strSc);
        return sharedPreferencesSc == null ? f11 : sharedPreferencesSc.getFloat(str2, f11);
    }

    public static int sc(Context context, String str, String str2, int i11) {
        String strSc = sc(str, str2);
        if (Ol.qr(strSc)) {
            return com.bytedance.sdk.component.pFF.sc(context, strSc).sc(str2, i11);
        }
        SharedPreferences sharedPreferencesSc = pFF.sc(context, strSc);
        return sharedPreferencesSc == null ? i11 : sharedPreferencesSc.getInt(str2, i11);
    }

    public static int sc(String str, String str2, int i11) {
        if (!sc()) {
            return i11;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                return sc(zY(), str, str2, i11);
            }
            TRI triPFF = pFF();
            if (triPFF != null) {
                String strSc = triPFF.sc(Uri.parse(We() + "int/" + str2 + pFF(str)));
                if (strSc != null && !strSc.equals("null")) {
                    return Integer.parseInt(strSc);
                }
            }
            return i11;
        } catch (Throwable unused) {
        }
    }

    public static long sc(Context context, String str, String str2, long j11) {
        String strSc = sc(str, str2);
        if (Ol.qr(strSc)) {
            return com.bytedance.sdk.component.pFF.sc(context, strSc).sc(str2, j11);
        }
        SharedPreferences sharedPreferencesSc = pFF.sc(context, strSc);
        return sharedPreferencesSc == null ? j11 : sharedPreferencesSc.getLong(str2, j11);
    }

    public static long sc(String str, String str2, long j11) {
        if (!sc()) {
            return j11;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                return sc(zY(), str, str2, j11);
            }
            TRI triPFF = pFF();
            if (triPFF != null) {
                String strSc = triPFF.sc(Uri.parse(We() + "long/" + str2 + pFF(str)));
                if (strSc != null && !strSc.equals("null")) {
                    return Long.parseLong(strSc);
                }
            }
            return j11;
        } catch (Throwable unused) {
        }
    }

    public static String sc(Context context, String str, String str2, String str3) {
        String strSc = sc(str, str2);
        if (Ol.qr(strSc)) {
            return com.bytedance.sdk.component.pFF.sc(context, strSc).sc(str2, str3);
        }
        SharedPreferences sharedPreferencesSc = pFF.sc(context, strSc);
        return sharedPreferencesSc == null ? str3 : sharedPreferencesSc.getString(str2, str3);
    }

    public static String sc(String str, String str2) {
        return f28617sc.contains(str2) ? "pag_sp_bad_par" : str;
    }

    public static void sc(String str) {
        if (sc()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                    pFF.pFF(zY(), str);
                    return;
                }
                TRI triPFF = pFF();
                if (triPFF != null) {
                    triPFF.sc(Uri.parse(We() + "clean" + pFF(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void sc(String str, String str2, Boolean bool) {
        if (sc()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                    pFF.sc(zY(), str, str2, bool);
                    return;
                }
                TRI triPFF = pFF();
                if (triPFF != null) {
                    Uri uri = Uri.parse(We() + "boolean/" + str2 + pFF(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, bool);
                    triPFF.sc(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void sc(String str, String str2, Float f11) {
        if (sc()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                    pFF.sc(zY(), str, str2, f11);
                    return;
                }
                TRI triPFF = pFF();
                if (triPFF != null) {
                    Uri uri = Uri.parse(We() + "float/" + str2 + pFF(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, f11);
                    triPFF.sc(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void sc(String str, String str2, Integer num) {
        if (sc()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                    pFF.sc(zY(), str, str2, num);
                    return;
                }
                TRI triPFF = pFF();
                if (triPFF != null) {
                    Uri uri = Uri.parse(We() + "int/" + str2 + pFF(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, num);
                    triPFF.sc(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void sc(String str, String str2, Long l11) {
        if (sc()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                    pFF.sc(zY(), str, str2, l11);
                    return;
                }
                TRI triPFF = pFF();
                if (triPFF != null) {
                    Uri uri = Uri.parse(We() + "long/" + str2 + pFF(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, l11);
                    triPFF.sc(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void sc(String str, String str2, String str3) {
        if (sc()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                    pFF.sc(zY(), str, str2, str3);
                    return;
                }
                TRI triPFF = pFF();
                if (triPFF != null) {
                    Uri uri = Uri.parse(We() + "string/" + str2 + pFF(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, str3);
                    triPFF.sc(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean sc() {
        if (Xc.sc() != null) {
            return true;
        }
        Tf.pFF("The context of SPHelper is null, please initialize sdk in main process");
        return false;
    }

    public static boolean sc(Context context, String str, String str2, boolean z11) {
        String strSc = sc(str, str2);
        if (Ol.qr(strSc)) {
            return com.bytedance.sdk.component.pFF.sc(context, strSc).sc(str2, z11);
        }
        SharedPreferences sharedPreferencesSc = pFF.sc(context, strSc);
        return sharedPreferencesSc == null ? z11 : sharedPreferencesSc.getBoolean(str2, z11);
    }

    public static boolean sc(String str, String str2, boolean z11) {
        if (!sc()) {
            return z11;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                return sc(zY(), str, str2, z11);
            }
            TRI triPFF = pFF();
            if (triPFF != null) {
                String strSc = triPFF.sc(Uri.parse(We() + "boolean/" + str2 + pFF(str)));
                if (strSc != null && !strSc.equals("null")) {
                    return Boolean.parseBoolean(strSc);
                }
            }
            return z11;
        } catch (Throwable unused) {
        }
    }

    private static Context zY() {
        return Xc.sc();
    }
}
