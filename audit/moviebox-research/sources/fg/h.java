package fg;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements gg.b<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<Context> f64870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u10.a<og.a> f64871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u10.a<og.a> f64872c;

    public h(u10.a<Context> aVar, u10.a<og.a> aVar2, u10.a<og.a> aVar3) {
        this.f64870a = aVar;
        this.f64871b = aVar2;
        this.f64872c = aVar3;
    }

    public static h a(u10.a<Context> aVar, u10.a<og.a> aVar2, u10.a<og.a> aVar3) {
        return new h(aVar, aVar2, aVar3);
    }

    public static g c(Context context, og.a aVar, og.a aVar2) {
        return new g(context, aVar, aVar2);
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g get() {
        return c(this.f64870a.get(), this.f64871b.get(), this.f64872c.get());
    }
}
