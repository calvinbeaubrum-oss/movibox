package com.cloud.tmc.integration.model;

import java.io.Serializable;
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
public final class PermissionAppInfoModel extends b implements Serializable {
    private String appId;
    private String appLogo;
    private String appName;
    private Boolean authStatus;
    private Long authTime;
    private String scopeName;

    public PermissionAppInfoModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public PermissionAppInfoModel(String str, String str2, String str3, String str4, Long l11, Boolean bool) {
        this.appId = str;
        this.scopeName = str2;
        this.appName = str3;
        this.appLogo = str4;
        this.authTime = l11;
        this.authStatus = bool;
    }

    public /* synthetic */ PermissionAppInfoModel(String str, String str2, String str3, String str4, Long l11, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) == 0 ? str4 : null, (i11 & 16) != 0 ? 0L : l11, (i11 & 32) != 0 ? Boolean.TRUE : bool);
    }

    public static /* synthetic */ PermissionAppInfoModel copy$default(PermissionAppInfoModel permissionAppInfoModel, String str, String str2, String str3, String str4, Long l11, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = permissionAppInfoModel.appId;
        }
        if ((i11 & 2) != 0) {
            str2 = permissionAppInfoModel.scopeName;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = permissionAppInfoModel.appName;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            str4 = permissionAppInfoModel.appLogo;
        }
        String str7 = str4;
        if ((i11 & 16) != 0) {
            l11 = permissionAppInfoModel.authTime;
        }
        Long l12 = l11;
        if ((i11 & 32) != 0) {
            bool = permissionAppInfoModel.authStatus;
        }
        return permissionAppInfoModel.copy(str, str5, str6, str7, l12, bool);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.scopeName;
    }

    public final String component3() {
        return this.appName;
    }

    public final String component4() {
        return this.appLogo;
    }

    public final Long component5() {
        return this.authTime;
    }

    public final Boolean component6() {
        return this.authStatus;
    }

    public final PermissionAppInfoModel copy(String str, String str2, String str3, String str4, Long l11, Boolean bool) {
        return new PermissionAppInfoModel(str, str2, str3, str4, l11, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionAppInfoModel)) {
            return false;
        }
        PermissionAppInfoModel permissionAppInfoModel = (PermissionAppInfoModel) obj;
        return Intrinsics.b(this.appId, permissionAppInfoModel.appId) && Intrinsics.b(this.scopeName, permissionAppInfoModel.scopeName) && Intrinsics.b(this.appName, permissionAppInfoModel.appName) && Intrinsics.b(this.appLogo, permissionAppInfoModel.appLogo) && Intrinsics.b(this.authTime, permissionAppInfoModel.authTime) && Intrinsics.b(this.authStatus, permissionAppInfoModel.authStatus);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppLogo() {
        return this.appLogo;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Boolean getAuthStatus() {
        return this.authStatus;
    }

    public final Long getAuthTime() {
        return this.authTime;
    }

    public final String getScopeName() {
        return this.scopeName;
    }

    public int hashCode() {
        String str = this.appId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.scopeName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.appName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.appLogo;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l11 = this.authTime;
        int iHashCode5 = (iHashCode4 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Boolean bool = this.authStatus;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setAppLogo(String str) {
        this.appLogo = str;
    }

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final void setAuthStatus(Boolean bool) {
        this.authStatus = bool;
    }

    public final void setAuthTime(Long l11) {
        this.authTime = l11;
    }

    public final void setScopeName(String str) {
        this.scopeName = str;
    }

    public String toString() {
        return "PermissionAppInfoModel(appId=" + this.appId + ", scopeName=" + this.scopeName + ", appName=" + this.appName + ", appLogo=" + this.appLogo + ", authTime=" + this.authTime + ", authStatus=" + this.authStatus + ')';
    }
}
