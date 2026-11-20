package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f3463a = new l1("provider");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f3464b = new l1("provider");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f3465c = new l1("compositionLocalMap");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f3466d = new l1("providerValues");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f3467e = new l1("providers");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f3468f = new l1("reference");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Comparator<o0> f3469g = new Comparator() { // from class: androidx.compose.runtime.j
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return k.b((o0) obj, (o0) obj2);
        }
    };

    public static final Object A() {
        return f3465c;
    }

    public static final Object B() {
        return f3463a;
    }

    public static final Object C(q0 q0Var) {
        return q0Var.d() != null ? new p0(Integer.valueOf(q0Var.a()), q0Var.d()) : Integer.valueOf(q0Var.a());
    }

    public static final Object D() {
        return f3464b;
    }

    public static final Object E() {
        return f3467e;
    }

    public static final Object F() {
        return f3468f;
    }

    public static final void G(List<o0> list, int i11, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int iY = y(list, i11);
        if (iY < 0) {
            int i12 = -(iY + 1);
            if (!(obj instanceof z)) {
                obj = null;
            }
            list.add(i12, new o0(recomposeScopeImpl, i11, obj));
            return;
        }
        o0 o0Var = list.get(iY);
        if (!(obj instanceof z)) {
            o0Var.e(null);
            return;
        }
        Object objA = o0Var.a();
        if (objA == null) {
            o0Var.e(obj);
        } else if (objA instanceof MutableScatterSet) {
            ((MutableScatterSet) objA).h(obj);
        } else {
            o0Var.e(androidx.collection.u0.b(objA, obj));
        }
    }

    public static final boolean H(i2 i2Var) {
        return i2Var.k() > i2Var.u() + 1;
    }

    public static final boolean I(m2 m2Var) {
        return m2Var.c0() > m2Var.e0() + 1;
    }

    public static final boolean J() {
        return false;
    }

    public static final <K, V> androidx.collection.l0<K, Object> K(int i11) {
        return h1.b(new androidx.collection.l0(i11));
    }

    public static final int L(i2 i2Var, int i11, int i12, int i13) {
        if (i11 == i12) {
            return i11;
        }
        if (i11 == i13 || i12 == i13) {
            return i13;
        }
        if (i2Var.P(i11) == i12) {
            return i12;
        }
        if (i2Var.P(i12) == i11) {
            return i11;
        }
        if (i2Var.P(i11) == i2Var.P(i12)) {
            return i2Var.P(i11);
        }
        int iV = v(i2Var, i11, i13);
        int iV2 = v(i2Var, i12, i13);
        int i14 = iV - iV2;
        for (int i15 = 0; i15 < i14; i15++) {
            i11 = i2Var.P(i11);
        }
        int i16 = iV2 - iV;
        for (int i17 = 0; i17 < i16; i17++) {
            i12 = i2Var.P(i12);
        }
        while (i11 != i12) {
            i11 = i2Var.P(i11);
            i12 = i2Var.P(i12);
        }
        return i11;
    }

    public static final void M(m2 m2Var, a2 a2Var) {
        int iG0;
        int iQ = m2Var.Q(m2Var.f3489b, m2Var.j0(m2Var.c0() + m2Var.m0(m2Var.c0())));
        for (int iQ2 = m2Var.Q(m2Var.f3489b, m2Var.j0(m2Var.c0())); iQ2 < iQ; iQ2++) {
            Object obj = m2Var.f3490c[m2Var.R(iQ2)];
            int iF = -1;
            if (obj instanceof h) {
                a2Var.b((h) obj, m2Var.g0() - iQ2, -1, -1);
            }
            if (obj instanceof c2) {
                int iG1 = m2Var.g0() - iQ2;
                c2 c2Var = (c2) obj;
                c cVarA = c2Var.a();
                if (cVarA == null || !cVarA.b()) {
                    iG0 = -1;
                } else {
                    iF = m2Var.F(cVarA);
                    iG0 = m2Var.g0() - m2Var.e1(iF);
                }
                a2Var.e(c2Var.b(), iG1, iF, iG0);
            }
            if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).x();
            }
        }
        m2Var.O0();
    }

    public static final void N(m2 m2Var, int i11, int i12, Object obj) {
        if (obj == m2Var.U0(i11, i12, i.f3413a.a())) {
            return;
        }
        s("Slot table is out of sync");
    }

    public static final o0 O(List<o0> list, int i11) {
        int iY = y(list, i11);
        if (iY >= 0) {
            return list.remove(iY);
        }
        return null;
    }

    public static final void P(List<o0> list, int i11, int i12) {
        int iX = x(list, i11);
        while (iX < list.size() && list.get(iX).b() < i12) {
            list.remove(iX);
        }
    }

    public static final void Q(boolean z11) {
        if (z11) {
            return;
        }
        s("Check failed");
    }

    public static final void R() {
    }

    public static final void S(int i11, int i12, int i13, String str) {
    }

    public static final int b(o0 o0Var, o0 o0Var2) {
        return Intrinsics.i(o0Var.b(), o0Var2.b());
    }

    public static final boolean o(int i11) {
        return i11 != 0;
    }

    public static final int p(boolean z11) {
        return z11 ? 1 : 0;
    }

    public static final List<Object> q(j2 j2Var, c cVar) {
        ArrayList arrayList = new ArrayList();
        i2 i2VarD = j2Var.D();
        try {
            r(i2VarD, arrayList, j2Var.e(cVar));
            Unit unit = Unit.f68710a;
            return arrayList;
        } finally {
            i2VarD.d();
        }
    }

    public static final void r(i2 i2Var, List<Object> list, int i11) {
        if (i2Var.J(i11)) {
            list.add(i2Var.L(i11));
            return;
        }
        int iE = i11 + 1;
        int iE2 = i11 + i2Var.E(i11);
        while (iE < iE2) {
            r(i2Var, list, iE);
            iE += i2Var.E(iE);
        }
    }

    public static final void s(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final Void t(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final void u(m2 m2Var, a2 a2Var) {
        int iF;
        int iG0;
        int iC0 = m2Var.c0();
        int iD0 = m2Var.d0();
        while (iC0 < iD0) {
            Object objD0 = m2Var.D0(iC0);
            if (objD0 instanceof h) {
                a2Var.d((h) objD0, m2Var.g0() - m2Var.g1(iC0), -1, -1);
            }
            int iC1 = m2Var.c1(m2Var.f3489b, m2Var.j0(iC0));
            int i11 = iC0 + 1;
            int iQ = m2Var.Q(m2Var.f3489b, m2Var.j0(i11));
            for (int i12 = iC1; i12 < iQ; i12++) {
                int i13 = i12 - iC1;
                Object obj = m2Var.f3490c[m2Var.R(i12)];
                if (obj instanceof c2) {
                    c2 c2Var = (c2) obj;
                    b2 b2VarB = c2Var.b();
                    if (!(b2VarB instanceof e2)) {
                        N(m2Var, iC0, i13, obj);
                        int iG1 = m2Var.g0() - i13;
                        c cVarA = c2Var.a();
                        if (cVarA == null || !cVarA.b()) {
                            iF = -1;
                            iG0 = -1;
                        } else {
                            iF = m2Var.F(cVarA);
                            iG0 = m2Var.g0() - m2Var.e1(iF);
                        }
                        a2Var.e(b2VarB, iG1, iF, iG0);
                    }
                } else if (obj instanceof RecomposeScopeImpl) {
                    N(m2Var, iC0, i13, obj);
                    ((RecomposeScopeImpl) obj).x();
                }
            }
            iC0 = i11;
        }
    }

    public static final int v(i2 i2Var, int i11, int i12) {
        int i13 = 0;
        while (i11 > 0 && i11 != i12) {
            i11 = i2Var.P(i11);
            i13++;
        }
        return i13;
    }

    public static final List<o0> w(List<o0> list, int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        for (int iX = x(list, i11); iX < list.size(); iX++) {
            o0 o0Var = list.get(iX);
            if (o0Var.b() >= i12) {
                break;
            }
            arrayList.add(o0Var);
        }
        return arrayList;
    }

    public static final int x(List<o0> list, int i11) {
        int iY = y(list, i11);
        return iY < 0 ? -(iY + 1) : iY;
    }

    public static final int y(List<o0> list, int i11) {
        int size = list.size() - 1;
        int i12 = 0;
        while (i12 <= size) {
            int i13 = (i12 + size) >>> 1;
            int i14 = Intrinsics.i(list.get(i13).b(), i11);
            if (i14 < 0) {
                i12 = i13 + 1;
            } else {
                if (i14 <= 0) {
                    return i13;
                }
                size = i13 - 1;
            }
        }
        return -(i12 + 1);
    }

    public static final o0 z(List<o0> list, int i11, int i12) {
        int iX = x(list, i11);
        if (iX >= list.size()) {
            return null;
        }
        o0 o0Var = list.get(iX);
        if (o0Var.b() < i12) {
            return o0Var;
        }
        return null;
    }
}
