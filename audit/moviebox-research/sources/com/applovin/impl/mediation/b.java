package com.applovin.impl.mediation;

import com.applovin.impl.gc;
import com.applovin.impl.ie;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements a.InterfaceC0187a, c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f20856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f20857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f20858c;

    public b(com.applovin.impl.sdk.j jVar) {
        this.f20856a = jVar;
        this.f20857b = new a(jVar);
        this.f20858c = new c(jVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void c(ie ieVar) {
        g gVarB;
        if (ieVar == null || (gVarB = ieVar.B()) == null || !ieVar.x().compareAndSet(false, true)) {
            return;
        }
        gc.e(gVarB.c(), ieVar);
    }

    public void a() {
        this.f20858c.a();
        this.f20857b.a();
    }

    @Override // com.applovin.impl.mediation.c.a
    public void a(ie ieVar) {
        c(ieVar);
    }

    @Override // com.applovin.impl.mediation.a.InterfaceC0187a
    public void b(final ie ieVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f21104a.c(ieVar);
            }
        }, ieVar.l0());
    }

    public void e(ie ieVar) {
        long jM0 = ieVar.m0();
        if (jM0 >= 0) {
            this.f20858c.a(ieVar, jM0);
        }
        boolean z11 = Boolean.parseBoolean(this.f20856a.g0().getExtraParameters().get("should_schedule_ad_hidden_on_ad_destroy"));
        if (ieVar.v0() || ieVar.w0() || z11) {
            this.f20857b.a(z11);
            this.f20857b.a(ieVar, this);
        }
    }
}
