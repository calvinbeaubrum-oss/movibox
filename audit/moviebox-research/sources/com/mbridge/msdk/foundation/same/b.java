package com.mbridge.msdk.foundation.same;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        public abstract void a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar);
    }

    public static String a(List<CampaignEx> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (CampaignEx campaignEx : list) {
            if (campaignEx != null && campaignEx.getCreativeId() != 0) {
                arrayList.add(campaignEx);
            }
        }
        if (arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            try {
                CampaignEx campaignEx2 = (CampaignEx) arrayList.get(i11);
                if (campaignEx2 != null) {
                    long creativeId = campaignEx2.getCreativeId();
                    if (i11 == arrayList.size() - 1) {
                        sb2.append(creativeId);
                    } else {
                        sb2.append(creativeId);
                        sb2.append(",");
                    }
                }
            } catch (Exception e11) {
                ad.a("SameCommon", "getCreativeID", e11);
            }
        }
        return sb2.toString();
    }

    public static void a(CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.d.b bVar, a aVar) {
        if (campaignEx == null || aVar == null) {
            return;
        }
        if (bVar == null) {
            try {
                bVar = new com.mbridge.msdk.foundation.same.report.d.b();
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        }
        boolean zC = ai.c(campaignEx);
        int iD = ai.d(context, campaignEx.getPackageName());
        d dVar = new d();
        dVar.a(BidResponsedEx.KEY_CID, campaignEx.getId());
        dVar.a(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
        dVar.a(CampaignEx.JSON_KEY_RETARGET_OFFER, Integer.valueOf(campaignEx.getRetarget_offer()));
        dVar.a("ind", Integer.valueOf(iD));
        dVar.a("stage", 1);
        if (zC) {
            if (iD != 1) {
                bVar.a("m_campaign_filtered", dVar);
                aVar.a("m_campaign_filtered", bVar);
            }
            bVar.a("m_campaign_ind_retarget", dVar);
            aVar.a("m_campaign_ind_retarget", bVar);
            return;
        }
        if (iD == 1) {
            bVar.a("m_campaign_filtered", dVar);
            aVar.a("m_campaign_filtered", bVar);
        }
        bVar.a("m_campaign_ind_unretarget", dVar);
        aVar.a("m_campaign_ind_unretarget", bVar);
    }

    public static boolean a(Context context, CampaignEx campaignEx) {
        if (context != null && campaignEx != null) {
            boolean zC = ai.c(context, campaignEx.getPackageName());
            if (ai.c(campaignEx) || campaignEx.getWtick() == 1 || !zC) {
                return true;
            }
        }
        return false;
    }
}
