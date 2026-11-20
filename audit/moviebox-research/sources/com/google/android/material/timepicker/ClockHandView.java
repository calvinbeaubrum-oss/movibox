package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeInterpolator f37881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ValueAnimator f37882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f37883d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f37884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f37885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f37886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f37887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f37888j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<c> f37889k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f37890l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f37891m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f37892n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f37893o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f37894p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f37895q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f37896r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b f37897s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public double f37898t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f37899u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f37900v;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(float f11, boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void d(float f11, boolean z11);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f37882c = new ValueAnimator();
        this.f37889k = new ArrayList();
        Paint paint = new Paint();
        this.f37892n = paint;
        this.f37893o = new RectF();
        this.f37900v = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, i11, R$style.Widget_MaterialComponents_TimePicker_Clock);
        this.f37880a = ti.j.f(context, R$attr.motionDurationLong2, 200);
        this.f37881b = ti.j.g(context, R$attr.motionEasingEmphasizedInterpolator, ii.b.f67202b);
        this.f37899u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_materialCircleRadius, 0);
        this.f37890l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.f37894p = resources.getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.f37891m = resources.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        q(0.0f);
        this.f37887i = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void b(c cVar) {
        this.f37889k.add(cVar);
    }

    public final void c(float f11, float f12) {
        this.f37900v = si.a.a((float) (getWidth() / 2), (float) (getHeight() / 2), f11, f12) > ((float) i(2)) + f0.g(getContext(), 12) ? 1 : 2;
    }

    public final void d(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int i11 = i(this.f37900v);
        float f11 = width;
        float f12 = i11;
        float fCos = (((float) Math.cos(this.f37898t)) * f12) + f11;
        float f13 = height;
        float fSin = (f12 * ((float) Math.sin(this.f37898t))) + f13;
        this.f37892n.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f37890l, this.f37892n);
        double dSin = Math.sin(this.f37898t);
        double dCos = Math.cos(this.f37898t);
        double d11 = i11 - this.f37890l;
        this.f37892n.setStrokeWidth(this.f37894p);
        canvas.drawLine(f11, f13, width + ((int) (dCos * d11)), height + ((int) (d11 * dSin)), this.f37892n);
        canvas.drawCircle(f11, f13, this.f37891m, this.f37892n);
    }

    public int e() {
        return this.f37900v;
    }

    public RectF f() {
        return this.f37893o;
    }

    public final int g(float f11, float f12) {
        int degrees = (int) Math.toDegrees(Math.atan2(f12 - (getHeight() / 2), f11 - (getWidth() / 2)));
        int i11 = degrees + 90;
        return i11 < 0 ? degrees + 450 : i11;
    }

    public float h() {
        return this.f37895q;
    }

    public final int i(int i11) {
        return i11 == 2 ? Math.round(this.f37899u * 0.66f) : this.f37899u;
    }

    public int j() {
        return this.f37890l;
    }

    public final Pair<Float, Float> k(float f11) {
        float fH = h();
        if (Math.abs(fH - f11) > 180.0f) {
            if (fH > 180.0f && f11 < 180.0f) {
                f11 += 360.0f;
            }
            if (fH < 180.0f && f11 > 180.0f) {
                fH += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(fH), Float.valueOf(f11));
    }

    public final boolean l(float f11, float f12, boolean z11, boolean z12, boolean z13) {
        float fG = g(f11, f12);
        boolean z14 = false;
        boolean z15 = h() != fG;
        if (z12 && z15) {
            return true;
        }
        if (!z15 && !z11) {
            return false;
        }
        if (z13 && this.f37883d) {
            z14 = true;
        }
        r(fG, z14);
        return true;
    }

    public final /* synthetic */ void m(ValueAnimator valueAnimator) {
        s(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    public void n(boolean z11) {
        this.f37883d = z11;
    }

    public void o(int i11) {
        this.f37899u = i11;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.f37882c.isRunning()) {
            return;
        }
        q(h());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        boolean z12;
        boolean z13;
        b bVar;
        int actionMasked = motionEvent.getActionMasked();
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i11 = (int) (x11 - this.f37884f);
                int i12 = (int) (y11 - this.f37885g);
                this.f37886h = (i11 * i11) + (i12 * i12) > this.f37887i;
                boolean z14 = this.f37896r;
                z11 = actionMasked == 1;
                if (this.f37888j) {
                    c(x11, y11);
                }
                z12 = z14;
            } else {
                z11 = false;
                z12 = false;
            }
            z13 = false;
        } else {
            this.f37884f = x11;
            this.f37885g = y11;
            this.f37886h = true;
            this.f37896r = false;
            z11 = false;
            z12 = false;
            z13 = true;
        }
        boolean zL = l(x11, y11, z12, z13, z11) | this.f37896r;
        this.f37896r = zL;
        if (zL && z11 && (bVar = this.f37897s) != null) {
            bVar.a(g(x11, y11), this.f37886h);
        }
        return true;
    }

    public void p(int i11) {
        this.f37900v = i11;
        invalidate();
    }

    public void q(float f11) {
        r(f11, false);
    }

    public void r(float f11, boolean z11) {
        ValueAnimator valueAnimator = this.f37882c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z11) {
            s(f11, false);
            return;
        }
        Pair<Float, Float> pairK = k(f11);
        this.f37882c.setFloatValues(((Float) pairK.first).floatValue(), ((Float) pairK.second).floatValue());
        this.f37882c.setDuration(this.f37880a);
        this.f37882c.setInterpolator(this.f37881b);
        this.f37882c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f37946a.m(valueAnimator2);
            }
        });
        this.f37882c.addListener(new a());
        this.f37882c.start();
    }

    public final void s(float f11, boolean z11) {
        float f12 = f11 % 360.0f;
        this.f37895q = f12;
        this.f37898t = Math.toRadians(f12 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fI = i(this.f37900v);
        float fCos = width + (((float) Math.cos(this.f37898t)) * fI);
        float fSin = height + (fI * ((float) Math.sin(this.f37898t)));
        RectF rectF = this.f37893o;
        int i11 = this.f37890l;
        rectF.set(fCos - i11, fSin - i11, fCos + i11, fSin + i11);
        Iterator<c> it = this.f37889k.iterator();
        while (it.hasNext()) {
            it.next().d(f12, z11);
        }
        invalidate();
    }

    public void t(boolean z11) {
        if (this.f37888j && !z11) {
            this.f37900v = 1;
        }
        this.f37888j = z11;
        invalidate();
    }

    public void u(b bVar) {
        this.f37897s = bVar;
    }
}
