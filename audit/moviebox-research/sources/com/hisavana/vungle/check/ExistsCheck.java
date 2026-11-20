package com.hisavana.vungle.check;

import android.content.Context;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.base.BaseQueryPrice;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.AdSourceConfig;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBaseAdSummary;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.vungle.excuter.VungleBanner;
import com.hisavana.vungle.excuter.VungleInterstitial;
import com.hisavana.vungle.excuter.VungleVideo;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExistsCheck implements IBaseAdSummary {
    public static final String VUNGLE_TAG = "vungle_log";
    public static boolean isDebug;

    public static void initAdSource(String str, l lVar) {
        AdLogUtil.Log().d(VUNGLE_TAG, "initAdSource");
        try {
            Vungle.init(str, f.a(), lVar);
        } catch (Exception e11) {
            AdLogUtil.Log().e(ComConstants.SDK_INIT, "ExistsCheck --> Vungle--> initialize exception");
            lVar.onError(new VungleException(1, e11.getMessage()));
        }
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseBanner getBanner(Context context, Network network, int i11, int i12) {
        return new VungleBanner(context, network, i11);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseInterstitial getInterstitial(Context context, Network network) {
        return new VungleInterstitial(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNative getNative(Context context, Network network, int i11) {
        return null;
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNativeViewHolder getNativeViewHolder() {
        return null;
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseQueryPrice getQueryPrice() {
        return null;
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseSplash getSplash(Context context, Network network) {
        return null;
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseVideo getVideo(Context context, Network network) {
        return new VungleVideo(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public void init(Context context, AdSourceConfig adSourceConfig) {
        if (context == null || adSourceConfig == null) {
            AdLogUtil.Log().d(VUNGLE_TAG, "Vungle initialize exception");
        } else {
            isDebug = adSourceConfig.isDebug;
        }
    }
}
