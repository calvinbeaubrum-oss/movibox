package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public class a<T> extends q<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f38688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.n f38689c;

        public a(Iterable iterable, com.google.common.base.n nVar) {
            this.f38688b = iterable;
            this.f38689c = nVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.l(this.f38688b.iterator(), this.f38689c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public class b<T> extends q<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f38690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.f f38691c;

        public b(Iterable iterable, com.google.common.base.f fVar) {
            this.f38690b = iterable;
            this.f38691c = fVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.B(this.f38690b.iterator(), this.f38691c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public class c<T> extends q<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f38692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f38693c;

        /* JADX INFO: compiled from: source.java */
        public class a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f38694a = true;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Iterator f38695b;

            public a(c cVar, Iterator it) {
                this.f38695b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f38695b.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                T t11 = (T) this.f38695b.next();
                this.f38694a = false;
                return t11;
            }

            @Override // java.util.Iterator
            public void remove() {
                l.e(!this.f38694a);
                this.f38695b.remove();
            }
        }

        public c(Iterable iterable, int i11) {
            this.f38692b = iterable;
            this.f38693c = i11;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f38692b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.f38693c), list.size()).iterator();
            }
            Iterator<T> it = iterable.iterator();
            Iterators.b(it, this.f38693c);
            return new a(this, it);
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        return iterable instanceof Collection ? collection.addAll((Collection) iterable) : Iterators.a(collection, ((Iterable) com.google.common.base.m.p(iterable)).iterator());
    }

    public static <T> boolean b(Iterable<T> iterable, com.google.common.base.n<? super T> nVar) {
        return Iterators.c(iterable.iterator(), nVar);
    }

    public static <E> Collection<E> c(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.k(iterable.iterator());
    }

    public static <T> Iterable<T> d(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return q.a(iterable, iterable2);
    }

    public static <T> Iterable<T> e(Iterable<T> iterable, com.google.common.base.n<? super T> nVar) {
        com.google.common.base.m.p(iterable);
        com.google.common.base.m.p(nVar);
        return new a(iterable, nVar);
    }

    public static <T> T f(Iterable<? extends T> iterable, T t11) {
        return (T) Iterators.p(iterable.iterator(), t11);
    }

    public static <T> T g(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) Iterators.n(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) i(list);
    }

    public static <T> T h(Iterable<? extends T> iterable, T t11) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t11;
            }
            if (iterable instanceof List) {
                return (T) i(Lists.b(iterable));
            }
        }
        return (T) Iterators.o(iterable.iterator(), t11);
    }

    public static <T> T i(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T j(Iterable<T> iterable) {
        return (T) Iterators.q(iterable.iterator());
    }

    public static boolean k(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static <T> boolean l(Iterable<T> iterable, com.google.common.base.n<? super T> nVar) {
        return ((iterable instanceof RandomAccess) && (iterable instanceof List)) ? m((List) iterable, (com.google.common.base.n) com.google.common.base.m.p(nVar)) : Iterators.w(iterable.iterator(), nVar);
    }

    public static <T> boolean m(List<T> list, com.google.common.base.n<? super T> nVar) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < list.size()) {
            T t11 = list.get(i11);
            if (!nVar.apply(t11)) {
                if (i11 > i12) {
                    try {
                        list.set(i12, t11);
                    } catch (IllegalArgumentException unused) {
                        o(list, nVar, i12, i11);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        o(list, nVar, i12, i11);
                        return true;
                    }
                }
                i12++;
            }
            i11++;
        }
        list.subList(i12, list.size()).clear();
        return i11 != i12;
    }

    public static <T> Iterable<T> n(Iterable<T> iterable, int i11) {
        com.google.common.base.m.p(iterable);
        com.google.common.base.m.e(i11 >= 0, "number to skip cannot be negative");
        return new c(iterable, i11);
    }

    public static <T> void o(List<T> list, com.google.common.base.n<? super T> nVar, int i11, int i12) {
        for (int size = list.size() - 1; size > i12; size--) {
            if (nVar.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            list.remove(i13);
        }
    }

    public static Object[] p(Iterable<?> iterable) {
        return c(iterable).toArray();
    }

    public static <T> T[] q(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) c(iterable).toArray(tArr);
    }

    public static String r(Iterable<?> iterable) {
        return Iterators.A(iterable.iterator());
    }

    public static <F, T> Iterable<T> s(Iterable<F> iterable, com.google.common.base.f<? super F, ? extends T> fVar) {
        com.google.common.base.m.p(iterable);
        com.google.common.base.m.p(fVar);
        return new b(iterable, fVar);
    }
}
