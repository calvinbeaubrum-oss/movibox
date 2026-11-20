package q2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m {
    public static float a(n nVar, long j11) {
        r2.a aVarB;
        if (!y.g(w.g(j11), y.f74261b.b())) {
            o.b("Only Sp can convert to Px");
        }
        r2.b bVar = r2.b.f75090a;
        if (bVar.f(nVar.M0()) && (aVarB = bVar.b(nVar.M0())) != null) {
            return i.h(aVarB.b(w.h(j11)));
        }
        return i.h(w.h(j11) * nVar.M0());
    }

    public static long b(n nVar, float f11) {
        r2.b bVar = r2.b.f75090a;
        if (!bVar.f(nVar.M0())) {
            return x.b(f11 / nVar.M0());
        }
        r2.a aVarB = bVar.b(nVar.M0());
        return x.b(aVarB != null ? aVarB.a(f11) : f11 / nVar.M0());
    }
}
