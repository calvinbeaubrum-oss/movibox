package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements MenuHost {
    public ColorStateList A;
    public ColorStateList B;
    public boolean C;
    public boolean D;
    public final ArrayList<View> E;
    public final ArrayList<View> F;
    public final int[] G;
    public final MenuHostHelper H;
    public ArrayList<MenuItem> I;
    public g J;
    public final ActionMenuView.e K;
    public r0 L;
    public ActionMenuPresenter M;
    public e N;
    public androidx.appcompat.view.menu.l.a O;
    public androidx.appcompat.view.menu.f.a P;
    public boolean Q;
    public OnBackInvokedCallback R;
    public OnBackInvokedDispatcher S;
    public boolean T;
    public final Runnable U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMenuView f1578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f1579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f1580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageButton f1581d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f1582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f1583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f1584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageButton f1585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f1586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f1587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1588l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1589m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1590n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1591o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1592p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1593q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1594r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1595s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1596t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public g0 f1597u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1598v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1599w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1600x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f1601y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f1602z;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int expandedMenuItemId;
        boolean isOverflowOpen;

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

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements ActionMenuView.e {
        public a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.H.onMenuItemSelected(menuItem)) {
                return true;
            }
            g gVar = Toolbar.this.J;
            if (gVar != null) {
                return gVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b implements androidx.appcompat.view.menu.f.a {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(@NonNull androidx.appcompat.view.menu.f fVar, @NonNull MenuItem menuItem) {
            androidx.appcompat.view.menu.f.a aVar = Toolbar.this.P;
            return aVar != null && aVar.a(fVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(@NonNull androidx.appcompat.view.menu.f fVar) {
            if (!Toolbar.this.f1578a.isOverflowMenuShowing()) {
                Toolbar.this.H.onPrepareMenu(fVar);
            }
            androidx.appcompat.view.menu.f.a aVar = Toolbar.this.P;
            if (aVar != null) {
                aVar.b(fVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.collapseActionView();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(33)
    public static class d {
        @Nullable
        public static OnBackInvokedDispatcher a(@NonNull View view) {
            return view.findOnBackInvokedDispatcher();
        }

        @NonNull
        public static OnBackInvokedCallback b(@NonNull final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: androidx.appcompat.widget.q0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        public static void c(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        public static void d(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class e implements androidx.appcompat.view.menu.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.appcompat.view.menu.f f1606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.h f1607b;

        public e() {
        }

        @Override // androidx.appcompat.view.menu.l
        public void b(androidx.appcompat.view.menu.f fVar, boolean z11) {
        }

        @Override // androidx.appcompat.view.menu.l
        public boolean c(androidx.appcompat.view.menu.f fVar, androidx.appcompat.view.menu.h hVar) {
            Toolbar.this.d();
            ViewParent parent = Toolbar.this.f1585i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1585i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1585i);
            }
            Toolbar.this.f1586j = hVar.getActionView();
            this.f1607b = hVar;
            ViewParent parent2 = Toolbar.this.f1586j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1586j);
                }
                f fVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                fVarGenerateDefaultLayoutParams.f826a = (toolbar4.f1591o & 112) | GravityCompat.START;
                fVarGenerateDefaultLayoutParams.f1609b = 2;
                toolbar4.f1586j.setLayoutParams(fVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1586j);
            }
            Toolbar.this.y();
            Toolbar.this.requestLayout();
            hVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f1586j;
            if (callback instanceof g1.c) {
                ((g1.c) callback).onActionViewExpanded();
            }
            Toolbar.this.B();
            return true;
        }

        @Override // androidx.appcompat.view.menu.l
        public void e(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.l
        public boolean f(androidx.appcompat.view.menu.q qVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.l
        public Parcelable g() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.l
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.l
        public void h(boolean z11) {
            if (this.f1607b != null) {
                androidx.appcompat.view.menu.f fVar = this.f1606a;
                if (fVar != null) {
                    int size = fVar.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        if (this.f1606a.getItem(i11) == this.f1607b) {
                            return;
                        }
                    }
                }
                j(this.f1606a, this.f1607b);
            }
        }

        @Override // androidx.appcompat.view.menu.l
        public boolean i() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.l
        public boolean j(androidx.appcompat.view.menu.f fVar, androidx.appcompat.view.menu.h hVar) {
            KeyEvent.Callback callback = Toolbar.this.f1586j;
            if (callback instanceof g1.c) {
                ((g1.c) callback).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1586j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1585i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1586j = null;
            toolbar3.a();
            this.f1607b = null;
            Toolbar.this.requestLayout();
            hVar.r(false);
            Toolbar.this.B();
            return true;
        }

        @Override // androidx.appcompat.view.menu.l
        public void k(Context context, androidx.appcompat.view.menu.f fVar) {
            androidx.appcompat.view.menu.h hVar;
            androidx.appcompat.view.menu.f fVar2 = this.f1606a;
            if (fVar2 != null && (hVar = this.f1607b) != null) {
                fVar2.f(hVar);
            }
            this.f1606a = fVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class f extends androidx.appcompat.app.a.C0029a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1609b;

        public f(int i11, int i12) {
            super(i11, i12);
            this.f1609b = 0;
            this.f826a = 8388627;
        }

        public f(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1609b = 0;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1609b = 0;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1609b = 0;
            a(marginLayoutParams);
        }

        public f(androidx.appcompat.app.a.C0029a c0029a) {
            super(c0029a);
            this.f1609b = 0;
        }

        public f(f fVar) {
            super((androidx.appcompat.app.a.C0029a) fVar);
            this.f1609b = 0;
            this.f1609b = fVar.f1609b;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface g {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(@NonNull Context context) {
        this(context, null);
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f1600x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.H = new MenuHostHelper(new Runnable() { // from class: androidx.appcompat.widget.o0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1731a.invalidateMenu();
            }
        });
        this.I = new ArrayList<>();
        this.K = new a();
        this.U = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        n0 n0VarV = n0.v(getContext(), attributeSet, R$styleable.Toolbar, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.Toolbar, attributeSet, n0VarV.r(), i11, 0);
        this.f1589m = n0VarV.n(R$styleable.Toolbar_titleTextAppearance, 0);
        this.f1590n = n0VarV.n(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.f1600x = n0VarV.l(R$styleable.Toolbar_android_gravity, this.f1600x);
        this.f1591o = n0VarV.l(R$styleable.Toolbar_buttonGravity, 48);
        int iE = n0VarV.e(R$styleable.Toolbar_titleMargin, 0);
        iE = n0VarV.s(R$styleable.Toolbar_titleMargins) ? n0VarV.e(R$styleable.Toolbar_titleMargins, iE) : iE;
        this.f1596t = iE;
        this.f1595s = iE;
        this.f1594r = iE;
        this.f1593q = iE;
        int iE2 = n0VarV.e(R$styleable.Toolbar_titleMarginStart, -1);
        if (iE2 >= 0) {
            this.f1593q = iE2;
        }
        int iE3 = n0VarV.e(R$styleable.Toolbar_titleMarginEnd, -1);
        if (iE3 >= 0) {
            this.f1594r = iE3;
        }
        int iE4 = n0VarV.e(R$styleable.Toolbar_titleMarginTop, -1);
        if (iE4 >= 0) {
            this.f1595s = iE4;
        }
        int iE5 = n0VarV.e(R$styleable.Toolbar_titleMarginBottom, -1);
        if (iE5 >= 0) {
            this.f1596t = iE5;
        }
        this.f1592p = n0VarV.f(R$styleable.Toolbar_maxButtonHeight, -1);
        int iE6 = n0VarV.e(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iE7 = n0VarV.e(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iF = n0VarV.f(R$styleable.Toolbar_contentInsetLeft, 0);
        int iF2 = n0VarV.f(R$styleable.Toolbar_contentInsetRight, 0);
        e();
        this.f1597u.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.f1597u.g(iE6, iE7);
        }
        this.f1598v = n0VarV.e(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f1599w = n0VarV.e(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1583g = n0VarV.g(R$styleable.Toolbar_collapseIcon);
        this.f1584h = n0VarV.p(R$styleable.Toolbar_collapseContentDescription);
        CharSequence charSequenceP = n0VarV.p(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = n0VarV.p(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.f1587k = getContext();
        setPopupTheme(n0VarV.n(R$styleable.Toolbar_popupTheme, 0));
        Drawable drawableG = n0VarV.g(R$styleable.Toolbar_navigationIcon);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = n0VarV.p(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = n0VarV.g(R$styleable.Toolbar_logo);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = n0VarV.p(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        if (n0VarV.s(R$styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(n0VarV.c(R$styleable.Toolbar_titleTextColor));
        }
        if (n0VarV.s(R$styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(n0VarV.c(R$styleable.Toolbar_subtitleTextColor));
        }
        if (n0VarV.s(R$styleable.Toolbar_menu)) {
            inflateMenu(n0VarV.n(R$styleable.Toolbar_menu, 0));
        }
        n0VarV.x();
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i11 = 0; i11 < menu.size(); i11++) {
            arrayList.add(menu.getItem(i11));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new g1.g(getContext());
    }

    public final boolean A(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void B() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = d.a(this);
            boolean z11 = hasExpandedActionView() && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.T;
            if (z11 && this.S == null) {
                if (this.R == null) {
                    this.R = d.b(new Runnable() { // from class: androidx.appcompat.widget.p0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1732a.collapseActionView();
                        }
                    });
                }
                d.c(onBackInvokedDispatcherA, this.R);
                this.S = onBackInvokedDispatcherA;
                return;
            }
            if (z11 || (onBackInvokedDispatcher = this.S) == null) {
                return;
            }
            d.d(onBackInvokedDispatcher, this.R);
            this.S = null;
        }
    }

    public void a() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.H.addMenuProvider(menuProvider);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull androidx.lifecycle.u uVar) {
        this.H.addMenuProvider(menuProvider, uVar);
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull androidx.lifecycle.u uVar, @NonNull Lifecycle.State state) {
        this.H.addMenuProvider(menuProvider, uVar, state);
    }

    public final void b(List<View> list, int i11) {
        boolean z11 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, getLayoutDirection());
        list.clear();
        if (!z11) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.f1609b == 0 && A(childAt) && l(fVar.f826a) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i13 = childCount - 1; i13 >= 0; i13--) {
            View childAt2 = getChildAt(i13);
            f fVar2 = (f) childAt2.getLayoutParams();
            if (fVar2.f1609b == 0 && A(childAt2) && l(fVar2.f826a) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    public final void c(View view, boolean z11) {
        f fVarGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            fVarGenerateLayoutParams = generateDefaultLayoutParams();
        } else {
            fVarGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (f) layoutParams;
        }
        fVarGenerateLayoutParams.f1609b = 1;
        if (!z11 || this.f1586j == null) {
            addView(view, fVarGenerateLayoutParams);
        } else {
            view.setLayoutParams(fVarGenerateLayoutParams);
            this.F.add(view);
        }
    }

    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f1578a) != null && actionMenuView.isOverflowReserved();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof f);
    }

    public void collapseActionView() {
        e eVar = this.N;
        androidx.appcompat.view.menu.h hVar = eVar == null ? null : eVar.f1607b;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    public void d() {
        if (this.f1585i == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.f1585i = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f1583g);
            this.f1585i.setContentDescription(this.f1584h);
            f fVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            fVarGenerateDefaultLayoutParams.f826a = (this.f1591o & 112) | GravityCompat.START;
            fVarGenerateDefaultLayoutParams.f1609b = 2;
            this.f1585i.setLayoutParams(fVarGenerateDefaultLayoutParams);
            this.f1585i.setOnClickListener(new c());
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.f1578a;
        if (actionMenuView != null) {
            actionMenuView.dismissPopupMenus();
        }
    }

    public final void e() {
        if (this.f1597u == null) {
            this.f1597u = new g0();
        }
    }

    public final void f() {
        if (this.f1582f == null) {
            this.f1582f = new AppCompatImageView(getContext());
        }
    }

    public final void g() {
        h();
        if (this.f1578a.peekMenu() == null) {
            androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) this.f1578a.getMenu();
            if (this.N == null) {
                this.N = new e();
            }
            this.f1578a.setExpandedActionViewsExclusive(true);
            fVar.c(this.N, this.f1587k);
            B();
        }
    }

    @Override // android.view.ViewGroup
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1585i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1585i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        g0 g0Var = this.f1597u;
        if (g0Var != null) {
            return g0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i11 = this.f1599w;
        return i11 != Integer.MIN_VALUE ? i11 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        g0 g0Var = this.f1597u;
        if (g0Var != null) {
            return g0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        g0 g0Var = this.f1597u;
        if (g0Var != null) {
            return g0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        g0 g0Var = this.f1597u;
        if (g0Var != null) {
            return g0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i11 = this.f1598v;
        return i11 != Integer.MIN_VALUE ? i11 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.f fVarPeekMenu;
        ActionMenuView actionMenuView = this.f1578a;
        return (actionMenuView == null || (fVarPeekMenu = actionMenuView.peekMenu()) == null || !fVarPeekMenu.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f1599w, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f1598v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1582f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1582f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        g();
        return this.f1578a.getMenu();
    }

    @Nullable
    public View getNavButtonView() {
        return this.f1581d;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1581d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1581d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.M;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        g();
        return this.f1578a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f1587k;
    }

    public int getPopupTheme() {
        return this.f1588l;
    }

    public CharSequence getSubtitle() {
        return this.f1602z;
    }

    @Nullable
    public final TextView getSubtitleTextView() {
        return this.f1580c;
    }

    public CharSequence getTitle() {
        return this.f1601y;
    }

    public int getTitleMarginBottom() {
        return this.f1596t;
    }

    public int getTitleMarginEnd() {
        return this.f1594r;
    }

    public int getTitleMarginStart() {
        return this.f1593q;
    }

    public int getTitleMarginTop() {
        return this.f1595s;
    }

    @Nullable
    public final TextView getTitleTextView() {
        return this.f1579b;
    }

    public w getWrapper() {
        if (this.L == null) {
            this.L = new r0(this, true);
        }
        return this.L;
    }

    public final void h() {
        if (this.f1578a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1578a = actionMenuView;
            actionMenuView.setPopupTheme(this.f1588l);
            this.f1578a.setOnMenuItemClickListener(this.K);
            this.f1578a.setMenuCallbacks(this.O, new b());
            f fVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            fVarGenerateDefaultLayoutParams.f826a = (this.f1591o & 112) | GravityCompat.END;
            this.f1578a.setLayoutParams(fVarGenerateDefaultLayoutParams);
            c(this.f1578a, false);
        }
    }

    public boolean hasExpandedActionView() {
        e eVar = this.N;
        return (eVar == null || eVar.f1607b == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.f1578a;
        return actionMenuView != null && actionMenuView.hideOverflowMenu();
    }

    public final void i() {
        if (this.f1581d == null) {
            this.f1581d = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            f fVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            fVarGenerateDefaultLayoutParams.f826a = (this.f1591o & 112) | GravityCompat.START;
            this.f1581d.setLayoutParams(fVarGenerateDefaultLayoutParams);
        }
    }

    public void inflateMenu(int i11) {
        getMenuInflater().inflate(i11, getMenu());
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        Iterator<MenuItem> it = this.I.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(it.next().getItemId());
        }
        w();
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.T;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.f1578a;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.f1578a;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.f1579b;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i11 = 0; i11 < lineCount; i11++) {
            if (layout.getEllipsisCount(i11) > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof androidx.appcompat.app.a.C0029a) {
            return new f((androidx.appcompat.app.a.C0029a) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public final int l(int i11) {
        int layoutDirection = getLayoutDirection();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, layoutDirection) & 7;
        if (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) {
            return absoluteGravity;
        }
        return layoutDirection == 1 ? 5 : 3;
    }

    public final int m(View view, int i11) {
        f fVar = (f) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i12 = i11 > 0 ? (measuredHeight - i11) / 2 : 0;
        int iN = n(fVar.f826a);
        if (iN == 48) {
            return getPaddingTop() - i12;
        }
        if (iN == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - i12;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i13 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
        if (iMax < i13) {
            iMax = i13;
        } else {
            int i14 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i15 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
            if (i14 < i15) {
                iMax = Math.max(0, iMax - (i15 - i14));
            }
        }
        return paddingTop + iMax;
    }

    public final int n(int i11) {
        int i12 = i11 & 112;
        return (i12 == 16 || i12 == 48 || i12 == 80) ? i12 : this.f1600x & 112;
    }

    public final int o(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        B();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.U);
        B();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0268  */
    /* JADX WARN: Code duplicated, block: B:102:0x028a  */
    /* JADX WARN: Code duplicated, block: B:104:0x028d  */
    /* JADX WARN: Code duplicated, block: B:107:0x02a1 A[LOOP:0: B:106:0x029f->B:107:0x02a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:110:0x02c3 A[LOOP:1: B:109:0x02c1->B:110:0x02c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:114:0x02ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:116:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:119:0x02fc A[LOOP:2: B:118:0x02fa->B:119:0x02fc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0062  */
    /* JADX WARN: Code duplicated, block: B:21:0x0069  */
    /* JADX WARN: Code duplicated, block: B:24:0x0077 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:26:0x0080  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:42:0x0104  */
    /* JADX WARN: Code duplicated, block: B:43:0x011c  */
    /* JADX WARN: Code duplicated, block: B:49:0x012a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x012c  */
    /* JADX WARN: Code duplicated, block: B:51:0x012f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0133  */
    /* JADX WARN: Code duplicated, block: B:54:0x0136  */
    /* JADX WARN: Code duplicated, block: B:57:0x0146  */
    /* JADX WARN: Code duplicated, block: B:59:0x014e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x0167  */
    /* JADX WARN: Code duplicated, block: B:68:0x016b  */
    /* JADX WARN: Code duplicated, block: B:70:0x017d  */
    /* JADX WARN: Code duplicated, block: B:71:0x0180  */
    /* JADX WARN: Code duplicated, block: B:73:0x018b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0197  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:81:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:88:0x021b  */
    /* JADX WARN: Code duplicated, block: B:90:0x021e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0227 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0229  */
    /* JADX WARN: Code duplicated, block: B:95:0x022e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0242  */
    /* JADX WARN: Code duplicated, block: B:99:0x0265  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int iS;
        int iT;
        int iMax;
        int iMin;
        boolean zA;
        boolean zA2;
        int measuredHeight;
        TextView textView;
        TextView textView2;
        f fVar;
        f fVar2;
        boolean z12;
        int i15;
        int i16;
        int paddingTop;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        int iMax2;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int size;
        int iS2;
        int i31;
        int i32;
        int size2;
        int i33;
        int i34;
        int i35;
        int size3;
        boolean z13 = getLayoutDirection() == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i36 = width - paddingRight;
        int[] iArr = this.G;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        int iMin2 = minimumHeight >= 0 ? Math.min(minimumHeight, i14 - i12) : 0;
        if (A(this.f1581d)) {
            if (z13) {
                iT = t(this.f1581d, i36, iArr, iMin2);
                iS = paddingLeft;
            } else {
                iS = s(this.f1581d, paddingLeft, iArr, iMin2);
            }
            if (A(this.f1585i)) {
                if (z13) {
                    iT = t(this.f1585i, iT, iArr, iMin2);
                } else {
                    iS = s(this.f1585i, iS, iArr, iMin2);
                }
            }
            if (A(this.f1578a)) {
                if (z13) {
                    iS = s(this.f1578a, iS, iArr, iMin2);
                } else {
                    iT = t(this.f1578a, iT, iArr, iMin2);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - iS);
            iArr[1] = Math.max(0, currentContentInsetRight - (i36 - iT));
            iMax = Math.max(iS, currentContentInsetLeft);
            iMin = Math.min(iT, i36 - currentContentInsetRight);
            if (A(this.f1586j)) {
                if (z13) {
                    iMin = t(this.f1586j, iMin, iArr, iMin2);
                } else {
                    iMax = s(this.f1586j, iMax, iArr, iMin2);
                }
            }
            if (A(this.f1582f)) {
                if (z13) {
                    iMin = t(this.f1582f, iMin, iArr, iMin2);
                } else {
                    iMax = s(this.f1582f, iMax, iArr, iMin2);
                }
            }
            zA = A(this.f1579b);
            zA2 = A(this.f1580c);
            if (zA) {
                f fVar3 = (f) this.f1579b.getLayoutParams();
                measuredHeight = ((ViewGroup.MarginLayoutParams) fVar3).topMargin + this.f1579b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin;
            } else {
                measuredHeight = 0;
            }
            if (zA2) {
                f fVar4 = (f) this.f1580c.getLayoutParams();
                measuredHeight += ((ViewGroup.MarginLayoutParams) fVar4).topMargin + this.f1580c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin;
            }
            if (!zA || zA2) {
                if (zA) {
                    textView = this.f1579b;
                } else {
                    textView = this.f1580c;
                }
                if (zA2) {
                    textView2 = this.f1580c;
                } else {
                    textView2 = this.f1579b;
                }
                fVar = (f) textView.getLayoutParams();
                fVar2 = (f) textView2.getLayoutParams();
                z12 = (!zA && this.f1579b.getMeasuredWidth() > 0) || (zA2 && this.f1580c.getMeasuredWidth() > 0);
                i15 = this.f1600x & 112;
                i16 = paddingLeft;
                if (i15 == 48) {
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin + this.f1595s;
                } else if (i15 != 80) {
                    iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    i25 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                    i26 = this.f1595s;
                    if (iMax2 < i25 + i26) {
                        iMax2 = i25 + i26;
                    } else {
                        i27 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                        i28 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                        i29 = this.f1596t;
                        if (i27 < i28 + i29) {
                            iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) fVar2).bottomMargin + i29) - i27));
                        }
                    }
                    paddingTop = paddingTop2 + iMax2;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) fVar2).bottomMargin) - this.f1596t) - measuredHeight;
                }
                if (z13) {
                    if (z12) {
                        i22 = this.f1593q;
                    } else {
                        i22 = 0;
                    }
                    int i37 = i22 - iArr[1];
                    iMin -= Math.max(0, i37);
                    iArr[1] = Math.max(0, -i37);
                    if (zA) {
                        f fVar5 = (f) this.f1579b.getLayoutParams();
                        int measuredWidth = iMin - this.f1579b.getMeasuredWidth();
                        int measuredHeight2 = this.f1579b.getMeasuredHeight() + paddingTop;
                        this.f1579b.layout(measuredWidth, paddingTop, iMin, measuredHeight2);
                        i23 = measuredWidth - this.f1594r;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) fVar5).bottomMargin;
                    } else {
                        i23 = iMin;
                    }
                    if (zA2) {
                        int i38 = paddingTop + ((ViewGroup.MarginLayoutParams) ((f) this.f1580c.getLayoutParams())).topMargin;
                        this.f1580c.layout(iMin - this.f1580c.getMeasuredWidth(), i38, iMin, this.f1580c.getMeasuredHeight() + i38);
                        i24 = iMin - this.f1594r;
                    } else {
                        i24 = iMin;
                    }
                    if (z12) {
                        iMin = Math.min(i23, i24);
                    }
                    iMax = iMax;
                } else {
                    if (z12) {
                        i17 = this.f1593q;
                    } else {
                        i17 = 0;
                    }
                    i18 = 0;
                    int i39 = i17 - iArr[0];
                    iMax += Math.max(0, i39);
                    iArr[0] = Math.max(0, -i39);
                    if (zA) {
                        f fVar6 = (f) this.f1579b.getLayoutParams();
                        int measuredWidth2 = this.f1579b.getMeasuredWidth() + iMax;
                        int measuredHeight3 = this.f1579b.getMeasuredHeight() + paddingTop;
                        this.f1579b.layout(iMax, paddingTop, measuredWidth2, measuredHeight3);
                        i19 = measuredWidth2 + this.f1594r;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) fVar6).bottomMargin;
                    } else {
                        i19 = iMax;
                    }
                    if (zA2) {
                        int i40 = paddingTop + ((ViewGroup.MarginLayoutParams) ((f) this.f1580c.getLayoutParams())).topMargin;
                        int measuredWidth3 = this.f1580c.getMeasuredWidth() + iMax;
                        this.f1580c.layout(iMax, i40, measuredWidth3, this.f1580c.getMeasuredHeight() + i40);
                        i21 = measuredWidth3 + this.f1594r;
                    } else {
                        i21 = iMax;
                    }
                    if (z12) {
                        iMax = Math.max(i19, i21);
                    }
                }
                b(this.E, 3);
                size = this.E.size();
                iS2 = iMax;
                for (i31 = 0; i31 < size; i31++) {
                    iS2 = s(this.E.get(i31), iS2, iArr, iMin2);
                }
                i32 = iMin2;
                b(this.E, 5);
                size2 = this.E.size();
                for (i33 = 0; i33 < size2; i33++) {
                    iMin = t(this.E.get(i33), iMin, iArr, i32);
                }
                b(this.E, 1);
                int iQ = q(this.E, iArr);
                i34 = (i16 + (((width - i16) - paddingRight) / 2)) - (iQ / 2);
                i35 = iQ + i34;
                if (i34 >= iS2) {
                    if (i35 > iMin) {
                        iS2 = i34 - (i35 - iMin);
                    } else {
                        iS2 = i34;
                    }
                }
                size3 = this.E.size();
                while (i18 < size3) {
                    iS2 = s(this.E.get(i18), iS2, iArr, i32);
                    i18++;
                }
                this.E.clear();
            }
            i16 = paddingLeft;
            iMin2 = iMin2;
            i18 = 0;
            b(this.E, 3);
            size = this.E.size();
            iS2 = iMax;
            while (i31 < size) {
                iS2 = s(this.E.get(i31), iS2, iArr, iMin2);
            }
            i32 = iMin2;
            b(this.E, 5);
            size2 = this.E.size();
            while (i33 < size2) {
                iMin = t(this.E.get(i33), iMin, iArr, i32);
            }
            b(this.E, 1);
            int iQ2 = q(this.E, iArr);
            i34 = (i16 + (((width - i16) - paddingRight) / 2)) - (iQ2 / 2);
            i35 = iQ2 + i34;
            if (i34 >= iS2) {
                if (i35 > iMin) {
                    iS2 = i34 - (i35 - iMin);
                } else {
                    iS2 = i34;
                }
            }
            size3 = this.E.size();
            while (i18 < size3) {
                iS2 = s(this.E.get(i18), iS2, iArr, i32);
                i18++;
            }
            this.E.clear();
        }
        iS = paddingLeft;
        iT = i36;
        if (A(this.f1585i)) {
            if (z13) {
                iT = t(this.f1585i, iT, iArr, iMin2);
            } else {
                iS = s(this.f1585i, iS, iArr, iMin2);
            }
        }
        if (A(this.f1578a)) {
            if (z13) {
                iS = s(this.f1578a, iS, iArr, iMin2);
            } else {
                iT = t(this.f1578a, iT, iArr, iMin2);
            }
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iS);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i36 - iT));
        iMax = Math.max(iS, currentContentInsetLeft2);
        iMin = Math.min(iT, i36 - currentContentInsetRight2);
        if (A(this.f1586j)) {
            if (z13) {
                iMin = t(this.f1586j, iMin, iArr, iMin2);
            } else {
                iMax = s(this.f1586j, iMax, iArr, iMin2);
            }
        }
        if (A(this.f1582f)) {
            if (z13) {
                iMin = t(this.f1582f, iMin, iArr, iMin2);
            } else {
                iMax = s(this.f1582f, iMax, iArr, iMin2);
            }
        }
        zA = A(this.f1579b);
        zA2 = A(this.f1580c);
        if (zA) {
            f fVar7 = (f) this.f1579b.getLayoutParams();
            measuredHeight = ((ViewGroup.MarginLayoutParams) fVar7).topMargin + this.f1579b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar7).bottomMargin;
        } else {
            measuredHeight = 0;
        }
        if (zA2) {
            f fVar8 = (f) this.f1580c.getLayoutParams();
            measuredHeight += ((ViewGroup.MarginLayoutParams) fVar8).topMargin + this.f1580c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar8).bottomMargin;
        }
        if (zA) {
            if (zA) {
                textView = this.f1579b;
            } else {
                textView = this.f1580c;
            }
            if (zA2) {
                textView2 = this.f1580c;
            } else {
                textView2 = this.f1579b;
            }
            fVar = (f) textView.getLayoutParams();
            fVar2 = (f) textView2.getLayoutParams();
            if (zA) {
            }
            i15 = this.f1600x & 112;
            i16 = paddingLeft;
            if (i15 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin + this.f1595s;
            } else if (i15 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i25 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                i26 = this.f1595s;
                if (iMax2 < i25 + i26) {
                    iMax2 = i25 + i26;
                } else {
                    i27 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i28 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                    i29 = this.f1596t;
                    if (i27 < i28 + i29) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) fVar2).bottomMargin + i29) - i27));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) fVar2).bottomMargin) - this.f1596t) - measuredHeight;
            }
            if (z13) {
                if (z12) {
                    i22 = this.f1593q;
                } else {
                    i22 = 0;
                }
                int i310 = i22 - iArr[1];
                iMin -= Math.max(0, i310);
                iArr[1] = Math.max(0, -i310);
                if (zA) {
                    f fVar9 = (f) this.f1579b.getLayoutParams();
                    int measuredWidth4 = iMin - this.f1579b.getMeasuredWidth();
                    int measuredHeight4 = this.f1579b.getMeasuredHeight() + paddingTop;
                    this.f1579b.layout(measuredWidth4, paddingTop, iMin, measuredHeight4);
                    i23 = measuredWidth4 - this.f1594r;
                    paddingTop = measuredHeight4 + ((ViewGroup.MarginLayoutParams) fVar9).bottomMargin;
                } else {
                    i23 = iMin;
                }
                if (zA2) {
                    int i311 = paddingTop + ((ViewGroup.MarginLayoutParams) ((f) this.f1580c.getLayoutParams())).topMargin;
                    this.f1580c.layout(iMin - this.f1580c.getMeasuredWidth(), i311, iMin, this.f1580c.getMeasuredHeight() + i311);
                    i24 = iMin - this.f1594r;
                } else {
                    i24 = iMin;
                }
                if (z12) {
                    iMin = Math.min(i23, i24);
                }
                iMax = iMax;
                i18 = 0;
            } else {
                if (z12) {
                    i17 = this.f1593q;
                } else {
                    i17 = 0;
                }
                i18 = 0;
                int i312 = i17 - iArr[0];
                iMax += Math.max(0, i312);
                iArr[0] = Math.max(0, -i312);
                if (zA) {
                    f fVar10 = (f) this.f1579b.getLayoutParams();
                    int measuredWidth5 = this.f1579b.getMeasuredWidth() + iMax;
                    int measuredHeight5 = this.f1579b.getMeasuredHeight() + paddingTop;
                    this.f1579b.layout(iMax, paddingTop, measuredWidth5, measuredHeight5);
                    i19 = measuredWidth5 + this.f1594r;
                    paddingTop = measuredHeight5 + ((ViewGroup.MarginLayoutParams) fVar10).bottomMargin;
                } else {
                    i19 = iMax;
                }
                if (zA2) {
                    int i41 = paddingTop + ((ViewGroup.MarginLayoutParams) ((f) this.f1580c.getLayoutParams())).topMargin;
                    int measuredWidth6 = this.f1580c.getMeasuredWidth() + iMax;
                    this.f1580c.layout(iMax, i41, measuredWidth6, this.f1580c.getMeasuredHeight() + i41);
                    i21 = measuredWidth6 + this.f1594r;
                } else {
                    i21 = iMax;
                }
                if (z12) {
                    iMax = Math.max(i19, i21);
                }
            }
        } else {
            if (zA) {
                textView = this.f1579b;
            } else {
                textView = this.f1580c;
            }
            if (zA2) {
                textView2 = this.f1580c;
            } else {
                textView2 = this.f1579b;
            }
            fVar = (f) textView.getLayoutParams();
            fVar2 = (f) textView2.getLayoutParams();
            if (zA) {
            }
            i15 = this.f1600x & 112;
            i16 = paddingLeft;
            if (i15 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin + this.f1595s;
            } else if (i15 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i25 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                i26 = this.f1595s;
                if (iMax2 < i25 + i26) {
                    iMax2 = i25 + i26;
                } else {
                    i27 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i28 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                    i29 = this.f1596t;
                    if (i27 < i28 + i29) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) fVar2).bottomMargin + i29) - i27));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) fVar2).bottomMargin) - this.f1596t) - measuredHeight;
            }
            if (z13) {
                if (z12) {
                    i22 = this.f1593q;
                } else {
                    i22 = 0;
                }
                int i313 = i22 - iArr[1];
                iMin -= Math.max(0, i313);
                iArr[1] = Math.max(0, -i313);
                if (zA) {
                    f fVar11 = (f) this.f1579b.getLayoutParams();
                    int measuredWidth7 = iMin - this.f1579b.getMeasuredWidth();
                    int measuredHeight6 = this.f1579b.getMeasuredHeight() + paddingTop;
                    this.f1579b.layout(measuredWidth7, paddingTop, iMin, measuredHeight6);
                    i23 = measuredWidth7 - this.f1594r;
                    paddingTop = measuredHeight6 + ((ViewGroup.MarginLayoutParams) fVar11).bottomMargin;
                } else {
                    i23 = iMin;
                }
                if (zA2) {
                    int i314 = paddingTop + ((ViewGroup.MarginLayoutParams) ((f) this.f1580c.getLayoutParams())).topMargin;
                    this.f1580c.layout(iMin - this.f1580c.getMeasuredWidth(), i314, iMin, this.f1580c.getMeasuredHeight() + i314);
                    i24 = iMin - this.f1594r;
                } else {
                    i24 = iMin;
                }
                if (z12) {
                    iMin = Math.min(i23, i24);
                }
                iMax = iMax;
                i18 = 0;
            } else {
                if (z12) {
                    i17 = this.f1593q;
                } else {
                    i17 = 0;
                }
                i18 = 0;
                int i315 = i17 - iArr[0];
                iMax += Math.max(0, i315);
                iArr[0] = Math.max(0, -i315);
                if (zA) {
                    f fVar12 = (f) this.f1579b.getLayoutParams();
                    int measuredWidth8 = this.f1579b.getMeasuredWidth() + iMax;
                    int measuredHeight7 = this.f1579b.getMeasuredHeight() + paddingTop;
                    this.f1579b.layout(iMax, paddingTop, measuredWidth8, measuredHeight7);
                    i19 = measuredWidth8 + this.f1594r;
                    paddingTop = measuredHeight7 + ((ViewGroup.MarginLayoutParams) fVar12).bottomMargin;
                } else {
                    i19 = iMax;
                }
                if (zA2) {
                    int i42 = paddingTop + ((ViewGroup.MarginLayoutParams) ((f) this.f1580c.getLayoutParams())).topMargin;
                    int measuredWidth9 = this.f1580c.getMeasuredWidth() + iMax;
                    this.f1580c.layout(iMax, i42, measuredWidth9, this.f1580c.getMeasuredHeight() + i42);
                    i21 = measuredWidth9 + this.f1594r;
                } else {
                    i21 = iMax;
                }
                if (z12) {
                    iMax = Math.max(i19, i21);
                }
            }
        }
        b(this.E, 3);
        size = this.E.size();
        iS2 = iMax;
        while (i31 < size) {
            iS2 = s(this.E.get(i31), iS2, iArr, iMin2);
        }
        i32 = iMin2;
        b(this.E, 5);
        size2 = this.E.size();
        while (i33 < size2) {
            iMin = t(this.E.get(i33), iMin, iArr, i32);
        }
        b(this.E, 1);
        int iQ3 = q(this.E, iArr);
        i34 = (i16 + (((width - i16) - paddingRight) / 2)) - (iQ3 / 2);
        i35 = iQ3 + i34;
        if (i34 >= iS2) {
            if (i35 > iMin) {
                iS2 = i34 - (i35 - iMin);
            } else {
                iS2 = i34;
            }
        }
        size3 = this.E.size();
        while (i18 < size3) {
            iS2 = s(this.E.get(i18), iS2, iArr, i32);
            i18++;
        }
        this.E.clear();
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        int[] iArr = this.G;
        boolean zB = y0.b(this);
        int i13 = !zB ? 1 : 0;
        if (A(this.f1581d)) {
            v(this.f1581d, i11, 0, i12, 0, this.f1592p);
            measuredWidth = this.f1581d.getMeasuredWidth() + o(this.f1581d);
            iMax = Math.max(0, this.f1581d.getMeasuredHeight() + p(this.f1581d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1581d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (A(this.f1585i)) {
            v(this.f1585i, i11, 0, i12, 0, this.f1592p);
            measuredWidth = this.f1585i.getMeasuredWidth() + o(this.f1585i);
            iMax = Math.max(iMax, this.f1585i.getMeasuredHeight() + p(this.f1585i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1585i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (A(this.f1578a)) {
            v(this.f1578a, i11, iMax3, i12, 0, this.f1592p);
            measuredWidth2 = this.f1578a.getMeasuredWidth() + o(this.f1578a);
            iMax = Math.max(iMax, this.f1578a.getMeasuredHeight() + p(this.f1578a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1578a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i13] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (A(this.f1586j)) {
            iMax4 += u(this.f1586j, i11, iMax4, i12, 0, iArr);
            iMax = Math.max(iMax, this.f1586j.getMeasuredHeight() + p(this.f1586j));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1586j.getMeasuredState());
        }
        if (A(this.f1582f)) {
            iMax4 += u(this.f1582f, i11, iMax4, i12, 0, iArr);
            iMax = Math.max(iMax, this.f1582f.getMeasuredHeight() + p(this.f1582f));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1582f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (((f) childAt.getLayoutParams()).f1609b == 0 && A(childAt)) {
                iMax4 += u(childAt, i11, iMax4, i12, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + p(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i15 = this.f1595s + this.f1596t;
        int i16 = this.f1593q + this.f1594r;
        if (A(this.f1579b)) {
            u(this.f1579b, i11, iMax4 + i16, i12, i15, iArr);
            int measuredWidth3 = this.f1579b.getMeasuredWidth() + o(this.f1579b);
            measuredHeight = this.f1579b.getMeasuredHeight() + p(this.f1579b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1579b.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (A(this.f1580c)) {
            iMax2 = Math.max(iMax2, u(this.f1580c, i11, iMax4 + i16, i12, measuredHeight + i15, iArr));
            measuredHeight += this.f1580c.getMeasuredHeight() + p(this.f1580c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f1580c.getMeasuredState());
        }
        int iMax5 = Math.max(iMax, measuredHeight);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i11, (-16777216) & iCombineMeasuredStates2), z() ? 0 : View.resolveSizeAndState(Math.max(iMax5 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i12, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.f1578a;
        androidx.appcompat.view.menu.f fVarPeekMenu = actionMenuView != null ? actionMenuView.peekMenu() : null;
        int i11 = savedState.expandedMenuItemId;
        if (i11 != 0 && this.N != null && fVarPeekMenu != null && (menuItemFindItem = fVarPeekMenu.findItem(i11)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            x();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i11) {
        super.onRtlPropertiesChanged(i11);
        e();
        this.f1597u.f(i11 == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.h hVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        e eVar = this.N;
        if (eVar != null && (hVar = eVar.f1607b) != null) {
            savedState.expandedMenuItemId = hVar.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public final int p(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final int q(List<View> list, int[] iArr) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int size = list.size();
        int i13 = 0;
        int measuredWidth = 0;
        while (i13 < size) {
            View view = list.get(i13);
            f fVar = (f) view.getLayoutParams();
            int i14 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin - i11;
            int i15 = ((ViewGroup.MarginLayoutParams) fVar).rightMargin - i12;
            int iMax = Math.max(0, i14);
            int iMax2 = Math.max(0, i15);
            int iMax3 = Math.max(0, -i14);
            int iMax4 = Math.max(0, -i15);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i13++;
            i12 = iMax4;
            i11 = iMax3;
        }
        return measuredWidth;
    }

    public final boolean r(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.H.removeMenuProvider(menuProvider);
    }

    public final int s(View view, int i11, int[] iArr, int i12) {
        f fVar = (f) view.getLayoutParams();
        int i13 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin - iArr[0];
        int iMax = i11 + Math.max(0, i13);
        iArr[0] = Math.max(0, -i13);
        int iM = m(view, i12);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iM, iMax + measuredWidth, view.getMeasuredHeight() + iM);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
    }

    public void setBackInvokedCallbackEnabled(boolean z11) {
        if (this.T != z11) {
            this.T = z11;
            B();
        }
    }

    public void setCollapseContentDescription(@StringRes int i11) {
        setCollapseContentDescription(i11 != 0 ? getContext().getText(i11) : null);
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            d();
        }
        ImageButton imageButton = this.f1585i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i11) {
        setCollapseIcon(d1.a.b(getContext(), i11));
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            d();
            this.f1585i.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f1585i;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f1583g);
            }
        }
    }

    public void setCollapsible(boolean z11) {
        this.Q = z11;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i11) {
        if (i11 < 0) {
            i11 = Integer.MIN_VALUE;
        }
        if (i11 != this.f1599w) {
            this.f1599w = i11;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i11) {
        if (i11 < 0) {
            i11 = Integer.MIN_VALUE;
        }
        if (i11 != this.f1598v) {
            this.f1598v = i11;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i11, int i12) {
        e();
        this.f1597u.e(i11, i12);
    }

    public void setContentInsetsRelative(int i11, int i12) {
        e();
        this.f1597u.g(i11, i12);
    }

    public void setLogo(int i11) {
        setLogo(d1.a.b(getContext(), i11));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!r(this.f1582f)) {
                c(this.f1582f, true);
            }
        } else {
            ImageView imageView = this.f1582f;
            if (imageView != null && r(imageView)) {
                removeView(this.f1582f);
                this.F.remove(this.f1582f);
            }
        }
        ImageView imageView2 = this.f1582f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(@StringRes int i11) {
        setLogoDescription(getContext().getText(i11));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        ImageView imageView = this.f1582f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setMenu(androidx.appcompat.view.menu.f fVar, ActionMenuPresenter actionMenuPresenter) {
        if (fVar == null && this.f1578a == null) {
            return;
        }
        h();
        androidx.appcompat.view.menu.f fVarPeekMenu = this.f1578a.peekMenu();
        if (fVarPeekMenu == fVar) {
            return;
        }
        if (fVarPeekMenu != null) {
            fVarPeekMenu.R(this.M);
            fVarPeekMenu.R(this.N);
        }
        if (this.N == null) {
            this.N = new e();
        }
        actionMenuPresenter.J(true);
        if (fVar != null) {
            fVar.c(actionMenuPresenter, this.f1587k);
            fVar.c(this.N, this.f1587k);
        } else {
            actionMenuPresenter.k(this.f1587k, null);
            this.N.k(this.f1587k, null);
            actionMenuPresenter.h(true);
            this.N.h(true);
        }
        this.f1578a.setPopupTheme(this.f1588l);
        this.f1578a.setPresenter(actionMenuPresenter);
        this.M = actionMenuPresenter;
        B();
    }

    public void setMenuCallbacks(androidx.appcompat.view.menu.l.a aVar, androidx.appcompat.view.menu.f.a aVar2) {
        this.O = aVar;
        this.P = aVar2;
        ActionMenuView actionMenuView = this.f1578a;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(aVar, aVar2);
        }
    }

    public void setNavigationContentDescription(@StringRes int i11) {
        setNavigationContentDescription(i11 != 0 ? getContext().getText(i11) : null);
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageButton imageButton = this.f1581d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            s0.a(this.f1581d, charSequence);
        }
    }

    public void setNavigationIcon(int i11) {
        setNavigationIcon(d1.a.b(getContext(), i11));
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            i();
            if (!r(this.f1581d)) {
                c(this.f1581d, true);
            }
        } else {
            ImageButton imageButton = this.f1581d;
            if (imageButton != null && r(imageButton)) {
                removeView(this.f1581d);
                this.F.remove(this.f1581d);
            }
        }
        ImageButton imageButton2 = this.f1581d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        i();
        this.f1581d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(g gVar) {
        this.J = gVar;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        g();
        this.f1578a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i11) {
        if (this.f1588l != i11) {
            this.f1588l = i11;
            if (i11 == 0) {
                this.f1587k = getContext();
            } else {
                this.f1587k = new ContextThemeWrapper(getContext(), i11);
            }
        }
    }

    public void setSubtitle(@StringRes int i11) {
        setSubtitle(getContext().getText(i11));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1580c;
            if (textView != null && r(textView)) {
                removeView(this.f1580c);
                this.F.remove(this.f1580c);
            }
        } else {
            if (this.f1580c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1580c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1580c.setEllipsize(TextUtils.TruncateAt.END);
                int i11 = this.f1590n;
                if (i11 != 0) {
                    this.f1580c.setTextAppearance(context, i11);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f1580c.setTextColor(colorStateList);
                }
            }
            if (!r(this.f1580c)) {
                c(this.f1580c, true);
            }
        }
        TextView textView2 = this.f1580c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1602z = charSequence;
    }

    public void setSubtitleTextAppearance(Context context, int i11) {
        this.f1590n = i11;
        TextView textView = this.f1580c;
        if (textView != null) {
            textView.setTextAppearance(context, i11);
        }
    }

    public void setSubtitleTextColor(int i11) {
        setSubtitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.f1580c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(@StringRes int i11) {
        setTitle(getContext().getText(i11));
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1579b;
            if (textView != null && r(textView)) {
                removeView(this.f1579b);
                this.F.remove(this.f1579b);
            }
        } else {
            if (this.f1579b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1579b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1579b.setEllipsize(TextUtils.TruncateAt.END);
                int i11 = this.f1589m;
                if (i11 != 0) {
                    this.f1579b.setTextAppearance(context, i11);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f1579b.setTextColor(colorStateList);
                }
            }
            if (!r(this.f1579b)) {
                c(this.f1579b, true);
            }
        }
        TextView textView2 = this.f1579b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1601y = charSequence;
    }

    public void setTitleMargin(int i11, int i12, int i13, int i14) {
        this.f1593q = i11;
        this.f1595s = i12;
        this.f1594r = i13;
        this.f1596t = i14;
        requestLayout();
    }

    public void setTitleMarginBottom(int i11) {
        this.f1596t = i11;
        requestLayout();
    }

    public void setTitleMarginEnd(int i11) {
        this.f1594r = i11;
        requestLayout();
    }

    public void setTitleMarginStart(int i11) {
        this.f1593q = i11;
        requestLayout();
    }

    public void setTitleMarginTop(int i11) {
        this.f1595s = i11;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, int i11) {
        this.f1589m = i11;
        TextView textView = this.f1579b;
        if (textView != null) {
            textView.setTextAppearance(context, i11);
        }
    }

    public void setTitleTextColor(int i11) {
        setTitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f1579b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.f1578a;
        return actionMenuView != null && actionMenuView.showOverflowMenu();
    }

    public final int t(View view, int i11, int[] iArr, int i12) {
        f fVar = (f) view.getLayoutParams();
        int i13 = ((ViewGroup.MarginLayoutParams) fVar).rightMargin - iArr[1];
        int iMax = i11 - Math.max(0, i13);
        iArr[1] = Math.max(0, -i13);
        int iM = m(view, i12);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iM, iMax, view.getMeasuredHeight() + iM);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) fVar).leftMargin);
    }

    public final int u(View view, int i11, int i12, int i13, int i14, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i15 = marginLayoutParams.leftMargin - iArr[0];
        int i16 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i15) + Math.max(0, i16);
        iArr[0] = Math.max(0, -i15);
        iArr[1] = Math.max(0, -i16);
        view.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + iMax + i12, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i13, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i14, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void v(View view, int i11, int i12, int i13, int i14, int i15) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i12, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i13, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i14, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i15 >= 0) {
            if (mode != 0) {
                i15 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i15);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final void w() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.H.onCreateMenu(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.I = currentMenuItems2;
    }

    public final void x() {
        removeCallbacks(this.U);
        post(this.U);
    }

    public void y() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((f) childAt.getLayoutParams()).f1609b != 2 && childAt != this.f1578a) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    public final boolean z() {
        if (!this.Q) {
            return false;
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (A(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }
}
