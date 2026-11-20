package pl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c implements u10.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f73886a;

    public c(a aVar) {
        this.f73886a = aVar;
    }

    public static c a(a aVar) {
        return new c(aVar);
    }

    public static jj.e c(a aVar) {
        return (jj.e) e10.b.c(aVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public jj.e get() {
        return c(this.f73886a);
    }
}
