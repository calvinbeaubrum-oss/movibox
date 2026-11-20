package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.IntRange;
import kotlin.ranges.a;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    public static final Companion Companion = new Companion(null);
    private static final MapBuilder Empty;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;
    private MapBuilderEntries<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private MapBuilderKeys<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private MapBuilderValues<V> valuesView;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int c(int i11) {
            return Integer.highestOneBit(a.d(i11, 1) * 3);
        }

        public final int d(int i11) {
            return Integer.numberOfLeadingZeros(i11) + 1;
        }

        public final MapBuilder e() {
            return MapBuilder.Empty;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntriesItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.g(map, "map");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public EntryRef<K, V> next() {
            a();
            if (c() >= ((MapBuilder) f()).length) {
                throw new NoSuchElementException();
            }
            int iC = c();
            i(iC + 1);
            j(iC);
            EntryRef<K, V> entryRef = new EntryRef<>(f(), d());
            g();
            return entryRef;
        }

        public final void l(StringBuilder sb2) {
            Intrinsics.g(sb2, "sb");
            if (c() >= ((MapBuilder) f()).length) {
                throw new NoSuchElementException();
            }
            int iC = c();
            i(iC + 1);
            j(iC);
            Object obj = ((MapBuilder) f()).keysArray[d()];
            if (obj == f()) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = ((MapBuilder) f()).valuesArray;
            Intrinsics.d(objArr);
            Object obj2 = objArr[d()];
            if (obj2 == f()) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            g();
        }

        public final int m() {
            if (c() >= ((MapBuilder) f()).length) {
                throw new NoSuchElementException();
            }
            int iC = c();
            i(iC + 1);
            j(iC);
            Object obj = ((MapBuilder) f()).keysArray[d()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = ((MapBuilder) f()).valuesArray;
            Intrinsics.d(objArr);
            Object obj2 = objArr[d()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            g();
            return iHashCode2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MapBuilder<K, V> f68794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f68795b;

        public EntryRef(MapBuilder<K, V> map, int i11) {
            Intrinsics.g(map, "map");
            this.f68794a = map;
            this.f68795b = i11;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (Intrinsics.b(entry.getKey(), getKey()) && Intrinsics.b(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.f68794a).keysArray[this.f68795b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.f68794a).valuesArray;
            Intrinsics.d(objArr);
            return (V) objArr[this.f68795b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v11) {
            this.f68794a.checkIsMutable$kotlin_stdlib();
            Object[] objArrAllocateValuesArray = this.f68794a.allocateValuesArray();
            int i11 = this.f68795b;
            V v12 = (V) objArrAllocateValuesArray[i11];
            objArrAllocateValuesArray[i11] = v11;
            return v12;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append('=');
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    @SourceDebugExtension
    public static class Itr<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MapBuilder<K, V> f68796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f68797b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f68798c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f68799d;

        public Itr(MapBuilder<K, V> map) {
            Intrinsics.g(map, "map");
            this.f68796a = map;
            this.f68798c = -1;
            this.f68799d = ((MapBuilder) map).modCount;
            g();
        }

        public final void a() {
            if (((MapBuilder) this.f68796a).modCount != this.f68799d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int c() {
            return this.f68797b;
        }

        public final int d() {
            return this.f68798c;
        }

        public final MapBuilder<K, V> f() {
            return this.f68796a;
        }

        public final void g() {
            while (this.f68797b < ((MapBuilder) this.f68796a).length) {
                int[] iArr = ((MapBuilder) this.f68796a).presenceArray;
                int i11 = this.f68797b;
                if (iArr[i11] >= 0) {
                    return;
                } else {
                    this.f68797b = i11 + 1;
                }
            }
        }

        public final boolean hasNext() {
            return this.f68797b < ((MapBuilder) this.f68796a).length;
        }

        public final void i(int i11) {
            this.f68797b = i11;
        }

        public final void j(int i11) {
            this.f68798c = i11;
        }

        public final void remove() {
            a();
            if (this.f68798c == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.f68796a.checkIsMutable$kotlin_stdlib();
            this.f68796a.removeKeyAt(this.f68798c);
            this.f68798c = -1;
            this.f68799d = ((MapBuilder) this.f68796a).modCount;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeysItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.g(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            a();
            if (c() >= ((MapBuilder) f()).length) {
                throw new NoSuchElementException();
            }
            int iC = c();
            i(iC + 1);
            j(iC);
            K k11 = (K) ((MapBuilder) f()).keysArray[d()];
            g();
            return k11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValuesItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.g(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            a();
            if (c() >= ((MapBuilder) f()).length) {
                throw new NoSuchElementException();
            }
            int iC = c();
            i(iC + 1);
            j(iC);
            Object[] objArr = ((MapBuilder) f()).valuesArray;
            Intrinsics.d(objArr);
            V v11 = (V) objArr[d()];
            g();
            return v11;
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        Empty = mapBuilder;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i11) {
        this(ListBuilderKt.d(i11), null, new int[i11], new int[Companion.c(i11)], 2, 0);
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i11, int i12) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i11;
        this.length = i12;
        this.hashShift = Companion.d(getHashSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) ListBuilderKt.d(getCapacity$kotlin_stdlib());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact() {
        int i11;
        V[] vArr = this.valuesArray;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            i11 = this.length;
            if (i12 >= i11) {
                break;
            }
            if (this.presenceArray[i12] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i13] = kArr[i12];
                if (vArr != null) {
                    vArr[i13] = vArr[i12];
                }
                i13++;
            }
            i12++;
        }
        ListBuilderKt.g(this.keysArray, i13, i11);
        if (vArr != null) {
            ListBuilderKt.g(vArr, i13, this.length);
        }
        this.length = i13;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    private final void ensureCapacity(int i11) {
        if (i11 < 0) {
            throw new OutOfMemoryError();
        }
        if (i11 > getCapacity$kotlin_stdlib()) {
            int iE = AbstractList.Companion.e(getCapacity$kotlin_stdlib(), i11);
            this.keysArray = (K[]) ListBuilderKt.e(this.keysArray, iE);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) ListBuilderKt.e(vArr, iE) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.presenceArray, iE);
            Intrinsics.f(iArrCopyOf, "copyOf(...)");
            this.presenceArray = iArrCopyOf;
            int iC = Companion.c(iE);
            if (iC > getHashSize()) {
                rehash(iC);
            }
        }
    }

    private final void ensureExtraCapacity(int i11) {
        if (shouldCompact(i11)) {
            rehash(getHashSize());
        } else {
            ensureCapacity(this.length + i11);
        }
    }

    private final int findKey(K k11) {
        int iHash = hash(k11);
        int i11 = this.maxProbeDistance;
        while (true) {
            int i12 = this.hashArray[iHash];
            if (i12 == 0) {
                return -1;
            }
            if (i12 > 0) {
                int i13 = i12 - 1;
                if (Intrinsics.b(this.keysArray[i13], k11)) {
                    return i13;
                }
            }
            i11--;
            if (i11 < 0) {
                return -1;
            }
            iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
        }
    }

    private final int findValue(V v11) {
        int i11 = this.length;
        while (true) {
            i11--;
            if (i11 < 0) {
                return -1;
            }
            if (this.presenceArray[i11] >= 0) {
                V[] vArr = this.valuesArray;
                Intrinsics.d(vArr);
                if (Intrinsics.b(vArr[i11], v11)) {
                    return i11;
                }
            }
        }
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k11) {
        return ((k11 != null ? k11.hashCode() : 0) * MAGIC) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z11 = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = collection.iterator();
        while (it.hasNext()) {
            if (putEntry(it.next())) {
                z11 = true;
            }
        }
        return z11;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] vArrAllocateValuesArray = allocateValuesArray();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrAllocateValuesArray[iAddKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i11 = (-iAddKey$kotlin_stdlib) - 1;
        if (Intrinsics.b(entry.getValue(), vArrAllocateValuesArray[i11])) {
            return false;
        }
        vArrAllocateValuesArray[i11] = entry.getValue();
        return true;
    }

    private final boolean putRehash(int i11) {
        int iHash = hash(this.keysArray[i11]);
        int i12 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[iHash] == 0) {
                iArr[iHash] = i11 + 1;
                this.presenceArray[i11] = iHash;
                return true;
            }
            i12--;
            if (i12 < 0) {
                return false;
            }
            iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
        }
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final void rehash(int i11) {
        registerModification();
        if (this.length > size()) {
            compact();
        }
        int i12 = 0;
        if (i11 != getHashSize()) {
            this.hashArray = new int[i11];
            this.hashShift = Companion.d(i11);
        } else {
            ArraysKt___ArraysJvmKt.s(this.hashArray, 0, 0, getHashSize());
        }
        while (i12 < this.length) {
            int i13 = i12 + 1;
            if (!putRehash(i12)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i12 = i13;
        }
    }

    private final void removeHashAt(int i11) {
        int iG = a.g(this.maxProbeDistance * 2, getHashSize() / 2);
        int i12 = 0;
        int i13 = i11;
        do {
            i11 = i11 == 0 ? getHashSize() - 1 : i11 - 1;
            i12++;
            if (i12 > this.maxProbeDistance) {
                this.hashArray[i13] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i14 = iArr[i11];
            if (i14 == 0) {
                iArr[i13] = 0;
                return;
            }
            if (i14 < 0) {
                iArr[i13] = -1;
            } else {
                int i15 = i14 - 1;
                if (((hash(this.keysArray[i15]) - i11) & (getHashSize() - 1)) >= i12) {
                    this.hashArray[i13] = i14;
                    this.presenceArray[i15] = i13;
                }
                iG--;
            }
            i13 = i11;
            i12 = 0;
            iG--;
        } while (iG >= 0);
        this.hashArray[i13] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKeyAt(int i11) {
        ListBuilderKt.f(this.keysArray, i11);
        removeHashAt(this.presenceArray[i11]);
        this.presenceArray[i11] = -1;
        this.size = size() - 1;
        registerModification();
    }

    private final boolean shouldCompact(int i11) {
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i12 = this.length;
        int i13 = capacity$kotlin_stdlib - i12;
        int size = i12 - size();
        return i13 < i11 && i13 + size >= i11 && size >= getCapacity$kotlin_stdlib() / 4;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K k11) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iHash = hash(k11);
            int iG = a.g(this.maxProbeDistance * 2, getHashSize() / 2);
            int i11 = 0;
            while (true) {
                int i12 = this.hashArray[iHash];
                if (i12 <= 0) {
                    if (this.length >= getCapacity$kotlin_stdlib()) {
                        ensureExtraCapacity(1);
                        break;
                    }
                    int i13 = this.length;
                    int i14 = i13 + 1;
                    this.length = i14;
                    this.keysArray[i13] = k11;
                    this.presenceArray[i13] = iHash;
                    this.hashArray[iHash] = i14;
                    this.size = size() + 1;
                    registerModification();
                    if (i11 > this.maxProbeDistance) {
                        this.maxProbeDistance = i11;
                    }
                    return i13;
                }
                if (Intrinsics.b(this.keysArray[i12 - 1], k11)) {
                    return -i12;
                }
                i11++;
                if (i11 > iG) {
                    rehash(getHashSize() * 2);
                    break;
                }
                iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
            }
        }
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = Empty;
        Intrinsics.e(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        IntIterator it = new IntRange(0, this.length - 1).iterator();
        while (it.hasNext()) {
            int iA = it.a();
            int[] iArr = this.presenceArray;
            int i11 = iArr[iA];
            if (i11 >= 0) {
                this.hashArray[i11] = 0;
                iArr[iA] = -1;
            }
        }
        ListBuilderKt.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            ListBuilderKt.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        registerModification();
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> m11) {
        Intrinsics.g(m11, "m");
        for (Object obj : m11) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.g(entry, "entry");
        int iFindKey = findKey(entry.getKey());
        if (iFindKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.d(vArr);
        return Intrinsics.b(vArr[iFindKey], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && contentEquals((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int iFindKey = findKey(obj);
        if (iFindKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.d(vArr);
        return vArr[iFindKey];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.entriesView;
        if (mapBuilderEntries != null) {
            return mapBuilderEntries;
        }
        MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
        this.entriesView = mapBuilderEntries2;
        return mapBuilderEntries2;
    }

    public Set<K> getKeys() {
        MapBuilderKeys<K> mapBuilderKeys = this.keysView;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
        this.keysView = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        MapBuilderValues<V> mapBuilderValues = this.valuesView;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
        this.valuesView = mapBuilderValues2;
        return mapBuilderValues2;
    }

    @Override // java.util.Map
    public int hashCode() {
        EntriesItr<K, V> entriesItrEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int iM = 0;
        while (entriesItrEntriesIterator$kotlin_stdlib.hasNext()) {
            iM += entriesItrEntriesIterator$kotlin_stdlib.m();
        }
        return iM;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr<>(this);
    }

    @Override // java.util.Map
    public V put(K k11, V v11) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(k11);
        V[] vArrAllocateValuesArray = allocateValuesArray();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrAllocateValuesArray[iAddKey$kotlin_stdlib] = v11;
            return null;
        }
        int i11 = (-iAddKey$kotlin_stdlib) - 1;
        V v12 = vArrAllocateValuesArray[i11];
        vArrAllocateValuesArray[i11] = v11;
        return v12;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics.g(from, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        int iRemoveKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (iRemoveKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.d(vArr);
        V v11 = vArr[iRemoveKey$kotlin_stdlib];
        ListBuilderKt.f(vArr, iRemoveKey$kotlin_stdlib);
        return v11;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.g(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iFindKey = findKey(entry.getKey());
        if (iFindKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.d(vArr);
        if (!Intrinsics.b(vArr[iFindKey], entry.getValue())) {
            return false;
        }
        removeKeyAt(iFindKey);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k11) {
        checkIsMutable$kotlin_stdlib();
        int iFindKey = findKey(k11);
        if (iFindKey < 0) {
            return -1;
        }
        removeKeyAt(iFindKey);
        return iFindKey;
    }

    public final boolean removeValue$kotlin_stdlib(V v11) {
        checkIsMutable$kotlin_stdlib();
        int iFindValue = findValue(v11);
        if (iFindValue < 0) {
            return false;
        }
        removeKeyAt(iFindValue);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        EntriesItr<K, V> entriesItrEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i11 = 0;
        while (entriesItrEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            entriesItrEntriesIterator$kotlin_stdlib.l(sb2);
            i11++;
        }
        sb2.append("}");
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr<>(this);
    }
}
