package com.mbridge.msdk.video.module.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class k extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f48024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected CampaignEx f48025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<CampaignEx> f48026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f48027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.mbridge.msdk.videocommon.download.a f48028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.mbridge.msdk.videocommon.b.c f48029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f48030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f48031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected com.mbridge.msdk.video.module.a.a f48032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f48033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f48034k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f48035l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f48036m = false;

    public k(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, com.mbridge.msdk.videocommon.b.c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i11, boolean z11) {
        this.f48027d = false;
        this.f48032i = new f();
        this.f48033j = 1;
        if (!z11 && campaignEx != null && an.b(str2) && aVar != null && aVar2 != null) {
            this.f48025b = campaignEx;
            this.f48031h = str;
            this.f48030g = str2;
            this.f48028e = aVar;
            this.f48029f = cVar;
            this.f48032i = aVar2;
            this.f48024a = true;
            this.f48033j = i11;
            this.f48027d = false;
            return;
        }
        if (!z11 || campaignEx == null || !an.b(str2) || aVar2 == null) {
            return;
        }
        this.f48025b = campaignEx;
        this.f48031h = str;
        this.f48030g = str2;
        this.f48028e = aVar;
        this.f48029f = cVar;
        this.f48032i = aVar2;
        this.f48024a = true;
        this.f48033j = i11;
        this.f48027d = true;
    }

    public final void a() {
        if (!this.f48024a || this.f48025b == null) {
            return;
        }
        com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("2000061", this.f48025b.getId(), this.f48025b.getRequestId(), this.f48025b.getRequestIdNotice(), this.f48030g, z.l(com.mbridge.msdk.foundation.controller.c.m().c()));
        nVar.d(this.f48025b.isMraid() ? com.mbridge.msdk.foundation.entity.n.f44338a : com.mbridge.msdk.foundation.entity.n.f44339b);
        com.mbridge.msdk.foundation.same.report.m.b(nVar, com.mbridge.msdk.foundation.controller.c.m().c(), this.f48030g);
    }

    public final void a(int i11) {
        if (this.f48025b != null) {
            if (i11 == 1 || i11 == 2) {
                com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b, i11, this.f48033j);
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i11, Object obj) {
        super.a(i11, obj);
        this.f48032i.a(i11, obj);
    }

    public final void a(int i11, String str) {
        if (this.f48025b != null) {
            com.mbridge.msdk.foundation.same.report.m.c(new com.mbridge.msdk.foundation.entity.n("2000062", this.f48025b.getId(), this.f48025b.getRequestId(), this.f48025b.getRequestIdNotice(), this.f48030g, z.l(com.mbridge.msdk.foundation.controller.c.m().c()), i11, str), com.mbridge.msdk.foundation.controller.c.m().c(), this.f48030g);
        }
    }

    public final void a(CampaignEx campaignEx) {
        this.f48025b = campaignEx;
    }

    public final void a(String str) {
        com.mbridge.msdk.foundation.entity.n nVar;
        try {
            if (this.f48024a) {
                q qVarA = q.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                if (!TextUtils.isEmpty(this.f48025b.getNoticeUrl())) {
                    int iL = z.l(com.mbridge.msdk.foundation.controller.c.m().c());
                    nVar = new com.mbridge.msdk.foundation.entity.n("2000021", iL, this.f48025b.getNoticeUrl(), str, z.a(com.mbridge.msdk.foundation.controller.c.m().c(), iL));
                } else if (TextUtils.isEmpty(this.f48025b.getClickURL())) {
                    nVar = null;
                } else {
                    int iL2 = z.l(com.mbridge.msdk.foundation.controller.c.m().c());
                    nVar = new com.mbridge.msdk.foundation.entity.n("2000021", iL2, this.f48025b.getClickURL(), str, z.a(com.mbridge.msdk.foundation.controller.c.m().c(), iL2));
                }
                if (nVar != null) {
                    nVar.e(this.f48025b.getId());
                    nVar.m(this.f48025b.getVideoUrlEncode());
                    nVar.h(str);
                    nVar.f(this.f48025b.getRequestId());
                    nVar.g(this.f48025b.getRequestIdNotice());
                    nVar.c(this.f48030g);
                    qVarA.a(nVar);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(List<CampaignEx> list) {
        this.f48026c = list;
    }

    public final void b() {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.k.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    k kVar = k.this;
                    if (!kVar.f48024a || kVar.f48025b == null || !an.b(kVar.f48030g) || com.mbridge.msdk.foundation.controller.c.m().c() == null) {
                        return;
                    }
                    com.mbridge.msdk.foundation.db.j jVarA = com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                    com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                    fVar.a(System.currentTimeMillis());
                    fVar.b(k.this.f48030g);
                    fVar.a(k.this.f48025b.getId());
                    jVarA.a(fVar);
                } catch (Throwable th2) {
                    ad.a("NotifyListener", th2.getMessage(), th2);
                }
            }
        };
        com.mbridge.msdk.foundation.controller.d.a();
        com.mbridge.msdk.foundation.same.f.b.b().execute(runnable);
    }

    public final void b(int i11) {
        CampaignEx campaignEx = this.f48025b;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (i11 == 1 || i11 == 2) {
                if (!noticeUrl.contains("endscreen_type")) {
                    StringBuilder sb2 = new StringBuilder(noticeUrl);
                    if (noticeUrl.contains("?")) {
                        sb2.append("&endscreen_type=");
                        sb2.append(i11);
                    } else {
                        sb2.append("?endscreen_type=");
                        sb2.append(i11);
                    }
                    noticeUrl = sb2.toString();
                } else if (i11 == 2) {
                    if (noticeUrl.contains("endscreen_type=1")) {
                        noticeUrl = noticeUrl.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else if (noticeUrl.contains("endscreen_type=2")) {
                    noticeUrl = noticeUrl.replace("endscreen_type=2", "endscreen_type=1");
                }
                this.f48025b.setNoticeUrl(noticeUrl);
            }
        }
    }

    public final void b(String str) {
        List<CampaignEx> list;
        if (this.f48025b == null || (list = this.f48026c) == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("camp_position")) {
                this.f48025b = this.f48026c.get(jSONObject.getInt("camp_position"));
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("NotifyListener", e11.getMessage());
            }
        }
    }

    public final void c() {
        try {
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.k.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        k kVar = k.this;
                        if (kVar.f48024a && kVar.f48025b != null && an.b(kVar.f48030g)) {
                            com.mbridge.msdk.videocommon.a.a aVarA = com.mbridge.msdk.videocommon.a.a.a();
                            k kVar2 = k.this;
                            aVarA.a(kVar2.f48025b, kVar2.f48030g);
                        }
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                        }
                    }
                    try {
                        com.mbridge.msdk.videocommon.a.a aVarA2 = com.mbridge.msdk.videocommon.a.a.a();
                        k kVar3 = k.this;
                        aVarA2.c(kVar3.f48031h, kVar3.f48025b.getAdType());
                    } catch (Exception e12) {
                        if (MBridgeConstans.DEBUG) {
                            e12.printStackTrace();
                        }
                    } catch (Throwable th2) {
                        ad.a("NotifyListener", th2.getMessage());
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.d.a();
            com.mbridge.msdk.foundation.same.f.b.b().execute(runnable);
        } catch (Throwable th2) {
            ad.a("NotifyListener", th2.getMessage(), th2);
        }
    }

    public final void d() {
        com.mbridge.msdk.videocommon.download.a aVar = this.f48028e;
        if (aVar != null) {
            aVar.f(true);
        }
    }

    public final void e() {
        CampaignEx campaignEx;
        Map<String, Long> map;
        String str;
        try {
            CampaignEx campaignEx2 = this.f48025b;
            if (campaignEx2 != null && campaignEx2.isDynamicView() && this.f48027d && !this.f48025b.isCampaignIsFiltered()) {
                this.f48035l = true;
                return;
            }
            if (!this.f48024a || (campaignEx = this.f48025b) == null || TextUtils.isEmpty(campaignEx.getOnlyImpressionURL()) || (map = com.mbridge.msdk.foundation.same.a.d.f44407k) == null || map.containsKey(this.f48025b.getOnlyImpressionURL()) || this.f48035l) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.d.f44407k.put(this.f48025b.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
            String onlyImpressionURL = this.f48025b.getOnlyImpressionURL();
            if (this.f48025b.getSpareOfferFlag() == 1) {
                str = onlyImpressionURL + "&to=1&cbt=" + this.f48025b.getCbt() + "&tmorl=" + this.f48033j;
            } else {
                str = onlyImpressionURL + "&to=0&cbt=" + this.f48025b.getCbt() + "&tmorl=" + this.f48033j;
            }
            String str2 = str;
            if (!this.f48027d || this.f48025b.isCampaignIsFiltered()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b, this.f48030g, str2, false, true, com.mbridge.msdk.click.a.a.f43073h);
                c();
            }
            this.f48035l = true;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void f() {
        try {
            if (!this.f48024a || this.f48034k || TextUtils.isEmpty(this.f48025b.getImpressionURL())) {
                return;
            }
            this.f48034k = true;
            if (this.f48025b.isBidCampaign() && this.f48025b != null) {
                try {
                    HashMap map = new HashMap();
                    List<com.mbridge.msdk.foundation.entity.d> listA = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(this.f48025b.getCampaignUnitId(), this.f48025b.getRequestId());
                    if (listA != null && listA.size() > 0 && listA.get(0) != null) {
                        if (listA.get(0).c() == 1) {
                            map.put("encrypt_p=", "encrypt_p=" + listA.get(0).b());
                            map.put("irlfa=", "irlfa=1");
                            for (Map.Entry entry : map.entrySet()) {
                                String str = (String) entry.getKey();
                                String str2 = (String) entry.getValue();
                                CampaignEx campaignEx = this.f48025b;
                                campaignEx.setImpressionURL(campaignEx.getImpressionURL().replaceAll(str, str2));
                                CampaignEx campaignEx2 = this.f48025b;
                                campaignEx2.setOnlyImpressionURL(campaignEx2.getOnlyImpressionURL().replaceAll(str, str2));
                            }
                        }
                        ad.a("BidReplaceCampignDao", "removeReplace count " + com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(this.f48025b.getRequestId()));
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            String impressionURL = this.f48025b.getImpressionURL();
            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b, this.f48030g, this.f48025b.getSpareOfferFlag() == 1 ? impressionURL + "&to=1&cbt=" + this.f48025b.getCbt() + "&tmorl=" + this.f48033j : impressionURL + "&to=0&cbt=" + this.f48025b.getCbt() + "&tmorl=" + this.f48033j, false, true, com.mbridge.msdk.click.a.a.f43072g);
            com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b);
            new Thread(new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.k.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.mbridge.msdk.foundation.db.k.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(k.this.f48025b.getId());
                    } catch (Throwable th2) {
                        ad.a("NotifyListener", th2.getMessage(), th2);
                    }
                }
            }).start();
            if (!this.f48024a || com.mbridge.msdk.foundation.same.a.d.f44406j == null || TextUtils.isEmpty(this.f48025b.getId())) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.d.a(this.f48030g, this.f48025b, "reward");
        } catch (Throwable th2) {
            ad.a("NotifyListener", th2.getMessage(), th2);
        }
    }

    public final void g() {
        CampaignEx campaignEx;
        List<String> pv_urls;
        try {
            if (!this.f48024a || this.f48036m || (campaignEx = this.f48025b) == null) {
                return;
            }
            this.f48036m = true;
            if ((campaignEx.isDynamicView() && this.f48027d && !this.f48025b.isCampaignIsFiltered()) || (pv_urls = this.f48025b.getPv_urls()) == null || pv_urls.size() <= 0) {
                return;
            }
            Iterator<String> it = pv_urls.iterator();
            while (it.hasNext()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b, this.f48030g, it.next(), false, true);
            }
        } catch (Throwable th2) {
            ad.b("NotifyListener", th2.getMessage());
        }
    }

    public final void h() {
        CampaignEx campaignEx = this.f48025b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getCampaignUnitId()) || this.f48025b.getNativeVideoTracking() == null || this.f48025b.getNativeVideoTracking().o() == null) {
            return;
        }
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        CampaignEx campaignEx2 = this.f48025b;
        com.mbridge.msdk.click.a.a(contextC, campaignEx2, campaignEx2.getCampaignUnitId(), this.f48025b.getNativeVideoTracking().o(), false, false);
    }
}
