package vm;

import java.util.Formatter;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f79022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d[] f79023b;

    public f(c cVar) {
        this.f79022a = new c(cVar);
        this.f79023b = new d[(cVar.e() - cVar.g()) + 1];
    }

    public final c a() {
        return this.f79022a;
    }

    public final d b(int i11) {
        return this.f79023b[e(i11)];
    }

    public final d c(int i11) {
        d dVar;
        d dVar2;
        d dVarB = b(i11);
        if (dVarB != null) {
            return dVarB;
        }
        for (int i12 = 1; i12 < 5; i12++) {
            int iE = e(i11) - i12;
            if (iE >= 0 && (dVar2 = this.f79023b[iE]) != null) {
                return dVar2;
            }
            int iE2 = e(i11) + i12;
            d[] dVarArr = this.f79023b;
            if (iE2 < dVarArr.length && (dVar = dVarArr[iE2]) != null) {
                return dVar;
            }
        }
        return null;
    }

    public final d[] d() {
        return this.f79023b;
    }

    public final int e(int i11) {
        return i11 - this.f79022a.g();
    }

    public final void f(int i11, d dVar) {
        this.f79023b[e(i11)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i11 = 0;
            for (d dVar : this.f79023b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i11));
                    i11++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i11), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i11++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th2) {
            try {
                formatter.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }
}
