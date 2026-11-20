package com.google.android.datatransport.runtime;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class v implements gg.b<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<og.a> f32672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u10.a<og.a> f32673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u10.a<kg.e> f32674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u10.a<lg.o> f32675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u10.a<lg.s> f32676e;

    public v(u10.a<og.a> aVar, u10.a<og.a> aVar2, u10.a<kg.e> aVar3, u10.a<lg.o> aVar4, u10.a<lg.s> aVar5) {
        this.f32672a = aVar;
        this.f32673b = aVar2;
        this.f32674c = aVar3;
        this.f32675d = aVar4;
        this.f32676e = aVar5;
    }

    public static v a(u10.a<og.a> aVar, u10.a<og.a> aVar2, u10.a<kg.e> aVar3, u10.a<lg.o> aVar4, u10.a<lg.s> aVar5) {
        return new v(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static t c(og.a aVar, og.a aVar2, kg.e eVar, lg.o oVar, lg.s sVar) {
        return new t(aVar, aVar2, eVar, oVar, sVar);
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t get() {
        return c(this.f32672a.get(), this.f32673b.get(), this.f32674c.get(), this.f32675d.get(), this.f32676e.get());
    }
}
