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
public final class h0<K> extends m0<K> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1929f;

    public h0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            m1.d.a("Capacity must be a positive value.");
        }
        o(t0.g(i11));
    }

    public /* synthetic */ h0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    public final void h() {
        if (this.f1949d <= 8 || Long.compare(ULong.b(ULong.b(this.f1950e) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f1949d) * 25) ^ Long.MIN_VALUE) > 0) {
            q(t0.e(this.f1949d));
        } else {
            j();
        }
    }

    public final void i() {
        this.f1950e = 0;
        long[] jArr = this.f1946a;
        if (jArr != t0.f1991a) {
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f1946a;
            int i11 = this.f1949d;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        ArraysKt___ArraysJvmKt.u(this.f1947b, null, 0, this.f1949d);
        m();
    }

    public final void j() {
        Object[] objArr;
        int i11;
        int i12;
        long[] jArr = this.f1946a;
        int i13 = this.f1949d;
        Object[] objArr2 = this.f1947b;
        float[] fArr = this.f1948c;
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
                    int iK = k(i18);
                    int i19 = i18 & i13;
                    if (((iK - i19) & i13) / 8 == ((i14 - i19) & i13) / 8) {
                        jArr[i15] = (((long) (i17 & 127)) << i16) | ((~(255 << i16)) & jArr[i15]);
                        jArr[kotlin.collections.d.T(jArr)] = (jArr[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i21 = iK >> 3;
                        long j12 = jArr[i21];
                        int i22 = (iK & 7) << 3;
                        if (((j12 >> i22) & 255) == 128) {
                            int i23 = i14;
                            objArr = objArr2;
                            jArr[i21] = (j12 & (~(255 << i22))) | (((long) (i17 & 127)) << i22);
                            jArr[i15] = (jArr[i15] & (~(255 << i16))) | (128 << i16);
                            objArr[iK] = objArr[i23];
                            objArr[i23] = null;
                            fArr[iK] = fArr[i23];
                            fArr[i23] = 0.0f;
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
                            objArr[iB] = objArr[iK];
                            objArr[iK] = objArr[i25];
                            objArr[i25] = objArr[iB];
                            fArr[iB] = fArr[iK];
                            fArr[iK] = fArr[i25];
                            fArr[i25] = fArr[iB];
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
        m();
    }

    public final int k(int i11) {
        int i12 = this.f1949d;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f1946a;
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

    public final int l(K k11) {
        int iHashCode = (k11 != null ? k11.hashCode() : 0) * (-862048943);
        int i11 = iHashCode ^ (iHashCode << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f1949d;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr = this.f1946a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j11 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j12 = i13;
            int i19 = i13;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int iNumberOfTrailingZeros = (i15 + (Long.numberOfTrailingZeros(j14) >> 3)) & i14;
                if (Intrinsics.b(this.f1947b[iNumberOfTrailingZeros], k11)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int iK = k(i12);
                if (this.f1929f == 0 && ((this.f1946a[iK >> 3] >> ((iK & 7) << 3)) & 255) != 254) {
                    h();
                    iK = k(i12);
                }
                this.f1950e++;
                int i21 = this.f1929f;
                long[] jArr2 = this.f1946a;
                int i22 = iK >> 3;
                long j15 = jArr2[i22];
                int i23 = (iK & 7) << 3;
                this.f1929f = i21 - (((j15 >> i23) & 255) == 128 ? 1 : 0);
                int i24 = this.f1949d;
                long j16 = ((~(255 << i23)) & j15) | (j12 << i23);
                jArr2[i22] = j16;
                jArr2[(((iK - 7) & i24) + (i24 & 7)) >> 3] = j16;
                return ~iK;
            }
            i16 += 8;
            i15 = (i15 + i16) & i14;
            i13 = i19;
        }
    }

    public final void m() {
        this.f1929f = t0.c(d()) - this.f1950e;
    }

    public final void n(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = t0.f1991a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f1946a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        m();
    }

    public final void o(int i11) {
        int iMax = i11 > 0 ? Math.max(7, t0.f(i11)) : 0;
        this.f1949d = iMax;
        n(iMax);
        this.f1947b = new Object[iMax];
        this.f1948c = new float[iMax];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(m0<K> from) {
        Intrinsics.g(from, "from");
        Object[] objArr = from.f1947b;
        float[] fArr = from.f1948c;
        long[] jArr = from.f1946a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i11 = 0;
        while (true) {
            long j11 = jArr[i11];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i11 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j11) < 128) {
                        int i14 = (i11 << 3) + i13;
                        r(objArr[i14], fArr[i14]);
                    }
                    j11 >>= 8;
                }
                if (i12 != 8) {
                    return;
                }
            }
            if (i11 == length) {
                return;
            } else {
                i11++;
            }
        }
    }

    public final void q(int i11) {
        int i12;
        long[] jArr = this.f1946a;
        Object[] objArr = this.f1947b;
        float[] fArr = this.f1948c;
        int i13 = this.f1949d;
        o(i11);
        long[] jArr2 = this.f1946a;
        Object[] objArr2 = this.f1947b;
        float[] fArr2 = this.f1948c;
        int i14 = this.f1949d;
        int i15 = 0;
        while (i15 < i13) {
            if (((jArr[i15 >> 3] >> ((i15 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i15];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i16 = iHashCode ^ (iHashCode << 16);
                int iK = k(i16 >>> 7);
                i12 = i15;
                long j11 = i16 & 127;
                int i17 = iK >> 3;
                int i18 = (iK & 7) << 3;
                long j12 = (j11 << i18) | (jArr2[i17] & (~(255 << i18)));
                jArr2[i17] = j12;
                jArr2[(((iK - 7) & i14) + (i14 & 7)) >> 3] = j12;
                objArr2[iK] = obj;
                fArr2[iK] = fArr[i12];
            } else {
                i12 = i15;
            }
            i15 = i12 + 1;
        }
    }

    public final void r(K k11, float f11) {
        int iL = l(k11);
        if (iL < 0) {
            iL = ~iL;
        }
        this.f1947b[iL] = k11;
        this.f1948c[iL] = f11;
    }
}
