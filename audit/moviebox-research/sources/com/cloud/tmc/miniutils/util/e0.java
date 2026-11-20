package com.cloud.tmc.miniutils.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Application f31990a;

    /* JADX INFO: compiled from: source.java */
    public static class a {
        public void a(@NonNull Activity activity) {
        }

        public void b(@NonNull Activity activity) {
        }

        public void c(@NonNull Activity activity) {
        }

        public void d(@NonNull Activity activity) {
        }

        public void e(@NonNull Activity activity) {
        }

        public void f(@NonNull Activity activity) {
        }

        public void g(@NonNull Activity activity, Lifecycle.Event event) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T> {
        void accept(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(Activity activity);

        void b(Activity activity);
    }

    @Deprecated
    public static Application a() {
        Application application = f31990a;
        if (application != null) {
            return application;
        }
        b(h0.h());
        Application application2 = f31990a;
        if (application2 != null) {
            return application2;
        }
        throw new NullPointerException("reflect failed.");
    }

    public static void b(Application application) {
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = f31990a;
        if (application2 == null) {
            f31990a = application;
            h0.n(application);
        } else {
            if (application2.equals(application)) {
                return;
            }
            h0.z(f31990a);
            f31990a = application;
            h0.n(application);
        }
    }

    public static void c(Application application) {
        if (application != null && f31990a == null) {
            b(application);
        }
    }
}
