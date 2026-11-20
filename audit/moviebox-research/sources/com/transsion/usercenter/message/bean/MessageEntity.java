package com.transsion.usercenter.message.bean;

import androidx.core.app.NotificationCompat;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.web.api.WebConstants;
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
@Metadata
public final class MessageEntity implements Serializable {

    @SerializedName("commentImages")
    private List<Image> commentImages;

    @SerializedName(AppLovinEventTypes.USER_VIEWED_CONTENT)
    private String content;

    @SerializedName(WebConstants.FIELD_DEEPLINK)
    private String deeplink;

    @SerializedName("image")
    private Cover image;

    @SerializedName("id")
    private String messageId;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private String title;

    @SerializedName("createdAt")
    private String createdAt = "";

    @SerializedName("type")
    private String type = "";

    @SerializedName("avator")
    private String avator = "";

    @SerializedName("picture")
    private String picture = "";

    @SerializedName("url")
    private String url = "";

    @SerializedName("nickname")
    private String nickname = "";

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private String status = "";

    @SerializedName("sendUid")
    private String sendUid = "";

    @SerializedName("topicId")
    private String topicId = "";

    @SerializedName("commentId")
    private String commentId = "";

    @SerializedName("commentStatus")
    private String commentStatus = "";

    public final String getAvator() {
        return this.avator;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final List<Image> getCommentImages() {
        return this.commentImages;
    }

    public final String getCommentStatus() {
        return this.commentStatus;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final Cover getImage() {
        return this.image;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final String getSendUid() {
        return this.sendUid;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setAvator(String str) {
        Intrinsics.g(str, "<set-?>");
        this.avator = str;
    }

    public final void setCommentId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.commentId = str;
    }

    public final void setCommentImages(List<Image> list) {
        this.commentImages = list;
    }

    public final void setCommentStatus(String str) {
        Intrinsics.g(str, "<set-?>");
        this.commentStatus = str;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setCreatedAt(String str) {
        Intrinsics.g(str, "<set-?>");
        this.createdAt = str;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setImage(Cover cover) {
        this.image = cover;
    }

    public final void setMessageId(String str) {
        this.messageId = str;
    }

    public final void setNickname(String str) {
        Intrinsics.g(str, "<set-?>");
        this.nickname = str;
    }

    public final void setPicture(String str) {
        Intrinsics.g(str, "<set-?>");
        this.picture = str;
    }

    public final void setSendUid(String str) {
        Intrinsics.g(str, "<set-?>");
        this.sendUid = str;
    }

    public final void setStatus(String str) {
        Intrinsics.g(str, "<set-?>");
        this.status = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTopicId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.topicId = str;
    }

    public final void setType(String str) {
        Intrinsics.g(str, "<set-?>");
        this.type = str;
    }

    public final void setUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.url = str;
    }
}
