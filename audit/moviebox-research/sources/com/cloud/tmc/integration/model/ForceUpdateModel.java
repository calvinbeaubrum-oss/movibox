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
public final class ForceUpdateModel extends b {
    private final String appId;
    private final String version;

    public ForceUpdateModel(String str, String str2) {
        this.appId = str;
        this.version = str2;
    }

    public static /* synthetic */ ForceUpdateModel copy$default(ForceUpdateModel forceUpdateModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = forceUpdateModel.appId;
        }
        if ((i11 & 2) != 0) {
            str2 = forceUpdateModel.version;
        }
        return forceUpdateModel.copy(str, str2);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.version;
    }

    public final ForceUpdateModel copy(String str, String str2) {
        return new ForceUpdateModel(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ForceUpdateModel)) {
            return false;
        }
        ForceUpdateModel forceUpdateModel = (ForceUpdateModel) obj;
        return Intrinsics.b(this.appId, forceUpdateModel.appId) && Intrinsics.b(this.version, forceUpdateModel.version);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.appId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.version;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ForceUpdateModel(appId=" + this.appId + ", version=" + this.version + ')';
    }
}
