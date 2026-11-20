package com.hisavana.mediation.ad;

import android.app.Activity;
import android.content.Context;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import hn.c;
import hn.h;
import hn.k;
import in.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TInterstitialAd extends b<BaseInterstitial> {
    public TInterstitialAd(Context context, String str) {
        super(context, str);
    }

    @Override // in.b
    public c a(CloudControlConfig.CodeSeat codeSeat) {
        return new k(codeSeat, d(), this.f67240h);
    }

    @Override // in.b
    public boolean a(int i11) {
        return i11 == 3;
    }

    @Override // in.b
    public boolean c() {
        return false;
    }

    public void show(Activity activity) {
        show(activity, "");
    }

    public void show(Activity activity, String str) {
        n();
        if (this.f67245m) {
            TAdErrorCode tAdErrorCode = TAdErrorCode.ERROR_CURRENT_OBJECT_IS_DESTROYED;
            trackingTriggerShowError(tAdErrorCode);
            b(tAdErrorCode);
            return;
        }
        if (this.f67239g == null) {
            this.f67239g = h.a(this.f67233a);
        }
        TAdErrorCode tAdErrorCodeB = b(this.f67239g);
        if (tAdErrorCodeB != null) {
            trackingTriggerShowError(tAdErrorCodeB);
            b(tAdErrorCodeB);
            return;
        }
        try {
            c cVarG = g();
            if (cVarG != null) {
                BaseInterstitial baseInterstitial = (BaseInterstitial) cVarG.c(this.f67249q);
                if (baseInterstitial != null) {
                    baseInterstitial.mBundle.putInt(TrackingKey.FILLING_SOURCE, this.mFillSource);
                    baseInterstitial.mBundle.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.f67249q ? 1 : 0);
                    setIsShowing(true);
                    baseInterstitial.show(activity, str, a(str));
                } else {
                    AdLogUtil.Log().w("TInterstitialAd", "no ad or ad is expired ");
                    t();
                }
            } else {
                AdLogUtil.Log().w("TInterstitialAd", "show error,interstitial handler is null");
                t();
            }
        } catch (Exception unused) {
            AdLogUtil.Log().e("TInterstitialAd", "show exception");
            t();
        }
    }
}
