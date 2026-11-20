package com.transsion.usercenter.net;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class CreateModifyUserInfoRequestEntity implements Parcelable {
    public static final Parcelable.Creator<CreateModifyUserInfoRequestEntity> CREATOR = new a();
    private String avatar;
    private String birthday;
    private String city;
    private String country;
    private int gender;
    private String newAvatarPath;
    private String nickname;
    private String province;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CreateModifyUserInfoRequestEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CreateModifyUserInfoRequestEntity createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CreateModifyUserInfoRequestEntity(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CreateModifyUserInfoRequestEntity[] newArray(int i11) {
            return new CreateModifyUserInfoRequestEntity[i11];
        }
    }

    public CreateModifyUserInfoRequestEntity(String nickname, String avatar, String newAvatarPath, int i11, String birthday, String country, String province, String city) {
        Intrinsics.g(nickname, "nickname");
        Intrinsics.g(avatar, "avatar");
        Intrinsics.g(newAvatarPath, "newAvatarPath");
        Intrinsics.g(birthday, "birthday");
        Intrinsics.g(country, "country");
        Intrinsics.g(province, "province");
        Intrinsics.g(city, "city");
        this.nickname = nickname;
        this.avatar = avatar;
        this.newAvatarPath = newAvatarPath;
        this.gender = i11;
        this.birthday = birthday;
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public final String component1() {
        return this.nickname;
    }

    public final String component2() {
        return this.avatar;
    }

    public final String component3() {
        return this.newAvatarPath;
    }

    public final int component4() {
        return this.gender;
    }

    public final String component5() {
        return this.birthday;
    }

    public final String component6() {
        return this.country;
    }

    public final String component7() {
        return this.province;
    }

    public final String component8() {
        return this.city;
    }

    public final CreateModifyUserInfoRequestEntity copy(String nickname, String avatar, String newAvatarPath, int i11, String birthday, String country, String province, String city) {
        Intrinsics.g(nickname, "nickname");
        Intrinsics.g(avatar, "avatar");
        Intrinsics.g(newAvatarPath, "newAvatarPath");
        Intrinsics.g(birthday, "birthday");
        Intrinsics.g(country, "country");
        Intrinsics.g(province, "province");
        Intrinsics.g(city, "city");
        return new CreateModifyUserInfoRequestEntity(nickname, avatar, newAvatarPath, i11, birthday, country, province, city);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateModifyUserInfoRequestEntity)) {
            return false;
        }
        CreateModifyUserInfoRequestEntity createModifyUserInfoRequestEntity = (CreateModifyUserInfoRequestEntity) obj;
        return Intrinsics.b(this.nickname, createModifyUserInfoRequestEntity.nickname) && Intrinsics.b(this.avatar, createModifyUserInfoRequestEntity.avatar) && Intrinsics.b(this.newAvatarPath, createModifyUserInfoRequestEntity.newAvatarPath) && this.gender == createModifyUserInfoRequestEntity.gender && Intrinsics.b(this.birthday, createModifyUserInfoRequestEntity.birthday) && Intrinsics.b(this.country, createModifyUserInfoRequestEntity.country) && Intrinsics.b(this.province, createModifyUserInfoRequestEntity.province) && Intrinsics.b(this.city, createModifyUserInfoRequestEntity.city);
    }

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

    public final int getGender() {
        return this.gender;
    }

    public final String getNewAvatarPath() {
        return this.newAvatarPath;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getProvince() {
        return this.province;
    }

    public int hashCode() {
        return (((((((((((((this.nickname.hashCode() * 31) + this.avatar.hashCode()) * 31) + this.newAvatarPath.hashCode()) * 31) + this.gender) * 31) + this.birthday.hashCode()) * 31) + this.country.hashCode()) * 31) + this.province.hashCode()) * 31) + this.city.hashCode();
    }

    public final void setAvatar(String str) {
        Intrinsics.g(str, "<set-?>");
        this.avatar = str;
    }

    public final void setBirthday(String str) {
        Intrinsics.g(str, "<set-?>");
        this.birthday = str;
    }

    public final void setCity(String str) {
        Intrinsics.g(str, "<set-?>");
        this.city = str;
    }

    public final void setCountry(String str) {
        Intrinsics.g(str, "<set-?>");
        this.country = str;
    }

    public final void setGender(int i11) {
        this.gender = i11;
    }

    public final void setNewAvatarPath(String str) {
        Intrinsics.g(str, "<set-?>");
        this.newAvatarPath = str;
    }

    public final void setNickname(String str) {
        Intrinsics.g(str, "<set-?>");
        this.nickname = str;
    }

    public final void setProvince(String str) {
        Intrinsics.g(str, "<set-?>");
        this.province = str;
    }

    public String toString() {
        return "CreateModifyUserInfoRequestEntity(nickname=" + this.nickname + ", avatar=" + this.avatar + ", newAvatarPath=" + this.newAvatarPath + ", gender=" + this.gender + ", birthday=" + this.birthday + ", country=" + this.country + ", province=" + this.province + ", city=" + this.city + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.nickname);
        out.writeString(this.avatar);
        out.writeString(this.newAvatarPath);
        out.writeInt(this.gender);
        out.writeString(this.birthday);
        out.writeString(this.country);
        out.writeString(this.province);
        out.writeString(this.city);
    }
}
