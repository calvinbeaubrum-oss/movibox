package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.core.util.i;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends Drawable implements Animatable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Interpolator f13039h = new LinearInterpolator();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Interpolator f13040i = new q3.b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f13041j = {ViewCompat.MEASURED_STATE_MASK};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f13042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Resources f13044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Animator f13045d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f13046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13047g;

    /* JADX INFO: compiled from: source.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f13048a;

        public a(c cVar) {
            this.f13048a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.n(fFloatValue, this.f13048a);
            b.this.b(fFloatValue, this.f13048a, false);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0121b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f13050a;

        public C0121b(c cVar) {
            this.f13050a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.b(1.0f, this.f13050a, true);
            this.f13050a.A();
            this.f13050a.l();
            b bVar = b.this;
            if (!bVar.f13047g) {
                bVar.f13046f += 1.0f;
                return;
            }
            bVar.f13047g = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f13050a.x(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f13046f = 0.0f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f13052a = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f13053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f13054c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Paint f13055d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f13056e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f13057f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f13058g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f13059h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int[] f13060i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f13061j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f13062k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f13063l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f13064m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f13065n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Path f13066o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f13067p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f13068q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f13069r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f13070s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f13071t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f13072u;

        public c() {
            Paint paint = new Paint();
            this.f13053b = paint;
            Paint paint2 = new Paint();
            this.f13054c = paint2;
            Paint paint3 = new Paint();
            this.f13055d = paint3;
            this.f13056e = 0.0f;
            this.f13057f = 0.0f;
            this.f13058g = 0.0f;
            this.f13059h = 5.0f;
            this.f13067p = 1.0f;
            this.f13071t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public void A() {
            this.f13062k = this.f13056e;
            this.f13063l = this.f13057f;
            this.f13064m = this.f13058g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f13052a;
            float f11 = this.f13068q;
            float fMin = (this.f13059h / 2.0f) + f11;
            if (f11 <= 0.0f) {
                fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f13069r * this.f13067p) / 2.0f, this.f13059h / 2.0f);
            }
            rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
            float f12 = this.f13056e;
            float f13 = this.f13058g;
            float f14 = (f12 + f13) * 360.0f;
            float f15 = ((this.f13057f + f13) * 360.0f) - f14;
            this.f13053b.setColor(this.f13072u);
            this.f13053b.setAlpha(this.f13071t);
            float f16 = this.f13059h / 2.0f;
            rectF.inset(f16, f16);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f13055d);
            float f17 = -f16;
            rectF.inset(f17, f17);
            canvas.drawArc(rectF, f14, f15, false, this.f13053b);
            b(canvas, f14, f15, rectF);
        }

        public void b(Canvas canvas, float f11, float f12, RectF rectF) {
            if (this.f13065n) {
                Path path = this.f13066o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f13066o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f13 = (this.f13069r * this.f13067p) / 2.0f;
                this.f13066o.moveTo(0.0f, 0.0f);
                this.f13066o.lineTo(this.f13069r * this.f13067p, 0.0f);
                Path path3 = this.f13066o;
                float f14 = this.f13069r;
                float f15 = this.f13067p;
                path3.lineTo((f14 * f15) / 2.0f, this.f13070s * f15);
                this.f13066o.offset((fMin + rectF.centerX()) - f13, rectF.centerY() + (this.f13059h / 2.0f));
                this.f13066o.close();
                this.f13054c.setColor(this.f13072u);
                this.f13054c.setAlpha(this.f13071t);
                canvas.save();
                canvas.rotate(f11 + f12, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f13066o, this.f13054c);
                canvas.restore();
            }
        }

        public int c() {
            return this.f13071t;
        }

        public float d() {
            return this.f13057f;
        }

        public int e() {
            return this.f13060i[f()];
        }

        public int f() {
            return (this.f13061j + 1) % this.f13060i.length;
        }

        public float g() {
            return this.f13056e;
        }

        public int h() {
            return this.f13060i[this.f13061j];
        }

        public float i() {
            return this.f13063l;
        }

        public float j() {
            return this.f13064m;
        }

        public float k() {
            return this.f13062k;
        }

        public void l() {
            t(f());
        }

        public void m() {
            this.f13062k = 0.0f;
            this.f13063l = 0.0f;
            this.f13064m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        public void n(int i11) {
            this.f13071t = i11;
        }

        public void o(float f11, float f12) {
            this.f13069r = (int) f11;
            this.f13070s = (int) f12;
        }

        public void p(float f11) {
            if (f11 != this.f13067p) {
                this.f13067p = f11;
            }
        }

        public void q(float f11) {
            this.f13068q = f11;
        }

        public void r(int i11) {
            this.f13072u = i11;
        }

        public void s(ColorFilter colorFilter) {
            this.f13053b.setColorFilter(colorFilter);
        }

        public void t(int i11) {
            this.f13061j = i11;
            this.f13072u = this.f13060i[i11];
        }

        public void u(@NonNull int[] iArr) {
            this.f13060i = iArr;
            t(0);
        }

        public void v(float f11) {
            this.f13057f = f11;
        }

        public void w(float f11) {
            this.f13058g = f11;
        }

        public void x(boolean z11) {
            if (this.f13065n != z11) {
                this.f13065n = z11;
            }
        }

        public void y(float f11) {
            this.f13056e = f11;
        }

        public void z(float f11) {
            this.f13059h = f11;
            this.f13053b.setStrokeWidth(f11);
        }
    }

    public b(@NonNull Context context) {
        this.f13044c = ((Context) i.g(context)).getResources();
        c cVar = new c();
        this.f13042a = cVar;
        cVar.u(f13041j);
        k(2.5f);
        m();
    }

    public final void a(float f11, c cVar) {
        n(f11, cVar);
        float fFloor = (float) (Math.floor(cVar.j() / 0.8f) + 1.0d);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f11));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((fFloor - cVar.j()) * f11));
    }

    public void b(float f11, c cVar, boolean z11) {
        float interpolation;
        float interpolation2;
        if (this.f13047g) {
            a(f11, cVar);
            return;
        }
        if (f11 != 1.0f || z11) {
            float fJ = cVar.j();
            if (f11 < 0.5f) {
                interpolation = cVar.k();
                interpolation2 = (f13040i.getInterpolation(f11 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float fK = cVar.k() + 0.79f;
                interpolation = fK - (((1.0f - f13040i.getInterpolation((f11 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = fK;
            }
            float f12 = fJ + (0.20999998f * f11);
            float f13 = (f11 + this.f13046f) * 216.0f;
            cVar.y(interpolation);
            cVar.v(interpolation2);
            cVar.w(f12);
            h(f13);
        }
    }

    public final int c(float f11, int i11, int i12) {
        int i13 = (i11 >> 24) & 255;
        int i14 = (i11 >> 16) & 255;
        int i15 = (i11 >> 8) & 255;
        int i16 = i11 & 255;
        return ((i13 + ((int) ((((i12 >> 24) & 255) - i13) * f11))) << 24) | ((i14 + ((int) ((((i12 >> 16) & 255) - i14) * f11))) << 16) | ((i15 + ((int) ((((i12 >> 8) & 255) - i15) * f11))) << 8) | (i16 + ((int) (f11 * ((i12 & 255) - i16))));
    }

    public void d(boolean z11) {
        this.f13042a.x(z11);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f13043b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f13042a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f11) {
        this.f13042a.p(f11);
        invalidateSelf();
    }

    public void f(@NonNull int... iArr) {
        this.f13042a.u(iArr);
        this.f13042a.t(0);
        invalidateSelf();
    }

    public void g(float f11) {
        this.f13042a.w(f11);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f13042a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(float f11) {
        this.f13043b = f11;
    }

    public final void i(float f11, float f12, float f13, float f14) {
        c cVar = this.f13042a;
        float f15 = this.f13044c.getDisplayMetrics().density;
        cVar.z(f12 * f15);
        cVar.q(f11 * f15);
        cVar.t(0);
        cVar.o(f13 * f15, f14 * f15);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f13045d.isRunning();
    }

    public void j(float f11, float f12) {
        this.f13042a.y(f11);
        this.f13042a.v(f12);
        invalidateSelf();
    }

    public void k(float f11) {
        this.f13042a.z(f11);
        invalidateSelf();
    }

    public void l(int i11) {
        if (i11 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void m() {
        c cVar = this.f13042a;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(cVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f13039h);
        valueAnimatorOfFloat.addListener(new C0121b(cVar));
        this.f13045d = valueAnimatorOfFloat;
    }

    public void n(float f11, c cVar) {
        if (f11 > 0.75f) {
            cVar.r(c((f11 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f13042a.n(i11);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13042a.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f13045d.cancel();
        this.f13042a.A();
        if (this.f13042a.d() != this.f13042a.g()) {
            this.f13047g = true;
            this.f13045d.setDuration(666L);
            this.f13045d.start();
        } else {
            this.f13042a.t(0);
            this.f13042a.m();
            this.f13045d.setDuration(1332L);
            this.f13045d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f13045d.cancel();
        h(0.0f);
        this.f13042a.x(false);
        this.f13042a.t(0);
        this.f13042a.m();
        invalidateSelf();
    }
}
