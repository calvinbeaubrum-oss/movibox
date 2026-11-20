package com.cloud.tmc.miniutils.util;

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
/* JADX INFO: loaded from: classes4.dex */
public final class UtilsActivityLifecycleImpl implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final UtilsActivityLifecycleImpl f31975h = new UtilsActivityLifecycleImpl();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Activity f31976i = new Activity();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<Activity> f31977a = new LinkedList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e0.c> f31978b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Activity, List<e0.a>> f31979c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f31980d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f31981f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f31982g = false;

    /* JADX INFO: renamed from: com.cloud.tmc.miniutils.util.UtilsActivityLifecycleImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ e0.a val$listener;

        public AnonymousClass1(Activity activity, e0.a aVar) {
            this.val$activity = activity;
            this.val$listener = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            UtilsActivityLifecycleImpl.this.d(this.val$activity, this.val$listener);
        }
    }

    /* JADX INFO: renamed from: com.cloud.tmc.miniutils.util.UtilsActivityLifecycleImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Activity val$activity;

        public AnonymousClass2(Activity activity) {
            this.val$activity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            UtilsActivityLifecycleImpl.this.f31979c.remove(this.val$activity);
        }
    }

    /* JADX INFO: renamed from: com.cloud.tmc.miniutils.util.UtilsActivityLifecycleImpl$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ e0.a val$callbacks;

        public AnonymousClass3(Activity activity, e0.a aVar) {
            this.val$activity = activity;
            this.val$callbacks = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            UtilsActivityLifecycleImpl.this.q(this.val$activity, this.val$callbacks);
        }
    }

    public static void r() {
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

    public final void d(Activity activity, e0.a aVar) {
        List<e0.a> copyOnWriteArrayList = this.f31979c.get(activity);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f31979c.put(activity, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(aVar)) {
            return;
        }
        copyOnWriteArrayList.add(aVar);
    }

    public final void e(Activity activity, Lifecycle.Event event) {
        f(activity, event, this.f31979c.get(activity));
        f(activity, event, this.f31979c.get(f31976i));
    }

    public final void f(Activity activity, Lifecycle.Event event, List<e0.a> list) {
        if (list == null) {
            return;
        }
        for (e0.a aVar : list) {
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
            this.f31979c.remove(activity);
        }
    }

    public final List<Activity> g() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object objI = i();
            if (objI == null) {
                return linkedList;
            }
            Field declaredField = objI.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objI);
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
                        linkedList.add(activity2);
                    } else {
                        activity = activity2;
                    }
                } else {
                    linkedList.add(activity2);
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

    public List<Activity> h() {
        if (!this.f31977a.isEmpty()) {
            return new LinkedList(this.f31977a);
        }
        this.f31977a.addAll(g());
        return new LinkedList(this.f31977a);
    }

    public final Object i() {
        Object objJ = j();
        return objJ != null ? objJ : k();
    }

    public final Object j() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e11.getMessage());
            return null;
        }
    }

    public final Object k() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e11.getMessage());
            return null;
        }
    }

    public Application l() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("getApplication", new Class[0]).invoke(i(), new Object[0]);
            if (objInvoke == null) {
                return null;
            }
            return (Application) objInvoke;
        } catch (Throwable th2) {
            Log.e("UtilsActivityLifecycleImpl", "init error ", th2);
            return null;
        }
    }

    public Activity m() {
        for (Activity activity : h()) {
            if (h0.p(activity)) {
                return activity;
            }
        }
        return null;
    }

    public void n(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public final void o(Activity activity, boolean z11) {
        if (this.f31978b.isEmpty()) {
            return;
        }
        for (e0.c cVar : this.f31978b) {
            if (z11) {
                cVar.a(activity);
            } else {
                cVar.b(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        if (this.f31977a.isEmpty()) {
            o(activity, true);
        }
        r();
        s(activity);
        e(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        this.f31977a.remove(activity);
        h0.f(activity);
        e(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        e(activity, Lifecycle.Event.ON_PAUSE);
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
        s(activity);
        if (this.f31982g) {
            this.f31982g = false;
            o(activity, true);
        }
        p(activity, false);
        e(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        if (!this.f31982g) {
            s(activity);
        }
        int i11 = this.f31981f;
        if (i11 < 0) {
            this.f31981f = i11 + 1;
        } else {
            this.f31980d++;
        }
        e(activity, Lifecycle.Event.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.f31981f--;
        } else {
            int i11 = this.f31980d - 1;
            this.f31980d = i11;
            if (i11 <= 0) {
                this.f31982g = true;
                o(activity, false);
            }
        }
        p(activity, true);
        e(activity, Lifecycle.Event.ON_STOP);
    }

    public final void p(final Activity activity, boolean z11) {
        try {
            if (z11) {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } else {
                final Object tag = activity.getWindow().getDecorView().getTag(-123);
                if (!(tag instanceof Integer)) {
                } else {
                    h0.y(new Runnable() { // from class: com.cloud.tmc.miniutils.util.UtilsActivityLifecycleImpl.4
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

    public final void q(Activity activity, e0.a aVar) {
        List<e0.a> list = this.f31979c.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        list.remove(aVar);
    }

    public final void s(Activity activity) {
        if (!this.f31977a.contains(activity)) {
            this.f31977a.addFirst(activity);
        } else {
            if (this.f31977a.getFirst().equals(activity)) {
                return;
            }
            this.f31977a.remove(activity);
            this.f31977a.addFirst(activity);
        }
    }

    public void t(Application application) {
        this.f31977a.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }
}
