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
public final class d0 extends p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1917e;

    public d0() {
        this(0, 1, null);
    }

    public d0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            m1.d.a("Capacity must be a positive value.");
        }
        n(t0.g(i11));
    }

    public /* synthetic */ d0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    public final boolean f(int i11) {
        int i12 = this.f1966d;
        this.f1964b[j(i11)] = i11;
        return this.f1966d != i12;
    }

    public final void g() {
        if (this.f1965c <= 8 || Long.compare(ULong.b(ULong.b(this.f1966d) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f1965c) * 25) ^ Long.MIN_VALUE) > 0) {
            t(t0.e(this.f1965c));
        } else {
            i();
        }
    }

    public final void h() {
        this.f1966d = 0;
        long[] jArr = this.f1963a;
        if (jArr != t0.f1991a) {
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f1963a;
            int i11 = this.f1965c;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        l();
    }

    public final void i() {
        int i11;
        long[] jArr = this.f1963a;
        int i12 = this.f1965c;
        int[] iArr = this.f1964b;
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
                    int i16 = iArr[i13] * (-862048943);
                    int i17 = i16 ^ (i16 << 16);
                    int i18 = i17 >>> 7;
                    int iK = k(i18);
                    int i19 = i18 & i12;
                    if (((iK - i19) & i12) / 8 == ((i13 - i19) & i12) / 8) {
                        jArr[i14] = (((long) (i17 & 127)) << i15) | ((~(255 << i15)) & jArr[i14]);
                        jArr[kotlin.collections.d.T(jArr)] = (jArr[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i21 = iK >> 3;
                        long j12 = jArr[i21];
                        int i22 = (iK & 7) << 3;
                        if (((j12 >> i22) & 255) == 128) {
                            int i23 = i13;
                            jArr[i21] = (((long) (i17 & 127)) << i22) | (j12 & (~(255 << i22)));
                            jArr[i14] = (jArr[i14] & (~(255 << i15))) | (128 << i15);
                            iArr[iK] = iArr[i23];
                            iArr[i23] = 0;
                            i11 = i23;
                            iB = i11;
                        } else {
                            int i24 = i13;
                            jArr[i21] = (((long) (i17 & 127)) << i22) | (j12 & (~(255 << i22)));
                            if (iB == -1) {
                                iB = t0.b(jArr, i24 + 1, i12);
                            }
                            iArr[iB] = iArr[iK];
                            iArr[iK] = iArr[i24];
                            iArr[i24] = iArr[iB];
                            i11 = i24 - 1;
                        }
                        jArr[kotlin.collections.d.T(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i13 = i11 + 1;
                        c11 = 0;
                    }
                }
                i13++;
            }
        }
        l();
    }

    public final int j(int i11) {
        int i12 = (-862048943) * i11;
        int i13 = i12 ^ (i12 << 16);
        int i14 = i13 >>> 7;
        int i15 = i13 & 127;
        int i16 = this.f1965c;
        int i17 = i14 & i16;
        int i18 = 0;
        while (true) {
            long[] jArr = this.f1963a;
            int i19 = i17 >> 3;
            int i21 = (i17 & 7) << 3;
            long j11 = ((jArr[i19 + 1] << (64 - i21)) & ((-i21) >> 63)) | (jArr[i19] >>> i21);
            long j12 = i15;
            int i22 = i18;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int iNumberOfTrailingZeros = (i17 + (Long.numberOfTrailingZeros(j14) >> 3)) & i16;
                if (this.f1964b[iNumberOfTrailingZeros] == i11) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int iK = k(i14);
                if (this.f1917e == 0 && ((this.f1963a[iK >> 3] >> ((iK & 7) << 3)) & 255) != 254) {
                    g();
                    iK = k(i14);
                }
                this.f1966d++;
                int i23 = this.f1917e;
                long[] jArr2 = this.f1963a;
                int i24 = iK >> 3;
                long j15 = jArr2[i24];
                int i25 = (iK & 7) << 3;
                this.f1917e = i23 - (((j15 >> i25) & 255) == 128 ? 1 : 0);
                int i26 = this.f1965c;
                long j16 = ((~(255 << i25)) & j15) | (j12 << i25);
                jArr2[i24] = j16;
                jArr2[(((iK - 7) & i26) + (i26 & 7)) >> 3] = j16;
                return iK;
            }
            i18 = i22 + 8;
            i17 = (i17 + i18) & i16;
        }
    }

    public final int k(int i11) {
        int i12 = this.f1965c;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f1963a;
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

    public final void l() {
        this.f1917e = t0.c(b()) - this.f1966d;
    }

    public final void m(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = t0.f1991a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f1963a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        l();
    }

    public final void n(int i11) {
        int iMax = i11 > 0 ? Math.max(7, t0.f(i11)) : 0;
        this.f1965c = iMax;
        m(iMax);
        this.f1964b = new int[iMax];
    }

    public final void o(int i11) {
        int iNumberOfTrailingZeros;
        int i12 = (-862048943) * i11;
        int i13 = i12 ^ (i12 << 16);
        int i14 = i13 & 127;
        int i15 = this.f1965c;
        int i16 = (i13 >>> 7) & i15;
        int i17 = 0;
        loop0: while (true) {
            long[] jArr = this.f1963a;
            int i18 = i16 >> 3;
            int i19 = (i16 & 7) << 3;
            long j11 = ((jArr[i18 + 1] << (64 - i19)) & ((-i19) >> 63)) | (jArr[i18] >>> i19);
            long j12 = (((long) i14) * 72340172838076673L) ^ j11;
            for (long j13 = (~j12) & (j12 - 72340172838076673L) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j13) >> 3) + i16) & i15;
                if (this.f1964b[iNumberOfTrailingZeros] == i11) {
                    break loop0;
                }
            }
            if ((j11 & ((~j11) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            } else {
                i17 += 8;
                i16 = (i16 + i17) & i15;
            }
        }
        if (iNumberOfTrailingZeros >= 0) {
            s(iNumberOfTrailingZeros);
        }
    }

    public final void p(p elements) {
        Intrinsics.g(elements, "elements");
        int[] iArr = elements.f1964b;
        long[] jArr = elements.f1963a;
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
                        o(iArr[(i11 << 3) + i13]);
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

    public final boolean q(int i11) {
        int iNumberOfTrailingZeros;
        int i12 = (-862048943) * i11;
        int i13 = i12 ^ (i12 << 16);
        int i14 = i13 & 127;
        int i15 = this.f1965c;
        int i16 = (i13 >>> 7) & i15;
        int i17 = 0;
        loop0: while (true) {
            long[] jArr = this.f1963a;
            int i18 = i16 >> 3;
            int i19 = (i16 & 7) << 3;
            long j11 = ((jArr[i18 + 1] << (64 - i19)) & ((-i19) >> 63)) | (jArr[i18] >>> i19);
            long j12 = (((long) i14) * 72340172838076673L) ^ j11;
            for (long j13 = (~j12) & (j12 - 72340172838076673L) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j13) >> 3) + i16) & i15;
                if (this.f1964b[iNumberOfTrailingZeros] == i11) {
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
        boolean z11 = iNumberOfTrailingZeros >= 0;
        if (z11) {
            s(iNumberOfTrailingZeros);
        }
        return z11;
    }

    public final boolean r(p elements) {
        Intrinsics.g(elements, "elements");
        int i11 = this.f1966d;
        p(elements);
        return i11 != this.f1966d;
    }

    public final void s(int i11) {
        this.f1966d--;
        long[] jArr = this.f1963a;
        int i12 = this.f1965c;
        int i13 = i11 >> 3;
        int i14 = (i11 & 7) << 3;
        long j11 = (jArr[i13] & (~(255 << i14))) | (254 << i14);
        jArr[i13] = j11;
        jArr[(((i11 - 7) & i12) + (i12 & 7)) >> 3] = j11;
    }

    public final void t(int i11) {
        long[] jArr = this.f1963a;
        int[] iArr = this.f1964b;
        int i12 = this.f1965c;
        n(i11);
        long[] jArr2 = this.f1963a;
        int[] iArr2 = this.f1964b;
        int i13 = this.f1965c;
        for (int i14 = 0; i14 < i12; i14++) {
            if (((jArr[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                int i15 = iArr[i14];
                int i16 = (-862048943) * i15;
                int i17 = i16 ^ (i16 << 16);
                int iK = k(i17 >>> 7);
                long j11 = i17 & 127;
                int i18 = iK >> 3;
                int i19 = (iK & 7) << 3;
                long j12 = (jArr2[i18] & (~(255 << i19))) | (j11 << i19);
                jArr2[i18] = j12;
                jArr2[(((iK - 7) & i13) + (i13 & 7)) >> 3] = j12;
                iArr2[iK] = i15;
            }
        }
    }
}
