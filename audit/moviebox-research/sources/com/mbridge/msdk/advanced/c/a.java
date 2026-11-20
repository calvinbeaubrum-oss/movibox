package com.mbridge.msdk.advanced.c;

import android.content.Context;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.advanced.common.d;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.e.b;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.net.URLEncoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {
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
                    nVar.d(PrepareException.ERROR_MANIFEST_INFO);
                    nVar.d(n.f44338a);
                    m.b(nVar, str, campaignEx);
                }
            } catch (Exception e11) {
                ad.b("NativeAdvancedReport", e11.getMessage());
            }
        }
    }

    public static void a(d dVar, String str) {
        if (dVar != null) {
            dVar.a("2000067");
            if (j.a().b()) {
                j.a().a(dVar.b());
            } else {
                m.a(dVar.b(), c.m().c(), str);
            }
        }
    }

    public static void a(String str, CampaignEx campaignEx, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(c.m().c());
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
            sb2.append(URLEncoder.encode(String.valueOf(z.l(c.m().c())), "utf-8"));
            if (j.a().b()) {
                j.a().a(sb2.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, q.a(sb2.toString(), c.m().c(), str), new b() { // from class: com.mbridge.msdk.advanced.c.a.1
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str3) {
                        ad.a("", "Mraid Expand REPORT FAILED");
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str3) {
                        ad.a("", "Mraid Expand REPORT SUCCESS");
                    }
                });
            }
        } catch (Exception e11) {
            ad.b("NativeAdvancedReport", e11.getMessage());
        }
    }

    public static void b(d dVar, String str) {
        if (dVar != null) {
            dVar.a("2000068");
            if (j.a().b()) {
                j.a().a(dVar.b());
            } else {
                m.a(dVar.b(), c.m().c(), str);
            }
        }
    }
}
