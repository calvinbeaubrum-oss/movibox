package com.iab.omid.library.mmadbridge.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f42358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f42359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f42360c;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(boolean z11);
    }

    public void a(@NonNull Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public void b(a aVar) {
        this.f42360c = aVar;
    }

    public final void c(boolean z11) {
        if (this.f42359b != z11) {
            this.f42359b = z11;
            if (this.f42358a) {
                f(z11);
                a aVar = this.f42360c;
                if (aVar != null) {
                    aVar.a(z11);
                }
            }
        }
    }

    public final boolean d() {
        return e().importance == 100 || h();
    }

    public ActivityManager.RunningAppProcessInfo e() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    public void f(boolean z11) {
    }

    public boolean g() {
        return this.f42359b;
    }

    public boolean h() {
        return false;
    }

    public void i() {
        this.f42358a = true;
        boolean zD = d();
        this.f42359b = zD;
        f(zD);
    }

    public void j() {
        this.f42358a = false;
        this.f42360c = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        c(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        c(d());
    }
}
