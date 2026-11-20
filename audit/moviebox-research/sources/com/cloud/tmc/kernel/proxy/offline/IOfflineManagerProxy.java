package com.cloud.tmc.kernel.proxy.offline;

import com.google.gson.JsonObject;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import zb.c;

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
@c("com.cloud.tmc.miniapp.defaultimpl.TmcOfflineManagerProxyImpl")
public interface IOfflineManagerProxy {
    void downloadPkg(String str, String str2, String str3, String str4, String str5, String str6, Function1<? super JsonObject, Unit> function1);

    void downloadPkgFromPlatform(String str, boolean z11);

    boolean enableVerifyServerFile(String str);

    void getOfflinePkgCachePath(String str, String str2, Function1<? super JsonObject, Unit> function1);

    File getOfflineResources(String str, String str2);

    boolean verifyServerFile(String str, String str2);
}
