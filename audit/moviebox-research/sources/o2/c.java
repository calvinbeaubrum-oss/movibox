package o2;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class c<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f72272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f72273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f72274c;

    @JvmOverloads
    public c() {
        this(0, 1, null);
    }

    @JvmOverloads
    public c(int i11) {
        if (i11 == 0) {
            this.f72272a = a.f72260a;
            this.f72273b = a.f72261b;
        } else {
            this.f72272a = new int[i11];
            this.f72273b = new Object[i11 << 1];
        }
        this.f72274c = 0;
    }

    public /* synthetic */ c(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }

    public final boolean a(K k11) {
        return d(k11) >= 0;
    }

    public final V b(K k11) {
        int iD = d(k11);
        if (iD >= 0) {
            return (V) this.f72273b[(iD << 1) + 1];
        }
        return null;
    }

    public final int c(Object obj, int i11) {
        int i12 = this.f72274c;
        if (i12 == 0) {
            return -1;
        }
        int iA = a.a(this.f72272a, i12, i11);
        if (iA < 0 || Intrinsics.b(obj, this.f72273b[iA << 1])) {
            return iA;
        }
        int i13 = iA + 1;
        while (i13 < i12 && this.f72272a[i13] == i11) {
            if (Intrinsics.b(obj, this.f72273b[i13 << 1])) {
                return i13;
            }
            i13++;
        }
        for (int i14 = iA - 1; i14 >= 0 && this.f72272a[i14] == i11; i14--) {
            if (Intrinsics.b(obj, this.f72273b[i14 << 1])) {
                return i14;
            }
        }
        return ~i13;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj, obj.hashCode());
    }

    public final int e() {
        int i11 = this.f72274c;
        if (i11 == 0) {
            return -1;
        }
        int iA = a.a(this.f72272a, i11, 0);
        if (iA < 0 || this.f72273b[iA << 1] == null) {
            return iA;
        }
        int i12 = iA + 1;
        while (i12 < i11 && this.f72272a[i12] == 0) {
            if (this.f72273b[i12 << 1] == null) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iA - 1; i13 >= 0 && this.f72272a[i13] == 0; i13--) {
            if (this.f72273b[i13 << 1] == null) {
                return i13;
            }
        }
        return ~i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof c) {
                c cVar = (c) obj;
                int i11 = this.f72274c;
                if (i11 != cVar.f72274c) {
                    return false;
                }
                for (int i12 = 0; i12 < i11; i12++) {
                    K kG = g(i12);
                    V vI = i(i12);
                    Object objB = cVar.b(kG);
                    if (vI == null) {
                        if (objB != null || !cVar.a(kG)) {
                            return false;
                        }
                    } else if (!Intrinsics.b(vI, objB)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f72274c != ((Map) obj).size()) {
                return false;
            }
            int i13 = this.f72274c;
            for (int i14 = 0; i14 < i13; i14++) {
                K kG2 = g(i14);
                V vI2 = i(i14);
                Object obj2 = ((Map) obj).get(kG2);
                if (vI2 == null) {
                    if (obj2 != null || !((Map) obj).containsKey(kG2)) {
                        return false;
                    }
                } else if (!Intrinsics.b(vI2, obj2)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final boolean f() {
        return this.f72274c <= 0;
    }

    public final K g(int i11) {
        return (K) this.f72273b[i11 << 1];
    }

    public final V h(K k11, V v11) {
        int iHashCode;
        int iC;
        int i11 = this.f72274c;
        if (k11 == null) {
            iC = e();
            iHashCode = 0;
        } else {
            iHashCode = k11.hashCode();
            iC = c(k11, iHashCode);
        }
        if (iC >= 0) {
            int i12 = (iC << 1) + 1;
            Object[] objArr = this.f72273b;
            V v12 = (V) objArr[i12];
            objArr[i12] = v11;
            return v12;
        }
        int i13 = ~iC;
        int[] iArr = this.f72272a;
        if (i11 >= iArr.length) {
            int i14 = 8;
            if (i11 >= 8) {
                i14 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i14 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i14);
            Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f72272a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f72273b, i14 << 1);
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f72273b = objArrCopyOf;
            if (i11 != this.f72274c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i13 < i11) {
            int[] iArr2 = this.f72272a;
            int i15 = i13 + 1;
            ArraysKt___ArraysJvmKt.j(iArr2, iArr2, i15, i13, i11);
            Object[] objArr2 = this.f72273b;
            ArraysKt___ArraysJvmKt.l(objArr2, objArr2, i15 << 1, i13 << 1, this.f72274c << 1);
        }
        int i16 = this.f72274c;
        if (i11 == i16) {
            int[] iArr3 = this.f72272a;
            if (i13 < iArr3.length) {
                iArr3[i13] = iHashCode;
                Object[] objArr3 = this.f72273b;
                int i17 = i13 << 1;
                objArr3[i17] = k11;
                objArr3[i17 + 1] = v11;
                this.f72274c = i16 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public int hashCode() {
        int[] iArr = this.f72272a;
        Object[] objArr = this.f72273b;
        int i11 = this.f72274c;
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

    public final V i(int i11) {
        return (V) this.f72273b[(i11 << 1) + 1];
    }

    public String toString() {
        if (f()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f72274c * 28);
        sb2.append('{');
        int i11 = this.f72274c;
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            K kG = g(i12);
            if (kG != this) {
                sb2.append(kG);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            V vI = i(i12);
            if (vI != this) {
                sb2.append(vI);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
