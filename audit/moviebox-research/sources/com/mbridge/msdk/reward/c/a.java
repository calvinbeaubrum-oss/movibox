package com.mbridge.msdk.reward.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.videocommon.d.b;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f46875a = "com.mbridge.msdk.reward.c.a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f46876b = "";

    public static void a(final Context context, CampaignEx campaignEx, String str) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000048&");
            stringBuffer.append("st=" + System.currentTimeMillis() + "&");
            stringBuffer.append("cid=" + campaignEx.getId() + "&");
            stringBuffer.append("network_type=" + z.l(context) + "&");
            stringBuffer.append("unit_id=" + str + "&");
            if (ai.c(campaignEx)) {
                stringBuffer.append("rtins_type=");
                stringBuffer.append(campaignEx.getRtinsType());
                stringBuffer.append("&");
            }
            if (campaignEx.isBidCampaign()) {
                stringBuffer.append("hb=1&");
            } else {
                stringBuffer.append("hb=0&");
            }
            stringBuffer.append("rid=" + campaignEx.getRequestId() + "&");
            stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("adspace_t=");
            sb2.append(campaignEx.getAdSpaceT());
            stringBuffer.append(sb2.toString());
            if (campaignEx.getRewardTemplateMode() != null) {
                try {
                    int iA = c.a(campaignEx, campaignEx.getRewardTemplateMode().e());
                    if (iA != -1) {
                        stringBuffer.append("&dyview=");
                        stringBuffer.append(iA);
                    }
                } catch (Exception unused) {
                }
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
                com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(context);
                e eVarA = q.a(string, context, str);
                eVarA.a("r_stid", b.a().b().b());
                aVar.post(0, d.f().f44626c, eVarA, new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.reward.c.a.2
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(final String str2) {
                        com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.reward.c.a.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                l lVar = new l();
                                lVar.a(string);
                                lVar.a(System.currentTimeMillis());
                                lVar.a(0);
                                lVar.b("POST");
                                lVar.c(d.f().f44626c);
                                n.a(h.a(context)).a(lVar);
                                ad.b(a.f46875a, str2);
                            }
                        });
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str2) {
                        ad.b(a.f46875a, str2);
                    }
                });
            } catch (Exception e11) {
                e11.printStackTrace();
                ad.b(f46875a, e11.getMessage());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                com.mbridge.msdk.foundation.db.q qVarA = com.mbridge.msdk.foundation.db.q.a(h.a(context));
                if (TextUtils.isEmpty(str) || qVarA == null || qVarA.a() <= 0) {
                    return;
                }
                List<com.mbridge.msdk.foundation.entity.n> listA = qVarA.a("m_download_end");
                List<com.mbridge.msdk.foundation.entity.n> listA2 = qVarA.a("2000021");
                List<com.mbridge.msdk.foundation.entity.n> listA3 = qVarA.a("2000039");
                List<com.mbridge.msdk.foundation.entity.n> listA4 = qVarA.a("m_download_end");
                List<com.mbridge.msdk.foundation.entity.n> listA5 = qVarA.a("m_download_end");
                List<com.mbridge.msdk.foundation.entity.n> listA6 = qVarA.a("2000044");
                String strE = com.mbridge.msdk.foundation.entity.n.e(listA2);
                String strA = com.mbridge.msdk.foundation.entity.n.a(listA);
                String strC = com.mbridge.msdk.foundation.entity.n.c(listA3);
                String strB = com.mbridge.msdk.foundation.entity.n.b(listA4);
                String strF = com.mbridge.msdk.foundation.entity.n.f(listA5);
                String strD = com.mbridge.msdk.foundation.entity.n.d(listA6);
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty(strE)) {
                    sb2.append(strE);
                }
                if (!TextUtils.isEmpty(strA)) {
                    sb2.append(strA);
                }
                if (!TextUtils.isEmpty(strC)) {
                    sb2.append(strC);
                }
                if (!TextUtils.isEmpty(strB)) {
                    sb2.append(strB);
                }
                if (!TextUtils.isEmpty(strF)) {
                    sb2.append(strF);
                }
                if (!TextUtils.isEmpty(strD)) {
                    sb2.append(strD);
                }
                if (TextUtils.isEmpty(sb2.toString())) {
                    return;
                }
                String string = sb2.toString();
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(context);
                    e eVarA = q.a(string, context, str);
                    eVarA.a("r_stid", b.a().b().b());
                    aVar.post(0, d.f().f44626c, eVarA, new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.reward.c.a.1
                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onFailed(String str2) {
                            ad.b(a.f46875a, str2);
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onSuccess(String str2) {
                            ad.b(a.f46875a, str2);
                        }
                    });
                } catch (Exception e11) {
                    e11.printStackTrace();
                    ad.b(f46875a, e11.getMessage());
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }
}
