package com.applovin.impl;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class pb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f21707a;

    public static void a() {
        f21707a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.sdk.j jVar) {
        if (f21707a) {
            return;
        }
        jVar.E().a(la.L, "no_ads_loaded");
    }

    public static void b(final com.applovin.impl.sdk.j jVar) {
        Long l11 = (Long) jVar.a(ve.J7);
        if (l11.longValue() <= 0) {
            return;
        }
        jVar.j0().a(new jn(jVar, true, "submitIntegrationErrorReport", new Runnable() { // from class: com.applovin.impl.d10
            @Override // java.lang.Runnable
            public final void run() {
                pb.a(jVar);
            }
        }), tm.b.OTHER, TimeUnit.SECONDS.toMillis(l11.longValue()));
    }
}
