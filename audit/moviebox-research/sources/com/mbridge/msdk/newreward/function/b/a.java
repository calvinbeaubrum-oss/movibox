package com.mbridge.msdk.newreward.function.b;

import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.config.utils.XLogUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.c;
import com.mbridge.msdk.videocommon.d.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f46162a = "RewardCandidateController";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f46163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.a.c f46164c;

    public a(String str, boolean z11, c cVar) {
        this.f46163b = cVar;
        try {
            com.mbridge.msdk.newreward.function.a.c cVarA = com.mbridge.msdk.newreward.function.a.a.a.a().a(str, b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), str, z11).G());
            this.f46164c = cVarA;
            cVarA.a(cVar);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v6 */
    private com.mbridge.msdk.newreward.function.a.b a(double d11, String str, com.mbridge.msdk.foundation.same.report.d.b bVar, String str2, e eVar, int i11, int i12, String str3) {
        JSONObject jSONObject;
        com.mbridge.msdk.newreward.function.a.b bVar2;
        ArrayList arrayList;
        int i13;
        JSONObject jSONObject2;
        List<com.mbridge.msdk.newreward.function.d.a.a> listS;
        com.mbridge.msdk.newreward.function.a.b bVar3 = this;
        com.mbridge.msdk.newreward.function.a.b bVarA = bVar3.f46164c.a();
        try {
            if (bVarA.h() > 0) {
                return bVarA;
            }
            JSONObject jSONObjectA = bVar3.f46164c.a(str);
            try {
                if (jSONObjectA != null) {
                    int iOptInt = jSONObjectA.optInt("max_usage_limit", 10);
                    if (jSONObjectA.optInt("max_cache_num", 20) > 0) {
                        List<com.mbridge.msdk.newreward.function.d.a.b> listA = bVar3.f46164c.a(iOptInt, i12, str3);
                        if (listA != null && listA.size() > 0) {
                            com.mbridge.msdk.newreward.function.a.b bVar4 = new com.mbridge.msdk.newreward.function.a.b();
                            if (listA.size() == 0) {
                                bVar4.d("candidate is null");
                                bVar4.a(com.mbridge.msdk.foundation.b.c.f44011c);
                            } else {
                                for (int i14 = 0; i14 < listA.size(); i14++) {
                                    com.mbridge.msdk.newreward.function.d.a.b bVar5 = listA.get(i14);
                                    if (bVar5 != null) {
                                        bVar4.a(bVar5.d());
                                    }
                                }
                                if (listA.size() > 0) {
                                    if (listA.size() != 0) {
                                        ArrayList arrayList2 = new ArrayList();
                                        for (int i15 = 0; i15 < listA.size(); i15++) {
                                            com.mbridge.msdk.newreward.function.d.a.b bVar6 = listA.get(i15);
                                            if (bVar6 != null && (listS = bVar6.s()) != null && listS.size() != 0) {
                                                int i16 = 0;
                                                boolean z11 = false;
                                                while (i16 < listS.size()) {
                                                    com.mbridge.msdk.newreward.function.d.a.a aVar = listS.get(i16);
                                                    boolean zC = ai.c(com.mbridge.msdk.foundation.controller.c.m().c(), aVar.g().getPackageName());
                                                    if (zC) {
                                                        bVar4.c(bVar6.d());
                                                        com.mbridge.msdk.newreward.function.a.c cVar = bVar3.f46164c;
                                                        if (cVar != null) {
                                                            cVar.a(bVar6.e(), bVar6.d(), 2, aVar.h().q());
                                                        }
                                                        z11 = zC;
                                                        break;
                                                    }
                                                    i16++;
                                                    z11 = zC;
                                                }
                                                if (!z11) {
                                                    arrayList2.add(bVar6);
                                                }
                                            }
                                        }
                                        listA = arrayList2;
                                    }
                                    if (listA.size() == 0) {
                                        bVar4.d("existed");
                                        bVar4.a(com.mbridge.msdk.foundation.b.c.f44011c);
                                    }
                                }
                                if (listA.size() > 0 && ((listA = bVar3.a(listA, bVar4)) == null || listA.size() == 0)) {
                                    bVar4.d("not ready");
                                    bVar4.a(com.mbridge.msdk.foundation.b.c.f44011c);
                                }
                                if (listA.size() > 0 && ((listA = bVar3.b(listA, bVar4)) == null || listA.size() == 0)) {
                                    bVar4.d("had in cache");
                                    bVar4.a(com.mbridge.msdk.foundation.b.c.f44011c);
                                }
                                if (listA == null || listA.size() <= 0) {
                                    jSONObject = jSONObjectA;
                                    bVar2 = bVarA;
                                    arrayList = null;
                                } else {
                                    ArrayList arrayList3 = new ArrayList();
                                    double dOptDouble = jSONObjectA.optDouble("t_disc", 0.8d);
                                    double dOptDouble2 = jSONObjectA.optDouble("u_disc", 0.95d);
                                    double dOptDouble3 = jSONObjectA.optDouble("max_ecppv_diff", 0.0d);
                                    int iOptInt2 = jSONObjectA.optInt("time_interval", 1800);
                                    int size = listA.size();
                                    double d12 = 0.0d;
                                    com.mbridge.msdk.newreward.function.d.a.b bVar7 = null;
                                    int i17 = 0;
                                    while (i17 < size) {
                                        com.mbridge.msdk.newreward.function.d.a.b bVar8 = listA.get(i17);
                                        if (bVar8 != null) {
                                            bVar2 = bVarA;
                                            i13 = size;
                                            jSONObject2 = jSONObjectA;
                                            try {
                                                double dPow = Math.pow(dOptDouble2, bVar8.r()) * bVar8.q() * Math.pow(dOptDouble, (System.currentTimeMillis() - bVar8.G()) / (((double) iOptInt2) * 1000.0d));
                                                arrayList3.add(new com.mbridge.msdk.newreward.function.a.a.C0505a(dPow, bVar8));
                                                if (dPow >= d11 - dOptDouble3 && dPow > d12) {
                                                    d12 = dPow;
                                                    bVar7 = bVar8;
                                                }
                                            } catch (Exception unused) {
                                                bVar3 = bVar2;
                                                bVar3.d("getHighestCampaigns exception");
                                                bVar3.a(com.mbridge.msdk.foundation.b.c.f44011c);
                                                return bVar3;
                                            }
                                        } else {
                                            i13 = size;
                                            jSONObject2 = jSONObjectA;
                                            bVar2 = bVarA;
                                        }
                                        i17++;
                                        jSONObjectA = jSONObject2;
                                        size = i13;
                                        bVarA = bVar2;
                                    }
                                    jSONObject = jSONObjectA;
                                    bVar2 = bVarA;
                                    if (bVar7 != null) {
                                        bVar4.a(bVar7);
                                        bVar4.a(com.mbridge.msdk.foundation.b.c.f44012d);
                                    } else {
                                        bVar4.d("no match campaign");
                                        bVar4.a(com.mbridge.msdk.foundation.b.c.f44011c);
                                    }
                                    arrayList = arrayList3;
                                }
                                a(bVar, str2, bVar4, arrayList, jSONObject, eVar, i11);
                            }
                            return bVar4;
                        }
                        com.mbridge.msdk.newreward.function.a.b bVar9 = bVarA;
                        bVar9.d("no cache");
                        bVar9.a(com.mbridge.msdk.foundation.b.c.f44011c);
                        a(bVar, str2, bVar9, null, jSONObjectA, eVar, 2);
                        bVar3 = bVar9;
                    } else {
                        com.mbridge.msdk.newreward.function.a.b bVar10 = bVarA;
                        bVar10.d("max cache num error");
                        bVar10.a(com.mbridge.msdk.foundation.b.c.f44011c);
                        bVar3 = bVar10;
                    }
                } else {
                    com.mbridge.msdk.newreward.function.a.b bVar11 = bVarA;
                    bVar11.d("setting config not mapping");
                    bVar11.a(com.mbridge.msdk.foundation.b.c.f44011c);
                    bVar3 = bVar11;
                }
            } catch (Exception unused2) {
            }
            return bVar3;
        } catch (Exception unused3) {
            bVar3 = bVarA;
        }
    }

    private List<com.mbridge.msdk.newreward.function.d.a.b> a(List<com.mbridge.msdk.newreward.function.d.a.b> list, com.mbridge.msdk.newreward.function.a.b bVar) {
        List<com.mbridge.msdk.newreward.function.d.a.a> listS;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.mbridge.msdk.newreward.function.d.a.b bVar2 = list.get(i11);
            if (bVar2 != null && (listS = bVar2.s()) != null && listS.size() != 0) {
                int i12 = 0;
                boolean z11 = false;
                while (i12 < listS.size()) {
                    com.mbridge.msdk.newreward.function.d.a.a aVar = listS.get(i12);
                    boolean zY = aVar.h().y();
                    if (!zY) {
                        bVar.b(bVar2.d());
                        com.mbridge.msdk.newreward.function.a.c cVar = this.f46164c;
                        if (cVar != null) {
                            cVar.a(bVar2.e(), bVar2.d(), 2, aVar.h().q());
                        }
                        z11 = zY;
                        break;
                    }
                    i12++;
                    z11 = zY;
                }
                if (z11) {
                    arrayList.add(bVar2);
                }
            }
        }
        return arrayList;
    }

    private List<com.mbridge.msdk.newreward.function.d.a.b> b(List<com.mbridge.msdk.newreward.function.d.a.b> list, com.mbridge.msdk.newreward.function.a.b bVar) {
        List<com.mbridge.msdk.newreward.function.d.a.a> listS;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.mbridge.msdk.newreward.function.d.a.b bVar2 = list.get(i11);
            if (bVar2 != null && (listS = bVar2.s()) != null && listS.size() != 0) {
                arrayList.add(bVar2);
            }
        }
        return arrayList;
    }

    public final com.mbridge.msdk.newreward.function.a.b a(com.mbridge.msdk.foundation.same.report.d.b bVar, com.mbridge.msdk.foundation.c.b bVar2, e eVar, int i11) {
        CampaignEx campaignEx;
        String str;
        int i12;
        String str2;
        String requestId;
        String strB;
        int iF;
        com.mbridge.msdk.newreward.function.a.b bVarA;
        com.mbridge.msdk.newreward.function.a.b bVar3 = new com.mbridge.msdk.newreward.function.a.b();
        if (eVar != null) {
            try {
                String strA = eVar.A();
                campaignEx = (eVar.v() == null || eVar.v().b() == null || eVar.v().b().C() == null || eVar.v().b().C().size() <= 0) ? null : eVar.v().b().C().get(0);
                if (this.f46164c != null) {
                    int iN = eVar.n();
                    String strU = eVar.u();
                    this.f46164c.a(iN);
                    this.f46164c.f(strU);
                    this.f46164c.a(eVar);
                    i12 = iN;
                    str = strU;
                } else {
                    str = "";
                    i12 = 94;
                }
                str2 = strA;
            } catch (Exception unused) {
                bVar3.d("getCandidateCampaignList result exception");
                bVar3.a(com.mbridge.msdk.foundation.b.c.f44011c);
                return bVar3;
            }
        } else {
            str = "";
            campaignEx = null;
            str2 = null;
            i12 = 94;
        }
        if (campaignEx == null) {
            requestId = "";
        } else {
            try {
                requestId = campaignEx.getRequestId();
            } catch (Exception unused2) {
                bVar3.d("getRewardCandidateCampaignList result exception");
                bVar3.a(com.mbridge.msdk.foundation.b.c.f44011c);
                return bVar3;
            }
        }
        if (bVar2 != null) {
            iF = bVar2.f();
            strB = bVar2.b();
        } else {
            strB = null;
            iF = 0;
        }
        com.mbridge.msdk.newreward.function.a.c cVar = this.f46164c;
        if (cVar == null) {
            bVarA = new com.mbridge.msdk.newreward.function.a.b();
            bVarA.d("can not get manager");
            bVarA.a(com.mbridge.msdk.foundation.b.c.f44011c);
        } else {
            com.mbridge.msdk.newreward.function.a.b bVarC = cVar.c(str2);
            if (bVarC.h() > com.mbridge.msdk.foundation.b.c.f44010b) {
                return bVarC;
            }
            String[] strArrSplit = x.a(str2.split("_")[3]).split("\\|");
            double d11 = Double.parseDouble(strArrSplit[0]);
            bVarA = a(d11, strArrSplit.length > 1 ? strArrSplit[1] : "", bVar, str2, eVar, i11, i12, str);
            if (bVarA != null && bVarA.a() != null) {
                this.f46164c.a(bVarA.a().s(), bVar, requestId, iF, strB, i11, d11);
            }
        }
        return bVarA;
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar, String str, com.mbridge.msdk.newreward.function.a.b bVar2, List<com.mbridge.msdk.newreward.function.a.a.C0505a> list, JSONObject jSONObject, e eVar, int i11) {
        String str2;
        try {
            d dVar = new d();
            if (i11 == 1) {
                str2 = "cb";
            } else if (i11 != 2) {
                str2 = i11 != 3 ? AppLovinMediationProvider.UNKNOWN : "track";
            } else {
                str2 = "candidate";
            }
            dVar.a("scene", str2);
            com.mbridge.msdk.newreward.function.a.c cVar = this.f46164c;
            if (cVar != null) {
                double d11 = cVar.d(str);
                if (d11 >= 0.0d) {
                    dVar.a("bp", x.b(d11 + ""));
                }
                dVar.a("cb_state", a(str) ? "open" : CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                try {
                    com.mbridge.msdk.newreward.function.a.c cVar2 = this.f46164c;
                    JSONObject jSONObjectA = cVar2.a(cVar2.b(str));
                    if (jSONObjectA != null) {
                        dVar.a(XLogUtil.TAG, jSONObjectA.toString());
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            if (bVar2 != null) {
                if (bVar2.h() == com.mbridge.msdk.foundation.b.c.f44012d) {
                    dVar.a("result", 1);
                } else {
                    dVar.a("result", 2);
                    dVar.a("reason", bVar2.b());
                }
                dVar.a("acr", bVar2.c());
                dVar.a("her", bVar2.e());
                dVar.a("nrr", bVar2.d());
                dVar.a("cer", bVar2.f());
            } else {
                dVar.a("result", 2);
                dVar.a("reason", "candidate result is null");
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i12 = 0; i12 < list.size(); i12++) {
                    com.mbridge.msdk.newreward.function.d.a.b bVarA = list.get(i12).a();
                    if (bVarA != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ecppv", x.b(bVarA.q() + ""));
                        jSONObject2.put("showCount", bVarA.r());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - bVarA.G());
                        jSONArray.put(jSONObject2);
                    }
                }
                dVar.a("data", jSONArray.toString());
            }
            if (bVar != null) {
                bVar.a("m_candidate_data");
                bVar.k("m_candidate_data");
                bVar.a("m_candidate_data", dVar);
                if (bVar2 != null && bVar2.a() != null && eVar != null) {
                    bVar.b(eVar.v().a());
                }
            }
            c cVar3 = this.f46163b;
            cVar3.a(eVar, com.mbridge.msdk.newreward.function.c.e.METRICS_KEY_M_CANDIDATE_DATE, cVar3.a("metrics_data", dVar));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public final boolean a(String str) {
        JSONObject jSONObjectA;
        try {
            com.mbridge.msdk.newreward.function.a.c cVar = this.f46164c;
            return (cVar == null || (jSONObjectA = cVar.a(cVar.b(str))) == null || jSONObjectA.optInt("c_cb", 0) != 1) ? false : true;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return false;
    }
}
