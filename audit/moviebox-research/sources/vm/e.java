package vm;

import java.util.Formatter;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f79018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f[] f79019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f79020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f79021d;

    public e(a aVar, c cVar) {
        this.f79018a = aVar;
        int iA = aVar.a();
        this.f79021d = iA;
        this.f79020c = cVar;
        this.f79019b = new f[iA + 2];
    }

    public static boolean b(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.i(dVar2.c());
        return true;
    }

    public static int c(int i11, int i12, d dVar) {
        if (dVar == null || dVar.g()) {
            return i12;
        }
        if (!dVar.h(i11)) {
            return i12 + 1;
        }
        dVar.i(i11);
        return 0;
    }

    public final void a(f fVar) {
        if (fVar != null) {
            ((g) fVar).g(this.f79018a);
        }
    }

    public final int d() {
        int iF = f();
        if (iF == 0) {
            return 0;
        }
        for (int i11 = 1; i11 < this.f79021d + 1; i11++) {
            d[] dVarArrD = this.f79019b[i11].d();
            for (int i12 = 0; i12 < dVarArrD.length; i12++) {
                d dVar = dVarArrD[i12];
                if (dVar != null && !dVar.g()) {
                    e(i11, i12, dVarArrD);
                }
            }
        }
        return iF;
    }

    public final void e(int i11, int i12, d[] dVarArr) {
        d dVar = dVarArr[i12];
        d[] dVarArrD = this.f79019b[i11 - 1].d();
        f fVar = this.f79019b[i11 + 1];
        d[] dVarArrD2 = fVar != null ? fVar.d() : dVarArrD;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = dVarArrD[i12];
        dVarArr2[3] = dVarArrD2[i12];
        if (i12 > 0) {
            int i13 = i12 - 1;
            dVarArr2[0] = dVarArr[i13];
            dVarArr2[4] = dVarArrD[i13];
            dVarArr2[5] = dVarArrD2[i13];
        }
        if (i12 > 1) {
            int i14 = i12 - 2;
            dVarArr2[8] = dVarArr[i14];
            dVarArr2[10] = dVarArrD[i14];
            dVarArr2[11] = dVarArrD2[i14];
        }
        if (i12 < dVarArr.length - 1) {
            int i15 = i12 + 1;
            dVarArr2[1] = dVarArr[i15];
            dVarArr2[6] = dVarArrD[i15];
            dVarArr2[7] = dVarArrD2[i15];
        }
        if (i12 < dVarArr.length - 2) {
            int i16 = i12 + 2;
            dVarArr2[9] = dVarArr[i16];
            dVarArr2[12] = dVarArrD[i16];
            dVarArr2[13] = dVarArrD2[i16];
        }
        for (int i17 = 0; i17 < 14 && !b(dVar, dVarArr2[i17]); i17++) {
        }
    }

    public final int f() {
        g();
        return h() + i();
    }

    public final void g() {
        f[] fVarArr = this.f79019b;
        f fVar = fVarArr[0];
        if (fVar == null || fVarArr[this.f79021d + 1] == null) {
            return;
        }
        d[] dVarArrD = fVar.d();
        d[] dVarArrD2 = this.f79019b[this.f79021d + 1].d();
        for (int i11 = 0; i11 < dVarArrD.length; i11++) {
            d dVar = dVarArrD[i11];
            if (dVar != null && dVarArrD2[i11] != null && dVar.c() == dVarArrD2[i11].c()) {
                for (int i12 = 1; i12 <= this.f79021d; i12++) {
                    d dVar2 = this.f79019b[i12].d()[i11];
                    if (dVar2 != null) {
                        dVar2.i(dVarArrD[i11].c());
                        if (!dVar2.g()) {
                            this.f79019b[i12].d()[i11] = null;
                        }
                    }
                }
            }
        }
    }

    public final int h() {
        f fVar = this.f79019b[0];
        if (fVar == null) {
            return 0;
        }
        d[] dVarArrD = fVar.d();
        int i11 = 0;
        for (int i12 = 0; i12 < dVarArrD.length; i12++) {
            d dVar = dVarArrD[i12];
            if (dVar != null) {
                int iC = dVar.c();
                int iC2 = 0;
                for (int i13 = 1; i13 < this.f79021d + 1 && iC2 < 2; i13++) {
                    d dVar2 = this.f79019b[i13].d()[i12];
                    if (dVar2 != null) {
                        iC2 = c(iC, iC2, dVar2);
                        if (!dVar2.g()) {
                            i11++;
                        }
                    }
                }
            }
        }
        return i11;
    }

    public final int i() {
        f[] fVarArr = this.f79019b;
        int i11 = this.f79021d;
        if (fVarArr[i11 + 1] == null) {
            return 0;
        }
        d[] dVarArrD = fVarArr[i11 + 1].d();
        int i12 = 0;
        for (int i13 = 0; i13 < dVarArrD.length; i13++) {
            d dVar = dVarArrD[i13];
            if (dVar != null) {
                int iC = dVar.c();
                int iC2 = 0;
                for (int i14 = this.f79021d + 1; i14 > 0 && iC2 < 2; i14--) {
                    d dVar2 = this.f79019b[i14].d()[i13];
                    if (dVar2 != null) {
                        iC2 = c(iC, iC2, dVar2);
                        if (!dVar2.g()) {
                            i12++;
                        }
                    }
                }
            }
        }
        return i12;
    }

    public int j() {
        return this.f79021d;
    }

    public int k() {
        return this.f79018a.b();
    }

    public int l() {
        return this.f79018a.c();
    }

    public c m() {
        return this.f79020c;
    }

    public f n(int i11) {
        return this.f79019b[i11];
    }

    public f[] o() {
        a(this.f79019b[0]);
        a(this.f79019b[this.f79021d + 1]);
        int i11 = 928;
        while (true) {
            int iD = d();
            if (iD <= 0 || iD >= i11) {
                break;
            }
            i11 = iD;
        }
        return this.f79019b;
    }

    public void p(c cVar) {
        this.f79020c = cVar;
    }

    public void q(int i11, f fVar) {
        this.f79019b[i11] = fVar;
    }

    public String toString() {
        f[] fVarArr = this.f79019b;
        f fVar = fVarArr[0];
        if (fVar == null) {
            fVar = fVarArr[this.f79021d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i11 = 0; i11 < fVar.d().length; i11++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i11));
                for (int i12 = 0; i12 < this.f79021d + 2; i12++) {
                    f fVar2 = this.f79019b[i12];
                    if (fVar2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = fVar2.d()[i11];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
