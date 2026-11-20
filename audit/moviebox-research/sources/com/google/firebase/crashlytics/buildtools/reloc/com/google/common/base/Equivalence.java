package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.io.Serializable;
import java.util.function.BiPredicate;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Equivalence<T> implements BiPredicate<T, T> {

    /* JADX INFO: compiled from: source.java */
    public static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class EquivalentToPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;
        private final T target;

        public EquivalentToPredicate(Equivalence<T> equivalence, T t11) {
            this.equivalence = (Equivalence) l.n(equivalence);
            this.target = t11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public boolean apply(T t11) {
            return this.equivalence.equivalent(t11, this.target);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EquivalentToPredicate)) {
                return false;
            }
            EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
            return this.equivalence.equals(equivalentToPredicate.equivalence) && g.a(this.target, equivalentToPredicate.target);
        }

        public int hashCode() {
            return g.b(this.equivalence, this.target);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Object obj) {
            return m.a(this, obj);
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        private final T reference;

        private Wrapper(Equivalence<? super T> equivalence, T t11) {
            this.equivalence = (Equivalence) l.n(equivalence);
            this.reference = t11;
        }

        public boolean equals(Object obj) {
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

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    public abstract boolean doEquivalent(T t11, T t12);

    public abstract int doHash(T t11);

    public final boolean equivalent(T t11, T t12) {
        if (t11 == t12) {
            return true;
        }
        if (t11 == null || t12 == null) {
            return false;
        }
        return doEquivalent(t11, t12);
    }

    public final n<T> equivalentTo(T t11) {
        return new EquivalentToPredicate(this, t11);
    }

    public final int hash(T t11) {
        if (t11 == null) {
            return 0;
        }
        return doHash(t11);
    }

    public final <F> Equivalence<F> onResultOf(d<F, ? extends T> dVar) {
        return new FunctionalEquivalence(dVar, this);
    }

    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    @Override // java.util.function.BiPredicate
    @Deprecated
    public final boolean test(T t11, T t12) {
        return equivalent(t11, t12);
    }

    public final <S extends T> Wrapper<S> wrap(S s11) {
        return new Wrapper<>(s11);
    }
}
