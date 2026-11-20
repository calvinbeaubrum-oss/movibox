package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
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
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2 f3419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f3420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object[] f3422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap<c, l0> f3424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3427i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m0 f3429k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3430l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3431m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3432n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3433o;

    public i2(j2 j2Var) {
        this.f3419a = j2Var;
        this.f3420b = j2Var.v();
        int iW = j2Var.w();
        this.f3421c = iW;
        this.f3422d = j2Var.x();
        this.f3423e = j2Var.y();
        this.f3427i = iW;
        this.f3428j = -1;
        this.f3429k = new m0();
    }

    public final Object A(int i11) {
        return B(this.f3426h, i11);
    }

    public final Object B(int i11, int i12) {
        int iV = l2.V(this.f3420b, i11);
        int i13 = i11 + 1;
        int i14 = iV + i12;
        return i14 < (i13 < this.f3421c ? l2.F(this.f3420b, i13) : this.f3423e) ? this.f3422d[i14] : i.f3413a.a();
    }

    public final int C(int i11) {
        return l2.O(this.f3420b, i11);
    }

    public final Object D(int i11) {
        return O(this.f3420b, i11);
    }

    public final int E(int i11) {
        return l2.I(this.f3420b, i11);
    }

    public final boolean F(int i11) {
        return l2.K(this.f3420b, i11);
    }

    public final boolean G(int i11) {
        return l2.L(this.f3420b, i11);
    }

    public final boolean H() {
        return t() || this.f3426h == this.f3427i;
    }

    public final boolean I() {
        return l2.N(this.f3420b, this.f3426h);
    }

    public final boolean J(int i11) {
        return l2.N(this.f3420b, i11);
    }

    public final Object K() {
        int i11;
        if (this.f3430l > 0 || (i11 = this.f3431m) >= this.f3432n) {
            this.f3433o = false;
            return i.f3413a.a();
        }
        this.f3433o = true;
        Object[] objArr = this.f3422d;
        this.f3431m = i11 + 1;
        return objArr[i11];
    }

    public final Object L(int i11) {
        if (l2.N(this.f3420b, i11)) {
            return M(this.f3420b, i11);
        }
        return null;
    }

    public final Object M(int[] iArr, int i11) {
        return l2.N(iArr, i11) ? this.f3422d[l2.R(iArr, i11)] : i.f3413a.a();
    }

    public final int N(int i11) {
        return l2.Q(this.f3420b, i11);
    }

    public final Object O(int[] iArr, int i11) {
        if (l2.L(iArr, i11)) {
            return this.f3422d[l2.S(iArr, i11)];
        }
        return null;
    }

    public final int P(int i11) {
        return l2.T(this.f3420b, i11);
    }

    public final void Q(int i11) {
        if (!(this.f3430l == 0)) {
            k.s("Cannot reposition while in an empty region");
        }
        this.f3426h = i11;
        int iT = i11 < this.f3421c ? l2.T(this.f3420b, i11) : -1;
        this.f3428j = iT;
        if (iT < 0) {
            this.f3427i = this.f3421c;
        } else {
            this.f3427i = iT + l2.I(this.f3420b, iT);
        }
        this.f3431m = 0;
        this.f3432n = 0;
    }

    public final void R(int i11) {
        int I = l2.I(this.f3420b, i11) + i11;
        int i12 = this.f3426h;
        if (!(i12 >= i11 && i12 <= I)) {
            k.s("Index " + i11 + " is not a parent of " + i12);
        }
        this.f3428j = i11;
        this.f3427i = I;
        this.f3431m = 0;
        this.f3432n = 0;
    }

    public final int S() {
        if (!(this.f3430l == 0)) {
            k.s("Cannot skip while in an empty region");
        }
        int iQ = l2.N(this.f3420b, this.f3426h) ? 1 : l2.Q(this.f3420b, this.f3426h);
        int i11 = this.f3426h;
        this.f3426h = i11 + l2.I(this.f3420b, i11);
        return iQ;
    }

    public final void T() {
        if (!(this.f3430l == 0)) {
            k.s("Cannot skip the enclosing group while in an empty region");
        }
        this.f3426h = this.f3427i;
        this.f3431m = 0;
        this.f3432n = 0;
    }

    public final void U() {
        l0 l0Var;
        if (this.f3430l <= 0) {
            int i11 = this.f3428j;
            int i12 = this.f3426h;
            if (!(l2.T(this.f3420b, i12) == i11)) {
                o1.a("Invalid slot table detected");
            }
            HashMap<c, l0> map = this.f3424f;
            if (map != null && (l0Var = map.get(a(i11))) != null) {
                l0Var.h(this.f3419a, i12);
            }
            m0 m0Var = this.f3429k;
            int i13 = this.f3431m;
            int i14 = this.f3432n;
            if (i13 == 0 && i14 == 0) {
                m0Var.j(-1);
            } else {
                m0Var.j(i13);
            }
            this.f3428j = i12;
            this.f3427i = l2.I(this.f3420b, i12) + i12;
            int i15 = i12 + 1;
            this.f3426h = i15;
            this.f3431m = l2.V(this.f3420b, i12);
            this.f3432n = i12 >= this.f3421c - 1 ? this.f3423e : l2.F(this.f3420b, i15);
        }
    }

    public final void V() {
        if (this.f3430l <= 0) {
            if (!l2.N(this.f3420b, this.f3426h)) {
                o1.a("Expected a node group");
            }
            U();
        }
    }

    public final c a(int i11) {
        ArrayList<c> arrayListS = this.f3419a.s();
        int iU = l2.U(arrayListS, i11, this.f3421c);
        if (iU >= 0) {
            return arrayListS.get(iU);
        }
        c cVar = new c(i11);
        arrayListS.add(-(iU + 1), cVar);
        return cVar;
    }

    public final Object b(int[] iArr, int i11) {
        return l2.J(iArr, i11) ? this.f3422d[l2.B(iArr, i11)] : i.f3413a.a();
    }

    public final void c() {
        this.f3430l++;
    }

    public final void d() {
        this.f3425g = true;
        this.f3419a.f(this, this.f3424f);
    }

    public final boolean e(int i11) {
        return l2.D(this.f3420b, i11);
    }

    public final void f() {
        if (!(this.f3430l > 0)) {
            o1.a("Unbalanced begin/end empty");
        }
        this.f3430l--;
    }

    public final void g() {
        if (this.f3430l == 0) {
            if (!(this.f3426h == this.f3427i)) {
                k.s("endGroup() not called at the end of a group");
            }
            int iT = l2.T(this.f3420b, this.f3428j);
            this.f3428j = iT;
            this.f3427i = iT < 0 ? this.f3421c : l2.I(this.f3420b, iT) + iT;
            int i11 = this.f3429k.i();
            if (i11 < 0) {
                this.f3431m = 0;
                this.f3432n = 0;
            } else {
                this.f3431m = i11;
                this.f3432n = iT >= this.f3421c - 1 ? this.f3423e : l2.F(this.f3420b, iT + 1);
            }
        }
    }

    public final List<q0> h() {
        ArrayList arrayList = new ArrayList();
        if (this.f3430l > 0) {
            return arrayList;
        }
        int I = this.f3426h;
        int i11 = 0;
        while (I < this.f3427i) {
            arrayList.add(new q0(l2.O(this.f3420b, I), O(this.f3420b, I), I, l2.N(this.f3420b, I) ? 1 : l2.Q(this.f3420b, I), i11));
            I += l2.I(this.f3420b, I);
            i11++;
        }
        return arrayList;
    }

    public final boolean i() {
        return this.f3425g;
    }

    public final int j() {
        return this.f3427i;
    }

    public final int k() {
        return this.f3426h;
    }

    public final Object l() {
        int i11 = this.f3426h;
        if (i11 < this.f3427i) {
            return b(this.f3420b, i11);
        }
        return 0;
    }

    public final int m() {
        return this.f3427i;
    }

    public final int n() {
        int i11 = this.f3426h;
        if (i11 < this.f3427i) {
            return l2.O(this.f3420b, i11);
        }
        return 0;
    }

    public final Object o() {
        int i11 = this.f3426h;
        if (i11 < this.f3427i) {
            return O(this.f3420b, i11);
        }
        return null;
    }

    public final int p() {
        return l2.I(this.f3420b, this.f3426h);
    }

    public final int q() {
        return this.f3431m - l2.V(this.f3420b, this.f3428j);
    }

    public final boolean r() {
        return this.f3433o;
    }

    public final boolean s() {
        int i11 = this.f3426h;
        return i11 < this.f3427i && l2.L(this.f3420b, i11);
    }

    public final boolean t() {
        return this.f3430l > 0;
    }

    public String toString() {
        return "SlotReader(current=" + this.f3426h + ", key=" + n() + ", parent=" + this.f3428j + ", end=" + this.f3427i + ')';
    }

    public final int u() {
        return this.f3428j;
    }

    public final int v() {
        int i11 = this.f3428j;
        if (i11 >= 0) {
            return l2.Q(this.f3420b, i11);
        }
        return 0;
    }

    public final int w() {
        return this.f3432n - this.f3431m;
    }

    public final int x() {
        return this.f3421c;
    }

    public final j2 y() {
        return this.f3419a;
    }

    public final Object z(int i11) {
        return b(this.f3420b, i11);
    }
}
