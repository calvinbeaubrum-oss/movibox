package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: compiled from: source.java */
    public static class a implements Iterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f39037a;

        /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0406a extends AbstractIterator<T> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<? extends Optional<? extends T>> f39038c;

            public C0406a() {
                this.f39038c = (Iterator) l.n(a.this.f39037a.iterator());
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.AbstractIterator
            public T a() {
                while (this.f39038c.hasNext()) {
                    Optional<? extends T> next = this.f39038c.next();
                    if (next.isPresent()) {
                        return next.get();
                    }
                }
                return b();
            }
        }

        public a(Iterable iterable) {
            this.f39037a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C0406a();
        }
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromJavaUtil(java.util.Optional<T> optional) {
        if (optional == null) {
            return null;
        }
        return fromNullable(optional.orElse(null));
    }

    public static <T> Optional<T> fromNullable(T t11) {
        return t11 == null ? absent() : new Present(t11);
    }

    public static <T> Optional<T> of(T t11) {
        return new Present(l.n(t11));
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        l.n(iterable);
        return new a(iterable);
    }

    public static <T> java.util.Optional<T> toJavaUtil(Optional<T> optional) {
        if (optional == null) {
            return null;
        }
        return optional.toJavaUtil();
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

    public java.util.Optional<T> toJavaUtil() {
        return java.util.Optional.ofNullable(orNull());
    }

    public abstract String toString();

    public abstract <V> Optional<V> transform(d<? super T, V> dVar);
}
