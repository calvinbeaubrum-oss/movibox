package g1;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.n;
import androidx.collection.v0;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f65329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f65330b;

    /* JADX INFO: compiled from: source.java */
    public static class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f65331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f65332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<f> f65333c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final v0<Menu, Menu> f65334d = new v0<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f65332b = context;
            this.f65331a = callback;
        }

        @Override // g1.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f65331a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // g1.b.a
        public boolean b(b bVar, MenuItem menuItem) {
            return this.f65331a.onActionItemClicked(e(bVar), new androidx.appcompat.view.menu.i(this.f65332b, (e3.b) menuItem));
        }

        @Override // g1.b.a
        public boolean c(b bVar, Menu menu) {
            return this.f65331a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // g1.b.a
        public void d(b bVar) {
            this.f65331a.onDestroyActionMode(e(bVar));
        }

        public ActionMode e(b bVar) {
            int size = this.f65333c.size();
            for (int i11 = 0; i11 < size; i11++) {
                f fVar = this.f65333c.get(i11);
                if (fVar != null && fVar.f65330b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f65332b, bVar);
            this.f65333c.add(fVar2);
            return fVar2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = this.f65334d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            n nVar = new n(this.f65332b, (e3.a) menu);
            this.f65334d.put(menu, nVar);
            return nVar;
        }
    }

    public f(Context context, b bVar) {
        this.f65329a = context;
        this.f65330b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f65330b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f65330b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new n(this.f65329a, (e3.a) this.f65330b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f65330b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f65330b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f65330b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f65330b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f65330b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f65330b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f65330b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f65330b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i11) {
        this.f65330b.n(i11);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f65330b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f65330b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i11) {
        this.f65330b.q(i11);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f65330b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z11) {
        this.f65330b.s(z11);
    }
}
