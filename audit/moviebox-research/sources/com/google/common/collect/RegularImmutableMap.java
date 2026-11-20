package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Object f38560a;
    final transient Object[] alternatingKeysAndValues;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient int f38561b;

    /* JADX INFO: compiled from: source.java */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient ImmutableMap<K, V> f38562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient Object[] f38563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient int f38564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f38565d;

        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i11, int i12) {
            this.f38562a = immutableMap;
            this.f38563b = objArr;
            this.f38564c = i11;
            this.f38565d = i12;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f38562a.get(key));
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i11) {
            return asList().copyIntoArray(objArr, i11);
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // java.util.List
                public Map.Entry<K, V> get(int i11) {
                    com.google.common.base.m.n(i11, EntrySet.this.f38565d);
                    int i12 = i11 * 2;
                    Object obj = EntrySet.this.f38563b[EntrySet.this.f38564c + i12];
                    Objects.requireNonNull(obj);
                    Object obj2 = EntrySet.this.f38563b[i12 + (EntrySet.this.f38564c ^ 1)];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }

                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.f38565d;
                }
            };
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public g1<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f38565d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class KeySet<K> extends ImmutableSet<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient ImmutableMap<K, ?> f38566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient ImmutableList<K> f38567b;

        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f38566a = immutableMap;
            this.f38567b = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.f38567b;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f38566a.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i11) {
            return asList().copyIntoArray(objArr, i11);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public g1<K> iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f38566a.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class KeysOrValuesAsList extends ImmutableList<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient Object[] f38568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient int f38569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient int f38570c;

        public KeysOrValuesAsList(Object[] objArr, int i11, int i12) {
            this.f38568a = objArr;
            this.f38569b = i11;
            this.f38570c = i12;
        }

        @Override // java.util.List
        public Object get(int i11) {
            com.google.common.base.m.n(i11, this.f38570c);
            Object obj = this.f38568a[(i11 * 2) + this.f38569b];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f38570c;
        }
    }

    public RegularImmutableMap(Object obj, Object[] objArr, int i11) {
        this.f38560a = obj;
        this.alternatingKeysAndValues = objArr;
        this.f38561b = i11;
    }

    public static Object a(Object[] objArr, int i11, int i12, int i13) {
        ImmutableMap.b.a aVar = null;
        if (i11 == 1) {
            Object obj = objArr[i13];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i13 ^ 1];
            Objects.requireNonNull(obj2);
            l.a(obj, obj2);
            return null;
        }
        int i14 = i12 - 1;
        int i15 = -1;
        if (i12 <= 128) {
            byte[] bArr = new byte[i12];
            Arrays.fill(bArr, (byte) -1);
            int i16 = 0;
            for (int i17 = 0; i17 < i11; i17++) {
                int i18 = (i17 * 2) + i13;
                int i19 = (i16 * 2) + i13;
                Object obj3 = objArr[i18];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i18 ^ 1];
                Objects.requireNonNull(obj4);
                l.a(obj3, obj4);
                int iC = c0.c(obj3.hashCode());
                while (true) {
                    int i21 = iC & i14;
                    int i22 = bArr[i21] & 255;
                    if (i22 == 255) {
                        bArr[i21] = (byte) i19;
                        if (i16 < i17) {
                            objArr[i19] = obj3;
                            objArr[i19 ^ 1] = obj4;
                        }
                        i16++;
                        break;
                    }
                    if (obj3.equals(objArr[i22])) {
                        int i23 = i22 ^ 1;
                        Object obj5 = objArr[i23];
                        Objects.requireNonNull(obj5);
                        aVar = new ImmutableMap.b.a(obj3, obj4, obj5);
                        objArr[i23] = obj4;
                        break;
                    }
                    iC = i21 + 1;
                }
            }
            return i16 == i11 ? bArr : new Object[]{bArr, Integer.valueOf(i16), aVar};
        }
        if (i12 <= 32768) {
            short[] sArr = new short[i12];
            Arrays.fill(sArr, (short) -1);
            int i24 = 0;
            for (int i25 = 0; i25 < i11; i25++) {
                int i26 = (i25 * 2) + i13;
                int i27 = (i24 * 2) + i13;
                Object obj6 = objArr[i26];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i26 ^ 1];
                Objects.requireNonNull(obj7);
                l.a(obj6, obj7);
                int iC2 = c0.c(obj6.hashCode());
                while (true) {
                    int i28 = iC2 & i14;
                    int i29 = sArr[i28] & 65535;
                    if (i29 == 65535) {
                        sArr[i28] = (short) i27;
                        if (i24 < i25) {
                            objArr[i27] = obj6;
                            objArr[i27 ^ 1] = obj7;
                        }
                        i24++;
                        break;
                    }
                    if (obj6.equals(objArr[i29])) {
                        int i31 = i29 ^ 1;
                        Object obj8 = objArr[i31];
                        Objects.requireNonNull(obj8);
                        aVar = new ImmutableMap.b.a(obj6, obj7, obj8);
                        objArr[i31] = obj7;
                        break;
                    }
                    iC2 = i28 + 1;
                }
            }
            return i24 == i11 ? sArr : new Object[]{sArr, Integer.valueOf(i24), aVar};
        }
        int[] iArr = new int[i12];
        Arrays.fill(iArr, -1);
        int i32 = 0;
        int i33 = 0;
        while (i32 < i11) {
            int i34 = (i32 * 2) + i13;
            int i35 = (i33 * 2) + i13;
            Object obj9 = objArr[i34];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i34 ^ 1];
            Objects.requireNonNull(obj10);
            l.a(obj9, obj10);
            int iC3 = c0.c(obj9.hashCode());
            while (true) {
                int i36 = iC3 & i14;
                int i37 = iArr[i36];
                if (i37 == i15) {
                    iArr[i36] = i35;
                    if (i33 < i32) {
                        objArr[i35] = obj9;
                        objArr[i35 ^ 1] = obj10;
                    }
                    i33++;
                    break;
                }
                if (obj9.equals(objArr[i37])) {
                    int i38 = i37 ^ 1;
                    Object obj11 = objArr[i38];
                    Objects.requireNonNull(obj11);
                    aVar = new ImmutableMap.b.a(obj9, obj10, obj11);
                    objArr[i38] = obj10;
                    break;
                }
                iC3 = i36 + 1;
                i15 = -1;
            }
            i32++;
            i15 = -1;
        }
        return i33 == i11 ? iArr : new Object[]{iArr, Integer.valueOf(i33), aVar};
    }

    public static <K, V> RegularImmutableMap<K, V> create(int i11, Object[] objArr) {
        return create(i11, objArr, null);
    }

    public static <K, V> RegularImmutableMap<K, V> create(int i11, Object[] objArr, ImmutableMap.b<K, V> bVar) {
        if (i11 == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i11 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            l.a(obj, obj2);
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        com.google.common.base.m.s(i11, objArr.length >> 1);
        Object objA = a(objArr, i11, ImmutableSet.chooseTableSize(i11), 0);
        if (objA instanceof Object[]) {
            Object[] objArr2 = (Object[]) objA;
            ImmutableMap.b.a aVar = (ImmutableMap.b.a) objArr2[2];
            if (bVar == null) {
                throw aVar.a();
            }
            bVar.f38358e = aVar;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objA = obj3;
            i11 = iIntValue;
        }
        return new RegularImmutableMap<>(objA, objArr, i11);
    }

    public static Object createHashTableOrThrow(Object[] objArr, int i11, int i12, int i13) {
        Object objA = a(objArr, i11, i12, i13);
        if (objA instanceof Object[]) {
            throw ((ImmutableMap.b.a) ((Object[]) objA)[2]).a();
        }
        return objA;
    }

    public static Object get(Object obj, Object[] objArr, int i11, int i12, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i11 == 1) {
            Object obj3 = objArr[i12];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i12 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iC = c0.c(obj2.hashCode());
            while (true) {
                int i13 = iC & length;
                int i14 = bArr[i13] & 255;
                if (i14 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i14])) {
                    return objArr[i14 ^ 1];
                }
                iC = i13 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iC2 = c0.c(obj2.hashCode());
            while (true) {
                int i15 = iC2 & length2;
                int i16 = sArr[i15] & 65535;
                if (i16 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i16])) {
                    return objArr[i16 ^ 1];
                }
                iC2 = i15 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iC3 = c0.c(obj2.hashCode());
            while (true) {
                int i17 = iC3 & length3;
                int i18 = iArr[i17];
                if (i18 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i18])) {
                    return objArr[i18 ^ 1];
                }
                iC3 = i17 + 1;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.f38561b);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.f38561b));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.f38561b);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        V v11 = (V) get(this.f38560a, this.alternatingKeysAndValues, this.f38561b, 0, obj);
        if (v11 == null) {
            return null;
        }
        return v11;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f38561b;
    }
}
