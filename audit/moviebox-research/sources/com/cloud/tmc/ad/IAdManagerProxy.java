package com.cloud.tmc.ad;

import com.cloud.tmc.ad.bean.response.AdsDTO;
import com.cloud.tmc.integration.structure.App;
import ia.b;
import kotlin.Metadata;
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
@c("com.cloud.tmc.miniapp.ad.AdManager")
public interface IAdManagerProxy {
    void applicationDestroy();

    void close(String str, App app);

    void fillingInterstitial(String str, AdsDTO adsDTO, String str2, String str3, App app, b bVar);

    String getAdSdkFrameworkVersion();

    long getAdSdkFrameworkVersionInt();

    void onCreate(App app);

    void onDestroy(String str);

    void showInterstitial(String str, App app, AdsDTO adsDTO, ia.c cVar);
}
