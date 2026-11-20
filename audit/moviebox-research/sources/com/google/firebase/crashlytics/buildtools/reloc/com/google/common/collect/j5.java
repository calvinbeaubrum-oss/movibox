package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class j5 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public static class a<T> extends m2<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f39704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n f39705c;

        public a(Iterable iterable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n nVar) {
            this.f39704b = iterable;
            this.f39705c = nVar;
        }

        public static /* synthetic */ void o(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n nVar, Consumer consumer, Object obj) {
            if (nVar.test(obj)) {
                consumer.accept(obj);
            }
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> consumer) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
            Iterable iterable = this.f39704b;
            final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n nVar = this.f39705c;
            iterable.forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.i5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    j5.a.o(nVar, consumer, obj);
                }
            });
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.k(this.f39704b.iterator(), this.f39705c);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return x1.a(this.f39704b.spliterator(), this.f39705c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public static class b<T> extends m2<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f39706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d f39707c;

        public b(Iterable iterable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d dVar) {
            this.f39706b = iterable;
            this.f39707c = dVar;
        }

        public static /* synthetic */ void o(Consumer consumer, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d dVar, Object obj) {
            consumer.accept(dVar.apply(obj));
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> consumer) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
            Iterable iterable = this.f39706b;
            final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d dVar = this.f39707c;
            iterable.forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.k5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    j5.b.o(consumer, dVar, obj);
                }
            });
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.y(this.f39706b.iterator(), this.f39707c);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return x1.e(this.f39706b.spliterator(), this.f39707c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public static class c<T> extends m2<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f39708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f39709c;

        /* JADX INFO: compiled from: source.java */
        public class a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f39710a = true;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Iterator f39711b;

            public a(Iterator it) {
                this.f39711b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f39711b.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                T t11 = (T) this.f39711b.next();
                this.f39710a = false;
                return t11;
            }

            @Override // java.util.Iterator
            public void remove() {
                n1.e(!this.f39710a);
                this.f39711b.remove();
            }
        }

        public c(Iterable iterable, int i11) {
            this.f39708b = iterable;
            this.f39709c = i11;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f39708b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.f39709c), list.size()).iterator();
            }
            Iterator<T> it = iterable.iterator();
            Iterators.b(it, this.f39709c);
            return new a(it);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            Iterable iterable = this.f39708b;
            if (!(iterable instanceof List)) {
                return o7.a(iterable).skip(this.f39709c).spliterator();
            }
            List list = (List) iterable;
            return list.subList(Math.min(list.size(), this.f39709c), list.size()).spliterator();
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        return iterable instanceof Collection ? collection.addAll(j2.a(iterable)) : Iterators.a(collection, ((Iterable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(iterable)).iterator());
    }

    public static <E> Collection<E> b(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.j(iterable.iterator());
    }

    public static <T> Iterable<T> c(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return m2.a(iterable, iterable2);
    }

    public static <T> Iterable<T> d(Iterable<T> iterable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n<? super T> nVar) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(iterable);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(nVar);
        return new a(iterable, nVar);
    }

    public static <T> T e(Iterable<? extends T> iterable, T t11) {
        return (T) Iterators.o(iterable.iterator(), t11);
    }

    public static <T> T f(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) Iterators.n(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) g(list);
    }

    public static <T> T g(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T h(Iterable<T> iterable) {
        return (T) Iterators.p(iterable.iterator());
    }

    public static boolean i(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> j(Iterable<T> iterable, int i11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(iterable);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e(i11 >= 0, "number to skip cannot be negative");
        return new c(iterable, i11);
    }

    public static Object[] k(Iterable<?> iterable) {
        return b(iterable).toArray();
    }

    public static <T> T[] l(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) b(iterable).toArray(tArr);
    }

    public static String m(Iterable<?> iterable) {
        return Iterators.x(iterable.iterator());
    }

    public static <F, T> Iterable<T> n(Iterable<F> iterable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super F, ? extends T> dVar) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(iterable);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(dVar);
        return new b(iterable, dVar);
    }
}
