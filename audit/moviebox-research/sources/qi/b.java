package qi;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f74796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f74797b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f74798c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.f74796a = (View) aVar;
    }

    public final void a() {
        ViewParent parent = this.f74796a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.f74796a);
        }
    }

    public int b() {
        return this.f74798c;
    }

    public boolean c() {
        return this.f74797b;
    }

    public void d(@NonNull Bundle bundle) {
        this.f74797b = bundle.getBoolean("expanded", false);
        this.f74798c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f74797b) {
            a();
        }
    }

    @NonNull
    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f74797b);
        bundle.putInt("expandedComponentIdHint", this.f74798c);
        return bundle;
    }

    public boolean f(boolean z11) {
        if (this.f74797b == z11) {
            return false;
        }
        this.f74797b = z11;
        a();
        return true;
    }

    public void g(int i11) {
        this.f74798c = i11;
    }
}
