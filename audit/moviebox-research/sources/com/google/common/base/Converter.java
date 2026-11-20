package com.google.common.base;

import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Converter<A, B> implements f<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RetainedWith
    public transient Converter<B, A> f38142a;
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

        @Override // com.google.common.base.Converter
        public A correctedDoBackward(C c11) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(c11));
        }

        @Override // com.google.common.base.Converter
        public C correctedDoForward(A a11) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(a11));
        }

        @Override // com.google.common.base.Converter
        public A doBackward(C c11) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public C doForward(A a11) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.f
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
        private final f<? super B, ? extends A> backwardFunction;
        private final f<? super A, ? extends B> forwardFunction;

        public FunctionBasedConverter(f<? super A, ? extends B> fVar, f<? super B, ? extends A> fVar2) {
            this.forwardFunction = (f) m.p(fVar);
            this.backwardFunction = (f) m.p(fVar2);
        }

        public /* synthetic */ FunctionBasedConverter(f fVar, f fVar2, a aVar) {
            this(fVar, fVar2);
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b11) {
            return this.backwardFunction.apply(b11);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a11) {
            return this.forwardFunction.apply(a11);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.f
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
        static final IdentityConverter<?> INSTANCE = new IdentityConverter<>();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) m.q(converter, "otherConverter");
        }

        @Override // com.google.common.base.Converter
        public T doBackward(T t11) {
            return t11;
        }

        @Override // com.google.common.base.Converter
        public T doForward(T t11) {
            return t11;
        }

        @Override // com.google.common.base.Converter
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

        @Override // com.google.common.base.Converter
        public B correctedDoBackward(A a11) {
            return this.original.correctedDoForward(a11);
        }

        @Override // com.google.common.base.Converter
        public A correctedDoForward(B b11) {
            return this.original.correctedDoBackward(b11);
        }

        @Override // com.google.common.base.Converter
        public B doBackward(A a11) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public A doForward(B b11) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.f
        public boolean equals(Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
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
        public final /* synthetic */ Iterable f38143a;

        /* JADX INFO: renamed from: com.google.common.base.Converter$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0387a implements Iterator<B> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator<? extends A> f38145a;

            public C0387a() {
                this.f38145a = a.this.f38143a.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f38145a.hasNext();
            }

            @Override // java.util.Iterator
            public B next() {
                return (B) Converter.this.convert(this.f38145a.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f38145a.remove();
            }
        }

        public a(Iterable iterable) {
            this.f38143a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<B> iterator() {
            return new C0387a();
        }
    }

    public Converter() {
        this(true);
    }

    public Converter(boolean z11) {
        this.handleNullAutomatically = z11;
    }

    public static <A, B> Converter<A, B> from(f<? super A, ? extends B> fVar, f<? super B, ? extends A> fVar2) {
        return new FunctionBasedConverter(fVar, fVar2, null);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final A a(B b11) {
        return (A) doBackward(i.a(b11));
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // com.google.common.base.f
    @Deprecated
    public final B apply(A a11) {
        return convert(a11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final B b(A a11) {
        return (B) doForward(i.a(a11));
    }

    public final B convert(A a11) {
        return correctedDoForward(a11);
    }

    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        m.q(iterable, "fromIterable");
        return new a(iterable);
    }

    public A correctedDoBackward(B b11) {
        if (!this.handleNullAutomatically) {
            return a(b11);
        }
        if (b11 == null) {
            return null;
        }
        return (A) m.p(doBackward(b11));
    }

    public B correctedDoForward(A a11) {
        if (!this.handleNullAutomatically) {
            return b(a11);
        }
        if (a11 == null) {
            return null;
        }
        return (B) m.p(doForward(a11));
    }

    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) m.p(converter));
    }

    public abstract A doBackward(B b11);

    public abstract B doForward(A a11);

    @Override // com.google.common.base.f
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.f38142a;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.f38142a = reverseConverter;
        return reverseConverter;
    }
}
