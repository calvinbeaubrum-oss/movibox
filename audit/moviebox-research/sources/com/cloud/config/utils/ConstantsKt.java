package com.cloud.config.utils;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ConstantsKt {
    public static final String CONTENT_MD5 = "content-md5";
    public static final int ERROR_1000 = 1000;
    public static final String ERROR_1000_MESSAGE = "data is null";
    public static final int ERROR_1001 = 1001;
    public static final String ERROR_1001_MESSAGE = "code isn't 0";
    public static final int ERROR_1002 = 1002;
    public static final String ERROR_1002_MESSAGE = "gateway failure";
    public static final int ERROR_1003 = 1003;
    public static final String ERROR_1003_MESSAGE = "try catch exception";
    public static final int ERROR_1004 = 1004;
    public static final String ERROR_1004_MESSAGE = "request failure";
    public static final int ERROR_1005 = 1005;
    public static final String ERROR_1005_MESSAGE = "request is null";

    public static final String toStoreConfigName(String str) {
        Intrinsics.g(str, "<this>");
        return Intrinsics.p("config_", str);
    }

    public static final String toStoreConfigUrlName(String str) {
        Intrinsics.g(str, "<this>");
        return "config_" + str + "_url";
    }

    public static final String toStoreMd5Name(String str) {
        Intrinsics.g(str, "<this>");
        return "config_" + str + "_md5";
    }
}
