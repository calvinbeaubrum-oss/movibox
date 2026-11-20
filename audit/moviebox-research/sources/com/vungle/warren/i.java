package com.vungle.warren;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.vungle.warren.utility.ViewUtility;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f62029d = Pattern.quote("{{{req_width}}}");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f62030e = Pattern.quote("{{{req_height}}}");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f62031f = Pattern.quote("{{{width}}}");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f62032g = Pattern.quote("{{{height}}}");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f62033h = Pattern.quote("{{{down_x}}}");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f62034i = Pattern.quote("{{{down_y}}}");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f62035j = Pattern.quote("{{{up_x}}}");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f62036k = Pattern.quote("{{{up_y}}}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.vungle.warren.model.c f62037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s00.a f62038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f62039c;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f62040a = new b(Integer.MIN_VALUE, Integer.MIN_VALUE);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f62041b = new b(Integer.MIN_VALUE, Integer.MIN_VALUE);

        public boolean a() {
            b bVar = this.f62040a;
            if (bVar.f62042a != Integer.MIN_VALUE && bVar.f62043b != Integer.MIN_VALUE) {
                b bVar2 = this.f62041b;
                if (bVar2.f62042a != Integer.MIN_VALUE && bVar2.f62043b != Integer.MIN_VALUE) {
                    return true;
                }
            }
            return false;
        }

        public void b(b bVar) {
            this.f62040a = bVar;
        }

        public void c(b bVar) {
            this.f62041b = bVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f62042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f62043b;

        public b(int i11, int i12) {
            this.f62042a = i11;
            this.f62043b = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        public static c f62044c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f62045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DisplayMetrics f62046b;

        public c(@NonNull Context context) {
            Context applicationContext = context.getApplicationContext();
            this.f62045a = applicationContext;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f62046b = displayMetrics;
            ((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }

        public static c c(@NonNull Context context) {
            if (f62044c == null) {
                f62044c = new c(context);
            }
            return f62044c;
        }

        public int a() {
            return this.f62046b.heightPixels;
        }

        public int b() {
            return this.f62046b.widthPixels;
        }
    }

    public i(@NonNull com.vungle.warren.model.c cVar, @NonNull s00.a aVar) {
        this.f62037a = cVar;
        this.f62038b = aVar;
    }

    public final int a() {
        if (Vungle.appContext() != null) {
            return c.c(Vungle.appContext()).a();
        }
        return 0;
    }

    public final int b() {
        if (Vungle.appContext() != null) {
            return c.c(Vungle.appContext()).b();
        }
        return 0;
    }

    public final int c() {
        if (Vungle.appContext() == null || this.f62037a.d() == null) {
            return 0;
        }
        AdConfig.AdSize adSizeA = this.f62037a.d().a();
        return adSizeA == AdConfig.AdSize.VUNGLE_DEFAULT ? a() : ViewUtility.a(Vungle.appContext(), adSizeA.getHeight());
    }

    public final int d() {
        if (Vungle.appContext() == null || this.f62037a.d() == null) {
            return 0;
        }
        AdConfig.AdSize adSizeA = this.f62037a.d().a();
        return adSizeA == AdConfig.AdSize.VUNGLE_DEFAULT ? b() : ViewUtility.a(Vungle.appContext(), adSizeA.getWidth());
    }

    public final void e() {
        String[] strArrG;
        if (this.f62038b == null || (strArrG = this.f62037a.G("video.clickCoordinates")) == null || strArrG.length == 0) {
            return;
        }
        int iD = d();
        int iC = c();
        int iD2 = d();
        int iC2 = c();
        for (int i11 = 0; i11 < strArrG.length; i11++) {
            String str = strArrG[i11];
            if (!TextUtils.isEmpty(str)) {
                strArrG[i11] = str.replaceAll(f62029d, Integer.toString(iD)).replaceAll(f62030e, Integer.toString(iC)).replaceAll(f62031f, Integer.toString(iD2)).replaceAll(f62032g, Integer.toString(iC2)).replaceAll(f62033h, Integer.toString(this.f62039c.f62040a.f62042a)).replaceAll(f62034i, Integer.toString(this.f62039c.f62040a.f62043b)).replaceAll(f62035j, Integer.toString(this.f62039c.f62041b.f62042a)).replaceAll(f62036k, Integer.toString(this.f62039c.f62041b.f62043b));
            }
        }
        this.f62038b.b(strArrG);
    }

    public void f(MotionEvent motionEvent) {
        if (this.f62037a.U()) {
            if (this.f62039c == null) {
                this.f62039c = new a();
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f62039c.b(new b((int) motionEvent.getX(), (int) motionEvent.getY()));
            } else {
                if (action != 1) {
                    return;
                }
                this.f62039c.c(new b((int) motionEvent.getX(), (int) motionEvent.getY()));
                if (this.f62039c.a()) {
                    e();
                }
            }
        }
    }
}
