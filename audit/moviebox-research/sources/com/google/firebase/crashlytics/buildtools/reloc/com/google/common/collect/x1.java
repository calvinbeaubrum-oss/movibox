package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class x1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public static class a<T> implements Spliterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Spliterator f39795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function f39796b;

        public a(Spliterator spliterator, Function function) {
            this.f39795a = spliterator;
            this.f39796b = function;
        }

        public static /* synthetic */ void c(Consumer consumer, Function function, Object obj) {
            consumer.accept(function.apply(obj));
        }

        public static /* synthetic */ void d(Consumer consumer, Function function, Object obj) {
            consumer.accept(function.apply(obj));
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f39795a.characteristics() & (-262);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f39795a.estimateSize();
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> consumer) {
            Spliterator spliterator = this.f39795a;
            final Function function = this.f39796b;
            spliterator.forEachRemaining(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.w1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    x1.a.c(consumer, function, obj);
                }
            });
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            Spliterator spliterator = this.f39795a;
            final Function function = this.f39796b;
            return spliterator.tryAdvance(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    x1.a.d(consumer, function, obj);
                }
            });
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator spliteratorTrySplit = this.f39795a.trySplit();
            if (spliteratorTrySplit != null) {
                return x1.e(spliteratorTrySplit, this.f39796b);
            }
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public class b<T> implements Spliterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Spliterator<T> f39797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Spliterator<F> f39798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f39799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f39800d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function f39801e;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0000: IPUT 
  (r6 I:java.util.function.Function)
  (r0 I:com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x1$b)
 com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x1.b.e java.util.function.Function, block:B:2:0x0000 */
        public b(Spliterator spliterator, Spliterator<T> spliterator2, Spliterator<F> spliterator3, int i11, long j11) {
            Function function;
            this.f39801e = function;
            this.f39797a = spliterator;
            this.f39798b = spliterator2;
            this.f39799c = spliterator3;
            this.f39800d = i11;
        }

        public static /* synthetic */ void c(Function function, Consumer consumer, Object obj) {
            y1.a(function.apply(obj)).forEachRemaining(consumer);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f39799c;
        }

        public final /* synthetic */ void d(Function function, Object obj) {
            this.f39797a = y1.a(function.apply(obj));
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            Spliterator<T> spliterator = this.f39797a;
            if (spliterator != null) {
                this.f39800d = Math.max(this.f39800d, spliterator.estimateSize());
            }
            return Math.max(this.f39800d, 0L);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> consumer) {
            Spliterator<T> spliterator = this.f39797a;
            if (spliterator != null) {
                spliterator.forEachRemaining(consumer);
                this.f39797a = null;
            }
            Spliterator<F> spliterator2 = this.f39798b;
            final Function function = this.f39801e;
            spliterator2.forEachRemaining(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    x1.b.c(function, consumer, obj);
                }
            });
            this.f39800d = 0L;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            Spliterator<F> spliterator;
            final Function function;
            do {
                Spliterator<T> spliterator2 = this.f39797a;
                if (spliterator2 != null && spliterator2.tryAdvance(consumer)) {
                    long j11 = this.f39800d;
                    if (j11 == Long.MAX_VALUE) {
                        return true;
                    }
                    this.f39800d = j11 - 1;
                    return true;
                }
                this.f39797a = null;
                spliterator = this.f39798b;
                function = this.f39801e;
            } while (spliterator.tryAdvance(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.a2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f39667a.d(function, obj);
                }
            }));
            return false;
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator spliteratorTrySplit = this.f39798b.trySplit();
            if (spliteratorTrySplit == null) {
                Spliterator<T> spliterator = this.f39797a;
                if (spliterator == null) {
                    return null;
                }
                this.f39797a = null;
                return spliterator;
            }
            int i11 = this.f39799c & (-65);
            long jEstimateSize = estimateSize();
            if (jEstimateSize < Long.MAX_VALUE) {
                jEstimateSize /= 2;
                this.f39800d -= jEstimateSize;
                this.f39799c = i11;
            }
            b bVar = new b(this.f39797a, spliteratorTrySplit, i11, jEstimateSize, this.f39801e);
            this.f39797a = null;
            return bVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public class c<T> implements Spliterator<T>, Consumer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f39802a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Spliterator f39803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Predicate f39804c;

        public c(Spliterator spliterator, Predicate predicate) {
            this.f39803b = spliterator;
            this.f39804c = predicate;
        }

        @Override // java.util.function.Consumer
        public void accept(T t11) {
            this.f39802a = t11;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f39803b.characteristics() & 277;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f39803b.estimateSize() / 2;
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            return this.f39803b.getComparator();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            while (this.f39803b.tryAdvance(this)) {
                try {
                    if (this.f39804c.test(this.f39802a)) {
                        consumer.accept(this.f39802a);
                        this.f39802a = null;
                        return true;
                    }
                    this.f39802a = null;
                } catch (Throwable th2) {
                    this.f39802a = null;
                    throw th2;
                }
            }
            return false;
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator spliteratorTrySplit = this.f39803b.trySplit();
            if (spliteratorTrySplit == null) {
                return null;
            }
            return x1.a(spliteratorTrySplit, this.f39804c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public class d<T> implements Spliterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Spliterator.OfInt f39805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IntFunction f39806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f39807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Comparator f39808d;

        public d(Spliterator.OfInt ofInt, IntFunction intFunction, int i11, Comparator comparator) {
            this.f39806b = intFunction;
            this.f39807c = i11;
            this.f39808d = comparator;
            this.f39805a = ofInt;
        }

        public static /* synthetic */ void c(Consumer consumer, IntFunction intFunction, int i11) {
            consumer.accept(intFunction.apply(i11));
        }

        public static /* synthetic */ void d(Consumer consumer, IntFunction intFunction, int i11) {
            consumer.accept(intFunction.apply(i11));
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f39807c | 16464;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f39805a.estimateSize();
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> consumer) {
            Spliterator.OfInt ofInt = this.f39805a;
            final IntFunction intFunction = this.f39806b;
            ofInt.forEachRemaining(new IntConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.h2
                @Override // java.util.function.IntConsumer
                public final void accept(int i11) {
                    x1.d.c(consumer, intFunction, i11);
                }
            });
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            if (hasCharacteristics(4)) {
                return this.f39808d;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            Spliterator.OfInt ofInt = this.f39805a;
            final IntFunction intFunction = this.f39806b;
            return ofInt.tryAdvance(new IntConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.i2
                @Override // java.util.function.IntConsumer
                public final void accept(int i11) {
                    x1.d.d(consumer, intFunction, i11);
                }
            });
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator.OfInt ofIntTrySplit = this.f39805a.trySplit();
            if (ofIntTrySplit == null) {
                return null;
            }
            return new d(ofIntTrySplit, this.f39806b, this.f39807c, this.f39808d);
        }
    }

    public static <T> Spliterator<T> a(Spliterator<T> spliterator, Predicate<? super T> predicate) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(spliterator);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(predicate);
        return new c(spliterator, predicate);
    }

    public static <F, T> Spliterator<T> b(Spliterator<F> spliterator, Function<? super F, Spliterator<T>> function, int i11, long j11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e((i11 & 16384) == 0, "flatMap does not support SUBSIZED characteristic");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e((i11 & 4) == 0, "flatMap does not support SORTED characteristic");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(spliterator);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        return new b(null, spliterator, i11, j11, function);
    }

    public static <T> Spliterator<T> c(int i11, int i12, IntFunction<T> intFunction) {
        return d(i11, i12, intFunction, null);
    }

    public static <T> Spliterator<T> d(int i11, int i12, IntFunction<T> intFunction, Comparator<? super T> comparator) {
        if (comparator != null) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d((i12 & 4) != 0);
        }
        return new d(IntStream.range(0, i11).spliterator(), intFunction, i12, comparator);
    }

    public static <F, T> Spliterator<T> e(Spliterator<F> spliterator, Function<? super F, ? extends T> function) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(spliterator);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        return new a(spliterator, function);
    }
}
