package androidx.constraintlayout.core;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements b.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static float f6374n = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6375a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6376b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6377c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f6378d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f6379e = new int[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f6380f = new int[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f6381g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f6382h = new int[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f6383i = new int[16];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6384j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6385k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f6386l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f6387m;

    public h(b bVar, c cVar) {
        this.f6386l = bVar;
        this.f6387m = cVar;
        clear();
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean a(SolverVariable solverVariable) {
        return o(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public SolverVariable b(int i11) {
        int i12 = this.f6384j;
        if (i12 == 0) {
            return null;
        }
        int i13 = this.f6385k;
        for (int i14 = 0; i14 < i12; i14++) {
            if (i14 == i11 && i13 != -1) {
                return this.f6387m.f6345d[this.f6380f[i13]];
            }
            i13 = this.f6383i[i13];
            if (i13 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void c(SolverVariable solverVariable, float f11, boolean z11) {
        float f12 = f6374n;
        if (f11 <= (-f12) || f11 >= f12) {
            int iO = o(solverVariable);
            if (iO == -1) {
                g(solverVariable, f11);
                return;
            }
            float[] fArr = this.f6381g;
            float f13 = fArr[iO] + f11;
            fArr[iO] = f13;
            float f14 = f6374n;
            if (f13 <= (-f14) || f13 >= f14) {
                return;
            }
            fArr[iO] = 0.0f;
            e(solverVariable, z11);
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public void clear() {
        int i11 = this.f6384j;
        for (int i12 = 0; i12 < i11; i12++) {
            SolverVariable solverVariableB = b(i12);
            if (solverVariableB != null) {
                solverVariableB.d(this.f6386l);
            }
        }
        for (int i13 = 0; i13 < this.f6376b; i13++) {
            this.f6380f[i13] = -1;
            this.f6379e[i13] = -1;
        }
        for (int i14 = 0; i14 < this.f6377c; i14++) {
            this.f6378d[i14] = -1;
        }
        this.f6384j = 0;
        this.f6385k = -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void d() {
        int i11 = this.f6384j;
        int i12 = this.f6385k;
        for (int i13 = 0; i13 < i11; i13++) {
            float[] fArr = this.f6381g;
            fArr[i12] = fArr[i12] * (-1.0f);
            i12 = this.f6383i[i12];
            if (i12 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public float e(SolverVariable solverVariable, boolean z11) {
        int iO = o(solverVariable);
        if (iO == -1) {
            return 0.0f;
        }
        q(solverVariable);
        float f11 = this.f6381g[iO];
        if (this.f6385k == iO) {
            this.f6385k = this.f6383i[iO];
        }
        this.f6380f[iO] = -1;
        int[] iArr = this.f6382h;
        int i11 = iArr[iO];
        if (i11 != -1) {
            int[] iArr2 = this.f6383i;
            iArr2[i11] = iArr2[iO];
        }
        int i12 = this.f6383i[iO];
        if (i12 != -1) {
            iArr[i12] = iArr[iO];
        }
        this.f6384j--;
        solverVariable.f6319n--;
        if (z11) {
            solverVariable.d(this.f6386l);
        }
        return f11;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float f(b bVar, boolean z11) {
        float fI = i(bVar.f6336a);
        e(bVar.f6336a, z11);
        h hVar = (h) bVar.f6340e;
        int currentSize = hVar.getCurrentSize();
        int i11 = 0;
        int i12 = 0;
        while (i11 < currentSize) {
            int i13 = hVar.f6380f[i12];
            if (i13 != -1) {
                c(this.f6387m.f6345d[i13], hVar.f6381g[i12] * fI, z11);
                i11++;
            }
            i12++;
        }
        return fI;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void g(SolverVariable solverVariable, float f11) {
        float f12 = f6374n;
        if (f11 > (-f12) && f11 < f12) {
            e(solverVariable, true);
            return;
        }
        if (this.f6384j == 0) {
            l(0, solverVariable, f11);
            k(solverVariable, 0);
            this.f6385k = 0;
            return;
        }
        int iO = o(solverVariable);
        if (iO != -1) {
            this.f6381g[iO] = f11;
            return;
        }
        if (this.f6384j + 1 >= this.f6376b) {
            n();
        }
        int i11 = this.f6384j;
        int i12 = this.f6385k;
        int i13 = -1;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = this.f6380f[i12];
            int i16 = solverVariable.f6309c;
            if (i15 == i16) {
                this.f6381g[i12] = f11;
                return;
            }
            if (i15 < i16) {
                i13 = i12;
            }
            i12 = this.f6383i[i12];
            if (i12 == -1) {
                break;
            }
        }
        p(i13, solverVariable, f11);
    }

    @Override // androidx.constraintlayout.core.b.a
    public int getCurrentSize() {
        return this.f6384j;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float h(int i11) {
        int i12 = this.f6384j;
        int i13 = this.f6385k;
        for (int i14 = 0; i14 < i12; i14++) {
            if (i14 == i11) {
                return this.f6381g[i13];
            }
            i13 = this.f6383i[i13];
            if (i13 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float i(SolverVariable solverVariable) {
        int iO = o(solverVariable);
        if (iO != -1) {
            return this.f6381g[iO];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void j(float f11) {
        int i11 = this.f6384j;
        int i12 = this.f6385k;
        for (int i13 = 0; i13 < i11; i13++) {
            float[] fArr = this.f6381g;
            fArr[i12] = fArr[i12] / f11;
            i12 = this.f6383i[i12];
            if (i12 == -1) {
                return;
            }
        }
    }

    public final void k(SolverVariable solverVariable, int i11) {
        int[] iArr;
        int i12 = solverVariable.f6309c % this.f6377c;
        int[] iArr2 = this.f6378d;
        int i13 = iArr2[i12];
        if (i13 == -1) {
            iArr2[i12] = i11;
        } else {
            while (true) {
                iArr = this.f6379e;
                int i14 = iArr[i13];
                if (i14 == -1) {
                    break;
                } else {
                    i13 = i14;
                }
            }
            iArr[i13] = i11;
        }
        this.f6379e[i11] = -1;
    }

    public final void l(int i11, SolverVariable solverVariable, float f11) {
        this.f6380f[i11] = solverVariable.f6309c;
        this.f6381g[i11] = f11;
        this.f6382h[i11] = -1;
        this.f6383i[i11] = -1;
        solverVariable.a(this.f6386l);
        solverVariable.f6319n++;
        this.f6384j++;
    }

    public final int m() {
        for (int i11 = 0; i11 < this.f6376b; i11++) {
            if (this.f6380f[i11] == -1) {
                return i11;
            }
        }
        return -1;
    }

    public final void n() {
        int i11 = this.f6376b * 2;
        this.f6380f = Arrays.copyOf(this.f6380f, i11);
        this.f6381g = Arrays.copyOf(this.f6381g, i11);
        this.f6382h = Arrays.copyOf(this.f6382h, i11);
        this.f6383i = Arrays.copyOf(this.f6383i, i11);
        this.f6379e = Arrays.copyOf(this.f6379e, i11);
        for (int i12 = this.f6376b; i12 < i11; i12++) {
            this.f6380f[i12] = -1;
            this.f6379e[i12] = -1;
        }
        this.f6376b = i11;
    }

    public int o(SolverVariable solverVariable) {
        if (this.f6384j != 0 && solverVariable != null) {
            int i11 = solverVariable.f6309c;
            int i12 = this.f6378d[i11 % this.f6377c];
            if (i12 == -1) {
                return -1;
            }
            if (this.f6380f[i12] == i11) {
                return i12;
            }
            do {
                i12 = this.f6379e[i12];
                if (i12 == -1) {
                    break;
                }
            } while (this.f6380f[i12] != i11);
            if (i12 != -1 && this.f6380f[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }

    public final void p(int i11, SolverVariable solverVariable, float f11) {
        int iM = m();
        l(iM, solverVariable, f11);
        if (i11 != -1) {
            this.f6382h[iM] = i11;
            int[] iArr = this.f6383i;
            iArr[iM] = iArr[i11];
            iArr[i11] = iM;
        } else {
            this.f6382h[iM] = -1;
            if (this.f6384j > 0) {
                this.f6383i[iM] = this.f6385k;
                this.f6385k = iM;
            } else {
                this.f6383i[iM] = -1;
            }
        }
        int i12 = this.f6383i[iM];
        if (i12 != -1) {
            this.f6382h[i12] = iM;
        }
        k(solverVariable, iM);
    }

    public final void q(SolverVariable solverVariable) {
        int[] iArr;
        int i11;
        int i12 = solverVariable.f6309c;
        int i13 = i12 % this.f6377c;
        int[] iArr2 = this.f6378d;
        int i14 = iArr2[i13];
        if (i14 == -1) {
            return;
        }
        if (this.f6380f[i14] == i12) {
            int[] iArr3 = this.f6379e;
            iArr2[i13] = iArr3[i14];
            iArr3[i14] = -1;
            return;
        }
        while (true) {
            iArr = this.f6379e;
            i11 = iArr[i14];
            if (i11 == -1 || this.f6380f[i11] == i12) {
                break;
            } else {
                i14 = i11;
            }
        }
        if (i11 == -1 || this.f6380f[i11] != i12) {
            return;
        }
        iArr[i14] = iArr[i11];
        iArr[i11] = -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i11 = this.f6384j;
        for (int i12 = 0; i12 < i11; i12++) {
            SolverVariable solverVariableB = b(i12);
            if (solverVariableB != null) {
                String str2 = str + solverVariableB + " = " + h(i12) + " ";
                int iO = o(solverVariableB);
                String str3 = str2 + "[p: ";
                String str4 = (this.f6382h[iO] != -1 ? str3 + this.f6387m.f6345d[this.f6380f[this.f6382h[iO]]] : str3 + DevicePublicKeyStringDef.NONE) + ", n: ";
                str = (this.f6383i[iO] != -1 ? str4 + this.f6387m.f6345d[this.f6380f[this.f6383i[iO]]] : str4 + DevicePublicKeyStringDef.NONE) + "]";
            }
        }
        return str + " }";
    }
}
