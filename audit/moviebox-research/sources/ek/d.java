package ek;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f64273a;

    public d() {
        this.f64273a = new a();
    }

    public d(c cVar) {
        this.f64273a = cVar;
    }

    public static d a(c cVar) {
        fk.a.g(cVar, "HTTP context");
        return cVar instanceof d ? (d) cVar : new d(cVar);
    }
}
