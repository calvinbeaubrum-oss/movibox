package com.google.android.exoplayer2.video;

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
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.video.e f35770a = new com.google.android.exoplayer2.video.e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final b f35771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final e f35772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f35773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public Surface f35774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f35775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f35776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f35777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f35778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f35779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f35780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f35781l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f35782m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f35783n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f35784o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f35785p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f35786q;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static final class a {
        public static void a(Surface surface, float f11) {
            try {
                surface.setFrameRate(f11, f11 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e11) {
                com.google.android.exoplayer2.util.s.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {

        /* JADX INFO: compiled from: source.java */
        public interface a {
            void a(@Nullable Display display);
        }

        void a(a aVar);

        void unregister();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowManager f35787a;

        public c(WindowManager windowManager) {
            this.f35787a = windowManager;
        }

        @Nullable
        public static b b(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new c(windowManager);
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.video.k.b
        public void a(b.a aVar) {
            aVar.a(this.f35787a.getDefaultDisplay());
        }

        @Override // com.google.android.exoplayer2.video.k.b
        public void unregister() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(17)
    public static final class d implements b, DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DisplayManager f35788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public b.a f35789b;

        public d(DisplayManager displayManager) {
            this.f35788a = displayManager;
        }

        @Nullable
        public static b c(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new d(displayManager);
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.video.k.b
        public void a(b.a aVar) {
            this.f35789b = aVar;
            this.f35788a.registerDisplayListener(this, o0.w());
            aVar.a(b());
        }

        public final Display b() {
            return this.f35788a.getDisplay(0);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i11) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i11) {
            b.a aVar = this.f35789b;
            if (aVar == null || i11 != 0) {
                return;
            }
            aVar.a(b());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i11) {
        }

        @Override // com.google.android.exoplayer2.video.k.b
        public void unregister() {
            this.f35788a.unregisterDisplayListener(this);
            this.f35789b = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements Choreographer.FrameCallback, Handler.Callback {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f35790g = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f35791a = C.TIME_UNSET;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f35792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HandlerThread f35793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Choreographer f35794d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f35795f;

        public e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f35793c = handlerThread;
            handlerThread.start();
            Handler handlerV = o0.v(handlerThread.getLooper(), this);
            this.f35792b = handlerV;
            handlerV.sendEmptyMessage(0);
        }

        public static e d() {
            return f35790g;
        }

        public void a() {
            this.f35792b.sendEmptyMessage(1);
        }

        public final void b() {
            Choreographer choreographer = this.f35794d;
            if (choreographer != null) {
                int i11 = this.f35795f + 1;
                this.f35795f = i11;
                if (i11 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        public final void c() {
            try {
                this.f35794d = Choreographer.getInstance();
            } catch (RuntimeException e11) {
                com.google.android.exoplayer2.util.s.j("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e11);
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j11) {
            this.f35791a = j11;
            ((Choreographer) com.google.android.exoplayer2.util.a.e(this.f35794d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f35792b.sendEmptyMessage(2);
        }

        public final void f() {
            Choreographer choreographer = this.f35794d;
            if (choreographer != null) {
                int i11 = this.f35795f - 1;
                this.f35795f = i11;
                if (i11 == 0) {
                    choreographer.removeFrameCallback(this);
                    this.f35791a = C.TIME_UNSET;
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

    public k(@Nullable Context context) {
        b bVarF = f(context);
        this.f35771b = bVarF;
        this.f35772c = bVarF != null ? e.d() : null;
        this.f35780k = C.TIME_UNSET;
        this.f35781l = C.TIME_UNSET;
        this.f35775f = -1.0f;
        this.f35778i = 1.0f;
        this.f35779j = 0;
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
    public static b f(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        b bVarC = o0.f35608a >= 17 ? d.c(applicationContext) : null;
        return bVarC == null ? c.b(applicationContext) : bVarC;
    }

    public long b(long j11) {
        long j12;
        if (this.f35785p == -1 || !this.f35770a.e()) {
            j12 = j11;
        } else {
            long jA = this.f35786q + ((long) ((this.f35770a.a() * (this.f35782m - this.f35785p)) / this.f35778i));
            if (c(j11, jA)) {
                j12 = jA;
            } else {
                n();
                j12 = j11;
            }
        }
        this.f35783n = this.f35782m;
        this.f35784o = j12;
        e eVar = this.f35772c;
        if (eVar == null || this.f35780k == C.TIME_UNSET) {
            return j12;
        }
        long j13 = eVar.f35791a;
        return j13 == C.TIME_UNSET ? j12 : e(j12, j13, this.f35780k) - this.f35781l;
    }

    public final void d() {
        Surface surface;
        if (o0.f35608a < 30 || (surface = this.f35774e) == null || this.f35779j == Integer.MIN_VALUE || this.f35777h == 0.0f) {
            return;
        }
        this.f35777h = 0.0f;
        a.a(surface, 0.0f);
    }

    public void g(float f11) {
        this.f35775f = f11;
        this.f35770a.g();
        q();
    }

    public void h(long j11) {
        long j12 = this.f35783n;
        if (j12 != -1) {
            this.f35785p = j12;
            this.f35786q = this.f35784o;
        }
        this.f35782m++;
        this.f35770a.f(j11 * 1000);
        q();
    }

    public void i(float f11) {
        this.f35778i = f11;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.f35773d = true;
        n();
        if (this.f35771b != null) {
            ((e) com.google.android.exoplayer2.util.a.e(this.f35772c)).a();
            this.f35771b.a(new b.a() { // from class: com.google.android.exoplayer2.video.j
                @Override // com.google.android.exoplayer2.video.k.b.a
                public final void a(Display display) {
                    this.f35769a.p(display);
                }
            });
        }
        r(false);
    }

    public void l() {
        this.f35773d = false;
        b bVar = this.f35771b;
        if (bVar != null) {
            bVar.unregister();
            ((e) com.google.android.exoplayer2.util.a.e(this.f35772c)).e();
        }
        d();
    }

    public void m(@Nullable Surface surface) {
        if (surface instanceof PlaceholderSurface) {
            surface = null;
        }
        if (this.f35774e == surface) {
            return;
        }
        d();
        this.f35774e = surface;
        r(true);
    }

    public final void n() {
        this.f35782m = 0L;
        this.f35785p = -1L;
        this.f35783n = -1L;
    }

    public void o(int i11) {
        if (this.f35779j == i11) {
            return;
        }
        this.f35779j = i11;
        r(true);
    }

    public final void p(@Nullable Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.f35780k = refreshRate;
            this.f35781l = (refreshRate * 80) / 100;
        } else {
            com.google.android.exoplayer2.util.s.i("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.f35780k = C.TIME_UNSET;
            this.f35781l = C.TIME_UNSET;
        }
    }

    public final void q() {
        if (o0.f35608a < 30 || this.f35774e == null) {
            return;
        }
        float fB = this.f35770a.e() ? this.f35770a.b() : this.f35775f;
        float f11 = this.f35776g;
        if (fB == f11) {
            return;
        }
        if (fB != -1.0f && f11 != -1.0f) {
            if (Math.abs(fB - this.f35776g) < ((!this.f35770a.e() || this.f35770a.d() < 5000000000L) ? 1.0f : 0.02f)) {
                return;
            }
        } else if (fB == -1.0f && this.f35770a.c() < 30) {
            return;
        }
        this.f35776g = fB;
        r(false);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0022  */
    public final void r(boolean z11) {
        Surface surface;
        float f11;
        if (o0.f35608a < 30 || (surface = this.f35774e) == null || this.f35779j == Integer.MIN_VALUE) {
            return;
        }
        if (this.f35773d) {
            float f12 = this.f35776g;
            if (f12 != -1.0f) {
                f11 = f12 * this.f35778i;
            } else {
                f11 = 0.0f;
            }
        } else {
            f11 = 0.0f;
        }
        if (z11 || this.f35777h != f11) {
            this.f35777h = f11;
            a.a(surface, f11);
        }
    }
}
