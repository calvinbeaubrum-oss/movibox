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
public final class PermissionInfoModel extends b {
    private Boolean authStatus;
    private Long authTimeStamp;
    private String scopeDescription;
    private String scopeName;
    private Long validityTime;

    public PermissionInfoModel(String str, String str2, Long l11, Boolean bool, Long l12) {
        this.scopeName = str;
        this.scopeDescription = str2;
        this.authTimeStamp = l11;
        this.authStatus = bool;
        this.validityTime = l12;
    }

    public static /* synthetic */ PermissionInfoModel copy$default(PermissionInfoModel permissionInfoModel, String str, String str2, Long l11, Boolean bool, Long l12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = permissionInfoModel.scopeName;
        }
        if ((i11 & 2) != 0) {
            str2 = permissionInfoModel.scopeDescription;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            l11 = permissionInfoModel.authTimeStamp;
        }
        Long l13 = l11;
        if ((i11 & 8) != 0) {
            bool = permissionInfoModel.authStatus;
        }
        Boolean bool2 = bool;
        if ((i11 & 16) != 0) {
            l12 = permissionInfoModel.validityTime;
        }
        return permissionInfoModel.copy(str, str3, l13, bool2, l12);
    }

    public final String component1() {
        return this.scopeName;
    }

    public final String component2() {
        return this.scopeDescription;
    }

    public final Long component3() {
        return this.authTimeStamp;
    }

    public final Boolean component4() {
        return this.authStatus;
    }

    public final Long component5() {
        return this.validityTime;
    }

    public final PermissionInfoModel copy(String str, String str2, Long l11, Boolean bool, Long l12) {
        return new PermissionInfoModel(str, str2, l11, bool, l12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionInfoModel)) {
            return false;
        }
        PermissionInfoModel permissionInfoModel = (PermissionInfoModel) obj;
        return Intrinsics.b(this.scopeName, permissionInfoModel.scopeName) && Intrinsics.b(this.scopeDescription, permissionInfoModel.scopeDescription) && Intrinsics.b(this.authTimeStamp, permissionInfoModel.authTimeStamp) && Intrinsics.b(this.authStatus, permissionInfoModel.authStatus) && Intrinsics.b(this.validityTime, permissionInfoModel.validityTime);
    }

    public final Boolean getAuthStatus() {
        return this.authStatus;
    }

    public final Long getAuthTimeStamp() {
        return this.authTimeStamp;
    }

    public final String getScopeDescription() {
        return this.scopeDescription;
    }

    public final String getScopeName() {
        return this.scopeName;
    }

    public final Long getValidityTime() {
        return this.validityTime;
    }

    public int hashCode() {
        String str = this.scopeName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.scopeDescription;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l11 = this.authTimeStamp;
        int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Boolean bool = this.authStatus;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l12 = this.validityTime;
        return iHashCode4 + (l12 != null ? l12.hashCode() : 0);
    }

    public final void setAuthStatus(Boolean bool) {
        this.authStatus = bool;
    }

    public final void setAuthTimeStamp(Long l11) {
        this.authTimeStamp = l11;
    }

    public final void setScopeDescription(String str) {
        this.scopeDescription = str;
    }

    public final void setScopeName(String str) {
        this.scopeName = str;
    }

    public final void setValidityTime(Long l11) {
        this.validityTime = l11;
    }

    public String toString() {
        return "PermissionInfoModel(scopeName=" + this.scopeName + ", scopeDescription=" + this.scopeDescription + ", authTimeStamp=" + this.authTimeStamp + ", authStatus=" + this.authStatus + ", validityTime=" + this.validityTime + ')';
    }
}
