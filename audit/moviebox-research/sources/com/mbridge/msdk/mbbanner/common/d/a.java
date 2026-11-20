package com.mbridge.msdk.mbbanner.common.d;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.e.b;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.net.URLEncoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static void a(com.mbridge.msdk.mbbanner.common.a.a aVar, String str) {
        if (aVar != null) {
            aVar.a("2000068");
            if (j.a().b()) {
                j.a().a(aVar.b());
            } else {
                m.a(aVar.b(), c.m().c(), str);
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
            sb2.append("rid_n");
            sb2.append("=");
            sb2.append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
            sb2.append("&");
            sb2.append("rid");
            sb2.append("=");
            sb2.append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
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
                aVar.post(0, d.f().f44626c, q.a(sb2.toString(), c.m().c(), str), new b() { // from class: com.mbridge.msdk.mbbanner.common.d.a.1
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
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }
}
