package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.R$attr;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    public static final float C = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final a D = new a();
    public static final int[] E = {R.attr.fillViewport};
    public final c A;
    public DifferentialMotionFlingController B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f8067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f8069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OverScroller f8070d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f8074i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8075j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public VelocityTracker f8076k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8077l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8078m;

    @NonNull
    public EdgeEffect mEdgeGlowBottom;

    @NonNull
    public EdgeEffect mEdgeGlowTop;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8079n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8080o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8081p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8082q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int[] f8083r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int[] f8084s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f8085t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f8086u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SavedState f8087v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final NestedScrollingParentHelper f8088w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final NestedScrollingChildHelper f8089x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f8090y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public d f8091z;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int scrollPosition;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.scrollPosition);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfoCompat.setScrollable(true);
            if (nestedScrollView.getScrollY() > 0) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            if (super.performAccessibilityAction(view, i11, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i11 != 4096) {
                if (i11 == 8192 || i11 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.H(0, iMax, true);
                    return true;
                }
                if (i11 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.H(0, iMin, true);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class b {
        public static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements DifferentialMotionFlingTarget {
        public c() {
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public float getScaledScrollFactor() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public boolean startDifferentialMotionFling(float f11) {
            if (f11 == 0.0f) {
                return false;
            }
            stopDifferentialMotionFling();
            NestedScrollView.this.fling((int) f11);
            return true;
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public void stopDifferentialMotionFling() {
            NestedScrollView.this.f8070d.abortAnimation();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(@NonNull NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14);
    }

    public NestedScrollView(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.nestedScrollViewStyle);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f8069c = new Rect();
        this.f8072g = true;
        this.f8073h = false;
        this.f8074i = null;
        this.f8075j = false;
        this.f8078m = true;
        this.f8082q = -1;
        this.f8083r = new int[2];
        this.f8084s = new int[2];
        c cVar = new c();
        this.A = cVar;
        this.B = new DifferentialMotionFlingController(getContext(), cVar);
        this.mEdgeGlowTop = g.a(context, attributeSet);
        this.mEdgeGlowBottom = g.a(context, attributeSet);
        this.f8067a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        o();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E, i11, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f8088w = new NestedScrollingParentHelper(this);
        this.f8089x = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, D);
    }

    private boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int e(int i11, int i12, int i13) {
        if (i12 >= i13 || i11 < 0) {
            return 0;
        }
        return i12 + i11 > i13 ? i13 - i12 : i11;
    }

    public static boolean s(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && s((View) parent, view2);
    }

    public final boolean A(int i11, int i12, int i13) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i14 = height + scrollY;
        boolean z11 = false;
        boolean z12 = i11 == 33;
        View viewK = k(z12, i12, i13);
        if (viewK == null) {
            viewK = this;
        }
        if (i12 < scrollY || i13 > i14) {
            B(z12 ? i12 - scrollY : i13 - i14, 0, 1, true);
            z11 = true;
        }
        if (viewK != findFocus()) {
            viewK.requestFocus(i11);
        }
        return z11;
    }

    public final int B(int i11, int i12, int i13, boolean z11) {
        int i14;
        int i15;
        VelocityTracker velocityTracker;
        if (i13 == 1) {
            startNestedScroll(2, i13);
        }
        if (dispatchNestedPreScroll(0, i11, this.f8084s, this.f8083r, i13)) {
            i14 = i11 - this.f8084s[1];
            i15 = this.f8083r[1];
        } else {
            i14 = i11;
            i15 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        boolean z12 = c() && !z11;
        boolean z13 = w(0, i14, 0, scrollY, 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent(i13);
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.f8084s;
        iArr[1] = 0;
        dispatchNestedScroll(0, scrollY2, 0, i14 - scrollY2, this.f8083r, i13, iArr);
        int i16 = i15 + this.f8083r[1];
        int i17 = i14 - this.f8084s[1];
        int i18 = scrollY + i17;
        if (i18 < 0) {
            if (z12) {
                g.d(this.mEdgeGlowTop, (-i17) / getHeight(), i12 / getWidth());
                if (!this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
        } else if (i18 > scrollRange && z12) {
            g.d(this.mEdgeGlowBottom, i17 / getHeight(), 1.0f - (i12 / getWidth()));
            if (!this.mEdgeGlowTop.isFinished()) {
                this.mEdgeGlowTop.onRelease();
            }
        }
        if (!this.mEdgeGlowTop.isFinished() || !this.mEdgeGlowBottom.isFinished()) {
            postInvalidateOnAnimation();
        } else if (z13 && i13 == 0 && (velocityTracker = this.f8076k) != null) {
            velocityTracker.clear();
        }
        if (i13 == 1) {
            stopNestedScroll(i13);
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
        return i16;
    }

    public final void C(View view) {
        view.getDrawingRect(this.f8069c);
        offsetDescendantRectToMyCoords(view, this.f8069c);
        int iF = f(this.f8069c);
        if (iF != 0) {
            scrollBy(0, iF);
        }
    }

    public final boolean D(Rect rect, boolean z11) {
        int iF = f(rect);
        boolean z12 = iF != 0;
        if (z12) {
            if (z11) {
                scrollBy(0, iF);
            } else {
                smoothScrollBy(0, iF);
            }
        }
        return z12;
    }

    public final boolean E(@NonNull EdgeEffect edgeEffect, int i11) {
        if (i11 > 0) {
            return true;
        }
        return l(-i11) < g.b(edgeEffect) * ((float) getHeight());
    }

    public final void F(int i11, int i12, int i13, boolean z11) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f8068b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f8070d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i12 + scrollY, Math.max(0, height - height2))) - scrollY, i13);
            z(z11);
        } else {
            if (!this.f8070d.isFinished()) {
                a();
            }
            scrollBy(i11, i12);
        }
        this.f8068b = AnimationUtils.currentAnimationTimeMillis();
    }

    public void G(int i11, int i12, int i13, boolean z11) {
        F(i11 - getScrollX(), i12 - getScrollY(), i13, z11);
    }

    public void H(int i11, int i12, boolean z11) {
        G(i11, i12, 250, z11);
    }

    public final boolean I(MotionEvent motionEvent) {
        boolean z11;
        if (g.b(this.mEdgeGlowTop) != 0.0f) {
            g.d(this.mEdgeGlowTop, 0.0f, motionEvent.getX() / getWidth());
            z11 = true;
        } else {
            z11 = false;
        }
        if (g.b(this.mEdgeGlowBottom) == 0.0f) {
            return z11;
        }
        g.d(this.mEdgeGlowBottom, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public final void a() {
        this.f8070d.abortAnimation();
        stopNestedScroll(1);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i11);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i11, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public boolean arrowScroll(int i11) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i11);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !t(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i11 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i11 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i11 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            B(maxScrollAmount, 0, 1, true);
        } else {
            viewFindNextFocus.getDrawingRect(this.f8069c);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f8069c);
            B(f(this.f8069c), 0, 1, true);
            viewFindNextFocus.requestFocus(i11);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && r(viewFindFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public final boolean c() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f8070d.isFinished()) {
            return;
        }
        this.f8070d.computeScrollOffset();
        int currY = this.f8070d.getCurrY();
        int iG = g(currY - this.f8086u);
        this.f8086u = currY;
        int[] iArr = this.f8084s;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, iG, iArr, null, 1);
        int i11 = iG - this.f8084s[1];
        int scrollRange = getScrollRange();
        if (i11 != 0) {
            int scrollY = getScrollY();
            w(0, i11, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i12 = i11 - scrollY2;
            int[] iArr2 = this.f8084s;
            iArr2[1] = 0;
            dispatchNestedScroll(0, scrollY2, 0, i12, this.f8083r, 1, iArr2);
            i11 = i12 - this.f8084s[1];
        }
        if (i11 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                if (i11 < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int) this.f8070d.getCurrVelocity());
                    }
                } else if (this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb((int) this.f8070d.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f8070d.isFinished()) {
            stopNestedScroll(1);
        } else {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f11, float f12, boolean z11) {
        return this.f8089x.dispatchNestedFling(f11, f12, z11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f11, float f12) {
        return this.f8089x.dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i11, int i12, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i11, i12, iArr, iArr2, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i11, int i12, @Nullable int[] iArr, @Nullable int[] iArr2, int i13) {
        return this.f8089x.dispatchNestedPreScroll(i11, i12, iArr, iArr2, i13);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i11, int i12, int i13, int i14, @Nullable int[] iArr, int i15, @NonNull int[] iArr2) {
        this.f8089x.dispatchNestedScroll(i11, i12, i13, i14, iArr, i15, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, @Nullable int[] iArr) {
        return this.f8089x.dispatchNestedScroll(i11, i12, i13, i14, iArr);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, @Nullable int[] iArr, int i15) {
        return this.f8089x.dispatchNestedScroll(i11, i12, i13, i14, iArr, i15);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int paddingLeft2 = 0;
        if (!this.mEdgeGlowTop.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            this.mEdgeGlowTop.setSize(width, height);
            if (this.mEdgeGlowTop.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        if (this.mEdgeGlowBottom.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (b.a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            paddingLeft2 = getPaddingLeft();
        }
        if (b.a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        this.mEdgeGlowBottom.setSize(width2, height2);
        if (this.mEdgeGlowBottom.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        this.f8069c.setEmpty();
        boolean zD = d();
        int i11 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        if (!zD) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(TsExtractor.TS_STREAM_TYPE_HDMV_DTS)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return keyEvent.isAltPressed() ? fullScroll(33) : arrowScroll(33);
        }
        if (keyCode == 20) {
            return keyEvent.isAltPressed() ? fullScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS) : arrowScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        }
        if (keyCode == 62) {
            if (keyEvent.isShiftPressed()) {
                i11 = 33;
            }
            pageScroll(i11);
            return false;
        }
        if (keyCode == 92) {
            return fullScroll(33);
        }
        if (keyCode == 93) {
            return fullScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        }
        if (keyCode == 122) {
            pageScroll(33);
            return false;
        }
        if (keyCode != 123) {
            return false;
        }
        pageScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        return false;
    }

    public int f(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i11 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i12 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i11 - verticalFadingEdgeLength : i11;
        int i13 = rect.bottom;
        if (i13 > i12 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i12, (childAt.getBottom() + layoutParams.bottomMargin) - i11);
        }
        if (rect.top >= scrollY || i13 >= i12) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i12 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    public void fling(int i11) {
        if (getChildCount() > 0) {
            this.f8070d.fling(getScrollX(), getScrollY(), 0, i11, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, 0);
            z(true);
        }
    }

    public boolean fullScroll(int i11) {
        int childCount;
        boolean z11 = i11 == 130;
        int height = getHeight();
        Rect rect = this.f8069c;
        rect.top = 0;
        rect.bottom = height;
        if (z11 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f8069c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f8069c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f8069c;
        return A(i11, rect3.top, rect3.bottom);
    }

    public int g(int i11) {
        int height = getHeight();
        if (i11 > 0 && g.b(this.mEdgeGlowTop) != 0.0f) {
            int iRound = Math.round(((-height) / 4.0f) * g.d(this.mEdgeGlowTop, ((-i11) * 4.0f) / height, 0.5f));
            if (iRound != i11) {
                this.mEdgeGlowTop.finish();
            }
            return i11 - iRound;
        }
        if (i11 >= 0 || g.b(this.mEdgeGlowBottom) == 0.0f) {
            return i11;
        }
        float f11 = height;
        int iRound2 = Math.round((f11 / 4.0f) * g.d(this.mEdgeGlowBottom, (i11 * 4.0f) / f11, 0.5f));
        if (iRound2 != i11) {
            this.mEdgeGlowBottom.finish();
        }
        return i11 - iRound2;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f8088w.getNestedScrollAxes();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.f8090y == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f8090y = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f8090y;
    }

    public final void h(int i11) {
        if (i11 != 0) {
            if (this.f8078m) {
                smoothScrollBy(0, i11);
            } else {
                scrollBy(0, i11);
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i11) {
        return this.f8089x.hasNestedScrollingParent(i11);
    }

    public final boolean i(int i11) {
        if (g.b(this.mEdgeGlowTop) != 0.0f) {
            if (E(this.mEdgeGlowTop, i11)) {
                this.mEdgeGlowTop.onAbsorb(i11);
            } else {
                fling(-i11);
            }
        } else {
            if (g.b(this.mEdgeGlowBottom) == 0.0f) {
                return false;
            }
            int i12 = -i11;
            if (E(this.mEdgeGlowBottom, i12)) {
                this.mEdgeGlowBottom.onAbsorb(i12);
            } else {
                fling(i12);
            }
        }
        return true;
    }

    public boolean isFillViewport() {
        return this.f8077l;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f8089x.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.f8078m;
    }

    public final void j() {
        this.f8082q = -1;
        this.f8075j = false;
        x();
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004f  */
    public final View k(boolean z11, int i11, int i12) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z12 = false;
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = focusables.get(i13);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i11 < bottom && top < i12) {
                boolean z13 = i11 < top && bottom < i12;
                if (view == null) {
                    view = view2;
                    z12 = z13;
                } else {
                    boolean z14 = (z11 && top < view.getTop()) || (!z11 && bottom > view.getBottom());
                    if (z12) {
                        if (z13 && z14) {
                            view = view2;
                        }
                    } else if (z13) {
                        view = view2;
                        z12 = true;
                    } else if (z14) {
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    public final float l(int i11) {
        double dLog = Math.log((Math.abs(i11) * 0.35f) / (this.f8067a * 0.015f));
        float f11 = C;
        return (float) (((double) (this.f8067a * 0.015f)) * Math.exp((((double) f11) / (((double) f11) - 1.0d)) * dLog));
    }

    public final boolean m(int i11, int i12) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i12 >= childAt.getTop() - scrollY && i12 < childAt.getBottom() - scrollY && i11 >= childAt.getLeft() && i11 < childAt.getRight();
    }

    @Override // android.view.ViewGroup
    public void measureChild(@NonNull View view, int i11, int i12) {
        view.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i12, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final void n() {
        VelocityTracker velocityTracker = this.f8076k;
        if (velocityTracker == null) {
            this.f8076k = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public final void o() {
        this.f8070d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f8079n = viewConfiguration.getScaledTouchSlop();
        this.f8080o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f8081p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8073h = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        int i11;
        float axisValue;
        int width;
        if (motionEvent.getAction() == 8 && !this.f8075j) {
            if (MotionEventCompat.isFromSource(motionEvent, 2)) {
                i11 = 9;
                axisValue = motionEvent.getAxisValue(9);
                width = (int) motionEvent.getX();
            } else if (MotionEventCompat.isFromSource(motionEvent, 4194304)) {
                axisValue = motionEvent.getAxisValue(26);
                width = getWidth() / 2;
                i11 = 26;
            } else {
                i11 = 0;
                axisValue = 0.0f;
                width = 0;
            }
            if (axisValue != 0.0f) {
                B(-((int) (axisValue * getVerticalScrollFactorCompat())), width, 1, MotionEventCompat.isFromSource(motionEvent, 8194));
                if (i11 != 0) {
                    this.B.onMotionEvent(motionEvent, i11);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007e  */
    /* JADX WARN: Code duplicated, block: B:33:0x009c  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z11 = true;
        if (action == 2 && this.f8075j) {
            return true;
        }
        int i11 = action & 255;
        if (i11 == 0) {
            int y11 = (int) motionEvent.getY();
            if (m((int) motionEvent.getX(), y11)) {
                this.f8071f = y11;
                this.f8082q = motionEvent.getPointerId(0);
                n();
                this.f8076k.addMovement(motionEvent);
                this.f8070d.computeScrollOffset();
                if (!I(motionEvent) && this.f8070d.isFinished()) {
                    z11 = false;
                }
                this.f8075j = z11;
                startNestedScroll(2, 0);
            } else {
                if (!I(motionEvent) && this.f8070d.isFinished()) {
                    z11 = false;
                }
                this.f8075j = z11;
                x();
            }
        } else if (i11 == 1) {
            this.f8075j = false;
            this.f8082q = -1;
            x();
            if (this.f8070d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else if (i11 == 2) {
            int i12 = this.f8082q;
            if (i12 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i12);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i12 + " in onInterceptTouchEvent");
                } else {
                    int y12 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y12 - this.f8071f) > this.f8079n && (2 & getNestedScrollAxes()) == 0) {
                        this.f8075j = true;
                        this.f8071f = y12;
                        p();
                        this.f8076k.addMovement(motionEvent);
                        this.f8085t = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i11 == 3) {
            this.f8075j = false;
            this.f8082q = -1;
            x();
            if (this.f8070d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else if (i11 == 6) {
            v(motionEvent);
        }
        return this.f8075j;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        int measuredHeight = 0;
        this.f8072g = false;
        View view = this.f8074i;
        if (view != null && s(view, this)) {
            C(this.f8074i);
        }
        this.f8074i = null;
        if (!this.f8073h) {
            if (this.f8087v != null) {
                scrollTo(getScrollX(), this.f8087v.scrollPosition);
                this.f8087v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i14 - i12) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iE = e(scrollY, paddingTop, measuredHeight);
            if (iE != scrollY) {
                scrollTo(getScrollX(), iE);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f8073h = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.f8077l && View.MeasureSpec.getMode(i12) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f11, float f12, boolean z11) {
        if (z11) {
            return false;
        }
        dispatchNestedFling(0.0f, f12, true);
        fling((int) f12);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f11, float f12) {
        return dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i11, int i12, @NonNull int[] iArr) {
        onNestedPreScroll(view, i11, i12, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i11, int i12, @NonNull int[] iArr, int i13) {
        dispatchNestedPreScroll(i11, i12, iArr, null, i13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14) {
        u(i14, 0, null);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15) {
        u(i14, i15, null);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15, @NonNull int[] iArr) {
        u(i14, i15, iArr);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i11) {
        onNestedScrollAccepted(view, view2, i11, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i11, int i12) {
        this.f8088w.onNestedScrollAccepted(view, view2, i11, i12);
        startNestedScroll(2, i12);
    }

    @Override // android.view.View
    public void onOverScrolled(int i11, int i12, boolean z11, boolean z12) {
        super.scrollTo(i11, i12);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i11, Rect rect) {
        if (i11 == 2) {
            i11 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        } else if (i11 == 1) {
            i11 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i11) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i11);
        if (viewFindNextFocus == null || r(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i11, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8087v = savedState;
        requestLayout();
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        d dVar = this.f8091z;
        if (dVar != null) {
            dVar.a(this, i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !t(viewFindFocus, 0, i14)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f8069c);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f8069c);
        h(f(this.f8069c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i11) {
        return onStartNestedScroll(view, view2, i11, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i11, int i12) {
        return (i11 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i11) {
        this.f8088w.onStopNestedScroll(view, i11);
        stopNestedScroll(i11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        ViewParent parent;
        p();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f8085t = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.f8085t);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f8076k;
                velocityTracker.computeCurrentVelocity(1000, this.f8081p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f8082q);
                if (Math.abs(yVelocity) >= this.f8080o) {
                    if (!i(yVelocity)) {
                        int i11 = -yVelocity;
                        float f11 = i11;
                        if (!dispatchNestedPreFling(0.0f, f11)) {
                            dispatchNestedFling(0.0f, f11, true);
                            fling(i11);
                        }
                    }
                } else if (this.f8070d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                j();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f8082q);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f8082q + " in onTouchEvent");
                } else {
                    int y11 = (int) motionEvent.getY(iFindPointerIndex);
                    int i12 = this.f8071f - y11;
                    int iY = i12 - y(i12, motionEvent.getX(iFindPointerIndex));
                    if (!this.f8075j && Math.abs(iY) > this.f8079n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f8075j = true;
                        iY = iY > 0 ? iY - this.f8079n : iY + this.f8079n;
                    }
                    if (this.f8075j) {
                        int iB = B(iY, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.f8071f = y11 - iB;
                        this.f8085t += iB;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f8075j && getChildCount() > 0 && this.f8070d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                j();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f8071f = (int) motionEvent.getY(actionIndex);
                this.f8082q = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                v(motionEvent);
                this.f8071f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f8082q));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f8075j && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f8070d.isFinished()) {
                a();
            }
            q((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.f8076k;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public final void p() {
        if (this.f8076k == null) {
            this.f8076k = VelocityTracker.obtain();
        }
    }

    public boolean pageScroll(int i11) {
        boolean z11 = i11 == 130;
        int height = getHeight();
        if (z11) {
            this.f8069c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f8069c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f8069c.top = getScrollY() - height;
            Rect rect2 = this.f8069c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f8069c;
        int i12 = rect3.top;
        int i13 = height + i12;
        rect3.bottom = i13;
        return A(i11, i12, i13);
    }

    public final void q(int i11, int i12) {
        this.f8071f = i11;
        this.f8082q = i12;
        startNestedScroll(2, 0);
    }

    public final boolean r(View view) {
        return !t(view, 0, getHeight());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f8072g) {
            this.f8074i = view2;
        } else {
            C(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(@NonNull View view, Rect rect, boolean z11) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return D(rect, z11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z11) {
        if (z11) {
            x();
        }
        super.requestDisallowInterceptTouchEvent(z11);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f8072g = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i11, int i12) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iE = e(i11, width, width2);
            int iE2 = e(i12, height, height2);
            if (iE == getScrollX() && iE2 == getScrollY()) {
                return;
            }
            super.scrollTo(iE, iE2);
        }
    }

    public void setFillViewport(boolean z11) {
        if (z11 != this.f8077l) {
            this.f8077l = z11;
            requestLayout();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z11) {
        this.f8089x.setNestedScrollingEnabled(z11);
    }

    public void setOnScrollChangeListener(@Nullable d dVar) {
        this.f8091z = dVar;
    }

    public void setSmoothScrollingEnabled(boolean z11) {
        this.f8078m = z11;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i11, int i12) {
        F(i11, i12, 250, false);
    }

    public final void smoothScrollBy(int i11, int i12, int i13) {
        F(i11, i12, i13, false);
    }

    public final void smoothScrollTo(int i11, int i12) {
        G(i11, i12, 250, false);
    }

    public final void smoothScrollTo(int i11, int i12, int i13) {
        G(i11, i12, i13, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i11) {
        return startNestedScroll(i11, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i11, int i12) {
        return this.f8089x.startNestedScroll(i11, i12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i11) {
        this.f8089x.stopNestedScroll(i11);
    }

    public final boolean t(View view, int i11, int i12) {
        view.getDrawingRect(this.f8069c);
        offsetDescendantRectToMyCoords(view, this.f8069c);
        return this.f8069c.bottom + i11 >= getScrollY() && this.f8069c.top - i11 <= getScrollY() + i12;
    }

    public final void u(int i11, int i12, @Nullable int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i11);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f8089x.dispatchNestedScroll(0, scrollY2, 0, i11 - scrollY2, null, i12, iArr);
    }

    public final void v(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f8082q) {
            int i11 = actionIndex == 0 ? 1 : 0;
            this.f8071f = (int) motionEvent.getY(i11);
            this.f8082q = motionEvent.getPointerId(i11);
            VelocityTracker velocityTracker = this.f8076k;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0057  */
    /* JADX WARN: Code duplicated, block: B:40:0x005a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x005c  */
    /* JADX WARN: Code duplicated, block: B:42:0x005e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0061  */
    /* JADX WARN: Code duplicated, block: B:49:0x0083 A[ADDED_TO_REGION] */
    public boolean w(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z11) {
        boolean z12;
        boolean z13;
        int overScrollMode = getOverScrollMode();
        boolean z14 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z15 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z16 = overScrollMode == 0 || (overScrollMode == 1 && z14);
        boolean z17 = overScrollMode == 0 || (overScrollMode == 1 && z15);
        int i19 = i13 + i11;
        int i21 = !z16 ? 0 : i17;
        int i22 = i14 + i12;
        int i23 = !z17 ? 0 : i18;
        int i24 = -i21;
        int i25 = i21 + i15;
        int i26 = -i23;
        int i27 = i23 + i16;
        if (i19 <= i25) {
            if (i19 < i24) {
                i19 = i24;
            } else {
                z12 = false;
            }
            if (i22 > i27) {
                if (i22 < i26) {
                    i22 = i26;
                } else {
                    z13 = false;
                }
                if (z13 && !hasNestedScrollingParent(1)) {
                    this.f8070d.springBack(i19, i22, 0, 0, 0, getScrollRange());
                }
                onOverScrolled(i19, i22, z12, z13);
                return !z12 || z13;
            }
            i22 = i27;
            z13 = true;
            if (z13) {
                this.f8070d.springBack(i19, i22, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i19, i22, z12, z13);
            if (z12) {
            }
        }
        i19 = i25;
        z12 = true;
        if (i22 > i27) {
            if (i22 < i26) {
                i22 = i26;
            } else {
                z13 = false;
            }
            if (z13) {
                this.f8070d.springBack(i19, i22, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i19, i22, z12, z13);
            if (z12) {
            }
        }
        i22 = i27;
        z13 = true;
        if (z13) {
            this.f8070d.springBack(i19, i22, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i19, i22, z12, z13);
        if (z12) {
        }
    }

    public final void x() {
        VelocityTracker velocityTracker = this.f8076k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f8076k = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0061  */
    public final int y(int i11, float f11) {
        float fD;
        int iRound;
        float width = f11 / getWidth();
        float height = i11 / getHeight();
        float f12 = 0.0f;
        if (g.b(this.mEdgeGlowTop) == 0.0f) {
            if (g.b(this.mEdgeGlowBottom) != 0.0f) {
                fD = g.d(this.mEdgeGlowBottom, height, 1.0f - width);
                if (g.b(this.mEdgeGlowBottom) == 0.0f) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
            iRound = Math.round(f12 * getHeight());
            if (iRound != 0) {
                invalidate();
            }
            return iRound;
        }
        fD = -g.d(this.mEdgeGlowTop, -height, width);
        if (g.b(this.mEdgeGlowTop) == 0.0f) {
            this.mEdgeGlowTop.onRelease();
        }
        f12 = fD;
        iRound = Math.round(f12 * getHeight());
        if (iRound != 0) {
            invalidate();
        }
        return iRound;
    }

    public final void z(boolean z11) {
        if (z11) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.f8086u = getScrollY();
        postInvalidateOnAnimation();
    }
}
