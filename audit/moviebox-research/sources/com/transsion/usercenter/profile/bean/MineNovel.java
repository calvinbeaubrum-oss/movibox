package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.Serializable;
import java.util.List;
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
public final class MineNovel implements Serializable {
    private String buttonText;

    @SerializedName("buttonUrl")
    private String deeplink;

    @SerializedName(TrackingKey.DESCRIPTION)
    private String des;

    @SerializedName(RewardPlus.ICON)
    private String icUrl;
    private List<MineNovelItem> subItems;
    private String title;

    public MineNovel(String str, String str2, String str3, String str4, String str5, List<MineNovelItem> list) {
        this.title = str;
        this.des = str2;
        this.icUrl = str3;
        this.deeplink = str4;
        this.buttonText = str5;
        this.subItems = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MineNovel copy$default(MineNovel mineNovel, String str, String str2, String str3, String str4, String str5, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = mineNovel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = mineNovel.des;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = mineNovel.icUrl;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = mineNovel.deeplink;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = mineNovel.buttonText;
        }
        String str9 = str5;
        if ((i11 & 32) != 0) {
            list = mineNovel.subItems;
        }
        return mineNovel.copy(str, str6, str7, str8, str9, list);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.des;
    }

    public final String component3() {
        return this.icUrl;
    }

    public final String component4() {
        return this.deeplink;
    }

    public final String component5() {
        return this.buttonText;
    }

    public final List<MineNovelItem> component6() {
        return this.subItems;
    }

    public final MineNovel copy(String str, String str2, String str3, String str4, String str5, List<MineNovelItem> list) {
        return new MineNovel(str, str2, str3, str4, str5, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MineNovel)) {
            return false;
        }
        MineNovel mineNovel = (MineNovel) obj;
        return Intrinsics.b(this.title, mineNovel.title) && Intrinsics.b(this.des, mineNovel.des) && Intrinsics.b(this.icUrl, mineNovel.icUrl) && Intrinsics.b(this.deeplink, mineNovel.deeplink) && Intrinsics.b(this.buttonText, mineNovel.buttonText) && Intrinsics.b(this.subItems, mineNovel.subItems);
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getDes() {
        return this.des;
    }

    public final String getIcUrl() {
        return this.icUrl;
    }

    public final List<MineNovelItem> getSubItems() {
        return this.subItems;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.des;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.deeplink;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.buttonText;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<MineNovelItem> list = this.subItems;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setDes(String str) {
        this.des = str;
    }

    public final void setIcUrl(String str) {
        this.icUrl = str;
    }

    public final void setSubItems(List<MineNovelItem> list) {
        this.subItems = list;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "MineNovel(title=" + this.title + ", des=" + this.des + ", icUrl=" + this.icUrl + ", deeplink=" + this.deeplink + ", buttonText=" + this.buttonText + ", subItems=" + this.subItems + ")";
    }
}
