package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f22474b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f22476d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f22477e = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f22475c = new Object();

    public c(j jVar) {
        this.f22473a = jVar;
        this.f22474b = jVar.J();
        for (com.applovin.impl.h0 h0Var : com.applovin.impl.h0.a()) {
            this.f22476d.put(h0Var, new p());
            this.f22477e.put(h0Var, new p());
        }
    }

    private p b(com.applovin.impl.h0 h0Var) {
        p pVar;
        synchronized (this.f22475c) {
            try {
                pVar = (p) this.f22477e.get(h0Var);
                if (pVar == null) {
                    pVar = new p();
                    this.f22477e.put(h0Var, pVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return pVar;
    }

    private p c(com.applovin.impl.h0 h0Var) {
        synchronized (this.f22475c) {
            try {
                p pVarB = b(h0Var);
                if (pVarB.b() > 0) {
                    return pVarB;
                }
                return d(h0Var);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private p d(com.applovin.impl.h0 h0Var) {
        p pVar;
        synchronized (this.f22475c) {
            try {
                pVar = (p) this.f22476d.get(h0Var);
                if (pVar == null) {
                    pVar = new p();
                    this.f22476d.put(h0Var, pVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return pVar;
    }

    public AppLovinAdImpl a(com.applovin.impl.h0 h0Var) {
        AppLovinAdImpl appLovinAdImplA;
        synchronized (this.f22475c) {
            appLovinAdImplA = c(h0Var).a();
        }
        return appLovinAdImplA;
    }

    public void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f22475c) {
            try {
                d(appLovinAdImpl.getAdZone()).a(appLovinAdImpl);
                if (n.a()) {
                    this.f22474b.a("AdPreloadManager", "Ad enqueued: " + appLovinAdImpl);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f22475c) {
            c(appLovinAdImpl.getAdZone()).b(appLovinAdImpl);
        }
    }

    public AppLovinAdImpl e(com.applovin.impl.h0 h0Var) {
        com.applovin.impl.sdk.ad.c cVar;
        synchronized (this.f22475c) {
            try {
                p pVarD = d(h0Var);
                if (pVarD.b() > 0) {
                    b(h0Var).a(pVarD.a());
                    cVar = new com.applovin.impl.sdk.ad.c(h0Var, this.f22473a);
                } else {
                    cVar = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (cVar != null) {
            if (n.a()) {
                this.f22474b.a("AdPreloadManager", "Retrieved ad of zone " + h0Var + "...");
            }
        } else if (n.a()) {
            this.f22474b.a("AdPreloadManager", "Unable to retrieve ad of zone " + h0Var + "...");
        }
        return cVar;
    }

    public AppLovinAdBase f(com.applovin.impl.h0 h0Var) {
        AppLovinAdImpl appLovinAdImplD;
        synchronized (this.f22475c) {
            appLovinAdImplD = c(h0Var).d();
        }
        return appLovinAdImplD;
    }
}
