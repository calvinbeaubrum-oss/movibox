package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.applovin.sdk.AppLovinEventParameters;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class User implements Serializable {

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("userId")
    private String userId;

    @SerializedName(AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER)
    private String username;

    public User(String str, String str2, String str3, String str4) {
        this.avatar = str;
        this.nickname = str2;
        this.userId = str3;
        this.username = str4;
    }

    public static /* synthetic */ User copy$default(User user, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = user.avatar;
        }
        if ((i11 & 2) != 0) {
            str2 = user.nickname;
        }
        if ((i11 & 4) != 0) {
            str3 = user.userId;
        }
        if ((i11 & 8) != 0) {
            str4 = user.username;
        }
        return user.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component2() {
        return this.nickname;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.username;
    }

    public final User copy(String str, String str2, String str3, String str4) {
        return new User(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return Intrinsics.b(this.avatar, user.avatar) && Intrinsics.b(this.nickname, user.nickname) && Intrinsics.b(this.userId, user.userId) && Intrinsics.b(this.username, user.username);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.avatar;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.nickname;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.username;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        return "User(avatar=" + this.avatar + ", nickname=" + this.nickname + ", userId=" + this.userId + ", username=" + this.username + ")";
    }
}
