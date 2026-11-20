package com.hisavana.mediation.ad;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.OnSkipListener;
import com.hisavana.common.interfacz.TAdListener;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.MediaLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import hn.c;
import hn.h;
import hn.i;
import hn.r;
import hn.s;
import in.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TSplashAd extends b<BaseSplash> {

    @ComConstants.SplashModeIntDef
    public int A;
    public int B;

    public TSplashAd(Context context, String str) {
        super(context);
        this.A = 1;
        this.B = 1;
        this.f67233a = str;
    }

    public static boolean hasCache(String str) {
        AdCache cache = AdCacheManager.getCache(4);
        int adNum = cache != null ? cache.getAdNum(str) : 0;
        AdLogUtil.Log().d("TSplashAd", "placementId " + str + ",adNum = " + adNum);
        MediaLogUtil.d("TSplashAd", "placementId " + str + ",adNum = " + adNum);
        return adNum > 0;
    }

    @Override // in.b
    public c a(CloudControlConfig.CodeSeat codeSeat) {
        i iVarD = d();
        iVarD.x(this.B);
        iVarD.z(this.A);
        return new r(codeSeat, iVarD, this.f67240h);
    }

    @Override // in.b
    public boolean a(int i11) {
        return i11 == 4;
    }

    @Override // in.b
    public boolean c() {
        return false;
    }

    @Override // in.b
    public void clearCurrentAd() {
        super.clearCurrentAd();
    }

    @Override // in.b
    public void destroy() {
        super.destroy();
    }

    @Override // in.b
    public void pause() {
        super.pause();
    }

    @Override // in.b
    public void resume() {
        super.resume();
    }

    public void setAdUnitId(String str) {
        this.f67233a = str;
    }

    public void setOnShowListener(TAdListener tAdListener) {
        s sVar = this.f67240h;
        if (sVar != null) {
            sVar.h(tAdListener);
        }
    }

    public void setOnSkipListener(OnSkipListener onSkipListener) {
        s sVar = this.f67240h;
        if (sVar != null) {
            sVar.g(onSkipListener);
        }
    }

    public void setOrientation(int i11) {
        if (i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("place use SplashAdOrientation.APP_SPLASH_AD_ORIENTATION_PORTRAIT or SplashAdOrientation.APP_SPLASH_AD_ORIENTATION_LANDSCAPE");
        }
        this.B = i11;
        AdLogUtil.Log().d("TSplashAd", "current orientation is " + i11);
    }

    public void setSplashMode(@ComConstants.SplashModeIntDef int i11) {
        this.A = i11;
    }

    public void showAd(@NonNull TSplashView tSplashView) {
        showAd(tSplashView, null, "");
    }

    public void showAd(@NonNull TSplashView tSplashView, View view) {
        showAd(tSplashView, view, "");
    }

    public void showAd(@NonNull TSplashView tSplashView, View view, String str) {
        n();
        AdLogUtil.Log().d("TSplashAd", "showAd sceneToken " + str);
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
            AdLogUtil.Log().d("TSplashAd", "showAd errorCode " + tAdErrorCodeB);
            return;
        }
        c cVarG = g();
        if (cVarG == null) {
            AdLogUtil.Log().w("TSplashAd", "show error,splash handler is null");
            t();
            return;
        }
        Object objC = cVarG.c(this.f67249q);
        if (!(objC instanceof BaseSplash)) {
            AdLogUtil.Log().w("TSplashAd", "no ad or ad is expired ");
            t();
            return;
        }
        BaseSplash baseSplash = (BaseSplash) objC;
        baseSplash.mBundle.putInt(TrackingKey.FILLING_SOURCE, this.mFillSource);
        baseSplash.mBundle.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.f67249q ? 1 : 0);
        baseSplash.addLogoLayout(view);
        setIsShowing(true);
        baseSplash.show(tSplashView, str, a(str));
    }

    public void showAd(@NonNull TSplashView tSplashView, String str) {
        showAd(tSplashView, null, str);
    }
}
