package i30;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f67008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f67009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f67010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f67011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f67012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f67013f;

    public p(p pVar, q qVar, q qVar2) {
        this(qVar, qVar2, pVar.f67010c, pVar.f67011d, pVar.f67012e);
        this.f67013f = pVar.f67013f;
    }

    public p(q qVar, q qVar2, q qVar3, int i11, String str) {
        this.f67008a = qVar;
        this.f67009b = qVar2;
        this.f67010c = qVar3;
        this.f67011d = i11;
        this.f67012e = str;
    }

    public static int a(p pVar) {
        int i11 = 0;
        while (pVar != null) {
            i11++;
            pVar = pVar.f67013f;
        }
        return i11;
    }

    public static int b(p pVar) {
        return (a(pVar) * 8) + 2;
    }

    public static void c(p pVar, d dVar) {
        dVar.k(a(pVar));
        while (pVar != null) {
            dVar.k(pVar.f67008a.f67018d).k(pVar.f67009b.f67018d).k(pVar.f67010c.f67018d).k(pVar.f67011d);
            pVar = pVar.f67013f;
        }
    }

    public static p d(p pVar, q qVar, q qVar2) {
        if (pVar == null) {
            return null;
        }
        p pVarD = d(pVar.f67013f, qVar, qVar2);
        pVar.f67013f = pVarD;
        q qVar3 = pVar.f67008a;
        int i11 = qVar3.f67018d;
        q qVar4 = pVar.f67009b;
        int i12 = qVar4.f67018d;
        int i13 = qVar.f67018d;
        int i14 = qVar2 == null ? Api.BaseClientBuilder.API_PRIORITY_OTHER : qVar2.f67018d;
        if (i13 >= i12 || i14 <= i11) {
            return pVar;
        }
        if (i13 <= i11) {
            return i14 >= i12 ? pVarD : new p(pVar, qVar2, qVar4);
        }
        if (i14 >= i12) {
            return new p(pVar, qVar3, qVar);
        }
        pVar.f67013f = new p(pVar, qVar2, qVar4);
        return new p(pVar, pVar.f67008a, qVar);
    }
}
