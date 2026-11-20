package com.cloud.h5update.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class UpdateEntity {
    private final String extraConfig;
    private final String ignoreCachedFiles;
    private final String packageName;
    private final List<PreloadResource> preloadResource;
    private final Integer updateMode;
    private final Long version;

    public UpdateEntity() {
        this(null, null, null, null, null, null, 63, null);
    }

    public UpdateEntity(String str, String str2, String str3, List<PreloadResource> list, Integer num, Long l11) {
        this.extraConfig = str;
        this.ignoreCachedFiles = str2;
        this.packageName = str3;
        this.preloadResource = list;
        this.updateMode = num;
        this.version = l11;
    }

    public /* synthetic */ UpdateEntity(String str, String str2, String str3, List list, Integer num, Long l11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : list, (i11 & 16) != 0 ? null : num, (i11 & 32) != 0 ? null : l11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateEntity copy$default(UpdateEntity updateEntity, String str, String str2, String str3, List list, Integer num, Long l11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = updateEntity.extraConfig;
        }
        if ((i11 & 2) != 0) {
            str2 = updateEntity.ignoreCachedFiles;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            str3 = updateEntity.packageName;
        }
        String str5 = str3;
        if ((i11 & 8) != 0) {
            list = updateEntity.preloadResource;
        }
        List list2 = list;
        if ((i11 & 16) != 0) {
            num = updateEntity.updateMode;
        }
        Integer num2 = num;
        if ((i11 & 32) != 0) {
            l11 = updateEntity.version;
        }
        return updateEntity.copy(str, str4, str5, list2, num2, l11);
    }

    public final String component1() {
        return this.extraConfig;
    }

    public final String component2() {
        return this.ignoreCachedFiles;
    }

    public final String component3() {
        return this.packageName;
    }

    public final List<PreloadResource> component4() {
        return this.preloadResource;
    }

    public final Integer component5() {
        return this.updateMode;
    }

    public final Long component6() {
        return this.version;
    }

    public final UpdateEntity copy(String str, String str2, String str3, List<PreloadResource> list, Integer num, Long l11) {
        return new UpdateEntity(str, str2, str3, list, num, l11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateEntity)) {
            return false;
        }
        UpdateEntity updateEntity = (UpdateEntity) obj;
        return Intrinsics.b(this.extraConfig, updateEntity.extraConfig) && Intrinsics.b(this.ignoreCachedFiles, updateEntity.ignoreCachedFiles) && Intrinsics.b(this.packageName, updateEntity.packageName) && Intrinsics.b(this.preloadResource, updateEntity.preloadResource) && Intrinsics.b(this.updateMode, updateEntity.updateMode) && Intrinsics.b(this.version, updateEntity.version);
    }

    public final String getExtraConfig() {
        return this.extraConfig;
    }

    public final String getIgnoreCachedFiles() {
        return this.ignoreCachedFiles;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final List<PreloadResource> getPreloadResource() {
        return this.preloadResource;
    }

    public final Integer getUpdateMode() {
        return this.updateMode;
    }

    public final Long getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.extraConfig;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.ignoreCachedFiles;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.packageName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<PreloadResource> list = this.preloadResource;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.updateMode;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Long l11 = this.version;
        return iHashCode5 + (l11 != null ? l11.hashCode() : 0);
    }

    public String toString() {
        return "UpdateEntity(extraConfig=" + this.extraConfig + ", ignoreCachedFiles=" + this.ignoreCachedFiles + ", packageName=" + this.packageName + ", preloadResource=" + this.preloadResource + ", updateMode=" + this.updateMode + ", version=" + this.version + ')';
    }
}
