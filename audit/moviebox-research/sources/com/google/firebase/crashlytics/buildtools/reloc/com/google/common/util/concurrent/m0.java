package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f40019a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f40020b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f40021c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f40022d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ThreadFactory f40023e = null;

    /* JADX INFO: compiled from: source.java */
    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f40024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f40025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f40026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Boolean f40027d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Integer f40028f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f40029g;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f40024a = threadFactory;
            this.f40025b = str;
            this.f40026c = atomicLong;
            this.f40027d = bool;
            this.f40028f = num;
            this.f40029g = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f40024a.newThread(runnable);
            String str = this.f40025b;
            if (str != null) {
                threadNewThread.setName(m0.d(str, Long.valueOf(this.f40026c.getAndIncrement())));
            }
            Boolean bool = this.f40027d;
            if (bool != null) {
                threadNewThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f40028f;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f40029g;
            if (uncaughtExceptionHandler != null) {
                threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return threadNewThread;
        }
    }

    public static ThreadFactory c(m0 m0Var) {
        String str = m0Var.f40019a;
        Boolean bool = m0Var.f40020b;
        Integer num = m0Var.f40021c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = m0Var.f40022d;
        ThreadFactory threadFactoryDefaultThreadFactory = m0Var.f40023e;
        if (threadFactoryDefaultThreadFactory == null) {
            threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactoryDefaultThreadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory b() {
        return c(this);
    }

    public m0 e(boolean z11) {
        this.f40020b = Boolean.valueOf(z11);
        return this;
    }

    public m0 f(String str) {
        d(str, 0);
        this.f40019a = str;
        return this;
    }
}
