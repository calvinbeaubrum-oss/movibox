package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.home.p003enum.BottomTabType;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class HomeTabItem implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<HomeTabItem> CREATOR = new a();
    private String displayType;
    private String name;
    private NameImage nameImage;
    private NameImage selectNameImage;
    private String tabCode;
    private Integer tabId;
    private String type;
    private String url;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<HomeTabItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HomeTabItem createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new HomeTabItem(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : NameImage.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? NameImage.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HomeTabItem[] newArray(int i11) {
            return new HomeTabItem[i11];
        }
    }

    public HomeTabItem(String str, Integer num, String str2, String url, String str3, NameImage nameImage, NameImage nameImage2, String str4) {
        Intrinsics.g(url, "url");
        this.name = str;
        this.tabId = num;
        this.type = str2;
        this.url = url;
        this.tabCode = str3;
        this.nameImage = nameImage;
        this.selectNameImage = nameImage2;
        this.displayType = str4;
    }

    public /* synthetic */ HomeTabItem(String str, Integer num, String str2, String str3, String str4, NameImage nameImage, NameImage nameImage2, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, num, str2, str3, str4, (i11 & 32) != 0 ? null : nameImage, (i11 & 64) != 0 ? null : nameImage2, (i11 & 128) != 0 ? BottomTabType.TAB_OPEN_TYPE_TAB : str5);
    }

    public final String component1() {
        return this.name;
    }

    public final Integer component2() {
        return this.tabId;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.url;
    }

    public final String component5() {
        return this.tabCode;
    }

    public final NameImage component6() {
        return this.nameImage;
    }

    public final NameImage component7() {
        return this.selectNameImage;
    }

    public final String component8() {
        return this.displayType;
    }

    public final HomeTabItem copy(String str, Integer num, String str2, String url, String str3, NameImage nameImage, NameImage nameImage2, String str4) {
        Intrinsics.g(url, "url");
        return new HomeTabItem(str, num, str2, url, str3, nameImage, nameImage2, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeTabItem)) {
            return false;
        }
        HomeTabItem homeTabItem = (HomeTabItem) obj;
        return Intrinsics.b(this.name, homeTabItem.name) && Intrinsics.b(this.tabId, homeTabItem.tabId) && Intrinsics.b(this.type, homeTabItem.type) && Intrinsics.b(this.url, homeTabItem.url) && Intrinsics.b(this.tabCode, homeTabItem.tabCode) && Intrinsics.b(this.nameImage, homeTabItem.nameImage) && Intrinsics.b(this.selectNameImage, homeTabItem.selectNameImage) && Intrinsics.b(this.displayType, homeTabItem.displayType);
    }

    public final String getDisplayType() {
        return this.displayType;
    }

    public final String getName() {
        return this.name;
    }

    public final NameImage getNameImage() {
        return this.nameImage;
    }

    public final NameImage getSelectNameImage() {
        return this.selectNameImage;
    }

    public final String getTabCode() {
        return this.tabCode;
    }

    public final Integer getTabId() {
        return this.tabId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.tabId;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.type;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.url.hashCode()) * 31;
        String str3 = this.tabCode;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        NameImage nameImage = this.nameImage;
        int iHashCode5 = (iHashCode4 + (nameImage == null ? 0 : nameImage.hashCode())) * 31;
        NameImage nameImage2 = this.selectNameImage;
        int iHashCode6 = (iHashCode5 + (nameImage2 == null ? 0 : nameImage2.hashCode())) * 31;
        String str4 = this.displayType;
        return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public final boolean isOpenLandPage() {
        String str;
        return (!Intrinsics.b(this.displayType, BottomTabType.TAB_OPEN_TYPE_LAND_PAGE) || (str = this.url) == null || str.length() == 0) ? false : true;
    }

    public final void setDisplayType(String str) {
        this.displayType = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setNameImage(NameImage nameImage) {
        this.nameImage = nameImage;
    }

    public final void setSelectNameImage(NameImage nameImage) {
        this.selectNameImage = nameImage;
    }

    public final void setTabCode(String str) {
        this.tabCode = str;
    }

    public final void setTabId(Integer num) {
        this.tabId = num;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        return "HomeTabItem(name=" + this.name + ", tabId=" + this.tabId + ", type=" + this.type + ", url=" + this.url + ", tabCode=" + this.tabCode + ", nameImage=" + this.nameImage + ", selectNameImage=" + this.selectNameImage + ", displayType=" + this.displayType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.name);
        Integer num = this.tabId;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.type);
        out.writeString(this.url);
        out.writeString(this.tabCode);
        NameImage nameImage = this.nameImage;
        if (nameImage == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            nameImage.writeToParcel(out, i11);
        }
        NameImage nameImage2 = this.selectNameImage;
        if (nameImage2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            nameImage2.writeToParcel(out, i11);
        }
        out.writeString(this.displayType);
    }
}
