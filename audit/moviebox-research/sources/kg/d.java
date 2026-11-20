package kg;

import java.util.concurrent.Executor;
import lg.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements gg.b<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<Executor> f68558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u10.a<fg.d> f68559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u10.a<u> f68560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u10.a<mg.d> f68561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u10.a<ng.a> f68562e;

    public d(u10.a<Executor> aVar, u10.a<fg.d> aVar2, u10.a<u> aVar3, u10.a<mg.d> aVar4, u10.a<ng.a> aVar5) {
        this.f68558a = aVar;
        this.f68559b = aVar2;
        this.f68560c = aVar3;
        this.f68561d = aVar4;
        this.f68562e = aVar5;
    }

    public static d a(u10.a<Executor> aVar, u10.a<fg.d> aVar2, u10.a<u> aVar3, u10.a<mg.d> aVar4, u10.a<ng.a> aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, fg.d dVar, u uVar, mg.d dVar2, ng.a aVar) {
        return new c(executor, dVar, uVar, dVar2, aVar);
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c(this.f68558a.get(), this.f68559b.get(), this.f68560c.get(), this.f68561d.get(), this.f68562e.get());
    }
}
