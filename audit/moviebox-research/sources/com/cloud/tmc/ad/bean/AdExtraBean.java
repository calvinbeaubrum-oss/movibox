package com.cloud.tmc.ad.bean;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AdExtraBean implements Serializable {
    private String appId;
    private String sdkVersion;
    private boolean testMode;

    public AdExtraBean(String appId, boolean z11, String sdkVersion) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(sdkVersion, "sdkVersion");
        this.appId = appId;
        this.testMode = z11;
        this.sdkVersion = sdkVersion;
    }

    public static /* synthetic */ AdExtraBean copy$default(AdExtraBean adExtraBean, String str, boolean z11, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = adExtraBean.appId;
        }
        if ((i11 & 2) != 0) {
            z11 = adExtraBean.testMode;
        }
        if ((i11 & 4) != 0) {
            str2 = adExtraBean.sdkVersion;
        }
        return adExtraBean.copy(str, z11, str2);
    }

    public final String component1() {
        return this.appId;
    }

    public final boolean component2() {
        return this.testMode;
    }

    public final String component3() {
        return this.sdkVersion;
    }

    public final AdExtraBean copy(String appId, boolean z11, String sdkVersion) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(sdkVersion, "sdkVersion");
        return new AdExtraBean(appId, z11, sdkVersion);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdExtraBean)) {
            return false;
        }
        AdExtraBean adExtraBean = (AdExtraBean) obj;
        return Intrinsics.b(this.appId, adExtraBean.appId) && this.testMode == adExtraBean.testMode && Intrinsics.b(this.sdkVersion, adExtraBean.sdkVersion);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final boolean getTestMode() {
        return this.testMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = this.appId.hashCode() * 31;
        boolean z11 = this.testMode;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return ((iHashCode + r11) * 31) + this.sdkVersion.hashCode();
    }

    public final void setAppId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.appId = str;
    }

    public final void setSdkVersion(String str) {
        Intrinsics.g(str, "<set-?>");
        this.sdkVersion = str;
    }

    public final void setTestMode(boolean z11) {
        this.testMode = z11;
    }

    public String toString() {
        return "AdExtraBean(appId=" + this.appId + ", testMode=" + this.testMode + ", sdkVersion=" + this.sdkVersion + ')';
    }
}
