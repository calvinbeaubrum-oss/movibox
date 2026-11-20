package p012Oooo0oO;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0012a f227b = new C0012a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f228c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Activity> f229a;

    /* JADX INFO: renamed from: Oooo0oO.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0012a {
        public final a a() {
            if (a.f228c == null) {
                synchronized (this) {
                    try {
                        if (a.f228c == null) {
                            a.f228c = new a();
                        }
                        Unit unit = Unit.f68710a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            a aVar = a.f228c;
            Intrinsics.d(aVar);
            return aVar;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.g(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.g(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.g(activity, "activity");
        WeakReference<Activity> weakReference = this.f229a;
        if ((weakReference != null ? weakReference.get() : null) != activity) {
            return;
        }
        this.f229a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.g(activity, "activity");
        this.f229a = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.g(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.g(activity, "activity");
    }
}
