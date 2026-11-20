package com.applovin.impl;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class hn extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final eq f19513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinAdLoadListener f19514i;

    /* JADX INFO: compiled from: source.java */
    public class a extends dn {
        public a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, es esVar) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Unable to resolve VAST wrapper. Server returned " + i11);
            }
            hn.this.a(i11);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, es esVar, int i11) {
            this.f24689a.j0().a(zm.a(esVar, hn.this.f19513h, hn.this.f19514i, hn.this.f24689a));
        }
    }

    public hn(eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskResolveVastWrapper", jVar);
        this.f19514i = appLovinAdLoadListener;
        this.f19513h = eqVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "Failed to resolve VAST wrapper due to error code " + i11);
        }
        if (i11 != -1009) {
            mq.a(this.f19513h, this.f19514i, i11 == -1001 ? fq.TIMED_OUT : fq.GENERAL_WRAPPER_ERROR, i11, this.f24689a);
            return;
        }
        AppLovinAdLoadListener appLovinAdLoadListener = this.f19514i;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i11);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String strA = mq.a(this.f19513h);
        if (!StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Resolving VAST failed. Could not find resolution URL");
            }
            a(-1);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Resolving VAST ad with depth " + this.f19513h.d() + " at " + strA);
        }
        try {
            this.f24689a.j0().a(new a(com.applovin.impl.sdk.network.a.a(this.f24689a).b(strA).c("GET").a(es.f18777f).a(((Integer) this.f24689a.a(sj.R4)).intValue()).c(((Integer) this.f24689a.a(sj.S4)).intValue()).a(false).a(), this.f24689a));
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Unable to resolve VAST wrapper", th2);
            }
            a(-1);
        }
    }
}
