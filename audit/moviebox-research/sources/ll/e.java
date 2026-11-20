package ll;

import cg.h;
import cl.g;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;
import yl.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e implements u10.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<jj.e> f70317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u10.a<bl.b<m>> f70318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u10.a<g> f70319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u10.a<bl.b<h>> f70320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u10.a<RemoteConfigManager> f70321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u10.a<nl.a> f70322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u10.a<SessionManager> f70323g;

    public e(u10.a<jj.e> aVar, u10.a<bl.b<m>> aVar2, u10.a<g> aVar3, u10.a<bl.b<h>> aVar4, u10.a<RemoteConfigManager> aVar5, u10.a<nl.a> aVar6, u10.a<SessionManager> aVar7) {
        this.f70317a = aVar;
        this.f70318b = aVar2;
        this.f70319c = aVar3;
        this.f70320d = aVar4;
        this.f70321e = aVar5;
        this.f70322f = aVar6;
        this.f70323g = aVar7;
    }

    public static e a(u10.a<jj.e> aVar, u10.a<bl.b<m>> aVar2, u10.a<g> aVar3, u10.a<bl.b<h>> aVar4, u10.a<RemoteConfigManager> aVar5, u10.a<nl.a> aVar6, u10.a<SessionManager> aVar7) {
        return new e(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static c c(jj.e eVar, bl.b<m> bVar, g gVar, bl.b<h> bVar2, RemoteConfigManager remoteConfigManager, nl.a aVar, SessionManager sessionManager) {
        return new c(eVar, bVar, gVar, bVar2, remoteConfigManager, aVar, sessionManager);
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c(this.f70317a.get(), this.f70318b.get(), this.f70319c.get(), this.f70320d.get(), this.f70321e.get(), this.f70322f.get(), this.f70323g.get());
    }
}
