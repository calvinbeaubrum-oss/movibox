package pl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d implements u10.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f73887a;

    public d(a aVar) {
        this.f73887a = aVar;
    }

    public static d a(a aVar) {
        return new d(aVar);
    }

    public static cl.g c(a aVar) {
        return (cl.g) e10.b.c(aVar.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public cl.g get() {
        return c(this.f73887a);
    }
}
