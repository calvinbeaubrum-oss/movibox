package com.bytedance.sdk.openadsdk.core.Ol.sc;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile sc f28041sc;
    private final pFF pFF;

    private sc(Application application) {
        this.pFF = pFF.sc(application);
    }

    public static sc sc(Application application) {
        if (f28041sc == null) {
            synchronized (sc.class) {
                try {
                    if (f28041sc == null) {
                        f28041sc = new sc(application);
                        application.registerActivityLifecycleCallbacks(f28041sc);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28041sc;
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
    public void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        pFF pff = this.pFF;
        if (pff != null) {
            pff.sc(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        pFF pff = this.pFF;
        if (pff != null) {
            pff.pFF(activity);
        }
    }

    public String sc(String str, long j11, int i11) {
        pFF pff = this.pFF;
        return pff != null ? pff.sc(str, j11, i11) : "null";
    }
}
