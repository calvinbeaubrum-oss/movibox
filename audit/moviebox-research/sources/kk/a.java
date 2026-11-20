package kk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f.a f68612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f.c f68613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f.b f68614c;

    public a(f.a aVar, f.c cVar, f.b bVar) {
        if (aVar == null) {
            throw new NullPointerException("Null appData");
        }
        this.f68612a = aVar;
        if (cVar == null) {
            throw new NullPointerException("Null osData");
        }
        this.f68613b = cVar;
        if (bVar == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.f68614c = bVar;
    }

    @Override // kk.f
    public f.a a() {
        return this.f68612a;
    }

    @Override // kk.f
    public f.b c() {
        return this.f68614c;
    }

    @Override // kk.f
    public f.c d() {
        return this.f68613b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f68612a.equals(fVar.a()) && this.f68613b.equals(fVar.d()) && this.f68614c.equals(fVar.c());
    }

    public int hashCode() {
        return ((((this.f68612a.hashCode() ^ 1000003) * 1000003) ^ this.f68613b.hashCode()) * 1000003) ^ this.f68614c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f68612a + ", osData=" + this.f68613b + ", deviceData=" + this.f68614c + "}";
    }
}
