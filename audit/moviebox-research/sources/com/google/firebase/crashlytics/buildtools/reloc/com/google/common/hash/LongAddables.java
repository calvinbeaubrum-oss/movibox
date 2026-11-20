package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class LongAddables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<k> f39823a;

    /* JADX INFO: compiled from: source.java */
    public static final class PureJavaLongAddable extends AtomicLong implements k {
        private PureJavaLongAddable() {
        }

        public /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.k
        public void add(long j11) {
            getAndAdd(j11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.k
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.k
        public long sum() {
            return get();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a implements q<k> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k get() {
            return new LongAdder();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements q<k> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        q<k> bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f39823a = bVar;
    }

    public static k a() {
        return f39823a.get();
    }
}
