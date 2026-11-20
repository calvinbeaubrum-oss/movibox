package com.apm.insight;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.h;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f16733a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Application f16734b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f16735c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f16736d = "default";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f16737e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static com.apm.insight.nativecrash.b f16738f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile ConcurrentHashMap<Integer, String> f16741i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile String f16746n;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ConfigManager f16739g = new ConfigManager();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static a f16740h = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static h f16742j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile String f16743k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Object f16744l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile int f16745m = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f16747o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static boolean f16748p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static boolean f16749q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static boolean f16750r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static boolean f16751s = true;

    public static com.apm.insight.nativecrash.b a() {
        if (f16738f == null) {
            f16738f = h.a(f16733a);
        }
        return f16738f;
    }

    public static String a(long j11, CrashType crashType, boolean z11, boolean z12) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j11);
        sb2.append("_");
        sb2.append(crashType.getName());
        sb2.append('_');
        sb2.append(f());
        sb2.append('_');
        sb2.append(z11 ? "oom_" : "normal_");
        sb2.append(f16735c);
        sb2.append('_');
        sb2.append(z12 ? "ignore_" : "normal_");
        sb2.append(Long.toHexString(new Random().nextLong()));
        sb2.append(RequestConfiguration.MAX_AD_CONTENT_RATING_G);
        return sb2.toString();
    }

    public static void a(int i11, String str) {
        if (f16741i == null) {
            synchronized (e.class) {
                try {
                    if (f16741i == null) {
                        f16741i = new ConcurrentHashMap<>();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        f16741i.put(Integer.valueOf(i11), str);
    }

    public static void a(Application application) {
        if (application != null) {
            f16734b = application;
        }
    }

    public static void a(Application application, Context context) {
        if (f16734b == null) {
            f16735c = System.currentTimeMillis();
            f16733a = context;
            f16734b = application;
            f16743k = Long.toHexString(new Random().nextLong()) + RequestConfiguration.MAX_AD_CONTENT_RATING_G;
        }
    }

    public static void a(Application application, Context context, ICommonParams iCommonParams) {
        a(application, context);
        f16738f = new com.apm.insight.nativecrash.b(f16733a, iCommonParams, a());
    }

    public static void a(com.apm.insight.nativecrash.b bVar) {
        f16738f = bVar;
    }

    public static void a(String str) {
        f16736d = str;
    }

    public static void a(boolean z11) {
        f16748p = z11;
    }

    public static a b() {
        return f16740h;
    }

    public static void b(int i11, String str) {
        f16745m = i11;
        f16746n = str;
    }

    public static void b(boolean z11) {
        f16749q = z11;
    }

    public static h c() {
        if (f16742j == null) {
            synchronized (e.class) {
                f16742j = new h();
            }
        }
        return f16742j;
    }

    public static void c(boolean z11) {
        f16750r = z11;
    }

    public static void d(boolean z11) {
        f16751s = z11;
    }

    public static boolean d() {
        if (!f16739g.isDebugMode()) {
            return false;
        }
        Object obj = a().a().get("channel");
        return (obj == null ? AppLovinMediationProvider.UNKNOWN : String.valueOf(obj)).contains("local_test");
    }

    public static String e() {
        return f() + '_' + Long.toHexString(new Random().nextLong()) + RequestConfiguration.MAX_AD_CONTENT_RATING_G;
    }

    public static String f() {
        if (f16743k == null) {
            synchronized (f16744l) {
                try {
                    if (f16743k == null) {
                        f16743k = Long.toHexString(new Random().nextLong()) + "U";
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f16743k;
    }

    public static Context g() {
        return f16733a;
    }

    public static Application h() {
        return f16734b;
    }

    public static ConfigManager i() {
        return f16739g;
    }

    public static long j() {
        return f16735c;
    }

    public static String k() {
        return f16736d;
    }

    public static void l() {
        f16747o = 1;
    }

    public static int m() {
        return f16747o;
    }

    public static boolean n() {
        return f16737e;
    }

    public static void o() {
        f16737e = true;
    }

    public static ConcurrentHashMap<Integer, String> p() {
        return f16741i;
    }

    public static int q() {
        return f16745m;
    }

    public static String r() {
        return f16746n;
    }

    public static boolean s() {
        return f16748p;
    }

    public static boolean t() {
        return f16749q;
    }

    public static boolean u() {
        return f16750r;
    }

    public static boolean v() {
        return f16751s;
    }
}
