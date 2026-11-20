package com.google.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e1<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<e1<K, V>.e> f41235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<K, V> f41236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f41237d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile e1<K, V>.g f41238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<K, V> f41239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile e1<K, V>.c f41240h;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* JADX INFO: compiled from: source.java */
    public static class a<FieldDescriptorType> extends e1<FieldDescriptorType, Object> {
        public a(int i11) {
            super(i11, null);
        }

        @Override // com.google.protobuf.e1, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.put((u.b) obj, obj2);
        }

        @Override // com.google.protobuf.e1
        public void r() {
            if (!q()) {
                for (int i11 = 0; i11 < l(); i11++) {
                    Map.Entry<FieldDescriptorType, Object> entryK = k(i11);
                    if (((u.b) entryK.getKey()).N()) {
                        entryK.setValue(Collections.unmodifiableList((List) entryK.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : n()) {
                    if (((u.b) entry.getKey()).N()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.r();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f41242b;

        public b() {
            this.f41241a = e1.this.f41235b.size();
        }

        public /* synthetic */ b(e1 e1Var, a aVar) {
            this();
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f41242b == null) {
                this.f41242b = e1.this.f41239g.entrySet().iterator();
            }
            return this.f41242b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (a().hasNext()) {
                return a().next();
            }
            List list = e1.this.f41235b;
            int i11 = this.f41241a - 1;
            this.f41241a = i11;
            return (Map.Entry) list.get(i11);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i11 = this.f41241a;
            return (i11 > 0 && i11 <= e1.this.f41235b.size()) || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends e1<K, V>.g {
        public c() {
            super(e1.this, null);
        }

        public /* synthetic */ c(e1 e1Var, a aVar) {
            this();
        }

        @Override // com.google.protobuf.e1.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b(e1.this, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Iterator<Object> f41245a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Iterable<Object> f41246b = new b();

        /* JADX INFO: compiled from: source.java */
        public static class a implements Iterator<Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static class b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return d.f41245a;
            }
        }

        public static <T> Iterable<T> b() {
            return (Iterable<T>) f41246b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Map.Entry<K, V>, Comparable<e1<K, V>.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f41247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f41248b;

        public e(K k11, V v11) {
            this.f41247a = k11;
            this.f41248b = v11;
        }

        public e(e1 e1Var, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e1<K, V>.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        public final boolean b(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public K getKey() {
            return this.f41247a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.f41247a, entry.getKey()) && b(this.f41248b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f41248b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k11 = this.f41247a;
            int iHashCode = k11 == null ? 0 : k11.hashCode();
            V v11 = this.f41248b;
            return iHashCode ^ (v11 != null ? v11.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v11) {
            e1.this.h();
            V v12 = this.f41248b;
            this.f41248b = v11;
            return v12;
        }

        public String toString() {
            return this.f41247a + "=" + this.f41248b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f41251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f41252c;

        public f() {
            this.f41250a = -1;
        }

        public /* synthetic */ f(e1 e1Var, a aVar) {
            this();
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f41252c == null) {
                this.f41252c = e1.this.f41236c.entrySet().iterator();
            }
            return this.f41252c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f41251b = true;
            int i11 = this.f41250a + 1;
            this.f41250a = i11;
            return i11 < e1.this.f41235b.size() ? (Map.Entry) e1.this.f41235b.get(this.f41250a) : a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f41250a + 1 >= e1.this.f41235b.size()) {
                return !e1.this.f41236c.isEmpty() && a().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f41251b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f41251b = false;
            e1.this.h();
            if (this.f41250a >= e1.this.f41235b.size()) {
                a().remove();
                return;
            }
            e1 e1Var = e1.this;
            int i11 = this.f41250a;
            this.f41250a = i11 - 1;
            e1Var.u(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends AbstractSet<Map.Entry<K, V>> {
        public g() {
        }

        public /* synthetic */ g(e1 e1Var, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            e1.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            e1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = e1.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(e1.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            e1.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return e1.this.size();
        }
    }

    public e1(int i11) {
        this.f41234a = i11;
        this.f41235b = Collections.emptyList();
        this.f41236c = Collections.emptyMap();
        this.f41239g = Collections.emptyMap();
    }

    public /* synthetic */ e1(int i11, a aVar) {
        this(i11);
    }

    public static <FieldDescriptorType extends u.b<FieldDescriptorType>> e1<FieldDescriptorType, Object> s(int i11) {
        return new a(i11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.f41235b.isEmpty()) {
            this.f41235b.clear();
        }
        if (this.f41236c.isEmpty()) {
            return;
        }
        this.f41236c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return g(comparable) >= 0 || this.f41236c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f41238f == null) {
            this.f41238f = new g(this, null);
        }
        return this.f41238f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e1)) {
            return super.equals(obj);
        }
        e1 e1Var = (e1) obj;
        int size = size();
        if (size != e1Var.size()) {
            return false;
        }
        int iL = l();
        if (iL != e1Var.l()) {
            return entrySet().equals(e1Var.entrySet());
        }
        for (int i11 = 0; i11 < iL; i11++) {
            if (!k(i11).equals(e1Var.k(i11))) {
                return false;
            }
        }
        if (iL != size) {
            return this.f41236c.equals(e1Var.f41236c);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:21:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x003c A[SYNTHETIC] */
    public final int g(K k11) {
        int i11;
        int i12;
        int i13;
        int iCompareTo;
        int size = this.f41235b.size();
        int i14 = size - 1;
        if (i14 < 0) {
            i11 = 0;
            while (i11 <= i14) {
                i13 = (i11 + i14) / 2;
                iCompareTo = k11.compareTo(this.f41235b.get(i13).getKey());
                if (iCompareTo < 0) {
                    i14 = i13 - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i13;
                    }
                    i11 = i13 + 1;
                }
            }
            i12 = i11 + 1;
        } else {
            int iCompareTo2 = k11.compareTo(this.f41235b.get(i14).getKey());
            if (iCompareTo2 > 0) {
                i12 = size + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i14;
                }
                i11 = 0;
                while (i11 <= i14) {
                    i13 = (i11 + i14) / 2;
                    iCompareTo = k11.compareTo(this.f41235b.get(i13).getKey());
                    if (iCompareTo < 0) {
                        i14 = i13 - 1;
                    } else {
                        if (iCompareTo > 0) {
                            return i13;
                        }
                        i11 = i13 + 1;
                    }
                }
                i12 = i11 + 1;
            }
        }
        return -i12;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        return iG >= 0 ? this.f41235b.get(iG).getValue() : this.f41236c.get(comparable);
    }

    public final void h() {
        if (this.f41237d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iL = l();
        int iHashCode = 0;
        for (int i11 = 0; i11 < iL; i11++) {
            iHashCode += this.f41235b.get(i11).hashCode();
        }
        return m() > 0 ? iHashCode + this.f41236c.hashCode() : iHashCode;
    }

    public Set<Map.Entry<K, V>> i() {
        if (this.f41240h == null) {
            this.f41240h = new c(this, null);
        }
        return this.f41240h;
    }

    public final void j() {
        h();
        if (!this.f41235b.isEmpty() || (this.f41235b instanceof ArrayList)) {
            return;
        }
        this.f41235b = new ArrayList(this.f41234a);
    }

    public Map.Entry<K, V> k(int i11) {
        return this.f41235b.get(i11);
    }

    public int l() {
        return this.f41235b.size();
    }

    public int m() {
        return this.f41236c.size();
    }

    public Iterable<Map.Entry<K, V>> n() {
        return this.f41236c.isEmpty() ? d.b() : this.f41236c.entrySet();
    }

    public final SortedMap<K, V> p() {
        h();
        if (this.f41236c.isEmpty() && !(this.f41236c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f41236c = treeMap;
            this.f41239g = treeMap.descendingMap();
        }
        return (SortedMap) this.f41236c;
    }

    public boolean q() {
        return this.f41237d;
    }

    public void r() {
        if (this.f41237d) {
            return;
        }
        this.f41236c = this.f41236c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f41236c);
        this.f41239g = this.f41239g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f41239g);
        this.f41237d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        if (iG >= 0) {
            return u(iG);
        }
        if (this.f41236c.isEmpty()) {
            return null;
        }
        return this.f41236c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f41235b.size() + this.f41236c.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public V put(K k11, V v11) {
        h();
        int iG = g(k11);
        if (iG >= 0) {
            return this.f41235b.get(iG).setValue(v11);
        }
        j();
        int i11 = -(iG + 1);
        if (i11 >= this.f41234a) {
            return p().put(k11, v11);
        }
        int size = this.f41235b.size();
        int i12 = this.f41234a;
        if (size == i12) {
            e1<K, V>.e eVarRemove = this.f41235b.remove(i12 - 1);
            p().put(eVarRemove.getKey(), eVarRemove.getValue());
        }
        this.f41235b.add(i11, new e(k11, v11));
        return null;
    }

    public final V u(int i11) {
        h();
        V value = this.f41235b.remove(i11).getValue();
        if (!this.f41236c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = p().entrySet().iterator();
            this.f41235b.add(new e(this, it.next()));
            it.remove();
        }
        return value;
    }
}
