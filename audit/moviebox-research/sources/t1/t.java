package t1;

import androidx.compose.runtime.o1;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;

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
public final class t<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f76696e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f76697f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final t f76698g = new t(0, 0, new Object[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f76699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f76700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v1.e f76701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object[] f76702d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t a() {
            return t.f76698g;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t<K, V> f76703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f76704b;

        public b(t<K, V> tVar, int i11) {
            this.f76703a = tVar;
            this.f76704b = i11;
        }

        public final t<K, V> a() {
            return this.f76703a;
        }

        public final int b() {
            return this.f76704b;
        }

        public final void c(t<K, V> tVar) {
            this.f76703a = tVar;
        }
    }

    public t(int i11, int i12, Object[] objArr) {
        this(i11, i12, objArr, null);
    }

    public t(int i11, int i12, Object[] objArr, v1.e eVar) {
        this.f76699a = i11;
        this.f76700b = i12;
        this.f76701c = eVar;
        this.f76702d = objArr;
    }

    public final t<K, V> A(int i11, f<K, V> fVar) {
        fVar.n(fVar.size() - 1);
        fVar.l(W(i11));
        if (this.f76702d.length == 2) {
            return null;
        }
        if (this.f76701c != fVar.j()) {
            return new t<>(0, 0, x.h(this.f76702d, i11), fVar.j());
        }
        this.f76702d = x.h(this.f76702d, i11);
        return this;
    }

    public final t<K, V> B(int i11, K k11, V v11, v1.e eVar) {
        int iN = n(i11);
        if (this.f76701c != eVar) {
            return new t<>(i11 | this.f76699a, this.f76700b, x.g(this.f76702d, iN, k11, v11), eVar);
        }
        this.f76702d = x.g(this.f76702d, iN, k11, v11);
        this.f76699a = i11 | this.f76699a;
        return this;
    }

    public final t<K, V> C(int i11, int i12, int i13, K k11, V v11, int i14, v1.e eVar) {
        if (this.f76701c != eVar) {
            return new t<>(this.f76699a ^ i12, i12 | this.f76700b, d(i11, i12, i13, k11, v11, i14, eVar), eVar);
        }
        this.f76702d = d(i11, i12, i13, k11, v11, i14, eVar);
        this.f76699a ^= i12;
        this.f76700b |= i12;
        return this;
    }

    public final t<K, V> D(int i11, K k11, V v11, int i12, f<K, V> fVar) {
        int iF = 1 << x.f(i11, i12);
        if (q(iF)) {
            int iN = n(iF);
            if (Intrinsics.b(k11, t(iN))) {
                fVar.l(W(iN));
                return W(iN) == v11 ? this : M(iN, v11, fVar);
            }
            fVar.n(fVar.size() + 1);
            return C(iN, iF, i11, k11, v11, i12, fVar.j());
        }
        if (!r(iF)) {
            fVar.n(fVar.size() + 1);
            return B(iF, k11, v11, fVar.j());
        }
        int iO = O(iF);
        t<K, V> tVarN = N(iO);
        t<K, V> tVarW = i12 == 30 ? tVarN.w(k11, v11, fVar) : tVarN.D(i11, k11, v11, i12 + 5, fVar);
        return tVarN == tVarW ? this : L(iO, tVarW, fVar.j());
    }

    public final t<K, V> E(t<K, V> tVar, int i11, v1.b bVar, f<K, V> fVar) {
        if (this == tVar) {
            bVar.b(e());
            return this;
        }
        if (i11 > 30) {
            return x(tVar, bVar, fVar.j());
        }
        int i12 = this.f76700b | tVar.f76700b;
        int i13 = this.f76699a;
        int i14 = tVar.f76699a;
        int i15 = (i13 ^ i14) & (~i12);
        int i16 = i13 & i14;
        int i17 = i15;
        while (i16 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i16);
            if (Intrinsics.b(t(n(iLowestOneBit)), tVar.t(tVar.n(iLowestOneBit)))) {
                i17 |= iLowestOneBit;
            } else {
                i12 |= iLowestOneBit;
            }
            i16 ^= iLowestOneBit;
        }
        int i18 = 0;
        if (!((i12 & i17) == 0)) {
            o1.b("Check failed.");
        }
        t<K, V> tVar2 = (Intrinsics.b(this.f76701c, fVar.j()) && this.f76699a == i17 && this.f76700b == i12) ? this : new t<>(i17, i12, new Object[(Integer.bitCount(i17) * 2) + Integer.bitCount(i12)]);
        int i19 = i12;
        int i21 = 0;
        while (i19 != 0) {
            int iLowestOneBit2 = Integer.lowestOneBit(i19);
            Object[] objArr = tVar2.f76702d;
            objArr[(objArr.length - 1) - i21] = F(tVar, iLowestOneBit2, i11, bVar, fVar);
            i21++;
            i19 ^= iLowestOneBit2;
        }
        while (i17 != 0) {
            int iLowestOneBit3 = Integer.lowestOneBit(i17);
            int i22 = i18 * 2;
            if (tVar.q(iLowestOneBit3)) {
                int iN = tVar.n(iLowestOneBit3);
                tVar2.f76702d[i22] = tVar.t(iN);
                tVar2.f76702d[i22 + 1] = tVar.W(iN);
                if (q(iLowestOneBit3)) {
                    bVar.c(bVar.a() + 1);
                }
            } else {
                int iN2 = n(iLowestOneBit3);
                tVar2.f76702d[i22] = t(iN2);
                tVar2.f76702d[i22 + 1] = W(iN2);
            }
            i18++;
            i17 ^= iLowestOneBit3;
        }
        if (l(tVar2)) {
            return this;
        }
        return tVar.l(tVar2) ? tVar : tVar2;
    }

    public final t<K, V> F(t<K, V> tVar, int i11, int i12, v1.b bVar, f<K, V> fVar) {
        if (r(i11)) {
            t<K, V> tVarN = N(O(i11));
            if (tVar.r(i11)) {
                return tVarN.E(tVar.N(tVar.O(i11)), i12 + 5, bVar, fVar);
            }
            if (!tVar.q(i11)) {
                return tVarN;
            }
            int iN = tVar.n(i11);
            K kT = tVar.t(iN);
            V vW = tVar.W(iN);
            int size = fVar.size();
            t<K, V> tVarD = tVarN.D(kT != null ? kT.hashCode() : 0, kT, vW, i12 + 5, fVar);
            if (fVar.size() != size) {
                return tVarD;
            }
            bVar.c(bVar.a() + 1);
            return tVarD;
        }
        if (!tVar.r(i11)) {
            int iN2 = n(i11);
            K kT2 = t(iN2);
            V vW2 = W(iN2);
            int iN3 = tVar.n(i11);
            K kT3 = tVar.t(iN3);
            return u(kT2 != null ? kT2.hashCode() : 0, kT2, vW2, kT3 != null ? kT3.hashCode() : 0, kT3, tVar.W(iN3), i12 + 5, fVar.j());
        }
        t<K, V> tVarN2 = tVar.N(tVar.O(i11));
        if (q(i11)) {
            int iN4 = n(i11);
            K kT4 = t(iN4);
            int i13 = i12 + 5;
            if (!tVarN2.k(kT4 != null ? kT4.hashCode() : 0, kT4, i13)) {
                return tVarN2.D(kT4 != null ? kT4.hashCode() : 0, kT4, W(iN4), i13, fVar);
            }
            bVar.c(bVar.a() + 1);
        }
        return tVarN2;
    }

    public final t<K, V> G(int i11, K k11, int i12, f<K, V> fVar) {
        int iF = 1 << x.f(i11, i12);
        if (q(iF)) {
            int iN = n(iF);
            return Intrinsics.b(k11, t(iN)) ? I(iN, iF, fVar) : this;
        }
        if (!r(iF)) {
            return this;
        }
        int iO = O(iF);
        t<K, V> tVarN = N(iO);
        return K(tVarN, i12 == 30 ? tVarN.z(k11, fVar) : tVarN.G(i11, k11, i12 + 5, fVar), iO, iF, fVar.j());
    }

    public final t<K, V> H(int i11, K k11, V v11, int i12, f<K, V> fVar) {
        int iF = 1 << x.f(i11, i12);
        if (q(iF)) {
            int iN = n(iF);
            return (Intrinsics.b(k11, t(iN)) && Intrinsics.b(v11, W(iN))) ? I(iN, iF, fVar) : this;
        }
        if (!r(iF)) {
            return this;
        }
        int iO = O(iF);
        t<K, V> tVarN = N(iO);
        return K(tVarN, i12 == 30 ? tVarN.y(k11, v11, fVar) : tVarN.H(i11, k11, v11, i12 + 5, fVar), iO, iF, fVar.j());
    }

    public final t<K, V> I(int i11, int i12, f<K, V> fVar) {
        fVar.n(fVar.size() - 1);
        fVar.l(W(i11));
        if (this.f76702d.length == 2) {
            return null;
        }
        if (this.f76701c != fVar.j()) {
            return new t<>(i12 ^ this.f76699a, this.f76700b, x.h(this.f76702d, i11), fVar.j());
        }
        this.f76702d = x.h(this.f76702d, i11);
        this.f76699a ^= i12;
        return this;
    }

    public final t<K, V> J(int i11, int i12, v1.e eVar) {
        Object[] objArr = this.f76702d;
        if (objArr.length == 1) {
            return null;
        }
        if (this.f76701c != eVar) {
            return new t<>(this.f76699a, i12 ^ this.f76700b, x.i(objArr, i11), eVar);
        }
        this.f76702d = x.i(objArr, i11);
        this.f76700b ^= i12;
        return this;
    }

    public final t<K, V> K(t<K, V> tVar, t<K, V> tVar2, int i11, int i12, v1.e eVar) {
        if (tVar2 == null) {
            return J(i11, i12, eVar);
        }
        return (this.f76701c == eVar || tVar != tVar2) ? L(i11, tVar2, eVar) : this;
    }

    public final t<K, V> L(int i11, t<K, V> tVar, v1.e eVar) {
        Object[] objArr = this.f76702d;
        if (objArr.length == 1 && tVar.f76702d.length == 2 && tVar.f76700b == 0) {
            tVar.f76699a = this.f76700b;
            return tVar;
        }
        if (this.f76701c == eVar) {
            objArr[i11] = tVar;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.f(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i11] = tVar;
        return new t<>(this.f76699a, this.f76700b, objArrCopyOf, eVar);
    }

    public final t<K, V> M(int i11, V v11, f<K, V> fVar) {
        if (this.f76701c == fVar.j()) {
            this.f76702d[i11 + 1] = v11;
            return this;
        }
        fVar.k(fVar.g() + 1);
        Object[] objArr = this.f76702d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.f(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i11 + 1] = v11;
        return new t<>(this.f76699a, this.f76700b, objArrCopyOf, fVar.j());
    }

    public final t<K, V> N(int i11) {
        Object obj = this.f76702d[i11];
        Intrinsics.e(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (t) obj;
    }

    public final int O(int i11) {
        return (this.f76702d.length - 1) - Integer.bitCount((i11 - 1) & this.f76700b);
    }

    public final b<K, V> P(int i11, K k11, V v11, int i12) {
        b<K, V> bVarP;
        int iF = 1 << x.f(i11, i12);
        if (q(iF)) {
            int iN = n(iF);
            if (!Intrinsics.b(k11, t(iN))) {
                return v(iN, iF, i11, k11, v11, i12).b();
            }
            if (W(iN) == v11) {
                return null;
            }
            return V(iN, v11).c();
        }
        if (!r(iF)) {
            return s(iF, k11, v11).b();
        }
        int iO = O(iF);
        t<K, V> tVarN = N(iO);
        if (i12 == 30) {
            bVarP = tVarN.h(k11, v11);
            if (bVarP == null) {
                return null;
            }
        } else {
            bVarP = tVarN.P(i11, k11, v11, i12 + 5);
            if (bVarP == null) {
                return null;
            }
        }
        bVarP.c(U(iO, iF, bVarP.a()));
        return bVarP;
    }

    public final t<K, V> Q(int i11, K k11, int i12) {
        int iF = 1 << x.f(i11, i12);
        if (q(iF)) {
            int iN = n(iF);
            return Intrinsics.b(k11, t(iN)) ? R(iN, iF) : this;
        }
        if (!r(iF)) {
            return this;
        }
        int iO = O(iF);
        t<K, V> tVarN = N(iO);
        return T(tVarN, i12 == 30 ? tVarN.i(k11) : tVarN.Q(i11, k11, i12 + 5), iO, iF);
    }

    public final t<K, V> R(int i11, int i12) {
        Object[] objArr = this.f76702d;
        if (objArr.length == 2) {
            return null;
        }
        return new t<>(i12 ^ this.f76699a, this.f76700b, x.h(objArr, i11));
    }

    public final t<K, V> S(int i11, int i12) {
        Object[] objArr = this.f76702d;
        if (objArr.length == 1) {
            return null;
        }
        return new t<>(this.f76699a, i12 ^ this.f76700b, x.i(objArr, i11));
    }

    public final t<K, V> T(t<K, V> tVar, t<K, V> tVar2, int i11, int i12) {
        if (tVar2 == null) {
            return S(i11, i12);
        }
        return tVar != tVar2 ? U(i11, i12, tVar2) : this;
    }

    public final t<K, V> U(int i11, int i12, t<K, V> tVar) {
        Object[] objArr = tVar.f76702d;
        if (objArr.length != 2 || tVar.f76700b != 0) {
            Object[] objArr2 = this.f76702d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            objArrCopyOf[i11] = tVar;
            return new t<>(this.f76699a, this.f76700b, objArrCopyOf);
        }
        if (this.f76702d.length == 1) {
            tVar.f76699a = this.f76700b;
            return tVar;
        }
        return new t<>(this.f76699a ^ i12, i12 ^ this.f76700b, x.k(this.f76702d, i11, n(i12), objArr[0], objArr[1]));
    }

    public final t<K, V> V(int i11, V v11) {
        Object[] objArr = this.f76702d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.f(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i11 + 1] = v11;
        return new t<>(this.f76699a, this.f76700b, objArrCopyOf);
    }

    public final V W(int i11) {
        return (V) this.f76702d[i11 + 1];
    }

    public final b<K, V> b() {
        return new b<>(this, 1);
    }

    public final b<K, V> c() {
        return new b<>(this, 0);
    }

    public final Object[] d(int i11, int i12, int i13, K k11, V v11, int i14, v1.e eVar) {
        K kT = t(i11);
        return x.j(this.f76702d, i11, O(i12) + 1, u(kT != null ? kT.hashCode() : 0, kT, W(i11), i13, k11, v11, i14 + 5, eVar));
    }

    public final int e() {
        if (this.f76700b == 0) {
            return this.f76702d.length / 2;
        }
        int iBitCount = Integer.bitCount(this.f76699a);
        int length = this.f76702d.length;
        for (int i11 = iBitCount * 2; i11 < length; i11++) {
            iBitCount += N(i11).e();
        }
        return iBitCount;
    }

    public final boolean f(K k11) {
        IntProgression intProgressionQ = kotlin.ranges.a.q(kotlin.ranges.a.r(0, this.f76702d.length), 2);
        int iG = intProgressionQ.g();
        int i11 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if ((iR > 0 && iG <= i11) || (iR < 0 && i11 <= iG)) {
            while (!Intrinsics.b(k11, this.f76702d[iG])) {
                if (iG != i11) {
                    iG += iR;
                }
            }
            return true;
        }
        return false;
    }

    public final V g(K k11) {
        IntProgression intProgressionQ = kotlin.ranges.a.q(kotlin.ranges.a.r(0, this.f76702d.length), 2);
        int iG = intProgressionQ.g();
        int i11 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if ((iR <= 0 || iG > i11) && (iR >= 0 || i11 > iG)) {
            return null;
        }
        while (!Intrinsics.b(k11, t(iG))) {
            if (iG == i11) {
                return null;
            }
            iG += iR;
        }
        return W(iG);
    }

    public final b<K, V> h(K k11, V v11) {
        IntProgression intProgressionQ = kotlin.ranges.a.q(kotlin.ranges.a.r(0, this.f76702d.length), 2);
        int iG = intProgressionQ.g();
        int i11 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if ((iR > 0 && iG <= i11) || (iR < 0 && i11 <= iG)) {
            while (!Intrinsics.b(k11, t(iG))) {
                if (iG != i11) {
                    iG += iR;
                }
            }
            if (v11 == W(iG)) {
                return null;
            }
            Object[] objArr = this.f76702d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.f(objArrCopyOf, "copyOf(this, size)");
            objArrCopyOf[iG + 1] = v11;
            return new t(0, 0, objArrCopyOf).c();
        }
        return new t(0, 0, x.g(this.f76702d, 0, k11, v11)).b();
    }

    public final t<K, V> i(K k11) {
        IntProgression intProgressionQ = kotlin.ranges.a.q(kotlin.ranges.a.r(0, this.f76702d.length), 2);
        int iG = intProgressionQ.g();
        int i11 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if ((iR > 0 && iG <= i11) || (iR < 0 && i11 <= iG)) {
            while (!Intrinsics.b(k11, t(iG))) {
                if (iG != i11) {
                    iG += iR;
                }
            }
            return j(iG);
        }
        return this;
    }

    public final t<K, V> j(int i11) {
        Object[] objArr = this.f76702d;
        if (objArr.length == 2) {
            return null;
        }
        return new t<>(0, 0, x.h(objArr, i11));
    }

    public final boolean k(int i11, K k11, int i12) {
        int iF = 1 << x.f(i11, i12);
        if (q(iF)) {
            return Intrinsics.b(k11, t(n(iF)));
        }
        if (!r(iF)) {
            return false;
        }
        t<K, V> tVarN = N(O(iF));
        return i12 == 30 ? tVarN.f(k11) : tVarN.k(i11, k11, i12 + 5);
    }

    public final boolean l(t<K, V> tVar) {
        if (this == tVar) {
            return true;
        }
        if (this.f76700b != tVar.f76700b || this.f76699a != tVar.f76699a) {
            return false;
        }
        int length = this.f76702d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (this.f76702d[i11] != tVar.f76702d[i11]) {
                return false;
            }
        }
        return true;
    }

    public final int m() {
        return Integer.bitCount(this.f76699a);
    }

    public final int n(int i11) {
        return Integer.bitCount((i11 - 1) & this.f76699a) * 2;
    }

    public final V o(int i11, K k11, int i12) {
        int iF = 1 << x.f(i11, i12);
        if (q(iF)) {
            int iN = n(iF);
            if (Intrinsics.b(k11, t(iN))) {
                return W(iN);
            }
            return null;
        }
        if (!r(iF)) {
            return null;
        }
        t<K, V> tVarN = N(O(iF));
        return i12 == 30 ? tVarN.g(k11) : tVarN.o(i11, k11, i12 + 5);
    }

    public final Object[] p() {
        return this.f76702d;
    }

    public final boolean q(int i11) {
        return (i11 & this.f76699a) != 0;
    }

    public final boolean r(int i11) {
        return (i11 & this.f76700b) != 0;
    }

    public final t<K, V> s(int i11, K k11, V v11) {
        return new t<>(i11 | this.f76699a, this.f76700b, x.g(this.f76702d, n(i11), k11, v11));
    }

    public final K t(int i11) {
        return (K) this.f76702d[i11];
    }

    public final t<K, V> u(int i11, K k11, V v11, int i12, K k12, V v12, int i13, v1.e eVar) {
        if (i13 > 30) {
            return new t<>(0, 0, new Object[]{k11, v11, k12, v12}, eVar);
        }
        int iF = x.f(i11, i13);
        int iF2 = x.f(i12, i13);
        if (iF != iF2) {
            return new t<>((1 << iF) | (1 << iF2), 0, iF < iF2 ? new Object[]{k11, v11, k12, v12} : new Object[]{k12, v12, k11, v11}, eVar);
        }
        return new t<>(0, 1 << iF, new Object[]{u(i11, k11, v11, i12, k12, v12, i13 + 5, eVar)}, eVar);
    }

    public final t<K, V> v(int i11, int i12, int i13, K k11, V v11, int i14) {
        return new t<>(this.f76699a ^ i12, i12 | this.f76700b, d(i11, i12, i13, k11, v11, i14, null));
    }

    public final t<K, V> w(K k11, V v11, f<K, V> fVar) {
        IntProgression intProgressionQ = kotlin.ranges.a.q(kotlin.ranges.a.r(0, this.f76702d.length), 2);
        int iG = intProgressionQ.g();
        int i11 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if ((iR > 0 && iG <= i11) || (iR < 0 && i11 <= iG)) {
            while (!Intrinsics.b(k11, t(iG))) {
                if (iG != i11) {
                    iG += iR;
                }
            }
            fVar.l(W(iG));
            if (this.f76701c == fVar.j()) {
                this.f76702d[iG + 1] = v11;
                return this;
            }
            fVar.k(fVar.g() + 1);
            Object[] objArr = this.f76702d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.f(objArrCopyOf, "copyOf(this, size)");
            objArrCopyOf[iG + 1] = v11;
            return new t<>(0, 0, objArrCopyOf, fVar.j());
        }
        fVar.n(fVar.size() + 1);
        return new t<>(0, 0, x.g(this.f76702d, 0, k11, v11), fVar.j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<K, V> x(t<K, V> tVar, v1.b bVar, v1.e eVar) {
        v1.a.a(this.f76700b == 0);
        v1.a.a(this.f76699a == 0);
        v1.a.a(tVar.f76700b == 0);
        v1.a.a(tVar.f76699a == 0);
        Object[] objArr = this.f76702d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + tVar.f76702d.length);
        Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
        int length = this.f76702d.length;
        IntProgression intProgressionQ = kotlin.ranges.a.q(kotlin.ranges.a.r(0, tVar.f76702d.length), 2);
        int iG = intProgressionQ.g();
        int i11 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if ((iR > 0 && iG <= i11) || (iR < 0 && i11 <= iG)) {
            while (true) {
                if (f(tVar.f76702d[iG])) {
                    bVar.c(bVar.a() + 1);
                } else {
                    Object[] objArr2 = tVar.f76702d;
                    objArrCopyOf[length] = objArr2[iG];
                    objArrCopyOf[length + 1] = objArr2[iG + 1];
                    length += 2;
                }
                if (iG == i11) {
                    break;
                }
                iG += iR;
            }
        }
        if (length == this.f76702d.length) {
            return this;
        }
        if (length == tVar.f76702d.length) {
            return tVar;
        }
        if (length == objArrCopyOf.length) {
            return new t<>(0, 0, objArrCopyOf, eVar);
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, length);
        Intrinsics.f(objArrCopyOf2, "copyOf(this, newSize)");
        return new t<>(0, 0, objArrCopyOf2, eVar);
    }

    public final t<K, V> y(K k11, V v11, f<K, V> fVar) {
        IntProgression intProgressionQ = kotlin.ranges.a.q(kotlin.ranges.a.r(0, this.f76702d.length), 2);
        int iG = intProgressionQ.g();
        int i11 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if ((iR > 0 && iG <= i11) || (iR < 0 && i11 <= iG)) {
            while (true) {
                if (Intrinsics.b(k11, t(iG)) && Intrinsics.b(v11, W(iG))) {
                    return A(iG, fVar);
                }
                if (iG != i11) {
                    iG += iR;
                }
            }
        }
        return this;
    }

    public final t<K, V> z(K k11, f<K, V> fVar) {
        IntProgression intProgressionQ = kotlin.ranges.a.q(kotlin.ranges.a.r(0, this.f76702d.length), 2);
        int iG = intProgressionQ.g();
        int i11 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if ((iR > 0 && iG <= i11) || (iR < 0 && i11 <= iG)) {
            while (!Intrinsics.b(k11, t(iG))) {
                if (iG != i11) {
                    iG += iR;
                }
            }
            return A(iG, fVar);
        }
        return this;
    }
}
