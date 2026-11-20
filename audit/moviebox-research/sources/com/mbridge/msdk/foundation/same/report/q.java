package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBConfiguration;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class q extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44913a = "q";

    public static com.mbridge.msdk.foundation.same.net.h.e a(Context context) {
        String str = "1";
        com.mbridge.msdk.foundation.same.net.h.e eVar = new com.mbridge.msdk.foundation.same.net.h.e();
        try {
            eVar.a(TrackingKey.PLATFORM, "1");
            eVar.a("package_name", URLEncoder.encode(z.e(context)));
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                eVar.a("os_version", Build.VERSION.RELEASE);
                eVar.a("brand", URLEncoder.encode(z.w()));
                eVar.a("model", URLEncoder.encode(z.h()));
                if (com.mbridge.msdk.f.b.a()) {
                    eVar.a("gaid", "");
                } else {
                    eVar.a("gaid", com.mbridge.msdk.foundation.tools.e.c());
                }
                eVar.a("mnc", z.k(context));
                eVar.a("mcc", z.j(context));
                int iL = z.l(context);
                eVar.a("network_type", iL + "");
                eVar.a("network_str", z.a(context, iL));
                eVar.a("language", URLEncoder.encode(z.s(context)));
                eVar.a("timezone", URLEncoder.encode(z.x()));
                eVar.a("ua", URLEncoder.encode(z.g()));
                eVar.a("adid_limit", com.mbridge.msdk.foundation.tools.e.a() + "");
                if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.b()) {
                    str = "0";
                }
                eVar.a("adid_limit_dev", str);
            }
            eVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            eVar.a("app_version_name", URLEncoder.encode(z.p(context)));
            eVar.a("orientation", URLEncoder.encode(z.r(context) + ""));
            eVar.a("screen_size", z.i(context) + "x" + z.g(context));
            if (com.mbridge.msdk.f.b.a()) {
                com.mbridge.msdk.foundation.same.net.h.f.b(eVar);
            }
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = com.mbridge.msdk.c.i.a();
            }
            if (gVarB != null) {
                JSONObject jSONObjectA = r.a(context, gVarB);
                if (!TextUtils.isEmpty(jSONObjectA.toString())) {
                    String strB = x.b(jSONObjectA.toString());
                    if (!TextUtils.isEmpty(strB)) {
                        eVar.a("dvi", strB);
                    }
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return eVar;
    }

    public static com.mbridge.msdk.foundation.same.net.h.e a(Context context, String str) {
        com.mbridge.msdk.foundation.same.net.h.e eVarA = a(context);
        eVarA.a("app_id", com.mbridge.msdk.foundation.controller.c.m().k() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                eVarA.a("data", URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        return eVarA;
    }

    public static com.mbridge.msdk.foundation.same.net.h.e a(String str, Context context) {
        com.mbridge.msdk.foundation.same.net.h.e eVarA = a(context);
        eVarA.a("app_id", com.mbridge.msdk.foundation.controller.c.m().k() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                eVarA.a("data", URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        eVarA.a("m_sdk", "msdk");
        return eVarA;
    }

    public static com.mbridge.msdk.foundation.same.net.h.e a(String str, Context context, String str2) {
        com.mbridge.msdk.foundation.same.net.h.e eVarA = a(context);
        eVarA.a("app_id", com.mbridge.msdk.foundation.controller.c.m().k() + "");
        eVarA.a(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
        try {
            if (!TextUtils.isEmpty(str2)) {
                String str3 = com.mbridge.msdk.foundation.controller.a.f44041b.get(str2);
                if (TextUtils.isEmpty(str)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("u_stid=");
                    sb2.append(str3 != null ? str3 : "");
                    str = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append("&");
                    sb3.append("u_stid");
                    sb3.append("=");
                    sb3.append(str3 != null ? str3 : "");
                    str = sb3.toString();
                }
            }
            eVarA.a("data", URLEncoder.encode(str, "utf-8"));
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
        }
        eVarA.a("m_sdk", "msdk");
        return eVarA;
    }

    public static com.mbridge.msdk.foundation.same.net.h.e a(String str, String str2, Context context, String str3) {
        String string;
        if (context != null) {
            context = context.getApplicationContext();
        }
        com.mbridge.msdk.foundation.same.net.h.e eVar = new com.mbridge.msdk.foundation.same.net.h.e();
        eVar.a("m_device_info", c(context, str3));
        eVar.a("m_action", str);
        try {
            if (TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                String str4 = com.mbridge.msdk.foundation.controller.a.f44041b.get(str3);
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject.put("u_stid", str4);
                }
                string = jSONObject.toString();
            } else {
                String strA = Aa.a();
                if (strA == null) {
                    strA = "";
                }
                JSONObject jSONObject2 = new JSONObject(str2);
                jSONObject2.put("channel", strA);
                String str5 = com.mbridge.msdk.foundation.controller.a.f44041b.get(str3);
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("u_stid", str5 != null ? str5 : "");
                }
                string = jSONObject2.toString();
            }
            str2 = string;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        eVar.a("m_data", str2);
        eVar.a("m_sdk", "msdk");
        return eVar;
    }

    public static String a(Campaign campaign, int i11, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", "adtrack");
            jSONObject.put("action", str);
            jSONObject.put("label", i11);
            if (campaign != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", campaign.getId());
                jSONObject2.put(CampaignEx.JSON_KEY_TITLE, campaign.getAppName());
                jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, jSONObject2);
            } else {
                jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
            }
        } catch (Exception e11) {
            ad.b(f44913a, e11.getMessage());
        }
        return jSONObject.toString();
    }

    public static String a(String str, Map<String, Object> map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("key=" + str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                sb2.append("&" + entry.getKey() + "=" + entry.getValue());
            }
        }
        sb2.append("\n");
        return sb2.toString();
    }

    public static JSONObject a(Context context, com.mbridge.msdk.c.g gVar) throws Exception {
        return r.a(context, gVar);
    }

    public static void a(int i11, String str, String str2) {
        try {
            new com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.c.m().c()).post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, a("key=2000080&reason=" + str2 + "&ad_type=" + i11 + "&url=" + URLEncoder.encode(str, "utf-8"), com.mbridge.msdk.foundation.controller.c.m().c(), ""), null);
        } catch (Exception e11) {
            ad.b(f44913a, e11.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, int i11, String str, String str2) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000114&");
            stringBuffer.append("network_type=" + z.l(context) + "&");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("gh_id=");
            String strEncode = "";
            sb2.append(TextUtils.isEmpty(campaignEx.getGhId()) ? "" : URLEncoder.encode(campaignEx.getGhId(), "utf-8"));
            sb2.append("&");
            stringBuffer.append(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("gh_path=");
            sb3.append(TextUtils.isEmpty(campaignEx.getGhPath()) ? "" : URLEncoder.encode(campaignEx.getGhPath(), "utf-8"));
            sb3.append("&");
            stringBuffer.append(sb3.toString());
            stringBuffer.append("unit_id=" + str2 + "&");
            stringBuffer.append("rid=");
            stringBuffer.append(campaignEx.getRequestId());
            stringBuffer.append("&");
            stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
            stringBuffer.append("result=" + i11 + "&");
            StringBuilder sb4 = new StringBuilder();
            sb4.append("reason=");
            if (!TextUtils.isEmpty(str)) {
                strEncode = URLEncoder.encode(str, "utf-8");
            }
            sb4.append(strEncode);
            sb4.append("&");
            stringBuffer.append(sb4.toString());
            stringBuffer.append("cid=" + campaignEx.getId());
            if (j.a().b()) {
                j.a().a(stringBuffer.toString());
            } else {
                a(context, stringBuffer.toString(), str2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str2))) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000054&");
                    stringBuffer.append("network_type=" + z.l(context) + "&");
                    stringBuffer.append("unit_id=" + str + "&");
                    stringBuffer.append("reason=" + str2 + "&");
                    stringBuffer.append("result=1&");
                    stringBuffer.append("devid=" + com.mbridge.msdk.foundation.tools.e.c() + "&");
                    if (campaignEx != null) {
                        stringBuffer.append("cid=" + campaignEx.getId() + "&");
                        if (campaignEx.getAdType() == 287) {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=3&");
                        } else if (campaignEx.getAdType() == 94) {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=1&");
                        } else if (campaignEx.getAdType() == 296) {
                            stringBuffer.append("ad_type=5&");
                            stringBuffer.append("creative=" + campaignEx.getCreativeId() + "&");
                        } else if (campaignEx.getAdType() == 297) {
                            stringBuffer.append("ad_type=6&");
                            stringBuffer.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            stringBuffer.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else if (campaignEx.getAdType() == 298) {
                            stringBuffer.append("ad_type=7&");
                            stringBuffer.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            stringBuffer.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=1&");
                        }
                        stringBuffer.append("rid=");
                        stringBuffer.append(campaignEx.getRequestId());
                        stringBuffer.append("&");
                        stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
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
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i11, int i12) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000074&");
            stringBuffer.append("network_type=" + z.l(context) + "&");
            stringBuffer.append("unit_id=" + str2 + "&");
            stringBuffer.append("cid=" + campaignEx.getId() + "&");
            stringBuffer.append("type=" + i11 + "&");
            stringBuffer.append("rid=");
            stringBuffer.append(campaignEx.getRequestId());
            stringBuffer.append("&");
            stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
            if (i12 != -1) {
                stringBuffer.append("d_t=" + i12 + "&");
            }
            stringBuffer.append("url=" + URLEncoder.encode(str, "utf-8"));
            if (j.a().b()) {
                j.a().a(stringBuffer.toString());
            } else {
                a(context, stringBuffer.toString(), str2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i11, int i12, int i13) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000075&");
            stringBuffer.append("network_type=" + z.l(context) + "&");
            stringBuffer.append("unit_id=" + str2 + "&");
            stringBuffer.append("cid=" + campaignEx.getId() + "&");
            stringBuffer.append("type=" + i11 + "&");
            stringBuffer.append("rid=");
            stringBuffer.append(campaignEx.getRequestId());
            stringBuffer.append("&");
            stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
            stringBuffer.append("statue=" + i12 + "&");
            if (i13 != -1) {
                stringBuffer.append("d_t=" + i13 + "&");
            }
            stringBuffer.append("url=" + URLEncoder.encode(str, "utf-8"));
            if (j.a().b()) {
                j.a().a(stringBuffer.toString());
            } else {
                a(context, stringBuffer.toString(), str2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i11, String str3, int i12) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000073&");
            stringBuffer.append("network_type=" + z.l(context) + "&");
            stringBuffer.append("unit_id=" + str2 + "&");
            stringBuffer.append("cid=" + campaignEx.getId() + "&");
            stringBuffer.append("reason=" + str3 + "&");
            stringBuffer.append("result=" + i11 + "&");
            stringBuffer.append("rid=");
            stringBuffer.append(campaignEx.getRequestId());
            stringBuffer.append("&");
            stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
            if (i12 != -1) {
                stringBuffer.append("d_t=" + i12 + "&");
            }
            stringBuffer.append("url=" + URLEncoder.encode(str, "utf-8"));
            if (j.a().b()) {
                j.a().a(stringBuffer.toString());
            } else {
                a(context, stringBuffer.toString(), str2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static void a(final Context context, final String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.e.a(context).post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, a(str, context, str2), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.q.1
                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onFailed(String str3) {
                    com.mbridge.msdk.foundation.entity.l lVar = new com.mbridge.msdk.foundation.entity.l();
                    lVar.a(str);
                    lVar.a(System.currentTimeMillis());
                    lVar.a(0);
                    lVar.b("POST");
                    lVar.c(com.mbridge.msdk.foundation.same.net.g.d.f().f44626c);
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(context)).a(lVar);
                    ad.b(q.f44913a, str3);
                }

                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onSuccess(String str3) {
                    ad.b(q.f44913a, str3);
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
            ad.b(f44913a, e11.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, int i11, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000076&");
                    stringBuffer.append("network_type=" + z.l(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("reason=" + str3 + "&");
                    stringBuffer.append("result=" + i11 + "&");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("url=");
                    sb2.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb2.toString());
                    if (j.a().b()) {
                        j.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str2);
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z11, CampaignEx campaignEx) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000047&");
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
                if (campaignEx != null) {
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("adtp=" + campaignEx.getAdType() + "&");
                    stringBuffer.append("rid=" + campaignEx.getRequestId());
                    stringBuffer.append("&");
                    stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                }
                stringBuffer.append("st=" + System.currentTimeMillis() + "&");
                stringBuffer.append("network_type=" + z.l(context) + "&");
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("hb=");
                stringBuffer.append(z11 ? 1 : 0);
                stringBuffer.append("&");
                stringBuffer.append("reason=" + str);
                if (j.a().b()) {
                    j.a().a(stringBuffer.toString());
                } else {
                    d(context, stringBuffer.toString());
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z11, String str3, String str4, String str5, String str6) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000104&");
                if (!TextUtils.isEmpty(str2)) {
                    String str7 = com.mbridge.msdk.foundation.controller.a.f44041b.get(str2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("u_stid=");
                    if (str7 == null) {
                        str7 = "";
                    }
                    sb2.append(str7);
                    sb2.append("&");
                    stringBuffer.append(sb2.toString());
                }
                stringBuffer.append("network_type=" + z.l(context) + "&");
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append("rid=" + str3 + "&");
                }
                if (!TextUtils.isEmpty(str4)) {
                    stringBuffer.append("rid_n=" + str4 + "&");
                }
                if (!TextUtils.isEmpty(str5)) {
                    stringBuffer.append("cid=" + str5 + "&");
                }
                if (!TextUtils.isEmpty(str6)) {
                    stringBuffer.append("template_id=" + str6 + "&");
                }
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("hb=");
                stringBuffer.append(z11 ? 1 : 0);
                stringBuffer.append("&");
                stringBuffer.append("reason=" + str);
                if (j.a().b()) {
                    j.a().a(stringBuffer.toString());
                } else {
                    d(context, stringBuffer.toString());
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str, boolean z11) {
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
            stringBuffer.append("network_type=" + z.l(context) + "&");
            stringBuffer.append("unit_id=" + str + "&");
            CampaignEx campaignEx = list.get(0);
            stringBuffer.append("cid=" + campaignEx.getId() + "&");
            if (z11) {
                stringBuffer.append("hb=");
                stringBuffer.append(1);
                stringBuffer.append("&");
            }
            String requestId = campaignEx.getRequestId();
            if (!TextUtils.isEmpty(requestId)) {
                stringBuffer.append("rid=");
                stringBuffer.append(requestId);
                stringBuffer.append("&");
            }
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (!TextUtils.isEmpty(requestIdNotice)) {
                stringBuffer.append("rid_n=");
                stringBuffer.append(requestIdNotice);
                stringBuffer.append("&");
            }
            StringBuilder sb2 = new StringBuilder("rtins_type=");
            for (int i11 = 0; i11 < list.size(); i11++) {
                CampaignEx campaignEx2 = list.get(i11);
                if (i11 < list.size() - 1) {
                    sb2.append(campaignEx2.getRtinsType());
                    sb2.append(",");
                } else {
                    sb2.append(campaignEx2.getRtinsType());
                }
            }
            stringBuffer.append((CharSequence) sb2);
            if (j.a().b()) {
                j.a().a(stringBuffer.toString());
            } else {
                a(context, stringBuffer.toString(), str);
            }
        } catch (Throwable th2) {
            ad.b(f44913a, th2.getMessage());
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i11, int i12, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.c.m().c());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("key");
            sb2.append("=");
            sb2.append(URLEncoder.encode("2000121", "utf-8"));
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
            sb2.append("type");
            sb2.append("=");
            sb2.append(i11);
            sb2.append("&");
            sb2.append("result");
            sb2.append("=");
            sb2.append(i12);
            sb2.append("&");
            sb2.append("reason");
            sb2.append("=");
            sb2.append(URLEncoder.encode(str2, "utf-8"));
            if (j.a().b()) {
                j.a().a(sb2.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, a(sb2.toString(), com.mbridge.msdk.foundation.controller.c.m().c(), str), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.q.4
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

    public static void a(CampaignEx campaignEx, String str, int i11, int i12, String str2, int i13, int i14, int i15, String str3) {
        com.mbridge.msdk.foundation.same.report.d.b bVar;
        try {
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar.a("key", URLEncoder.encode("2000094", "utf-8"));
            if (campaignEx != null) {
                dVar.a("rid", URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
                dVar.a("rid_n", URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
                dVar.a(BidResponsedEx.KEY_CID, URLEncoder.encode(campaignEx.getId(), "utf-8"));
                bVar = com.mbridge.msdk.foundation.same.report.d.c.a().b(campaignEx.getCurrentLocalRid());
            } else {
                bVar = null;
            }
            dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str, "utf-8"));
            if (i11 == 0) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = "0";
                }
                dVar.a("video_prg", str3 + "");
            } else {
                dVar.a("video_prg", i11 + "");
            }
            dVar.a("phase", i12 + "");
            dVar.a("feedback_content", URLEncoder.encode(str2, "utf-8"));
            dVar.a("feedback_close", i13 + "");
            dVar.a("type", i15 + "");
            dVar.a("ad_type", i14 + "");
            dVar.a("network_type", URLEncoder.encode(String.valueOf(z.l(com.mbridge.msdk.foundation.controller.c.m().c())), "utf-8"));
            if (bVar == null) {
                bVar = new com.mbridge.msdk.foundation.same.report.d.b();
            }
            bVar.d(str);
            bVar.b(i14);
            bVar.a("2000094", dVar);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000094", bVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public static void a(String str) {
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().c() == null) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.c.m().c());
            String str2 = "key=2000088&state=" + str;
            ad.b(f44913a, str2);
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null || f.a(gVarB, str2)) {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, a(str2, com.mbridge.msdk.foundation.controller.c.m().c(), ""), null);
            }
        } catch (Throwable th2) {
            ad.b(f44913a, th2.getMessage());
        }
    }

    public static void a(String str, int i11, int i12, String str2, int i13, String str3) {
        try {
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar.a("key", URLEncoder.encode("m_water_mark_result", "utf-8"));
            dVar.a("water_mark_result", i12 + "");
            dVar.a("water_mark_error_msg", URLEncoder.encode(str2, "utf-8"));
            dVar.a("render_result", i13 + "");
            dVar.a("water_mark_str", URLEncoder.encode(str3, "utf-8"));
            com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
            bVar.b(i11);
            bVar.d(str);
            bVar.a("m_water_mark_result", dVar);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("m_water_mark_result", bVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean a() {
        try {
            return System.currentTimeMillis() - ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED > ((Long) al.a(com.mbridge.msdk.foundation.controller.c.m().c(), "privateAuthorityTimesTamp", 0L)).longValue();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static void b() {
        try {
            al.b(com.mbridge.msdk.foundation.controller.c.m().c(), "privateAuthorityTimesTamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void b(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000054&");
            stringBuffer.append("network_type=");
            stringBuffer.append(z.l(context));
            stringBuffer.append("&");
            stringBuffer.append("unit_id=");
            stringBuffer.append(str);
            stringBuffer.append("&");
            stringBuffer.append("cid=");
            stringBuffer.append(campaignEx.getId());
            stringBuffer.append("&");
            stringBuffer.append("reason=&");
            stringBuffer.append("result=2&");
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append(str2);
            }
            if (campaignEx.getAdType() == 287) {
                stringBuffer.append("creative=");
                stringBuffer.append(URLEncoder.encode(campaignEx.getendcard_url()));
                stringBuffer.append("&");
                stringBuffer.append("ad_type=3&");
            } else if (campaignEx.getAdType() == 94) {
                stringBuffer.append("creative=");
                stringBuffer.append(URLEncoder.encode(campaignEx.getendcard_url()));
                stringBuffer.append("&");
                stringBuffer.append("ad_type=1&");
            } else if (campaignEx.getAdType() == 296) {
                stringBuffer.append("ad_type=5&");
                stringBuffer.append("creative=");
                stringBuffer.append(campaignEx.getCreativeId());
                stringBuffer.append("&");
            } else if (campaignEx.getAdType() == 297) {
                stringBuffer.append("ad_type=6&");
                stringBuffer.append("creative=");
                stringBuffer.append(campaignEx.getCreativeId());
                stringBuffer.append("&");
            } else if (campaignEx.getAdType() == 298) {
                stringBuffer.append("ad_type=7&");
                stringBuffer.append("creative=");
                stringBuffer.append(campaignEx.getCreativeId());
                stringBuffer.append("&");
            } else {
                stringBuffer.append("creative=");
                stringBuffer.append(URLEncoder.encode(campaignEx.getendcard_url()));
                stringBuffer.append("&");
                stringBuffer.append("ad_type=1&");
            }
            stringBuffer.append("devid=");
            stringBuffer.append(com.mbridge.msdk.foundation.tools.e.c());
            stringBuffer.append("&");
            if (campaignEx.isBidCampaign()) {
                stringBuffer.append("hb=1&");
            }
            stringBuffer.append("rid=");
            stringBuffer.append(campaignEx.getRequestId());
            stringBuffer.append("&");
            stringBuffer.append("rid_n=");
            stringBuffer.append(campaignEx.getRequestIdNotice());
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

    public static void b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.e.a(context).post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, a(str, context), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.q.3
                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onFailed(String str2) {
                    ad.b(q.f44913a, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onSuccess(String str2) {
                    ad.b(q.f44913a, str2);
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
            ad.b(f44913a, e11.getMessage());
        }
    }

    public static void b(String str) {
        try {
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.c.m().c());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("key=");
            sb2.append("2000090");
            sb2.append("&");
            sb2.append("reason=");
            sb2.append(TextUtils.isEmpty(str) ? "" : str);
            sb2.append("&");
            sb2.append("result=");
            sb2.append(!TextUtils.isEmpty(str));
            aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, a(sb2.toString(), com.mbridge.msdk.foundation.controller.c.m().c(), ""), null);
        } catch (Exception e11) {
            ad.b(f44913a, e11.getMessage());
        }
    }

    private static String c(Context context, String str) {
        String str2 = "1";
        if (context == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pf", "1");
            jSONObject.put("ov", z.v());
            jSONObject.put("pn", z.e(context));
            jSONObject.put("vn", z.p(context));
            jSONObject.put("vc", z.q(context));
            jSONObject.put("ot", z.r(context));
            jSONObject.put("dm", z.h());
            jSONObject.put("bd", z.w());
            jSONObject.put("gaid", com.mbridge.msdk.foundation.tools.e.c());
            jSONObject.put("mnc", z.k(context));
            jSONObject.put("mcc", z.j(context));
            int iL = z.l(context);
            jSONObject.put("nt", iL);
            jSONObject.put("nts", z.a(context, iL));
            jSONObject.put("l", z.s(context));
            jSONObject.put("tz", z.x());
            jSONObject.put("ua", z.g());
            jSONObject.put("app_id", com.mbridge.msdk.foundation.controller.c.m().k());
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put("sv", MBConfiguration.SDK_VERSION);
            jSONObject.put("ss", z.i(context) + "x" + z.g(context));
            jSONObject.put("adid_limit", com.mbridge.msdk.foundation.tools.e.a());
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.b()) {
                str2 = "0";
            }
            jSONObject.put("adid_limit_dev", str2);
            if (com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k()) != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    try {
                        String strL = z.l();
                        if (!TextUtils.isEmpty(strL)) {
                            jSONObject2.put("manufacturer", strL);
                        }
                        int iK = z.k();
                        if (iK != -1) {
                            jSONObject2.put("sdkint", iK);
                        }
                        String strM = z.m(context);
                        if (!TextUtils.isEmpty(strM)) {
                            jSONObject2.put("is24H", strM);
                        }
                        String strP = z.p();
                        if (!TextUtils.isEmpty(strP)) {
                            jSONObject2.put("totalram", strP);
                        }
                        String strN = z.n(context);
                        if (!TextUtils.isEmpty(strN)) {
                            jSONObject2.put("totalmemory", strN);
                        }
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("ReportUtilDiff", e11.getMessage());
                        }
                    }
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("ReportUtilDiff", e12.getMessage());
                    }
                } catch (Throwable th2) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("ReportUtilDiff", th2.getMessage());
                    }
                }
                if (!TextUtils.isEmpty(jSONObject2.toString())) {
                    String strB = x.b(jSONObject2.toString());
                    if (!TextUtils.isEmpty(strB)) {
                        jSONObject.put("dvi", URLEncoder.encode(strB, "utf-8"));
                    }
                }
            }
            return jSONObject.toString();
        } catch (Exception e13) {
            e13.printStackTrace();
            return "";
        }
    }

    public static void c() {
        try {
            com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.q.5
                @Override // java.lang.Runnable
                public final void run() {
                    String[] list;
                    try {
                        String strA = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_CRASH_INFO);
                        if (TextUtils.isEmpty(strA)) {
                            return;
                        }
                        File file = new File(strA);
                        if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
                            for (String str : list) {
                                File file2 = new File(strA + "/" + str);
                                if (file2.exists()) {
                                    String strB = ab.b(file2);
                                    if (TextUtils.isEmpty(strB)) {
                                        continue;
                                    } else {
                                        String[] strArrSplit = strB.split("====");
                                        if (strArrSplit.length > 0) {
                                            new o(com.mbridge.msdk.foundation.controller.c.m().c()).a(strArrSplit[0], file2);
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        ad.b(q.f44913a, th2.getMessage());
                    }
                }
            });
        } catch (Throwable th2) {
            ad.b(f44913a, th2.getMessage());
        }
    }

    private static void d(final Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.e.a(context).post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, a(str, context), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.q.2
                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onFailed(String str2) {
                    com.mbridge.msdk.foundation.entity.l lVar = new com.mbridge.msdk.foundation.entity.l();
                    lVar.a(str);
                    lVar.a(System.currentTimeMillis());
                    lVar.a(0);
                    lVar.b("POST");
                    lVar.c(com.mbridge.msdk.foundation.same.net.g.d.f().f44626c);
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(context)).a(lVar);
                    ad.b(q.f44913a, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onSuccess(String str2) {
                    ad.b(q.f44913a, str2);
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
            ad.b(f44913a, e11.getMessage());
        }
    }
}
