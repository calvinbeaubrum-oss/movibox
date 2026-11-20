package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.r0;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ToolbarActionBar extends androidx.appcompat.app.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.appcompat.widget.w f812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Window.Callback f813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatDelegateImpl.e f814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<androidx.appcompat.app.a.b> f818g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f819h = new Runnable() { // from class: androidx.appcompat.app.ToolbarActionBar.1
        @Override // java.lang.Runnable
        public void run() {
            ToolbarActionBar.this.w();
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Toolbar.g f820i;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements Toolbar.g {
        public a() {
        }

        @Override // androidx.appcompat.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ToolbarActionBar.this.f813b.onMenuItemSelected(0, menuItem);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public final class b implements androidx.appcompat.view.menu.l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f822a;

        public b() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void b(@NonNull androidx.appcompat.view.menu.f fVar, boolean z11) {
            if (this.f822a) {
                return;
            }
            this.f822a = true;
            ToolbarActionBar.this.f812a.k();
            ToolbarActionBar.this.f813b.onPanelClosed(108, fVar);
            this.f822a = false;
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean c(@NonNull androidx.appcompat.view.menu.f fVar) {
            ToolbarActionBar.this.f813b.onMenuOpened(108, fVar);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public final class c implements androidx.appcompat.view.menu.f.a {
        public c() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean a(@NonNull androidx.appcompat.view.menu.f fVar, @NonNull MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void b(@NonNull androidx.appcompat.view.menu.f fVar) {
            if (ToolbarActionBar.this.f812a.isOverflowMenuShowing()) {
                ToolbarActionBar.this.f813b.onPanelClosed(108, fVar);
            } else if (ToolbarActionBar.this.f813b.onPreparePanel(0, null, fVar)) {
                ToolbarActionBar.this.f813b.onMenuOpened(108, fVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d implements AppCompatDelegateImpl.e {
        public d() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.e
        public boolean a(int i11) {
            if (i11 != 0) {
                return false;
            }
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.f815d) {
                return false;
            }
            toolbarActionBar.f812a.setMenuPrepared();
            ToolbarActionBar.this.f815d = true;
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.e
        public View onCreatePanelView(int i11) {
            if (i11 == 0) {
                return new View(ToolbarActionBar.this.f812a.getContext());
            }
            return null;
        }
    }

    public ToolbarActionBar(@NonNull Toolbar toolbar, @Nullable CharSequence charSequence, @NonNull Window.Callback callback) {
        a aVar = new a();
        this.f820i = aVar;
        androidx.core.util.i.g(toolbar);
        r0 r0Var = new r0(toolbar, false);
        this.f812a = r0Var;
        this.f813b = (Window.Callback) androidx.core.util.i.g(callback);
        r0Var.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(aVar);
        r0Var.setWindowTitle(charSequence);
        this.f814c = new d();
    }

    @Override // androidx.appcompat.app.a
    public boolean f() {
        return this.f812a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        if (!this.f812a.a()) {
            return false;
        }
        this.f812a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void h(boolean z11) {
        if (z11 == this.f817f) {
            return;
        }
        this.f817f = z11;
        int size = this.f818g.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f818g.get(i11).a(z11);
        }
    }

    @Override // androidx.appcompat.app.a
    public int i() {
        return this.f812a.r();
    }

    @Override // androidx.appcompat.app.a
    public Context j() {
        return this.f812a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public void k() {
        this.f812a.setVisibility(8);
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.f812a.g().removeCallbacks(this.f819h);
        ViewCompat.postOnAnimation(this.f812a.g(), this.f819h);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    @Override // androidx.appcompat.app.a
    public void n() {
        this.f812a.g().removeCallbacks(this.f819h);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i11, KeyEvent keyEvent) {
        Menu menuV = v();
        if (menuV == null) {
            return false;
        }
        menuV.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuV.performShortcut(i11, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.f812a.showOverflowMenu();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z11) {
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z11) {
    }

    @Override // androidx.appcompat.app.a
    public void t(CharSequence charSequence) {
        this.f812a.setWindowTitle(charSequence);
    }

    public final Menu v() {
        if (!this.f816e) {
            this.f812a.o(new b(), new c());
            this.f816e = true;
        }
        return this.f812a.c();
    }

    public void w() {
        Menu menuV = v();
        androidx.appcompat.view.menu.f fVar = menuV instanceof androidx.appcompat.view.menu.f ? (androidx.appcompat.view.menu.f) menuV : null;
        if (fVar != null) {
            fVar.i0();
        }
        try {
            menuV.clear();
            if (!this.f813b.onCreatePanelMenu(0, menuV) || !this.f813b.onPreparePanel(0, null, menuV)) {
                menuV.clear();
            }
        } finally {
            if (fVar != null) {
                fVar.h0();
            }
        }
    }
}
