package com.mbridge.msdk.splash.e;

import android.content.Context;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.e.b;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.splash.a.c;
import java.net.URLEncoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static void a(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().l() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, long j11, int i11) {
        if (campaignEx != null) {
            try {
                if (campaignEx.isMraid()) {
                    n nVar = new n();
                    nVar.f(campaignEx.getRequestId());
                    nVar.g(campaignEx.getRequestIdNotice());
                    nVar.e(campaignEx.getId());
                    nVar.b(i11);
                    nVar.l(String.valueOf(System.currentTimeMillis() - j11));
                    nVar.n("");
                    nVar.h(str2);
                    nVar.d(PrepareException.ERROR_NO_URL);
                    nVar.d(n.f44338a);
                    m.b(nVar, str, campaignEx);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str) {
        a(campaignEx, "", 1, str);
    }

    private static void a(CampaignEx campaignEx, String str, int i11, String str2) {
        a(c.a().c(campaignEx.getId()).b(str2).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).f(str).b(i11).a(campaignEx.isBidCampaign()), str2);
    }

    public static void a(CampaignEx campaignEx, String str, String str2) {
        a(campaignEx, str, 2, str2);
    }

    private static void a(c cVar, String str) {
        if (cVar != null) {
            cVar.a("2000068");
            if (j.a().b()) {
                j.a().a(cVar.b());
            } else {
                m.a(cVar.b(), com.mbridge.msdk.foundation.controller.c.m().c(), str);
            }
        }
    }

    public static void a(c cVar, String str, int i11) {
        if (cVar != null) {
            cVar.a("2000069");
            cVar.a(i11);
            if (j.a().b()) {
                j.a().a(cVar.b());
            } else {
                m.a(cVar.b(), com.mbridge.msdk.foundation.controller.c.m().c(), str);
            }
        }
    }

    public static void a(String str, CampaignEx campaignEx) {
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        n nVar = new n("2000061", campaignEx.getId(), campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), str, z.l(com.mbridge.msdk.foundation.controller.c.m().c()));
        nVar.d(n.f44338a);
        m.b(nVar, com.mbridge.msdk.foundation.controller.c.m().c(), str);
    }

    public static void a(String str, CampaignEx campaignEx, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.c.m().c());
            StringBuilder sb2 = new StringBuilder();
            if (campaignEx.isBidCampaign()) {
                sb2.append("hb=");
                sb2.append(1);
                sb2.append("&");
            }
            sb2.append("key");
            sb2.append("=");
            sb2.append(URLEncoder.encode("2000070", "utf-8"));
            sb2.append("&");
            sb2.append("rid");
            sb2.append("=");
            sb2.append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
            sb2.append("&");
            sb2.append("rid_n");
            sb2.append("=");
            sb2.append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
            sb2.append("&");
            sb2.append(BidResponsedEx.KEY_CID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(campaignEx.getId(), "utf-8"));
            sb2.append("&");
            sb2.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(str, "utf-8"));
            sb2.append("&");
            sb2.append(CampaignEx.JSON_KEY_CLICK_URL);
            sb2.append("=");
            sb2.append(URLEncoder.encode(str2, "utf-8"));
            sb2.append("&");
            sb2.append("network_type");
            sb2.append("=");
            sb2.append(URLEncoder.encode(String.valueOf(z.l(com.mbridge.msdk.foundation.controller.c.m().c())), "utf-8"));
            if (j.a().b()) {
                j.a().a(sb2.toString());
            } else {
                aVar.post(0, d.f().f44626c, q.a(sb2.toString(), com.mbridge.msdk.foundation.controller.c.m().c(), str), new b() { // from class: com.mbridge.msdk.splash.e.a.1
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str3) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str3) {
                    }
                });
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public static void b(CampaignEx campaignEx, String str) {
        try {
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.c.m().c());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("key");
            sb2.append("=");
            sb2.append(URLEncoder.encode("2000092", "utf-8"));
            sb2.append("&");
            sb2.append("rid");
            sb2.append("=");
            sb2.append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
            sb2.append("&");
            sb2.append("rid_n");
            sb2.append("=");
            sb2.append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
            sb2.append("&");
            sb2.append(BidResponsedEx.KEY_CID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(campaignEx.getId(), "utf-8"));
            sb2.append("&");
            sb2.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(str, "utf-8"));
            sb2.append("&");
            sb2.append("network_type");
            sb2.append("=");
            sb2.append(URLEncoder.encode(String.valueOf(z.l(com.mbridge.msdk.foundation.controller.c.m().c())), "utf-8"));
            if (j.a().b()) {
                j.a().a(sb2.toString());
            } else {
                aVar.post(0, d.f().f44626c, q.a(sb2.toString(), com.mbridge.msdk.foundation.controller.c.m().c(), str), new b() { // from class: com.mbridge.msdk.splash.e.a.2
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str2) {
                        ad.a("", "FLBClick REPORT FAILED");
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str2) {
                        ad.a("", "FLBClick REPORT SUCCESS");
                    }
                });
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }
}
