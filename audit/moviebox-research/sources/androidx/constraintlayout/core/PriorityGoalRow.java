package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class PriorityGoalRow extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SolverVariable[] f6298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SolverVariable[] f6299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6300j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f6301k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f6302l;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SolverVariable f6303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PriorityGoalRow f6304b;

        public a(PriorityGoalRow priorityGoalRow) {
            this.f6304b = priorityGoalRow;
        }

        public boolean a(SolverVariable solverVariable, float f11) {
            boolean z11 = true;
            if (!this.f6303a.f6307a) {
                for (int i11 = 0; i11 < 9; i11++) {
                    float f12 = solverVariable.f6315j[i11];
                    if (f12 != 0.0f) {
                        float f13 = f12 * f11;
                        if (Math.abs(f13) < 1.0E-4f) {
                            f13 = 0.0f;
                        }
                        this.f6303a.f6315j[i11] = f13;
                    } else {
                        this.f6303a.f6315j[i11] = 0.0f;
                    }
                }
                return true;
            }
            for (int i12 = 0; i12 < 9; i12++) {
                float[] fArr = this.f6303a.f6315j;
                float f14 = fArr[i12] + (solverVariable.f6315j[i12] * f11);
                fArr[i12] = f14;
                if (Math.abs(f14) < 1.0E-4f) {
                    this.f6303a.f6315j[i12] = 0.0f;
                } else {
                    z11 = false;
                }
            }
            if (z11) {
                PriorityGoalRow.this.G(this.f6303a);
            }
            return false;
        }

        public void b(SolverVariable solverVariable) {
            this.f6303a = solverVariable;
        }

        public final boolean c() {
            for (int i11 = 8; i11 >= 0; i11--) {
                float f11 = this.f6303a.f6315j[i11];
                if (f11 > 0.0f) {
                    return false;
                }
                if (f11 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(SolverVariable solverVariable) {
            for (int i11 = 8; i11 >= 0; i11--) {
                float f11 = solverVariable.f6315j[i11];
                float f12 = this.f6303a.f6315j[i11];
                if (f12 != f11) {
                    if (f12 < f11) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f6303a.f6315j, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f6303a != null) {
                for (int i11 = 0; i11 < 9; i11++) {
                    str = str + this.f6303a.f6315j[i11] + " ";
                }
            }
            return str + "] " + this.f6303a;
        }
    }

    public PriorityGoalRow(c cVar) {
        super(cVar);
        this.f6297g = 128;
        this.f6298h = new SolverVariable[128];
        this.f6299i = new SolverVariable[128];
        this.f6300j = 0;
        this.f6301k = new a(this);
        this.f6302l = cVar;
    }

    @Override // androidx.constraintlayout.core.b
    public void B(d dVar, b bVar, boolean z11) {
        SolverVariable solverVariable = bVar.f6336a;
        if (solverVariable == null) {
            return;
        }
        b.a aVar = bVar.f6340e;
        int currentSize = aVar.getCurrentSize();
        for (int i11 = 0; i11 < currentSize; i11++) {
            SolverVariable solverVariableB = aVar.b(i11);
            float fH = aVar.h(i11);
            this.f6301k.b(solverVariableB);
            if (this.f6301k.a(solverVariable, fH)) {
                F(solverVariableB);
            }
            this.f6337b += bVar.f6337b * fH;
        }
        G(solverVariable);
    }

    public final void F(SolverVariable solverVariable) {
        int i11;
        int i12 = this.f6300j + 1;
        SolverVariable[] solverVariableArr = this.f6298h;
        if (i12 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f6298h = solverVariableArr2;
            this.f6299i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f6298h;
        int i13 = this.f6300j;
        solverVariableArr3[i13] = solverVariable;
        int i14 = i13 + 1;
        this.f6300j = i14;
        if (i14 > 1 && solverVariableArr3[i13].f6309c > solverVariable.f6309c) {
            int i15 = 0;
            while (true) {
                i11 = this.f6300j;
                if (i15 >= i11) {
                    break;
                }
                this.f6299i[i15] = this.f6298h[i15];
                i15++;
            }
            Arrays.sort(this.f6299i, 0, i11, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.f6309c - solverVariable3.f6309c;
                }
            });
            for (int i16 = 0; i16 < this.f6300j; i16++) {
                this.f6298h[i16] = this.f6299i[i16];
            }
        }
        solverVariable.f6307a = true;
        solverVariable.a(this);
    }

    public final void G(SolverVariable solverVariable) {
        int i11 = 0;
        while (i11 < this.f6300j) {
            if (this.f6298h[i11] == solverVariable) {
                while (true) {
                    int i12 = this.f6300j;
                    if (i11 >= i12 - 1) {
                        this.f6300j = i12 - 1;
                        solverVariable.f6307a = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.f6298h;
                        int i13 = i11 + 1;
                        solverVariableArr[i11] = solverVariableArr[i13];
                        i11 = i13;
                    }
                }
            } else {
                i11++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public SolverVariable b(d dVar, boolean[] zArr) {
        int i11 = -1;
        for (int i12 = 0; i12 < this.f6300j; i12++) {
            SolverVariable solverVariable = this.f6298h[i12];
            if (!zArr[solverVariable.f6309c]) {
                this.f6301k.b(solverVariable);
                if (i11 == -1) {
                    if (this.f6301k.c()) {
                        i11 = i12;
                    }
                } else if (this.f6301k.d(this.f6298h[i11])) {
                    i11 = i12;
                }
            }
        }
        if (i11 == -1) {
            return null;
        }
        return this.f6298h[i11];
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public void c(SolverVariable solverVariable) {
        this.f6301k.b(solverVariable);
        this.f6301k.e();
        solverVariable.f6315j[solverVariable.f6311f] = 1.0f;
        F(solverVariable);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public void clear() {
        this.f6300j = 0;
        this.f6337b = 0.0f;
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public boolean isEmpty() {
        return this.f6300j == 0;
    }

    @Override // androidx.constraintlayout.core.b
    public String toString() {
        String str = " goal -> (" + this.f6337b + ") : ";
        for (int i11 = 0; i11 < this.f6300j; i11++) {
            this.f6301k.b(this.f6298h[i11]);
            str = str + this.f6301k + " ";
        }
        return str;
    }
}
