package androidx.constraintlayout.core;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f6346r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f6347s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f6348t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f6349u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f6350v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f6351w = 1000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static long f6352x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f6353y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f6357d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.constraintlayout.core.b[] f6360g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f6367n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f6370q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6354a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6355b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, SolverVariable> f6356c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6358e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6359f = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6361h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6362i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean[] f6363j = new boolean[32];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6364k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6365l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6366m = 32;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SolverVariable[] f6368o = new SolverVariable[f6351w];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6369p = 0;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(a aVar);

        SolverVariable b(d dVar, boolean[] zArr);

        void c(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        boolean isEmpty();
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends androidx.constraintlayout.core.b {
        public b(c cVar) {
            this.f6340e = new h(this, cVar);
        }
    }

    public d() {
        this.f6360g = null;
        this.f6360g = new androidx.constraintlayout.core.b[32];
        D();
        c cVar = new c();
        this.f6367n = cVar;
        this.f6357d = new PriorityGoalRow(cVar);
        if (f6350v) {
            this.f6370q = new b(cVar);
        } else {
            this.f6370q = new androidx.constraintlayout.core.b(cVar);
        }
    }

    public static androidx.constraintlayout.core.b s(d dVar, SolverVariable solverVariable, SolverVariable solverVariable2, float f11) {
        return dVar.r().j(solverVariable, solverVariable2, f11);
    }

    public static e x() {
        return null;
    }

    public void A() throws Exception {
        if (this.f6357d.isEmpty()) {
            n();
            return;
        }
        if (!this.f6361h && !this.f6362i) {
            B(this.f6357d);
            return;
        }
        for (int i11 = 0; i11 < this.f6365l; i11++) {
            if (!this.f6360g[i11].f6341f) {
                B(this.f6357d);
                return;
            }
        }
        n();
    }

    public void B(a aVar) throws Exception {
        u(aVar);
        C(aVar, false);
        n();
    }

    public final int C(a aVar, boolean z11) {
        for (int i11 = 0; i11 < this.f6364k; i11++) {
            this.f6363j[i11] = false;
        }
        boolean z12 = false;
        int i12 = 0;
        while (!z12) {
            i12++;
            if (i12 >= this.f6364k * 2) {
                return i12;
            }
            if (aVar.getKey() != null) {
                this.f6363j[aVar.getKey().f6309c] = true;
            }
            SolverVariable solverVariableB = aVar.b(this, this.f6363j);
            if (solverVariableB != null) {
                boolean[] zArr = this.f6363j;
                int i13 = solverVariableB.f6309c;
                if (zArr[i13]) {
                    return i12;
                }
                zArr[i13] = true;
            }
            if (solverVariableB != null) {
                float f11 = Float.MAX_VALUE;
                int i14 = -1;
                for (int i15 = 0; i15 < this.f6365l; i15++) {
                    androidx.constraintlayout.core.b bVar = this.f6360g[i15];
                    if (bVar.f6336a.f6316k != SolverVariable.Type.UNRESTRICTED && !bVar.f6341f && bVar.t(solverVariableB)) {
                        float fI = bVar.f6340e.i(solverVariableB);
                        if (fI < 0.0f) {
                            float f12 = (-bVar.f6337b) / fI;
                            if (f12 < f11) {
                                i14 = i15;
                                f11 = f12;
                            }
                        }
                    }
                }
                if (i14 > -1) {
                    androidx.constraintlayout.core.b bVar2 = this.f6360g[i14];
                    bVar2.f6336a.f6310d = -1;
                    bVar2.x(solverVariableB);
                    SolverVariable solverVariable = bVar2.f6336a;
                    solverVariable.f6310d = i14;
                    solverVariable.j(this, bVar2);
                }
            } else {
                z12 = true;
            }
        }
        return i12;
    }

    public final void D() {
        int i11 = 0;
        if (f6350v) {
            while (i11 < this.f6365l) {
                androidx.constraintlayout.core.b bVar = this.f6360g[i11];
                if (bVar != null) {
                    this.f6367n.f6342a.release(bVar);
                }
                this.f6360g[i11] = null;
                i11++;
            }
            return;
        }
        while (i11 < this.f6365l) {
            androidx.constraintlayout.core.b bVar2 = this.f6360g[i11];
            if (bVar2 != null) {
                this.f6367n.f6343b.release(bVar2);
            }
            this.f6360g[i11] = null;
            i11++;
        }
    }

    public void E() {
        c cVar;
        int i11 = 0;
        while (true) {
            cVar = this.f6367n;
            SolverVariable[] solverVariableArr = cVar.f6345d;
            if (i11 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i11];
            if (solverVariable != null) {
                solverVariable.e();
            }
            i11++;
        }
        cVar.f6344c.a(this.f6368o, this.f6369p);
        this.f6369p = 0;
        Arrays.fill(this.f6367n.f6345d, (Object) null);
        HashMap<String, SolverVariable> map = this.f6356c;
        if (map != null) {
            map.clear();
        }
        this.f6355b = 0;
        this.f6357d.clear();
        this.f6364k = 1;
        for (int i12 = 0; i12 < this.f6365l; i12++) {
            androidx.constraintlayout.core.b bVar = this.f6360g[i12];
            if (bVar != null) {
                bVar.f6338c = false;
            }
        }
        D();
        this.f6365l = 0;
        if (f6350v) {
            this.f6370q = new b(this.f6367n);
        } else {
            this.f6370q = new androidx.constraintlayout.core.b(this.f6367n);
        }
    }

    public final SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable solverVariableAcquire = this.f6367n.f6344c.acquire();
        if (solverVariableAcquire == null) {
            solverVariableAcquire = new SolverVariable(type, str);
            solverVariableAcquire.i(type, str);
        } else {
            solverVariableAcquire.e();
            solverVariableAcquire.i(type, str);
        }
        int i11 = this.f6369p;
        int i12 = f6351w;
        if (i11 >= i12) {
            int i13 = i12 * 2;
            f6351w = i13;
            this.f6368o = (SolverVariable[]) Arrays.copyOf(this.f6368o, i13);
        }
        SolverVariable[] solverVariableArr = this.f6368o;
        int i14 = this.f6369p;
        this.f6369p = i14 + 1;
        solverVariableArr[i14] = solverVariableAcquire;
        return solverVariableAcquire;
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f11, int i11) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable solverVariableQ = q(constraintWidget.q(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable solverVariableQ2 = q(constraintWidget.q(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable solverVariableQ3 = q(constraintWidget.q(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable solverVariableQ4 = q(constraintWidget.q(type4));
        SolverVariable solverVariableQ5 = q(constraintWidget2.q(type));
        SolverVariable solverVariableQ6 = q(constraintWidget2.q(type2));
        SolverVariable solverVariableQ7 = q(constraintWidget2.q(type3));
        SolverVariable solverVariableQ8 = q(constraintWidget2.q(type4));
        androidx.constraintlayout.core.b bVarR = r();
        double d11 = f11;
        double d12 = i11;
        bVarR.q(solverVariableQ2, solverVariableQ4, solverVariableQ6, solverVariableQ8, (float) (Math.sin(d11) * d12));
        d(bVarR);
        androidx.constraintlayout.core.b bVarR2 = r();
        bVarR2.q(solverVariableQ, solverVariableQ3, solverVariableQ5, solverVariableQ7, (float) (Math.cos(d11) * d12));
        d(bVarR2);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, float f11, SolverVariable solverVariable3, SolverVariable solverVariable4, int i12, int i13) {
        androidx.constraintlayout.core.b bVarR = r();
        bVarR.h(solverVariable, solverVariable2, i11, f11, solverVariable3, solverVariable4, i12);
        if (i13 != 8) {
            bVarR.d(this, i13);
        }
        d(bVarR);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x007a  */
    public void d(androidx.constraintlayout.core.b bVar) {
        SolverVariable solverVariableV;
        if (bVar == null) {
            return;
        }
        boolean z11 = true;
        if (this.f6365l + 1 >= this.f6366m || this.f6364k + 1 >= this.f6359f) {
            z();
        }
        if (!bVar.f6341f) {
            bVar.D(this);
            if (bVar.isEmpty()) {
                return;
            }
            bVar.r();
            if (bVar.f(this)) {
                SolverVariable solverVariableP = p();
                bVar.f6336a = solverVariableP;
                int i11 = this.f6365l;
                l(bVar);
                if (this.f6365l == i11 + 1) {
                    this.f6370q.a(bVar);
                    C(this.f6370q, true);
                    if (solverVariableP.f6310d == -1) {
                        if (bVar.f6336a == solverVariableP && (solverVariableV = bVar.v(solverVariableP)) != null) {
                            bVar.x(solverVariableV);
                        }
                        if (!bVar.f6341f) {
                            bVar.f6336a.j(this, bVar);
                        }
                        if (f6350v) {
                            this.f6367n.f6342a.release(bVar);
                        } else {
                            this.f6367n.f6343b.release(bVar);
                        }
                        this.f6365l--;
                    }
                } else {
                    z11 = false;
                }
            } else {
                z11 = false;
            }
            if (!bVar.s() || z11) {
                return;
            }
        }
        l(bVar);
    }

    public androidx.constraintlayout.core.b e(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        if (f6347s && i12 == 8 && solverVariable2.f6313h && solverVariable.f6310d == -1) {
            solverVariable.h(this, solverVariable2.f6312g + i11);
            return null;
        }
        androidx.constraintlayout.core.b bVarR = r();
        bVarR.n(solverVariable, solverVariable2, i11);
        if (i12 != 8) {
            bVarR.d(this, i12);
        }
        d(bVarR);
        return bVarR;
    }

    public void f(SolverVariable solverVariable, int i11) {
        if (f6347s && solverVariable.f6310d == -1) {
            float f11 = i11;
            solverVariable.h(this, f11);
            for (int i12 = 0; i12 < this.f6355b + 1; i12++) {
                SolverVariable solverVariable2 = this.f6367n.f6345d[i12];
                if (solverVariable2 != null && solverVariable2.f6320o && solverVariable2.f6321p == solverVariable.f6309c) {
                    solverVariable2.h(this, solverVariable2.f6322q + f11);
                }
            }
            return;
        }
        int i13 = solverVariable.f6310d;
        if (i13 == -1) {
            androidx.constraintlayout.core.b bVarR = r();
            bVarR.i(solverVariable, i11);
            d(bVarR);
            return;
        }
        androidx.constraintlayout.core.b bVar = this.f6360g[i13];
        if (bVar.f6341f) {
            bVar.f6337b = i11;
            return;
        }
        if (bVar.f6340e.getCurrentSize() == 0) {
            bVar.f6341f = true;
            bVar.f6337b = i11;
        } else {
            androidx.constraintlayout.core.b bVarR2 = r();
            bVarR2.m(solverVariable, i11);
            d(bVarR2);
        }
    }

    public void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, boolean z11) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f6311f = 0;
        bVarR.o(solverVariable, solverVariable2, solverVariableT, i11);
        d(bVarR);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f6311f = 0;
        bVarR.o(solverVariable, solverVariable2, solverVariableT, i11);
        if (i12 != 8) {
            m(bVarR, (int) (bVarR.f6340e.i(solverVariableT) * (-1.0f)), i12);
        }
        d(bVarR);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, boolean z11) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f6311f = 0;
        bVarR.p(solverVariable, solverVariable2, solverVariableT, i11);
        d(bVarR);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f6311f = 0;
        bVarR.p(solverVariable, solverVariable2, solverVariableT, i11);
        if (i12 != 8) {
            m(bVarR, (int) (bVarR.f6340e.i(solverVariableT) * (-1.0f)), i12);
        }
        d(bVarR);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11, int i11) {
        androidx.constraintlayout.core.b bVarR = r();
        bVarR.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, f11);
        if (i11 != 8) {
            bVarR.d(this, i11);
        }
        d(bVarR);
    }

    public final void l(androidx.constraintlayout.core.b bVar) {
        int i11;
        if (f6348t && bVar.f6341f) {
            bVar.f6336a.h(this, bVar.f6337b);
        } else {
            androidx.constraintlayout.core.b[] bVarArr = this.f6360g;
            int i12 = this.f6365l;
            bVarArr[i12] = bVar;
            SolverVariable solverVariable = bVar.f6336a;
            solverVariable.f6310d = i12;
            this.f6365l = i12 + 1;
            solverVariable.j(this, bVar);
        }
        if (f6348t && this.f6354a) {
            int i13 = 0;
            while (i13 < this.f6365l) {
                if (this.f6360g[i13] == null) {
                    System.out.println("WTF");
                }
                androidx.constraintlayout.core.b bVar2 = this.f6360g[i13];
                if (bVar2 != null && bVar2.f6341f) {
                    bVar2.f6336a.h(this, bVar2.f6337b);
                    if (f6350v) {
                        this.f6367n.f6342a.release(bVar2);
                    } else {
                        this.f6367n.f6343b.release(bVar2);
                    }
                    this.f6360g[i13] = null;
                    int i14 = i13 + 1;
                    int i15 = i14;
                    while (true) {
                        i11 = this.f6365l;
                        if (i14 >= i11) {
                            break;
                        }
                        androidx.constraintlayout.core.b[] bVarArr2 = this.f6360g;
                        int i16 = i14 - 1;
                        androidx.constraintlayout.core.b bVar3 = bVarArr2[i14];
                        bVarArr2[i16] = bVar3;
                        SolverVariable solverVariable2 = bVar3.f6336a;
                        if (solverVariable2.f6310d == i14) {
                            solverVariable2.f6310d = i16;
                        }
                        i15 = i14;
                        i14++;
                    }
                    if (i15 < i11) {
                        this.f6360g[i15] = null;
                    }
                    this.f6365l = i11 - 1;
                    i13--;
                }
                i13++;
            }
            this.f6354a = false;
        }
    }

    public void m(androidx.constraintlayout.core.b bVar, int i11, int i12) {
        bVar.e(o(i12, null), i11);
    }

    public final void n() {
        for (int i11 = 0; i11 < this.f6365l; i11++) {
            androidx.constraintlayout.core.b bVar = this.f6360g[i11];
            bVar.f6336a.f6312g = bVar.f6337b;
        }
    }

    public SolverVariable o(int i11, String str) {
        if (this.f6364k + 1 >= this.f6359f) {
            z();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.ERROR, str);
        int i12 = this.f6355b + 1;
        this.f6355b = i12;
        this.f6364k++;
        solverVariableA.f6309c = i12;
        solverVariableA.f6311f = i11;
        this.f6367n.f6345d[i12] = solverVariableA;
        this.f6357d.c(solverVariableA);
        return solverVariableA;
    }

    public SolverVariable p() {
        if (this.f6364k + 1 >= this.f6359f) {
            z();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i11 = this.f6355b + 1;
        this.f6355b = i11;
        this.f6364k++;
        solverVariableA.f6309c = i11;
        this.f6367n.f6345d[i11] = solverVariableA;
        return solverVariableA;
    }

    public SolverVariable q(Object obj) {
        SolverVariable solverVariableI = null;
        if (obj == null) {
            return null;
        }
        if (this.f6364k + 1 >= this.f6359f) {
            z();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariableI = constraintAnchor.i();
            if (solverVariableI == null) {
                constraintAnchor.s(this.f6367n);
                solverVariableI = constraintAnchor.i();
            }
            int i11 = solverVariableI.f6309c;
            if (i11 == -1 || i11 > this.f6355b || this.f6367n.f6345d[i11] == null) {
                if (i11 != -1) {
                    solverVariableI.e();
                }
                int i12 = this.f6355b + 1;
                this.f6355b = i12;
                this.f6364k++;
                solverVariableI.f6309c = i12;
                solverVariableI.f6316k = SolverVariable.Type.UNRESTRICTED;
                this.f6367n.f6345d[i12] = solverVariableI;
            }
        }
        return solverVariableI;
    }

    public androidx.constraintlayout.core.b r() {
        androidx.constraintlayout.core.b bVarAcquire;
        if (f6350v) {
            bVarAcquire = this.f6367n.f6342a.acquire();
            if (bVarAcquire == null) {
                bVarAcquire = new b(this.f6367n);
                f6353y++;
            } else {
                bVarAcquire.y();
            }
        } else {
            bVarAcquire = this.f6367n.f6343b.acquire();
            if (bVarAcquire == null) {
                bVarAcquire = new androidx.constraintlayout.core.b(this.f6367n);
                f6352x++;
            } else {
                bVarAcquire.y();
            }
        }
        SolverVariable.c();
        return bVarAcquire;
    }

    public SolverVariable t() {
        if (this.f6364k + 1 >= this.f6359f) {
            z();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i11 = this.f6355b + 1;
        this.f6355b = i11;
        this.f6364k++;
        solverVariableA.f6309c = i11;
        this.f6367n.f6345d[i11] = solverVariableA;
        return solverVariableA;
    }

    public final int u(a aVar) throws Exception {
        for (int i11 = 0; i11 < this.f6365l; i11++) {
            androidx.constraintlayout.core.b bVar = this.f6360g[i11];
            if (bVar.f6336a.f6316k != SolverVariable.Type.UNRESTRICTED && bVar.f6337b < 0.0f) {
                boolean z11 = false;
                int i12 = 0;
                while (!z11) {
                    i12++;
                    float f11 = Float.MAX_VALUE;
                    int i13 = 0;
                    int i14 = -1;
                    int i15 = -1;
                    int i16 = 0;
                    while (true) {
                        if (i13 >= this.f6365l) {
                            break;
                        }
                        androidx.constraintlayout.core.b bVar2 = this.f6360g[i13];
                        if (bVar2.f6336a.f6316k != SolverVariable.Type.UNRESTRICTED && !bVar2.f6341f && bVar2.f6337b < 0.0f) {
                            int i17 = 9;
                            if (f6349u) {
                                int currentSize = bVar2.f6340e.getCurrentSize();
                                int i18 = 0;
                                while (i18 < currentSize) {
                                    SolverVariable solverVariableB = bVar2.f6340e.b(i18);
                                    float fI = bVar2.f6340e.i(solverVariableB);
                                    if (fI > 0.0f) {
                                        int i19 = 0;
                                        while (i19 < i17) {
                                            float f12 = solverVariableB.f6314i[i19] / fI;
                                            if ((f12 < f11 && i19 == i16) || i19 > i16) {
                                                i16 = i19;
                                                i15 = solverVariableB.f6309c;
                                                i14 = i13;
                                                f11 = f12;
                                            }
                                            i19++;
                                            i17 = 9;
                                        }
                                    }
                                    i18++;
                                    i17 = 9;
                                }
                            } else {
                                for (int i21 = 1; i21 < this.f6364k; i21++) {
                                    SolverVariable solverVariable = this.f6367n.f6345d[i21];
                                    float fI2 = bVar2.f6340e.i(solverVariable);
                                    if (fI2 > 0.0f) {
                                        for (int i22 = 0; i22 < 9; i22++) {
                                            float f13 = solverVariable.f6314i[i22] / fI2;
                                            if ((f13 < f11 && i22 == i16) || i22 > i16) {
                                                i14 = i13;
                                                i15 = i21;
                                                i16 = i22;
                                                f11 = f13;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i13++;
                    }
                    if (i14 != -1) {
                        androidx.constraintlayout.core.b bVar3 = this.f6360g[i14];
                        bVar3.f6336a.f6310d = -1;
                        bVar3.x(this.f6367n.f6345d[i15]);
                        SolverVariable solverVariable2 = bVar3.f6336a;
                        solverVariable2.f6310d = i14;
                        solverVariable2.j(this, bVar3);
                    } else {
                        z11 = true;
                    }
                    if (i12 > this.f6364k / 2) {
                        z11 = true;
                    }
                }
                return i12;
            }
        }
        return 0;
    }

    public void v(e eVar) {
    }

    public c w() {
        return this.f6367n;
    }

    public int y(Object obj) {
        SolverVariable solverVariableI = ((ConstraintAnchor) obj).i();
        if (solverVariableI != null) {
            return (int) (solverVariableI.f6312g + 0.5f);
        }
        return 0;
    }

    public final void z() {
        int i11 = this.f6358e * 2;
        this.f6358e = i11;
        this.f6360g = (androidx.constraintlayout.core.b[]) Arrays.copyOf(this.f6360g, i11);
        c cVar = this.f6367n;
        cVar.f6345d = (SolverVariable[]) Arrays.copyOf(cVar.f6345d, this.f6358e);
        int i12 = this.f6358e;
        this.f6363j = new boolean[i12];
        this.f6359f = i12;
        this.f6366m = i12;
    }
}
