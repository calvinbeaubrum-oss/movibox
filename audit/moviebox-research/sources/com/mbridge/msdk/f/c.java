package com.mbridge.msdk.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.GoogleApiAvailability;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f43981a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f43982b = false;

    public static void a() {
        if (af.a().a("cronet_env_check", false)) {
            try {
                GoogleApiAvailability.getInstance().getApkVersion(com.mbridge.msdk.foundation.controller.c.m().c());
                GoogleApiAvailability.getInstance().verifyGooglePlayServicesIsAvailable(com.mbridge.msdk.foundation.controller.c.m().c(), 11925000);
                try {
                    String strD = d();
                    boolean z11 = !TextUtils.isEmpty(strD);
                    f43982b = z11;
                    if (z11) {
                        f43981a = strD;
                    }
                } catch (Throwable th2) {
                    ad.b("CronetEnvCheckUtil", th2.getMessage());
                }
            } catch (Throwable th3) {
                ad.b("CronetEnvCheckUtil", th3.getMessage());
                f43982b = false;
            }
        }
    }

    public static boolean a(boolean z11) {
        return f43982b && z11;
    }

    public static boolean b() {
        return af.a().a("cronet_engine_open", false) && f43982b;
    }

    public static boolean c() {
        return f43982b;
    }

    private static String d() {
        ArrayList<Pair> arrayList = new ArrayList();
        arrayList.add(Pair.create(1, "org.chromium.net.impl.JavaCronetProvider"));
        arrayList.add(Pair.create(2, "org.chromium.net.impl.NativeCronetProvider"));
        arrayList.add(Pair.create(3, "com.google.android.gms.net.PlayServicesCronetProvider"));
        arrayList.add(Pair.create(4, "com.google.android.gms.net.GmsCoreCronetProvider"));
        try {
            StringBuilder sb2 = new StringBuilder();
            ClassLoader classLoader = com.mbridge.msdk.foundation.controller.c.m().c().getClassLoader();
            for (Pair pair : arrayList) {
                try {
                    if (!TextUtils.isEmpty(classLoader.loadClass((String) pair.second).getConstructor(Context.class).newInstance(com.mbridge.msdk.foundation.controller.c.m().c()).getClass().getName())) {
                        if (sb2.length() > 0) {
                            sb2.append(",");
                        }
                        sb2.append(pair.first);
                    }
                } catch (Throwable th2) {
                    ad.b("CronetEnvCheckUtil", th2.getMessage());
                }
            }
            return sb2.toString();
        } catch (Throwable th3) {
            ad.b("CronetEnvCheckUtil", th3.getMessage());
            return "";
        }
    }
}
