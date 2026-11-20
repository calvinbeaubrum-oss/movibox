package com.cloud.tmc.integration.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class PermissionAuthStatusModel extends b {
    private String appId;
    private Boolean authStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public PermissionAuthStatusModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public PermissionAuthStatusModel(String str, Boolean bool) {
        this.appId = str;
        this.authStatus = bool;
    }

    public /* synthetic */ PermissionAuthStatusModel(String str, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : bool);
    }

    public static /* synthetic */ PermissionAuthStatusModel copy$default(PermissionAuthStatusModel permissionAuthStatusModel, String str, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = permissionAuthStatusModel.appId;
        }
        if ((i11 & 2) != 0) {
            bool = permissionAuthStatusModel.authStatus;
        }
        return permissionAuthStatusModel.copy(str, bool);
    }

    public final String component1() {
        return this.appId;
    }

    public final Boolean component2() {
        return this.authStatus;
    }

    public final PermissionAuthStatusModel copy(String str, Boolean bool) {
        return new PermissionAuthStatusModel(str, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionAuthStatusModel)) {
            return false;
        }
        PermissionAuthStatusModel permissionAuthStatusModel = (PermissionAuthStatusModel) obj;
        return Intrinsics.b(this.appId, permissionAuthStatusModel.appId) && Intrinsics.b(this.authStatus, permissionAuthStatusModel.authStatus);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Boolean getAuthStatus() {
        return this.authStatus;
    }

    public int hashCode() {
        String str = this.appId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.authStatus;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setAuthStatus(Boolean bool) {
        this.authStatus = bool;
    }

    public String toString() {
        return "PermissionAuthStatusModel(appId=" + this.appId + ", authStatus=" + this.authStatus + ')';
    }
}
