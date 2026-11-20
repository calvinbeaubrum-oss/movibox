package com.transsion.push.bean;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
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
public enum MsgType {
    LOCAL_PUSH("1"),
    DOWNLOAD_PUSH("4"),
    PERMANENT("5"),
    TOP10_PUSH(PrepareException.ERROR_NO_URL),
    SUBJECT_SEEKING(PrepareException.ERROR_MINI_APPID),
    ONLINE_JSON_PUSH(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY);

    private final String type;

    MsgType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
