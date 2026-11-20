package com.cloud.tmc.offline.download.utils;

import android.content.Context;
import android.util.Log;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class OfflineStoreCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfflineStoreCache f32077a = new OfflineStoreCache();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, OffPkgConfig> f32078b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, Long> f32079c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f32080d = xb.e.d("offline");

    public final Context a() {
        return OfflineManager.A();
    }

    public final KVStorageProxy b() {
        return (KVStorageProxy) tc.a.a(KVStorageProxy.class);
    }

    public final String c(OffPkgConfig config) {
        Intrinsics.g(config, "config");
        String group = config.getGroup();
        if (group == null || group.length() == 0) {
            k("offPkgConfig group is null!", true);
            return null;
        }
        String str = group + config.getVersion() + "_last_modify";
        Context contextA = a();
        if (contextA != null) {
            return f32077a.b().getString(contextA, group, xb.e.d(str));
        }
        return null;
    }

    public final OffPkgConfig d(String str) {
        String string;
        if (str == null || str.length() == 0) {
            k("offPkgConfig group is null!", true);
            return null;
        }
        String str2 = str + "offline_pkg_config";
        Context contextA = a();
        if (contextA == null || (string = f32077a.b().getString(contextA, str, xb.e.d(str2))) == null || string.length() == 0) {
            return null;
        }
        Type type = new TypeToken<OffPkgConfig>() { // from class: com.cloud.tmc.offline.download.utils.OfflineStoreCache$getOfflinePkgConfigCache$1
        }.getType();
        Intrinsics.f(type, "object : TypeToken<OffPkgConfig>() {}.type");
        return (OffPkgConfig) TmcGsonUtils.e(string, type);
    }

    public final OffPkgConfig e(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap<String, OffPkgConfig> map = f32078b;
        OffPkgConfig offPkgConfig = map.get(str);
        HashMap<String, Long> map2 = f32079c;
        Long l11 = map2.get(str);
        if (l11 == null) {
            l11 = 0L;
        }
        long jLongValue = l11.longValue();
        if (offPkgConfig != null && jCurrentTimeMillis - jLongValue <= OfflineManager.I()) {
            return offPkgConfig;
        }
        OffPkgConfig offPkgConfigD = d(str);
        if (offPkgConfigD != null) {
            map.put(str, offPkgConfigD);
        }
        map2.put(str, Long.valueOf(jCurrentTimeMillis));
        TmcLogger.c("TmcOfflineDownload: OfflineStoreCache", "offlinePkgConfigMemoryCache 内存失效，从缓存中读取，" + offPkgConfigD);
        return offPkgConfigD;
    }

    public final int f() {
        Context contextA = a();
        if (contextA != null) {
            return f32077a.b().getInt(contextA, f32080d, "vUrlFileSize");
        }
        return 0;
    }

    public final String g(String key) {
        Intrinsics.g(key, "key");
        Context contextA = a();
        if (contextA == null) {
            return null;
        }
        return f32077a.b().getString(contextA, f32080d, "vUrlFile_" + key);
    }

    public final OfflineZipDownloadInfo h(OffPkgConfig config, String url) {
        Intrinsics.g(config, "config");
        Intrinsics.g(url, "url");
        return i(config.getGroup(), url);
    }

    public final OfflineZipDownloadInfo i(String str, String url) {
        String string;
        Intrinsics.g(url, "url");
        if (str == null || str.length() == 0) {
            return new OfflineZipDownloadInfo(null, null, 0, null, 15, null);
        }
        String str2 = str + url + "_download_state";
        Context contextA = a();
        if (contextA == null || (string = f32077a.b().getString(contextA, str, xb.e.d(str2))) == null) {
            return new OfflineZipDownloadInfo(null, null, 0, null, 15, null);
        }
        try {
            Type type = new TypeToken<OfflineZipDownloadInfo>() { // from class: com.cloud.tmc.offline.download.utils.OfflineStoreCache$getZipDownloadStatus$1
            }.getType();
            Intrinsics.f(type, "object : TypeToken<Offli…ipDownloadInfo>() {}.type");
            return (OfflineZipDownloadInfo) TmcGsonUtils.e(string, type);
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: OfflineStoreCache", "Exception json parse error", th2);
            return new OfflineZipDownloadInfo(null, null, 0, null, 15, null);
        }
    }

    public final long j(OffPkgConfig config) {
        Intrinsics.g(config, "config");
        String group = config.getGroup();
        if (group == null || group.length() == 0) {
            k("offPkgConfig group is null!", true);
            return 0L;
        }
        String str = group + config.getVersion() + "_last_update_time";
        Context contextA = a();
        if (contextA != null) {
            return f32077a.b().getLong(contextA, group, xb.e.d(str));
        }
        return 0L;
    }

    public final void k(String str, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(' ');
        sb2.append(z11 ? Log.getStackTraceString(new Throwable("Just Print")) : "");
        TmcLogger.c("TmcOfflineDownload: OfflineStoreCache", sb2.toString());
    }

    public final void l(String key) {
        Intrinsics.g(key, "key");
        Context contextA = a();
        if (contextA != null) {
            f32077a.b().remove(contextA, f32080d, "vUrlFile_" + key);
        }
    }

    public final void m(OffPkgConfig config, String lastModify) {
        Intrinsics.g(config, "config");
        Intrinsics.g(lastModify, "lastModify");
        String group = config.getGroup();
        if (group == null || group.length() == 0) {
            k("offPkgConfig group is null!", true);
            return;
        }
        String str = group + config.getVersion() + "_last_modify";
        Context contextA = a();
        if (contextA != null) {
            f32077a.b().putString(contextA, group, xb.e.d(str), lastModify);
        }
    }

    public final void n(OffPkgConfig config) {
        Intrinsics.g(config, "config");
        String group = config.getGroup();
        if (group == null) {
            group = "";
        }
        String version = config.getVersion();
        o(group, version != null ? version : "");
    }

    public final void o(String group, String version) {
        Intrinsics.g(group, "group");
        Intrinsics.g(version, "version");
        if (group.length() == 0) {
            k("offPkgConfig group is null!", true);
            return;
        }
        String str = group + version + "_last_update_time";
        Context contextA = a();
        if (contextA != null) {
            f32077a.b().putLong(contextA, group, xb.e.d(str), System.currentTimeMillis());
        }
    }

    public final void p(OffPkgConfig offPkgConfig) {
        String group = offPkgConfig != null ? offPkgConfig.getGroup() : null;
        if (group == null || group.length() == 0) {
            k("offPkgConfig group is null!", true);
            return;
        }
        String str = group + "offline_pkg_config";
        Context contextA = a();
        if (contextA != null) {
            f32077a.b().putString(contextA, group, xb.e.d(str), o.a(offPkgConfig));
        }
    }

    public final void q(int i11) {
        Context contextA = a();
        if (contextA != null) {
            f32077a.b().putInt(contextA, f32080d, "vUrlFileSize", i11);
        }
    }

    public final void r(String key, String value) {
        Intrinsics.g(key, "key");
        Intrinsics.g(value, "value");
        Context contextA = a();
        if (contextA != null) {
            f32077a.b().putString(contextA, f32080d, "vUrlFile_" + key, value);
        }
    }

    public final void s(OffPkgConfig config, OfflineZipDownloadInfo info) {
        Intrinsics.g(config, "config");
        Intrinsics.g(info, "info");
        String group = config.getGroup();
        String version = config.getVersion();
        if (version == null) {
            version = "";
        }
        t(group, version, info);
    }

    public final void t(String str, String version, OfflineZipDownloadInfo info) {
        Intrinsics.g(version, "version");
        Intrinsics.g(info, "info");
        String url = info.getUrl();
        if (str == null || str.length() == 0 || url == null || url.length() == 0) {
            k("offPkgConfig group or info url is null!", true);
            return;
        }
        OfflineZipDownloadInfo offlineZipDownloadInfoI = i(str, url);
        offlineZipDownloadInfoI.setUrl(info.getUrl());
        offlineZipDownloadInfoI.setZipUnCompressPath(info.getZipUnCompressPath());
        offlineZipDownloadInfoI.setStatus(info.getStatus());
        offlineZipDownloadInfoI.setManifest(info.getManifest());
        String str2 = str + url + "_download_state";
        Context contextA = a();
        if (contextA != null) {
            f32077a.b().putString(contextA, str, xb.e.d(str2), o.a(offlineZipDownloadInfoI));
        }
        if (offlineZipDownloadInfoI.getStatus() == 2) {
            o(str, version);
        }
    }
}
