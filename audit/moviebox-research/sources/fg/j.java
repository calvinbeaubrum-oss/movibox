package fg;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j implements gg.b<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<Context> f64878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u10.a<g> f64879b;

    public j(u10.a<Context> aVar, u10.a<g> aVar2) {
        this.f64878a = aVar;
        this.f64879b = aVar2;
    }

    public static j a(u10.a<Context> aVar, u10.a<g> aVar2) {
        return new j(aVar, aVar2);
    }

    public static i c(Context context, Object obj) {
        return new i(context, (g) obj);
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c(this.f64878a.get(), this.f64879b.get());
    }
}
