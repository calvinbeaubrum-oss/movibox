package kn;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.mmadbridge.adsession.AdSessionContextType;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.internal.h;
import com.iab.omid.library.mmadbridge.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g extends b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f68657k = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f68658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f68659b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public pn.a f68661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AdSessionStatePublisher f68662e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f68666i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f68667j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.iab.omid.library.mmadbridge.internal.e> f68660c = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f68663f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f68664g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f68665h = UUID.randomUUID().toString();

    public g(c cVar, d dVar) {
        this.f68659b = cVar;
        this.f68658a = dVar;
        r(null);
        this.f68662e = (dVar.c() == AdSessionContextType.HTML || dVar.c() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.mmadbridge.publisher.a(dVar.j()) : new com.iab.omid.library.mmadbridge.publisher.b(dVar.f(), dVar.g());
        this.f68662e.w();
        com.iab.omid.library.mmadbridge.internal.c.e().b(this);
        this.f68662e.j(cVar);
    }

    public static void i(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    public void A() {
        h();
        w().u();
        this.f68666i = true;
    }

    @Override // kn.b
    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.f68664g) {
            return;
        }
        i(view);
        j(str);
        if (m(view) == null) {
            this.f68660c.add(new com.iab.omid.library.mmadbridge.internal.e(view, friendlyObstructionPurpose, str));
        }
    }

    @Override // kn.b
    public void c() {
        if (this.f68664g) {
            return;
        }
        this.f68661d.clear();
        e();
        this.f68664g = true;
        w().t();
        com.iab.omid.library.mmadbridge.internal.c.e().d(this);
        w().o();
        this.f68662e = null;
    }

    @Override // kn.b
    public void d(View view) {
        if (this.f68664g) {
            return;
        }
        nn.g.c(view, "AdView is null");
        if (o() == view) {
            return;
        }
        r(view);
        w().a();
        p(view);
    }

    @Override // kn.b
    public void e() {
        if (this.f68664g) {
            return;
        }
        this.f68660c.clear();
    }

    @Override // kn.b
    public void f(View view) {
        if (this.f68664g) {
            return;
        }
        i(view);
        com.iab.omid.library.mmadbridge.internal.e eVarM = m(view);
        if (eVarM != null) {
            this.f68660c.remove(eVarM);
        }
    }

    @Override // kn.b
    public void g() {
        if (this.f68663f) {
            return;
        }
        this.f68663f = true;
        com.iab.omid.library.mmadbridge.internal.c.e().f(this);
        this.f68662e.b(h.d().c());
        this.f68662e.h(com.iab.omid.library.mmadbridge.internal.a.a().c());
        this.f68662e.k(this, this.f68658a);
    }

    public final void h() {
        if (this.f68666i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    public final void j(String str) {
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!f68657k.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
    }

    public void k(List<pn.a> list) {
        if (s()) {
            ArrayList arrayList = new ArrayList();
            Iterator<pn.a> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            throw null;
        }
    }

    public void l(@NonNull JSONObject jSONObject) {
        n();
        w().m(jSONObject);
        this.f68667j = true;
    }

    public final com.iab.omid.library.mmadbridge.internal.e m(View view) {
        for (com.iab.omid.library.mmadbridge.internal.e eVar : this.f68660c) {
            if (eVar.c().get() == view) {
                return eVar;
            }
        }
        return null;
    }

    public final void n() {
        if (this.f68667j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    public View o() {
        return this.f68661d.get();
    }

    public final void p(View view) {
        Collection<g> collectionC = com.iab.omid.library.mmadbridge.internal.c.e().c();
        if (collectionC == null || collectionC.isEmpty()) {
            return;
        }
        for (g gVar : collectionC) {
            if (gVar != this && gVar.o() == view) {
                gVar.f68661d.clear();
            }
        }
    }

    public List<com.iab.omid.library.mmadbridge.internal.e> q() {
        return this.f68660c;
    }

    public final void r(View view) {
        this.f68661d = new pn.a(view);
    }

    public boolean s() {
        return false;
    }

    public boolean t() {
        return this.f68663f && !this.f68664g;
    }

    public boolean u() {
        return this.f68664g;
    }

    public String v() {
        return this.f68665h;
    }

    public AdSessionStatePublisher w() {
        return this.f68662e;
    }

    public boolean x() {
        return this.f68659b.b();
    }

    public boolean y() {
        return this.f68659b.c();
    }

    public boolean z() {
        return this.f68663f;
    }
}
