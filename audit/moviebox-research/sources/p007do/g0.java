package p007do;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.compose.animation.core.j0;
import eo.z;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g0 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f63456a = new AtomicReference();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f63457b;

    public g0(z zVar) {
        this.f63457b = zVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        j0.a(this.f63456a, activity, null);
        this.f63457b.f64333c.readLock();
        WeakReference weakReference = this.f63457b.f64336f;
        c cVar = weakReference != null ? (c) weakReference.get() : null;
        if (cVar == null || cVar.f63434b != activity) {
            return;
        }
        this.f63457b.d(cVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        onActivityDestroyed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.f63456a.set(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        this.f63456a.set(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        onActivityDestroyed(activity);
    }
}
