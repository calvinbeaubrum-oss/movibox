package com.mbridge.msdk.newinterstitial.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.newreward.b.d;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeRefactor;
import com.mbridge.msdk.out.BaseExtraInterfaceForHandler;
import com.mbridge.msdk.reward.b.a;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MBBidNewInterstitialHandler implements BaseExtraInterfaceForHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f45962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f45963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f45964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f45965d = false;

    public MBBidNewInterstitialHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String strE = ai.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ai.b(str2, strE);
        }
        a(str, str2);
    }

    public MBBidNewInterstitialHandler(String str, String str2) {
        a(str, str2);
    }

    private void a(String str, String str2) {
        boolean zIsAvailable = MBridgeRefactor.getInstance().isAvailable(MBridgeRefactor.REFACTOR_SWITCH_NEW_INTERSTITIAL_VIDEO);
        this.f45965d = zIsAvailable;
        if (zIsAvailable) {
            b(str, str2);
            return;
        }
        this.f45963b = str2;
        try {
            if (this.f45962a == null) {
                a aVar = new a();
                this.f45962a = aVar;
                aVar.a(true);
                this.f45962a.b(true);
            }
            this.f45962a.b(str, str2);
        } catch (Throwable th2) {
            ad.a("MBBidNewInterstitialHandler", th2.getMessage(), th2);
        }
    }

    private void b(String str, String str2) {
        this.f45963b = str2;
        if (this.f45964c == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.f45964c = new d(287, str, str2, true);
        }
    }

    public void clearVideoCache() {
        if (this.f45965d) {
            return;
        }
        try {
            if (this.f45962a != null) {
                ab.b();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f45965d) {
            d dVar = this.f45964c;
            return dVar != null ? dVar.d() : "";
        }
        a aVar = this.f45962a;
        return aVar != null ? aVar.d() : "";
    }

    public String getRequestId() {
        if (this.f45965d) {
            d dVar = this.f45964c;
            return dVar != null ? dVar.c() : "";
        }
        a aVar = this.f45962a;
        return aVar != null ? aVar.a() : "";
    }

    public boolean isBidReady() {
        if (this.f45965d) {
            d dVar = this.f45964c;
            if (dVar != null) {
                return dVar.b();
            }
            return false;
        }
        a aVar = this.f45962a;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        if (this.f45965d) {
            d dVar = this.f45964c;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        if (this.f45962a != null) {
            this.f45962a.a(false, com.mbridge.msdk.foundation.same.report.d.c.a().a(1, 287, this.f45963b, true, 1));
        }
    }

    public void loadFromBid(String str) {
        if (this.f45965d) {
            d dVar = this.f45964c;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        if (this.f45962a != null) {
            this.f45962a.a(true, str, com.mbridge.msdk.foundation.same.report.d.c.a().a(1, 287, this.f45963b, true, 2));
        }
    }

    public void playVideoMute(int i11) {
        if (this.f45965d) {
            d dVar = this.f45964c;
            if (dVar != null) {
                dVar.a(i11);
                return;
            }
            return;
        }
        a aVar = this.f45962a;
        if (aVar != null) {
            aVar.a(i11);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        if (this.f45965d) {
            MBridgeGlobalCommon.setAlertDialogText(this.f45963b, str, str2, str3, str4);
            return;
        }
        a aVar = this.f45962a;
        if (aVar != null) {
            aVar.a(str, str2, str3, str4);
        }
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.f45963b, jSONObject);
    }

    public void setIVRewardEnable(int i11, double d11) {
        if (this.f45965d) {
            d dVar = this.f45964c;
            if (dVar != null) {
                dVar.a(i11, com.mbridge.msdk.foundation.same.a.I, (int) (d11 * 100.0d));
                return;
            }
            a aVar = this.f45962a;
            if (aVar != null) {
                aVar.a(i11, com.mbridge.msdk.foundation.same.a.I, (int) (d11 * 100.0d));
            }
        }
    }

    public void setIVRewardEnable(int i11, int i12) {
        if (this.f45965d) {
            d dVar = this.f45964c;
            if (dVar != null) {
                dVar.a(i11, com.mbridge.msdk.foundation.same.a.J, i12);
                return;
            }
            return;
        }
        a aVar = this.f45962a;
        if (aVar != null) {
            aVar.a(i11, com.mbridge.msdk.foundation.same.a.J, i12);
        }
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        if (this.f45965d) {
            d dVar = this.f45964c;
            if (dVar != null) {
                dVar.a(new NewInterstitialListenerWrapper(newInterstitialListener));
                return;
            }
            return;
        }
        a aVar = this.f45962a;
        if (aVar != null) {
            aVar.a(new com.mbridge.msdk.newinterstitial.a.a(newInterstitialListener, this.f45963b, true));
        }
    }

    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        if (this.f45965d) {
            d dVar = this.f45964c;
            if (dVar != null) {
                dVar.a(new NewInterstitialListenerWrapper(newInterstitialListener));
                return;
            }
            return;
        }
        a aVar = this.f45962a;
        if (aVar != null) {
            aVar.a(new com.mbridge.msdk.newinterstitial.a.a(newInterstitialListener, this.f45963b, true));
        }
    }

    public void showFromBid() {
        if (this.f45965d) {
            d dVar = this.f45964c;
            if (dVar != null) {
                dVar.a("");
                return;
            }
            return;
        }
        if (this.f45962a != null) {
            this.f45962a.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.c.a().a(1, 287, this.f45963b, false, -1));
        }
    }
}
