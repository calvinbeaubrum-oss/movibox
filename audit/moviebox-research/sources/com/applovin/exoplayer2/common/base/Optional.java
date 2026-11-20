package com.applovin.exoplayer2.common.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f17204a;

        /* JADX INFO: renamed from: com.applovin.exoplayer2.common.base.Optional$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0170a extends b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Iterator f17205c;

            public C0170a() {
                this.f17205c = (Iterator) Preconditions.checkNotNull(a.this.f17204a.iterator());
            }

            @Override // com.applovin.exoplayer2.common.base.b
            public Object a() {
                while (this.f17205c.hasNext()) {
                    Optional optional = (Optional) this.f17205c.next();
                    if (optional.isPresent()) {
                        return optional.get();
                    }
                }
                return b();
            }
        }

        public a(Iterable iterable) {
            this.f17204a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C0170a();
        }
    }

    public static <T> Optional<T> absent() {
        return com.applovin.exoplayer2.common.base.a.a();
    }

    public static <T> Optional<T> fromNullable(@NullableDecl T t11) {
        return t11 == null ? absent() : new d(t11);
    }

    public static <T> Optional<T> of(T t11) {
        return new d(Preconditions.checkNotNull(t11));
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@NullableDecl Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T t11);

    @NullableDecl
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);
}
