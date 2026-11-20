package com.hisavana.mediation.ad;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.google.android.gms.common.api.Api;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.base.WrapTadView;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.manager.RequestingAdManager;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import hn.a;
import hn.c;
import hn.i;
import in.b;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TBannerAd extends b<BaseBanner> {
    public WrapTadView C;
    public boolean E;
    public boolean F;
    public String G;
    public int A = -1;
    public int B = 0;
    public int D = 0;

    public TBannerAd(Context context, WrapTadView wrapTadView) {
        this.f67234b = context;
        b();
        this.C = wrapTadView;
    }

    @Override // in.b
    public c a(CloudControlConfig.CodeSeat codeSeat) {
        i iVarD = d();
        iVarD.o(this.A);
        iVarD.r(this.D);
        iVarD.l(this.B);
        iVarD.p(this.E);
        iVarD.f(this.F);
        return new a(codeSeat, iVarD, this.f67240h);
    }

    @Override // in.b
    public boolean a(int i11) {
        return i11 == 2;
    }

    public void c(int i11) {
        this.A = i11;
    }

    @Override // in.b
    public boolean c() {
        return true;
    }

    @Override // in.b
    public void clearCurrentAd() {
        if (this.f67248p) {
            return;
        }
        super.clearCurrentAd();
    }

    public void d(int i11) {
        this.B = i11;
    }

    @Override // in.b
    public void destroy() {
        super.destroy();
        WrapTadView wrapTadView = this.C;
        if (wrapTadView != null) {
            wrapTadView.removeAllViews();
            ViewParent parent = this.C.getParent();
            if (parent instanceof ViewGroup) {
                try {
                    ((ViewGroup) parent).removeView(this.C);
                } catch (Exception e11) {
                    AdLogUtil.Log().e("TBannerAd", "Failed to remove banner view: " + e11.getMessage());
                }
            }
        }
        this.C = null;
        u();
    }

    @Override // in.b
    public String enterScene(String str, int i11) {
        Preconditions.a();
        String strEnterScene = super.enterScene(str, i11);
        this.G = strEnterScene;
        return strEnterScene;
    }

    @Override // in.b
    public void q() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("must call show in main thread");
        }
        if (this.C == null) {
            AdLogUtil.Log().d(ComConstants.AD_FLOW, "TBannerAd --> mBannerView is null");
            return;
        }
        n();
        if (this.f67248p) {
            setIsShowing(false);
            clearCurrentAd();
        }
        this.C.removeAllViews();
        c cVarG = g();
        if (cVarG != null) {
            try {
                cVarG.n(this.f67240h);
                BaseBanner baseBanner = (BaseBanner) cVarG.c(this.f67249q);
                if (baseBanner != null) {
                    baseBanner.mBundle.putInt(TrackingKey.FILLING_SOURCE, this.mFillSource);
                    baseBanner.mBundle.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.f67249q ? 1 : 0);
                    setIsShowing(true);
                    WrapTadView wrapTadView = this.C;
                    String str = this.G;
                    baseBanner.show(wrapTadView, str, a(str));
                } else {
                    t();
                    AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBannerAd --> no ad or ad is expired");
                }
                u();
            } catch (Throwable th2) {
                AdLogUtil.Log().e(ComConstants.AD_FLOW, "TBannerAd --> exception:" + Log.getStackTraceString(th2));
                t();
            }
        }
    }

    public void setAdUnitId(String str) {
        this.f67233a = str;
    }

    public void setBannerType(int i11) {
        this.D = i11;
    }

    public void setCloseDirectlyWithoutJumping(boolean z11) {
        this.F = z11;
    }

    public void setHideAdCloseView(boolean z11) {
        this.E = z11;
    }

    public final void u() {
        ArrayList<ICacheAd> caches;
        AdLogUtil.Log().d("TBannerAd", "destroyFoldAd ");
        AdCache cache = AdCacheManager.getCache(e());
        if (cache != null && (caches = cache.getCaches(this.f67233a, Api.BaseClientBuilder.API_PRIORITY_OTHER, false, this.f67249q)) != null && !caches.isEmpty()) {
            for (ICacheAd iCacheAd : caches) {
                if ((iCacheAd instanceof BaseBanner) && ((BaseBanner) iCacheAd).destroyFoldAd()) {
                    cache.removeCache(this.f67233a, iCacheAd);
                    AdLogUtil.Log().d("TBannerAd", "destroyFoldAd removeCache " + iCacheAd);
                }
            }
        }
        RequestingAdManager.getInstance().destroyFoldAd(this.f67233a);
    }
}
