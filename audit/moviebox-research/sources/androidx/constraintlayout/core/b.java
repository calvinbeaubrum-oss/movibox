package androidx.constraintlayout.core;

import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f6340e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SolverVariable f6336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f6337b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6338c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<SolverVariable> f6339d = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6341f = false;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        boolean a(SolverVariable solverVariable);

        SolverVariable b(int i11);

        void c(SolverVariable solverVariable, float f11, boolean z11);

        void clear();

        void d();

        float e(SolverVariable solverVariable, boolean z11);

        float f(b bVar, boolean z11);

        void g(SolverVariable solverVariable, float f11);

        int getCurrentSize();

        float h(int i11);

        float i(SolverVariable solverVariable);

        void j(float f11);
    }

    public b() {
    }

    public b(c cVar) {
        this.f6340e = new androidx.constraintlayout.core.a(this, cVar);
    }

    public void A(d dVar, SolverVariable solverVariable, boolean z11) {
        if (solverVariable == null || !solverVariable.f6313h) {
            return;
        }
        this.f6337b += solverVariable.f6312g * this.f6340e.i(solverVariable);
        this.f6340e.e(solverVariable, z11);
        if (z11) {
            solverVariable.d(this);
        }
        if (d.f6348t && this.f6340e.getCurrentSize() == 0) {
            this.f6341f = true;
            dVar.f6354a = true;
        }
    }

    public void B(d dVar, b bVar, boolean z11) {
        this.f6337b += bVar.f6337b * this.f6340e.f(bVar, z11);
        if (z11) {
            bVar.f6336a.d(this);
        }
        if (d.f6348t && this.f6336a != null && this.f6340e.getCurrentSize() == 0) {
            this.f6341f = true;
            dVar.f6354a = true;
        }
    }

    public void C(d dVar, SolverVariable solverVariable, boolean z11) {
        if (solverVariable == null || !solverVariable.f6320o) {
            return;
        }
        float fI = this.f6340e.i(solverVariable);
        this.f6337b += solverVariable.f6322q * fI;
        this.f6340e.e(solverVariable, z11);
        if (z11) {
            solverVariable.d(this);
        }
        this.f6340e.c(dVar.f6367n.f6345d[solverVariable.f6321p], fI, z11);
        if (d.f6348t && this.f6340e.getCurrentSize() == 0) {
            this.f6341f = true;
            dVar.f6354a = true;
        }
    }

    public void D(d dVar) {
        if (dVar.f6360g.length == 0) {
            return;
        }
        boolean z11 = false;
        while (!z11) {
            int currentSize = this.f6340e.getCurrentSize();
            for (int i11 = 0; i11 < currentSize; i11++) {
                SolverVariable solverVariableB = this.f6340e.b(i11);
                if (solverVariableB.f6310d != -1 || solverVariableB.f6313h || solverVariableB.f6320o) {
                    this.f6339d.add(solverVariableB);
                }
            }
            int size = this.f6339d.size();
            if (size > 0) {
                for (int i12 = 0; i12 < size; i12++) {
                    SolverVariable solverVariable = this.f6339d.get(i12);
                    if (solverVariable.f6313h) {
                        A(dVar, solverVariable, true);
                    } else if (solverVariable.f6320o) {
                        C(dVar, solverVariable, true);
                    } else {
                        B(dVar, dVar.f6360g[solverVariable.f6310d], true);
                    }
                }
                this.f6339d.clear();
            } else {
                z11 = true;
            }
        }
        if (d.f6348t && this.f6336a != null && this.f6340e.getCurrentSize() == 0) {
            this.f6341f = true;
            dVar.f6354a = true;
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f6336a = null;
            this.f6340e.clear();
            for (int i11 = 0; i11 < bVar.f6340e.getCurrentSize(); i11++) {
                this.f6340e.c(bVar.f6340e.b(i11), bVar.f6340e.h(i11), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public SolverVariable b(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // androidx.constraintlayout.core.d.a
    public void c(SolverVariable solverVariable) {
        int i11 = solverVariable.f6311f;
        float f11 = 1.0f;
        if (i11 != 1) {
            if (i11 == 2) {
                f11 = 1000.0f;
            } else if (i11 == 3) {
                f11 = 1000000.0f;
            } else if (i11 == 4) {
                f11 = 1.0E9f;
            } else if (i11 == 5) {
                f11 = 1.0E12f;
            }
        }
        this.f6340e.g(solverVariable, f11);
    }

    @Override // androidx.constraintlayout.core.d.a
    public void clear() {
        this.f6340e.clear();
        this.f6336a = null;
        this.f6337b = 0.0f;
    }

    public b d(d dVar, int i11) {
        this.f6340e.g(dVar.o(i11, "ep"), 1.0f);
        this.f6340e.g(dVar.o(i11, "em"), -1.0f);
        return this;
    }

    public b e(SolverVariable solverVariable, int i11) {
        this.f6340e.g(solverVariable, i11);
        return this;
    }

    public boolean f(d dVar) {
        boolean z11;
        SolverVariable solverVariableG = g(dVar);
        if (solverVariableG == null) {
            z11 = true;
        } else {
            x(solverVariableG);
            z11 = false;
        }
        if (this.f6340e.getCurrentSize() == 0) {
            this.f6341f = true;
        }
        return z11;
    }

    public SolverVariable g(d dVar) {
        int currentSize = this.f6340e.getCurrentSize();
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        boolean z11 = false;
        boolean z12 = false;
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (int i11 = 0; i11 < currentSize; i11++) {
            float fH = this.f6340e.h(i11);
            SolverVariable solverVariableB = this.f6340e.b(i11);
            if (solverVariableB.f6316k == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null || f11 > fH) {
                    boolean zU = u(solverVariableB, dVar);
                    z11 = zU;
                    f11 = fH;
                    solverVariable = solverVariableB;
                } else if (!z11 && u(solverVariableB, dVar)) {
                    f11 = fH;
                    solverVariable = solverVariableB;
                    z11 = true;
                }
            } else if (solverVariable == null && fH < 0.0f) {
                if (solverVariable2 == null || f12 > fH) {
                    boolean zU2 = u(solverVariableB, dVar);
                    z12 = zU2;
                    f12 = fH;
                    solverVariable2 = solverVariableB;
                } else if (!z12 && u(solverVariableB, dVar)) {
                    f12 = fH;
                    solverVariable2 = solverVariableB;
                    z12 = true;
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.core.d.a
    public SolverVariable getKey() {
        return this.f6336a;
    }

    public b h(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, float f11, SolverVariable solverVariable3, SolverVariable solverVariable4, int i12) {
        if (solverVariable2 == solverVariable3) {
            this.f6340e.g(solverVariable, 1.0f);
            this.f6340e.g(solverVariable4, 1.0f);
            this.f6340e.g(solverVariable2, -2.0f);
            return this;
        }
        if (f11 == 0.5f) {
            this.f6340e.g(solverVariable, 1.0f);
            this.f6340e.g(solverVariable2, -1.0f);
            this.f6340e.g(solverVariable3, -1.0f);
            this.f6340e.g(solverVariable4, 1.0f);
            if (i11 > 0 || i12 > 0) {
                this.f6337b = (-i11) + i12;
            }
        } else if (f11 <= 0.0f) {
            this.f6340e.g(solverVariable, -1.0f);
            this.f6340e.g(solverVariable2, 1.0f);
            this.f6337b = i11;
        } else if (f11 >= 1.0f) {
            this.f6340e.g(solverVariable4, -1.0f);
            this.f6340e.g(solverVariable3, 1.0f);
            this.f6337b = -i12;
        } else {
            float f12 = 1.0f - f11;
            this.f6340e.g(solverVariable, f12 * 1.0f);
            this.f6340e.g(solverVariable2, f12 * (-1.0f));
            this.f6340e.g(solverVariable3, (-1.0f) * f11);
            this.f6340e.g(solverVariable4, 1.0f * f11);
            if (i11 > 0 || i12 > 0) {
                this.f6337b = ((-i11) * f12) + (i12 * f11);
            }
        }
        return this;
    }

    public b i(SolverVariable solverVariable, int i11) {
        this.f6336a = solverVariable;
        float f11 = i11;
        solverVariable.f6312g = f11;
        this.f6337b = f11;
        this.f6341f = true;
        return this;
    }

    @Override // androidx.constraintlayout.core.d.a
    public boolean isEmpty() {
        return this.f6336a == null && this.f6337b == 0.0f && this.f6340e.getCurrentSize() == 0;
    }

    public b j(SolverVariable solverVariable, SolverVariable solverVariable2, float f11) {
        this.f6340e.g(solverVariable, -1.0f);
        this.f6340e.g(solverVariable2, f11);
        return this;
    }

    public b k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11) {
        this.f6340e.g(solverVariable, -1.0f);
        this.f6340e.g(solverVariable2, 1.0f);
        this.f6340e.g(solverVariable3, f11);
        this.f6340e.g(solverVariable4, -f11);
        return this;
    }

    public b l(float f11, float f12, float f13, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f6337b = 0.0f;
        if (f12 == 0.0f || f11 == f13) {
            this.f6340e.g(solverVariable, 1.0f);
            this.f6340e.g(solverVariable2, -1.0f);
            this.f6340e.g(solverVariable4, 1.0f);
            this.f6340e.g(solverVariable3, -1.0f);
        } else if (f11 == 0.0f) {
            this.f6340e.g(solverVariable, 1.0f);
            this.f6340e.g(solverVariable2, -1.0f);
        } else if (f13 == 0.0f) {
            this.f6340e.g(solverVariable3, 1.0f);
            this.f6340e.g(solverVariable4, -1.0f);
        } else {
            float f14 = (f11 / f12) / (f13 / f12);
            this.f6340e.g(solverVariable, 1.0f);
            this.f6340e.g(solverVariable2, -1.0f);
            this.f6340e.g(solverVariable4, f14);
            this.f6340e.g(solverVariable3, -f14);
        }
        return this;
    }

    public b m(SolverVariable solverVariable, int i11) {
        if (i11 < 0) {
            this.f6337b = i11 * (-1);
            this.f6340e.g(solverVariable, 1.0f);
        } else {
            this.f6337b = i11;
            this.f6340e.g(solverVariable, -1.0f);
        }
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    public b n(SolverVariable solverVariable, SolverVariable solverVariable2, int i11) {
        boolean z11;
        if (i11 == 0) {
            this.f6340e.g(solverVariable, -1.0f);
            this.f6340e.g(solverVariable2, 1.0f);
        } else {
            if (i11 < 0) {
                i11 *= -1;
                z11 = true;
            } else {
                z11 = false;
            }
            this.f6337b = i11;
            if (z11) {
                this.f6340e.g(solverVariable, 1.0f);
                this.f6340e.g(solverVariable2, -1.0f);
            } else {
                this.f6340e.g(solverVariable, -1.0f);
                this.f6340e.g(solverVariable2, 1.0f);
            }
        }
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0023  */
    public b o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i11) {
        boolean z11;
        if (i11 == 0) {
            this.f6340e.g(solverVariable, -1.0f);
            this.f6340e.g(solverVariable2, 1.0f);
            this.f6340e.g(solverVariable3, 1.0f);
        } else {
            if (i11 < 0) {
                i11 *= -1;
                z11 = true;
            } else {
                z11 = false;
            }
            this.f6337b = i11;
            if (z11) {
                this.f6340e.g(solverVariable, 1.0f);
                this.f6340e.g(solverVariable2, -1.0f);
                this.f6340e.g(solverVariable3, -1.0f);
            } else {
                this.f6340e.g(solverVariable, -1.0f);
                this.f6340e.g(solverVariable2, 1.0f);
                this.f6340e.g(solverVariable3, 1.0f);
            }
        }
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0023  */
    public b p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i11) {
        boolean z11;
        if (i11 == 0) {
            this.f6340e.g(solverVariable, -1.0f);
            this.f6340e.g(solverVariable2, 1.0f);
            this.f6340e.g(solverVariable3, -1.0f);
        } else {
            if (i11 < 0) {
                i11 *= -1;
                z11 = true;
            } else {
                z11 = false;
            }
            this.f6337b = i11;
            if (z11) {
                this.f6340e.g(solverVariable, 1.0f);
                this.f6340e.g(solverVariable2, -1.0f);
                this.f6340e.g(solverVariable3, 1.0f);
            } else {
                this.f6340e.g(solverVariable, -1.0f);
                this.f6340e.g(solverVariable2, 1.0f);
                this.f6340e.g(solverVariable3, -1.0f);
            }
        }
        return this;
    }

    public b q(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11) {
        this.f6340e.g(solverVariable3, 0.5f);
        this.f6340e.g(solverVariable4, 0.5f);
        this.f6340e.g(solverVariable, -0.5f);
        this.f6340e.g(solverVariable2, -0.5f);
        this.f6337b = -f11;
        return this;
    }

    public void r() {
        float f11 = this.f6337b;
        if (f11 < 0.0f) {
            this.f6337b = f11 * (-1.0f);
            this.f6340e.d();
        }
    }

    public boolean s() {
        SolverVariable solverVariable = this.f6336a;
        return solverVariable != null && (solverVariable.f6316k == SolverVariable.Type.UNRESTRICTED || this.f6337b >= 0.0f);
    }

    public boolean t(SolverVariable solverVariable) {
        return this.f6340e.a(solverVariable);
    }

    public String toString() {
        return z();
    }

    public final boolean u(SolverVariable solverVariable, d dVar) {
        return solverVariable.f6319n <= 1;
    }

    public SolverVariable v(SolverVariable solverVariable) {
        return w(null, solverVariable);
    }

    public final SolverVariable w(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.f6340e.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f11 = 0.0f;
        for (int i11 = 0; i11 < currentSize; i11++) {
            float fH = this.f6340e.h(i11);
            if (fH < 0.0f) {
                SolverVariable solverVariableB = this.f6340e.b(i11);
                if ((zArr == null || !zArr[solverVariableB.f6309c]) && solverVariableB != solverVariable && (((type = solverVariableB.f6316k) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && fH < f11)) {
                    f11 = fH;
                    solverVariable2 = solverVariableB;
                }
            }
        }
        return solverVariable2;
    }

    public void x(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f6336a;
        if (solverVariable2 != null) {
            this.f6340e.g(solverVariable2, -1.0f);
            this.f6336a.f6310d = -1;
            this.f6336a = null;
        }
        float fE = this.f6340e.e(solverVariable, true) * (-1.0f);
        this.f6336a = solverVariable;
        if (fE == 1.0f) {
            return;
        }
        this.f6337b /= fE;
        this.f6340e.j(fE);
    }

    public void y() {
        this.f6336a = null;
        this.f6340e.clear();
        this.f6337b = 0.0f;
        this.f6341f = false;
    }

    public String z() {
        boolean z11;
        String str = (this.f6336a == null ? "0" : "" + this.f6336a) + " = ";
        if (this.f6337b != 0.0f) {
            str = str + this.f6337b;
            z11 = true;
        } else {
            z11 = false;
        }
        int currentSize = this.f6340e.getCurrentSize();
        for (int i11 = 0; i11 < currentSize; i11++) {
            SolverVariable solverVariableB = this.f6340e.b(i11);
            if (solverVariableB != null) {
                float fH = this.f6340e.h(i11);
                if (fH != 0.0f) {
                    String string = solverVariableB.toString();
                    if (z11) {
                        if (fH > 0.0f) {
                            str = str + " + ";
                        } else {
                            str = str + " - ";
                            fH *= -1.0f;
                        }
                    } else if (fH < 0.0f) {
                        str = str + "- ";
                        fH *= -1.0f;
                    }
                    str = fH == 1.0f ? str + string : str + fH + " " + string;
                    z11 = true;
                }
            }
        }
        if (z11) {
            return str;
        }
        return str + "0.0";
    }
}
