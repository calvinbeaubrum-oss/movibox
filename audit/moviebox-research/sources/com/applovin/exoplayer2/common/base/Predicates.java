package com.applovin.exoplayer2.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Predicates {

    /* JADX INFO: compiled from: source.java */
    public static class b implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f17207a;

        private b(List list) {
            this.f17207a = list;
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            for (int i11 = 0; i11 < this.f17207a.size(); i11++) {
                if (!((Predicate) this.f17207a.get(i11)).apply(obj)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f17207a.equals(((b) obj).f17207a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17207a.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.toStringHelper("and", this.f17207a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Predicate f17208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f17209b;

        private c(Predicate predicate, Function function) {
            this.f17208a = (Predicate) Preconditions.checkNotNull(predicate);
            this.f17209b = (Function) Preconditions.checkNotNull(function);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f17208a.apply(this.f17209b.apply(obj));
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f17209b.equals(cVar.f17209b) && this.f17208a.equals(cVar.f17208a);
        }

        public int hashCode() {
            return this.f17209b.hashCode() ^ this.f17208a.hashCode();
        }

        public String toString() {
            return this.f17208a + "(" + this.f17209b + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Collection f17210a;

        private d(Collection collection) {
            this.f17210a = (Collection) Preconditions.checkNotNull(collection);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            try {
                return this.f17210a.contains(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f17210a.equals(((d) obj).f17210a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17210a.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.f17210a + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f17211a;

        private e(Class cls) {
            this.f17211a = (Class) Preconditions.checkNotNull(cls);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f17211a.isInstance(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            return (obj instanceof e) && this.f17211a == ((e) obj).f17211a;
        }

        public int hashCode() {
            return this.f17211a.hashCode();
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.f17211a.getName() + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f17212a;

        private f(Object obj) {
            this.f17212a = obj;
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f17212a.equals(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof f) {
                return this.f17212a.equals(((f) obj).f17212a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17212a.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.f17212a + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Predicate f17213a;

        public g(Predicate predicate) {
            this.f17213a = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            return !this.f17213a.apply(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof g) {
                return this.f17213a.equals(((g) obj).f17213a);
            }
            return false;
        }

        public int hashCode() {
            return ~this.f17213a.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.f17213a + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: source.java */
    public static abstract class h implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f17214a = new a("ALWAYS_TRUE", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f17215b = new b("ALWAYS_FALSE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f17216c = new c("IS_NULL", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final h f17217d = new d("NOT_NULL", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ h[] f17218f = a();

        /* JADX INFO: compiled from: source.java */
        public final enum a extends h {
            public a(String str, int i11) {
                super(str, i11);
            }

            @Override // com.applovin.exoplayer2.common.base.Predicate
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        /* JADX INFO: compiled from: source.java */
        public final enum b extends h {
            public b(String str, int i11) {
                super(str, i11);
            }

            @Override // com.applovin.exoplayer2.common.base.Predicate
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* JADX INFO: compiled from: source.java */
        public final enum c extends h {
            public c(String str, int i11) {
                super(str, i11);
            }

            @Override // com.applovin.exoplayer2.common.base.Predicate
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        /* JADX INFO: compiled from: source.java */
        public final enum d extends h {
            public d(String str, int i11) {
                super(str, i11);
            }

            @Override // com.applovin.exoplayer2.common.base.Predicate
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        private h(String str, int i11) {
            super(str, i11);
        }

        private static /* synthetic */ h[] a() {
            return new h[]{f17214a, f17215b, f17216c, f17217d};
        }

        public static h valueOf(String str) {
            return (h) Enum.valueOf(h.class, str);
        }

        public static h[] values() {
            return (h[]) f17218f.clone();
        }

        public Predicate b() {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f17219a;

        private i(List list) {
            this.f17219a = list;
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            for (int i11 = 0; i11 < this.f17219a.size(); i11++) {
                if (((Predicate) this.f17219a.get(i11)).apply(obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof i) {
                return this.f17219a.equals(((i) obj).f17219a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17219a.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.toStringHelper("or", this.f17219a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f17220a;

        private j(Class cls) {
            this.f17220a = (Class) Preconditions.checkNotNull(cls);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Class cls) {
            return this.f17220a.isAssignableFrom(cls);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            return (obj instanceof j) && this.f17220a == ((j) obj).f17220a;
        }

        public int hashCode() {
            return this.f17220a.hashCode();
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.f17220a.getName() + ")";
        }
    }

    private Predicates() {
    }

    public static <T> Predicate<T> alwaysFalse() {
        return h.f17215b.b();
    }

    public static <T> Predicate<T> alwaysTrue() {
        return h.f17214a.b();
    }

    public static <T> Predicate<T> and(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new b(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> iterable) {
        return new b(defensiveCopy(iterable));
    }

    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<? super T>... predicateArr) {
        return new b(defensiveCopy(predicateArr));
    }

    private static <T> List<Predicate<? super T>> asList(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return Arrays.asList(predicate, predicate2);
    }

    public static <A, B> Predicate<A> compose(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new c(predicate, function);
    }

    public static <T> List<T> defensiveCopy(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Preconditions.checkNotNull(it.next()));
        }
        return arrayList;
    }

    private static <T> List<T> defensiveCopy(T... tArr) {
        return defensiveCopy(Arrays.asList(tArr));
    }

    public static <T> Predicate<T> equalTo(@NullableDecl T t11) {
        return t11 == null ? isNull() : new f(t11);
    }

    public static <T> Predicate<T> in(Collection<? extends T> collection) {
        return new d(collection);
    }

    public static Predicate<Object> instanceOf(Class<?> cls) {
        return new e(cls);
    }

    public static <T> Predicate<T> isNull() {
        return h.f17216c.b();
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return new g(predicate);
    }

    public static <T> Predicate<T> notNull() {
        return h.f17217d.b();
    }

    public static <T> Predicate<T> or(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new i(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> iterable) {
        return new i(defensiveCopy(iterable));
    }

    @SafeVarargs
    public static <T> Predicate<T> or(Predicate<? super T>... predicateArr) {
        return new i(defensiveCopy(predicateArr));
    }

    public static Predicate<Class<?>> subtypeOf(Class<?> cls) {
        return new j(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String toStringHelper(String str, Iterable<?> iterable) {
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
