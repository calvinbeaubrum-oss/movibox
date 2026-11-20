package ha;

import android.os.Build;
import android.text.TextUtils;
import com.cloud.tmc.integration.utils.q;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.core.utils.e;
import ja.d;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f66406a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f66407b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f66408c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f66409d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f66410e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f66411f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f66412g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f66413h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f66414i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f66415j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f66416k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f66417l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static AtomicInteger f66418m = new AtomicInteger(0);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static AtomicInteger f66419n = new AtomicInteger(0);

    public static String a() {
        if (TextUtils.isEmpty(f66415j)) {
            f66415j = Build.BRAND;
        }
        return f66415j;
    }

    public static String b() {
        if (TextUtils.isEmpty(f66409d)) {
            f66409d = Build.MANUFACTURER;
        }
        return f66409d;
    }

    public static String c() {
        if (q.b(f66413h, f66418m, 1)) {
            String strF = DeviceInfo.f();
            if (!TextUtils.isEmpty(strF) && strF.length() >= 3) {
                f66413h = strF.substring(0, 3);
            }
        }
        return f66413h;
    }

    public static String d() {
        if (q.b(f66414i, f66419n, 1)) {
            String strF = DeviceInfo.f();
            if (!TextUtils.isEmpty(strF) && strF.length() >= 3) {
                f66414i = strF.substring(3);
            }
        }
        return f66414i;
    }

    public static String e() {
        if (TextUtils.isEmpty(f66416k)) {
            f66416k = Build.MODEL;
        }
        return f66416k;
    }

    public static String f() {
        if (TextUtils.isEmpty(f66417l)) {
            f66417l = q.m();
        }
        return f66417l;
    }

    public static int g() {
        if (f66412g == -1) {
            f66412g = (int) e.b();
        }
        return f66412g;
    }

    public static int h() {
        if (f66411f == -1) {
            f66411f = e.e();
        }
        return f66411f;
    }

    public static int i() {
        if (f66410e == -1) {
            f66410e = e.f();
        }
        return f66410e;
    }

    public static String j() {
        if (TextUtils.isEmpty(f66406a)) {
            f66406a = q.n();
        }
        return f66406a;
    }

    public static int k() {
        if (f66408c == -1) {
            f66408c = DeviceInfo.h() ? 2 : 1;
        }
        return f66408c;
    }

    public static String l() {
        if (TextUtils.isEmpty(f66407b)) {
            f66407b = d.c();
        }
        return f66407b;
    }
}
