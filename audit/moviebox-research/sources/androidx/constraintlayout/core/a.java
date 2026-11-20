package androidx.constraintlayout.core;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static float f6324l = 0.001f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f6326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f6327c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6325a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6328d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SolverVariable f6329e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f6330f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f6331g = new int[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f6332h = new float[8];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6333i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6334j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6335k = false;

    public a(b bVar, c cVar) {
        this.f6326b = bVar;
        this.f6327c = cVar;
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean a(SolverVariable solverVariable) {
        int i11 = this.f6333i;
        if (i11 == -1) {
            return false;
        }
        for (int i12 = 0; i11 != -1 && i12 < this.f6325a; i12++) {
            if (this.f6330f[i11] == solverVariable.f6309c) {
                return true;
            }
            i11 = this.f6331g[i11];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.b.a
    public SolverVariable b(int i11) {
        int i12 = this.f6333i;
        for (int i13 = 0; i12 != -1 && i13 < this.f6325a; i13++) {
            if (i13 == i11) {
                return this.f6327c.f6345d[this.f6330f[i12]];
            }
            i12 = this.f6331g[i12];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void c(SolverVariable solverVariable, float f11, boolean z11) {
        float f12 = f6324l;
        if (f11 <= (-f12) || f11 >= f12) {
            int i11 = this.f6333i;
            if (i11 == -1) {
                this.f6333i = 0;
                this.f6332h[0] = f11;
                this.f6330f[0] = solverVariable.f6309c;
                this.f6331g[0] = -1;
                solverVariable.f6319n++;
                solverVariable.a(this.f6326b);
                this.f6325a++;
                if (this.f6335k) {
                    return;
                }
                int i12 = this.f6334j + 1;
                this.f6334j = i12;
                int[] iArr = this.f6330f;
                if (i12 >= iArr.length) {
                    this.f6335k = true;
                    this.f6334j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i13 = -1;
            for (int i14 = 0; i11 != -1 && i14 < this.f6325a; i14++) {
                int i15 = this.f6330f[i11];
                int i16 = solverVariable.f6309c;
                if (i15 == i16) {
                    float[] fArr = this.f6332h;
                    float f13 = fArr[i11] + f11;
                    float f14 = f6324l;
                    if (f13 > (-f14) && f13 < f14) {
                        f13 = 0.0f;
                    }
                    fArr[i11] = f13;
                    if (f13 == 0.0f) {
                        if (i11 == this.f6333i) {
                            this.f6333i = this.f6331g[i11];
                        } else {
                            int[] iArr2 = this.f6331g;
                            iArr2[i13] = iArr2[i11];
                        }
                        if (z11) {
                            solverVariable.d(this.f6326b);
                        }
                        if (this.f6335k) {
                            this.f6334j = i11;
                        }
                        solverVariable.f6319n--;
                        this.f6325a--;
                        return;
                    }
                    return;
                }
                if (i15 < i16) {
                    i13 = i11;
                }
                i11 = this.f6331g[i11];
            }
            int length = this.f6334j;
            int i17 = length + 1;
            if (this.f6335k) {
                int[] iArr3 = this.f6330f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i17;
            }
            int[] iArr4 = this.f6330f;
            if (length >= iArr4.length && this.f6325a < iArr4.length) {
                int i18 = 0;
                while (true) {
                    int[] iArr5 = this.f6330f;
                    if (i18 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i18] == -1) {
                        length = i18;
                        break;
                    }
                    i18++;
                }
            }
            int[] iArr6 = this.f6330f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i19 = this.f6328d * 2;
                this.f6328d = i19;
                this.f6335k = false;
                this.f6334j = length - 1;
                this.f6332h = Arrays.copyOf(this.f6332h, i19);
                this.f6330f = Arrays.copyOf(this.f6330f, this.f6328d);
                this.f6331g = Arrays.copyOf(this.f6331g, this.f6328d);
            }
            this.f6330f[length] = solverVariable.f6309c;
            this.f6332h[length] = f11;
            if (i13 != -1) {
                int[] iArr7 = this.f6331g;
                iArr7[length] = iArr7[i13];
                iArr7[i13] = length;
            } else {
                this.f6331g[length] = this.f6333i;
                this.f6333i = length;
            }
            solverVariable.f6319n++;
            solverVariable.a(this.f6326b);
            this.f6325a++;
            if (!this.f6335k) {
                this.f6334j++;
            }
            int i21 = this.f6334j;
            int[] iArr8 = this.f6330f;
            if (i21 >= iArr8.length) {
                this.f6335k = true;
                this.f6334j = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void clear() {
        int i11 = this.f6333i;
        for (int i12 = 0; i11 != -1 && i12 < this.f6325a; i12++) {
            SolverVariable solverVariable = this.f6327c.f6345d[this.f6330f[i11]];
            if (solverVariable != null) {
                solverVariable.d(this.f6326b);
            }
            i11 = this.f6331g[i11];
        }
        this.f6333i = -1;
        this.f6334j = -1;
        this.f6335k = false;
        this.f6325a = 0;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void d() {
        int i11 = this.f6333i;
        for (int i12 = 0; i11 != -1 && i12 < this.f6325a; i12++) {
            float[] fArr = this.f6332h;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.f6331g[i11];
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float e(SolverVariable solverVariable, boolean z11) {
        if (this.f6329e == solverVariable) {
            this.f6329e = null;
        }
        int i11 = this.f6333i;
        if (i11 == -1) {
            return 0.0f;
        }
        int i12 = 0;
        int i13 = -1;
        while (i11 != -1 && i12 < this.f6325a) {
            if (this.f6330f[i11] == solverVariable.f6309c) {
                if (i11 == this.f6333i) {
                    this.f6333i = this.f6331g[i11];
                } else {
                    int[] iArr = this.f6331g;
                    iArr[i13] = iArr[i11];
                }
                if (z11) {
                    solverVariable.d(this.f6326b);
                }
                solverVariable.f6319n--;
                this.f6325a--;
                this.f6330f[i11] = -1;
                if (this.f6335k) {
                    this.f6334j = i11;
                }
                return this.f6332h[i11];
            }
            i12++;
            i13 = i11;
            i11 = this.f6331g[i11];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float f(b bVar, boolean z11) {
        float fI = i(bVar.f6336a);
        e(bVar.f6336a, z11);
        b.a aVar = bVar.f6340e;
        int currentSize = aVar.getCurrentSize();
        for (int i11 = 0; i11 < currentSize; i11++) {
            SolverVariable solverVariableB = aVar.b(i11);
            c(solverVariableB, aVar.i(solverVariableB) * fI, z11);
        }
        return fI;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void g(SolverVariable solverVariable, float f11) {
        if (f11 == 0.0f) {
            e(solverVariable, true);
            return;
        }
        int i11 = this.f6333i;
        if (i11 == -1) {
            this.f6333i = 0;
            this.f6332h[0] = f11;
            this.f6330f[0] = solverVariable.f6309c;
            this.f6331g[0] = -1;
            solverVariable.f6319n++;
            solverVariable.a(this.f6326b);
            this.f6325a++;
            if (this.f6335k) {
                return;
            }
            int i12 = this.f6334j + 1;
            this.f6334j = i12;
            int[] iArr = this.f6330f;
            if (i12 >= iArr.length) {
                this.f6335k = true;
                this.f6334j = iArr.length - 1;
                return;
            }
            return;
        }
        int i13 = -1;
        for (int i14 = 0; i11 != -1 && i14 < this.f6325a; i14++) {
            int i15 = this.f6330f[i11];
            int i16 = solverVariable.f6309c;
            if (i15 == i16) {
                this.f6332h[i11] = f11;
                return;
            }
            if (i15 < i16) {
                i13 = i11;
            }
            i11 = this.f6331g[i11];
        }
        int length = this.f6334j;
        int i17 = length + 1;
        if (this.f6335k) {
            int[] iArr2 = this.f6330f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i17;
        }
        int[] iArr3 = this.f6330f;
        if (length >= iArr3.length && this.f6325a < iArr3.length) {
            int i18 = 0;
            while (true) {
                int[] iArr4 = this.f6330f;
                if (i18 >= iArr4.length) {
                    break;
                }
                if (iArr4[i18] == -1) {
                    length = i18;
                    break;
                }
                i18++;
            }
        }
        int[] iArr5 = this.f6330f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i19 = this.f6328d * 2;
            this.f6328d = i19;
            this.f6335k = false;
            this.f6334j = length - 1;
            this.f6332h = Arrays.copyOf(this.f6332h, i19);
            this.f6330f = Arrays.copyOf(this.f6330f, this.f6328d);
            this.f6331g = Arrays.copyOf(this.f6331g, this.f6328d);
        }
        this.f6330f[length] = solverVariable.f6309c;
        this.f6332h[length] = f11;
        if (i13 != -1) {
            int[] iArr6 = this.f6331g;
            iArr6[length] = iArr6[i13];
            iArr6[i13] = length;
        } else {
            this.f6331g[length] = this.f6333i;
            this.f6333i = length;
        }
        solverVariable.f6319n++;
        solverVariable.a(this.f6326b);
        int i21 = this.f6325a + 1;
        this.f6325a = i21;
        if (!this.f6335k) {
            this.f6334j++;
        }
        int[] iArr7 = this.f6330f;
        if (i21 >= iArr7.length) {
            this.f6335k = true;
        }
        if (this.f6334j >= iArr7.length) {
            this.f6335k = true;
            this.f6334j = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public int getCurrentSize() {
        return this.f6325a;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float h(int i11) {
        int i12 = this.f6333i;
        for (int i13 = 0; i12 != -1 && i13 < this.f6325a; i13++) {
            if (i13 == i11) {
                return this.f6332h[i12];
            }
            i12 = this.f6331g[i12];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float i(SolverVariable solverVariable) {
        int i11 = this.f6333i;
        for (int i12 = 0; i11 != -1 && i12 < this.f6325a; i12++) {
            if (this.f6330f[i11] == solverVariable.f6309c) {
                return this.f6332h[i11];
            }
            i11 = this.f6331g[i11];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void j(float f11) {
        int i11 = this.f6333i;
        for (int i12 = 0; i11 != -1 && i12 < this.f6325a; i12++) {
            float[] fArr = this.f6332h;
            fArr[i11] = fArr[i11] / f11;
            i11 = this.f6331g[i11];
        }
    }

    public String toString() {
        int i11 = this.f6333i;
        String str = "";
        for (int i12 = 0; i11 != -1 && i12 < this.f6325a; i12++) {
            str = ((str + " -> ") + this.f6332h[i11] + " : ") + this.f6327c.f6345d[this.f6330f[i11]];
            i11 = this.f6331g[i11];
        }
        return str;
    }
}
