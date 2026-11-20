package com.transsion.home.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

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
@Keep
@Metadata
public class VideoInfo implements Serializable {
    public static final int $stable = 8;

    @SerializedName("alg")
    private String alg;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("be_followed_status")
    private Boolean beFollowedStatus;

    @SerializedName("comment_count")
    private String commentCount;

    @SerializedName("default_definition_type")
    private Integer defaultDefinitionType;

    @SerializedName("default_video_url")
    private String defaultVideoUrl;

    @SerializedName("video_duration")
    private Long duration;

    @SerializedName("first_frame_url")
    private String firstFrameUrl;

    @SerializedName("has_followed")
    private Boolean followStatus;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f52333id;

    @SerializedName("has_liked")
    private Boolean likeStatus;

    @SerializedName("like_count")
    private String likes;

    @SerializedName("ops")
    private String ops;

    @SerializedName("picture_height")
    private Integer pictureHeight;

    @SerializedName("picture_url")
    private String pictureUrl;

    @SerializedName("picture_width")
    private Integer pictureWidth;
    private int pid;
    private int position;

    @SerializedName("raw_video_url")
    private String rawVideoUrl;

    @SerializedName("rec_id")
    private String recId;

    @SerializedName("scene_type")
    private Integer sceneType;

    @SerializedName("thumb_picture_url")
    private String thumbPictureUrl;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private String title;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("user_name")
    private String userName;

    @SerializedName("video_height")
    private Integer videoHeight;

    @SerializedName("video_id")
    private String videoId;

    @SerializedName("video_status")
    private Integer videoStatus;

    @SerializedName("video_url_list")
    private List<VideoType> videoUrlList;

    @SerializedName("video_width")
    private Integer videoWidth;

    @SerializedName("view_count")
    private Long viewCount;
    private int exposureType = 1;
    private int trendType = 1;

    public final String getAlg() {
        return this.alg;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final Boolean getBeFollowedStatus() {
        return this.beFollowedStatus;
    }

    public final String getCommentCount() {
        return this.commentCount;
    }

    public final Integer getDefaultDefinitionType() {
        return this.defaultDefinitionType;
    }

    public final String getDefaultVideoUrl() {
        return this.defaultVideoUrl;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final int getExposureType() {
        return this.exposureType;
    }

    public final String getFirstFrameUrl() {
        return this.firstFrameUrl;
    }

    public final Boolean getFollowStatus() {
        return this.followStatus;
    }

    public final String getId() {
        return this.f52333id;
    }

    public final Boolean getLikeStatus() {
        return this.likeStatus;
    }

    public final String getLikes() {
        return this.likes;
    }

    public final String getOps() {
        return this.ops;
    }

    public final Integer getPictureHeight() {
        return this.pictureHeight;
    }

    public final String getPictureUrl() {
        return this.pictureUrl;
    }

    public final Integer getPictureWidth() {
        return this.pictureWidth;
    }

    public final int getPid() {
        return this.pid;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getRawVideoUrl() {
        return this.rawVideoUrl;
    }

    public final String getRecId() {
        return this.recId;
    }

    public final Integer getSceneType() {
        return this.sceneType;
    }

    public final String getThumbPictureUrl() {
        return this.thumbPictureUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTrendType() {
        return this.trendType;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final Integer getVideoHeight() {
        return this.videoHeight;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final Integer getVideoStatus() {
        return this.videoStatus;
    }

    public final List<VideoType> getVideoUrlList() {
        return this.videoUrlList;
    }

    public final Integer getVideoWidth() {
        return this.videoWidth;
    }

    public final Long getViewCount() {
        return this.viewCount;
    }

    public final void setAlg(String str) {
        this.alg = str;
    }

    public final void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public final void setBeFollowedStatus(Boolean bool) {
        this.beFollowedStatus = bool;
    }

    public final void setCommentCount(String str) {
        this.commentCount = str;
    }

    public final void setDefaultDefinitionType(Integer num) {
        this.defaultDefinitionType = num;
    }

    public final void setDefaultVideoUrl(String str) {
        this.defaultVideoUrl = str;
    }

    public final void setDuration(Long l11) {
        this.duration = l11;
    }

    public final void setExposureType(int i11) {
        this.exposureType = i11;
    }

    public final void setFirstFrameUrl(String str) {
        this.firstFrameUrl = str;
    }

    public final void setFollowStatus(Boolean bool) {
        this.followStatus = bool;
    }

    public final void setId(String str) {
        this.f52333id = str;
    }

    public final void setLikeStatus(Boolean bool) {
        this.likeStatus = bool;
    }

    public final void setLikes(String str) {
        this.likes = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPictureHeight(Integer num) {
        this.pictureHeight = num;
    }

    public final void setPictureUrl(String str) {
        this.pictureUrl = str;
    }

    public final void setPictureWidth(Integer num) {
        this.pictureWidth = num;
    }

    public final void setPid(int i11) {
        this.pid = i11;
    }

    public final void setPosition(int i11) {
        this.position = i11;
    }

    public final void setRawVideoUrl(String str) {
        this.rawVideoUrl = str;
    }

    public final void setRecId(String str) {
        this.recId = str;
    }

    public final void setSceneType(Integer num) {
        this.sceneType = num;
    }

    public final void setThumbPictureUrl(String str) {
        this.thumbPictureUrl = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTrendType(int i11) {
        this.trendType = i11;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public final void setVideoHeight(Integer num) {
        this.videoHeight = num;
    }

    public final void setVideoId(String str) {
        this.videoId = str;
    }

    public final void setVideoStatus(Integer num) {
        this.videoStatus = num;
    }

    public final void setVideoUrlList(List<VideoType> list) {
        this.videoUrlList = list;
    }

    public final void setVideoWidth(Integer num) {
        this.videoWidth = num;
    }

    public final void setViewCount(Long l11) {
        this.viewCount = l11;
    }
}
