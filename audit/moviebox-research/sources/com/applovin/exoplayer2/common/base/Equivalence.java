package com.applovin.exoplayer2.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Equivalence<T> {

    /* JADX INFO: compiled from: source.java */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;

        @NullableDecl
        private final T reference;

        private Wrapper(Equivalence<? super T> equivalence, @NullableDecl T t11) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.reference = t11;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, wrapper.reference);
            }
            return false;
        }

        @NullableDecl
        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends Equivalence implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f17197a = new b();

        @Override // com.applovin.exoplayer2.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.applovin.exoplayer2.common.base.Equivalence
        public int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Equivalence f17198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f17199b;

        public c(Equivalence equivalence, Object obj) {
            this.f17198a = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.f17199b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f17198a.equivalent(obj, this.f17199b);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f17198a.equals(cVar.f17198a) && Objects.equal(this.f17199b, cVar.f17199b);
        }

        public int hashCode() {
            return Objects.hashCode(this.f17198a, this.f17199b);
        }

        public String toString() {
            return this.f17198a + ".equivalentTo(" + this.f17199b + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends Equivalence implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f17200a = new d();

        @Override // com.applovin.exoplayer2.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.applovin.exoplayer2.common.base.Equivalence
        public int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public static Equivalence<Object> equals() {
        return b.f17197a;
    }

    public static Equivalence<Object> identity() {
        return d.f17200a;
    }

    public abstract boolean doEquivalent(T t11, T t12);

    public abstract int doHash(T t11);

    public final boolean equivalent(@NullableDecl T t11, @NullableDecl T t12) {
        if (t11 == t12) {
            return true;
        }
        if (t11 == null || t12 == null) {
            return false;
        }
        return doEquivalent(t11, t12);
    }

    public final Predicate<T> equivalentTo(@NullableDecl T t11) {
        return new c(this, t11);
    }

    public final int hash(@NullableDecl T t11) {
        if (t11 == null) {
            return 0;
        }
        return doHash(t11);
    }

    public final <S extends T> Wrapper<S> wrap(@NullableDecl S s11) {
        return new Wrapper<>(s11);
    }
}
