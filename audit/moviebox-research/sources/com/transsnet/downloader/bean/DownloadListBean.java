package com.transsnet.downloader.bean;

import androidx.annotation.Keep;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.gson.annotations.SerializedName;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.DownloadResolutionItem;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class DownloadListBean implements Serializable {
    private String countryName;

    @SerializedName("cover")
    private Cover cover;

    @SerializedName(TrackingKey.DESCRIPTION)
    private String description;

    @SerializedName("durationSeconds")
    private Integer durationSeconds;
    private transient int endPosition;

    @SerializedName("genre")
    private String genre;

    @SerializedName("groupId")
    private String groupId;

    @SerializedName("list")
    private List<DownloadItem> items;
    private transient boolean loadMore;

    @SerializedName("pager")
    private Pager pager;

    @SerializedName(RequestParameters.POSITION)
    private Integer position;
    private String releaseDate;

    @SerializedName("resolution")
    private Integer resolution;

    @SerializedName("collectionResolutions")
    private List<DownloadResolutionItem> resolutionList;

    @SerializedName("favInfo")
    private ShortTVFavInfo shortTVFavInfo;
    private transient int startPosition;

    @SerializedName("subjectId")
    private String subjectId;

    @SerializedName("subjectTitle")
    private String subjectTitle;

    @SerializedName("subjectType")
    private int subjectType;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private String title;

    @SerializedName("totalEpisode")
    private Integer totalEpisode;

    public DownloadListBean(List<DownloadItem> list, Pager pager, Cover cover, String str, String str2, String str3, int i11, String str4, Integer num, Integer num2, Integer num3, List<DownloadResolutionItem> list2, String str5, String str6, List<String> list3, ShortTVFavInfo shortTVFavInfo, Integer num4, String str7, String str8, boolean z11, int i12, int i13) {
        this.items = list;
        this.pager = pager;
        this.cover = cover;
        this.subjectId = str;
        this.groupId = str2;
        this.title = str3;
        this.subjectType = i11;
        this.subjectTitle = str4;
        this.position = num;
        this.totalEpisode = num2;
        this.resolution = num3;
        this.resolutionList = list2;
        this.description = str5;
        this.genre = str6;
        this.tags = list3;
        this.shortTVFavInfo = shortTVFavInfo;
        this.durationSeconds = num4;
        this.releaseDate = str7;
        this.countryName = str8;
        this.loadMore = z11;
        this.startPosition = i12;
        this.endPosition = i13;
    }

    public /* synthetic */ DownloadListBean(List list, Pager pager, Cover cover, String str, String str2, String str3, int i11, String str4, Integer num, Integer num2, Integer num3, List list2, String str5, String str6, List list3, ShortTVFavInfo shortTVFavInfo, Integer num4, String str7, String str8, boolean z11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, pager, cover, str, str2, str3, (i14 & 64) != 0 ? 0 : i11, str4, num, num2, (i14 & 1024) != 0 ? 0 : num3, (i14 & 2048) != 0 ? null : list2, (i14 & 4096) != 0 ? null : str5, (i14 & 8192) != 0 ? null : str6, (i14 & 16384) != 0 ? null : list3, (32768 & i14) != 0 ? null : shortTVFavInfo, (65536 & i14) != 0 ? 0 : num4, (131072 & i14) != 0 ? null : str7, (262144 & i14) != 0 ? null : str8, (524288 & i14) != 0 ? true : z11, (1048576 & i14) != 0 ? 0 : i12, (i14 & 2097152) != 0 ? 0 : i13);
    }

    public final List<DownloadItem> component1() {
        return this.items;
    }

    public final Integer component10() {
        return this.totalEpisode;
    }

    public final Integer component11() {
        return this.resolution;
    }

    public final List<DownloadResolutionItem> component12() {
        return this.resolutionList;
    }

    public final String component13() {
        return this.description;
    }

    public final String component14() {
        return this.genre;
    }

    public final List<String> component15() {
        return this.tags;
    }

    public final ShortTVFavInfo component16() {
        return this.shortTVFavInfo;
    }

    public final Integer component17() {
        return this.durationSeconds;
    }

    public final String component18() {
        return this.releaseDate;
    }

    public final String component19() {
        return this.countryName;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final boolean component20() {
        return this.loadMore;
    }

    public final int component21() {
        return this.startPosition;
    }

    public final int component22() {
        return this.endPosition;
    }

    public final Cover component3() {
        return this.cover;
    }

    public final String component4() {
        return this.subjectId;
    }

    public final String component5() {
        return this.groupId;
    }

    public final String component6() {
        return this.title;
    }

    public final int component7() {
        return this.subjectType;
    }

    public final String component8() {
        return this.subjectTitle;
    }

    public final Integer component9() {
        return this.position;
    }

    public final DownloadListBean copy(List<DownloadItem> list, Pager pager, Cover cover, String str, String str2, String str3, int i11, String str4, Integer num, Integer num2, Integer num3, List<DownloadResolutionItem> list2, String str5, String str6, List<String> list3, ShortTVFavInfo shortTVFavInfo, Integer num4, String str7, String str8, boolean z11, int i12, int i13) {
        return new DownloadListBean(list, pager, cover, str, str2, str3, i11, str4, num, num2, num3, list2, str5, str6, list3, shortTVFavInfo, num4, str7, str8, z11, i12, i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadListBean)) {
            return false;
        }
        DownloadListBean downloadListBean = (DownloadListBean) obj;
        return Intrinsics.b(this.items, downloadListBean.items) && Intrinsics.b(this.pager, downloadListBean.pager) && Intrinsics.b(this.cover, downloadListBean.cover) && Intrinsics.b(this.subjectId, downloadListBean.subjectId) && Intrinsics.b(this.groupId, downloadListBean.groupId) && Intrinsics.b(this.title, downloadListBean.title) && this.subjectType == downloadListBean.subjectType && Intrinsics.b(this.subjectTitle, downloadListBean.subjectTitle) && Intrinsics.b(this.position, downloadListBean.position) && Intrinsics.b(this.totalEpisode, downloadListBean.totalEpisode) && Intrinsics.b(this.resolution, downloadListBean.resolution) && Intrinsics.b(this.resolutionList, downloadListBean.resolutionList) && Intrinsics.b(this.description, downloadListBean.description) && Intrinsics.b(this.genre, downloadListBean.genre) && Intrinsics.b(this.tags, downloadListBean.tags) && Intrinsics.b(this.shortTVFavInfo, downloadListBean.shortTVFavInfo) && Intrinsics.b(this.durationSeconds, downloadListBean.durationSeconds) && Intrinsics.b(this.releaseDate, downloadListBean.releaseDate) && Intrinsics.b(this.countryName, downloadListBean.countryName) && this.loadMore == downloadListBean.loadMore && this.startPosition == downloadListBean.startPosition && this.endPosition == downloadListBean.endPosition;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final Cover getCover() {
        return this.cover;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public final int getEndPosition() {
        return this.endPosition;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final List<DownloadItem> getItems() {
        return this.items;
    }

    public final boolean getLoadMore() {
        return this.loadMore;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final Integer getResolution() {
        return this.resolution;
    }

    public final List<DownloadResolutionItem> getResolutionList() {
        return this.resolutionList;
    }

    public final ShortTVFavInfo getShortTVFavInfo() {
        return this.shortTVFavInfo;
    }

    public final int getStartPosition() {
        return this.startPosition;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getSubjectTitle() {
        return this.subjectTitle;
    }

    public final int getSubjectType() {
        return this.subjectType;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getTotalEpisode() {
        return this.totalEpisode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v40, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        List<DownloadItem> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Pager pager = this.pager;
        int iHashCode2 = (iHashCode + (pager == null ? 0 : pager.hashCode())) * 31;
        Cover cover = this.cover;
        int iHashCode3 = (iHashCode2 + (cover == null ? 0 : cover.hashCode())) * 31;
        String str = this.subjectId;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.groupId;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode6 = (((iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.subjectType) * 31;
        String str4 = this.subjectTitle;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.position;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.totalEpisode;
        int iHashCode9 = (iHashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.resolution;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<DownloadResolutionItem> list2 = this.resolutionList;
        int iHashCode11 = (iHashCode10 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str5 = this.description;
        int iHashCode12 = (iHashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.genre;
        int iHashCode13 = (iHashCode12 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<String> list3 = this.tags;
        int iHashCode14 = (iHashCode13 + (list3 == null ? 0 : list3.hashCode())) * 31;
        ShortTVFavInfo shortTVFavInfo = this.shortTVFavInfo;
        int iHashCode15 = (iHashCode14 + (shortTVFavInfo == null ? 0 : shortTVFavInfo.hashCode())) * 31;
        Integer num4 = this.durationSeconds;
        int iHashCode16 = (iHashCode15 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str7 = this.releaseDate;
        int iHashCode17 = (iHashCode16 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.countryName;
        int iHashCode18 = (iHashCode17 + (str8 != null ? str8.hashCode() : 0)) * 31;
        boolean z11 = this.loadMore;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return ((((iHashCode18 + r11) * 31) + this.startPosition) * 31) + this.endPosition;
    }

    public final void setCountryName(String str) {
        this.countryName = str;
    }

    public final void setCover(Cover cover) {
        this.cover = cover;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public final void setEndPosition(int i11) {
        this.endPosition = i11;
    }

    public final void setGenre(String str) {
        this.genre = str;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setItems(List<DownloadItem> list) {
        this.items = list;
    }

    public final void setLoadMore(boolean z11) {
        this.loadMore = z11;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public final void setPosition(Integer num) {
        this.position = num;
    }

    public final void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public final void setResolution(Integer num) {
        this.resolution = num;
    }

    public final void setResolutionList(List<DownloadResolutionItem> list) {
        this.resolutionList = list;
    }

    public final void setShortTVFavInfo(ShortTVFavInfo shortTVFavInfo) {
        this.shortTVFavInfo = shortTVFavInfo;
    }

    public final void setStartPosition(int i11) {
        this.startPosition = i11;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectTitle(String str) {
        this.subjectTitle = str;
    }

    public final void setSubjectType(int i11) {
        this.subjectType = i11;
    }

    public final void setTags(List<String> list) {
        this.tags = list;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTotalEpisode(Integer num) {
        this.totalEpisode = num;
    }

    public String toString() {
        return "DownloadListBean(items=" + this.items + ", pager=" + this.pager + ", cover=" + this.cover + ", subjectId=" + this.subjectId + ", groupId=" + this.groupId + ", title=" + this.title + ", subjectType=" + this.subjectType + ", subjectTitle=" + this.subjectTitle + ", position=" + this.position + ", totalEpisode=" + this.totalEpisode + ", resolution=" + this.resolution + ", resolutionList=" + this.resolutionList + ", description=" + this.description + ", genre=" + this.genre + ", tags=" + this.tags + ", shortTVFavInfo=" + this.shortTVFavInfo + ", durationSeconds=" + this.durationSeconds + ", releaseDate=" + this.releaseDate + ", countryName=" + this.countryName + ", loadMore=" + this.loadMore + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + ")";
    }
}
