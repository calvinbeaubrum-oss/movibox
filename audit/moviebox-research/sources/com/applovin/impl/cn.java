package com.applovin.impl;

import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class cn extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final eq f18265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinAdLoadListener f18266i;

    public cn(eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskRenderVastAd", jVar);
        this.f18266i = appLovinAdLoadListener;
        this.f18265h = eqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Rendering VAST ad...");
        }
        int size = this.f18265h.a().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String strA = "";
        jq jqVarA = null;
        nq nqVarA = null;
        dq dqVarA = null;
        cq cqVarA = null;
        String strA2 = "";
        for (es esVar : this.f18265h.a()) {
            es esVarB = esVar.b(mq.b(esVar) ? "Wrapper" : "InLine");
            if (esVarB != null) {
                es esVarB2 = esVarB.b("AdSystem");
                if (esVarB2 != null) {
                    jqVarA = jq.a(esVarB2, jqVarA, this.f24689a);
                }
                strA = mq.a(esVarB, "AdTitle", strA);
                strA2 = mq.a(esVarB, "Description", strA2);
                mq.a(esVarB.a("Impression"), hashSet, this.f18265h, this.f24689a);
                es esVarC = esVarB.c("ViewableImpression");
                if (esVarC != null) {
                    mq.a(esVarC.a("Viewable"), hashSet, this.f18265h, this.f24689a);
                }
                es esVarB3 = esVarB.b("AdVerifications");
                if (esVarB3 != null) {
                    cqVarA = cq.a(esVarB3, cqVarA, this.f18265h, this.f24689a);
                }
                mq.a(esVarB.a("Error"), hashSet2, this.f18265h, this.f24689a);
                es esVarC2 = esVarB.c("Creatives");
                if (esVarC2 != null) {
                    for (es esVar2 : esVarC2.b()) {
                        es esVarC3 = esVar2.c("Linear");
                        if (esVarC3 != null) {
                            nqVarA = nq.a(esVarC3, nqVarA, this.f18265h, this.f24689a);
                        } else {
                            es esVarB4 = esVar2.b("CompanionAds");
                            if (esVarB4 != null) {
                                es esVarB5 = esVarB4.b("Companion");
                                if (esVarB5 != null) {
                                    dqVarA = dq.a(esVarB5, dqVarA, this.f18265h, this.f24689a);
                                }
                            } else if (com.applovin.impl.sdk.n.a()) {
                                this.f24691c.b(this.f24690b, "Received and will skip rendering for an unidentified creative: " + esVar2);
                            }
                        }
                    }
                }
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Did not find wrapper or inline response for node: " + esVar);
            }
        }
        aq aqVarA = new aq.b().a(this.f24689a).a(this.f18265h.b()).b(this.f18265h.e()).a(this.f18265h.c()).b(strA).a(strA2).a(jqVarA).a(nqVarA).a(dqVarA).a(cqVarA).b(hashSet).a(cqVarA).a(hashSet2).a();
        fq fqVarC = mq.c(aqVarA);
        if (fqVarC != null) {
            mq.a(this.f18265h, this.f18266i, fqVarC, -6, this.f24689a);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Finished rendering VAST ad: " + aqVarA);
        }
        aqVarA.getAdEventTracker().e();
        this.f24689a.j0().a((yl) new dm(aqVarA, this.f24689a, this.f18266i), tm.b.CACHING);
    }
}
