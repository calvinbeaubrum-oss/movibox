package com.transsion.payment.lib.bean;

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
public final class SkuBean implements Parcelable {
    public static final Parcelable.Creator<SkuBean> CREATOR = new a();
    private SkuCategory category;
    private String coin;
    private String countryCode;
    private String currency;
    private String description;
    private String duration;
    private String formattedPrice;
    private String price;
    private String skuId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SkuBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SkuBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new SkuBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : SkuCategory.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SkuBean[] newArray(int i11) {
            return new SkuBean[i11];
        }
    }

    public SkuBean(String str, String str2, String str3, String str4, String str5, String str6, SkuCategory skuCategory, String str7, String str8) {
        this.skuId = str;
        this.coin = str2;
        this.currency = str3;
        this.formattedPrice = str4;
        this.countryCode = str5;
        this.price = str6;
        this.category = skuCategory;
        this.duration = str7;
        this.description = str8;
    }

    public /* synthetic */ SkuBean(String str, String str2, String str3, String str4, String str5, String str6, SkuCategory skuCategory, String str7, String str8, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? SkuCategory.SkuCategoryOnceRecharge : skuCategory, (i11 & 128) != 0 ? null : str7, (i11 & 256) != 0 ? null : str8);
    }

    public final String component1() {
        return this.skuId;
    }

    public final String component2() {
        return this.coin;
    }

    public final String component3() {
        return this.currency;
    }

    public final String component4() {
        return this.formattedPrice;
    }

    public final String component5() {
        return this.countryCode;
    }

    public final String component6() {
        return this.price;
    }

    public final SkuCategory component7() {
        return this.category;
    }

    public final String component8() {
        return this.duration;
    }

    public final String component9() {
        return this.description;
    }

    public final SkuBean copy(String str, String str2, String str3, String str4, String str5, String str6, SkuCategory skuCategory, String str7, String str8) {
        return new SkuBean(str, str2, str3, str4, str5, str6, skuCategory, str7, str8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuBean)) {
            return false;
        }
        SkuBean skuBean = (SkuBean) obj;
        return Intrinsics.b(this.skuId, skuBean.skuId) && Intrinsics.b(this.coin, skuBean.coin) && Intrinsics.b(this.currency, skuBean.currency) && Intrinsics.b(this.formattedPrice, skuBean.formattedPrice) && Intrinsics.b(this.countryCode, skuBean.countryCode) && Intrinsics.b(this.price, skuBean.price) && this.category == skuBean.category && Intrinsics.b(this.duration, skuBean.duration) && Intrinsics.b(this.description, skuBean.description);
    }

    public final SkuCategory getCategory() {
        return this.category;
    }

    public final String getCoin() {
        return this.coin;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getFormattedPrice() {
        return this.formattedPrice;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        String str = this.skuId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.coin;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.currency;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.formattedPrice;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.countryCode;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.price;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        SkuCategory skuCategory = this.category;
        int iHashCode7 = (iHashCode6 + (skuCategory == null ? 0 : skuCategory.hashCode())) * 31;
        String str7 = this.duration;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.description;
        return iHashCode8 + (str8 != null ? str8.hashCode() : 0);
    }

    public final void setCategory(SkuCategory skuCategory) {
        this.category = skuCategory;
    }

    public final void setCoin(String str) {
        this.coin = str;
    }

    public final void setCountryCode(String str) {
        this.countryCode = str;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final void setFormattedPrice(String str) {
        this.formattedPrice = str;
    }

    public final void setPrice(String str) {
        this.price = str;
    }

    public final void setSkuId(String str) {
        this.skuId = str;
    }

    public String toString() {
        return "SkuBean(skuId=" + this.skuId + ", coin=" + this.coin + ", currency=" + this.currency + ", formattedPrice=" + this.formattedPrice + ", countryCode=" + this.countryCode + ", price=" + this.price + ", category=" + this.category + ", duration=" + this.duration + ", description=" + this.description + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.skuId);
        out.writeString(this.coin);
        out.writeString(this.currency);
        out.writeString(this.formattedPrice);
        out.writeString(this.countryCode);
        out.writeString(this.price);
        SkuCategory skuCategory = this.category;
        if (skuCategory == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(skuCategory.name());
        }
        out.writeString(this.duration);
        out.writeString(this.description);
    }
}
