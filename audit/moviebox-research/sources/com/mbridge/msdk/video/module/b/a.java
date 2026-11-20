package com.mbridge.msdk.video.module.b;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ao;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static void a(String str, CampaignEx campaignEx, d dVar) {
        String strA;
        String strA2;
        if (TextUtils.isEmpty(str) || campaignEx == null || dVar == null) {
            return;
        }
        try {
            String mof_template_url = campaignEx.getMof_template_url();
            String strA3 = "";
            if (TextUtils.isEmpty(mof_template_url)) {
                strA = "";
                strA2 = strA;
            } else {
                strA2 = ao.a(mof_template_url, "cltp");
                strA = ao.a(mof_template_url, "xt");
            }
            if (!TextUtils.isEmpty(strA2)) {
                dVar.a("cltp", strA2);
            }
            if (!TextUtils.isEmpty(strA)) {
                dVar.a("xt", strA);
            }
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null) {
                String strE = rewardTemplateMode.e();
                if (!TextUtils.isEmpty(strE)) {
                    strA3 = ao.a(strE, "alecfc");
                }
            }
            if (!TextUtils.isEmpty(strA3)) {
                dVar.a("alecfc", strA3);
            }
            c.a().a(str, campaignEx, dVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }
}
