package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Serializable;
import java.util.List;
import kotlin.Deprecated;
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
@Deprecated
@Keep
@Metadata
public final class ResolutionListBean implements Serializable {

    @SerializedName("resourceLink")
    private String downloadUrl;

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    @SerializedName("ep")
    private Integer f53881ep;

    @SerializedName("episode")
    private Integer episode;

    @SerializedName("extCaptions")
    private List<SubtitleItem> extCaptions;

    @SerializedName("linkType")
    private Integer linkType;

    @SerializedName("postId")
    private String postId;

    @SerializedName("resolution")
    private Integer resolution;

    @SerializedName("resourceId")
    private String resourceId;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    @SerializedName("se")
    private Integer f53882se;

    @SerializedName("size")
    private String size;

    @SerializedName("sourceUrl")
    private String sourceUrl;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private String title;

    @SerializedName("uploadBy")
    private String uploadBy;

    public ResolutionListBean(Integer num, String str, String str2, Integer num2, String str3, String str4, String str5, String str6, List<SubtitleItem> list, Integer num3, Integer num4, String str7, Integer num5) {
        this.episode = num;
        this.title = str;
        this.downloadUrl = str2;
        this.linkType = num2;
        this.size = str3;
        this.uploadBy = str4;
        this.resourceId = str5;
        this.postId = str6;
        this.extCaptions = list;
        this.f53882se = num3;
        this.f53881ep = num4;
        this.sourceUrl = str7;
        this.resolution = num5;
    }

    public final Integer component1() {
        return this.episode;
    }

    public final Integer component10() {
        return this.f53882se;
    }

    public final Integer component11() {
        return this.f53881ep;
    }

    public final String component12() {
        return this.sourceUrl;
    }

    public final Integer component13() {
        return this.resolution;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.downloadUrl;
    }

    public final Integer component4() {
        return this.linkType;
    }

    public final String component5() {
        return this.size;
    }

    public final String component6() {
        return this.uploadBy;
    }

    public final String component7() {
        return this.resourceId;
    }

    public final String component8() {
        return this.postId;
    }

    public final List<SubtitleItem> component9() {
        return this.extCaptions;
    }

    public final ResolutionListBean copy(Integer num, String str, String str2, Integer num2, String str3, String str4, String str5, String str6, List<SubtitleItem> list, Integer num3, Integer num4, String str7, Integer num5) {
        return new ResolutionListBean(num, str, str2, num2, str3, str4, str5, str6, list, num3, num4, str7, num5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolutionListBean)) {
            return false;
        }
        ResolutionListBean resolutionListBean = (ResolutionListBean) obj;
        return Intrinsics.b(this.episode, resolutionListBean.episode) && Intrinsics.b(this.title, resolutionListBean.title) && Intrinsics.b(this.downloadUrl, resolutionListBean.downloadUrl) && Intrinsics.b(this.linkType, resolutionListBean.linkType) && Intrinsics.b(this.size, resolutionListBean.size) && Intrinsics.b(this.uploadBy, resolutionListBean.uploadBy) && Intrinsics.b(this.resourceId, resolutionListBean.resourceId) && Intrinsics.b(this.postId, resolutionListBean.postId) && Intrinsics.b(this.extCaptions, resolutionListBean.extCaptions) && Intrinsics.b(this.f53882se, resolutionListBean.f53882se) && Intrinsics.b(this.f53881ep, resolutionListBean.f53881ep) && Intrinsics.b(this.sourceUrl, resolutionListBean.sourceUrl) && Intrinsics.b(this.resolution, resolutionListBean.resolution);
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final Integer getEp() {
        return this.f53881ep;
    }

    public final Integer getEpisode() {
        return this.episode;
    }

    public final List<SubtitleItem> getExtCaptions() {
        return this.extCaptions;
    }

    public final Integer getLinkType() {
        return this.linkType;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final Integer getResolution() {
        return this.resolution;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final Integer getSe() {
        return this.f53882se;
    }

    public final String getSize() {
        return this.size;
    }

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUploadBy() {
        return this.uploadBy;
    }

    public int hashCode() {
        Integer num = this.episode;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.downloadUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.linkType;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.size;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.uploadBy;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.resourceId;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.postId;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<SubtitleItem> list = this.extCaptions;
        int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num3 = this.f53882se;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f53881ep;
        int iHashCode11 = (iHashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str7 = this.sourceUrl;
        int iHashCode12 = (iHashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num5 = this.resolution;
        return iHashCode12 + (num5 != null ? num5.hashCode() : 0);
    }

    public final void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public final void setEp(Integer num) {
        this.f53881ep = num;
    }

    public final void setEpisode(Integer num) {
        this.episode = num;
    }

    public final void setExtCaptions(List<SubtitleItem> list) {
        this.extCaptions = list;
    }

    public final void setLinkType(Integer num) {
        this.linkType = num;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setResolution(Integer num) {
        this.resolution = num;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final void setSe(Integer num) {
        this.f53882se = num;
    }

    public final void setSize(String str) {
        this.size = str;
    }

    public final void setSourceUrl(String str) {
        this.sourceUrl = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setUploadBy(String str) {
        this.uploadBy = str;
    }

    public String toString() {
        return "ResolutionListBean(episode=" + this.episode + ", title=" + this.title + ", downloadUrl=" + this.downloadUrl + ", linkType=" + this.linkType + ", size=" + this.size + ", uploadBy=" + this.uploadBy + ", resourceId=" + this.resourceId + ", postId=" + this.postId + ", extCaptions=" + this.extCaptions + ", se=" + this.f53882se + ", ep=" + this.f53881ep + ", sourceUrl=" + this.sourceUrl + ", resolution=" + this.resolution + ")";
    }
}
