package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.n;
import com.bykv.vk.openvk.preload.a.q;
import com.bykv.vk.openvk.preload.a.r;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k<T> extends q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n<T> f25423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.g<T> f25424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.a.d f25425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.c.a<T> f25426d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private q<T> f25429g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k<T>.a f25428f = new a(this, 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final r f25427e = null;

    /* JADX INFO: compiled from: source.java */
    public final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar, byte b11) {
            this();
        }
    }

    public k(n<T> nVar, com.bykv.vk.openvk.preload.a.g<T> gVar, com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        this.f25423a = nVar;
        this.f25424b = gVar;
        this.f25425c = dVar;
        this.f25426d = aVar;
    }

    private q<T> b() {
        q<T> qVar = this.f25429g;
        if (qVar != null) {
            return qVar;
        }
        q<T> qVarA = this.f25425c.a((r) null, this.f25426d);
        this.f25429g = qVarA;
        return qVarA;
    }

    @Override // com.bykv.vk.openvk.preload.a.q
    public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (this.f25424b == null) {
            return b().a(aVar);
        }
        if (com.bykv.vk.openvk.preload.falconx.a.a.a(aVar) instanceof com.bykv.vk.openvk.preload.a.j) {
            return null;
        }
        return this.f25424b.a();
    }

    @Override // com.bykv.vk.openvk.preload.a.q
    public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t11) throws IOException {
        n<T> nVar = this.f25423a;
        if (nVar == null) {
            b().a(cVar, t11);
        } else if (t11 == null) {
            cVar.h();
        } else {
            com.bykv.vk.openvk.preload.falconx.a.a.a(nVar.a(), cVar);
        }
    }
}
