package com.mbridge.msdk.video.dynview.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.out.Campaign;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f47584a = "com.mbridge.msdk.video.dynview.f.a";

    public static void a(Context context, CampaignEx campaignEx, String str, View view) {
        if (context == null || campaignEx == null) {
            return;
        }
        if (campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().l() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
        }
        com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(context, str);
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup) view;
            aVar.a(new i() { // from class: com.mbridge.msdk.video.dynview.f.a.2
                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onFinishRedirection(Campaign campaign, String str2) {
                    if (campaign == null) {
                        return;
                    }
                    ah.a(campaign, viewGroup);
                }

                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onRedirectionFailed(Campaign campaign, String str2) {
                    if (campaign == null) {
                        return;
                    }
                    ah.a(campaign, viewGroup);
                }

                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onStartRedirection(Campaign campaign, String str2) {
                    if (campaign == null) {
                        return;
                    }
                    ah.b(campaign, viewGroup);
                }
            });
        }
        aVar.a(campaignEx);
    }

    public static void a(CampaignEx campaignEx, Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000091&");
                stringBuffer.append("network_type=" + z.l(context) + "&");
                stringBuffer.append("unit_id=" + str2 + "&");
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.U)) {
                    stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.U + "&");
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f44371g)) {
                    stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.f44371g + "&");
                }
                stringBuffer.append("hb=0&");
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append("rid_n=");
                    stringBuffer.append(str3);
                    stringBuffer.append("&");
                }
                stringBuffer.append("reason=" + str);
                if (campaignEx != null && campaignEx.getRewardTemplateMode() != null) {
                    stringBuffer.append("&dyview=");
                    stringBuffer.append(ai.b(campaignEx.getRewardTemplateMode().e()));
                }
                if (j.a().b()) {
                    j.a().a(stringBuffer.toString());
                    return;
                }
                String string = stringBuffer.toString();
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                try {
                    new com.mbridge.msdk.foundation.same.report.e.a(context).post(0, d.f().f44626c, q.a(string, context), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.video.dynview.f.a.1
                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onFailed(String str4) {
                            ad.b(a.f47584a, str4);
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onSuccess(String str4) {
                            ad.b(a.f47584a, str4);
                        }
                    });
                } catch (Exception e11) {
                    e11.printStackTrace();
                    ad.b(f47584a, e11.getMessage());
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009b  */
    /* JADX WARN: Code duplicated, block: B:35:? A[RETURN, SYNTHETIC] */
    public static void a(CampaignUnit campaignUnit, int i11, int i12, String str) {
        int i13;
        String impressionURL;
        int i14;
        String str2;
        if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0 || campaignUnit.getAds().get(i11) == null) {
            return;
        }
        if (i12 == 0 && campaignUnit.getAds().get(i11).mMoreOfferImpShow) {
            return;
        }
        String strA = ao.a(campaignUnit.getAds().get(i11).getendcard_url(), "mof_testuid");
        if (TextUtils.isEmpty(strA)) {
            strA = ao.a(campaignUnit.getAds().get(i11).getendcard_url(), "mof_uid");
        }
        String str3 = TextUtils.isEmpty(strA) ? str : strA;
        if (i12 != 0) {
            if (i12 != 1) {
                str2 = "";
                i14 = 0;
            } else {
                i13 = com.mbridge.msdk.click.a.a.f43073h;
                impressionURL = campaignUnit.getAds().get(i11).getOnlyImpressionURL();
            }
            if (TextUtils.isEmpty(str2)) {
            }
            com.mbridge.msdk.click.a.a(c.m().c(), campaignUnit.getAds().get(i11), str3, str2, false, true, i14);
        }
        i13 = com.mbridge.msdk.click.a.a.f43072g;
        impressionURL = campaignUnit.getAds().get(i11).getImpressionURL();
        i14 = i13;
        str2 = impressionURL;
        if (TextUtils.isEmpty(str2)) {
            com.mbridge.msdk.click.a.a(c.m().c(), campaignUnit.getAds().get(i11), str3, str2, false, true, i14);
        }
    }
}
