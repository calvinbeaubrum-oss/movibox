package io.reactivex.rxjava3.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Scheduler f67316a = g10.a.d(new Callable() { // from class: io.reactivex.rxjava3.android.schedulers.a
        @Override // java.util.concurrent.Callable
        public final Object call() {
            return b.a.f67317a;
        }
    });

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Scheduler f67317a = new HandlerScheduler(new Handler(Looper.getMainLooper()), true);
    }

    public static Scheduler c() {
        return g10.a.e(f67316a);
    }
}
