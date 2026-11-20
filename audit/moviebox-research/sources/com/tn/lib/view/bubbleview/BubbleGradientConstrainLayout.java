package com.tn.lib.view.bubbleview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BubbleGradientConstrainLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f49746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BubbleDrawable f49747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f49748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49749d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f49750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f49751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f49752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f49753i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f49754j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f49755k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BubbleDrawable.ArrowLocation f49756l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BubbleDrawable.GradientDirection f49757m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f49758n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f49759o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f49760p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float[] f49761q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f49762r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f49763s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f49764t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ObjectAnimator f49765u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ObjectAnimator f49766v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AnimatorSet f49767w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f49768x;

    /* JADX INFO: compiled from: source.java */
    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f49769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f49770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f49771c;

        public a(float f11, ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            this.f49769a = f11;
            this.f49770b = marginLayoutParams;
            this.f49771c = i11;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            BubbleGradientConstrainLayout.this.setX(this.f49769a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.f49770b;
            marginLayoutParams.leftMargin = this.f49771c;
            BubbleGradientConstrainLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BubbleGradientConstrainLayout.this.setX(this.f49769a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.f49770b;
            marginLayoutParams.leftMargin = this.f49771c;
            BubbleGradientConstrainLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public BubbleGradientConstrainLayout(Context context) {
        super(context);
        this.f49746a = "BubbleGradientLinearLayout";
        f(null);
    }

    public BubbleGradientConstrainLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49746a = "BubbleGradientLinearLayout";
        f(attributeSet);
    }

    public static int c(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void f(AttributeSet attributeSet) {
        setLayerType(1, null);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f49748c = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowRadius, BubbleDrawable.b.A);
            this.f49749d = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_shadowColor, BubbleDrawable.b.B);
            this.f49750f = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetX, BubbleDrawable.b.C);
            this.f49751g = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetY, BubbleDrawable.b.C);
            this.f49752h = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f49708u);
            this.f49754j = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f49709v);
            this.f49753i = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f49710w);
            this.f49755k = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f49711x);
            this.f49758n = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_bubbleColor, BubbleDrawable.b.f49712y);
            this.f49762r = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_gradientStartColor, BubbleDrawable.b.f49712y);
            this.f49763s = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_gradientEndColor, BubbleDrawable.b.f49712y);
            this.f49764t = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_gradientCenterColor, -1);
            this.f49768x = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BubbleView_isOpenAnimator, false);
            this.f49756l = BubbleDrawable.ArrowLocation.mapIntToValue(typedArrayObtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f49757m = BubbleDrawable.GradientDirection.mapIntToValue(typedArrayObtainStyledAttributes.getInt(R$styleable.BubbleView_gradient_orientation, 0));
            this.f49759o = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            typedArrayObtainStyledAttributes.recycle();
            int i11 = this.f49764t;
            if (i11 > 0) {
                this.f49760p = new int[]{this.f49762r, i11, this.f49763s};
            } else {
                this.f49760p = new int[]{this.f49762r, this.f49763s};
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i11, int i12) {
        i((int) ((getPaddingLeft() + this.f49748c) - this.f49750f), (int) (((i11 - getPaddingRight()) - this.f49748c) - this.f49750f), (int) ((getPaddingTop() + this.f49748c) - this.f49751g), (int) (((i12 - getPaddingBottom()) - this.f49748c) - this.f49751g));
        setBackgroundDrawable(this.f49747b);
    }

    private void i(int i11, int i12, int i13, int i14) {
        if (i12 < i11 || i14 < i13) {
            return;
        }
        RectF rectF = new RectF(i11, i13, i12, i14);
        this.f49761q = e(this.f49757m);
        BubbleDrawable.b bVarU = new BubbleDrawable.b().B(rectF).t(this.f49756l).z(BubbleDrawable.BubbleType.SHADER).q(this.f49753i).s(this.f49754j).v(this.f49752h).u(this.f49755k);
        float[] fArr = this.f49761q;
        this.f49747b = bVarU.y(fArr[0], fArr[1], fArr[2], fArr[3], this.f49760p).r(this.f49759o).F(this.f49748c).C(this.f49749d).D(this.f49750f).E(this.f49751g).A();
    }

    public final void b() {
        ObjectAnimator objectAnimator = this.f49765u;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.f49765u.cancel();
    }

    public final float[] e(BubbleDrawable.GradientDirection gradientDirection) {
        return gradientDirection == BubbleDrawable.GradientDirection.getDefault() ? new float[]{0.0f, 0.0f, 0.0f, getHeight()} : new float[]{0.0f, 0.0f, getWidth(), 0.0f};
    }

    public final void g() {
        h(getWidth(), getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startTransAnim();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        h(i11, i12);
    }

    public void setLocation(BubbleDrawable.ArrowLocation arrowLocation) {
        this.f49756l = arrowLocation;
        h(getWidth(), getHeight());
    }

    public void setUpBubbleDrawable() {
        setBackgroundDrawable(null);
        post(new Runnable() { // from class: com.tn.lib.view.bubbleview.BubbleGradientConstrainLayout.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleGradientConstrainLayout bubbleGradientConstrainLayout = BubbleGradientConstrainLayout.this;
                bubbleGradientConstrainLayout.h(bubbleGradientConstrainLayout.getWidth(), BubbleGradientConstrainLayout.this.getHeight());
            }
        });
    }

    public void setmArrowPosition(float f11) {
        this.f49755k = f11;
        g();
    }

    public void startShowRemindAnim() {
        AnimatorSet animatorSet = this.f49767w;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f49767w = null;
        }
        this.f49767w = new AnimatorSet();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        float x11 = getX();
        int i11 = marginLayoutParams.leftMargin;
        if (this.f49766v == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "translationX", x11 - (Math.abs(i11) + c(getContext(), 4.0f)), c(getContext(), 4.0f) + x11, x11 - (Math.abs(marginLayoutParams.leftMargin) + c(getContext(), 4.0f)));
            this.f49766v = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(100L);
            this.f49766v.setInterpolator(new LinearInterpolator());
            this.f49766v.setRepeatCount(1);
            this.f49766v.addListener(new a(x11, marginLayoutParams, i11));
        }
        this.f49767w.play(this.f49766v).with(this.f49765u);
        this.f49767w.start();
    }

    public void startTransAnim() {
        if (this.f49768x) {
            if (this.f49765u == null) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "translationY", getY(), getY() - c(getContext(), 6.0f), getY());
                this.f49765u = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                this.f49765u.setInterpolator(new LinearInterpolator());
                this.f49765u.setRepeatCount(-1);
            }
            if (this.f49765u.isStarted()) {
                return;
            }
            this.f49765u.start();
        }
    }
}
