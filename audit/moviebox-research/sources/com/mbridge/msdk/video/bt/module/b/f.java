package com.mbridge.msdk.video.bt.module.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.z;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f47525a = "com.mbridge.msdk.video.bt.module.b.f";

    public static void a(Context context, CampaignEx campaignEx, String str, int i11) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000054&");
            stringBuffer.append("network_type=" + z.l(context) + "&");
            stringBuffer.append("unit_id=" + str + "&");
            stringBuffer.append("cid=" + campaignEx.getId() + "&");
            stringBuffer.append("reason=&");
            stringBuffer.append("templateshowtype=" + i11 + " offer show success&");
            stringBuffer.append("result=2&");
            if (campaignEx.getAdType() == 287) {
                stringBuffer.append("ad_type=3&");
            } else if (campaignEx.getAdType() == 94) {
                stringBuffer.append("ad_type=1&");
            } else {
                stringBuffer.append("ad_type=1&");
            }
            String str2 = campaignEx.getendcard_url();
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append("creative=" + URLEncoder.encode(str2) + "&");
            }
            stringBuffer.append("devid=" + com.mbridge.msdk.foundation.tools.e.c() + "&");
            stringBuffer.append("rid=");
            stringBuffer.append(campaignEx.getRequestId());
            stringBuffer.append("&");
            stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
            stringBuffer.append("&");
            stringBuffer.append("adspace_t=");
            stringBuffer.append(campaignEx.getAdSpaceT());
            if (j.a().b()) {
                j.a().a(stringBuffer.toString());
            } else {
                a(context, stringBuffer.toString(), str);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i11) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str2))) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000054&");
                stringBuffer.append("network_type=" + z.l(context) + "&");
                stringBuffer.append("unit_id=" + str + "&");
                stringBuffer.append("cid=" + campaignEx.getId() + "&");
                stringBuffer.append("reason=" + str2 + "&");
                stringBuffer.append("templateshowtype=" + i11 + "&");
                stringBuffer.append("reason=" + str2 + "&");
                stringBuffer.append("result=1&");
                if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                    stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                }
                stringBuffer.append("devid=" + com.mbridge.msdk.foundation.tools.e.c() + "&");
                if (campaignEx.getAdType() == 287) {
                    stringBuffer.append("ad_type=3&");
                } else if (campaignEx.getAdType() == 94) {
                    stringBuffer.append("ad_type=1&");
                } else {
                    stringBuffer.append("ad_type=1&");
                }
                stringBuffer.append("rid=");
                stringBuffer.append(campaignEx.getRequestId());
                stringBuffer.append("&");
                stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
                stringBuffer.append("&");
                stringBuffer.append("adspace_t=" + campaignEx.getAdSpaceT());
                if (j.a().b()) {
                    j.a().a(stringBuffer.toString());
                } else {
                    a(context, stringBuffer.toString(), str);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                q qVarA = q.a(com.mbridge.msdk.foundation.db.h.a(context));
                if (TextUtils.isEmpty(str) || qVarA == null || qVarA.a() <= 0) {
                    return;
                }
                List<n> listA = qVarA.a("m_download_end");
                List<n> listA2 = qVarA.a("2000021");
                List<n> listA3 = qVarA.a("2000039");
                List<n> listA4 = qVarA.a("m_download_end");
                List<n> listA5 = qVarA.a("m_download_end");
                List<n> listA6 = qVarA.a("2000044");
                String strE = n.e(listA2);
                String strA = n.a(listA);
                String strC = n.c(listA3);
                String strB = n.b(listA4);
                String strF = n.f(listA5);
                String strD = n.d(listA6);
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
                    com.mbridge.msdk.foundation.same.net.h.e eVarA = com.mbridge.msdk.foundation.same.report.q.a(string, context, str);
                    eVarA.a("r_stid", com.mbridge.msdk.videocommon.d.b.a().b().b());
                    aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, eVarA, new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.video.bt.module.b.f.1
                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onFailed(String str2) {
                            ad.b(f.f47525a, str2);
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onSuccess(String str2) {
                            ad.b(f.f47525a, str2);
                        }
                    });
                } catch (Exception e11) {
                    e11.printStackTrace();
                    ad.b(f47525a, e11.getMessage());
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    private static void a(final Context context, final String str, String str2) {
        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
            context = com.mbridge.msdk.foundation.controller.c.m().c();
        }
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(context);
            com.mbridge.msdk.foundation.same.net.h.e eVarA = com.mbridge.msdk.foundation.same.report.q.a(str, context, str2);
            eVarA.a("r_stid", com.mbridge.msdk.videocommon.d.b.a().b().b());
            aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, eVarA, new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.video.bt.module.b.f.2
                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onFailed(final String str3) {
                    com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.b.f.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            l lVar = new l();
                            lVar.a(str);
                            lVar.a(System.currentTimeMillis());
                            lVar.a(0);
                            lVar.b("POST");
                            lVar.c(com.mbridge.msdk.foundation.same.net.g.d.f().f44626c);
                            com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(context)).a(lVar);
                            ad.b(f.f47525a, str3);
                        }
                    });
                }

                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onSuccess(String str3) {
                    ad.b(f.f47525a, str3);
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
            ad.b(f47525a, e11.getMessage());
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str) {
        if (context == null || list == null) {
            return;
        }
        try {
            if (list.size() <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000054&");
            stringBuffer.append("network_type=" + z.l(context) + "&");
            stringBuffer.append("unit_id=" + str + "&");
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < list.size(); i11++) {
                arrayList.add(list.get(i11).getId());
            }
            stringBuffer.append("cid=" + arrayList.toString() + "&");
            stringBuffer.append("result=2&");
            if (list.get(0) != null) {
                CampaignEx campaignEx = list.get(0);
                stringBuffer.append("reason=&");
                stringBuffer.append("templateshowtype=two offer ec show success&");
                stringBuffer.append("ad_type=" + campaignEx.getAdType() + "&");
                stringBuffer.append("devid=" + com.mbridge.msdk.foundation.tools.e.c() + "&");
                stringBuffer.append("rid=");
                stringBuffer.append(campaignEx.getRequestId());
                stringBuffer.append("&");
                stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
                stringBuffer.append("&");
                stringBuffer.append("&adspace_t=");
                stringBuffer.append(campaignEx.getAdSpaceT());
            }
            if (j.a().b()) {
                j.a().a(stringBuffer.toString());
            } else {
                a(context, stringBuffer.toString(), str);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str, String str2) {
        if (context == null || list == null) {
            return;
        }
        try {
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str2))) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000054&");
                stringBuffer.append("network_type=" + z.l(context) + "&");
                stringBuffer.append("unit_id=" + str + "&");
                String[] strArr = new String[list.size()];
                for (int i11 = 0; i11 < list.size(); i11++) {
                    strArr[i11] = list.get(i11).getId();
                }
                stringBuffer.append("cid=" + strArr + "&");
                stringBuffer.append("reason=" + str2 + "&");
                stringBuffer.append("result=1&");
                stringBuffer.append("devid=" + com.mbridge.msdk.foundation.tools.e.c() + "&");
                if (list.get(0) != null) {
                    CampaignEx campaignEx = list.get(0);
                    stringBuffer.append("ad_type=" + campaignEx.getAdType() + "&");
                    stringBuffer.append("rid=");
                    stringBuffer.append(campaignEx.getRequestId());
                    stringBuffer.append("&");
                    stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
                    stringBuffer.append("&");
                    stringBuffer.append("templateshowtype=" + campaignEx.getMof_tplid());
                    stringBuffer.append("&");
                    stringBuffer.append("adspace_t=" + campaignEx.getAdSpaceT());
                }
                if (j.a().b()) {
                    j.a().a(stringBuffer.toString());
                } else {
                    a(context, stringBuffer.toString(), str);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i11) {
        try {
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            if (contextC != null && campaignEx != null && !TextUtils.isEmpty(str)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000115&");
                stringBuffer.append("network_type=" + z.l(contextC) + "&");
                stringBuffer.append("unit_id=" + str + "&");
                stringBuffer.append("cid=" + campaignEx.getId() + "&");
                stringBuffer.append("play_cur_time=" + i11 + "&");
                stringBuffer.append("reason=close ad in advance " + campaignEx.getMof_tplid() + "&");
                stringBuffer.append("result=1&");
                stringBuffer.append("devid=" + com.mbridge.msdk.foundation.tools.e.c() + "&");
                stringBuffer.append("ad_type=" + campaignEx.getAdType() + "&");
                stringBuffer.append("rid=");
                stringBuffer.append(campaignEx.getRequestId());
                stringBuffer.append("&");
                stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
                stringBuffer.append("&");
                stringBuffer.append("adspace_t=" + campaignEx.getAdSpaceT());
                if (j.a().b()) {
                    j.a().a(stringBuffer.toString());
                } else {
                    a(contextC, stringBuffer.toString(), str);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
