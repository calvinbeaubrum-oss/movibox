package k7;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f68453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f68455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f68456d;

    public d(c cVar, int i11, String str, String str2) {
        if (cVar.f68449o == null) {
            cVar.f68449o = this;
        } else {
            cVar.f68450p.f68453a = this;
        }
        cVar.f68450p = this;
        this.f68454b = i11;
        this.f68455c = cVar.h(str);
        this.f68456d = cVar.h(str2);
    }

    public int a() {
        return 8;
    }

    public void b(a aVar) {
        aVar.g(this.f68454b & (-393217)).g(this.f68455c).g(this.f68456d);
        aVar.g(0);
    }

    public void c() {
    }
}
