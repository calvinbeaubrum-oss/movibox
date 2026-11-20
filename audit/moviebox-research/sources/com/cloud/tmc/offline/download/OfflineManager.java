package com.cloud.tmc.offline.download;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.PreloadResource;
import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppStoreInfo;
import com.cloud.tmc.integration.utils.LatestUseUtils;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.OfflineDownloadAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.l;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.offline.download.intf.IOfflineDownloadConfig;
import com.cloud.tmc.offline.download.model.ClearOfflineDownloadCacheData;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflineDownloadBuilder;
import com.cloud.tmc.offline.download.model.OfflinePkgCachePath;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.cloud.tmc.offline.download.model.ZipFileInfo;
import com.cloud.tmc.offline.download.resource.IOfflineResourceManagerProxy;
import com.cloud.tmc.offline.download.resource.OfflineResourceManagerProxyImpl;
import com.cloud.tmc.offline.download.resource.processor.IOfflineResourceProcessorProxy;
import com.cloud.tmc.offline.download.resource.processor.OfflineResourceProcessorProxyImpl;
import com.cloud.tmc.offline.download.task.LoadOfflineConfigTask;
import com.cloud.tmc.offline.download.task.PrePullAppInfoCheckTask;
import com.cloud.tmc.offline.download.task.PrePullAppInfoDownloadTask;
import com.cloud.tmc.offline.download.task.PrePullAppInfoParseTask;
import com.cloud.tmc.offline.download.utils.OfflineStoreCache;
import com.cloud.tmc.offline.download.utils.OfflineUtils;
import com.cloud.tmc.offline.download.utils.f;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.transsion.gslb.Worker;
import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xb.e;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class OfflineManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f32004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Application f32005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static vd.b f32006d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfflineManager f32003a = new OfflineManager();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f32007e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f32008f = LazyKt__LazyJVMKt.b(new Function0<com.cloud.tmc.offline.download.task.queue.b>() { // from class: com.cloud.tmc.offline.download.OfflineManager$mTaskQueue$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.cloud.tmc.offline.download.task.queue.b invoke() {
            return new com.cloud.tmc.offline.download.task.queue.b(false, 1, null);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements NetworkUtil.d {
        @Override // com.cloud.tmc.kernel.utils.NetworkUtil.d
        public void a(NetworkUtil.Network network, NetworkUtil.Network network2) {
            try {
                String strK = NetworkUtil.k(network2);
                if (Intrinsics.b(strK, DevicePublicKeyStringDef.NONE) || Intrinsics.b(strK, "UNKNOWN") || !OfflineManager.D()) {
                    return;
                }
                OfflineManager.f0(OfflineManager.f32003a, "condition_change_network", null, false, null, 14, null);
            } catch (Throwable th2) {
                TmcLogger.g("TmcOfflineDownload: OfflineManager", "network failed!", th2);
            }
        }
    }

    @JvmStatic
    public static final Context A() {
        Application application = f32005c;
        if (application != null) {
            return application.getApplicationContext();
        }
        return null;
    }

    public static final boolean B() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        boolean z11 = false;
        if (jsonObjectZ != null && (jsonElement = jsonObjectZ.get("initLoad")) != null && jsonElement.getAsBoolean()) {
            z11 = true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("init load config is ");
        sb2.append(z11 ? "enabled" : "disabled");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", sb2.toString());
        return z11;
    }

    public static final boolean D() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        boolean z11 = false;
        if (jsonObjectZ != null && (jsonElement = jsonObjectZ.get("networkLoad")) != null && jsonElement.getAsBoolean()) {
            z11 = true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("network load config is ");
        sb2.append(z11 ? "enabled" : "disabled");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", sb2.toString());
        return z11;
    }

    public static final long E() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        long asLong = (jsonObjectZ == null || (jsonElement = jsonObjectZ.get("offlineManifestTimeInterval")) == null) ? 3600000L : jsonElement.getAsLong();
        TmcLogger.c("TmcOfflineDownload: OfflineManager", "offline manifest time interval is " + asLong);
        return asLong;
    }

    public static final long F() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        long asLong = (jsonObjectZ == null || (jsonElement = jsonObjectZ.get("offlineMaxUpdateTimeInterval")) == null) ? ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED : jsonElement.getAsLong();
        TmcLogger.c("TmcOfflineDownload: OfflineManager", "offline max update time interval is " + asLong);
        return asLong;
    }

    @JvmStatic
    public static final List<ZipFileInfo> G(String str) {
        try {
            return OfflineUtils.B(OfflineUtils.f32081a, str, null, 2, null);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "getOfflinePackageDownloadInfo", th2);
            return null;
        }
    }

    @JvmStatic
    public static final OfflinePkgCachePath H(String group, String url) {
        Intrinsics.g(group, "group");
        Intrinsics.g(url, "url");
        try {
            if (!f32004b) {
                return null;
            }
            OffPkgConfig offPkgConfig = new OffPkgConfig(null, null, group, null, null, null, null, url, 0, null, null, null, null, null, null, null, null, null, 261755, null);
            OfflineZipDownloadInfo offlineZipDownloadInfoH = OfflineStoreCache.f32077a.h(offPkgConfig, e.a(offPkgConfig.getPkgUrl(), ""));
            boolean z11 = offlineZipDownloadInfoH.getStatus() == 4;
            OfflineUtils offlineUtils = OfflineUtils.f32081a;
            Bundle bundleQ = OfflineUtils.Q(offlineUtils, offPkgConfig, "api", null, null, null, 24, null);
            bundleQ.putString("offline_pkg_search_resources_type", "dir");
            bundleQ.putString("offline_pkg_appId", group);
            Unit unit = Unit.f68710a;
            offlineUtils.R(z11, bundleQ);
            if (z11) {
                ZipFileInfo zipFileInfo = new ZipFileInfo(null, null, null, 7, null);
                String zipUnCompressPath = offlineZipDownloadInfoH.getZipUnCompressPath();
                if (zipUnCompressPath != null) {
                    zipFileInfo.setZipUnCompressPath(zipUnCompressPath);
                }
                String url2 = offlineZipDownloadInfoH.getUrl();
                if (url2 != null) {
                    zipFileInfo.setUrl(url2);
                }
                OffPkgConfig manifest = offlineZipDownloadInfoH.getManifest();
                if (manifest != null) {
                    zipFileInfo.setManifest(manifest);
                }
                return new OfflinePkgCachePath(offPkgConfig.getGroup(), offPkgConfig.getVersion(), g.q(zipFileInfo));
            }
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "Unable to download package", th2);
        }
        return null;
    }

    public static final long I() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        long asLong = (jsonObjectZ == null || (jsonElement = jsonObjectZ.get("offlinePkgConfigTimeInterval")) == null) ? 3600000L : jsonElement.getAsLong();
        TmcLogger.c("TmcOfflineDownload: OfflineManager", "offline pkg config time interval is " + asLong);
        return asLong;
    }

    @JvmStatic
    public static final OfflinePkgCachePath J(String appId) {
        Intrinsics.g(appId, "appId");
        try {
            if (!f32004b || U()) {
                return null;
            }
            OfflineUtils offlineUtils = OfflineUtils.f32081a;
            if (!offlineUtils.g(appId)) {
                TmcLogger.c("TmcOfflineDownload: OfflineManager", "getOfflinePkgFwCachePath: check offline package version is not available, appId: " + appId);
                return null;
            }
            if (OfflineUtils.f(offlineUtils, appId, null, 2, null)) {
                OfflinePkgCachePath offlinePkgCachePathG = OfflineUtils.G(offlineUtils, appId, null, 2, null);
                f.f32092a.b(appId, offlinePkgCachePathG != null);
                return offlinePkgCachePathG;
            }
            TmcLogger.k("TmcOfflineDownload: OfflineManager", "getOfflinePkgFwCachePath: 离线包当前尚未下载，稍后再请求，appId: " + appId);
            return null;
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "Unable to load offline", th2);
            return null;
        }
    }

    @JvmStatic
    public static final File K(String str, String str2) {
        try {
            if (!f32004b || V()) {
                return null;
            }
            OfflineUtils offlineUtils = OfflineUtils.f32081a;
            if (!OfflineUtils.i(offlineUtils, str, str2, null, 4, null)) {
                TmcLogger.c("TmcOfflineDownload: OfflineManager", "appId: " + str + " url: " + str2 + " is not valid");
                return null;
            }
            if (!offlineUtils.g(str)) {
                TmcLogger.c("TmcOfflineDownload: OfflineManager", "getOfflineResources: check offline package version is not available, appId: " + str + ", url: " + str2);
                return null;
            }
            if (OfflineUtils.f(offlineUtils, str, null, 2, null)) {
                Object objA = ((IOfflineResourceProcessorProxy) tc.a.a(IOfflineResourceProcessorProxy.class)).getResultWithInterceptorChain(new be.a.b(str, str2)).a();
                f.f32092a.g(str, objA instanceof File, str2);
                if (objA instanceof File) {
                    return (File) objA;
                }
                return null;
            }
            TmcLogger.k("TmcOfflineDownload: OfflineManager", "getOfflineResources: 离线包当前尚未下载，稍后再请求，appId: " + str + ", url: " + str2);
            return null;
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "getOfflineResources", th2);
        }
    }

    public static final long M() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        long asLong = (jsonObjectZ == null || (jsonElement = jsonObjectZ.get("prefetchCdnAppInfoIntervals")) == null) ? 28800000L : jsonElement.getAsLong();
        TmcLogger.c("TmcOfflineDownload: OfflineManager", "prefetch cdn appInfo time interval is " + asLong);
        return asLong;
    }

    public static final String N() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        String strA = e.a((jsonObjectZ == null || (jsonElement = jsonObjectZ.get("prefetchCdnAppInfoUrl")) == null) ? null : jsonElement.getAsString(), "https://app-oss.byte-app.com/platform/appinfo/releaseInfo/allReleaseAppInfo.zip");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", "prefetch cdn appInfo url is " + strA);
        return strA;
    }

    @JvmStatic
    public static final void O(final Application application) {
        Intrinsics.g(application, "application");
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.cloud.tmc.offline.download.OfflineManager$init$block$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    TmcLogger.c("TmcOfflineDownload: OfflineManager", "init called with initSomeThings on thread: " + Thread.currentThread().getName());
                    OfflineManager.f32003a.R(application);
                } catch (Throwable th2) {
                    TmcLogger.g("TmcOfflineDownload: OfflineManager", "init failed!", th2);
                }
            }
        };
        try {
            boolean zJ = OfflineUtils.f32081a.J();
            TmcLogger.c("TmcOfflineDownload: OfflineManager", "init is main thread: " + zJ);
            if (zJ) {
                com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.offline.download.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        OfflineManager.P(function0);
                    }
                });
            } else {
                function0.invoke();
            }
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", th2.getMessage(), th2);
        }
    }

    public static final void P(Function0 block) {
        Intrinsics.g(block, "$block");
        block.invoke();
    }

    public static final IOfflineResourceProcessorProxy S() {
        return new OfflineResourceProcessorProxyImpl();
    }

    public static final IOfflineResourceManagerProxy T() {
        return new OfflineResourceManagerProxyImpl();
    }

    public static final boolean U() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        boolean z11 = false;
        if (jsonObjectZ != null && (jsonElement = jsonObjectZ.get("offlinePkgFw")) != null && !jsonElement.getAsBoolean()) {
            z11 = true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("offlinePkgFw config is ");
        sb2.append(z11 ? "disable" : "enable");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", sb2.toString());
        return z11;
    }

    public static final boolean V() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        boolean z11 = false;
        if (jsonObjectZ != null && (jsonElement = jsonObjectZ.get("offlineResources")) != null && !jsonElement.getAsBoolean()) {
            z11 = true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("offlineResources config is ");
        sb2.append(z11 ? "disable" : "enable");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", sb2.toString());
        return z11;
    }

    public static final boolean W() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        boolean z11 = false;
        if (jsonObjectZ != null && (jsonElement = jsonObjectZ.get("ahaSoFormatConvert")) != null && jsonElement.getAsBoolean()) {
            z11 = true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ahaSoFormatConvert config is ");
        sb2.append(z11 ? "enabled" : "disabled");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", sb2.toString());
        return z11;
    }

    public static final boolean X() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        boolean z11 = false;
        if (jsonObjectZ != null && (jsonElement = jsonObjectZ.get("enablePrefetchCdnAppInfo")) != null && jsonElement.getAsBoolean()) {
            z11 = true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("prefetch cdn appInfo enable config is ");
        sb2.append(z11 ? "enabled" : "disabled");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", sb2.toString());
        return z11;
    }

    public static final boolean Y() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        boolean z11 = false;
        if (jsonObjectZ != null && (jsonElement = jsonObjectZ.get("enable")) != null && jsonElement.getAsBoolean()) {
            z11 = true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("离线模块总开关是 ");
        sb2.append(z11 ? "enabled" : "disabled");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", sb2.toString());
        return z11;
    }

    public static final boolean a0() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        boolean z11 = false;
        if (jsonObjectZ != null && (jsonElement = jsonObjectZ.get("forceRefreshPrefetchCdnAppInfo")) != null && jsonElement.getAsBoolean()) {
            z11 = true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("force refresh prefetch cdn appInfo enable config is ");
        sb2.append(z11 ? "enabled" : "disabled");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", sb2.toString());
        return z11;
    }

    @JvmStatic
    public static final boolean c0() {
        return f32004b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f0(OfflineManager offlineManager, String str, String str2, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        if ((i11 & 8) != 0) {
            function1 = null;
        }
        offlineManager.e0(str, str2, z11, function1);
    }

    @JvmStatic
    public static final void g0() {
        try {
            OfflineManager offlineManager = f32003a;
            if (offlineManager.d0()) {
                TmcLogger.c("TmcOfflineDownload: OfflineManager", "预拉取 AppInfo 跑的太快了！");
            } else if (X()) {
                offlineManager.x(new PrePullAppInfoCheckTask(new Function2<ce.b, yd.a<?>, Unit>() { // from class: com.cloud.tmc.offline.download.OfflineManager$prePullFeaturedAppInfo$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(ce.b bVar, yd.a<?> aVar) {
                        invoke2(bVar, aVar);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ce.b bVar, yd.a<?> result) {
                        Intrinsics.g(bVar, "<anonymous parameter 0>");
                        Intrinsics.g(result, "result");
                        Object objA = result.a();
                        String str = objA instanceof String ? (String) objA : null;
                        TmcLogger.c("TmcOfflineDownload: OfflineManager", "PrePullAppInfoCheckTask 下一步是 " + str);
                        if (Intrinsics.b(str, "step_download")) {
                            try {
                                OfflineManager.f32003a.n("step_check");
                                return;
                            } catch (Throwable th2) {
                                TmcLogger.g("TmcOfflineDownload: OfflineManager", "执行下载任务发生错误", th2);
                                return;
                            }
                        }
                        if (Intrinsics.b(str, "step_unzip")) {
                            try {
                                OfflineManager.f32003a.o("step_check");
                            } catch (Throwable th3) {
                                TmcLogger.g("TmcOfflineDownload: OfflineManager", "执行解压任务发生错误", th3);
                            }
                        }
                    }
                }));
            } else {
                TmcLogger.c("TmcOfflineDownload: OfflineManager", "预拉取精选 AppInfo 能力已关闭");
            }
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "prePullFeaturedAppInfo failed", th2);
        }
    }

    @JvmStatic
    public static final void j(String str, Lifecycle lifecycle) {
        try {
            com.cloud.tmc.offline.download.utils.c.f32089a.a(str, lifecycle);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "addOfflineLifecycleObserver", th2);
        }
    }

    @JvmStatic
    public static final boolean j0(String str, String str2) {
        try {
            return OfflineUtils.f32081a.V(str, str2);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "Verify server file", th2);
            return false;
        }
    }

    @JvmStatic
    public static final boolean k(String str) {
        try {
            return OfflineUtils.f32081a.b(str);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "checkMiniAppInDisableAntiShakeList", th2);
            return false;
        }
    }

    public static final void m(Context context) {
        Intrinsics.g(context, "$context");
        Object objD = k.d(MiniAppConfigHelper.f30370a.e("clearOfflineDownloadCache", "{\"clear\":false,\"intervalTime\":604800}"), ClearOfflineDownloadCacheData.class);
        Intrinsics.f(objD, "fromJson(\n              …ava\n                    )");
        ClearOfflineDownloadCacheData clearOfflineDownloadCacheData = (ClearOfflineDownloadCacheData) objD;
        long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, "appId_lastClearOfflineDownloadCache", "key_lastClearOfflineDownloadCache");
        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        if (!clearOfflineDownloadCacheData.getClear() || jCurrentTimeMillis - j11 <= clearOfflineDownloadCacheData.getIntervalTime()) {
            return;
        }
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, "appId_lastClearOfflineDownloadCache", "key_lastClearOfflineDownloadCache", jCurrentTimeMillis);
        List<AppStoreInfo> listD = LatestUseUtils.d();
        if (listD != null) {
            for (AppStoreInfo appStoreInfo : listD) {
                TmcLogger.k("TmcOfflineDownload: OfflineUtils", "遍历使用过的小程序，进行清除缓存，group: " + appStoreInfo.getAppId());
                OffPkgConfig offPkgConfigD = OfflineStoreCache.f32077a.d(appStoreInfo.getAppId());
                if (offPkgConfigD != null) {
                    OfflineUtils.f32081a.m(offPkgConfigD);
                }
            }
        }
    }

    @JvmStatic
    public static final void p(OffPkgConfig config, Function1<? super OfflinePkgCachePath, Unit> function1) {
        Intrinsics.g(config, "config");
        r(o.a(config), function1);
    }

    @JvmStatic
    public static final void q(OfflineDownloadBuilder builder, Function1<? super OfflinePkgCachePath, Unit> function1) {
        Intrinsics.g(builder, "builder");
        p(builder.build(), function1);
    }

    @JvmStatic
    public static final void r(String str, final Function1<? super OfflinePkgCachePath, Unit> function1) {
        final OffPkgConfig offPkgConfig;
        try {
            if (!f32004b) {
                if (function1 != null) {
                    function1.invoke(null);
                    return;
                }
                return;
            }
            if (str != null && str.length() != 0) {
                if (!l.e()) {
                    if (function1 != null) {
                        function1.invoke(null);
                        return;
                    }
                    return;
                }
                try {
                    Type type = new TypeToken<OffPkgConfig>() { // from class: com.cloud.tmc.offline.download.OfflineManager$downloadPkg$offPkgConfig$pkgConfig$1
                    }.getType();
                    Intrinsics.f(type, "object : TypeToken<OffPkgConfig?>() {}.type");
                    offPkgConfig = (OffPkgConfig) TmcGsonUtils.e(str, type);
                } catch (Exception e11) {
                    TmcLogger.g("TmcOfflineDownload: OfflineManager", "Json parse error", e11);
                    offPkgConfig = null;
                }
                if (offPkgConfig == null) {
                    if (function1 != null) {
                        function1.invoke(null);
                        return;
                    }
                    return;
                }
                if (!OfflineUtils.f32081a.j(offPkgConfig)) {
                    if (function1 != null) {
                        function1.invoke(null);
                        return;
                    }
                    return;
                }
                String strSubstring = String.valueOf(System.currentTimeMillis()).substring(0, 10);
                Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                long j11 = Long.parseLong(strSubstring);
                UpdateEntity updateEntity = new UpdateEntity(o.a(offPkgConfig), "*.html", offPkgConfig.getGroup(), kotlin.collections.f.e(new PreloadResource(offPkgConfig.getPkgEncrypted(), Integer.valueOf((int) System.currentTimeMillis()), offPkgConfig.getPkgUrl(), offPkgConfig.getGroup(), Long.valueOf(j11))), 4, Long.valueOf(j11));
                String type2 = offPkgConfig.getType();
                if (type2 == null) {
                    type2 = "normal";
                }
                offPkgConfig.setType(type2);
                offPkgConfig.setExtraConfig(o.a(updateEntity));
                final String str2 = "api";
                f32003a.x(new com.cloud.tmc.offline.download.task.a(offPkgConfig, str2, false, new Function2<ce.b, yd.a<?>, Unit>() { // from class: com.cloud.tmc.offline.download.OfflineManager$downloadPkg$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(ce.b bVar, yd.a<?> aVar) {
                        invoke2(bVar, aVar);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ce.b task, yd.a<?> result) {
                        Intrinsics.g(task, "task");
                        Intrinsics.g(result, "result");
                        TmcLogger.c("TmcOfflineDownload: OfflineManager", String.valueOf(result));
                        OfflineUtils.f32081a.U(offPkgConfig, task, result, str2);
                        if (result instanceof yd.a.b) {
                            OfflineStoreCache.f32077a.p(offPkgConfig);
                            OfflinePkgCachePath offlinePkgCachePathH = OfflineManager.H(e.a(offPkgConfig.getGroup(), ""), e.a(offPkgConfig.getPkgUrl(), ""));
                            if (offlinePkgCachePathH != null) {
                                Function1<OfflinePkgCachePath, Unit> function2 = function1;
                                if (function2 != null) {
                                    function2.invoke(offlinePkgCachePathH);
                                    return;
                                }
                                return;
                            }
                        }
                        Function1<OfflinePkgCachePath, Unit> function3 = function1;
                        if (function3 != null) {
                            function3.invoke(null);
                        }
                    }
                }, 4, null));
                return;
            }
            if (function1 != null) {
                function1.invoke(null);
            }
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "Error downloading", th2);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void s(String str) {
        v(str, false, null, 6, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void t(String str, boolean z11) {
        v(str, z11, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void u(String str, boolean z11, Function1<? super Boolean, Unit> function1) {
        TmcLogger.c("TmcOfflineDownload: OfflineManager", "downloadPkgFromPlatform: packageName: " + str + " antiShake: " + z11 + " isInit: " + f32004b);
        if (!f32004b) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        } else if (str != null && str.length() != 0) {
            f32003a.e0("api", str, z11, function1);
        } else if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public static /* synthetic */ void v(String str, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        u(str, z11, function1);
    }

    @JvmStatic
    public static final boolean w(String str) {
        try {
            return OfflineUtils.f32081a.p(str);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "Error enabling verify server file", th2);
            return false;
        }
    }

    public static final boolean y() {
        JsonElement jsonElement;
        JsonObject jsonObjectZ = f32003a.z();
        boolean z11 = false;
        if (jsonObjectZ != null && (jsonElement = jsonObjectZ.get("checkVersion")) != null && jsonElement.getAsBoolean()) {
            z11 = true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("check version enable config is ");
        sb2.append(z11 ? "enabled" : "disabled");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", sb2.toString());
        return z11;
    }

    public final com.cloud.tmc.offline.download.task.queue.b C() {
        return (com.cloud.tmc.offline.download.task.queue.b) f32008f.getValue();
    }

    public final vd.b L() {
        return f32006d;
    }

    public final void Q() {
        int i11;
        try {
            TH5Update.a aVar = TH5Update.f28868c;
            aVar.r(new wd.a(f32006d));
            String strQ = AppDynamicBuildConfig.q();
            TmcLogger.c("TmcOfflineDownload: OfflineManager", "离线配置模式为：" + strQ);
            int i12 = 3;
            if (Intrinsics.b(strQ, "test")) {
                i11 = 3;
            } else {
                i11 = Intrinsics.b(strQ, "pre") ? 2 : 1;
            }
            if (!AppDynamicBuildConfig.v()) {
                i12 = i11;
            }
            TmcLogger.c("TmcOfflineDownload: OfflineManager", "离线下载模式为：" + i12 + " (1:online;2:pre;3:test)");
            Context contextA = A();
            if (contextA != null) {
                aVar.d().r(i12).n((Application) contextA, (Worker.WHAT_QUIT & 2) != 0, (Worker.WHAT_QUIT & 4) != 0 ? null : null, (Worker.WHAT_QUIT & 8) == 0 ? null : null, (Worker.WHAT_QUIT & 16) != 0 ? false : true, (Worker.WHAT_QUIT & 32) != 0 ? "" : null, (Worker.WHAT_QUIT & 64) == 0 ? 0 : 0);
            }
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "Offline init H5 update failed!", th2);
        }
    }

    public final synchronized void R(Application application) {
        if (!Y()) {
            TmcLogger.c("TmcOfflineDownload: OfflineManager", "OfflineManager init fails! Params is disabled");
            return;
        }
        if (f32004b) {
            TmcLogger.c("TmcOfflineDownload: OfflineManager", "OfflineManager is initialized");
            return;
        }
        f32005c = application;
        try {
            tc.a.d(IOfflineResourceProcessorProxy.class, new tc.a.b() { // from class: com.cloud.tmc.offline.download.c
                @Override // tc.a.b
                public final Object get() {
                    return OfflineManager.S();
                }
            });
            tc.a.d(IOfflineResourceManagerProxy.class, new tc.a.b() { // from class: com.cloud.tmc.offline.download.d
                @Override // tc.a.b
                public final Object get() {
                    return OfflineManager.T();
                }
            });
            if (((IOfflineDownloadConfig) tc.a.a(IOfflineDownloadConfig.class)).enableNetworkListener() && D()) {
                NetworkUtil.d(application, f32007e);
            }
            Q();
            f32004b = true;
            TmcLogger.c("TmcOfflineDownload: OfflineManager", "OfflineManager initialized");
            if (B()) {
                f0(this, "init", null, false, null, 14, null);
            }
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "Offline init failed", th2);
        }
    }

    public final boolean Z() {
        return com.cloud.tmc.offline.download.utils.b.a("is_fast", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
    }

    public final boolean b0() {
        return com.cloud.tmc.offline.download.utils.b.a("is_host_fast", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
    }

    public final boolean d0() {
        return com.cloud.tmc.offline.download.utils.b.a("is_pre_pull_appInfo_fast", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0084  */
    /* JADX WARN: Code duplicated, block: B:35:0x009a  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x0084, please report this as an issue */
    public final void e0(final String str, String str2, boolean z11, final Function1<? super Boolean, Unit> function1) {
        if (!f32004b) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("antiShake switch is ");
        sb2.append(z11 ? "enable" : "disabled");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", sb2.toString());
        if (z11) {
            String str3 = "Loading configuration time is too short, try later! trigger: " + str;
            if (str2 != null && str2.length() != 0) {
                Context contextA = A();
                if (Intrinsics.b(str2, contextA != null ? contextA.getPackageName() : null)) {
                    if (b0()) {
                        TmcLogger.c("TmcOfflineDownload: OfflineManager", str3 + " host is fast");
                        if (function1 != null) {
                            function1.invoke(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                } else if (Z()) {
                    TmcLogger.c("TmcOfflineDownload: OfflineManager", str3 + " packageName: " + str2);
                    if (function1 != null) {
                        function1.invoke(Boolean.FALSE);
                        return;
                    }
                    return;
                }
            } else if (b0()) {
                TmcLogger.c("TmcOfflineDownload: OfflineManager", str3 + " host is fast");
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                    return;
                }
                return;
            }
        }
        if (str2 == null) {
            Context contextA2 = A();
            str2 = contextA2 != null ? contextA2.getPackageName() : null;
        }
        if (str2 == null || str2.length() == 0) {
            TmcLogger.c("TmcOfflineDownload: OfflineManager", "packageName is null or empty!");
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        TmcLogger.c("TmcOfflineDownload: OfflineManager", "loadConfig: trigger: " + str + " packageName: " + str2);
        if (OfflineUtils.f32081a.d(str2)) {
            x(new LoadOfflineConfigTask(str2, 0, str, new Function2<ce.b, yd.a<?>, Unit>() { // from class: com.cloud.tmc.offline.download.OfflineManager$loadConfig$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ce.b bVar, yd.a<?> aVar) {
                    invoke2(bVar, aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ce.b task, yd.a<?> result) {
                    Intrinsics.g(task, "task");
                    Intrinsics.g(result, "result");
                    TmcLogger.c("TmcOfflineDownload: OfflineManager", String.valueOf(result));
                    OfflineUtils.f32081a.U(null, task, result, str);
                    if (result instanceof yd.a.b) {
                        OfflineManager offlineManager = OfflineManager.f32003a;
                        String str4 = str;
                        Object objA = result.a();
                        offlineManager.i0(str4, objA instanceof OffPkgConfig ? (OffPkgConfig) objA : null, function1);
                        return;
                    }
                    Function1<Boolean, Unit> function2 = function1;
                    if (function2 != null) {
                        function2.invoke(Boolean.FALSE);
                    }
                }
            }));
            return;
        }
        TmcLogger.c("TmcOfflineDownload: OfflineManager", "loadConfig: " + ("packageName: " + str2 + " is not valid, unable to load config"));
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public final void h0(vd.b bVar) {
        try {
            TH5Update.a aVar = TH5Update.f28868c;
            m9.b bVarJ = aVar.j();
            Unit unit = null;
            wd.a aVar2 = bVarJ instanceof wd.a ? (wd.a) bVarJ : null;
            if (aVar2 != null) {
                aVar2.j(bVar);
                unit = Unit.f68710a;
            }
            if (unit == null) {
                aVar.r(new wd.a(bVar));
            }
            f32006d = bVar;
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineManager", "set update callback failed!", th2);
        }
    }

    public final void i0(final String str, OffPkgConfig offPkgConfig, final Function1<? super Boolean, Unit> function1) {
        if (!f32004b) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        final OffPkgConfig offPkgConfigD = OfflineStoreCache.f32077a.d(offPkgConfig != null ? offPkgConfig.getGroup() : null);
        if (offPkgConfigD == null) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        boolean zB = Intrinsics.b(offPkgConfigD.getDownloadModel(), "startup");
        TmcLogger.c("TmcOfflineDownload: OfflineManager", "startDownloadTask: trigger: " + str + " isStartUp: " + zB);
        x(new com.cloud.tmc.offline.download.task.a(offPkgConfigD, str, zB ^ true, new Function2<ce.b, yd.a<?>, Unit>() { // from class: com.cloud.tmc.offline.download.OfflineManager$startDownloadTask$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ce.b bVar, yd.a<?> aVar) {
                invoke2(bVar, aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ce.b task, yd.a<?> result) {
                Intrinsics.g(task, "task");
                Intrinsics.g(result, "result");
                TmcLogger.c("TmcOfflineDownload: OfflineManager", "startDownloadTask: " + result);
                OfflineUtils.f32081a.U(offPkgConfigD, task, result, str);
                if (result instanceof yd.a.b) {
                    Function1<Boolean, Unit> function2 = function1;
                    if (function2 != null) {
                        function2.invoke(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                Function1<Boolean, Unit> function3 = function1;
                if (function3 != null) {
                    function3.invoke(Boolean.FALSE);
                }
            }
        }));
    }

    public final void l(final Context context) {
        Intrinsics.g(context, "context");
        try {
            com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.offline.download.a
                @Override // java.lang.Runnable
                public final void run() {
                    OfflineManager.m(context);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.e("clearCache error:" + th2);
        }
    }

    public final void n(String str) {
        if (X()) {
            x(new PrePullAppInfoDownloadTask(str, new Function2<ce.b, yd.a<?>, Unit>() { // from class: com.cloud.tmc.offline.download.OfflineManager$doExecutePrePullAppInfoDownloadTask$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ce.b bVar, yd.a<?> aVar) {
                    invoke2(bVar, aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ce.b bVar, yd.a<?> result) {
                    Intrinsics.g(bVar, "<anonymous parameter 0>");
                    Intrinsics.g(result, "result");
                    Object objA = result.a();
                    String str2 = objA instanceof String ? (String) objA : null;
                    TmcLogger.c("TmcOfflineDownload: OfflineManager", "PrePullAppInfoDownloadTask 下一步是 " + str2);
                    if (Intrinsics.b(str2, "step_unzip")) {
                        try {
                            OfflineManager.f32003a.o("step_download");
                        } catch (Throwable th2) {
                            TmcLogger.g("TmcOfflineDownload: OfflineManager", "执行解压任务发生错误啦", th2);
                        }
                    }
                }
            }));
        } else {
            TmcLogger.c("TmcOfflineDownload: OfflineManager", "预拉取精选 AppInfo 能力已关闭，下载任务");
        }
    }

    public final void o(String str) {
        if (X()) {
            x(new PrePullAppInfoParseTask(str, new Function2<ce.b, yd.a<?>, Unit>() { // from class: com.cloud.tmc.offline.download.OfflineManager$doExecutePrePullAppInfoUnZipTask$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ce.b bVar, yd.a<?> aVar) {
                    invoke2(bVar, aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ce.b bVar, yd.a<?> result) {
                    Intrinsics.g(bVar, "<anonymous parameter 0>");
                    Intrinsics.g(result, "result");
                    Object objA = result.a();
                    String str2 = objA instanceof String ? (String) objA : null;
                    TmcLogger.c("TmcOfflineDownload: OfflineManager", "PrePullAppInfoParseTask 下一步是 " + str2);
                    if (Intrinsics.b(str2, "step_download")) {
                        try {
                            OfflineManager.f32003a.n("step_unzip");
                        } catch (Throwable th2) {
                            TmcLogger.g("TmcOfflineDownload: OfflineManager", "执行下载任务发生错误啦", th2);
                        }
                    }
                }
            }));
        } else {
            TmcLogger.c("TmcOfflineDownload: OfflineManager", "预拉取精选 AppInfo 能力已关闭，解析任务");
        }
    }

    public final void x(ce.b bVar) {
        if (f32004b) {
            if (!Y()) {
                TmcLogger.c("TmcOfflineDownload: OfflineManager", "Offline download is disabled");
                return;
            }
            if (!l.e()) {
                TmcLogger.c("TmcOfflineDownload: OfflineManager", "Offline download current process is not mini process，cannot execute task");
                return;
            }
            if (!com.cloud.tmc.offline.download.utils.e.a()) {
                TmcLogger.c("TmcOfflineDownload: OfflineManager", "Network connection is not connected!");
                return;
            }
            TmcLogger.c("TmcOfflineDownload: OfflineManager", "execute: task: " + bVar + " trigger: " + bVar.I());
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            OfflineDownloadAnalyseType offlineDownloadAnalyseType = OfflineDownloadAnalyseType.TASK_START;
            Bundle bundle = new Bundle();
            bundle.putAll(OfflineUtils.Q(OfflineUtils.f32081a, bVar instanceof com.cloud.tmc.offline.download.task.a ? ((com.cloud.tmc.offline.download.task.a) bVar).h() : null, bVar.I(), Boolean.valueOf(bVar.M()), null, bVar, 8, null));
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record(null, offlineDownloadAnalyseType, "", bundle);
            C().b(bVar);
        }
    }

    public final JsonObject z() {
        try {
            ConfigService configService = (ConfigService) tc.a.a(ConfigService.class);
            MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.f30370a;
            JsonObject configJsonObject = configService.getConfigJsonObject(miniAppConfigHelper.i());
            return configJsonObject == null ? JsonParser.parseString(miniAppConfigHelper.g()).getAsJsonObject() : configJsonObject;
        } catch (Throwable th2) {
            TmcLogger.h("TmcOfflineDownload: OfflineManager", th2);
            return null;
        }
    }
}
