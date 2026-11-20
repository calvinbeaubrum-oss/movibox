package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class e {
    private static final b ATOMIC_HELPER;
    private static final Logger log = Logger.getLogger(e.class.getName());
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {
        public b() {
        }

        public abstract void a(e eVar, Set<Throwable> set, Set<Throwable> set2);

        public abstract int b(e eVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<e, Set<Throwable>> f40005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater<e> f40006b;

        public c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f40005a = atomicReferenceFieldUpdater;
            this.f40006b = atomicIntegerFieldUpdater;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.e.b
        public void a(e eVar, Set<Throwable> set, Set<Throwable> set2) {
            androidx.concurrent.futures.a.a(this.f40005a, eVar, set, set2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.e.b
        public int b(e eVar) {
            return this.f40006b.decrementAndGet(eVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends b {
        public d() {
            super();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.e.b
        public void a(e eVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (eVar) {
                try {
                    if (eVar.seenExceptions == set) {
                        eVar.seenExceptions = set2;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.e.b
        public int b(e eVar) {
            int i11;
            synchronized (eVar) {
                e.access$310(eVar);
                i11 = eVar.remaining;
            }
            return i11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        b dVar;
        Throwable th2 = null;
        Object[] objArr = 0;
        try {
            dVar = new c(AtomicReferenceFieldUpdater.newUpdater(e.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(e.class, "remaining"));
        } catch (Throwable th3) {
            dVar = new d();
            th2 = th3;
        }
        ATOMIC_HELPER = dVar;
        if (th2 != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
        }
    }

    public e(int i11) {
        this.remaining = i11;
    }

    public static /* synthetic */ int access$310(e eVar) {
        int i11 = eVar.remaining;
        eVar.remaining = i11 - 1;
        return i11;
    }

    public abstract void addInitialException(Set<Throwable> set);

    public final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.b(this);
    }

    public final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set<Throwable> setC = Sets.c();
        addInitialException(setC);
        ATOMIC_HELPER.a(this, null, setC);
        return this.seenExceptions;
    }
}
