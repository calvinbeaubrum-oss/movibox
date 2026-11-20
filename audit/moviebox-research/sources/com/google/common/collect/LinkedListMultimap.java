package com.google.common.collect;

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
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class LinkedListMultimap<K, V> extends com.google.common.collect.c<K, V> implements g0<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient g<K, V> head;
    private transient Map<K, f<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;
    private transient g<K, V> tail;

    /* JADX INFO: compiled from: source.java */
    public class a extends AbstractSequentialList<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f38439a;

        public a(Object obj) {
            this.f38439a = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i11) {
            return new i(this.f38439a, i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(this.f38439a);
            if (fVar == null) {
                return 0;
            }
            return fVar.f38452c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        public b() {
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
    public class c extends Sets.d<K> {
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
        public class a extends e1<Map.Entry<K, V>, V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f38444b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                this.f38444b = hVar;
            }

            @Override // com.google.common.collect.d1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // com.google.common.collect.e1, java.util.ListIterator
            public void set(V v11) {
                this.f38444b.g(v11);
            }
        }

        public d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i11) {
            h hVar = new h(i11);
            return new a(this, hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Iterator<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<K> f38445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g<K, V> f38446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g<K, V> f38447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f38448d;

        public e() {
            this.f38445a = Sets.g(LinkedListMultimap.this.keySet().size());
            this.f38446b = LinkedListMultimap.this.head;
            this.f38448d = LinkedListMultimap.this.modCount;
        }

        public /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }

        public final void a() {
            if (LinkedListMultimap.this.modCount != this.f38448d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f38446b != null;
        }

        @Override // java.util.Iterator
        public K next() {
            g<K, V> gVar;
            a();
            g<K, V> gVar2 = this.f38446b;
            if (gVar2 == null) {
                throw new NoSuchElementException();
            }
            this.f38447c = gVar2;
            this.f38445a.add(gVar2.f38453a);
            do {
                gVar = this.f38446b.f38455c;
                this.f38446b = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.f38445a.add(gVar.f38453a));
            return this.f38447c.f38453a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            com.google.common.base.m.w(this.f38447c != null, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.removeAllNodes(this.f38447c.f38453a);
            this.f38447c = null;
            this.f38448d = LinkedListMultimap.this.modCount;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g<K, V> f38450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g<K, V> f38451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f38452c;

        public f(g<K, V> gVar) {
            this.f38450a = gVar;
            this.f38451b = gVar;
            gVar.f38458g = null;
            gVar.f38457f = null;
            this.f38452c = 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g<K, V> extends com.google.common.collect.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f38453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f38454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g<K, V> f38455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g<K, V> f38456d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g<K, V> f38457f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public g<K, V> f38458g;

        public g(K k11, V v11) {
            this.f38453a = k11;
            this.f38454b = v11;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f38453a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return this.f38454b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v11) {
            V v12 = this.f38454b;
            this.f38454b = v11;
            return v12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements ListIterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g<K, V> f38460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g<K, V> f38461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g<K, V> f38462d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f38463f;

        public h(int i11) {
            this.f38463f = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            com.google.common.base.m.s(i11, size);
            if (i11 < size / 2) {
                this.f38460b = LinkedListMultimap.this.head;
                while (true) {
                    int i12 = i11 - 1;
                    if (i11 <= 0) {
                        break;
                    }
                    next();
                    i11 = i12;
                }
            } else {
                this.f38462d = LinkedListMultimap.this.tail;
                this.f38459a = size;
                while (true) {
                    int i13 = i11 + 1;
                    if (i11 >= size) {
                        break;
                    }
                    previous();
                    i11 = i13;
                }
            }
            this.f38461c = null;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public final void b() {
            if (LinkedListMultimap.this.modCount != this.f38463f) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public g<K, V> next() {
            b();
            g<K, V> gVar = this.f38460b;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f38461c = gVar;
            this.f38462d = gVar;
            this.f38460b = gVar.f38455c;
            this.f38459a++;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public g<K, V> previous() {
            b();
            g<K, V> gVar = this.f38462d;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f38461c = gVar;
            this.f38460b = gVar;
            this.f38462d = gVar.f38456d;
            this.f38459a--;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void g(V v11) {
            com.google.common.base.m.v(this.f38461c != null);
            this.f38461c.f38454b = v11;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f38460b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f38462d != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f38459a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f38459a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            com.google.common.base.m.w(this.f38461c != null, "no calls to next() since the last call to remove()");
            g<K, V> gVar = this.f38461c;
            if (gVar != this.f38460b) {
                this.f38462d = gVar.f38456d;
                this.f38459a--;
            } else {
                this.f38460b = gVar.f38455c;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.f38461c = null;
            this.f38463f = LinkedListMultimap.this.modCount;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements ListIterator<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f38465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g<K, V> f38467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g<K, V> f38468d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g<K, V> f38469f;

        public i(K k11) {
            this.f38465a = k11;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(k11);
            this.f38467c = fVar == null ? null : fVar.f38450a;
        }

        public i(K k11, int i11) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(k11);
            int i12 = fVar == null ? 0 : fVar.f38452c;
            com.google.common.base.m.s(i11, i12);
            if (i11 < i12 / 2) {
                this.f38467c = fVar == null ? null : fVar.f38450a;
                while (true) {
                    int i13 = i11 - 1;
                    if (i11 <= 0) {
                        break;
                    }
                    next();
                    i11 = i13;
                }
            } else {
                this.f38469f = fVar == null ? null : fVar.f38451b;
                this.f38466b = i12;
                while (true) {
                    int i14 = i11 + 1;
                    if (i11 >= i12) {
                        break;
                    }
                    previous();
                    i11 = i14;
                }
            }
            this.f38465a = k11;
            this.f38468d = null;
        }

        @Override // java.util.ListIterator
        public void add(V v11) {
            this.f38469f = LinkedListMultimap.this.addNode(this.f38465a, v11, this.f38467c);
            this.f38466b++;
            this.f38468d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f38467c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f38469f != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            g<K, V> gVar = this.f38467c;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f38468d = gVar;
            this.f38469f = gVar;
            this.f38467c = gVar.f38457f;
            this.f38466b++;
            return gVar.f38454b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f38466b;
        }

        @Override // java.util.ListIterator
        public V previous() {
            g<K, V> gVar = this.f38469f;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f38468d = gVar;
            this.f38467c = gVar;
            this.f38469f = gVar.f38458g;
            this.f38466b--;
            return gVar.f38454b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f38466b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            com.google.common.base.m.w(this.f38468d != null, "no calls to next() since the last call to remove()");
            g<K, V> gVar = this.f38468d;
            if (gVar != this.f38467c) {
                this.f38469f = gVar.f38458g;
                this.f38466b--;
            } else {
                this.f38467c = gVar.f38457f;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.f38468d = null;
        }

        @Override // java.util.ListIterator
        public void set(V v11) {
            com.google.common.base.m.v(this.f38468d != null);
            this.f38468d.f38454b = v11;
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    private LinkedListMultimap(int i11) {
        this.keyToKeyList = p0.d(i11);
    }

    private LinkedListMultimap(h0<? extends K, ? extends V> h0Var) {
        this(h0Var.keySet().size());
        putAll(h0Var);
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
            Objects.requireNonNull(gVar3);
            gVar3.f38455c = gVar2;
            gVar2.f38456d = this.tail;
            this.tail = gVar2;
            f<K, V> fVar = this.keyToKeyList.get(k11);
            if (fVar == null) {
                this.keyToKeyList.put(k11, new f<>(gVar2));
                this.modCount++;
            } else {
                fVar.f38452c++;
                g<K, V> gVar4 = fVar.f38451b;
                gVar4.f38457f = gVar2;
                gVar2.f38458g = gVar4;
                fVar.f38451b = gVar2;
            }
        } else {
            f<K, V> fVar2 = this.keyToKeyList.get(k11);
            Objects.requireNonNull(fVar2);
            fVar2.f38452c++;
            gVar2.f38456d = gVar.f38456d;
            gVar2.f38458g = gVar.f38458g;
            gVar2.f38455c = gVar;
            gVar2.f38457f = gVar;
            g<K, V> gVar5 = gVar.f38458g;
            if (gVar5 == null) {
                fVar2.f38450a = gVar2;
            } else {
                gVar5.f38457f = gVar2;
            }
            g<K, V> gVar6 = gVar.f38456d;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.f38455c = gVar2;
            }
            gVar.f38456d = gVar2;
            gVar.f38458g = gVar2;
        }
        this.size++;
        return gVar2;
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i11) {
        return new LinkedListMultimap<>(i11);
    }

    public static <K, V> LinkedListMultimap<K, V> create(h0<? extends K, ? extends V> h0Var) {
        return new LinkedListMultimap<>(h0Var);
    }

    private List<V> getCopy(K k11) {
        return Collections.unmodifiableList(Lists.k(new i(k11)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int i11 = objectInputStream.readInt();
        for (int i12 = 0; i12 < i11; i12++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(K k11) {
        Iterators.e(new i(k11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f38456d;
        if (gVar2 != null) {
            gVar2.f38455c = gVar.f38455c;
        } else {
            this.head = gVar.f38455c;
        }
        g<K, V> gVar3 = gVar.f38455c;
        if (gVar3 != null) {
            gVar3.f38456d = gVar2;
        } else {
            this.tail = gVar2;
        }
        if (gVar.f38458g == null && gVar.f38457f == null) {
            f<K, V> fVarRemove = this.keyToKeyList.remove(gVar.f38453a);
            Objects.requireNonNull(fVarRemove);
            fVarRemove.f38452c = 0;
            this.modCount++;
        } else {
            f<K, V> fVar = this.keyToKeyList.get(gVar.f38453a);
            Objects.requireNonNull(fVar);
            fVar.f38452c--;
            g<K, V> gVar4 = gVar.f38458g;
            if (gVar4 == null) {
                g<K, V> gVar5 = gVar.f38457f;
                Objects.requireNonNull(gVar5);
                fVar.f38450a = gVar5;
            } else {
                gVar4.f38457f = gVar.f38457f;
            }
            g<K, V> gVar6 = gVar.f38457f;
            if (gVar6 == null) {
                g<K, V> gVar7 = gVar.f38458g;
                Objects.requireNonNull(gVar7);
                fVar.f38451b = gVar7;
            } else {
                gVar6.f38458g = gVar.f38458g;
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

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.h0
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.h0
    public boolean containsKey(Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.common.collect.c
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.c
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    @Override // com.google.common.collect.c
    public List<Map.Entry<K, V>> createEntries() {
        return new b();
    }

    @Override // com.google.common.collect.c
    public Set<K> createKeySet() {
        return new c();
    }

    @Override // com.google.common.collect.c
    public j0<K> createKeys() {
        return new Multimaps.c(this);
    }

    @Override // com.google.common.collect.c
    public List<V> createValues() {
        return new d();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.h0
    public List<V> get(K k11) {
        return new a(k11);
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ j0 keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public boolean put(K k11, V v11) {
        addNode(k11, v11, null);
        return true;
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean putAll(h0 h0Var) {
        return super.putAll(h0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.h0
    public List<V> removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    @Override // com.google.common.collect.c
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

    @Override // com.google.common.collect.h0
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.h0
    public List<V> values() {
        return (List) super.values();
    }
}
