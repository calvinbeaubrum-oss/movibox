package com.applovin.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class q implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f21862a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference f21863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference f21864c;

    public q(Context context) {
        this.f21863b = new WeakReference(null);
        this.f21864c = new WeakReference(null);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.f21863b = new WeakReference(activity);
            if (activity.hasWindowFocus()) {
                this.f21864c = this.f21863b;
            }
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
    }

    public Activity a() {
        return (Activity) this.f21864c.get();
    }

    public void a(p pVar) {
        this.f21862a.add(pVar);
    }

    public Activity b() {
        return (Activity) this.f21863b.get();
    }

    public void b(p pVar) {
        this.f21862a.remove(pVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Iterator it = new ArrayList(this.f21862a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onActivityCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Iterator it = new ArrayList(this.f21862a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onActivityDestroyed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f21864c = new WeakReference(null);
        Iterator it = new ArrayList(this.f21862a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        WeakReference weakReference = new WeakReference(activity);
        this.f21863b = weakReference;
        this.f21864c = weakReference;
        Iterator it = new ArrayList(this.f21862a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Iterator it = new ArrayList(this.f21862a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onActivitySaveInstanceState(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Iterator it = new ArrayList(this.f21862a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onActivityStarted(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Iterator it = new ArrayList(this.f21862a).iterator();
        while (it.hasNext()) {
            ((p) it.next()).onActivityStopped(activity);
        }
    }
}
