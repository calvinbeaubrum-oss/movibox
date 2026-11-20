package vl;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ql.a f78942d = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f78943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bl.b<cg.h> f78944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cg.g<com.google.firebase.perf.v1.g> f78945c;

    public b(bl.b<cg.h> bVar, String str) {
        this.f78943a = str;
        this.f78944b = bVar;
    }

    public final boolean a() {
        if (this.f78945c == null) {
            cg.h hVar = this.f78944b.get();
            if (hVar != null) {
                this.f78945c = hVar.b(this.f78943a, com.google.firebase.perf.v1.g.class, cg.c.b("proto"), new cg.f() { // from class: vl.a
                    @Override // cg.f
                    public final Object apply(Object obj) {
                        return ((com.google.firebase.perf.v1.g) obj).h();
                    }
                });
            } else {
                f78942d.j("Flg TransportFactory is not available at the moment");
            }
        }
        return this.f78945c != null;
    }

    public void b(@NonNull com.google.firebase.perf.v1.g gVar) {
        if (a()) {
            this.f78945c.a(cg.d.e(gVar));
        } else {
            f78942d.j("Unable to dispatch event because Flg Transport is not available");
        }
    }
}
