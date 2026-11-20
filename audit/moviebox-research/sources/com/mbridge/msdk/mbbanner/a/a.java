package com.mbridge.msdk.mbbanner.a;

import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.mbbanner.common.a.b;
import com.mbridge.msdk.mbbanner.common.c.c;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f45223a = "BannerController";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f45224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f45225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MBridgeIds f45226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f45227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f45228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MBBannerView f45229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f45230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f45231i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f45232j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private BannerAdListener f45234l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private CampaignUnit f45235m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c f45236n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private k f45237o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private j f45238p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f45239q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f45240r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f45241s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f45242t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f45243u;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f45233k = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.c f45244v = new com.mbridge.msdk.mbbanner.common.b.c() { // from class: com.mbridge.msdk.mbbanner.a.a.1
        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void a() {
            if (a.this.f45234l != null) {
                a.this.f45234l.onClick(a.this.f45226d);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void a(CampaignEx campaignEx) {
            a.this.d();
            if (a.this.f45234l != null) {
                a.this.f45234l.onLogImpression(a.this.f45226d);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void a(String str) {
            a.this.b(str);
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void a(List<CampaignEx> list) {
            if (a.this.f45234l != null) {
                a.this.f45234l.onLoadSuccessed(a.this.f45226d);
            }
            ad.b(a.f45223a, "onShowSuccessed:");
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void b() {
            if (a.this.f45234l != null) {
                a.this.f45234l.onLeaveApp(a.this.f45226d);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void c() {
            if (a.this.f45234l != null) {
                a.this.f45234l.showFullScreen(a.this.f45226d);
                a.this.f45243u = true;
                com.mbridge.msdk.mbbanner.common.c.a.a().a(2, a.this.f45225c, a.this.f45224b, null, null);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void d() {
            if (a.this.f45234l != null) {
                a.this.f45234l.closeFullScreen(a.this.f45226d);
                a.this.f45243u = false;
                com.mbridge.msdk.mbbanner.common.c.a.a().a(3, a.this.f45225c, a.this.f45224b, new b(a.this.f45231i + "x" + a.this.f45230h, a.this.f45232j * 1000), a.this.f45245w);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.c
        public final void e() {
            if (a.this.f45234l != null) {
                a.this.f45234l.onCloseBanner(a.this.f45226d);
            }
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.b f45245w = new com.mbridge.msdk.mbbanner.common.b.b() { // from class: com.mbridge.msdk.mbbanner.a.a.2
        @Override // com.mbridge.msdk.mbbanner.common.b.b
        public final void a(com.mbridge.msdk.foundation.c.b bVar) {
            CampaignEx campaignExC;
            boolean zE;
            String str = "";
            if (bVar != null) {
                String strB = bVar.b();
                str = TextUtils.isEmpty(strB) ? "" : strB;
                campaignExC = bVar.c();
                zE = bVar.e();
            } else {
                campaignExC = null;
                zE = false;
            }
            if (a.this.f45234l != null) {
                a.this.f45234l.onLoadFailed(a.this.f45226d, str);
            }
            a.this.d();
            try {
                q.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, a.this.f45224b, zE, campaignExC);
            } catch (Exception unused) {
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.b
        public final void a(String str, CampaignUnit campaignUnit, boolean z11) {
            a.this.f45235m = campaignUnit;
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.b
        public final void a(String str, boolean z11) {
            if (a.this.f45235m != null) {
                try {
                    q.a(com.mbridge.msdk.foundation.controller.c.m().c(), a.this.f45235m.getAds(), a.this.f45224b, z11);
                } catch (Exception unused) {
                }
            }
            if (a.this.f45229g != null) {
                a.this.f45242t = true;
                a.this.i();
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.b
        public final void b(com.mbridge.msdk.foundation.c.b bVar) {
            boolean zE;
            CampaignEx campaignExC;
            if (a.this.f45234l != null) {
                a.this.f45234l.onLoadFailed(a.this.f45226d, "banner res load failed");
            }
            a.this.d();
            String str = "";
            if (bVar != null) {
                String strB = bVar.b();
                str = TextUtils.isEmpty(strB) ? "" : strB;
                zE = bVar.e();
                campaignExC = bVar.c();
            } else {
                zE = false;
                campaignExC = null;
            }
            q.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, a.this.f45224b, zE, campaignExC);
        }
    };

    public a(MBBannerView mBBannerView, BannerSize bannerSize, String str, String str2) {
        this.f45229g = mBBannerView;
        if (bannerSize != null) {
            this.f45230h = bannerSize.getHeight();
            this.f45231i = bannerSize.getWidth();
        }
        this.f45224b = str2;
        str = TextUtils.isEmpty(str) ? "" : str;
        this.f45225c = str;
        this.f45226d = new MBridgeIds(str, this.f45224b);
        String strK = com.mbridge.msdk.foundation.controller.c.m().k();
        String strB = com.mbridge.msdk.foundation.controller.c.m().b();
        if (this.f45238p == null) {
            this.f45238p = new j();
        }
        this.f45238p.a(com.mbridge.msdk.foundation.controller.c.m().c(), strK, strB, this.f45224b);
        h();
    }

    private int b(int i11) {
        if (i11 <= 0) {
            return i11;
        }
        if (i11 < 10) {
            return 10;
        }
        if (i11 > 180) {
            return 180;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        BannerAdListener bannerAdListener = this.f45234l;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.f45226d, str);
        }
        ad.b(f45223a, "showFailed:" + str);
        d();
    }

    private void h() {
        k kVarD = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f45224b);
        this.f45237o = kVarD;
        if (kVarD == null) {
            this.f45237o = k.d(this.f45224b);
        }
        if (this.f45233k == -1) {
            this.f45232j = b(this.f45237o.q());
        }
        if (this.f45228f == 0) {
            boolean z11 = this.f45237o.f() == 1;
            this.f45227e = z11;
            c cVar = this.f45236n;
            if (cVar != null) {
                cVar.a(z11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f45241s || !this.f45242t) {
            return;
        }
        MBBannerView mBBannerView = this.f45229g;
        if (this.f45235m != null) {
            if (this.f45236n == null) {
                this.f45236n = new c(mBBannerView, this.f45244v, this.f45225c, this.f45224b, this.f45227e, this.f45237o);
            }
            this.f45236n.b(this.f45239q);
            this.f45236n.c(this.f45240r);
            this.f45236n.a(this.f45227e, this.f45228f);
            this.f45236n.a(this.f45235m);
        } else {
            b("banner show failed because campain is exception");
        }
        this.f45242t = false;
    }

    private void j() {
        MBBannerView mBBannerView = this.f45229g;
        if (mBBannerView != null) {
            if (!this.f45239q || !this.f45240r || this.f45243u || aq.a(mBBannerView, 1)) {
                com.mbridge.msdk.mbbanner.common.c.a.a().a(2, this.f45225c, this.f45224b, null, null);
            } else {
                com.mbridge.msdk.mbbanner.common.c.a.a().a(3, this.f45225c, this.f45224b, new b(this.f45231i + "x" + this.f45230h, this.f45232j * 1000), this.f45245w);
            }
            if (this.f45239q) {
                return;
            }
            com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.f45225c, this.f45224b, null, null);
            com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f45224b);
        }
    }

    private void k() {
        j();
        c cVar = this.f45236n;
        if (cVar != null) {
            cVar.b(this.f45239q);
            this.f45236n.c(this.f45240r);
        }
    }

    public final String a() {
        CampaignUnit campaignUnit = this.f45235m;
        return (campaignUnit == null || campaignUnit.getRequestId() == null) ? "" : this.f45235m.getRequestId();
    }

    public final void a(int i11) {
        int iB = b(i11);
        this.f45233k = iB;
        this.f45232j = iB;
    }

    public final void a(int i11, int i12, int i13, int i14) {
        c cVar = this.f45236n;
        if (cVar != null) {
            cVar.a(i11, i12, i13, i14);
        }
    }

    public final void a(BannerAdListener bannerAdListener) {
        this.f45234l = bannerAdListener;
    }

    public final void a(BannerSize bannerSize) {
        if (bannerSize != null) {
            this.f45230h = bannerSize.getHeight();
            this.f45231i = bannerSize.getWidth();
        }
    }

    public final void a(String str) {
        if (this.f45230h < 1 || this.f45231i < 1) {
            BannerAdListener bannerAdListener = this.f45234l;
            if (bannerAdListener != null) {
                bannerAdListener.onLoadFailed(this.f45226d, "banner load failed because params are exception");
                return;
            }
            return;
        }
        try {
            if (com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(com.mbridge.msdk.foundation.controller.c.m().c())) {
                b bVar = new b(this.f45231i + "x" + this.f45230h, this.f45232j * 1000);
                bVar.a(str);
                bVar.b(this.f45225c);
                com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f45225c, this.f45224b, bVar, this.f45245w);
                com.mbridge.msdk.mbbanner.common.c.a.a().a(1, this.f45225c, this.f45224b, bVar, this.f45245w);
                return;
            }
        } catch (Exception unused) {
        }
        BannerAdListener bannerAdListener2 = this.f45234l;
        if (bannerAdListener2 != null) {
            bannerAdListener2.onLoadFailed(this.f45226d, "banner load failed because WebView is not available");
        }
    }

    public final void a(boolean z11) {
        this.f45227e = z11;
        this.f45228f = z11 ? 1 : 2;
    }

    public final String b() {
        CampaignUnit campaignUnit = this.f45235m;
        return campaignUnit != null ? com.mbridge.msdk.foundation.same.b.a(campaignUnit.getAds()) : "";
    }

    public final void b(boolean z11) {
        this.f45239q = z11;
        k();
        i();
    }

    public final void c() {
        this.f45241s = true;
        if (this.f45234l != null) {
            this.f45234l = null;
        }
        if (this.f45245w != null) {
            this.f45245w = null;
        }
        if (this.f45244v != null) {
            this.f45244v = null;
        }
        if (this.f45229g != null) {
            this.f45229g = null;
        }
        com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.f45225c, this.f45224b, null, null);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f45224b);
        com.mbridge.msdk.mbbanner.common.c.a.a().b();
        c cVar = this.f45236n;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void c(boolean z11) {
        this.f45240r = z11;
        k();
    }

    public final void d() {
        if (this.f45241s) {
            return;
        }
        j();
        h();
        b bVar = new b(this.f45231i + "x" + this.f45230h, this.f45232j * 1000);
        bVar.b(this.f45225c);
        bVar.a(true);
        com.mbridge.msdk.mbbanner.common.c.a.a().b(this.f45225c, this.f45224b, bVar, this.f45245w);
    }

    public final void e() {
        com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.f45225c, this.f45224b, new b(this.f45231i + "x" + this.f45230h, this.f45232j * 1000), this.f45245w);
    }

    public final void f() {
        com.mbridge.msdk.mbbanner.common.c.a.a().a(3, this.f45225c, this.f45224b, new b(this.f45231i + "x" + this.f45230h, this.f45232j * 1000), this.f45245w);
    }
}
