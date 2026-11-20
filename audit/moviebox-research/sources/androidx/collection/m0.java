package androidx.collection;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
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
public abstract class m0<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public long[] f1946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public Object[] f1947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public float[] f1948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public int f1949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public int f1950e;

    public m0() {
        this.f1946a = t0.f1991a;
        this.f1947b = m1.a.f70587c;
        this.f1948c = i.a();
    }

    public /* synthetic */ m0(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean a(K k11) {
        return b(k11) >= 0;
    }

    @PublishedApi
    public final int b(K k11) {
        int i11 = 0;
        int iHashCode = (k11 != null ? k11.hashCode() : 0) * (-862048943);
        int i12 = iHashCode ^ (iHashCode << 16);
        int i13 = i12 & 127;
        int i14 = this.f1949d;
        int i15 = i12 >>> 7;
        while (true) {
            int i16 = i15 & i14;
            long[] jArr = this.f1946a;
            int i17 = i16 >> 3;
            int i18 = (i16 & 7) << 3;
            long j11 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j12 = (((long) i13) * 72340172838076673L) ^ j11;
            for (long j13 = (~j12) & (j12 - 72340172838076673L) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j13) >> 3) + i16) & i14;
                if (Intrinsics.b(this.f1947b[iNumberOfTrailingZeros], k11)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j11 & ((~j11) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i11 += 8;
            i15 = i16 + i11;
        }
    }

    public final float c(K k11) {
        int iB = b(k11);
        if (iB >= 0) {
            return this.f1948c[iB];
        }
        throw new NoSuchElementException("There is no key " + k11 + " in the map");
    }

    public final int d() {
        return this.f1949d;
    }

    public final float e(K k11, float f11) {
        int iB = b(k11);
        return iB >= 0 ? this.f1948c[iB] : f11;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0065 A[LOOP:0: B:14:0x0027->B:27:0x0065, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        if (m0Var.f() != f()) {
            return false;
        }
        Object[] objArr = this.f1947b;
        float[] fArr = this.f1948c;
        long[] jArr = this.f1946a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j11 = jArr[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j11) < 128) {
                            int i14 = (i11 << 3) + i13;
                            if (fArr[i14] != m0Var.c(objArr[i14])) {
                                return false;
                            }
                        }
                        j11 >>= 8;
                    }
                    if (i12 == 8) {
                        if (i11 != length) {
                            i11++;
                        }
                    }
                } else if (i11 != length) {
                    i11++;
                }
            }
        }
        return true;
    }

    public final int f() {
        return this.f1950e;
    }

    public final boolean g() {
        return this.f1950e == 0;
    }

    public int hashCode() {
        Object[] objArr = this.f1947b;
        float[] fArr = this.f1948c;
        long[] jArr = this.f1946a;
        int length = jArr.length - 2;
        int i11 = 0;
        if (length >= 0) {
            int i12 = 0;
            int iFloatToIntBits = 0;
            while (true) {
                long j11 = jArr[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((255 & j11) < 128) {
                            int i15 = (i12 << 3) + i14;
                            Object obj = objArr[i15];
                            iFloatToIntBits += Float.floatToIntBits(fArr[i15]) ^ (obj != null ? obj.hashCode() : 0);
                        }
                        j11 >>= 8;
                    }
                    if (i13 != 8) {
                        return iFloatToIntBits;
                    }
                }
                if (i12 != length) {
                    i12++;
                } else {
                    i11 = iFloatToIntBits;
                }
            }
        }
        return i11;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0074 A[DONT_INVERT, PHI: r8
  0x0074: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:10:0x0031, B:22:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:24:0x0076 A[LOOP:0: B:9:0x0023->B:24:0x0076, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0079 A[EDGE_INSN: B:28:0x0079->B:25:0x0079 BREAK  A[LOOP:0: B:9:0x0023->B:24:0x0076], SYNTHETIC] */
    public String toString() {
        if (g()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        Object[] objArr = this.f1947b;
        float[] fArr = this.f1948c;
        long[] jArr = this.f1946a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                long j11 = jArr[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i11 != length) {
                        break;
                        break;
                    }
                    i11++;
                } else {
                    int i13 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((255 & j11) < 128) {
                            int i15 = (i11 << 3) + i14;
                            Object obj = objArr[i15];
                            float f11 = fArr[i15];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb2.append(obj);
                            sb2.append("=");
                            sb2.append(f11);
                            i12++;
                            if (i12 < this.f1950e) {
                                sb2.append(',');
                                sb2.append(' ');
                            }
                        }
                        j11 >>= 8;
                    }
                    if (i13 != 8) {
                        break;
                    }
                    if (i11 != length) {
                        break;
                    }
                    i11++;
                }
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        Intrinsics.f(string, "s.append('}').toString()");
        return string;
    }
}
