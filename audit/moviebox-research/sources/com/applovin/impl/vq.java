package com.applovin.impl;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class vq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r8 f23938a = new r8();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f23939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f23940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f23941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Surface f23942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f23943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f23944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f23945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f23946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f23947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f23948k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f23949l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f23950m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f23951n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f23952o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f23953p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f23954q;

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static void a(Surface surface, float f11) {
            try {
                surface.setFrameRate(f11, f11 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e11) {
                pc.a("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {

        /* JADX INFO: compiled from: source.java */
        public interface a {
            void a(Display display);
        }

        void a();

        void a(a aVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WindowManager f23955a;

        private c(WindowManager windowManager) {
            this.f23955a = windowManager;
        }

        public static b a(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new c(windowManager);
            }
            return null;
        }

        @Override // com.applovin.impl.vq.b
        public void a() {
        }

        @Override // com.applovin.impl.vq.b
        public void a(b.a aVar) {
            aVar.a(this.f23955a.getDefaultDisplay());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements b, DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayManager f23956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b.a f23957b;

        private d(DisplayManager displayManager) {
            this.f23956a = displayManager;
        }

        public static b a(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new d(displayManager);
            }
            return null;
        }

        private Display b() {
            return this.f23956a.getDisplay(0);
        }

        @Override // com.applovin.impl.vq.b
        public void a() {
            this.f23956a.unregisterDisplayListener(this);
            this.f23957b = null;
        }

        @Override // com.applovin.impl.vq.b
        public void a(b.a aVar) {
            this.f23957b = aVar;
            this.f23956a.registerDisplayListener(this, xp.a());
            aVar.a(b());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i11) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i11) {
            b.a aVar = this.f23957b;
            if (aVar == null || i11 != 0) {
                return;
            }
            aVar.a(b());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i11) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements Choreographer.FrameCallback, Handler.Callback {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final e f23958g = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f23959a = C.TIME_UNSET;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f23960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HandlerThread f23961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Choreographer f23962d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f23963f;

        private e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f23961c = handlerThread;
            handlerThread.start();
            Handler handlerA = xp.a(handlerThread.getLooper(), (Handler.Callback) this);
            this.f23960b = handlerA;
            handlerA.sendEmptyMessage(0);
        }

        private void b() {
            int i11 = this.f23963f + 1;
            this.f23963f = i11;
            if (i11 == 1) {
                ((Choreographer) b1.a(this.f23962d)).postFrameCallback(this);
            }
        }

        private void c() {
            this.f23962d = Choreographer.getInstance();
        }

        public static e d() {
            return f23958g;
        }

        private void f() {
            int i11 = this.f23963f - 1;
            this.f23963f = i11;
            if (i11 == 0) {
                ((Choreographer) b1.a(this.f23962d)).removeFrameCallback(this);
                this.f23959a = C.TIME_UNSET;
            }
        }

        public void a() {
            this.f23960b.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j11) {
            this.f23959a = j11;
            ((Choreographer) b1.a(this.f23962d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f23960b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 0) {
                c();
                return true;
            }
            if (i11 == 1) {
                b();
                return true;
            }
            if (i11 != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public vq(Context context) {
        b bVarA = a(context);
        this.f23939b = bVarA;
        this.f23940c = bVarA != null ? e.d() : null;
        this.f23948k = C.TIME_UNSET;
        this.f23949l = C.TIME_UNSET;
        this.f23943f = -1.0f;
        this.f23946i = 1.0f;
        this.f23947j = 0;
    }

    private static long a(long j11, long j12, long j13) {
        long j14;
        long j15 = j12 + (((j11 - j12) / j13) * j13);
        if (j11 <= j15) {
            j14 = j15 - j13;
        } else {
            j15 = j13 + j15;
            j14 = j15;
        }
        return j15 - j11 < j11 - j14 ? j15 : j14;
    }

    private static b a(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        b bVarA = xp.f24372a >= 17 ? d.a(applicationContext) : null;
        return bVarA == null ? c.a(applicationContext) : bVarA;
    }

    private void a() {
        Surface surface;
        if (xp.f24372a < 30 || (surface = this.f23942e) == null || this.f23947j == Integer.MIN_VALUE || this.f23945h == 0.0f) {
            return;
        }
        this.f23945h = 0.0f;
        a.a(surface, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.f23948k = refreshRate;
            this.f23949l = (refreshRate * 80) / 100;
        } else {
            pc.d("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.f23948k = C.TIME_UNSET;
            this.f23949l = C.TIME_UNSET;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0022  */
    private void a(boolean z11) {
        Surface surface;
        float f11;
        if (xp.f24372a < 30 || (surface = this.f23942e) == null || this.f23947j == Integer.MIN_VALUE) {
            return;
        }
        if (this.f23941d) {
            float f12 = this.f23944g;
            if (f12 != -1.0f) {
                f11 = f12 * this.f23946i;
            } else {
                f11 = 0.0f;
            }
        } else {
            f11 = 0.0f;
        }
        if (z11 || this.f23945h != f11) {
            this.f23945h = f11;
            a.a(surface, f11);
        }
    }

    private static boolean a(long j11, long j12) {
        return Math.abs(j11 - j12) <= 20000000;
    }

    private void g() {
        this.f23950m = 0L;
        this.f23953p = -1L;
        this.f23951n = -1L;
    }

    private void h() {
        if (xp.f24372a < 30 || this.f23942e == null) {
            return;
        }
        float fB = this.f23938a.e() ? this.f23938a.b() : this.f23943f;
        float f11 = this.f23944g;
        if (fB == f11) {
            return;
        }
        if (fB != -1.0f && f11 != -1.0f) {
            if (Math.abs(fB - this.f23944g) < ((!this.f23938a.e() || this.f23938a.d() < 5000000000L) ? 1.0f : 0.02f)) {
                return;
            }
        } else if (fB == -1.0f && this.f23938a.c() < 30) {
            return;
        }
        this.f23944g = fB;
        a(false);
    }

    public long a(long j11) {
        long j12;
        if (this.f23953p == -1 || !this.f23938a.e()) {
            j12 = j11;
        } else {
            long jA = this.f23954q + ((long) ((this.f23938a.a() * (this.f23950m - this.f23953p)) / this.f23946i));
            if (a(j11, jA)) {
                j12 = jA;
            } else {
                g();
                j12 = j11;
            }
        }
        this.f23951n = this.f23950m;
        this.f23952o = j12;
        e eVar = this.f23940c;
        if (eVar == null || this.f23948k == C.TIME_UNSET) {
            return j12;
        }
        long j13 = eVar.f23959a;
        return j13 == C.TIME_UNSET ? j12 : a(j12, j13, this.f23948k) - this.f23949l;
    }

    public void a(float f11) {
        this.f23943f = f11;
        this.f23938a.f();
        h();
    }

    public void a(int i11) {
        if (this.f23947j == i11) {
            return;
        }
        this.f23947j = i11;
        a(true);
    }

    public void a(Surface surface) {
        if (surface instanceof h7) {
            surface = null;
        }
        if (this.f23942e == surface) {
            return;
        }
        a();
        this.f23942e = surface;
        a(true);
    }

    public void b() {
        b bVar = this.f23939b;
        if (bVar != null) {
            bVar.a();
            ((e) b1.a(this.f23940c)).e();
        }
    }

    public void b(float f11) {
        this.f23946i = f11;
        g();
        a(false);
    }

    public void b(long j11) {
        long j12 = this.f23951n;
        if (j12 != -1) {
            this.f23953p = j12;
            this.f23954q = this.f23952o;
        }
        this.f23950m++;
        this.f23938a.a(j11 * 1000);
        h();
    }

    public void c() {
        if (this.f23939b != null) {
            ((e) b1.a(this.f23940c)).a();
            this.f23939b.a(new b.a() { // from class: com.applovin.impl.y70
                @Override // com.applovin.impl.vq.b.a
                public final void a(Display display) {
                    this.f24567a.a(display);
                }
            });
        }
    }

    public void d() {
        g();
    }

    public void e() {
        this.f23941d = true;
        g();
        a(false);
    }

    public void f() {
        this.f23941d = false;
        a();
    }
}
