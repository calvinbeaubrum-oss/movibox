package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractMapBasedMultiset<E> extends t<E> implements Serializable {
    private static final long serialVersionUID = -2250766705698539974L;
    private transient Map<E, Count> backingMap;
    private transient long size;

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map.Entry<E, Count> f39251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f39252b;

        public a(Iterator it) {
            this.f39252b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39252b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            Map.Entry<E, Count> entry = (Map.Entry) this.f39252b.next();
            this.f39251a = entry;
            return entry.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(this.f39251a != null);
            AbstractMapBasedMultiset.this.size -= (long) this.f39251a.getValue().getAndSet(0);
            this.f39252b.remove();
            this.f39251a = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Iterator<l6.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map.Entry<E, Count> f39254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f39255b;

        /* JADX INFO: compiled from: source.java */
        public class a extends Multisets.b<E> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map.Entry f39257a;

            public a(Map.Entry entry) {
                this.f39257a = entry;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6.a
            public int getCount() {
                Count count;
                Count count2 = (Count) this.f39257a.getValue();
                if ((count2 == null || count2.get() == 0) && (count = (Count) AbstractMapBasedMultiset.this.backingMap.get(getElement())) != null) {
                    return count.get();
                }
                if (count2 == null) {
                    return 0;
                }
                return count2.get();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6.a
            public E getElement() {
                return (E) this.f39257a.getKey();
            }
        }

        public b(Iterator it) {
            this.f39255b = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l6.a<E> next() {
            Map.Entry<E, Count> entry = (Map.Entry) this.f39255b.next();
            this.f39254a = entry;
            return new a(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39255b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(this.f39254a != null);
            AbstractMapBasedMultiset.this.size -= (long) this.f39254a.getValue().getAndSet(0);
            this.f39255b.remove();
            this.f39254a = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<E, Count>> f39259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map.Entry<E, Count> f39260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f39261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f39262d;

        public c() {
            this.f39259a = AbstractMapBasedMultiset.this.backingMap.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39261c > 0 || this.f39259a.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f39261c == 0) {
                Map.Entry<E, Count> next = this.f39259a.next();
                this.f39260b = next;
                this.f39261c = next.getValue().get();
            }
            this.f39261c--;
            this.f39262d = true;
            return this.f39260b.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(this.f39262d);
            if (this.f39260b.getValue().get() <= 0) {
                throw new ConcurrentModificationException();
            }
            if (this.f39260b.getValue().addAndGet(-1) == 0) {
                this.f39259a.remove();
            }
            AbstractMapBasedMultiset.access$010(AbstractMapBasedMultiset.this);
            this.f39262d = false;
        }
    }

    public AbstractMapBasedMultiset(Map<E, Count> map) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(map.isEmpty());
        this.backingMap = map;
    }

    public static /* synthetic */ long access$010(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        long j11 = abstractMapBasedMultiset.size;
        abstractMapBasedMultiset.size = j11 - 1;
        return j11;
    }

    private static int getAndSet(Count count, int i11) {
        if (count == null) {
            return 0;
        }
        return count.getAndSet(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$forEachEntry$0(ObjIntConsumer objIntConsumer, Object obj, Count count) {
        objIntConsumer.accept(obj, count.get());
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int add(E e11, int i11) {
        if (i11 == 0) {
            return count(e11);
        }
        int i12 = 0;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.f(i11 > 0, "occurrences cannot be negative: %s", i11);
        Count count = this.backingMap.get(e11);
        if (count == null) {
            this.backingMap.put(e11, new Count(i11));
        } else {
            int i13 = count.get();
            long j11 = ((long) i13) + ((long) i11);
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.h(j11 <= 2147483647L, "too many occurrences: %s", j11);
            count.add(i11);
            i12 = i13;
        }
        this.size += (long) i11;
        return i12;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterator<Count> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            it.next().set(0);
        }
        this.backingMap.clear();
        this.size = 0L;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int count(Object obj) {
        Count count = (Count) Maps.s(this.backingMap, obj);
        if (count == null) {
            return 0;
        }
        return count.get();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public int distinctElements() {
        return this.backingMap.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public Iterator<E> elementIterator() {
        return new a(this.backingMap.entrySet().iterator());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public Iterator<l6.a<E>> entryIterator() {
        return new b(this.backingMap.entrySet().iterator());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public Set<l6.a<E>> entrySet() {
        return super.entrySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public void forEachEntry(final ObjIntConsumer<? super E> objIntConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(objIntConsumer);
        this.backingMap.forEach(new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                AbstractMapBasedMultiset.lambda$forEachEntry$0(objIntConsumer, obj, (Count) obj2);
            }
        });
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new c();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int remove(Object obj, int i11) {
        if (i11 == 0) {
            return count(obj);
        }
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.f(i11 > 0, "occurrences cannot be negative: %s", i11);
        Count count = this.backingMap.get(obj);
        if (count == null) {
            return 0;
        }
        int i12 = count.get();
        if (i12 <= i11) {
            this.backingMap.remove(obj);
            i11 = i12;
        }
        count.add(-i11);
        this.size -= (long) i11;
        return i12;
    }

    public void setBackingMap(Map<E, Count> map) {
        this.backingMap = map;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int setCount(E e11, int i11) {
        int andSet;
        n1.b(i11, "count");
        if (i11 == 0) {
            andSet = getAndSet(this.backingMap.remove(e11), i11);
        } else {
            Count count = this.backingMap.get(e11);
            int andSet2 = getAndSet(count, i11);
            if (count == null) {
                this.backingMap.put(e11, new Count(i11));
            }
            andSet = andSet2;
        }
        this.size += (long) (i11 - andSet);
        return andSet;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int size() {
        return Ints.i(this.size);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return k6.c(this);
    }
}
