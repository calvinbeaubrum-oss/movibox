package androidx.collection;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt___ArraysJvmKt;
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
public final class f0<V> extends s<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1923f;

    public f0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            m1.d.a("Capacity must be a positive value.");
        }
        m(t0.g(i11));
    }

    public final void f() {
        if (this.f1980d <= 8 || Long.compare(ULong.b(ULong.b(this.f1981e) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f1980d) * 25) ^ Long.MIN_VALUE) > 0) {
            n(t0.e(this.f1980d));
        } else {
            h();
        }
    }

    public final void g() {
        this.f1981e = 0;
        long[] jArr = this.f1977a;
        if (jArr != t0.f1991a) {
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f1977a;
            int i11 = this.f1980d;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        ArraysKt___ArraysJvmKt.u(this.f1979c, null, 0, this.f1980d);
        k();
    }

    public final void h() {
        long[] jArr;
        int i11;
        int i12;
        long[] jArr2 = this.f1977a;
        int i13 = this.f1980d;
        long[] jArr3 = this.f1978b;
        Object[] objArr = this.f1979c;
        t0.a(jArr2, i13);
        char c11 = 0;
        int i14 = 0;
        int iB = -1;
        while (i14 != i13) {
            int i15 = i14 >> 3;
            int i16 = (i14 & 7) << 3;
            long j11 = (jArr2[i15] >> i16) & 255;
            if (j11 == 128) {
                iB = i14;
                i14++;
            } else {
                if (j11 == 254) {
                    int iA = l.p.a(jArr3[i14]) * (-862048943);
                    int i17 = iA ^ (iA << 16);
                    int i18 = i17 >>> 7;
                    int iJ = j(i18);
                    int i19 = i18 & i13;
                    if (((iJ - i19) & i13) / 8 == ((i14 - i19) & i13) / 8) {
                        jArr2[i15] = (((long) (i17 & 127)) << i16) | ((~(255 << i16)) & jArr2[i15]);
                        jArr2[kotlin.collections.d.T(jArr2)] = (jArr2[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i21 = iJ >> 3;
                        long j12 = jArr2[i21];
                        int i22 = (iJ & 7) << 3;
                        if (((j12 >> i22) & 255) == 128) {
                            int i23 = i14;
                            jArr = jArr3;
                            jArr2[i21] = (j12 & (~(255 << i22))) | (((long) (i17 & 127)) << i22);
                            jArr2[i15] = (jArr2[i15] & (~(255 << i16))) | (128 << i16);
                            jArr[iJ] = jArr[i23];
                            jArr[i23] = 0;
                            objArr[iJ] = objArr[i23];
                            objArr[i23] = null;
                            i12 = i23;
                            iB = i12;
                            i11 = i13;
                        } else {
                            int i24 = i13;
                            jArr = jArr3;
                            int i25 = i14;
                            jArr2[i21] = (((long) (i17 & 127)) << i22) | (j12 & (~(255 << i22)));
                            if (iB == -1) {
                                i11 = i24;
                                iB = t0.b(jArr2, i25 + 1, i11);
                            } else {
                                i11 = i24;
                            }
                            jArr[iB] = jArr[iJ];
                            jArr[iJ] = jArr[i25];
                            jArr[i25] = jArr[iB];
                            objArr[iB] = objArr[iJ];
                            objArr[iJ] = objArr[i25];
                            objArr[i25] = objArr[iB];
                            i12 = i25 - 1;
                        }
                        c11 = 0;
                        jArr2[kotlin.collections.d.T(jArr2)] = (jArr2[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i14 = i12 + 1;
                        i13 = i11;
                        jArr3 = jArr;
                    }
                }
                i14++;
            }
        }
        k();
    }

    public final int i(long j11) {
        int iA = l.p.a(j11) * (-862048943);
        int i11 = iA ^ (iA << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f1980d;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr = this.f1977a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j12 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j13 = i13;
            int i19 = i16;
            long j14 = j12 ^ (j13 * 72340172838076673L);
            for (long j15 = (~j14) & (j14 - 72340172838076673L) & (-9187201950435737472L); j15 != 0; j15 &= j15 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j15) >> 3) + i15) & i14;
                if (this.f1978b[iNumberOfTrailingZeros] == j11) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j12) << 6) & j12 & (-9187201950435737472L)) != 0) {
                int iJ = j(i12);
                if (this.f1923f == 0 && ((this.f1977a[iJ >> 3] >> ((iJ & 7) << 3)) & 255) != 254) {
                    f();
                    iJ = j(i12);
                }
                this.f1981e++;
                int i21 = this.f1923f;
                long[] jArr2 = this.f1977a;
                int i22 = iJ >> 3;
                long j16 = jArr2[i22];
                int i23 = (iJ & 7) << 3;
                this.f1923f = i21 - (((j16 >> i23) & 255) == 128 ? 1 : 0);
                int i24 = this.f1980d;
                long j17 = ((~(255 << i23)) & j16) | (j13 << i23);
                jArr2[i22] = j17;
                jArr2[(((iJ - 7) & i24) + (i24 & 7)) >> 3] = j17;
                return iJ;
            }
            i16 = i19 + 8;
            i15 = (i15 + i16) & i14;
        }
    }

    public final int j(int i11) {
        int i12 = this.f1980d;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f1977a;
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

    public final void k() {
        this.f1923f = t0.c(c()) - this.f1981e;
    }

    public final void l(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = t0.f1991a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f1977a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        k();
    }

    public final void m(int i11) {
        int iMax = i11 > 0 ? Math.max(7, t0.f(i11)) : 0;
        this.f1980d = iMax;
        l(iMax);
        this.f1978b = new long[iMax];
        this.f1979c = new Object[iMax];
    }

    public final void n(int i11) {
        f0<V> f0Var = this;
        long[] jArr = f0Var.f1977a;
        long[] jArr2 = f0Var.f1978b;
        Object[] objArr = f0Var.f1979c;
        int i12 = f0Var.f1980d;
        m(i11);
        long[] jArr3 = f0Var.f1977a;
        long[] jArr4 = f0Var.f1978b;
        Object[] objArr2 = f0Var.f1979c;
        int i13 = f0Var.f1980d;
        int i14 = 0;
        while (i14 < i12) {
            if (((jArr[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                long j11 = jArr2[i14];
                int iA = l.p.a(j11) * (-862048943);
                int i15 = iA ^ (iA << 16);
                int iJ = f0Var.j(i15 >>> 7);
                long j12 = i15 & 127;
                int i16 = iJ >> 3;
                int i17 = (iJ & 7) << 3;
                long j13 = (jArr3[i16] & (~(255 << i17))) | (j12 << i17);
                jArr3[i16] = j13;
                jArr3[(((iJ - 7) & i13) + (i13 & 7)) >> 3] = j13;
                jArr4[iJ] = j11;
                objArr2[iJ] = objArr[i14];
            }
            i14++;
            f0Var = this;
            jArr = jArr;
        }
    }

    public final void o(long j11, V v11) {
        int i11 = i(j11);
        this.f1978b[i11] = j11;
        this.f1979c[i11] = v11;
    }
}
