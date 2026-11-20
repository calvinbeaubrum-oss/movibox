package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.moviedetailapi.DownloadItem;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class ResourceDetectors implements Serializable {

    @SerializedName("downloadUrl")
    private String downloadUrl;

    @SerializedName("extCaptions")
    private List<SubtitleItem> extSubtitle;

    @SerializedName("firstSize")
    private Long firstSize;

    @SerializedName("postId")
    private String postId;
    private transient Integer resolution;

    @SerializedName("resolutionList")
    private List<DownloadItem> resolutionList;

    @SerializedName("resourceId")
    private String resourceId;

    @SerializedName("resourceLink")
    private String resourceLink;

    @SerializedName("source")
    private String source;

    @SerializedName("totalEpisode")
    private Integer totalEpisode;

    @SerializedName("totalSize")
    private Long totalSize;

    @SerializedName("type")
    private Integer type;

    @SerializedName("uploadBy")
    private String uploadBy;

    @SerializedName("uploadTime")
    private String uploadTime;

    public ResourceDetectors() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public ResourceDetectors(Integer num, Integer num2, Long l11, String str, String str2, String str3, String str4, String str5, String str6, Long l12, String str7, List<SubtitleItem> list, List<DownloadItem> list2, Integer num3) {
        this.type = num;
        this.totalEpisode = num2;
        this.totalSize = l11;
        this.uploadTime = str;
        this.uploadBy = str2;
        this.resourceLink = str3;
        this.downloadUrl = str4;
        this.source = str5;
        this.resourceId = str6;
        this.firstSize = l12;
        this.postId = str7;
        this.extSubtitle = list;
        this.resolutionList = list2;
        this.resolution = num3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ResourceDetectors(Integer num, Integer num2, Long l11, String str, String str2, String str3, String str4, String str5, String str6, Long l12, String str7, List list, List list2, Integer num3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        Integer num4 = 0;
        this((i11 & 1) != 0 ? num4 : num, (i11 & 2) != 0 ? null : num2, (i11 & 4) != 0 ? null : l11, (i11 & 8) != 0 ? null : str, (i11 & 16) != 0 ? null : str2, (i11 & 32) != 0 ? null : str3, (i11 & 64) != 0 ? null : str4, (i11 & 128) != 0 ? null : str5, (i11 & 256) != 0 ? null : str6, (i11 & 512) != 0 ? null : l12, (i11 & 1024) != 0 ? null : str7, (i11 & 2048) != 0 ? null : list, (i11 & 4096) == 0 ? list2 : null, (i11 & 8192) == 0 ? num3 : 0);
    }

    public final Integer component1() {
        return this.type;
    }

    public final Long component10() {
        return this.firstSize;
    }

    public final String component11() {
        return this.postId;
    }

    public final List<SubtitleItem> component12() {
        return this.extSubtitle;
    }

    public final List<DownloadItem> component13() {
        return this.resolutionList;
    }

    public final Integer component14() {
        return this.resolution;
    }

    public final Integer component2() {
        return this.totalEpisode;
    }

    public final Long component3() {
        return this.totalSize;
    }

    public final String component4() {
        return this.uploadTime;
    }

    public final String component5() {
        return this.uploadBy;
    }

    public final String component6() {
        return this.resourceLink;
    }

    public final String component7() {
        return this.downloadUrl;
    }

    public final String component8() {
        return this.source;
    }

    public final String component9() {
        return this.resourceId;
    }

    public final ResourceDetectors copy(Integer num, Integer num2, Long l11, String str, String str2, String str3, String str4, String str5, String str6, Long l12, String str7, List<SubtitleItem> list, List<DownloadItem> list2, Integer num3) {
        return new ResourceDetectors(num, num2, l11, str, str2, str3, str4, str5, str6, l12, str7, list, list2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourceDetectors)) {
            return false;
        }
        ResourceDetectors resourceDetectors = (ResourceDetectors) obj;
        return Intrinsics.b(this.type, resourceDetectors.type) && Intrinsics.b(this.totalEpisode, resourceDetectors.totalEpisode) && Intrinsics.b(this.totalSize, resourceDetectors.totalSize) && Intrinsics.b(this.uploadTime, resourceDetectors.uploadTime) && Intrinsics.b(this.uploadBy, resourceDetectors.uploadBy) && Intrinsics.b(this.resourceLink, resourceDetectors.resourceLink) && Intrinsics.b(this.downloadUrl, resourceDetectors.downloadUrl) && Intrinsics.b(this.source, resourceDetectors.source) && Intrinsics.b(this.resourceId, resourceDetectors.resourceId) && Intrinsics.b(this.firstSize, resourceDetectors.firstSize) && Intrinsics.b(this.postId, resourceDetectors.postId) && Intrinsics.b(this.extSubtitle, resourceDetectors.extSubtitle) && Intrinsics.b(this.resolutionList, resourceDetectors.resolutionList) && Intrinsics.b(this.resolution, resourceDetectors.resolution);
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final List<SubtitleItem> getExtSubtitle() {
        return this.extSubtitle;
    }

    public final Long getFirstSize() {
        return this.firstSize;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final Integer getResolution() {
        return this.resolution;
    }

    public final List<DownloadItem> getResolutionList() {
        return this.resolutionList;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getResourceLink() {
        return this.resourceLink;
    }

    public final String getSource() {
        return this.source;
    }

    public final Integer getTotalEpisode() {
        return this.totalEpisode;
    }

    public final Long getTotalSize() {
        return this.totalSize;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getUploadBy() {
        return this.uploadBy;
    }

    public final String getUploadTime() {
        return this.uploadTime;
    }

    public int hashCode() {
        Integer num = this.type;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.totalEpisode;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l11 = this.totalSize;
        int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str = this.uploadTime;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uploadBy;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.resourceLink;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.downloadUrl;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.source;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.resourceId;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l12 = this.firstSize;
        int iHashCode10 = (iHashCode9 + (l12 == null ? 0 : l12.hashCode())) * 31;
        String str7 = this.postId;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<SubtitleItem> list = this.extSubtitle;
        int iHashCode12 = (iHashCode11 + (list == null ? 0 : list.hashCode())) * 31;
        List<DownloadItem> list2 = this.resolutionList;
        int iHashCode13 = (iHashCode12 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num3 = this.resolution;
        return iHashCode13 + (num3 != null ? num3.hashCode() : 0);
    }

    public final boolean isCollection() {
        Integer num = this.type;
        return num != null && num.intValue() == 1;
    }

    public final boolean isMultiResolution() {
        List<DownloadItem> list;
        Integer num = this.type;
        return (num == null || num.intValue() == 0) && (list = this.resolutionList) != null && (list.isEmpty() ^ true);
    }

    public final boolean isSingleResource() {
        List<DownloadItem> list;
        Integer num = this.type;
        return (num == null || num.intValue() == 0) && ((list = this.resolutionList) == null || list.isEmpty());
    }

    public final void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public final void setExtSubtitle(List<SubtitleItem> list) {
        this.extSubtitle = list;
    }

    public final void setFirstSize(Long l11) {
        this.firstSize = l11;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setResolution(Integer num) {
        this.resolution = num;
    }

    public final void setResolutionList(List<DownloadItem> list) {
        this.resolutionList = list;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final void setResourceLink(String str) {
        this.resourceLink = str;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final void setTotalEpisode(Integer num) {
        this.totalEpisode = num;
    }

    public final void setTotalSize(Long l11) {
        this.totalSize = l11;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final void setUploadBy(String str) {
        this.uploadBy = str;
    }

    public final void setUploadTime(String str) {
        this.uploadTime = str;
    }

    public String toString() {
        return "ResourceDetectors(type=" + this.type + ", totalEpisode=" + this.totalEpisode + ", totalSize=" + this.totalSize + ", uploadTime=" + this.uploadTime + ", uploadBy=" + this.uploadBy + ", resourceLink=" + this.resourceLink + ", downloadUrl=" + this.downloadUrl + ", source=" + this.source + ", resourceId=" + this.resourceId + ", firstSize=" + this.firstSize + ", postId=" + this.postId + ", extSubtitle=" + this.extSubtitle + ", resolutionList=" + this.resolutionList + ", resolution=" + this.resolution + ")";
    }
}
