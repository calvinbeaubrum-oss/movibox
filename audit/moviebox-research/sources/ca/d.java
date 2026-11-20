package ca;

import android.os.Build;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.j;
import com.cloud.sdk.commonutil.util.s;
import com.hisavana.common.BuildConfig;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f14739a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f14740b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f14741c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f14742d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f14743e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f14744f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f14745g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f14746h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f14747i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f14748j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f14749k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f14750l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f14751m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f14752n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f14753o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f14754p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f14755q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f14756r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AtomicInteger f14757s = new AtomicInteger(0);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final AtomicInteger f14758t = new AtomicInteger(0);

    public static String a() {
        if (TextUtils.isEmpty(f14750l)) {
            f14750l = Build.BRAND;
        }
        return f14750l;
    }

    public static String b() {
        if (TextUtils.isEmpty(f14756r)) {
            f14756r = DeviceUtil.c();
        }
        return f14756r;
    }

    public static String c() {
        if (TextUtils.isEmpty(f14744f)) {
            f14744f = Build.MANUFACTURER;
        }
        return f14744f;
    }

    public static String d() {
        if (DeviceUtil.b(f14748j, f14757s, 1)) {
            String strC = ea.c.c();
            if (!TextUtils.isEmpty(strC) && strC.length() >= 3) {
                f14748j = strC.substring(0, 3);
            }
        }
        return f14748j;
    }

    public static String e() {
        if (DeviceUtil.b(f14749k, f14758t, 1)) {
            String strC = ea.c.c();
            if (!TextUtils.isEmpty(strC) && strC.length() >= 3) {
                f14749k = strC.substring(3);
            }
        }
        return f14749k;
    }

    public static String f() {
        if (TextUtils.isEmpty(f14751m)) {
            f14751m = Build.MODEL;
        }
        return f14751m;
    }

    public static int g() {
        if (f14753o == 0) {
            f14753o = DeviceUtil.k();
        }
        return f14753o;
    }

    public static String h() {
        if (TextUtils.isEmpty(f14752n)) {
            f14752n = DeviceUtil.l();
        }
        return f14752n;
    }

    public static int i() {
        if (f14747i == -1) {
            f14747i = (int) j.b();
        }
        return f14747i;
    }

    public static int j() {
        if (f14746h == -1) {
            try {
                f14746h = j.f();
            } catch (Throwable unused) {
            }
        }
        return f14746h;
    }

    public static int k() {
        if (f14745g == -1) {
            try {
                f14745g = j.g();
            } catch (Throwable unused) {
            }
        }
        return f14745g;
    }

    public static String l() {
        if (TextUtils.isEmpty(f14740b)) {
            f14740b = BuildConfig.VERSION_NAME;
        }
        return f14740b;
    }

    public static int m() {
        if (f14741c == 0) {
            f14741c = 336100;
        }
        return f14741c;
    }

    public static String n() {
        if (TextUtils.isEmpty(f14739a)) {
            f14739a = DeviceUtil.n();
        }
        return f14739a;
    }

    public static int o() {
        if (f14743e == -1) {
            f14743e = ea.c.d() ? 2 : 1;
        }
        return f14743e;
    }

    public static String p() {
        if (TextUtils.isEmpty(f14742d)) {
            f14742d = s.c();
        }
        return f14742d;
    }

    public static String q() {
        if (TextUtils.isEmpty(f14755q)) {
            f14755q = String.valueOf(com.cloud.sdk.commonutil.util.f.d());
        }
        return f14755q;
    }

    public static String r() {
        if (TextUtils.isEmpty(f14754p)) {
            f14754p = String.valueOf(com.cloud.sdk.commonutil.util.f.e());
        }
        return f14754p;
    }
}
