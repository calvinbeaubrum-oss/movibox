package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.core.view.InputDeviceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends v2.c {
    public int Y0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public int f6637c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f6638d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public int f6639e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public int f6640f1;
    public w2.b W0 = new w2.b(this);
    public w2.e X0 = new w2.e(this);
    public w2.b.InterfaceC0880b Z0 = null;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public boolean f6635a1 = false;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public androidx.constraintlayout.core.d f6636b1 = new androidx.constraintlayout.core.d();

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f6641g1 = 0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f6642h1 = 0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public c[] f6643i1 = new c[4];

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public c[] f6644j1 = new c[4];

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f6645k1 = false;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public boolean f6646l1 = false;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public boolean f6647m1 = false;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public int f6648n1 = 0;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public int f6649o1 = 0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f6650p1 = InputDeviceCompat.SOURCE_KEYBOARD;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public boolean f6651q1 = false;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public boolean f6652r1 = false;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public boolean f6653s1 = false;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public int f6654t1 = 0;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f6655u1 = null;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f6656v1 = null;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f6657w1 = null;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f6658x1 = null;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public HashSet<ConstraintWidget> f6659y1 = new HashSet<>();

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public w2.b.a f6660z1 = new w2.b.a();

    public static boolean X1(int i11, ConstraintWidget constraintWidget, w2.b.InterfaceC0880b interfaceC0880b, w2.b.a aVar, int i12) {
        int i13;
        int i14;
        if (interfaceC0880b == null) {
            return false;
        }
        if (constraintWidget.X() == 8 || (constraintWidget instanceof f) || (constraintWidget instanceof a)) {
            aVar.f79157e = 0;
            aVar.f79158f = 0;
            return false;
        }
        aVar.f79153a = constraintWidget.C();
        aVar.f79154b = constraintWidget.V();
        aVar.f79155c = constraintWidget.Y();
        aVar.f79156d = constraintWidget.z();
        aVar.f79161i = false;
        aVar.f79162j = i12;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f79153a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z11 = dimensionBehaviour == dimensionBehaviour2;
        boolean z12 = aVar.f79154b == dimensionBehaviour2;
        boolean z13 = z11 && constraintWidget.f6540f0 > 0.0f;
        boolean z14 = z12 && constraintWidget.f6540f0 > 0.0f;
        if (z11 && constraintWidget.c0(0) && constraintWidget.f6573w == 0 && !z13) {
            aVar.f79153a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z12 && constraintWidget.f6575x == 0) {
                aVar.f79153a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z11 = false;
        }
        if (z12 && constraintWidget.c0(1) && constraintWidget.f6575x == 0 && !z14) {
            aVar.f79154b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z11 && constraintWidget.f6573w == 0) {
                aVar.f79154b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z12 = false;
        }
        if (constraintWidget.p0()) {
            aVar.f79153a = ConstraintWidget.DimensionBehaviour.FIXED;
            z11 = false;
        }
        if (constraintWidget.q0()) {
            aVar.f79154b = ConstraintWidget.DimensionBehaviour.FIXED;
            z12 = false;
        }
        if (z13) {
            if (constraintWidget.f6577y[0] == 4) {
                aVar.f79153a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z12) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = aVar.f79154b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i14 = aVar.f79156d;
                } else {
                    aVar.f79153a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0880b.b(constraintWidget, aVar);
                    i14 = aVar.f79158f;
                }
                aVar.f79153a = dimensionBehaviour4;
                aVar.f79155c = (int) (constraintWidget.x() * i14);
            }
        }
        if (z14) {
            if (constraintWidget.f6577y[1] == 4) {
                aVar.f79154b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z11) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = aVar.f79153a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i13 = aVar.f79155c;
                } else {
                    aVar.f79154b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0880b.b(constraintWidget, aVar);
                    i13 = aVar.f79157e;
                }
                aVar.f79154b = dimensionBehaviour6;
                if (constraintWidget.y() == -1) {
                    aVar.f79156d = (int) (i13 / constraintWidget.x());
                } else {
                    aVar.f79156d = (int) (constraintWidget.x() * i13);
                }
            }
        }
        interfaceC0880b.b(constraintWidget, aVar);
        constraintWidget.o1(aVar.f79157e);
        constraintWidget.P0(aVar.f79158f);
        constraintWidget.O0(aVar.f79160h);
        constraintWidget.E0(aVar.f79159g);
        aVar.f79162j = w2.b.a.f79150k;
        return aVar.f79161i;
    }

    public boolean A1(androidx.constraintlayout.core.d dVar) {
        boolean zY1 = Y1(64);
        g(dVar, zY1);
        int size = this.V0.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = this.V0.get(i11);
            constraintWidget.W0(0, false);
            constraintWidget.W0(1, false);
            if (constraintWidget instanceof a) {
                z11 = true;
            }
        }
        if (z11) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget2 = this.V0.get(i12);
                if (constraintWidget2 instanceof a) {
                    ((a) constraintWidget2).C1();
                }
            }
        }
        this.f6659y1.clear();
        for (int i13 = 0; i13 < size; i13++) {
            ConstraintWidget constraintWidget3 = this.V0.get(i13);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof i) {
                    this.f6659y1.add(constraintWidget3);
                } else {
                    constraintWidget3.g(dVar, zY1);
                }
            }
        }
        while (this.f6659y1.size() > 0) {
            int size2 = this.f6659y1.size();
            Iterator<ConstraintWidget> it = this.f6659y1.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar.z1(this.f6659y1)) {
                    iVar.g(dVar, zY1);
                    this.f6659y1.remove(iVar);
                    break;
                }
            }
            if (size2 == this.f6659y1.size()) {
                Iterator<ConstraintWidget> it2 = this.f6659y1.iterator();
                while (it2.hasNext()) {
                    it2.next().g(dVar, zY1);
                }
                this.f6659y1.clear();
            }
        }
        if (androidx.constraintlayout.core.d.f6346r) {
            HashSet<ConstraintWidget> hashSet = new HashSet<>();
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget4 = this.V0.get(i14);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            e(this, dVar, hashSet, C() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            for (ConstraintWidget constraintWidget5 : hashSet) {
                g.a(this, dVar, constraintWidget5);
                constraintWidget5.g(dVar, zY1);
            }
        } else {
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget6 = this.V0.get(i15);
                if (constraintWidget6 instanceof d) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.f6532b0;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.T0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.k1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.g(dVar, zY1);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.T0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.k1(dimensionBehaviour2);
                    }
                } else {
                    g.a(this, dVar, constraintWidget6);
                    if (!constraintWidget6.f()) {
                        constraintWidget6.g(dVar, zY1);
                    }
                }
            }
        }
        if (this.f6641g1 > 0) {
            b.b(this, dVar, null, 0);
        }
        if (this.f6642h1 > 0) {
            b.b(this, dVar, null, 1);
        }
        return true;
    }

    public final void B1(ConstraintWidget constraintWidget) {
        int i11 = this.f6641g1 + 1;
        c[] cVarArr = this.f6644j1;
        if (i11 >= cVarArr.length) {
            this.f6644j1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f6644j1[this.f6641g1] = new c(constraintWidget, 0, U1());
        this.f6641g1++;
    }

    public void C1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f6658x1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f6658x1.get().e()) {
            this.f6658x1 = new WeakReference<>(constraintAnchor);
        }
    }

    public void D1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f6656v1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f6656v1.get().e()) {
            this.f6656v1 = new WeakReference<>(constraintAnchor);
        }
    }

    public final void E1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f6636b1.h(solverVariable, this.f6636b1.q(constraintAnchor), 0, 5);
    }

    public final void F1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f6636b1.h(this.f6636b1.q(constraintAnchor), solverVariable, 0, 5);
    }

    public final void G1(ConstraintWidget constraintWidget) {
        int i11 = this.f6642h1 + 1;
        c[] cVarArr = this.f6643i1;
        if (i11 >= cVarArr.length) {
            this.f6643i1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f6643i1[this.f6642h1] = new c(constraintWidget, 1, U1());
        this.f6642h1++;
    }

    public void H1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f6657w1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f6657w1.get().e()) {
            this.f6657w1 = new WeakReference<>(constraintAnchor);
        }
    }

    public void I1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f6655u1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f6655u1.get().e()) {
            this.f6655u1 = new WeakReference<>(constraintAnchor);
        }
    }

    public boolean J1(boolean z11) {
        return this.X0.f(z11);
    }

    public boolean K1(boolean z11) {
        return this.X0.g(z11);
    }

    public boolean L1(boolean z11, int i11) {
        return this.X0.h(z11, i11);
    }

    public void M1(androidx.constraintlayout.core.e eVar) {
        this.f6636b1.v(eVar);
    }

    public w2.b.InterfaceC0880b N1() {
        return this.Z0;
    }

    public int O1() {
        return this.f6650p1;
    }

    public androidx.constraintlayout.core.d P1() {
        return this.f6636b1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void Q(StringBuilder sb2) {
        sb2.append(this.f6557o + ":{\n");
        sb2.append("  actualWidth:" + this.f6536d0);
        sb2.append("\n");
        sb2.append("  actualHeight:" + this.f6538e0);
        sb2.append("\n");
        Iterator<ConstraintWidget> it = v1().iterator();
        while (it.hasNext()) {
            it.next().Q(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }

    public boolean Q1() {
        return false;
    }

    public void R1() {
        this.X0.j();
    }

    public void S1() {
        this.X0.k();
    }

    public boolean T1() {
        return this.f6653s1;
    }

    public boolean U1() {
        return this.f6635a1;
    }

    public boolean V1() {
        return this.f6652r1;
    }

    public long W1(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        this.f6637c1 = i18;
        this.f6638d1 = i19;
        return this.W0.d(this, i11, i18, i19, i12, i13, i14, i15, i16, i17);
    }

    public boolean Y1(int i11) {
        return (this.f6650p1 & i11) == i11;
    }

    public final void Z1() {
        this.f6641g1 = 0;
        this.f6642h1 = 0;
    }

    public void a2(w2.b.InterfaceC0880b interfaceC0880b) {
        this.Z0 = interfaceC0880b;
        this.X0.n(interfaceC0880b);
    }

    public void b2(int i11) {
        this.f6650p1 = i11;
        androidx.constraintlayout.core.d.f6346r = Y1(512);
    }

    public void c2(int i11) {
        this.Y0 = i11;
    }

    public void d2(boolean z11) {
        this.f6635a1 = z11;
    }

    public boolean e2(androidx.constraintlayout.core.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zY1 = Y1(64);
        u1(dVar, zY1);
        int size = this.V0.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = this.V0.get(i11);
            constraintWidget.u1(dVar, zY1);
            if (constraintWidget.e0()) {
                z11 = true;
            }
        }
        return z11;
    }

    public void f2() {
        this.W0.e(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void t1(boolean z11, boolean z12) {
        super.t1(z11, z12);
        int size = this.V0.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.V0.get(i11).t1(z11, z12);
        }
    }

    @Override // v2.c, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void v0() {
        this.f6636b1.E();
        this.f6637c1 = 0;
        this.f6639e1 = 0;
        this.f6638d1 = 0;
        this.f6640f1 = 0;
        this.f6651q1 = false;
        super.v0();
    }

    /* JADX WARN: Code duplicated, block: B:151:0x0307 A[PHI: r2 r16
  0x0307: PHI (r2v14 boolean) = (r2v13 boolean), (r2v18 boolean), (r2v18 boolean), (r2v18 boolean) binds: [B:138:0x02c8, B:146:0x02ed, B:147:0x02ef, B:149:0x02f5] A[DONT_GENERATE, DONT_INLINE]
  0x0307: PHI (r16v4 boolean) = (r16v3 boolean), (r16v5 boolean), (r16v5 boolean), (r16v5 boolean) binds: [B:138:0x02c8, B:146:0x02ed, B:147:0x02ef, B:149:0x02f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // v2.c
    public void w1() {
        int i11;
        int i12;
        boolean z11;
        boolean zE2;
        boolean z12;
        ?? r11;
        boolean z13;
        boolean z14;
        int i13;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        this.f6544h0 = 0;
        this.f6546i0 = 0;
        this.f6652r1 = false;
        this.f6653s1 = false;
        int size = this.V0.size();
        int iMax = Math.max(0, Y());
        int iMax2 = Math.max(0, z());
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.f6532b0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[0];
        if (this.Y0 == 0 && g.b(this.f6650p1, 1)) {
            w2.f.h(this, N1());
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget = this.V0.get(i14);
                if (constraintWidget.o0() && !(constraintWidget instanceof f) && !(constraintWidget instanceof a) && !(constraintWidget instanceof i) && !constraintWidget.n0()) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviourW = constraintWidget.w(0);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = constraintWidget.w(1);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviourW != dimensionBehaviour4 || constraintWidget.f6573w == 1 || dimensionBehaviourW2 != dimensionBehaviour4 || constraintWidget.f6575x == 1) {
                        X1(0, constraintWidget, this.Z0, new w2.b.a(), w2.b.a.f79150k);
                    }
                }
            }
        }
        if (size <= 2 || !((dimensionBehaviour3 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour2 == dimensionBehaviour) && g.b(this.f6650p1, 1024) && w2.g.c(this, N1()))) {
            i11 = iMax2;
            i12 = iMax;
            z11 = false;
        } else {
            if (dimensionBehaviour3 == dimensionBehaviour) {
                if (iMax >= Y() || iMax <= 0) {
                    iMax = Y();
                } else {
                    o1(iMax);
                    this.f6652r1 = true;
                }
            }
            if (dimensionBehaviour2 == dimensionBehaviour) {
                if (iMax2 >= z() || iMax2 <= 0) {
                    iMax2 = z();
                } else {
                    P0(iMax2);
                    this.f6653s1 = true;
                }
            }
            i11 = iMax2;
            i12 = iMax;
            z11 = true;
        }
        boolean z15 = Y1(64) || Y1(128);
        androidx.constraintlayout.core.d dVar = this.f6636b1;
        dVar.f6361h = false;
        dVar.f6362i = false;
        if (this.f6650p1 != 0 && z15) {
            dVar.f6362i = true;
        }
        ArrayList<ConstraintWidget> arrayList = this.V0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z16 = dimensionBehaviourC == dimensionBehaviour5 || V() == dimensionBehaviour5;
        Z1();
        for (int i15 = 0; i15 < size; i15++) {
            ConstraintWidget constraintWidget2 = this.V0.get(i15);
            if (constraintWidget2 instanceof v2.c) {
                ((v2.c) constraintWidget2).w1();
            }
        }
        boolean zY1 = Y1(64);
        boolean z17 = z11;
        int i16 = 0;
        boolean zA1 = true;
        while (zA1) {
            int i17 = i16 + 1;
            try {
                this.f6636b1.E();
                Z1();
                o(this.f6636b1);
                for (int i18 = 0; i18 < size; i18++) {
                    this.V0.get(i18).o(this.f6636b1);
                }
                zA1 = A1(this.f6636b1);
                WeakReference<ConstraintAnchor> weakReference = this.f6655u1;
                if (weakReference != null && weakReference.get() != null) {
                    F1(this.f6655u1.get(), this.f6636b1.q(this.R));
                    this.f6655u1 = null;
                }
                WeakReference<ConstraintAnchor> weakReference2 = this.f6657w1;
                if (weakReference2 != null && weakReference2.get() != null) {
                    E1(this.f6657w1.get(), this.f6636b1.q(this.T));
                    this.f6657w1 = null;
                }
                WeakReference<ConstraintAnchor> weakReference3 = this.f6656v1;
                if (weakReference3 != null && weakReference3.get() != null) {
                    F1(this.f6656v1.get(), this.f6636b1.q(this.Q));
                    this.f6656v1 = null;
                }
                WeakReference<ConstraintAnchor> weakReference4 = this.f6658x1;
                if (weakReference4 != null && weakReference4.get() != null) {
                    E1(this.f6658x1.get(), this.f6636b1.q(this.S));
                    this.f6658x1 = null;
                }
                if (zA1) {
                    this.f6636b1.A();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                System.out.println("EXCEPTION : " + e11);
            }
            if (zA1) {
                zE2 = e2(this.f6636b1, g.f6699a);
            } else {
                u1(this.f6636b1, zY1);
                for (int i19 = 0; i19 < size; i19++) {
                    this.V0.get(i19).u1(this.f6636b1, zY1);
                }
                zE2 = false;
            }
            if (z16 && i17 < 8 && g.f6699a[2]) {
                int i21 = 0;
                int iMax3 = 0;
                int iMax4 = 0;
                while (i21 < size) {
                    ConstraintWidget constraintWidget3 = this.V0.get(i21);
                    iMax4 = Math.max(iMax4, constraintWidget3.f6544h0 + constraintWidget3.Y());
                    iMax3 = Math.max(iMax3, constraintWidget3.f6546i0 + constraintWidget3.z());
                    i21++;
                    zE2 = zE2;
                }
                z12 = zE2;
                int iMax5 = Math.max(this.f6558o0, iMax4);
                int iMax6 = Math.max(this.f6560p0, iMax3);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour3 == dimensionBehaviour6 && Y() < iMax5) {
                    o1(iMax5);
                    this.f6532b0[0] = dimensionBehaviour6;
                    z17 = true;
                    z12 = true;
                }
                if (dimensionBehaviour2 == dimensionBehaviour6 && z() < iMax6) {
                    P0(iMax6);
                    this.f6532b0[1] = dimensionBehaviour6;
                    z17 = true;
                    z12 = true;
                }
            } else {
                z12 = zE2;
            }
            int iMax7 = Math.max(this.f6558o0, Y());
            if (iMax7 > Y()) {
                o1(iMax7);
                this.f6532b0[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                z17 = true;
                z12 = true;
            }
            int iMax8 = Math.max(this.f6560p0, z());
            if (iMax8 > z()) {
                P0(iMax8);
                r11 = 1;
                this.f6532b0[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                z13 = true;
                z12 = true;
            } else {
                r11 = 1;
                z13 = z17;
            }
            if (z13) {
                z17 = z13;
                z14 = z12;
                i13 = 8;
            } else {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = this.f6532b0[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour7 == dimensionBehaviour8 && i12 > 0 && Y() > i12) {
                    this.f6652r1 = r11;
                    this.f6532b0[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    o1(i12);
                    z13 = true;
                    z12 = true;
                }
                if (this.f6532b0[r11] != dimensionBehaviour8 || i11 <= 0 || z() <= i11) {
                    z17 = z13;
                    z14 = z12;
                    i13 = 8;
                } else {
                    this.f6653s1 = r11;
                    this.f6532b0[r11] = ConstraintWidget.DimensionBehaviour.FIXED;
                    P0(i11);
                    i13 = 8;
                    z14 = true;
                    z17 = true;
                }
            }
            zA1 = i17 > i13 ? false : z14;
            i16 = i17;
        }
        this.V0 = arrayList;
        if (z17) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.f6532b0;
            dimensionBehaviourArr2[0] = dimensionBehaviour3;
            dimensionBehaviourArr2[1] = dimensionBehaviour2;
        }
        z0(this.f6636b1.w());
    }

    public void z1(ConstraintWidget constraintWidget, int i11) {
        if (i11 == 0) {
            B1(constraintWidget);
        } else if (i11 == 1) {
            G1(constraintWidget);
        }
    }
}
