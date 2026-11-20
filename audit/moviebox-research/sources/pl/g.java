package pl;

import com.google.firebase.perf.session.SessionManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g implements u10.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f73943a;

    public g(a aVar) {
        this.f73943a = aVar;
    }

    public static g a(a aVar) {
        return new g(aVar);
    }

    public static SessionManager c(a aVar) {
        return (SessionManager) e10.b.c(aVar.f(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SessionManager get() {
        return c(this.f73943a);
    }
}
