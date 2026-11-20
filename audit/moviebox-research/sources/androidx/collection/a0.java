package androidx.collection;

import kotlin.Metadata;
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
public final class a0 extends k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1911f;

    public a0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            m1.d.a("Capacity must be a positive value.");
        }
        o(t0.g(i11));
    }

    public /* synthetic */ a0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    public final void h() {
        if (this.f1939d <= 8 || Long.compare(ULong.b(ULong.b(this.f1940e) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f1939d) * 25) ^ Long.MIN_VALUE) > 0) {
            p(t0.e(this.f1939d));
        } else {
            j();
        }
    }

    public final void i() {
        this.f1940e = 0;
        long[] jArr = this.f1936a;
        if (jArr != t0.f1991a) {
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f1936a;
            int i11 = this.f1939d;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        m();
    }

    public final void j() {
        int[] iArr;
        int i11;
        int i12;
        long[] jArr = this.f1936a;
        int i13 = this.f1939d;
        int[] iArr2 = this.f1937b;
        int[] iArr3 = this.f1938c;
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
                    int iK = k(i19);
                    int i21 = i19 & i13;
                    if (((iK - i21) & i13) / 8 == ((i14 - i21) & i13) / 8) {
                        jArr[i15] = (((long) (i18 & 127)) << i16) | ((~(255 << i16)) & jArr[i15]);
                        jArr[kotlin.collections.d.T(jArr)] = (jArr[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i22 = iK >> 3;
                        long j12 = jArr[i22];
                        int i23 = (iK & 7) << 3;
                        if (((j12 >> i23) & 255) == 128) {
                            int i24 = i14;
                            iArr = iArr2;
                            jArr[i22] = (j12 & (~(255 << i23))) | (((long) (i18 & 127)) << i23);
                            jArr[i15] = (jArr[i15] & (~(255 << i16))) | (128 << i16);
                            iArr[iK] = iArr[i24];
                            iArr[i24] = 0;
                            iArr3[iK] = iArr3[i24];
                            iArr3[i24] = 0;
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
                            iArr[iB] = iArr[iK];
                            iArr[iK] = iArr[i26];
                            iArr[i26] = iArr[iB];
                            iArr3[iB] = iArr3[iK];
                            iArr3[iK] = iArr3[i26];
                            iArr3[i26] = iArr3[iB];
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
        int i12 = this.f1939d;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f1936a;
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

    public final int l(int i11) {
        int i12 = (-862048943) * i11;
        int i13 = i12 ^ (i12 << 16);
        int i14 = i13 >>> 7;
        int i15 = i13 & 127;
        int i16 = this.f1939d;
        int i17 = i14 & i16;
        int i18 = 0;
        while (true) {
            long[] jArr = this.f1936a;
            int i19 = i17 >> 3;
            int i21 = (i17 & 7) << 3;
            long j11 = ((jArr[i19 + 1] << (64 - i21)) & ((-i21) >> 63)) | (jArr[i19] >>> i21);
            long j12 = i15;
            int i22 = i18;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int iNumberOfTrailingZeros = (i17 + (Long.numberOfTrailingZeros(j14) >> 3)) & i16;
                if (this.f1937b[iNumberOfTrailingZeros] == i11) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int iK = k(i14);
                if (this.f1911f == 0 && ((this.f1936a[iK >> 3] >> ((iK & 7) << 3)) & 255) != 254) {
                    h();
                    iK = k(i14);
                }
                this.f1940e++;
                int i23 = this.f1911f;
                long[] jArr2 = this.f1936a;
                int i24 = iK >> 3;
                long j15 = jArr2[i24];
                int i25 = (iK & 7) << 3;
                this.f1911f = i23 - (((j15 >> i25) & 255) == 128 ? 1 : 0);
                int i26 = this.f1939d;
                long j16 = ((~(255 << i25)) & j15) | (j12 << i25);
                jArr2[i24] = j16;
                jArr2[(((iK - 7) & i26) + (i26 & 7)) >> 3] = j16;
                return ~iK;
            }
            i18 = i22 + 8;
            i17 = (i17 + i18) & i16;
        }
    }

    public final void m() {
        this.f1911f = t0.c(d()) - this.f1940e;
    }

    public final void n(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = t0.f1991a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f1936a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        m();
    }

    public final void o(int i11) {
        int iMax = i11 > 0 ? Math.max(7, t0.f(i11)) : 0;
        this.f1939d = iMax;
        n(iMax);
        this.f1937b = new int[iMax];
        this.f1938c = new int[iMax];
    }

    public final void p(int i11) {
        a0 a0Var = this;
        long[] jArr = a0Var.f1936a;
        int[] iArr = a0Var.f1937b;
        int[] iArr2 = a0Var.f1938c;
        int i12 = a0Var.f1939d;
        o(i11);
        long[] jArr2 = a0Var.f1936a;
        int[] iArr3 = a0Var.f1937b;
        int[] iArr4 = a0Var.f1938c;
        int i13 = a0Var.f1939d;
        int i14 = 0;
        while (i14 < i12) {
            if (((jArr[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                int i15 = iArr[i14];
                int i16 = (-862048943) * i15;
                int i17 = i16 ^ (i16 << 16);
                int iK = a0Var.k(i17 >>> 7);
                long j11 = i17 & 127;
                int i18 = iK >> 3;
                int i19 = (iK & 7) << 3;
                long j12 = (jArr2[i18] & (~(255 << i19))) | (j11 << i19);
                jArr2[i18] = j12;
                jArr2[(((iK - 7) & i13) + (i13 & 7)) >> 3] = j12;
                iArr3[iK] = i15;
                iArr4[iK] = iArr2[i14];
            }
            i14++;
            a0Var = this;
            jArr = jArr;
        }
    }

    public final void q(int i11, int i12) {
        int iL = l(i11);
        if (iL < 0) {
            iL = ~iL;
        }
        this.f1937b[iL] = i11;
        this.f1938c[iL] = i12;
    }
}
