package com.mbridge.msdk.newreward.function.f;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.d.a.b f46445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f46446b;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0509a implements com.mbridge.msdk.newreward.a.b.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.newreward.a.e f46448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a f46449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.mbridge.msdk.newreward.a.b.b f46450c;

        public C0509a(com.mbridge.msdk.newreward.a.e eVar, a aVar, com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f46448a = eVar;
            this.f46449b = aVar;
            this.f46450c = bVar;
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void a(com.mbridge.msdk.foundation.c.b bVar) {
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f46450c;
            if (bVar2 == null) {
                return;
            }
            try {
                bVar2.a(bVar);
            } catch (Exception e11) {
                ad.a("CampaignModel", "reqFailed: ", e11);
            }
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void a(Object obj) {
            try {
                com.mbridge.msdk.newreward.function.d.a.b bVar = (com.mbridge.msdk.newreward.function.d.a.b) obj;
                bVar.b(this.f46448a.x());
                int iH = (int) (((double) this.f46448a.H()) * 1.2d);
                bVar.d(iH);
                bVar.e(iH);
                bVar.b(Math.max(this.f46448a.J(), bVar.n()));
                this.f46449b.a(bVar);
                if (!TextUtils.isEmpty(bVar.i())) {
                    MBridgeGlobalCommon.SESSION_ID = bVar.i();
                }
                MBridgeSharedPreferenceModel.getInstance().putInteger(String.format(MBridgeCommon.SharedPreference.KEY_VCN, bVar.c()), bVar.D());
                com.mbridge.msdk.newreward.function.e.c.a().b().a(bVar);
                com.mbridge.msdk.newreward.a.b.b bVar2 = this.f46450c;
                if (bVar2 == null) {
                    return;
                }
                bVar2.a(obj);
            } catch (Exception e11) {
                ad.a("CampaignModel", "reqSuccessful: ", e11);
                com.mbridge.msdk.newreward.a.b.b bVar3 = this.f46450c;
                if (bVar3 != null) {
                    bVar3.a(new com.mbridge.msdk.foundation.c.b(880020, e11.getMessage()));
                }
            }
        }
    }

    private void a(k kVar, CampaignEx campaignEx) {
        if (kVar == null || kVar.b(campaignEx.getId())) {
            return;
        }
        g gVar = new g();
        gVar.a(campaignEx.getId());
        gVar.b(campaignEx.getFca());
        gVar.c(campaignEx.getFcb());
        gVar.a(0);
        gVar.d(0);
        gVar.a(System.currentTimeMillis());
        kVar.a(gVar);
    }

    private boolean a(com.mbridge.msdk.newreward.function.d.a.a aVar) {
        CampaignEx campaignExG;
        if (aVar != null && (campaignExG = aVar.g()) != null) {
            try {
                if (campaignExG.getPlayable_ads_without_video() == 2) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public final List<CampaignEx> a() {
        com.mbridge.msdk.newreward.function.d.a.b bVar = this.f46445a;
        if (bVar == null) {
            return null;
        }
        return bVar.C();
    }

    public final void a(com.mbridge.msdk.newreward.a.e eVar, com.mbridge.msdk.newreward.function.g.a aVar, com.mbridge.msdk.newreward.a.b.b bVar) {
        this.f46446b = eVar;
        try {
            new com.mbridge.msdk.newreward.a.b.c(eVar).a(aVar, new C0509a(eVar, this, bVar));
        } catch (IOException e11) {
            if (bVar != null) {
                bVar.a(new com.mbridge.msdk.foundation.c.b(880020, e11.getMessage()));
            }
        }
    }

    public final void a(com.mbridge.msdk.newreward.function.d.a.b bVar) {
        this.f46445a = bVar;
    }

    public final com.mbridge.msdk.newreward.function.d.a.b b() {
        return this.f46445a;
    }

    public final void b(com.mbridge.msdk.newreward.function.d.a.b bVar) throws MBridgeError {
        boolean z11;
        if (bVar == null || bVar.s() == null) {
            throw new MBridgeError(880003, "Need show campaign list is NULL!");
        }
        for (com.mbridge.msdk.newreward.function.d.a.a aVar : bVar.s()) {
            CampaignEx campaignExG = aVar.g();
            if (campaignExG != null && campaignExG.getOfferType() != 99) {
                if (a(aVar)) {
                    z11 = (an.a(campaignExG.getendcard_url()) && TextUtils.isEmpty(campaignExG.getMraid())) ? false : true;
                    if (aVar.f() == null && aVar.e() == null) {
                        throw new MBridgeError(880003, "playable offer endcard or mraid is null");
                    }
                } else {
                    z11 = !an.a(campaignExG.getVideoUrlEncode());
                    if (aVar.d() == null) {
                        throw new MBridgeError(880003, "No video campaign");
                    }
                }
                if (z11) {
                    Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                    if (com.mbridge.msdk.f.b.a() && ai.c(campaignExG)) {
                        campaignExG.setRtinsType(ai.c(contextC, campaignExG.getPackageName()) ? 1 : 2);
                    }
                    try {
                        com.mbridge.msdk.foundation.same.report.d.b bVarB = com.mbridge.msdk.foundation.same.report.d.c.a().b(campaignExG.getLocalRequestId());
                        if (bVarB == null) {
                            bVarB = new com.mbridge.msdk.foundation.same.report.d.b();
                            bVarB.c(campaignExG.getLocalRequestId());
                            bVarB.b(campaignExG.getAdType());
                            bVarB.d(campaignExG.getCampaignUnitId());
                            bVarB.i(campaignExG.isBidCampaign() ? "1" : "0");
                        }
                        bVarB.a(campaignExG);
                        com.mbridge.msdk.newreward.a.e eVar = this.f46446b;
                        if (eVar != null && eVar.p() != null) {
                            com.mbridge.msdk.videocommon.d.a aVarA = this.f46446b.p().a();
                            if (aVarA != null) {
                                bVarB.h(aVarA.b());
                                bVarB.f(aVarA.c());
                            }
                            com.mbridge.msdk.videocommon.d.c cVarB = this.f46446b.p().b();
                            if (cVarB != null) {
                                bVarB.g(cVarB.l());
                                bVarB.n(cVarB.k());
                            }
                        }
                        com.mbridge.msdk.foundation.same.b.a(campaignExG, com.mbridge.msdk.foundation.controller.c.m().c(), bVarB, new com.mbridge.msdk.foundation.same.b.a() { // from class: com.mbridge.msdk.newreward.function.f.a.1
                            @Override // com.mbridge.msdk.foundation.same.b.a
                            public final void a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar2) {
                                com.mbridge.msdk.foundation.same.report.d.c.a().a(str, bVar2);
                            }
                        });
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                        }
                    }
                    if (!com.mbridge.msdk.foundation.same.b.a(contextC, campaignExG)) {
                        ai.a(bVar.c(), campaignExG, com.mbridge.msdk.foundation.same.a.f44388x);
                        throw new MBridgeError(880021, "APP ALREADY INSTALLED");
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public final void c(com.mbridge.msdk.newreward.function.d.a.b bVar) {
        if (bVar == null || bVar.s() == null) {
            return;
        }
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        k kVarA = k.a(h.a(contextC));
        Iterator<com.mbridge.msdk.newreward.function.d.a.a> it = bVar.s().iterator();
        while (it.hasNext()) {
            CampaignEx campaignExG = it.next().g();
            if (campaignExG != null) {
                if (!com.mbridge.msdk.f.b.a()) {
                    a(kVarA, campaignExG);
                } else if (!ai.c(contextC, campaignExG.getPackageName())) {
                    a(kVarA, campaignExG);
                }
            }
        }
    }

    public final boolean c() {
        com.mbridge.msdk.newreward.function.d.a.b bVar = this.f46445a;
        return bVar != null && bVar.y();
    }
}
