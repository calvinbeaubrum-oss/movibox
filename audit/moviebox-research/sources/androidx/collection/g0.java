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
public final class g0 extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1924e;

    public g0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            m1.d.a("Capacity must be a positive value.");
        }
        k(t0.g(i11));
    }

    public final void e() {
        if (this.f1989c <= 8 || Long.compare(ULong.b(ULong.b(this.f1990d) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f1989c) * 25) ^ Long.MIN_VALUE) > 0) {
            o(t0.e(this.f1989c));
        } else {
            f();
        }
    }

    public final void f() {
        int i11;
        long[] jArr = this.f1987a;
        int i12 = this.f1989c;
        long[] jArr2 = this.f1988b;
        t0.a(jArr, i12);
        char c11 = 0;
        int i13 = 0;
        int iB = -1;
        while (i13 != i12) {
            int i14 = i13 >> 3;
            int i15 = (i13 & 7) << 3;
            long j11 = (jArr[i14] >> i15) & 255;
            if (j11 == 128) {
                iB = i13;
                i13++;
            } else {
                if (j11 == 254) {
                    int iA = l.p.a(jArr2[i13]) * (-862048943);
                    int i16 = iA ^ (iA << 16);
                    int i17 = i16 >>> 7;
                    int iH = h(i17);
                    int i18 = i17 & i12;
                    if (((iH - i18) & i12) / 8 == ((i13 - i18) & i12) / 8) {
                        jArr[i14] = (((long) (i16 & 127)) << i15) | ((~(255 << i15)) & jArr[i14]);
                        jArr[kotlin.collections.d.T(jArr)] = (jArr[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i19 = iH >> 3;
                        long j12 = jArr[i19];
                        int i21 = (iH & 7) << 3;
                        if (((j12 >> i21) & 255) == 128) {
                            int i22 = i13;
                            jArr[i19] = (((long) (i16 & 127)) << i21) | (j12 & (~(255 << i21)));
                            jArr[i14] = (jArr[i14] & (~(255 << i15))) | (128 << i15);
                            jArr2[iH] = jArr2[i22];
                            jArr2[i22] = 0;
                            i11 = i22;
                            iB = i11;
                        } else {
                            int i23 = i13;
                            jArr[i19] = (((long) (i16 & 127)) << i21) | (j12 & (~(255 << i21)));
                            if (iB == -1) {
                                iB = t0.b(jArr, i23 + 1, i12);
                            }
                            jArr2[iB] = jArr2[iH];
                            jArr2[iH] = jArr2[i23];
                            jArr2[i23] = jArr2[iB];
                            i11 = i23 - 1;
                        }
                        jArr[kotlin.collections.d.T(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i13 = i11 + 1;
                        c11 = 0;
                    }
                }
                i13++;
            }
        }
        i();
    }

    public final int g(long j11) {
        int iA = l.p.a(j11) * (-862048943);
        int i11 = iA ^ (iA << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f1989c;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr = this.f1987a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j12 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j13 = i13;
            int i19 = i16;
            long j14 = j12 ^ (j13 * 72340172838076673L);
            for (long j15 = (~j14) & (j14 - 72340172838076673L) & (-9187201950435737472L); j15 != 0; j15 &= j15 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j15) >> 3) + i15) & i14;
                if (this.f1988b[iNumberOfTrailingZeros] == j11) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j12) << 6) & j12 & (-9187201950435737472L)) != 0) {
                int iH = h(i12);
                if (this.f1924e == 0 && ((this.f1987a[iH >> 3] >> ((iH & 7) << 3)) & 255) != 254) {
                    e();
                    iH = h(i12);
                }
                this.f1990d++;
                int i21 = this.f1924e;
                long[] jArr2 = this.f1987a;
                int i22 = iH >> 3;
                long j16 = jArr2[i22];
                int i23 = (iH & 7) << 3;
                this.f1924e = i21 - (((j16 >> i23) & 255) == 128 ? 1 : 0);
                int i24 = this.f1989c;
                long j17 = ((~(255 << i23)) & j16) | (j13 << i23);
                jArr2[i22] = j17;
                jArr2[(((iH - 7) & i24) + (i24 & 7)) >> 3] = j17;
                return iH;
            }
            i16 = i19 + 8;
            i15 = (i15 + i16) & i14;
        }
    }

    public final int h(int i11) {
        int i12 = this.f1989c;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f1987a;
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

    public final void i() {
        this.f1924e = t0.c(b()) - this.f1990d;
    }

    public final void j(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = t0.f1991a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f1987a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        i();
    }

    public final void k(int i11) {
        int iMax = i11 > 0 ? Math.max(7, t0.f(i11)) : 0;
        this.f1989c = iMax;
        j(iMax);
        this.f1988b = new long[iMax];
    }

    public final void l(long j11) {
        this.f1988b[g(j11)] = j11;
    }

    public final boolean m(long j11) {
        int iNumberOfTrailingZeros;
        int iA = l.p.a(j11) * (-862048943);
        int i11 = iA ^ (iA << 16);
        int i12 = i11 & 127;
        int i13 = this.f1989c;
        int i14 = (i11 >>> 7) & i13;
        int i15 = 0;
        loop0: while (true) {
            long[] jArr = this.f1987a;
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j12 = ((jArr[i16 + 1] << (64 - i17)) & ((-i17) >> 63)) | (jArr[i16] >>> i17);
            long j13 = (((long) i12) * 72340172838076673L) ^ j12;
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j14) >> 3) + i14) & i13;
                if (this.f1988b[iNumberOfTrailingZeros] == j11) {
                    break loop0;
                }
            }
            if ((j12 & ((~j12) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i15 += 8;
            i14 = (i14 + i15) & i13;
        }
        boolean z11 = iNumberOfTrailingZeros >= 0;
        if (z11) {
            n(iNumberOfTrailingZeros);
        }
        return z11;
    }

    public final void n(int i11) {
        this.f1990d--;
        long[] jArr = this.f1987a;
        int i12 = this.f1989c;
        int i13 = i11 >> 3;
        int i14 = (i11 & 7) << 3;
        long j11 = (jArr[i13] & (~(255 << i14))) | (254 << i14);
        jArr[i13] = j11;
        jArr[(((i11 - 7) & i12) + (i12 & 7)) >> 3] = j11;
    }

    public final void o(int i11) {
        long[] jArr = this.f1987a;
        long[] jArr2 = this.f1988b;
        int i12 = this.f1989c;
        k(i11);
        long[] jArr3 = this.f1987a;
        long[] jArr4 = this.f1988b;
        int i13 = this.f1989c;
        for (int i14 = 0; i14 < i12; i14++) {
            if (((jArr[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                long j11 = jArr2[i14];
                int iA = l.p.a(j11) * (-862048943);
                int i15 = iA ^ (iA << 16);
                int iH = h(i15 >>> 7);
                long j12 = i15 & 127;
                int i16 = iH >> 3;
                int i17 = (iH & 7) << 3;
                long j13 = (jArr3[i16] & (~(255 << i17))) | (j12 << i17);
                jArr3[i16] = j13;
                jArr3[(((iH - 7) & i13) + (i13 & 7)) >> 3] = j13;
                jArr4[iH] = j11;
            }
        }
    }
}
