package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d0 extends androidx.appcompat.app.a implements ActionBarOverlayLayout.b {
    public static final Interpolator E = new AccelerateInterpolator();
    public static final Interpolator F = new DecelerateInterpolator();
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarOverlayLayout f851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActionBarContainer f852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.appcompat.widget.w f853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActionBarContextView f854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScrollingTabContainerView f856i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f859l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f860m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g1.b f861n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g1.b.a f862o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f863p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f865r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f868u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f869v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f870w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public g1.h f872y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f873z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<Object> f857j = new ArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f858k = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<androidx.appcompat.app.a.b> f864q = new ArrayList<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f866s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f867t = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f871x = true;
    public final ViewPropertyAnimatorListener B = new a();
    public final ViewPropertyAnimatorListener C = new b();
    public final ViewPropertyAnimatorUpdateListener D = new c();

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewPropertyAnimatorListenerAdapter {
        public a() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            View view2;
            d0 d0Var = d0.this;
            if (d0Var.f867t && (view2 = d0Var.f855h) != null) {
                view2.setTranslationY(0.0f);
                d0.this.f852e.setTranslationY(0.0f);
            }
            d0.this.f852e.setVisibility(8);
            d0.this.f852e.setTransitioning(false);
            d0 d0Var2 = d0.this;
            d0Var2.f872y = null;
            d0Var2.x();
            ActionBarOverlayLayout actionBarOverlayLayout = d0.this.f851d;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends ViewPropertyAnimatorListenerAdapter {
        public b() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            d0 d0Var = d0.this;
            d0Var.f872y = null;
            d0Var.f852e.requestLayout();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ViewPropertyAnimatorUpdateListener {
        public c() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            ((View) d0.this.f852e.getParent()).invalidate();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends g1.b implements androidx.appcompat.view.menu.f.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.appcompat.view.menu.f f878d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g1.b.a f879f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public WeakReference<View> f880g;

        public d(Context context, g1.b.a aVar) {
            this.f877c = context;
            this.f879f = aVar;
            androidx.appcompat.view.menu.f fVarX = new androidx.appcompat.view.menu.f(context).X(1);
            this.f878d = fVarX;
            fVarX.W(this);
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(@NonNull androidx.appcompat.view.menu.f fVar, @NonNull MenuItem menuItem) {
            g1.b.a aVar = this.f879f;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(@NonNull androidx.appcompat.view.menu.f fVar) {
            if (this.f879f == null) {
                return;
            }
            k();
            d0.this.f854g.showOverflowMenu();
        }

        @Override // g1.b
        public void c() {
            d0 d0Var = d0.this;
            if (d0Var.f860m != this) {
                return;
            }
            if (d0.w(d0Var.f868u, d0Var.f869v, false)) {
                this.f879f.d(this);
            } else {
                d0 d0Var2 = d0.this;
                d0Var2.f861n = this;
                d0Var2.f862o = this.f879f;
            }
            this.f879f = null;
            d0.this.v(false);
            d0.this.f854g.closeMode();
            d0 d0Var3 = d0.this;
            d0Var3.f851d.setHideOnContentScrollEnabled(d0Var3.A);
            d0.this.f860m = null;
        }

        @Override // g1.b
        public View d() {
            WeakReference<View> weakReference = this.f880g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // g1.b
        public Menu e() {
            return this.f878d;
        }

        @Override // g1.b
        public MenuInflater f() {
            return new g1.g(this.f877c);
        }

        @Override // g1.b
        public CharSequence g() {
            return d0.this.f854g.getSubtitle();
        }

        @Override // g1.b
        public CharSequence i() {
            return d0.this.f854g.getTitle();
        }

        @Override // g1.b
        public void k() {
            if (d0.this.f860m != this) {
                return;
            }
            this.f878d.i0();
            try {
                this.f879f.a(this, this.f878d);
            } finally {
                this.f878d.h0();
            }
        }

        @Override // g1.b
        public boolean l() {
            return d0.this.f854g.isTitleOptional();
        }

        @Override // g1.b
        public void m(View view) {
            d0.this.f854g.setCustomView(view);
            this.f880g = new WeakReference<>(view);
        }

        @Override // g1.b
        public void n(int i11) {
            o(d0.this.f848a.getResources().getString(i11));
        }

        @Override // g1.b
        public void o(CharSequence charSequence) {
            d0.this.f854g.setSubtitle(charSequence);
        }

        @Override // g1.b
        public void q(int i11) {
            r(d0.this.f848a.getResources().getString(i11));
        }

        @Override // g1.b
        public void r(CharSequence charSequence) {
            d0.this.f854g.setTitle(charSequence);
        }

        @Override // g1.b
        public void s(boolean z11) {
            super.s(z11);
            d0.this.f854g.setTitleOptional(z11);
        }

        public boolean t() {
            this.f878d.i0();
            try {
                return this.f879f.c(this, this.f878d);
            } finally {
                this.f878d.h0();
            }
        }
    }

    public d0(Activity activity, boolean z11) {
        this.f850c = activity;
        View decorView = activity.getWindow().getDecorView();
        D(decorView);
        if (z11) {
            return;
        }
        this.f855h = decorView.findViewById(R.id.content);
    }

    public d0(Dialog dialog) {
        D(dialog.getWindow().getDecorView());
    }

    public static boolean w(boolean z11, boolean z12, boolean z13) {
        if (z13) {
            return true;
        }
        return (z11 || z12) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final androidx.appcompat.widget.w A(View view) {
        if (view instanceof androidx.appcompat.widget.w) {
            return (androidx.appcompat.widget.w) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        sb2.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb2.toString());
    }

    public int B() {
        return this.f853f.d();
    }

    public final void C() {
        if (this.f870w) {
            this.f870w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f851d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    public final void D(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f851d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f853f = A(view.findViewById(R$id.action_bar));
        this.f854g = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f852e = actionBarContainer;
        androidx.appcompat.widget.w wVar = this.f853f;
        if (wVar == null || this.f854g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f848a = wVar.getContext();
        boolean z11 = (this.f853f.r() & 4) != 0;
        if (z11) {
            this.f859l = true;
        }
        g1.a aVarB = g1.a.b(this.f848a);
        J(aVarB.a() || z11);
        H(aVarB.g());
        TypedArray typedArrayObtainStyledAttributes = this.f848a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            I(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            G(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void E(boolean z11) {
        F(z11 ? 4 : 0, 4);
    }

    public void F(int i11, int i12) {
        int iR = this.f853f.r();
        if ((i12 & 4) != 0) {
            this.f859l = true;
        }
        this.f853f.b((i11 & i12) | ((~i12) & iR));
    }

    public void G(float f11) {
        ViewCompat.setElevation(this.f852e, f11);
    }

    public final void H(boolean z11) {
        this.f865r = z11;
        if (z11) {
            this.f852e.setTabContainer(null);
            this.f853f.l(this.f856i);
        } else {
            this.f853f.l(null);
            this.f852e.setTabContainer(this.f856i);
        }
        boolean z12 = B() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.f856i;
        if (scrollingTabContainerView != null) {
            if (z12) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f851d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f853f.j(!this.f865r && z12);
        this.f851d.setHasNonEmbeddedTabs(!this.f865r && z12);
    }

    public void I(boolean z11) {
        if (z11 && !this.f851d.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.A = z11;
        this.f851d.setHideOnContentScrollEnabled(z11);
    }

    public void J(boolean z11) {
        this.f853f.h(z11);
    }

    public final boolean K() {
        return this.f852e.isLaidOut();
    }

    public final void L() {
        if (this.f870w) {
            return;
        }
        this.f870w = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f851d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        M(false);
    }

    public final void M(boolean z11) {
        if (w(this.f868u, this.f869v, this.f870w)) {
            if (this.f871x) {
                return;
            }
            this.f871x = true;
            z(z11);
            return;
        }
        if (this.f871x) {
            this.f871x = false;
            y(z11);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void a() {
        if (this.f869v) {
            this.f869v = false;
            M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void b() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void c(boolean z11) {
        this.f867t = z11;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void d() {
        if (this.f869v) {
            return;
        }
        this.f869v = true;
        M(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void e() {
        g1.h hVar = this.f872y;
        if (hVar != null) {
            hVar.a();
            this.f872y = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        androidx.appcompat.widget.w wVar = this.f853f;
        if (wVar == null || !wVar.a()) {
            return false;
        }
        this.f853f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void h(boolean z11) {
        if (z11 == this.f863p) {
            return;
        }
        this.f863p = z11;
        int size = this.f864q.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f864q.get(i11).a(z11);
        }
    }

    @Override // androidx.appcompat.app.a
    public int i() {
        return this.f853f.r();
    }

    @Override // androidx.appcompat.app.a
    public Context j() {
        if (this.f849b == null) {
            TypedValue typedValue = new TypedValue();
            this.f848a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                this.f849b = new ContextThemeWrapper(this.f848a, i11);
            } else {
                this.f849b = this.f848a;
            }
        }
        return this.f849b;
    }

    @Override // androidx.appcompat.app.a
    public void k() {
        if (this.f868u) {
            return;
        }
        this.f868u = true;
        M(false);
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        H(g1.a.b(this.f848a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i11, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.f860m;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i11, keyEvent, 0);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.b
    public void onWindowVisibilityChanged(int i11) {
        this.f866s = i11;
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z11) {
        if (this.f859l) {
            return;
        }
        E(z11);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z11) {
        g1.h hVar;
        this.f873z = z11;
        if (z11 || (hVar = this.f872y) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void t(CharSequence charSequence) {
        this.f853f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public g1.b u(g1.b.a aVar) {
        d dVar = this.f860m;
        if (dVar != null) {
            dVar.c();
        }
        this.f851d.setHideOnContentScrollEnabled(false);
        this.f854g.killMode();
        d dVar2 = new d(this.f854g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f860m = dVar2;
        dVar2.k();
        this.f854g.initForMode(dVar2);
        v(true);
        return dVar2;
    }

    public void v(boolean z11) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatE;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatE2;
        if (z11) {
            L();
        } else {
            C();
        }
        if (!K()) {
            if (z11) {
                this.f853f.setVisibility(4);
                this.f854g.setVisibility(0);
                return;
            } else {
                this.f853f.setVisibility(0);
                this.f854g.setVisibility(8);
                return;
            }
        }
        if (z11) {
            viewPropertyAnimatorCompatE2 = this.f853f.e(4, 100L);
            viewPropertyAnimatorCompatE = this.f854g.setupAnimatorToVisibility(0, 200L);
        } else {
            viewPropertyAnimatorCompatE = this.f853f.e(0, 200L);
            viewPropertyAnimatorCompatE2 = this.f854g.setupAnimatorToVisibility(8, 100L);
        }
        g1.h hVar = new g1.h();
        hVar.d(viewPropertyAnimatorCompatE2, viewPropertyAnimatorCompatE);
        hVar.h();
    }

    public void x() {
        g1.b.a aVar = this.f862o;
        if (aVar != null) {
            aVar.d(this.f861n);
            this.f861n = null;
            this.f862o = null;
        }
    }

    public void y(boolean z11) {
        View view;
        g1.h hVar = this.f872y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f866s != 0 || (!this.f873z && !z11)) {
            this.B.onAnimationEnd(null);
            return;
        }
        this.f852e.setAlpha(1.0f);
        this.f852e.setTransitioning(true);
        g1.h hVar2 = new g1.h();
        float f11 = -this.f852e.getHeight();
        if (z11) {
            int[] iArr = {0, 0};
            this.f852e.getLocationInWindow(iArr);
            f11 -= iArr[1];
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatTranslationY = ViewCompat.animate(this.f852e).translationY(f11);
        viewPropertyAnimatorCompatTranslationY.setUpdateListener(this.D);
        hVar2.c(viewPropertyAnimatorCompatTranslationY);
        if (this.f867t && (view = this.f855h) != null) {
            hVar2.c(ViewCompat.animate(view).translationY(f11));
        }
        hVar2.f(E);
        hVar2.e(250L);
        hVar2.g(this.B);
        this.f872y = hVar2;
        hVar2.h();
    }

    public void z(boolean z11) {
        View view;
        View view2;
        g1.h hVar = this.f872y;
        if (hVar != null) {
            hVar.a();
        }
        this.f852e.setVisibility(0);
        if (this.f866s == 0 && (this.f873z || z11)) {
            this.f852e.setTranslationY(0.0f);
            float f11 = -this.f852e.getHeight();
            if (z11) {
                int[] iArr = {0, 0};
                this.f852e.getLocationInWindow(iArr);
                f11 -= iArr[1];
            }
            this.f852e.setTranslationY(f11);
            g1.h hVar2 = new g1.h();
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatTranslationY = ViewCompat.animate(this.f852e).translationY(0.0f);
            viewPropertyAnimatorCompatTranslationY.setUpdateListener(this.D);
            hVar2.c(viewPropertyAnimatorCompatTranslationY);
            if (this.f867t && (view2 = this.f855h) != null) {
                view2.setTranslationY(f11);
                hVar2.c(ViewCompat.animate(this.f855h).translationY(0.0f));
            }
            hVar2.f(F);
            hVar2.e(250L);
            hVar2.g(this.C);
            this.f872y = hVar2;
            hVar2.h();
        } else {
            this.f852e.setAlpha(1.0f);
            this.f852e.setTranslationY(0.0f);
            if (this.f867t && (view = this.f855h) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f851d;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }
}
