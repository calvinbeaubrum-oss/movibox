package com.transsion.publish.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class StaffEntity implements Serializable {
    private String avatarUrl;
    private String character;
    private String name;
    private String releaseDate;
    private Integer staffType;

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getCharacter() {
        return this.character;
    }

    public final String getName() {
        return this.name;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final Integer getStaffType() {
        return this.staffType;
    }

    public final void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public final void setCharacter(String str) {
        this.character = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public final void setStaffType(Integer num) {
        this.staffType = num;
    }
}
