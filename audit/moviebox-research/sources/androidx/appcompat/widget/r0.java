package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class r0 implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toolbar f1749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f1751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f1752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f1753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f1755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1756h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f1757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f1758j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f1759k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Window.Callback f1760l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1761m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ActionMenuPresenter f1762n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1763o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1764p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f1765q;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.appcompat.view.menu.a f1766a;

        public a() {
            this.f1766a = new androidx.appcompat.view.menu.a(r0.this.f1749a.getContext(), 0, R.id.home, 0, 0, r0.this.f1757i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            r0 r0Var = r0.this;
            Window.Callback callback = r0Var.f1760l;
            if (callback == null || !r0Var.f1761m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f1766a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends ViewPropertyAnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1768a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1769b;

        public b(int i11) {
            this.f1769b = i11;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
            this.f1768a = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (this.f1768a) {
                return;
            }
            r0.this.f1749a.setVisibility(this.f1769b);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            r0.this.f1749a.setVisibility(0);
        }
    }

    public r0(Toolbar toolbar, boolean z11) {
        this(toolbar, z11, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    public r0(Toolbar toolbar, boolean z11, int i11, int i12) {
        Drawable drawable;
        this.f1763o = 0;
        this.f1764p = 0;
        this.f1749a = toolbar;
        this.f1757i = toolbar.getTitle();
        this.f1758j = toolbar.getSubtitle();
        this.f1756h = this.f1757i != null;
        this.f1755g = toolbar.getNavigationIcon();
        n0 n0VarV = n0.v(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.f1765q = n0VarV.g(R$styleable.ActionBar_homeAsUpIndicator);
        if (z11) {
            CharSequence charSequenceP = n0VarV.p(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceP)) {
                B(charSequenceP);
            }
            CharSequence charSequenceP2 = n0VarV.p(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                A(charSequenceP2);
            }
            Drawable drawableG = n0VarV.g(R$styleable.ActionBar_logo);
            if (drawableG != null) {
                w(drawableG);
            }
            Drawable drawableG2 = n0VarV.g(R$styleable.ActionBar_icon);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.f1755g == null && (drawable = this.f1765q) != null) {
                z(drawable);
            }
            b(n0VarV.k(R$styleable.ActionBar_displayOptions, 0));
            int iN = n0VarV.n(R$styleable.ActionBar_customNavigationLayout, 0);
            if (iN != 0) {
                u(LayoutInflater.from(this.f1749a.getContext()).inflate(iN, (ViewGroup) this.f1749a, false));
                b(this.f1750b | 16);
            }
            int iM = n0VarV.m(R$styleable.ActionBar_height, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1749a.getLayoutParams();
                layoutParams.height = iM;
                this.f1749a.setLayoutParams(layoutParams);
            }
            int iE = n0VarV.e(R$styleable.ActionBar_contentInsetStart, -1);
            int iE2 = n0VarV.e(R$styleable.ActionBar_contentInsetEnd, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.f1749a.setContentInsetsRelative(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = n0VarV.n(R$styleable.ActionBar_titleTextStyle, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.f1749a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), iN2);
            }
            int iN3 = n0VarV.n(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.f1749a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), iN3);
            }
            int iN4 = n0VarV.n(R$styleable.ActionBar_popupTheme, 0);
            if (iN4 != 0) {
                this.f1749a.setPopupTheme(iN4);
            }
        } else {
            this.f1750b = t();
        }
        n0VarV.x();
        v(i11);
        this.f1759k = this.f1749a.getNavigationContentDescription();
        this.f1749a.setNavigationOnClickListener(new a());
    }

    public void A(CharSequence charSequence) {
        this.f1758j = charSequence;
        if ((this.f1750b & 8) != 0) {
            this.f1749a.setSubtitle(charSequence);
        }
    }

    public void B(CharSequence charSequence) {
        this.f1756h = true;
        C(charSequence);
    }

    public final void C(CharSequence charSequence) {
        this.f1757i = charSequence;
        if ((this.f1750b & 8) != 0) {
            this.f1749a.setTitle(charSequence);
            if (this.f1756h) {
                ViewCompat.setAccessibilityPaneTitle(this.f1749a.getRootView(), charSequence);
            }
        }
    }

    public final void D() {
        if ((this.f1750b & 4) != 0) {
            if (TextUtils.isEmpty(this.f1759k)) {
                this.f1749a.setNavigationContentDescription(this.f1764p);
            } else {
                this.f1749a.setNavigationContentDescription(this.f1759k);
            }
        }
    }

    public final void E() {
        if ((this.f1750b & 4) == 0) {
            this.f1749a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f1749a;
        Drawable drawable = this.f1755g;
        if (drawable == null) {
            drawable = this.f1765q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void F() {
        Drawable drawable;
        int i11 = this.f1750b;
        if ((i11 & 2) == 0) {
            drawable = null;
        } else if ((i11 & 1) == 0 || (drawable = this.f1754f) == null) {
            drawable = this.f1753e;
        }
        this.f1749a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.w
    public boolean a() {
        return this.f1749a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.w
    public void b(int i11) {
        View view;
        int i12 = this.f1750b ^ i11;
        this.f1750b = i11;
        if (i12 != 0) {
            if ((i12 & 4) != 0) {
                if ((i11 & 4) != 0) {
                    D();
                }
                E();
            }
            if ((i12 & 3) != 0) {
                F();
            }
            if ((i12 & 8) != 0) {
                if ((i11 & 8) != 0) {
                    this.f1749a.setTitle(this.f1757i);
                    this.f1749a.setSubtitle(this.f1758j);
                } else {
                    this.f1749a.setTitle((CharSequence) null);
                    this.f1749a.setSubtitle((CharSequence) null);
                }
            }
            if ((i12 & 16) == 0 || (view = this.f1752d) == null) {
                return;
            }
            if ((i11 & 16) != 0) {
                this.f1749a.addView(view);
            } else {
                this.f1749a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.w
    public Menu c() {
        return this.f1749a.getMenu();
    }

    @Override // androidx.appcompat.widget.w
    public boolean canShowOverflowMenu() {
        return this.f1749a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.w
    public void collapseActionView() {
        this.f1749a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.w
    public int d() {
        return this.f1763o;
    }

    @Override // androidx.appcompat.widget.w
    public ViewPropertyAnimatorCompat e(int i11, long j11) {
        return ViewCompat.animate(this.f1749a).alpha(i11 == 0 ? 1.0f : 0.0f).setDuration(j11).setListener(new b(i11));
    }

    @Override // androidx.appcompat.widget.w
    public boolean f() {
        return this.f1753e != null;
    }

    @Override // androidx.appcompat.widget.w
    public ViewGroup g() {
        return this.f1749a;
    }

    @Override // androidx.appcompat.widget.w
    public Context getContext() {
        return this.f1749a.getContext();
    }

    @Override // androidx.appcompat.widget.w
    public CharSequence getTitle() {
        return this.f1749a.getTitle();
    }

    @Override // androidx.appcompat.widget.w
    public void h(boolean z11) {
    }

    @Override // androidx.appcompat.widget.w
    public boolean hideOverflowMenu() {
        return this.f1749a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.w
    public void i() {
    }

    @Override // androidx.appcompat.widget.w
    public boolean isOverflowMenuShowPending() {
        return this.f1749a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.w
    public boolean isOverflowMenuShowing() {
        return this.f1749a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.w
    public void j(boolean z11) {
        this.f1749a.setCollapsible(z11);
    }

    @Override // androidx.appcompat.widget.w
    public void k() {
        this.f1749a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.w
    public void l(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f1751c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1749a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1751c);
            }
        }
        this.f1751c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.f1763o != 2) {
            return;
        }
        this.f1749a.addView(scrollingTabContainerView, 0);
        Toolbar.f fVar = (Toolbar.f) this.f1751c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) fVar).width = -2;
        ((ViewGroup.MarginLayoutParams) fVar).height = -2;
        fVar.f826a = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.w
    public void m(SparseArray<Parcelable> sparseArray) {
        this.f1749a.saveHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.w
    public void n(int i11) {
        w(i11 != 0 ? d1.a.b(getContext(), i11) : null);
    }

    @Override // androidx.appcompat.widget.w
    public void o(androidx.appcompat.view.menu.l.a aVar, androidx.appcompat.view.menu.f.a aVar2) {
        this.f1749a.setMenuCallbacks(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.w
    public void p(SparseArray<Parcelable> sparseArray) {
        this.f1749a.restoreHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.w
    public boolean q() {
        return this.f1754f != null;
    }

    @Override // androidx.appcompat.widget.w
    public int r() {
        return this.f1750b;
    }

    @Override // androidx.appcompat.widget.w
    public void s() {
    }

    @Override // androidx.appcompat.widget.w
    public void setIcon(int i11) {
        setIcon(i11 != 0 ? d1.a.b(getContext(), i11) : null);
    }

    @Override // androidx.appcompat.widget.w
    public void setIcon(Drawable drawable) {
        this.f1753e = drawable;
        F();
    }

    @Override // androidx.appcompat.widget.w
    public void setMenu(Menu menu, androidx.appcompat.view.menu.l.a aVar) {
        if (this.f1762n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f1749a.getContext());
            this.f1762n = actionMenuPresenter;
            actionMenuPresenter.r(R$id.action_menu_presenter);
        }
        this.f1762n.d(aVar);
        this.f1749a.setMenu((androidx.appcompat.view.menu.f) menu, this.f1762n);
    }

    @Override // androidx.appcompat.widget.w
    public void setMenuPrepared() {
        this.f1761m = true;
    }

    @Override // androidx.appcompat.widget.w
    public void setVisibility(int i11) {
        this.f1749a.setVisibility(i11);
    }

    @Override // androidx.appcompat.widget.w
    public void setWindowCallback(Window.Callback callback) {
        this.f1760l = callback;
    }

    @Override // androidx.appcompat.widget.w
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f1756h) {
            return;
        }
        C(charSequence);
    }

    @Override // androidx.appcompat.widget.w
    public boolean showOverflowMenu() {
        return this.f1749a.showOverflowMenu();
    }

    public final int t() {
        if (this.f1749a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1765q = this.f1749a.getNavigationIcon();
        return 15;
    }

    public void u(View view) {
        View view2 = this.f1752d;
        if (view2 != null && (this.f1750b & 16) != 0) {
            this.f1749a.removeView(view2);
        }
        this.f1752d = view;
        if (view == null || (this.f1750b & 16) == 0) {
            return;
        }
        this.f1749a.addView(view);
    }

    public void v(int i11) {
        if (i11 == this.f1764p) {
            return;
        }
        this.f1764p = i11;
        if (TextUtils.isEmpty(this.f1749a.getNavigationContentDescription())) {
            x(this.f1764p);
        }
    }

    public void w(Drawable drawable) {
        this.f1754f = drawable;
        F();
    }

    public void x(int i11) {
        y(i11 == 0 ? null : getContext().getString(i11));
    }

    public void y(CharSequence charSequence) {
        this.f1759k = charSequence;
        D();
    }

    public void z(Drawable drawable) {
        this.f1755g = drawable;
        E();
    }
}
