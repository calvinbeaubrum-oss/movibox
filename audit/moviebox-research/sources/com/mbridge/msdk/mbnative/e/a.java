package com.mbridge.msdk.mbnative.e;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.out.Campaign;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static void a(final Context context, String str, String str2, boolean z11, CampaignEx campaignEx) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000047&");
                stringBuffer.append("network_type=" + z.l(context) + "&");
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("st=" + System.currentTimeMillis() + "&");
                if (campaignEx != null) {
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("adtp=" + campaignEx.getAdType() + "&");
                    stringBuffer.append("rid=" + campaignEx.getRequestId());
                    stringBuffer.append("&");
                    stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                }
                if (!TextUtils.isEmpty(str2)) {
                    String str3 = com.mbridge.msdk.foundation.controller.a.f44041b.get(str2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("u_stid=");
                    if (str3 == null) {
                        str3 = "";
                    }
                    sb2.append(str3);
                    sb2.append("&");
                    stringBuffer.append(sb2.toString());
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.U)) {
                    stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.U + "&");
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f44371g)) {
                    stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.f44371g + "&");
                }
                if (z11) {
                    stringBuffer.append("hb=1&");
                }
                stringBuffer.append("reason=" + str);
                if (j.a().b()) {
                    j.a().a(stringBuffer.toString());
                    return;
                }
                final String string = stringBuffer.toString();
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                try {
                    new com.mbridge.msdk.foundation.same.report.e.a(context).post(0, d.f().f44626c, q.a(string, context), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.mbnative.e.a.2
                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onFailed(String str4) {
                            l lVar = new l();
                            lVar.a(string);
                            lVar.a(System.currentTimeMillis());
                            lVar.a(0);
                            lVar.b("POST");
                            lVar.c(d.f().f44626c);
                            n.a(h.a(context)).a(lVar);
                            ad.b("NativeReport", str4);
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onSuccess(String str4) {
                            ad.b("NativeReport", str4);
                        }
                    });
                } catch (Exception e11) {
                    e11.printStackTrace();
                    ad.b("NativeReport", e11.getMessage());
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void a(final Context context, List<Campaign> list, String str) {
        if (context == null || list == null) {
            return;
        }
        try {
            if (list.size() <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000048&");
            stringBuffer.append("st=" + System.currentTimeMillis() + "&");
            if (list.size() > 0) {
                stringBuffer.append("cid=" + list.get(0).getId() + "&");
            }
            stringBuffer.append("network_type=" + z.l(context) + "&");
            stringBuffer.append("unit_id=" + str + "&");
            if (list.size() > 1) {
                CampaignEx campaignEx = (CampaignEx) list.get(0);
                if (campaignEx.isBidCampaign()) {
                    stringBuffer.append("hb=");
                    stringBuffer.append(1);
                    stringBuffer.append("&");
                }
                if (ai.c(campaignEx)) {
                    stringBuffer.append("rtins_type=");
                    stringBuffer.append(campaignEx.getRtinsType());
                    stringBuffer.append("&");
                }
                stringBuffer.append("rid=" + campaignEx.getRequestId() + "&");
                stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
            } else if (list.size() == 1) {
                CampaignEx campaignEx2 = (CampaignEx) list.get(0);
                if (campaignEx2.isBidCampaign()) {
                    stringBuffer.append("hb=");
                    stringBuffer.append(1);
                    stringBuffer.append("&");
                }
                if (ai.c(campaignEx2)) {
                    stringBuffer.append("rtins_type=");
                    stringBuffer.append(campaignEx2.getRtinsType());
                    stringBuffer.append("&");
                }
                stringBuffer.append("rid=" + campaignEx2.getRequestId() + "&");
                stringBuffer.append("rid_n=" + campaignEx2.getRequestIdNotice());
            }
            if (j.a().b()) {
                j.a().a(stringBuffer.toString());
                return;
            }
            final String string = stringBuffer.toString();
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                new com.mbridge.msdk.foundation.same.report.e.a(context).post(0, d.f().f44626c, q.a(string, context, str), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.mbnative.e.a.1
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str2) {
                        l lVar = new l();
                        lVar.a(string);
                        lVar.a(System.currentTimeMillis());
                        lVar.a(0);
                        lVar.b("POST");
                        lVar.c(d.f().f44626c);
                        n.a(h.a(context)).a(lVar);
                        ad.b("NativeReport", str2);
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str2) {
                        ad.b("NativeReport", str2);
                    }
                });
            } catch (Exception e11) {
                e11.printStackTrace();
                ad.b("NativeReport", e11.getMessage());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar, CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.d.a.a aVar) {
        try {
            c.a().a(str, bVar, campaignEx, context, aVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }
}
