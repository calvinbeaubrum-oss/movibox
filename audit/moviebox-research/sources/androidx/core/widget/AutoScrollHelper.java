package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f8032s = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f8035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f8036d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8040i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8044m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8045n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f8046o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f8047p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f8048q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f8049r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f8033a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Interpolator f8034b = new AccelerateInterpolator();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f8037f = {0.0f, 0.0f};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f8038g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f8041j = {0.0f, 0.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f8042k = {0.0f, 0.0f};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float[] f8043l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: compiled from: source.java */
    public class ScrollAnimationRunnable implements Runnable {
        public ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.f8047p) {
                if (autoScrollHelper.f8045n) {
                    autoScrollHelper.f8045n = false;
                    autoScrollHelper.f8033a.m();
                }
                a aVar = AutoScrollHelper.this.f8033a;
                if (aVar.h() || !AutoScrollHelper.this.u()) {
                    AutoScrollHelper.this.f8047p = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.f8046o) {
                    autoScrollHelper2.f8046o = false;
                    autoScrollHelper2.c();
                }
                aVar.a();
                AutoScrollHelper.this.j(aVar.b(), aVar.c());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.f8035c, this);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f8052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f8053d;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f8059j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f8060k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8054e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f8058i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f8055f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8056g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8057h = 0;

        public void a() {
            if (this.f8055f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j11 = jCurrentAnimationTimeMillis - this.f8055f;
            this.f8055f = jCurrentAnimationTimeMillis;
            float f11 = j11 * fG;
            this.f8056g = (int) (this.f8052c * f11);
            this.f8057h = (int) (f11 * this.f8053d);
        }

        public int b() {
            return this.f8056g;
        }

        public int c() {
            return this.f8057h;
        }

        public int d() {
            float f11 = this.f8052c;
            return (int) (f11 / Math.abs(f11));
        }

        public final float e(long j11) {
            long j12 = this.f8054e;
            if (j11 < j12) {
                return 0.0f;
            }
            long j13 = this.f8058i;
            if (j13 < 0 || j11 < j13) {
                return AutoScrollHelper.e((j11 - j12) / this.f8050a, 0.0f, 1.0f) * 0.5f;
            }
            float f11 = this.f8059j;
            return (1.0f - f11) + (f11 * AutoScrollHelper.e((j11 - j13) / this.f8060k, 0.0f, 1.0f));
        }

        public int f() {
            float f11 = this.f8053d;
            return (int) (f11 / Math.abs(f11));
        }

        public final float g(float f11) {
            return ((-4.0f) * f11 * f11) + (f11 * 4.0f);
        }

        public boolean h() {
            return this.f8058i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f8058i + ((long) this.f8060k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f8060k = AutoScrollHelper.f((int) (jCurrentAnimationTimeMillis - this.f8054e), 0, this.f8051b);
            this.f8059j = e(jCurrentAnimationTimeMillis);
            this.f8058i = jCurrentAnimationTimeMillis;
        }

        public void j(int i11) {
            this.f8051b = i11;
        }

        public void k(int i11) {
            this.f8050a = i11;
        }

        public void l(float f11, float f12) {
            this.f8052c = f11;
            this.f8053d = f12;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f8054e = jCurrentAnimationTimeMillis;
            this.f8058i = -1L;
            this.f8055f = jCurrentAnimationTimeMillis;
            this.f8059j = 0.5f;
            this.f8056g = 0;
            this.f8057h = 0;
        }
    }

    public AutoScrollHelper(@NonNull View view) {
        this.f8035c = view;
        float f11 = Resources.getSystem().getDisplayMetrics().density;
        float f12 = (int) ((1575.0f * f11) + 0.5f);
        o(f12, f12);
        float f13 = (int) ((f11 * 315.0f) + 0.5f);
        p(f13, f13);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f8032s);
        r(500);
        q(500);
    }

    public static float e(float f11, float f12, float f13) {
        if (f11 > f13) {
            return f13;
        }
        return f11 < f12 ? f12 : f11;
    }

    public static int f(int i11, int i12, int i13) {
        if (i11 > i13) {
            return i13;
        }
        return i11 < i12 ? i12 : i11;
    }

    public abstract boolean a(int i11);

    public abstract boolean b(int i11);

    public void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f8035c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final float d(int i11, float f11, float f12, float f13) {
        float fH = h(this.f8037f[i11], f12, this.f8038g[i11], f11);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f14 = this.f8041j[i11];
        float f15 = this.f8042k[i11];
        float f16 = this.f8043l[i11];
        float f17 = f14 * f13;
        return fH > 0.0f ? e(fH * f17, f15, f16) : -e((-fH) * f17, f15, f16);
    }

    public final float g(float f11, float f12) {
        if (f12 == 0.0f) {
            return 0.0f;
        }
        int i11 = this.f8039h;
        if (i11 == 0 || i11 == 1) {
            if (f11 < f12) {
                if (f11 >= 0.0f) {
                    return 1.0f - (f11 / f12);
                }
                if (this.f8047p && i11 == 1) {
                    return 1.0f;
                }
            }
        } else if (i11 == 2 && f11 < 0.0f) {
            return f11 / (-f12);
        }
        return 0.0f;
    }

    public final float h(float f11, float f12, float f13, float f14) {
        float interpolation;
        float fE = e(f11 * f12, 0.0f, f13);
        float fG = g(f12 - f14, fE) - g(f14, fE);
        if (fG < 0.0f) {
            interpolation = -this.f8034b.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f8034b.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    public final void i() {
        if (this.f8045n) {
            this.f8047p = false;
        } else {
            this.f8033a.i();
        }
    }

    public abstract void j(int i11, int i12);

    @NonNull
    public AutoScrollHelper k(int i11) {
        this.f8040i = i11;
        return this;
    }

    @NonNull
    public AutoScrollHelper l(int i11) {
        this.f8039h = i11;
        return this;
    }

    public AutoScrollHelper m(boolean z11) {
        if (this.f8048q && !z11) {
            i();
        }
        this.f8048q = z11;
        return this;
    }

    @NonNull
    public AutoScrollHelper n(float f11, float f12) {
        float[] fArr = this.f8038g;
        fArr[0] = f11;
        fArr[1] = f12;
        return this;
    }

    @NonNull
    public AutoScrollHelper o(float f11, float f12) {
        float[] fArr = this.f8043l;
        fArr[0] = f11 / 1000.0f;
        fArr[1] = f12 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f8048q) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                i();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    i();
                }
            }
            return this.f8049r && this.f8047p;
        }
        this.f8046o = true;
        this.f8044m = false;
        this.f8033a.l(d(0, motionEvent.getX(), view.getWidth(), this.f8035c.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.f8035c.getHeight()));
        if (!this.f8047p && u()) {
            v();
        }
        if (this.f8049r) {
            return false;
        }
    }

    @NonNull
    public AutoScrollHelper p(float f11, float f12) {
        float[] fArr = this.f8042k;
        fArr[0] = f11 / 1000.0f;
        fArr[1] = f12 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper q(int i11) {
        this.f8033a.j(i11);
        return this;
    }

    @NonNull
    public AutoScrollHelper r(int i11) {
        this.f8033a.k(i11);
        return this;
    }

    @NonNull
    public AutoScrollHelper s(float f11, float f12) {
        float[] fArr = this.f8037f;
        fArr[0] = f11;
        fArr[1] = f12;
        return this;
    }

    @NonNull
    public AutoScrollHelper t(float f11, float f12) {
        float[] fArr = this.f8041j;
        fArr[0] = f11 / 1000.0f;
        fArr[1] = f12 / 1000.0f;
        return this;
    }

    public boolean u() {
        a aVar = this.f8033a;
        int iF = aVar.f();
        int iD = aVar.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }

    public final void v() {
        int i11;
        if (this.f8036d == null) {
            this.f8036d = new ScrollAnimationRunnable();
        }
        this.f8047p = true;
        this.f8045n = true;
        if (this.f8044m || (i11 = this.f8040i) <= 0) {
            this.f8036d.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.f8035c, this.f8036d, i11);
        }
        this.f8044m = true;
    }
}
