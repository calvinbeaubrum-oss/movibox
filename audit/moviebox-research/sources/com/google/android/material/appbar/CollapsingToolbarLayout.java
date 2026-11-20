package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.x;
import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public static final int G = R$style.Widget_Design_CollapsingToolbar;
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;
    public int A;

    @Nullable
    public WindowInsetsCompat B;
    public int C;
    public boolean D;
    public int E;
    public boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f36130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ViewGroup f36132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public View f36133d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f36134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f36139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final com.google.android.material.internal.b f36140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final pi.a f36141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f36142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f36143o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public Drawable f36144p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public Drawable f36145q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f36146r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f36147s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f36148t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f36149u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TimeInterpolator f36150v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TimeInterpolator f36151w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f36152x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AppBarLayout.g f36153y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f36154z;

    /* JADX INFO: compiled from: source.java */
    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return CollapsingToolbarLayout.this.o(windowInsetsCompat);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f36157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f36158b;

        public c(int i11, int i12) {
            super(i11, i12);
            this.f36157a = 0;
            this.f36158b = 0.5f;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f36157a = 0;
            this.f36158b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.f36157a = typedArrayObtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(typedArrayObtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public c(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f36157a = 0;
            this.f36158b = 0.5f;
        }

        public void a(float f11) {
            this.f36158b = f11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements AppBarLayout.g {
        public d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, int i11) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f36154z = i11;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.B;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i12);
                c cVar = (c) childAt.getLayoutParams();
                k kVarK = CollapsingToolbarLayout.k(childAt);
                int i13 = cVar.f36157a;
                if (i13 == 1) {
                    kVarK.f(g3.a.b(-i11, 0, CollapsingToolbarLayout.this.i(childAt)));
                } else if (i13 == 2) {
                    kVarK.f(Math.round((-i11) * cVar.f36158b));
                }
            }
            CollapsingToolbarLayout.this.u();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f36145q != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int minimumHeight = (height - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop;
            float f11 = minimumHeight;
            CollapsingToolbarLayout.this.f36140l.B0(Math.min(1.0f, (height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f11));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f36140l.o0(collapsingToolbarLayout3.f36154z + minimumHeight);
            CollapsingToolbarLayout.this.f36140l.z0(Math.abs(i11) / f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public interface e extends x {
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.collapsingToolbarLayoutStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = G;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f36130a = true;
        this.f36139k = new Rect();
        this.f36152x = -1;
        this.C = 0;
        this.E = 0;
        Context context2 = getContext();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.f36140l = bVar;
        bVar.M0(ii.b.f67205e);
        bVar.I0(false);
        this.f36141m = new pi.a(context2);
        TypedArray typedArrayI = b0.i(context2, attributeSet, R$styleable.CollapsingToolbarLayout, i11, i12, new int[0]);
        bVar.v0(typedArrayI.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START));
        bVar.k0(typedArrayI.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f36138j = dimensionPixelSize;
        this.f36137i = dimensionPixelSize;
        this.f36136h = dimensionPixelSize;
        this.f36135g = dimensionPixelSize;
        if (typedArrayI.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f36135g = typedArrayI.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (typedArrayI.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f36137i = typedArrayI.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (typedArrayI.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f36136h = typedArrayI.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (typedArrayI.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f36138j = typedArrayI.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f36142n = typedArrayI.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayI.getText(R$styleable.CollapsingToolbarLayout_title));
        bVar.s0(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        bVar.h0(androidx.appcompat.R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayI.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            bVar.s0(typedArrayI.getResourceId(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (typedArrayI.hasValue(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            bVar.h0(typedArrayI.getResourceId(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        if (typedArrayI.hasValue(R$styleable.CollapsingToolbarLayout_titleTextEllipsize)) {
            setTitleEllipsize(b(typedArrayI.getInt(R$styleable.CollapsingToolbarLayout_titleTextEllipsize, -1)));
        }
        if (typedArrayI.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleTextColor)) {
            bVar.u0(vi.d.a(context2, typedArrayI, R$styleable.CollapsingToolbarLayout_expandedTitleTextColor));
        }
        if (typedArrayI.hasValue(R$styleable.CollapsingToolbarLayout_collapsedTitleTextColor)) {
            bVar.j0(vi.d.a(context2, typedArrayI, R$styleable.CollapsingToolbarLayout_collapsedTitleTextColor));
        }
        this.f36152x = typedArrayI.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (typedArrayI.hasValue(R$styleable.CollapsingToolbarLayout_maxLines)) {
            bVar.G0(typedArrayI.getInt(R$styleable.CollapsingToolbarLayout_maxLines, 1));
        }
        if (typedArrayI.hasValue(R$styleable.CollapsingToolbarLayout_titlePositionInterpolator)) {
            bVar.H0(AnimationUtils.loadInterpolator(context2, typedArrayI.getResourceId(R$styleable.CollapsingToolbarLayout_titlePositionInterpolator, 0)));
        }
        this.f36149u = typedArrayI.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, LogSeverity.CRITICAL_VALUE);
        this.f36150v = ti.j.g(context2, R$attr.motionEasingStandardInterpolator, ii.b.f67203c);
        this.f36151w = ti.j.g(context2, R$attr.motionEasingStandardInterpolator, ii.b.f67204d);
        setContentScrim(typedArrayI.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayI.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(typedArrayI.getInt(R$styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.f36131b = typedArrayI.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.D = typedArrayI.getBoolean(R$styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.F = typedArrayI.getBoolean(R$styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        typedArrayI.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList colorStateListH = com.google.android.material.color.b.h(getContext(), R$attr.colorSurfaceContainer);
        if (colorStateListH != null) {
            return colorStateListH.getDefaultColor();
        }
        return this.f36141m.d(getResources().getDimension(R$dimen.design_appbar_elevation));
    }

    public static int h(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static CharSequence j(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @NonNull
    public static k k(@NonNull View view) {
        k kVar = (k) view.getTag(R$id.view_offset_helper);
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(view);
        view.setTag(R$id.view_offset_helper, kVar2);
        return kVar2;
    }

    public static boolean m(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    public final void a(int i11) {
        d();
        ValueAnimator valueAnimator = this.f36148t;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f36148t = valueAnimator2;
            valueAnimator2.setInterpolator(i11 > this.f36146r ? this.f36150v : this.f36151w);
            this.f36148t.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.f36148t.cancel();
        }
        this.f36148t.setDuration(this.f36149u);
        this.f36148t.setIntValues(this.f36146r, i11);
        this.f36148t.start();
    }

    public final TextUtils.TruncateAt b(int i11) {
        if (i11 == 0) {
            return TextUtils.TruncateAt.START;
        }
        if (i11 != 1) {
            return i11 != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE;
        }
        return TextUtils.TruncateAt.MIDDLE;
    }

    public final void c(AppBarLayout appBarLayout) {
        if (l()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public final void d() {
        if (this.f36130a) {
            ViewGroup viewGroup = null;
            this.f36132c = null;
            this.f36133d = null;
            int i11 = this.f36131b;
            if (i11 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i11);
                this.f36132c = viewGroup2;
                if (viewGroup2 != null) {
                    this.f36133d = e(viewGroup2);
                }
            }
            if (this.f36132c == null) {
                int childCount = getChildCount();
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    if (m(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                }
                this.f36132c = viewGroup;
            }
            t();
            this.f36130a = false;
        }
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        d();
        if (this.f36132c == null && (drawable = this.f36144p) != null && this.f36146r > 0) {
            drawable.mutate().setAlpha(this.f36146r);
            this.f36144p.draw(canvas);
        }
        if (this.f36142n && this.f36143o) {
            if (this.f36132c == null || this.f36144p == null || this.f36146r <= 0 || !l() || this.f36140l.F() >= this.f36140l.G()) {
                this.f36140l.l(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.f36144p.getBounds(), Region.Op.DIFFERENCE);
                this.f36140l.l(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.f36145q == null || this.f36146r <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.B;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f36145q.setBounds(0, -this.f36154z, getWidth(), systemWindowInsetTop - this.f36154z);
            this.f36145q.mutate().setAlpha(this.f36146r);
            this.f36145q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j11) {
        boolean z11;
        if (this.f36144p == null || this.f36146r <= 0 || !n(view)) {
            z11 = false;
        } else {
            s(this.f36144p, view, getWidth(), getHeight());
            this.f36144p.mutate().setAlpha(this.f36146r);
            this.f36144p.draw(canvas);
            z11 = true;
        }
        return super.drawChild(canvas, view, j11) || z11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f36145q;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f36144p;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.b bVar = this.f36140l;
        if (bVar != null) {
            state |= bVar.J0(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @NonNull
    public final View e(@NonNull View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getCollapsedTitleGravity() {
        return this.f36140l.q();
    }

    public float getCollapsedTitleTextSize() {
        return this.f36140l.u();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.f36140l.v();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.f36144p;
    }

    public int getExpandedTitleGravity() {
        return this.f36140l.B();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f36138j;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f36137i;
    }

    public int getExpandedTitleMarginStart() {
        return this.f36135g;
    }

    public int getExpandedTitleMarginTop() {
        return this.f36136h;
    }

    public float getExpandedTitleTextSize() {
        return this.f36140l.D();
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.f36140l.E();
    }

    @RequiresApi(23)
    public int getHyphenationFrequency() {
        return this.f36140l.H();
    }

    public int getLineCount() {
        return this.f36140l.I();
    }

    @RequiresApi(23)
    public float getLineSpacingAdd() {
        return this.f36140l.J();
    }

    @RequiresApi(23)
    public float getLineSpacingMultiplier() {
        return this.f36140l.K();
    }

    public int getMaxLines() {
        return this.f36140l.L();
    }

    public int getScrimAlpha() {
        return this.f36146r;
    }

    public long getScrimAnimationDuration() {
        return this.f36149u;
    }

    public int getScrimVisibleHeightTrigger() {
        int i11 = this.f36152x;
        if (i11 >= 0) {
            return i11 + this.C + this.E;
        }
        WindowInsetsCompat windowInsetsCompat = this.B;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.f36145q;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.f36142n) {
            return this.f36140l.O();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.A;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f36140l.N();
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f36140l.R();
    }

    public final int i(@NonNull View view) {
        return ((getHeight() - k(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((c) view.getLayoutParams())).bottomMargin;
    }

    public boolean isExtraMultilineHeightEnabled() {
        return this.F;
    }

    public boolean isForceApplySystemWindowInsetTop() {
        return this.D;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.f36140l.V();
    }

    public boolean isTitleEnabled() {
        return this.f36142n;
    }

    public final boolean l() {
        return this.A == 1;
    }

    public final boolean n(View view) {
        View view2 = this.f36133d;
        if (view2 == null || view2 == this) {
            if (view != this.f36132c) {
                return false;
            }
        } else if (view != view2) {
            return false;
        }
        return true;
    }

    public WindowInsetsCompat o(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!androidx.core.util.d.a(this.B, windowInsetsCompat2)) {
            this.B = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            c(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.f36153y == null) {
                this.f36153y = new d();
            }
            appBarLayout.addOnOffsetChangedListener(this.f36153y);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f36140l.Z(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.g gVar = this.f36153y;
        if (gVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(gVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        WindowInsetsCompat windowInsetsCompat = this.B;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt = getChildAt(i15);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            k(getChildAt(i16)).d();
        }
        v(i11, i12, i13, i14, false);
        w();
        u();
        int childCount3 = getChildCount();
        for (int i17 = 0; i17 < childCount3; i17++) {
            k(getChildAt(i17)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        d();
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i12);
        WindowInsetsCompat windowInsetsCompat = this.B;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if ((mode == 0 || this.D) && systemWindowInsetTop > 0) {
            this.C = systemWindowInsetTop;
            super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        if (this.F && this.f36140l.L() > 1) {
            w();
            v(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int iZ = this.f36140l.z();
            if (iZ > 1) {
                this.E = Math.round(this.f36140l.A()) * (iZ - 1);
                super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.E, 1073741824));
            }
        }
        ViewGroup viewGroup = this.f36132c;
        if (viewGroup != null) {
            View view = this.f36133d;
            if (view == null || view == this) {
                setMinimumHeight(h(viewGroup));
            } else {
                setMinimumHeight(h(view));
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        Drawable drawable = this.f36144p;
        if (drawable != null) {
            r(drawable, i11, i12);
        }
    }

    public final void p(boolean z11) {
        int titleMarginStart;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        View view = this.f36133d;
        if (view == null) {
            view = this.f36132c;
        }
        int i11 = i(view);
        com.google.android.material.internal.d.a(this, this.f36134f, this.f36139k);
        ViewGroup viewGroup = this.f36132c;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            titleMarginStart = toolbar.getTitleMarginStart();
            titleMarginEnd = toolbar.getTitleMarginEnd();
            titleMarginTop = toolbar.getTitleMarginTop();
            titleMarginBottom = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            titleMarginStart = 0;
            titleMarginBottom = 0;
            titleMarginEnd = 0;
            titleMarginTop = 0;
        } else {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            titleMarginStart = toolbar2.getTitleMarginStart();
            titleMarginEnd = toolbar2.getTitleMarginEnd();
            titleMarginTop = toolbar2.getTitleMarginTop();
            titleMarginBottom = toolbar2.getTitleMarginBottom();
        }
        com.google.android.material.internal.b bVar = this.f36140l;
        Rect rect = this.f36139k;
        int i12 = rect.left + (z11 ? titleMarginEnd : titleMarginStart);
        int i13 = rect.top + i11 + titleMarginTop;
        int i14 = rect.right;
        if (!z11) {
            titleMarginStart = titleMarginEnd;
        }
        bVar.f0(i12, i13, i14 - titleMarginStart, (rect.bottom + i11) - titleMarginBottom);
    }

    public final void q() {
        setContentDescription(getTitle());
    }

    public final void r(@NonNull Drawable drawable, int i11, int i12) {
        s(drawable, this.f36132c, i11, i12);
    }

    public final void s(@NonNull Drawable drawable, @Nullable View view, int i11, int i12) {
        if (l() && view != null && this.f36142n) {
            i12 = view.getBottom();
        }
        drawable.setBounds(0, 0, i11, i12);
    }

    public void setCollapsedTitleGravity(int i11) {
        this.f36140l.k0(i11);
    }

    public void setCollapsedTitleTextAppearance(int i11) {
        this.f36140l.h0(i11);
    }

    public void setCollapsedTitleTextColor(int i11) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f36140l.j0(colorStateList);
    }

    public void setCollapsedTitleTextSize(float f11) {
        this.f36140l.l0(f11);
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.f36140l.m0(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f36144p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f36144p = drawableMutate;
            if (drawableMutate != null) {
                r(drawableMutate, getWidth(), getHeight());
                this.f36144p.setCallback(this);
                this.f36144p.setAlpha(this.f36146r);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i11) {
        setContentScrim(new ColorDrawable(i11));
    }

    public void setContentScrimResource(int i11) {
        setContentScrim(z2.a.getDrawable(getContext(), i11));
    }

    public void setExpandedTitleColor(int i11) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setExpandedTitleGravity(int i11) {
        this.f36140l.v0(i11);
    }

    public void setExpandedTitleMargin(int i11, int i12, int i13, int i14) {
        this.f36135g = i11;
        this.f36136h = i12;
        this.f36137i = i13;
        this.f36138j = i14;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i11) {
        this.f36138j = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i11) {
        this.f36137i = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i11) {
        this.f36135g = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i11) {
        this.f36136h = i11;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i11) {
        this.f36140l.s0(i11);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f36140l.u0(colorStateList);
    }

    public void setExpandedTitleTextSize(float f11) {
        this.f36140l.w0(f11);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.f36140l.x0(typeface);
    }

    public void setExtraMultilineHeightEnabled(boolean z11) {
        this.F = z11;
    }

    public void setForceApplySystemWindowInsetTop(boolean z11) {
        this.D = z11;
    }

    @RequiresApi(23)
    public void setHyphenationFrequency(int i11) {
        this.f36140l.C0(i11);
    }

    @RequiresApi(23)
    public void setLineSpacingAdd(float f11) {
        this.f36140l.E0(f11);
    }

    @RequiresApi(23)
    public void setLineSpacingMultiplier(float f11) {
        this.f36140l.F0(f11);
    }

    public void setMaxLines(int i11) {
        this.f36140l.G0(i11);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z11) {
        this.f36140l.I0(z11);
    }

    public void setScrimAlpha(int i11) {
        ViewGroup viewGroup;
        if (i11 != this.f36146r) {
            if (this.f36144p != null && (viewGroup = this.f36132c) != null) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.f36146r = i11;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(long j11) {
        this.f36149u = j11;
    }

    public void setScrimVisibleHeightTrigger(int i11) {
        if (this.f36152x != i11) {
            this.f36152x = i11;
            u();
        }
    }

    public void setScrimsShown(boolean z11) {
        setScrimsShown(z11, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean z11, boolean z12) {
        if (this.f36147s != z11) {
            if (z12) {
                a(z11 ? 255 : 0);
            } else {
                setScrimAlpha(z11 ? 255 : 0);
            }
            this.f36147s = z11;
        }
    }

    @RequiresApi(23)
    public void setStaticLayoutBuilderConfigurer(@Nullable e eVar) {
        this.f36140l.K0(eVar);
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f36145q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f36145q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f36145q.setState(getDrawableState());
                }
                d3.a.m(this.f36145q, ViewCompat.getLayoutDirection(this));
                this.f36145q.setVisible(getVisibility() == 0, false);
                this.f36145q.setCallback(this);
                this.f36145q.setAlpha(this.f36146r);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(int i11) {
        setStatusBarScrim(new ColorDrawable(i11));
    }

    public void setStatusBarScrimResource(int i11) {
        setStatusBarScrim(z2.a.getDrawable(getContext(), i11));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f36140l.L0(charSequence);
        q();
    }

    public void setTitleCollapseMode(int i11) {
        this.A = i11;
        boolean zL = l();
        this.f36140l.A0(zL);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            c((AppBarLayout) parent);
        }
        if (zL && this.f36144p == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        this.f36140l.N0(truncateAt);
    }

    public void setTitleEnabled(boolean z11) {
        if (z11 != this.f36142n) {
            this.f36142n = z11;
            q();
            t();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.f36140l.H0(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        boolean z11 = i11 == 0;
        Drawable drawable = this.f36145q;
        if (drawable != null && drawable.isVisible() != z11) {
            this.f36145q.setVisible(z11, false);
        }
        Drawable drawable2 = this.f36144p;
        if (drawable2 == null || drawable2.isVisible() == z11) {
            return;
        }
        this.f36144p.setVisible(z11, false);
    }

    public final void t() {
        View view;
        if (!this.f36142n && (view = this.f36134f) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f36134f);
            }
        }
        if (!this.f36142n || this.f36132c == null) {
            return;
        }
        if (this.f36134f == null) {
            this.f36134f = new View(getContext());
        }
        if (this.f36134f.getParent() == null) {
            this.f36132c.addView(this.f36134f, -1, -1);
        }
    }

    public final void u() {
        if (this.f36144p == null && this.f36145q == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f36154z < getScrimVisibleHeightTrigger());
    }

    public final void v(int i11, int i12, int i13, int i14, boolean z11) {
        View view;
        if (!this.f36142n || (view = this.f36134f) == null) {
            return;
        }
        boolean z12 = ViewCompat.isAttachedToWindow(view) && this.f36134f.getVisibility() == 0;
        this.f36143o = z12;
        if (z12 || z11) {
            boolean z13 = ViewCompat.getLayoutDirection(this) == 1;
            p(z13);
            this.f36140l.p0(z13 ? this.f36137i : this.f36135g, this.f36139k.top + this.f36136h, (i13 - i11) - (z13 ? this.f36135g : this.f36137i), (i14 - i12) - this.f36138j);
            this.f36140l.c0(z11);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f36144p || drawable == this.f36145q;
    }

    public final void w() {
        if (this.f36132c != null && this.f36142n && TextUtils.isEmpty(this.f36140l.O())) {
            setTitle(j(this.f36132c));
        }
    }
}
