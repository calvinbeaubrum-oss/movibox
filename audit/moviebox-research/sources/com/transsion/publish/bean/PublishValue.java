package com.transsion.publish.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class PublishValue implements Serializable {
    private int fileType;
    private int progress;
    private int state;
    private String uploadUrl = "";

    public PublishValue(int i11) {
        this.fileType = i11;
    }

    public final int getFileType() {
        return this.fileType;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getState() {
        return this.state;
    }

    public final String getUploadUrl() {
        return this.uploadUrl;
    }

    public final void setFileType(int i11) {
        this.fileType = i11;
    }

    public final void setProgress(int i11) {
        this.progress = i11;
    }

    public final void setState(int i11) {
        this.state = i11;
    }

    public final void setUploadUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.uploadUrl = str;
    }
}
