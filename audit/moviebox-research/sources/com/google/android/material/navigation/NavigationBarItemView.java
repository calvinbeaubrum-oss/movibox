package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.s0;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$string;
import com.google.android.material.badge.BadgeDrawable;
import ti.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class NavigationBarItemView extends FrameLayout implements m.a {
    public static final int[] H = {R.attr.state_checked};
    public static final c I;
    public static final c J;
    public float A;
    public boolean B;
    public int C;
    public int D;
    public boolean E;
    public int F;

    @Nullable
    public BadgeDrawable G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f37135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f37136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public Drawable f37137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f37138d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f37139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f37140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f37141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f37142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f37143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f37144k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f37145l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final FrameLayout f37146m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public final View f37147n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ImageView f37148o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ViewGroup f37149p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TextView f37150q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TextView f37151r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f37152s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f37153t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public h f37154u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public ColorStateList f37155v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public Drawable f37156w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public Drawable f37157x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ValueAnimator f37158y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c f37159z;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            if (NavigationBarItemView.this.f37148o.getVisibility() == 0) {
                NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                navigationBarItemView.u(navigationBarItemView.f37148o);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f37161a;

        public b(float f11) {
            this.f37161a = f11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NavigationBarItemView.this.o(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f37161a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {
        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public float a(float f11, float f12) {
            return ii.b.b(0.0f, 1.0f, f12 == 0.0f ? 0.8f : 0.0f, f12 == 0.0f ? 1.0f : 0.2f, f11);
        }

        public float b(float f11, float f12) {
            return ii.b.a(0.4f, 1.0f, f11);
        }

        public float c(float f11, float f12) {
            return 1.0f;
        }

        public void d(float f11, float f12, @NonNull View view) {
            view.setScaleX(b(f11, f12));
            view.setScaleY(c(f11, f12));
            view.setAlpha(a(f11, f12));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends c {
        public d() {
            super(null);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.c
        public float c(float f11, float f12) {
            return b(f11, f12);
        }
    }

    static {
        a aVar = null;
        I = new c(aVar);
        J = new d(aVar);
    }

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        this.f37135a = false;
        this.f37152s = -1;
        this.f37153t = 0;
        this.f37159z = I;
        this.A = 0.0f;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f37146m = (FrameLayout) findViewById(R$id.navigation_bar_item_icon_container);
        this.f37147n = findViewById(R$id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(R$id.navigation_bar_item_icon_view);
        this.f37148o = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.navigation_bar_item_labels_group);
        this.f37149p = viewGroup;
        TextView textView = (TextView) findViewById(R$id.navigation_bar_item_small_label_view);
        this.f37150q = textView;
        TextView textView2 = (TextView) findViewById(R$id.navigation_bar_item_large_label_view);
        this.f37151r = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f37138d = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f37139f = viewGroup.getPaddingBottom();
        this.f37140g = getResources().getDimensionPixelSize(R$dimen.m3_navigation_item_active_indicator_label_padding);
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        e(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    public static Drawable g(@NonNull ColorStateList colorStateList) {
        return new RippleDrawable(wi.b.a(colorStateList), null, null);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f37146m;
        return frameLayout != null ? frameLayout : this.f37148o;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i11 = 0;
        for (int i12 = 0; i12 < iIndexOfChild; i12++) {
            View childAt = viewGroup.getChildAt(i12);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i11++;
            }
        }
        return i11;
    }

    private int getSuggestedIconHeight() {
        return ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin + getIconOrContainer().getMeasuredHeight();
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable badgeDrawable = this.G;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.G.l();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f37148o.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    public static void p(TextView textView, int i11) {
        androidx.core.widget.m.p(textView, i11);
        int i12 = vi.d.i(textView.getContext(), i11, 0);
        if (i12 != 0) {
            textView.setTextSize(0, i12);
        }
    }

    public static void q(@NonNull View view, float f11, float f12, int i11) {
        view.setScaleX(f11);
        view.setScaleY(f12);
        view.setVisibility(i11);
    }

    public static void r(@NonNull View view, int i11, int i12) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i11;
        layoutParams.bottomMargin = i11;
        layoutParams.gravity = i12;
        view.setLayoutParams(layoutParams);
    }

    public static void x(@NonNull View view, int i11) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.f37146m;
        if (frameLayout != null && this.B) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(float f11, float f12) {
        this.f37141h = f11 - f12;
        this.f37142i = (f12 * 1.0f) / f11;
        this.f37143j = (f11 * 1.0f) / f12;
    }

    public void f() {
        n();
        this.f37154u = null;
        this.A = 0.0f;
        this.f37135a = false;
    }

    @Nullable
    public Drawable getActiveIndicatorDrawable() {
        View view = this.f37147n;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.G;
    }

    public int getItemBackgroundResId() {
        return R$drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.m.a
    @Nullable
    public h getItemData() {
        return this.f37154u;
    }

    public int getItemDefaultMarginResId() {
        return R$dimen.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f37152s;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f37149p.getLayoutParams();
        return getSuggestedIconHeight() + (this.f37149p.getVisibility() == 0 ? this.f37140g : 0) + layoutParams.topMargin + this.f37149p.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f37149p.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f37149p.getMeasuredWidth() + layoutParams.rightMargin);
    }

    @Nullable
    public final FrameLayout h(View view) {
        ImageView imageView = this.f37148o;
        if (view == imageView && com.google.android.material.badge.c.f36220a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    public final boolean i() {
        return this.G != null;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void initialize(@NonNull h hVar, int i11) {
        this.f37154u = hVar;
        setCheckable(hVar.isCheckable());
        setChecked(hVar.isChecked());
        setEnabled(hVar.isEnabled());
        setIcon(hVar.getIcon());
        setTitle(hVar.getTitle());
        setId(hVar.getItemId());
        if (!TextUtils.isEmpty(hVar.getContentDescription())) {
            setContentDescription(hVar.getContentDescription());
        }
        CharSequence tooltipText = !TextUtils.isEmpty(hVar.getTooltipText()) ? hVar.getTooltipText() : hVar.getTitle();
        if (Build.VERSION.SDK_INT > 23) {
            s0.a(this, tooltipText);
        }
        setVisibility(hVar.isVisible() ? 0 : 8);
        this.f37135a = true;
    }

    public final boolean j() {
        return this.E && this.f37144k == 2;
    }

    public final void k(float f11) {
        if (!this.B || !this.f37135a || !ViewCompat.isAttachedToWindow(this)) {
            o(f11, f11);
            return;
        }
        ValueAnimator valueAnimator = this.f37158y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f37158y = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.A, f11);
        this.f37158y = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new b(f11));
        this.f37158y.setInterpolator(j.g(getContext(), R$attr.motionEasingEmphasizedInterpolator, ii.b.f67202b));
        this.f37158y.setDuration(j.f(getContext(), R$attr.motionDurationLong2, getResources().getInteger(R$integer.material_motion_duration_long_1)));
        this.f37158y.start();
    }

    public final void l() {
        h hVar = this.f37154u;
        if (hVar != null) {
            setChecked(hVar.isChecked());
        }
    }

    public final void m() {
        Drawable drawableG = this.f37137c;
        RippleDrawable rippleDrawable = null;
        boolean z11 = true;
        if (this.f37136b != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.B && getActiveIndicatorDrawable() != null && this.f37146m != null && activeIndicatorDrawable != null) {
                rippleDrawable = new RippleDrawable(wi.b.e(this.f37136b), null, activeIndicatorDrawable);
                z11 = false;
            } else if (drawableG == null) {
                drawableG = g(this.f37136b);
            }
        }
        FrameLayout frameLayout = this.f37146m;
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
            this.f37146m.setForeground(rippleDrawable);
        }
        ViewCompat.setBackground(this, drawableG);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z11);
        }
    }

    public void n() {
        t(this.f37148o);
    }

    public final void o(float f11, float f12) {
        View view = this.f37147n;
        if (view != null) {
            this.f37159z.d(f11, f12, view);
        }
        this.A = f11;
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int i11) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i11 + 1);
        h hVar = this.f37154u;
        if (hVar != null && hVar.isCheckable() && this.f37154u.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, H);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.G;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.f37154u.getTitle();
            if (!TextUtils.isEmpty(this.f37154u.getContentDescription())) {
                title = this.f37154u.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.G.i()));
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            accessibilityNodeInfoCompatWrap.setClickable(false);
            accessibilityNodeInfoCompatWrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        accessibilityNodeInfoCompatWrap.setRoleDescription(getResources().getString(R$string.item_view_role_description));
    }

    @Override // android.view.View
    public void onSizeChanged(final int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        post(new Runnable() { // from class: com.google.android.material.navigation.NavigationBarItemView.2
            @Override // java.lang.Runnable
            public void run() {
                NavigationBarItemView.this.v(i11);
            }
        });
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public final void s(@Nullable View view) {
        if (i() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.c.c(this.G, view, h(view));
        }
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable drawable) {
        View view = this.f37147n;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        m();
    }

    public void setActiveIndicatorEnabled(boolean z11) {
        this.B = z11;
        m();
        View view = this.f37147n;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i11) {
        this.D = i11;
        v(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i11) {
        if (this.f37140g != i11) {
            this.f37140g = i11;
            l();
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i11) {
        this.F = i11;
        v(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z11) {
        this.E = z11;
    }

    public void setActiveIndicatorWidth(int i11) {
        this.C = i11;
        v(getWidth());
    }

    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        if (this.G == badgeDrawable) {
            return;
        }
        if (i() && this.f37148o != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            t(this.f37148o);
        }
        this.G = badgeDrawable;
        ImageView imageView = this.f37148o;
        if (imageView != null) {
            s(imageView);
        }
    }

    public void setCheckable(boolean z11) {
        refreshDrawableState();
    }

    public void setChecked(boolean z11) {
        TextView textView = this.f37151r;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.f37151r;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.f37150q;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.f37150q;
        textView4.setPivotY(textView4.getBaseline());
        k(z11 ? 1.0f : 0.0f);
        int i11 = this.f37144k;
        if (i11 != -1) {
            if (i11 == 0) {
                if (z11) {
                    r(getIconOrContainer(), this.f37138d, 49);
                    x(this.f37149p, this.f37139f);
                    this.f37151r.setVisibility(0);
                } else {
                    r(getIconOrContainer(), this.f37138d, 17);
                    x(this.f37149p, 0);
                    this.f37151r.setVisibility(4);
                }
                this.f37150q.setVisibility(4);
            } else if (i11 == 1) {
                x(this.f37149p, this.f37139f);
                if (z11) {
                    r(getIconOrContainer(), (int) (this.f37138d + this.f37141h), 49);
                    q(this.f37151r, 1.0f, 1.0f, 0);
                    TextView textView5 = this.f37150q;
                    float f11 = this.f37142i;
                    q(textView5, f11, f11, 4);
                } else {
                    r(getIconOrContainer(), this.f37138d, 49);
                    TextView textView6 = this.f37151r;
                    float f12 = this.f37143j;
                    q(textView6, f12, f12, 4);
                    q(this.f37150q, 1.0f, 1.0f, 0);
                }
            } else if (i11 == 2) {
                r(getIconOrContainer(), this.f37138d, 17);
                this.f37151r.setVisibility(8);
                this.f37150q.setVisibility(8);
            }
        } else if (this.f37145l) {
            if (z11) {
                r(getIconOrContainer(), this.f37138d, 49);
                x(this.f37149p, this.f37139f);
                this.f37151r.setVisibility(0);
            } else {
                r(getIconOrContainer(), this.f37138d, 17);
                x(this.f37149p, 0);
                this.f37151r.setVisibility(4);
            }
            this.f37150q.setVisibility(4);
        } else {
            x(this.f37149p, this.f37139f);
            if (z11) {
                r(getIconOrContainer(), (int) (this.f37138d + this.f37141h), 49);
                q(this.f37151r, 1.0f, 1.0f, 0);
                TextView textView7 = this.f37150q;
                float f13 = this.f37142i;
                q(textView7, f13, f13, 4);
            } else {
                r(getIconOrContainer(), this.f37138d, 49);
                TextView textView8 = this.f37151r;
                float f14 = this.f37143j;
                q(textView8, f14, f14, 4);
                q(this.f37150q, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z11);
    }

    @Override // android.view.View
    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        this.f37150q.setEnabled(z11);
        this.f37151r.setEnabled(z11);
        this.f37148o.setEnabled(z11);
        if (z11) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.f37156w) {
            return;
        }
        this.f37156w = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = d3.a.r(drawable).mutate();
            this.f37157x = drawable;
            ColorStateList colorStateList = this.f37155v;
            if (colorStateList != null) {
                d3.a.o(drawable, colorStateList);
            }
        }
        this.f37148o.setImageDrawable(drawable);
    }

    public void setIconSize(int i11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f37148o.getLayoutParams();
        layoutParams.width = i11;
        layoutParams.height = i11;
        this.f37148o.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.f37155v = colorStateList;
        if (this.f37154u == null || (drawable = this.f37157x) == null) {
            return;
        }
        d3.a.o(drawable, colorStateList);
        this.f37157x.invalidateSelf();
    }

    public void setItemBackground(int i11) {
        setItemBackground(i11 == 0 ? null : z2.a.getDrawable(getContext(), i11));
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f37137c = drawable;
        m();
    }

    public void setItemPaddingBottom(int i11) {
        if (this.f37139f != i11) {
            this.f37139f = i11;
            l();
        }
    }

    public void setItemPaddingTop(int i11) {
        if (this.f37138d != i11) {
            this.f37138d = i11;
            l();
        }
    }

    public void setItemPosition(int i11) {
        this.f37152s = i11;
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.f37136b = colorStateList;
        m();
    }

    public void setLabelVisibilityMode(int i11) {
        if (this.f37144k != i11) {
            this.f37144k = i11;
            w();
            v(getWidth());
            l();
        }
    }

    public void setShifting(boolean z11) {
        if (this.f37145l != z11) {
            this.f37145l = z11;
            l();
        }
    }

    public void setShortcut(boolean z11, char c11) {
    }

    public void setTextAppearanceActive(int i11) {
        this.f37153t = i11;
        p(this.f37151r, i11);
        e(this.f37150q.getTextSize(), this.f37151r.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z11) {
        setTextAppearanceActive(this.f37153t);
        TextView textView = this.f37151r;
        textView.setTypeface(textView.getTypeface(), z11 ? 1 : 0);
    }

    public void setTextAppearanceInactive(int i11) {
        p(this.f37150q, i11);
        e(this.f37150q.getTextSize(), this.f37151r.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f37150q.setTextColor(colorStateList);
            this.f37151r.setTextColor(colorStateList);
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f37150q.setText(charSequence);
        this.f37151r.setText(charSequence);
        h hVar = this.f37154u;
        if (hVar == null || TextUtils.isEmpty(hVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        h hVar2 = this.f37154u;
        if (hVar2 != null && !TextUtils.isEmpty(hVar2.getTooltipText())) {
            charSequence = this.f37154u.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            s0.a(this, charSequence);
        }
    }

    public boolean showsIcon() {
        return true;
    }

    public final void t(@Nullable View view) {
        if (i()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.c.f(this.G, view);
            }
            this.G = null;
        }
    }

    public final void u(View view) {
        if (i()) {
            com.google.android.material.badge.c.g(this.G, view, h(view));
        }
    }

    public final void v(int i11) {
        if (this.f37147n == null || i11 <= 0) {
            return;
        }
        int iMin = Math.min(this.C, i11 - (this.F * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f37147n.getLayoutParams();
        layoutParams.height = j() ? iMin : this.D;
        layoutParams.width = iMin;
        this.f37147n.setLayoutParams(layoutParams);
    }

    public final void w() {
        if (j()) {
            this.f37159z = J;
        } else {
            this.f37159z = I;
        }
    }
}
