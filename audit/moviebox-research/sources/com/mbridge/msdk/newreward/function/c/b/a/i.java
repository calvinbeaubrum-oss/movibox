package com.mbridge.msdk.newreward.function.c.b.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.d.c.n;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.reward.player.MBRewardVideoActivity;
import com.transsion.push.PushConstants;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements com.mbridge.msdk.newreward.function.c.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.mbridge.msdk.newreward.a.e f46193a;

    /* JADX INFO: compiled from: source.java */
    public static class a implements com.mbridge.msdk.video.bt.module.b.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.d.a.b f46194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.e f46195b;

        public a(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.a.e eVar) {
            this.f46194a = bVar;
            this.f46195b = eVar;
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(int i11, String str, String str2) {
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar) {
            try {
                com.mbridge.msdk.newreward.function.e.c.a().b().a(this.f46194a.a(), this.f46194a.b(), this.f46194a.c(), this.f46194a.e(), 6);
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000130", bVar);
                this.f46195b.B().onAdShow(new MBridgeIds(this.f46195b.u(), this.f46195b.y()));
            } catch (Exception e11) {
                ad.a("DefaultShowRewardListener", "onAdShow", e11);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar, String str) {
            try {
                com.mbridge.msdk.newreward.function.e.c.a().b().a(this.f46194a.a(), this.f46194a.b(), this.f46194a.c(), this.f46194a.e(), 7);
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("reason", str);
                bVar.a("2000131", dVar);
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000131", bVar);
                this.f46195b.B().onShowFail(new MBridgeIds(this.f46195b.u(), this.f46195b.y()), str);
            } catch (Exception e11) {
                ad.a("DefaultShowRewardListener", "onShowFail", e11);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar, boolean z11, com.mbridge.msdk.videocommon.b.c cVar) {
            try {
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000152", bVar);
                this.f46195b.B().onAdClose(new MBridgeIds(this.f46195b.u(), this.f46195b.y()), new RewardInfo(z11, cVar.a(), String.valueOf(cVar.b())));
            } catch (Exception e11) {
                ad.a("DefaultShowRewardListener", "onAdClose", e11);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(String str, String str2) {
            try {
                this.f46195b.B().onVideoComplete(new MBridgeIds(this.f46195b.u(), this.f46195b.y()));
            } catch (Exception e11) {
                ad.a("DefaultShowRewardListener", "onVideoComplete", e11);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(boolean z11, int i11) {
            try {
                this.f46195b.B().onAdCloseWithIVReward(new MBridgeIds(this.f46195b.u(), this.f46195b.y()), z11, i11);
            } catch (Exception e11) {
                ad.a("DefaultShowRewardListener", "onAdCloseWithIVReward", e11);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void a(boolean z11, String str, String str2) {
            try {
                this.f46195b.B().onVideoAdClicked(new MBridgeIds(this.f46195b.u(), this.f46195b.y()));
            } catch (Exception e11) {
                ad.a("DefaultShowRewardListener", "onVideoAdClicked", e11);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.h
        public final void b(String str, String str2) {
            try {
                com.mbridge.msdk.foundation.d.b.a().a(str2 + "_2", 2);
                this.f46195b.B().onEndcardShow(new MBridgeIds(this.f46195b.u(), this.f46195b.y()));
            } catch (Exception e11) {
                ad.a("DefaultShowRewardListener", "onEndcardShow", e11);
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.function.c.b.b
    public final void a(Object obj) {
        Intent intent;
        com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) ((com.mbridge.msdk.newreward.function.c.b) obj).b();
        this.f46193a = eVar;
        if (eVar != null) {
            try {
                com.mbridge.msdk.newreward.function.d.a.b bVarB = eVar.v().b();
                try {
                    Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                    String str = MBRewardVideoActivity.INTENT_UNITID;
                    intent = new Intent(contextC, (Class<?>) MBRewardVideoActivity.class);
                } catch (Exception unused) {
                    intent = null;
                }
                intent.putExtra(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f46193a.y());
                intent.putExtra(MBridgeConstans.PLACEMENT_ID, this.f46193a.u());
                intent.putExtra(CampaignEx.JSON_NATIVE_VIDEO_MUTE, this.f46193a.F());
                boolean z11 = this.f46193a.n() == 287;
                intent.putExtra("isIV", z11);
                intent.putExtra("isBid", TextUtils.isEmpty(this.f46193a.A()));
                if (z11) {
                    intent.putExtra("ivRewardMode", this.f46193a.i());
                    intent.putExtra("ivRewardValueType", this.f46193a.h());
                    intent.putExtra("ivRewardValue", this.f46193a.i());
                }
                intent.putExtra("isBigOffer", !TextUtils.isEmpty(bVarB.z()));
                intent.putExtra("is_refactor", true);
                List<com.mbridge.msdk.newreward.function.d.a.a> listS = bVarB.s();
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.a> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                for (com.mbridge.msdk.newreward.function.d.a.a aVar : listS) {
                    CampaignEx campaignExG = aVar.g();
                    campaignExG.setReady_rate(100);
                    copyOnWriteArrayList.add(campaignExG);
                    com.mbridge.msdk.videocommon.download.a aVar2 = new com.mbridge.msdk.videocommon.download.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignExG, this.f46193a.y(), 1);
                    aVar2.d(this.f46193a.n());
                    aVar2.d(campaignExG.getVideoUrlEncode());
                    n nVarD = aVar.d();
                    if (nVarD != null) {
                        aVar2.c(nVarD.f().getPath());
                    }
                    copyOnWriteArrayList2.add(aVar2);
                }
                com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f46193a.y(), copyOnWriteArrayList);
                com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f46193a.y(), copyOnWriteArrayList2);
                intent.addFlags(ASTNode.DEOP);
                MBridgeGlobalCommon.showRewardListener = new a(bVarB, this.f46193a);
                com.mbridge.msdk.foundation.controller.c.m().c().startActivity(intent);
            } catch (Exception e11) {
                ad.a("ShowReceiver", PushConstants.PUSH_SERVICE_TYPE_SHOW, e11);
            }
        }
    }
}
