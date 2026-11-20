package com.transsion.usercenter.edit.api;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RequstUserEntity implements Serializable {

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("birthday")
    private String birthday;
    private String city;

    @SerializedName(PlaceTypes.COUNTRY)
    private String country;

    @SerializedName("gender")
    private Integer gender;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f59311id;
    private String newAvatarPath;

    @SerializedName("nickname")
    private String nickname;
    private String tempBucket;
    private String userBio;
    private String userId;

    public final String getAvatar() {
        return this.avatar;
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

    public final Integer getGender() {
        return this.gender;
    }

    public final String getId() {
        return this.f59311id;
    }

    public final String getNewAvatarPath() {
        return this.newAvatarPath;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getTempBucket() {
        return this.tempBucket;
    }

    public final String getUserBio() {
        return this.userBio;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
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

    public final void setGender(Integer num) {
        this.gender = num;
    }

    public final void setId(String str) {
        this.f59311id = str;
    }

    public final void setNewAvatarPath(String str) {
        this.newAvatarPath = str;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setTempBucket(String str) {
        this.tempBucket = str;
    }

    public final void setUserBio(String str) {
        this.userBio = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }
}
