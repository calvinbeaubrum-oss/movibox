package pl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class h implements u10.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f73944a;

    public h(a aVar) {
        this.f73944a = aVar;
    }

    public static h a(a aVar) {
        return new h(aVar);
    }

    public static bl.b<cg.h> c(a aVar) {
        return (bl.b) e10.b.c(aVar.g(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public bl.b<cg.h> get() {
        return c(this.f73944a);
    }
}
