package com.google.common.collect;

import com.google.common.base.Optional;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class q<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Optional<Iterable<E>> f38726a;

    /* JADX INFO: compiled from: source.java */
    public class a extends q<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f38727b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f38727b = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f38727b.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public class b<T> extends q<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable[] f38728b;

        /* JADX INFO: compiled from: source.java */
        public class a extends com.google.common.collect.a<Iterator<? extends T>> {
            public a(int i11) {
                super(i11);
            }

            @Override // com.google.common.collect.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Iterator<? extends T> a(int i11) {
                return b.this.f38728b[i11].iterator();
            }
        }

        public b(Iterable[] iterableArr) {
            this.f38728b = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.f(new a(this.f38728b.length));
        }
    }

    public q() {
        this.f38726a = Optional.absent();
    }

    public q(Iterable<E> iterable) {
        this.f38726a = Optional.of(iterable);
    }

    public static <T> q<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return b(iterable, iterable2);
    }

    public static <T> q<T> b(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            com.google.common.base.m.p(iterable);
        }
        return new b(iterableArr);
    }

    public static <E> q<E> f(Iterable<E> iterable) {
        return iterable instanceof q ? (q) iterable : new a(iterable, iterable);
    }

    public final q<E> e(com.google.common.base.n<? super E> nVar) {
        return f(e0.e(g(), nVar));
    }

    public final Iterable<E> g() {
        return this.f38726a.or(this);
    }

    public final ImmutableSet<E> i() {
        return ImmutableSet.copyOf(g());
    }

    public String toString() {
        return e0.r(g());
    }
}
