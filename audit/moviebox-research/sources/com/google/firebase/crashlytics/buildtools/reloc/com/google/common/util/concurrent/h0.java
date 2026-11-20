package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class h0<V> extends c0<V> implements i0<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadFactory f40010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f40011b;

    static {
        ThreadFactory threadFactoryB = new m0().e(true).f("ListenableFutureAdapter-thread-%d").b();
        f40010a = threadFactoryB;
        f40011b = Executors.newCachedThreadPool(threadFactoryB);
    }

    public static /* synthetic */ Future f(h0 h0Var) {
        throw null;
    }

    public static /* synthetic */ z g(h0 h0Var) {
        throw null;
    }
}
