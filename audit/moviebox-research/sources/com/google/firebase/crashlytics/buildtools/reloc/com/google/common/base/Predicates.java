package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.io.Serializable;
import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Predicates {

    /* JADX INFO: compiled from: source.java */
    public static class CompositionPredicate<A, B> implements n<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final d<A, ? extends B> f39040f;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final n<B> f39041p;

        public CompositionPredicate(n<B> nVar, d<A, ? extends B> dVar) {
            this.f39041p = (n) l.n(nVar);
            this.f39040f = (d) l.n(dVar);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public boolean apply(A a11) {
            return this.f39041p.apply(this.f39040f.apply(a11));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public boolean equals(Object obj) {
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
            return this.f39040f.equals(compositionPredicate.f39040f) && this.f39041p.equals(compositionPredicate.f39041p);
        }

        public int hashCode() {
            return this.f39040f.hashCode() ^ this.f39041p.hashCode();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Object obj) {
            return m.a(this, obj);
        }

        public String toString() {
            return this.f39041p + "(" + this.f39040f + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class InPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        public InPredicate(Collection<?> collection) {
            this.target = (Collection) l.n(collection);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public boolean apply(T t11) {
            try {
                return this.target.contains(t11);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public boolean equals(Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Object obj) {
            return m.a(this, obj);
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class IsEqualToPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        public IsEqualToPredicate(T t11) {
            this.target = t11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public boolean apply(T t11) {
            return this.target.equals(t11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public boolean equals(Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Object obj) {
            return m.a(this, obj);
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class NotPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        final n<T> predicate;

        public NotPredicate(n<T> nVar) {
            this.predicate = (n) l.n(nVar);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public boolean apply(T t11) {
            return !this.predicate.apply(t11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public boolean equals(Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Object obj) {
            return m.a(this, obj);
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum ObjectPredicate implements n<Object> {
        ALWAYS_TRUE { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
            public boolean apply(Object obj) {
                return true;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return m.a(this, obj);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
            public boolean apply(Object obj) {
                return false;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return m.a(this, obj);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return m.a(this, obj);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate.4
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates.ObjectPredicate, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return m.a(this, obj);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public abstract /* synthetic */ boolean apply(Object obj);

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Object obj) {
            return m.a(this, obj);
        }

        public <T> n<T> withNarrowedType() {
            return this;
        }
    }

    public static <T> n<T> a() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <A, B> n<A> b(n<B> nVar, d<A, ? extends B> dVar) {
        return new CompositionPredicate(nVar, dVar);
    }

    public static <T> n<T> c(T t11) {
        return t11 == null ? e() : new IsEqualToPredicate(t11);
    }

    public static <T> n<T> d(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    public static <T> n<T> e() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> n<T> f(n<T> nVar) {
        return new NotPredicate(nVar);
    }
}
