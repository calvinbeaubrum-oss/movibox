package com.mbridge.msdk.foundation.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebEnvCheckEntry;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f45049a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f45050b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f45051c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f45052d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f45053e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f45054f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f45055g = "";

    public static int a() {
        return f45052d;
    }

    public static void a(int i11) {
        f45052d = i11;
    }

    public static void a(final Context context) {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.e.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID) && com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
                    try {
                        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                        e.a(advertisingIdInfo.getId());
                        e.f45052d = advertisingIdInfo.isLimitAdTrackingEnabled() ? 1 : 0;
                        e.a(context, advertisingIdInfo.getId(), e.f45052d);
                    } catch (Exception unused) {
                        ad.d("DomainSameDiTool", "GET ADID ERROR TRY TO GET FROM GOOGLE PLAY APP");
                        try {
                            b.a aVarA = new b().a(context);
                            e.a(aVarA.a());
                            e.f45052d = aVarA.b() ? 1 : 0;
                            e.a(context, aVarA.a(), e.f45052d);
                        } catch (Exception unused2) {
                            ad.d("DomainSameDiTool", "GET ADID FROM GOOGLE PLAY APP ERROR");
                        }
                    } catch (Throwable th2) {
                        ad.b("DomainSameDiTool", th2.getMessage());
                    }
                }
            }
        }).start();
    }

    public static /* synthetic */ void a(Context context, String str, int i11) {
        try {
            if (an.b(str)) {
                al.b(context, MBridgeConstans.SP_GA_ID, str);
            }
            al.b(context, MBridgeConstans.SP_GA_ID_LIMIT, Integer.valueOf(i11));
        } catch (Exception e11) {
            ad.b("DomainSameDiTool", e11.getMessage());
        }
    }

    public static void a(String str) {
        f45050b = x.b(str);
        f45049a = str;
    }

    public static String b() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.k() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
            return TextUtils.isEmpty(f45050b) ? "" : f45050b;
        }
        if (!TextUtils.isEmpty(f45050b)) {
            return (com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() || f45052d == 0) ? f45050b : "";
        }
        if (!f45051c) {
            a(com.mbridge.msdk.foundation.controller.c.m().c());
            f45051c = true;
        }
        return "";
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        try {
            WebEnvCheckEntry.class.getMethod("check", Context.class).invoke(WebEnvCheckEntry.class.newInstance(), context);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static String c() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.k() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
            return TextUtils.isEmpty(f45049a) ? "" : f45049a;
        }
        if (!TextUtils.isEmpty(f45049a)) {
            return (com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() || f45052d == 0) ? f45049a : "";
        }
        z.j();
        if (!f45051c) {
            a(com.mbridge.msdk.foundation.controller.c.m().c());
            f45051c = true;
        }
        return TextUtils.isEmpty(f45049a) ? "" : f45049a;
    }

    public static String d() {
        if (TextUtils.isEmpty(f45055g) && !f45054f) {
            e();
        }
        return f45055g;
    }

    public static String e() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.k() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (f45054f) {
            return f45053e;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                ContentResolver contentResolver = com.mbridge.msdk.foundation.controller.c.m().c().getContentResolver();
                int i11 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking");
                String string = Settings.Secure.getString(contentResolver, "advertising_id");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, i11);
                jSONObject.put("amazonId", string);
                String string2 = jSONObject.toString();
                if (!TextUtils.isEmpty(string2)) {
                    f45055g = string2;
                    f45053e = x.b(string2);
                }
            } catch (Settings.SettingNotFoundException e11) {
                ad.b("DomainSameDiTool", e11.getMessage());
            }
        } catch (Throwable th2) {
            ad.b("DomainSameDiTool", th2.getMessage());
        }
        f45054f = true;
        return f45053e;
    }
}
