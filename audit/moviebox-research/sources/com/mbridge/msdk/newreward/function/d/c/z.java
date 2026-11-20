package com.mbridge.msdk.newreward.function.d.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class z extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.d.a.b f46400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.d.a.a f46401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f46402c;

    public z(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar, c cVar) {
        this.f46400a = bVar;
        this.f46401b = aVar;
        this.f46402c = cVar;
        cVar.b(true);
        cVar.a(false);
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.p
    public final void a(int i11, x xVar) {
        if (xVar != null) {
            xVar.a(this.f46400a, this.f46401b, this);
            xVar.b(this.f46400a, this.f46401b, this);
        }
    }
}
