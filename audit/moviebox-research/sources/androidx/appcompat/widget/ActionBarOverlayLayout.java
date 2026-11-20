package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements v, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    public static final int[] H = {R$attr.actionBarSize, R.attr.windowContentOverlay};
    public static final WindowInsetsCompat I = new WindowInsetsCompat.Builder().setSystemWindowInsets(c3.c.b(0, 1, 0, 1)).build();
    public static final Rect J = new Rect();
    public OverScroller A;
    public ViewPropertyAnimator B;
    public final AnimatorListenerAdapter C;
    public final Runnable D;
    public final Runnable E;
    public final NestedScrollingParentHelper F;
    public final d G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f1238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContainer f1239d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w f1240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f1241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1245k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1246l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1247m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f1248n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f1249o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f1250p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f1251q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f1252r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f1253s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Rect f1254t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Rect f1255u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public WindowInsetsCompat f1256v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public WindowInsetsCompat f1257w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public WindowInsetsCompat f1258x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public WindowInsetsCompat f1259y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b f1260z;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f1245k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f1245k = false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface b {
        void a();

        void b();

        void c(boolean z11);

        void d();

        void e();

        void onWindowVisibilityChanged(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class c extends ViewGroup.MarginLayoutParams {
        public c(int i11, int i12) {
            super(i11, i12);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class d extends View {
        public d(Context context) {
            super(context);
            setWillNotDraw(true);
        }

        @Override // android.view.View
        public int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1237b = 0;
        this.f1248n = new Rect();
        this.f1249o = new Rect();
        this.f1250p = new Rect();
        this.f1251q = new Rect();
        this.f1252r = new Rect();
        this.f1253s = new Rect();
        this.f1254t = new Rect();
        this.f1255u = new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.CONSUMED;
        this.f1256v = windowInsetsCompat;
        this.f1257w = windowInsetsCompat;
        this.f1258x = windowInsetsCompat;
        this.f1259y = windowInsetsCompat;
        this.C = new a();
        this.D = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.f();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.B = actionBarOverlayLayout.f1239d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
            }
        };
        this.E = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.f();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.B = actionBarOverlayLayout.f1239d.animate().translationY(-ActionBarOverlayLayout.this.f1239d.getHeight()).setListener(ActionBarOverlayLayout.this.C);
            }
        };
        g(context);
        this.F = new NestedScrollingParentHelper(this);
        d dVar = new d(context);
        this.G = dVar;
        addView(dVar);
    }

    private void g(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(H);
        this.f1236a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f1241g = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.A = new OverScroller(context);
    }

    public final void a() {
        f();
        this.E.run();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final boolean b(@NonNull View view, @NonNull Rect rect, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15;
        c cVar = (c) view.getLayoutParams();
        if (z11) {
            int i11 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
            int i12 = rect.left;
            if (i11 != i12) {
                ((ViewGroup.MarginLayoutParams) cVar).leftMargin = i12;
                z15 = true;
            } else {
                z15 = false;
            }
        } else {
            z15 = false;
        }
        if (z12) {
            int i13 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
            int i14 = rect.top;
            if (i13 != i14) {
                ((ViewGroup.MarginLayoutParams) cVar).topMargin = i14;
                z15 = true;
            }
        }
        if (z14) {
            int i15 = ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
            int i16 = rect.right;
            if (i15 != i16) {
                ((ViewGroup.MarginLayoutParams) cVar).rightMargin = i16;
                z15 = true;
            }
        }
        if (z13) {
            int i17 = ((ViewGroup.MarginLayoutParams) cVar).bottomMargin;
            int i18 = rect.bottom;
            if (i17 != i18) {
                ((ViewGroup.MarginLayoutParams) cVar).bottomMargin = i18;
                return true;
            }
        }
        return z15;
    }

    public final boolean c() {
        ViewCompat.computeSystemWindowInsets(this.G, I, this.f1251q);
        return !this.f1251q.equals(J);
    }

    @Override // androidx.appcompat.widget.v
    public boolean canShowOverflowMenu() {
        j();
        return this.f1240f.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    @Override // androidx.appcompat.widget.v
    public void dismissPopups() {
        j();
        this.f1240f.k();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.f1241g != null) {
            int bottom = this.f1239d.getVisibility() == 0 ? (int) (this.f1239d.getBottom() + this.f1239d.getTranslationY() + 0.5f) : 0;
            this.f1241g.setBounds(0, bottom, getWidth(), this.f1241g.getIntrinsicHeight() + bottom);
            this.f1241g.draw(canvas);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final w e(View view) {
        if (view instanceof w) {
            return (w) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void f() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    @Override // android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1239d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.F.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        j();
        return this.f1240f.getTitle();
    }

    public final void h() {
        f();
        postDelayed(this.E, 600L);
    }

    public boolean hasIcon() {
        j();
        return this.f1240f.f();
    }

    public boolean hasLogo() {
        j();
        return this.f1240f.q();
    }

    @Override // androidx.appcompat.widget.v
    public boolean hideOverflowMenu() {
        j();
        return this.f1240f.hideOverflowMenu();
    }

    public final void i() {
        f();
        postDelayed(this.D, 600L);
    }

    @Override // androidx.appcompat.widget.v
    public void initFeature(int i11) {
        j();
        if (i11 == 2) {
            this.f1240f.i();
        } else if (i11 == 5) {
            this.f1240f.s();
        } else {
            if (i11 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.f1244j;
    }

    public boolean isInOverlayMode() {
        return this.f1242h;
    }

    @Override // androidx.appcompat.widget.v
    public boolean isOverflowMenuShowPending() {
        j();
        return this.f1240f.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.v
    public boolean isOverflowMenuShowing() {
        j();
        return this.f1240f.isOverflowMenuShowing();
    }

    public void j() {
        if (this.f1238c == null) {
            this.f1238c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f1239d = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f1240f = e(findViewById(R$id.action_bar));
        }
    }

    public final void k() {
        f();
        this.D.run();
    }

    public final boolean l(float f11) {
        this.A.fling(0, 0, 0, (int) f11, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return this.A.getFinalY() > this.f1239d.getHeight();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        j();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, this);
        boolean zB = b(this.f1239d, new Rect(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom()), true, true, false, true);
        ViewCompat.computeSystemWindowInsets(this, windowInsetsCompat, this.f1248n);
        Rect rect = this.f1248n;
        WindowInsetsCompat windowInsetsCompatInset = windowInsetsCompat.inset(rect.left, rect.top, rect.right, rect.bottom);
        this.f1256v = windowInsetsCompatInset;
        if (!this.f1257w.equals(windowInsetsCompatInset)) {
            this.f1257w = this.f1256v;
            zB = true;
        }
        if (this.f1249o.equals(this.f1248n)) {
            if (zB) {
            }
            return windowInsetsCompat.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
        }
        this.f1249o.set(this.f1248n);
        requestLayout();
        return windowInsetsCompat.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i16 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin + paddingLeft;
                int i17 = ((ViewGroup.MarginLayoutParams) cVar).topMargin + paddingTop;
                childAt.layout(i16, i17, measuredWidth + i16, measuredHeight + i17);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int measuredHeight;
        j();
        measureChildWithMargins(this.f1239d, i11, 0, i12, 0);
        c cVar = (c) this.f1239d.getLayoutParams();
        int iMax = Math.max(0, this.f1239d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin + ((ViewGroup.MarginLayoutParams) cVar).rightMargin);
        int iMax2 = Math.max(0, this.f1239d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) cVar).topMargin + ((ViewGroup.MarginLayoutParams) cVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1239d.getMeasuredState());
        boolean z11 = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0;
        if (z11) {
            measuredHeight = this.f1236a;
            if (this.f1243i && this.f1239d.getTabContainer() != null) {
                measuredHeight += this.f1236a;
            }
        } else {
            measuredHeight = this.f1239d.getVisibility() != 8 ? this.f1239d.getMeasuredHeight() : 0;
        }
        this.f1250p.set(this.f1248n);
        this.f1258x = this.f1256v;
        if (this.f1242h || z11 || !c()) {
            this.f1258x = new WindowInsetsCompat.Builder(this.f1258x).setSystemWindowInsets(c3.c.b(this.f1258x.getSystemWindowInsetLeft(), this.f1258x.getSystemWindowInsetTop() + measuredHeight, this.f1258x.getSystemWindowInsetRight(), this.f1258x.getSystemWindowInsetBottom())).build();
        } else {
            Rect rect = this.f1250p;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f1258x = this.f1258x.inset(0, measuredHeight, 0, 0);
        }
        b(this.f1238c, this.f1250p, true, true, true, true);
        if (!this.f1259y.equals(this.f1258x)) {
            WindowInsetsCompat windowInsetsCompat = this.f1258x;
            this.f1259y = windowInsetsCompat;
            ViewCompat.dispatchApplyWindowInsets(this.f1238c, windowInsetsCompat);
        }
        measureChildWithMargins(this.f1238c, i11, 0, i12, 0);
        c cVar2 = (c) this.f1238c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f1238c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin + ((ViewGroup.MarginLayoutParams) cVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f1238c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) cVar2).topMargin + ((ViewGroup.MarginLayoutParams) cVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1238c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i11, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i12, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        if (!this.f1244j || !z11) {
            return false;
        }
        if (l(f12)) {
            a();
        } else {
            k();
        }
        this.f1245k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f11, float f12) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        if (i13 == 0) {
            onNestedPreScroll(view, i11, i12, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        int i15 = this.f1246l + i12;
        this.f1246l = i15;
        setActionBarHideOffset(i15);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        if (i15 == 0) {
            onNestedScroll(view, i11, i12, i13, i14);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        onNestedScroll(view, i11, i12, i13, i14, i15);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i11) {
        this.F.onNestedScrollAccepted(view, view2, i11);
        this.f1246l = getActionBarHideOffset();
        f();
        b bVar = this.f1260z;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            onNestedScrollAccepted(view, view2, i11);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i11) {
        if ((i11 & 2) == 0 || this.f1239d.getVisibility() != 0) {
            return false;
        }
        return this.f1244j;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        return i12 == 0 && onStartNestedScroll(view, view2, i11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.f1244j && !this.f1245k) {
            if (this.f1246l <= this.f1239d.getHeight()) {
                i();
            } else {
                h();
            }
        }
        b bVar = this.f1260z;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i11) {
        if (i11 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i11) {
        super.onWindowSystemUiVisibilityChanged(i11);
        j();
        int i12 = this.f1247m ^ i11;
        this.f1247m = i11;
        boolean z11 = (i11 & 4) == 0;
        boolean z12 = (i11 & 256) != 0;
        b bVar = this.f1260z;
        if (bVar != null) {
            bVar.c(!z12);
            if (z11 || !z12) {
                this.f1260z.a();
            } else {
                this.f1260z.d();
            }
        }
        if ((i12 & 256) == 0 || this.f1260z == null) {
            return;
        }
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        this.f1237b = i11;
        b bVar = this.f1260z;
        if (bVar != null) {
            bVar.onWindowVisibilityChanged(i11);
        }
    }

    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        j();
        this.f1240f.p(sparseArray);
    }

    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        j();
        this.f1240f.m(sparseArray);
    }

    public void setActionBarHideOffset(int i11) {
        f();
        this.f1239d.setTranslationY(-Math.max(0, Math.min(i11, this.f1239d.getHeight())));
    }

    public void setActionBarVisibilityCallback(b bVar) {
        this.f1260z = bVar;
        if (getWindowToken() != null) {
            this.f1260z.onWindowVisibilityChanged(this.f1237b);
            int i11 = this.f1247m;
            if (i11 != 0) {
                onWindowSystemUiVisibilityChanged(i11);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z11) {
        this.f1243i = z11;
    }

    public void setHideOnContentScrollEnabled(boolean z11) {
        if (z11 != this.f1244j) {
            this.f1244j = z11;
            if (z11) {
                return;
            }
            f();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i11) {
        j();
        this.f1240f.setIcon(i11);
    }

    public void setIcon(Drawable drawable) {
        j();
        this.f1240f.setIcon(drawable);
    }

    public void setLogo(int i11) {
        j();
        this.f1240f.n(i11);
    }

    @Override // androidx.appcompat.widget.v
    public void setMenu(Menu menu, androidx.appcompat.view.menu.l.a aVar) {
        j();
        this.f1240f.setMenu(menu, aVar);
    }

    @Override // androidx.appcompat.widget.v
    public void setMenuPrepared() {
        j();
        this.f1240f.setMenuPrepared();
    }

    public void setOverlayMode(boolean z11) {
        this.f1242h = z11;
    }

    public void setShowingForActionMode(boolean z11) {
    }

    public void setUiOptions(int i11) {
    }

    @Override // androidx.appcompat.widget.v
    public void setWindowCallback(Window.Callback callback) {
        j();
        this.f1240f.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.v
    public void setWindowTitle(CharSequence charSequence) {
        j();
        this.f1240f.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.v
    public boolean showOverflowMenu() {
        j();
        return this.f1240f.showOverflowMenu();
    }
}
