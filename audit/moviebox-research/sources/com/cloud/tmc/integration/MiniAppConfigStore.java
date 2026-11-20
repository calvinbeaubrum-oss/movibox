package com.cloud.tmc.integration;

import android.content.Context;
import com.cloud.config.AbsConfigStore;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class MiniAppConfigStore extends AbsConfigStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f30379c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppConfigStore(final Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f30379c = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<String>() { // from class: com.cloud.tmc.integration.MiniAppConfigStore$CONFIG_QUERY_KEY$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return ((IConfigStrategyProxy) tc.a.a(IConfigStrategyProxy.class)).getConfigKey(context);
            }
        });
        t(MiniAppConfigHelper.j());
    }

    @Override // com.cloud.config.AbsConfigStore
    public List<String> i() {
        List<String> listV = v();
        listV.add(MiniAppConfigHelper.f30370a.i());
        return listV;
    }

    @Override // com.cloud.config.AbsConfigStore
    public String j() {
        return u();
    }

    @Override // com.cloud.config.AbsConfigStore
    public boolean s() {
        return AppDynamicBuildConfig.h();
    }

    public final String u() {
        return (String) this.f30379c.getValue();
    }

    public final List<String> v() {
        return g.q("miniZeroNewsRequestNum", "enableOpenBrowserConfig", "hybridUrlBlackList", "preManagerConfigUrl", "miniWidgetForbidLoadStatus", "closeMiniAppSDK", "whiteScreen", PermissionConstant.jsapiPermission, "appinfoRefreshInterval", "fwRefreshInterval", "updateConfigByLaunch", "packageSize", "updateCompareVersion", "layerHardware", "shortShareUrl", "minicardTargetAppUrl", "minicardEnable", "minicardLimitNum", "mutipleTask", "shellSchemeFilter", "byteBridge", "fps", "miniappStorageWhiteList", "miniappStorageEnable", "enableAnimMemorySize", "logEReport", "scopeConfig", "scopeRequestDiff", "miniStorageWhiteMaxSize", "miniStorageDefaultMaxSize", "miniStorageAllMaxSize", "miniLoadProgressConfig", "miniLogoAnimateConfig", "networkImproveNumV2", "enableAdsense", "scanCode", "appInfoCDNConfig", "miniFeedbackId", "miniAddHomeBubbleForbidId", "miniPopwindowintervalTime", "miniShowAddHomeBubbleDelay", "miniCameraEnable", "miniPopWindowTime", "privacyAgreementDialogWhiteListV4", "miniPermissionIgnoreId", "requestConfig", "webviewCacheStrategy", "miniEnableForceUpdateModelList", "miniAddHomeTime", "miniAddHomeNum", "resourceResponseEncoding", "athenaReportPaths", "miniBackInterceptorTime", "miniBackInterceptorShowTime", "miniBackInterceptorNum", "miniBackInterceptorEnable", "miniShowMsgBubbleDelay", "miniMsgBubbleEnable", "miniPopwindowMsgBubbleForbidId", "msgRefreshInterval", "msgTotalEnable", "msgBubbleEnable", "msgBottomItemEnable", "miniOfflineDownloadDisableAntiShake", "miniAddHomeCustomWhitelist", "miniSharpNewsInterval", "enableSharpNewsPreRequest", "enableSharpNewsPreFullSearch", "enableSharpNewsPreZero", "enableSharpNewsVideo", "innerWarmup", "innerWarmupSetting", "innerWebviewWarmupV3", "miniStartRecordForbidId", "enablePreUnZipV3", "preUnZipIdList", "enablePreUnZipRetry", "miniEnableQuickModeLaunch", "enableBackgroundUnzipV3", "enableCheckDownloadZip", "enableWebViewMask", "miniShowAddHomeBubbleInterval", "miniShowMsgBubbleInterval", "miniEnableNewMiniappInit", "enableZeroNewsPreRequest", "maxSharpNewsZeroScreenPreRequest", "maxSharpNewsZeroTopicPreRequest", "enableSharpNewsPreZeroNews", "enableZeroNewsTopicPreRequest", "enableZeroScreenNewsSync", "enableZeroScreenTopicSync", "zeroNewsPreSize", "zeroTopicPreSize", "miniEnableClearPreStorage", "miniClearPreDiff", "miniTopicRequestNum", "miniFullSearchRequestNum", "enableShellDestory", "enableSystemDestory", "appInfoConfig", "enableH5DomMonitor", "enableShellDomMonitor", "enableCheckAddHomeButtom", "enableCheckAsyncInit", "warmUpEntranceConfig", "getGaid", "miniPreHtmlRequestNum", "maxminiPreRequest", "enableShellPreRequest", "enablePreConfig", "enablePreHtmlPreConfig", "enableOfflinePackageConfig", "enableAppinfoPreConfig", "forceUpdatePreConfig", "updatePreConfigInterval", "enablePreInitV2", "jumpStoreDeeplink", "preHtmlExpiredTime", "enablePreManagerCongig", "enableMoveToBack", "enableFixMiniHotOpen", "enableFixHotStartUrl", "corsList", "enableAppinfoCdn", "enableOpenBrowserConfig", "enableMiniWidget", "corsList", "athenaInitDelay", "athenaCacheSize", "nativeWebviewDownloadConfig", "miniAppFilePathValid", "maxNativeWebviewNum", "miniGoHomeAllowId", "miniShellJumpUrlWhiteList", "clearOfflineDownloadCache", "enableAsyncAddHomeReceiver", "hideLoadingNativeTime", "hideLoadingH5Time", "injectJSConfigV3", "enablePreHybridPreConfig", "showAddHomeCustomDialog", "enableAddHomeUseAssets", "hideLoadingNativeTime", "hideLoadingH5Time", "downgradeScanFile", "enableCheckShareButtom", "addHomeTipsRequestInterval", "enableAddHomeTopTip", "enableAddHomeBottomTip", "enableAddHomeBackDialogTip", "offScreenRender", "keyGamePerformanceMonitorStr", "fixEncodeUrl", "keyGamePerformanceMonitorStrUseLocal", "enablePreStrategyTrackPoint", "enablePreZeroScreenUpdate", "enableUseOxygenBus", "clearStartTimeDataInterval", "collectUsageDataDurationCondition", "forceAthenaReportMode", "postInitAdsense", "mfahList", "enableForceAddHome", "enableUpdateAddHome", "miniAppServerId", "cameraSlowAutoFocusDeviceWhiteList", "enableMiniSubPackage", "prefetchConfigUrl", "prefetchV2Enable", "prefetchFreshTime", "eofflineafq", "forceFinishMiniApp", "ccrInterval", "cdnrInterval", "cdnConfigsuccess", "fpnav", "addHomeSwitch", "offlineAppsSwitch", "offlineAppsAbilitySwitch", "offlineAppsList", "offlineAppsScanLevel", "oflHostInterval", "oflInterval", "uofhs", "uofms", "merqm", "muscl", "enableDevUserAgreement", "enableduaWhitlist", "miniPsStorageSizeMin", "miniPsStoragews", "miniStartToPs", "miniStartSyncOnlyPsLink", "enableAppinfoDownload", "showAddHomeCustomLowVersion", "miniesti", "privacyAutoBlackCountry", "privacyAutoWhiteCountry", "autoAgreePrivacy");
    }
}
