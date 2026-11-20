package com.transsion.usercenter.edit;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.SerializedName;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class UserEntity implements Serializable {

    @SerializedName("age")
    private String age;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("city")
    private String city;

    @SerializedName(PlaceTypes.COUNTRY)
    private String country;

    @SerializedName("follower")
    private int follower;

    @SerializedName("following")
    private int following;

    @SerializedName("is_follow_he")
    private Boolean isFollowHe;

    @SerializedName("is_follow_me")
    private Boolean isFollowMe;

    @SerializedName("likes")
    private int likes;

    @SerializedName(alternate = {"user_name"}, value = "name")
    private String name;

    @SerializedName("sex")
    private String sex;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("videos")
    private int videos;
    private final String FEMALE = "F";
    private final String MALE = "M";

    @SerializedName("receive_likes")
    private String receiveLikes = "";
    private String tokenUpload = "";

    public final String getAge() {
        return this.age;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getFEMALE() {
        return this.FEMALE;
    }

    public final int getFollower() {
        return this.follower;
    }

    public final int getFollowing() {
        return this.following;
    }

    public final int getLikes() {
        return this.likes;
    }

    public final String getMALE() {
        return this.MALE;
    }

    public final String getName() {
        return this.name;
    }

    public final String getReceiveLikes() {
        return this.receiveLikes;
    }

    public final String getSex() {
        return this.sex;
    }

    public final String getTokenUpload() {
        return this.tokenUpload;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getVideos() {
        return this.videos;
    }

    public final boolean isFemale() {
        return Intrinsics.b(this.FEMALE, this.sex);
    }

    public final Boolean isFollowHe() {
        return this.isFollowHe;
    }

    public final Boolean isFollowMe() {
        return this.isFollowMe;
    }

    public final boolean isMale() {
        return Intrinsics.b(this.MALE, this.sex);
    }

    public final void setAge(String str) {
        this.age = str;
    }

    public final void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public final void setBirthday(String str) {
        this.birthday = str;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setFollowHe(Boolean bool) {
        this.isFollowHe = bool;
    }

    public final void setFollowMe(Boolean bool) {
        this.isFollowMe = bool;
    }

    public final void setFollower(int i11) {
        this.follower = i11;
    }

    public final void setFollowing(int i11) {
        this.following = i11;
    }

    public final void setLikes(int i11) {
        this.likes = i11;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setReceiveLikes(String str) {
        Intrinsics.g(str, "<set-?>");
        this.receiveLikes = str;
    }

    public final void setSex(String str) {
        this.sex = str;
    }

    public final void setTokenUpload(String str) {
        Intrinsics.g(str, "<set-?>");
        this.tokenUpload = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setVideos(int i11) {
        this.videos = i11;
    }
}
