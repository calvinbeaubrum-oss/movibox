package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent3, NestedScrollingParent2, NestedScrollingChild3, NestedScrollingChild2, NestedScrollingParent, NestedScrollingChild {
    public static final int DEFAULT = 1;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    public static final int LARGE = 0;
    public static final String Q = "SwipeRefreshLayout";
    public static final int[] R = {R.attr.enabled};
    public int A;
    public int B;
    public int C;
    public androidx.swiperefreshlayout.widget.b D;
    public Animation E;
    public Animation F;
    public Animation G;
    public Animation H;
    public Animation I;
    public boolean J;
    public int K;
    public boolean L;
    public boolean M;
    public Animation.AnimationListener N;
    public final Animation O;
    public final Animation P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f12997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f12998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13000d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f13001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f13002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NestedScrollingParentHelper f13003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final NestedScrollingChildHelper f13004i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f13005j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f13006k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f13007l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13008m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13009n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13010o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13011p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13012q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13013r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13014s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13015t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f13016u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DecelerateInterpolator f13017v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public androidx.swiperefreshlayout.widget.a f13018w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13019x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13020y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f13021z;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f13022a;

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
            this.f13022a = parcel.readByte() != 0;
        }

        public SavedState(Parcelable parcelable, boolean z11) {
            super(parcelable);
            this.f13022a = z11;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeByte(this.f13022a ? (byte) 1 : (byte) 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f12999c) {
                swipeRefreshLayout.j();
                return;
            }
            swipeRefreshLayout.D.setAlpha(255);
            SwipeRefreshLayout.this.D.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.J && (jVar = swipeRefreshLayout2.f12998b) != null) {
                jVar.a();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.f13010o = swipeRefreshLayout3.f13018w.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c extends Animation {
        public c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13027b;

        public d(int i11, int i12) {
            this.f13026a = i11;
            this.f13027b = i12;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            androidx.swiperefreshlayout.widget.b bVar = SwipeRefreshLayout.this.D;
            int i11 = this.f13026a;
            bVar.setAlpha((int) (i11 + ((this.f13027b - i11) * f11)));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f13015t) {
                return;
            }
            swipeRefreshLayout.p(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class f extends Animation {
        public f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int iAbs = !swipeRefreshLayout.L ? swipeRefreshLayout.B - Math.abs(swipeRefreshLayout.A) : swipeRefreshLayout.B;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i11 = swipeRefreshLayout2.f13020y;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i11 + ((int) ((iAbs - i11) * f11))) - swipeRefreshLayout2.f13018w.getTop());
            SwipeRefreshLayout.this.D.e(1.0f - f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class g extends Animation {
        public g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout.this.h(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class h extends Animation {
        public h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f12 = swipeRefreshLayout.f13021z;
            swipeRefreshLayout.setAnimationProgress(f12 + ((-f12) * f11));
            SwipeRefreshLayout.this.h(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface i {
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface j {
        void a();
    }

    public SwipeRefreshLayout(@NonNull Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12999c = false;
        this.f13001f = -1.0f;
        this.f13005j = new int[2];
        this.f13006k = new int[2];
        this.f13007l = new int[2];
        this.f13014s = -1;
        this.f13019x = -1;
        this.N = new a();
        this.O = new f();
        this.P = new g();
        this.f13000d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f13009n = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f13017v = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.K = (int) (displayMetrics.density * 40.0f);
        c();
        setChildrenDrawingOrderEnabled(true);
        int i11 = (int) (displayMetrics.density * 64.0f);
        this.B = i11;
        this.f13001f = i11;
        this.f13003h = new NestedScrollingParentHelper(this);
        this.f13004i = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i12 = -this.K;
        this.f13010o = i12;
        this.A = i12;
        h(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void i(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f13014s) {
            this.f13014s = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void setColorViewAlpha(int i11) {
        this.f13018w.getBackground().setAlpha(i11);
        this.D.setAlpha(i11);
    }

    public final void a(int i11, Animation.AnimationListener animationListener) {
        this.f13020y = i11;
        this.O.reset();
        this.O.setDuration(200L);
        this.O.setInterpolator(this.f13017v);
        if (animationListener != null) {
            this.f13018w.b(animationListener);
        }
        this.f13018w.clearAnimation();
        this.f13018w.startAnimation(this.O);
    }

    public final void b(int i11, Animation.AnimationListener animationListener) {
        if (this.f13015t) {
            q(i11, animationListener);
            return;
        }
        this.f13020y = i11;
        this.P.reset();
        this.P.setDuration(200L);
        this.P.setInterpolator(this.f13017v);
        if (animationListener != null) {
            this.f13018w.b(animationListener);
        }
        this.f13018w.clearAnimation();
        this.f13018w.startAnimation(this.P);
    }

    public final void c() {
        this.f13018w = new androidx.swiperefreshlayout.widget.a(getContext());
        androidx.swiperefreshlayout.widget.b bVar = new androidx.swiperefreshlayout.widget.b(getContext());
        this.D = bVar;
        bVar.l(1);
        this.f13018w.setImageDrawable(this.D);
        this.f13018w.setVisibility(8);
        addView(this.f13018w);
    }

    public boolean canChildScrollUp() {
        View view = this.f12997a;
        return view instanceof ListView ? androidx.core.widget.j.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    public final void d() {
        if (this.f12997a == null) {
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                if (!childAt.equals(this.f13018w)) {
                    this.f12997a = childAt;
                    return;
                }
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f11, float f12, boolean z11) {
        return this.f13004i.dispatchNestedFling(f11, f12, z11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f11, float f12) {
        return this.f13004i.dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2) {
        return this.f13004i.dispatchNestedPreScroll(i11, i12, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2, int i13) {
        return i13 == 0 && dispatchNestedPreScroll(i11, i12, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i11, int i12, int i13, int i14, @Nullable int[] iArr, int i15, @NonNull int[] iArr2) {
        if (i15 == 0) {
            this.f13004i.dispatchNestedScroll(i11, i12, i13, i14, iArr, i15, iArr2);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr) {
        return this.f13004i.dispatchNestedScroll(i11, i12, i13, i14, iArr);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr, int i15) {
        return i15 == 0 && this.f13004i.dispatchNestedScroll(i11, i12, i13, i14, iArr, i15);
    }

    public final void e(float f11) {
        if (f11 > this.f13001f) {
            k(true, true);
            return;
        }
        this.f12999c = false;
        this.D.j(0.0f, 0.0f);
        b(this.f13010o, !this.f13015t ? new e() : null);
        this.D.d(false);
    }

    public final boolean f(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public final void g(float f11) {
        this.D.d(true);
        float fMin = Math.min(1.0f, Math.abs(f11 / this.f13001f));
        float fMax = (((float) Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f11) - this.f13001f;
        int i11 = this.C;
        if (i11 <= 0) {
            i11 = this.L ? this.B - this.A : this.B;
        }
        float f12 = i11;
        double dMax = Math.max(0.0f, Math.min(fAbs, f12 * 2.0f) / f12) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i12 = this.A + ((int) ((f12 * fMin) + (f12 * fPow * 2.0f)));
        if (this.f13018w.getVisibility() != 0) {
            this.f13018w.setVisibility(0);
        }
        if (!this.f13015t) {
            this.f13018w.setScaleX(1.0f);
            this.f13018w.setScaleY(1.0f);
        }
        if (this.f13015t) {
            setAnimationProgress(Math.min(1.0f, f11 / this.f13001f));
        }
        if (f11 < this.f13001f) {
            if (this.D.getAlpha() > 76 && !f(this.G)) {
                o();
            }
        } else if (this.D.getAlpha() < 255 && !f(this.H)) {
            n();
        }
        this.D.j(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.D.e(Math.min(1.0f, fMax));
        this.D.g((((fMax * 0.4f) - 0.25f) + (fPow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i12 - this.f13010o);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i11, int i12) {
        int i13 = this.f13019x;
        if (i13 < 0) {
            return i12;
        }
        if (i12 == i11 - 1) {
            return i13;
        }
        return i12 >= i13 ? i12 + 1 : i12;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f13003h.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.K;
    }

    public int getProgressViewEndOffset() {
        return this.B;
    }

    public int getProgressViewStartOffset() {
        return this.A;
    }

    public void h(float f11) {
        int i11 = this.f13020y;
        setTargetOffsetTopAndBottom((i11 + ((int) ((this.A - i11) * f11))) - this.f13018w.getTop());
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f13004i.hasNestedScrollingParent();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i11) {
        return i11 == 0 && hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f13004i.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.f12999c;
    }

    public void j() {
        this.f13018w.clearAnimation();
        this.D.stop();
        this.f13018w.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f13015t) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.A - this.f13010o);
        }
        this.f13010o = this.f13018w.getTop();
    }

    public final void k(boolean z11, boolean z12) {
        if (this.f12999c != z11) {
            this.J = z12;
            d();
            this.f12999c = z11;
            if (z11) {
                a(this.f13010o, this.N);
            } else {
                p(this.N);
            }
        }
    }

    public final Animation l(int i11, int i12) {
        d dVar = new d(i11, i12);
        dVar.setDuration(300L);
        this.f13018w.b(null);
        this.f13018w.clearAnimation();
        this.f13018w.startAnimation(dVar);
        return dVar;
    }

    public final void m(float f11) {
        float f12 = this.f13012q;
        float f13 = f11 - f12;
        int i11 = this.f13000d;
        if (f13 <= i11 || this.f13013r) {
            return;
        }
        this.f13011p = f12 + i11;
        this.f13013r = true;
        this.D.setAlpha(76);
    }

    public final void n() {
        this.H = l(this.D.getAlpha(), 255);
    }

    public final void o() {
        this.G = l(this.D.getAlpha(), 76);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f13016u && actionMasked == 0) {
            this.f13016u = false;
        }
        if (!isEnabled() || this.f13016u || canChildScrollUp() || this.f12999c || this.f13008m) {
            return false;
        }
        if (actionMasked == 0) {
            setTargetOffsetTopAndBottom(this.A - this.f13018w.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f13014s = pointerId;
            this.f13013r = false;
            int iFindPointerIndex = motionEvent.findPointerIndex(pointerId);
            if (iFindPointerIndex < 0) {
                return false;
            }
            this.f13012q = motionEvent.getY(iFindPointerIndex);
        } else if (actionMasked == 1) {
            this.f13013r = false;
            this.f13014s = -1;
        } else if (actionMasked == 2) {
            int i11 = this.f13014s;
            if (i11 == -1) {
                Log.e(Q, "Got ACTION_MOVE event but don't have an active pointer id.");
                return false;
            }
            int iFindPointerIndex2 = motionEvent.findPointerIndex(i11);
            if (iFindPointerIndex2 < 0) {
                return false;
            }
            m(motionEvent.getY(iFindPointerIndex2));
        } else if (actionMasked == 3) {
            this.f13013r = false;
            this.f13014s = -1;
        } else if (actionMasked == 6) {
            i(motionEvent);
        }
        return this.f13013r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f12997a == null) {
            d();
        }
        View view = this.f12997a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f13018w.getMeasuredWidth();
        int measuredHeight2 = this.f13018w.getMeasuredHeight();
        int i15 = measuredWidth / 2;
        int i16 = measuredWidth2 / 2;
        int i17 = this.f13010o;
        this.f13018w.layout(i15 - i16, i17, i15 + i16, measuredHeight2 + i17);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.f12997a == null) {
            d();
        }
        View view = this.f12997a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f13018w.measure(View.MeasureSpec.makeMeasureSpec(this.K, 1073741824), View.MeasureSpec.makeMeasureSpec(this.K, 1073741824));
        this.f13019x = -1;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            if (getChildAt(i13) == this.f13018w) {
                this.f13019x = i13;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        return dispatchNestedFling(f11, f12, z11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f11, float f12) {
        return dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
        if (i12 > 0) {
            float f11 = this.f13002g;
            if (f11 > 0.0f) {
                float f12 = i12;
                if (f12 > f11) {
                    iArr[1] = (int) f11;
                    this.f13002g = 0.0f;
                } else {
                    this.f13002g = f11 - f12;
                    iArr[1] = i12;
                }
                g(this.f13002g);
            }
        }
        if (this.L && i12 > 0 && this.f13002g == 0.0f && Math.abs(i12 - iArr[1]) > 0) {
            this.f13018w.setVisibility(8);
        }
        int[] iArr2 = this.f13005j;
        if (dispatchNestedPreScroll(i11 - iArr[0], i12 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        if (i13 == 0) {
            onNestedPreScroll(view, i11, i12, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i11, i12, i13, i14, 0, this.f13007l);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        onNestedScroll(view, i11, i12, i13, i14, i15, this.f13007l);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15, @NonNull int[] iArr) {
        if (i15 != 0) {
            return;
        }
        int i16 = iArr[1];
        dispatchNestedScroll(i11, i12, i13, i14, this.f13006k, i15, iArr);
        int i17 = i14 - (iArr[1] - i16);
        int i18 = i17 == 0 ? i14 + this.f13006k[1] : i17;
        if (i18 >= 0 || canChildScrollUp()) {
            return;
        }
        float fAbs = this.f13002g + Math.abs(i18);
        this.f13002g = fAbs;
        g(fAbs);
        iArr[1] = iArr[1] + i17;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i11) {
        this.f13003h.onNestedScrollAccepted(view, view2, i11);
        startNestedScroll(i11 & 2);
        this.f13002g = 0.0f;
        this.f13008m = true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            onNestedScrollAccepted(view, view2, i11);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.f13022a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f12999c);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i11) {
        return (!isEnabled() || this.f13016u || this.f12999c || (i11 & 2) == 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            return onStartNestedScroll(view, view2, i11);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.f13003h.onStopNestedScroll(view);
        this.f13008m = false;
        float f11 = this.f13002g;
        if (f11 > 0.0f) {
            e(f11);
            this.f13002g = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i11) {
        if (i11 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f13016u && actionMasked == 0) {
            this.f13016u = false;
        }
        if (!isEnabled() || this.f13016u || canChildScrollUp() || this.f12999c || this.f13008m) {
            return false;
        }
        if (actionMasked == 0) {
            this.f13014s = motionEvent.getPointerId(0);
            this.f13013r = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f13014s);
                if (iFindPointerIndex < 0) {
                    Log.e(Q, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f13013r) {
                    float y11 = (motionEvent.getY(iFindPointerIndex) - this.f13011p) * 0.5f;
                    this.f13013r = false;
                    e(y11);
                }
                this.f13014s = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f13014s);
                if (iFindPointerIndex2 < 0) {
                    Log.e(Q, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y12 = motionEvent.getY(iFindPointerIndex2);
                m(y12);
                if (this.f13013r) {
                    float f11 = (y12 - this.f13011p) * 0.5f;
                    if (f11 <= 0.0f) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    g(f11);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(Q, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.f13014s = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    i(motionEvent);
                }
            }
        }
        return true;
    }

    public void p(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.F = cVar;
        cVar.setDuration(150L);
        this.f13018w.b(animationListener);
        this.f13018w.clearAnimation();
        this.f13018w.startAnimation(this.F);
    }

    public final void q(int i11, Animation.AnimationListener animationListener) {
        this.f13020y = i11;
        this.f13021z = this.f13018w.getScaleX();
        h hVar = new h();
        this.I = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.f13018w.b(animationListener);
        }
        this.f13018w.clearAnimation();
        this.f13018w.startAnimation(this.I);
    }

    public final void r(Animation.AnimationListener animationListener) {
        this.f13018w.setVisibility(0);
        this.D.setAlpha(255);
        b bVar = new b();
        this.E = bVar;
        bVar.setDuration(this.f13009n);
        if (animationListener != null) {
            this.f13018w.b(animationListener);
        }
        this.f13018w.clearAnimation();
        this.f13018w.startAnimation(this.E);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z11) {
        ViewParent parent;
        View view = this.f12997a;
        if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
            super.requestDisallowInterceptTouchEvent(z11);
        } else {
            if (this.M || (parent = getParent()) == null) {
                return;
            }
            parent.requestDisallowInterceptTouchEvent(z11);
        }
    }

    public void setAnimationProgress(float f11) {
        this.f13018w.setScaleX(f11);
        this.f13018w.setScaleY(f11);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        d();
        this.D.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr2[i11] = z2.a.getColor(context, iArr[i11]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i11) {
        this.f13001f = i11;
    }

    @Override // android.view.View
    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        if (z11) {
            return;
        }
        j();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z11) {
        this.M = z11;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z11) {
        this.f13004i.setNestedScrollingEnabled(z11);
    }

    public void setOnChildScrollUpCallback(@Nullable i iVar) {
    }

    public void setOnRefreshListener(@Nullable j jVar) {
        this.f12998b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i11) {
        setProgressBackgroundColorSchemeResource(i11);
    }

    public void setProgressBackgroundColorSchemeColor(int i11) {
        this.f13018w.setBackgroundColor(i11);
    }

    public void setProgressBackgroundColorSchemeResource(int i11) {
        setProgressBackgroundColorSchemeColor(z2.a.getColor(getContext(), i11));
    }

    public void setProgressViewEndTarget(boolean z11, int i11) {
        this.B = i11;
        this.f13015t = z11;
        this.f13018w.invalidate();
    }

    public void setProgressViewOffset(boolean z11, int i11, int i12) {
        this.f13015t = z11;
        this.A = i11;
        this.B = i12;
        this.L = true;
        j();
        this.f12999c = false;
    }

    public void setRefreshing(boolean z11) {
        if (!z11 || this.f12999c == z11) {
            k(z11, false);
            return;
        }
        this.f12999c = z11;
        setTargetOffsetTopAndBottom((!this.L ? this.B + this.A : this.B) - this.f13010o);
        this.J = false;
        r(this.N);
    }

    public void setSize(int i11) {
        if (i11 == 0 || i11 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i11 == 0) {
                this.K = (int) (displayMetrics.density * 56.0f);
            } else {
                this.K = (int) (displayMetrics.density * 40.0f);
            }
            this.f13018w.setImageDrawable(null);
            this.D.l(i11);
            this.f13018w.setImageDrawable(this.D);
        }
    }

    public void setSlingshotDistance(int i11) {
        this.C = i11;
    }

    public void setTargetOffsetTopAndBottom(int i11) {
        this.f13018w.bringToFront();
        ViewCompat.offsetTopAndBottom(this.f13018w, i11);
        this.f13010o = this.f13018w.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i11) {
        return this.f13004i.startNestedScroll(i11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i11, int i12) {
        return i12 == 0 && startNestedScroll(i11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f13004i.stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i11) {
        if (i11 == 0) {
            stopNestedScroll();
        }
    }
}
