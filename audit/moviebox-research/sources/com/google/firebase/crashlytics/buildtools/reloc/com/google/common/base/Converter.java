package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Converter<A, B> implements d<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Converter<B, A> f39032a;
    private final boolean handleNullAutomatically;

    /* JADX INFO: compiled from: source.java */
    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        public ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public A correctedDoBackward(C c11) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(c11));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public C correctedDoForward(A a11) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(a11));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public A doBackward(C c11) {
            throw new AssertionError();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public C doForward(A a11) {
            throw new AssertionError();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d
        public boolean equals(Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final d<? super B, ? extends A> backwardFunction;
        private final d<? super A, ? extends B> forwardFunction;

        public FunctionBasedConverter(d<? super A, ? extends B> dVar, d<? super B, ? extends A> dVar2) {
            this.forwardFunction = (d) l.n(dVar);
            this.backwardFunction = (d) l.n(dVar2);
        }

        public /* synthetic */ FunctionBasedConverter(d dVar, d dVar2, a aVar) {
            this(dVar, dVar2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public A doBackward(B b11) {
            return this.backwardFunction.apply(b11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public B doForward(A a11) {
            return this.forwardFunction.apply(a11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d
        public boolean equals(Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter INSTANCE = new IdentityConverter();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) l.o(converter, "otherConverter");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public T doBackward(T t11) {
            return t11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public T doForward(T t11) {
            return t11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        public ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public B correctedDoBackward(A a11) {
            return this.original.correctedDoForward(a11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public A correctedDoForward(B b11) {
            return this.original.correctedDoBackward(b11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public B doBackward(A a11) {
            throw new AssertionError();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public A doForward(B b11) {
            throw new AssertionError();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d
        public boolean equals(Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterable<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f39033a;

        /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0405a implements Iterator<B> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator<? extends A> f39035a;

            public C0405a() {
                this.f39035a = a.this.f39033a.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f39035a.hasNext();
            }

            @Override // java.util.Iterator
            public B next() {
                return (B) Converter.this.convert(this.f39035a.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f39035a.remove();
            }
        }

        public a(Iterable iterable) {
            this.f39033a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<B> iterator() {
            return new C0405a();
        }
    }

    public Converter() {
        this(true);
    }

    public Converter(boolean z11) {
        this.handleNullAutomatically = z11;
    }

    public static <A, B> Converter<A, B> from(d<? super A, ? extends B> dVar, d<? super B, ? extends A> dVar2) {
        return new FunctionBasedConverter(dVar, dVar2, null);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
    @Deprecated
    public final B apply(A a11) {
        return convert(a11);
    }

    public final B convert(A a11) {
        return correctedDoForward(a11);
    }

    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        l.o(iterable, "fromIterable");
        return new a(iterable);
    }

    public A correctedDoBackward(B b11) {
        if (!this.handleNullAutomatically) {
            return doBackward(b11);
        }
        if (b11 == null) {
            return null;
        }
        return (A) l.n(doBackward(b11));
    }

    public B correctedDoForward(A a11) {
        if (!this.handleNullAutomatically) {
            return doForward(a11);
        }
        if (a11 == null) {
            return null;
        }
        return (B) l.n(doForward(a11));
    }

    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) l.n(converter));
    }

    public abstract A doBackward(B b11);

    public abstract B doForward(A a11);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.f39032a;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.f39032a = reverseConverter;
        return reverseConverter;
    }
}
