package com.transsion.ad.ps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class PsLinkAdInfo implements Parcelable {
    public static final Parcelable.Creator<PsLinkAdInfo> CREATOR = new a();
    private String advertiserAvatar;
    private String advertiserAvatarPath;
    private String advertiserName;
    private String buttonText;
    private final String desc;
    private String path;
    private final String title;
    private String url;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PsLinkAdInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PsLinkAdInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PsLinkAdInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PsLinkAdInfo[] newArray(int i11) {
            return new PsLinkAdInfo[i11];
        }
    }

    public PsLinkAdInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public PsLinkAdInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.advertiserName = str;
        this.advertiserAvatar = str2;
        this.advertiserAvatarPath = str3;
        this.title = str4;
        this.desc = str5;
        this.buttonText = str6;
        this.url = str7;
        this.path = str8;
    }

    public /* synthetic */ PsLinkAdInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7, (i11 & 128) == 0 ? str8 : null);
    }

    public final String component1() {
        return this.advertiserName;
    }

    public final String component2() {
        return this.advertiserAvatar;
    }

    public final String component3() {
        return this.advertiserAvatarPath;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.desc;
    }

    public final String component6() {
        return this.buttonText;
    }

    public final String component7() {
        return this.url;
    }

    public final String component8() {
        return this.path;
    }

    public final PsLinkAdInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new PsLinkAdInfo(str, str2, str3, str4, str5, str6, str7, str8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PsLinkAdInfo)) {
            return false;
        }
        PsLinkAdInfo psLinkAdInfo = (PsLinkAdInfo) obj;
        return Intrinsics.b(this.advertiserName, psLinkAdInfo.advertiserName) && Intrinsics.b(this.advertiserAvatar, psLinkAdInfo.advertiserAvatar) && Intrinsics.b(this.advertiserAvatarPath, psLinkAdInfo.advertiserAvatarPath) && Intrinsics.b(this.title, psLinkAdInfo.title) && Intrinsics.b(this.desc, psLinkAdInfo.desc) && Intrinsics.b(this.buttonText, psLinkAdInfo.buttonText) && Intrinsics.b(this.url, psLinkAdInfo.url) && Intrinsics.b(this.path, psLinkAdInfo.path);
    }

    public final String getAdvertiserAvatar() {
        return this.advertiserAvatar;
    }

    public final String getAdvertiserAvatarPath() {
        return this.advertiserAvatarPath;
    }

    public final String getAdvertiserName() {
        return this.advertiserName;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.advertiserName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.advertiserAvatar;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.advertiserAvatarPath;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.desc;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.buttonText;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.url;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.path;
        return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public final void setAdvertiserAvatar(String str) {
        this.advertiserAvatar = str;
    }

    public final void setAdvertiserAvatarPath(String str) {
        this.advertiserAvatarPath = str;
    }

    public final void setAdvertiserName(String str) {
        this.advertiserName = str;
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "PsLinkAdInfo(advertiserName=" + this.advertiserName + ", advertiserAvatar=" + this.advertiserAvatar + ", advertiserAvatarPath=" + this.advertiserAvatarPath + ", title=" + this.title + ", desc=" + this.desc + ", buttonText=" + this.buttonText + ", url=" + this.url + ", path=" + this.path + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.advertiserName);
        out.writeString(this.advertiserAvatar);
        out.writeString(this.advertiserAvatarPath);
        out.writeString(this.title);
        out.writeString(this.desc);
        out.writeString(this.buttonText);
        out.writeString(this.url);
        out.writeString(this.path);
    }
}
