package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Application f25289a;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class Task<Result> extends ThreadUtils.SimpleTask<Result> {
        private b<Result> mConsumer;

        public Task(b<Result> bVar) {
            this.mConsumer = bVar;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(Result result) {
            b<Result> bVar = this.mConsumer;
            if (bVar != null) {
                bVar.accept(result);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
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
    /* JADX INFO: loaded from: classes3.dex */
    public interface b<T> {
        void accept(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
    public interface c {
        void a(Activity activity);

        void b(Activity activity);
    }

    public static Application a() {
        Application application = f25289a;
        if (application != null) {
            return application;
        }
        b(j0.j());
        if (f25289a == null) {
            throw new NullPointerException("reflect failed.");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j0.k());
        sb2.append(" reflect app success.");
        return f25289a;
    }

    public static void b(Application application) {
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = f25289a;
        if (application2 == null) {
            f25289a = application;
            j0.u(application);
            j0.E();
        } else {
            if (application2.equals(application)) {
                return;
            }
            j0.J(f25289a);
            f25289a = application;
            j0.u(application);
        }
    }
}
