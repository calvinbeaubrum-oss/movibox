package com.facebook.ads.redexgen.uinode;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC10202y<K, V> {

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/2y<TK;TV;>.EntrySet; */
    public C10162u A00;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/2y<TK;TV;>.KeySet; */
    public C10172v A01;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/2y<TK;TV;>.ValuesCollection; */
    public C10192x A02;

    public static <K, V> boolean A00(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean A01(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean A02(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public static <T> boolean A03(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused2) {
            return false;
        }
    }

    public abstract int A04();

    public abstract int A05(Object obj);

    public abstract int A06(Object obj);

    public abstract Map<K, V> A07();

    public final Set<Map.Entry<K, V>> A08() {
        if (this.A00 == null) {
            this.A00 = new Set<Map.Entry<K, V>>() { // from class: com.facebook.ads.redexgen.X.2u
                private final boolean A00(Map.Entry<K, V> entry) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public final /* bridge */ /* synthetic */ boolean add(Object obj) {
                    A00((Map.Entry) obj);
                    throw null;
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
                    int iA04 = this.A00.A04();
                    for (Map.Entry<K, V> entry : collection) {
                        this.A00.A0F(entry.getKey(), entry.getValue());
                    }
                    return iA04 != this.A00.A04();
                }

                @Override // java.util.Set, java.util.Collection
                public final void clear() {
                    this.A00.A0D();
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean contains(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    int iA05 = this.A00.A05(entry.getKey());
                    if (iA05 < 0) {
                        return false;
                    }
                    return AbstractC10132r.A04(this.A00.A0B(iA05, 1), entry.getValue());
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean containsAll(Collection<?> collection) {
                    Iterator<?> it = collection.iterator();
                    while (it.hasNext()) {
                        if (!contains(it.next())) {
                            return false;
                        }
                    }
                    return true;
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean equals(Object obj) {
                    return AbstractC10202y.A03(this, obj);
                }

                @Override // java.util.Set, java.util.Collection
                public final int hashCode() {
                    int i11 = 0;
                    for (int iA04 = this.A00.A04() - 1; iA04 >= 0; iA04--) {
                        int iHashCode = 0;
                        Object objA0B = this.A00.A0B(iA04, 0);
                        Object objA0B2 = this.A00.A0B(iA04, 1);
                        int iHashCode2 = objA0B == null ? 0 : objA0B.hashCode();
                        if (objA0B2 != null) {
                            iHashCode = objA0B2.hashCode();
                        }
                        i11 += iHashCode ^ iHashCode2;
                    }
                    return i11;
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean isEmpty() {
                    return this.A00.A04() == 0;
                }

                @Override // java.util.Set, java.util.Collection, java.lang.Iterable
                public final Iterator<Map.Entry<K, V>> iterator() {
                    return new C10182w(this.A00);
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean remove(Object obj) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean removeAll(Collection<?> collection) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean retainAll(Collection<?> collection) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public final int size() {
                    return this.A00.A04();
                }

                @Override // java.util.Set, java.util.Collection
                public final Object[] toArray() {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    throw new UnsupportedOperationException();
                }
            };
        }
        return this.A00;
    }

    public final Set<K> A09() {
        if (this.A01 == null) {
            this.A01 = new Set<K>() { // from class: com.facebook.ads.redexgen.X.2v
                @Override // java.util.Set, java.util.Collection
                public final boolean add(K k11) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean addAll(Collection<? extends K> collection) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public final void clear() {
                    this.A00.A0D();
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean contains(Object obj) {
                    return this.A00.A05(obj) >= 0;
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean containsAll(Collection<?> collection) {
                    return AbstractC10202y.A00(this.A00.A07(), collection);
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean equals(Object obj) {
                    return AbstractC10202y.A03(this, obj);
                }

                @Override // java.util.Set, java.util.Collection
                public final int hashCode() {
                    int i11 = 0;
                    for (int iA04 = this.A00.A04() - 1; iA04 >= 0; iA04--) {
                        int iHashCode = 0;
                        Object objA0B = this.A00.A0B(iA04, 0);
                        if (objA0B != null) {
                            iHashCode = objA0B.hashCode();
                        }
                        i11 += iHashCode;
                    }
                    return i11;
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean isEmpty() {
                    return this.A00.A04() == 0;
                }

                @Override // java.util.Set, java.util.Collection, java.lang.Iterable
                public final Iterator<K> iterator() {
                    return new C10152t(this.A00, 0);
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean remove(Object obj) {
                    int iA05 = this.A00.A05(obj);
                    if (iA05 < 0) {
                        return false;
                    }
                    this.A00.A0E(iA05);
                    return true;
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean removeAll(Collection<?> collection) {
                    return AbstractC10202y.A01(this.A00.A07(), collection);
                }

                @Override // java.util.Set, java.util.Collection
                public final boolean retainAll(Collection<?> collection) {
                    return AbstractC10202y.A02(this.A00.A07(), collection);
                }

                @Override // java.util.Set, java.util.Collection
                public final int size() {
                    return this.A00.A04();
                }

                @Override // java.util.Set, java.util.Collection
                public final Object[] toArray() {
                    return this.A00.A0G(0);
                }

                @Override // java.util.Set, java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    return (T[]) this.A00.A0H(tArr, 0);
                }
            };
        }
        return this.A01;
    }

    public final Collection<V> A0A() {
        if (this.A02 == null) {
            this.A02 = new Collection<V>() { // from class: com.facebook.ads.redexgen.X.2x
                public static String[] A01 = {"WaXEENy4Qqf0iZa9rE7K5Tc", "CdcJslr1GuWzD3hgs8KQ2mZhu", "VqX8APEjT5Wjv2WgYqLWWETF9QEoqL89", "1lDdPMX0zjCtSNVsVcyG9UOAfTksMFfY", "Q30AX00aPMLh2Hp2SxjAPSj4hvT3yuLk", "DGZ9hWDjpXQG3w", "JKstht1TU3rAhNk0s2YNIFhF9tCkCvUD", "xnB3F8eRzgUElZJXVWbAPi1tu19rGp71"};

                @Override // java.util.Collection
                public final boolean add(V v11) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Collection
                public final boolean addAll(Collection<? extends V> collection) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Collection
                public final void clear() {
                    this.A00.A0D();
                }

                @Override // java.util.Collection
                public final boolean contains(Object obj) {
                    return this.A00.A06(obj) >= 0;
                }

                @Override // java.util.Collection
                public final boolean containsAll(Collection<?> collection) {
                    Iterator<?> it = collection.iterator();
                    while (it.hasNext()) {
                        if (!contains(it.next())) {
                            return false;
                        }
                    }
                    return true;
                }

                @Override // java.util.Collection
                public final boolean isEmpty() {
                    return this.A00.A04() == 0;
                }

                @Override // java.util.Collection, java.lang.Iterable
                public final Iterator<V> iterator() {
                    return new C10152t(this.A00, 1);
                }

                @Override // java.util.Collection
                public final boolean remove(Object obj) {
                    int iA06 = this.A00.A06(obj);
                    if (iA06 >= 0) {
                        this.A00.A0E(iA06);
                        return true;
                    }
                    if (A01[6].charAt(4) == 'M') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[1] = "JaPNh4sPI8rJ5EjhCFrDgKQsA";
                    strArr[5] = "wvLzjGRSTCxgOw";
                    return false;
                }

                @Override // java.util.Collection
                public final boolean removeAll(Collection<?> collection) {
                    int iA04 = this.A00.A04();
                    boolean z11 = false;
                    int i11 = 0;
                    while (i11 < iA04) {
                        if (collection.contains(this.A00.A0B(i11, 1))) {
                            this.A00.A0E(i11);
                            i11--;
                            iA04--;
                            z11 = true;
                        }
                        i11++;
                    }
                    return z11;
                }

                @Override // java.util.Collection
                public final boolean retainAll(Collection<?> collection) {
                    int iA04 = this.A00.A04();
                    boolean z11 = false;
                    int i11 = 0;
                    while (i11 < iA04) {
                        if (!collection.contains(this.A00.A0B(i11, 1))) {
                            this.A00.A0E(i11);
                            i11--;
                            iA04--;
                            z11 = true;
                        }
                        i11++;
                    }
                    return z11;
                }

                @Override // java.util.Collection
                public final int size() {
                    return this.A00.A04();
                }

                @Override // java.util.Collection
                public final Object[] toArray() {
                    return this.A00.A0G(1);
                }

                @Override // java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    return (T[]) this.A00.A0H(tArr, 1);
                }
            };
        }
        return this.A02;
    }

    public abstract Object A0B(int i11, int i12);

    public abstract V A0C(int i11, V v11);

    public abstract void A0D();

    public abstract void A0E(int i11);

    public abstract void A0F(K k11, V v11);

    public final Object[] A0G(int i11) {
        int iA04 = A04();
        Object[] objArr = new Object[iA04];
        for (int i12 = 0; i12 < iA04; i12++) {
            objArr[i12] = A0B(i12, i11);
        }
        return objArr;
    }

    public final <T> T[] A0H(T[] tArr, int i11) {
        int iA04 = A04();
        if (tArr.length < iA04) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iA04));
        }
        for (int i12 = 0; i12 < iA04; i12++) {
            tArr[i12] = A0B(i12, i11);
        }
        if (tArr.length > iA04) {
            tArr[iA04] = null;
        }
        return tArr;
    }
}
