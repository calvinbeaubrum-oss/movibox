package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import com.google.android.material.internal.g0;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.vungle.warren.error.VungleException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f37571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f37572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f37573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f37574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f37575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ViewGroup f37576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f37577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final SnackbarBaseLayout f37578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final com.google.android.material.snackbar.b f37579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f37580k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f37581l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f37584o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f37585p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f37586q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f37587r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f37588s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f37589t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f37590u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<n<B>> f37591v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Behavior f37592w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public final AccessibilityManager f37593x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final TimeInterpolator f37569z = ii.b.f67202b;
    public static final TimeInterpolator A = ii.b.f67201a;
    public static final TimeInterpolator B = ii.b.f67204d;
    public static final boolean D = false;
    public static final int[] E = {R$attr.snackbarStyle};
    public static final String F = BaseTransientBottomBar.class.getSimpleName();

    @NonNull
    public static final Handler C = new Handler(Looper.getMainLooper(), new h());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f37582m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final Runnable f37583n = new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f37578i == null || baseTransientBottomBar.f37577h == null) {
                return;
            }
            int iHeight = (g0.a(BaseTransientBottomBar.this.f37577h).height() - BaseTransientBottomBar.this.I()) + ((int) BaseTransientBottomBar.this.f37578i.getTranslationY());
            if (iHeight >= BaseTransientBottomBar.this.f37588s) {
                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                baseTransientBottomBar2.f37589t = baseTransientBottomBar2.f37588s;
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f37578i.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.F, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
            baseTransientBottomBar3.f37589t = baseTransientBottomBar3.f37588s;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f37588s - iHeight;
            BaseTransientBottomBar.this.f37578i.requestLayout();
        }
    };

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public com.google.android.material.snackbar.e.b f37594y = new k();

    /* JADX INFO: compiled from: source.java */
    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @NonNull
        public final o f37595m = new o(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean F(View view) {
            return this.f37595m.a(view);
        }

        public final void Q(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f37595m.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.f37595m.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SnackbarBaseLayout extends FrameLayout {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final View.OnTouchListener f37596m = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public BaseTransientBottomBar<?> f37597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public yi.n f37598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f37599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f37600d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f37601f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f37602g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f37603h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ColorStateList f37604i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public PorterDuff.Mode f37605j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public Rect f37606k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f37607l;

        /* JADX INFO: compiled from: source.java */
        public class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public SnackbarBaseLayout(@NonNull Context context) {
            this(context, null);
        }

        public SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            super(zi.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
            }
            this.f37599c = typedArrayObtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
            if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_shapeAppearance) || typedArrayObtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_shapeAppearanceOverlay)) {
                this.f37598b = yi.n.e(context2, attributeSet, 0, 0).m();
            }
            this.f37600d = typedArrayObtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(vi.d.a(context2, typedArrayObtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(f0.r(typedArrayObtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f37601f = typedArrayObtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f37602g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_android_maxWidth, -1);
            this.f37603h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_maxActionInlineWidth, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f37596m);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, d());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f37597a = baseTransientBottomBar;
        }

        public void c(ViewGroup viewGroup) {
            this.f37607l = true;
            viewGroup.addView(this);
            this.f37607l = false;
        }

        @NonNull
        public final Drawable d() {
            int iL = com.google.android.material.color.b.l(this, R$attr.colorSurface, R$attr.colorOnSurface, getBackgroundOverlayColorAlpha());
            yi.n nVar = this.f37598b;
            Drawable drawableW = nVar != null ? BaseTransientBottomBar.w(iL, nVar) : BaseTransientBottomBar.v(iL, getResources());
            if (this.f37604i == null) {
                return d3.a.r(drawableW);
            }
            Drawable drawableR = d3.a.r(drawableW);
            d3.a.o(drawableR, this.f37604i);
            return drawableR;
        }

        public final void e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f37606k = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        public float getActionTextColorAlpha() {
            return this.f37601f;
        }

        public int getAnimationMode() {
            return this.f37599c;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f37600d;
        }

        public int getMaxInlineActionWidth() {
            return this.f37603h;
        }

        public int getMaxWidth() {
            return this.f37602g;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f37597a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.N();
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f37597a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.O();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
            super.onLayout(z11, i11, i12, i13, i14);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f37597a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.P();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i11, int i12) {
            super.onMeasure(i11, i12);
            if (this.f37602g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i13 = this.f37602g;
                if (measuredWidth > i13) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), i12);
                }
            }
        }

        public void setAnimationMode(int i11) {
            this.f37599c = i11;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.f37604i != null) {
                drawable = d3.a.r(drawable.mutate());
                d3.a.o(drawable, this.f37604i);
                d3.a.p(drawable, this.f37605j);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.f37604i = colorStateList;
            if (getBackground() != null) {
                Drawable drawableR = d3.a.r(getBackground().mutate());
                d3.a.o(drawableR, colorStateList);
                d3.a.p(drawableR, this.f37605j);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.f37605j = mode;
            if (getBackground() != null) {
                Drawable drawableR = d3.a.r(getBackground().mutate());
                d3.a.p(drawableR, mode);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f37607l || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            e((ViewGroup.MarginLayoutParams) layoutParams);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f37597a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.e0();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f37596m);
            super.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f37608a;

        public a(int i11) {
            this.f37608a = i11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.Q(this.f37608a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f37578i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f37578i.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.f37578i.setScaleY(fFloatValue);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.R();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f37579j.animateContentIn(BaseTransientBottomBar.this.f37572c - BaseTransientBottomBar.this.f37570a, BaseTransientBottomBar.this.f37570a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f37614b;

        public e(int i11) {
            this.f37614b = i11;
            this.f37613a = i11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.D) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f37578i, iIntValue - this.f37613a);
            } else {
                BaseTransientBottomBar.this.f37578i.setTranslationY(iIntValue);
            }
            this.f37613a = iIntValue;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f37616a;

        public f(int i11) {
            this.f37616a = i11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.Q(this.f37616a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f37579j.animateContentOut(0, BaseTransientBottomBar.this.f37571b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37618a = 0;

        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.D) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f37578i, iIntValue - this.f37618a);
            } else {
                BaseTransientBottomBar.this.f37578i.setTranslationY(iIntValue);
            }
            this.f37618a = iIntValue;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i11 = message.what;
            if (i11 == 0) {
                ((BaseTransientBottomBar) message.obj).Y();
                return true;
            }
            if (i11 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).K(message.arg1);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements OnApplyWindowInsetsListener {
        public i() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            BaseTransientBottomBar.this.f37584o = windowInsetsCompat.getSystemWindowInsetBottom();
            BaseTransientBottomBar.this.f37585p = windowInsetsCompat.getSystemWindowInsetLeft();
            BaseTransientBottomBar.this.f37586q = windowInsetsCompat.getSystemWindowInsetRight();
            BaseTransientBottomBar.this.e0();
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j extends AccessibilityDelegateCompat {
        public j() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(1048576);
            accessibilityNodeInfoCompat.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            if (i11 != 1048576) {
                return super.performAccessibilityAction(view, i11, bundle);
            }
            BaseTransientBottomBar.this.x();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k implements com.google.android.material.snackbar.e.b {
        public k() {
        }

        @Override // com.google.android.material.snackbar.e.b
        public void a(int i11) {
            Handler handler = BaseTransientBottomBar.C;
            handler.sendMessage(handler.obtainMessage(1, i11, 0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.e.b
        public void show() {
            Handler handler = BaseTransientBottomBar.C;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l implements SwipeDismissBehavior.c {
        public l() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(@NonNull View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.y(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i11) {
            if (i11 == 0) {
                com.google.android.material.snackbar.e.c().k(BaseTransientBottomBar.this.f37594y);
            } else if (i11 == 1 || i11 == 2) {
                com.google.android.material.snackbar.e.c().j(BaseTransientBottomBar.this.f37594y);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class m extends AnimatorListenerAdapter {
        public m() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.R();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class n<B> {
        public void a(B b11, int i11) {
        }

        public void b(B b11) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.google.android.material.snackbar.e.b f37625a;

        public o(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.M(0.1f);
            swipeDismissBehavior.K(0.6f);
            swipeDismissBehavior.N(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.e.c().j(this.f37625a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.e.c().k(this.f37625a);
            }
        }

        public void c(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f37625a = baseTransientBottomBar.f37594y;
        }
    }

    public BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull com.google.android.material.snackbar.b bVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f37576g = viewGroup;
        this.f37579j = bVar;
        this.f37577h = context;
        b0.a(context);
        SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(F(), viewGroup, false);
        this.f37578i = snackbarBaseLayout;
        snackbarBaseLayout.setBaseTransientBottomBar(this);
        if (view instanceof SnackbarContentLayout) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
            snackbarContentLayout.a(snackbarBaseLayout.getActionTextColorAlpha());
            snackbarContentLayout.setMaxInlineActionWidth(snackbarBaseLayout.getMaxInlineActionWidth());
        }
        snackbarBaseLayout.addView(view);
        ViewCompat.setAccessibilityLiveRegion(snackbarBaseLayout, 1);
        ViewCompat.setImportantForAccessibility(snackbarBaseLayout, 1);
        ViewCompat.setFitsSystemWindows(snackbarBaseLayout, true);
        ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new i());
        ViewCompat.setAccessibilityDelegate(snackbarBaseLayout, new j());
        this.f37593x = (AccessibilityManager) context.getSystemService("accessibility");
        this.f37572c = ti.j.f(context, R$attr.motionDurationLong2, 250);
        this.f37570a = ti.j.f(context, R$attr.motionDurationLong2, 150);
        this.f37571b = ti.j.f(context, R$attr.motionDurationMedium1, 75);
        this.f37573d = ti.j.g(context, R$attr.motionEasingEmphasizedInterpolator, A);
        this.f37575f = ti.j.g(context, R$attr.motionEasingEmphasizedInterpolator, B);
        this.f37574e = ti.j.g(context, R$attr.motionEasingEmphasizedInterpolator, f37569z);
    }

    @NonNull
    public static GradientDrawable v(int i11, @NonNull Resources resources) {
        float dimension = resources.getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i11);
        return gradientDrawable;
    }

    @NonNull
    public static yi.i w(int i11, @NonNull yi.n nVar) {
        yi.i iVar = new yi.i(nVar);
        iVar.d0(ColorStateList.valueOf(i11));
        return iVar;
    }

    @Nullable
    public View A() {
        return null;
    }

    @NonNull
    public Context B() {
        return this.f37577h;
    }

    public int C() {
        return this.f37580k;
    }

    @NonNull
    public SwipeDismissBehavior<? extends View> D() {
        return new Behavior();
    }

    public final ValueAnimator E(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f37575f);
        valueAnimatorOfFloat.addUpdateListener(new c());
        return valueAnimatorOfFloat;
    }

    public int F() {
        return J() ? R$layout.mtrl_layout_snackbar : R$layout.design_layout_snackbar;
    }

    public final int G() {
        int height = this.f37578i.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f37578i.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    @NonNull
    public View H() {
        return this.f37578i;
    }

    public final int I() {
        int[] iArr = new int[2];
        this.f37578i.getLocationInWindow(iArr);
        return iArr[1] + this.f37578i.getHeight();
    }

    public boolean J() {
        TypedArray typedArrayObtainStyledAttributes = this.f37577h.obtainStyledAttributes(E);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public final void K(int i11) {
        if (V() && this.f37578i.getVisibility() == 0) {
            t(i11);
        } else {
            Q(i11);
        }
    }

    public boolean L() {
        return com.google.android.material.snackbar.e.c().e(this.f37594y);
    }

    public final boolean M() {
        ViewGroup.LayoutParams layoutParams = this.f37578i.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    public void N() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.f37578i.getRootWindowInsets()) == null) {
            return;
        }
        this.f37588s = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
        e0();
    }

    public void O() {
        if (L()) {
            C.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
                @Override // java.lang.Runnable
                public void run() {
                    BaseTransientBottomBar.this.Q(3);
                }
            });
        }
    }

    public void P() {
        if (this.f37590u) {
            Z();
            this.f37590u = false;
        }
    }

    public void Q(int i11) {
        com.google.android.material.snackbar.e.c().h(this.f37594y);
        List<n<B>> list = this.f37591v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f37591v.get(size).a(this, i11);
            }
        }
        ViewParent parent = this.f37578i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f37578i);
        }
    }

    public void R() {
        com.google.android.material.snackbar.e.c().i(this.f37594y);
        List<n<B>> list = this.f37591v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f37591v.get(size).b(this);
            }
        }
    }

    public final void S() {
        this.f37587r = u();
        e0();
    }

    @NonNull
    public B T(int i11) {
        this.f37580k = i11;
        return this;
    }

    public final void U(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorD = this.f37592w;
        if (swipeDismissBehaviorD == null) {
            swipeDismissBehaviorD = D();
        }
        if (swipeDismissBehaviorD instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorD).Q(this);
        }
        swipeDismissBehaviorD.L(new l());
        fVar.o(swipeDismissBehaviorD);
        if (A() == null) {
            fVar.f7526g = 80;
        }
    }

    public boolean V() {
        AccessibilityManager accessibilityManager = this.f37593x;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public final boolean W() {
        return this.f37588s > 0 && !this.f37581l && M();
    }

    public void X() {
        com.google.android.material.snackbar.e.c().m(C(), this.f37594y);
    }

    public final void Y() {
        if (this.f37578i.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f37578i.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                U((CoordinatorLayout.f) layoutParams);
            }
            this.f37578i.c(this.f37576g);
            S();
            this.f37578i.setVisibility(4);
        }
        if (ViewCompat.isLaidOut(this.f37578i)) {
            Z();
        } else {
            this.f37590u = true;
        }
    }

    public final void Z() {
        if (V()) {
            s();
            return;
        }
        if (this.f37578i.getParent() != null) {
            this.f37578i.setVisibility(0);
        }
        R();
    }

    public final void a0() {
        ValueAnimator valueAnimatorZ = z(0.0f, 1.0f);
        ValueAnimator valueAnimatorE = E(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorZ, valueAnimatorE);
        animatorSet.setDuration(this.f37570a);
        animatorSet.addListener(new m());
        animatorSet.start();
    }

    public final void b0(int i11) {
        ValueAnimator valueAnimatorZ = z(1.0f, 0.0f);
        valueAnimatorZ.setDuration(this.f37571b);
        valueAnimatorZ.addListener(new a(i11));
        valueAnimatorZ.start();
    }

    public final void c0() {
        int iG = G();
        if (D) {
            ViewCompat.offsetTopAndBottom(this.f37578i, iG);
        } else {
            this.f37578i.setTranslationY(iG);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iG, 0);
        valueAnimator.setInterpolator(this.f37574e);
        valueAnimator.setDuration(this.f37572c);
        valueAnimator.addListener(new d());
        valueAnimator.addUpdateListener(new e(iG));
        valueAnimator.start();
    }

    public final void d0(int i11) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, G());
        valueAnimator.setInterpolator(this.f37574e);
        valueAnimator.setDuration(this.f37572c);
        valueAnimator.addListener(new f(i11));
        valueAnimator.addUpdateListener(new g());
        valueAnimator.start();
    }

    public final void e0() {
        ViewGroup.LayoutParams layoutParams = this.f37578i.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(F, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (this.f37578i.f37606k == null) {
            Log.w(F, "Unable to update margins because original view margins are not set");
            return;
        }
        if (this.f37578i.getParent() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i11 = this.f37578i.f37606k.bottom + (A() != null ? this.f37587r : this.f37584o);
        int i12 = this.f37578i.f37606k.left + this.f37585p;
        int i13 = this.f37578i.f37606k.right + this.f37586q;
        int i14 = this.f37578i.f37606k.top;
        boolean z11 = (marginLayoutParams.bottomMargin == i11 && marginLayoutParams.leftMargin == i12 && marginLayoutParams.rightMargin == i13 && marginLayoutParams.topMargin == i14) ? false : true;
        if (z11) {
            marginLayoutParams.bottomMargin = i11;
            marginLayoutParams.leftMargin = i12;
            marginLayoutParams.rightMargin = i13;
            marginLayoutParams.topMargin = i14;
            this.f37578i.requestLayout();
        }
        if ((z11 || this.f37589t != this.f37588s) && Build.VERSION.SDK_INT >= 29 && W()) {
            this.f37578i.removeCallbacks(this.f37583n);
            this.f37578i.post(this.f37583n);
        }
    }

    public void s() {
        this.f37578i.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
            @Override // java.lang.Runnable
            public void run() {
                SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.f37578i;
                if (snackbarBaseLayout == null) {
                    return;
                }
                if (snackbarBaseLayout.getParent() != null) {
                    BaseTransientBottomBar.this.f37578i.setVisibility(0);
                }
                if (BaseTransientBottomBar.this.f37578i.getAnimationMode() == 1) {
                    BaseTransientBottomBar.this.a0();
                } else {
                    BaseTransientBottomBar.this.c0();
                }
            }
        });
    }

    public final void t(int i11) {
        if (this.f37578i.getAnimationMode() == 1) {
            b0(i11);
        } else {
            d0(i11);
        }
    }

    public final int u() {
        if (A() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        A().getLocationOnScreen(iArr);
        int i11 = iArr[1];
        int[] iArr2 = new int[2];
        this.f37576g.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f37576g.getHeight()) - i11;
    }

    public void x() {
        y(3);
    }

    public void y(int i11) {
        com.google.android.material.snackbar.e.c().b(this.f37594y, i11);
    }

    public final ValueAnimator z(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f37573d);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }
}
