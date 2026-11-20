package com.cloud.tmc.offline.download.utils;

import android.content.Context;
import android.os.Bundle;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.OfflineDownloadAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.offline.download.OfflineManager;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.s;
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
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f32092a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ArrayList<HashMap<String, Object>>> f32093b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ArrayList<HashMap<String, Object>>> f32094c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, HashMap<String, Object>> f32095d = new ConcurrentHashMap<>();

    public final void a(String str) {
        ArrayList<HashMap<String, Object>> arrayListRemove;
        if (str != null) {
            try {
                if (str.length() == 0 || (arrayListRemove = f32094c.remove(str)) == null) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("offline_pkg_appId", str);
                bundle.putString("offline_pkg_data", o.a(arrayListRemove));
                TmcLogger.k("TmcOfflineDownload: TrackReportUtils", "reportDownloadRecord: " + bundle);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(str, OfflineDownloadAnalyseType.OFFLINE_PKG_DOWNLOAD_STATUS, "", bundle);
            } catch (Throwable th2) {
                TmcLogger.g("TmcOfflineDownload: TrackReportUtils", "reportDownloadRecord", th2);
            }
        }
    }

    public final void b(String str, boolean z11) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    return;
                }
                Bundle bundle = new Bundle();
                OfflineDownloadAnalyseType offlineDownloadAnalyseType = OfflineDownloadAnalyseType.OFFLINE_PKG_USAGE_STATUS;
                bundle.putInt(offlineDownloadAnalyseType.getObjectNameEn(), z11 ? 1 : 0);
                bundle.putString("offline_pkg_appId", str);
                TmcLogger.k("TmcOfflineDownload: TrackReportUtils", "reportMiniAppPackage: " + bundle);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(str, offlineDownloadAnalyseType, "", bundle);
            } catch (Throwable th2) {
                TmcLogger.g("TmcOfflineDownload: TrackReportUtils", "reportMiniAppPackage", th2);
            }
        }
    }

    public final void c() {
        try {
            ConcurrentHashMap<String, HashMap<String, Object>> concurrentHashMap = f32095d;
            if (concurrentHashMap.isEmpty()) {
                TmcLogger.c("TmcOfflineDownload: TrackReportUtils", "reportPrePullCdnRecord 数据记录为 empty 不允许上报");
                return;
            }
            Bundle bundle = new Bundle();
            for (Map.Entry<String, HashMap<String, Object>> entry : concurrentHashMap.entrySet()) {
                String key = entry.getKey();
                HashMap<String, Object> value = entry.getValue();
                bundle.putString(key, value != null ? o.a(value) : null);
            }
            f32095d.clear();
            TmcLogger.k("TmcOfflineDownload: TrackReportUtils", "reportPrePullCdnRecord: " + bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("renderWarmup", OfflineDownloadAnalyseType.PREFETCH_CDN_APPINFO_STATUS, "", bundle);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: TrackReportUtils", "reportPrePullCdnRecord", th2);
        }
    }

    public final void d(String str) {
        ArrayList<HashMap<String, Object>> arrayListRemove;
        if (str != null) {
            try {
                if (str.length() == 0 || (arrayListRemove = f32093b.remove(str)) == null) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("offline_pkg_appId", str);
                bundle.putString("offline_pkg_data", o.a(arrayListRemove));
                TmcLogger.k("TmcOfflineDownload: TrackReportUtils", "reportResourceRecord: " + bundle);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(str, OfflineDownloadAnalyseType.OFFLINE_RES_USAGE_STATUS, "", bundle);
            } catch (Throwable th2) {
                TmcLogger.g("TmcOfflineDownload: TrackReportUtils", "reportResourceRecord", th2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0043  */
    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    public final void e(String str, String str2, boolean z11, Integer num, String str3, long j11) {
        String str4;
        String packageName;
        if (str == null || str.length() == 0) {
            return;
        }
        ConcurrentHashMap<String, ArrayList<HashMap<String, Object>>> concurrentHashMap = f32094c;
        ArrayList<HashMap<String, Object>> arrayList = concurrentHashMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            concurrentHashMap.put(str, arrayList);
        }
        Context contextA = OfflineManager.A();
        if (contextA != null && (packageName = contextA.getPackageName()) != null && packageName.length() > 0) {
            Context contextA2 = OfflineManager.A();
            if (Intrinsics.b(str, contextA2 != null ? contextA2.getPackageName() : null)) {
                str4 = "sdk";
            } else if (str.length() > 0) {
                str4 = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
            } else {
                str4 = "other";
            }
        } else if (str.length() > 0) {
            str4 = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
        } else {
            str4 = "other";
        }
        arrayList.add(s.j(TuplesKt.a(OfflineDownloadAnalyseType.OFFLINE_PKG_DOWNLOAD_STATUS.getObjectNameEn(), Integer.valueOf(z11 ? 1 : 0)), TuplesKt.a("offline_pkg_url", str2), TuplesKt.a("offline_pkg_consume_time", Long.valueOf(j11)), TuplesKt.a("offline_pkg_channel", str4), TuplesKt.a("offline_pkg_error_code", num), TuplesKt.a("offline_pkg_error_msg", str3)));
    }

    public final void f(String currentStep, String previousStep, int i11, String str, String str2, String str3) {
        Intrinsics.g(currentStep, "currentStep");
        Intrinsics.g(previousStep, "previousStep");
        int iHashCode = currentStep.hashCode();
        if (iHashCode == -1707681637) {
            if (currentStep.equals("step_download")) {
                f32095d.put("step_download", s.j(TuplesKt.a("download_status", Integer.valueOf(i11)), TuplesKt.a("url", str), TuplesKt.a(TrackingKey.ERROR_CODE, str2), TuplesKt.a("error_msg", str3), TuplesKt.a("previous_step", previousStep), TuplesKt.a("force_refresh", Boolean.valueOf(OfflineManager.a0()))));
            }
        } else if (iHashCode == -1257948288) {
            if (currentStep.equals("step_parse")) {
                f32095d.put("step_parse", s.j(TuplesKt.a("parse_status", Integer.valueOf(i11)), TuplesKt.a("url", str), TuplesKt.a(TrackingKey.ERROR_CODE, str2), TuplesKt.a("error_msg", str3), TuplesKt.a("previous_step", previousStep), TuplesKt.a("force_refresh", Boolean.valueOf(OfflineManager.a0()))));
            }
        } else if (iHashCode == -1252936011 && currentStep.equals("step_unzip")) {
            f32095d.put("step_unzip", s.j(TuplesKt.a("unzip_status", Integer.valueOf(i11)), TuplesKt.a("url", str), TuplesKt.a(TrackingKey.ERROR_CODE, str2), TuplesKt.a("error_msg", str3), TuplesKt.a("previous_step", previousStep), TuplesKt.a("force_refresh", Boolean.valueOf(OfflineManager.a0()))));
        }
    }

    public final void g(String str, boolean z11, String str2) {
        if (str == null || str.length() == 0) {
            return;
        }
        ConcurrentHashMap<String, ArrayList<HashMap<String, Object>>> concurrentHashMap = f32093b;
        ArrayList<HashMap<String, Object>> arrayList = concurrentHashMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            concurrentHashMap.put(str, arrayList);
        }
        arrayList.add(s.j(TuplesKt.a(OfflineDownloadAnalyseType.OFFLINE_RES_USAGE_STATUS.getObjectNameEn(), Integer.valueOf(z11 ? 1 : 0)), TuplesKt.a("offline_pkg_url", str2)));
    }
}
