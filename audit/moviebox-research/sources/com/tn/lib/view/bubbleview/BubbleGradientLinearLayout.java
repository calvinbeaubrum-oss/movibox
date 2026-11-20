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
import android.widget.LinearLayout;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BubbleGradientLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f49773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BubbleDrawable f49774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f49775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49776d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f49777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f49778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f49779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f49780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f49781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f49782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BubbleDrawable.ArrowLocation f49783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BubbleDrawable.GradientDirection f49784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f49785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f49786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f49787p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float[] f49788q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f49789r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f49790s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f49791t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ObjectAnimator f49792u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ObjectAnimator f49793v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AnimatorSet f49794w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f49795x;

    /* JADX INFO: compiled from: source.java */
    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f49796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f49797b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f49798c;

        public a(float f11, ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            this.f49796a = f11;
            this.f49797b = marginLayoutParams;
            this.f49798c = i11;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            BubbleGradientLinearLayout.this.setX(this.f49796a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.f49797b;
            marginLayoutParams.leftMargin = this.f49798c;
            BubbleGradientLinearLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BubbleGradientLinearLayout.this.setX(this.f49796a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.f49797b;
            marginLayoutParams.leftMargin = this.f49798c;
            BubbleGradientLinearLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49800a;

        static {
            int[] iArr = new int[BubbleDrawable.GradientDirection.values().length];
            f49800a = iArr;
            try {
                iArr[BubbleDrawable.GradientDirection.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49800a[BubbleDrawable.GradientDirection.TOP_LEFT_BOTTOM_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49800a[BubbleDrawable.GradientDirection.TOP_RIGHT_BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f49800a[BubbleDrawable.GradientDirection.BOTTOM_LEFT_TOP_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f49800a[BubbleDrawable.GradientDirection.BOTTOM_RIGHT_TOP_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public BubbleGradientLinearLayout(Context context) {
        super(context);
        this.f49773a = "BubbleGradientLinearLayout";
        e(null);
    }

    public BubbleGradientLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49773a = "BubbleGradientLinearLayout";
        e(attributeSet);
    }

    public static int c(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void b() {
        ObjectAnimator objectAnimator = this.f49792u;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.f49792u.cancel();
    }

    public final float[] d(BubbleDrawable.GradientDirection gradientDirection) {
        int i11 = b.f49800a[gradientDirection.ordinal()];
        if (i11 == 1) {
            return new float[]{0.0f, 0.0f, getWidth(), 0.0f};
        }
        if (i11 == 2) {
            return new float[]{0.0f, 0.0f, getWidth(), getHeight()};
        }
        if (i11 == 3) {
            return new float[]{getWidth(), 0.0f, 0.0f, getHeight()};
        }
        if (i11 != 4) {
            return i11 != 5 ? new float[]{0.0f, 0.0f, 0.0f, getHeight()} : new float[]{getWidth(), getHeight(), 0.0f, 0.0f};
        }
        return new float[]{0.0f, getHeight(), getWidth(), 0.0f};
    }

    public final void e(AttributeSet attributeSet) {
        setLayerType(1, null);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f49775c = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowRadius, BubbleDrawable.b.A);
            this.f49776d = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_shadowColor, BubbleDrawable.b.B);
            this.f49777f = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetX, BubbleDrawable.b.C);
            this.f49778g = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetY, BubbleDrawable.b.C);
            this.f49779h = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f49708u);
            this.f49781j = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f49709v);
            this.f49780i = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f49710w);
            this.f49782k = typedArrayObtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f49711x);
            this.f49785n = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_bubbleColor, BubbleDrawable.b.f49712y);
            this.f49789r = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_gradientStartColor, BubbleDrawable.b.f49712y);
            this.f49790s = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_gradientEndColor, BubbleDrawable.b.f49712y);
            this.f49791t = typedArrayObtainStyledAttributes.getColor(R$styleable.BubbleView_gradientCenterColor, BubbleDrawable.b.f49712y);
            this.f49795x = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BubbleView_isOpenAnimator, false);
            this.f49783l = BubbleDrawable.ArrowLocation.mapIntToValue(typedArrayObtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f49784m = BubbleDrawable.GradientDirection.mapIntToValue(typedArrayObtainStyledAttributes.getInt(R$styleable.BubbleView_gradient_orientation, 0));
            this.f49786o = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            typedArrayObtainStyledAttributes.recycle();
            int i11 = this.f49791t;
            if (i11 != BubbleDrawable.b.f49712y) {
                this.f49787p = new int[]{this.f49789r, i11, this.f49790s};
            } else {
                this.f49787p = new int[]{this.f49789r, this.f49790s};
            }
        }
    }

    public final void f() {
        g(getWidth(), getHeight());
    }

    public final void g(int i11, int i12) {
        h((int) ((getPaddingLeft() + this.f49775c) - this.f49777f), (int) (((i11 - getPaddingRight()) - this.f49775c) - this.f49777f), (int) ((getPaddingTop() + this.f49775c) - this.f49778g), (int) (((i12 - getPaddingBottom()) - this.f49775c) - this.f49778g));
        setBackgroundDrawable(this.f49774b);
    }

    public final void h(int i11, int i12, int i13, int i14) {
        if (i12 < i11 || i14 < i13) {
            return;
        }
        RectF rectF = new RectF(i11, i13, i12, i14);
        this.f49788q = d(this.f49784m);
        BubbleDrawable.b bVarU = new BubbleDrawable.b().B(rectF).t(this.f49783l).z(BubbleDrawable.BubbleType.SHADER).q(this.f49780i).s(this.f49781j).v(this.f49779h).u(this.f49782k);
        float[] fArr = this.f49788q;
        this.f49774b = bVarU.y(fArr[0], fArr[1], fArr[2], fArr[3], this.f49787p).r(this.f49786o).F(this.f49775c).C(this.f49776d).D(this.f49777f).E(this.f49778g).A();
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
        g(i11, i12);
    }

    public void setGradientColors(int i11, int i12, int i13) {
        this.f49789r = i11;
        this.f49790s = i12;
        this.f49791t = i13;
        f();
    }

    public void setLocation(BubbleDrawable.ArrowLocation arrowLocation) {
        this.f49783l = arrowLocation;
        g(getWidth(), getHeight());
    }

    public void setUpBubbleDrawable() {
        setBackgroundDrawable(null);
        post(new Runnable() { // from class: com.tn.lib.view.bubbleview.BubbleGradientLinearLayout.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleGradientLinearLayout bubbleGradientLinearLayout = BubbleGradientLinearLayout.this;
                bubbleGradientLinearLayout.g(bubbleGradientLinearLayout.getWidth(), BubbleGradientLinearLayout.this.getHeight());
            }
        });
    }

    public void setmArrowPosition(float f11) {
        this.f49782k = f11;
        f();
    }

    public void startShowRemindAnim() {
        AnimatorSet animatorSet = this.f49794w;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f49794w = null;
        }
        this.f49794w = new AnimatorSet();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        float x11 = getX();
        int i11 = marginLayoutParams.leftMargin;
        if (this.f49793v == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "translationX", x11 - (Math.abs(i11) + c(getContext(), 4.0f)), c(getContext(), 4.0f) + x11, x11 - (Math.abs(marginLayoutParams.leftMargin) + c(getContext(), 4.0f)));
            this.f49793v = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(100L);
            this.f49793v.setInterpolator(new LinearInterpolator());
            this.f49793v.setRepeatCount(1);
            this.f49793v.addListener(new a(x11, marginLayoutParams, i11));
        }
        this.f49794w.play(this.f49793v).with(this.f49792u);
        this.f49794w.start();
    }

    public void startTransAnim() {
        if (this.f49795x) {
            if (this.f49792u == null) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "translationY", getY(), getY() - c(getContext(), 6.0f), getY());
                this.f49792u = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                this.f49792u.setInterpolator(new LinearInterpolator());
                this.f49792u.setRepeatCount(-1);
            }
            if (this.f49792u.isStarted()) {
                return;
            }
            this.f49792u.start();
        }
    }
}
