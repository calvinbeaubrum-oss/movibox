package i30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class u extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f67059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f67060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f67061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f67062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f67063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f67064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f67065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f67066j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f67067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f67068l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f67069m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f67070n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f67071o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f67072p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f67073q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d f67074r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f67075s;

    public u(x xVar, int i11, int i12, int i13) {
        super(458752);
        this.f67059c = xVar;
        this.f67060d = i11;
        this.f67061e = i12;
        this.f67062f = i13;
        this.f67064h = new d();
        this.f67066j = new d();
        this.f67068l = new d();
        this.f67070n = new d();
        this.f67072p = new d();
        this.f67074r = new d();
    }

    @Override // i30.t
    public void a() {
    }

    @Override // i30.t
    public void b(String str, int i11, String... strArr) {
        this.f67066j.k(this.f67059c.B(str).f67083a).k(i11);
        if (strArr == null) {
            this.f67066j.k(0);
        } else {
            this.f67066j.k(strArr.length);
            for (String str2 : strArr) {
                this.f67066j.k(this.f67059c.y(str2).f67083a);
            }
        }
        this.f67065i++;
    }

    @Override // i30.t
    public void c(String str) {
        this.f67075s = this.f67059c.e(str).f67083a;
    }

    @Override // i30.t
    public void d(String str, int i11, String... strArr) {
        this.f67068l.k(this.f67059c.B(str).f67083a).k(i11);
        if (strArr == null) {
            this.f67068l.k(0);
        } else {
            this.f67068l.k(strArr.length);
            for (String str2 : strArr) {
                this.f67068l.k(this.f67059c.y(str2).f67083a);
            }
        }
        this.f67067k++;
    }

    @Override // i30.t
    public void e(String str) {
        this.f67074r.k(this.f67059c.B(str).f67083a);
        this.f67073q++;
    }

    @Override // i30.t
    public void f(String str, String... strArr) {
        this.f67072p.k(this.f67059c.e(str).f67083a);
        this.f67072p.k(strArr.length);
        for (String str2 : strArr) {
            this.f67072p.k(this.f67059c.e(str2).f67083a);
        }
        this.f67071o++;
    }

    @Override // i30.t
    public void g(String str, int i11, String str2) {
        this.f67064h.k(this.f67059c.y(str).f67083a).k(i11).k(str2 == null ? 0 : this.f67059c.D(str2));
        this.f67063g++;
    }

    @Override // i30.t
    public void h(String str) {
        this.f67070n.k(this.f67059c.e(str).f67083a);
        this.f67069m++;
    }

    public int i() {
        this.f67059c.D("Module");
        int i11 = this.f67064h.f66921b + 22 + this.f67066j.f66921b + this.f67068l.f66921b + this.f67070n.f66921b + this.f67072p.f66921b;
        if (this.f67073q > 0) {
            this.f67059c.D("ModulePackages");
            i11 += this.f67074r.f66921b + 8;
        }
        if (this.f67075s <= 0) {
            return i11;
        }
        this.f67059c.D("ModuleMainClass");
        return i11 + 8;
    }

    public int j() {
        return (this.f67073q > 0 ? 1 : 0) + 1 + (this.f67075s > 0 ? 1 : 0);
    }

    public void k(d dVar) {
        d dVarK = dVar.k(this.f67059c.D("Module")).i(this.f67064h.f66921b + 16 + this.f67066j.f66921b + this.f67068l.f66921b + this.f67070n.f66921b + this.f67072p.f66921b).k(this.f67060d).k(this.f67061e).k(this.f67062f).k(this.f67063g);
        d dVar2 = this.f67064h;
        d dVarK2 = dVarK.h(dVar2.f66920a, 0, dVar2.f66921b).k(this.f67065i);
        d dVar3 = this.f67066j;
        d dVarK3 = dVarK2.h(dVar3.f66920a, 0, dVar3.f66921b).k(this.f67067k);
        d dVar4 = this.f67068l;
        d dVarK4 = dVarK3.h(dVar4.f66920a, 0, dVar4.f66921b).k(this.f67069m);
        d dVar5 = this.f67070n;
        d dVarK5 = dVarK4.h(dVar5.f66920a, 0, dVar5.f66921b).k(this.f67071o);
        d dVar6 = this.f67072p;
        dVarK5.h(dVar6.f66920a, 0, dVar6.f66921b);
        if (this.f67073q > 0) {
            d dVarK6 = dVar.k(this.f67059c.D("ModulePackages")).i(this.f67074r.f66921b + 2).k(this.f67073q);
            d dVar7 = this.f67074r;
            dVarK6.h(dVar7.f66920a, 0, dVar7.f66921b);
        }
        if (this.f67075s > 0) {
            dVar.k(this.f67059c.D("ModuleMainClass")).i(2).k(this.f67075s);
        }
    }
}
