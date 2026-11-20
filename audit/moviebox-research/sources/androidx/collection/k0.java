package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt___ArraysJvmKt;
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
public final class k0<K> extends q0<K> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1941f;

    public k0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            m1.d.a("Capacity must be a positive value.");
        }
        n(t0.g(i11));
    }

    public /* synthetic */ k0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    public final void h() {
        if (this.f1974d <= 8 || Long.compare(ULong.b(ULong.b(this.f1975e) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f1974d) * 25) ^ Long.MIN_VALUE) > 0) {
            o(t0.e(this.f1974d));
        } else {
            i();
        }
    }

    public final void i() {
        Object[] objArr;
        int i11;
        int i12;
        long[] jArr = this.f1971a;
        int i13 = this.f1974d;
        Object[] objArr2 = this.f1972b;
        long[] jArr2 = this.f1973c;
        t0.a(jArr, i13);
        char c11 = 0;
        int i14 = 0;
        int iB = -1;
        while (i14 != i13) {
            int i15 = i14 >> 3;
            int i16 = (i14 & 7) << 3;
            long j11 = (jArr[i15] >> i16) & 255;
            if (j11 == 128) {
                iB = i14;
                i14++;
            } else {
                if (j11 == 254) {
                    Object obj = objArr2[i14];
                    int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                    int i17 = iHashCode ^ (iHashCode << 16);
                    int i18 = i17 >>> 7;
                    int iJ = j(i18);
                    int i19 = i18 & i13;
                    if (((iJ - i19) & i13) / 8 == ((i14 - i19) & i13) / 8) {
                        jArr[i15] = (((long) (i17 & 127)) << i16) | ((~(255 << i16)) & jArr[i15]);
                        jArr[kotlin.collections.d.T(jArr)] = (jArr[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i21 = iJ >> 3;
                        long j12 = jArr[i21];
                        int i22 = (iJ & 7) << 3;
                        if (((j12 >> i22) & 255) == 128) {
                            int i23 = i14;
                            objArr = objArr2;
                            jArr[i21] = (j12 & (~(255 << i22))) | (((long) (i17 & 127)) << i22);
                            jArr[i15] = (jArr[i15] & (~(255 << i16))) | (128 << i16);
                            objArr[iJ] = objArr[i23];
                            objArr[i23] = null;
                            jArr2[iJ] = jArr2[i23];
                            jArr2[i23] = 0;
                            i12 = i23;
                            iB = i12;
                            i11 = i13;
                        } else {
                            int i24 = i13;
                            objArr = objArr2;
                            int i25 = i14;
                            jArr[i21] = (((long) (i17 & 127)) << i22) | (j12 & (~(255 << i22)));
                            if (iB == -1) {
                                i11 = i24;
                                iB = t0.b(jArr, i25 + 1, i11);
                            } else {
                                i11 = i24;
                            }
                            objArr[iB] = objArr[iJ];
                            objArr[iJ] = objArr[i25];
                            objArr[i25] = objArr[iB];
                            jArr2[iB] = jArr2[iJ];
                            jArr2[iJ] = jArr2[i25];
                            jArr2[i25] = jArr2[iB];
                            i12 = i25 - 1;
                        }
                        c11 = 0;
                        jArr[kotlin.collections.d.T(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i14 = i12 + 1;
                        i13 = i11;
                        objArr2 = objArr;
                    }
                }
                i14++;
            }
        }
        l();
    }

    public final int j(int i11) {
        int i12 = this.f1974d;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f1971a;
            int i15 = i13 >> 3;
            int i16 = (i13 & 7) << 3;
            long j11 = ((jArr[i15 + 1] << (64 - i16)) & ((-i16) >> 63)) | (jArr[i15] >>> i16);
            long j12 = j11 & ((~j11) << 7) & (-9187201950435737472L);
            if (j12 != 0) {
                return (i13 + (Long.numberOfTrailingZeros(j12) >> 3)) & i12;
            }
            i14 += 8;
            i13 = (i13 + i14) & i12;
        }
    }

    public final int k(K k11) {
        int iHashCode = (k11 != null ? k11.hashCode() : 0) * (-862048943);
        int i11 = iHashCode ^ (iHashCode << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f1974d;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr = this.f1971a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j11 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j12 = i13;
            int i19 = i13;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int iNumberOfTrailingZeros = (i15 + (Long.numberOfTrailingZeros(j14) >> 3)) & i14;
                if (Intrinsics.b(this.f1972b[iNumberOfTrailingZeros], k11)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int iJ = j(i12);
                if (this.f1941f == 0 && ((this.f1971a[iJ >> 3] >> ((iJ & 7) << 3)) & 255) != 254) {
                    h();
                    iJ = j(i12);
                }
                this.f1975e++;
                int i21 = this.f1941f;
                long[] jArr2 = this.f1971a;
                int i22 = iJ >> 3;
                long j15 = jArr2[i22];
                int i23 = (iJ & 7) << 3;
                this.f1941f = i21 - (((j15 >> i23) & 255) == 128 ? 1 : 0);
                int i24 = this.f1974d;
                long j16 = ((~(255 << i23)) & j15) | (j12 << i23);
                jArr2[i22] = j16;
                jArr2[(((iJ - 7) & i24) + (i24 & 7)) >> 3] = j16;
                return ~iJ;
            }
            i16 += 8;
            i15 = (i15 + i16) & i14;
            i13 = i19;
        }
    }

    public final void l() {
        this.f1941f = t0.c(d()) - this.f1975e;
    }

    public final void m(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = t0.f1991a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f1971a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        l();
    }

    public final void n(int i11) {
        int iMax = i11 > 0 ? Math.max(7, t0.f(i11)) : 0;
        this.f1974d = iMax;
        m(iMax);
        this.f1972b = new Object[iMax];
        this.f1973c = new long[iMax];
    }

    public final void o(int i11) {
        int i12;
        long[] jArr = this.f1971a;
        Object[] objArr = this.f1972b;
        long[] jArr2 = this.f1973c;
        int i13 = this.f1974d;
        n(i11);
        long[] jArr3 = this.f1971a;
        Object[] objArr2 = this.f1972b;
        long[] jArr4 = this.f1973c;
        int i14 = this.f1974d;
        int i15 = 0;
        while (i15 < i13) {
            if (((jArr[i15 >> 3] >> ((i15 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i15];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i16 = iHashCode ^ (iHashCode << 16);
                int iJ = j(i16 >>> 7);
                i12 = i15;
                long j11 = i16 & 127;
                int i17 = iJ >> 3;
                int i18 = (iJ & 7) << 3;
                long j12 = (j11 << i18) | (jArr3[i17] & (~(255 << i18)));
                jArr3[i17] = j12;
                jArr3[(((iJ - 7) & i14) + (i14 & 7)) >> 3] = j12;
                objArr2[iJ] = obj;
                jArr4[iJ] = jArr2[i12];
            } else {
                i12 = i15;
            }
            i15 = i12 + 1;
        }
    }

    public final void p(K k11, long j11) {
        int iK = k(k11);
        if (iK < 0) {
            iK = ~iK;
        }
        this.f1972b[iK] = k11;
        this.f1973c[iK] = j11;
    }
}
