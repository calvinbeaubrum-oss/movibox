package com.mbridge.msdk.newreward.function.c.b.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.a.a f46218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.b.b.a f46219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f46220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f46221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f46222e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f46223f = false;

    /* JADX INFO: compiled from: source.java */
    public class a implements com.mbridge.msdk.newreward.a.b.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f46227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f46228c;

        public a(c cVar, com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f46227b = cVar;
            this.f46228c = bVar;
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void a(com.mbridge.msdk.foundation.c.b bVar) {
            if (bVar.a() == 1) {
                if (!c.this.f46219b.a() || !c.this.f46220c.a() || this.f46227b.f46223f) {
                    return;
                } else {
                    this.f46227b.f46223f = true;
                }
            }
            this.f46228c.a(bVar);
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void a(Object obj) {
            if (this.f46227b.f46222e) {
                return;
            }
            this.f46227b.f46222e = true;
            this.f46228c.a(obj);
        }
    }

    public c(com.mbridge.msdk.newreward.function.c.a.a aVar) {
        this.f46218a = aVar;
    }

    private void a() {
        this.f46219b = new com.mbridge.msdk.newreward.function.c.b.b.a(this.f46218a);
    }

    public final void a(e eVar, final com.mbridge.msdk.newreward.a.b.b bVar) {
        int iC = eVar.c();
        if (iC == 1) {
            if (this.f46219b == null) {
                a();
            }
            this.f46219b.a(eVar, new a(this, bVar));
        } else if (iC == 2) {
            if (this.f46221d == null) {
                this.f46221d = new d();
            }
            this.f46221d.a(eVar, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.c.b.b.c.1
                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void a(com.mbridge.msdk.foundation.c.b bVar2) {
                    com.mbridge.msdk.newreward.a.b.b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.a(bVar2);
                    }
                }

                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void a(Object obj) {
                    com.mbridge.msdk.newreward.a.b.b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(obj);
                    }
                }
            });
        } else {
            if (iC != 3) {
                return;
            }
            if (this.f46220c == null) {
                this.f46220c = new b(this.f46218a);
            }
            this.f46220c.a(eVar, new a(this, bVar));
        }
    }

    public final boolean a(e eVar) {
        if (eVar.c() == 1) {
            if (this.f46219b == null) {
                a();
            }
            return this.f46219b.a(eVar.a(), eVar, eVar.b());
        }
        if (eVar.c() == 2) {
            if (this.f46221d == null) {
                this.f46221d = new d();
            }
            return this.f46221d.a(eVar);
        }
        if (eVar.c() != 3) {
            return false;
        }
        if (this.f46220c == null) {
            this.f46220c = new b(this.f46218a);
        }
        return true;
    }
}
