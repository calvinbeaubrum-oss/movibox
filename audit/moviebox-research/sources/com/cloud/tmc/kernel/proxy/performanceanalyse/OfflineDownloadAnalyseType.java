package com.cloud.tmc.kernel.proxy.performanceanalyse;

import kotlin.Metadata;

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
public enum OfflineDownloadAnalyseType implements c {
    TASK_START("500", "task_start", "离线下载任务启动"),
    TASK_FAIL("501", "task_fail", "离线下载任务失败"),
    TASK_FINISH("502", "task_finish", "离线下载任务完成"),
    QUEUE_TIME("503", "queue_time", "离线包任务排队时长"),
    DOWNLOAD_TIME("504", "download_time", "离线包任务下载时长"),
    OFFLINE_PKG_API_USAGE_STATUS("505", "offline_pkg_api_usage_status", "离线包获取请求状态"),
    OFFLINE_RESOURCE_URL_CHANGE("506", "offline_resource_url_change", "离线资源服务端文件变化App重新启动"),
    OFFLINE_VERIFY_SERVER_FILE("507", "offline_verify_server_file", "离线资源校验服务端文件"),
    OFFLINE_RES_USAGE_STATUS("508", "offline_res_usage_status", "离线资源命中状态"),
    OFFLINE_PKG_USAGE_STATUS("509", "offline_pkg_usage_status", "离线小程序包命中状态"),
    OFFLINE_PKG_DOWNLOAD_STATUS("510", "offline_download_status", "离线资源包下载状态"),
    PREFETCH_CDN_APPINFO_STATUS("520", "prefetch_cdn_appinfo_status", "预拉取 CDN AppInfo 状态");

    private final String objectId;
    private final String objectNameEn;
    private final String objectNameZh;

    OfflineDownloadAnalyseType(String str, String str2, String str3) {
        this.objectId = str;
        this.objectNameEn = str2;
        this.objectNameZh = str3;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final String getObjectNameEn() {
        return this.objectNameEn;
    }

    public final String getObjectNameZh() {
        return this.objectNameZh;
    }
}
