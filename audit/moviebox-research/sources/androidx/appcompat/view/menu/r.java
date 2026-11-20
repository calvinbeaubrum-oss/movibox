package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class r extends n implements SubMenu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e3.c f1200e;

    public r(Context context, e3.c cVar) {
        super(context, cVar);
        this.f1200e = cVar;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f1200e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return c(this.f1200e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i11) {
        this.f1200e.setHeaderIcon(i11);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f1200e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i11) {
        this.f1200e.setHeaderTitle(i11);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f1200e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f1200e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i11) {
        this.f1200e.setIcon(i11);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f1200e.setIcon(drawable);
        return this;
    }
}
