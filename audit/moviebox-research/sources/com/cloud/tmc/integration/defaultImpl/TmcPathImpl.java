package com.cloud.tmc.integration.defaultImpl;

import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.miniutils.util.r;
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
public final class TmcPathImpl implements PathProxy {
    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getAppBaseDownloadPath(String str) {
        return getRootDownloadPath() + '/' + str;
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getAppBaseFilePath(String str) {
        return getRootFilePath() + '/' + str;
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getBaseMiniAppPath(String str) {
        return getRootMiniAppPath() + '/' + str;
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getDownloadPath(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        return getAppBaseDownloadPath(appModel.getAppId()) + '/' + appModel.getPackageUrl_MD5();
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getDownloadPath(AppModel appModel, String str) {
        Intrinsics.g(appModel, "appModel");
        return getAppBaseDownloadPath(appModel.getAppId()) + '/' + str;
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getIDEDevelopPath(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        return getRootIDEDevelopPath() + '/' + appModel.getAppId();
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getRootDownloadPath() {
        return r.c() + "/byteapp_download";
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getRootFilePath() {
        return r.c() + "/byteapp_files";
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getRootIDEDevelopPath() {
        return r.b() + "/develop";
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getRootMiniAppPath() {
        return r.c() + "/mini";
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getRootSOPath() {
        return r.c() + "/so";
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getRootStoragePath() {
        return r.f() + "/mmkv";
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getTarPath(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        return getTarPath(appModel.getAppId(), appModel.getPackageUrl_MD5(), appModel.getAppId());
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getTarPath(String str, String str2, String str3) {
        return getZipUnCompressPath(str, str2) + '/' + str3 + ".tar";
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getTarUnCompressPath(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        if (appModel.getDevMode() == 2) {
            return getIDEDevelopPath(appModel);
        }
        return getBaseMiniAppPath(appModel.getAppId()) + '/' + appModel.getPackageUrl_MD5();
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getTarUnCompressPath(AppModel appModel, String str) {
        Intrinsics.g(appModel, "appModel");
        if (appModel.getDevMode() == 2) {
            return getIDEDevelopPath(appModel);
        }
        return getBaseMiniAppPath(appModel.getAppId()) + '/' + str;
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getZipPath(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        return getAppBaseDownloadPath(appModel.getAppId()) + '/' + appModel.getPackageUrl_MD5() + '/' + appModel.getPackageUrl_MD5() + ".zip";
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getZipUnCompressPath(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        return getZipUnCompressPath(appModel.getAppId(), appModel.getPackageUrl_MD5());
    }

    @Override // com.cloud.tmc.integration.proxy.PathProxy
    public String getZipUnCompressPath(String str, String str2) {
        return getAppBaseDownloadPath(str) + '/' + str2 + "/unzip";
    }
}
