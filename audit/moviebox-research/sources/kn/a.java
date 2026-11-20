package kn;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f68638a;

    public a(g gVar) {
        this.f68638a = gVar;
    }

    public static a a(b bVar) {
        g gVar = (g) bVar;
        nn.g.c(bVar, "AdSession is null");
        nn.g.l(gVar);
        nn.g.g(gVar);
        a aVar = new a(gVar);
        gVar.w().i(aVar);
        return aVar;
    }

    public void b() {
        nn.g.g(this.f68638a);
        nn.g.j(this.f68638a);
        if (!this.f68638a.t()) {
            try {
                this.f68638a.g();
            } catch (Exception unused) {
            }
        }
        if (this.f68638a.t()) {
            this.f68638a.A();
        }
    }

    public void c(@NonNull com.iab.omid.library.mmadbridge.adsession.media.b bVar) {
        nn.g.c(bVar, "VastProperties is null");
        nn.g.f(this.f68638a);
        nn.g.j(this.f68638a);
        this.f68638a.l(bVar.a());
    }
}
