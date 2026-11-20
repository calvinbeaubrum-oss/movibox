package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class ConcurrentHashMultiset<E> extends t<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* JADX INFO: compiled from: source.java */
    public class a extends v2<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f39280a;

        public a(Set set) {
            this.f39280a = set;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return obj != null && j2.d(this.f39280a, obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public Set<E> delegate() {
            return this.f39280a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return obj != null && j2.e(this.f39280a, obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AbstractIterator<l6.a<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Iterator<Map.Entry<E, AtomicInteger>> f39282c;

        public b() {
            this.f39282c = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public l6.a<E> a() {
            while (this.f39282c.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.f39282c.next();
                int i11 = next.getValue().get();
                if (i11 != 0) {
                    return Multisets.g(next.getKey(), i11);
                }
            }
            return b();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends p2<l6.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l6.a<E> f39284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f39285b;

        public c(Iterator it) {
            this.f39285b = it;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Iterator<l6.a<E>> delegate() {
            return this.f39285b;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p2, java.util.Iterator
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public l6.a<E> next() {
            l6.a<E> aVar = (l6.a) super.next();
            this.f39284a = aVar;
            return aVar;
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(this.f39284a != null);
            ConcurrentHashMultiset.this.setCount(this.f39284a.getElement(), 0);
            this.f39284a = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends t<E>.b {
        public d() {
            super();
        }

        public /* synthetic */ d(ConcurrentHashMultiset concurrentHashMultiset, a aVar) {
            this();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multisets.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ConcurrentHashMultiset<E> a() {
            return ConcurrentHashMultiset.this;
        }

        public final List<l6.a<E>> e() {
            ArrayList arrayListL = Lists.l(size());
            Iterators.a(arrayListL, iterator());
            return arrayListL;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return e().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) e().toArray(tArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y6.b<ConcurrentHashMultiset> f39288a = y6.a(ConcurrentHashMultiset.class, "countMap");
    }

    public ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> concurrentHashMultisetCreate = create();
        j5.a(concurrentHashMultisetCreate, iterable);
        return concurrentHashMultisetCreate;
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        e.f39288a.b(this, (ConcurrentMap) objectInputStream.readObject());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList arrayListL = Lists.l(size());
        for (l6.a aVar : entrySet()) {
            Object element = aVar.getElement();
            for (int count = aVar.getCount(); count > 0; count--) {
                arrayListL.add(element);
            }
        }
        return arrayListL;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int add(E e11, int i11) {
        AtomicInteger atomicIntegerPutIfAbsent;
        int i12;
        AtomicInteger atomicInteger;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
        if (i11 == 0) {
            return count(e11);
        }
        n1.d(i11, "occurences");
        do {
            atomicIntegerPutIfAbsent = (AtomicInteger) Maps.s(this.countMap, e11);
            if (atomicIntegerPutIfAbsent == null && (atomicIntegerPutIfAbsent = this.countMap.putIfAbsent(e11, new AtomicInteger(i11))) == null) {
                return 0;
            }
            do {
                i12 = atomicIntegerPutIfAbsent.get();
                if (i12 == 0) {
                    atomicInteger = new AtomicInteger(i11);
                    if (this.countMap.putIfAbsent(e11, atomicInteger) == null) {
                        break;
                    }
                } else {
                    try {
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException("Overflow adding " + i11 + " occurrences to a count of " + i12);
                    }
                }
            } while (!atomicIntegerPutIfAbsent.compareAndSet(i12, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.c.a(i12, i11)));
            return i12;
        } while (!this.countMap.replace(e11, atomicIntegerPutIfAbsent, atomicInteger));
        return 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int count(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.s(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public Set<E> createElementSet() {
        return new a(this.countMap.keySet());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    @Deprecated
    public Set<l6.a<E>> createEntrySet() {
        return new d(this, null);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public Iterator<l6.a<E>> entryIterator() {
        return new c(new b());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        k6.b(this, objIntConsumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int remove(Object obj, int i11) {
        int i12;
        int iMax;
        if (i11 == 0) {
            return count(obj);
        }
        n1.d(i11, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.s(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i12 = atomicInteger.get();
            if (i12 == 0) {
                return 0;
            }
            iMax = Math.max(0, i12 - i11);
        } while (!atomicInteger.compareAndSet(i12, iMax));
        if (iMax == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i12;
    }

    public boolean removeExactly(Object obj, int i11) {
        int i12;
        int i13;
        if (i11 == 0) {
            return true;
        }
        n1.d(i11, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.s(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i12 = atomicInteger.get();
            if (i12 < i11) {
                return false;
            }
            i13 = i12 - i11;
        } while (!atomicInteger.compareAndSet(i12, i13));
        if (i13 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int setCount(E e11, int i11) {
        AtomicInteger atomicIntegerPutIfAbsent;
        AtomicInteger atomicInteger;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
        n1.b(i11, "count");
        do {
            atomicIntegerPutIfAbsent = (AtomicInteger) Maps.s(this.countMap, e11);
            if (atomicIntegerPutIfAbsent != null || (i11 != 0 && (atomicIntegerPutIfAbsent = this.countMap.putIfAbsent(e11, new AtomicInteger(i11))) != null)) {
                while (true) {
                    int i12 = atomicIntegerPutIfAbsent.get();
                    if (i12 == 0) {
                        break;
                    }
                    if (atomicIntegerPutIfAbsent.compareAndSet(i12, i11)) {
                        if (i11 == 0) {
                            this.countMap.remove(e11, atomicIntegerPutIfAbsent);
                        }
                        return i12;
                    }
                }
                if (i11 != 0) {
                    atomicInteger = new AtomicInteger(i11);
                    if (this.countMap.putIfAbsent(e11, atomicInteger) == null) {
                        break;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } while (!this.countMap.replace(e11, atomicIntegerPutIfAbsent, atomicInteger));
        return 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public boolean setCount(E e11, int i11, int i12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
        n1.b(i11, "oldCount");
        n1.b(i12, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.s(this.countMap, e11);
        if (atomicInteger == null) {
            if (i11 != 0) {
                return false;
            }
            return i12 == 0 || this.countMap.putIfAbsent(e11, new AtomicInteger(i12)) == null;
        }
        int i13 = atomicInteger.get();
        if (i13 == i11) {
            if (i13 == 0) {
                if (i12 == 0) {
                    this.countMap.remove(e11, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i12);
                return this.countMap.putIfAbsent(e11, atomicInteger2) == null || this.countMap.replace(e11, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i13, i12)) {
                if (i12 == 0) {
                    this.countMap.remove(e11, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int size() {
        Iterator<AtomicInteger> it = this.countMap.values().iterator();
        long j11 = 0;
        while (it.hasNext()) {
            j11 += (long) it.next().get();
        }
        return Ints.i(j11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return k6.c(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }
}
