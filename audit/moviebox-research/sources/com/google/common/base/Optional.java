package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f38147a;

        /* JADX INFO: renamed from: com.google.common.base.Optional$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0388a extends AbstractIterator<T> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<? extends Optional<? extends T>> f38148c;

            public C0388a() {
                this.f38148c = (Iterator) m.p(a.this.f38147a.iterator());
            }

            @Override // com.google.common.base.AbstractIterator
            public T a() {
                while (this.f38148c.hasNext()) {
                    Optional<? extends T> next = this.f38148c.next();
                    if (next.isPresent()) {
                        return next.get();
                    }
                }
                return b();
            }
        }

        public a(Iterable iterable) {
            this.f38147a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C0388a();
        }
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(T t11) {
        return t11 == null ? absent() : new Present(t11);
    }

    public static <T> Optional<T> of(T t11) {
        return new Present(m.p(t11));
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        m.p(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(q<? extends T> qVar);

    public abstract T or(T t11);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(f<? super T, V> fVar);
}
