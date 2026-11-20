package ol;

import cg.h;
import cl.g;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;
import jj.e;
import ll.c;
import pl.d;
import pl.f;
import yl.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements ol.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u10.a<e> f72479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u10.a<bl.b<m>> f72480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u10.a<g> f72481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u10.a<bl.b<h>> f72482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u10.a<RemoteConfigManager> f72483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u10.a<nl.a> f72484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public u10.a<SessionManager> f72485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public u10.a<c> f72486h;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public pl.a f72487a;

        public b() {
        }

        public ol.b a() {
            e10.b.a(this.f72487a, pl.a.class);
            return new a(this.f72487a);
        }

        public b b(pl.a aVar) {
            this.f72487a = (pl.a) e10.b.b(aVar);
            return this;
        }
    }

    public a(pl.a aVar) {
        c(aVar);
    }

    public static b b() {
        return new b();
    }

    @Override // ol.b
    public c a() {
        return this.f72486h.get();
    }

    public final void c(pl.a aVar) {
        this.f72479a = pl.c.a(aVar);
        this.f72480b = pl.e.a(aVar);
        this.f72481c = d.a(aVar);
        this.f72482d = pl.h.a(aVar);
        this.f72483e = f.a(aVar);
        this.f72484f = pl.b.a(aVar);
        pl.g gVarA = pl.g.a(aVar);
        this.f72485g = gVarA;
        this.f72486h = e10.a.a(ll.e.a(this.f72479a, this.f72480b, this.f72481c, this.f72482d, this.f72483e, this.f72484f, gVarA));
    }
}
