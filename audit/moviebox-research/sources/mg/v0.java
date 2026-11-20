package mg;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class v0 implements gg.b<u0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<Context> f71093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u10.a<String> f71094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u10.a<Integer> f71095c;

    public v0(u10.a<Context> aVar, u10.a<String> aVar2, u10.a<Integer> aVar3) {
        this.f71093a = aVar;
        this.f71094b = aVar2;
        this.f71095c = aVar3;
    }

    public static v0 a(u10.a<Context> aVar, u10.a<String> aVar2, u10.a<Integer> aVar3) {
        return new v0(aVar, aVar2, aVar3);
    }

    public static u0 c(Context context, String str, int i11) {
        return new u0(context, str, i11);
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u0 get() {
        return c(this.f71093a.get(), this.f71094b.get(), this.f71095c.get().intValue());
    }
}
