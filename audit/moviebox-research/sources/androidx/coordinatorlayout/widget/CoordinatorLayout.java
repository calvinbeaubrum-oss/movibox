package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.util.h;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.material.card.MaterialCardView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f7493v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Class<?>[] f7494w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ThreadLocal<Map<String, Constructor<c>>> f7495x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Comparator<View> f7496y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final androidx.core.util.f<Rect> f7497z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View> f7498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.coordinatorlayout.widget.b<View> f7499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<View> f7500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<View> f7501d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f7502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f7503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f7504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int[] f7507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f7508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f7509m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f7510n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7511o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WindowInsetsCompat f7512p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7513q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f7514r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f7515s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public OnApplyWindowInsetsListener f7516t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final NestedScrollingParentHelper f7517u;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        SparseArray<Parcelable> behaviorStates;

        /* JADX INFO: compiled from: source.java */
        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i11 = parcel.readInt();
            int[] iArr = new int[i11];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                this.behaviorStates.append(iArr[i12], parcelableArray[i12]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i12 = 0; i12 < size; i12++) {
                iArr[i12] = this.behaviorStates.keyAt(i12);
                parcelableArr[i12] = this.behaviorStates.valueAt(i12);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ViewElevationComparator implements Comparator<View> {
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            float z11 = ViewCompat.getZ(view);
            float z12 = ViewCompat.getZ(view2);
            if (z11 > z12) {
                return -1;
            }
            return z11 < z12 ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return CoordinatorLayout.this.J(windowInsetsCompat);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        @NonNull
        c getBehavior();
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c<V extends View> {
        public c() {
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, @NonNull View view2, int i11, int i12) {
            if (i12 == 0) {
                return z(coordinatorLayout, v11, view, view2, i11);
            }
            return false;
        }

        @Deprecated
        public void B(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view) {
        }

        public void C(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11) {
            if (i11 == 0) {
                B(coordinatorLayout, v11, view);
            }
        }

        public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11) {
            return d(coordinatorLayout, v11) > 0.0f;
        }

        public boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull Rect rect) {
            return false;
        }

        public int c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11) {
            return ViewCompat.MEASURED_STATE_MASK;
        }

        public float d(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11) {
            return 0.0f;
        }

        public boolean e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void g(@NonNull f fVar) {
        }

        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view) {
            return false;
        }

        public void i(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view) {
        }

        public void j() {
        }

        public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11) {
            return false;
        }

        public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11, int i12, int i13, int i14) {
            return false;
        }

        public boolean n(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, float f11, float f12, boolean z11) {
            return false;
        }

        public boolean o(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, float f11, float f12) {
            return false;
        }

        @Deprecated
        public void p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11, int i12, @NonNull int[] iArr) {
        }

        public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11, int i12, @NonNull int[] iArr, int i13) {
            if (i13 == 0) {
                p(coordinatorLayout, v11, view, i11, i12, iArr);
            }
        }

        @Deprecated
        public void r(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11, int i12, int i13, int i14) {
        }

        @Deprecated
        public void s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11, int i12, int i13, int i14, int i15) {
            if (i15 == 0) {
                r(coordinatorLayout, v11, view, i11, i12, i13, i14);
            }
        }

        public void t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11, int i12, int i13, int i14, int i15, @NonNull int[] iArr) {
            iArr[0] = iArr[0] + i13;
            iArr[1] = iArr[1] + i14;
            s(coordinatorLayout, v11, view, i11, i12, i13, i14, i15);
        }

        @Deprecated
        public void u(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, @NonNull View view2, int i11) {
        }

        public void v(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, @NonNull View view2, int i11, int i12) {
            if (i12 == 0) {
                u(coordinatorLayout, v11, view, view2, i11);
            }
        }

        public boolean w(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull Rect rect, boolean z11) {
            return false;
        }

        public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull Parcelable parcelable) {
        }

        @Nullable
        public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, @NonNull View view2, int i11) {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f7515s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.w(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f7515s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f7520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7522c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7523d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7524e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7525f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7526g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7527h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7528i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7529j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View f7530k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public View f7531l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f7532m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f7533n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f7534o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f7535p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Rect f7536q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f7537r;

        public f(int i11, int i12) {
            super(i11, i12);
            this.f7521b = false;
            this.f7522c = 0;
            this.f7523d = 0;
            this.f7524e = -1;
            this.f7525f = -1;
            this.f7526g = 0;
            this.f7527h = 0;
            this.f7536q = new Rect();
        }

        public f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7521b = false;
            this.f7522c = 0;
            this.f7523d = 0;
            this.f7524e = -1;
            this.f7525f = -1;
            this.f7526g = 0;
            this.f7527h = 0;
            this.f7536q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.f7522c = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f7525f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f7523d = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f7524e = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f7526g = typedArrayObtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f7527h = typedArrayObtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R$styleable.CoordinatorLayout_Layout_layout_behavior);
            this.f7521b = zHasValue;
            if (zHasValue) {
                this.f7520a = CoordinatorLayout.x(context, attributeSet, typedArrayObtainStyledAttributes.getString(R$styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar = this.f7520a;
            if (cVar != null) {
                cVar.g(this);
            }
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7521b = false;
            this.f7522c = 0;
            this.f7523d = 0;
            this.f7524e = -1;
            this.f7525f = -1;
            this.f7526g = 0;
            this.f7527h = 0;
            this.f7536q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7521b = false;
            this.f7522c = 0;
            this.f7523d = 0;
            this.f7524e = -1;
            this.f7525f = -1;
            this.f7526g = 0;
            this.f7527h = 0;
            this.f7536q = new Rect();
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f7521b = false;
            this.f7522c = 0;
            this.f7523d = 0;
            this.f7524e = -1;
            this.f7525f = -1;
            this.f7526g = 0;
            this.f7527h = 0;
            this.f7536q = new Rect();
        }

        public boolean a() {
            return this.f7530k == null && this.f7525f != -1;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.f7531l || s(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) || ((cVar = this.f7520a) != null && cVar.e(coordinatorLayout, view, view2));
        }

        public boolean c() {
            if (this.f7520a == null) {
                this.f7532m = false;
            }
            return this.f7532m;
        }

        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f7525f == -1) {
                this.f7531l = null;
                this.f7530k = null;
                return null;
            }
            if (this.f7530k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f7530k;
        }

        public int e() {
            return this.f7525f;
        }

        @Nullable
        public c f() {
            return this.f7520a;
        }

        public boolean g() {
            return this.f7535p;
        }

        public Rect h() {
            return this.f7536q;
        }

        public boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z11 = this.f7532m;
            if (z11) {
                return true;
            }
            c cVar = this.f7520a;
            boolean zA = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z11;
            this.f7532m = zA;
            return zA;
        }

        public boolean j(int i11) {
            if (i11 == 0) {
                return this.f7533n;
            }
            if (i11 != 1) {
                return false;
            }
            return this.f7534o;
        }

        public void k() {
            this.f7535p = false;
        }

        public void l(int i11) {
            r(i11, false);
        }

        public void m() {
            this.f7532m = false;
        }

        public final void n(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f7525f);
            this.f7530k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f7531l = null;
                    this.f7530k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f7525f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f7531l = null;
                this.f7530k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f7531l = null;
                    this.f7530k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f7531l = viewFindViewById;
        }

        public void o(@Nullable c cVar) {
            c cVar2 = this.f7520a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.j();
                }
                this.f7520a = cVar;
                this.f7537r = null;
                this.f7521b = true;
                if (cVar != null) {
                    cVar.g(this);
                }
            }
        }

        public void p(boolean z11) {
            this.f7535p = z11;
        }

        public void q(Rect rect) {
            this.f7536q.set(rect);
        }

        public void r(int i11, boolean z11) {
            if (i11 == 0) {
                this.f7533n = z11;
            } else {
                if (i11 != 1) {
                    return;
                }
                this.f7534o = z11;
            }
        }

        public final boolean s(View view, int i11) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((f) view.getLayoutParams()).f7526g, i11);
            return absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.f7527h, i11) & absoluteGravity) == absoluteGravity;
        }

        public final boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f7530k.getId() != this.f7525f) {
                return false;
            }
            View view2 = this.f7530k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f7531l = null;
                    this.f7530k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f7531l = view2;
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.w(0);
            return true;
        }
    }

    static {
        Package r11 = CoordinatorLayout.class.getPackage();
        f7493v = r11 != null ? r11.getName() : null;
        f7496y = new ViewElevationComparator();
        f7494w = new Class[]{Context.class, AttributeSet.class};
        f7495x = new ThreadLocal<>();
        f7497z = new h(12);
    }

    public CoordinatorLayout(@NonNull Context context) {
        this(context, null);
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7498a = new ArrayList();
        this.f7499b = new androidx.coordinatorlayout.widget.b<>();
        this.f7500c = new ArrayList();
        this.f7501d = new ArrayList();
        this.f7503g = new int[2];
        this.f7504h = new int[2];
        this.f7517u = new NestedScrollingParentHelper(this);
        TypedArray typedArrayObtainStyledAttributes = i11 == 0 ? context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, i11, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i11 == 0) {
                saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, R$style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i11, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f7507k = resources.getIntArray(resourceId);
            float f11 = resources.getDisplayMetrics().density;
            int length = this.f7507k.length;
            for (int i12 = 0; i12 < length; i12++) {
                int[] iArr = this.f7507k;
                iArr[i12] = (int) (iArr[i12] * f11);
            }
        }
        this.f7514r = typedArrayObtainStyledAttributes.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        K();
        super.setOnHierarchyChangeListener(new e());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public static void B(@NonNull Rect rect) {
        rect.setEmpty();
        f7497z.release(rect);
    }

    public static int E(int i11) {
        if (i11 == 0) {
            return 17;
        }
        return i11;
    }

    private static int F(int i11) {
        if ((i11 & 7) == 0) {
            i11 |= GravityCompat.START;
        }
        return (i11 & 112) == 0 ? i11 | 48 : i11;
    }

    public static int G(int i11) {
        return i11 == 0 ? MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END : i11;
    }

    @NonNull
    public static Rect a() {
        Rect rectAcquire = f7497z.acquire();
        return rectAcquire == null ? new Rect() : rectAcquire;
    }

    private static int c(int i11, int i12, int i13) {
        if (i11 < i12) {
            return i12;
        }
        return i11 > i13 ? i13 : i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c x(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(InstructionFileId.DOT)) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f7493v;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<c>>> threadLocal = f7495x;
            Map<String, Constructor<c>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f7494w);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e11) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e11);
        }
    }

    public void A(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    public void C() {
        if (this.f7506j && this.f7510n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f7510n);
        }
        this.f7511o = false;
    }

    public final void D(boolean z11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            c cVarF = ((f) childAt.getLayoutParams()).f();
            if (cVarF != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z11) {
                    cVarF.k(this, childAt, motionEventObtain);
                } else {
                    cVarF.D(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            ((f) getChildAt(i12).getLayoutParams()).m();
        }
        this.f7508l = null;
        this.f7505i = false;
    }

    public final void H(View view, int i11) {
        f fVar = (f) view.getLayoutParams();
        int i12 = fVar.f7528i;
        if (i12 != i11) {
            ViewCompat.offsetLeftAndRight(view, i11 - i12);
            fVar.f7528i = i11;
        }
    }

    public final void I(View view, int i11) {
        f fVar = (f) view.getLayoutParams();
        int i12 = fVar.f7529j;
        if (i12 != i11) {
            ViewCompat.offsetTopAndBottom(view, i11 - i12);
            fVar.f7529j = i11;
        }
    }

    public final WindowInsetsCompat J(WindowInsetsCompat windowInsetsCompat) {
        if (androidx.core.util.d.a(this.f7512p, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.f7512p = windowInsetsCompat;
        boolean z11 = false;
        boolean z12 = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
        this.f7513q = z12;
        if (!z12 && getBackground() == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        WindowInsetsCompat windowInsetsCompatE = e(windowInsetsCompat);
        requestLayout();
        return windowInsetsCompatE;
    }

    public final void K() {
        if (!ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.setOnApplyWindowInsetsListener(this, null);
            return;
        }
        if (this.f7516t == null) {
            this.f7516t = new a();
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, this.f7516t);
        setSystemUiVisibility(1280);
    }

    public void b() {
        if (this.f7506j) {
            if (this.f7510n == null) {
                this.f7510n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f7510n);
        }
        this.f7511o = true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public final void d(f fVar, Rect rect, int i11, int i12) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i11) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i12) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i11 + iMax, i12 + iMax2);
    }

    public void dispatchDependentViewsChanged(@NonNull View view) {
        List listG = this.f7499b.g(view);
        if (listG == null || listG.isEmpty()) {
            return;
        }
        for (int i11 = 0; i11 < listG.size(); i11++) {
            View view2 = (View) listG.get(i11);
            c cVarF = ((f) view2.getLayoutParams()).f();
            if (cVarF != null) {
                cVarF.h(this, view2, view);
            }
        }
    }

    public boolean doViewsOverlap(@NonNull View view, @NonNull View view2) {
        boolean z11 = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rectA = a();
        i(view, view.getParent() != this, rectA);
        Rect rectA2 = a();
        i(view2, view2.getParent() != this, rectA2);
        try {
            if (rectA.left <= rectA2.right && rectA.top <= rectA2.bottom && rectA.right >= rectA2.left && rectA.bottom >= rectA2.top) {
                z11 = true;
            }
            return z11;
        } finally {
            B(rectA);
            B(rectA2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j11) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f7520a;
        if (cVar != null) {
            float fD = cVar.d(this, view);
            if (fD > 0.0f) {
                if (this.f7502f == null) {
                    this.f7502f = new Paint();
                }
                this.f7502f.setColor(fVar.f7520a.c(this, view));
                this.f7502f.setAlpha(c(Math.round(fD * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f7502f);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f7514r;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidate();
        }
    }

    public final WindowInsetsCompat e(WindowInsetsCompat windowInsetsCompat) {
        c cVarF;
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (ViewCompat.getFitsSystemWindows(childAt) && (cVarF = ((f) childAt.getLayoutParams()).f()) != null) {
                windowInsetsCompat = cVarF.f(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.isConsumed()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    public void f() {
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            if (q(getChildAt(i11))) {
                z11 = true;
                break;
            }
        }
        if (z11 != this.f7511o) {
            if (z11) {
                b();
            } else {
                C();
            }
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @NonNull
    public List<View> getDependencies(@NonNull View view) {
        List<View> listH = this.f7499b.h(view);
        this.f7501d.clear();
        if (listH != null) {
            this.f7501d.addAll(listH);
        }
        return this.f7501d;
    }

    public final List<View> getDependencySortedChildren() {
        z();
        return Collections.unmodifiableList(this.f7498a);
    }

    @NonNull
    public List<View> getDependents(@NonNull View view) {
        List listG = this.f7499b.g(view);
        this.f7501d.clear();
        if (listG != null) {
            this.f7501d.addAll(listG);
        }
        return this.f7501d;
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.f7512p;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f7517u.getNestedScrollAxes();
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.f7514r;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public void i(View view, boolean z11, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z11) {
            j(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean isPointInChildBounds(@NonNull View view, int i11, int i12) {
        Rect rectA = a();
        j(view, rectA);
        try {
            return rectA.contains(i11, i12);
        } finally {
            B(rectA);
        }
    }

    public void j(View view, Rect rect) {
        androidx.coordinatorlayout.widget.c.a(this, view, rect);
    }

    public void k(View view, int i11, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        l(view, i11, rect, rect2, fVar, measuredWidth, measuredHeight);
        d(fVar, rect2, measuredWidth, measuredHeight);
    }

    public final void l(View view, int i11, Rect rect, Rect rect2, f fVar, int i12, int i13) {
        int iWidth;
        int iHeight;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(E(fVar.f7522c), i11);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(F(fVar.f7523d), i11);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int i16 = absoluteGravity2 & 7;
        int i17 = absoluteGravity2 & 112;
        if (i16 != 1) {
            iWidth = i16 != 5 ? rect.left : rect.right;
        } else {
            iWidth = rect.left + (rect.width() / 2);
        }
        if (i17 != 16) {
            iHeight = i17 != 80 ? rect.top : rect.bottom;
        } else {
            iHeight = rect.top + (rect.height() / 2);
        }
        if (i14 == 1) {
            iWidth -= i12 / 2;
        } else if (i14 != 5) {
            iWidth -= i12;
        }
        if (i15 == 16) {
            iHeight -= i13 / 2;
        } else if (i15 != 80) {
            iHeight -= i13;
        }
        rect2.set(iWidth, iHeight, i12 + iWidth, i13 + iHeight);
    }

    public final int m(int i11) {
        int[] iArr = this.f7507k;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i11);
            return 0;
        }
        if (i11 >= 0 && i11 < iArr.length) {
            return iArr[i11];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i11 + " out of range for " + this);
        return 0;
    }

    public void n(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f o(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f7521b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.o(behavior);
                fVar.f7521b = true;
            } else {
                d dVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    dVar = (d) superclass.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.o(dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e11) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e11);
                    }
                }
                fVar.f7521b = true;
            }
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        D(false);
        if (this.f7511o) {
            if (this.f7510n == null) {
                this.f7510n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f7510n);
        }
        if (this.f7512p == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.f7506j = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        D(false);
        if (this.f7511o && this.f7510n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f7510n);
        }
        View view = this.f7509m;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f7506j = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f7513q || this.f7514r == null) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.f7512p;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f7514r.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f7514r.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            D(true);
        }
        boolean zY = y(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            D(true);
        }
        return zY;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        c cVarF;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.f7498a.size();
        for (int i15 = 0; i15 < size; i15++) {
            View view = this.f7498a.get(i15);
            if (view.getVisibility() != 8 && ((cVarF = ((f) view.getLayoutParams()).f()) == null || !cVarF.l(this, view, layoutDirection))) {
                onLayoutChild(view, layoutDirection);
            }
        }
    }

    public void onLayoutChild(@NonNull View view, int i11) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = fVar.f7530k;
        if (view2 != null) {
            s(view, view2, i11);
            return;
        }
        int i12 = fVar.f7524e;
        if (i12 >= 0) {
            t(view, i12, i11);
        } else {
            r(view, i11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:46:0x011f  */
    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int i13;
        int iMax;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        c cVarF;
        f fVar;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        z();
        f();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        boolean z11 = layoutDirection == 1;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int i21 = paddingLeft + paddingRight;
        int i22 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z12 = this.f7512p != null && ViewCompat.getFitsSystemWindows(this);
        int size3 = this.f7498a.size();
        int i23 = suggestedMinimumWidth;
        int i24 = suggestedMinimumHeight;
        int iCombineMeasuredStates = 0;
        int i25 = 0;
        while (i25 < size3) {
            View view = this.f7498a.get(i25);
            if (view.getVisibility() == 8) {
                i18 = i25;
                i15 = size3;
                i16 = paddingLeft;
            } else {
                f fVar2 = (f) view.getLayoutParams();
                int i26 = fVar2.f7524e;
                if (i26 < 0 || mode == 0) {
                    i13 = iCombineMeasuredStates;
                } else {
                    int iM = m(i26);
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(G(fVar2.f7522c), layoutDirection) & 7;
                    i13 = iCombineMeasuredStates;
                    if ((absoluteGravity == 3 && !z11) || (absoluteGravity == 5 && z11)) {
                        iMax = Math.max(0, (size - paddingRight) - iM);
                    } else if ((absoluteGravity == 5 && !z11) || (absoluteGravity == 3 && z11)) {
                        iMax = Math.max(0, iM - paddingLeft);
                    }
                    if (z12 || ViewCompat.getFitsSystemWindows(view)) {
                        iMakeMeasureSpec = i11;
                        iMakeMeasureSpec2 = i12;
                    } else {
                        int systemWindowInsetLeft = this.f7512p.getSystemWindowInsetLeft() + this.f7512p.getSystemWindowInsetRight();
                        int systemWindowInsetTop = this.f7512p.getSystemWindowInsetTop() + this.f7512p.getSystemWindowInsetBottom();
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - systemWindowInsetLeft, mode);
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - systemWindowInsetTop, mode2);
                    }
                    cVarF = fVar2.f();
                    if (cVarF != null) {
                        fVar = fVar2;
                        i17 = i13;
                        i18 = i25;
                        i14 = i24;
                        i16 = paddingLeft;
                        i19 = i23;
                        i15 = size3;
                        if (!cVarF.m(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                        }
                        f fVar3 = fVar;
                        int iMax2 = Math.max(i19, i21 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin + ((ViewGroup.MarginLayoutParams) fVar3).rightMargin);
                        int iMax3 = Math.max(i14, i22 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin + ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
                        iCombineMeasuredStates = View.combineMeasuredStates(i17, view.getMeasuredState());
                        i23 = iMax2;
                        i24 = iMax3;
                    } else {
                        fVar = fVar2;
                        i14 = i24;
                        i15 = size3;
                        i16 = paddingLeft;
                        i17 = i13;
                        i18 = i25;
                        i19 = i23;
                    }
                    onMeasureChild(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                    f fVar4 = fVar;
                    int iMax4 = Math.max(i19, i21 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin + ((ViewGroup.MarginLayoutParams) fVar4).rightMargin);
                    int iMax5 = Math.max(i14, i22 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin + ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i17, view.getMeasuredState());
                    i23 = iMax4;
                    i24 = iMax5;
                }
                iMax = 0;
                if (z12) {
                    iMakeMeasureSpec = i11;
                    iMakeMeasureSpec2 = i12;
                } else {
                    iMakeMeasureSpec = i11;
                    iMakeMeasureSpec2 = i12;
                }
                cVarF = fVar2.f();
                if (cVarF != null) {
                    fVar = fVar2;
                    i17 = i13;
                    i18 = i25;
                    i14 = i24;
                    i16 = paddingLeft;
                    i19 = i23;
                    i15 = size3;
                    if (!cVarF.m(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                    }
                    f fVar5 = fVar;
                    int iMax6 = Math.max(i19, i21 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar5).leftMargin + ((ViewGroup.MarginLayoutParams) fVar5).rightMargin);
                    int iMax7 = Math.max(i14, i22 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar5).topMargin + ((ViewGroup.MarginLayoutParams) fVar5).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i17, view.getMeasuredState());
                    i23 = iMax6;
                    i24 = iMax7;
                } else {
                    fVar = fVar2;
                    i14 = i24;
                    i15 = size3;
                    i16 = paddingLeft;
                    i17 = i13;
                    i18 = i25;
                    i19 = i23;
                }
                onMeasureChild(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                f fVar6 = fVar;
                int iMax8 = Math.max(i19, i21 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar6).leftMargin + ((ViewGroup.MarginLayoutParams) fVar6).rightMargin);
                int iMax9 = Math.max(i14, i22 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar6).topMargin + ((ViewGroup.MarginLayoutParams) fVar6).bottomMargin);
                iCombineMeasuredStates = View.combineMeasuredStates(i17, view.getMeasuredState());
                i23 = iMax8;
                i24 = iMax9;
            }
            i25 = i18 + 1;
            paddingLeft = i16;
            size3 = i15;
        }
        int i27 = iCombineMeasuredStates;
        setMeasuredDimension(View.resolveSizeAndState(i23, i11, (-16777216) & i27), View.resolveSizeAndState(i24, i12, i27 << 16));
    }

    public void onMeasureChild(View view, int i11, int i12, int i13, int i14) {
        measureChildWithMargins(view, i11, i12, i13, i14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        c cVarF;
        int childCount = getChildCount();
        boolean zN = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (cVarF = fVar.f()) != null) {
                    zN |= cVarF.n(this, childAt, view, f11, f12, z11);
                }
            }
        }
        if (zN) {
            w(1);
        }
        return zN;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f11, float f12) {
        c cVarF;
        int childCount = getChildCount();
        boolean zO = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (cVarF = fVar.f()) != null) {
                    zO |= cVarF.o(this, childAt, view, f11, f12);
                }
            }
        }
        return zO;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
        onNestedPreScroll(view, i11, i12, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        c cVarF;
        int childCount = getChildCount();
        boolean z11 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i13) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.f7503g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.q(this, childAt, view, i11, i12, iArr2, i13);
                    int[] iArr3 = this.f7503g;
                    iMax = i11 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f7503g;
                    iMax2 = i12 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z11 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z11) {
            w(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i11, i12, i13, i14, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        onNestedScroll(view, i11, i12, i13, i14, 0, this.f7504h);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15, @NonNull int[] iArr) {
        c cVarF;
        int childCount = getChildCount();
        boolean z11 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i15) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.f7503g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.t(this, childAt, view, i11, i12, i13, i14, i15, iArr2);
                    int[] iArr3 = this.f7503g;
                    iMax = i13 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    iMax2 = i14 > 0 ? Math.max(iMax2, this.f7503g[1]) : Math.min(iMax2, this.f7503g[1]);
                    z11 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z11) {
            w(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i11) {
        onNestedScrollAccepted(view, view2, i11, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        c cVarF;
        this.f7517u.onNestedScrollAccepted(view, view2, i11, i12);
        this.f7509m = view2;
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i12) && (cVarF = fVar.f()) != null) {
                cVarF.v(this, childAt, view, view2, i11, i12);
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id2 = childAt.getId();
            c cVarF = o(childAt).f();
            if (id2 != -1 && cVarF != null && (parcelable2 = sparseArray.get(id2)) != null) {
                cVarF.x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableY;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id2 = childAt.getId();
            c cVarF = ((f) childAt.getLayoutParams()).f();
            if (id2 != -1 && cVarF != null && (parcelableY = cVarF.y(this, childAt)) != null) {
                sparseArray.append(id2, parcelableY);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i11) {
        return onStartNestedScroll(view, view2, i11, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVarF = fVar.f();
                if (cVarF != null) {
                    boolean zA = cVarF.A(this, childAt, view, view2, i11, i12);
                    z11 |= zA;
                    fVar.r(i12, zA);
                } else {
                    fVar.r(i12, false);
                }
            }
        }
        return z11;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i11) {
        this.f7517u.onStopNestedScroll(view, i11);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i11)) {
                c cVarF = fVar.f();
                if (cVarF != null) {
                    cVarF.C(this, childAt, view, i11);
                }
                fVar.l(i11);
                fVar.k();
            }
        }
        this.f7509m = null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x0037 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015 A[PHI: r3
  0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0024, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zY;
        boolean zD;
        MotionEvent motionEventObtain;
        int actionMasked = motionEvent.getActionMasked();
        if (this.f7508l == null) {
            zY = y(motionEvent, 1);
            if (!zY) {
                zD = false;
            }
            motionEventObtain = null;
            if (this.f7508l == null) {
                zD |= super.onTouchEvent(motionEvent);
            } else if (zY) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEventObtain);
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                D(false);
            }
            return zD;
        }
        zY = false;
        c cVarF = ((f) this.f7508l.getLayoutParams()).f();
        if (cVarF != null) {
            zD = cVarF.D(this, this.f7508l, motionEvent);
        } else {
            zD = false;
        }
        motionEventObtain = null;
        if (this.f7508l == null) {
            zD |= super.onTouchEvent(motionEvent);
        } else if (zY) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            motionEventObtain = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEventObtain);
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        if (actionMasked != 1) {
            D(false);
        } else {
            D(false);
        }
        return zD;
    }

    public final void p(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i11) : i11));
        }
        Comparator<View> comparator = f7496y;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public final boolean q(View view) {
        return this.f7499b.j(view);
    }

    public final void r(View view, int i11) {
        f fVar = (f) view.getLayoutParams();
        Rect rectA = a();
        rectA.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.f7512p != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
            rectA.left += this.f7512p.getSystemWindowInsetLeft();
            rectA.top += this.f7512p.getSystemWindowInsetTop();
            rectA.right -= this.f7512p.getSystemWindowInsetRight();
            rectA.bottom -= this.f7512p.getSystemWindowInsetBottom();
        }
        Rect rectA2 = a();
        GravityCompat.apply(F(fVar.f7522c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectA, rectA2, i11);
        view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        B(rectA);
        B(rectA2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z11) {
        c cVarF = ((f) view.getLayoutParams()).f();
        if (cVarF == null || !cVarF.w(this, view, rect, z11)) {
            return super.requestChildRectangleOnScreen(view, rect, z11);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z11) {
        super.requestDisallowInterceptTouchEvent(z11);
        if (!z11 || this.f7505i) {
            return;
        }
        D(false);
        this.f7505i = true;
    }

    public final void s(View view, View view2, int i11) {
        Rect rectA = a();
        Rect rectA2 = a();
        try {
            j(view2, rectA);
            k(view, i11, rectA, rectA2);
            view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        } finally {
            B(rectA);
            B(rectA2);
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z11) {
        super.setFitsSystemWindows(z11);
        K();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f7515s = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f7514r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f7514r = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f7514r.setState(getDrawableState());
                }
                d3.a.m(this.f7514r, ViewCompat.getLayoutDirection(this));
                this.f7514r.setVisible(getVisibility() == 0, false);
                this.f7514r.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarBackgroundColor(int i11) {
        setStatusBarBackground(new ColorDrawable(i11));
    }

    public void setStatusBarBackgroundResource(int i11) {
        setStatusBarBackground(i11 != 0 ? z2.a.getDrawable(getContext(), i11) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        boolean z11 = i11 == 0;
        Drawable drawable = this.f7514r;
        if (drawable == null || drawable.isVisible() == z11) {
            return;
        }
        this.f7514r.setVisible(z11, false);
    }

    public final void t(View view, int i11, int i12) {
        int i13;
        f fVar = (f) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(G(fVar.f7522c), i12);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i12 == 1) {
            i11 = width - i11;
        }
        int iM = m(i11) - measuredWidth;
        if (i14 == 1) {
            iM += measuredWidth / 2;
        } else if (i14 == 5) {
            iM += measuredWidth;
        }
        if (i15 != 16) {
            i13 = i15 != 80 ? 0 : measuredHeight;
        } else {
            i13 = measuredHeight / 2;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(iM, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i13, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    public final void u(View view, Rect rect, int i11) {
        boolean z11;
        int width;
        int i12;
        int i13;
        int i14;
        int height;
        int i15;
        int i16;
        int i17;
        if (ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            Rect rectA = a();
            Rect rectA2 = a();
            rectA2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (cVarF == null || !cVarF.b(this, view, rectA)) {
                rectA.set(rectA2);
            } else if (!rectA2.contains(rectA)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectA.toShortString() + " | Bounds:" + rectA2.toShortString());
            }
            B(rectA2);
            if (rectA.isEmpty()) {
                B(rectA);
                return;
            }
            int absoluteGravity = GravityCompat.getAbsoluteGravity(fVar.f7527h, i11);
            boolean z12 = true;
            if ((absoluteGravity & 48) != 48 || (i16 = (rectA.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f7529j) >= (i17 = rect.top)) {
                z11 = false;
            } else {
                I(view, i17 - i16);
                z11 = true;
            }
            if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - rectA.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f7529j) < (i15 = rect.bottom)) {
                I(view, height - i15);
            } else if (!z11) {
                I(view, 0);
            }
            if ((absoluteGravity & 3) != 3 || (i13 = (rectA.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f7528i) >= (i14 = rect.left)) {
                z12 = false;
            } else {
                H(view, i14 - i13);
            }
            if ((absoluteGravity & 5) == 5 && (width = ((getWidth() - rectA.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f7528i) < (i12 = rect.right)) {
                H(view, width - i12);
            } else if (!z12) {
                H(view, 0);
            }
            B(rectA);
        }
    }

    public void v(View view, int i11) {
        c cVarF;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f7530k != null) {
            Rect rectA = a();
            Rect rectA2 = a();
            Rect rectA3 = a();
            j(fVar.f7530k, rectA);
            i(view, false, rectA2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            l(view, i11, rectA, rectA3, fVar, measuredWidth, measuredHeight);
            boolean z11 = (rectA3.left == rectA2.left && rectA3.top == rectA2.top) ? false : true;
            d(fVar, rectA3, measuredWidth, measuredHeight);
            int i12 = rectA3.left - rectA2.left;
            int i13 = rectA3.top - rectA2.top;
            if (i12 != 0) {
                ViewCompat.offsetLeftAndRight(view, i12);
            }
            if (i13 != 0) {
                ViewCompat.offsetTopAndBottom(view, i13);
            }
            if (z11 && (cVarF = fVar.f()) != null) {
                cVarF.h(this, view, fVar.f7530k);
            }
            B(rectA);
            B(rectA2);
            B(rectA3);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7514r;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ca  */
    public final void w(int i11) {
        int i12;
        c cVarF;
        boolean zH;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.f7498a.size();
        Rect rectA = a();
        Rect rectA2 = a();
        Rect rectA3 = a();
        for (int i13 = 0; i13 < size; i13++) {
            View view = this.f7498a.get(i13);
            f fVar = (f) view.getLayoutParams();
            if (i11 != 0 || view.getVisibility() != 8) {
                for (int i14 = 0; i14 < i13; i14++) {
                    if (fVar.f7531l == this.f7498a.get(i14)) {
                        v(view, layoutDirection);
                    }
                }
                i(view, true, rectA2);
                if (fVar.f7526g != 0 && !rectA2.isEmpty()) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(fVar.f7526g, layoutDirection);
                    int i15 = absoluteGravity & 112;
                    if (i15 == 48) {
                        rectA.top = Math.max(rectA.top, rectA2.bottom);
                    } else if (i15 == 80) {
                        rectA.bottom = Math.max(rectA.bottom, getHeight() - rectA2.top);
                    }
                    int i16 = absoluteGravity & 7;
                    if (i16 == 3) {
                        rectA.left = Math.max(rectA.left, rectA2.right);
                    } else if (i16 == 5) {
                        rectA.right = Math.max(rectA.right, getWidth() - rectA2.left);
                    }
                }
                if (fVar.f7527h != 0 && view.getVisibility() == 0) {
                    u(view, rectA, layoutDirection);
                }
                if (i11 != 2) {
                    n(view, rectA3);
                    if (!rectA3.equals(rectA2)) {
                        A(view, rectA2);
                        for (i12 = i13 + 1; i12 < size; i12++) {
                            View view2 = this.f7498a.get(i12);
                            f fVar2 = (f) view2.getLayoutParams();
                            cVarF = fVar2.f();
                            if (cVarF == null && cVarF.e(this, view2, view)) {
                                if (i11 == 0 && fVar2.g()) {
                                    fVar2.k();
                                } else {
                                    if (i11 != 2) {
                                        zH = cVarF.h(this, view2, view);
                                    } else {
                                        cVarF.i(this, view2, view);
                                        zH = true;
                                    }
                                    if (i11 == 1) {
                                        fVar2.p(zH);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    while (i12 < size) {
                        View view3 = this.f7498a.get(i12);
                        f fVar3 = (f) view3.getLayoutParams();
                        cVarF = fVar3.f();
                        if (cVarF == null) {
                        }
                    }
                }
            }
        }
        B(rectA);
        B(rectA2);
        B(rectA3);
    }

    public final boolean y(MotionEvent motionEvent, int i11) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f7500c;
        p(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zK = false;
        boolean z11 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view = list.get(i12);
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            if (!(zK || z11) || actionMasked == 0) {
                if (!zK && cVarF != null) {
                    if (i11 == 0) {
                        zK = cVarF.k(this, view, motionEvent);
                    } else if (i11 == 1) {
                        zK = cVarF.D(this, view, motionEvent);
                    }
                    if (zK) {
                        this.f7508l = view;
                    }
                }
                boolean zC = fVar.c();
                boolean zI = fVar.i(this, view);
                z11 = zI && !zC;
                if (zI && !z11) {
                    break;
                }
            } else if (cVarF != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i11 == 0) {
                    cVarF.k(this, view, motionEventObtain);
                } else if (i11 == 1) {
                    cVarF.D(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zK;
    }

    public final void z() {
        this.f7498a.clear();
        this.f7499b.c();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            f fVarO = o(childAt);
            fVarO.d(this, childAt);
            this.f7499b.b(childAt);
            for (int i12 = 0; i12 < childCount; i12++) {
                if (i12 != i11) {
                    View childAt2 = getChildAt(i12);
                    if (fVarO.b(this, childAt, childAt2)) {
                        if (!this.f7499b.d(childAt2)) {
                            this.f7499b.b(childAt2);
                        }
                        this.f7499b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f7498a.addAll(this.f7499b.i());
        Collections.reverse(this.f7498a);
    }
}
