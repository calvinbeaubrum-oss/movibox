package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class em extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f18755h;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(l0.a aVar);
    }

    public em(com.applovin.impl.sdk.j jVar, a aVar) {
        super("TaskCollectAdvertisingId", jVar, true);
        this.f18755h = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18755h.a(this.f24689a.y().f());
    }
}
