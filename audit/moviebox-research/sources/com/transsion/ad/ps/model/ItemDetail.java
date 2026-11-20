package com.transsion.ad.ps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class ItemDetail implements Parcelable {
    public static final Parcelable.Creator<ItemDetail> CREATOR = new a();
    private String downloadCount;
    private String iconUrl;
    private String img0;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private Integer isOffer;
    private String itemID;
    private String lan;
    private String name;
    private String packageName;
    private List<SafeTag> safeTagList;
    private Integer safetyStyle;
    private String score;
    private List<Integer> screenshotMode;
    private String simpleDescription;
    private String sourceSize;
    private String star;
    private List<Tag> tagList;
    private String versionCode;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<ItemDetail> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ItemDetail createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            String string10 = parcel.readString();
            String string11 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(i11);
                int i12 = 0;
                while (i12 != i11) {
                    arrayList4.add(parcel.readInt() == 0 ? null : SafeTag.CREATOR.createFromParcel(parcel));
                    i12++;
                    i11 = i11;
                }
                arrayList = arrayList4;
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i13 = parcel.readInt();
                ArrayList arrayList5 = new ArrayList(i13);
                int i14 = 0;
                while (i14 != i13) {
                    arrayList5.add(parcel.readInt() == 0 ? null : Tag.CREATOR.createFromParcel(parcel));
                    i14++;
                    i13 = i13;
                }
                arrayList2 = arrayList5;
            }
            Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string12 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList3 = null;
            } else {
                int i15 = parcel.readInt();
                ArrayList arrayList6 = new ArrayList(i15);
                int i16 = 0;
                while (i16 != i15) {
                    arrayList6.add(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                    i16++;
                    i15 = i15;
                }
                arrayList3 = arrayList6;
            }
            return new ItemDetail(string, string2, string3, string4, string5, string6, string7, numValueOf, string8, string9, string10, string11, arrayList, arrayList2, numValueOf2, string12, arrayList3, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ItemDetail[] newArray(int i11) {
            return new ItemDetail[i11];
        }
    }

    public ItemDetail(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, String str8, String str9, String str10, String str11, List<SafeTag> list, List<Tag> list2, Integer num2, String str12, List<Integer> list3, String str13, String str14, String str15, String str16) {
        this.downloadCount = str;
        this.iconUrl = str2;
        this.img0 = str3;
        this.img1 = str4;
        this.img2 = str5;
        this.img3 = str6;
        this.img4 = str7;
        this.isOffer = num;
        this.itemID = str8;
        this.lan = str9;
        this.name = str10;
        this.packageName = str11;
        this.safeTagList = list;
        this.tagList = list2;
        this.safetyStyle = num2;
        this.score = str12;
        this.screenshotMode = list3;
        this.simpleDescription = str13;
        this.sourceSize = str14;
        this.star = str15;
        this.versionCode = str16;
    }

    public final String component1() {
        return this.downloadCount;
    }

    public final String component10() {
        return this.lan;
    }

    public final String component11() {
        return this.name;
    }

    public final String component12() {
        return this.packageName;
    }

    public final List<SafeTag> component13() {
        return this.safeTagList;
    }

    public final List<Tag> component14() {
        return this.tagList;
    }

    public final Integer component15() {
        return this.safetyStyle;
    }

    public final String component16() {
        return this.score;
    }

    public final List<Integer> component17() {
        return this.screenshotMode;
    }

    public final String component18() {
        return this.simpleDescription;
    }

    public final String component19() {
        return this.sourceSize;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final String component20() {
        return this.star;
    }

    public final String component21() {
        return this.versionCode;
    }

    public final String component3() {
        return this.img0;
    }

    public final String component4() {
        return this.img1;
    }

    public final String component5() {
        return this.img2;
    }

    public final String component6() {
        return this.img3;
    }

    public final String component7() {
        return this.img4;
    }

    public final Integer component8() {
        return this.isOffer;
    }

    public final String component9() {
        return this.itemID;
    }

    public final ItemDetail copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, String str8, String str9, String str10, String str11, List<SafeTag> list, List<Tag> list2, Integer num2, String str12, List<Integer> list3, String str13, String str14, String str15, String str16) {
        return new ItemDetail(str, str2, str3, str4, str5, str6, str7, num, str8, str9, str10, str11, list, list2, num2, str12, list3, str13, str14, str15, str16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemDetail)) {
            return false;
        }
        ItemDetail itemDetail = (ItemDetail) obj;
        return Intrinsics.b(this.downloadCount, itemDetail.downloadCount) && Intrinsics.b(this.iconUrl, itemDetail.iconUrl) && Intrinsics.b(this.img0, itemDetail.img0) && Intrinsics.b(this.img1, itemDetail.img1) && Intrinsics.b(this.img2, itemDetail.img2) && Intrinsics.b(this.img3, itemDetail.img3) && Intrinsics.b(this.img4, itemDetail.img4) && Intrinsics.b(this.isOffer, itemDetail.isOffer) && Intrinsics.b(this.itemID, itemDetail.itemID) && Intrinsics.b(this.lan, itemDetail.lan) && Intrinsics.b(this.name, itemDetail.name) && Intrinsics.b(this.packageName, itemDetail.packageName) && Intrinsics.b(this.safeTagList, itemDetail.safeTagList) && Intrinsics.b(this.tagList, itemDetail.tagList) && Intrinsics.b(this.safetyStyle, itemDetail.safetyStyle) && Intrinsics.b(this.score, itemDetail.score) && Intrinsics.b(this.screenshotMode, itemDetail.screenshotMode) && Intrinsics.b(this.simpleDescription, itemDetail.simpleDescription) && Intrinsics.b(this.sourceSize, itemDetail.sourceSize) && Intrinsics.b(this.star, itemDetail.star) && Intrinsics.b(this.versionCode, itemDetail.versionCode);
    }

    public final String getDownloadCount() {
        return this.downloadCount;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getImg0() {
        return this.img0;
    }

    public final String getImg1() {
        return this.img1;
    }

    public final String getImg2() {
        return this.img2;
    }

    public final String getImg3() {
        return this.img3;
    }

    public final String getImg4() {
        return this.img4;
    }

    public final String getItemID() {
        return this.itemID;
    }

    public final String getLan() {
        return this.lan;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final List<SafeTag> getSafeTagList() {
        return this.safeTagList;
    }

    public final Integer getSafetyStyle() {
        return this.safetyStyle;
    }

    public final String getScore() {
        return this.score;
    }

    public final List<Integer> getScreenshotMode() {
        return this.screenshotMode;
    }

    public final String getSimpleDescription() {
        return this.simpleDescription;
    }

    public final String getSourceSize() {
        return this.sourceSize;
    }

    public final String getStar() {
        return this.star;
    }

    public final List<Tag> getTagList() {
        return this.tagList;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        String str = this.downloadCount;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.iconUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.img0;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.img1;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.img2;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.img3;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.img4;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.isOffer;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str8 = this.itemID;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.lan;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.name;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.packageName;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        List<SafeTag> list = this.safeTagList;
        int iHashCode13 = (iHashCode12 + (list == null ? 0 : list.hashCode())) * 31;
        List<Tag> list2 = this.tagList;
        int iHashCode14 = (iHashCode13 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num2 = this.safetyStyle;
        int iHashCode15 = (iHashCode14 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str12 = this.score;
        int iHashCode16 = (iHashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31;
        List<Integer> list3 = this.screenshotMode;
        int iHashCode17 = (iHashCode16 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str13 = this.simpleDescription;
        int iHashCode18 = (iHashCode17 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.sourceSize;
        int iHashCode19 = (iHashCode18 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.star;
        int iHashCode20 = (iHashCode19 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.versionCode;
        return iHashCode20 + (str16 != null ? str16.hashCode() : 0);
    }

    public final Integer isOffer() {
        return this.isOffer;
    }

    public final void setDownloadCount(String str) {
        this.downloadCount = str;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setImg0(String str) {
        this.img0 = str;
    }

    public final void setImg1(String str) {
        this.img1 = str;
    }

    public final void setImg2(String str) {
        this.img2 = str;
    }

    public final void setImg3(String str) {
        this.img3 = str;
    }

    public final void setImg4(String str) {
        this.img4 = str;
    }

    public final void setItemID(String str) {
        this.itemID = str;
    }

    public final void setLan(String str) {
        this.lan = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOffer(Integer num) {
        this.isOffer = num;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void setSafeTagList(List<SafeTag> list) {
        this.safeTagList = list;
    }

    public final void setSafetyStyle(Integer num) {
        this.safetyStyle = num;
    }

    public final void setScore(String str) {
        this.score = str;
    }

    public final void setScreenshotMode(List<Integer> list) {
        this.screenshotMode = list;
    }

    public final void setSimpleDescription(String str) {
        this.simpleDescription = str;
    }

    public final void setSourceSize(String str) {
        this.sourceSize = str;
    }

    public final void setStar(String str) {
        this.star = str;
    }

    public final void setTagList(List<Tag> list) {
        this.tagList = list;
    }

    public final void setVersionCode(String str) {
        this.versionCode = str;
    }

    public String toString() {
        return "ItemDetail(downloadCount=" + this.downloadCount + ", iconUrl=" + this.iconUrl + ", img0=" + this.img0 + ", img1=" + this.img1 + ", img2=" + this.img2 + ", img3=" + this.img3 + ", img4=" + this.img4 + ", isOffer=" + this.isOffer + ", itemID=" + this.itemID + ", lan=" + this.lan + ", name=" + this.name + ", packageName=" + this.packageName + ", safeTagList=" + this.safeTagList + ", tagList=" + this.tagList + ", safetyStyle=" + this.safetyStyle + ", score=" + this.score + ", screenshotMode=" + this.screenshotMode + ", simpleDescription=" + this.simpleDescription + ", sourceSize=" + this.sourceSize + ", star=" + this.star + ", versionCode=" + this.versionCode + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.downloadCount);
        out.writeString(this.iconUrl);
        out.writeString(this.img0);
        out.writeString(this.img1);
        out.writeString(this.img2);
        out.writeString(this.img3);
        out.writeString(this.img4);
        Integer num = this.isOffer;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.itemID);
        out.writeString(this.lan);
        out.writeString(this.name);
        out.writeString(this.packageName);
        List<SafeTag> list = this.safeTagList;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            for (SafeTag safeTag : list) {
                if (safeTag == null) {
                    out.writeInt(0);
                } else {
                    out.writeInt(1);
                    safeTag.writeToParcel(out, i11);
                }
            }
        }
        List<Tag> list2 = this.tagList;
        if (list2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list2.size());
            for (Tag tag : list2) {
                if (tag == null) {
                    out.writeInt(0);
                } else {
                    out.writeInt(1);
                    tag.writeToParcel(out, i11);
                }
            }
        }
        Integer num2 = this.safetyStyle;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        out.writeString(this.score);
        List<Integer> list3 = this.screenshotMode;
        if (list3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list3.size());
            for (Integer num3 : list3) {
                if (num3 == null) {
                    out.writeInt(0);
                } else {
                    out.writeInt(1);
                    out.writeInt(num3.intValue());
                }
            }
        }
        out.writeString(this.simpleDescription);
        out.writeString(this.sourceSize);
        out.writeString(this.star);
        out.writeString(this.versionCode);
    }
}
