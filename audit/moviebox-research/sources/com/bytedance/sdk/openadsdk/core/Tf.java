package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Tf {
    private static boolean We;
    private static String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static String f28200sc;
    private static String zY;

    @RequiresPermission(anyOf = {"android.permission.ACCESS_WIFI_STATE"})
    @SuppressLint({"HardwareIds"})
    private static void ExN(Context context) {
        Context contextWe;
        if (We || (contextWe = We(context)) == null) {
            return;
        }
        pFF = String.valueOf(Build.TIME);
        zY = zY.sc(contextWe).pFF("uuid", (String) null);
        We = true;
    }

    private static void TRI(Context context) {
        Context contextWe = We(context);
        if (contextWe == null) {
            return;
        }
        String strPFF = zY.sc(contextWe).pFF("abcd", (String) null);
        if (TextUtils.isEmpty(strPFF)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strPFF);
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            if (iOptInt == 3) {
                String strZY = com.bytedance.sdk.component.utils.sc.zY(strOptString);
                if (TextUtils.isEmpty(strZY)) {
                    return;
                }
                f28200sc = new JSONObject(strZY).optString("abcd");
                sc();
            }
        } catch (Throwable unused) {
        }
    }

    private static Context We(Context context) {
        return context == null ? Xc.sc() : context;
    }

    public static String pFF() {
        try {
            Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
            String language = locale != null ? locale.getLanguage() : "";
            if (locale == null || !"zh".equals(language)) {
                return language;
            }
            String string = locale.toString();
            if (locale.toString().length() >= 5) {
                string = string.substring(0, 5);
            }
            return Locale.SIMPLIFIED_CHINESE.toString().equals(string) ? "zh" : "zh-Hant";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String pFF(Context context) {
        if (pFF == null && !We) {
            synchronized (Tf.class) {
                try {
                    if (!We) {
                        ExN(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pFF;
    }

    public static String sc(Context context) {
        if (!TextUtils.isEmpty(f28200sc)) {
            return f28200sc;
        }
        TRI(context);
        return f28200sc;
    }

    public static void sc() {
        if (TextUtils.isEmpty(f28200sc)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.Cb.pFF(new com.bytedance.sdk.component.Qj.Qj("update_did") { // from class: com.bytedance.sdk.openadsdk.core.Tf.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", SystemClock.elapsedRealtime());
                    jSONObject.put("abcd", Tf.f28200sc);
                    zY.sc(Xc.sc()).sc("abcd", com.bytedance.sdk.component.utils.sc.sc(jSONObject).toString());
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void sc(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(f28200sc)) {
                f28200sc = str;
            }
            sc();
        }
        if (TextUtils.isEmpty(f28200sc)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.Ol.zY.pFF(f28200sc);
        UFX.sc(f28200sc);
    }

    public static String zY(Context context) {
        if (TextUtils.isEmpty(zY) && !We) {
            synchronized (Tf.class) {
                try {
                    if (!We) {
                        ExN(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return zY;
    }
}
