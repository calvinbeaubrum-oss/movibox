package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.v0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v0<e3.b, MenuItem> f1075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v0<e3.c, SubMenu> f1076c;

    public c(Context context) {
        this.f1074a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof e3.b)) {
            return menuItem;
        }
        e3.b bVar = (e3.b) menuItem;
        if (this.f1075b == null) {
            this.f1075b = new v0<>();
        }
        MenuItem menuItem2 = this.f1075b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        i iVar = new i(this.f1074a, bVar);
        this.f1075b.put(bVar, iVar);
        return iVar;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof e3.c)) {
            return subMenu;
        }
        e3.c cVar = (e3.c) subMenu;
        if (this.f1076c == null) {
            this.f1076c = new v0<>();
        }
        SubMenu subMenu2 = this.f1076c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        r rVar = new r(this.f1074a, cVar);
        this.f1076c.put(cVar, rVar);
        return rVar;
    }

    public final void e() {
        v0<e3.b, MenuItem> v0Var = this.f1075b;
        if (v0Var != null) {
            v0Var.clear();
        }
        v0<e3.c, SubMenu> v0Var2 = this.f1076c;
        if (v0Var2 != null) {
            v0Var2.clear();
        }
    }

    public final void f(int i11) {
        if (this.f1075b == null) {
            return;
        }
        int i12 = 0;
        while (i12 < this.f1075b.size()) {
            if (this.f1075b.keyAt(i12).getGroupId() == i11) {
                this.f1075b.removeAt(i12);
                i12--;
            }
            i12++;
        }
    }

    public final void g(int i11) {
        if (this.f1075b == null) {
            return;
        }
        for (int i12 = 0; i12 < this.f1075b.size(); i12++) {
            if (this.f1075b.keyAt(i12).getItemId() == i11) {
                this.f1075b.removeAt(i12);
                return;
            }
        }
    }
}
