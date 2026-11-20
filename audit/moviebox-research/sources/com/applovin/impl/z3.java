package com.applovin.impl;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.RoundedCorner;
import android.view.WindowManager;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f24793a = new HashMap(2);

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f24795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f24796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24797d;

        /* JADX INFO: renamed from: com.applovin.impl.z3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0208a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f24798a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f24799b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f24800c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f24801d;

            public C0208a a(int i11) {
                this.f24800c = i11;
                return this;
            }

            public a a() {
                return new a(this.f24798a, this.f24799b, this.f24800c, this.f24801d);
            }

            public C0208a b(int i11) {
                this.f24801d = i11;
                return this;
            }

            public C0208a c(int i11) {
                this.f24798a = i11;
                return this;
            }

            public C0208a d(int i11) {
                this.f24799b = i11;
                return this;
            }

            public String toString() {
                return "CompatibilityUtils.ScreenCornerRadii.ScreenCornerRadiiBuilder(topLeft=" + this.f24798a + ", topRight=" + this.f24799b + ", bottomLeft=" + this.f24800c + ", bottomRight=" + this.f24801d + ")";
            }
        }

        public a(int i11, int i12, int i13, int i14) {
            this.f24794a = i11;
            this.f24795b = i12;
            this.f24796c = i13;
            this.f24797d = i14;
        }

        public int a() {
            return this.f24796c;
        }

        public boolean a(Object obj) {
            return obj instanceof a;
        }

        public int b() {
            return this.f24797d;
        }

        public int c() {
            return this.f24794a;
        }

        public int d() {
            return this.f24795b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.a(this) && c() == aVar.c() && d() == aVar.d() && a() == aVar.a() && b() == aVar.b();
        }

        public int hashCode() {
            return ((((((c() + 59) * 59) + d()) * 59) + a()) * 59) + b();
        }

        public String toString() {
            return "CompatibilityUtils.ScreenCornerRadii(topLeft=" + c() + ", topRight=" + d() + ", bottomLeft=" + a() + ", bottomRight=" + b() + ")";
        }
    }

    private static int a(int i11, Display display) {
        RoundedCorner roundedCorner = display.getRoundedCorner(i11);
        if (roundedCorner != null) {
            return roundedCorner.getRadius();
        }
        return -1;
    }

    public static Point a(Context context) {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        Point point = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        StrictMode.setVmPolicy(vmPolicy);
        return point;
    }

    public static a a(Context context, com.applovin.impl.sdk.j jVar) {
        a aVarA = null;
        if (((Boolean) jVar.a(sj.f22961g4)).booleanValue() && m()) {
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                try {
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    aVarA = new a.C0208a().c(a(0, defaultDisplay)).d(a(1, defaultDisplay)).a(a(3, defaultDisplay)).b(a(2, defaultDisplay)).a();
                } catch (Throwable unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        }
        return aVarA;
    }

    public static void a() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        } catch (Throwable unused) {
        }
    }

    public static boolean a(String str, Context context) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static Point b(Context context) {
        int orientation = AppLovinSdkUtils.getOrientation(context);
        Map map = f24793a;
        if (map.containsKey(Integer.valueOf(orientation))) {
            return (Point) map.get(Integer.valueOf(orientation));
        }
        Point point = new Point();
        point.x = 480;
        point.y = 320;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (b()) {
                Rect bounds = windowManager.getMaximumWindowMetrics().getBounds();
                point = new Point(bounds.width(), bounds.height());
            } else if (d()) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
        }
        StrictMode.setVmPolicy(vmPolicy);
        map.put(Integer.valueOf(orientation), point);
        return point;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 34;
    }

    public static boolean d() {
        return true;
    }

    public static boolean e() {
        return true;
    }

    public static boolean f() {
        return true;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean k() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean l() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean m() {
        return Build.VERSION.SDK_INT >= 31;
    }
}
