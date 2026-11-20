package com.transsion.core.deviceinfo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.transsion.core.log.LogUtils;
import com.transsion.core.utils.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(3)
public class DeviceInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f51780a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f51781b = "";

    public static String c() {
        if (!TextUtils.isEmpty(f51781b)) {
            return f51781b;
        }
        String string = Settings.Secure.getString(ws.a.a().getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string)) {
            string = string.trim();
        }
        String strA = TextUtils.isEmpty(string) ? "" : c.a(string);
        f51781b = strA;
        return strA;
    }

    public static String d() {
        String str = f51780a;
        if (str == null || str.length() == 0) {
            new Thread(new Runnable() { // from class: com.transsion.core.deviceinfo.DeviceInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String unused = DeviceInfo.f51780a = a.a(ws.a.a()).a();
                        LogUtils.g("advertisingId is " + DeviceInfo.f51780a);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            }).start();
        }
        return f51780a;
    }

    public static String e() {
        if (g()) {
            return d();
        }
        String str = f51780a;
        if (str != null && str.length() != 0) {
            return f51780a;
        }
        try {
            f51780a = a.a(ws.a.a()).a();
            LogUtils.g("advertisingId is " + f51780a);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return f51780a;
    }

    public static String f() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ws.a.a().getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean g() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean h() {
        Context contextA = ws.a.a();
        return contextA.getResources() != null && (contextA.getResources().getConfiguration().screenLayout & 15) >= 3;
    }
}
