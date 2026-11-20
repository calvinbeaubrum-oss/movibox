package com.hisavana.max.check;

import android.content.Context;
import androidx.annotation.NonNull;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.cloud.sdk.commonutil.util.DeviceUtil;
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
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.max.executer.MaxBanner;
import com.hisavana.max.executer.MaxInterstitial;
import com.hisavana.max.executer.MaxNative;
import com.hisavana.max.executer.MaxSplash;
import com.hisavana.max.executer.MaxVideo;
import com.hisavana.max.holder.NativeAdViewHolder;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class ExistsCheck implements IBaseAdSummary {
    public static final String MAX_TAG = "max_log";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f41820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AppLovinSdk f41821b;
    public static boolean isDebug;

    public static AppLovinSdk getAppLovinSdk(Context context, String str) {
        AppLovinSdk appLovinSdk = f41821b;
        if (appLovinSdk != null) {
            return appLovinSdk;
        }
        if (context == null) {
            return null;
        }
        AppLovinSdkSettings appLovinSdkSettings = new AppLovinSdkSettings(context);
        appLovinSdkSettings.setExtraParameter("user_agent_collection_enabled", "false");
        if (f41820a) {
            appLovinSdkSettings.setTestDeviceAdvertisingIds(Collections.singletonList(DeviceUtil.e()));
        }
        appLovinSdkSettings.setVerboseLogging(isDebug);
        appLovinSdkSettings.setMuted(AdMuteStatus.MUTE_ALL);
        AppLovinSdk appLovinSdk2 = AppLovinSdk.getInstance(str, appLovinSdkSettings, context);
        f41821b = appLovinSdk2;
        appLovinSdk2.setMediationProvider(AppLovinMediationProvider.MAX);
        return f41821b;
    }

    public static void initAdSource(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        AppLovinSdk appLovinSdk = f41821b;
        if (appLovinSdk != null) {
            appLovinSdk.initializeSdk(sdkInitializationListener);
        }
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseBanner getBanner(Context context, Network network, int i11, int i12) {
        return new MaxBanner(context, network, i11);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseInterstitial getInterstitial(Context context, Network network) {
        return new MaxInterstitial(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNative getNative(Context context, Network network, int i11) {
        return new MaxNative(context, network, i11);
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
        return new MaxSplash(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseVideo getVideo(Context context, Network network) {
        return new MaxVideo(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public void init(@NonNull Context context, AdSourceConfig adSourceConfig) {
        if (context == null || adSourceConfig == null) {
            AdLogUtil.Log().d(MAX_TAG, "Max initialize exception");
        } else {
            isDebug = adSourceConfig.isDebug;
            f41820a = adSourceConfig.testDevice;
        }
    }
}
