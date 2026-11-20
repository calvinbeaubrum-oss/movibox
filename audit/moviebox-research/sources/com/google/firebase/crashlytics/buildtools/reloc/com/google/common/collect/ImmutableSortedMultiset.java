package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements g7<E> {
    transient ImmutableSortedMultiset<E> descendingMultiset;

    /* JADX INFO: compiled from: source.java */
    public static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        public SerializedForm(g7<E> g7Var) {
            this.comparator = g7Var.comparator();
            int size = g7Var.entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i11 = 0;
            for (l6.a<E> aVar : g7Var.entrySet()) {
                this.elements[i11] = aVar.getElement();
                this.counts[i11] = aVar.getCount();
                i11++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            a aVar = new a(this.comparator);
            for (int i11 = 0; i11 < length; i11++) {
                aVar.m(this.elements[i11], this.counts[i11]);
            }
            return aVar.i();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a<E> extends ImmutableMultiset.b<E> {
        public a(Comparator<? super E> comparator) {
            super(TreeMultiset.create((Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator)));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset.b
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e11) {
            super.a(e11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset.b
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public a<E> f(E... eArr) {
            super.f(eArr);
            return this;
        }

        public a<E> l(Iterator<? extends E> it) {
            super.g(it);
            return this;
        }

        public a<E> m(E e11, int i11) {
            super.h(e11, i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset.b
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMultiset<E> i() {
            return ImmutableSortedMultiset.copyOfSorted((g7) this.f39366a);
        }
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        ArrayList arrayListI = Lists.i(iterable);
        TreeMultiset treeMultisetCreate = TreeMultiset.create((Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator));
        j5.a(treeMultisetCreate, arrayListI);
        return copyOfSortedEntries(comparator, treeMultisetCreate.entrySet());
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
        return new a(comparator).l(it).i();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(Ordering.natural(), Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(g7<E> g7Var) {
        return copyOfSortedEntries(g7Var.comparator(), Lists.i(g7Var.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<l6.a<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.b bVar = new ImmutableList.b(collection.size());
        long[] jArr = new long[collection.size() + 1];
        int i11 = 0;
        for (l6.a<E> aVar : collection) {
            bVar.a(aVar.getElement());
            int i12 = i11 + 1;
            jArr[i12] = jArr[i11] + ((long) aVar.getCount());
            i11 = i12;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(bVar.h(), comparator), jArr, 0, collection.size());
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        return Ordering.natural().equals(comparator) ? (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET : new RegularImmutableSortedMultiset(comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$toImmutableSortedMultiset$0(Object obj) {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$toImmutableSortedMultiset$2(Function function, ToIntFunction toIntFunction, l6 l6Var, Object obj) {
        l6Var.add(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function.apply(obj)), toIntFunction.applyAsInt(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l6 lambda$toImmutableSortedMultiset$3(l6 l6Var, l6 l6Var2) {
        l6Var.addAll(l6Var2);
        return l6Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableSortedMultiset lambda$toImmutableSortedMultiset$4(Comparator comparator, l6 l6Var) {
        return copyOfSortedEntries(comparator, l6Var.entrySet());
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(comparable), new long[]{0, 1}, 0, 1);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/firebase/crashlytics/buildtools/reloc/com/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList arrayListK = Lists.k(comparableArr.length + 6);
        Collections.addAll(arrayListK, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(arrayListK, comparableArr);
        return copyOf(Ordering.natural(), arrayListK);
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(Ordering.natural().reverse());
    }

    public static <E> Collector<E, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(Comparator<? super E> comparator) {
        return toImmutableSortedMultiset(comparator, Function.identity(), new ToIntFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v4
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ImmutableSortedMultiset.lambda$toImmutableSortedMultiset$0(obj);
            }
        });
    }

    public static <T, E> Collector<T, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(final Comparator<? super E> comparator, final Function<? super T, ? extends E> function, final ToIntFunction<? super T> toIntFunction) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(toIntFunction);
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r4
            @Override // java.util.function.Supplier
            public final Object get() {
                return TreeMultiset.create(comparator);
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ImmutableSortedMultiset.lambda$toImmutableSortedMultiset$2(function, toIntFunction, (l6) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ImmutableSortedMultiset.lambda$toImmutableSortedMultiset$3((l6) obj, (l6) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.u4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableSortedMultiset.lambda$toImmutableSortedMultiset$4(comparator, (l6) obj);
            }
        }, new Collector.Characteristics[0]);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.e7
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public abstract /* synthetic */ int count(Object obj);

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultisetEmptyMultiset = this.descendingMultiset;
        if (immutableSortedMultisetEmptyMultiset == null) {
            immutableSortedMultisetEmptyMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultisetEmptyMultiset;
        }
        return immutableSortedMultisetEmptyMultiset;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract /* synthetic */ l6.a firstEntry();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        k6.b(this, objIntConsumer);
    }

    public abstract ImmutableSortedMultiset<E> headMultiset(E e11, BoundType boundType);

    public abstract /* synthetic */ l6.a lastEntry();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    @Deprecated
    public final l6.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    @Deprecated
    public final l6.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public ImmutableSortedMultiset<E> subMultiset(E e11, BoundType boundType, E e12, BoundType boundType2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.k(comparator().compare(e11, e12) <= 0, "Expected lowerBound <= upperBound but %s > %s", e11, e12);
        return tailMultiset((Object) e11, boundType).headMultiset((Object) e12, boundType2);
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e11, BoundType boundType);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
