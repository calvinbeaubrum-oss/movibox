package k7;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f68475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f68476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f68478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f68479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f68480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f68481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f68482h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f68483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f68484j;

    public i(c cVar, int i11, String str, String str2, String str3, String[] strArr) {
        if (cVar.f68451q == null) {
            cVar.f68451q = this;
        } else {
            cVar.f68452r.f68475a = this;
        }
        cVar.f68452r = this;
        this.f68476b = cVar;
        this.f68477c = i11;
        this.f68478d = cVar.h(str);
        this.f68479e = cVar.h(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.f68480f = length;
        this.f68481g = new int[length];
        for (int i12 = 0; i12 < this.f68480f; i12++) {
            this.f68481g[i12] = cVar.b(strArr[i12]).f68457a;
        }
    }

    @Override // k7.h
    public void a(int i11, String str, String str2, String str3) {
        this.f68482h.c(i11, this.f68476b.d(str, str2, str3).f68457a);
    }

    @Override // k7.h
    public void b(int i11, f fVar) {
        if ((fVar.f68466a & 2) != 0 && fVar.f68467b - this.f68482h.f68428b < -32768) {
            throw new UnsupportedOperationException();
        }
        this.f68482h.d(i11);
        a aVar = this.f68482h;
        fVar.b(this, aVar, aVar.f68428b - 1, i11 == 200);
    }

    @Override // k7.h
    public void c(int i11, int i12) {
        if (i12 < 4 && i11 != 169) {
            this.f68482h.d((i11 < 54 ? ((i11 - 21) << 2) + 26 : ((i11 - 54) << 2) + 59) + i12);
        } else if (i12 >= 256) {
            this.f68482h.d(196).c(i11, i12);
        } else {
            this.f68482h.b(i11, i12);
        }
    }

    @Override // k7.h
    public void d(Object obj) {
        e eVarC = this.f68476b.c(obj);
        int i11 = eVarC.f68457a;
        int i12 = eVarC.f68458b;
        if (i12 == 5 || i12 == 6) {
            this.f68482h.c(20, i11);
        } else if (i11 >= 256) {
            this.f68482h.c(19, i11);
        } else {
            this.f68482h.b(18, i11);
        }
    }

    @Override // k7.h
    public void e(f fVar) {
        a aVar = this.f68482h;
        fVar.c(this, aVar.f68428b, aVar.f68427a);
    }

    @Override // k7.h
    public void f(int i11, int i12) {
        this.f68482h.d(132).b(i11, i12);
    }

    @Override // k7.h
    public void g(int i11, String str) {
        this.f68482h.c(i11, this.f68476b.b(str).f68457a);
    }

    @Override // k7.h
    public void h(int i11, int i12) {
        this.f68482h.b(i11, i12);
    }

    @Override // k7.h
    public void i(int i11) {
        this.f68482h.d(i11);
    }

    @Override // k7.h
    public void j(int i11, int i12) {
        this.f68483i = i11;
        this.f68484j = i12;
    }

    @Override // k7.h
    public void k(int i11, String str, String str2, String str3) {
        boolean z11 = i11 == 185;
        e eVarE = this.f68476b.e(str, str2, str3, z11);
        int iB = eVarE.f68459c;
        if (!z11) {
            this.f68482h.c(i11, eVarE.f68457a);
            return;
        }
        if (iB == 0) {
            iB = j.b(str3);
            eVarE.f68459c = iB;
        }
        this.f68482h.c(185, eVarE.f68457a).b(iB >> 2, 0);
    }

    @Override // k7.h
    public void l() {
    }

    public final int m() {
        int i11;
        if (this.f68482h.f68428b > 0) {
            this.f68476b.h("Code");
            i11 = this.f68482h.f68428b + 26;
        } else {
            i11 = 8;
        }
        if (this.f68480f <= 0) {
            return i11;
        }
        this.f68476b.h("Exceptions");
        return i11 + (this.f68480f * 2) + 8;
    }

    public final void n(a aVar) {
        aVar.g(this.f68477c & (-393217)).g(this.f68478d).g(this.f68479e);
        int i11 = this.f68482h.f68428b > 0 ? 1 : 0;
        if (this.f68480f > 0) {
            i11++;
        }
        aVar.g(i11);
        int i12 = this.f68482h.f68428b;
        if (i12 > 0) {
            aVar.g(this.f68476b.h("Code")).f(i12 + 12);
            aVar.g(this.f68483i).g(this.f68484j);
            a aVarF = aVar.f(this.f68482h.f68428b);
            a aVar2 = this.f68482h;
            aVarF.e(aVar2.f68427a, 0, aVar2.f68428b);
            aVar.g(0);
            aVar.g(0);
        }
        if (this.f68480f > 0) {
            aVar.g(this.f68476b.h("Exceptions")).f((this.f68480f * 2) + 2);
            aVar.g(this.f68480f);
            for (int i13 = 0; i13 < this.f68480f; i13++) {
                aVar.g(this.f68481g[i13]);
            }
        }
    }
}
