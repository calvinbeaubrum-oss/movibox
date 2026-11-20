package com.bykv.vk.openvk.preload.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Comparator<Comparable> f25523d = new Comparator<Comparable>() { // from class: com.bykv.vk.openvk.preload.a.b.g.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static /* synthetic */ boolean f25524i = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f25525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f25526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final d<K, V> f25527c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Comparator<? super K> f25528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d<K, V> f25529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g<K, V>.a f25530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private g<K, V>.b f25531h;

    /* JADX INFO: compiled from: source.java */
    public class a extends AbstractSet<Map.Entry<K, V>> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && g.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new g<K, V>.c<Map.Entry<K, V>>() { // from class: com.bykv.vk.openvk.preload.a.b.g.a.1
                {
                    g gVar = g.this;
                }

                @Override // java.util.Iterator
                public final /* synthetic */ Object next() {
                    return a();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            d<K, V> dVarA;
            if (!(obj instanceof Map.Entry) || (dVarA = g.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            g.this.a((d) dVarA, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return g.this.f25525a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b extends AbstractSet<K> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new g<K, V>.c<K>() { // from class: com.bykv.vk.openvk.preload.a.b.g.b.1
                {
                    g gVar = g.this;
                }

                @Override // java.util.Iterator
                public final K next() {
                    return a().f25545f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            return g.this.a(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return g.this.f25525a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d<K, V> f25536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d<K, V> f25537b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f25538c;

        public c() {
            this.f25536a = g.this.f25527c.f25543d;
            this.f25538c = g.this.f25526b;
        }

        public final d<K, V> a() {
            d<K, V> dVar = this.f25536a;
            g gVar = g.this;
            if (dVar == gVar.f25527c) {
                throw new NoSuchElementException();
            }
            if (gVar.f25526b != this.f25538c) {
                throw new ConcurrentModificationException();
            }
            this.f25536a = dVar.f25543d;
            this.f25537b = dVar;
            return dVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f25536a != g.this.f25527c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.f25537b;
            if (dVar == null) {
                throw new IllegalStateException();
            }
            g.this.a((d) dVar, true);
            this.f25537b = null;
            this.f25538c = g.this.f25526b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d<K, V> f25540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        d<K, V> f25541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        d<K, V> f25542c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        d<K, V> f25543d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        d<K, V> f25544e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final K f25545f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        V f25546g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f25547h;

        public d() {
            this.f25545f = null;
            this.f25544e = this;
            this.f25543d = this;
        }

        public d(d<K, V> dVar, K k11, d<K, V> dVar2, d<K, V> dVar3) {
            this.f25540a = dVar;
            this.f25545f = k11;
            this.f25547h = 1;
            this.f25543d = dVar2;
            this.f25544e = dVar3;
            dVar3.f25543d = this;
            dVar2.f25544e = this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k11 = this.f25545f;
                if (k11 != null ? k11.equals(entry.getKey()) : entry.getKey() == null) {
                    V v11 = this.f25546g;
                    if (v11 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (v11.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f25545f;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f25546g;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k11 = this.f25545f;
            int iHashCode = k11 == null ? 0 : k11.hashCode();
            V v11 = this.f25546g;
            return iHashCode ^ (v11 != null ? v11.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v11) {
            V v12 = this.f25546g;
            this.f25546g = v11;
            return v12;
        }

        public final String toString() {
            return this.f25545f + "=" + this.f25546g;
        }
    }

    public g() {
        this(f25523d);
    }

    private g(Comparator<? super K> comparator) {
        this.f25525a = 0;
        this.f25526b = 0;
        this.f25527c = new d<>();
        this.f25528e = comparator == null ? f25523d : comparator;
    }

    private d<K, V> a(K k11, boolean z11) {
        int iCompareTo;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.f25528e;
        d<K, V> dVar2 = this.f25529f;
        if (dVar2 != null) {
            Comparable comparable = comparator == f25523d ? (Comparable) k11 : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(dVar2.f25545f) : comparator.compare(k11, dVar2.f25545f);
                if (iCompareTo != 0) {
                    d<K, V> dVar3 = iCompareTo < 0 ? dVar2.f25541b : dVar2.f25542c;
                    if (dVar3 == null) {
                        break;
                    }
                    dVar2 = dVar3;
                } else {
                    return dVar2;
                }
            }
        } else {
            iCompareTo = 0;
        }
        if (!z11) {
            return null;
        }
        d<K, V> dVar4 = this.f25527c;
        if (dVar2 != null) {
            dVar = new d<>(dVar2, k11, dVar4, dVar4.f25544e);
            if (iCompareTo < 0) {
                dVar2.f25541b = dVar;
            } else {
                dVar2.f25542c = dVar;
            }
            b(dVar2, true);
        } else {
            if (comparator == f25523d && !(k11 instanceof Comparable)) {
                throw new ClassCastException(k11.getClass().getName() + " is not Comparable");
            }
            dVar = new d<>(dVar2, k11, dVar4, dVar4.f25544e);
            this.f25529f = dVar;
        }
        this.f25525a++;
        this.f25526b++;
        return dVar;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f25541b;
        d<K, V> dVar3 = dVar.f25542c;
        d<K, V> dVar4 = dVar3.f25541b;
        d<K, V> dVar5 = dVar3.f25542c;
        dVar.f25542c = dVar4;
        if (dVar4 != null) {
            dVar4.f25540a = dVar;
        }
        a(dVar, dVar3);
        dVar3.f25541b = dVar;
        dVar.f25540a = dVar3;
        int iMax = Math.max(dVar2 != null ? dVar2.f25547h : 0, dVar4 != null ? dVar4.f25547h : 0) + 1;
        dVar.f25547h = iMax;
        dVar3.f25547h = Math.max(iMax, dVar5 != null ? dVar5.f25547h : 0) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f25540a;
        dVar.f25540a = null;
        if (dVar2 != null) {
            dVar2.f25540a = dVar3;
        }
        if (dVar3 == null) {
            this.f25529f = dVar2;
            return;
        }
        if (dVar3.f25541b == dVar) {
            dVar3.f25541b = dVar2;
        } else {
            if (!f25524i && dVar3.f25542c != dVar) {
                throw new AssertionError();
            }
            dVar3.f25542c = dVar2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d<K, V> b(Object obj) {
        if (obj != 0) {
            try {
                return a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f25541b;
        d<K, V> dVar3 = dVar.f25542c;
        d<K, V> dVar4 = dVar2.f25541b;
        d<K, V> dVar5 = dVar2.f25542c;
        dVar.f25541b = dVar5;
        if (dVar5 != null) {
            dVar5.f25540a = dVar;
        }
        a(dVar, dVar2);
        dVar2.f25542c = dVar;
        dVar.f25540a = dVar2;
        int iMax = Math.max(dVar3 != null ? dVar3.f25547h : 0, dVar5 != null ? dVar5.f25547h : 0) + 1;
        dVar.f25547h = iMax;
        dVar2.f25547h = Math.max(iMax, dVar4 != null ? dVar4.f25547h : 0) + 1;
    }

    private void b(d<K, V> dVar, boolean z11) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f25541b;
            d<K, V> dVar3 = dVar.f25542c;
            int i11 = dVar2 != null ? dVar2.f25547h : 0;
            int i12 = dVar3 != null ? dVar3.f25547h : 0;
            int i13 = i11 - i12;
            if (i13 == -2) {
                d<K, V> dVar4 = dVar3.f25541b;
                d<K, V> dVar5 = dVar3.f25542c;
                int i14 = (dVar4 != null ? dVar4.f25547h : 0) - (dVar5 != null ? dVar5.f25547h : 0);
                if (i14 == -1 || (i14 == 0 && !z11)) {
                    a((d) dVar);
                } else {
                    if (!f25524i && i14 != 1) {
                        throw new AssertionError();
                    }
                    b((d) dVar3);
                    a((d) dVar);
                }
                if (z11) {
                    return;
                }
            } else if (i13 == 2) {
                d<K, V> dVar6 = dVar2.f25541b;
                d<K, V> dVar7 = dVar2.f25542c;
                int i15 = (dVar6 != null ? dVar6.f25547h : 0) - (dVar7 != null ? dVar7.f25547h : 0);
                if (i15 == 1 || (i15 == 0 && !z11)) {
                    b((d) dVar);
                } else {
                    if (!f25524i && i15 != -1) {
                        throw new AssertionError();
                    }
                    a((d) dVar2);
                    b((d) dVar);
                }
                if (z11) {
                    return;
                }
            } else if (i13 == 0) {
                dVar.f25547h = i11 + 1;
                if (z11) {
                    return;
                }
            } else {
                if (!f25524i && i13 != -1 && i13 != 1) {
                    throw new AssertionError();
                }
                dVar.f25547h = Math.max(i11, i12) + 1;
                if (!z11) {
                    return;
                }
            }
            dVar = dVar.f25540a;
        }
    }

    public final d<K, V> a(Object obj) {
        d<K, V> dVarB = b(obj);
        if (dVarB != null) {
            a((d) dVarB, true);
        }
        return dVarB;
    }

    public final d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> dVarB = b(entry.getKey());
        if (dVarB == null) {
            return null;
        }
        V v11 = dVarB.f25546g;
        Object value = entry.getValue();
        if (v11 == value || (v11 != null && v11.equals(value))) {
            return dVarB;
        }
        return null;
    }

    public final void a(d<K, V> dVar, boolean z11) {
        int i11;
        if (z11) {
            d<K, V> dVar2 = dVar.f25544e;
            dVar2.f25543d = dVar.f25543d;
            dVar.f25543d.f25544e = dVar2;
        }
        d<K, V> dVar3 = dVar.f25541b;
        d<K, V> dVar4 = dVar.f25542c;
        d<K, V> dVar5 = dVar.f25540a;
        int i12 = 0;
        if (dVar3 == null || dVar4 == null) {
            if (dVar3 != null) {
                a(dVar, dVar3);
                dVar.f25541b = null;
            } else if (dVar4 != null) {
                a(dVar, dVar4);
                dVar.f25542c = null;
            } else {
                a(dVar, (d) null);
            }
            b(dVar5, false);
            this.f25525a--;
            this.f25526b++;
            return;
        }
        if (dVar3.f25547h > dVar4.f25547h) {
            d<K, V> dVar6 = dVar3.f25542c;
            while (true) {
                d<K, V> dVar7 = dVar6;
                dVar4 = dVar3;
                dVar3 = dVar7;
                if (dVar3 == null) {
                    break;
                } else {
                    dVar6 = dVar3.f25542c;
                }
            }
        } else {
            while (true) {
                d<K, V> dVar8 = dVar4.f25541b;
                if (dVar8 == null) {
                    break;
                } else {
                    dVar4 = dVar8;
                }
            }
        }
        a((d) dVar4, false);
        d<K, V> dVar9 = dVar.f25541b;
        if (dVar9 != null) {
            i11 = dVar9.f25547h;
            dVar4.f25541b = dVar9;
            dVar9.f25540a = dVar4;
            dVar.f25541b = null;
        } else {
            i11 = 0;
        }
        d<K, V> dVar10 = dVar.f25542c;
        if (dVar10 != null) {
            i12 = dVar10.f25547h;
            dVar4.f25542c = dVar10;
            dVar10.f25540a = dVar4;
            dVar.f25542c = null;
        }
        dVar4.f25547h = Math.max(i11, i12) + 1;
        a(dVar, dVar4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f25529f = null;
        this.f25525a = 0;
        this.f25526b++;
        d<K, V> dVar = this.f25527c;
        dVar.f25544e = dVar;
        dVar.f25543d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return b(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.a aVar = this.f25530g;
        if (aVar != null) {
            return aVar;
        }
        g<K, V>.a aVar2 = new a();
        this.f25530g = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        d<K, V> dVarB = b(obj);
        if (dVarB != null) {
            return dVarB.f25546g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        g<K, V>.b bVar = this.f25531h;
        if (bVar != null) {
            return bVar;
        }
        g<K, V>.b bVar2 = new b();
        this.f25531h = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k11, V v11) {
        if (k11 == null) {
            throw new NullPointerException("key == null");
        }
        d<K, V> dVarA = a((Object) k11, true);
        V v12 = dVarA.f25546g;
        dVarA.f25546g = v11;
        return v12;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        d<K, V> dVarA = a(obj);
        if (dVarA != null) {
            return dVarA.f25546g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f25525a;
    }
}
