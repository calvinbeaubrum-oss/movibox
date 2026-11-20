package com.cloud.tmc.integration.model;

import android.os.Bundle;
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
public final class LauncherPreDataModel extends b {
    private String appId;
    private Bundle bundle;
    private String schemeUrl;

    public LauncherPreDataModel(String str, String str2, Bundle bundle) {
        this.appId = str;
        this.schemeUrl = str2;
        this.bundle = bundle;
    }

    public static /* synthetic */ LauncherPreDataModel copy$default(LauncherPreDataModel launcherPreDataModel, String str, String str2, Bundle bundle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = launcherPreDataModel.appId;
        }
        if ((i11 & 2) != 0) {
            str2 = launcherPreDataModel.schemeUrl;
        }
        if ((i11 & 4) != 0) {
            bundle = launcherPreDataModel.bundle;
        }
        return launcherPreDataModel.copy(str, str2, bundle);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.schemeUrl;
    }

    public final Bundle component3() {
        return this.bundle;
    }

    public final LauncherPreDataModel copy(String str, String str2, Bundle bundle) {
        return new LauncherPreDataModel(str, str2, bundle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LauncherPreDataModel)) {
            return false;
        }
        LauncherPreDataModel launcherPreDataModel = (LauncherPreDataModel) obj;
        return Intrinsics.b(this.appId, launcherPreDataModel.appId) && Intrinsics.b(this.schemeUrl, launcherPreDataModel.schemeUrl) && Intrinsics.b(this.bundle, launcherPreDataModel.bundle);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final String getSchemeUrl() {
        return this.schemeUrl;
    }

    public int hashCode() {
        String str = this.appId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.schemeUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Bundle bundle = this.bundle;
        return iHashCode2 + (bundle != null ? bundle.hashCode() : 0);
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public final void setSchemeUrl(String str) {
        this.schemeUrl = str;
    }

    public String toString() {
        return "LauncherPreDataModel(appId=" + this.appId + ", schemeUrl=" + this.schemeUrl + ", bundle=" + this.bundle + ')';
    }
}
