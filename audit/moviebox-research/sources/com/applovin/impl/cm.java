package com.applovin.impl;

import android.net.Uri;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class cm extends bm {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.a f18260r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f18261s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f18262t;

    /* JADX INFO: compiled from: source.java */
    public class a implements f1.a {
        public a() {
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                if (cm.this.f18260r.J0()) {
                    cm.this.f18260r.b(cm.this.f18260r.h1().replaceFirst(cm.this.f18260r.k1(), uri.toString()));
                    com.applovin.impl.sdk.n nVar = cm.this.f24691c;
                    if (com.applovin.impl.sdk.n.a()) {
                        cm cmVar = cm.this;
                        cmVar.f24691c.a(cmVar.f24690b, "Replaced video URL with cached video URI in HTML for web video ad");
                    }
                }
                cm.this.f18260r.o1();
                cm.this.f18260r.d(uri);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements bm.e {
        public b() {
        }

        @Override // com.applovin.impl.bm.e
        public void a(String str) {
            cm.this.f18260r.b(cm.this.d(str));
            cm.this.f18260r.b(true);
            com.applovin.impl.sdk.n nVar = cm.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                cm cmVar = cm.this;
                cmVar.f24691c.a(cmVar.f24690b, "Finish caching non-video resources for ad #" + cm.this.f18260r.getAdIdNumber());
            }
            cm cmVar2 = cm.this;
            cmVar2.f24691c.f(cmVar2.f24690b, "Ad updated with cachedHTML = " + cm.this.f18260r.h1());
        }
    }

    public cm(com.applovin.impl.sdk.ad.a aVar, com.applovin.impl.sdk.j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, jVar, appLovinAdLoadListener);
        this.f18260r = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        if (yp.h(com.applovin.impl.sdk.j.l())) {
            str = yp.b(str);
        }
        return this.f18260r.isOpenMeasurementEnabled() ? this.f24689a.W().a(str) : str;
    }

    private void m() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Caching HTML resources...");
        }
        this.f18260r.b(d(a(a(this.f18260r.h1(), this.f18260r.i1(), this.f18260r.p1(), this.f18260r.X(), this.f18260r.q1()), this.f18260r.X(), this.f18260r)));
        this.f18260r.b(true);
        a(this.f18260r);
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Finish caching non-video resources for ad #" + this.f18260r.getAdIdNumber());
        }
        this.f24691c.f(this.f24690b, "Ad updated with cachedHTML = " + this.f18260r.h1());
    }

    private void n() {
        Uri uriC;
        if (l() || (uriC = c(this.f18260r.m1())) == null) {
            return;
        }
        if (this.f18260r.J0()) {
            this.f18260r.b(this.f18260r.h1().replaceFirst(this.f18260r.k1(), uriC.toString()));
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Replaced video URL with cached video URI in HTML for web video ad");
            }
        }
        this.f18260r.o1();
        this.f18260r.d(uriC);
    }

    private e1 o() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Caching HTML resources...");
        }
        return a(this.f18260r.h1(), this.f18260r.X(), new b());
    }

    private f1 p() {
        return b(this.f18260r.m1(), new a());
    }

    public void b(boolean z11) {
        this.f18262t = z11;
    }

    public void c(boolean z11) {
        this.f18261s = z11;
    }

    @Override // com.applovin.impl.bm, java.lang.Runnable
    public void run() {
        super.run();
        boolean zH0 = this.f18260r.H0();
        boolean z11 = this.f18262t;
        if (zH0 || z11) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Begin caching for streaming ad #" + this.f18260r.getAdIdNumber() + "...");
            }
            if (((Boolean) this.f24689a.a(sj.f22935d1)).booleanValue()) {
                if (!z3.f()) {
                    a(e());
                }
                ArrayList arrayList = new ArrayList();
                if (!zH0) {
                    f();
                    e1 e1VarO = o();
                    if (e1VarO != null) {
                        arrayList.add(e1VarO);
                    }
                } else if (this.f18261s) {
                    f();
                    e1 e1VarO2 = o();
                    if (e1VarO2 != null) {
                        arrayList.add(e1VarO2);
                    }
                    f1 f1VarP = p();
                    if (f1VarP != null) {
                        arrayList.add(f1VarP);
                    }
                } else {
                    e1 e1VarO3 = o();
                    if (e1VarO3 != null) {
                        a(Arrays.asList(e1VarO3));
                    }
                    f();
                    f1 f1VarP2 = p();
                    if (f1VarP2 != null) {
                        arrayList.add(f1VarP2);
                    }
                }
                a(arrayList);
                f();
            } else {
                j();
                if (zH0) {
                    if (this.f18261s) {
                        f();
                    }
                    m();
                    if (!this.f18261s) {
                        f();
                    }
                    n();
                } else {
                    f();
                    m();
                }
            }
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Begin processing for non-streaming ad #" + this.f18260r.getAdIdNumber() + "...");
            }
            if (((Boolean) this.f24689a.a(sj.f22935d1)).booleanValue()) {
                ArrayList arrayList2 = new ArrayList();
                if (!z3.f()) {
                    arrayList2.addAll(e());
                }
                e1 e1VarO4 = o();
                if (e1VarO4 != null) {
                    arrayList2.add(e1VarO4);
                }
                f1 f1VarP3 = p();
                if (f1VarP3 != null) {
                    arrayList2.add(f1VarP3);
                }
                a(arrayList2);
                f();
            } else {
                j();
                m();
                n();
                f();
            }
        }
        k();
    }
}
