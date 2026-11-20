package com.mbridge.msdk.out;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.c.b;
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
public class MBRewardVideoHandler implements BaseExtraInterfaceForHandler {
    private static final String AD_TYPE = "rv";
    private static final String REFACTOR_SWITCH_REWARD_VIDEO = "new_bridge_reward_video";
    private static final String TAG = "MBRewardVideoHandler";
    private a controller;
    private d newController;
    private boolean refactorAvailable = false;
    private String unitId;

    public MBRewardVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        if (context instanceof Activity) {
            c.m().a(context);
        }
        String strE = ai.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ai.b(str2, strE);
        }
        initMBRewardVideoHandler(str, str2);
    }

    public MBRewardVideoHandler(String str, String str2) {
        String strE = ai.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ai.b(str2, strE);
        }
        initMBRewardVideoHandler(str, str2);
    }

    private void initMBNewRewardVideoHandler(String str, String str2) {
        this.unitId = str2;
        if (this.newController == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.newController = new d(94, str, str2, false);
        }
    }

    private void initMBRewardVideoHandler(String str, String str2) {
        boolean zIsAvailable = MBridgeRefactor.getInstance().isAvailable("new_bridge_reward_video");
        this.refactorAvailable = zIsAvailable;
        if (zIsAvailable) {
            initMBNewRewardVideoHandler(str, str2);
            return;
        }
        this.unitId = str2;
        try {
            if (this.controller == null) {
                a aVar = new a();
                this.controller = aVar;
                aVar.a(false);
            }
            this.controller.b(str, str2);
        } catch (Throwable th2) {
            ad.a(TAG, th2.getMessage(), th2);
        }
    }

    public void clearBitmapCache() {
        try {
            b.a(c.m().c()).c();
        } catch (Throwable th2) {
            ad.b(TAG, th2.getMessage());
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

    public boolean isReady() {
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

    public void load() {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a(true, "");
                return;
            }
            return;
        }
        if (this.controller != null) {
            this.controller.a(true, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, 94, this.unitId, true, 2));
        }
    }

    public void loadFormSelfFilling() {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        if (this.controller != null) {
            this.controller.a(false, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, 94, this.unitId, true, 1));
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
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a(new RewardVideoListenerWrapper(gVar));
                return;
            }
            return;
        }
        if (this.controller != null) {
            if (com.mbridge.msdk.f.b.a()) {
                this.controller.a(new com.mbridge.msdk.video.bt.module.b.a(gVar, this.unitId, false));
            } else {
                this.controller.a(new com.mbridge.msdk.video.bt.module.b.a(gVar));
            }
        }
    }

    public void show() {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a("");
                return;
            }
            return;
        }
        if (this.controller != null) {
            this.controller.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, 94, this.unitId, false, -1));
        }
    }

    public void show(String str) {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a("");
                return;
            }
            return;
        }
        if (this.controller != null) {
            this.controller.a((String) null, str, (String) null, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, 94, this.unitId, false, -1));
        }
    }

    public void show(String str, String str2) {
        if (this.refactorAvailable) {
            d dVar = this.newController;
            if (dVar != null) {
                dVar.a("");
                return;
            }
            return;
        }
        if (this.controller != null) {
            this.controller.a((String) null, str, str2, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, 94, this.unitId, false, -1));
        }
    }
}
