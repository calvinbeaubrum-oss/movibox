package com.cloud.tmc.offline.download.utils;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.x;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.miniutils.util.c0;
import com.cloud.tmc.miniutils.util.i;
import com.cloud.tmc.miniutils.util.j;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflineDownloadBuilder;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.cloud.tmc.offline.download.model.OfflineZipFileInfo;
import com.cloud.tmc.offline.download.model.PrePullAppInfo;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;
import okhttp3.Headers;

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
public final class PrePullAppInfoUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PrePullAppInfoUtils f32085a = new PrePullAppInfoUtils();

    public final void a(String zipUnCompressPath) {
        Intrinsics.g(zipUnCompressPath, "zipUnCompressPath");
        try {
            if (!j.x(zipUnCompressPath)) {
                TmcLogger.c("PrePullAppInfoUtils", "check cdnAppInfoFile is not exist, zipUnCompressPath: " + zipUnCompressPath);
                return;
            }
            for (File file : xb.b.e(new File(zipUnCompressPath), false, new Function1<File, Boolean>() { // from class: com.cloud.tmc.offline.download.utils.PrePullAppInfoUtils$checkCdnAppInfoFileAndDelete$listFiles$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(File it) {
                    Intrinsics.g(it, "it");
                    return Boolean.valueOf(!Intrinsics.b(xb.b.c(it), fd.a.a().get("zip")));
                }
            })) {
                if (file.exists()) {
                    TmcLogger.k("PrePullAppInfoUtils", "check cdnAppInfoFile delete " + xb.b.b(file) + ", file: " + file);
                }
            }
            TmcLogger.c("PrePullAppInfoUtils", "check cdnAppInfoFile finished");
        } catch (Throwable th2) {
            TmcLogger.g("PrePullAppInfoUtils", th2.getMessage(), th2);
        }
    }

    public final boolean b(Headers headers, Function1<? super String, Unit> block) {
        Intrinsics.g(headers, "headers");
        Intrinsics.g(block, "block");
        OffPkgConfig offPkgConfigE = e();
        String strF = f(headers, HttpHeaders.LAST_MODIFIED);
        TmcLogger.c("PrePullAppInfoUtils", "checkResponseHeader server lastModified: " + strF);
        if (strF == null || strF.length() == 0) {
            TmcLogger.c("PrePullAppInfoUtils", "checkResponseHeader server lastModify is null or empty");
            return false;
        }
        String strC = OfflineStoreCache.f32077a.c(offPkgConfigE);
        TmcLogger.c("PrePullAppInfoUtils", "checkResponseHeader local lastModify: " + strC);
        if (strC == null || strC.length() == 0) {
            TmcLogger.c("PrePullAppInfoUtils", "checkResponseHeader local lastModify is null or empty");
            block.invoke(strF);
            return false;
        }
        boolean zV = l.v(strF, strC, true);
        TmcLogger.c("PrePullAppInfoUtils", "checkResponseHeader 判断本地与服务端 LastModify 是否相同 : " + zV);
        if (!zV) {
            block.invoke(strF);
        }
        return zV;
    }

    public final String c(String str) {
        String strG = FileUtil.G(str);
        if (strG == null) {
            strG = ".zip";
        }
        String strC = xb.e.c(str != null ? xb.e.d(str) : null);
        if (strC == null) {
            strC = x.f31135a.a();
        }
        String strF = FileUtil.f(strC, strG);
        TmcLogger.c("PrePullAppInfoUtils", "Generating file name by url: " + strF);
        return strF;
    }

    public final File d(OffPkgConfig offPkgConfig) {
        Intrinsics.g(offPkgConfig, "offPkgConfig");
        OfflineZipFileInfo offlineZipFileInfoQ = OfflineUtils.f32081a.q(offPkgConfig);
        TmcLogger.c("PrePullAppInfoUtils", "Generating zip file info: " + offlineZipFileInfoQ);
        String zipCacheAbsolutePath = offlineZipFileInfoQ.getZipCacheAbsolutePath();
        try {
            if (j.j(zipCacheAbsolutePath)) {
                String strC = c(offPkgConfig.getPkgUrl());
                TmcLogger.c("PrePullAppInfoUtils", "Generating zip file name: " + strC);
                return new File(zipCacheAbsolutePath, strC);
            }
        } catch (Exception e11) {
            TmcLogger.g("PrePullAppInfoUtils", "Unable to create zip directory", e11);
        }
        TmcLogger.c("PrePullAppInfoUtils", "创建下载文件夹失败");
        return null;
    }

    public final OffPkgConfig e() {
        return new OfflineDownloadBuilder().setGroup("pre_pull_appInfo").setPkgUrl(OfflineManager.N()).setPriority(1).setDownloadModel("idle").setVersion("0.0.0").build();
    }

    public final String f(Headers headers, String name) {
        Intrinsics.g(headers, "<this>");
        Intrinsics.g(name, "name");
        try {
            String str = headers.get(name);
            if (str != null && str.length() != 0) {
                return str;
            }
            List<String> listValues = headers.values(name);
            return listValues.isEmpty() ^ true ? (String) CollectionsKt___CollectionsKt.g0(listValues) : str;
        } catch (Throwable th2) {
            TmcLogger.g("PrePullAppInfoUtils", "getHeaderIgnoreCase failed", th2);
            return null;
        }
    }

    public final boolean g() {
        OffPkgConfig offPkgConfigE = e();
        long j11 = OfflineStoreCache.f32077a.j(offPkgConfigE);
        long jCurrentTimeMillis = System.currentTimeMillis() - j11;
        boolean z11 = j11 <= 0 || jCurrentTimeMillis > OfflineManager.M();
        if (!z11) {
            long jB = c0.b();
            String strA = c0.a(jB, jB - jCurrentTimeMillis, 5);
            StringBuilder sb2 = new StringBuilder();
            String group = offPkgConfigE.getGroup();
            if (group == null) {
                group = "It";
            }
            sb2.append(group);
            sb2.append(" has only been ");
            sb2.append(strA);
            sb2.append(" since the last update or check");
            TmcLogger.c("PrePullAppInfoUtils", sb2.toString());
        }
        return z11;
    }

    public final boolean h() {
        return OfflineStoreCache.f32077a.h(e(), OfflineManager.N()).getStatus() >= 2;
    }

    public final boolean i() {
        return OfflineStoreCache.f32077a.h(e(), OfflineManager.N()).getStatus() == 5;
    }

    public final boolean j() {
        return OfflineStoreCache.f32077a.h(e(), OfflineManager.N()).getStatus() == 7;
    }

    public final ArrayList<PrePullAppInfo> k(String zipUnCompressPath, Function1<? super Throwable, Unit> function1) {
        Intrinsics.g(zipUnCompressPath, "zipUnCompressPath");
        if (!j.x(zipUnCompressPath)) {
            if (function1 != null) {
                function1.invoke(new IOException(zipUnCompressPath + " is not a directory"));
            }
            return null;
        }
        File file = new File(zipUnCompressPath, "allReleaseAppInfo.json");
        if (!FileUtil.c(file)) {
            if (function1 != null) {
                function1.invoke(new IOException(file.getAbsolutePath() + " is not exists"));
            }
            return null;
        }
        String strD = i.d(file, "UTF-8");
        Intrinsics.f(strD, "readFile2String(appInfoFile, \"UTF-8\")");
        try {
            Type type = new TypeToken<ArrayList<PrePullAppInfo>>() { // from class: com.cloud.tmc.offline.download.utils.PrePullAppInfoUtils$loadCdnAppInfo$1
            }.getType();
            Intrinsics.f(type, "object : TypeToken<Array…rePullAppInfo>>() {}.type");
            return (ArrayList) TmcGsonUtils.e(strD, type);
        } catch (Throwable th2) {
            TmcLogger.g("PrePullAppInfoUtils", "parse Json fail", th2);
            if (function1 == null) {
                return null;
            }
            function1.invoke(th2);
            return null;
        }
    }

    public final void l(OfflineZipDownloadInfo info) {
        Intrinsics.g(info, "info");
        OfflineStoreCache.f32077a.s(e(), info);
    }

    public final void m(File srcFile, String destFile, Function3<? super Boolean, ? super String, ? super Throwable, Unit> function3) {
        Intrinsics.g(srcFile, "srcFile");
        Intrinsics.g(destFile, "destFile");
        try {
            wb.a.b(srcFile, destFile);
            if (function3 != null) {
                function3.invoke(Boolean.TRUE, destFile, null);
            }
        } catch (Throwable th2) {
            TmcLogger.g("PrePullAppInfoUtils", "Unable to unzip file, " + srcFile, th2);
            if (function3 != null) {
                function3.invoke(Boolean.FALSE, destFile, th2);
            }
        }
    }
}
