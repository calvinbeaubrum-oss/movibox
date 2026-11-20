package com.google.android.material.bottomsheet;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.f0;
import com.vungle.warren.error.VungleException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import yi.i;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> implements ti.b {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f36306j0 = R$style.Widget_Design_BottomSheet_Modal;
    public n A;
    public boolean B;
    public final BottomSheetBehavior<V>.StateSettlingTracker C;

    @Nullable
    public ValueAnimator D;
    public int E;
    public int F;
    public int G;
    public float H;
    public int I;
    public float J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public int O;

    @Nullable
    public ViewDragHelper P;
    public boolean Q;
    public int R;
    public boolean S;
    public float T;
    public int U;
    public int V;
    public int W;

    @Nullable
    public WeakReference<V> X;

    @Nullable
    public WeakReference<View> Y;

    @Nullable
    public WeakReference<View> Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36307a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @NonNull
    public final ArrayList<f> f36308a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f36309b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @Nullable
    public VelocityTracker f36310b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f36311c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @Nullable
    public ti.f f36312c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f36313d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f36314d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f36315e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36316f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f36317f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36318g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @Nullable
    public Map<View, Integer> f36319g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f36320h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final SparseIntArray f36321h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36322i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final ViewDragHelper.b f36323i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f36325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public ColorStateList f36326l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f36327m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f36328n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f36329o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f36330p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f36331q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f36332r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f36333s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f36334t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f36335u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f36336v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f36337w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f36338x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f36339y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f36340z;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i11) {
            super(parcelable);
            this.state = i11;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.N;
            this.peekHeight = bottomSheetBehavior.f36318g;
            this.fitToContents = bottomSheetBehavior.f36309b;
            this.hideable = bottomSheetBehavior.K;
            this.skipCollapsed = bottomSheetBehavior.L;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class StateSettlingTracker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f36341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f36342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f36343c;

        public StateSettlingTracker() {
            this.f36343c = new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.StateSettlingTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    StateSettlingTracker.this.f36342b = false;
                    ViewDragHelper viewDragHelper = BottomSheetBehavior.this.P;
                    if (viewDragHelper != null && viewDragHelper.n(true)) {
                        StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                        stateSettlingTracker.c(stateSettlingTracker.f36341a);
                        return;
                    }
                    StateSettlingTracker stateSettlingTracker2 = StateSettlingTracker.this;
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.N == 2) {
                        bottomSheetBehavior.V0(stateSettlingTracker2.f36341a);
                    }
                }
            };
        }

        public void c(int i11) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.X;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f36341a = i11;
            if (this.f36342b) {
                return;
            }
            ViewCompat.postOnAnimation(BottomSheetBehavior.this.X.get(), this.f36343c);
            this.f36342b = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomSheetBehavior.this.V0(5);
            WeakReference<V> weakReference = BottomSheetBehavior.this.X;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            BottomSheetBehavior.this.X.get().requestLayout();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f36325k != null) {
                BottomSheetBehavior.this.f36325k.e0(fFloatValue);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements f0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f36347a;

        public c(boolean z11) {
            this.f36347a = z11;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0080  */
        /* JADX WARN: Code duplicated, block: B:28:0x0092  */
        /* JADX WARN: Code duplicated, block: B:34:0x00a4 A[DONT_INVERT] */
        @Override // com.google.android.material.internal.f0.d
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, f0.e eVar) {
            boolean z11;
            c3.c insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            c3.c insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.mandatorySystemGestures());
            BottomSheetBehavior.this.f36339y = insets.f14555b;
            boolean zP = f0.p(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.f36331q) {
                BottomSheetBehavior.this.f36338x = windowInsetsCompat.getSystemWindowInsetBottom();
                paddingBottom = eVar.f37045d + BottomSheetBehavior.this.f36338x;
            }
            if (BottomSheetBehavior.this.f36332r) {
                paddingLeft = (zP ? eVar.f37044c : eVar.f37042a) + insets.f14554a;
            }
            if (BottomSheetBehavior.this.f36333s) {
                paddingRight = (zP ? eVar.f37042a : eVar.f37044c) + insets.f14556c;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z12 = true;
            if (BottomSheetBehavior.this.f36335u) {
                int i11 = marginLayoutParams.leftMargin;
                int i12 = insets.f14554a;
                if (i11 != i12) {
                    marginLayoutParams.leftMargin = i12;
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else {
                z11 = false;
            }
            if (BottomSheetBehavior.this.f36336v) {
                int i13 = marginLayoutParams.rightMargin;
                int i14 = insets.f14556c;
                if (i13 != i14) {
                    marginLayoutParams.rightMargin = i14;
                } else {
                    z12 = z11;
                }
            } else {
                z12 = z11;
            }
            if (BottomSheetBehavior.this.f36337w) {
                int i15 = marginLayoutParams.topMargin;
                int i16 = insets.f14555b;
                if (i15 != i16) {
                    marginLayoutParams.topMargin = i16;
                } else if (z12) {
                }
                view.setLayoutParams(marginLayoutParams);
            } else if (z12) {
                view.setLayoutParams(marginLayoutParams);
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.f36347a) {
                BottomSheetBehavior.this.f36329o = insets2.f14557d;
            }
            if (BottomSheetBehavior.this.f36331q || this.f36347a) {
                BottomSheetBehavior.this.h1(false);
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends ViewDragHelper.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f36349a;

        public d() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int a(@NonNull View view, int i11, int i12) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int b(@NonNull View view, int i11, int i12) {
            return g3.a.b(i11, BottomSheetBehavior.this.o0(), e(view));
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int e(@NonNull View view) {
            return BottomSheetBehavior.this.f0() ? BottomSheetBehavior.this.W : BottomSheetBehavior.this.I;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void j(int i11) {
            if (i11 == 1 && BottomSheetBehavior.this.M) {
                BottomSheetBehavior.this.V0(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void k(@NonNull View view, int i11, int i12, int i13, int i14) {
            BottomSheetBehavior.this.k0(i12);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:6:0x0010  */
        @Override // androidx.customview.widget.ViewDragHelper.b
        public void l(@NonNull View view, float f11, float f12) {
            int i11 = 6;
            if (f12 >= 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.K && bottomSheetBehavior.Z0(view, f12)) {
                    if ((Math.abs(f11) < Math.abs(f12) && f12 > BottomSheetBehavior.this.f36316f) || n(view)) {
                        i11 = 5;
                    } else if (BottomSheetBehavior.this.f36309b || Math.abs(view.getTop() - BottomSheetBehavior.this.o0()) < Math.abs(view.getTop() - BottomSheetBehavior.this.G)) {
                        i11 = 3;
                    }
                } else if (f12 == 0.0f || Math.abs(f11) > Math.abs(f12)) {
                    int top = view.getTop();
                    if (!BottomSheetBehavior.this.f36309b) {
                        BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                        int i12 = bottomSheetBehavior2.G;
                        if (top < i12) {
                            if (top < Math.abs(top - bottomSheetBehavior2.I)) {
                                i11 = 3;
                            } else if (BottomSheetBehavior.this.a1()) {
                                i11 = 4;
                            }
                        } else if (Math.abs(top - i12) >= Math.abs(top - BottomSheetBehavior.this.I) || BottomSheetBehavior.this.a1()) {
                            i11 = 4;
                        }
                    } else if (Math.abs(top - BottomSheetBehavior.this.F) < Math.abs(top - BottomSheetBehavior.this.I)) {
                        i11 = 3;
                    } else {
                        i11 = 4;
                    }
                } else if (BottomSheetBehavior.this.f36309b) {
                    i11 = 4;
                } else {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - BottomSheetBehavior.this.G) >= Math.abs(top2 - BottomSheetBehavior.this.I) || BottomSheetBehavior.this.a1()) {
                        i11 = 4;
                    }
                }
            } else if (BottomSheetBehavior.this.f36309b) {
                i11 = 3;
            } else {
                int top3 = view.getTop();
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f36349a;
                if (BottomSheetBehavior.this.a1()) {
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior3.X0(jCurrentTimeMillis, (top3 * 100.0f) / bottomSheetBehavior3.W)) {
                        i11 = 4;
                    }
                } else if (top3 <= BottomSheetBehavior.this.G) {
                }
                i11 = 3;
            }
            BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
            bottomSheetBehavior4.c1(view, i11, bottomSheetBehavior4.b1());
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean m(@NonNull View view, int i11) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i12 = bottomSheetBehavior.N;
            if (i12 == 1 || bottomSheetBehavior.f36317f0) {
                return false;
            }
            if (i12 == 3 && bottomSheetBehavior.f36314d0 == i11) {
                WeakReference<View> weakReference = bottomSheetBehavior.Z;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f36349a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.X;
            return weakReference2 != null && weakReference2.get() == view;
        }

        public final boolean n(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.W + bottomSheetBehavior.o0()) / 2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements AccessibilityViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f36351a;

        public e(int i11) {
            this.f36351a = i11;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            BottomSheetBehavior.this.U0(this.f36351a);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class f {
        public void a(@NonNull View view) {
        }

        public abstract void b(@NonNull View view, float f11);

        public abstract void c(@NonNull View view, int i11);
    }

    public BottomSheetBehavior() {
        this.f36307a = 0;
        this.f36309b = true;
        this.f36311c = false;
        this.f36327m = -1;
        this.f36328n = -1;
        this.C = new StateSettlingTracker();
        this.H = 0.5f;
        this.J = -1.0f;
        this.M = true;
        this.N = 4;
        this.O = 4;
        this.T = 0.1f;
        this.f36308a0 = new ArrayList<>();
        this.f36315e0 = -1;
        this.f36321h0 = new SparseIntArray();
        this.f36323i0 = new d();
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i11;
        super(context, attributeSet);
        this.f36307a = 0;
        this.f36309b = true;
        this.f36311c = false;
        this.f36327m = -1;
        this.f36328n = -1;
        this.C = new StateSettlingTracker();
        this.H = 0.5f;
        this.J = -1.0f;
        this.M = true;
        this.N = 4;
        this.O = 4;
        this.T = 0.1f;
        this.f36308a0 = new ArrayList<>();
        this.f36315e0 = -1;
        this.f36321h0 = new SparseIntArray();
        this.f36323i0 = new d();
        this.f36324j = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_backgroundTint)) {
            this.f36326l = vi.d.a(context, typedArrayObtainStyledAttributes, R$styleable.BottomSheetBehavior_Layout_backgroundTint);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.A = n.e(context, attributeSet, R$attr.bottomSheetStyle, f36306j0).m();
        }
        i0(context);
        j0();
        this.J = typedArrayObtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_android_maxWidth)) {
            O0(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_android_maxWidth, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_android_maxHeight)) {
            N0(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_android_maxHeight, -1));
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue == null || (i11 = typedValuePeekValue.data) != -1) {
            P0(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            P0(i11);
        }
        M0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        K0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        J0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        T0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        H0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        R0(typedArrayObtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        L0(typedArrayObtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (typedValuePeekValue2 == null || typedValuePeekValue2.type != 16) {
            I0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        } else {
            I0(typedValuePeekValue2.data);
        }
        S0(typedArrayObtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.f36331q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.f36332r = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.f36333s = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.f36334t = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.f36335u = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.f36336v = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.f36337w = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.f36340z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f36313d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void D0() {
        this.f36314d0 = -1;
        this.f36315e0 = -1;
        VelocityTracker velocityTracker = this.f36310b0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f36310b0 = null;
        }
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> m0(@NonNull V v11) {
        ViewGroup.LayoutParams layoutParams = v11.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) layoutParams).f();
        if (cVarF instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) cVarF;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, @NonNull View view2, int i11, int i12) {
        this.R = 0;
        this.S = false;
        return (i11 & 2) != 0;
    }

    public boolean A0() {
        return true;
    }

    public void B0(@NonNull f fVar) {
        this.f36308a0.remove(fVar);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void C(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11) {
        WeakReference<View> weakReference;
        int i12 = 3;
        if (v11.getTop() == o0()) {
            V0(3);
            return;
        }
        if (!A0() || ((weakReference = this.Z) != null && view == weakReference.get() && this.S)) {
            if (this.R > 0) {
                if (!this.f36309b && v11.getTop() > this.G) {
                    i12 = 6;
                }
            } else if (this.K && Z0(v11, s0())) {
                i12 = 5;
            } else if (this.R == 0) {
                int top = v11.getTop();
                if (!this.f36309b) {
                    int i13 = this.G;
                    if (top < i13) {
                        if (top >= Math.abs(top - this.I)) {
                            if (a1()) {
                                i12 = 4;
                            } else {
                                i12 = 6;
                            }
                        }
                    } else if (Math.abs(top - i13) < Math.abs(top - this.I)) {
                        i12 = 6;
                    } else {
                        i12 = 4;
                    }
                } else if (Math.abs(top - this.F) >= Math.abs(top - this.I)) {
                    i12 = 4;
                }
            } else {
                if (!this.f36309b) {
                    int top2 = v11.getTop();
                    if (Math.abs(top2 - this.G) < Math.abs(top2 - this.I)) {
                        i12 = 6;
                    }
                }
                i12 = 4;
            }
            c1(v11, i12, false);
            this.S = false;
        }
    }

    public final void C0(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i11) {
        ViewCompat.replaceAccessibilityAction(view, accessibilityActionCompat, null, h0(i11));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
        if (!v11.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.N == 1 && actionMasked == 0) {
            return true;
        }
        if (Y0()) {
            this.P.H(motionEvent);
        }
        if (actionMasked == 0) {
            D0();
        }
        if (this.f36310b0 == null) {
            this.f36310b0 = VelocityTracker.obtain();
        }
        this.f36310b0.addMovement(motionEvent);
        if (Y0() && actionMasked == 2 && !this.Q && Math.abs(this.f36315e0 - motionEvent.getY()) > this.P.A()) {
            this.P.c(v11, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.Q;
    }

    public final void E0(@NonNull SavedState savedState) {
        int i11 = this.f36307a;
        if (i11 == 0) {
            return;
        }
        if (i11 == -1 || (i11 & 1) == 1) {
            this.f36318g = savedState.peekHeight;
        }
        if (i11 == -1 || (i11 & 2) == 2) {
            this.f36309b = savedState.fitToContents;
        }
        if (i11 == -1 || (i11 & 4) == 4) {
            this.K = savedState.hideable;
        }
        if (i11 == -1 || (i11 & 8) == 8) {
            this.L = savedState.skipCollapsed;
        }
    }

    public final void F0(V v11, Runnable runnable) {
        if (z0(v11)) {
            v11.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void G0(@Nullable View view) {
        WeakReference<View> weakReference;
        if (view != null || (weakReference = this.Y) == null) {
            this.Y = new WeakReference<>(view);
            e1(view, 1);
        } else {
            g0(weakReference.get(), 1);
            this.Y = null;
        }
    }

    public void H0(boolean z11) {
        this.M = z11;
    }

    public void I0(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.E = i11;
        f1(this.N, true);
    }

    public void J0(boolean z11) {
        if (this.f36309b == z11) {
            return;
        }
        this.f36309b = z11;
        if (this.X != null) {
            Z();
        }
        V0((this.f36309b && this.N == 6) ? 3 : this.N);
        f1(this.N, true);
        d1();
    }

    public void K0(boolean z11) {
        this.f36330p = z11;
    }

    public void L0(float f11) {
        if (f11 <= 0.0f || f11 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.H = f11;
        if (this.X != null) {
            b0();
        }
    }

    public void M0(boolean z11) {
        if (this.K != z11) {
            this.K = z11;
            if (!z11 && this.N == 5) {
                U0(4);
            }
            d1();
        }
    }

    public void N0(int i11) {
        this.f36328n = i11;
    }

    public void O0(int i11) {
        this.f36327m = i11;
    }

    public void P0(int i11) {
        Q0(i11, false);
    }

    public final void Q0(int i11, boolean z11) {
        if (i11 == -1) {
            if (this.f36320h) {
                return;
            } else {
                this.f36320h = true;
            }
        } else {
            if (!this.f36320h && this.f36318g == i11) {
                return;
            }
            this.f36320h = false;
            this.f36318g = Math.max(0, i11);
        }
        h1(z11);
    }

    public void R0(int i11) {
        this.f36307a = i11;
    }

    public void S0(int i11) {
        this.f36316f = i11;
    }

    public void T0(boolean z11) {
        this.L = z11;
    }

    public void U0(int i11) {
        if (i11 == 1 || i11 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("STATE_");
            sb2.append(i11 == 1 ? "DRAGGING" : "SETTLING");
            sb2.append(" should not be set externally.");
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!this.K && i11 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i11);
            return;
        }
        final int i12 = (i11 == 6 && this.f36309b && r0(i11) <= this.F) ? 3 : i11;
        WeakReference<V> weakReference = this.X;
        if (weakReference == null || weakReference.get() == null) {
            V0(i11);
        } else {
            final V v11 = this.X.get();
            F0(v11, new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetBehavior.this.c1(v11, i12, false);
                }
            });
        }
    }

    public void V0(int i11) {
        V v11;
        if (this.N == i11) {
            return;
        }
        this.N = i11;
        if (i11 == 4 || i11 == 3 || i11 == 6 || (this.K && i11 == 5)) {
            this.O = i11;
        }
        WeakReference<V> weakReference = this.X;
        if (weakReference == null || (v11 = weakReference.get()) == null) {
            return;
        }
        if (i11 == 3) {
            g1(true);
        } else if (i11 == 6 || i11 == 5 || i11 == 4) {
            g1(false);
        }
        f1(i11, true);
        for (int i12 = 0; i12 < this.f36308a0.size(); i12++) {
            this.f36308a0.get(i12).c(v11, i11);
        }
        d1();
    }

    public final void W0(@NonNull View view) {
        boolean z11 = (Build.VERSION.SDK_INT < 29 || w0() || this.f36320h) ? false : true;
        if (this.f36331q || this.f36332r || this.f36333s || this.f36335u || this.f36336v || this.f36337w || z11) {
            f0.f(view, new c(z11));
        }
    }

    public final int X(View view, @StringRes int i11, int i12) {
        return ViewCompat.addAccessibilityAction(view, view.getResources().getString(i11), h0(i12));
    }

    public boolean X0(long j11, float f11) {
        return false;
    }

    public void Y(@NonNull f fVar) {
        if (this.f36308a0.contains(fVar)) {
            return;
        }
        this.f36308a0.add(fVar);
    }

    public final boolean Y0() {
        return this.P != null && (this.M || this.N == 1);
    }

    public final void Z() {
        int iD0 = d0();
        if (this.f36309b) {
            this.I = Math.max(this.W - iD0, this.F);
        } else {
            this.I = this.W - iD0;
        }
    }

    public boolean Z0(@NonNull View view, float f11) {
        if (this.L) {
            return true;
        }
        if (y0() && view.getTop() >= this.I) {
            return Math.abs((((float) view.getTop()) + (f11 * this.T)) - ((float) this.I)) / ((float) d0()) > 0.5f;
        }
        return false;
    }

    @RequiresApi(VungleException.WEB_CRASH)
    public final float a0(float f11, @Nullable RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float radius = roundedCorner.getRadius();
            if (radius > 0.0f && f11 > 0.0f) {
                return radius / f11;
            }
        }
        return 0.0f;
    }

    public boolean a1() {
        return false;
    }

    public final void b0() {
        this.G = (int) (this.W * (1.0f - this.H));
    }

    public boolean b1() {
        return true;
    }

    public final float c0() {
        WeakReference<V> weakReference;
        WindowInsets rootWindowInsets;
        if (this.f36325k == null || (weakReference = this.X) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        V v11 = this.X.get();
        if (!t0() || (rootWindowInsets = v11.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(a0(this.f36325k.L(), rootWindowInsets.getRoundedCorner(0)), a0(this.f36325k.M(), rootWindowInsets.getRoundedCorner(1)));
    }

    public final void c1(View view, int i11, boolean z11) {
        int iR0 = r0(i11);
        ViewDragHelper viewDragHelper = this.P;
        if (viewDragHelper == null || (!z11 ? viewDragHelper.S(view, view.getLeft(), iR0) : viewDragHelper.Q(view.getLeft(), iR0))) {
            V0(i11);
            return;
        }
        V0(2);
        f1(i11, true);
        this.C.c(i11);
    }

    @Override // ti.b
    public void cancelBackProgress() {
        ti.f fVar = this.f36312c0;
        if (fVar == null) {
            return;
        }
        fVar.f();
    }

    public final int d0() {
        int i11;
        if (this.f36320h) {
            return Math.min(Math.max(this.f36322i, this.W - ((this.V * 9) / 16)), this.U) + this.f36338x;
        }
        return (this.f36330p || this.f36331q || (i11 = this.f36329o) <= 0) ? this.f36318g + this.f36338x : Math.max(this.f36318g, i11 + this.f36324j);
    }

    public final void d1() {
        WeakReference<V> weakReference = this.X;
        if (weakReference != null) {
            e1(weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.Y;
        if (weakReference2 != null) {
            e1(weakReference2.get(), 1);
        }
    }

    public final float e0(int i11) {
        float f11;
        float fO0;
        int i12 = this.I;
        if (i11 > i12 || i12 == o0()) {
            int i13 = this.I;
            f11 = i13 - i11;
            fO0 = this.W - i13;
        } else {
            int i14 = this.I;
            f11 = i14 - i11;
            fO0 = i14 - o0();
        }
        return f11 / fO0;
    }

    public final void e1(View view, int i11) {
        if (view == null) {
            return;
        }
        g0(view, i11);
        if (!this.f36309b && this.N != 6) {
            this.f36321h0.put(i11, X(view, R$string.bottomsheet_action_expand_halfway, 6));
        }
        if (this.K && y0() && this.N != 5) {
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i12 = this.N;
        if (i12 == 3) {
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, this.f36309b ? 4 : 6);
            return;
        }
        if (i12 == 4) {
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, this.f36309b ? 3 : 6);
        } else {
            if (i12 != 6) {
                return;
            }
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    public final boolean f0() {
        return x0() && y0();
    }

    public final void f1(int i11, boolean z11) {
        boolean zU0;
        ValueAnimator valueAnimator;
        if (i11 == 2 || this.B == (zU0 = u0()) || this.f36325k == null) {
            return;
        }
        this.B = zU0;
        if (!z11 || (valueAnimator = this.D) == null) {
            ValueAnimator valueAnimator2 = this.D;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.D.cancel();
            }
            this.f36325k.e0(this.B ? c0() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            this.D.reverse();
        } else {
            this.D.setFloatValues(this.f36325k.A(), zU0 ? c0() : 1.0f);
            this.D.start();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(@NonNull CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.X = null;
        this.P = null;
        this.f36312c0 = null;
    }

    public final void g0(View view, int i11) {
        if (view == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 524288);
        ViewCompat.removeAccessibilityAction(view, 262144);
        ViewCompat.removeAccessibilityAction(view, 1048576);
        int i12 = this.f36321h0.get(i11, -1);
        if (i12 != -1) {
            ViewCompat.removeAccessibilityAction(view, i12);
            this.f36321h0.delete(i11);
        }
    }

    public final void g1(boolean z11) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.X;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z11) {
                if (this.f36319g0 != null) {
                    return;
                } else {
                    this.f36319g0 = new HashMap(childCount);
                }
            }
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = coordinatorLayout.getChildAt(i11);
                if (childAt != this.X.get()) {
                    if (z11) {
                        this.f36319g0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f36311c) {
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    } else if (this.f36311c && (map = this.f36319g0) != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.f36319g0.get(childAt).intValue());
                    }
                }
            }
            if (!z11) {
                this.f36319g0 = null;
            } else if (this.f36311c) {
                this.X.get().sendAccessibilityEvent(8);
            }
        }
    }

    public final AccessibilityViewCommand h0(int i11) {
        return new e(i11);
    }

    public final void h1(boolean z11) {
        V v11;
        if (this.X != null) {
            Z();
            if (this.N != 4 || (v11 = this.X.get()) == null) {
                return;
            }
            if (z11) {
                U0(4);
            } else {
                v11.requestLayout();
            }
        }
    }

    @Override // ti.b
    public void handleBackInvoked() {
        ti.f fVar = this.f36312c0;
        if (fVar == null) {
            return;
        }
        androidx.activity.b bVarC = fVar.c();
        if (bVarC == null || Build.VERSION.SDK_INT < 34) {
            U0(this.K ? 5 : 4);
        } else if (this.K) {
            this.f36312c0.h(bVarC, new a());
        } else {
            this.f36312c0.i(bVarC, null);
            U0(4);
        }
    }

    public final void i0(@NonNull Context context) {
        if (this.A == null) {
            return;
        }
        i iVar = new i(this.A);
        this.f36325k = iVar;
        iVar.S(context);
        ColorStateList colorStateList = this.f36326l;
        if (colorStateList != null) {
            this.f36325k.d0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f36325k.setTint(typedValue.data);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.X = null;
        this.P = null;
        this.f36312c0 = null;
    }

    public final void j0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(c0(), 1.0f);
        this.D = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.D.addUpdateListener(new b());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
        int i11;
        ViewDragHelper viewDragHelper;
        if (!v11.isShown() || !this.M) {
            this.Q = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            D0();
        }
        if (this.f36310b0 == null) {
            this.f36310b0 = VelocityTracker.obtain();
        }
        this.f36310b0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x11 = (int) motionEvent.getX();
            this.f36315e0 = (int) motionEvent.getY();
            if (this.N != 2) {
                WeakReference<View> weakReference = this.Z;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x11, this.f36315e0)) {
                    this.f36314d0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f36317f0 = true;
                }
            }
            this.Q = this.f36314d0 == -1 && !coordinatorLayout.isPointInChildBounds(v11, x11, this.f36315e0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f36317f0 = false;
            this.f36314d0 = -1;
            if (this.Q) {
                this.Q = false;
                return false;
            }
        }
        if (!this.Q && (viewDragHelper = this.P) != null && viewDragHelper.R(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.Z;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.Q || this.N == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.P == null || (i11 = this.f36315e0) == -1 || Math.abs(((float) i11) - motionEvent.getY()) <= ((float) this.P.A())) ? false : true;
    }

    public void k0(int i11) {
        V v11 = this.X.get();
        if (v11 == null || this.f36308a0.isEmpty()) {
            return;
        }
        float fE0 = e0(i11);
        for (int i12 = 0; i12 < this.f36308a0.size(); i12++) {
            this.f36308a0.get(i12).b(v11, fE0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v11)) {
            v11.setFitsSystemWindows(true);
        }
        if (this.X == null) {
            this.f36322i = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            W0(v11);
            ViewCompat.setWindowInsetsAnimationCallback(v11, new com.google.android.material.bottomsheet.d(v11));
            this.X = new WeakReference<>(v11);
            this.f36312c0 = new ti.f(v11);
            i iVar = this.f36325k;
            if (iVar != null) {
                ViewCompat.setBackground(v11, iVar);
                i iVar2 = this.f36325k;
                float elevation = this.J;
                if (elevation == -1.0f) {
                    elevation = ViewCompat.getElevation(v11);
                }
                iVar2.c0(elevation);
            } else {
                ColorStateList colorStateList = this.f36326l;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(v11, colorStateList);
                }
            }
            d1();
            if (ViewCompat.getImportantForAccessibility(v11) == 0) {
                ViewCompat.setImportantForAccessibility(v11, 1);
            }
        }
        if (this.P == null) {
            this.P = ViewDragHelper.p(coordinatorLayout, this.f36323i0);
        }
        int top = v11.getTop();
        coordinatorLayout.onLayoutChild(v11, i11);
        this.V = coordinatorLayout.getWidth();
        this.W = coordinatorLayout.getHeight();
        int height = v11.getHeight();
        this.U = height;
        int iMin = this.W;
        int i12 = iMin - height;
        int i13 = this.f36339y;
        if (i12 < i13) {
            if (this.f36334t) {
                int i14 = this.f36328n;
                if (i14 != -1) {
                    iMin = Math.min(iMin, i14);
                }
                this.U = iMin;
            } else {
                int iMin2 = iMin - i13;
                int i15 = this.f36328n;
                if (i15 != -1) {
                    iMin2 = Math.min(iMin2, i15);
                }
                this.U = iMin2;
            }
        }
        this.F = Math.max(0, this.W - this.U);
        b0();
        Z();
        int i16 = this.N;
        if (i16 == 3) {
            ViewCompat.offsetTopAndBottom(v11, o0());
        } else if (i16 == 6) {
            ViewCompat.offsetTopAndBottom(v11, this.G);
        } else if (this.K && i16 == 5) {
            ViewCompat.offsetTopAndBottom(v11, this.W);
        } else if (i16 == 4) {
            ViewCompat.offsetTopAndBottom(v11, this.I);
        } else if (i16 == 1 || i16 == 2) {
            ViewCompat.offsetTopAndBottom(v11, top - v11.getTop());
        }
        f1(this.N, false);
        this.Z = new WeakReference<>(l0(v11));
        for (int i17 = 0; i17 < this.f36308a0.size(); i17++) {
            this.f36308a0.get(i17).a(v11);
        }
        return true;
    }

    @Nullable
    public View l0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View viewL0 = l0(viewGroup.getChildAt(i11));
                if (viewL0 != null) {
                    return viewL0;
                }
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v11.getLayoutParams();
        v11.measure(n0(i11, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i12, this.f36327m, marginLayoutParams.width), n0(i13, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i14, this.f36328n, marginLayoutParams.height));
        return true;
    }

    public final int n0(int i11, int i12, int i13, int i14) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, i12, i14);
        if (i13 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i13), 1073741824);
        }
        if (size != 0) {
            i13 = Math.min(size, i13);
        }
        return View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, float f11, float f12) {
        WeakReference<View> weakReference;
        if (A0() && (weakReference = this.Z) != null && view == weakReference.get()) {
            return this.N != 3 || super.o(coordinatorLayout, v11, view, f11, f12);
        }
        return false;
    }

    public int o0() {
        if (this.f36309b) {
            return this.F;
        }
        return Math.max(this.E, this.f36334t ? 0 : this.f36339y);
    }

    public i p0() {
        return this.f36325k;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11, int i12, @NonNull int[] iArr, int i13) {
        if (i13 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.Z;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (!A0() || view == view2) {
            int top = v11.getTop();
            int i14 = top - i12;
            if (i12 > 0) {
                if (i14 < o0()) {
                    int iO0 = top - o0();
                    iArr[1] = iO0;
                    ViewCompat.offsetTopAndBottom(v11, -iO0);
                    V0(3);
                } else {
                    if (!this.M) {
                        return;
                    }
                    iArr[1] = i12;
                    ViewCompat.offsetTopAndBottom(v11, -i12);
                    V0(1);
                }
            } else if (i12 < 0 && !view.canScrollVertically(-1)) {
                if (i14 > this.I && !f0()) {
                    int i15 = top - this.I;
                    iArr[1] = i15;
                    ViewCompat.offsetTopAndBottom(v11, -i15);
                    V0(4);
                } else {
                    if (!this.M) {
                        return;
                    }
                    iArr[1] = i12;
                    ViewCompat.offsetTopAndBottom(v11, -i12);
                    V0(1);
                }
            }
            k0(v11.getTop());
            this.R = i12;
            this.S = true;
        }
    }

    public int q0() {
        return this.N;
    }

    public final int r0(int i11) {
        if (i11 == 3) {
            return o0();
        }
        if (i11 == 4) {
            return this.I;
        }
        if (i11 == 5) {
            return this.W;
        }
        if (i11 == 6) {
            return this.G;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i11);
    }

    public final float s0() {
        VelocityTracker velocityTracker = this.f36310b0;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f36313d);
        return this.f36310b0.getYVelocity(this.f36314d0);
    }

    @Override // ti.b
    public void startBackProgress(@NonNull androidx.activity.b bVar) {
        ti.f fVar = this.f36312c0;
        if (fVar == null) {
            return;
        }
        fVar.j(bVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11, int i12, int i13, int i14, int i15, @NonNull int[] iArr) {
    }

    public final boolean t0() {
        WeakReference<V> weakReference = this.X;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.X.get().getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    public final boolean u0() {
        return this.N == 3 && (this.f36340z || t0());
    }

    @Override // ti.b
    public void updateBackProgress(@NonNull androidx.activity.b bVar) {
        ti.f fVar = this.f36312c0;
        if (fVar == null) {
            return;
        }
        fVar.l(bVar);
    }

    public boolean v0() {
        return this.f36309b;
    }

    public boolean w0() {
        return this.f36330p;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.x(coordinatorLayout, v11, savedState.getSuperState());
        E0(savedState);
        int i11 = savedState.state;
        if (i11 == 1 || i11 == 2) {
            this.N = 4;
            this.O = 4;
        } else {
            this.N = i11;
            this.O = i11;
        }
    }

    public boolean x0() {
        return this.K;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    @NonNull
    public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11) {
        return new SavedState(super.y(coordinatorLayout, v11), (BottomSheetBehavior<?>) this);
    }

    public boolean y0() {
        return true;
    }

    public final boolean z0(V v11) {
        ViewParent parent = v11.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v11);
    }
}
