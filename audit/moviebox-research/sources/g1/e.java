package g1;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends b implements androidx.appcompat.view.menu.f.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f65322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContextView f65323d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b.a f65324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<View> f65325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f65326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f65327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public androidx.appcompat.view.menu.f f65328j;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z11) {
        this.f65322c = context;
        this.f65323d = actionBarContextView;
        this.f65324f = aVar;
        androidx.appcompat.view.menu.f fVarX = new androidx.appcompat.view.menu.f(actionBarContextView.getContext()).X(1);
        this.f65328j = fVarX;
        fVarX.W(this);
        this.f65327i = z11;
    }

    @Override // androidx.appcompat.view.menu.f.a
    public boolean a(@NonNull androidx.appcompat.view.menu.f fVar, @NonNull MenuItem menuItem) {
        return this.f65324f.b(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.f.a
    public void b(@NonNull androidx.appcompat.view.menu.f fVar) {
        k();
        this.f65323d.showOverflowMenu();
    }

    @Override // g1.b
    public void c() {
        if (this.f65326h) {
            return;
        }
        this.f65326h = true;
        this.f65324f.d(this);
    }

    @Override // g1.b
    public View d() {
        WeakReference<View> weakReference = this.f65325g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // g1.b
    public Menu e() {
        return this.f65328j;
    }

    @Override // g1.b
    public MenuInflater f() {
        return new g(this.f65323d.getContext());
    }

    @Override // g1.b
    public CharSequence g() {
        return this.f65323d.getSubtitle();
    }

    @Override // g1.b
    public CharSequence i() {
        return this.f65323d.getTitle();
    }

    @Override // g1.b
    public void k() {
        this.f65324f.a(this, this.f65328j);
    }

    @Override // g1.b
    public boolean l() {
        return this.f65323d.isTitleOptional();
    }

    @Override // g1.b
    public void m(View view) {
        this.f65323d.setCustomView(view);
        this.f65325g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // g1.b
    public void n(int i11) {
        o(this.f65322c.getString(i11));
    }

    @Override // g1.b
    public void o(CharSequence charSequence) {
        this.f65323d.setSubtitle(charSequence);
    }

    @Override // g1.b
    public void q(int i11) {
        r(this.f65322c.getString(i11));
    }

    @Override // g1.b
    public void r(CharSequence charSequence) {
        this.f65323d.setTitle(charSequence);
    }

    @Override // g1.b
    public void s(boolean z11) {
        super.s(z11);
        this.f65323d.setTitleOptional(z11);
    }
}
