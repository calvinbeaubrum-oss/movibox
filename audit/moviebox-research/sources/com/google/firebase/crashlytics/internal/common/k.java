package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class k implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f40213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ok.g f40214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f40215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gk.a f40216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f40217e = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(ok.g gVar, Thread thread, Throwable th2);
    }

    public k(a aVar, ok.g gVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, gk.a aVar2) {
        this.f40213a = aVar;
        this.f40214b = gVar;
        this.f40215c = uncaughtExceptionHandler;
        this.f40216d = aVar2;
    }

    public boolean a() {
        return this.f40217e.get();
    }

    public final boolean b(Thread thread, Throwable th2) {
        if (thread == null) {
            gk.f.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th2 == null) {
            gk.f.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.f40216d.b()) {
            return true;
        }
        gk.f.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        this.f40217e.set(true);
        try {
            try {
                if (b(thread, th2)) {
                    this.f40213a.a(this.f40214b, thread, th2);
                } else {
                    gk.f.f().b("Uncaught exception will not be recorded by Crashlytics.");
                }
            } catch (Exception e11) {
                gk.f.f().e("An error occurred in the uncaught exception handler", e11);
            }
        } finally {
            gk.f.f().b("Completed exception processing. Invoking default exception handler.");
            this.f40215c.uncaughtException(thread, th2);
            this.f40217e.set(false);
        }
    }
}
