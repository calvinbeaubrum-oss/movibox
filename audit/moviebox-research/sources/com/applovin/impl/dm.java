package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class dm extends bm {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final aq f18463r;

    /* JADX INFO: compiled from: source.java */
    public class a implements f1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ iq f18464a;

        public a(iq iqVar) {
            this.f18464a = iqVar;
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                this.f18464a.a(uri);
                dm.this.f18463r.b(true);
                return;
            }
            com.applovin.impl.sdk.n nVar = dm.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                dm dmVar = dm.this;
                dmVar.f24691c.b(dmVar.f24690b, "Failed to cache static companion ad");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements bm.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ iq f18466a;

        public b(iq iqVar) {
            this.f18466a = iqVar;
        }

        @Override // com.applovin.impl.bm.e
        public void a(String str) {
            this.f18466a.a(str);
            dm.this.f18463r.b(true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements bm.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ iq f18468a;

        public c(iq iqVar) {
            this.f18468a = iqVar;
        }

        @Override // com.applovin.impl.bm.e
        public void a(String str) {
            this.f18468a.a(str);
            dm.this.f18463r.b(true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements f1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ oq f18470a;

        public d(oq oqVar) {
            this.f18470a = oqVar;
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                com.applovin.impl.sdk.n nVar = dm.this.f24691c;
                if (com.applovin.impl.sdk.n.a()) {
                    dm dmVar = dm.this;
                    dmVar.f24691c.a(dmVar.f24690b, "Video file successfully cached into: " + uri);
                }
                this.f18470a.a(uri);
                return;
            }
            com.applovin.impl.sdk.n nVar2 = dm.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                dm dmVar2 = dm.this;
                dmVar2.f24691c.b(dmVar2.f24690b, "Failed to cache video file: " + this.f18470a);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements bm.e {
        public e() {
        }

        @Override // com.applovin.impl.bm.e
        public void a(String str) {
            if (dm.this.f18463r.isOpenMeasurementEnabled()) {
                str = dm.this.f24689a.W().a(str);
            }
            dm.this.f18463r.b(str);
            com.applovin.impl.sdk.n nVar = dm.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                dm dmVar = dm.this;
                dmVar.f24691c.a(dmVar.f24690b, "Finish caching HTML template " + dm.this.f18463r.j1() + " for ad #" + dm.this.f18463r.getAdIdNumber());
            }
        }
    }

    public dm(aq aqVar, com.applovin.impl.sdk.j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", aqVar, jVar, appLovinAdLoadListener);
        this.f18463r = aqVar;
    }

    private String d(String str) {
        String strReplace = str;
        for (String str2 : StringUtils.getRegexMatches(StringUtils.match(str, (String) this.f24689a.a(sj.f22954f5)), 1)) {
            if (!TextUtils.isEmpty(str2)) {
                if (this.f17992h.shouldCancelHtmlCachingIfShown() && this.f17992h.hasShown()) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f24691c.a(this.f24690b, "Cancelling HTML JavaScript caching due to ad being shown already");
                    }
                    this.f17993i.e();
                    return str;
                }
                Uri uriA = a(str2, Collections.emptyList(), false);
                if (uriA != null) {
                    strReplace = strReplace.replace(str2, uriA.toString());
                    this.f17992h.a(uriA);
                    this.f17993i.d();
                } else {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f24691c.b(this.f24690b, "Failed to cache JavaScript resource: " + str2);
                    }
                    this.f17993i.c();
                }
            }
        }
        return strReplace;
    }

    private void m() {
        if (l()) {
            return;
        }
        if (!this.f18463r.w1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Companion ad caching disabled. Skipping...");
                return;
            }
            return;
        }
        dq dqVarH1 = this.f18463r.h1();
        if (dqVarH1 == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "No companion ad provided. Skipping...");
                return;
            }
            return;
        }
        iq iqVarD = dqVarH1.d();
        if (iqVarD == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Failed to retrieve non-video resources from companion ad. Skipping...");
                return;
            }
            return;
        }
        Uri uriB = iqVarD.b();
        String string = uriB != null ? uriB.toString() : "";
        String strA = iqVarD.a();
        if (!URLUtil.isValidUrl(string) && !StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.k(this.f24690b, "Companion ad does not have any resources attached. Skipping...");
                return;
            }
            return;
        }
        if (iqVarD.c() == iq.a.STATIC) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Caching static companion ad at " + string + "...");
            }
            Uri uriA = a(string, Collections.emptyList(), false);
            if (uriA != null) {
                iqVarD.a(uriA);
                this.f18463r.b(true);
                return;
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "Failed to cache static companion ad");
                    return;
                }
                return;
            }
        }
        if (iqVarD.c() != iq.a.HTML) {
            if (iqVarD.c() == iq.a.IFRAME && com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Skip caching of iFrame resource...");
                return;
            }
            return;
        }
        if (!StringUtils.isValidString(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Caching provided HTML for companion ad. No fetch required. HTML: " + strA);
            }
            if (((Boolean) this.f24689a.a(sj.f22939d5)).booleanValue()) {
                strA = d(strA);
            }
            iqVarD.a(a(strA, Collections.emptyList(), this.f18463r));
            this.f18463r.b(true);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Begin caching HTML companion ad. Fetching from " + string + "...");
        }
        String strD = d(string, null, false);
        if (StringUtils.isValidString(strD)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "HTML fetched. Caching HTML now...");
            }
            iqVarD.a(a(strD, Collections.emptyList(), this.f18463r));
            this.f18463r.b(true);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "Unable to load companion ad resources from " + string);
        }
    }

    private void n() {
        String strJ1;
        if (l() || !mq.a(this.f18463r)) {
            return;
        }
        if (this.f18463r.k1() != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Begin caching HTML template. Fetching from " + this.f18463r.k1() + "...");
            }
            strJ1 = b(this.f18463r.k1().toString(), this.f18463r.X(), true);
        } else {
            strJ1 = this.f18463r.j1();
        }
        if (!StringUtils.isValidString(strJ1)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Unable to load HTML template");
                return;
            }
            return;
        }
        String strA = a(strJ1, this.f18463r.X(), this.f17992h);
        if (this.f18463r.isOpenMeasurementEnabled()) {
            strA = this.f24689a.W().a(strA);
        }
        this.f18463r.b(strA);
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Finish caching HTML template " + this.f18463r.j1() + " for ad #" + this.f18463r.getAdIdNumber());
        }
    }

    private void o() {
        oq oqVarS1;
        Uri uriD;
        if (l()) {
            return;
        }
        if (!this.f18463r.x1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Video caching disabled. Skipping...");
                return;
            }
            return;
        }
        if (this.f18463r.r1() == null || (oqVarS1 = this.f18463r.s1()) == null || (uriD = oqVarS1.d()) == null) {
            return;
        }
        Uri uriC = c(uriD.toString(), Collections.emptyList(), false);
        if (uriC != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Video file successfully cached into: " + uriC);
            }
            oqVarS1.a(uriC);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "Failed to cache video file: " + oqVarS1);
        }
    }

    private d1 p() {
        if (!this.f18463r.w1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Companion ad caching disabled. Skipping...");
            }
            return null;
        }
        dq dqVarH1 = this.f18463r.h1();
        if (dqVarH1 == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "No companion ad provided. Skipping...");
            }
            return null;
        }
        iq iqVarD = dqVarH1.d();
        if (iqVarD == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Failed to retrieve non-video resources from companion ad. Skipping...");
            }
            return null;
        }
        Uri uriB = iqVarD.b();
        String string = uriB != null ? uriB.toString() : "";
        String strA = iqVarD.a();
        if (URLUtil.isValidUrl(string) || StringUtils.isValidString(strA)) {
            if (iqVarD.c() == iq.a.STATIC) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.a(this.f24690b, "Caching static companion ad at " + string + "...");
                }
                return new f1(string, this.f18463r, Collections.emptyList(), false, this.f17993i, this.f24689a, new a(iqVarD));
            }
            if (iqVarD.c() == iq.a.HTML) {
                if (!StringUtils.isValidString(string)) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f24691c.a(this.f24690b, "Caching provided HTML for companion ad. No fetch required. HTML: " + strA);
                    }
                    return a(strA, Collections.emptyList(), new c(iqVarD));
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.a(this.f24690b, "Begin caching HTML companion ad. Fetching from " + string + "...");
                }
                String strD = d(string, null, false);
                if (StringUtils.isValidString(strD)) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f24691c.a(this.f24690b, "HTML fetched. Caching HTML now...");
                    }
                    return a(strD, Collections.emptyList(), new b(iqVarD));
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "Unable to load companion ad resources from " + string);
                }
            } else if (iqVarD.c() == iq.a.IFRAME && com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Skip caching of iFrame resource...");
            }
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.k(this.f24690b, "Companion ad does not have any resources attached. Skipping...");
        }
        return null;
    }

    @Override // com.applovin.impl.bm
    public void a(int i11) {
        this.f18463r.getAdEventTracker().f();
        super.a(i11);
    }

    @Override // com.applovin.impl.bm
    public void f() {
        this.f18463r.getAdEventTracker().h();
        super.f();
    }

    public e1 q() {
        if (!TextUtils.isEmpty(this.f18463r.j1())) {
            return a(this.f18463r.j1(), this.f18463r.X(), new e());
        }
        if (!com.applovin.impl.sdk.n.a()) {
            return null;
        }
        this.f24691c.a(this.f24690b, "Unable to load HTML template");
        return null;
    }

    public f1 r() {
        oq oqVarS1;
        Uri uriD;
        if (!this.f18463r.x1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Video caching disabled. Skipping...");
            }
            return null;
        }
        if (this.f18463r.r1() == null || (oqVarS1 = this.f18463r.s1()) == null || (uriD = oqVarS1.d()) == null) {
            return null;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Caching video file " + oqVarS1 + " creative...");
        }
        return a(uriD.toString(), Collections.emptyList(), false, (f1.a) new d(oqVarS1));
    }

    @Override // com.applovin.impl.bm, java.lang.Runnable
    public void run() {
        super.run();
        boolean zH0 = this.f18463r.H0();
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVar = this.f24691c;
            String str = this.f24690b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Begin caching for VAST ");
            sb2.append(zH0 ? "streaming " : "");
            sb2.append("ad #");
            sb2.append(this.f17992h.getAdIdNumber());
            sb2.append("...");
            nVar.a(str, sb2.toString());
        }
        if (zH0) {
            if (((Boolean) this.f24689a.a(sj.f22935d1)).booleanValue()) {
                if (!z3.f()) {
                    a(e());
                }
                if (this.f18463r.u1()) {
                    f();
                    ArrayList arrayList = new ArrayList();
                    d1 d1VarP = p();
                    if (d1VarP != null) {
                        arrayList.add(d1VarP);
                    }
                    e1 e1VarQ = q();
                    if (e1VarQ != null) {
                        arrayList.add(e1VarQ);
                    }
                    f1 f1VarR = r();
                    if (f1VarR != null) {
                        arrayList.add(f1VarR);
                    }
                    a(arrayList);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    if (this.f18463r.l1() == aq.c.COMPANION_AD) {
                        d1 d1VarP2 = p();
                        if (d1VarP2 != null) {
                            arrayList2.add(d1VarP2);
                        }
                        e1 e1VarQ2 = q();
                        if (e1VarQ2 != null) {
                            arrayList2.add(e1VarQ2);
                        }
                        a(arrayList2);
                        f();
                        f1 f1VarR2 = r();
                        if (f1VarR2 != null) {
                            arrayList3.add(f1VarR2);
                        }
                        a(arrayList3);
                    } else {
                        f1 f1VarR3 = r();
                        if (f1VarR3 != null) {
                            arrayList2.add(f1VarR3);
                        }
                        a(arrayList2);
                        f();
                        d1 d1VarP3 = p();
                        if (d1VarP3 != null) {
                            arrayList3.add(d1VarP3);
                        }
                        e1 e1VarQ3 = q();
                        if (e1VarQ3 != null) {
                            arrayList3.add(e1VarQ3);
                        }
                        a(arrayList3);
                    }
                }
            } else {
                j();
                if (this.f18463r.u1()) {
                    f();
                }
                aq.c cVarL1 = this.f18463r.l1();
                aq.c cVar = aq.c.COMPANION_AD;
                if (cVarL1 == cVar) {
                    m();
                    n();
                    a(this.f18463r);
                } else {
                    o();
                }
                if (!this.f18463r.u1()) {
                    f();
                }
                if (this.f18463r.l1() == cVar) {
                    o();
                } else {
                    m();
                    n();
                    a(this.f18463r);
                }
            }
        } else if (((Boolean) this.f24689a.a(sj.f22935d1)).booleanValue()) {
            ArrayList arrayList4 = new ArrayList();
            if (!z3.f()) {
                arrayList4.addAll(e());
            }
            d1 d1VarP4 = p();
            if (d1VarP4 != null) {
                arrayList4.add(d1VarP4);
            }
            f1 f1VarR4 = r();
            if (f1VarR4 != null) {
                arrayList4.add(f1VarR4);
            }
            e1 e1VarQ4 = q();
            if (e1VarQ4 != null) {
                arrayList4.add(e1VarQ4);
            }
            a(arrayList4);
            f();
        } else {
            j();
            m();
            o();
            n();
            a(this.f18463r);
            f();
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Finished caching VAST ad #" + this.f18463r.getAdIdNumber());
        }
        this.f18463r.v1();
        k();
    }
}
