package com.cloud.tmc.miniapp;

import android.content.Context;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import hd.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ConfigImpl implements IConfigStrategyProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f31295a = "ConfigImpl";

    @Override // com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy
    public boolean checkAddHomeHost(Context context, String str) {
        return Intrinsics.b(str, context != null ? context.getPackageName() : null);
    }

    @Override // com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy
    public String getAbilitiesCdnUrl() {
        return AppDynamicBuildConfig.p() + "SDK/AbilityConfig.json";
    }

    @Override // com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy
    public String getConfigKey(Context context) {
        Intrinsics.g(context, "context");
        String str = "config_" + AppUtils.f31011a.i(context);
        k.a("getConfigKey: ", str, this.f31295a);
        return str;
    }

    @Override // com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy
    public String getMiniAppVersion(String version) {
        Intrinsics.g(version, "version");
        return version;
    }

    @Override // com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy
    public String getMyByteAppRecommendListCdnUrl() {
        return AppDynamicBuildConfig.p() + "SDK/myByteAppRecommendListV2.json";
    }

    @Override // com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy
    public String getOfflineConfigDefaultValue() {
        return "{\"enable\":false,\"initLoad\":false,\"networkLoad\":false,\"ahaSoFormatConvert\":false,\"checkVersion\":false,\"enablePrefetchCdnAppInfo\":false,\"forceRefreshPrefetchCdnAppInfo\":false}";
    }

    @Override // com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy
    public String getOfflineConfigKey() {
        return "offlineDownload_OnlineV2";
    }

    @Override // com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy
    public String getPreStrategyCdnUrl() {
        return MiniAppLaunch.f31784a.L(AppDynamicBuildConfig.p() + "SDK/preStrategyConfig.json");
    }

    @Override // com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy
    public String getPreStrategyConfigFilePath() {
        return "preStrategyConfig.json";
    }

    public final String getTAG() {
        return this.f31295a;
    }
}
