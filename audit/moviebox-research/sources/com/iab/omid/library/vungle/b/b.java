package com.iab.omid.library.vungle.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static b f42425d = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f42426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f42427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f42428c;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(boolean z11);
    }

    public static b a() {
        return f42425d;
    }

    public void b(@NonNull Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public void c(a aVar) {
        this.f42428c = aVar;
    }

    public final void d(boolean z11) {
        if (this.f42427b != z11) {
            this.f42427b = z11;
            if (this.f42426a) {
                h();
                a aVar = this.f42428c;
                if (aVar != null) {
                    aVar.a(!z11);
                }
            }
        }
    }

    public void e() {
        this.f42426a = true;
        this.f42427b = false;
        h();
    }

    public void f() {
        this.f42426a = false;
        this.f42427b = false;
        this.f42428c = null;
    }

    @RequiresApi(api = 16)
    public ActivityManager.RunningAppProcessInfo g() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    public final void h() {
        boolean z11 = !this.f42427b;
        Iterator<sn.f> it = com.iab.omid.library.vungle.b.a.a().c().iterator();
        while (it.hasNext()) {
            it.next().k().h(z11);
        }
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
        d(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        View viewG;
        boolean z11 = false;
        boolean z12 = g().importance != 100;
        boolean z13 = true;
        for (sn.f fVar : com.iab.omid.library.vungle.b.a.a().e()) {
            if (fVar.i() && (viewG = fVar.g()) != null && viewG.hasWindowFocus()) {
                z13 = false;
            }
        }
        if (z12 && z13) {
            z11 = true;
        }
        d(z11);
    }
}
