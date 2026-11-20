package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class UtilsActivityLifecycleImpl implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final UtilsActivityLifecycleImpl f25290h = new UtilsActivityLifecycleImpl();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Activity f25291i = new Activity();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<Activity> f25292a = new LinkedList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Utils.c> f25293b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Activity, List<Utils.a>> f25294c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25295d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25296f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25297g = false;

    /* JADX INFO: renamed from: com.blankj.utilcode.util.UtilsActivityLifecycleImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Activity val$activity;

        public AnonymousClass2(Activity activity) {
            this.val$activity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            UtilsActivityLifecycleImpl.this.f25294c.remove(this.val$activity);
        }
    }

    public static void w() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                    declaredField.set(null, Float.valueOf(1.0f));
                }
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (NoSuchFieldException e12) {
                e12.printStackTrace();
            }
        }
    }

    public void d(final Activity activity, final Utils.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        j0.H(new Runnable() { // from class: com.blankj.utilcode.util.UtilsActivityLifecycleImpl.1
            @Override // java.lang.Runnable
            public void run() {
                UtilsActivityLifecycleImpl.this.f(activity, aVar);
            }
        });
    }

    public void e(Utils.a aVar) {
        d(f25291i, aVar);
    }

    public final void f(Activity activity, Utils.a aVar) {
        List<Utils.a> copyOnWriteArrayList = this.f25294c.get(activity);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f25294c.put(activity, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(aVar)) {
            return;
        }
        copyOnWriteArrayList.add(aVar);
    }

    public final void g(Activity activity, Lifecycle.Event event) {
        h(activity, event, this.f25294c.get(activity));
        h(activity, event, this.f25294c.get(f25291i));
    }

    public final void h(Activity activity, Lifecycle.Event event, List<Utils.a> list) {
        if (list == null) {
            return;
        }
        for (Utils.a aVar : list) {
            aVar.g(activity, event);
            if (event.equals(Lifecycle.Event.ON_CREATE)) {
                aVar.a(activity);
            } else if (event.equals(Lifecycle.Event.ON_START)) {
                aVar.e(activity);
            } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                aVar.d(activity);
            } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                aVar.c(activity);
            } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                aVar.f(activity);
            } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                aVar.b(activity);
            }
        }
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            this.f25294c.remove(activity);
        }
    }

    public final List<Activity> i() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object objK = k();
            if (objK == null) {
                return linkedList;
            }
            Field declaredField = objK.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objK);
            if (!(obj instanceof Map)) {
                return linkedList;
            }
            for (Object obj2 : ((Map) obj).values()) {
                Class<?> cls = obj2.getClass();
                Field declaredField2 = cls.getDeclaredField("activity");
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(obj2);
                if (activity == null) {
                    Field declaredField3 = cls.getDeclaredField("paused");
                    declaredField3.setAccessible(true);
                    if (declaredField3.getBoolean(obj2)) {
                        linkedList.addFirst(activity2);
                    } else {
                        activity = activity2;
                    }
                } else {
                    linkedList.addFirst(activity2);
                }
            }
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e11.getMessage());
        }
        if (activity != null) {
            linkedList.addFirst(activity);
        }
        return linkedList;
    }

    public List<Activity> j() {
        if (!this.f25292a.isEmpty()) {
            return new LinkedList(this.f25292a);
        }
        this.f25292a.addAll(i());
        return new LinkedList(this.f25292a);
    }

    public final Object k() {
        Object objL = l();
        return objL != null ? objL : m();
    }

    public final Object l() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e11.getMessage());
            return null;
        }
    }

    public final Object m() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e11.getMessage());
            return null;
        }
    }

    public Application n() {
        Object objInvoke;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objK = k();
            if (objK == null || (objInvoke = cls.getMethod("getApplication", new Class[0]).invoke(objK, new Object[0])) == null) {
                return null;
            }
            return (Application) objInvoke;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public Activity o() {
        for (Activity activity : j()) {
            if (j0.v(activity)) {
                return activity;
            }
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        if (this.f25292a.size() == 0) {
            r(activity, true);
        }
        LanguageUtils.a(activity);
        w();
        x(activity);
        g(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        this.f25292a.remove(activity);
        j0.f(activity);
        g(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        g(activity, Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        x(activity);
        if (this.f25297g) {
            this.f25297g = false;
            r(activity, true);
        }
        s(activity, false);
        g(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        if (!this.f25297g) {
            x(activity);
        }
        int i11 = this.f25296f;
        if (i11 < 0) {
            this.f25296f = i11 + 1;
        } else {
            this.f25295d++;
        }
        g(activity, Lifecycle.Event.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.f25296f--;
        } else {
            int i11 = this.f25295d - 1;
            this.f25295d = i11;
            if (i11 <= 0) {
                this.f25297g = true;
                r(activity, false);
            }
        }
        s(activity, true);
        g(activity, Lifecycle.Event.ON_STOP);
    }

    public void p(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public boolean q() {
        return !this.f25297g;
    }

    public final void r(Activity activity, boolean z11) {
        if (this.f25293b.isEmpty()) {
            return;
        }
        for (Utils.c cVar : this.f25293b) {
            if (z11) {
                cVar.a(activity);
            } else {
                cVar.b(activity);
            }
        }
    }

    public final void s(final Activity activity, boolean z11) {
        try {
            if (z11) {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } else {
                final Object tag = activity.getWindow().getDecorView().getTag(-123);
                if (!(tag instanceof Integer)) {
                } else {
                    j0.I(new Runnable() { // from class: com.blankj.utilcode.util.UtilsActivityLifecycleImpl.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Window window2 = activity.getWindow();
                                if (window2 != null) {
                                    window2.setSoftInputMode(((Integer) tag).intValue());
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }, 100L);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void t(final Activity activity, final Utils.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        j0.H(new Runnable() { // from class: com.blankj.utilcode.util.UtilsActivityLifecycleImpl.3
            @Override // java.lang.Runnable
            public void run() {
                UtilsActivityLifecycleImpl.this.v(activity, aVar);
            }
        });
    }

    public void u(Utils.a aVar) {
        t(f25291i, aVar);
    }

    public final void v(Activity activity, Utils.a aVar) {
        List<Utils.a> list = this.f25294c.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        list.remove(aVar);
    }

    public final void x(Activity activity) {
        if (!this.f25292a.contains(activity)) {
            this.f25292a.addFirst(activity);
        } else {
            if (this.f25292a.getFirst().equals(activity)) {
                return;
            }
            this.f25292a.remove(activity);
            this.f25292a.addFirst(activity);
        }
    }

    public void y(Application application) {
        this.f25292a.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }
}
