package g1;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f65314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f65315b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        boolean a(b bVar, Menu menu);

        boolean b(b bVar, MenuItem menuItem);

        boolean c(b bVar, Menu menu);

        void d(b bVar);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f65314a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f65315b;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i11);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f65314a = obj;
    }

    public abstract void q(int i11);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z11) {
        this.f65315b = z11;
    }
}
