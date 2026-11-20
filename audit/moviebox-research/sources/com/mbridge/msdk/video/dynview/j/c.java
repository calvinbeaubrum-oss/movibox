package com.mbridge.msdk.video.dynview.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.n;
import com.mbridge.msdk.foundation.tools.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public final com.mbridge.msdk.video.dynview.c a(Context context, CampaignEx campaignEx, int i11, String str) {
        String string;
        String str2;
        StringBuilder sb2;
        if (campaignEx == null) {
            return null;
        }
        try {
            long ecTemplateId = campaignEx.getEcTemplateId();
            int iR = z.r(context);
            int iA = ai.a(campaignEx.getendcard_url(), "n_logo", 1);
            if (ecTemplateId == 1302) {
                if (iR == 1) {
                    sb2 = new StringBuilder();
                    sb2.append("mbridge_reward_end_card_layout_portrait_");
                    sb2.append(ecTemplateId);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("mbridge_reward_end_card_layout_landscape_");
                    sb2.append(ecTemplateId);
                }
                string = sb2.toString();
                str2 = "template_" + str + iR + "_" + ecTemplateId;
            } else {
                string = iR == 1 ? "mbridge_reward_end_card_layout_portrait" : "mbridge_reward_end_card_layout_landscape";
                str2 = "template_" + str + iR;
            }
            List<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                arrayList = ab.a(n.a(2, i11 + "", campaignEx.getendcard_url()), str2);
            }
            return new com.mbridge.msdk.video.dynview.c.a().a(string).a(4).a(context).b(z.r(context)).b(arrayList).e(campaignEx.getDynamicTempCode()).d(i11).b(str).g(iA).a();
        } catch (Exception e11) {
            ad.b("ViewOptionWrapper", e11.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c a(Context context, List<CampaignEx> list) {
        String mof_template_url;
        int iB;
        int mof_tplid;
        int dynamicTempCode;
        if (list == null) {
            return null;
        }
        try {
            float f11 = ai.f(com.mbridge.msdk.foundation.controller.c.m().c());
            float fE = ai.e(com.mbridge.msdk.foundation.controller.c.m().c());
            List<String> arrayList = new ArrayList<>();
            if (list.size() <= 0 || list.get(0) == null) {
                mof_template_url = "";
                iB = 1;
                mof_tplid = 0;
                dynamicTempCode = 0;
            } else {
                CampaignEx campaignEx = list.get(0);
                iB = (campaignEx == null || campaignEx.getRewardTemplateMode() == null) ? 1 : campaignEx.getRewardTemplateMode().b();
                mof_tplid = list.get(0).getMof_tplid();
                mof_template_url = list.get(0).getMof_template_url();
                dynamicTempCode = list.get(0).getDynamicTempCode();
            }
            if (mof_tplid != 0 && !TextUtils.isEmpty(mof_template_url)) {
                arrayList = ab.a(n.a(0, mof_tplid + "", mof_template_url), "template_" + mof_tplid + "_" + iB);
            }
            String str = "mbridge_same_choice_one_layout_portrait";
            if (iB != 1) {
                if (iB == 2) {
                    str = "mbridge_same_choice_one_layout_landscape";
                } else if (context.getResources().getConfiguration().orientation == 2) {
                    str = "mbridge_same_choice_one_layout_landscape";
                    iB = 2;
                } else {
                    iB = 1;
                }
            }
            return new com.mbridge.msdk.video.dynview.c.a().a(context).a(str).a(1).a(fE).b(f11).a(list).b(iB).b(arrayList).e(dynamicTempCode).d(mof_tplid).a();
        } catch (Exception e11) {
            ad.b("ViewOptionWrapper", e11.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c a(View view, CampaignEx campaignEx) {
        String strE;
        int iF;
        String str;
        if (campaignEx == null) {
            return null;
        }
        try {
            List<String> arrayList = new ArrayList<>();
            String campaignUnitId = campaignEx.getCampaignUnitId();
            if (campaignEx.getRewardTemplateMode() != null) {
                iF = campaignEx.getRewardTemplateMode().f();
                strE = campaignEx.getRewardTemplateMode().e();
            } else {
                strE = "";
                iF = 0;
            }
            int iA = ai.a(strE, "ia_tp", -5);
            if (iF == 0 || iF == 102 || iF == 202) {
                str = "mbridge_reward_layer_floor";
            } else {
                str = "mbridge_reward_layer_floor_" + iF;
            }
            boolean zA = com.mbridge.msdk.video.dynview.i.a.a(strE);
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), campaignUnitId, false);
            int iG = cVarA != null ? cVarA.g() : 0;
            if (!TextUtils.isEmpty(strE)) {
                arrayList = ab.a(n.a(1, iF + "", strE), "template_" + iF);
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(campaignEx);
            return new com.mbridge.msdk.video.dynview.c.a().a(str).a(2).a(arrayList2).a(view.getContext()).a(view).c(iG).f(iA).b(z.r(view.getContext())).d(iF).a(zA).b(arrayList).e(campaignEx.getDynamicTempCode()).a();
        } catch (Exception e11) {
            ad.b("ViewOptionWrapper", e11.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c b(Context context, List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    float f11 = ai.f(com.mbridge.msdk.foundation.controller.c.m().c());
                    float fE = ai.e(com.mbridge.msdk.foundation.controller.c.m().c());
                    List<String> arrayList = new ArrayList<>();
                    int dynamicTempCode = list.get(0).getDynamicTempCode();
                    int mof_tplid = list.get(0).getMof_tplid();
                    String mof_template_url = list.get(0).getMof_template_url();
                    int iR = z.r(context);
                    if (mof_tplid != 0 && !TextUtils.isEmpty(mof_template_url)) {
                        arrayList = ab.a(n.a(0, mof_tplid + "", mof_template_url), "template_" + mof_tplid + "_" + iR);
                    }
                    return new com.mbridge.msdk.video.dynview.c.a().a(iR == 1 ? "mbridge_order_layout_list_portrait" : "mbridge_order_layout_list_landscape").a(5).a(context).a(fE).b(f11).a(list).b(iR).b(arrayList).e(dynamicTempCode).d(mof_tplid).a();
                }
            } catch (Exception e11) {
                ad.b("ViewOptionWrapper", e11.getMessage());
            }
        }
        return null;
    }

    public final com.mbridge.msdk.video.dynview.c b(View view, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), campaignEx.getCampaignUnitId(), false);
            int iG = cVarA != null ? cVarA.g() : 0;
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            return new com.mbridge.msdk.video.dynview.c.a().a("mbridge_reward_layer_floor_bottom").a(3).a(arrayList).a(view.getContext()).a(view).c(iG).b(z.r(view.getContext())).a();
        } catch (Exception e11) {
            ad.b("ViewOptionWrapper", e11.getMessage());
            return null;
        }
    }
}
