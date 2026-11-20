package com.transsion.ad.ps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class RecommendInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<RecommendInfo> CREATOR = new a();
    private String adSource;
    private String buttonText;
    private String categoryCode;
    private String categoryName;
    private ItemDetail detail;
    private int downloadCount;
    private Boolean exists;
    private String gpLink;
    private String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f50556id;
    private int isOffer;
    private String itemID;
    private String name;
    private String offerDesc;
    private String packageName;
    private transient PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo;
    private transient String placementId;
    private String planName;
    private transient String sceneId;
    private String showContent;
    private int showType;
    private String simpleDescription;
    private long size;
    private String star;
    private transient TAdNativeInfo tAdNativeInfo;
    private String verifyGoogle;
    private int versionCode;
    private String versionName;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<RecommendInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RecommendInfo createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            ItemDetail itemDetailCreateFromParcel = parcel.readInt() == 0 ? null : ItemDetail.CREATOR.createFromParcel(parcel);
            int i11 = parcel.readInt();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            long j11 = parcel.readLong();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            int i12 = parcel.readInt();
            String string10 = parcel.readString();
            long j12 = parcel.readLong();
            int i13 = parcel.readInt();
            int i14 = parcel.readInt();
            String string11 = parcel.readString();
            String string12 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new RecommendInfo(string, string2, itemDetailCreateFromParcel, i11, string3, string4, string5, string6, string7, j11, string8, string9, i12, string10, j12, i13, i14, string11, string12, boolValueOf, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RecommendInfo[] newArray(int i11) {
            return new RecommendInfo[i11];
        }
    }

    public RecommendInfo() {
        this(null, null, null, 0, null, null, null, null, null, 0L, null, null, 0, null, 0L, 0, 0, null, null, null, null, null, null, null, 16777215, null);
    }

    public RecommendInfo(String str, String str2, ItemDetail itemDetail, int i11, String str3, String str4, String str5, String str6, String str7, long j11, String str8, String str9, int i12, String str10, long j12, int i13, int i14, String str11, String str12, Boolean bool, String str13, String str14, String str15, String str16) {
        this.categoryCode = str;
        this.categoryName = str2;
        this.detail = itemDetail;
        this.downloadCount = i11;
        this.iconUrl = str3;
        this.itemID = str4;
        this.offerDesc = str5;
        this.packageName = str6;
        this.simpleDescription = str7;
        this.size = j11;
        this.star = str8;
        this.verifyGoogle = str9;
        this.versionCode = i12;
        this.versionName = str10;
        this.f50556id = j12;
        this.isOffer = i13;
        this.showType = i14;
        this.planName = str11;
        this.name = str12;
        this.exists = bool;
        this.adSource = str13;
        this.buttonText = str14;
        this.gpLink = str15;
        this.showContent = str16;
    }

    public /* synthetic */ RecommendInfo(String str, String str2, ItemDetail itemDetail, int i11, String str3, String str4, String str5, String str6, String str7, long j11, String str8, String str9, int i12, String str10, long j12, int i13, int i14, String str11, String str12, Boolean bool, String str13, String str14, String str15, String str16, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? null : str, (i15 & 2) != 0 ? null : str2, (i15 & 4) != 0 ? null : itemDetail, (i15 & 8) != 0 ? 0 : i11, (i15 & 16) != 0 ? null : str3, (i15 & 32) != 0 ? null : str4, (i15 & 64) != 0 ? null : str5, (i15 & 128) != 0 ? null : str6, (i15 & 256) != 0 ? null : str7, (i15 & 512) != 0 ? 0L : j11, (i15 & 1024) != 0 ? null : str8, (i15 & 2048) != 0 ? null : str9, (i15 & 4096) != 0 ? 0 : i12, (i15 & 8192) != 0 ? null : str10, (i15 & 16384) != 0 ? 0L : j12, (32768 & i15) != 0 ? 0 : i13, (i15 & 65536) != 0 ? 0 : i14, (i15 & 131072) != 0 ? null : str11, (i15 & 262144) != 0 ? null : str12, (i15 & 524288) != 0 ? null : bool, (i15 & 1048576) != 0 ? null : str13, (i15 & 2097152) != 0 ? null : str14, (i15 & 4194304) != 0 ? null : str15, (i15 & 8388608) != 0 ? null : str16);
    }

    public static /* synthetic */ void getPalmStoreDownLoadTaskInfo$annotations() {
    }

    public static /* synthetic */ void getPlacementId$annotations() {
    }

    public static /* synthetic */ void getSceneId$annotations() {
    }

    public static /* synthetic */ void getTAdNativeInfo$annotations() {
    }

    public final String component1() {
        return this.categoryCode;
    }

    public final long component10() {
        return this.size;
    }

    public final String component11() {
        return this.star;
    }

    public final String component12() {
        return this.verifyGoogle;
    }

    public final int component13() {
        return this.versionCode;
    }

    public final String component14() {
        return this.versionName;
    }

    public final long component15() {
        return this.f50556id;
    }

    public final int component16() {
        return this.isOffer;
    }

    public final int component17() {
        return this.showType;
    }

    public final String component18() {
        return this.planName;
    }

    public final String component19() {
        return this.name;
    }

    public final String component2() {
        return this.categoryName;
    }

    public final Boolean component20() {
        return this.exists;
    }

    public final String component21() {
        return this.adSource;
    }

    public final String component22() {
        return this.buttonText;
    }

    public final String component23() {
        return this.gpLink;
    }

    public final String component24() {
        return this.showContent;
    }

    public final ItemDetail component3() {
        return this.detail;
    }

    public final int component4() {
        return this.downloadCount;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final String component6() {
        return this.itemID;
    }

    public final String component7() {
        return this.offerDesc;
    }

    public final String component8() {
        return this.packageName;
    }

    public final String component9() {
        return this.simpleDescription;
    }

    public final RecommendInfo copy(String str, String str2, ItemDetail itemDetail, int i11, String str3, String str4, String str5, String str6, String str7, long j11, String str8, String str9, int i12, String str10, long j12, int i13, int i14, String str11, String str12, Boolean bool, String str13, String str14, String str15, String str16) {
        return new RecommendInfo(str, str2, itemDetail, i11, str3, str4, str5, str6, str7, j11, str8, str9, i12, str10, j12, i13, i14, str11, str12, bool, str13, str14, str15, str16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendInfo)) {
            return false;
        }
        RecommendInfo recommendInfo = (RecommendInfo) obj;
        return Intrinsics.b(this.categoryCode, recommendInfo.categoryCode) && Intrinsics.b(this.categoryName, recommendInfo.categoryName) && Intrinsics.b(this.detail, recommendInfo.detail) && this.downloadCount == recommendInfo.downloadCount && Intrinsics.b(this.iconUrl, recommendInfo.iconUrl) && Intrinsics.b(this.itemID, recommendInfo.itemID) && Intrinsics.b(this.offerDesc, recommendInfo.offerDesc) && Intrinsics.b(this.packageName, recommendInfo.packageName) && Intrinsics.b(this.simpleDescription, recommendInfo.simpleDescription) && this.size == recommendInfo.size && Intrinsics.b(this.star, recommendInfo.star) && Intrinsics.b(this.verifyGoogle, recommendInfo.verifyGoogle) && this.versionCode == recommendInfo.versionCode && Intrinsics.b(this.versionName, recommendInfo.versionName) && this.f50556id == recommendInfo.f50556id && this.isOffer == recommendInfo.isOffer && this.showType == recommendInfo.showType && Intrinsics.b(this.planName, recommendInfo.planName) && Intrinsics.b(this.name, recommendInfo.name) && Intrinsics.b(this.exists, recommendInfo.exists) && Intrinsics.b(this.adSource, recommendInfo.adSource) && Intrinsics.b(this.buttonText, recommendInfo.buttonText) && Intrinsics.b(this.gpLink, recommendInfo.gpLink) && Intrinsics.b(this.showContent, recommendInfo.showContent);
    }

    public final String getAdSource() {
        return this.adSource;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getCategoryCode() {
        return this.categoryCode;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final ItemDetail getDetail() {
        return this.detail;
    }

    public final int getDownloadCount() {
        return this.downloadCount;
    }

    public final Boolean getExists() {
        return this.exists;
    }

    public final String getGpLink() {
        return this.gpLink;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final long getId() {
        return this.f50556id;
    }

    public final String getItemID() {
        return this.itemID;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOfferDesc() {
        return this.offerDesc;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final PalmStoreDownLoadTaskInfo getPalmStoreDownLoadTaskInfo() {
        return this.palmStoreDownLoadTaskInfo;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final String getPlanName() {
        return this.planName;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final String getShowContent() {
        return this.showContent;
    }

    public final int getShowType() {
        return this.showType;
    }

    public final String getSimpleDescription() {
        return this.simpleDescription;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getStar() {
        return this.star;
    }

    public final TAdNativeInfo getTAdNativeInfo() {
        return this.tAdNativeInfo;
    }

    public final String getVerifyGoogle() {
        return this.verifyGoogle;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        String str = this.categoryCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.categoryName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ItemDetail itemDetail = this.detail;
        int iHashCode3 = (((iHashCode2 + (itemDetail == null ? 0 : itemDetail.hashCode())) * 31) + this.downloadCount) * 31;
        String str3 = this.iconUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.itemID;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.offerDesc;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.packageName;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.simpleDescription;
        int iHashCode8 = (((iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + p.a(this.size)) * 31;
        String str8 = this.star;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.verifyGoogle;
        int iHashCode10 = (((iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31) + this.versionCode) * 31;
        String str10 = this.versionName;
        int iHashCode11 = (((((((iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31) + p.a(this.f50556id)) * 31) + this.isOffer) * 31) + this.showType) * 31;
        String str11 = this.planName;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.name;
        int iHashCode13 = (iHashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Boolean bool = this.exists;
        int iHashCode14 = (iHashCode13 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str13 = this.adSource;
        int iHashCode15 = (iHashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.buttonText;
        int iHashCode16 = (iHashCode15 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.gpLink;
        int iHashCode17 = (iHashCode16 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.showContent;
        return iHashCode17 + (str16 != null ? str16.hashCode() : 0);
    }

    public final int isOffer() {
        return this.isOffer;
    }

    public final void setAdSource(String str) {
        this.adSource = str;
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public final void setCategoryCode(String str) {
        this.categoryCode = str;
    }

    public final void setCategoryName(String str) {
        this.categoryName = str;
    }

    public final void setDetail(ItemDetail itemDetail) {
        this.detail = itemDetail;
    }

    public final void setDownloadCount(int i11) {
        this.downloadCount = i11;
    }

    public final void setExists(Boolean bool) {
        this.exists = bool;
    }

    public final void setGpLink(String str) {
        this.gpLink = str;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setId(long j11) {
        this.f50556id = j11;
    }

    public final void setItemID(String str) {
        this.itemID = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOffer(int i11) {
        this.isOffer = i11;
    }

    public final void setOfferDesc(String str) {
        this.offerDesc = str;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void setPalmStoreDownLoadTaskInfo(PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo) {
        this.palmStoreDownLoadTaskInfo = palmStoreDownLoadTaskInfo;
    }

    public final void setPlacementId(String str) {
        this.placementId = str;
    }

    public final void setPlanName(String str) {
        this.planName = str;
    }

    public final void setSceneId(String str) {
        this.sceneId = str;
    }

    public final void setShowContent(String str) {
        this.showContent = str;
    }

    public final void setShowType(int i11) {
        this.showType = i11;
    }

    public final void setSimpleDescription(String str) {
        this.simpleDescription = str;
    }

    public final void setSize(long j11) {
        this.size = j11;
    }

    public final void setStar(String str) {
        this.star = str;
    }

    public final void setTAdNativeInfo(TAdNativeInfo tAdNativeInfo) {
        this.tAdNativeInfo = tAdNativeInfo;
    }

    public final void setVerifyGoogle(String str) {
        this.verifyGoogle = str;
    }

    public final void setVersionCode(int i11) {
        this.versionCode = i11;
    }

    public final void setVersionName(String str) {
        this.versionName = str;
    }

    public String toString() {
        return "RecommendInfo(categoryCode=" + this.categoryCode + ", categoryName=" + this.categoryName + ", detail=" + this.detail + ", downloadCount=" + this.downloadCount + ", iconUrl=" + this.iconUrl + ", itemID=" + this.itemID + ", offerDesc=" + this.offerDesc + ", packageName=" + this.packageName + ", simpleDescription=" + this.simpleDescription + ", size=" + this.size + ", star=" + this.star + ", verifyGoogle=" + this.verifyGoogle + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", id=" + this.f50556id + ", isOffer=" + this.isOffer + ", showType=" + this.showType + ", planName=" + this.planName + ", name=" + this.name + ", exists=" + this.exists + ", adSource=" + this.adSource + ", buttonText=" + this.buttonText + ", gpLink=" + this.gpLink + ", showContent=" + this.showContent + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.categoryCode);
        out.writeString(this.categoryName);
        ItemDetail itemDetail = this.detail;
        if (itemDetail == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            itemDetail.writeToParcel(out, i11);
        }
        out.writeInt(this.downloadCount);
        out.writeString(this.iconUrl);
        out.writeString(this.itemID);
        out.writeString(this.offerDesc);
        out.writeString(this.packageName);
        out.writeString(this.simpleDescription);
        out.writeLong(this.size);
        out.writeString(this.star);
        out.writeString(this.verifyGoogle);
        out.writeInt(this.versionCode);
        out.writeString(this.versionName);
        out.writeLong(this.f50556id);
        out.writeInt(this.isOffer);
        out.writeInt(this.showType);
        out.writeString(this.planName);
        out.writeString(this.name);
        Boolean bool = this.exists;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        out.writeString(this.adSource);
        out.writeString(this.buttonText);
        out.writeString(this.gpLink);
        out.writeString(this.showContent);
    }
}
