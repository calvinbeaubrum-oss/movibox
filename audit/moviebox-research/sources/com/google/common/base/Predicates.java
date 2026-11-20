package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Predicates {

    /* JADX INFO: compiled from: source.java */
    public static class AndPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends n<? super T>> components;

        public AndPredicate(List<? extends n<? super T>> list) {
            this.components = list;
        }

        @Override // com.google.common.base.n
        public boolean apply(T t11) {
            for (int i11 = 0; i11 < this.components.size(); i11++) {
                if (!this.components.get(i11).apply(t11)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.base.n
        public boolean equals(Object obj) {
            if (obj instanceof AndPredicate) {
                return this.components.equals(((AndPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.j("and", this.components);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class CompositionPredicate<A, B> implements n<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final f<A, ? extends B> f38150f;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final n<B> f38151p;

        public CompositionPredicate(n<B> nVar, f<A, ? extends B> fVar) {
            this.f38151p = (n) m.p(nVar);
            this.f38150f = (f) m.p(fVar);
        }

        @Override // com.google.common.base.n
        public boolean apply(A a11) {
            return this.f38151p.apply(this.f38150f.apply(a11));
        }

        @Override // com.google.common.base.n
        public boolean equals(Object obj) {
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
            return this.f38150f.equals(compositionPredicate.f38150f) && this.f38151p.equals(compositionPredicate.f38151p);
        }

        public int hashCode() {
            return this.f38150f.hashCode() ^ this.f38151p.hashCode();
        }

        public String toString() {
            return this.f38151p + "(" + this.f38150f + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class InPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        public InPredicate(Collection<?> collection) {
            this.target = (Collection) m.p(collection);
        }

        @Override // com.google.common.base.n
        public boolean apply(T t11) {
            try {
                return this.target.contains(t11);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.n
        public boolean equals(Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class IsEqualToPredicate implements n<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Object target;

        public IsEqualToPredicate(Object obj) {
            this.target = obj;
        }

        @Override // com.google.common.base.n
        public boolean apply(Object obj) {
            return this.target.equals(obj);
        }

        @Override // com.google.common.base.n
        public boolean equals(Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }

        public <T> n<T> withNarrowedType() {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class NotPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        final n<T> predicate;

        public NotPredicate(n<T> nVar) {
            this.predicate = (n) m.p(nVar);
        }

        @Override // com.google.common.base.n
        public boolean apply(T t11) {
            return !this.predicate.apply(t11);
        }

        @Override // com.google.common.base.n
        public boolean equals(Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum ObjectPredicate implements n<Object> {
        ALWAYS_TRUE { // from class: com.google.common.base.Predicates.ObjectPredicate.1
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.n
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.google.common.base.Predicates.ObjectPredicate.2
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.n
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.3
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.n
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.4
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.n
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        @Override // com.google.common.base.n
        public abstract /* synthetic */ boolean apply(Object obj);

        public <T> n<T> withNarrowedType() {
            return this;
        }
    }

    public static <T> n<T> b() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> n<T> c(n<? super T> nVar, n<? super T> nVar2) {
        return new AndPredicate(d((n) m.p(nVar), (n) m.p(nVar2)));
    }

    public static <T> List<n<? super T>> d(n<? super T> nVar, n<? super T> nVar2) {
        return Arrays.asList(nVar, nVar2);
    }

    public static <A, B> n<A> e(n<B> nVar, f<A, ? extends B> fVar) {
        return new CompositionPredicate(nVar, fVar);
    }

    public static <T> n<T> f(T t11) {
        return t11 == null ? h() : new IsEqualToPredicate(t11).withNarrowedType();
    }

    public static <T> n<T> g(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    public static <T> n<T> h() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> n<T> i(n<T> nVar) {
        return new NotPredicate(nVar);
    }

    public static String j(String str, Iterable<?> iterable) {
        StringBuilder sb2 = new StringBuilder("Predicates.");
        sb2.append(str);
        sb2.append('(');
        boolean z11 = true;
        for (Object obj : iterable) {
            if (!z11) {
                sb2.append(',');
            }
            sb2.append(obj);
            z11 = false;
        }
        sb2.append(')');
        return sb2.toString();
    }
}
