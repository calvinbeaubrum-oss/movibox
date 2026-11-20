package com.hisavana.fblibrary.excuter.check;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cloud.sdk.commonutil.util.i;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BidderTokenProvider;
import com.facebook.biddingkit.bridge.BiddingKit;
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
import com.hisavana.fblibrary.excuter.FanBanner;
import com.hisavana.fblibrary.excuter.FanInterstitial;
import com.hisavana.fblibrary.excuter.FanNative;
import com.hisavana.fblibrary.excuter.FanVideo;
import com.hisavana.fblibrary.excuter.bidding.FanBidding;
import com.hisavana.fblibrary.excuter.holder.NativeAdViewHolder;
import com.hisavana.fblibrary.excuter.util.PltatformUtil;
import gn.a;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ExistsCheck implements IBaseAdSummary {
    public static void initFan(Context context, AudienceNetworkAds.InitListener initListener) {
        if (context == null) {
            return;
        }
        AudienceNetworkAds.buildInitSettings(context).withInitListener(initListener).initialize();
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseBanner getBanner(Context context, Network network, int i11, int i12) {
        return a.d(context, network, new FanBanner(context, network, i11));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseInterstitial getInterstitial(Context context, Network network) {
        return a.e(context, network, new FanInterstitial(context, network));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNative getNative(Context context, Network network, int i11) {
        return a.a(context, network, i11, new FanNative(context, network, i11));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNativeViewHolder getNativeViewHolder() {
        return new NativeAdViewHolder();
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseQueryPrice getQueryPrice() {
        return a.b(new FanBidding());
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseSplash getSplash(Context context, Network network) {
        return null;
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseVideo getVideo(Context context, Network network) {
        return a.c(context, network, new FanVideo(context, network));
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public void init(@NonNull final Context context, final AdSourceConfig adSourceConfig) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("timeout_ms", 2000);
            jSONObject.put("auction", jSONObject2);
            BiddingKit.c(context.getApplicationContext(), jSONObject.toString());
            BiddingKit.d(adSourceConfig.isDebug);
        } catch (Exception e11) {
            e11.printStackTrace();
            AdLogUtil.Log().e(ComConstants.SDK_INIT, Log.getStackTraceString(e11));
        }
        i.f30292a.e(new Runnable() { // from class: com.hisavana.fblibrary.excuter.check.ExistsCheck.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ComConstants.fbBidToken = BidderTokenProvider.getBidderToken(context);
                    AdLogUtil.Log().d("FanExistsCheck", "ExistsCheck -fb-> get fbtoken success!!!");
                    AdSourceConfig adSourceConfig2 = adSourceConfig;
                    if (adSourceConfig2 == null || !adSourceConfig2.testDevice) {
                        return;
                    }
                    AdSettings.setTestMode(true);
                } catch (Exception e12) {
                    AdLogUtil.Log().e(ComConstants.SDK_INIT, Log.getStackTraceString(e12));
                }
            }
        });
        if (adSourceConfig.testDevice) {
            PltatformUtil.addTestDevice(context);
        }
        PltatformUtil.handler = AdSourceConfig.handler;
    }
}
