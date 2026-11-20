package androidx.collection;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public class v0<K, V> {
    private Object[] array;
    private int[] hashes;
    private int size;

    @JvmOverloads
    public v0() {
        this(0, 1, null);
    }

    @JvmOverloads
    public v0(int i11) {
        this.hashes = i11 == 0 ? m1.a.f70585a : new int[i11];
        this.array = i11 == 0 ? m1.a.f70587c : new Object[i11 << 1];
    }

    public /* synthetic */ v0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }

    public v0(v0<? extends K, ? extends V> v0Var) {
        this(0, 1, null);
        if (v0Var != null) {
            putAll(v0Var);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends V> T getOrDefaultInternal(Object obj, T t11) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (T) this.array[(iIndexOfKey << 1) + 1] : t11;
    }

    private final int indexOf(K k11, int i11) {
        int i12 = this.size;
        if (i12 == 0) {
            return -1;
        }
        int iA = m1.a.a(this.hashes, i12, i11);
        if (iA < 0 || Intrinsics.b(k11, this.array[iA << 1])) {
            return iA;
        }
        int i13 = iA + 1;
        while (i13 < i12 && this.hashes[i13] == i11) {
            if (Intrinsics.b(k11, this.array[i13 << 1])) {
                return i13;
            }
            i13++;
        }
        for (int i14 = iA - 1; i14 >= 0 && this.hashes[i14] == i11; i14--) {
            if (Intrinsics.b(k11, this.array[i14 << 1])) {
                return i14;
            }
        }
        return ~i13;
    }

    private final int indexOfNull() {
        int i11 = this.size;
        if (i11 == 0) {
            return -1;
        }
        int iA = m1.a.a(this.hashes, i11, 0);
        if (iA < 0 || this.array[iA << 1] == null) {
            return iA;
        }
        int i12 = iA + 1;
        while (i12 < i11 && this.hashes[i12] == 0) {
            if (this.array[i12 << 1] == null) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iA - 1; i13 >= 0 && this.hashes[i13] == 0; i13--) {
            if (this.array[i13 << 1] == null) {
                return i13;
            }
        }
        return ~i12;
    }

    @JvmName
    public final int __restricted$indexOfValue(V v11) {
        int i11 = this.size * 2;
        Object[] objArr = this.array;
        if (v11 == null) {
            for (int i12 = 1; i12 < i11; i12 += 2) {
                if (objArr[i12] == null) {
                    return i12 >> 1;
                }
            }
            return -1;
        }
        for (int i13 = 1; i13 < i11; i13 += 2) {
            if (Intrinsics.b(v11, objArr[i13])) {
                return i13 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = m1.a.f70585a;
            this.array = m1.a.f70587c;
            this.size = 0;
        }
        if (this.size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K k11) {
        return indexOfKey(k11) >= 0;
    }

    public boolean containsValue(V v11) {
        return __restricted$indexOfValue(v11) >= 0;
    }

    public void ensureCapacity(int i11) {
        int i12 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < i11) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i11);
            Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i11 * 2);
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.array = objArrCopyOf;
        }
        if (this.size != i12) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof v0) {
                if (size() != ((v0) obj).size()) {
                    return false;
                }
                v0 v0Var = (v0) obj;
                int i11 = this.size;
                for (int i12 = 0; i12 < i11; i12++) {
                    K kKeyAt = keyAt(i12);
                    V vValueAt = valueAt(i12);
                    Object obj2 = v0Var.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj2 != null || !v0Var.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!Intrinsics.b(vValueAt, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i13 = this.size;
            for (int i14 = 0; i14 < i13; i14++) {
                K kKeyAt2 = keyAt(i14);
                V vValueAt2 = valueAt(i14);
                Object obj3 = ((Map) obj).get(kKeyAt2);
                if (vValueAt2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(kKeyAt2)) {
                        return false;
                    }
                } else if (!Intrinsics.b(vValueAt2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public V get(K k11) {
        int iIndexOfKey = indexOfKey(k11);
        if (iIndexOfKey >= 0) {
            return (V) this.array[(iIndexOfKey << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object obj, V v11) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (V) this.array[(iIndexOfKey << 1) + 1] : v11;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i11 = this.size;
        int i12 = 1;
        int i13 = 0;
        int iHashCode = 0;
        while (i13 < i11) {
            Object obj = objArr[i12];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i13];
            i13++;
            i12 += 2;
        }
        return iHashCode;
    }

    public int indexOfKey(K k11) {
        return k11 == null ? indexOfNull() : indexOf(k11, k11.hashCode());
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public K keyAt(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 < this.size) {
            z11 = true;
        }
        if (!z11) {
            m1.d.a("Expected index to be within 0..size()-1, but was " + i11);
        }
        return (K) this.array[i11 << 1];
    }

    public V put(K k11, V v11) {
        int i11 = this.size;
        int iHashCode = k11 != null ? k11.hashCode() : 0;
        int iIndexOf = k11 != null ? indexOf(k11, iHashCode) : indexOfNull();
        if (iIndexOf >= 0) {
            int i12 = (iIndexOf << 1) + 1;
            Object[] objArr = this.array;
            V v12 = (V) objArr[i12];
            objArr[i12] = v11;
            return v12;
        }
        int i13 = ~iIndexOf;
        int[] iArr = this.hashes;
        if (i11 >= iArr.length) {
            int i14 = 8;
            if (i11 >= 8) {
                i14 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i14 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i14);
            Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i14 << 1);
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.array = objArrCopyOf;
            if (i11 != this.size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i13 < i11) {
            int[] iArr2 = this.hashes;
            int i15 = i13 + 1;
            ArraysKt___ArraysJvmKt.j(iArr2, iArr2, i15, i13, i11);
            Object[] objArr2 = this.array;
            ArraysKt___ArraysJvmKt.l(objArr2, objArr2, i15 << 1, i13 << 1, this.size << 1);
        }
        int i16 = this.size;
        if (i11 == i16) {
            int[] iArr3 = this.hashes;
            if (i13 < iArr3.length) {
                iArr3[i13] = iHashCode;
                Object[] objArr3 = this.array;
                int i17 = i13 << 1;
                objArr3[i17] = k11;
                objArr3[i17 + 1] = v11;
                this.size = i16 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(v0<? extends K, ? extends V> map) {
        Intrinsics.g(map, "map");
        int i11 = map.size;
        ensureCapacity(this.size + i11);
        if (this.size != 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                put(map.keyAt(i12), map.valueAt(i12));
            }
        } else if (i11 > 0) {
            ArraysKt___ArraysJvmKt.j(map.hashes, this.hashes, 0, 0, i11);
            ArraysKt___ArraysJvmKt.l(map.array, this.array, 0, 0, i11 << 1);
            this.size = i11;
        }
    }

    public V putIfAbsent(K k11, V v11) {
        V v12 = get(k11);
        return v12 == null ? put(k11, v11) : v12;
    }

    public V remove(K k11) {
        int iIndexOfKey = indexOfKey(k11);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public boolean remove(K k11, V v11) {
        int iIndexOfKey = indexOfKey(k11);
        if (iIndexOfKey < 0 || !Intrinsics.b(v11, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public V removeAt(int i11) {
        if (!(i11 >= 0 && i11 < this.size)) {
            m1.d.a("Expected index to be within 0..size()-1, but was " + i11);
        }
        Object[] objArr = this.array;
        int i12 = i11 << 1;
        V v11 = (V) objArr[i12 + 1];
        int i13 = this.size;
        if (i13 <= 1) {
            clear();
        } else {
            int i14 = i13 - 1;
            int[] iArr = this.hashes;
            if (iArr.length <= 8 || i13 >= iArr.length / 3) {
                if (i11 < i14) {
                    int i15 = i11 + 1;
                    ArraysKt___ArraysJvmKt.j(iArr, iArr, i11, i15, i13);
                    Object[] objArr2 = this.array;
                    ArraysKt___ArraysJvmKt.l(objArr2, objArr2, i12, i15 << 1, i13 << 1);
                }
                Object[] objArr3 = this.array;
                int i16 = i14 << 1;
                objArr3[i16] = null;
                objArr3[i16 + 1] = null;
            } else {
                int i17 = i13 > 8 ? i13 + (i13 >> 1) : 8;
                int[] iArrCopyOf = Arrays.copyOf(iArr, i17);
                Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
                this.hashes = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(this.array, i17 << 1);
                Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
                this.array = objArrCopyOf;
                if (i13 != this.size) {
                    throw new ConcurrentModificationException();
                }
                if (i11 > 0) {
                    ArraysKt___ArraysJvmKt.j(iArr, this.hashes, 0, 0, i11);
                    ArraysKt___ArraysJvmKt.l(objArr, this.array, 0, 0, i12);
                }
                if (i11 < i14) {
                    int i18 = i11 + 1;
                    ArraysKt___ArraysJvmKt.j(iArr, this.hashes, i11, i18, i13);
                    ArraysKt___ArraysJvmKt.l(objArr, this.array, i12, i18 << 1, i13 << 1);
                }
            }
            if (i13 != this.size) {
                throw new ConcurrentModificationException();
            }
            this.size = i14;
        }
        return v11;
    }

    public V replace(K k11, V v11) {
        int iIndexOfKey = indexOfKey(k11);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, v11);
        }
        return null;
    }

    public boolean replace(K k11, V v11, V v12) {
        int iIndexOfKey = indexOfKey(k11);
        if (iIndexOfKey < 0 || !Intrinsics.b(v11, valueAt(iIndexOfKey))) {
            return false;
        }
        setValueAt(iIndexOfKey, v12);
        return true;
    }

    public V setValueAt(int i11, V v11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 < this.size) {
            z11 = true;
        }
        if (!z11) {
            m1.d.a("Expected index to be within 0..size()-1, but was " + i11);
        }
        int i12 = (i11 << 1) + 1;
        Object[] objArr = this.array;
        V v12 = (V) objArr[i12];
        objArr[i12] = v11;
        return v12;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.size * 28);
        sb2.append('{');
        int i11 = this.size;
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            K kKeyAt = keyAt(i12);
            if (kKeyAt != sb2) {
                sb2.append(kKeyAt);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            V vValueAt = valueAt(i12);
            if (vValueAt != sb2) {
                sb2.append(vValueAt);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public V valueAt(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 < this.size) {
            z11 = true;
        }
        if (!z11) {
            m1.d.a("Expected index to be within 0..size()-1, but was " + i11);
        }
        return (V) this.array[(i11 << 1) + 1];
    }
}
