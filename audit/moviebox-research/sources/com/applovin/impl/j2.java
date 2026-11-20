package com.applovin.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.View;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f19812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f19813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f19816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f19817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f19818g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Handler f19822k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private HandlerThread f19823l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c f19825n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakReference f19819h = new WeakReference(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19820i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Integer f19821j = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Runnable f19824m = new Runnable() { // from class: com.applovin.impl.uy
        @Override // java.lang.Runnable
        public final void run() {
            this.f23709a.a();
        }
    };

    /* JADX INFO: compiled from: source.java */
    public class a implements d {
        public a() {
        }

        @Override // com.applovin.impl.j2.d
        public void a(Bitmap bitmap) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i11 = width / j2.this.f19816e;
                int i12 = height / j2.this.f19816e;
                int i13 = i11 / 2;
                for (int i14 = i12 / 2; i14 < height; i14 += i12) {
                    for (int i15 = i13; i15 < width; i15 += i11) {
                        int pixel = bitmap.getPixel(i15, i14);
                        if (j2.this.a(pixel)) {
                            bitmap.recycle();
                            j2.this.f();
                            j2.this.d();
                            return;
                        }
                        if (j2.this.f19821j == null) {
                            j2.this.f19821j = Integer.valueOf(pixel);
                        }
                    }
                }
                j2.e(j2.this);
                bitmap.recycle();
                j2.this.d();
            } catch (Exception e11) {
                j2.this.f19812a.E().a("BlackViewDetector", "onScreenshotCaptured", e11);
                j2.this.g();
            }
        }

        @Override // com.applovin.impl.j2.d
        public void a(boolean z11) {
            if (z11) {
                j2.this.g();
            } else {
                j2.this.d();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements PixelCopy.OnPixelCopyFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f19827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f19828b;

        public b(d dVar, Bitmap bitmap) {
            this.f19827a = dVar;
            this.f19828b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i11) {
            if (i11 == 0) {
                this.f19827a.a(this.f19828b);
                return;
            }
            com.applovin.impl.sdk.n unused = j2.this.f19813b;
            if (com.applovin.impl.sdk.n.a()) {
                j2.this.f19813b.b("BlackViewDetector", "Failed to capture screenshot with error code: " + i11);
            }
            this.f19827a.a(true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(View view);
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(Bitmap bitmap);

        void a(boolean z11);
    }

    public j2(com.applovin.impl.sdk.j jVar) {
        this.f19812a = jVar;
        this.f19813b = jVar.J();
        this.f19814c = ((Long) jVar.a(sj.Y5)).longValue();
        this.f19815d = ((Long) jVar.a(sj.X5)).longValue();
        this.f19816e = ((Integer) jVar.a(sj.Z5)).intValue();
        this.f19817f = ((Integer) jVar.a(sj.f22917a6)).intValue();
        this.f19818g = ((Integer) jVar.a(sj.f22924b6)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ActivityManager.MemoryInfo memoryInfoA;
        View view = (View) this.f19819h.get();
        if (view == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f19813b.k("BlackViewDetector", "Monitored view no longer exists.");
            }
            g();
            return;
        }
        Long l11 = (Long) this.f19812a.a(sj.f22955f6);
        if (l11.longValue() > 0 && (memoryInfoA = yp.a((ActivityManager) com.applovin.impl.sdk.j.l().getSystemService("activity"))) != null && memoryInfoA.availMem < l11.longValue()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f19813b.k("BlackViewDetector", "Cancelling black view detection due to low memory");
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f19813b.a("BlackViewDetector", "Checking for black view: " + view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth != 0 && measuredHeight != 0) {
            a(view, new a());
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f19813b.k("BlackViewDetector", "Monitored view is not visible due to dimensions (width = " + measuredWidth + ", height = " + measuredHeight + ")");
        }
        f();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c cVar = this.f19825n;
        if (cVar != null) {
            cVar.a(view);
        }
    }

    private void a(View view, d dVar) {
        if (Build.VERSION.SDK_INT < 26) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f19813b.k("BlackViewDetector", "Unable to capture screenshots on views below API 26");
            }
            dVar.a(true);
            return;
        }
        Activity activityA = this.f19812a.e().a();
        if (activityA == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f19813b.b("BlackViewDetector", "Failed to capture screenshot due to no active activity");
            }
            dVar.a(false);
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i11 = iArr[0];
        int i12 = iArr[1];
        Rect rect = new Rect(i11, i12, i11 + measuredWidth, i12 + measuredHeight);
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            PixelCopy.request(activityA.getWindow(), rect, bitmapCreateBitmap, new b(dVar, bitmapCreateBitmap), new Handler());
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f19813b.b("BlackViewDetector", "Failed to capture screenshot due to exception: " + th2);
            }
            dVar.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x004d  */
    public boolean a(int i11) {
        boolean z11;
        int iRed = Color.red(i11);
        int iGreen = Color.green(i11);
        int iBlue = Color.blue(i11);
        Integer num = this.f19821j;
        if (num != null) {
            int iRed2 = Color.red(num.intValue());
            int iGreen2 = Color.green(this.f19821j.intValue());
            int iBlue2 = Color.blue(this.f19821j.intValue());
            if (Math.abs(iRed - iRed2) > this.f19818g || Math.abs(iGreen - iGreen2) > this.f19818g || Math.abs(iBlue - iBlue2) > this.f19818g) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        int i12 = this.f19817f;
        return iRed > i12 || iGreen > i12 || iBlue > i12 || z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f19825n = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long j11 = this.f19814c;
        if (j11 <= 0) {
            if (this.f19820i == 1) {
                e();
            }
            g();
        } else {
            if (this.f19820i > 1) {
                e();
                g();
                return;
            }
            Handler handler = this.f19822k;
            if (handler != null) {
                handler.postDelayed(this.f19824m, j11);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f19813b.k("BlackViewDetector", "Monitoring handler was unexpectedly null");
            }
            g();
        }
    }

    public static /* synthetic */ int e(j2 j2Var) {
        int i11 = j2Var.f19820i;
        j2Var.f19820i = i11 + 1;
        return i11;
    }

    private void e() {
        final View view = (View) this.f19819h.get();
        if (com.applovin.impl.sdk.n.a()) {
            this.f19813b.k("BlackViewDetector", "Detected black view: " + view);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.wy
            @Override // java.lang.Runnable
            public final void run() {
                this.f24170a.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f19820i = 0;
        this.f19821j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f19819h.get() != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f19813b.a("BlackViewDetector", "Stopped monitoring view: " + this.f19819h.get());
            }
            this.f19819h.clear();
        }
        Handler handler = this.f19822k;
        if (handler != null) {
            handler.removeCallbacks(this.f19824m);
            this.f19822k = null;
        }
        if (this.f19825n != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.vy
                @Override // java.lang.Runnable
                public final void run() {
                    this.f23989a.c();
                }
            });
        }
    }

    public void a(View view, c cVar) {
        if (((Boolean) this.f19812a.a(sj.W5)).booleanValue()) {
            View view2 = (View) this.f19819h.get();
            if (view2 != null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f19813b.k("BlackViewDetector", "Monitoring is already in progress for a view: " + view2);
                    return;
                }
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f19813b.a("BlackViewDetector", "Started monitoring view: " + view);
            }
            try {
                if (this.f19823l == null) {
                    HandlerThread handlerThread = new HandlerThread("AppLovinSdk:black_view_detector");
                    this.f19823l = handlerThread;
                    handlerThread.start();
                } else {
                    this.f19812a.E().a(la.F, "BlackViewDetector:maybeStartMonitoring() unexpectedly called multiple times");
                    g();
                }
                this.f19825n = cVar;
                this.f19819h = new WeakReference(view);
                f();
                Handler handler = new Handler(this.f19823l.getLooper());
                this.f19822k = handler;
                handler.postDelayed(this.f19824m, this.f19815d);
            } catch (Throwable th2) {
                g();
                this.f19812a.E().a("BlackViewDetector", "maybeStartMonitoring", th2);
            }
        }
    }

    public void b() {
        g();
        HandlerThread handlerThread = this.f19823l;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f19823l = null;
        }
    }
}
