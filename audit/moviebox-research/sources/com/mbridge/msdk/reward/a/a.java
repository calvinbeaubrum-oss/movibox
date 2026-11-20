package com.mbridge.msdk.reward.a;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.config.utils.XLogUtil;
import com.mbridge.msdk.foundation.b.d;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f46529a = "RewardCandidateController";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f46530b;

    public a(String str, boolean z11) {
        try {
            this.f46530b = b.a().a(str, com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), str, z11).G());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private com.mbridge.msdk.foundation.b.c a(double d11, String str, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.d.b bVar, String str2, int i11) {
        com.mbridge.msdk.foundation.b.c cVarA = this.f46530b.a();
        try {
            if (cVarA.g() > 0) {
                return cVarA;
            }
            JSONObject jSONObjectA = this.f46530b.a(str);
            if (jSONObjectA != null) {
                int iOptInt = jSONObjectA.optInt("max_usage_limit", 10);
                int iOptInt2 = jSONObjectA.optInt("max_cache_num", 20);
                if (iOptInt2 > 0) {
                    long j11 = 8640000;
                    long jOptLong = jSONObjectA.optLong("show_interval_time", 8640000L);
                    if (jOptLong != 0) {
                        j11 = jOptLong;
                    }
                    List<com.mbridge.msdk.foundation.b.b> listA = this.f46530b.a(iOptInt, System.currentTimeMillis() - (j11 * 1000));
                    if (listA != null && listA.size() > 0) {
                        return a(listA, jSONObjectA, iOptInt2, d11, cVar, bVar, str2, true, i11);
                    }
                    cVarA.d("no cache");
                    cVarA.a(com.mbridge.msdk.foundation.b.c.f44011c);
                    a(bVar, str2, cVarA, (List<com.mbridge.msdk.foundation.b.a.C0483a>) null, jSONObjectA, 2);
                } else {
                    cVarA.d("max cache num error");
                    cVarA.a(com.mbridge.msdk.foundation.b.c.f44011c);
                }
            } else {
                cVarA.d("setting config not mapping");
                cVarA.a(com.mbridge.msdk.foundation.b.c.f44011c);
            }
            return cVarA;
        } catch (Exception unused) {
            cVarA.d("getHighestCampaigns exception");
            cVarA.a(com.mbridge.msdk.foundation.b.c.f44011c);
        }
    }

    private com.mbridge.msdk.foundation.b.c a(List<com.mbridge.msdk.foundation.b.b> list, JSONObject jSONObject, int i11, double d11, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.d.b bVar, String str, boolean z11, int i12) {
        ArrayList arrayList;
        int i13;
        com.mbridge.msdk.foundation.b.c cVar2;
        a aVar = this;
        List<com.mbridge.msdk.foundation.b.b> listA = list;
        com.mbridge.msdk.foundation.b.c cVar3 = new com.mbridge.msdk.foundation.b.c();
        if (jSONObject == null) {
            cVar3.d("config is null");
            cVar3.a(com.mbridge.msdk.foundation.b.c.f44011c);
            return cVar3;
        }
        if (listA == null || list.size() == 0) {
            cVar3.d("candidate is null");
            cVar3.a(com.mbridge.msdk.foundation.b.c.f44011c);
            return cVar3;
        }
        int i14 = 0;
        for (int i15 = 0; i15 < list.size(); i15++) {
            com.mbridge.msdk.foundation.b.b bVar2 = listA.get(i15);
            if (bVar2 != null) {
                cVar3.a(bVar2.e());
            }
        }
        if (list.size() > 0 && ((listA = aVar.a(listA, cVar3)) == null || listA.size() == 0)) {
            cVar3.d("existed");
            cVar3.a(com.mbridge.msdk.foundation.b.c.f44011c);
        }
        if (listA.size() > 0 && ((listA = aVar.a(listA, cVar, cVar3)) == null || listA.size() == 0)) {
            cVar3.d("not ready");
            cVar3.a(com.mbridge.msdk.foundation.b.c.f44011c);
        }
        com.mbridge.msdk.foundation.b.b bVar3 = null;
        if (listA == null || listA.size() <= 0) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            double dOptDouble = jSONObject.optDouble("t_disc", 0.8d);
            double dOptDouble2 = jSONObject.optDouble("u_disc", 0.95d);
            double d12 = 0.0d;
            double dOptDouble3 = jSONObject.optDouble("max_ecppv_diff", 0.0d);
            int iOptInt = jSONObject.optInt("time_interval", 1800);
            int size = listA.size();
            while (i14 < size) {
                List<com.mbridge.msdk.foundation.b.b> list2 = listA;
                com.mbridge.msdk.foundation.b.b bVar4 = listA.get(i14);
                if (bVar4 != null) {
                    i13 = size;
                    cVar2 = cVar3;
                    double dPow = Math.pow(dOptDouble2, bVar4.f()) * bVar4.c() * Math.pow(dOptDouble, (System.currentTimeMillis() - bVar4.h()) / (((double) iOptInt) * 1000.0d));
                    arrayList2.add(new com.mbridge.msdk.foundation.b.a.C0483a(dPow, bVar4));
                    if (dPow >= d11 - dOptDouble3 && dPow > d12) {
                        bVar3 = bVar4;
                        d12 = dPow;
                    }
                } else {
                    i13 = size;
                    cVar2 = cVar3;
                }
                i14++;
                aVar = this;
                listA = list2;
                size = i13;
                cVar3 = cVar2;
            }
            com.mbridge.msdk.foundation.b.c cVar4 = cVar3;
            d dVar = aVar.f46530b;
            if (dVar != null) {
                dVar.a(arrayList2, i11);
            }
            if (bVar3 != null) {
                cVar3 = cVar4;
                cVar3.a(bVar3.b());
                cVar3.a(com.mbridge.msdk.foundation.b.c.f44012d);
            } else {
                cVar3 = cVar4;
                cVar3.d("no match campaign");
                cVar3.a(com.mbridge.msdk.foundation.b.c.f44011c);
            }
            arrayList = arrayList2;
        }
        if (z11) {
            a(bVar, str, cVar3, arrayList, jSONObject, 2);
        }
        return cVar3;
    }

    private List<com.mbridge.msdk.foundation.b.b> a(List<com.mbridge.msdk.foundation.b.b> list, com.mbridge.msdk.foundation.b.c cVar) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListB;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.mbridge.msdk.foundation.b.b bVar = list.get(i11);
            if (bVar != null && (copyOnWriteArrayListB = bVar.b()) != null && copyOnWriteArrayListB.size() != 0) {
                int i12 = 0;
                boolean z11 = false;
                while (i12 < copyOnWriteArrayListB.size()) {
                    CampaignEx campaignEx = copyOnWriteArrayListB.get(i12);
                    boolean zC = ai.c(c.m().c(), campaignEx.getPackageName());
                    if (zC) {
                        cVar.c(bVar.e());
                        d dVar = this.f46530b;
                        if (dVar != null) {
                            dVar.a(bVar.d(), bVar.e(), 2, campaignEx.getEcppv());
                        }
                        z11 = zC;
                        break;
                    }
                    i12++;
                    z11 = zC;
                }
                if (!z11) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private List<com.mbridge.msdk.foundation.b.b> a(List<com.mbridge.msdk.foundation.b.b> list, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.b.c cVar2) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListB;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.mbridge.msdk.foundation.b.b bVar = list.get(i11);
            if (bVar != null && (copyOnWriteArrayListB = bVar.b()) != null && copyOnWriteArrayListB.size() != 0) {
                boolean zA = false;
                for (int i12 = 0; i12 < copyOnWriteArrayListB.size(); i12++) {
                    CampaignEx campaignEx = copyOnWriteArrayListB.get(i12);
                    if (cVar != null && !(zA = cVar.a(copyOnWriteArrayListB, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())))) {
                        cVar2.b(bVar.e());
                        d dVar = this.f46530b;
                        if (dVar == null) {
                            break;
                        }
                        dVar.a(bVar.d(), bVar.e(), 2, campaignEx.getEcppv());
                        break;
                    }
                }
                if (zA) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public final com.mbridge.msdk.foundation.b.c a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar, CampaignEx campaignEx, com.mbridge.msdk.foundation.c.b bVar2, int i11, com.mbridge.msdk.reward.adapter.c cVar) {
        String requestId;
        String strB;
        int iF;
        com.mbridge.msdk.foundation.b.c cVarA;
        com.mbridge.msdk.foundation.b.c cVar2 = new com.mbridge.msdk.foundation.b.c();
        if (campaignEx == null) {
            requestId = "";
        } else {
            try {
                try {
                    requestId = campaignEx.getRequestId();
                } catch (Exception unused) {
                    cVar2.d("getRewardCandidateCampaignList result exception");
                    cVar2.a(com.mbridge.msdk.foundation.b.c.f44011c);
                    return cVar2;
                }
            } catch (Exception unused2) {
                cVar2.d("getCandidateCampaignList result exception");
                cVar2.a(com.mbridge.msdk.foundation.b.c.f44011c);
                return cVar2;
            }
        }
        if (bVar2 != null) {
            iF = bVar2.f();
            strB = bVar2.b();
        } else {
            strB = null;
            iF = 0;
        }
        d dVar = this.f46530b;
        if (dVar == null) {
            cVarA = new com.mbridge.msdk.foundation.b.c();
            cVarA.d("can not get manager");
            cVarA.a(com.mbridge.msdk.foundation.b.c.f44011c);
        } else {
            com.mbridge.msdk.foundation.b.c cVarC = dVar.c(str);
            if (cVarC.g() > com.mbridge.msdk.foundation.b.c.f44010b) {
                return cVarC;
            }
            String[] strArrSplit = x.a(str.split("_")[3]).split("\\|");
            double d11 = Double.parseDouble(strArrSplit[0]);
            cVarA = a(d11, strArrSplit.length > 1 ? strArrSplit[1] : "", cVar, bVar, str, i11);
            this.f46530b.a(cVarA.a(), bVar, requestId, iF, strB, i11, d11);
        }
        return cVarA;
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar, String str, com.mbridge.msdk.foundation.b.c cVar, List<com.mbridge.msdk.foundation.b.a.C0483a> list, JSONObject jSONObject, int i11) {
        String str2;
        try {
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            if (i11 == 1) {
                str2 = "cb";
            } else if (i11 != 2) {
                str2 = i11 != 3 ? AppLovinMediationProvider.UNKNOWN : "track";
            } else {
                str2 = "candidate";
            }
            dVar.a("scene", str2);
            d dVar2 = this.f46530b;
            if (dVar2 != null) {
                double d11 = dVar2.d(str);
                if (d11 >= 0.0d) {
                    dVar.a("bp", x.b(d11 + ""));
                }
                dVar.a("cb_state", a(str) ? "open" : CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                try {
                    d dVar3 = this.f46530b;
                    JSONObject jSONObjectA = dVar3.a(dVar3.b(str));
                    if (jSONObjectA != null) {
                        dVar.a(XLogUtil.TAG, jSONObjectA.toString());
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            if (cVar != null) {
                if (cVar.g() == com.mbridge.msdk.foundation.b.c.f44012d) {
                    dVar.a("result", 1);
                } else {
                    dVar.a("result", 2);
                    dVar.a("reason", cVar.b());
                }
                dVar.a("acr", cVar.c());
                dVar.a("her", cVar.e());
                dVar.a("nrr", cVar.d());
                dVar.a("cer", cVar.f());
            } else {
                dVar.a("result", 2);
                dVar.a("reason", "candidate result is null");
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i12 = 0; i12 < list.size(); i12++) {
                    com.mbridge.msdk.foundation.b.b bVarA = list.get(i12).a();
                    if (bVarA != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ecppv", x.b(bVarA.c() + ""));
                        jSONObject2.put("showCount", bVarA.f());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - bVarA.h());
                        jSONArray.put(jSONObject2);
                    }
                }
                dVar.a("data", jSONArray.toString());
            }
            if (bVar != null) {
                bVar.a("m_candidate_data");
                bVar.k("m_candidate_data");
                bVar.a("m_candidate_data", dVar);
                if (cVar != null && cVar.a() != null) {
                    bVar.b(cVar.a());
                }
            }
            com.mbridge.msdk.foundation.same.report.d.c.a().a("m_candidate_data", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public final void a(String str, String str2, int i11, String str3) {
        d dVar = this.f46530b;
        if (dVar != null) {
            dVar.a(str, str2, i11, str3);
        }
    }

    public final void a(List<CampaignEx> list, String str, com.mbridge.msdk.reward.adapter.c cVar, String str2) {
        try {
            if (this.f46530b == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f46530b.a(com.mbridge.msdk.foundation.b.a.f43990b, 2, list, this.f46530b.a(list, str) > 0, "", "", -1, str2);
            d dVar = this.f46530b;
            JSONObject jSONObjectA = dVar.a(dVar.b(str));
            if (jSONObjectA == null || this.f46530b.d(str) <= 0.0d) {
                return;
            }
            a(this.f46530b.a(jSONObjectA.optInt("max_usage_limit", 10), 0L), jSONObjectA, jSONObjectA.optInt("max_cache_num", 20), -1.0d, cVar, new com.mbridge.msdk.foundation.same.report.d.b(), str, false, 0);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final boolean a(String str) {
        JSONObject jSONObjectA;
        try {
            d dVar = this.f46530b;
            return (dVar == null || (jSONObjectA = dVar.a(dVar.b(str))) == null || jSONObjectA.optInt("c_cb", 0) != 1) ? false : true;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return false;
    }
}
