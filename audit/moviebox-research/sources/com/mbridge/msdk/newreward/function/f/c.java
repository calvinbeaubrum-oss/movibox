package com.mbridge.msdk.newreward.function.f;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.f.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46474a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.c.e.values().length];
            f46474a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_V3_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_V3_RES_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_V3_RES_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_V3_CAMPAIGN_SUCCESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_FAILED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_SHOW_START.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_DOWNLOAD_START.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_DOWNLOAD_END.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.METRICS_KEY_M_CANDIDATE_DATE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.METRICS_KEY_M_CANDIDATE_DB.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_CHECK.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f46474a[com.mbridge.msdk.newreward.function.c.e.REPORT_SHOW_FAIL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public final void a(com.mbridge.msdk.newreward.a.e eVar, Map map, com.mbridge.msdk.newreward.function.c.e eVar2) {
        List<CampaignEx> listC;
        if (eVar == null) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.d.b bVarB = com.mbridge.msdk.foundation.same.report.d.c.a().b(eVar.x());
            if (bVarB == null) {
                bVarB = new com.mbridge.msdk.foundation.same.report.d.b();
                bVarB.c(eVar.x());
                bVarB.b(eVar.n());
            }
            bVarB.d(eVar.y());
            bVarB.e(eVar.A());
            bVarB.i(eVar.I() ? "1" : "0");
            if (eVar.v() != null) {
                bVarB.b(eVar.v().a());
            }
            if (eVar.p() != null) {
                com.mbridge.msdk.videocommon.d.a aVarA = eVar.p().a();
                if (aVarA != null) {
                    bVarB.h(aVarA.b());
                    bVarB.f(aVarA.c());
                }
                com.mbridge.msdk.videocommon.d.c cVarB = eVar.p().b();
                if (cVarB != null) {
                    bVarB.g(cVarB.l());
                    bVarB.n(cVarB.k());
                }
            }
            Object obj = (map == null || !map.containsKey("metrics_data")) ? null : map.get("metrics_data");
            switch (AnonymousClass1.f46474a[eVar2.ordinal()]) {
                case 1:
                    bVarB.a("2000125");
                    com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar.a(map);
                    bVarB.a("2000125", dVar);
                    break;
                case 2:
                    bVarB.a("2000126");
                    if (obj != null && (obj instanceof com.mbridge.msdk.newreward.function.d.a.b)) {
                        bVarB.b(((com.mbridge.msdk.newreward.function.d.a.b) obj).C());
                    }
                    if (map != null) {
                        map.remove("metrics_data");
                    }
                    com.mbridge.msdk.foundation.same.report.d.d dVar2 = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar2.a(map);
                    bVarB.a("2000126", dVar2);
                    break;
                case 3:
                    bVarB.a("2000126");
                    com.mbridge.msdk.foundation.same.report.d.d dVar3 = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar3.a(map);
                    bVarB.a("2000126", dVar3);
                    break;
                case 4:
                    bVarB.a("m_v3_req_retry_start");
                    com.mbridge.msdk.foundation.same.report.d.d dVar4 = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar4.a(map);
                    bVarB.a("m_v3_req_retry_start", dVar4);
                    break;
                case 5:
                    bVarB.a("m_v3_req_retry_end");
                    com.mbridge.msdk.foundation.same.report.d.d dVar5 = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar5.a(map);
                    bVarB.a("m_v3_req_retry_end", dVar5);
                    break;
                case 6:
                    bVarB.a("2000127");
                    if (obj != null && (obj instanceof com.mbridge.msdk.newreward.function.d.a.b)) {
                        bVarB.b(((com.mbridge.msdk.newreward.function.d.a.b) obj).C());
                    }
                    if (map != null) {
                        map.remove("metrics_data");
                    }
                    com.mbridge.msdk.foundation.same.report.d.d dVar6 = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar6.a(map);
                    bVarB.a("2000127", dVar6);
                    break;
                case 7:
                    bVarB.a("2000048");
                    if (obj != null && (obj instanceof com.mbridge.msdk.newreward.function.d.a.b)) {
                        bVarB.b(((com.mbridge.msdk.newreward.function.d.a.b) obj).C());
                    }
                    if (map != null) {
                        map.remove("metrics_data");
                    }
                    com.mbridge.msdk.foundation.same.report.d.d dVar7 = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar7.a(map);
                    bVarB.a("2000048", dVar7);
                    break;
                case 8:
                    bVarB.a("2000047");
                    if (obj != null && (obj instanceof com.mbridge.msdk.foundation.c.b)) {
                        bVarB.a((com.mbridge.msdk.foundation.c.b) obj);
                    }
                    break;
                case 9:
                    com.mbridge.msdk.foundation.same.report.d.d dVar8 = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar8.a("m_load_check", Integer.valueOf(eVar.j() ? 1 : 0));
                    bVarB.a("2000128", dVar8);
                    bVarB.a("2000128");
                    break;
                case 10:
                    bVarB.a("m_download_start");
                    com.mbridge.msdk.foundation.same.report.d.d dVar9 = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar9.a(map);
                    int iIntValue = (map == null || !(map.get("resource_type") instanceof Integer)) ? 0 : ((Integer) map.get("resource_type")).intValue();
                    bVarB.a("m_download_start", dVar9, iIntValue);
                    bVarB.a(iIntValue);
                    break;
                case 11:
                    bVarB.a("m_download_end");
                    com.mbridge.msdk.foundation.same.report.d.d dVar10 = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar10.a(map);
                    int iIntValue2 = (map == null || !(map.get("resource_type") instanceof Integer)) ? 0 : ((Integer) map.get("resource_type")).intValue();
                    bVarB.a("m_download_end", dVar10, iIntValue2);
                    bVarB.a(iIntValue2);
                    break;
                case 12:
                    bVarB.a("m_candidate_data");
                    bVarB.a("m_candidate_data", (com.mbridge.msdk.foundation.same.report.d.d) (map != null ? map.get("metrics_data") : new com.mbridge.msdk.foundation.same.report.d.d()));
                    break;
                case 13:
                    bVarB.a("m_candidate_db");
                    bVarB.a("m_candidate_db", (com.mbridge.msdk.foundation.same.report.d.d) (map != null ? map.get("metrics_data") : new com.mbridge.msdk.foundation.same.report.d.d()));
                    break;
                case 14:
                    bVarB.a("m_load_check");
                    com.mbridge.msdk.newreward.function.d.a.b bVar = (map == null || !map.containsKey("campaign")) ? null : (com.mbridge.msdk.newreward.function.d.a.b) map.remove("campaign");
                    if (bVar != null && (listC = bVar.C()) != null) {
                        bVarB.b(listC);
                    }
                    com.mbridge.msdk.foundation.same.report.d.d dVar11 = new com.mbridge.msdk.foundation.same.report.d.d();
                    if (map != null) {
                        dVar11.a(map);
                    }
                    bVarB.a("m_load_check", dVar11);
                    break;
            }
            com.mbridge.msdk.foundation.same.report.d.c.a().a(bVarB);
            com.mbridge.msdk.foundation.same.report.d.c.a().a(bVarB.c(), bVarB, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(com.mbridge.msdk.newreward.b.b bVar, Map map, com.mbridge.msdk.newreward.function.c.e eVar) {
        if (bVar == null) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.d.b bVar2 = new com.mbridge.msdk.foundation.same.report.d.b();
            bVar2.c(bVar.b());
            bVar2.b(bVar.e());
            bVar2.d(bVar.c());
            bVar2.i(bVar.f() ? "1" : "0");
            if (bVar.g() != null) {
                com.mbridge.msdk.videocommon.d.a aVarA = bVar.g().a();
                if (aVarA != null) {
                    bVar2.h(aVarA.b());
                    bVar2.f(aVarA.c());
                }
                com.mbridge.msdk.videocommon.d.c cVarB = bVar.g().b();
                if (cVarB != null) {
                    bVar2.g(cVarB.l());
                    bVar2.n(cVarB.k());
                }
            }
            int i11 = AnonymousClass1.f46474a[eVar.ordinal()];
            if (i11 == 9) {
                bVar2.a("2000128");
            } else if (i11 == 15) {
                bVar2.a("2000131");
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a(map);
                bVar2.a("2000131", dVar);
            }
            com.mbridge.msdk.foundation.same.report.d.c.a().a(bVar2);
            com.mbridge.msdk.foundation.same.report.d.c.a().a(bVar2.c(), bVar2, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }
}
