package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class LinkedListMultimap<K, V> extends s<K, V> implements q5<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient g<K, V> head;
    private transient Map<K, f<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;
    private transient g<K, V> tail;

    /* JADX INFO: compiled from: source.java */
    public class a extends AbstractSequentialList<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f39437a;

        public a(Object obj) {
            this.f39437a = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i11) {
            return new i(this.f39437a, i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(this.f39437a);
            if (fVar == null) {
                return 0;
            }
            return fVar.f39451c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
            for (g<K, V> gVar = LinkedListMultimap.this.head; gVar != null; gVar = gVar.f39454c) {
                consumer.accept(gVar);
            }
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i11) {
            return new h(i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends Sets.a<K> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new e(LinkedListMultimap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return !LinkedListMultimap.this.removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.keyToKeyList.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AbstractSequentialList<V> {

        /* JADX INFO: compiled from: source.java */
        public class a extends s7<Map.Entry<K, V>, V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f39442b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ListIterator listIterator, h hVar) {
                super(listIterator);
                this.f39442b = hVar;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r7
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s7, java.util.ListIterator
            public void set(V v11) {
                this.f39442b.g(v11);
            }
        }

        public d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i11) {
            h hVar = new h(i11);
            return new a(hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Iterator<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<K> f39444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g<K, V> f39445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g<K, V> f39446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f39447d;

        public e() {
            this.f39444a = Sets.e(LinkedListMultimap.this.keySet().size());
            this.f39445b = LinkedListMultimap.this.head;
            this.f39447d = LinkedListMultimap.this.modCount;
        }

        public /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }

        public final void a() {
            if (LinkedListMultimap.this.modCount != this.f39447d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f39445b != null;
        }

        @Override // java.util.Iterator
        public K next() {
            g<K, V> gVar;
            a();
            LinkedListMultimap.checkElement(this.f39445b);
            g<K, V> gVar2 = this.f39445b;
            this.f39446c = gVar2;
            this.f39444a.add(gVar2.f39452a);
            do {
                gVar = this.f39445b.f39454c;
                this.f39445b = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.f39444a.add(gVar.f39452a));
            return this.f39446c.f39452a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            n1.e(this.f39446c != null);
            LinkedListMultimap.this.removeAllNodes(this.f39446c.f39452a);
            this.f39446c = null;
            this.f39447d = LinkedListMultimap.this.modCount;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g<K, V> f39449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g<K, V> f39450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f39451c;

        public f(g<K, V> gVar) {
            this.f39449a = gVar;
            this.f39450b = gVar;
            gVar.f39457g = null;
            gVar.f39456f = null;
            this.f39451c = 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g<K, V> extends q<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f39452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f39453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g<K, V> f39454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g<K, V> f39455d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g<K, V> f39456f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public g<K, V> f39457g;

        public g(K k11, V v11) {
            this.f39452a = k11;
            this.f39453b = v11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
        public K getKey() {
            return this.f39452a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
        public V getValue() {
            return this.f39453b;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
        public V setValue(V v11) {
            V v12 = this.f39453b;
            this.f39453b = v11;
            return v12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements ListIterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f39458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g<K, V> f39459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g<K, V> f39460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g<K, V> f39461d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f39462f;

        public h(int i11) {
            this.f39462f = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.q(i11, size);
            if (i11 < size / 2) {
                this.f39459b = LinkedListMultimap.this.head;
                while (true) {
                    int i12 = i11 - 1;
                    if (i11 <= 0) {
                        break;
                    }
                    next();
                    i11 = i12;
                }
            } else {
                this.f39461d = LinkedListMultimap.this.tail;
                this.f39458a = size;
                while (true) {
                    int i13 = i11 + 1;
                    if (i11 >= size) {
                        break;
                    }
                    previous();
                    i11 = i13;
                }
            }
            this.f39460c = null;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public final void b() {
            if (LinkedListMultimap.this.modCount != this.f39462f) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public g<K, V> next() {
            b();
            LinkedListMultimap.checkElement(this.f39459b);
            g<K, V> gVar = this.f39459b;
            this.f39460c = gVar;
            this.f39461d = gVar;
            this.f39459b = gVar.f39454c;
            this.f39458a++;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public g<K, V> previous() {
            b();
            LinkedListMultimap.checkElement(this.f39461d);
            g<K, V> gVar = this.f39461d;
            this.f39460c = gVar;
            this.f39459b = gVar;
            this.f39461d = gVar.f39455d;
            this.f39458a--;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void g(V v11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.t(this.f39460c != null);
            this.f39460c.f39453b = v11;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f39459b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f39461d != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f39458a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f39458a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            n1.e(this.f39460c != null);
            g<K, V> gVar = this.f39460c;
            if (gVar != this.f39459b) {
                this.f39461d = gVar.f39455d;
                this.f39458a--;
            } else {
                this.f39459b = gVar.f39454c;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.f39460c = null;
            this.f39462f = LinkedListMultimap.this.modCount;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements ListIterator<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f39464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g<K, V> f39466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g<K, V> f39467d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g<K, V> f39468f;

        public i(Object obj) {
            this.f39464a = obj;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            this.f39466c = fVar == null ? null : fVar.f39449a;
        }

        public i(Object obj, int i11) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            int i12 = fVar == null ? 0 : fVar.f39451c;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.q(i11, i12);
            if (i11 < i12 / 2) {
                this.f39466c = fVar == null ? null : fVar.f39449a;
                while (true) {
                    int i13 = i11 - 1;
                    if (i11 <= 0) {
                        break;
                    }
                    next();
                    i11 = i13;
                }
            } else {
                this.f39468f = fVar == null ? null : fVar.f39450b;
                this.f39465b = i12;
                while (true) {
                    int i14 = i11 + 1;
                    if (i11 >= i12) {
                        break;
                    }
                    previous();
                    i11 = i14;
                }
            }
            this.f39464a = obj;
            this.f39467d = null;
        }

        @Override // java.util.ListIterator
        public void add(V v11) {
            this.f39468f = LinkedListMultimap.this.addNode(this.f39464a, v11, this.f39466c);
            this.f39465b++;
            this.f39467d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f39466c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f39468f != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            LinkedListMultimap.checkElement(this.f39466c);
            g<K, V> gVar = this.f39466c;
            this.f39467d = gVar;
            this.f39468f = gVar;
            this.f39466c = gVar.f39456f;
            this.f39465b++;
            return gVar.f39453b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f39465b;
        }

        @Override // java.util.ListIterator
        public V previous() {
            LinkedListMultimap.checkElement(this.f39468f);
            g<K, V> gVar = this.f39468f;
            this.f39467d = gVar;
            this.f39466c = gVar;
            this.f39468f = gVar.f39457g;
            this.f39465b--;
            return gVar.f39453b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f39465b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            n1.e(this.f39467d != null);
            g<K, V> gVar = this.f39467d;
            if (gVar != this.f39466c) {
                this.f39468f = gVar.f39457g;
                this.f39465b--;
            } else {
                this.f39466c = gVar.f39456f;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.f39467d = null;
        }

        @Override // java.util.ListIterator
        public void set(V v11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.t(this.f39467d != null);
            this.f39467d.f39453b = v11;
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    private LinkedListMultimap(int i11) {
        this.keyToKeyList = r6.b(i11);
    }

    private LinkedListMultimap(z5<? extends K, ? extends V> z5Var) {
        this(z5Var.keySet().size());
        putAll(z5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g<K, V> addNode(K k11, V v11, g<K, V> gVar) {
        g<K, V> gVar2 = new g<>(k11, v11);
        if (this.head == null) {
            this.tail = gVar2;
            this.head = gVar2;
            this.keyToKeyList.put(k11, new f<>(gVar2));
            this.modCount++;
        } else if (gVar == null) {
            g<K, V> gVar3 = this.tail;
            gVar3.f39454c = gVar2;
            gVar2.f39455d = gVar3;
            this.tail = gVar2;
            f<K, V> fVar = this.keyToKeyList.get(k11);
            if (fVar == null) {
                this.keyToKeyList.put(k11, new f<>(gVar2));
                this.modCount++;
            } else {
                fVar.f39451c++;
                g<K, V> gVar4 = fVar.f39450b;
                gVar4.f39456f = gVar2;
                gVar2.f39457g = gVar4;
                fVar.f39450b = gVar2;
            }
        } else {
            this.keyToKeyList.get(k11).f39451c++;
            gVar2.f39455d = gVar.f39455d;
            gVar2.f39457g = gVar.f39457g;
            gVar2.f39454c = gVar;
            gVar2.f39456f = gVar;
            g<K, V> gVar5 = gVar.f39457g;
            if (gVar5 == null) {
                this.keyToKeyList.get(k11).f39449a = gVar2;
            } else {
                gVar5.f39456f = gVar2;
            }
            g<K, V> gVar6 = gVar.f39455d;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.f39454c = gVar2;
            }
            gVar.f39455d = gVar2;
            gVar.f39457g = gVar2;
        }
        this.size++;
        return gVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkElement(Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i11) {
        return new LinkedListMultimap<>(i11);
    }

    public static <K, V> LinkedListMultimap<K, V> create(z5<? extends K, ? extends V> z5Var) {
        return new LinkedListMultimap<>(z5Var);
    }

    private List<V> getCopy(Object obj) {
        return Collections.unmodifiableList(Lists.j(new i(obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = Maps.o();
        int i11 = objectInputStream.readInt();
        for (int i12 = 0; i12 < i11; i12++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(Object obj) {
        Iterators.d(new i(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f39455d;
        if (gVar2 != null) {
            gVar2.f39454c = gVar.f39454c;
        } else {
            this.head = gVar.f39454c;
        }
        g<K, V> gVar3 = gVar.f39454c;
        if (gVar3 != null) {
            gVar3.f39455d = gVar2;
        } else {
            this.tail = gVar2;
        }
        if (gVar.f39457g == null && gVar.f39456f == null) {
            this.keyToKeyList.remove(gVar.f39452a).f39451c = 0;
            this.modCount++;
        } else {
            f<K, V> fVar = this.keyToKeyList.get(gVar.f39452a);
            fVar.f39451c--;
            g<K, V> gVar4 = gVar.f39457g;
            if (gVar4 == null) {
                fVar.f39449a = gVar.f39456f;
            } else {
                gVar4.f39456f = gVar.f39456f;
            }
            g<K, V> gVar5 = gVar.f39456f;
            if (gVar5 == null) {
                fVar.f39450b = gVar4;
            } else {
                gVar5.f39457g = gVar4;
            }
        }
        this.size--;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public boolean containsKey(Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public List<Map.Entry<K, V>> createEntries() {
        return new b();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Set<K> createKeySet() {
        return new c();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public l6<K> createKeys() {
        return new Multimaps.c(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public List<V> createValues() {
        return new d();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ void forEach(BiConsumer biConsumer) {
        y5.a(this, biConsumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public List<V> get(K k11) {
        return new a(k11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ l6 keys() {
        return super.keys();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public boolean put(K k11, V v11) {
        addNode(k11, v11, null);
        return true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean putAll(z5 z5Var) {
        return super.putAll(z5Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public List<V> removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public List<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k11);
        i iVar = new i(k11);
        Iterator<? extends V> it = iterable.iterator();
        while (iVar.hasNext() && it.hasNext()) {
            iVar.next();
            iVar.set(it.next());
        }
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
        while (it.hasNext()) {
            iVar.add(it.next());
        }
        return copy;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public int size() {
        return this.size;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public List<V> values() {
        return (List) super.values();
    }
}
