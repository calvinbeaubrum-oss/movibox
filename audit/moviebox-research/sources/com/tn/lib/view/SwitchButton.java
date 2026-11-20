package com.tn.lib.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.tn.lib.widget.R$style;
import com.tn.lib.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class SwitchButton extends View implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f49615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f49616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49618d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f49619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f49620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f49621h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f49622i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f49623j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f49624k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RectF f49625l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f49626m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f49627n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f49628o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public State f49629p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f49630q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f49631r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f49632s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f49633t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f49634u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f49635v;

    /* JADX INFO: compiled from: source.java */
    public enum State {
        OPEN,
        CLOSE
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwitchButton.this.f49628o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SwitchButton.this.postInvalidate();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwitchButton.this.f49616b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SwitchButton.this.f49620g.setColor(SwitchButton.this.f49616b);
            SwitchButton.this.postInvalidate();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwitchButton.this.setClickable(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwitchButton.this.setClickable(false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(SwitchButton switchButton, boolean z11);
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f49624k = 10.0f;
        this.f49635v = true;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SwitchView, i11, R$style.def_switch_view);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i12 = 0; i12 < indexCount; i12++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i12);
            if (index == R$styleable.SwitchView_switch_bg_color) {
                this.f49616b = typedArrayObtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            } else if (index == R$styleable.SwitchView_switch_ball_color) {
                this.f49618d = typedArrayObtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            } else if (index == R$styleable.SwitchView_switch_checked_bg_color) {
                this.f49617c = typedArrayObtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            } else if (index == R$styleable.SwitchView_switch_radius) {
                this.f49624k = typedArrayObtainStyledAttributes.getInteger(index, 10);
            } else if (index == R$styleable.SwitchView_switch_gradient_start_color) {
                this.f49633t = typedArrayObtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            } else if (index == R$styleable.SwitchView_switch_gradient_end_color) {
                this.f49634u = typedArrayObtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        i();
    }

    public final void e(int i11, int i12, int i13, int i14) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(i11, i12);
        valueAnimatorOfFloat.addUpdateListener(new a());
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i13), Integer.valueOf(i14));
        valueAnimatorOfObject.addUpdateListener(new b());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfObject);
        animatorSet.setDuration(50L);
        animatorSet.addListener(new c());
        animatorSet.start();
    }

    public final Paint f(int i11, int i12, Paint.Style style, int i13) {
        Paint paint = new Paint(1);
        paint.setColor(i11);
        paint.setStrokeWidth(i13);
        paint.setDither(true);
        paint.setTextSize(i12);
        paint.setStyle(style);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        return paint;
    }

    public final void g(Canvas canvas) {
        this.f49619f.setColor(this.f49618d);
        canvas.drawCircle(this.f49628o, this.f49623j, this.f49624k, this.f49619f);
    }

    public final void h(Canvas canvas) {
        if (this.f49629p != State.OPEN) {
            RectF rectF = this.f49625l;
            int i11 = this.f49623j;
            canvas.drawRoundRect(rectF, i11, i11, this.f49620g);
        } else {
            Paint paint = new Paint();
            paint.setShader(new LinearGradient(0.0f, 0.0f, this.f49622i, 0.0f, this.f49633t, this.f49634u, Shader.TileMode.CLAMP));
            RectF rectF2 = this.f49625l;
            int i12 = this.f49623j;
            canvas.drawRoundRect(rectF2, i12, i12, paint);
        }
    }

    public final void i() {
        this.f49631r = this.f49616b;
        this.f49632s = this.f49617c;
        int i11 = this.f49618d;
        Paint.Style style = Paint.Style.FILL;
        this.f49619f = f(i11, 0, style, 0);
        this.f49620g = f(this.f49616b, 0, style, 0);
        this.f49629p = State.CLOSE;
        setOnClickListener(this);
        this.f49620g.setColor(this.f49616b);
        this.f49624k = tp.f.f77260a.a(getContext(), this.f49624k);
    }

    public boolean isChecked() {
        return this.f49627n;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f49635v) {
            State state = this.f49629p;
            State state2 = State.CLOSE;
            State state3 = state == state2 ? State.OPEN : state2;
            this.f49629p = state3;
            if (state3 == state2) {
                e(this.f49626m, this.f49623j, this.f49632s, this.f49631r);
            } else {
                e(this.f49623j, this.f49626m, this.f49631r, this.f49632s);
            }
            d dVar = this.f49630q;
            if (dVar != null) {
                dVar.a(this, this.f49629p == State.OPEN);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        h(canvas);
        g(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 44.0f, getResources().getDisplayMetrics()), 1073741824);
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            i12 = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()), 1073741824);
        }
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        this.f49621h = i12;
        this.f49622i = i11;
        this.f49615a = (i11 * 1.0f) / 30.0f;
        int i15 = i12 / 2;
        this.f49623j = i15;
        int i16 = i11 - i15;
        this.f49626m = i16;
        this.f49628o = this.f49627n ? i16 : i15;
        this.f49625l = new RectF(0.0f, 0.0f, this.f49622i, this.f49621h);
    }

    public void setChecked(boolean z11) {
        this.f49627n = z11;
        State state = z11 ? State.OPEN : State.CLOSE;
        if (this.f49629p == state) {
            return;
        }
        this.f49629p = state;
        if (z11 && this.f49626m == 0) {
            this.f49628o = tp.f.f77260a.a(getContext(), 32.0f);
            int i11 = this.f49632s;
            this.f49616b = i11;
            this.f49620g.setColor(i11);
            postInvalidate();
        } else if (state == State.CLOSE) {
            e(this.f49626m, this.f49623j, this.f49632s, this.f49631r);
        } else {
            e(this.f49623j, this.f49626m, this.f49631r, this.f49632s);
        }
        d dVar = this.f49630q;
        if (dVar != null) {
            dVar.a(this, this.f49629p == State.OPEN);
        }
    }

    public void setColor(Integer num, Integer num2, Integer num3) {
        this.f49631r = num.intValue();
        this.f49632s = num2.intValue();
        this.f49618d = num3.intValue();
        this.f49619f.setColor(num3.intValue());
        postInvalidate();
    }

    public void setEnable(boolean z11) {
        this.f49635v = z11;
    }

    public void setGradientColors(int i11, int i12, Integer num) {
        this.f49633t = i11;
        this.f49634u = i12;
        this.f49618d = num.intValue();
        postInvalidate();
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.f49630q = dVar;
    }
}
