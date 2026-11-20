package com.cloud.tupdate.bean;

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
    private final AppScoreContent appScoreContent;
    private final UpdateContent updateContent;

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateEntity() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public UpdateEntity(UpdateContent updateContent, AppScoreContent appScoreContent) {
        this.updateContent = updateContent;
        this.appScoreContent = appScoreContent;
    }

    public /* synthetic */ UpdateEntity(UpdateContent updateContent, AppScoreContent appScoreContent, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : updateContent, (i11 & 2) != 0 ? null : appScoreContent);
    }

    public static /* synthetic */ UpdateEntity copy$default(UpdateEntity updateEntity, UpdateContent updateContent, AppScoreContent appScoreContent, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            updateContent = updateEntity.updateContent;
        }
        if ((i11 & 2) != 0) {
            appScoreContent = updateEntity.appScoreContent;
        }
        return updateEntity.copy(updateContent, appScoreContent);
    }

    public final UpdateContent component1() {
        return this.updateContent;
    }

    public final AppScoreContent component2() {
        return this.appScoreContent;
    }

    public final UpdateEntity copy(UpdateContent updateContent, AppScoreContent appScoreContent) {
        return new UpdateEntity(updateContent, appScoreContent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateEntity)) {
            return false;
        }
        UpdateEntity updateEntity = (UpdateEntity) obj;
        return Intrinsics.b(this.updateContent, updateEntity.updateContent) && Intrinsics.b(this.appScoreContent, updateEntity.appScoreContent);
    }

    public final AppScoreContent getAppScoreContent() {
        return this.appScoreContent;
    }

    public final UpdateContent getUpdateContent() {
        return this.updateContent;
    }

    public int hashCode() {
        UpdateContent updateContent = this.updateContent;
        int iHashCode = (updateContent == null ? 0 : updateContent.hashCode()) * 31;
        AppScoreContent appScoreContent = this.appScoreContent;
        return iHashCode + (appScoreContent != null ? appScoreContent.hashCode() : 0);
    }

    public String toString() {
        return "UpdateEntity(updateContent=" + this.updateContent + ", appScoreContent=" + this.appScoreContent + ')';
    }
}
