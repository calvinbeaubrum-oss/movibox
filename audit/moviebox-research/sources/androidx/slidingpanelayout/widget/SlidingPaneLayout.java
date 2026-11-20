package androidx.slidingpanelayout.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.window.layout.r;
import androidx.window.layout.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k6.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class SlidingPaneLayout extends ViewGroup {
    public static final int LOCK_MODE_LOCKED = 3;
    public static final int LOCK_MODE_LOCKED_CLOSED = 2;
    public static final int LOCK_MODE_LOCKED_OPEN = 1;
    public static final int LOCK_MODE_UNLOCKED = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f12933z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f12936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f12937d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f12939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f12941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12945m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12946n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<e> f12947o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public e f12948p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ViewDragHelper f12949q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12950r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f12951s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Rect f12952t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList<DisableLayerRunnable> f12953u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12954v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public r f12955w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public FoldingFeatureObserver.a f12956x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public FoldingFeatureObserver f12957y;

    /* JADX INFO: compiled from: source.java */
    public class DisableLayerRunnable implements Runnable {
        final View mChildView;

        public DisableLayerRunnable(View view) {
            this.mChildView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() == SlidingPaneLayout.this) {
                this.mChildView.setLayerType(0, null);
                SlidingPaneLayout.this.h(this.mChildView);
            }
            SlidingPaneLayout.this.f12953u.remove(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12959b;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f12958a = parcel.readInt() != 0;
            this.f12959b = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f12958a ? 1 : 0);
            parcel.writeInt(this.f12959b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements FoldingFeatureObserver.a {
        public a() {
        }

        @Override // androidx.slidingpanelayout.widget.FoldingFeatureObserver.a
        public void a(@NonNull r rVar) {
            SlidingPaneLayout.this.f12955w = rVar;
            k6.b bVar = new k6.b();
            bVar.a0(300L);
            bVar.c0(PathInterpolatorCompat.create(0.2f, 0.0f, 0.0f, 1.0f));
            s.a(SlidingPaneLayout.this, bVar);
            SlidingPaneLayout.this.requestLayout();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f12961a = new Rect();

        public b() {
        }

        private void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f12961a;
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean b(View view) {
            return SlidingPaneLayout.this.i(view);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompatObtain);
            a(accessibilityNodeInfoCompat, accessibilityNodeInfoCompatObtain);
            accessibilityNodeInfoCompatObtain.recycle();
            accessibilityNodeInfoCompat.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
            accessibilityNodeInfoCompat.setSource(view);
            Object parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i11);
                if (!b(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (b(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends ViewDragHelper.b {
        public c() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int a(View view, int i11, int i12) {
            d dVar = (d) SlidingPaneLayout.this.f12939g.getLayoutParams();
            if (SlidingPaneLayout.this.j()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + SlidingPaneLayout.this.f12939g.getWidth());
                return Math.max(Math.min(i11, width), width - SlidingPaneLayout.this.f12942j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
            return Math.min(Math.max(i11, paddingLeft), SlidingPaneLayout.this.f12942j + paddingLeft);
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int b(View view, int i11, int i12) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int d(View view) {
            return SlidingPaneLayout.this.f12942j;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void f(int i11, int i12) {
            if (n()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f12949q.c(slidingPaneLayout.f12939g, i12);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void h(int i11, int i12) {
            if (n()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f12949q.c(slidingPaneLayout.f12939g, i12);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void i(View view, int i11) {
            SlidingPaneLayout.this.o();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void j(int i11) {
            if (SlidingPaneLayout.this.f12949q.B() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f12940h != 1.0f) {
                    slidingPaneLayout.c(slidingPaneLayout.f12939g);
                    SlidingPaneLayout.this.f12950r = true;
                } else {
                    slidingPaneLayout.r(slidingPaneLayout.f12939g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.b(slidingPaneLayout2.f12939g);
                    SlidingPaneLayout.this.f12950r = false;
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void k(View view, int i11, int i12, int i13, int i14) {
            SlidingPaneLayout.this.l(i11);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void l(View view, float f11, float f12) {
            int paddingLeft;
            d dVar = (d) view.getLayoutParams();
            if (SlidingPaneLayout.this.j()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
                if (f11 < 0.0f || (f11 == 0.0f && SlidingPaneLayout.this.f12940h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f12942j;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f12939g.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) dVar).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f11 > 0.0f || (f11 == 0.0f && SlidingPaneLayout.this.f12940h > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.f12942j;
                }
            }
            SlidingPaneLayout.this.f12949q.Q(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean m(View view, int i11) {
            if (n()) {
                return ((d) view.getLayoutParams()).f12966b;
            }
            return false;
        }

        public final boolean n() {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.f12943k || slidingPaneLayout.getLockMode() == 3) {
                return false;
            }
            if (SlidingPaneLayout.this.isOpen() && SlidingPaneLayout.this.getLockMode() == 1) {
                return false;
            }
            return SlidingPaneLayout.this.isOpen() || SlidingPaneLayout.this.getLockMode() != 2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int[] f12964e = {R.attr.layout_weight};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f12965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Paint f12968d;

        public d() {
            super(-1, -1);
            this.f12965a = 0.0f;
        }

        public d(int i11, int i12) {
            super(i11, i12);
            this.f12965a = 0.0f;
        }

        public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12965a = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f12964e);
            this.f12965a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }

        public d(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12965a = 0.0f;
        }

        public d(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f12965a = 0.0f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void a(@NonNull View view);

        void b(@NonNull View view);

        void c(@NonNull View view, float f11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends FrameLayout {
        public f(View view) {
            super(view.getContext());
            addView(view);
        }

        @Override // android.view.View
        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    static {
        f12933z = Build.VERSION.SDK_INT >= 29;
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f12934a = 0;
        this.f12940h = 1.0f;
        this.f12947o = new CopyOnWriteArrayList();
        this.f12951s = true;
        this.f12952t = new Rect();
        this.f12953u = new ArrayList<>();
        this.f12956x = new a();
        float f11 = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new b());
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper viewDragHelperO = ViewDragHelper.o(this, 0.5f, new c());
        this.f12949q = viewDragHelperO;
        viewDragHelperO.P(f11 * 400.0f);
        setFoldingFeatureObserver(new FoldingFeatureObserver(w.a(context), z2.a.getMainExecutor(context)));
    }

    @Nullable
    public static Activity e(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static Rect f(@NonNull r rVar, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i11 = iArr[0];
        Rect rect = new Rect(i11, iArr[1], view.getWidth() + i11, iArr[1] + view.getWidth());
        Rect rect2 = new Rect(rVar.getBounds());
        boolean zIntersect = rect2.intersect(rect);
        if ((rect2.width() == 0 && rect2.height() == 0) || !zIntersect) {
            return null;
        }
        rect2.offset(-iArr[0], -iArr[1]);
        return rect2;
    }

    public static int g(View view) {
        return view instanceof f ? ViewCompat.getMinimumWidth(((f) view).getChildAt(0)) : ViewCompat.getMinimumWidth(view);
    }

    private c3.c getSystemGestureInsets() {
        WindowInsetsCompat rootWindowInsets;
        if (!f12933z || (rootWindowInsets = ViewCompat.getRootWindowInsets(this)) == null) {
            return null;
        }
        return rootWindowInsets.getSystemGestureInsets();
    }

    public static int k(@NonNull View view, int i11, int i12) {
        d dVar = (d) view.getLayoutParams();
        return (((ViewGroup.MarginLayoutParams) dVar).width != 0 || dVar.f12965a <= 0.0f) ? View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824) : ViewGroup.getChildMeasureSpec(i11, i12, ((ViewGroup.MarginLayoutParams) dVar).height);
    }

    public static boolean s(View view) {
        return view.isOpaque();
    }

    private void setFoldingFeatureObserver(FoldingFeatureObserver foldingFeatureObserver) {
        this.f12957y = foldingFeatureObserver;
        foldingFeatureObserver.f(this.f12956x);
    }

    public final boolean a(int i11) {
        if (!this.f12938f) {
            this.f12950r = false;
        }
        if (!this.f12951s && !p(1.0f, i11)) {
            return false;
        }
        this.f12950r = false;
        return true;
    }

    public void addPanelSlideListener(@NonNull e eVar) {
        this.f12947o.add(eVar);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i11, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 1) {
            super.addView(new f(view), i11, layoutParams);
        } else {
            super.addView(view, i11, layoutParams);
        }
    }

    public void b(@NonNull View view) {
        Iterator<e> it = this.f12947o.iterator();
        while (it.hasNext()) {
            it.next().b(view);
        }
        sendAccessibilityEvent(32);
    }

    public void c(@NonNull View view) {
        Iterator<e> it = this.f12947o.iterator();
        while (it.hasNext()) {
            it.next().a(view);
        }
        sendAccessibilityEvent(32);
    }

    @Deprecated
    public boolean canSlide() {
        return this.f12938f;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public void close() {
        closePane();
    }

    public boolean closePane() {
        return a(0);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f12949q.n(true)) {
            if (this.f12938f) {
                ViewCompat.postInvalidateOnAnimation(this);
            } else {
                this.f12949q.a();
            }
        }
    }

    public void d(@NonNull View view) {
        Iterator<e> it = this.f12947o.iterator();
        while (it.hasNext()) {
            it.next().c(view, this.f12940h);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i11;
        int right;
        super.draw(canvas);
        Drawable drawable = j() ? this.f12937d : this.f12936c;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (j()) {
            right = childAt.getRight();
            i11 = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i12 = left - intrinsicWidth;
            i11 = left;
            right = i12;
        }
        drawable.setBounds(right, top, i11, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j11) {
        if (j() ^ isOpen()) {
            this.f12949q.O(1);
            c3.c systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                ViewDragHelper viewDragHelper = this.f12949q;
                viewDragHelper.N(Math.max(viewDragHelper.x(), systemGestureInsets.f14554a));
            }
        } else {
            this.f12949q.O(2);
            c3.c systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                ViewDragHelper viewDragHelper2 = this.f12949q;
                viewDragHelper2.N(Math.max(viewDragHelper2.x(), systemGestureInsets2.f14556c));
            }
        }
        d dVar = (d) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.f12938f && !dVar.f12966b && this.f12939g != null) {
            canvas.getClipBounds(this.f12952t);
            if (j()) {
                Rect rect = this.f12952t;
                rect.left = Math.max(rect.left, this.f12939g.getRight());
            } else {
                Rect rect2 = this.f12952t;
                rect2.right = Math.min(rect2.right, this.f12939g.getLeft());
            }
            canvas.clipRect(this.f12952t);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j11);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    @Deprecated
    public int getCoveredFadeColor() {
        return this.f12935b;
    }

    public final int getLockMode() {
        return this.f12954v;
    }

    public int getParallaxDistance() {
        return this.f12944l;
    }

    @Deprecated
    public int getSliderFadeColor() {
        return this.f12934a;
    }

    public void h(View view) {
        ViewCompat.setLayerPaint(view, ((d) view.getLayoutParams()).f12968d);
    }

    public boolean i(View view) {
        if (view == null) {
            return false;
        }
        return this.f12938f && ((d) view.getLayoutParams()).f12967c && this.f12940h > 0.0f;
    }

    public boolean isOpen() {
        return !this.f12938f || this.f12940h == 0.0f;
    }

    public boolean isSlideable() {
        return this.f12938f;
    }

    public boolean j() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public void l(int i11) {
        if (this.f12939g == null) {
            this.f12940h = 0.0f;
            return;
        }
        boolean zJ = j();
        d dVar = (d) this.f12939g.getLayoutParams();
        int width = this.f12939g.getWidth();
        if (zJ) {
            i11 = (getWidth() - i11) - width;
        }
        float paddingRight = (i11 - ((zJ ? getPaddingRight() : getPaddingLeft()) + (zJ ? ((ViewGroup.MarginLayoutParams) dVar).rightMargin : ((ViewGroup.MarginLayoutParams) dVar).leftMargin))) / this.f12942j;
        this.f12940h = paddingRight;
        if (this.f12944l != 0) {
            n(paddingRight);
        }
        d(this.f12939g);
    }

    public final boolean m(int i11) {
        if (!this.f12938f) {
            this.f12950r = true;
        }
        if (!this.f12951s && !p(0.0f, i11)) {
            return false;
        }
        this.f12950r = true;
        return true;
    }

    public final void n(float f11) {
        boolean zJ = j();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt != this.f12939g) {
                float f12 = 1.0f - this.f12941i;
                int i12 = this.f12944l;
                this.f12941i = f11;
                int i13 = ((int) (f12 * i12)) - ((int) ((1.0f - f11) * i12));
                if (zJ) {
                    i13 = -i13;
                }
                childAt.offsetLeftAndRight(i13);
            }
        }
    }

    public void o() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Activity activityE;
        super.onAttachedToWindow();
        this.f12951s = true;
        if (this.f12957y == null || (activityE = e(getContext())) == null) {
            return;
        }
        this.f12957y.e(activityE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f12951s = true;
        FoldingFeatureObserver foldingFeatureObserver = this.f12957y;
        if (foldingFeatureObserver != null) {
            foldingFeatureObserver.g();
        }
        int size = this.f12953u.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f12953u.get(i11).run();
        }
        this.f12953u.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f12938f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f12950r = this.f12949q.G(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f12938f || (this.f12943k && actionMasked != 0)) {
            this.f12949q.b();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.f12949q.b();
            return false;
        }
        if (actionMasked == 0) {
            this.f12943k = false;
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.f12945m = x11;
            this.f12946n = y11;
            if (this.f12949q.G(this.f12939g, (int) x11, (int) y11) && i(this.f12939g)) {
                z11 = true;
            }
            return this.f12949q.R(motionEvent) || z11;
        }
        if (actionMasked == 2) {
            float x12 = motionEvent.getX();
            float y12 = motionEvent.getY();
            float fAbs = Math.abs(x12 - this.f12945m);
            float fAbs2 = Math.abs(y12 - this.f12946n);
            if (fAbs > this.f12949q.A() && fAbs2 > fAbs) {
                this.f12949q.b();
                this.f12943k = true;
                return false;
            }
        }
        z11 = false;
        if (this.f12949q.R(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean zJ = j();
        int i21 = i13 - i11;
        int paddingRight = zJ ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zJ ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f12951s) {
            this.f12940h = (this.f12938f && this.f12950r) ? 0.0f : 1.0f;
        }
        int i22 = paddingRight;
        int i23 = 0;
        while (i23 < childCount) {
            View childAt = getChildAt(i23);
            if (childAt.getVisibility() == 8) {
                i15 = i22;
            } else {
                d dVar = (d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (dVar.f12966b) {
                    int i24 = i21 - paddingLeft;
                    int iMin = (Math.min(paddingRight, i24) - i22) - (((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin);
                    this.f12942j = iMin;
                    int i25 = zJ ? ((ViewGroup.MarginLayoutParams) dVar).rightMargin : ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
                    dVar.f12967c = ((i22 + i25) + iMin) + (measuredWidth / 2) > i24;
                    int i26 = (int) (iMin * this.f12940h);
                    this.f12940h = i26 / iMin;
                    i15 = i22 + i25 + i26;
                    i16 = 0;
                } else if (!this.f12938f || (i17 = this.f12944l) == 0) {
                    i15 = paddingRight;
                    i16 = 0;
                } else {
                    i16 = (int) ((1.0f - this.f12940h) * i17);
                    i15 = paddingRight;
                }
                if (zJ) {
                    i19 = (i21 - i15) + i16;
                    i18 = i19 - measuredWidth;
                } else {
                    i18 = i15 - i16;
                    i19 = i18 + measuredWidth;
                }
                childAt.layout(i18, paddingTop, i19, childAt.getMeasuredHeight() + paddingTop);
                r rVar = this.f12955w;
                paddingRight += childAt.getWidth() + Math.abs((rVar != null && rVar.getOrientation() == r.b.f13204c && this.f12955w.isSeparating()) ? this.f12955w.getBounds().width() : 0);
            }
            i23++;
            i22 = i15;
        }
        if (this.f12951s) {
            if (this.f12938f && this.f12944l != 0) {
                n(this.f12940h);
            }
            r(this.f12939g);
        }
        this.f12951s = false;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0087 A[PHI: r15
  0x0087: PHI (r15v5 float) = (r15v1 float), (r15v6 float) binds: [B:18:0x007e, B:20:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:24:0x0097 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0099  */
    /* JADX WARN: Code duplicated, block: B:26:0x009b  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00da  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:48:0x00eb  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v12 */
    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int paddingTop;
        int iMin;
        int i13;
        int iMax;
        int iMakeMeasureSpec;
        int iMax2;
        int i14;
        int iMakeMeasureSpec2;
        int measuredHeight;
        boolean z11;
        int i15;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        ?? r11 = 0;
        if (mode2 == Integer.MIN_VALUE) {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            iMin = 0;
        } else if (mode2 != 1073741824) {
            iMin = 0;
            paddingTop = 0;
        } else {
            iMin = (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = iMin;
        }
        int iMax3 = Math.max((size - getPaddingLeft()) - getPaddingRight(), 0);
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f12939g = null;
        int i16 = iMax3;
        int i17 = 0;
        boolean z12 = false;
        float f11 = 0.0f;
        while (true) {
            i13 = 8;
            if (i17 >= childCount) {
                break;
            }
            View childAt = getChildAt(i17);
            d dVar = (d) childAt.getLayoutParams();
            int i18 = size;
            if (childAt.getVisibility() == 8) {
                dVar.f12967c = r11;
            } else {
                float f12 = dVar.f12965a;
                if (f12 > 0.0f) {
                    f11 += f12;
                    if (((ViewGroup.MarginLayoutParams) dVar).width != 0) {
                        iMax2 = Math.max(iMax3 - (((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin), (int) r11);
                        i14 = ((ViewGroup.MarginLayoutParams) dVar).width;
                        if (i14 == -2) {
                            if (mode == 0) {
                                i15 = mode;
                            } else {
                                i15 = Integer.MIN_VALUE;
                            }
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, i15);
                        } else if (i14 == -1) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, mode);
                        } else {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                        }
                        childAt.measure(iMakeMeasureSpec2, ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) dVar).height));
                        int measuredWidth = childAt.getMeasuredWidth();
                        measuredHeight = childAt.getMeasuredHeight();
                        if (measuredHeight > iMin) {
                            if (mode2 == Integer.MIN_VALUE) {
                                iMin = Math.min(measuredHeight, paddingTop);
                            } else if (mode2 == 0) {
                                iMin = measuredHeight;
                            }
                        }
                        i16 -= measuredWidth;
                        if (i17 != 0) {
                            if (i16 < 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            dVar.f12966b = z11;
                            z12 |= z11;
                            if (z11) {
                                this.f12939g = childAt;
                            }
                        }
                    }
                } else {
                    iMax2 = Math.max(iMax3 - (((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin), (int) r11);
                    i14 = ((ViewGroup.MarginLayoutParams) dVar).width;
                    if (i14 == -2) {
                        if (mode == 0) {
                            i15 = mode;
                        } else {
                            i15 = Integer.MIN_VALUE;
                        }
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, i15);
                    } else if (i14 == -1) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, mode);
                    } else {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                    }
                    childAt.measure(iMakeMeasureSpec2, ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) dVar).height));
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    measuredHeight = childAt.getMeasuredHeight();
                    if (measuredHeight > iMin) {
                        if (mode2 == Integer.MIN_VALUE) {
                            iMin = Math.min(measuredHeight, paddingTop);
                        } else if (mode2 == 0) {
                            iMin = measuredHeight;
                        }
                    }
                    i16 -= measuredWidth2;
                    if (i17 != 0) {
                        if (i16 < 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        dVar.f12966b = z11;
                        z12 |= z11;
                        if (z11) {
                            this.f12939g = childAt;
                        }
                    }
                }
            }
            i17++;
            size = i18;
            r11 = 0;
        }
        int i19 = size;
        int i21 = i16;
        if (z12 || f11 > 0.0f) {
            int i22 = 0;
            while (i22 < childCount) {
                View childAt2 = getChildAt(i22);
                if (childAt2.getVisibility() != i13) {
                    d dVar2 = (d) childAt2.getLayoutParams();
                    int measuredWidth3 = (((ViewGroup.MarginLayoutParams) dVar2).width != 0 || dVar2.f12965a <= 0.0f) ? childAt2.getMeasuredWidth() : 0;
                    if (z12) {
                        iMax = iMax3 - (((ViewGroup.MarginLayoutParams) dVar2).leftMargin + ((ViewGroup.MarginLayoutParams) dVar2).rightMargin);
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    } else if (dVar2.f12965a > 0.0f) {
                        iMax = measuredWidth3 + ((int) ((dVar2.f12965a * Math.max(0, i21)) / f11));
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    } else {
                        iMax = measuredWidth3;
                        iMakeMeasureSpec = 0;
                    }
                    int iK = k(childAt2, i12, getPaddingTop() + getPaddingBottom());
                    if (measuredWidth3 != iMax) {
                        childAt2.measure(iMakeMeasureSpec, iK);
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        if (measuredHeight2 > iMin) {
                            if (mode2 == Integer.MIN_VALUE) {
                                measuredHeight2 = Math.min(measuredHeight2, paddingTop);
                            } else if (mode2 == 0) {
                            }
                            iMin = measuredHeight2;
                        }
                    }
                }
                i22++;
                i13 = 8;
            }
        }
        ArrayList<Rect> arrayListQ = q();
        if (arrayListQ != null && !z12) {
            for (int i23 = 0; i23 < childCount; i23++) {
                View childAt3 = getChildAt(i23);
                if (childAt3.getVisibility() != 8) {
                    Rect rect = arrayListQ.get(i23);
                    d dVar3 = (d) childAt3.getLayoutParams();
                    int i24 = ((ViewGroup.MarginLayoutParams) dVar3).leftMargin + ((ViewGroup.MarginLayoutParams) dVar3).rightMargin;
                    int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(childAt3.getMeasuredHeight(), 1073741824);
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), Integer.MIN_VALUE), iMakeMeasureSpec3);
                    if ((childAt3.getMeasuredWidthAndState() & 16777216) == 1 || (g(childAt3) != 0 && rect.width() < g(childAt3))) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(iMax3 - i24, 1073741824), iMakeMeasureSpec3);
                        if (i23 != 0) {
                            dVar3.f12966b = true;
                            this.f12939g = childAt3;
                            z12 = true;
                        }
                    } else {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), iMakeMeasureSpec3);
                    }
                }
            }
        }
        setMeasuredDimension(i19, iMin + getPaddingTop() + getPaddingBottom());
        this.f12938f = z12;
        if (this.f12949q.B() == 0 || z12) {
            return;
        }
        this.f12949q.a();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f12958a) {
            openPane();
        } else {
            closePane();
        }
        this.f12950r = savedState.f12958a;
        setLockMode(savedState.f12959b);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12958a = isSlideable() ? isOpen() : this.f12950r;
        savedState.f12959b = this.f12954v;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 != i13) {
            this.f12951s = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f12938f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f12949q.H(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.f12945m = x11;
            this.f12946n = y11;
        } else if (actionMasked == 1 && i(this.f12939g)) {
            float x12 = motionEvent.getX();
            float y12 = motionEvent.getY();
            float f11 = x12 - this.f12945m;
            float f12 = y12 - this.f12946n;
            int iA = this.f12949q.A();
            if ((f11 * f11) + (f12 * f12) < iA * iA && this.f12949q.G(this.f12939g, (int) x12, (int) y12)) {
                a(0);
            }
        }
        return true;
    }

    public void open() {
        openPane();
    }

    public boolean openPane() {
        return m(0);
    }

    public boolean p(float f11, int i11) {
        int paddingLeft;
        if (!this.f12938f) {
            return false;
        }
        boolean zJ = j();
        d dVar = (d) this.f12939g.getLayoutParams();
        if (zJ) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + (f11 * this.f12942j)) + this.f12939g.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin + (f11 * this.f12942j));
        }
        ViewDragHelper viewDragHelper = this.f12949q;
        View view = this.f12939g;
        if (!viewDragHelper.S(view, paddingLeft, view.getTop())) {
            return false;
        }
        o();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    public final ArrayList<Rect> q() {
        Rect rectF;
        r rVar = this.f12955w;
        if (rVar == null || !rVar.isSeparating() || this.f12955w.getBounds().left == 0 || this.f12955w.getBounds().top != 0 || (rectF = f(this.f12955w, this)) == null) {
            return null;
        }
        Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), Math.max(getPaddingLeft(), rectF.left), getHeight() - getPaddingBottom());
        int width = getWidth() - getPaddingRight();
        return new ArrayList<>(Arrays.asList(rect, new Rect(Math.min(width, rectF.right), getPaddingTop(), width, getHeight() - getPaddingBottom())));
    }

    public void r(View view) {
        int left;
        int right;
        int top;
        int bottom;
        View childAt;
        View view2 = view;
        boolean zJ = j();
        int width = zJ ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zJ ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !s(view)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        int childCount = getChildCount();
        int i11 = 0;
        while (i11 < childCount && (childAt = getChildAt(i11)) != view2) {
            if (childAt.getVisibility() != 8) {
                childAt.setVisibility((Math.max(zJ ? paddingLeft : width, childAt.getLeft()) < left || Math.max(paddingTop, childAt.getTop()) < top || Math.min(zJ ? width : paddingLeft, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i11++;
            view2 = view;
            zJ = zJ;
        }
    }

    public void removePanelSlideListener(@NonNull e eVar) {
        this.f12947o.remove(eVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@NonNull View view) {
        if (view.getParent() instanceof f) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.f12938f) {
            return;
        }
        this.f12950r = view == this.f12939g;
    }

    @Deprecated
    public void setCoveredFadeColor(int i11) {
        this.f12935b = i11;
    }

    public final void setLockMode(int i11) {
        this.f12954v = i11;
    }

    @Deprecated
    public void setPanelSlideListener(@Nullable e eVar) {
        e eVar2 = this.f12948p;
        if (eVar2 != null) {
            removePanelSlideListener(eVar2);
        }
        if (eVar != null) {
            addPanelSlideListener(eVar);
        }
        this.f12948p = eVar;
    }

    public void setParallaxDistance(int i11) {
        this.f12944l = i11;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.f12936c = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.f12937d = drawable;
    }

    @Deprecated
    public void setShadowResource(int i11) {
        setShadowDrawableLeft(getResources().getDrawable(i11));
    }

    public void setShadowResourceLeft(int i11) {
        setShadowDrawableLeft(z2.a.getDrawable(getContext(), i11));
    }

    public void setShadowResourceRight(int i11) {
        setShadowDrawableRight(z2.a.getDrawable(getContext(), i11));
    }

    @Deprecated
    public void setSliderFadeColor(int i11) {
        this.f12934a = i11;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }
}
