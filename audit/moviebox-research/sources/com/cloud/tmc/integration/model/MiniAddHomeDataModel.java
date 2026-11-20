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
public final class MiniAddHomeDataModel extends b {
    private final String appId;
    private String appLogoUrl;
    private final String appName;

    public MiniAddHomeDataModel(String appId, String appName, String str) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(appName, "appName");
        this.appId = appId;
        this.appName = appName;
        this.appLogoUrl = str;
    }

    public static /* synthetic */ MiniAddHomeDataModel copy$default(MiniAddHomeDataModel miniAddHomeDataModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = miniAddHomeDataModel.appId;
        }
        if ((i11 & 2) != 0) {
            str2 = miniAddHomeDataModel.appName;
        }
        if ((i11 & 4) != 0) {
            str3 = miniAddHomeDataModel.appLogoUrl;
        }
        return miniAddHomeDataModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.appName;
    }

    public final String component3() {
        return this.appLogoUrl;
    }

    public final MiniAddHomeDataModel copy(String appId, String appName, String str) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(appName, "appName");
        return new MiniAddHomeDataModel(appId, appName, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniAddHomeDataModel)) {
            return false;
        }
        MiniAddHomeDataModel miniAddHomeDataModel = (MiniAddHomeDataModel) obj;
        return Intrinsics.b(this.appId, miniAddHomeDataModel.appId) && Intrinsics.b(this.appName, miniAddHomeDataModel.appName) && Intrinsics.b(this.appLogoUrl, miniAddHomeDataModel.appLogoUrl);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppLogoUrl() {
        return this.appLogoUrl;
    }

    public final String getAppName() {
        return this.appName;
    }

    public int hashCode() {
        int iHashCode = ((this.appId.hashCode() * 31) + this.appName.hashCode()) * 31;
        String str = this.appLogoUrl;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setAppLogoUrl(String str) {
        this.appLogoUrl = str;
    }

    public String toString() {
        return "MiniAddHomeDataModel(appId=" + this.appId + ", appName=" + this.appName + ", appLogoUrl=" + this.appLogoUrl + ')';
    }
}
