package com.cloud.tmc.offline.download.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.PreloadResource;
import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.proxy.IAppInfoManagerProxy;
import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.OfflineDownloadAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.c0;
import com.cloud.tmc.miniutils.util.i;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OffPkgConfigExtParams;
import com.cloud.tmc.offline.download.model.OfflinePkgCachePath;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.cloud.tmc.offline.download.model.OfflineZipFileInfo;
import com.cloud.tmc.offline.download.model.PackageInclude;
import com.cloud.tmc.offline.download.model.ZipFileInfo;
import com.cloud.tmc.offline.download.resource.IOfflineResourceManagerProxy;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.push.PushConstants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
@SourceDebugExtension
public final class OfflineUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfflineUtils f32081a = new OfflineUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, OffPkgConfig> f32082b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f32083c;

    public static /* synthetic */ List B(OfflineUtils offlineUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return offlineUtils.A(str, str2);
    }

    public static /* synthetic */ OffPkgConfig D(OfflineUtils offlineUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return offlineUtils.C(str, str2);
    }

    public static /* synthetic */ OfflinePkgCachePath G(OfflineUtils offlineUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return offlineUtils.F(str, str2);
    }

    public static /* synthetic */ void N(OfflineUtils offlineUtils, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        offlineUtils.M(str, z11);
    }

    public static /* synthetic */ Bundle Q(OfflineUtils offlineUtils, OffPkgConfig offPkgConfig, String str, Boolean bool, Long l11, ce.b bVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            offPkgConfig = null;
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            bool = null;
        }
        if ((i11 & 8) != 0) {
            l11 = null;
        }
        if ((i11 & 16) != 0) {
            bVar = null;
        }
        return offlineUtils.P(offPkgConfig, str, bool, l11, bVar);
    }

    public static /* synthetic */ OfflinePkgCachePath T(OfflineUtils offlineUtils, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return offlineUtils.S(str, z11);
    }

    public static /* synthetic */ boolean f(OfflineUtils offlineUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return offlineUtils.e(str, str2);
    }

    public static /* synthetic */ boolean i(OfflineUtils offlineUtils, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        return offlineUtils.h(str, str2, str3);
    }

    public final List<ZipFileInfo> A(String str, String str2) {
        ArrayList arrayList;
        if (str != null && str.length() != 0) {
            Context contextA = OfflineManager.A();
            String packageName = contextA != null ? contextA.getPackageName() : null;
            if (packageName != null && packageName.length() != 0) {
                OfflinePkgCachePath offlinePkgCachePathS = S(str2 == null ? str : str2, true);
                List<ZipFileInfo> zipFileInfo = offlinePkgCachePathS != null ? offlinePkgCachePathS.getZipFileInfo() : null;
                if (zipFileInfo != null) {
                    arrayList = new ArrayList();
                    for (ZipFileInfo zipFileInfo2 : zipFileInfo) {
                        OffPkgConfig manifest = zipFileInfo2.getManifest();
                        if (!Intrinsics.b(str, manifest != null ? manifest.getGroup() : null)) {
                            zipFileInfo2 = null;
                        }
                        if (zipFileInfo2 != null) {
                            arrayList.add(zipFileInfo2);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null && (!arrayList.isEmpty())) {
                    return arrayList;
                }
                if (Intrinsics.b(str, packageName)) {
                    return null;
                }
                if ((str2 == null || str2.length() == 0) && !Intrinsics.b(str2, packageName)) {
                    return A(str, packageName);
                }
                return null;
            }
        }
        return null;
    }

    public final OffPkgConfig C(String str, String str2) {
        Context contextX = x();
        String packageName = contextX != null ? contextX.getPackageName() : null;
        if (packageName == null || packageName.length() == 0) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "No package name");
            return null;
        }
        OffPkgConfig offPkgConfigD = OfflineStoreCache.f32077a.d(str2 == null ? packageName : str2);
        if (offPkgConfigD == null) {
            if (Intrinsics.b(str, packageName)) {
                return null;
            }
            if ((str2 == null || str2.length() == 0) && !Intrinsics.b(str, str2)) {
                return f32081a.C(str, str);
            }
            return null;
        }
        UpdateEntity updateEntityT = t(offPkgConfigD);
        if (updateEntityT == null) {
            if (Intrinsics.b(str, packageName)) {
                return null;
            }
            if ((str2 == null || str2.length() == 0) && !Intrinsics.b(str, str2)) {
                return f32081a.C(str, str);
            }
            return null;
        }
        List<PreloadResource> preloadResource = updateEntityT.getPreloadResource();
        if (preloadResource == null) {
            if (Intrinsics.b(str, packageName)) {
                return null;
            }
            if ((str2 == null || str2.length() == 0) && !Intrinsics.b(str, str2)) {
                return f32081a.C(str, str);
            }
            return null;
        }
        Iterator<PreloadResource> it = preloadResource.iterator();
        while (it.hasNext()) {
            String staticZipUrl = it.next().getStaticZipUrl();
            if (staticZipUrl != null) {
                OfflineZipDownloadInfo offlineZipDownloadInfoH = OfflineStoreCache.f32077a.h(offPkgConfigD, staticZipUrl);
                if (offlineZipDownloadInfoH.getStatus() != 4) {
                    continue;
                } else {
                    OffPkgConfig manifest = offlineZipDownloadInfoH.getManifest();
                    if (Intrinsics.b(str, manifest != null ? manifest.getGroup() : null)) {
                        return offlineZipDownloadInfoH.getManifest();
                    }
                }
            }
        }
        if (Intrinsics.b(str, packageName)) {
            return null;
        }
        if ((str2 == null || str2.length() == 0) && !Intrinsics.b(str, str2)) {
            return C(str, str);
        }
        return null;
    }

    public final OffPkgConfig E(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap<String, OffPkgConfig> map = f32082b;
        OffPkgConfig offPkgConfig = map.get(str);
        if (offPkgConfig != null && jCurrentTimeMillis - f32083c <= OfflineManager.E()) {
            return offPkgConfig;
        }
        OffPkgConfig offPkgConfigD = D(this, str, null, 2, null);
        if (offPkgConfigD != null) {
            map.put(str, offPkgConfigD);
        }
        f32083c = jCurrentTimeMillis;
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "manifestCache 内存失效，从缓存中读取，" + offPkgConfigD);
        return offPkgConfigD;
    }

    public final OfflinePkgCachePath F(String appId, String str) {
        ZipFileInfo zipFileInfo;
        Object next;
        OffPkgConfig manifest;
        Intrinsics.g(appId, "appId");
        Context contextA = OfflineManager.A();
        OfflinePkgCachePath offlinePkgCachePath = null;
        String packageName = contextA != null ? contextA.getPackageName() : null;
        if (packageName == null || packageName.length() == 0) {
            return null;
        }
        OfflinePkgCachePath offlinePkgCachePathT = T(this, str == null ? packageName : str, false, 2, null);
        List<ZipFileInfo> zipFileInfo2 = offlinePkgCachePathT != null ? offlinePkgCachePathT.getZipFileInfo() : null;
        if (zipFileInfo2 != null) {
            Iterator<T> it = zipFileInfo2.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                manifest = ((ZipFileInfo) next).getManifest();
            } while (!Intrinsics.b(appId, manifest != null ? manifest.getGroup() : null));
            zipFileInfo = (ZipFileInfo) next;
        } else {
            zipFileInfo = null;
        }
        if (zipFileInfo != null) {
            OffPkgConfig manifest2 = zipFileInfo.getManifest();
            offlinePkgCachePath = new OfflinePkgCachePath(appId, manifest2 != null ? manifest2.getVersion() : null, kotlin.collections.g.q(zipFileInfo));
        }
        if (Intrinsics.b(appId, packageName)) {
            return offlinePkgCachePath;
        }
        if ((str != null && str.length() != 0) || Intrinsics.b(appId, str) || offlinePkgCachePath != null) {
            return offlinePkgCachePath;
        }
        if (d(appId)) {
            return F(appId, appId);
        }
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "getOfflinePkgFwCachePath: " + ("appId: " + appId + " is not valid, unable search for miniapp offline pkg"));
        return offlinePkgCachePath;
    }

    public final OfflineDownloadAnalyseType H(yd.a<?> aVar) {
        return aVar instanceof yd.a.b ? OfflineDownloadAnalyseType.TASK_FINISH : OfflineDownloadAnalyseType.TASK_FAIL;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0027  */
    public final boolean I(OffPkgConfig offPkgConfig) {
        boolean z11;
        long j11 = OfflineStoreCache.f32077a.j(offPkgConfig);
        long jCurrentTimeMillis = System.currentTimeMillis() - j11;
        if (j11 <= 0) {
            z11 = true;
        } else {
            if (jCurrentTimeMillis > (AppDynamicBuildConfig.v() ? 120000L : z())) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        if (!z11) {
            long jB = c0.b();
            String strA = c0.a(jB, jB - jCurrentTimeMillis, 5);
            StringBuilder sb2 = new StringBuilder();
            String group = offPkgConfig.getGroup();
            if (group == null) {
                group = "It";
            }
            sb2.append(group);
            sb2.append(" has only been ");
            sb2.append(strA);
            sb2.append(" since the last update or check, which does not meet the 24-hour update policy");
            N(this, sb2.toString(), false, 2, null);
        }
        return z11;
    }

    public final boolean J() {
        return Intrinsics.b(Looper.myLooper(), Looper.getMainLooper());
    }

    public final boolean K(OffPkgConfig offPkgConfig) {
        UpdateEntity updateEntityT;
        List<PreloadResource> preloadResource;
        Intrinsics.g(offPkgConfig, "offPkgConfig");
        if (!I(offPkgConfig)) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "更新时间不满足要求，不允许更新");
            return false;
        }
        OffPkgConfig offPkgConfigD = OfflineStoreCache.f32077a.d(offPkgConfig.getGroup());
        if (offPkgConfigD == null) {
            return true;
        }
        if (Intrinsics.b(offPkgConfig.getVersion(), offPkgConfigD.getVersion()) && (updateEntityT = t(offPkgConfig)) != null && (preloadResource = updateEntityT.getPreloadResource()) != null) {
            Iterator<T> it = preloadResource.iterator();
            while (it.hasNext()) {
                String staticZipUrl = ((PreloadResource) it.next()).getStaticZipUrl();
                if (staticZipUrl != null && staticZipUrl.length() > 0) {
                    OfflineZipDownloadInfo offlineZipDownloadInfoH = OfflineStoreCache.f32077a.h(offPkgConfig, staticZipUrl);
                    if (offlineZipDownloadInfoH.getStatus() < 2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("当前资源尚未下载，允许下载：");
                        String url = offlineZipDownloadInfoH.getUrl();
                        if (url != null) {
                            staticZipUrl = url;
                        }
                        sb2.append(staticZipUrl);
                        TmcLogger.c("TmcOfflineDownload: OfflineUtils", sb2.toString());
                        return true;
                    }
                }
            }
        }
        boolean zB = true ^ Intrinsics.b(offPkgConfig.getVersion(), offPkgConfigD.getVersion());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("检查版本是否符合更新要求：");
        sb3.append(zB ? "符合" : "不符合");
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", sb3.toString());
        if (zB) {
            OfflineStoreCache.f32077a.n(offPkgConfigD);
            j.d(l0.a(w0.b()), null, null, new OfflineUtils$isNeedDownload$2$1(offPkgConfigD, f32081a.y(offPkgConfig, offPkgConfigD), null), 3, null);
        }
        return zB;
    }

    public final OffPkgConfig L(String zipUnCompressPath) {
        Intrinsics.g(zipUnCompressPath, "zipUnCompressPath");
        if (!com.cloud.tmc.miniutils.util.j.x(zipUnCompressPath)) {
            return null;
        }
        File file = new File(zipUnCompressPath, "offpkg_manifest.json");
        if (!FileUtil.c(file)) {
            return null;
        }
        String strD = i.d(file, "UTF-8");
        Intrinsics.f(strD, "readFile2String(manifestFile, \"UTF-8\")");
        try {
            return (OffPkgConfig) TmcGsonUtils.d(strD, OffPkgConfig.class);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineUtils", "parse Json fail", th2);
            return null;
        }
    }

    public final void M(String str, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(' ');
        sb2.append(z11 ? Log.getStackTraceString(new Throwable("Just Print")) : "");
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", sb2.toString());
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f1  */
    public final boolean O(String str, Response response) {
        UpdateEntity updateEntityT;
        String extraConfig;
        JsonArray asJsonArray;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        JsonElement next;
        JsonObject asJsonObject2;
        JsonElement jsonElement2;
        JsonElement next2;
        JsonObject asJsonObject3;
        JsonElement jsonElement3;
        JsonObject asJsonObject4;
        JsonElement jsonElement4;
        JsonElement jsonElement5;
        JsonObject asJsonObject5;
        JsonElement jsonElement6;
        try {
            String str2 = response.headers().get("ETag");
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "metadataMatches: Server eTag: " + str2);
            OffPkgConfig offPkgConfigD = OfflineStoreCache.f32077a.d(str);
            if (offPkgConfigD == null || (updateEntityT = t(offPkgConfigD)) == null || (extraConfig = updateEntityT.getExtraConfig()) == null) {
                return false;
            }
            JsonElement string = JsonParser.parseString(extraConfig);
            String asString = null;
            JsonObject asJsonObject6 = string != null ? string.getAsJsonObject() : null;
            JsonArray asJsonArray2 = (asJsonObject6 == null || (jsonElement5 = asJsonObject6.get("extParams")) == null || (asJsonObject5 = jsonElement5.getAsJsonObject()) == null || (jsonElement6 = asJsonObject5.get("verifyServerFileMetadata")) == null) ? null : jsonElement6.getAsJsonArray();
            if (asJsonArray2 != null) {
                Iterator<JsonElement> it = asJsonArray2.iterator();
                do {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                    asJsonObject4 = next2.getAsJsonObject();
                } while (!Intrinsics.b((asJsonObject4 == null || (jsonElement4 = asJsonObject4.get(PushConstants.PROVIDER_FIELD_APP_ID)) == null) ? null : jsonElement4.getAsString(), str));
                JsonElement jsonElement7 = next2;
                if (jsonElement7 == null || (asJsonObject3 = jsonElement7.getAsJsonObject()) == null || (jsonElement3 = asJsonObject3.get(TtmlNode.TAG_METADATA)) == null) {
                    asJsonArray = null;
                } else {
                    asJsonArray = jsonElement3.getAsJsonArray();
                }
            } else {
                asJsonArray = null;
            }
            if (asJsonArray != null) {
                Iterator<JsonElement> it2 = asJsonArray.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    asJsonObject2 = next.getAsJsonObject();
                } while (!Intrinsics.b((asJsonObject2 == null || (jsonElement2 = asJsonObject2.get("url")) == null) ? null : jsonElement2.getAsString(), response.request().url().toString()));
                JsonElement jsonElement8 = next;
                if (jsonElement8 != null) {
                    asJsonObject = jsonElement8.getAsJsonObject();
                } else {
                    asJsonObject = null;
                }
            } else {
                asJsonObject = null;
            }
            if (asJsonObject != null && (jsonElement = asJsonObject.get("eTag")) != null) {
                asString = jsonElement.getAsString();
            }
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "metadataMatches: H5 platform eTag: " + asString);
            return Intrinsics.b(asString, str2);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineUtils", "metadataMatches fail!", th2);
            return false;
        }
    }

    public final Bundle P(OffPkgConfig offPkgConfig, String str, Boolean bool, Long l11, ce.b bVar) {
        Bundle bundle = new Bundle();
        if (offPkgConfig != null) {
            bundle.putString("offline_pkg_version", offPkgConfig.getVersion());
            bundle.putString("offline_pkg_group", offPkgConfig.getGroup());
            bundle.putString("offline_pkg_nation", offPkgConfig.getNation());
            bundle.putString("offline_pkg_app", offPkgConfig.getApp());
            bundle.putString("offline_pkg_language", offPkgConfig.getLanguage());
            bundle.putInt("offline_pkg_priority", offPkgConfig.getPriority());
            bundle.putString("offline_pkg_type", offPkgConfig.getType());
            bundle.putString("offline_pkg_networkType", offPkgConfig.getNetworkType());
        }
        if (bool != null) {
            bool.booleanValue();
            bundle.putString("offline_pkg_downloadModel", bool.booleanValue() ? "idle" : "startup");
        }
        if (l11 != null) {
            l11.longValue();
            bundle.putLong("offline_pkg_consume_time", l11.longValue());
        }
        if (bVar instanceof ce.a) {
            bundle.putString("offline_pkg_task", ((ce.a) bVar).toString());
        }
        if (str != null) {
            bundle.putString("offline_pkg_trigger", str);
        }
        return bundle;
    }

    public final void R(boolean z11, Bundle bundle) {
        Intrinsics.g(bundle, "bundle");
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            OfflineDownloadAnalyseType offlineDownloadAnalyseType = OfflineDownloadAnalyseType.OFFLINE_PKG_API_USAGE_STATUS;
            bundle.putInt(offlineDownloadAnalyseType.getObjectNameEn(), z11 ? 1 : 0);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record(null, offlineDownloadAnalyseType, "", bundle);
        } catch (Throwable th2) {
            TmcLogger.h("TmcOfflineDownload: OfflineUtils", th2);
        }
    }

    public final OfflinePkgCachePath S(String group, boolean z11) {
        UpdateEntity updateEntityT;
        Intrinsics.g(group, "group");
        if (!OfflineManager.c0()) {
            return null;
        }
        OffPkgConfig offPkgConfigE = z11 ? OfflineStoreCache.f32077a.e(group) : OfflineStoreCache.f32077a.d(group);
        if (offPkgConfigE == null || (updateEntityT = t(offPkgConfigE)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PreloadResource> preloadResource = updateEntityT.getPreloadResource();
        if (preloadResource == null) {
            return null;
        }
        Iterator<PreloadResource> it = preloadResource.iterator();
        while (it.hasNext()) {
            String staticZipUrl = it.next().getStaticZipUrl();
            if (staticZipUrl != null) {
                OfflineZipDownloadInfo offlineZipDownloadInfoH = OfflineStoreCache.f32077a.h(offPkgConfigE, staticZipUrl);
                if (offlineZipDownloadInfoH.getStatus() == 4) {
                    ZipFileInfo zipFileInfo = new ZipFileInfo(null, null, null, 7, null);
                    String zipUnCompressPath = offlineZipDownloadInfoH.getZipUnCompressPath();
                    if (zipUnCompressPath != null) {
                        zipFileInfo.setZipUnCompressPath(zipUnCompressPath);
                    }
                    String url = offlineZipDownloadInfoH.getUrl();
                    if (url != null) {
                        zipFileInfo.setUrl(url);
                    }
                    OffPkgConfig manifest = offlineZipDownloadInfoH.getManifest();
                    if (manifest != null) {
                        zipFileInfo.setManifest(manifest);
                    }
                    arrayList.add(zipFileInfo);
                }
            }
        }
        return new OfflinePkgCachePath(offPkgConfigE.getGroup(), offPkgConfigE.getVersion(), arrayList);
    }

    public final void U(OffPkgConfig offPkgConfig, ce.b task, yd.a<?> result, String trigger) {
        Intrinsics.g(task, "task");
        Intrinsics.g(result, "result");
        Intrinsics.g(trigger, "trigger");
        if (result.d()) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - task.L();
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            OfflineDownloadAnalyseType offlineDownloadAnalyseTypeH = H(result);
            String str = task + "，耗时：" + jElapsedRealtime + "ms";
            Bundle bundleP = P(offPkgConfig, trigger, Boolean.valueOf(task.M()), Long.valueOf(jElapsedRealtime), task);
            bundleP.putInt("offline_pkg_error_code", result.b());
            bundleP.putString("offline_pkg_error_msg", result.c());
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record(null, offlineDownloadAnalyseTypeH, str, bundleP);
        }
    }

    public final boolean V(final String str, final String str2) {
        boolean zBooleanValue = false;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "verifyServerFile: appId or url is null or empty");
            return false;
        }
        if (!NetworkUtils.r()) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "verifyServerFile: 网络未连接，默认进行通过。" + str2);
            return true;
        }
        if (!W(str, str2)) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "verifyServerFile: 该URL不在待校验的URLS内则默认进行通过。" + str2);
            return true;
        }
        Function0<Boolean> function0 = new Function0<Boolean>() { // from class: com.cloud.tmc.offline.download.utils.OfflineUtils$verifyServerFile$block$1

            /* JADX INFO: compiled from: source.java */
            @Metadata
            @SourceDebugExtension
            public static final class a implements Interceptor {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f32084a;

                public a(String str) {
                    this.f32084a = str;
                }

                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain chain) throws IOException {
                    Intrinsics.g(chain, "chain");
                    Request request = chain.request();
                    Response responseProceed = chain.proceed(request);
                    return OfflineUtils.f32081a.O(this.f32084a, responseProceed) ? new Response.Builder().request(request).protocol(responseProceed.protocol()).code(304).message("Not Modified").body(responseProceed.body()).build() : responseProceed;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws IOException {
                Response responseExecute = FirebasePerfOkHttpClient.execute(new OkHttpClient.Builder().addInterceptor(new a(str)).build().newCall(new Request.Builder().url(str2).build()));
                boolean z11 = true;
                if (responseExecute.code() == 304) {
                    TmcLogger.c("TmcOfflineDownload: OfflineUtils", "verifyServerFile: 离线文件校验成功，Not Modified，url: " + str2);
                    PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                    String str3 = str;
                    OfflineDownloadAnalyseType offlineDownloadAnalyseType = OfflineDownloadAnalyseType.OFFLINE_VERIFY_SERVER_FILE;
                    Bundle bundle = new Bundle();
                    String str4 = str;
                    String str5 = str2;
                    bundle.putString("offline_pkg_appId", str4);
                    bundle.putString("offline_pkg_url", str5);
                    bundle.putInt("offline_pkg_verify_server_status", 0);
                    Unit unit = Unit.f68710a;
                    performanceAnalyseProxy.record(str3, offlineDownloadAnalyseType, "", bundle);
                } else {
                    if (responseExecute.isSuccessful()) {
                        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "verifyServerFile: 请求成功，未命中离线文件，文件失效，url: " + str2);
                        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                        String str6 = str;
                        OfflineDownloadAnalyseType offlineDownloadAnalyseType2 = OfflineDownloadAnalyseType.OFFLINE_VERIFY_SERVER_FILE;
                        Bundle bundle2 = new Bundle();
                        String str7 = str;
                        String str8 = str2;
                        bundle2.putString("offline_pkg_appId", str7);
                        bundle2.putString("offline_pkg_url", str8);
                        bundle2.putInt("offline_pkg_verify_server_status", 1);
                        Unit unit2 = Unit.f68710a;
                        performanceAnalyseProxy2.record(str6, offlineDownloadAnalyseType2, "", bundle2);
                    } else {
                        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "verifyServerFile: 请求失败，url: " + str2);
                        PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                        String str9 = str;
                        OfflineDownloadAnalyseType offlineDownloadAnalyseType3 = OfflineDownloadAnalyseType.OFFLINE_VERIFY_SERVER_FILE;
                        Bundle bundle3 = new Bundle();
                        String str10 = str;
                        String str11 = str2;
                        bundle3.putString("offline_pkg_appId", str10);
                        bundle3.putString("offline_pkg_url", str11);
                        bundle3.putInt("offline_pkg_verify_server_status", 2);
                        Unit unit3 = Unit.f68710a;
                        performanceAnalyseProxy3.record(str9, offlineDownloadAnalyseType3, "", bundle3);
                    }
                    z11 = false;
                }
                return Boolean.valueOf(z11);
            }
        };
        try {
            if (J()) {
                TmcLogger.f("TmcOfflineDownload: OfflineUtils", "verifyServerFile 不支持在主线程中使用");
            } else {
                zBooleanValue = function0.invoke().booleanValue();
            }
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineUtils", "verifyServerFile request fail! ", th2);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            OfflineDownloadAnalyseType offlineDownloadAnalyseType = OfflineDownloadAnalyseType.OFFLINE_VERIFY_SERVER_FILE;
            Bundle bundle = new Bundle();
            bundle.putString("offline_pkg_appId", str);
            bundle.putString("offline_pkg_url", str2);
            bundle.putString("offline_pkg_error_msg", th2.getMessage());
            bundle.putInt("offline_pkg_verify_server_status", 3);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.record(str, offlineDownloadAnalyseType, "", bundle);
        }
        return zBooleanValue;
    }

    public final boolean W(String str, String str2) {
        OffPkgConfig offPkgConfigD;
        UpdateEntity updateEntityT;
        String extraConfig;
        JsonObject asJsonObject;
        JsonElement next;
        JsonElement jsonElement;
        JsonObject asJsonObject2;
        JsonElement jsonElement2;
        JsonObject asJsonObject3;
        JsonElement jsonElement3;
        JsonObject asJsonObject4;
        JsonElement jsonElement4;
        if (str2 == null || str2.length() == 0 || (offPkgConfigD = OfflineStoreCache.f32077a.d(str)) == null || (updateEntityT = t(offPkgConfigD)) == null || (extraConfig = updateEntityT.getExtraConfig()) == null) {
            return false;
        }
        try {
            JsonElement string = JsonParser.parseString(extraConfig);
            asJsonObject = string != null ? string.getAsJsonObject() : null;
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineUtils", "Json parse exception:", th2);
        }
        if (asJsonObject == null) {
            return false;
        }
        try {
            JsonElement jsonElement5 = asJsonObject.get("extParams");
            JsonArray asJsonArray = (jsonElement5 == null || (asJsonObject4 = jsonElement5.getAsJsonObject()) == null || (jsonElement4 = asJsonObject4.get("verifyServerFileMetadata")) == null) ? null : jsonElement4.getAsJsonArray();
            if (asJsonArray == null) {
                TmcLogger.c("TmcOfflineDownload: OfflineUtils", "verifyServerUrl: verifyServerFileMetadata 没有配置");
                return false;
            }
            Iterator<JsonElement> it = asJsonArray.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                asJsonObject3 = next.getAsJsonObject();
            } while (!Intrinsics.b((asJsonObject3 == null || (jsonElement3 = asJsonObject3.get(PushConstants.PROVIDER_FIELD_APP_ID)) == null) ? null : jsonElement3.getAsString(), str));
            JsonElement jsonElement6 = next;
            JsonArray asJsonArray2 = (jsonElement6 == null || (asJsonObject2 = jsonElement6.getAsJsonObject()) == null || (jsonElement2 = asJsonObject2.get(TtmlNode.TAG_METADATA)) == null) ? null : jsonElement2.getAsJsonArray();
            if (asJsonArray2 == null) {
                TmcLogger.c("TmcOfflineDownload: OfflineUtils", "verifyServerUrl: 没有查询到相关的配置信息");
                return false;
            }
            int i11 = 0;
            for (JsonElement jsonElement7 : asJsonArray2) {
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                JsonObject asJsonObject5 = jsonElement7.getAsJsonObject();
                if (Intrinsics.b((asJsonObject5 == null || (jsonElement = asJsonObject5.get("url")) == null) ? null : jsonElement.getAsString(), str2)) {
                    return i11 != -1;
                }
                i11++;
            }
            return false;
        } catch (Throwable th3) {
            TmcLogger.g("TmcOfflineDownload: OfflineUtils", "", th3);
            return false;
        }
    }

    public final boolean b(String str) {
        String whiteListStr;
        ArrayList arrayList;
        ArrayList arrayList2;
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            whiteListStr = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("miniOfflineDownloadDisableAntiShake", "[\"1000886706715795456\"]");
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineUtils", "checkMiniAppInDisableAntiShakeList failed!", th2);
            whiteListStr = "[\"1000886706715795456\"]";
        }
        try {
            Intrinsics.f(whiteListStr, "whiteListStr");
            Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.offline.download.utils.OfflineUtils$checkMiniAppInDisableAntiShakeList$whiteList$1
            }.getType();
            Intrinsics.f(type, "object : TypeToken<ArrayList<String>>() {}.type");
            arrayList2 = (ArrayList) TmcGsonUtils.e(whiteListStr, type);
        } catch (Throwable th3) {
            TmcLogger.h("TmcOfflineDownload: OfflineUtils", th3);
            try {
                Type type2 = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.offline.download.utils.OfflineUtils$checkMiniAppInDisableAntiShakeList$whiteList$2
                }.getType();
                Intrinsics.f(type2, "object : TypeToken<ArrayList<String>>() {}.type");
                arrayList = (ArrayList) TmcGsonUtils.e("[\"1000886706715795456\"]", type2);
            } catch (Throwable th4) {
                TmcLogger.g("TmcOfflineDownload: OfflineUtils", "", th4);
                arrayList = new ArrayList();
            }
            arrayList2 = arrayList;
        }
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "checkMiniAppInDisableAntiShakeList: 当前小程序是否在禁用离线加载防抖名单中：" + arrayList2.contains(str) + " 禁用名单：" + arrayList2);
        return arrayList2.contains(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean c(String str) {
        Context contextX = x();
        boolean zB = false;
        if (contextX == null) {
            return false;
        }
        String strG = NetworkUtil.g(contextX);
        Intrinsics.f(strG, "getDetailNetworkType(context)");
        if (str != null) {
            switch (str.hashCode()) {
                case -2069000991:
                    if (str.equals("onlyWifi")) {
                        zB = Intrinsics.b(strG, "WIFI");
                    }
                    break;
                case -1078030475:
                    if (str.equals("medium")) {
                        zB = Intrinsics.b(strG, "3G");
                    }
                    break;
                case -1012208801:
                    if (str.equals("only4g")) {
                        zB = Intrinsics.b(strG, "4G");
                    }
                    break;
                case -1012208770:
                    if (str.equals("only5g")) {
                        zB = Intrinsics.b(strG, "5G");
                    }
                    break;
                case -891980137:
                    if (str.equals("strong") && (Intrinsics.b(strG, "4G") || Intrinsics.b(strG, "5G") || Intrinsics.b(strG, "WIFI"))) {
                        zB = true;
                    }
                    break;
                case 3645304:
                    if (str.equals("weak")) {
                        zB = Intrinsics.b(strG, "2G");
                    }
                    break;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("checkNetwork: current:");
        sb2.append(strG);
        sb2.append(" target:");
        sb2.append(str);
        sb2.append(" 是否符合要求：");
        sb2.append(zB ? "符合" : "不符合");
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", sb2.toString());
        return zB;
    }

    public final boolean d(String str) {
        OffPkgConfigExtParams extParams;
        if (str == null || str.length() == 0) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "appId is null or empty");
            return false;
        }
        Context contextX = x();
        List<String> authorizedMiniApp = null;
        String packageName = contextX != null ? contextX.getPackageName() : null;
        if (packageName == null || packageName.length() == 0) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "packageName is null or empty");
            return false;
        }
        if (Intrinsics.b(str, packageName)) {
            return true;
        }
        OffPkgConfig offPkgConfigD = OfflineStoreCache.f32077a.d(packageName);
        if (offPkgConfigD != null && (extParams = offPkgConfigD.getExtParams()) != null) {
            authorizedMiniApp = extParams.getAuthorizedMiniApp();
        }
        if (authorizedMiniApp == null) {
            return false;
        }
        Iterator<String> it = authorizedMiniApp.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (StringsKt__StringsKt.O(it.next(), str, true)) {
                return i11 != -1;
            }
            i11++;
        }
        return false;
    }

    public final boolean e(String str, String str2) {
        ZipFileInfo zipFileInfo;
        Object next;
        OffPkgConfig manifest;
        if (str != null && str.length() != 0) {
            Context contextA = OfflineManager.A();
            String packageName = contextA != null ? contextA.getPackageName() : null;
            if (packageName != null && packageName.length() != 0) {
                OfflinePkgCachePath offlinePkgCachePathS = S(str2 == null ? str : str2, true);
                List<ZipFileInfo> zipFileInfo2 = offlinePkgCachePathS != null ? offlinePkgCachePathS.getZipFileInfo() : null;
                if (zipFileInfo2 != null) {
                    Iterator<T> it = zipFileInfo2.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        manifest = ((ZipFileInfo) next).getManifest();
                    } while (!Intrinsics.b(str, manifest != null ? manifest.getGroup() : null));
                    zipFileInfo = (ZipFileInfo) next;
                } else {
                    zipFileInfo = null;
                }
                String zipUnCompressPath = zipFileInfo != null ? zipFileInfo.getZipUnCompressPath() : null;
                if (zipUnCompressPath != null && zipUnCompressPath.length() != 0) {
                    return FileUtil.e(new File(zipUnCompressPath));
                }
                if (Intrinsics.b(str, packageName)) {
                    return false;
                }
                if ((str2 == null || str2.length() == 0) && !Intrinsics.b(str2, packageName)) {
                    return e(str, packageName);
                }
                return false;
            }
        }
        return false;
    }

    public final boolean g(String str) {
        ExtendModel extend;
        String offlinePackageVersion;
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "checkOfflinePackageVersion : appId: " + str);
        if (str == null || str.length() == 0) {
            return false;
        }
        if (!OfflineManager.y()) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "Checking offline package version is not enabled");
            return true;
        }
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "Current appId is: " + str);
        if (Intrinsics.b(str, "100000")) {
            return true;
        }
        AppModel appModelHasNotOffline = null;
        try {
            Context contextX = x();
            if (contextX != null) {
                appModelHasNotOffline = ((IAppInfoManagerProxy) tc.a.a(IAppInfoManagerProxy.class)).getAppModelHasNotOffline(contextX, lb.a.f70163b.a(str));
            }
        } catch (Exception e11) {
            TmcLogger.g("TmcOfflineDownload: OfflineUtils", "getAppModelHasNotOffline is failed", e11);
        }
        if (appModelHasNotOffline == null || (extend = appModelHasNotOffline.getExtend()) == null || (offlinePackageVersion = extend.getOfflinePackageVersion()) == null) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "checkOfflinePackageVersion: appInfo 中没有配置 offlinePackageVersion，则使用");
            return true;
        }
        OffPkgConfig offPkgConfigE = E(str);
        if (offPkgConfigE == null) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "checkOfflinePackageManifest: 读取不到 " + str + " 配置的离线包 manifest，不通过");
            return false;
        }
        String version = offPkgConfigE.getVersion();
        if (version == null) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "checkOfflinePackageVersion: 离线包 manifest 中没有配置 offlinePackageVersion，则不通过");
            return false;
        }
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "checkOfflinePackageVersion: offlinePackageVersion: " + offlinePackageVersion + " version: " + version);
        if (Intrinsics.b(offlinePackageVersion, version)) {
            return true;
        }
        return k(offlinePackageVersion, version);
    }

    public final boolean h(String str, String str2, String str3) {
        String str4;
        String strSubstring;
        List<String> paths;
        OffPkgConfigExtParams extParams;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "appId or url is empty!");
            return false;
        }
        Context contextX = x();
        String packageName = contextX != null ? contextX.getPackageName() : null;
        if (packageName == null || packageName.length() == 0) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "packageName is null or empty!");
            return false;
        }
        OffPkgConfig offPkgConfigE = OfflineStoreCache.f32077a.e(str3 == null ? str : str3);
        List<PackageInclude> packageInclude = (offPkgConfigE == null || (extParams = offPkgConfigE.getExtParams()) == null) ? null : extParams.getPackageInclude();
        if (l.u(str2, ".so", false, 2, null) && OfflineManager.W()) {
            String strD = l.D(str2, ".so", "@===.zip", true);
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "so file check replace success! url: " + strD);
            str4 = strD;
        } else {
            str4 = str2;
        }
        try {
            strSubstring = xb.e.d(l.F(str4, FileUtil.U(str) + '/', "", false, 4, null)).substring(0, 10);
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        } catch (Throwable unused) {
            strSubstring = "";
        }
        if (packageInclude != null) {
            for (PackageInclude packageInclude2 : packageInclude) {
                String appId = packageInclude2.getAppId();
                if (appId != null && StringsKt__StringsKt.O(appId, str, true) && (paths = packageInclude2.getPaths()) != null) {
                    Iterator<String> it = paths.iterator();
                    int i11 = 0;
                    while (it.hasNext()) {
                        if (l.v(it.next(), strSubstring, true)) {
                            if (i11 == -1) {
                                break;
                            }
                            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "file check success! url: " + str2);
                            return true;
                        }
                        i11++;
                    }
                }
            }
        }
        if (Intrinsics.b(str, packageName)) {
            return false;
        }
        if ((str3 == null || str3.length() == 0) && !Intrinsics.b(str3, packageName)) {
            return h(str, str2, packageName);
        }
        return false;
    }

    public final boolean j(OffPkgConfig offPkgConfig) {
        Intrinsics.g(offPkgConfig, "offPkgConfig");
        String group = offPkgConfig.getGroup();
        if (group == null || group.length() == 0) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "No group specified for package config");
            return false;
        }
        String networkType = offPkgConfig.getNetworkType();
        if (networkType == null || networkType.length() == 0) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "No networkType specified for package config");
            return false;
        }
        String pkgUrl = offPkgConfig.getPkgUrl();
        if (pkgUrl == null || pkgUrl.length() == 0) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "No pkgUrl specified for package config");
            return false;
        }
        String pkgEncrypted = offPkgConfig.getPkgEncrypted();
        if (pkgEncrypted != null && pkgEncrypted.length() != 0) {
            return true;
        }
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "No pkgEncrypted specified for package config");
        return false;
    }

    public final boolean k(String str, String str2) {
        try {
            String[] strArr = (String[]) new Regex("\\.").split(str, 0).toArray(new String[0]);
            String[] strArr2 = (String[]) new Regex("\\.").split(str2, 0).toArray(new String[0]);
            int iD = kotlin.ranges.a.d(strArr.length, strArr2.length);
            int i11 = 0;
            while (i11 < iD) {
                int i12 = Integer.parseInt(v(i11 < strArr.length ? strArr[i11] : "0"));
                int i13 = Integer.parseInt(v(i11 < strArr2.length ? strArr2[i11] : "0"));
                if (i13 < i12) {
                    return false;
                }
                if (i13 > i12) {
                    return true;
                }
                i11++;
            }
            return false;
        } catch (Exception e11) {
            TmcLogger.f("TmcOfflineDownload: OfflineUtils", e11.getMessage());
            return true;
        }
    }

    public final void l(String str, IOfflineResourceManagerProxy iOfflineResourceManagerProxy, List<? extends File> list, String str2) {
        for (File file : list) {
            if (file.isDirectory()) {
                File[] fileArrF = xb.b.f(file, false, null, 2, null);
                l(str, iOfflineResourceManagerProxy, kotlin.collections.g.o(Arrays.copyOf(fileArrF, fileArrF.length)), str2 + File.separator + file.getName());
            } else {
                String absolutePath = file.getAbsolutePath();
                Intrinsics.f(absolutePath, "file.absolutePath");
                String name = file.getName();
                Intrinsics.f(name, "file.name");
                TmcLogger.c("TmcOfflineDownload: OfflineUtils", "generateVUrl: fileName: " + file.getName() + ", vUrl: " + iOfflineResourceManagerProxy.generateVUrl(absolutePath, str, name, str2, true));
            }
        }
    }

    public final void m(OffPkgConfig offPkgConfig) {
        Intrinsics.g(offPkgConfig, "offPkgConfig");
        UpdateEntity updateEntityT = t(offPkgConfig);
        String version = offPkgConfig.getVersion();
        if (version == null) {
            version = "";
        }
        n(offPkgConfig.getGroup(), version, updateEntityT);
    }

    public final void n(String str, String version, UpdateEntity updateEntity) {
        List<PreloadResource> preloadResource;
        String zipUnCompressPath;
        Intrinsics.g(version, "version");
        TmcLogger.k("TmcOfflineDownload: OfflineUtils", "开始检查删除旧资源文件，group: " + str + ", version:" + version);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("开始检查删除旧资源文件，updateEntity: ");
        sb2.append(updateEntity);
        TmcLogger.k("TmcOfflineDownload: OfflineUtils", sb2.toString());
        if (str == null || updateEntity == null || (preloadResource = updateEntity.getPreloadResource()) == null) {
            return;
        }
        Iterator<T> it = preloadResource.iterator();
        while (it.hasNext()) {
            String staticZipUrl = ((PreloadResource) it.next()).getStaticZipUrl();
            if (staticZipUrl != null) {
                OfflineZipDownloadInfo offlineZipDownloadInfoI = OfflineStoreCache.f32077a.i(str, staticZipUrl);
                if (offlineZipDownloadInfoI.getStatus() > 2 && (zipUnCompressPath = offlineZipDownloadInfoI.getZipUnCompressPath()) != null && zipUnCompressPath.length() != 0) {
                    File file = new File(zipUnCompressPath);
                    if (FileUtil.c(file)) {
                        File[] fileArrF = xb.b.f(file, true, null, 2, null);
                        IOfflineResourceManagerProxy iOfflineResourceManagerProxy = (IOfflineResourceManagerProxy) tc.a.a(IOfflineResourceManagerProxy.class);
                        for (File file2 : fileArrF) {
                            if (iOfflineResourceManagerProxy != null) {
                                iOfflineResourceManagerProxy.removeByFilePath(file2.getAbsolutePath(), true);
                            }
                        }
                        boolean zN = com.cloud.tmc.miniutils.util.j.n(offlineZipDownloadInfoI.getZipUnCompressPath());
                        if (zN) {
                            offlineZipDownloadInfoI.setStatus(0);
                            OfflineStoreCache.f32077a.t(str, version, offlineZipDownloadInfoI);
                            TH5Update.f28868c.b(updateEntity);
                            ((OfflineAppProxy) tc.a.a(OfflineAppProxy.class)).scanForOfflineDownloadDelete();
                        }
                        TmcLogger.k("TmcOfflineDownload: OfflineUtils", "删除旧的文件资源结果为：" + zN + "，文件夹路径：" + offlineZipDownloadInfoI.getZipUnCompressPath());
                    }
                }
            }
        }
    }

    public final void o(OffPkgConfig newOffPkgConfig) {
        Intrinsics.g(newOffPkgConfig, "newOffPkgConfig");
        OfflineStoreCache offlineStoreCache = OfflineStoreCache.f32077a;
        OffPkgConfig offPkgConfigD = offlineStoreCache.d(newOffPkgConfig.getGroup());
        if (offPkgConfigD == null) {
            return;
        }
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "diff update offline pkg config before, extInfo: " + offPkgConfigD.getExtInfo() + " extParams: " + offPkgConfigD.getExtParams());
        offPkgConfigD.setExtInfo(newOffPkgConfig.getExtInfo());
        offPkgConfigD.setExtParams(newOffPkgConfig.getExtParams());
        offlineStoreCache.p(offPkgConfigD);
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "diff update offline pkg config after, extInfo: " + offPkgConfigD.getExtInfo() + " extParams: " + offPkgConfigD.getExtParams());
    }

    public final boolean p(String str) {
        UpdateEntity updateEntityT;
        String extraConfig;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        boolean asBoolean = false;
        if (str != null && str.length() != 0) {
            OffPkgConfig offPkgConfigD = OfflineStoreCache.f32077a.d(str);
            if (offPkgConfigD == null || (updateEntityT = t(offPkgConfigD)) == null || (extraConfig = updateEntityT.getExtraConfig()) == null) {
                return false;
            }
            JsonObject asJsonObject2 = null;
            try {
                JsonElement string = JsonParser.parseString(extraConfig);
                if (string != null) {
                    asJsonObject2 = string.getAsJsonObject();
                }
            } catch (Throwable th2) {
                TmcLogger.h("TmcOfflineDownload: OfflineUtils", th2);
            }
            if (asJsonObject2 == null) {
                return false;
            }
            try {
                JsonElement jsonElement2 = asJsonObject2.get("extParams");
                if (jsonElement2 != null && (asJsonObject = jsonElement2.getAsJsonObject()) != null && (jsonElement = asJsonObject.get("verifyServerFile")) != null) {
                    asBoolean = jsonElement.getAsBoolean();
                }
            } catch (Throwable th3) {
                TmcLogger.h("TmcOfflineDownload: OfflineUtils", th3);
            }
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "enableVerifyServerFile: 启用验证服务器文件开关 verifyServerFile=" + asBoolean);
        }
        return asBoolean;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004b  */
    /* JADX WARN: Code duplicated, block: B:22:0x006b  */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x004b, please report this as an issue */
    public final OfflineZipFileInfo q(OffPkgConfig offPkgConfig) {
        String zipDirPath;
        Intrinsics.g(offPkgConfig, "offPkgConfig");
        String type = offPkgConfig.getType();
        if (type == null) {
            TmcLogger.c("TmcOfflineDownload: OfflineUtils", "offline_pkg_manifest type is unknown");
            zipDirPath = ((PathProxy) tc.a.a(PathProxy.class)).getAppBaseDownloadPath(offPkgConfig.getGroup());
        } else {
            int iHashCode = type.hashCode();
            if (iHashCode != -1039745817) {
                if (iHashCode != 43564935) {
                    if (iHashCode == 1064526442 && type.equals("miniapp")) {
                        zipDirPath = ((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(offPkgConfig.getGroup()) + "/temp_data";
                    }
                } else if (type.equals("miniframework")) {
                    zipDirPath = ((PathProxy) tc.a.a(PathProxy.class)).getAppBaseDownloadPath(offPkgConfig.getGroup());
                }
                TmcLogger.c("TmcOfflineDownload: OfflineUtils", "offline_pkg_manifest type is unknown");
                zipDirPath = ((PathProxy) tc.a.a(PathProxy.class)).getAppBaseDownloadPath(offPkgConfig.getGroup());
            } else if (type.equals("normal")) {
                zipDirPath = ((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(offPkgConfig.getGroup()) + "/temp_data";
            } else {
                TmcLogger.c("TmcOfflineDownload: OfflineUtils", "offline_pkg_manifest type is unknown");
                zipDirPath = ((PathProxy) tc.a.a(PathProxy.class)).getAppBaseDownloadPath(offPkgConfig.getGroup());
            }
        }
        String str = zipDirPath + '/' + xb.e.d(offPkgConfig.getGroup());
        Intrinsics.f(zipDirPath, "zipDirPath");
        return new OfflineZipFileInfo(zipDirPath, str);
    }

    public final OffPkgConfig r(UpdateEntity updateEntity) {
        OffPkgConfig offPkgConfig = null;
        if (updateEntity != null) {
            String extraConfig = updateEntity.getExtraConfig();
            if (extraConfig != null) {
                Type type = new TypeToken<OffPkgConfig>() { // from class: com.cloud.tmc.offline.download.utils.OfflineUtils$generateOffPkgConfig$1$fromJson$1
                }.getType();
                Intrinsics.f(type, "object : TypeToken<OffPkgConfig>() {}.type");
                offPkgConfig = (OffPkgConfig) TmcGsonUtils.e(extraConfig, type);
            }
            if (offPkgConfig != null) {
                offPkgConfig.setGroup(updateEntity.getPackageName());
            }
            if (offPkgConfig != null) {
                offPkgConfig.setVersion(String.valueOf(updateEntity.getVersion()));
            }
            if (offPkgConfig != null) {
                offPkgConfig.setExtraConfig(o.a(updateEntity));
            }
        }
        return offPkgConfig;
    }

    public final String s() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append('_');
        sb2.append(kotlin.ranges.a.o(new IntRange(DefaultOggSeeker.MATCH_BYTE_RANGE, 999999), Random.Default));
        String string = sb2.toString();
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "Generating unique id: " + string);
        return string;
    }

    public final UpdateEntity t(OffPkgConfig offPkgConfig) {
        Intrinsics.g(offPkgConfig, "offPkgConfig");
        String extraConfig = offPkgConfig.getExtraConfig();
        if (extraConfig == null) {
            return null;
        }
        try {
            Type type = new TypeToken<UpdateEntity>() { // from class: com.cloud.tmc.offline.download.utils.OfflineUtils$generateUpdateEntity$1
            }.getType();
            Intrinsics.f(type, "object : TypeToken<UpdateEntity>() {}.type");
            return (UpdateEntity) TmcGsonUtils.e(extraConfig, type);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineUtils", "Exception json parse error", th2);
            return null;
        }
    }

    public final void u(String group, String zipUnCompressPath) {
        Intrinsics.g(group, "group");
        Intrinsics.g(zipUnCompressPath, "zipUnCompressPath");
        File[] fileArrF = xb.b.f(new File(zipUnCompressPath), false, null, 2, null);
        IOfflineResourceManagerProxy manager = (IOfflineResourceManagerProxy) tc.a.a(IOfflineResourceManagerProxy.class);
        Intrinsics.f(manager, "manager");
        l(group, manager, kotlin.collections.g.o(Arrays.copyOf(fileArrF, fileArrF.length)), "");
    }

    public final String v(String str) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (Character.isDigit(str.charAt(i11))) {
                sb2.append(str.charAt(i11));
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "builder.toString()");
        return string;
    }

    public final String w(String url) {
        Intrinsics.g(url, "url");
        List<String> listE0 = StringsKt__StringsKt.E0(url, new String[]{"_"}, false, 0, 6, null);
        str = "100000";
        if (!listE0.contains("100000")) {
            for (String str : listE0) {
                if (str.length() != 19 || !g.f32096a.c(str)) {
                }
            }
            str = "";
        }
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "[getAppId] url:" + url + ", targetAppId:" + str);
        return str;
    }

    public final Context x() {
        return OfflineManager.A();
    }

    public final UpdateEntity y(OffPkgConfig offPkgConfig, OffPkgConfig offPkgConfig2) {
        List<PreloadResource> preloadResource;
        List<PreloadResource> preloadResource2;
        List<PreloadResource> preloadResource3;
        List<PreloadResource> preloadResource4;
        UpdateEntity updateEntityT = t(offPkgConfig);
        UpdateEntity updateEntityT2 = t(offPkgConfig2);
        ArrayList arrayList = new ArrayList();
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "[getDiffUpdateEntity] newUpdateEntity:" + updateEntityT);
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "[getDiffUpdateEntity] oldUpdateEntity:" + updateEntityT2);
        if (updateEntityT != null && (preloadResource3 = updateEntityT.getPreloadResource()) != null) {
            for (PreloadResource preloadResource5 : preloadResource3) {
                OfflineUtils offlineUtils = f32081a;
                String url = preloadResource5.getUrl();
                if (url == null) {
                    url = "";
                }
                String strW = offlineUtils.w(url);
                if (updateEntityT2 != null && (preloadResource4 = updateEntityT2.getPreloadResource()) != null) {
                    for (PreloadResource preloadResource6 : preloadResource4) {
                        OfflineUtils offlineUtils2 = f32081a;
                        String url2 = preloadResource6.getUrl();
                        if (url2 == null) {
                            url2 = "";
                        }
                        if (Intrinsics.b(strW, offlineUtils2.w(url2)) && (!Intrinsics.b(preloadResource5.getEncryptedStaticZip(), preloadResource6.getEncryptedStaticZip()) || !Intrinsics.b(preloadResource5.getStaticZipUrl(), preloadResource6.getStaticZipUrl()) || !Intrinsics.b(preloadResource5.getVersion(), preloadResource6.getVersion()))) {
                            arrayList.add(preloadResource6);
                        }
                    }
                }
            }
        }
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "[getDiffUpdateEntity] 更新diffPreloadResource:" + arrayList);
        if (updateEntityT2 != null && (preloadResource = updateEntityT2.getPreloadResource()) != null) {
            for (PreloadResource preloadResource7 : preloadResource) {
                OfflineUtils offlineUtils3 = f32081a;
                String url3 = preloadResource7.getUrl();
                if (url3 == null) {
                    url3 = "";
                }
                String strW2 = offlineUtils3.w(url3);
                if (updateEntityT != null && (preloadResource2 = updateEntityT.getPreloadResource()) != null) {
                    boolean z11 = false;
                    for (PreloadResource preloadResource8 : preloadResource2) {
                        OfflineUtils offlineUtils4 = f32081a;
                        String url4 = preloadResource8.getUrl();
                        if (url4 == null) {
                            url4 = "";
                        }
                        if (Intrinsics.b(strW2, offlineUtils4.w(url4))) {
                            z11 = true;
                        }
                    }
                    if (!z11) {
                    }
                }
                arrayList.add(preloadResource7);
            }
        }
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "[getDiffUpdateEntity] 最终diffPreloadResource:" + arrayList);
        UpdateEntity updateEntity = new UpdateEntity(updateEntityT2 != null ? updateEntityT2.getExtraConfig() : null, updateEntityT2 != null ? updateEntityT2.getIgnoreCachedFiles() : null, updateEntityT2 != null ? updateEntityT2.getPackageName() : null, arrayList, updateEntityT2 != null ? updateEntityT2.getUpdateMode() : null, updateEntityT2 != null ? updateEntityT2.getVersion() : null);
        TmcLogger.c("TmcOfflineDownload: OfflineUtils", "[getDiffUpdateEntity] diffUpdateEntity:" + updateEntity);
        return updateEntity;
    }

    public final long z() {
        return OfflineManager.F();
    }
}
