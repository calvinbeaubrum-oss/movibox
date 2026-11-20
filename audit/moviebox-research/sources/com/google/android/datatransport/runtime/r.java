package com.google.android.datatransport.runtime;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r<T> implements cg.g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f32652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f32653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cg.c f32654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cg.f<T, byte[]> f32655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f32656e;

    public r(o oVar, String str, cg.c cVar, cg.f<T, byte[]> fVar, s sVar) {
        this.f32652a = oVar;
        this.f32653b = str;
        this.f32654c = cVar;
        this.f32655d = fVar;
        this.f32656e = sVar;
    }

    public static /* synthetic */ void e(Exception exc) {
    }

    @Override // cg.g
    public void a(cg.d<T> dVar) {
        b(dVar, new cg.i() { // from class: com.google.android.datatransport.runtime.q
            @Override // cg.i
            public final void a(Exception exc) {
                r.e(exc);
            }
        });
    }

    @Override // cg.g
    public void b(cg.d<T> dVar, cg.i iVar) {
        this.f32656e.a(n.a().e(this.f32652a).c(dVar).f(this.f32653b).d(this.f32655d).b(this.f32654c).a(), iVar);
    }

    public o d() {
        return this.f32652a;
    }
}
