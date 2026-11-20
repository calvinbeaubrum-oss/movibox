package com.mbridge.msdk.e;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class g implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f43866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r f43867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f43868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f43869d = new AtomicLong(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long[] f43870e = new long[2];

    public g(c cVar, r rVar, j jVar) {
        this.f43866a = cVar;
        this.f43867b = rVar;
        this.f43868c = jVar;
    }

    @Override // com.mbridge.msdk.e.l
    public final void a(e eVar) {
        long jIncrementAndGet = this.f43869d.incrementAndGet();
        this.f43870e[0] = System.currentTimeMillis();
        this.f43870e[1] = jIncrementAndGet;
    }

    @Override // com.mbridge.msdk.e.l
    public final long[] a() {
        long[] jArr = this.f43870e;
        return jArr.length == 0 ? new long[]{0, 0} : jArr;
    }

    @Override // com.mbridge.msdk.e.l
    public final void b(final e eVar) {
        this.f43868c.b(new Runnable() { // from class: com.mbridge.msdk.e.g.1
            @Override // java.lang.Runnable
            public final void run() {
                i iVar = new i(eVar);
                iVar.a(1);
                iVar.b(0);
                iVar.a(System.currentTimeMillis() + eVar.h());
                if (g.this.f43866a.a(iVar) > 0) {
                    g.this.f43867b.c();
                    g.this.f43867b.d();
                    g.this.f43867b.a(eVar);
                }
            }
        });
    }
}
