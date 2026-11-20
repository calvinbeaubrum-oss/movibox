package pl;

import yl.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e implements u10.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f73941a;

    public e(a aVar) {
        this.f73941a = aVar;
    }

    public static e a(a aVar) {
        return new e(aVar);
    }

    public static bl.b<m> c(a aVar) {
        return (bl.b) e10.b.c(aVar.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public bl.b<m> get() {
        return c(this.f73941a);
    }
}
