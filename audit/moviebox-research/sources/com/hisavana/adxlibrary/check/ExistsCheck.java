package com.hisavana.adxlibrary.check;

import android.content.Context;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.hisavana.adxlibrary.excuter.AdxBanner;
import com.hisavana.adxlibrary.excuter.AdxInterstitia;
import com.hisavana.adxlibrary.excuter.AdxNative;
import com.hisavana.adxlibrary.excuter.AdxRewarded;
import com.hisavana.adxlibrary.excuter.AdxSplash;
import com.hisavana.adxlibrary.holder.NativeAdViewHolder;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.base.BaseQueryPrice;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.AdMuteStatus;
import com.hisavana.common.bean.AdSourceConfig;
import com.hisavana.common.bean.Network;
import com.hisavana.common.interfacz.IBaseAdSummary;
import en.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ExistsCheck implements IBaseAdSummary {
    public void check() {
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseBanner getBanner(Context context, Network network, int i11, int i12) {
        return a.a(context, network, new AdxBanner(context, network, i11));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseInterstitial getInterstitial(Context context, Network network) {
        return a.b(context, network, new AdxInterstitia(context, network));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNative getNative(Context context, Network network, int i11) {
        return a.c(context, network, i11, new AdxNative(context, network, i11));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNativeViewHolder getNativeViewHolder() {
        return new NativeAdViewHolder();
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseQueryPrice getQueryPrice() {
        return null;
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseSplash getSplash(Context context, Network network) {
        return new AdxSplash(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseVideo getVideo(Context context, Network network) {
        return new AdxRewarded(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public void init(Context context, AdSourceConfig adSourceConfig) {
        AdManager.c cVar = new AdManager.c();
        cVar.i(adSourceConfig.isDebug).n(adSourceConfig.testDevice).m(adSourceConfig.vidAppId).h(adSourceConfig.appId).l(adSourceConfig.shouldOptimizeImageLoading);
        long j11 = adSourceConfig.defaultVersion;
        if (j11 > 0) {
            cVar.k(j11);
        }
        int i11 = adSourceConfig.defaultMaterialMaxSize;
        if (i11 > 0) {
            cVar.j(i11);
        }
        AdManager.g(context, cVar.c());
        AdManager.k(AdMuteStatus.MUTE_ALL);
    }
}
