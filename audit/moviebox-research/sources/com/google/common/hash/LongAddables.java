package com.google.common.hash;

import com.google.common.base.q;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class LongAddables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<h> f38736a;

    /* JADX INFO: compiled from: source.java */
    public static final class PureJavaLongAddable extends AtomicLong implements h {
        private PureJavaLongAddable() {
        }

        public /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }

        @Override // com.google.common.hash.h
        public void add(long j11) {
            getAndAdd(j11);
        }

        @Override // com.google.common.hash.h
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.hash.h
        public long sum() {
            return get();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements q<h> {
        @Override // com.google.common.base.q
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h get() {
            return new LongAdder();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements q<h> {
        @Override // com.google.common.base.q
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        q<h> bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f38736a = bVar;
    }

    public static h a() {
        return f38736a.get();
    }
}
