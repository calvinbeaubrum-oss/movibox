package com.google.firebase.perf.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class f implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f41026a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<View> f41027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f41028c;

    public f(View view, Runnable runnable) {
        this.f41027b = new AtomicReference<>(view);
        this.f41028c = runnable;
    }

    public static void a(View view, Runnable runnable) {
        view.getViewTreeObserver().addOnPreDrawListener(new f(view, runnable));
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View andSet = this.f41027b.getAndSet(null);
        if (andSet == null) {
            return true;
        }
        andSet.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f41026a.post(this.f41028c);
        return true;
    }
}
