package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class m2 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f3486y = new a(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f3487z = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2 f3488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f3489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f3490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<c> f3491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<c, l0> f3492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.collection.c0<androidx.collection.d0> f3493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3497j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3498k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3499l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3500m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3501n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3502o;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public androidx.collection.c0<androidx.collection.j0<Object>> f3506s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3507t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3508u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3510w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public r1 f3511x;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final m0 f3503p = new m0();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final m0 f3504q = new m0();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final m0 f3505r = new m0();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3509v = -1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ List c(a aVar, m2 m2Var, int i11, m2 m2Var2, boolean z11, boolean z12, boolean z13, int i12, Object obj) {
            return aVar.b(m2Var, i11, m2Var2, z11, z12, (i12 & 32) != 0 ? true : z13);
        }

        public final List<c> b(m2 m2Var, int i11, m2 m2Var2, boolean z11, boolean z12, boolean z13) {
            boolean zP0;
            List<c> listL;
            int iM0 = m2Var.m0(i11);
            int i12 = i11 + iM0;
            int iP = m2Var.P(i11);
            int iP2 = m2Var.P(i12);
            int i13 = iP2 - iP;
            boolean zM = m2Var.M(i11);
            m2Var2.q0(iM0);
            m2Var2.r0(i13, m2Var2.c0());
            if (m2Var.f3494g < i12) {
                m2Var.z0(i12);
            }
            if (m2Var.f3498k < iP2) {
                m2Var.B0(iP2, i12);
            }
            int[] iArr = m2Var2.f3489b;
            int iC0 = m2Var2.c0();
            ArraysKt___ArraysJvmKt.j(m2Var.f3489b, iArr, iC0 * 5, i11 * 5, i12 * 5);
            Object[] objArr = m2Var2.f3490c;
            int i14 = m2Var2.f3496i;
            ArraysKt___ArraysJvmKt.l(m2Var.f3490c, objArr, i14, iP, iP2);
            int iE0 = m2Var2.e0();
            l2.b0(iArr, iC0, iE0);
            int i15 = iC0 - i11;
            int i16 = iC0 + iM0;
            int iQ = i14 - m2Var2.Q(iArr, iC0);
            int i17 = m2Var2.f3500m;
            int i18 = m2Var2.f3499l;
            int length = objArr.length;
            int i19 = i17;
            int i21 = iC0;
            while (true) {
                zP0 = false;
                if (i21 >= i16) {
                    break;
                }
                if (i21 != iC0) {
                    l2.b0(iArr, i21, l2.T(iArr, i21) + i15);
                }
                l2.X(iArr, i21, m2Var2.S(m2Var2.Q(iArr, i21) + iQ, i19 < i21 ? 0 : m2Var2.f3498k, i18, length));
                if (i21 == i19) {
                    i19++;
                }
                i21++;
                iQ = iQ;
                i16 = i16;
            }
            int i22 = i16;
            m2Var2.f3500m = i19;
            int iP3 = l2.P(m2Var.f3491d, i11, m2Var.f0());
            int iP4 = l2.P(m2Var.f3491d, i12, m2Var.f0());
            if (iP3 < iP4) {
                ArrayList arrayList = m2Var.f3491d;
                ArrayList arrayList2 = new ArrayList(iP4 - iP3);
                for (int i23 = iP3; i23 < iP4; i23++) {
                    c cVar = (c) arrayList.get(i23);
                    cVar.c(cVar.a() + i15);
                    arrayList2.add(cVar);
                }
                m2Var2.f3491d.addAll(l2.P(m2Var2.f3491d, m2Var2.c0(), m2Var2.f0()), arrayList2);
                arrayList.subList(iP3, iP4).clear();
                listL = arrayList2;
            } else {
                listL = kotlin.collections.g.l();
            }
            if (!listL.isEmpty()) {
                HashMap map = m2Var.f3492e;
                HashMap map2 = m2Var2.f3492e;
                if (map != null && map2 != null) {
                    int size = listL.size();
                    for (int i24 = 0; i24 < size; i24++) {
                        c cVar2 = listL.get(i24);
                        l0 l0Var = (l0) map.get(cVar2);
                        if (l0Var != null) {
                            map.remove(cVar2);
                            map2.put(cVar2, l0Var);
                        }
                    }
                }
            }
            int iE1 = m2Var2.e0();
            l0 l0VarH1 = m2Var2.h1(iE0);
            if (l0VarH1 != null) {
                int I = iE1 + 1;
                int iC1 = m2Var2.c0();
                int i25 = -1;
                while (I < iC1) {
                    i25 = I;
                    I = l2.I(m2Var2.f3489b, I) + I;
                }
                l0VarH1.b(m2Var2, i25, iC1);
            }
            int iH0 = m2Var.H0(i11);
            if (z13) {
                if (z11) {
                    zP0 = iH0 >= 0;
                    if (zP0) {
                        m2Var.j1();
                        m2Var.D(iH0 - m2Var.c0());
                        m2Var.j1();
                    }
                    m2Var.D(i11 - m2Var.c0());
                    boolean zO0 = m2Var.O0();
                    if (zP0) {
                        m2Var.Z0();
                        m2Var.T();
                        m2Var.Z0();
                        m2Var.T();
                    }
                    zP0 = zO0;
                } else {
                    zP0 = m2Var.P0(i11, iM0);
                    m2Var.Q0(iP, i13, i11 - 1);
                }
            }
            if (!(!zP0)) {
                k.s("Unexpectedly removed anchors");
            }
            m2Var2.f3502o += l2.N(iArr, iC0) ? 1 : l2.Q(iArr, iC0);
            if (z12) {
                m2Var2.f3507t = i22;
                m2Var2.f3496i = i14 + i13;
            }
            if (zM) {
                m2Var2.s1(iE0);
            }
            return listL;
        }
    }

    public m2(j2 j2Var) {
        this.f3488a = j2Var;
        this.f3489b = j2Var.v();
        this.f3490c = j2Var.x();
        this.f3491d = j2Var.s();
        this.f3492e = j2Var.z();
        this.f3493f = j2Var.u();
        this.f3494g = j2Var.w();
        this.f3495h = (this.f3489b.length / 5) - j2Var.w();
        this.f3498k = j2Var.y();
        this.f3499l = this.f3490c.length - j2Var.y();
        this.f3500m = j2Var.w();
        this.f3508u = j2Var.w();
    }

    public static /* synthetic */ void v0(m2 m2Var, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = m2Var.f3509v;
        }
        m2Var.u0(i11);
    }

    public final List<c> A0(int i11, j2 j2Var, int i12) {
        k.Q(this.f3501n <= 0 && m0(this.f3507t + i11) == 1);
        int i13 = this.f3507t;
        int i14 = this.f3496i;
        int i15 = this.f3497j;
        D(i11);
        j1();
        I();
        m2 m2VarE = j2Var.E();
        try {
            List<c> listC = a.c(f3486y, m2VarE, i12, this, false, true, false, 32, null);
            m2VarE.L(true);
            U();
            T();
            this.f3507t = i13;
            this.f3496i = i14;
            this.f3497j = i15;
            return listC;
        } catch (Throwable th2) {
            m2VarE.L(false);
            throw th2;
        }
    }

    public final void B0(int i11, int i12) {
        int i13 = this.f3499l;
        int i14 = this.f3498k;
        int i15 = this.f3500m;
        if (i14 != i11) {
            Object[] objArr = this.f3490c;
            if (i11 < i14) {
                ArraysKt___ArraysJvmKt.l(objArr, objArr, i11 + i13, i11, i14);
            } else {
                ArraysKt___ArraysJvmKt.l(objArr, objArr, i14, i14 + i13, i11 + i13);
            }
        }
        int iMin = Math.min(i12 + 1, f0());
        if (i15 != iMin) {
            int length = this.f3490c.length - i13;
            if (iMin < i15) {
                int iJ0 = j0(iMin);
                int iJ1 = j0(i15);
                int i16 = this.f3494g;
                while (iJ0 < iJ1) {
                    int iF = l2.F(this.f3489b, iJ0);
                    if (!(iF >= 0)) {
                        k.s("Unexpected anchor value, expected a positive anchor");
                    }
                    l2.X(this.f3489b, iJ0, -((length - iF) + 1));
                    iJ0++;
                    if (iJ0 == i16) {
                        iJ0 += this.f3495h;
                    }
                }
            } else {
                int iJ2 = j0(i15);
                int iJ3 = j0(iMin);
                while (iJ2 < iJ3) {
                    int iF2 = l2.F(this.f3489b, iJ2);
                    if (!(iF2 < 0)) {
                        k.s("Unexpected anchor value, expected a negative anchor");
                    }
                    l2.X(this.f3489b, iJ2, iF2 + length + 1);
                    iJ2++;
                    if (iJ2 == this.f3494g) {
                        iJ2 += this.f3495h;
                    }
                }
            }
            this.f3500m = iMin;
        }
        this.f3498k = i11;
    }

    public final List<c> C0(c cVar, int i11, m2 m2Var) {
        k.Q(m2Var.f3501n > 0);
        k.Q(this.f3501n == 0);
        k.Q(cVar.b());
        int iF = F(cVar) + i11;
        int i12 = this.f3507t;
        k.Q(i12 <= iF && iF < this.f3508u);
        int iH0 = H0(iF);
        int iM0 = m0(iF);
        int iF0 = t0(iF) ? 1 : F0(iF);
        List<c> listC = a.c(f3486y, this, iF, m2Var, false, false, false, 32, null);
        s1(iH0);
        boolean z11 = iF0 > 0;
        while (iH0 >= i12) {
            int iJ0 = j0(iH0);
            int[] iArr = this.f3489b;
            l2.Y(iArr, iJ0, l2.I(iArr, iJ0) - iM0);
            if (z11) {
                if (l2.N(this.f3489b, iJ0)) {
                    z11 = false;
                } else {
                    int[] iArr2 = this.f3489b;
                    l2.a0(iArr2, iJ0, l2.Q(iArr2, iJ0) - iF0);
                }
            }
            iH0 = H0(iH0);
        }
        if (z11) {
            k.Q(this.f3502o >= iF0);
            this.f3502o -= iF0;
        }
        return listC;
    }

    public final void D(int i11) {
        boolean z11 = false;
        if (!(i11 >= 0)) {
            k.s("Cannot seek backwards");
        }
        if (!(this.f3501n <= 0)) {
            o1.b("Cannot call seek() while inserting");
        }
        if (i11 == 0) {
            return;
        }
        int i12 = this.f3507t + i11;
        if (i12 >= this.f3509v && i12 <= this.f3508u) {
            z11 = true;
        }
        if (!z11) {
            k.s("Cannot seek outside the current group (" + this.f3509v + '-' + this.f3508u + ')');
        }
        this.f3507t = i12;
        int iQ = Q(this.f3489b, j0(i12));
        this.f3496i = iQ;
        this.f3497j = iQ;
    }

    public final Object D0(int i11) {
        int iJ0 = j0(i11);
        if (l2.N(this.f3489b, iJ0)) {
            return this.f3490c[R(G0(this.f3489b, iJ0))];
        }
        return null;
    }

    public final c E(int i11) {
        ArrayList<c> arrayList = this.f3491d;
        int iU = l2.U(arrayList, i11, f0());
        if (iU >= 0) {
            return arrayList.get(iU);
        }
        if (i11 > this.f3494g) {
            i11 = -(f0() - i11);
        }
        c cVar = new c(i11);
        arrayList.add(-(iU + 1), cVar);
        return cVar;
    }

    public final Object E0(c cVar) {
        return D0(cVar.e(this));
    }

    public final int F(c cVar) {
        int iA = cVar.a();
        return iA < 0 ? iA + f0() : iA;
    }

    public final int F0(int i11) {
        return l2.Q(this.f3489b, j0(i11));
    }

    public final void G(c cVar, Object obj) {
        if (!(this.f3501n == 0)) {
            k.s("Can only append a slot if not current inserting");
        }
        int i11 = this.f3496i;
        int i12 = this.f3497j;
        int iF = F(cVar);
        int iQ = Q(this.f3489b, j0(iF + 1));
        this.f3496i = iQ;
        this.f3497j = iQ;
        r0(1, iF);
        if (i11 >= iQ) {
            i11++;
            i12++;
        }
        this.f3490c[iQ] = obj;
        this.f3496i = i11;
        this.f3497j = i12;
    }

    public final int G0(int[] iArr, int i11) {
        return Q(iArr, i11);
    }

    public final int H(int[] iArr, int i11) {
        return Q(iArr, i11) + l2.E(l2.H(iArr, i11) >> 29);
    }

    public final int H0(int i11) {
        return I0(this.f3489b, i11);
    }

    public final void I() {
        int i11 = this.f3501n;
        this.f3501n = i11 + 1;
        if (i11 == 0) {
            T0();
        }
    }

    public final int I0(int[] iArr, int i11) {
        return J0(l2.T(iArr, j0(i11)));
    }

    public final boolean J(int i11) {
        int iM0 = i11 + 1;
        int iM1 = i11 + m0(i11);
        while (iM0 < iM1) {
            if (l2.C(this.f3489b, j0(iM0))) {
                return true;
            }
            iM0 += m0(iM0);
        }
        return false;
    }

    public final int J0(int i11) {
        return i11 > -2 ? i11 : f0() + i11 + 2;
    }

    public final void K() {
        int i11 = this.f3498k;
        ArraysKt___ArraysJvmKt.u(this.f3490c, null, i11, this.f3499l + i11);
    }

    public final int K0(int i11, int i12) {
        return i11 < i12 ? i11 : -((f0() - i11) + 2);
    }

    public final void L(boolean z11) {
        this.f3510w = true;
        if (z11 && this.f3503p.d()) {
            z0(f0());
            B0(this.f3490c.length - this.f3499l, this.f3494g);
            K();
            M0();
        }
        this.f3488a.g(this, this.f3489b, this.f3494g, this.f3490c, this.f3498k, this.f3491d, this.f3492e, this.f3493f);
    }

    public final Object L0(Object obj) {
        Object objX0 = X0();
        W0(obj);
        return objX0;
    }

    public final boolean M(int i11) {
        return i11 >= 0 && l2.C(this.f3489b, j0(i11));
    }

    public final void M0() {
        r1 r1Var = this.f3511x;
        if (r1Var != null) {
            while (r1Var.b()) {
                t1(r1Var.d(), r1Var);
            }
        }
    }

    public final boolean N(int i11) {
        return i11 >= 0 && l2.D(this.f3489b, j0(i11));
    }

    public final boolean N0(int i11, int i12, HashMap<c, l0> map) {
        int i13 = i12 + i11;
        int iP = l2.P(this.f3491d, i13, Y() - this.f3495h);
        if (iP >= this.f3491d.size()) {
            iP--;
        }
        int i14 = iP + 1;
        int i15 = 0;
        while (iP >= 0) {
            c cVar = this.f3491d.get(iP);
            int iF = F(cVar);
            if (iF < i11) {
                break;
            }
            if (iF < i13) {
                cVar.c(Integer.MIN_VALUE);
                if (map != null) {
                    map.remove(cVar);
                }
                if (i15 == 0) {
                    i15 = iP + 1;
                }
                i14 = iP;
            }
            iP--;
        }
        boolean z11 = i14 < i15;
        if (z11) {
            this.f3491d.subList(i14, i15).clear();
        }
        return z11;
    }

    public final int O(int i11, int i12, int i13) {
        return i11 < 0 ? (i13 - i12) + i11 + 1 : i11;
    }

    public final boolean O0() {
        c cVarO1;
        if (!(this.f3501n == 0)) {
            k.s("Cannot remove group while inserting");
        }
        int i11 = this.f3507t;
        int i12 = this.f3496i;
        int iQ = Q(this.f3489b, j0(i11));
        int iY0 = Y0();
        l0 l0VarH1 = h1(this.f3509v);
        if (l0VarH1 != null && (cVarO1 = o1(i11)) != null) {
            l0VarH1.g(cVarO1);
        }
        r1 r1Var = this.f3511x;
        if (r1Var != null) {
            while (r1Var.b() && r1Var.c() >= i11) {
                r1Var.d();
            }
        }
        boolean zP0 = P0(i11, this.f3507t - i11);
        Q0(iQ, this.f3496i - iQ, i11 - 1);
        this.f3507t = i11;
        this.f3496i = i12;
        this.f3502o -= iY0;
        return zP0;
    }

    public final int P(int i11) {
        return Q(this.f3489b, j0(i11));
    }

    public final boolean P0(int i11, int i12) {
        boolean zN0 = false;
        if (i12 > 0) {
            ArrayList<c> arrayList = this.f3491d;
            z0(i11);
            zN0 = arrayList.isEmpty() ^ true ? N0(i11, i12, this.f3492e) : false;
            this.f3494g = i11;
            this.f3495h += i12;
            int i13 = this.f3500m;
            if (i13 > i11) {
                this.f3500m = Math.max(i11, i13 - i12);
            }
            int i14 = this.f3508u;
            if (i14 >= this.f3494g) {
                this.f3508u = i14 - i12;
            }
            int i15 = this.f3509v;
            if (N(i15)) {
                s1(i15);
            }
        }
        return zN0;
    }

    public final int Q(int[] iArr, int i11) {
        return i11 >= Y() ? this.f3490c.length - this.f3499l : O(l2.F(iArr, i11), this.f3499l, this.f3490c.length);
    }

    public final void Q0(int i11, int i12, int i13) {
        if (i12 > 0) {
            int i14 = this.f3499l;
            int i15 = i11 + i12;
            B0(i15, i13);
            this.f3498k = i11;
            this.f3499l = i14 + i12;
            ArraysKt___ArraysJvmKt.u(this.f3490c, null, i11, i15);
            int i16 = this.f3497j;
            if (i16 >= i11) {
                this.f3497j = i16 - i12;
            }
        }
    }

    public final int R(int i11) {
        return i11 < this.f3498k ? i11 : i11 + this.f3499l;
    }

    public final void R0() {
        if (!(this.f3501n == 0)) {
            k.s("Cannot reset when inserting");
        }
        M0();
        this.f3507t = 0;
        this.f3508u = Y() - this.f3495h;
        this.f3496i = 0;
        this.f3497j = 0;
        this.f3502o = 0;
    }

    public final int S(int i11, int i12, int i13, int i14) {
        return i11 > i12 ? -(((i14 - i13) - i11) + 1) : i11;
    }

    public final int S0() {
        int iY = (Y() - this.f3495h) - this.f3504q.i();
        this.f3508u = iY;
        return iY;
    }

    public final int T() {
        androidx.collection.j0<Object> j0VarC;
        boolean z11 = this.f3501n > 0;
        int i11 = this.f3507t;
        int i12 = this.f3508u;
        int i13 = this.f3509v;
        int iJ0 = j0(i13);
        int i14 = this.f3502o;
        int i15 = i11 - i13;
        boolean zN = l2.N(this.f3489b, iJ0);
        if (z11) {
            androidx.collection.c0<androidx.collection.j0<Object>> c0Var = this.f3506s;
            if (c0Var != null && (j0VarC = c0Var.c(i13)) != null) {
                Object[] objArr = j0VarC.f1895a;
                int i16 = j0VarC.f1896b;
                for (int i17 = 0; i17 < i16; i17++) {
                    L0(objArr[i17]);
                }
                c0Var.q(i13);
            }
            l2.Y(this.f3489b, iJ0, i15);
            l2.a0(this.f3489b, iJ0, i14);
            this.f3502o = this.f3505r.i() + (zN ? 1 : i14);
            int iI0 = I0(this.f3489b, i13);
            this.f3509v = iI0;
            int iF0 = iI0 < 0 ? f0() : j0(iI0 + 1);
            int iQ = iF0 >= 0 ? Q(this.f3489b, iF0) : 0;
            this.f3496i = iQ;
            this.f3497j = iQ;
        } else {
            if (!(i11 == i12)) {
                k.s("Expected to be at the end of a group");
            }
            int I = l2.I(this.f3489b, iJ0);
            int iQ2 = l2.Q(this.f3489b, iJ0);
            l2.Y(this.f3489b, iJ0, i15);
            l2.a0(this.f3489b, iJ0, i14);
            int i18 = this.f3503p.i();
            S0();
            this.f3509v = i18;
            int iI1 = I0(this.f3489b, i13);
            int i19 = this.f3505r.i();
            this.f3502o = i19;
            if (iI1 == i18) {
                this.f3502o = i19 + (zN ? 0 : i14 - iQ2);
            } else {
                int i21 = i15 - I;
                int i22 = zN ? 0 : i14 - iQ2;
                if (i21 != 0 || i22 != 0) {
                    while (iI1 != 0 && iI1 != i18 && (i22 != 0 || i21 != 0)) {
                        int iJ1 = j0(iI1);
                        if (i21 != 0) {
                            l2.Y(this.f3489b, iJ1, l2.I(this.f3489b, iJ1) + i21);
                        }
                        if (i22 != 0) {
                            int[] iArr = this.f3489b;
                            l2.a0(iArr, iJ1, l2.Q(iArr, iJ1) + i22);
                        }
                        if (l2.N(this.f3489b, iJ1)) {
                            i22 = 0;
                        }
                        iI1 = I0(this.f3489b, iI1);
                    }
                }
                this.f3502o += i22;
            }
        }
        return i14;
    }

    public final void T0() {
        this.f3504q.j((Y() - this.f3495h) - this.f3508u);
    }

    public final void U() {
        if (!(this.f3501n > 0)) {
            o1.b("Unbalanced begin/end insert");
        }
        int i11 = this.f3501n - 1;
        this.f3501n = i11;
        if (i11 == 0) {
            if (!(this.f3505r.b() == this.f3503p.b())) {
                k.s("startGroup/endGroup mismatch while inserting");
            }
            S0();
        }
    }

    public final Object U0(int i11, int i12, Object obj) {
        int iR = R(d1(i11, i12));
        Object[] objArr = this.f3490c;
        Object obj2 = objArr[iR];
        objArr[iR] = obj;
        return obj2;
    }

    public final void V(int i11) {
        boolean z11 = false;
        if (!(this.f3501n <= 0)) {
            k.s("Cannot call ensureStarted() while inserting");
        }
        int i12 = this.f3509v;
        if (i12 != i11) {
            if (i11 >= i12 && i11 < this.f3508u) {
                z11 = true;
            }
            if (!z11) {
                k.s("Started group at " + i11 + " must be a subgroup of the group at " + i12);
            }
            int i13 = this.f3507t;
            int i14 = this.f3496i;
            int i15 = this.f3497j;
            this.f3507t = i11;
            j1();
            this.f3507t = i13;
            this.f3496i = i14;
            this.f3497j = i15;
        }
    }

    public final Object V0(int i11, Object obj) {
        return U0(this.f3507t, i11, obj);
    }

    public final void W(c cVar) {
        V(cVar.e(this));
    }

    public final void W0(Object obj) {
        if (!(this.f3496i <= this.f3497j)) {
            k.s("Writing to an invalid slot");
        }
        this.f3490c[R(this.f3496i - 1)] = obj;
    }

    public final void X(int i11, int i12, int i13) {
        int iK0 = K0(i11, this.f3494g);
        while (i13 < i12) {
            l2.b0(this.f3489b, j0(i13), iK0);
            int I = l2.I(this.f3489b, j0(i13)) + i13;
            X(i13, I, i13 + 1);
            i13 = I;
        }
    }

    public final Object X0() {
        if (this.f3501n > 0) {
            r0(1, this.f3509v);
        }
        Object[] objArr = this.f3490c;
        int i11 = this.f3496i;
        this.f3496i = i11 + 1;
        return objArr[R(i11)];
    }

    public final int Y() {
        return this.f3489b.length / 5;
    }

    public final int Y0() {
        int iJ0 = j0(this.f3507t);
        int I = this.f3507t + l2.I(this.f3489b, iJ0);
        this.f3507t = I;
        this.f3496i = Q(this.f3489b, j0(I));
        if (l2.N(this.f3489b, iJ0)) {
            return 1;
        }
        return l2.Q(this.f3489b, iJ0);
    }

    public final boolean Z() {
        return this.f3510w;
    }

    public final void Z0() {
        int i11 = this.f3508u;
        this.f3507t = i11;
        this.f3496i = Q(this.f3489b, j0(i11));
    }

    public final boolean a0() {
        return this.f3493f != null;
    }

    public final Object a1(int i11, int i12) {
        int iC1 = c1(this.f3489b, j0(i11));
        int iQ = Q(this.f3489b, j0(i11 + 1));
        int i13 = i12 + iC1;
        if (iC1 > i13 || i13 >= iQ) {
            return i.f3413a.a();
        }
        return this.f3490c[R(i13)];
    }

    public final boolean b0() {
        return this.f3492e != null;
    }

    public final Object b1(c cVar, int i11) {
        return a1(F(cVar), i11);
    }

    public final int c0() {
        return this.f3507t;
    }

    public final int c1(int[] iArr, int i11) {
        return i11 >= Y() ? this.f3490c.length - this.f3499l : O(l2.V(iArr, i11), this.f3499l, this.f3490c.length);
    }

    public final int d0() {
        return this.f3508u;
    }

    public final int d1(int i11, int i12) {
        int iC1 = c1(this.f3489b, j0(i11));
        int i13 = iC1 + i12;
        if (!(i13 >= iC1 && i13 < Q(this.f3489b, j0(i11 + 1)))) {
            k.s("Write to an invalid slot index " + i12 + " for group " + i11);
        }
        return i13;
    }

    public final int e0() {
        return this.f3509v;
    }

    public final int e1(int i11) {
        return Q(this.f3489b, j0(i11 + m0(i11)));
    }

    public final int f0() {
        return Y() - this.f3495h;
    }

    public final int f1(int i11) {
        return Q(this.f3489b, j0(i11 + 1));
    }

    public final int g0() {
        return this.f3490c.length - this.f3499l;
    }

    public final int g1(int i11) {
        return c1(this.f3489b, j0(i11));
    }

    public final j2 h0() {
        return this.f3488a;
    }

    public final l0 h1(int i11) {
        c cVarO1;
        HashMap<c, l0> map = this.f3492e;
        if (map == null || (cVarO1 = o1(i11)) == null) {
            return null;
        }
        return map.get(cVarO1);
    }

    public final Object i0(int i11) {
        int iJ0 = j0(i11);
        return l2.J(this.f3489b, iJ0) ? this.f3490c[H(this.f3489b, iJ0)] : i.f3413a.a();
    }

    public final void i1(int i11, Object obj, Object obj2) {
        l1(i11, obj, false, obj2);
    }

    public final int j0(int i11) {
        return i11 < this.f3494g ? i11 : i11 + this.f3495h;
    }

    public final void j1() {
        if (!(this.f3501n == 0)) {
            k.s("Key must be supplied when inserting");
        }
        i.a aVar = i.f3413a;
        l1(0, aVar.a(), false, aVar.a());
    }

    public final int k0(int i11) {
        return l2.O(this.f3489b, j0(i11));
    }

    public final void k1(int i11, Object obj) {
        l1(i11, obj, false, i.f3413a.a());
    }

    public final Object l0(int i11) {
        int iJ0 = j0(i11);
        if (l2.L(this.f3489b, iJ0)) {
            return this.f3490c[l2.S(this.f3489b, iJ0)];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l1(int i11, Object obj, boolean z11, Object obj2) {
        int I;
        l0 l0VarH1;
        int i12 = this.f3509v;
        boolean z12 = this.f3501n > 0;
        this.f3505r.j(this.f3502o);
        if (z12) {
            int i13 = this.f3507t;
            int iQ = Q(this.f3489b, j0(i13));
            q0(1);
            this.f3496i = iQ;
            this.f3497j = iQ;
            int iJ0 = j0(i13);
            i.a aVar = i.f3413a;
            int i14 = obj != aVar.a() ? 1 : 0;
            int i15 = (z11 || obj2 == aVar.a()) ? 0 : 1;
            int iS = S(iQ, this.f3498k, this.f3499l, this.f3490c.length);
            if (iS >= 0 && this.f3500m < i13) {
                iS = -(((this.f3490c.length - this.f3499l) - iS) + 1);
            }
            l2.M(this.f3489b, iJ0, i11, z11, i14, i15, this.f3509v, iS);
            int i16 = (z11 ? 1 : 0) + i14 + i15;
            if (i16 > 0) {
                r0(i16, i13);
                Object[] objArr = this.f3490c;
                int i17 = this.f3496i;
                if (z11) {
                    objArr[i17] = obj2;
                    i17++;
                }
                if (i14 != 0) {
                    objArr[i17] = obj;
                    i17++;
                }
                if (i15 != 0) {
                    objArr[i17] = obj2;
                    i17++;
                }
                this.f3496i = i17;
            }
            this.f3502o = 0;
            I = i13 + 1;
            this.f3509v = i13;
            this.f3507t = I;
            if (i12 >= 0 && (l0VarH1 = h1(i12)) != null) {
                l0VarH1.i(this, i13);
            }
        } else {
            this.f3503p.j(i12);
            T0();
            int i18 = this.f3507t;
            int iJ1 = j0(i18);
            if (!Intrinsics.b(obj2, i.f3413a.a())) {
                if (z11) {
                    w1(obj2);
                } else {
                    r1(obj2);
                }
            }
            this.f3496i = c1(this.f3489b, iJ1);
            this.f3497j = Q(this.f3489b, j0(this.f3507t + 1));
            this.f3502o = l2.Q(this.f3489b, iJ1);
            this.f3509v = i18;
            this.f3507t = i18 + 1;
            I = i18 + l2.I(this.f3489b, iJ1);
        }
        this.f3508u = I;
    }

    public final int m0(int i11) {
        return l2.I(this.f3489b, j0(i11));
    }

    public final void m1(int i11, Object obj) {
        l1(i11, obj, true, i.f3413a.a());
    }

    public final boolean n0(int i11) {
        return o0(i11, this.f3507t);
    }

    public final void n1(int i11) {
        k.Q(i11 > 0);
        int i12 = this.f3509v;
        int iC1 = c1(this.f3489b, j0(i12));
        int iQ = Q(this.f3489b, j0(i12 + 1)) - i11;
        k.Q(iQ >= iC1);
        Q0(iQ, i11, i12);
        int i13 = this.f3496i;
        if (i13 >= iC1) {
            this.f3496i = i13 - i11;
        }
    }

    public final boolean o0(int i11, int i12) {
        int iC;
        int iY;
        if (i12 == this.f3509v) {
            iY = this.f3508u;
        } else if (i12 <= this.f3503p.h(0) && (iC = this.f3503p.c(i12)) >= 0) {
            iY = (Y() - this.f3495h) - this.f3504q.f(iC);
        } else {
            int iM0 = m0(i12);
            iY = iM0 + i12;
        }
        return i11 > i12 && i11 < iY;
    }

    public final c o1(int i11) {
        if (i11 < 0 || i11 >= f0()) {
            return null;
        }
        return l2.G(this.f3491d, i11, f0());
    }

    public final boolean p0(int i11) {
        int i12 = this.f3509v;
        return (i11 > i12 && i11 < this.f3508u) || (i12 == 0 && i11 == 0);
    }

    public final Object p1(Object obj) {
        if (this.f3501n <= 0 || this.f3496i == this.f3498k) {
            return L0(obj);
        }
        androidx.collection.c0<androidx.collection.j0<Object>> c0Var = this.f3506s;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i11 = 1;
        int i12 = 0;
        if (c0Var == null) {
            c0Var = new androidx.collection.c0<>(i12, i11, defaultConstructorMarker);
        }
        this.f3506s = c0Var;
        int i13 = this.f3509v;
        androidx.collection.j0<Object> j0VarC = c0Var.c(i13);
        if (j0VarC == null) {
            j0VarC = new androidx.collection.j0<>(i12, i11, defaultConstructorMarker);
            c0Var.t(i13, j0VarC);
        }
        j0VarC.e(obj);
        return i.f3413a.a();
    }

    public final void q0(int i11) {
        if (i11 > 0) {
            int i12 = this.f3507t;
            z0(i12);
            int i13 = this.f3494g;
            int i14 = this.f3495h;
            int[] iArr = this.f3489b;
            int length = iArr.length / 5;
            int i15 = length - i14;
            if (i14 < i11) {
                int iMax = Math.max(Math.max(length * 2, i15 + i11), 32);
                int[] iArr2 = new int[iMax * 5];
                int i16 = iMax - i15;
                ArraysKt___ArraysJvmKt.j(iArr, iArr2, 0, 0, i13 * 5);
                ArraysKt___ArraysJvmKt.j(iArr, iArr2, (i13 + i16) * 5, (i14 + i13) * 5, length * 5);
                this.f3489b = iArr2;
                i14 = i16;
            }
            int i17 = this.f3508u;
            if (i17 >= i13) {
                this.f3508u = i17 + i11;
            }
            int i18 = i13 + i11;
            this.f3494g = i18;
            this.f3495h = i14 - i11;
            int iS = S(i15 > 0 ? P(i12 + i11) : 0, this.f3500m >= i13 ? this.f3498k : 0, this.f3499l, this.f3490c.length);
            for (int i19 = i13; i19 < i18; i19++) {
                l2.X(this.f3489b, i19, iS);
            }
            int i21 = this.f3500m;
            if (i21 >= i13) {
                this.f3500m = i21 + i11;
            }
        }
    }

    public final void q1(int i11, int i12) {
        c cVar;
        int iA;
        c cVar2;
        int iA2;
        int i13;
        int iY = Y() - this.f3495h;
        if (i11 >= i12) {
            for (int iP = l2.P(this.f3491d, i12, iY); iP < this.f3491d.size() && (iA = (cVar = this.f3491d.get(iP)).a()) >= 0; iP++) {
                cVar.c(-(iY - iA));
            }
            return;
        }
        for (int iP2 = l2.P(this.f3491d, i11, iY); iP2 < this.f3491d.size() && (iA2 = (cVar2 = this.f3491d.get(iP2)).a()) < 0 && (i13 = iA2 + iY) < i12; iP2++) {
            cVar2.c(i13);
        }
    }

    public final void r0(int i11, int i12) {
        if (i11 > 0) {
            B0(this.f3496i, i12);
            int i13 = this.f3498k;
            int i14 = this.f3499l;
            if (i14 < i11) {
                Object[] objArr = this.f3490c;
                int length = objArr.length;
                int i15 = length - i14;
                int iMax = Math.max(Math.max(length * 2, i15 + i11), 32);
                Object[] objArr2 = new Object[iMax];
                for (int i16 = 0; i16 < iMax; i16++) {
                    objArr2[i16] = null;
                }
                int i17 = iMax - i15;
                int i18 = i14 + i13;
                ArraysKt___ArraysJvmKt.l(objArr, objArr2, 0, 0, i13);
                ArraysKt___ArraysJvmKt.l(objArr, objArr2, i13 + i17, i18, length);
                this.f3490c = objArr2;
                i14 = i17;
            }
            int i19 = this.f3497j;
            if (i19 >= i13) {
                this.f3497j = i19 + i11;
            }
            this.f3498k = i13 + i11;
            this.f3499l = i14 - i11;
        }
    }

    public final void r1(Object obj) {
        int iJ0 = j0(this.f3507t);
        if (!l2.J(this.f3489b, iJ0)) {
            k.s("Updating the data of a group that was not created with a data slot");
        }
        this.f3490c[R(H(this.f3489b, iJ0))] = obj;
    }

    public final boolean s0() {
        int i11 = this.f3507t;
        return i11 < this.f3508u && l2.N(this.f3489b, j0(i11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s1(int i11) {
        if (i11 >= 0) {
            r1 r1Var = this.f3511x;
            if (r1Var == null) {
                r1Var = new r1(null, 1, 0 == true ? 1 : 0);
                this.f3511x = r1Var;
            }
            r1Var.a(i11);
        }
    }

    public final boolean t0(int i11) {
        return l2.N(this.f3489b, j0(i11));
    }

    public final void t1(int i11, r1 r1Var) {
        int iJ0 = j0(i11);
        boolean zJ = J(i11);
        if (l2.D(this.f3489b, iJ0) != zJ) {
            l2.W(this.f3489b, iJ0, zJ);
            int iH0 = H0(i11);
            if (iH0 >= 0) {
                r1Var.a(iH0);
            }
        }
    }

    public String toString() {
        return "SlotWriter(current = " + this.f3507t + " end=" + this.f3508u + " size = " + f0() + " gap=" + this.f3494g + '-' + (this.f3494g + this.f3495h) + ')';
    }

    public final void u0(int i11) {
        int iJ0 = j0(i11);
        if (l2.K(this.f3489b, iJ0)) {
            return;
        }
        l2.Z(this.f3489b, iJ0, true);
        if (l2.D(this.f3489b, iJ0)) {
            return;
        }
        s1(H0(i11));
    }

    public final void u1(int[] iArr, int i11, int i12) {
        l2.X(iArr, i11, S(i12, this.f3498k, this.f3499l, this.f3490c.length));
    }

    public final void v1(c cVar, Object obj) {
        x1(cVar.e(this), obj);
    }

    public final void w0(int i11, int i12, int i13) {
        c cVar;
        int iF;
        int i14 = i13 + i11;
        int iF0 = f0();
        int iP = l2.P(this.f3491d, i11, iF0);
        ArrayList arrayList = new ArrayList();
        if (iP >= 0) {
            while (iP < this.f3491d.size() && (iF = F((cVar = this.f3491d.get(iP)))) >= i11 && iF < i14) {
                arrayList.add(cVar);
                this.f3491d.remove(iP);
            }
        }
        int i15 = i12 - i11;
        int size = arrayList.size();
        for (int i16 = 0; i16 < size; i16++) {
            c cVar2 = (c) arrayList.get(i16);
            int iF2 = F(cVar2) + i15;
            if (iF2 >= this.f3494g) {
                cVar2.c(-(iF0 - iF2));
            } else {
                cVar2.c(iF2);
            }
            this.f3491d.add(l2.P(this.f3491d, iF2, iF0), cVar2);
        }
    }

    public final void w1(Object obj) {
        x1(this.f3507t, obj);
    }

    public final List<c> x0(j2 j2Var, int i11, boolean z11) {
        boolean z12 = false;
        z12 = true;
        k.Q(this.f3501n > 0);
        if (i11 != 0 || this.f3507t != 0 || this.f3488a.w() != 0 || l2.I(j2Var.v(), i11) != j2Var.w()) {
            m2 m2VarE = j2Var.E();
            try {
                return f3486y.b(m2VarE, i11, this, true, true, z11);
            } finally {
                m2VarE.L(z12);
            }
        }
        int[] iArr = this.f3489b;
        Object[] objArr = this.f3490c;
        ArrayList<c> arrayList = this.f3491d;
        HashMap<c, l0> map = this.f3492e;
        androidx.collection.c0<androidx.collection.d0> c0Var = this.f3493f;
        int[] iArrV = j2Var.v();
        int iW = j2Var.w();
        Object[] objArrX = j2Var.x();
        int iY = j2Var.y();
        HashMap<c, l0> mapZ = j2Var.z();
        androidx.collection.c0<androidx.collection.d0> c0VarU = j2Var.u();
        this.f3489b = iArrV;
        this.f3490c = objArrX;
        this.f3491d = j2Var.s();
        this.f3494g = iW;
        this.f3495h = (iArrV.length / 5) - iW;
        this.f3498k = iY;
        this.f3499l = objArrX.length - iY;
        this.f3500m = iW;
        this.f3492e = mapZ;
        this.f3493f = c0VarU;
        j2Var.G(iArr, 0, objArr, 0, arrayList, map, c0Var);
        return this.f3491d;
    }

    public final void x1(int i11, Object obj) {
        int iJ0 = j0(i11);
        int[] iArr = this.f3489b;
        if (!(iJ0 < iArr.length && l2.N(iArr, iJ0))) {
            k.s("Updating the node of a group at " + i11 + " that was not created with as a node group");
        }
        this.f3490c[R(G0(this.f3489b, iJ0))] = obj;
    }

    public final void y0(int i11) {
        if (!(this.f3501n == 0)) {
            k.s("Cannot move a group while inserting");
        }
        if (!(i11 >= 0)) {
            k.s("Parameter offset is out of bounds");
        }
        if (i11 == 0) {
            return;
        }
        int i12 = this.f3507t;
        int i13 = this.f3509v;
        int i14 = this.f3508u;
        int I = i12;
        for (int i15 = i11; i15 > 0; i15--) {
            I += l2.I(this.f3489b, j0(I));
            if (!(I <= i14)) {
                k.s("Parameter offset is out of bounds");
            }
        }
        int I2 = l2.I(this.f3489b, j0(I));
        int iQ = Q(this.f3489b, j0(this.f3507t));
        int iQ2 = Q(this.f3489b, j0(I));
        int i16 = I + I2;
        int iQ3 = Q(this.f3489b, j0(i16));
        int i17 = iQ3 - iQ2;
        r0(i17, Math.max(this.f3507t - 1, 0));
        q0(I2);
        int[] iArr = this.f3489b;
        int iJ0 = j0(i16) * 5;
        ArraysKt___ArraysJvmKt.j(iArr, iArr, j0(i12) * 5, iJ0, (I2 * 5) + iJ0);
        if (i17 > 0) {
            Object[] objArr = this.f3490c;
            ArraysKt___ArraysJvmKt.l(objArr, objArr, iQ, R(iQ2 + i17), R(iQ3 + i17));
        }
        int i18 = iQ2 + i17;
        int i19 = i18 - iQ;
        int i21 = this.f3498k;
        int i22 = this.f3499l;
        int length = this.f3490c.length;
        int i23 = this.f3500m;
        int i24 = i12 + I2;
        int i25 = i12;
        while (i25 < i24) {
            int iJ1 = j0(i25);
            int i26 = i21;
            int i27 = i19;
            u1(iArr, iJ1, S(Q(iArr, iJ1) - i19, i23 < iJ1 ? 0 : i26, i22, length));
            i25++;
            i21 = i26;
            i19 = i27;
        }
        w0(i16, i12, I2);
        if (!(!P0(i16, I2))) {
            k.s("Unexpectedly removed anchors");
        }
        X(i13, this.f3508u, i12);
        if (i17 > 0) {
            Q0(i18, i17, i16 - 1);
        }
    }

    public final void y1() {
        this.f3492e = this.f3488a.z();
        this.f3493f = this.f3488a.u();
    }

    public final void z0(int i11) {
        int i12 = this.f3495h;
        int i13 = this.f3494g;
        if (i13 != i11) {
            if (!this.f3491d.isEmpty()) {
                q1(i13, i11);
            }
            if (i12 > 0) {
                int[] iArr = this.f3489b;
                int i14 = i11 * 5;
                int i15 = i12 * 5;
                int i16 = i13 * 5;
                if (i11 < i13) {
                    ArraysKt___ArraysJvmKt.j(iArr, iArr, i15 + i14, i14, i16);
                } else {
                    ArraysKt___ArraysJvmKt.j(iArr, iArr, i16, i16 + i15, i14 + i15);
                }
            }
            if (i11 < i13) {
                i13 = i11 + i12;
            }
            int iY = Y();
            k.Q(i13 < iY);
            while (i13 < iY) {
                int iT = l2.T(this.f3489b, i13);
                int iK0 = K0(J0(iT), i11);
                if (iK0 != iT) {
                    l2.b0(this.f3489b, i13, iK0);
                }
                i13++;
                if (i13 == i11) {
                    i13 += i12;
                }
            }
        }
        this.f3494g = i11;
    }
}
