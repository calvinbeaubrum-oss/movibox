package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements l6<E> {
    private transient ImmutableList<E> asList;
    private transient ImmutableSet<l6.a<E>> entrySet;

    /* JADX INFO: compiled from: source.java */
    public static final class ElementSet<E> extends ImmutableSet.Indexed<E> {
        private final l6<E> delegate;
        private final List<l6.a<E>> entries;

        public ElementSet(List<l6.a<E>> list, l6<E> l6Var) {
            this.entries = list;
            this.delegate = l6Var;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.delegate.contains(obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet.Indexed
        public E get(int i11) {
            return this.entries.get(i11).getElement();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.entries.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class EntrySet extends IndexedImmutableSet<l6.a<E>> {
        private static final long serialVersionUID = 0;

        public EntrySet() {
        }

        public /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, a aVar) {
            this();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof l6.a)) {
                return false;
            }
            l6.a aVar = (l6.a) obj;
            return aVar.getCount() > 0 && ImmutableMultiset.this.count(aVar.getElement()) == aVar.getCount();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IndexedImmutableSet
        public l6.a<E> get(int i11) {
            return ImmutableMultiset.this.getEntry(i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        public SerializedForm(l6<?> l6Var) {
            int size = l6Var.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i11 = 0;
            for (l6.a<?> aVar : l6Var.entrySet()) {
                this.elements[i11] = aVar.getElement();
                this.counts[i11] = aVar.getCount();
                i11++;
            }
        }

        public Object readResolve() {
            LinkedHashMultiset linkedHashMultisetCreate = LinkedHashMultiset.create(this.elements.length);
            int i11 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i11 >= objArr.length) {
                    return ImmutableMultiset.copyOf(linkedHashMultisetCreate);
                }
                linkedHashMultisetCreate.add(objArr[i11], this.counts[i11]);
                i11++;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends t7<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f39362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public E f39363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f39364c;

        public a(Iterator it) {
            this.f39364c = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39362a > 0 || this.f39364c.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f39362a <= 0) {
                l6.a aVar = (l6.a) this.f39364c.next();
                this.f39363b = (E) aVar.getElement();
                this.f39362a = aVar.getCount();
            }
            this.f39362a--;
            return this.f39363b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b<E> extends ImmutableCollection.a<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l6<E> f39366a;

        public b() {
            this(LinkedHashMultiset.create());
        }

        public b(l6<E> l6Var) {
            this.f39366a = l6Var;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public b<E> a(E e11) {
            this.f39366a.add((E) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11));
            return this;
        }

        public b<E> f(E... eArr) {
            super.b(eArr);
            return this;
        }

        public b<E> g(Iterator<? extends E> it) {
            super.c(it);
            return this;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public b<E> h(E e11, int i11) {
            this.f39366a.add((E) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11), i11);
            return this;
        }

        public ImmutableMultiset<E> i() {
            return ImmutableMultiset.copyOf(this.f39366a);
        }
    }

    public static <E> b<E> builder() {
        return new b<>();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        LinkedHashMultiset linkedHashMultisetCreate = LinkedHashMultiset.create();
        Collections.addAll(linkedHashMultisetCreate, eArr);
        return copyFromEntries(linkedHashMultisetCreate.entrySet());
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends l6.a<? extends E>> collection) {
        return collection.isEmpty() ? of() : RegularImmutableMultiset.create(collection);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        return copyFromEntries((iterable instanceof l6 ? Multisets.d(iterable) : LinkedHashMultiset.create(iterable)).entrySet());
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        LinkedHashMultiset linkedHashMultisetCreate = LinkedHashMultiset.create();
        Iterators.a(linkedHashMultisetCreate, it);
        return copyFromEntries(linkedHashMultisetCreate.entrySet());
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private ImmutableSet<l6.a<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$toImmutableMultiset$0(Object obj) {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$toImmutableMultiset$1(Function function, ToIntFunction toIntFunction, l6 l6Var, Object obj) {
        l6Var.add(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function.apply(obj)), toIntFunction.applyAsInt(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l6 lambda$toImmutableMultiset$2(l6 l6Var, l6 l6Var2) {
        l6Var.addAll(l6Var2);
        return l6Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableMultiset lambda$toImmutableMultiset$3(l6 l6Var) {
        return copyFromEntries(l6Var.entrySet());
    }

    public static <E> ImmutableMultiset<E> of() {
        return (ImmutableMultiset<E>) RegularImmutableMultiset.EMPTY;
    }

    public static <E> ImmutableMultiset<E> of(E e11) {
        return copyFromElements(e11);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12) {
        return copyFromElements(e11, e12);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13) {
        return copyFromElements(e11, e12, e13);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14) {
        return copyFromElements(e11, e12, e13, e14);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14, E e15) {
        return copyFromElements(e11, e12, e13, e14, e15);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E... eArr) {
        return new b().a(e11).a(e12).a(e13).a(e14).a(e15).a(e16).f(eArr).i();
    }

    public static <E> Collector<E, ?, ImmutableMultiset<E>> toImmutableMultiset() {
        return toImmutableMultiset(Function.identity(), new ToIntFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.e4
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ImmutableMultiset.lambda$toImmutableMultiset$0(obj);
            }
        });
    }

    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(final Function<? super T, ? extends E> function, final ToIntFunction<? super T> toIntFunction) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(toIntFunction);
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.a4
            @Override // java.util.function.Supplier
            public final Object get() {
                return LinkedHashMultiset.create();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.b4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ImmutableMultiset.lambda$toImmutableMultiset$1(function, toIntFunction, (l6) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ImmutableMultiset.lambda$toImmutableMultiset$2((l6) obj, (l6) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableMultiset.lambda$toImmutableMultiset$3((l6) obj);
            }
        }, new Collector.Characteristics[0]);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    @Deprecated
    public final int add(E e11, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> immutableListAsList = super.asList();
        this.asList = immutableListAsList;
        return immutableListAsList;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        t7<l6.a<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            l6.a<E> next = it.next();
            Arrays.fill(objArr, i11, next.getCount() + i11, next.getElement());
            i11 += next.getCount();
        }
        return i11;
    }

    public abstract /* synthetic */ int count(Object obj);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public abstract ImmutableSet<E> elementSet();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public ImmutableSet<l6.a<E>> entrySet() {
        ImmutableSet<l6.a<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<l6.a<E>> immutableSetCreateEntrySet = createEntrySet();
        this.entrySet = immutableSetCreateEntrySet;
        return immutableSetCreateEntrySet;
    }

    @Override // java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public boolean equals(Object obj) {
        return Multisets.f(this, obj);
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        k6.b(this, objIntConsumer);
    }

    public abstract l6.a<E> getEntry(int i11);

    @Override // java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int hashCode() {
        return Sets.b(entrySet());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public t7<E> iterator() {
        return new a(entrySet().iterator());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    @Deprecated
    public final int remove(Object obj, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    @Deprecated
    public final int setCount(E e11, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    @Deprecated
    public final boolean setCount(E e11, int i11, int i12) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
