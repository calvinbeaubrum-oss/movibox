package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class CoverUrl {
    private String coverUrl;
    private final int type;

    public CoverUrl(String str, int i11) {
        this.coverUrl = str;
        this.type = i11;
    }

    public static /* synthetic */ CoverUrl copy$default(CoverUrl coverUrl, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = coverUrl.coverUrl;
        }
        if ((i12 & 2) != 0) {
            i11 = coverUrl.type;
        }
        return coverUrl.copy(str, i11);
    }

    public final String component1() {
        return this.coverUrl;
    }

    public final int component2() {
        return this.type;
    }

    public final CoverUrl copy(String str, int i11) {
        return new CoverUrl(str, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoverUrl)) {
            return false;
        }
        CoverUrl coverUrl = (CoverUrl) obj;
        return Intrinsics.b(this.coverUrl, coverUrl.coverUrl) && this.type == coverUrl.type;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.coverUrl;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.type;
    }

    public final void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public String toString() {
        return "CoverUrl(coverUrl=" + this.coverUrl + ", type=" + this.type + ")";
    }
}
