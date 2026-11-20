package com.transsion.baselib.db.video;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class ShortTvFavoriteState implements Serializable {
    private String favoriteNum;
    private String favoriteTime;
    private boolean hasFavorite;
    private String subjectId = "";

    public final String getFavoriteNum() {
        return this.favoriteNum;
    }

    public final String getFavoriteTime() {
        return this.favoriteTime;
    }

    public final boolean getHasFavorite() {
        return this.hasFavorite;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final void setFavoriteNum(String str) {
        this.favoriteNum = str;
    }

    public final void setFavoriteTime(String str) {
        this.favoriteTime = str;
    }

    public final void setHasFavorite(boolean z11) {
        this.hasFavorite = z11;
    }

    public final void setSubjectId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.subjectId = str;
    }
}
