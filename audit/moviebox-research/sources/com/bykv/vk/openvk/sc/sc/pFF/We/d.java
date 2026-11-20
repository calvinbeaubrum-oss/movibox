package com.bykv.vk.openvk.sc.sc.pFF.We;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e.a f25896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e.d f25897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e.f f25898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e.b f25899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e.InterfaceC0216e f25900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e.g f25901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e.c f25902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25903h = false;

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public final void a(e.f fVar) {
        this.f25898c = fVar;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public final void c(e.d dVar) {
        this.f25897b = dVar;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public final void d(e.a aVar) {
        this.f25896a = aVar;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public final void e(e.c cVar) {
        this.f25902g = cVar;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public final void g(e.InterfaceC0216e interfaceC0216e) {
        this.f25900e = interfaceC0216e;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public final void i(e.b bVar) {
        this.f25899d = bVar;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public final void j(e.g gVar) {
        this.f25901f = gVar;
    }

    public final void k() {
        try {
            e.b bVar = this.f25899d;
            if (bVar != null) {
                bVar.zY(this);
            }
        } catch (Throwable unused) {
        }
    }

    public final void l() {
        try {
            e.a aVar = this.f25896a;
            if (aVar != null) {
                aVar.pFF(this);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean m(int i11, int i12) {
        try {
            e.c cVar = this.f25902g;
            return cVar != null && cVar.pFF(this, i11, i12);
        } catch (Throwable unused) {
        }
    }

    public void n() {
        this.f25896a = null;
        this.f25898c = null;
        this.f25897b = null;
        this.f25899d = null;
        this.f25900e = null;
        this.f25901f = null;
        this.f25902g = null;
    }

    public final void o(int i11) {
        try {
            e.f fVar = this.f25898c;
            if (fVar != null) {
                fVar.sc(this, i11);
            }
        } catch (Throwable unused) {
        }
    }

    public final void p(int i11, int i12, int i13, int i14) {
        try {
            e.InterfaceC0216e interfaceC0216e = this.f25900e;
            if (interfaceC0216e != null) {
                interfaceC0216e.sc(this, i11, i12, i13, i14);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean q(int i11, int i12) {
        try {
            e.g gVar = this.f25901f;
            return gVar != null && gVar.sc(this, i11, i12);
        } catch (Throwable unused) {
        }
    }

    public final void r() {
        try {
            e.d dVar = this.f25897b;
            if (dVar != null) {
                dVar.sc(this);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void sc(boolean z11) {
        this.f25903h = z11;
    }
}
