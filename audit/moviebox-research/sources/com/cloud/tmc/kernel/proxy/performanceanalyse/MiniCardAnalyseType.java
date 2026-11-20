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
public enum MiniCardAnalyseType implements c {
    START_UP("800", "startup", "卡片启动"),
    UPDATE_REQUEST("801", "update_request", "更新请求"),
    CARD_EXPOSURE("802", "card_exposure", "卡片曝光"),
    GO_TO_MY_BYTEAPP("803", "go_to_my_byteapp", "前往 My ByteApp"),
    LATEST_USE_EXPOSURE("804", "latest_use_exposure", "最近使用区域曝光"),
    LATEST_USE_CLICK("805", "latest_use_click", "最近使用小程序点击"),
    RECOMMEND_EXPOSURE("806", "recommend_exposure", "推荐区域曝光"),
    RECOMMEND_CLICK("807", "recommend_click", "推荐小程序点击");

    private final String objectId;
    private final String objectNameEn;
    private final String objectNameZh;

    MiniCardAnalyseType(String str, String str2, String str3) {
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
