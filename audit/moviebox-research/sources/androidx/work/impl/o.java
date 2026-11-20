package androidx.work.impl;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class o implements androidx.work.l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.lifecycle.c0<androidx.work.l.b> f13475c = new androidx.lifecycle.c0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a<androidx.work.l.b.c> f13476d = androidx.work.impl.utils.futures.a.x();

    public o() {
        a(androidx.work.l.f13573b);
    }

    public void a(@NonNull androidx.work.l.b bVar) {
        this.f13475c.n(bVar);
        if (bVar instanceof androidx.work.l.b.c) {
            this.f13476d.t((androidx.work.l.b.c) bVar);
        } else if (bVar instanceof androidx.work.l.b.a) {
            this.f13476d.u(((androidx.work.l.b.a) bVar).a());
        }
    }
}
