package androidx.media3.exoplayer.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f11669a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final c f11670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final f f11671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public Surface f11673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f11674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f11675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f11676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f11677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f11679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f11680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f11681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f11682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f11683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f11684p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f11685q;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(17)
    public static final class a {
        public static boolean a(@Nullable Surface surface) {
            return surface instanceof PlaceholderSurface;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static final class b {
        public static void a(Surface surface, float f11) {
            try {
                surface.setFrameRate(f11, f11 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e11) {
                z3.o.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {

        /* JADX INFO: compiled from: source.java */
        public interface a {
            void a(@Nullable Display display);
        }

        void a(a aVar);

        void unregister();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowManager f11686a;

        public d(WindowManager windowManager) {
            this.f11686a = windowManager;
        }

        @Nullable
        public static c b(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new d(windowManager);
            }
            return null;
        }

        @Override // androidx.media3.exoplayer.video.r.c
        public void a(c.a aVar) {
            aVar.a(this.f11686a.getDefaultDisplay());
        }

        @Override // androidx.media3.exoplayer.video.r.c
        public void unregister() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(17)
    public static final class e implements c, DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DisplayManager f11687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public c.a f11688b;

        public e(DisplayManager displayManager) {
            this.f11687a = displayManager;
        }

        @Nullable
        public static c c(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new e(displayManager);
            }
            return null;
        }

        @Override // androidx.media3.exoplayer.video.r.c
        public void a(c.a aVar) {
            this.f11688b = aVar;
            this.f11687a.registerDisplayListener(this, u0.A());
            aVar.a(b());
        }

        public final Display b() {
            return this.f11687a.getDisplay(0);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i11) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i11) {
            c.a aVar = this.f11688b;
            if (aVar == null || i11 != 0) {
                return;
            }
            aVar.a(b());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i11) {
        }

        @Override // androidx.media3.exoplayer.video.r.c
        public void unregister() {
            this.f11687a.unregisterDisplayListener(this);
            this.f11688b = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements Choreographer.FrameCallback, Handler.Callback {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f11689g = new f();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f11690a = C.TIME_UNSET;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f11691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HandlerThread f11692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Choreographer f11693d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11694f;

        public f() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f11692c = handlerThread;
            handlerThread.start();
            Handler handlerZ = u0.z(handlerThread.getLooper(), this);
            this.f11691b = handlerZ;
            handlerZ.sendEmptyMessage(0);
        }

        public static f d() {
            return f11689g;
        }

        public void a() {
            this.f11691b.sendEmptyMessage(1);
        }

        public final void b() {
            Choreographer choreographer = this.f11693d;
            if (choreographer != null) {
                int i11 = this.f11694f + 1;
                this.f11694f = i11;
                if (i11 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        public final void c() {
            try {
                this.f11693d = Choreographer.getInstance();
            } catch (RuntimeException e11) {
                z3.o.i("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e11);
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j11) {
            this.f11690a = j11;
            ((Choreographer) z3.a.e(this.f11693d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f11691b.sendEmptyMessage(2);
        }

        public final void f() {
            Choreographer choreographer = this.f11693d;
            if (choreographer != null) {
                int i11 = this.f11694f - 1;
                this.f11694f = i11;
                if (i11 == 0) {
                    choreographer.removeFrameCallback(this);
                    this.f11690a = C.TIME_UNSET;
                }
            }
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

    public r(@Nullable Context context) {
        c cVarF = f(context);
        this.f11670b = cVarF;
        this.f11671c = cVarF != null ? f.d() : null;
        this.f11679k = C.TIME_UNSET;
        this.f11680l = C.TIME_UNSET;
        this.f11674f = -1.0f;
        this.f11677i = 1.0f;
        this.f11678j = 0;
    }

    public static boolean c(long j11, long j12) {
        return Math.abs(j11 - j12) <= 20000000;
    }

    public static long e(long j11, long j12, long j13) {
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

    @Nullable
    public static c f(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        c cVarC = u0.f81838a >= 17 ? e.c(applicationContext) : null;
        return cVarC == null ? d.b(applicationContext) : cVarC;
    }

    public long b(long j11) {
        long j12;
        if (this.f11684p == -1 || !this.f11669a.e()) {
            j12 = j11;
        } else {
            long jA = this.f11685q + ((long) ((this.f11669a.a() * (this.f11681m - this.f11684p)) / this.f11677i));
            if (c(j11, jA)) {
                j12 = jA;
            } else {
                n();
                j12 = j11;
            }
        }
        this.f11682n = this.f11681m;
        this.f11683o = j12;
        f fVar = this.f11671c;
        if (fVar == null || this.f11679k == C.TIME_UNSET) {
            return j12;
        }
        long j13 = fVar.f11690a;
        return j13 == C.TIME_UNSET ? j12 : e(j12, j13, this.f11679k) - this.f11680l;
    }

    public final void d() {
        Surface surface;
        if (u0.f81838a < 30 || (surface = this.f11673e) == null || this.f11678j == Integer.MIN_VALUE || this.f11676h == 0.0f) {
            return;
        }
        this.f11676h = 0.0f;
        b.a(surface, 0.0f);
    }

    public void g(float f11) {
        this.f11674f = f11;
        this.f11669a.g();
        q();
    }

    public void h(long j11) {
        long j12 = this.f11682n;
        if (j12 != -1) {
            this.f11684p = j12;
            this.f11685q = this.f11683o;
        }
        this.f11681m++;
        this.f11669a.f(j11 * 1000);
        q();
    }

    public void i(float f11) {
        this.f11677i = f11;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.f11672d = true;
        n();
        if (this.f11670b != null) {
            ((f) z3.a.e(this.f11671c)).a();
            this.f11670b.a(new c.a() { // from class: androidx.media3.exoplayer.video.q
                @Override // androidx.media3.exoplayer.video.r.c.a
                public final void a(Display display) {
                    this.f11668a.p(display);
                }
            });
        }
        r(false);
    }

    public void l() {
        this.f11672d = false;
        c cVar = this.f11670b;
        if (cVar != null) {
            cVar.unregister();
            ((f) z3.a.e(this.f11671c)).e();
        }
        d();
    }

    public void m(@Nullable Surface surface) {
        if (u0.f81838a >= 17 && a.a(surface)) {
            surface = null;
        }
        if (this.f11673e == surface) {
            return;
        }
        d();
        this.f11673e = surface;
        r(true);
    }

    public final void n() {
        this.f11681m = 0L;
        this.f11684p = -1L;
        this.f11682n = -1L;
    }

    public void o(int i11) {
        if (this.f11678j == i11) {
            return;
        }
        this.f11678j = i11;
        r(true);
    }

    public final void p(@Nullable Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.f11679k = refreshRate;
            this.f11680l = (refreshRate * 80) / 100;
        } else {
            z3.o.h("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.f11679k = C.TIME_UNSET;
            this.f11680l = C.TIME_UNSET;
        }
    }

    public final void q() {
        if (u0.f81838a < 30 || this.f11673e == null) {
            return;
        }
        float fB = this.f11669a.e() ? this.f11669a.b() : this.f11674f;
        float f11 = this.f11675g;
        if (fB == f11) {
            return;
        }
        if (fB != -1.0f && f11 != -1.0f) {
            if (Math.abs(fB - this.f11675g) < ((!this.f11669a.e() || this.f11669a.d() < 5000000000L) ? 1.0f : 0.02f)) {
                return;
            }
        } else if (fB == -1.0f && this.f11669a.c() < 30) {
            return;
        }
        this.f11675g = fB;
        r(false);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0022  */
    public final void r(boolean z11) {
        Surface surface;
        float f11;
        if (u0.f81838a < 30 || (surface = this.f11673e) == null || this.f11678j == Integer.MIN_VALUE) {
            return;
        }
        if (this.f11672d) {
            float f12 = this.f11675g;
            if (f12 != -1.0f) {
                f11 = f12 * this.f11677i;
            } else {
                f11 = 0.0f;
            }
        } else {
            f11 = 0.0f;
        }
        if (z11 || this.f11676h != f11) {
            this.f11676h = f11;
            b.a(surface, f11);
        }
    }
}
