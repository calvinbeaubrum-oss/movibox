package com.transsion.moviedetailapi.bean;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.ad.bidding.nativead.c;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.mvel2.ast.ASTNode;
import xu.a;

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
@SourceDebugExtension
public class Subject extends a implements Serializable {
    private String aka;

    @SerializedName("appointmentCnt")
    private Long appointmentCnt;
    private boolean builtIn;

    @SerializedName("category")
    private String category;
    private int coinPerEp;

    @SerializedName("contentRating")
    private String contentRating;

    @SerializedName("corner")
    private String corner;
    private transient boolean correlation;

    @SerializedName("countryName")
    private String countryName;

    @SerializedName("cover")
    private Cover cover;
    private transient boolean coverCache;
    private transient boolean deleted;

    @SerializedName(TrackingKey.DESCRIPTION)
    private String description;

    @SerializedName("dl")
    private SubjectDl download;
    private List<DubsInfo> dubs;

    @SerializedName("duration")
    private String duration;

    @SerializedName(alternate = {"durationSeconds"}, value = "seconds")
    private Integer durationSeconds;
    private List<ExplainBean> explains;

    @SerializedName("relatedApp")
    private SubjectGameInfo gameInfo;

    @SerializedName("genre")
    private String genre;

    @SerializedName("hasResource")
    private Boolean hasResource;

    @SerializedName("imdbRatingValue")
    private String imdbRate;
    private boolean isCache;

    @SerializedName("language")
    private String language;

    @SerializedName("likeStatus")
    private Integer likeStatus;
    private transient long loadCoverDuration;
    private transient boolean loadCoverSuccess;

    @SerializedName("mySeeTime")
    private String mySeeTime;
    private transient c nonAdDelegate;

    @SerializedName("ops")
    private String ops;

    @SerializedName("postTitle")
    private String postTitle;

    @SerializedName("releaseDate")
    private String releaseDate;

    @SerializedName("resourceDetectors")
    private List<ResourceDetectors> resourceDetectors;
    private String restrictLevel;
    private Integer seNum;
    private int season;

    @SerializedName("seenStatus")
    private Integer seenStatus;
    private transient boolean series;

    @SerializedName("favInfo")
    private ShortTVFavInfo shortTVFavInfo;

    @SerializedName("firstEp")
    private ShortTVItem shortTVFirstEp;

    @SerializedName("staffList")
    private List<? extends Staff> staffList;

    @SerializedName("stills")
    private Cover stills;

    @SerializedName("subjectId")
    private String subjectId;

    @SerializedName("subjectType")
    private Integer subjectType;
    private String subtitles;

    @SerializedName("tag")
    private String tag;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private String title;

    @SerializedName(alternate = {"shortsEpisode"}, value = "totalEpisode")
    private int totalEpisode;
    private long totalSize;

    @SerializedName("trailer")
    private Trailer trailer;
    private List<Integer> unlockedEps;

    @SerializedName("viewers")
    private Long viewers;

    @SerializedName("wantToSeeCount")
    private Long wantToSeeCount;

    public Subject() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
    }

    public Subject(String str, Integer num, String str2, String str3, Cover cover, String str4, String str5, String str6, Integer num2, String str7, List<String> list, String str8, String str9, String str10, String str11, Integer num3, List<? extends Staff> list2, Long l11, Boolean bool, String str12, SubjectDl subjectDl, List<ResourceDetectors> list3, Cover cover2, Trailer trailer, boolean z11, boolean z12, c cVar, String str13, Long l12, String str14, String str15, boolean z13, boolean z14, ShortTVItem shortTVItem, ShortTVFavInfo shortTVFavInfo, int i11, boolean z15, boolean z16, long j11, String str16, List<ExplainBean> list4, long j12, List<Integer> list5, int i12, boolean z17, Integer num4, int i13, SubjectGameInfo subjectGameInfo, String str17, List<DubsInfo> list6, String str18, String str19, Long l13, Integer num5) {
        this.subjectId = str;
        this.subjectType = num;
        this.title = str2;
        this.countryName = str3;
        this.cover = cover;
        this.releaseDate = str4;
        this.description = str5;
        this.duration = str6;
        this.durationSeconds = num2;
        this.genre = str7;
        this.tags = list;
        this.tag = str8;
        this.imdbRate = str9;
        this.language = str10;
        this.mySeeTime = str11;
        this.seenStatus = num3;
        this.staffList = list2;
        this.wantToSeeCount = l11;
        this.hasResource = bool;
        this.ops = str12;
        this.download = subjectDl;
        this.resourceDetectors = list3;
        this.stills = cover2;
        this.trailer = trailer;
        this.series = z11;
        this.correlation = z12;
        this.nonAdDelegate = cVar;
        this.postTitle = str13;
        this.viewers = l12;
        this.contentRating = str14;
        this.category = str15;
        this.builtIn = z13;
        this.isCache = z14;
        this.shortTVFirstEp = shortTVItem;
        this.shortTVFavInfo = shortTVFavInfo;
        this.totalEpisode = i11;
        this.loadCoverSuccess = z15;
        this.coverCache = z16;
        this.loadCoverDuration = j11;
        this.aka = str16;
        this.explains = list4;
        this.totalSize = j12;
        this.unlockedEps = list5;
        this.coinPerEp = i12;
        this.deleted = z17;
        this.seNum = num4;
        this.season = i13;
        this.gameInfo = subjectGameInfo;
        this.subtitles = str17;
        this.dubs = list6;
        this.corner = str18;
        this.restrictLevel = str19;
        this.appointmentCnt = l13;
        this.likeStatus = num5;
    }

    public /* synthetic */ Subject(String str, Integer num, String str2, String str3, Cover cover, String str4, String str5, String str6, Integer num2, String str7, List list, String str8, String str9, String str10, String str11, Integer num3, List list2, Long l11, Boolean bool, String str12, SubjectDl subjectDl, List list3, Cover cover2, Trailer trailer, boolean z11, boolean z12, c cVar, String str13, Long l12, String str14, String str15, boolean z13, boolean z14, ShortTVItem shortTVItem, ShortTVFavInfo shortTVFavInfo, int i11, boolean z15, boolean z16, long j11, String str16, List list4, long j12, List list5, int i12, boolean z17, Integer num4, int i13, SubjectGameInfo subjectGameInfo, String str17, List list6, String str18, String str19, Long l13, Integer num5, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? null : str, (i14 & 2) != 0 ? 1 : num, (i14 & 4) != 0 ? null : str2, (i14 & 8) != 0 ? null : str3, (i14 & 16) != 0 ? null : cover, (i14 & 32) != 0 ? null : str4, (i14 & 64) != 0 ? null : str5, (i14 & 128) != 0 ? null : str6, (i14 & 256) != 0 ? 0 : num2, (i14 & 512) != 0 ? null : str7, (i14 & 1024) != 0 ? null : list, (i14 & 2048) != 0 ? null : str8, (i14 & 4096) != 0 ? null : str9, (i14 & 8192) != 0 ? null : str10, (i14 & 16384) != 0 ? null : str11, (i14 & 32768) != 0 ? 0 : num3, (i14 & 65536) != 0 ? null : list2, (i14 & 131072) != 0 ? 0L : l11, (i14 & 262144) != 0 ? null : bool, (i14 & 524288) != 0 ? null : str12, (i14 & 1048576) != 0 ? null : subjectDl, (i14 & 2097152) != 0 ? null : list3, (i14 & 4194304) != 0 ? null : cover2, (i14 & 8388608) != 0 ? null : trailer, (i14 & 16777216) != 0 ? false : z11, (i14 & ASTNode.PCTX_STORED) != 0 ? false : z12, (i14 & 67108864) != 0 ? null : cVar, (i14 & ASTNode.NOJIT) != 0 ? null : str13, (i14 & ASTNode.DEOP) != 0 ? null : l12, (i14 & ASTNode.DISCARD) != 0 ? null : str14, (i14 & 1073741824) != 0 ? null : str15, (i14 & Integer.MIN_VALUE) != 0 ? false : z13, (i15 & 1) != 0 ? false : z14, (i15 & 2) != 0 ? null : shortTVItem, (i15 & 4) != 0 ? null : shortTVFavInfo, (i15 & 8) != 0 ? 0 : i11, (i15 & 16) != 0 ? false : z15, (i15 & 32) != 0 ? false : z16, (i15 & 64) != 0 ? 0L : j11, (i15 & 128) != 0 ? null : str16, (i15 & 256) != 0 ? null : list4, (i15 & 512) != 0 ? 0L : j12, (i15 & 1024) != 0 ? null : list5, (i15 & 2048) != 0 ? -1 : i12, (i15 & 4096) != 0 ? false : z17, (i15 & 8192) != 0 ? 0 : num4, (i15 & 16384) != 0 ? 1 : i13, (i15 & 32768) != 0 ? null : subjectGameInfo, (i15 & 65536) != 0 ? null : str17, (i15 & 131072) != 0 ? null : list6, (i15 & 262144) != 0 ? null : str18, (i15 & 524288) != 0 ? null : str19, (i15 & 1048576) != 0 ? 0L : l13, (i15 & 2097152) != 0 ? 0 : num5);
    }

    @Deprecated
    public static /* synthetic */ void getDownload$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getResourceDetectors$annotations() {
    }

    public final Subject copyData() {
        return new Subject(this.subjectId, this.subjectType, this.title, this.countryName, this.cover, this.releaseDate, this.description, this.duration, this.durationSeconds, this.genre, this.tags, null, this.imdbRate, this.language, this.mySeeTime, null, null, null, this.hasResource, this.ops, this.download, this.resourceDetectors, this.stills, this.trailer, false, false, null, null, null, null, null, this.builtIn, this.isCache, this.shortTVFirstEp, this.shortTVFavInfo, this.totalEpisode, false, false, 0L, null, null, this.totalSize, this.unlockedEps, this.coinPerEp, false, null, 0, null, null, null, null, null, null, null, 2130937856, 4190704, null);
    }

    public final String currentDubLandCode() {
        Object next;
        List<DubsInfo> list = this.dubs;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((DubsInfo) next).getSubjectId(), this.subjectId));
        DubsInfo dubsInfo = (DubsInfo) next;
        if (dubsInfo != null) {
            return dubsInfo.getLanCode();
        }
        return null;
    }

    public final String currentDubLandName() {
        Object next;
        List<DubsInfo> list = this.dubs;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((DubsInfo) next).getSubjectId(), this.subjectId));
        DubsInfo dubsInfo = (DubsInfo) next;
        if (dubsInfo != null) {
            return dubsInfo.getLanName();
        }
        return null;
    }

    public final String getAka() {
        return this.aka;
    }

    public final Long getAppointmentCnt() {
        return this.appointmentCnt;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final String getCategory() {
        return this.category;
    }

    public final int getCoinPerEp() {
        return this.coinPerEp;
    }

    public final String getContentRating() {
        return this.contentRating;
    }

    public final String getCorner() {
        return this.corner;
    }

    public final boolean getCorrelation() {
        return this.correlation;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final Cover getCover() {
        return this.cover;
    }

    public final boolean getCoverCache() {
        return this.coverCache;
    }

    public final boolean getDeleted() {
        return this.deleted;
    }

    public final String getDescription() {
        return this.description;
    }

    public final SubjectDl getDownload() {
        return this.download;
    }

    public final List<DubsInfo> getDubs() {
        return this.dubs;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public final List<ExplainBean> getExplains() {
        return this.explains;
    }

    public final SubjectGameInfo getGameInfo() {
        return this.gameInfo;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final Boolean getHasResource() {
        return this.hasResource;
    }

    public final String getImdbRate() {
        return this.imdbRate;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final Integer getLikeStatus() {
        return this.likeStatus;
    }

    public final long getLoadCoverDuration() {
        return this.loadCoverDuration;
    }

    public final boolean getLoadCoverSuccess() {
        return this.loadCoverSuccess;
    }

    public final String getMySeeTime() {
        return this.mySeeTime;
    }

    public final c getNonAdDelegate() {
        return this.nonAdDelegate;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getPostTitle() {
        return this.postTitle;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final long getResourceAboutDuration() {
        int i11;
        Integer num = this.durationSeconds;
        int iIntValue = 0;
        if (num == null || num.intValue() <= 0) {
            String str = this.duration;
            if (str == null || str.length() <= 0) {
                return 0L;
            }
            Pattern patternCompile = Pattern.compile("[^0-9]+");
            String str2 = this.duration;
            Intrinsics.d(str2);
            String[] strArrSplit = patternCompile.split(StringsKt__StringsKt.Z0(str2).toString());
            if (strArrSplit.length == 2) {
                String str3 = strArrSplit[0];
                Intrinsics.f(str3, "durationArray[0]");
                iIntValue = Integer.parseInt(str3);
                String str4 = strArrSplit[1];
                Intrinsics.f(str4, "durationArray[1]");
                i11 = Integer.parseInt(str4);
            } else if (strArrSplit.length == 1) {
                String str5 = strArrSplit[0];
                Intrinsics.f(str5, "durationArray[0]");
                i11 = Integer.parseInt(str5);
            } else {
                i11 = 0;
            }
            iIntValue = ((iIntValue * 60) + i11) * 60;
        } else {
            Integer num2 = this.durationSeconds;
            if (num2 != null) {
                iIntValue = num2.intValue();
            }
        }
        return ((long) iIntValue) * 1000;
    }

    public final ResourceDetectors getResourceDetector() {
        ResourceDetectors resourceDetectors;
        List<DownloadItem> resolutionList;
        List<ResourceDetectors> list = this.resourceDetectors;
        if (list == null || list.isEmpty()) {
            boolean zIsSeries = isSeries();
            SubjectDl subjectDl = this.download;
            String resourceId = subjectDl != null ? subjectDl.getResourceId() : null;
            SubjectDl subjectDl2 = this.download;
            String url = subjectDl2 != null ? subjectDl2.getUrl() : null;
            SubjectDl subjectDl3 = this.download;
            Long size = subjectDl3 != null ? subjectDl3.getSize() : null;
            SubjectDl subjectDl4 = this.download;
            String sourceUrl = subjectDl4 != null ? subjectDl4.getSourceUrl() : null;
            SubjectDl subjectDl5 = this.download;
            String postId = subjectDl5 != null ? subjectDl5.getPostId() : null;
            SubjectDl subjectDl6 = this.download;
            return new ResourceDetectors(Integer.valueOf(zIsSeries ? 1 : 0), null, size, null, null, sourceUrl, url, null, resourceId, null, postId, subjectDl6 != null ? subjectDl6.getExtSubtitle() : null, null, null, 12954, null);
        }
        List<ResourceDetectors> list2 = this.resourceDetectors;
        ResourceDetectors resourceDetectors2 = list2 != null ? list2.get(0) : null;
        List<ResourceDetectors> list3 = this.resourceDetectors;
        if (list3 == null || (resourceDetectors = list3.get(0)) == null || (resolutionList = resourceDetectors.getResolutionList()) == null) {
            return resourceDetectors2;
        }
        for (DownloadItem downloadItem : resolutionList) {
            if (Intrinsics.b(downloadItem.getResourceId(), resourceDetectors2 != null ? resourceDetectors2.getResourceId() : null)) {
                resourceDetectors2 = new ResourceDetectors(resourceDetectors2 != null ? resourceDetectors2.getType() : null, null, downloadItem.getSize(), null, downloadItem.getUploadBy(), downloadItem.getSourceUrl(), downloadItem.getUrl(), null, downloadItem.getResourceId(), null, downloadItem.getPostId(), downloadItem.getExtSubtitle(), null, downloadItem.getResolution(), 4746, null);
            }
        }
        return resourceDetectors2;
    }

    public final List<ResourceDetectors> getResourceDetectors() {
        return this.resourceDetectors;
    }

    public final String getRestrictLevel() {
        return this.restrictLevel;
    }

    public final Integer getSeNum() {
        return this.seNum;
    }

    public final int getSeason() {
        return this.season;
    }

    public final Integer getSeenStatus() {
        return this.seenStatus;
    }

    public final boolean getSeries() {
        return this.series;
    }

    public final ShortTVFavInfo getShortTVFavInfo() {
        return this.shortTVFavInfo;
    }

    public final ShortTVItem getShortTVFirstEp() {
        return this.shortTVFirstEp;
    }

    public final List<Staff> getStaffList() {
        return this.staffList;
    }

    public final Cover getStills() {
        return this.stills;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public final String getSubtitles() {
        return this.subtitles;
    }

    public final String getTag() {
        return this.tag;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTotalEpisode() {
        return this.totalEpisode;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public final Trailer getTrailer() {
        return this.trailer;
    }

    public final List<Integer> getUnlockedEps() {
        return this.unlockedEps;
    }

    public final Long getViewers() {
        return this.viewers;
    }

    public final Long getWantToSeeCount() {
        return this.wantToSeeCount;
    }

    public final boolean isCache() {
        return this.isCache;
    }

    public final boolean isEPType() {
        return isTvType() || isEduType();
    }

    public final boolean isEduType() {
        Integer num = this.subjectType;
        SubjectType subjectType = SubjectType.EDUCATION;
        return Intrinsics.b(num, subjectType != null ? Integer.valueOf(subjectType.getValue()) : null);
    }

    public final boolean isMovieType() {
        Integer num = this.subjectType;
        SubjectType subjectType = SubjectType.MOVIE;
        return Intrinsics.b(num, subjectType != null ? Integer.valueOf(subjectType.getValue()) : null);
    }

    public final boolean isMusicType() {
        Integer num = this.subjectType;
        SubjectType subjectType = SubjectType.MUSIC;
        if (!Intrinsics.b(num, subjectType != null ? Integer.valueOf(subjectType.getValue()) : null)) {
            Integer num2 = this.subjectType;
            SubjectType subjectType2 = SubjectType.AUDIO;
            if (!Intrinsics.b(num2, subjectType2 != null ? Integer.valueOf(subjectType2.getValue()) : null)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isSeries() {
        SubjectDl subjectDl;
        if (!this.series && (subjectDl = this.download) != null) {
            if (!TextUtils.isEmpty(subjectDl != null ? subjectDl.getUrl() : null)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isShortTV() {
        Integer num = this.subjectType;
        SubjectType subjectType = SubjectType.SHORT_TV;
        return Intrinsics.b(num, subjectType != null ? Integer.valueOf(subjectType.getValue()) : null);
    }

    public final boolean isTvType() {
        Integer num = this.subjectType;
        SubjectType subjectType = SubjectType.TV;
        return Intrinsics.b(num, subjectType != null ? Integer.valueOf(subjectType.getValue()) : null);
    }

    public final void setAka(String str) {
        this.aka = str;
    }

    public final void setAppointmentCnt(Long l11) {
        this.appointmentCnt = l11;
    }

    public final void setBuiltIn(boolean z11) {
        this.builtIn = z11;
    }

    public final void setCache(boolean z11) {
        this.isCache = z11;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final void setCoinPerEp(int i11) {
        this.coinPerEp = i11;
    }

    public final void setContentRating(String str) {
        this.contentRating = str;
    }

    public final void setCorner(String str) {
        this.corner = str;
    }

    public final void setCorrelation(boolean z11) {
        this.correlation = z11;
    }

    public final void setCountryName(String str) {
        this.countryName = str;
    }

    public final void setCover(Cover cover) {
        this.cover = cover;
    }

    public final void setCoverCache(boolean z11) {
        this.coverCache = z11;
    }

    public final void setDeleted(boolean z11) {
        this.deleted = z11;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setDownload(SubjectDl subjectDl) {
        this.download = subjectDl;
    }

    public final void setDubs(List<DubsInfo> list) {
        this.dubs = list;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public final void setExplains(List<ExplainBean> list) {
        this.explains = list;
    }

    public final void setGameInfo(SubjectGameInfo subjectGameInfo) {
        this.gameInfo = subjectGameInfo;
    }

    public final void setGenre(String str) {
        this.genre = str;
    }

    public final void setHasResource(Boolean bool) {
        this.hasResource = bool;
    }

    public final void setImdbRate(String str) {
        this.imdbRate = str;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setLikeStatus(Integer num) {
        this.likeStatus = num;
    }

    public final void setLoadCoverDuration(long j11) {
        this.loadCoverDuration = j11;
    }

    public final void setLoadCoverSuccess(boolean z11) {
        this.loadCoverSuccess = z11;
    }

    public final void setMySeeTime(String str) {
        this.mySeeTime = str;
    }

    public final void setNonAdDelegate(c cVar) {
        this.nonAdDelegate = cVar;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPostTitle(String str) {
        this.postTitle = str;
    }

    public final void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public final void setResourceDetectors(List<ResourceDetectors> list) {
        this.resourceDetectors = list;
    }

    public final void setRestrictLevel(String str) {
        this.restrictLevel = str;
    }

    public final void setSeNum(Integer num) {
        this.seNum = num;
    }

    public final void setSeason(int i11) {
        this.season = i11;
    }

    public final void setSeenStatus(Integer num) {
        this.seenStatus = num;
    }

    public final void setSeries(boolean z11) {
        this.series = z11;
    }

    public final void setShortTVFavInfo(ShortTVFavInfo shortTVFavInfo) {
        this.shortTVFavInfo = shortTVFavInfo;
    }

    public final void setShortTVFirstEp(ShortTVItem shortTVItem) {
        this.shortTVFirstEp = shortTVItem;
    }

    public final void setStaffList(List<? extends Staff> list) {
        this.staffList = list;
    }

    public final void setStills(Cover cover) {
        this.stills = cover;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectType(Integer num) {
        this.subjectType = num;
    }

    public final void setSubtitles(String str) {
        this.subtitles = str;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final void setTags(List<String> list) {
        this.tags = list;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTotalEpisode(int i11) {
        this.totalEpisode = i11;
    }

    public final void setTotalSize(long j11) {
        this.totalSize = j11;
    }

    public final void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public final void setUnlockedEps(List<Integer> list) {
        this.unlockedEps = list;
    }

    public final void setViewers(Long l11) {
        this.viewers = l11;
    }

    public final void setWantToSeeCount(Long l11) {
        this.wantToSeeCount = l11;
    }
}
