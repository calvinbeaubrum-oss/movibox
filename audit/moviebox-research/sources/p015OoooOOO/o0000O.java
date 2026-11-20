package p015OoooOOO;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.cloud.tmc.miniapp.R$styleable;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.MiniRefreshState;
import com.google.logging.type.LogSeverity;
import p0.f;
import p0.i;
import p017OoooOo0.Oooo000;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class o0000O extends Oooo000 implements f {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public boolean f329OooO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public int f330OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public boolean f331OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public int f332OooO0o0;
    public boolean OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public boolean f333OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public Path f334OooOO0;
    public Paint OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public int f335OooOO0o;
    public int OooOOO;
    public int OooOOO0;
    public int OooOOOO;
    public float OooOOOo;
    public float OooOOo;
    public float OooOOo0;
    public float OooOOoo;
    public Animator OooOo;
    public float OooOo0;
    public int OooOo00;
    public float OooOo0O;
    public float OooOo0o;
    public RectF OooOoO0;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f336a;

        static {
            int[] iArr = new int[MiniRefreshState.values().length];
            f336a = iArr;
            try {
                iArr[MiniRefreshState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f336a[MiniRefreshState.PULL_DOWN_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f337a;

        public b(byte b11) {
            this.f337a = b11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b11 = this.f337a;
            if (b11 == 0) {
                o0000O.this.OooOo0o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b11) {
                o0000O o0000o = o0000O.this;
                if (o0000o.f333OooO0oo) {
                    valueAnimator.cancel();
                    return;
                }
                o0000o.OooOOO0 = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
            } else if (2 == b11) {
                o0000O.this.OooOOOo = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b11) {
                o0000O.this.OooOOoo = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b11) {
                o0000O.this.OooOo00 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            o0000O.this.invalidate();
        }
    }

    public o0000O(Context context, AttributeSet attributeSet) {
        super(context, null, 0);
        this.f329OooO = false;
        this.OooOOO = -1;
        this.OooOOOO = 0;
        this.OooOo00 = 0;
        this.OooOo0 = 0.0f;
        this.OooOo0O = 0.0f;
        this.OooOo0o = 0.0f;
        this.OooOoO0 = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.OooO0O0 = s0.b.f75912e;
        this.f334OooOO0 = new Path();
        Paint paint = new Paint();
        this.OooOO0O = paint;
        paint.setAntiAlias(true);
        this.OooOOo = x0.b.a(7.0f);
        this.OooOo0 = x0.b.a(20.0f);
        this.OooOo0O = x0.b.a(7.0f);
        this.OooOO0O.setStrokeWidth(x0.b.a(3.0f));
        setMinimumHeight(x0.b.a(100.0f));
        if (isInEditMode()) {
            this.f335OooOO0o = 1000;
            this.OooOo0o = 1.0f;
            this.OooOo00 = 270;
        } else {
            this.OooOo0o = 0.0f;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R$styleable.MiniBezierRadarHeader);
        this.f329OooO = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniBezierRadarHeader_srlEnableHorizontalDrag, this.f329OooO);
        OooO00o(typedArrayObtainStyledAttributes.getColor(R$styleable.MiniBezierRadarHeader_srlAccentColor, -1));
        OooO0O0(typedArrayObtainStyledAttributes.getColor(R$styleable.MiniBezierRadarHeader_srlPrimaryColor, -14540254));
        this.OooO0oO = typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniBezierRadarHeader_srlAccentColor);
        this.f331OooO0o = typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniBezierRadarHeader_srlPrimaryColor);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public int OooO00o(@NonNull i iVar, boolean z11) {
        Animator animator = this.OooOo;
        if (animator != null) {
            animator.removeAllListeners();
            this.OooOo.end();
            this.OooOo = null;
        }
        int width = getWidth();
        int i11 = this.OooOOOO;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.OooOo0, (float) Math.sqrt(((double) ((i11 * i11) + (width * width))) * 1.0d));
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.addUpdateListener(new b((byte) 3));
        valueAnimatorOfFloat.start();
        return LogSeverity.WARNING_VALUE;
    }

    public o0000O OooO00o(int i11) {
        this.f330OooO0Oo = i11;
        this.OooO0oO = true;
        return this;
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void OooO00o(float f11, int i11, int i12) {
        this.OooOOO = i11;
        invalidate();
    }

    @Override // p017OoooOo0.Oooo000, w0.d
    public void OooO00o(@NonNull i iVar, @NonNull MiniRefreshState miniRefreshState, @NonNull MiniRefreshState miniRefreshState2) {
        int i11 = a.f336a[miniRefreshState2.ordinal()];
        if (i11 == 1 || i11 == 2) {
            this.OooOOOo = 1.0f;
            this.OooOo0o = 0.0f;
            this.OooOOoo = 0.0f;
        }
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void OooO00o(boolean z11, float f11, int i11, int i12, int i13) {
        this.OooOOOO = i11;
        if (z11 || this.f333OooO0oo) {
            this.f333OooO0oo = true;
            this.f335OooOO0o = Math.min(i12, i11);
            this.OooOOO0 = (int) (Math.max(0, i11 - i12) * 1.9f);
            this.OooOOo0 = f11;
            invalidate();
        }
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public boolean OooO00o() {
        return this.f329OooO;
    }

    public o0000O OooO0O0(int i11) {
        this.f332OooO0o0 = i11;
        this.f331OooO0o = true;
        return this;
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void OooO0O0(@NonNull i iVar, int i11, int i12) {
        this.f335OooOO0o = i11 - 1;
        this.f333OooO0oo = false;
        x0.b bVar = new x0.b(1);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(bVar);
        valueAnimatorOfFloat.addUpdateListener(new b((byte) 2));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(bVar);
        valueAnimatorOfFloat2.addUpdateListener(new b((byte) 0));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 360);
        valueAnimatorOfInt.setDuration(720L);
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new b((byte) 4));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfInt);
        animatorSet.start();
        int i13 = this.OooOOO0;
        float f11 = i13;
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(i13, 0, -((int) (0.8f * f11)), 0, -((int) (f11 * 0.4f)), 0);
        valueAnimatorOfInt2.addUpdateListener(new b((byte) 1));
        valueAnimatorOfInt2.setInterpolator(new x0.b(1));
        valueAnimatorOfInt2.setDuration(800L);
        valueAnimatorOfInt2.start();
        this.OooOo = animatorSet;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f11;
        int width = getWidth();
        int height = isInEditMode() ? getHeight() : this.OooOOOO;
        this.f334OooOO0.reset();
        this.f334OooOO0.lineTo(0.0f, this.f335OooOO0o);
        Path path = this.f334OooOO0;
        int i11 = this.OooOOO;
        float f12 = i11 >= 0 ? i11 : width / 2.0f;
        int i12 = this.f335OooOO0o;
        float f13 = width;
        path.quadTo(f12, this.OooOOO0 + i12, f13, i12);
        this.f334OooOO0.lineTo(f13, 0.0f);
        this.OooOO0O.setColor(this.f332OooO0o0);
        canvas.drawPath(this.f334OooOO0, this.OooOO0O);
        if (this.OooOOOo > 0.0f) {
            this.OooOO0O.setColor(this.f330OooO0Oo);
            float f14 = height;
            float f15 = f14 / x0.b.f79782b;
            float f16 = (f13 * 1.0f) / 7.0f;
            float f17 = this.OooOOo0;
            float f18 = (f16 * f17) - (f17 > 1.0f ? ((f17 - 1.0f) * f16) / f17 : 0.0f);
            float f19 = f14 - (f17 > 1.0f ? (((f17 - 1.0f) * f14) / 2.0f) / f17 : 0.0f);
            int i13 = 0;
            while (i13 < 7) {
                int i14 = i13 + 1;
                int i15 = i13 - 3;
                float f21 = f13;
                this.OooOO0O.setAlpha((int) ((1.0d - (1.0d / Math.pow((((double) f15) / 800.0d) + 1.0d, 15.0d))) * ((double) (this.OooOOOo * ((float) ((1.0d - ((((double) Math.abs(i15)) / 7.0d) * 2.0d)) * 255.0d))))));
                float f22 = (1.0f - (1.0f / ((f15 / 10.0f) + 1.0f))) * this.OooOOo;
                canvas.drawCircle((i15 * f18) + ((f21 / 2.0f) - (f22 / 2.0f)), f19 / 2.0f, f22, this.OooOO0O);
                i13 = i14;
                f13 = f21;
            }
            f11 = f13;
            this.OooOO0O.setAlpha(255);
        } else {
            f11 = f13;
        }
        if (this.OooOo != null || isInEditMode()) {
            float f23 = this.OooOo0;
            float f24 = this.OooOo0o;
            float f25 = f23 * f24;
            float f26 = this.OooOo0O * f24;
            this.OooOO0O.setColor(this.f330OooO0Oo);
            Paint paint = this.OooOO0O;
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            float f27 = f11 / 2.0f;
            float f28 = height / 2.0f;
            canvas.drawCircle(f27, f28, f25, this.OooOO0O);
            Paint paint2 = this.OooOO0O;
            Paint.Style style2 = Paint.Style.STROKE;
            paint2.setStyle(style2);
            float f29 = f25 + f26;
            canvas.drawCircle(f27, f28, f29, this.OooOO0O);
            this.OooOO0O.setColor((this.f332OooO0o0 & 16777215) | 1426063360);
            this.OooOO0O.setStyle(style);
            this.OooOoO0.set(f27 - f25, f28 - f25, f27 + f25, f25 + f28);
            canvas.drawArc(this.OooOoO0, 270.0f, this.OooOo00, true, this.OooOO0O);
            this.OooOO0O.setStyle(style2);
            this.OooOoO0.set(f27 - f29, f28 - f29, f27 + f29, f28 + f29);
            canvas.drawArc(this.OooOoO0, 270.0f, this.OooOo00, false, this.OooOO0O);
            this.OooOO0O.setStyle(style);
        }
        if (this.OooOOoo > 0.0f) {
            this.OooOO0O.setColor(this.f330OooO0Oo);
            canvas.drawCircle(f11 / 2.0f, height / 2.0f, this.OooOOoo, this.OooOO0O);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.OooOo;
        if (animator != null) {
            animator.removeAllListeners();
            this.OooOo.end();
            this.OooOo = null;
        }
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0 && !this.f331OooO0o) {
            this.f332OooO0o0 = iArr[0];
            this.f331OooO0o = false;
        }
        if (iArr.length <= 1 || this.OooO0oO) {
            return;
        }
        this.f330OooO0Oo = iArr[1];
        this.OooO0oO = false;
    }
}
