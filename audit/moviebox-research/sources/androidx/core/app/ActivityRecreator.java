package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ActivityRecreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f7545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Field f7546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Field f7547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f7548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f7549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Method f7550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Handler f7551g = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    public static final class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f7552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Activity f7553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7555d = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f7556f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f7557g = false;

        public a(@NonNull Activity activity) {
            this.f7553b = activity;
            this.f7554c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f7553b == activity) {
                this.f7553b = null;
                this.f7556f = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f7556f || this.f7557g || this.f7555d || !ActivityRecreator.h(this.f7552a, this.f7554c, activity)) {
                return;
            }
            this.f7557g = true;
            this.f7552a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f7553b == activity) {
                this.f7555d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> clsA = a();
        f7545a = clsA;
        f7546b = b();
        f7547c = f();
        f7548d = d(clsA);
        f7549e = c(clsA);
        f7550f = e(clsA);
    }

    public static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 == 26 || i11 == 27;
    }

    public static boolean h(Object obj, int i11, Activity activity) {
        try {
            final Object obj2 = f7547c.get(activity);
            if (obj2 == obj && activity.hashCode() == i11) {
                final Object obj3 = f7546b.get(activity);
                f7551g.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.ActivityRecreator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Method method = ActivityRecreator.f7548d;
                            if (method != null) {
                                method.invoke(obj3, obj2, Boolean.FALSE, "AppCompat recreation");
                            } else {
                                ActivityRecreator.f7549e.invoke(obj3, obj2, Boolean.FALSE);
                            }
                        } catch (RuntimeException e11) {
                            if (e11.getClass() == RuntimeException.class && e11.getMessage() != null && e11.getMessage().startsWith("Unable to stop")) {
                                throw e11;
                            }
                        } catch (Throwable th2) {
                            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th2);
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th2) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th2);
            return false;
        }
    }

    public static boolean i(@NonNull Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f7550f == null) {
            return false;
        }
        if (f7549e == null && f7548d == null) {
            return false;
        }
        try {
            final Object obj2 = f7547c.get(activity);
            if (obj2 == null || (obj = f7546b.get(activity)) == null) {
                return false;
            }
            final Application application = activity.getApplication();
            final a aVar = new a(activity);
            application.registerActivityLifecycleCallbacks(aVar);
            f7551g.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.f7552a = obj2;
                }
            });
            try {
                if (g()) {
                    Method method = f7550f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                f7551g.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
