package com.google.common.util.concurrent;

import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@ReflectionSupport(ReflectionSupport.Level.FULL)
public abstract class d<OutputT> extends AbstractFuture.h<OutputT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f38936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f38937b = Logger.getLogger(d.class.getName());
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions;

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {
        public b() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<d<?>, Set<Throwable>> f38938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater<d<?>> f38939b;

        public c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f38938a = atomicReferenceFieldUpdater;
            this.f38939b = atomicIntegerFieldUpdater;
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0404d extends b {
        public C0404d() {
            super();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        b c0404d;
        Throwable th2 = null;
        Object[] objArr = 0;
        try {
            c0404d = new c(AtomicReferenceFieldUpdater.newUpdater(d.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(d.class, "remaining"));
        } catch (Error | RuntimeException e11) {
            c0404d = new C0404d();
            th2 = e11;
        }
        f38936a = c0404d;
        if (th2 != null) {
            f38937b.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
        }
    }
}
