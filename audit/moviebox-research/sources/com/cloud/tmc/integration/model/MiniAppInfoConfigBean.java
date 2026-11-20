package com.cloud.tmc.integration.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
public final class MiniAppInfoConfigBean extends b {
    private String appId;
    private AppInfoModel appInfo;

    public MiniAppInfoConfigBean(String str, AppInfoModel appInfoModel) {
        this.appId = str;
        this.appInfo = appInfoModel;
    }

    public static /* synthetic */ MiniAppInfoConfigBean copy$default(MiniAppInfoConfigBean miniAppInfoConfigBean, String str, AppInfoModel appInfoModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = miniAppInfoConfigBean.appId;
        }
        if ((i11 & 2) != 0) {
            appInfoModel = miniAppInfoConfigBean.appInfo;
        }
        return miniAppInfoConfigBean.copy(str, appInfoModel);
    }

    public final String component1() {
        return this.appId;
    }

    public final AppInfoModel component2() {
        return this.appInfo;
    }

    public final MiniAppInfoConfigBean copy(String str, AppInfoModel appInfoModel) {
        return new MiniAppInfoConfigBean(str, appInfoModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniAppInfoConfigBean)) {
            return false;
        }
        MiniAppInfoConfigBean miniAppInfoConfigBean = (MiniAppInfoConfigBean) obj;
        return Intrinsics.b(this.appId, miniAppInfoConfigBean.appId) && Intrinsics.b(this.appInfo, miniAppInfoConfigBean.appInfo);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final AppInfoModel getAppInfo() {
        return this.appInfo;
    }

    public int hashCode() {
        String str = this.appId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        AppInfoModel appInfoModel = this.appInfo;
        return iHashCode + (appInfoModel != null ? appInfoModel.hashCode() : 0);
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setAppInfo(AppInfoModel appInfoModel) {
        this.appInfo = appInfoModel;
    }

    public String toString() {
        return "MiniAppInfoConfigBean(appId=" + this.appId + ", appInfo=" + this.appInfo + ')';
    }
}
