package com.gyf.immersionbar;

import android.R;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class f implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImmersionBar f41646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Window f41647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f41648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f41649d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f41650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f41651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f41652h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f41653i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f41654j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f41655k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f41656l;

    public f(ImmersionBar immersionBar) {
        this.f41651g = 0;
        this.f41652h = 0;
        this.f41653i = 0;
        this.f41654j = 0;
        this.f41646a = immersionBar;
        Window window = immersionBar.getWindow();
        this.f41647b = window;
        View decorView = window.getDecorView();
        this.f41648c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(R.id.content);
        if (immersionBar.isDialogFragment()) {
            Fragment supportFragment = immersionBar.getSupportFragment();
            if (supportFragment != null) {
                this.f41650f = supportFragment.getView();
            } else {
                android.app.Fragment fragment = immersionBar.getFragment();
                if (fragment != null) {
                    this.f41650f = fragment.getView();
                }
            }
        } else {
            View childAt = frameLayout.getChildAt(0);
            this.f41650f = childAt;
            if (childAt != null && (childAt instanceof DrawerLayout)) {
                this.f41650f = ((DrawerLayout) childAt).getChildAt(0);
            }
        }
        View view = this.f41650f;
        if (view != null) {
            this.f41651g = view.getPaddingLeft();
            this.f41652h = this.f41650f.getPaddingTop();
            this.f41653i = this.f41650f.getPaddingRight();
            this.f41654j = this.f41650f.getPaddingBottom();
        }
        View view2 = this.f41650f;
        this.f41649d = view2 != null ? view2 : frameLayout;
    }

    public void a() {
        if (this.f41656l) {
            this.f41648c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f41656l = false;
        }
    }

    public void b() {
        if (this.f41656l) {
            if (this.f41650f != null) {
                this.f41649d.setPadding(this.f41651g, this.f41652h, this.f41653i, this.f41654j);
            } else {
                this.f41649d.setPadding(this.f41646a.getPaddingLeft(), this.f41646a.getPaddingTop(), this.f41646a.getPaddingRight(), this.f41646a.getPaddingBottom());
            }
        }
    }

    public void c(int i11) {
        this.f41647b.setSoftInputMode(i11);
        if (this.f41656l) {
            return;
        }
        this.f41648c.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f41656l = true;
    }

    public void d() {
        this.f41655k = 0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImmersionBar immersionBar = this.f41646a;
        if (immersionBar == null || immersionBar.getBarParams() == null || !this.f41646a.getBarParams().G) {
            return;
        }
        a barConfig = this.f41646a.getBarConfig();
        int iD = barConfig.n() ? barConfig.d() : barConfig.g();
        Rect rect = new Rect();
        this.f41648c.getWindowVisibleDisplayFrame(rect);
        int height = this.f41649d.getHeight() - rect.bottom;
        if (height != this.f41655k) {
            this.f41655k = height;
            int i11 = 0;
            int i12 = 1;
            if (ImmersionBar.checkFitsSystemWindows(this.f41647b.getDecorView().findViewById(R.id.content))) {
                if (height - iD > iD) {
                    i11 = 1;
                }
            } else if (this.f41650f != null) {
                if (this.f41646a.getBarParams().F) {
                    height += this.f41646a.getActionBarHeight() + barConfig.k();
                }
                if (this.f41646a.getBarParams().f41639z) {
                    height += barConfig.k();
                }
                if (height > iD) {
                    i11 = height + this.f41654j;
                } else {
                    i12 = 0;
                }
                this.f41649d.setPadding(this.f41651g, this.f41652h, this.f41653i, i11);
                i11 = i12;
            } else {
                int paddingBottom = this.f41646a.getPaddingBottom();
                int i13 = height - iD;
                if (i13 > iD) {
                    paddingBottom = i13 + iD;
                    i11 = 1;
                }
                this.f41649d.setPadding(this.f41646a.getPaddingLeft(), this.f41646a.getPaddingTop(), this.f41646a.getPaddingRight(), paddingBottom);
            }
            this.f41646a.getBarParams().getClass();
            if (i11 == 0 && this.f41646a.getBarParams().f41624k != BarHide.FLAG_SHOW_BAR) {
                this.f41646a.setBar();
            }
            if (i11 == 0) {
                this.f41646a.fitsParentBarKeyboard();
            }
        }
    }
}
