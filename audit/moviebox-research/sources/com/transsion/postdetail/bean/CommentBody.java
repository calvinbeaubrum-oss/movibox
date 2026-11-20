package com.transsion.postdetail.bean;

import androidx.annotation.Keep;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.gson.annotations.SerializedName;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class CommentBody {

    @SerializedName("bucket")
    private String bucket;

    @SerializedName(AppLovinEventTypes.USER_VIEWED_CONTENT)
    private String content;

    @SerializedName("imageList")
    private List<String> imageList;

    @SerializedName("replyedCommentId")
    private String replyedCommentId;

    @SerializedName("replyedUid")
    private String replyedUid;

    @SerializedName("rootCommentId")
    private String rootCommentId;

    @SerializedName("topicId")
    private String topicId;

    @SerializedName("topicType")
    private String topicType;

    public CommentBody(String str, String str2, String str3, String str4, String str5, List<String> list, String str6, String str7) {
        this.content = str;
        this.rootCommentId = str2;
        this.replyedCommentId = str3;
        this.replyedUid = str4;
        this.topicId = str5;
        this.imageList = list;
        this.bucket = str6;
        this.topicType = str7;
    }

    public final String component1() {
        return this.content;
    }

    public final String component2() {
        return this.rootCommentId;
    }

    public final String component3() {
        return this.replyedCommentId;
    }

    public final String component4() {
        return this.replyedUid;
    }

    public final String component5() {
        return this.topicId;
    }

    public final List<String> component6() {
        return this.imageList;
    }

    public final String component7() {
        return this.bucket;
    }

    public final String component8() {
        return this.topicType;
    }

    public final CommentBody copy(String str, String str2, String str3, String str4, String str5, List<String> list, String str6, String str7) {
        return new CommentBody(str, str2, str3, str4, str5, list, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentBody)) {
            return false;
        }
        CommentBody commentBody = (CommentBody) obj;
        return Intrinsics.b(this.content, commentBody.content) && Intrinsics.b(this.rootCommentId, commentBody.rootCommentId) && Intrinsics.b(this.replyedCommentId, commentBody.replyedCommentId) && Intrinsics.b(this.replyedUid, commentBody.replyedUid) && Intrinsics.b(this.topicId, commentBody.topicId) && Intrinsics.b(this.imageList, commentBody.imageList) && Intrinsics.b(this.bucket, commentBody.bucket) && Intrinsics.b(this.topicType, commentBody.topicType);
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<String> getImageList() {
        return this.imageList;
    }

    public final String getReplyedCommentId() {
        return this.replyedCommentId;
    }

    public final String getReplyedUid() {
        return this.replyedUid;
    }

    public final String getRootCommentId() {
        return this.rootCommentId;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public final String getTopicType() {
        return this.topicType;
    }

    public int hashCode() {
        String str = this.content;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.rootCommentId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.replyedCommentId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.replyedUid;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.topicId;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<String> list = this.imageList;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str6 = this.bucket;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.topicType;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setBucket(String str) {
        this.bucket = str;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setImageList(List<String> list) {
        this.imageList = list;
    }

    public final void setReplyedCommentId(String str) {
        this.replyedCommentId = str;
    }

    public final void setReplyedUid(String str) {
        this.replyedUid = str;
    }

    public final void setRootCommentId(String str) {
        this.rootCommentId = str;
    }

    public final void setTopicId(String str) {
        this.topicId = str;
    }

    public final void setTopicType(String str) {
        this.topicType = str;
    }

    public String toString() {
        return "CommentBody(content=" + this.content + ", rootCommentId=" + this.rootCommentId + ", replyedCommentId=" + this.replyedCommentId + ", replyedUid=" + this.replyedUid + ", topicId=" + this.topicId + ", imageList=" + this.imageList + ", bucket=" + this.bucket + ", topicType=" + this.topicType + ")";
    }
}
