package com.cloud.sdk.commonutil.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<WeakReference<Activity>> f30303a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<b> f30304b = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, @Nullable Bundle bundle) {
            n.f30303a.add(new WeakReference(activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (n.f30303a.isEmpty()) {
                return;
            }
            Iterator it = n.f30303a.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() == activity) {
                    it.remove();
                }
            }
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
            if (n.f30304b.isEmpty()) {
                return;
            }
            Iterator it = n.f30304b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (n.f30304b.isEmpty()) {
                return;
            }
            Iterator it = n.f30304b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(activity);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {
        public void a(Activity activity) {
        }

        public void b(Activity activity) {
        }
    }

    public static Activity c() {
        List<WeakReference<Activity>> list = f30303a;
        if (list.isEmpty() || list.get(0) == null || list.get(0).get() == null) {
            return null;
        }
        return list.get(0).get();
    }

    public static void d(Application application) {
        if (application == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new a());
    }
}
