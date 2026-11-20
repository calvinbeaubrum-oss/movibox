package com.polygamma.ogm;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReferenceQueue f48887a = new ReferenceQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p007do.m f48888b;

    public t(p007do.m mVar) {
        this.f48888b = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        do {
            try {
                this.f48887a.remove();
                break;
            } catch (InterruptedException unused) {
                String str = p007do.m.f63464o;
            }
        } while (this.f48888b.f63470c.get() != null);
        p007do.m.u(this.f48888b);
    }
}
