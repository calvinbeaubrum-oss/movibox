package com.transsion.usercenter.setting.feedback.bean;

import java.io.Serializable;
import java.util.List;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RequestFeedbackEntity implements Serializable {
    private String content;
    private String email;
    private List<String> imageUrl;
    private String logId;
    private String pageName;
    private String subjectId;
    private String tempBucket;
    private String uid;
    private String whatsApp;

    public final String getContent() {
        return this.content;
    }

    public final String getEmail() {
        return this.email;
    }

    public final List<String> getImageUrl() {
        return this.imageUrl;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getTempBucket() {
        return this.tempBucket;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getWhatsApp() {
        return this.whatsApp;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final void setImageUrl(List<String> list) {
        this.imageUrl = list;
    }

    public final void setLogId(String str) {
        this.logId = str;
    }

    public final void setPageName(String str) {
        this.pageName = str;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setTempBucket(String str) {
        this.tempBucket = str;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public final void setWhatsApp(String str) {
        this.whatsApp = str;
    }
}
