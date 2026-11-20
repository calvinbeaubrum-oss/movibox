package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ULong;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableSet;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class MutableScatterSet<E> extends ScatterSet<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1890e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class MutableSetWrapper extends ScatterSet<E>.a implements KMutableSet {
        public MutableSetWrapper() {
            super();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(E e11) {
            return MutableScatterSet.this.h(e11);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends E> elements) {
            Intrinsics.g(elements, "elements");
            return MutableScatterSet.this.j(elements);
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MutableScatterSet.this.m();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return new MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet.this);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            return MutableScatterSet.this.x(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<? extends Object> elements) {
            Intrinsics.g(elements, "elements");
            int iC = MutableScatterSet.this.c();
            Iterator<? extends Object> it = elements.iterator();
            while (it.hasNext()) {
                MutableScatterSet.this.t((E) it.next());
            }
            return iC != MutableScatterSet.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<? extends Object> elements) {
            Intrinsics.g(elements, "elements");
            MutableScatterSet<E> mutableScatterSet = MutableScatterSet.this;
            long[] jArr = mutableScatterSet.f1897a;
            int length = jArr.length - 2;
            boolean z11 = false;
            if (length >= 0) {
                int i11 = 0;
                boolean z12 = false;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                int i14 = (i11 << 3) + i13;
                                if (!elements.contains(mutableScatterSet.f1898b[i14])) {
                                    mutableScatterSet.y(i14);
                                    z12 = true;
                                }
                            }
                            j11 >>= 8;
                        }
                        if (i12 != 8) {
                            return z12;
                        }
                    }
                    if (i11 != length) {
                        i11++;
                    } else {
                        z11 = z12;
                    }
                }
            }
            return z11;
        }
    }

    public MutableScatterSet() {
        this(0, 1, null);
    }

    public MutableScatterSet(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            m1.d.a("Capacity must be a positive value.");
        }
        s(t0.g(i11));
    }

    public /* synthetic */ MutableScatterSet(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    public final boolean h(E e11) {
        int iC = c();
        this.f1898b[o(e11)] = e11;
        return c() != iC;
    }

    public final boolean i(ScatterSet<E> elements) {
        Intrinsics.g(elements, "elements");
        int iC = c();
        u(elements);
        return iC != c();
    }

    public final boolean j(Iterable<? extends E> elements) {
        Intrinsics.g(elements, "elements");
        int iC = c();
        v(elements);
        return iC != c();
    }

    public final void k() {
        if (this.f1899c <= 8 || Long.compare(ULong.b(ULong.b(this.f1900d) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f1899c) * 25) ^ Long.MIN_VALUE) > 0) {
            z(t0.e(this.f1899c));
        } else {
            n();
        }
    }

    public final Set<E> l() {
        return new MutableSetWrapper();
    }

    public final void m() {
        this.f1900d = 0;
        long[] jArr = this.f1897a;
        if (jArr != t0.f1991a) {
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f1897a;
            int i11 = this.f1899c;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        ArraysKt___ArraysJvmKt.u(this.f1898b, null, 0, this.f1899c);
        q();
    }

    public final void n() {
        int i11;
        long[] jArr = this.f1897a;
        int i12 = this.f1899c;
        Object[] objArr = this.f1898b;
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
                    Object obj = objArr[i13];
                    int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                    int i16 = iHashCode ^ (iHashCode << 16);
                    int i17 = i16 >>> 7;
                    int iP = p(i17);
                    int i18 = i17 & i12;
                    if (((iP - i18) & i12) / 8 == ((i13 - i18) & i12) / 8) {
                        jArr[i14] = (((long) (i16 & 127)) << i15) | ((~(255 << i15)) & jArr[i14]);
                        jArr[kotlin.collections.d.T(jArr)] = (jArr[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i19 = iP >> 3;
                        long j12 = jArr[i19];
                        int i21 = (iP & 7) << 3;
                        if (((j12 >> i21) & 255) == 128) {
                            int i22 = i13;
                            jArr[i19] = (((long) (i16 & 127)) << i21) | (j12 & (~(255 << i21)));
                            jArr[i14] = (jArr[i14] & (~(255 << i15))) | (128 << i15);
                            objArr[iP] = objArr[i22];
                            objArr[i22] = null;
                            i11 = i22;
                            iB = i11;
                        } else {
                            int i23 = i13;
                            jArr[i19] = (((long) (i16 & 127)) << i21) | (j12 & (~(255 << i21)));
                            if (iB == -1) {
                                iB = t0.b(jArr, i23 + 1, i12);
                            }
                            objArr[iB] = objArr[iP];
                            objArr[iP] = objArr[i23];
                            objArr[i23] = objArr[iB];
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
        q();
    }

    public final int o(E e11) {
        int iHashCode = (e11 != null ? e11.hashCode() : 0) * (-862048943);
        int i11 = iHashCode ^ (iHashCode << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f1899c;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr = this.f1897a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j11 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j12 = i13;
            int i19 = i13;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int iNumberOfTrailingZeros = (i15 + (Long.numberOfTrailingZeros(j14) >> 3)) & i14;
                if (Intrinsics.b(this.f1898b[iNumberOfTrailingZeros], e11)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int iP = p(i12);
                if (this.f1890e == 0 && ((this.f1897a[iP >> 3] >> ((iP & 7) << 3)) & 255) != 254) {
                    k();
                    iP = p(i12);
                }
                this.f1900d++;
                int i21 = this.f1890e;
                long[] jArr2 = this.f1897a;
                int i22 = iP >> 3;
                long j15 = jArr2[i22];
                int i23 = (iP & 7) << 3;
                this.f1890e = i21 - (((j15 >> i23) & 255) == 128 ? 1 : 0);
                int i24 = this.f1899c;
                long j16 = ((~(255 << i23)) & j15) | (j12 << i23);
                jArr2[i22] = j16;
                jArr2[(((iP - 7) & i24) + (i24 & 7)) >> 3] = j16;
                return iP;
            }
            i16 += 8;
            i15 = (i15 + i16) & i14;
            i13 = i19;
        }
    }

    public final int p(int i11) {
        int i12 = this.f1899c;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f1897a;
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

    public final void q() {
        this.f1890e = t0.c(b()) - this.f1900d;
    }

    public final void r(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = t0.f1991a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt___ArraysJvmKt.w(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f1897a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        q();
    }

    public final void s(int i11) {
        int iMax = i11 > 0 ? Math.max(7, t0.f(i11)) : 0;
        this.f1899c = iMax;
        r(iMax);
        this.f1898b = new Object[iMax];
    }

    public final void t(E e11) {
        int iNumberOfTrailingZeros;
        int i11 = 0;
        int iHashCode = (e11 != null ? e11.hashCode() : 0) * (-862048943);
        int i12 = iHashCode ^ (iHashCode << 16);
        int i13 = i12 & 127;
        int i14 = this.f1899c;
        int i15 = i12 >>> 7;
        loop0: while (true) {
            int i16 = i15 & i14;
            long[] jArr = this.f1897a;
            int i17 = i16 >> 3;
            int i18 = (i16 & 7) << 3;
            long j11 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j12 = (((long) i13) * 72340172838076673L) ^ j11;
            for (long j13 = (~j12) & (j12 - 72340172838076673L) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j13) >> 3) + i16) & i14;
                if (Intrinsics.b(this.f1898b[iNumberOfTrailingZeros], e11)) {
                    break loop0;
                }
            }
            if ((j11 & ((~j11) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            } else {
                i11 += 8;
                i15 = i16 + i11;
            }
        }
        if (iNumberOfTrailingZeros >= 0) {
            y(iNumberOfTrailingZeros);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u(ScatterSet<E> elements) {
        Intrinsics.g(elements, "elements");
        Object[] objArr = elements.f1898b;
        long[] jArr = elements.f1897a;
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
                        w(objArr[(i11 << 3) + i13]);
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

    public final void v(Iterable<? extends E> elements) {
        Intrinsics.g(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            w(it.next());
        }
    }

    public final void w(E e11) {
        this.f1898b[o(e11)] = e11;
    }

    public final boolean x(E e11) {
        int iNumberOfTrailingZeros;
        int iHashCode = (e11 != null ? e11.hashCode() : 0) * (-862048943);
        int i11 = iHashCode ^ (iHashCode << 16);
        int i12 = i11 & 127;
        int i13 = this.f1899c;
        int i14 = (i11 >>> 7) & i13;
        int i15 = 0;
        loop0: while (true) {
            long[] jArr = this.f1897a;
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j11 = ((jArr[i16 + 1] << (64 - i17)) & ((-i17) >> 63)) | (jArr[i16] >>> i17);
            long j12 = (((long) i12) * 72340172838076673L) ^ j11;
            for (long j13 = (~j12) & (j12 - 72340172838076673L) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j13) >> 3) + i14) & i13;
                if (Intrinsics.b(this.f1898b[iNumberOfTrailingZeros], e11)) {
                    break loop0;
                }
            }
            if ((j11 & ((~j11) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i15 += 8;
            i14 = (i14 + i15) & i13;
        }
        boolean z11 = iNumberOfTrailingZeros >= 0;
        if (z11) {
            y(iNumberOfTrailingZeros);
        }
        return z11;
    }

    @PublishedApi
    public final void y(int i11) {
        this.f1900d--;
        long[] jArr = this.f1897a;
        int i12 = this.f1899c;
        int i13 = i11 >> 3;
        int i14 = (i11 & 7) << 3;
        long j11 = (jArr[i13] & (~(255 << i14))) | (254 << i14);
        jArr[i13] = j11;
        jArr[(((i11 - 7) & i12) + (i12 & 7)) >> 3] = j11;
        this.f1898b[i11] = null;
    }

    public final void z(int i11) {
        long[] jArr = this.f1897a;
        Object[] objArr = this.f1898b;
        int i12 = this.f1899c;
        s(i11);
        long[] jArr2 = this.f1897a;
        Object[] objArr2 = this.f1898b;
        int i13 = this.f1899c;
        for (int i14 = 0; i14 < i12; i14++) {
            if (((jArr[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i14];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i15 = iHashCode ^ (iHashCode << 16);
                int iP = p(i15 >>> 7);
                long j11 = i15 & 127;
                int i16 = iP >> 3;
                int i17 = (iP & 7) << 3;
                long j12 = (jArr2[i16] & (~(255 << i17))) | (j11 << i17);
                jArr2[i16] = j12;
                jArr2[(((iP - 7) & i13) + (i13 & 7)) >> 3] = j12;
                objArr2[iP] = obj;
            }
        }
    }
}
