package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.RewardPlus;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class MineNovelItem implements Serializable {

    @SerializedName("url")
    private String deeplink;

    @SerializedName(RewardPlus.ICON)
    private String icUrl;
    private String title;

    public MineNovelItem(String str, String str2, String str3) {
        this.title = str;
        this.deeplink = str2;
        this.icUrl = str3;
    }

    public static /* synthetic */ MineNovelItem copy$default(MineNovelItem mineNovelItem, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = mineNovelItem.title;
        }
        if ((i11 & 2) != 0) {
            str2 = mineNovelItem.deeplink;
        }
        if ((i11 & 4) != 0) {
            str3 = mineNovelItem.icUrl;
        }
        return mineNovelItem.copy(str, str2, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.deeplink;
    }

    public final String component3() {
        return this.icUrl;
    }

    public final MineNovelItem copy(String str, String str2, String str3) {
        return new MineNovelItem(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MineNovelItem)) {
            return false;
        }
        MineNovelItem mineNovelItem = (MineNovelItem) obj;
        return Intrinsics.b(this.title, mineNovelItem.title) && Intrinsics.b(this.deeplink, mineNovelItem.deeplink) && Intrinsics.b(this.icUrl, mineNovelItem.icUrl);
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getIcUrl() {
        return this.icUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deeplink;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icUrl;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setIcUrl(String str) {
        this.icUrl = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "MineNovelItem(title=" + this.title + ", deeplink=" + this.deeplink + ", icUrl=" + this.icUrl + ")";
    }
}
