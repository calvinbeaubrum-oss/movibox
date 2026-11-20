package nr;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e0;
import androidx.lifecycle.t;
import androidx.lifecycle.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f72142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f72143b;

    public b(u uVar, a aVar) {
        this.f72143b = uVar;
        this.f72142a = aVar;
    }

    @e0(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        d.a("onDestroy");
        this.f72142a.onDestroy(this.f72143b);
    }

    @e0(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        d.a("onPause");
        this.f72142a.onStop(this.f72143b);
    }

    @e0(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        d.a("onResume");
        u uVar = this.f72143b;
        if ((uVar instanceof Fragment) && ((Fragment) uVar).isVisible()) {
            this.f72142a.onStart(this.f72143b);
        }
    }

    @e0(Lifecycle.Event.ON_START)
    public void onStart() {
        d.a("onStart");
    }

    @e0(Lifecycle.Event.ON_STOP)
    public void onStop() {
        d.a("onStop");
    }
}
