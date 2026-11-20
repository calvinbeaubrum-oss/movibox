package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.f.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.newreward.b.d;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeRefactor;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.video.bt.module.b.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBBidRewardVideoHandler implements BaseExtraInterfaceForHandler {
    private static final String AD_TYPE = "rv";
    private static final String REFACTOR_SWITCH_REWARD_VIDEO = "new_bridge_reward_video";
    private static final String TAG = "MBBidRewardVideoHandler";
    private a controller;
    private d newController;
    private boolean refactorAvailable = false;
    private String unitId;

    public MBBidRewardVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String strE = ai.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ai.b(str2, strE);
        }
        initMBBidRewardVideoHandler(str, str2);
    }

    public MBBidRewardVideoHandler(String str, String str2) {
        String strE = ai.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ai.b(str2, strE);
        }
        initMBBidRewardVideoHandler(str, str2);
    }

    private void initMBBidRewardVideoHandler(String str, String str2) {
        boolean zIsAvailable = MBridgeRefactor.getInstance().isAvailable("new_bridge_reward_video");
        this.refactorAvailable = zIsAvailable;
        if (zIsAvailable) {
            initMBNewBidRewardVideoHandler(str, str2);
            return;
        }
        this.unitId = str2;
        try {
            if (this.controller == null) {
                a aVar = new a();
                this.controller = aVar;
                aVar.a(false);
                this.controller.b(true);
            }
            this.controller.b(str, str2);
        } catch (Throwable th2) {
            ad.a(TAG, th2.getMessage(), th2);
        }
    }

    private void initMBNewBidRewardVideoHandler(String str, String str2) {
        this.unitId = str2;
        if (this.newController == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.newController = new d(94, str, str2, true);
        }
    }

    public void clearVideoCache() {
        if (this.refactorAvailable) {
            return;
        }
        try {
            if (this.controller != null) {
                ab.b();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            return dVar != null ? dVar.d() : "";
        }
        a aVar = this.controller;
        return aVar != null ? aVar.d() : "";
    }

    public String getRequestId() {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            return dVar != null ? dVar.c() : "";
        }
        a aVar = this.controller;
        return aVar != null ? aVar.a() : "";
    }

    public boolean isBidReady() {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                return dVar.b();
            }
            return false;
        }
        a aVar = this.controller;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFromBid(String str) {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        if (this.controller != null) {
            this.controller.a(true, str, com.mbridge.msdk.foundation.same.report.d.c.a().a(1, 94, this.unitId, true, 2));
        }
    }

    public void playVideoMute(int i11) {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a(i11);
                return;
            }
            return;
        }
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(i11);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        if (this.refactorAvailable) {
            MBridgeGlobalCommon.setAlertDialogText(this.unitId, str, str2, str3, str4);
            return;
        }
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(str, str2, str3, str4);
        }
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.unitId, jSONObject);
    }

    public void setRewardPlus(boolean z11) {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a(z11);
                return;
            }
            return;
        }
        a aVar = this.controller;
        if (aVar != null) {
            aVar.c(z11);
        }
    }

    public void setRewardVideoListener(g gVar) {
        d dVar;
        if (this.refactorAvailable && (dVar = this.newController) != null) {
            dVar.a(new RewardVideoListenerWrapper(gVar));
        }
        if (this.controller != null) {
            if (b.a()) {
                this.controller.a(new com.mbridge.msdk.video.bt.module.b.a(gVar, this.unitId, true));
            } else {
                this.controller.a(new com.mbridge.msdk.video.bt.module.b.a(gVar));
            }
        }
    }

    public void showFromBid() {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a("");
                return;
            }
            return;
        }
        if (this.controller != null) {
            this.controller.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.c.a().a(1, 94, this.unitId, false, -1));
        }
    }

    public void showFromBid(String str) {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a("");
                return;
            }
            return;
        }
        if (this.controller != null) {
            this.controller.a((String) null, str, (String) null, com.mbridge.msdk.foundation.same.report.d.c.a().a(1, 94, this.unitId, false, -1));
        }
    }

    public void showFromBid(String str, String str2) {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a("");
                return;
            }
            return;
        }
        if (this.controller != null) {
            this.controller.a((String) null, str, str2, com.mbridge.msdk.foundation.same.report.d.c.a().a(1, 94, this.unitId, false, -1));
        }
    }
}
