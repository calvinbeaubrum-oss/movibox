package sn;

import android.view.View;
import com.iab.omid.library.vungle.adsession.AdSessionContextType;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f76432i = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f76433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f76434b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vn.a f76436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AdSessionStatePublisher f76437e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.iab.omid.library.vungle.b.c> f76435c = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f76438f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f76439g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f76440h = UUID.randomUUID().toString();

    public f(b bVar, c cVar) {
        this.f76434b = bVar;
        this.f76433a = cVar;
        f(null);
        this.f76437e = (cVar.b() == AdSessionContextType.HTML || cVar.b() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.vungle.publisher.a(cVar.i()) : new com.iab.omid.library.vungle.publisher.b(cVar.e(), cVar.f());
        this.f76437e.a();
        com.iab.omid.library.vungle.b.a.a().b(this);
        this.f76437e.e(bVar);
    }

    @Override // sn.a
    public void b() {
        if (this.f76439g) {
            return;
        }
        this.f76436d.clear();
        l();
        this.f76439g = true;
        k().l();
        com.iab.omid.library.vungle.b.a.a().f(this);
        k().i();
        this.f76437e = null;
    }

    @Override // sn.a
    public void c(View view) {
        if (this.f76439g) {
            return;
        }
        un.e.c(view, "AdView is null");
        if (g() == view) {
            return;
        }
        f(view);
        k().n();
        h(view);
    }

    @Override // sn.a
    public void d() {
        if (this.f76438f) {
            return;
        }
        this.f76438f = true;
        com.iab.omid.library.vungle.b.a.a().d(this);
        this.f76437e.b(com.iab.omid.library.vungle.b.f.a().e());
        this.f76437e.f(this, this.f76433a);
    }

    public List<com.iab.omid.library.vungle.b.c> e() {
        return this.f76435c;
    }

    public final void f(View view) {
        this.f76436d = new vn.a(view);
    }

    public View g() {
        return this.f76436d.get();
    }

    public final void h(View view) {
        Collection<f> collectionC = com.iab.omid.library.vungle.b.a.a().c();
        if (collectionC == null || collectionC.isEmpty()) {
            return;
        }
        for (f fVar : collectionC) {
            if (fVar != this && fVar.g() == view) {
                fVar.f76436d.clear();
            }
        }
    }

    public boolean i() {
        return this.f76438f && !this.f76439g;
    }

    public String j() {
        return this.f76440h;
    }

    public AdSessionStatePublisher k() {
        return this.f76437e;
    }

    public void l() {
        if (this.f76439g) {
            return;
        }
        this.f76435c.clear();
    }
}
