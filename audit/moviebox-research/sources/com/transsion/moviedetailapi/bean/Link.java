package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.transsion.web.api.WebConstants;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class Link implements Serializable {

    @SerializedName("btn")
    private String btn;

    @SerializedName(WebConstants.FIELD_DEEPLINK)
    private String deeplink;

    @SerializedName(RewardPlus.ICON)
    private String icon;

    @SerializedName("image")
    private String image;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private String title;

    @SerializedName("url")
    private String url;

    public Link(String str, String str2, String str3, String str4, String str5, String str6) {
        this.url = str;
        this.deeplink = str2;
        this.icon = str3;
        this.title = str4;
        this.btn = str5;
        this.image = str6;
    }

    public static /* synthetic */ Link copy$default(Link link, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = link.url;
        }
        if ((i11 & 2) != 0) {
            str2 = link.deeplink;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = link.icon;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = link.title;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = link.btn;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = link.image;
        }
        return link.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.deeplink;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.btn;
    }

    public final String component6() {
        return this.image;
    }

    public final Link copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new Link(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Link)) {
            return false;
        }
        Link link = (Link) obj;
        return Intrinsics.b(this.url, link.url) && Intrinsics.b(this.deeplink, link.deeplink) && Intrinsics.b(this.icon, link.icon) && Intrinsics.b(this.title, link.title) && Intrinsics.b(this.btn, link.btn) && Intrinsics.b(this.image, link.image);
    }

    public final String getBtn() {
        return this.btn;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deeplink;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.btn;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.image;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setBtn(String str) {
        this.btn = str;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "Link(url=" + this.url + ", deeplink=" + this.deeplink + ", icon=" + this.icon + ", title=" + this.title + ", btn=" + this.btn + ", image=" + this.image + ")";
    }
}
