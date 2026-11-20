package com.mbridge.msdk.interstitialvideo.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.newreward.b.d;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeRefactor;
import com.mbridge.msdk.reward.b.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class MBBidInterstitialVideoHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f45215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f45216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f45217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f45218d = false;

    public MBBidInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String strE = ai.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ai.b(str2, strE);
        }
        a(str, str2);
    }

    public MBBidInterstitialVideoHandler(String str, String str2) {
        a(str, str2);
    }

    private void a(String str, String str2) {
        boolean zIsAvailable = MBridgeRefactor.getInstance().isAvailable(MBridgeRefactor.REFACTOR_SWITCH_REWARD_VIDEO);
        this.f45218d = zIsAvailable;
        if (zIsAvailable) {
            b(str, str2);
            return;
        }
        this.f45216b = str2;
        try {
            if (this.f45215a == null) {
                a aVar = new a();
                this.f45215a = aVar;
                aVar.a(true);
                this.f45215a.b(true);
            }
            this.f45215a.b(str, str2);
        } catch (Throwable th2) {
            ad.a("MBBidRewardVideoHandler", th2.getMessage(), th2);
        }
    }

    private void b(String str, String str2) {
        this.f45216b = str2;
        if (this.f45217c == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.f45217c = new d(287, str, str2, true);
        }
    }

    public void clearVideoCache() {
        if (this.f45218d) {
            return;
        }
        try {
            if (this.f45215a != null) {
                ab.b();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f45218d) {
            d dVar = this.f45217c;
            return dVar != null ? dVar.d() : "";
        }
        a aVar = this.f45215a;
        return aVar != null ? aVar.d() : "";
    }

    public String getRequestId() {
        if (this.f45218d) {
            d dVar = this.f45217c;
            return dVar != null ? dVar.c() : "";
        }
        a aVar = this.f45215a;
        return aVar != null ? aVar.a() : "";
    }

    public boolean isBidReady() {
        if (this.f45218d) {
            d dVar = this.f45217c;
            if (dVar != null) {
                return dVar.b();
            }
            return false;
        }
        a aVar = this.f45215a;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        if (this.f45218d) {
            d dVar = this.f45217c;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        if (this.f45215a != null) {
            this.f45215a.a(false, com.mbridge.msdk.foundation.same.report.d.c.a().a(1, 287, this.f45216b, true, 1));
        }
    }

    public void loadFromBid(String str) {
        if (this.f45218d) {
            d dVar = this.f45217c;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        if (this.f45215a != null) {
            this.f45215a.a(true, str, com.mbridge.msdk.foundation.same.report.d.c.a().a(1, 287, this.f45216b, true, 2));
        }
    }

    public void playVideoMute(int i11) {
        if (this.f45218d) {
            d dVar = this.f45217c;
            if (dVar != null) {
                dVar.a(i11);
                return;
            }
            return;
        }
        a aVar = this.f45215a;
        if (aVar != null) {
            aVar.a(i11);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        if (this.f45218d) {
            MBridgeGlobalCommon.setAlertDialogText(this.f45216b, str, str2, str3, str4);
            return;
        }
        a aVar = this.f45215a;
        if (aVar != null) {
            aVar.a(str, str2, str3, str4);
        }
    }

    public void setIVRewardEnable(int i11, double d11) {
        if (this.f45218d) {
            d dVar = this.f45217c;
            if (dVar != null) {
                dVar.a(i11, com.mbridge.msdk.foundation.same.a.I, (int) (d11 * 100.0d));
                return;
            }
            return;
        }
        a aVar = this.f45215a;
        if (aVar != null) {
            aVar.a(i11, com.mbridge.msdk.foundation.same.a.I, (int) (d11 * 100.0d));
        }
    }

    public void setIVRewardEnable(int i11, int i12) {
        if (this.f45218d) {
            d dVar = this.f45217c;
            if (dVar != null) {
                dVar.a(i11, com.mbridge.msdk.foundation.same.a.J, i12);
                return;
            }
            return;
        }
        a aVar = this.f45215a;
        if (aVar != null) {
            aVar.a(i11, com.mbridge.msdk.foundation.same.a.J, i12);
        }
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        if (this.f45218d) {
            d dVar = this.f45217c;
            if (dVar != null) {
                dVar.a(new InterstitialVideoListenerWrapper(interstitialVideoListener));
                return;
            }
            return;
        }
        a aVar = this.f45215a;
        if (aVar != null) {
            aVar.a(new com.mbridge.msdk.interstitialvideo.a.a(interstitialVideoListener, this.f45216b, true));
        }
    }

    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        if (this.f45218d) {
            d dVar = this.f45217c;
            if (dVar != null) {
                dVar.a(new InterstitialVideoListenerWrapper(interstitialVideoListener));
                return;
            }
            return;
        }
        a aVar = this.f45215a;
        if (aVar != null) {
            aVar.a(new com.mbridge.msdk.interstitialvideo.a.a(interstitialVideoListener, this.f45216b, true));
        }
    }

    public void showFromBid() {
        if (this.f45218d) {
            d dVar = this.f45217c;
            if (dVar != null) {
                dVar.a("");
                return;
            }
            return;
        }
        if (this.f45215a != null) {
            this.f45215a.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.c.a().a(1, 287, this.f45216b, false, -1));
        }
    }
}
