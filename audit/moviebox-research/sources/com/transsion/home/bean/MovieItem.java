package com.transsion.home.bean;

import com.google.gson.annotations.SerializedName;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.ad.bidding.nativead.c;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PreVideoAddress;
import com.transsion.moviedetailapi.bean.Staff;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
@Metadata
public final class MovieItem implements Serializable {
    public static final int $stable = 8;
    private transient String channelId;

    @SerializedName("corner")
    private String corner;

    @SerializedName("countryName")
    private String countryName;

    @SerializedName("cover")
    private Cover cover;

    @SerializedName(TrackingKey.DESCRIPTION)
    private String description;

    @SerializedName("duration")
    private String duration;

    @SerializedName("genre")
    private String genre;

    @SerializedName("hasResource")
    private Boolean hasResource;

    @SerializedName("haveSeenCount")
    private Integer haveSeenCount;

    @SerializedName("imdbRatingValue")
    private String imdbRatingValue;

    @SerializedName("language")
    private String language;

    @SerializedName("myScoreDate")
    private String myScoreDate;

    @SerializedName("myScoreValue")
    private Integer myScoreValue;
    private transient c nonAdDelegate;

    @SerializedName("ops")
    private String ops;

    @SerializedName("preVideoAddress")
    private List<PreVideoAddress> preVideoAddress;

    @SerializedName("preVideoCover")
    private Cover preVideoCover;

    @SerializedName("releaseDate")
    private String releaseDate;

    @SerializedName("seenStatus")
    private Integer seenStatus;
    private transient Map<String, String> selectItems;

    @SerializedName("staffList")
    private List<? extends Staff> staffList;

    @SerializedName("subjectId")
    private String subjectId;

    @SerializedName("subjectType")
    private Integer subjectType;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private String title;

    @SerializedName("wantToSeeCount")
    private Integer wantToSeeCount;

    public MovieItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
    }

    public MovieItem(String str, Cover cover, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Integer num2, List<PreVideoAddress> list, Cover cover2, String str8, Integer num3, List<? extends Staff> list2, String str9, Boolean bool, Integer num4, String str10, Integer num5, String str11, String str12, String str13, Map<String, String> map, c cVar) {
        this.countryName = str;
        this.cover = cover;
        this.description = str2;
        this.duration = str3;
        this.genre = str4;
        this.haveSeenCount = num;
        this.imdbRatingValue = str5;
        this.language = str6;
        this.myScoreDate = str7;
        this.myScoreValue = num2;
        this.preVideoAddress = list;
        this.preVideoCover = cover2;
        this.releaseDate = str8;
        this.seenStatus = num3;
        this.staffList = list2;
        this.subjectId = str9;
        this.hasResource = bool;
        this.subjectType = num4;
        this.title = str10;
        this.wantToSeeCount = num5;
        this.ops = str11;
        this.corner = str12;
        this.channelId = str13;
        this.selectItems = map;
        this.nonAdDelegate = cVar;
    }

    public /* synthetic */ MovieItem(String str, Cover cover, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Integer num2, List list, Cover cover2, String str8, Integer num3, List list2, String str9, Boolean bool, Integer num4, String str10, Integer num5, String str11, String str12, String str13, Map map, c cVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : cover, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : num, (i11 & 64) != 0 ? null : str5, (i11 & 128) != 0 ? null : str6, (i11 & 256) != 0 ? null : str7, (i11 & 512) != 0 ? null : num2, (i11 & 1024) != 0 ? null : list, (i11 & 2048) != 0 ? null : cover2, (i11 & 4096) != 0 ? null : str8, (i11 & 8192) != 0 ? null : num3, (i11 & 16384) != 0 ? null : list2, (i11 & 32768) != 0 ? null : str9, (i11 & 65536) != 0 ? null : bool, (i11 & 131072) != 0 ? null : num4, (i11 & 262144) != 0 ? null : str10, (i11 & 524288) != 0 ? null : num5, (i11 & 1048576) != 0 ? null : str11, (i11 & 2097152) != 0 ? null : str12, (i11 & 4194304) != 0 ? null : str13, (i11 & 8388608) != 0 ? null : map, (i11 & 16777216) != 0 ? null : cVar);
    }

    public final String component1() {
        return this.countryName;
    }

    public final Integer component10() {
        return this.myScoreValue;
    }

    public final List<PreVideoAddress> component11() {
        return this.preVideoAddress;
    }

    public final Cover component12() {
        return this.preVideoCover;
    }

    public final String component13() {
        return this.releaseDate;
    }

    public final Integer component14() {
        return this.seenStatus;
    }

    public final List<Staff> component15() {
        return this.staffList;
    }

    public final String component16() {
        return this.subjectId;
    }

    public final Boolean component17() {
        return this.hasResource;
    }

    public final Integer component18() {
        return this.subjectType;
    }

    public final String component19() {
        return this.title;
    }

    public final Cover component2() {
        return this.cover;
    }

    public final Integer component20() {
        return this.wantToSeeCount;
    }

    public final String component21() {
        return this.ops;
    }

    public final String component22() {
        return this.corner;
    }

    public final String component23() {
        return this.channelId;
    }

    public final Map<String, String> component24() {
        return this.selectItems;
    }

    public final c component25() {
        return this.nonAdDelegate;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.duration;
    }

    public final String component5() {
        return this.genre;
    }

    public final Integer component6() {
        return this.haveSeenCount;
    }

    public final String component7() {
        return this.imdbRatingValue;
    }

    public final String component8() {
        return this.language;
    }

    public final String component9() {
        return this.myScoreDate;
    }

    public final MovieItem copy(String str, Cover cover, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Integer num2, List<PreVideoAddress> list, Cover cover2, String str8, Integer num3, List<? extends Staff> list2, String str9, Boolean bool, Integer num4, String str10, Integer num5, String str11, String str12, String str13, Map<String, String> map, c cVar) {
        return new MovieItem(str, cover, str2, str3, str4, num, str5, str6, str7, num2, list, cover2, str8, num3, list2, str9, bool, num4, str10, num5, str11, str12, str13, map, cVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MovieItem)) {
            return false;
        }
        MovieItem movieItem = (MovieItem) obj;
        return Intrinsics.b(this.countryName, movieItem.countryName) && Intrinsics.b(this.cover, movieItem.cover) && Intrinsics.b(this.description, movieItem.description) && Intrinsics.b(this.duration, movieItem.duration) && Intrinsics.b(this.genre, movieItem.genre) && Intrinsics.b(this.haveSeenCount, movieItem.haveSeenCount) && Intrinsics.b(this.imdbRatingValue, movieItem.imdbRatingValue) && Intrinsics.b(this.language, movieItem.language) && Intrinsics.b(this.myScoreDate, movieItem.myScoreDate) && Intrinsics.b(this.myScoreValue, movieItem.myScoreValue) && Intrinsics.b(this.preVideoAddress, movieItem.preVideoAddress) && Intrinsics.b(this.preVideoCover, movieItem.preVideoCover) && Intrinsics.b(this.releaseDate, movieItem.releaseDate) && Intrinsics.b(this.seenStatus, movieItem.seenStatus) && Intrinsics.b(this.staffList, movieItem.staffList) && Intrinsics.b(this.subjectId, movieItem.subjectId) && Intrinsics.b(this.hasResource, movieItem.hasResource) && Intrinsics.b(this.subjectType, movieItem.subjectType) && Intrinsics.b(this.title, movieItem.title) && Intrinsics.b(this.wantToSeeCount, movieItem.wantToSeeCount) && Intrinsics.b(this.ops, movieItem.ops) && Intrinsics.b(this.corner, movieItem.corner) && Intrinsics.b(this.channelId, movieItem.channelId) && Intrinsics.b(this.selectItems, movieItem.selectItems) && Intrinsics.b(this.nonAdDelegate, movieItem.nonAdDelegate);
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final String getCorner() {
        return this.corner;
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

    public final String getDuration() {
        return this.duration;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final Boolean getHasResource() {
        return this.hasResource;
    }

    public final Integer getHaveSeenCount() {
        return this.haveSeenCount;
    }

    public final String getImdbRatingValue() {
        return this.imdbRatingValue;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getMyScoreDate() {
        return this.myScoreDate;
    }

    public final Integer getMyScoreValue() {
        return this.myScoreValue;
    }

    public final c getNonAdDelegate() {
        return this.nonAdDelegate;
    }

    public final String getOps() {
        return this.ops;
    }

    public final List<PreVideoAddress> getPreVideoAddress() {
        return this.preVideoAddress;
    }

    public final Cover getPreVideoCover() {
        return this.preVideoCover;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final Integer getSeenStatus() {
        return this.seenStatus;
    }

    public final Map<String, String> getSelectItems() {
        return this.selectItems;
    }

    public final List<Staff> getStaffList() {
        return this.staffList;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getWantToSeeCount() {
        return this.wantToSeeCount;
    }

    public int hashCode() {
        String str = this.countryName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Cover cover = this.cover;
        int iHashCode2 = (iHashCode + (cover == null ? 0 : cover.hashCode())) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.duration;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.genre;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.haveSeenCount;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.imdbRatingValue;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.language;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.myScoreDate;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num2 = this.myScoreValue;
        int iHashCode10 = (iHashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<PreVideoAddress> list = this.preVideoAddress;
        int iHashCode11 = (iHashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        Cover cover2 = this.preVideoCover;
        int iHashCode12 = (iHashCode11 + (cover2 == null ? 0 : cover2.hashCode())) * 31;
        String str8 = this.releaseDate;
        int iHashCode13 = (iHashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num3 = this.seenStatus;
        int iHashCode14 = (iHashCode13 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<? extends Staff> list2 = this.staffList;
        int iHashCode15 = (iHashCode14 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str9 = this.subjectId;
        int iHashCode16 = (iHashCode15 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool = this.hasResource;
        int iHashCode17 = (iHashCode16 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num4 = this.subjectType;
        int iHashCode18 = (iHashCode17 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str10 = this.title;
        int iHashCode19 = (iHashCode18 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num5 = this.wantToSeeCount;
        int iHashCode20 = (iHashCode19 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str11 = this.ops;
        int iHashCode21 = (iHashCode20 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.corner;
        int iHashCode22 = (iHashCode21 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.channelId;
        int iHashCode23 = (iHashCode22 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Map<String, String> map = this.selectItems;
        int iHashCode24 = (iHashCode23 + (map == null ? 0 : map.hashCode())) * 31;
        c cVar = this.nonAdDelegate;
        return iHashCode24 + (cVar != null ? cVar.hashCode() : 0);
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final void setCorner(String str) {
        this.corner = str;
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

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final void setGenre(String str) {
        this.genre = str;
    }

    public final void setHasResource(Boolean bool) {
        this.hasResource = bool;
    }

    public final void setHaveSeenCount(Integer num) {
        this.haveSeenCount = num;
    }

    public final void setImdbRatingValue(String str) {
        this.imdbRatingValue = str;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setMyScoreDate(String str) {
        this.myScoreDate = str;
    }

    public final void setMyScoreValue(Integer num) {
        this.myScoreValue = num;
    }

    public final void setNonAdDelegate(c cVar) {
        this.nonAdDelegate = cVar;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPreVideoAddress(List<PreVideoAddress> list) {
        this.preVideoAddress = list;
    }

    public final void setPreVideoCover(Cover cover) {
        this.preVideoCover = cover;
    }

    public final void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public final void setSeenStatus(Integer num) {
        this.seenStatus = num;
    }

    public final void setSelectItems(Map<String, String> map) {
        this.selectItems = map;
    }

    public final void setStaffList(List<? extends Staff> list) {
        this.staffList = list;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectType(Integer num) {
        this.subjectType = num;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setWantToSeeCount(Integer num) {
        this.wantToSeeCount = num;
    }

    public String toString() {
        return "MovieItem(countryName=" + this.countryName + ", cover=" + this.cover + ", description=" + this.description + ", duration=" + this.duration + ", genre=" + this.genre + ", haveSeenCount=" + this.haveSeenCount + ", imdbRatingValue=" + this.imdbRatingValue + ", language=" + this.language + ", myScoreDate=" + this.myScoreDate + ", myScoreValue=" + this.myScoreValue + ", preVideoAddress=" + this.preVideoAddress + ", preVideoCover=" + this.preVideoCover + ", releaseDate=" + this.releaseDate + ", seenStatus=" + this.seenStatus + ", staffList=" + this.staffList + ", subjectId=" + this.subjectId + ", hasResource=" + this.hasResource + ", subjectType=" + this.subjectType + ", title=" + this.title + ", wantToSeeCount=" + this.wantToSeeCount + ", ops=" + this.ops + ", corner=" + this.corner + ", channelId=" + this.channelId + ", selectItems=" + this.selectItems + ", nonAdDelegate=" + this.nonAdDelegate + ")";
    }
}
