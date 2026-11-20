package androidx.collection;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ULong;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class c0<V> extends n<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1916f;

    public c0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            m1.d.a("Capacity must be a positive value.");
        }
        o(t0.g(i11));
    }

    public /* synthetic */ c0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    public final void h() {
        if (this.f1954d <= 8 || Long.compare(ULong.b(ULong.b(this.f1955e) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f1954d) * 25) ^ Long.MIN_VALUE) > 0) {
            s(t0.e(this.f1954d));
        } else {
            j();
        }
    }

    public final void i() {
        this.f1955e = 0;
        long[] jArr = this.f1951a;
        if (jArr != t0.f1991a) {
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f1951a;
            int i11 = this.f1954d;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        ArraysKt___ArraysJvmKt.u(this.f1953c, null, 0, this.f1954d);
        m();
    }

    public final void j() {
        int[] iArr;
        int i11;
        int i12;
        long[] jArr = this.f1951a;
        int i13 = this.f1954d;
        int[] iArr2 = this.f1952b;
        Object[] objArr = this.f1953c;
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
                    int i17 = iArr2[i14] * (-862048943);
                    int i18 = i17 ^ (i17 << 16);
                    int i19 = i18 >>> 7;
                    int iL = l(i19);
                    int i21 = i19 & i13;
                    if (((iL - i21) & i13) / 8 == ((i14 - i21) & i13) / 8) {
                        jArr[i15] = (((long) (i18 & 127)) << i16) | ((~(255 << i16)) & jArr[i15]);
                        jArr[kotlin.collections.d.T(jArr)] = (jArr[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i22 = iL >> 3;
                        long j12 = jArr[i22];
                        int i23 = (iL & 7) << 3;
                        if (((j12 >> i23) & 255) == 128) {
                            int i24 = i14;
                            iArr = iArr2;
                            jArr[i22] = (j12 & (~(255 << i23))) | (((long) (i18 & 127)) << i23);
                            jArr[i15] = (jArr[i15] & (~(255 << i16))) | (128 << i16);
                            iArr[iL] = iArr[i24];
                            iArr[i24] = 0;
                            objArr[iL] = objArr[i24];
                            objArr[i24] = null;
                            i12 = i24;
                            iB = i12;
                            i11 = i13;
                        } else {
                            int i25 = i13;
                            iArr = iArr2;
                            int i26 = i14;
                            jArr[i22] = (((long) (i18 & 127)) << i23) | (j12 & (~(255 << i23)));
                            if (iB == -1) {
                                i11 = i25;
                                iB = t0.b(jArr, i26 + 1, i11);
                            } else {
                                i11 = i25;
                            }
                            iArr[iB] = iArr[iL];
                            iArr[iL] = iArr[i26];
                            iArr[i26] = iArr[iB];
                            objArr[iB] = objArr[iL];
                            objArr[iL] = objArr[i26];
                            objArr[i26] = objArr[iB];
                            i12 = i26 - 1;
                        }
                        c11 = 0;
                        jArr[kotlin.collections.d.T(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i14 = i12 + 1;
                        i13 = i11;
                        iArr2 = iArr;
                    }
                }
                i14++;
            }
        }
        m();
    }

    public final int k(int i11) {
        int i12 = (-862048943) * i11;
        int i13 = i12 ^ (i12 << 16);
        int i14 = i13 >>> 7;
        int i15 = i13 & 127;
        int i16 = this.f1954d;
        int i17 = i14 & i16;
        int i18 = 0;
        while (true) {
            long[] jArr = this.f1951a;
            int i19 = i17 >> 3;
            int i21 = (i17 & 7) << 3;
            long j11 = ((jArr[i19 + 1] << (64 - i21)) & ((-i21) >> 63)) | (jArr[i19] >>> i21);
            long j12 = i15;
            int i22 = i18;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int iNumberOfTrailingZeros = (i17 + (Long.numberOfTrailingZeros(j14) >> 3)) & i16;
                if (this.f1952b[iNumberOfTrailingZeros] == i11) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int iL = l(i14);
                if (this.f1916f == 0 && ((this.f1951a[iL >> 3] >> ((iL & 7) << 3)) & 255) != 254) {
                    h();
                    iL = l(i14);
                }
                this.f1955e++;
                int i23 = this.f1916f;
                long[] jArr2 = this.f1951a;
                int i24 = iL >> 3;
                long j15 = jArr2[i24];
                int i25 = (iL & 7) << 3;
                this.f1916f = i23 - (((j15 >> i25) & 255) == 128 ? 1 : 0);
                int i26 = this.f1954d;
                long j16 = ((~(255 << i25)) & j15) | (j12 << i25);
                jArr2[i24] = j16;
                jArr2[(((iL - 7) & i26) + (i26 & 7)) >> 3] = j16;
                return iL;
            }
            i18 = i22 + 8;
            i17 = (i17 + i18) & i16;
        }
    }

    public final int l(int i11) {
        int i12 = this.f1954d;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f1951a;
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

    public final void m() {
        this.f1916f = t0.c(d()) - this.f1955e;
    }

    public final void n(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = t0.f1991a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f1951a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        m();
    }

    public final void o(int i11) {
        int iMax = i11 > 0 ? Math.max(7, t0.f(i11)) : 0;
        this.f1954d = iMax;
        n(iMax);
        this.f1952b = new int[iMax];
        this.f1953c = new Object[iMax];
    }

    public final V p(int i11, V v11) {
        int iK = k(i11);
        Object[] objArr = this.f1953c;
        V v12 = (V) objArr[iK];
        this.f1952b[iK] = i11;
        objArr[iK] = v11;
        return v12;
    }

    public final V q(int i11) {
        int iNumberOfTrailingZeros;
        int i12 = (-862048943) * i11;
        int i13 = i12 ^ (i12 << 16);
        int i14 = i13 & 127;
        int i15 = this.f1954d;
        int i16 = (i13 >>> 7) & i15;
        int i17 = 0;
        loop0: while (true) {
            long[] jArr = this.f1951a;
            int i18 = i16 >> 3;
            int i19 = (i16 & 7) << 3;
            long j11 = ((jArr[i18 + 1] << (64 - i19)) & ((-i19) >> 63)) | (jArr[i18] >>> i19);
            long j12 = (((long) i14) * 72340172838076673L) ^ j11;
            for (long j13 = (~j12) & (j12 - 72340172838076673L) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j13) >> 3) + i16) & i15;
                if (this.f1952b[iNumberOfTrailingZeros] == i11) {
                    break loop0;
                }
            }
            if ((j11 & ((~j11) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i17 += 8;
            i16 = (i16 + i17) & i15;
        }
        if (iNumberOfTrailingZeros >= 0) {
            return r(iNumberOfTrailingZeros);
        }
        return null;
    }

    @PublishedApi
    public final V r(int i11) {
        this.f1955e--;
        long[] jArr = this.f1951a;
        int i12 = this.f1954d;
        int i13 = i11 >> 3;
        int i14 = (i11 & 7) << 3;
        long j11 = (jArr[i13] & (~(255 << i14))) | (254 << i14);
        jArr[i13] = j11;
        jArr[(((i11 - 7) & i12) + (i12 & 7)) >> 3] = j11;
        Object[] objArr = this.f1953c;
        V v11 = (V) objArr[i11];
        objArr[i11] = null;
        return v11;
    }

    public final void s(int i11) {
        c0<V> c0Var = this;
        long[] jArr = c0Var.f1951a;
        int[] iArr = c0Var.f1952b;
        Object[] objArr = c0Var.f1953c;
        int i12 = c0Var.f1954d;
        o(i11);
        long[] jArr2 = c0Var.f1951a;
        int[] iArr2 = c0Var.f1952b;
        Object[] objArr2 = c0Var.f1953c;
        int i13 = c0Var.f1954d;
        int i14 = 0;
        while (i14 < i12) {
            if (((jArr[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                int i15 = iArr[i14];
                int i16 = (-862048943) * i15;
                int i17 = i16 ^ (i16 << 16);
                int iL = c0Var.l(i17 >>> 7);
                long j11 = i17 & 127;
                int i18 = iL >> 3;
                int i19 = (iL & 7) << 3;
                long j12 = (jArr2[i18] & (~(255 << i19))) | (j11 << i19);
                jArr2[i18] = j12;
                jArr2[(((iL - 7) & i13) + (i13 & 7)) >> 3] = j12;
                iArr2[iL] = i15;
                objArr2[iL] = objArr[i14];
            }
            i14++;
            c0Var = this;
            jArr = jArr;
        }
    }

    public final void t(int i11, V v11) {
        int iK = k(i11);
        this.f1952b[iK] = i11;
        this.f1953c[iK] = v11;
    }
}
