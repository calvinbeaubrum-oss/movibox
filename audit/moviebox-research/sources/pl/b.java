package pl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements u10.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f73885a;

    public b(a aVar) {
        this.f73885a = aVar;
    }

    public static b a(a aVar) {
        return new b(aVar);
    }

    public static nl.a c(a aVar) {
        return (nl.a) e10.b.c(aVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public nl.a get() {
        return c(this.f73885a);
    }
}
