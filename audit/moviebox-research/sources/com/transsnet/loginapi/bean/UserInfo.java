package com.transsnet.loginapi.bean;

import androidx.annotation.Keep;
import com.applovin.sdk.AppLovinEventParameters;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public class UserInfo implements Serializable {

    @SerializedName("age")
    private int age;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("birthday")
    private String birthday;

    /* JADX INFO: renamed from: cc, reason: collision with root package name */
    @SerializedName("cc")
    private String f61683cc;

    @SerializedName(PlaceTypes.COUNTRY)
    private String country;
    private String email;

    @SerializedName("gender")
    private int gender;

    @SerializedName("nickname")
    private String nickname;
    private String pcc;

    @SerializedName("phone")
    private String phone;

    @SerializedName("province")
    private String province;

    @SerializedName("short_id")
    private String shortId;
    private String token;

    @SerializedName("userId")
    private String userId;
    private int userType;

    @SerializedName(AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER)
    private String username;

    public final int getAge() {
        return this.age;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final String getCc() {
        return this.f61683cc;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getEmail() {
        return this.email;
    }

    public final int getGender() {
        return this.gender;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getPcc() {
        return this.pcc;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getProvince() {
        return this.province;
    }

    public final String getShortId() {
        return this.shortId;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setAge(int i11) {
        this.age = i11;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setBirthday(String str) {
        this.birthday = str;
    }

    public final void setCc(String str) {
        this.f61683cc = str;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final void setGender(int i11) {
        this.gender = i11;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setPcc(String str) {
        this.pcc = str;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final void setProvince(String str) {
        this.province = str;
    }

    public final void setShortId(String str) {
        this.shortId = str;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setUserType(int i11) {
        this.userType = i11;
    }

    public final void setUsername(String str) {
        this.username = str;
    }
}
