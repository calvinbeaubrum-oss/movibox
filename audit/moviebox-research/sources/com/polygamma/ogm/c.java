package com.polygamma.ogm;

import java.util.TimerTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f48871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p007do.s f48872b;

    public c(p007do.s sVar, m mVar) {
        this.f48872b = sVar;
        this.f48871a = mVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        try {
            this.f48872b.f63506h.submit((Runnable) this.f48871a);
        } finally {
            cancel();
        }
    }
}
