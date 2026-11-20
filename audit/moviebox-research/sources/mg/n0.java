package mg;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n0 implements gg.b<m0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<og.a> f71065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u10.a<og.a> f71066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u10.a<e> f71067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u10.a<u0> f71068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u10.a<String> f71069e;

    public n0(u10.a<og.a> aVar, u10.a<og.a> aVar2, u10.a<e> aVar3, u10.a<u0> aVar4, u10.a<String> aVar5) {
        this.f71065a = aVar;
        this.f71066b = aVar2;
        this.f71067c = aVar3;
        this.f71068d = aVar4;
        this.f71069e = aVar5;
    }

    public static n0 a(u10.a<og.a> aVar, u10.a<og.a> aVar2, u10.a<e> aVar3, u10.a<u0> aVar4, u10.a<String> aVar5) {
        return new n0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static m0 c(og.a aVar, og.a aVar2, Object obj, Object obj2, u10.a<String> aVar3) {
        return new m0(aVar, aVar2, (e) obj, (u0) obj2, aVar3);
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c(this.f71065a.get(), this.f71066b.get(), this.f71067c.get(), this.f71068d.get(), this.f71069e);
    }
}
