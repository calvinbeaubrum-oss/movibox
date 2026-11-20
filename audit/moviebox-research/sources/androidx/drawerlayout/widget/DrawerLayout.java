package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.R$attr;
import androidx.drawerlayout.R$dimen;
import androidx.drawerlayout.R$styleable;
import com.google.logging.type.LogSeverity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    public static final int[] M = {R.attr.colorPrimaryDark};
    public static final int[] N = {R.attr.layout_gravity};
    public static final boolean O;
    public static final boolean P;
    public static boolean Q = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public CharSequence A;
    public CharSequence B;
    public Object C;
    public boolean D;
    public Drawable E;
    public Drawable F;
    public Drawable G;
    public Drawable H;
    public final ArrayList<View> I;
    public Rect J;
    public Matrix K;
    public final AccessibilityViewCommand L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f8188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8190d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f8191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f8192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewDragHelper f8193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewDragHelper f8194i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewDragCallback f8195j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewDragCallback f8196k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8197l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8198m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8199n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8200o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8201p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8202q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f8203r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f8204s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public e f8205t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List<e> f8206u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f8207v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f8208w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f8209x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Drawable f8210y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f8211z;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

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
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
            this.openDrawerGravity = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.openDrawerGravity);
            parcel.writeInt(this.lockModeLeft);
            parcel.writeInt(this.lockModeRight);
            parcel.writeInt(this.lockModeStart);
            parcel.writeInt(this.lockModeEnd);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class ViewDragCallback extends ViewDragHelper.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewDragHelper f8213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f8214c = new Runnable() { // from class: androidx.drawerlayout.widget.DrawerLayout.ViewDragCallback.1
            @Override // java.lang.Runnable
            public void run() {
                ViewDragCallback.this.o();
            }
        };

        public ViewDragCallback(int i11) {
            this.f8212a = i11;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int a(View view, int i11, int i12) {
            if (DrawerLayout.this.b(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i11, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i11, width));
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int b(View view, int i11, int i12) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int d(View view) {
            if (DrawerLayout.this.t(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void f(int i11, int i12) {
            View viewH = (i11 & 1) == 1 ? DrawerLayout.this.h(3) : DrawerLayout.this.h(5);
            if (viewH == null || DrawerLayout.this.getDrawerLockMode(viewH) != 0) {
                return;
            }
            this.f8213b.c(viewH, i12);
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean g(int i11) {
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void h(int i11, int i12) {
            DrawerLayout.this.postDelayed(this.f8214c, 160L);
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void i(View view, int i11) {
            ((f) view.getLayoutParams()).f8222c = false;
            n();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void j(int i11) {
            DrawerLayout.this.D(i11, this.f8213b.w());
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void k(View view, int i11, int i12, int i13, int i14) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.b(view, 3) ? i11 + width : DrawerLayout.this.getWidth() - i11) / width;
            DrawerLayout.this.A(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void l(View view, float f11, float f12) {
            int i11;
            float fL = DrawerLayout.this.l(view);
            int width = view.getWidth();
            if (DrawerLayout.this.b(view, 3)) {
                i11 = (f11 > 0.0f || (f11 == 0.0f && fL > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f11 < 0.0f || (f11 == 0.0f && fL > 0.5f)) {
                    width2 -= width;
                }
                i11 = width2;
            }
            this.f8213b.Q(i11, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean m(View view, int i11) {
            return DrawerLayout.this.t(view) && DrawerLayout.this.b(view, this.f8212a) && DrawerLayout.this.getDrawerLockMode(view) == 0;
        }

        public final void n() {
            View viewH = DrawerLayout.this.h(this.f8212a == 3 ? 5 : 3);
            if (viewH != null) {
                DrawerLayout.this.closeDrawer(viewH);
            }
        }

        public void o() {
            View viewH;
            int width;
            int iY = this.f8213b.y();
            boolean z11 = this.f8212a == 3;
            if (z11) {
                viewH = DrawerLayout.this.h(3);
                width = (viewH != null ? -viewH.getWidth() : 0) + iY;
            } else {
                viewH = DrawerLayout.this.h(5);
                width = DrawerLayout.this.getWidth() - iY;
            }
            if (viewH != null) {
                if (((!z11 || viewH.getLeft() >= width) && (z11 || viewH.getLeft() <= width)) || DrawerLayout.this.getDrawerLockMode(viewH) != 0) {
                    return;
                }
                f fVar = (f) viewH.getLayoutParams();
                this.f8213b.S(viewH, width, viewH.getTop());
                fVar.f8222c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.a();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f8214c);
        }

        public void q(ViewDragHelper viewDragHelper) {
            this.f8213b = viewDragHelper;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements AccessibilityViewCommand {
        public a() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            if (!DrawerLayout.this.isDrawerOpen(view) || DrawerLayout.this.getDrawerLockMode(view) == 2) {
                return false;
            }
            DrawerLayout.this.closeDrawer(view);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b implements View.OnApplyWindowInsetsListener {
        public b() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f8218a = new Rect();

        public c() {
        }

        public final void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (DrawerLayout.r(childAt)) {
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        public final void b(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f8218a;
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewJ = DrawerLayout.this.j();
            if (viewJ == null) {
                return true;
            }
            CharSequence drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.k(viewJ));
            if (drawerTitle == null) {
                return true;
            }
            text.add(drawerTitle);
            return true;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.O) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompatObtain);
                accessibilityNodeInfoCompat.setSource(view);
                Object parentForAccessibility = ViewCompat.getParentForAccessibility(view);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                }
                b(accessibilityNodeInfoCompat, accessibilityNodeInfoCompatObtain);
                accessibilityNodeInfoCompatObtain.recycle();
                a(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.setClassName("androidx.drawerlayout.widget.DrawerLayout");
            accessibilityNodeInfoCompat.setFocusable(false);
            accessibilityNodeInfoCompat.setFocused(false);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.O || DrawerLayout.r(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class d extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (DrawerLayout.r(view)) {
                return;
            }
            accessibilityNodeInfoCompat.setParent(null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface e {
        void a(@NonNull View view);

        void b(@NonNull View view);

        void c(int i11);

        void d(@NonNull View view, float f11);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f8221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8222c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8223d;

        public f(int i11, int i12) {
            super(i11, i12);
            this.f8220a = 0;
        }

        public f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8220a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.N);
            this.f8220a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public f(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8220a = 0;
        }

        public f(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8220a = 0;
        }

        public f(@NonNull f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f8220a = 0;
            this.f8220a = fVar.f8220a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class g implements e {
        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void c(int i11) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void d(View view, float f11) {
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        O = true;
        P = true;
        Q = i11 >= 29;
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, null);
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.drawerLayoutStyle);
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f8187a = new d();
        this.f8190d = -1728053248;
        this.f8192g = new Paint();
        this.f8199n = true;
        this.f8200o = 3;
        this.f8201p = 3;
        this.f8202q = 3;
        this.f8203r = 3;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.L = new a();
        setDescendantFocusability(262144);
        float f11 = getResources().getDisplayMetrics().density;
        this.f8189c = (int) ((64.0f * f11) + 0.5f);
        float f12 = f11 * 400.0f;
        ViewDragCallback viewDragCallback = new ViewDragCallback(3);
        this.f8195j = viewDragCallback;
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(5);
        this.f8196k = viewDragCallback2;
        ViewDragHelper viewDragHelperO = ViewDragHelper.o(this, 1.0f, viewDragCallback);
        this.f8193h = viewDragHelperO;
        viewDragHelperO.O(1);
        viewDragHelperO.P(f12);
        viewDragCallback.q(viewDragHelperO);
        ViewDragHelper viewDragHelperO2 = ViewDragHelper.o(this, 1.0f, viewDragCallback2);
        this.f8194i = viewDragHelperO2;
        viewDragHelperO2.O(2);
        viewDragHelperO2.P(f12);
        viewDragCallback2.q(viewDragHelperO2);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new c());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            setOnApplyWindowInsetsListener(new b());
            setSystemUiVisibility(1280);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(M);
            try {
                this.f8209x = typedArrayObtainStyledAttributes.getDrawable(0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.DrawerLayout, i11, 0);
        try {
            if (typedArrayObtainStyledAttributes2.hasValue(R$styleable.DrawerLayout_elevation)) {
                this.f8188b = typedArrayObtainStyledAttributes2.getDimension(R$styleable.DrawerLayout_elevation, 0.0f);
            } else {
                this.f8188b = getResources().getDimension(R$dimen.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.I = new ArrayList<>();
        } catch (Throwable th3) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th3;
        }
    }

    public static String n(int i11) {
        if ((i11 & 3) == 3) {
            return "LEFT";
        }
        return (i11 & 5) == 5 ? "RIGHT" : Integer.toHexString(i11);
    }

    public static boolean o(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public static boolean r(View view) {
        return (ViewCompat.getImportantForAccessibility(view) == 4 || ViewCompat.getImportantForAccessibility(view) == 2) ? false : true;
    }

    public void A(View view, float f11) {
        f fVar = (f) view.getLayoutParams();
        if (f11 == fVar.f8221b) {
            return;
        }
        fVar.f8221b = f11;
        f(view, f11);
    }

    public final void B(View view) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS;
        ViewCompat.removeAccessibilityAction(view, accessibilityActionCompat.getId());
        if (!isDrawerOpen(view) || getDrawerLockMode(view) == 2) {
            return;
        }
        ViewCompat.replaceAccessibilityAction(view, accessibilityActionCompat, null, this.L);
    }

    public final void C(View view, boolean z11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((z11 || t(childAt)) && !(z11 && childAt == view)) {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            }
        }
    }

    public void D(int i11, View view) {
        int i12;
        int iB = this.f8193h.B();
        int iB2 = this.f8194i.B();
        if (iB == 1 || iB2 == 1) {
            i12 = 1;
        } else {
            i12 = 2;
            if (iB != 2 && iB2 != 2) {
                i12 = 0;
            }
        }
        if (view != null && i11 == 0) {
            float f11 = ((f) view.getLayoutParams()).f8221b;
            if (f11 == 0.0f) {
                d(view);
            } else if (f11 == 1.0f) {
                e(view);
            }
        }
        if (i12 != this.f8197l) {
            this.f8197l = i12;
            List<e> list = this.f8206u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f8206u.get(size).c(i12);
                }
            }
        }
    }

    public void a() {
        if (this.f8204s) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            getChildAt(i11).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.f8204s = true;
    }

    public void addDrawerListener(@NonNull e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.f8206u == null) {
            this.f8206u = new ArrayList();
        }
        this.f8206u.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i11, int i12) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (!t(childAt)) {
                this.I.add(childAt);
            } else if (isDrawerOpen(childAt)) {
                childAt.addFocusables(arrayList, i11, i12);
                z11 = true;
            }
        }
        if (!z11) {
            int size = this.I.size();
            for (int i14 = 0; i14 < size; i14++) {
                View view = this.I.get(i14);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i11, i12);
                }
            }
        }
        this.I.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i11, layoutParams);
        if (i() != null || t(view)) {
            ViewCompat.setImportantForAccessibility(view, 4);
        } else {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
        if (O) {
            return;
        }
        ViewCompat.setAccessibilityDelegate(view, this.f8187a);
    }

    public boolean b(View view, int i11) {
        return (k(view) & i11) == i11;
    }

    public void c(boolean z11) {
        int childCount = getChildCount();
        boolean zS = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            f fVar = (f) childAt.getLayoutParams();
            if (t(childAt) && (!z11 || fVar.f8222c)) {
                zS |= b(childAt, 3) ? this.f8193h.S(childAt, -childAt.getWidth(), childAt.getTop()) : this.f8194i.S(childAt, getWidth(), childAt.getTop());
                fVar.f8222c = false;
            }
        }
        this.f8195j.p();
        this.f8196k.p();
        if (zS) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public void close() {
        closeDrawer(GravityCompat.START);
    }

    public void closeDrawer(int i11) {
        closeDrawer(i11, true);
    }

    public void closeDrawer(int i11, boolean z11) {
        View viewH = h(i11);
        if (viewH != null) {
            closeDrawer(viewH, z11);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + n(i11));
    }

    public void closeDrawer(@NonNull View view) {
        closeDrawer(view, true);
    }

    public void closeDrawer(@NonNull View view, boolean z11) {
        if (!t(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f fVar = (f) view.getLayoutParams();
        if (this.f8199n) {
            fVar.f8221b = 0.0f;
            fVar.f8223d = 0;
        } else if (z11) {
            fVar.f8223d |= 4;
            if (b(view, 3)) {
                this.f8193h.S(view, -view.getWidth(), view.getTop());
            } else {
                this.f8194i.S(view, getWidth(), view.getTop());
            }
        } else {
            w(view, 0.0f);
            D(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void closeDrawers() {
        c(false);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i11 = 0; i11 < childCount; i11++) {
            fMax = Math.max(fMax, ((f) getChildAt(i11).getLayoutParams()).f8221b);
        }
        this.f8191f = fMax;
        boolean zN = this.f8193h.n(true);
        boolean zN2 = this.f8194i.n(true);
        if (zN || zN2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void d(View view) {
        View rootView;
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f8223d & 1) == 1) {
            fVar.f8223d = 0;
            List<e> list = this.f8206u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f8206u.get(size).b(view);
                }
            }
            C(view, false);
            B(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f8191f <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            View childAt = getChildAt(i11);
            if (u(x11, y11, childAt) && !s(childAt) && g(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j11) {
        int height = getHeight();
        boolean zS = s(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i11 = 0;
        if (zS) {
            int childCount = getChildCount();
            int i12 = 0;
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (childAt != view && childAt.getVisibility() == 0 && o(childAt) && t(childAt) && childAt.getHeight() >= height) {
                    if (b(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i12) {
                            i12 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i12, 0, width, getHeight());
            i11 = i12;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j11);
        canvas.restoreToCount(iSave);
        float f11 = this.f8191f;
        if (f11 > 0.0f && zS) {
            int i14 = this.f8190d;
            this.f8192g.setColor((i14 & 16777215) | (((int) ((((-16777216) & i14) >>> 24) * f11)) << 24));
            canvas.drawRect(i11, 0.0f, width, getHeight(), this.f8192g);
        } else if (this.f8210y != null && b(view, 3)) {
            int intrinsicWidth = this.f8210y.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.f8193h.y(), 1.0f));
            this.f8210y.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f8210y.setAlpha((int) (fMax * 255.0f));
            this.f8210y.draw(canvas);
        } else if (this.f8211z != null && b(view, 5)) {
            int intrinsicWidth2 = this.f8211z.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f8194i.y(), 1.0f));
            this.f8211z.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f8211z.setAlpha((int) (fMax2 * 255.0f));
            this.f8211z.draw(canvas);
        }
        return zDrawChild;
    }

    public void e(View view) {
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f8223d & 1) == 0) {
            fVar.f8223d = 1;
            List<e> list = this.f8206u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f8206u.get(size).a(view);
                }
            }
            C(view, true);
            B(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    public void f(View view, float f11) {
        List<e> list = this.f8206u;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f8206u.get(size).d(view, f11);
            }
        }
    }

    public final boolean g(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventM = m(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventM);
            motionEventM.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public float getDrawerElevation() {
        if (P) {
            return this.f8188b;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i11) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (i11 == 3) {
            int i12 = this.f8200o;
            if (i12 != 3) {
                return i12;
            }
            int i13 = layoutDirection == 0 ? this.f8202q : this.f8203r;
            if (i13 != 3) {
                return i13;
            }
            return 0;
        }
        if (i11 == 5) {
            int i14 = this.f8201p;
            if (i14 != 3) {
                return i14;
            }
            int i15 = layoutDirection == 0 ? this.f8203r : this.f8202q;
            if (i15 != 3) {
                return i15;
            }
            return 0;
        }
        if (i11 == 8388611) {
            int i16 = this.f8202q;
            if (i16 != 3) {
                return i16;
            }
            int i17 = layoutDirection == 0 ? this.f8200o : this.f8201p;
            if (i17 != 3) {
                return i17;
            }
            return 0;
        }
        if (i11 != 8388613) {
            return 0;
        }
        int i18 = this.f8203r;
        if (i18 != 3) {
            return i18;
        }
        int i19 = layoutDirection == 0 ? this.f8201p : this.f8200o;
        if (i19 != 3) {
            return i19;
        }
        return 0;
    }

    public int getDrawerLockMode(@NonNull View view) {
        if (t(view)) {
            return getDrawerLockMode(((f) view.getLayoutParams()).f8220a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Nullable
    public CharSequence getDrawerTitle(int i11) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.A;
        }
        if (absoluteGravity == 5) {
            return this.B;
        }
        return null;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.f8209x;
    }

    public View h(int i11) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this)) & 7;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if ((k(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    public View i() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((((f) childAt.getLayoutParams()).f8223d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public boolean isDrawerOpen(int i11) {
        View viewH = h(i11);
        if (viewH != null) {
            return isDrawerOpen(viewH);
        }
        return false;
    }

    public boolean isDrawerOpen(@NonNull View view) {
        if (t(view)) {
            return (((f) view.getLayoutParams()).f8223d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerVisible(int i11) {
        View viewH = h(i11);
        if (viewH != null) {
            return isDrawerVisible(viewH);
        }
        return false;
    }

    public boolean isDrawerVisible(@NonNull View view) {
        if (t(view)) {
            return ((f) view.getLayoutParams()).f8221b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isOpen() {
        return isDrawerOpen(GravityCompat.START);
    }

    public View j() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (t(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int k(View view) {
        return GravityCompat.getAbsoluteGravity(((f) view.getLayoutParams()).f8220a, ViewCompat.getLayoutDirection(this));
    }

    public float l(View view) {
        return ((f) view.getLayoutParams()).f8221b;
    }

    public final MotionEvent m(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.K == null) {
                this.K = new Matrix();
            }
            matrix.invert(this.K);
            motionEventObtain.transform(this.K);
        }
        return motionEventObtain;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8199n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8199n = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.D || this.f8209x == null) {
            return;
        }
        Object obj = this.C;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f8209x.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f8209x.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        View viewU;
        int actionMasked = motionEvent.getActionMasked();
        boolean zR = this.f8193h.R(motionEvent) | this.f8194i.R(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                c(true);
                this.f8204s = false;
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    c(true);
                    this.f8204s = false;
                }
            } else if (this.f8193h.e(3)) {
                this.f8195j.p();
                this.f8196k.p();
            }
            z11 = false;
        } else {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.f8207v = x11;
            this.f8208w = y11;
            z11 = this.f8191f > 0.0f && (viewU = this.f8193h.u((int) x11, (int) y11)) != null && s(viewU);
            this.f8204s = false;
        }
        return zR || z11 || p() || this.f8204s;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4 || !q()) {
            return super.onKeyDown(i11, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return super.onKeyUp(i11, keyEvent);
        }
        View viewJ = j();
        if (viewJ != null && getDrawerLockMode(viewJ) == 0) {
            closeDrawers();
        }
        return viewJ != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        WindowInsets rootWindowInsets;
        float f11;
        int i15;
        this.f8198m = true;
        int i16 = i13 - i11;
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (s(childAt)) {
                    int i18 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                    childAt.layout(i18, ((ViewGroup.MarginLayoutParams) fVar).topMargin, childAt.getMeasuredWidth() + i18, ((ViewGroup.MarginLayoutParams) fVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b(childAt, 3)) {
                        float f12 = measuredWidth;
                        i15 = (-measuredWidth) + ((int) (fVar.f8221b * f12));
                        f11 = (measuredWidth + i15) / f12;
                    } else {
                        float f13 = measuredWidth;
                        int i19 = i16 - ((int) (fVar.f8221b * f13));
                        f11 = (i16 - i19) / f13;
                        i15 = i19;
                    }
                    boolean z12 = f11 != fVar.f8221b;
                    int i21 = fVar.f8220a & 112;
                    if (i21 == 16) {
                        int i22 = i14 - i12;
                        int i23 = (i22 - measuredHeight) / 2;
                        int i24 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        if (i23 < i24) {
                            i23 = i24;
                        } else {
                            int i25 = i23 + measuredHeight;
                            int i26 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                            if (i25 > i22 - i26) {
                                i23 = (i22 - i26) - measuredHeight;
                            }
                        }
                        childAt.layout(i15, i23, measuredWidth + i15, measuredHeight + i23);
                    } else if (i21 != 80) {
                        int i27 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        childAt.layout(i15, i27, measuredWidth + i15, measuredHeight + i27);
                    } else {
                        int i28 = i14 - i12;
                        childAt.layout(i15, (i28 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i15, i28 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                    }
                    if (z12) {
                        A(childAt, f11);
                    }
                    int i29 = fVar.f8221b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i29) {
                        childAt.setVisibility(i29);
                    }
                }
            }
        }
        if (Q && (rootWindowInsets = getRootWindowInsets()) != null) {
            c3.c systemGestureInsets = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets).getSystemGestureInsets();
            ViewDragHelper viewDragHelper = this.f8193h;
            viewDragHelper.N(Math.max(viewDragHelper.x(), systemGestureInsets.f14554a));
            ViewDragHelper viewDragHelper2 = this.f8194i;
            viewDragHelper2.N(Math.max(viewDragHelper2.x(), systemGestureInsets.f14556c));
        }
        this.f8198m = false;
        this.f8199n = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = LogSeverity.NOTICE_VALUE;
            }
            if (mode2 == 0) {
                size2 = LogSeverity.NOTICE_VALUE;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z11 = this.C != null && ViewCompat.getFitsSystemWindows(this);
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int childCount = getChildCount();
        boolean z12 = false;
        boolean z13 = false;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (z11) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(fVar.f8220a, layoutDirection);
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.C;
                        if (absoluteGravity == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                    } else {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.C;
                        if (absoluteGravity == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) fVar).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (s(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, 1073741824));
                } else {
                    if (!t(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i13 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (P) {
                        float elevation = ViewCompat.getElevation(childAt);
                        float f11 = this.f8188b;
                        if (elevation != f11) {
                            ViewCompat.setElevation(childAt, f11);
                        }
                    }
                    int iK = k(childAt) & 7;
                    boolean z14 = iK == 3;
                    if ((z14 && z12) || (!z14 && z13)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + n(iK) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z14) {
                        z12 = true;
                    } else {
                        z13 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i11, this.f8189c + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((ViewGroup.MarginLayoutParams) fVar).width), ViewGroup.getChildMeasureSpec(i12, ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, ((ViewGroup.MarginLayoutParams) fVar).height));
                }
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View viewH;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i11 = savedState.openDrawerGravity;
        if (i11 != 0 && (viewH = h(i11)) != null) {
            openDrawer(viewH);
        }
        int i12 = savedState.lockModeLeft;
        if (i12 != 3) {
            setDrawerLockMode(i12, 3);
        }
        int i13 = savedState.lockModeRight;
        if (i13 != 3) {
            setDrawerLockMode(i13, 5);
        }
        int i14 = savedState.lockModeStart;
        if (i14 != 3) {
            setDrawerLockMode(i14, GravityCompat.START);
        }
        int i15 = savedState.lockModeEnd;
        if (i15 != 3) {
            setDrawerLockMode(i15, GravityCompat.END);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i11) {
        z();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            f fVar = (f) getChildAt(i11).getLayoutParams();
            int i12 = fVar.f8223d;
            boolean z11 = i12 == 1;
            boolean z12 = i12 == 2;
            if (z11 || z12) {
                savedState.openDrawerGravity = fVar.f8220a;
                break;
            }
        }
        savedState.lockModeLeft = this.f8200o;
        savedState.lockModeRight = this.f8201p;
        savedState.lockModeStart = this.f8202q;
        savedState.lockModeEnd = this.f8203r;
        return savedState;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        View viewI;
        this.f8193h.H(motionEvent);
        this.f8194i.H(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.f8207v = x11;
            this.f8208w = y11;
            this.f8204s = false;
        } else if (action == 1) {
            float x12 = motionEvent.getX();
            float y12 = motionEvent.getY();
            View viewU = this.f8193h.u((int) x12, (int) y12);
            if (viewU != null && s(viewU)) {
                float f11 = x12 - this.f8207v;
                float f12 = y12 - this.f8208w;
                int iA = this.f8193h.A();
                z11 = (f11 * f11) + (f12 * f12) >= ((float) (iA * iA)) || (viewI = i()) == null || getDrawerLockMode(viewI) == 2;
            }
            c(z11);
        } else if (action == 3) {
            c(true);
            this.f8204s = false;
        }
        return true;
    }

    public void open() {
        openDrawer(GravityCompat.START);
    }

    public void openDrawer(int i11) {
        openDrawer(i11, true);
    }

    public void openDrawer(int i11, boolean z11) {
        View viewH = h(i11);
        if (viewH != null) {
            openDrawer(viewH, z11);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + n(i11));
    }

    public void openDrawer(@NonNull View view) {
        openDrawer(view, true);
    }

    public void openDrawer(@NonNull View view, boolean z11) {
        if (!t(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f fVar = (f) view.getLayoutParams();
        if (this.f8199n) {
            fVar.f8221b = 1.0f;
            fVar.f8223d = 1;
            C(view, true);
            B(view);
        } else if (z11) {
            fVar.f8223d |= 2;
            if (b(view, 3)) {
                this.f8193h.S(view, 0, view.getTop());
            } else {
                this.f8194i.S(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            w(view, 1.0f);
            D(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public final boolean p() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (((f) getChildAt(i11).getLayoutParams()).f8222c) {
                return true;
            }
        }
        return false;
    }

    public final boolean q() {
        return j() != null;
    }

    public void removeDrawerListener(@NonNull e eVar) {
        List<e> list;
        if (eVar == null || (list = this.f8206u) == null) {
            return;
        }
        list.remove(eVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z11) {
        super.requestDisallowInterceptTouchEvent(z11);
        if (z11) {
            c(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f8198m) {
            return;
        }
        super.requestLayout();
    }

    public boolean s(View view) {
        return ((f) view.getLayoutParams()).f8220a == 0;
    }

    public void setChildInsets(Object obj, boolean z11) {
        this.C = obj;
        this.D = z11;
        setWillNotDraw(!z11 && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f11) {
        this.f8188b = f11;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (t(childAt)) {
                ViewCompat.setElevation(childAt, this.f8188b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.f8205t;
        if (eVar2 != null) {
            removeDrawerListener(eVar2);
        }
        if (eVar != null) {
            addDrawerListener(eVar);
        }
        this.f8205t = eVar;
    }

    public void setDrawerLockMode(int i11) {
        setDrawerLockMode(i11, 3);
        setDrawerLockMode(i11, 5);
    }

    public void setDrawerLockMode(int i11, int i12) {
        View viewH;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i12, ViewCompat.getLayoutDirection(this));
        if (i12 == 3) {
            this.f8200o = i11;
        } else if (i12 == 5) {
            this.f8201p = i11;
        } else if (i12 == 8388611) {
            this.f8202q = i11;
        } else if (i12 == 8388613) {
            this.f8203r = i11;
        }
        if (i11 != 0) {
            (absoluteGravity == 3 ? this.f8193h : this.f8194i).b();
        }
        if (i11 != 1) {
            if (i11 == 2 && (viewH = h(absoluteGravity)) != null) {
                openDrawer(viewH);
                return;
            }
            return;
        }
        View viewH2 = h(absoluteGravity);
        if (viewH2 != null) {
            closeDrawer(viewH2);
        }
    }

    public void setDrawerLockMode(int i11, @NonNull View view) {
        if (t(view)) {
            setDrawerLockMode(i11, ((f) view.getLayoutParams()).f8220a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public void setDrawerShadow(int i11, int i12) {
        setDrawerShadow(z2.a.getDrawable(getContext(), i11), i12);
    }

    public void setDrawerShadow(Drawable drawable, int i11) {
        if (P) {
            return;
        }
        if ((i11 & GravityCompat.START) == 8388611) {
            this.E = drawable;
        } else if ((i11 & GravityCompat.END) == 8388613) {
            this.F = drawable;
        } else if ((i11 & 3) == 3) {
            this.G = drawable;
        } else if ((i11 & 5) != 5) {
            return;
        } else {
            this.H = drawable;
        }
        z();
        invalidate();
    }

    public void setDrawerTitle(int i11, @Nullable CharSequence charSequence) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.A = charSequence;
        } else if (absoluteGravity == 5) {
            this.B = charSequence;
        }
    }

    public void setScrimColor(int i11) {
        this.f8190d = i11;
        invalidate();
    }

    public void setStatusBarBackground(int i11) {
        this.f8209x = i11 != 0 ? z2.a.getDrawable(getContext(), i11) : null;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.f8209x = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i11) {
        this.f8209x = new ColorDrawable(i11);
        invalidate();
    }

    public boolean t(View view) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(((f) view.getLayoutParams()).f8220a, ViewCompat.getLayoutDirection(view));
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    public final boolean u(float f11, float f12, View view) {
        if (this.J == null) {
            this.J = new Rect();
        }
        view.getHitRect(this.J);
        return this.J.contains((int) f11, (int) f12);
    }

    public final void v(Drawable drawable, int i11) {
        if (drawable == null || !d3.a.h(drawable)) {
            return;
        }
        d3.a.m(drawable, i11);
    }

    public void w(View view, float f11) {
        float fL = l(view);
        float width = view.getWidth();
        int i11 = ((int) (width * f11)) - ((int) (fL * width));
        if (!b(view, 3)) {
            i11 = -i11;
        }
        view.offsetLeftAndRight(i11);
        A(view, f11);
    }

    public final Drawable x() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                v(drawable, layoutDirection);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.F;
            if (drawable2 != null) {
                v(drawable2, layoutDirection);
                return this.F;
            }
        }
        return this.G;
    }

    public final Drawable y() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.F;
            if (drawable != null) {
                v(drawable, layoutDirection);
                return this.F;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                v(drawable2, layoutDirection);
                return this.E;
            }
        }
        return this.H;
    }

    public final void z() {
        if (P) {
            return;
        }
        this.f8210y = x();
        this.f8211z = y();
    }
}
