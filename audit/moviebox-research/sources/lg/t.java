package lg;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t implements gg.b<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<Executor> f70278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u10.a<mg.d> f70279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u10.a<u> f70280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u10.a<ng.a> f70281d;

    public t(u10.a<Executor> aVar, u10.a<mg.d> aVar2, u10.a<u> aVar3, u10.a<ng.a> aVar4) {
        this.f70278a = aVar;
        this.f70279b = aVar2;
        this.f70280c = aVar3;
        this.f70281d = aVar4;
    }

    public static t a(u10.a<Executor> aVar, u10.a<mg.d> aVar2, u10.a<u> aVar3, u10.a<ng.a> aVar4) {
        return new t(aVar, aVar2, aVar3, aVar4);
    }

    public static s c(Executor executor, mg.d dVar, u uVar, ng.a aVar) {
        return new s(executor, dVar, uVar, aVar);
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public s get() {
        return c(this.f70278a.get(), this.f70279b.get(), this.f70280c.get(), this.f70281d.get());
    }
}
