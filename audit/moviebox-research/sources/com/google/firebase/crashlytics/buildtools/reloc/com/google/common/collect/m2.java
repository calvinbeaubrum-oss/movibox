package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class m2<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Optional<Iterable<E>> f39735a;

    /* JADX INFO: compiled from: source.java */
    public static class a extends m2<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f39736b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f39736b = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f39736b.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public static class b<T> extends m2<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable[] f39737b;

        /* JADX INFO: compiled from: source.java */
        public class a extends c<Iterator<? extends T>> {
            public a(int i11) {
                super(i11);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Iterator<? extends T> a(int i11) {
                return b.this.f39737b[i11].iterator();
            }
        }

        public b(Iterable[] iterableArr) {
            this.f39737b = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.e(new a(this.f39737b.length));
        }
    }

    public m2() {
        this.f39735a = Optional.absent();
    }

    public m2(Iterable<E> iterable) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(iterable);
        this.f39735a = Optional.fromNullable(this == iterable ? null : iterable);
    }

    public static <T> m2<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return b(iterable, iterable2);
    }

    public static <T> m2<T> b(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(iterable);
        }
        return new b(iterableArr);
    }

    public static <E> m2<E> f(Iterable<E> iterable) {
        return iterable instanceof m2 ? (m2) iterable : new a(iterable, iterable);
    }

    public final m2<E> e(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n<? super E> nVar) {
        return f(j5.d(g(), nVar));
    }

    public final Iterable<E> g() {
        return this.f39735a.or(this);
    }

    public final ImmutableSet<E> i() {
        return ImmutableSet.copyOf(g());
    }

    public String toString() {
        return j5.m(g());
    }
}
