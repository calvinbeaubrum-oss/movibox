package com.applovin.exoplayer2.common.base;

import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;

    @MonotonicNonNullDecl
    private transient Converter<B, A> reverse;

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f17187a;

        /* JADX INFO: renamed from: com.applovin.exoplayer2.common.base.Converter$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0169a implements Iterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Iterator f17189a;

            public C0169a() {
                this.f17189a = a.this.f17187a.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f17189a.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public Object next() {
                return Converter.this.convert(this.f17189a.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f17189a.remove();
            }
        }

        public a(Iterable iterable) {
            this.f17187a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C0169a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends Converter implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Converter f17191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Converter f17192b;

        public b(Converter converter, Converter converter2) {
            this.f17191a = converter;
            this.f17192b = converter2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object correctedDoBackward(Object obj) {
            return this.f17191a.correctedDoBackward(this.f17192b.correctedDoBackward(obj));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object correctedDoForward(Object obj) {
            return this.f17192b.correctedDoForward(this.f17191a.correctedDoForward(obj));
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object doBackward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object doForward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.applovin.exoplayer2.common.base.Converter, com.applovin.exoplayer2.common.base.Function
        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f17191a.equals(bVar.f17191a) && this.f17192b.equals(bVar.f17192b);
        }

        public int hashCode() {
            return (this.f17191a.hashCode() * 31) + this.f17192b.hashCode();
        }

        public String toString() {
            return this.f17191a + ".andThen(" + this.f17192b + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends Converter implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f17193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function f17194b;

        private c(Function function, Function function2) {
            this.f17193a = (Function) Preconditions.checkNotNull(function);
            this.f17194b = (Function) Preconditions.checkNotNull(function2);
        }

        public /* synthetic */ c(Function function, Function function2, a aVar) {
            this(function, function2);
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object doBackward(Object obj) {
            return this.f17194b.apply(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object doForward(Object obj) {
            return this.f17193a.apply(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Converter, com.applovin.exoplayer2.common.base.Function
        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f17193a.equals(cVar.f17193a) && this.f17194b.equals(cVar.f17194b);
        }

        public int hashCode() {
            return (this.f17193a.hashCode() * 31) + this.f17194b.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.f17193a + ", " + this.f17194b + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends Converter implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f17195a = new d();

        private d() {
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Converter doAndThen(Converter converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object doBackward(Object obj) {
            return obj;
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object doForward(Object obj) {
            return obj;
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public d reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends Converter implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Converter f17196a;

        public e(Converter converter) {
            this.f17196a = converter;
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object correctedDoBackward(Object obj) {
            return this.f17196a.correctedDoForward(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object correctedDoForward(Object obj) {
            return this.f17196a.correctedDoBackward(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object doBackward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Object doForward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.applovin.exoplayer2.common.base.Converter, com.applovin.exoplayer2.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return this.f17196a.equals(((e) obj).f17196a);
            }
            return false;
        }

        public int hashCode() {
            return ~this.f17196a.hashCode();
        }

        @Override // com.applovin.exoplayer2.common.base.Converter
        public Converter reverse() {
            return this.f17196a;
        }

        public String toString() {
            return this.f17196a + ".reverse()";
        }
    }

    public Converter() {
        this(true);
    }

    public Converter(boolean z11) {
        this.handleNullAutomatically = z11;
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new c(function, function2, null);
    }

    public static <T> Converter<T, T> identity() {
        return d.f17195a;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // com.applovin.exoplayer2.common.base.Function
    @NullableDecl
    @Deprecated
    public final B apply(@NullableDecl A a11) {
        return convert(a11);
    }

    @NullableDecl
    public final B convert(@NullableDecl A a11) {
        return correctedDoForward(a11);
    }

    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new a(iterable);
    }

    @NullableDecl
    public A correctedDoBackward(@NullableDecl B b11) {
        if (!this.handleNullAutomatically) {
            return doBackward(b11);
        }
        if (b11 == null) {
            return null;
        }
        return (A) Preconditions.checkNotNull(doBackward(b11));
    }

    @NullableDecl
    public B correctedDoForward(@NullableDecl A a11) {
        if (!this.handleNullAutomatically) {
            return doForward(a11);
        }
        if (a11 == null) {
            return null;
        }
        return (B) Preconditions.checkNotNull(doForward(a11));
    }

    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new b(this, (Converter) Preconditions.checkNotNull(converter));
    }

    public abstract A doBackward(B b11);

    public abstract B doForward(A a11);

    @Override // com.applovin.exoplayer2.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        e eVar = new e(this);
        this.reverse = eVar;
        return eVar;
    }
}
