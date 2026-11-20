package com.transsion.postdetail.bean;

import androidx.annotation.Keep;
import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.config.utils.CommonUtils;
import com.google.gson.annotations.SerializedName;
import com.transsion.moviedetailapi.bean.Cover;
import e9.a;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rv.b;

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
public final class CommentBean implements Serializable, a {

    @SerializedName("avatarUrl")
    private String avatarUrl;

    @SerializedName("commentId")
    private String commentId;

    @SerializedName(AppLovinEventTypes.USER_VIEWED_CONTENT)
    private String content;

    @SerializedName("createdAt")
    private Long createdAt;

    @SerializedName("gender")
    private Integer gender;

    @SerializedName("imageList")
    private List<Cover> imageList;

    @SerializedName("likeCnt")
    private int likeCnt;

    @SerializedName("likeStatu")
    private Boolean likeStatu;
    private b localParam;

    @SerializedName("nickName")
    private String nickName;

    @SerializedName("replyedCommentId")
    private String replyedCommentId;

    @SerializedName("replyedNickName")
    private String replyedNickName;

    @SerializedName("replyedUid")
    private String replyedUid;

    @SerializedName("rootCommentId")
    private String rootCommentId;

    @SerializedName("subCommentCnt")
    private int subCommentCnt;

    @SerializedName("subComments")
    private List<CommentBean> subComments;

    @SerializedName("topicId")
    private String topicId;

    @SerializedName("topicType")
    private String topicType;

    @SerializedName(CommonUtils.PARAM_UID)
    private String uid;

    public CommentBean(String str, String str2, String str3, Long l11, Integer num, int i11, Boolean bool, String str4, String str5, String str6, String str7, String str8, int i12, List<CommentBean> list, String str9, String str10, String str11, List<Cover> list2, b bVar) {
        this.avatarUrl = str;
        this.commentId = str2;
        this.content = str3;
        this.createdAt = l11;
        this.gender = num;
        this.likeCnt = i11;
        this.likeStatu = bool;
        this.nickName = str4;
        this.replyedCommentId = str5;
        this.replyedNickName = str6;
        this.replyedUid = str7;
        this.rootCommentId = str8;
        this.subCommentCnt = i12;
        this.subComments = list;
        this.topicId = str9;
        this.topicType = str10;
        this.uid = str11;
        this.imageList = list2;
    }

    public /* synthetic */ CommentBean(String str, String str2, String str3, Long l11, Integer num, int i11, Boolean bool, String str4, String str5, String str6, String str7, String str8, int i12, List list, String str9, String str10, String str11, List list2, b bVar, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, l11, num, (i13 & 32) != 0 ? 0 : i11, bool, str4, str5, str6, str7, str8, (i13 & 4096) != 0 ? 0 : i12, list, str9, str10, str11, list2, (i13 & 262144) != 0 ? null : bVar);
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final Integer getGender() {
        return this.gender;
    }

    public final List<Cover> getImageList() {
        return this.imageList;
    }

    @Override // e9.a
    public int getItemType() {
        return isSubComment() ? 1 : 0;
    }

    public final int getLikeCnt() {
        return this.likeCnt;
    }

    public final Boolean getLikeStatu() {
        return this.likeStatu;
    }

    public final b getLocalParam() {
        return null;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getReplyedCommentId() {
        return this.replyedCommentId;
    }

    public final String getReplyedNickName() {
        return this.replyedNickName;
    }

    public final String getReplyedUid() {
        return this.replyedUid;
    }

    public final String getRootCommentId() {
        return this.rootCommentId;
    }

    public final int getSubCommentCnt() {
        return this.subCommentCnt;
    }

    public final List<CommentBean> getSubComments() {
        return this.subComments;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public final String getTopicType() {
        return this.topicType;
    }

    public final String getUid() {
        return this.uid;
    }

    public final boolean isSubComment() {
        return !Intrinsics.b(this.rootCommentId, "0");
    }

    public final void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public final void setCommentId(String str) {
        this.commentId = str;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setCreatedAt(Long l11) {
        this.createdAt = l11;
    }

    public final void setGender(Integer num) {
        this.gender = num;
    }

    public final void setImageList(List<Cover> list) {
        this.imageList = list;
    }

    public final void setLikeCnt(int i11) {
        this.likeCnt = i11;
    }

    public final void setLikeStatu(Boolean bool) {
        this.likeStatu = bool;
    }

    public final void setLocalParam(b bVar) {
    }

    public final void setNickName(String str) {
        this.nickName = str;
    }

    public final void setReplyedCommentId(String str) {
        this.replyedCommentId = str;
    }

    public final void setReplyedNickName(String str) {
        this.replyedNickName = str;
    }

    public final void setReplyedUid(String str) {
        this.replyedUid = str;
    }

    public final void setRootCommentId(String str) {
        this.rootCommentId = str;
    }

    public final void setSubCommentCnt(int i11) {
        this.subCommentCnt = i11;
    }

    public final void setSubComments(List<CommentBean> list) {
        this.subComments = list;
    }

    public final void setTopicId(String str) {
        this.topicId = str;
    }

    public final void setTopicType(String str) {
        this.topicType = str;
    }

    public final void setUid(String str) {
        this.uid = str;
    }
}
