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
public final class PermissionListModel extends b implements Serializable {
    private String scopeDescription;
    private String scopeName;

    /* JADX WARN: Multi-variable type inference failed */
    public PermissionListModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public PermissionListModel(String str, String str2) {
        this.scopeName = str;
        this.scopeDescription = str2;
    }

    public /* synthetic */ PermissionListModel(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }

    public static /* synthetic */ PermissionListModel copy$default(PermissionListModel permissionListModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = permissionListModel.scopeName;
        }
        if ((i11 & 2) != 0) {
            str2 = permissionListModel.scopeDescription;
        }
        return permissionListModel.copy(str, str2);
    }

    public final String component1() {
        return this.scopeName;
    }

    public final String component2() {
        return this.scopeDescription;
    }

    public final PermissionListModel copy(String str, String str2) {
        return new PermissionListModel(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionListModel)) {
            return false;
        }
        PermissionListModel permissionListModel = (PermissionListModel) obj;
        return Intrinsics.b(this.scopeName, permissionListModel.scopeName) && Intrinsics.b(this.scopeDescription, permissionListModel.scopeDescription);
    }

    public final String getScopeDescription() {
        return this.scopeDescription;
    }

    public final String getScopeName() {
        return this.scopeName;
    }

    public int hashCode() {
        String str = this.scopeName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.scopeDescription;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setScopeDescription(String str) {
        this.scopeDescription = str;
    }

    public final void setScopeName(String str) {
        this.scopeName = str;
    }

    public String toString() {
        return "PermissionListModel(scopeName=" + this.scopeName + ", scopeDescription=" + this.scopeDescription + ')';
    }
}
