package mg;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements gg.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<Context> f71042a;

    public h(u10.a<Context> aVar) {
        this.f71042a = aVar;
    }

    public static h a(u10.a<Context> aVar) {
        return new h(aVar);
    }

    public static String c(Context context) {
        return (String) gg.d.d(f.b(context));
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c(this.f71042a.get());
    }
}
