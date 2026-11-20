package com.transsion.moviedetailapi.bean;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public enum MediaType {
    TEXT("NONE"),
    IMAGE("IMAGE"),
    IMAGE_SINGLE("IMAGE_SINGLE"),
    AUDIO("AUDIO"),
    VIDEO("VIDEO"),
    GIF("GIF"),
    SUBJECT_DETAIL_NATIVE_AD("SUBJECT_DETAIL_NATIVE_AD"),
    POST_DETAIL_FOR_YOU_NATIVE_AD("POST_DETAIL_FOR_YOU_NATIVE_AD"),
    CONTENT_ALL("CONTENT_ALL"),
    ROOM_LIST("ROOM_LIST");

    private final String value;

    MediaType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
