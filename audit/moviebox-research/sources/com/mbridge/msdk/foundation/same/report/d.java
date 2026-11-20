package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements c {
    private String a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            if (map.containsKey(CampaignEx.JSON_KEY_CAMPAIGN_UNITID) && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                map.remove(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            }
            StringBuilder sb2 = new StringBuilder();
            try {
                int i11 = 0;
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = map.get(str);
                        if (i11 == 0) {
                            sb2.append(str);
                            sb2.append("=");
                            if (str2 == null) {
                                str2 = "";
                            }
                            sb2.append(str2);
                        } else {
                            sb2.append("&");
                            sb2.append(str);
                            sb2.append("=");
                            if (str2 == null) {
                                str2 = "";
                            }
                            sb2.append(str2);
                        }
                        i11++;
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("CommonReport", e11.getMessage());
                }
                sb2 = null;
            }
            if (sb2 != null && sb2.length() > 0) {
                return sb2.toString();
            }
        }
        return null;
    }

    private Map<String, String> a(b bVar, Context context, String str, String str2) {
        if (bVar == null) {
            return null;
        }
        Map<String, String> mapF = bVar.f();
        if (mapF == null) {
            mapF = new HashMap<>();
        }
        if (!TextUtils.isEmpty(bVar.a())) {
            mapF.put("adtp", bVar.a());
        }
        if (!TextUtils.isEmpty(str2)) {
            mapF.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            String str3 = com.mbridge.msdk.foundation.controller.a.f44041b.get(str2);
            if (TextUtils.isEmpty(str)) {
                str = com.mbridge.msdk.foundation.controller.c.m().k();
            }
            com.mbridge.msdk.c.k kVarD = com.mbridge.msdk.c.h.a().d(str, str2);
            if (kVarD != null && !TextUtils.isEmpty(kVarD.s())) {
                mapF.put("us_rid", kVarD.s());
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            mapF.put("u_stid", str3);
        }
        com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(str);
        if (gVarB == null) {
            com.mbridge.msdk.c.h.a();
            gVarB = com.mbridge.msdk.c.i.a();
        }
        if (!TextUtils.isEmpty(gVarB.am())) {
            mapF.put("as_rid", gVarB.am());
        }
        try {
            String strH = bVar.h();
            String strN = gVarB.N();
            JSONArray jSONArrayM = gVarB.M();
            if (jSONArrayM != null) {
                for (int i11 = 0; i11 < jSONArrayM.length(); i11++) {
                    if (strH.equals(jSONArrayM.getString(i11))) {
                        strN = "1.0";
                        break;
                    }
                }
            }
            if (TextUtils.isEmpty(strN)) {
                mapF.put("log_rate", "-1");
            } else {
                mapF.put("log_rate", strN);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        String strH2 = bVar.h();
        if (!TextUtils.isEmpty(strH2)) {
            mapF.put("key", strH2);
        }
        if (context != null) {
            mapF.put("network_type", String.valueOf(z.l(context)));
            mapF.put("network_available", String.valueOf(ai.l(context)));
        }
        if (bVar.n()) {
            mapF.put("duration", String.valueOf(bVar.e()));
        }
        return mapF;
    }

    @Override // com.mbridge.msdk.foundation.same.report.c
    public final com.mbridge.msdk.foundation.same.net.h.e a(b bVar) throws Exception {
        if (bVar == null) {
            return null;
        }
        Context contextC = bVar.c() == null ? com.mbridge.msdk.foundation.controller.c.m().c() : bVar.c();
        String strK = bVar.k();
        String strB = bVar.b();
        String strG = bVar.g();
        try {
            String strA = a(a(bVar, contextC, strB, strK));
            bVar.a(strA);
            if (TextUtils.isEmpty(strA)) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("CommonReport", "decorate report data is null");
                }
                return null;
            }
            com.mbridge.msdk.foundation.same.net.h.e eVarA = q.a(contextC);
            eVarA.a("data", URLEncoder.encode(strA, "utf-8"));
            if (TextUtils.isEmpty(strB)) {
                strB = com.mbridge.msdk.foundation.controller.c.m().k();
            }
            eVarA.a("app_id", strB);
            eVarA.a("m_sdk", "msdk");
            eVarA.a("r_stid", strG);
            if (!TextUtils.isEmpty(strK)) {
                eVarA.a(MBridgeConstans.PROPERTIES_UNIT_ID, strK);
            }
            return eVarA;
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CommonReport", "decorate report data error: " + e11.getMessage());
            }
            return null;
        }
    }
}
