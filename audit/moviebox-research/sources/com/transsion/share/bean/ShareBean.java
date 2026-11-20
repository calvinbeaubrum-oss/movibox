package com.transsion.share.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
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
public final class ShareBean {
    private ShareType shareType;

    @SerializedName("url")
    private String shortUrl;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private String title = "";

    @SerializedName(CampaignEx.JSON_KEY_DESC)
    private String desc = "";

    @SerializedName("downUrl")
    private String downUrl = "";

    @SerializedName("coverUrl")
    private String coverUrl = "";

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDownUrl() {
        return this.downUrl;
    }

    public final ShareType getShareType() {
        return this.shareType;
    }

    public final String getShortUrl() {
        return this.shortUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setCoverUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.coverUrl = str;
    }

    public final void setDesc(String str) {
        Intrinsics.g(str, "<set-?>");
        this.desc = str;
    }

    public final void setDownUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.downUrl = str;
    }

    public final void setShareType(ShareType shareType) {
        this.shareType = shareType;
    }

    public final void setShortUrl(String str) {
        this.shortUrl = str;
    }

    public final void setTitle(String str) {
        Intrinsics.g(str, "<set-?>");
        this.title = str;
    }
}
