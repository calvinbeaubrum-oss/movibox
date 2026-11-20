package lg;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p implements gg.b<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<Context> f70263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u10.a<fg.d> f70264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u10.a<mg.d> f70265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u10.a<u> f70266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u10.a<Executor> f70267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u10.a<ng.a> f70268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u10.a<og.a> f70269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u10.a<og.a> f70270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u10.a<mg.c> f70271i;

    public p(u10.a<Context> aVar, u10.a<fg.d> aVar2, u10.a<mg.d> aVar3, u10.a<u> aVar4, u10.a<Executor> aVar5, u10.a<ng.a> aVar6, u10.a<og.a> aVar7, u10.a<og.a> aVar8, u10.a<mg.c> aVar9) {
        this.f70263a = aVar;
        this.f70264b = aVar2;
        this.f70265c = aVar3;
        this.f70266d = aVar4;
        this.f70267e = aVar5;
        this.f70268f = aVar6;
        this.f70269g = aVar7;
        this.f70270h = aVar8;
        this.f70271i = aVar9;
    }

    public static p a(u10.a<Context> aVar, u10.a<fg.d> aVar2, u10.a<mg.d> aVar3, u10.a<u> aVar4, u10.a<Executor> aVar5, u10.a<ng.a> aVar6, u10.a<og.a> aVar7, u10.a<og.a> aVar8, u10.a<mg.c> aVar9) {
        return new p(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static o c(Context context, fg.d dVar, mg.d dVar2, u uVar, Executor executor, ng.a aVar, og.a aVar2, og.a aVar3, mg.c cVar) {
        return new o(context, dVar, dVar2, uVar, executor, aVar, aVar2, aVar3, cVar);
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public o get() {
        return c(this.f70263a.get(), this.f70264b.get(), this.f70265c.get(), this.f70266d.get(), this.f70267e.get(), this.f70268f.get(), this.f70269g.get(), this.f70270h.get(), this.f70271i.get());
    }
}
