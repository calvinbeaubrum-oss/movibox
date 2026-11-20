package x20;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f79861a;

    public b(c cVar) {
        a(cVar);
    }

    public void a(c cVar) {
        if (this.f79861a != null) {
            throw new IllegalStateException("The Not ResourceSelector accepts a single nested ResourceSelector");
        }
        this.f79861a = cVar;
    }
}
