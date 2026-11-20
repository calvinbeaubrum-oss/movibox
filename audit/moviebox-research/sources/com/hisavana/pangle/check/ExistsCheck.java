package com.hisavana.pangle.check;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
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
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBaseAdSummary;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.pangle.executer.PangleBanner;
import com.hisavana.pangle.executer.PangleInterstitial;
import com.hisavana.pangle.executer.PangleNative;
import com.hisavana.pangle.executer.PangleSplash;
import com.hisavana.pangle.executer.PangleVideo;
import com.hisavana.pangle.holder.NativeAdViewHolder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ExistsCheck implements IBaseAdSummary {
    public static final String PANGLE_TAG = "pangle_log";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f42018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f42019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f42020c;

    public static PAGConfig a(String str) {
        return new PAGConfig.Builder().appId(str).debugLog(f42019b).appIcon(f42018a).supportMultiProcess(true).build();
    }

    public static void initAdSource(String str, PAGSdk.PAGInitCallback pAGInitCallback) {
        AdLogUtil.Log().d(PANGLE_TAG, "initAdSource");
        if (f42020c) {
            pAGInitCallback.success();
            return;
        }
        try {
            PAGSdk.init(f.a(), a(str), pAGInitCallback);
        } catch (Exception e11) {
            AdLogUtil.Log().e(ComConstants.SDK_INIT, "ExistsCheck --> Pangle--> initialize exception");
            pAGInitCallback.fail(TAdErrorCode.CODE_AD_SOURCE_INIT_FAILED, e11.getMessage());
        }
    }

    public static void setInitState(boolean z11) {
        f42020c = z11;
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseBanner getBanner(Context context, Network network, int i11, int i12) {
        return new PangleBanner(context, network, i11);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseInterstitial getInterstitial(Context context, Network network) {
        return new PangleInterstitial(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseNative getNative(Context context, Network network, int i11) {
        return new PangleNative(context, network, i11);
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
        return new PangleSplash(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public BaseVideo getVideo(Context context, Network network) {
        return new PangleVideo(context, network);
    }

    @Override // com.hisavana.common.interfacz.IBaseAdSummary
    public void init(Context context, AdSourceConfig adSourceConfig) {
        if (context == null || adSourceConfig == null) {
            AdLogUtil.Log().d(PANGLE_TAG, "Pangle initialize exception");
        } else {
            f42019b = adSourceConfig.isDebug;
            f42018a = adSourceConfig.appIconId;
        }
    }
}
