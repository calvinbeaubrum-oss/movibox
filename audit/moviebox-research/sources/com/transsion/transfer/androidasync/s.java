package com.transsion.transfer.androidasync;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class s implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f58857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fy.a f58858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fy.d f58859c;

    @Override // com.transsion.transfer.androidasync.r
    public final void A(fy.a aVar) {
        this.f58858b = aVar;
    }

    @Override // com.transsion.transfer.androidasync.r
    public fy.d G() {
        return this.f58859c;
    }

    public final fy.a K() {
        return this.f58858b;
    }

    public void L(Exception exc) {
        if (this.f58857a) {
            return;
        }
        this.f58857a = true;
        if (K() != null) {
            K().i(exc);
        }
    }

    @Override // com.transsion.transfer.androidasync.r
    public void o(fy.d dVar) {
        this.f58859c = dVar;
    }
}
