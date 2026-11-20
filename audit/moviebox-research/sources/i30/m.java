package i30;

import com.alibaba.sdk.android.oss.common.RequestParameters;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class m extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f66983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f66984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f66985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f66986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f66987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f66988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f66989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f66990j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f66991k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f66992l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f66993m;

    public m(x xVar, int i11, String str, String str2, String str3, Object obj) {
        super(458752);
        this.f66983c = xVar;
        this.f66984d = i11;
        this.f66985e = xVar.D(str);
        this.f66986f = xVar.D(str2);
        if (str3 != null) {
            this.f66987g = xVar.D(str3);
        }
        if (obj != null) {
            this.f66988h = xVar.d(obj).f67083a;
        }
    }

    @Override // i30.l
    public a a(String str, boolean z11) {
        d dVar = new d();
        dVar.k(this.f66983c.D(str)).k(0);
        if (z11) {
            b bVar = new b(this.f66983c, dVar, this.f66989i);
            this.f66989i = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f66983c, dVar, this.f66990j);
        this.f66990j = bVar2;
        return bVar2;
    }

    @Override // i30.l
    public void b(c cVar) {
        cVar.f66917c = this.f66993m;
        this.f66993m = cVar;
    }

    @Override // i30.l
    public void c() {
    }

    @Override // i30.l
    public a d(int i11, z zVar, String str, boolean z11) {
        d dVar = new d();
        a0.a(i11, dVar);
        z.d(zVar, dVar);
        dVar.k(this.f66983c.D(str)).k(0);
        if (z11) {
            b bVar = new b(this.f66983c, dVar, this.f66991k);
            this.f66991k = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f66983c, dVar, this.f66992l);
        this.f66992l = bVar2;
        return bVar2;
    }

    public final void e(c.a aVar) {
        aVar.b(this.f66993m);
    }

    public int f() {
        int iF;
        if (this.f66988h != 0) {
            this.f66983c.D("ConstantValue");
            iF = 16;
        } else {
            iF = 8;
        }
        if ((this.f66984d & 4096) != 0 && this.f66983c.R() < 49) {
            this.f66983c.D("Synthetic");
            iF += 6;
        }
        if (this.f66987g != 0) {
            this.f66983c.D(RequestParameters.SIGNATURE);
            iF += 8;
        }
        if ((this.f66984d & 131072) != 0) {
            this.f66983c.D("Deprecated");
            iF += 6;
        }
        b bVar = this.f66989i;
        if (bVar != null) {
            iF += bVar.f("RuntimeVisibleAnnotations");
        }
        b bVar2 = this.f66990j;
        if (bVar2 != null) {
            iF += bVar2.f("RuntimeInvisibleAnnotations");
        }
        b bVar3 = this.f66991k;
        if (bVar3 != null) {
            iF += bVar3.f("RuntimeVisibleTypeAnnotations");
        }
        b bVar4 = this.f66992l;
        if (bVar4 != null) {
            iF += bVar4.f("RuntimeInvisibleTypeAnnotations");
        }
        c cVar = this.f66993m;
        return cVar != null ? iF + cVar.a(this.f66983c) : iF;
    }

    public void g(d dVar) {
        boolean z11 = this.f66983c.R() < 49;
        dVar.k((~(z11 ? 4096 : 0)) & this.f66984d).k(this.f66985e).k(this.f66986f);
        int iC = this.f66988h == 0 ? 0 : 1;
        int i11 = this.f66984d;
        if ((i11 & 4096) != 0 && z11) {
            iC++;
        }
        if (this.f66987g != 0) {
            iC++;
        }
        if ((i11 & 131072) != 0) {
            iC++;
        }
        if (this.f66989i != null) {
            iC++;
        }
        if (this.f66990j != null) {
            iC++;
        }
        if (this.f66991k != null) {
            iC++;
        }
        if (this.f66992l != null) {
            iC++;
        }
        c cVar = this.f66993m;
        if (cVar != null) {
            iC += cVar.c();
        }
        dVar.k(iC);
        if (this.f66988h != 0) {
            dVar.k(this.f66983c.D("ConstantValue")).i(2).k(this.f66988h);
        }
        if ((4096 & this.f66984d) != 0 && z11) {
            dVar.k(this.f66983c.D("Synthetic")).i(0);
        }
        if (this.f66987g != 0) {
            dVar.k(this.f66983c.D(RequestParameters.SIGNATURE)).i(2).k(this.f66987g);
        }
        if ((this.f66984d & 131072) != 0) {
            dVar.k(this.f66983c.D("Deprecated")).i(0);
        }
        b bVar = this.f66989i;
        if (bVar != null) {
            bVar.h(this.f66983c.D("RuntimeVisibleAnnotations"), dVar);
        }
        b bVar2 = this.f66990j;
        if (bVar2 != null) {
            bVar2.h(this.f66983c.D("RuntimeInvisibleAnnotations"), dVar);
        }
        b bVar3 = this.f66991k;
        if (bVar3 != null) {
            bVar3.h(this.f66983c.D("RuntimeVisibleTypeAnnotations"), dVar);
        }
        b bVar4 = this.f66992l;
        if (bVar4 != null) {
            bVar4.h(this.f66983c.D("RuntimeInvisibleTypeAnnotations"), dVar);
        }
        c cVar2 = this.f66993m;
        if (cVar2 != null) {
            cVar2.e(this.f66983c, dVar);
        }
    }
}
