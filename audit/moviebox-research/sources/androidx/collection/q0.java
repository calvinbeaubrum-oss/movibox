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
public abstract class q0<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public long[] f1971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public Object[] f1972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public long[] f1973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public int f1974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public int f1975e;

    public q0() {
        this.f1971a = t0.f1991a;
        this.f1972b = m1.a.f70587c;
        this.f1973c = u.a();
    }

    public /* synthetic */ q0(DefaultConstructorMarker defaultConstructorMarker) {
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
        int i14 = this.f1974d;
        int i15 = i12 >>> 7;
        while (true) {
            int i16 = i15 & i14;
            long[] jArr = this.f1971a;
            int i17 = i16 >> 3;
            int i18 = (i16 & 7) << 3;
            long j11 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j12 = (((long) i13) * 72340172838076673L) ^ j11;
            for (long j13 = (~j12) & (j12 - 72340172838076673L) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j13) >> 3) + i16) & i14;
                if (Intrinsics.b(this.f1972b[iNumberOfTrailingZeros], k11)) {
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

    public final long c(K k11) {
        int iB = b(k11);
        if (iB >= 0) {
            return this.f1973c[iB];
        }
        throw new NoSuchElementException("There is no key " + k11 + " in the map");
    }

    public final int d() {
        return this.f1974d;
    }

    public final long e(K k11, long j11) {
        int iB = b(k11);
        return iB >= 0 ? this.f1973c[iB] : j11;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0064 A[LOOP:0: B:14:0x0027->B:26:0x0064, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        if (q0Var.f() != f()) {
            return false;
        }
        Object[] objArr = this.f1972b;
        long[] jArr = this.f1973c;
        long[] jArr2 = this.f1971a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j11 = jArr2[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j11) < 128) {
                            int i14 = (i11 << 3) + i13;
                            if (jArr[i14] != q0Var.c(objArr[i14])) {
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
        return this.f1975e;
    }

    public final boolean g() {
        return this.f1975e == 0;
    }

    public int hashCode() {
        Object[] objArr = this.f1972b;
        long[] jArr = this.f1973c;
        long[] jArr2 = this.f1971a;
        int length = jArr2.length - 2;
        int i11 = 0;
        if (length >= 0) {
            int i12 = 0;
            int iHashCode = 0;
            while (true) {
                long j11 = jArr2[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((255 & j11) < 128) {
                            int i15 = (i12 << 3) + i14;
                            Object obj = objArr[i15];
                            iHashCode += (obj != null ? obj.hashCode() : 0) ^ l.p.a(jArr[i15]);
                        }
                        j11 >>= 8;
                    }
                    if (i13 != 8) {
                        return iHashCode;
                    }
                }
                if (i12 != length) {
                    i12++;
                } else {
                    i11 = iHashCode;
                }
            }
        }
        return i11;
    }

    public String toString() {
        int i11;
        int i12;
        if (g()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        Object[] objArr = this.f1972b;
        long[] jArr = this.f1973c;
        long[] jArr2 = this.f1971a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i13 = 0;
            int i14 = 0;
            while (true) {
                long j11 = jArr2[i13];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i15 = 8 - ((~(i13 - length)) >>> 31);
                    int i16 = 0;
                    while (i16 < i15) {
                        if ((255 & j11) < 128) {
                            int i17 = (i13 << 3) + i16;
                            Object obj = objArr[i17];
                            i12 = i13;
                            long j12 = jArr[i17];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb2.append(obj);
                            sb2.append("=");
                            sb2.append(j12);
                            i14++;
                            if (i14 < this.f1975e) {
                                sb2.append(',');
                                sb2.append(' ');
                            }
                        } else {
                            i12 = i13;
                        }
                        j11 >>= 8;
                        i16++;
                        i13 = i12;
                    }
                    int i18 = i13;
                    if (i15 != 8) {
                        break;
                    }
                    i11 = i18;
                } else {
                    i11 = i13;
                }
                if (i11 == length) {
                    break;
                }
                i13 = i11 + 1;
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        Intrinsics.f(string, "s.append('}').toString()");
        return string;
    }
}
