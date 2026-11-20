package com.transsion.memberapi;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import su.h;

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
public final class SkuItem implements Serializable {
    private String category;
    private String coin;
    private String countryCode;
    private String currency;
    private String currencySymbol;
    private String description;
    private String duration;
    private String durationCount;
    private String durationUnitDesc;
    private String formattedPrice;
    private MemberDetail memberDetail;
    private double price;
    private double priceUnit;
    private String skuId;
    private String subDescription;
    private Integer userPoints;

    public SkuItem(String skuId, String countryCode, String currency, double d11, String category, String coin, String duration, String description, String str, String formattedPrice, String durationUnitDesc, String durationCount, String currencySymbol, double d12, Integer num, MemberDetail memberDetail) {
        Intrinsics.g(skuId, "skuId");
        Intrinsics.g(countryCode, "countryCode");
        Intrinsics.g(currency, "currency");
        Intrinsics.g(category, "category");
        Intrinsics.g(coin, "coin");
        Intrinsics.g(duration, "duration");
        Intrinsics.g(description, "description");
        Intrinsics.g(formattedPrice, "formattedPrice");
        Intrinsics.g(durationUnitDesc, "durationUnitDesc");
        Intrinsics.g(durationCount, "durationCount");
        Intrinsics.g(currencySymbol, "currencySymbol");
        this.skuId = skuId;
        this.countryCode = countryCode;
        this.currency = currency;
        this.price = d11;
        this.category = category;
        this.coin = coin;
        this.duration = duration;
        this.description = description;
        this.subDescription = str;
        this.formattedPrice = formattedPrice;
        this.durationUnitDesc = durationUnitDesc;
        this.durationCount = durationCount;
        this.currencySymbol = currencySymbol;
        this.priceUnit = d12;
        this.userPoints = num;
        this.memberDetail = memberDetail;
    }

    public final String component1() {
        return this.skuId;
    }

    public final String component10() {
        return this.formattedPrice;
    }

    public final String component11() {
        return this.durationUnitDesc;
    }

    public final String component12() {
        return this.durationCount;
    }

    public final String component13() {
        return this.currencySymbol;
    }

    public final double component14() {
        return this.priceUnit;
    }

    public final Integer component15() {
        return this.userPoints;
    }

    public final MemberDetail component16() {
        return this.memberDetail;
    }

    public final String component2() {
        return this.countryCode;
    }

    public final String component3() {
        return this.currency;
    }

    public final double component4() {
        return this.price;
    }

    public final String component5() {
        return this.category;
    }

    public final String component6() {
        return this.coin;
    }

    public final String component7() {
        return this.duration;
    }

    public final String component8() {
        return this.description;
    }

    public final String component9() {
        return this.subDescription;
    }

    public final SkuItem copy(String skuId, String countryCode, String currency, double d11, String category, String coin, String duration, String description, String str, String formattedPrice, String durationUnitDesc, String durationCount, String currencySymbol, double d12, Integer num, MemberDetail memberDetail) {
        Intrinsics.g(skuId, "skuId");
        Intrinsics.g(countryCode, "countryCode");
        Intrinsics.g(currency, "currency");
        Intrinsics.g(category, "category");
        Intrinsics.g(coin, "coin");
        Intrinsics.g(duration, "duration");
        Intrinsics.g(description, "description");
        Intrinsics.g(formattedPrice, "formattedPrice");
        Intrinsics.g(durationUnitDesc, "durationUnitDesc");
        Intrinsics.g(durationCount, "durationCount");
        Intrinsics.g(currencySymbol, "currencySymbol");
        return new SkuItem(skuId, countryCode, currency, d11, category, coin, duration, description, str, formattedPrice, durationUnitDesc, durationCount, currencySymbol, d12, num, memberDetail);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuItem)) {
            return false;
        }
        SkuItem skuItem = (SkuItem) obj;
        return Intrinsics.b(this.skuId, skuItem.skuId) && Intrinsics.b(this.countryCode, skuItem.countryCode) && Intrinsics.b(this.currency, skuItem.currency) && Double.compare(this.price, skuItem.price) == 0 && Intrinsics.b(this.category, skuItem.category) && Intrinsics.b(this.coin, skuItem.coin) && Intrinsics.b(this.duration, skuItem.duration) && Intrinsics.b(this.description, skuItem.description) && Intrinsics.b(this.subDescription, skuItem.subDescription) && Intrinsics.b(this.formattedPrice, skuItem.formattedPrice) && Intrinsics.b(this.durationUnitDesc, skuItem.durationUnitDesc) && Intrinsics.b(this.durationCount, skuItem.durationCount) && Intrinsics.b(this.currencySymbol, skuItem.currencySymbol) && Double.compare(this.priceUnit, skuItem.priceUnit) == 0 && Intrinsics.b(this.userPoints, skuItem.userPoints) && Intrinsics.b(this.memberDetail, skuItem.memberDetail);
    }

    public final String getCategory() {
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

    public final String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getDurationCount() {
        return this.durationCount;
    }

    public final String getDurationUnitDesc() {
        return this.durationUnitDesc;
    }

    public final String getFormattedPrice() {
        return this.formattedPrice;
    }

    public final MemberDetail getMemberDetail() {
        return this.memberDetail;
    }

    public final double getPrice() {
        return this.price;
    }

    public final double getPriceUnit() {
        return this.priceUnit;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final String getSubDescription() {
        return this.subDescription;
    }

    public final Integer getUserPoints() {
        return this.userPoints;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.skuId.hashCode() * 31) + this.countryCode.hashCode()) * 31) + this.currency.hashCode()) * 31) + h.a(this.price)) * 31) + this.category.hashCode()) * 31) + this.coin.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str = this.subDescription;
        int iHashCode2 = (((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.formattedPrice.hashCode()) * 31) + this.durationUnitDesc.hashCode()) * 31) + this.durationCount.hashCode()) * 31) + this.currencySymbol.hashCode()) * 31) + h.a(this.priceUnit)) * 31;
        Integer num = this.userPoints;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        MemberDetail memberDetail = this.memberDetail;
        return iHashCode3 + (memberDetail != null ? memberDetail.hashCode() : 0);
    }

    public final void setCategory(String str) {
        Intrinsics.g(str, "<set-?>");
        this.category = str;
    }

    public final void setCoin(String str) {
        Intrinsics.g(str, "<set-?>");
        this.coin = str;
    }

    public final void setCountryCode(String str) {
        Intrinsics.g(str, "<set-?>");
        this.countryCode = str;
    }

    public final void setCurrency(String str) {
        Intrinsics.g(str, "<set-?>");
        this.currency = str;
    }

    public final void setCurrencySymbol(String str) {
        Intrinsics.g(str, "<set-?>");
        this.currencySymbol = str;
    }

    public final void setDescription(String str) {
        Intrinsics.g(str, "<set-?>");
        this.description = str;
    }

    public final void setDuration(String str) {
        Intrinsics.g(str, "<set-?>");
        this.duration = str;
    }

    public final void setDurationCount(String str) {
        Intrinsics.g(str, "<set-?>");
        this.durationCount = str;
    }

    public final void setDurationUnitDesc(String str) {
        Intrinsics.g(str, "<set-?>");
        this.durationUnitDesc = str;
    }

    public final void setFormattedPrice(String str) {
        Intrinsics.g(str, "<set-?>");
        this.formattedPrice = str;
    }

    public final void setMemberDetail(MemberDetail memberDetail) {
        this.memberDetail = memberDetail;
    }

    public final void setPrice(double d11) {
        this.price = d11;
    }

    public final void setPriceUnit(double d11) {
        this.priceUnit = d11;
    }

    public final void setSkuId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.skuId = str;
    }

    public final void setSubDescription(String str) {
        this.subDescription = str;
    }

    public final void setUserPoints(Integer num) {
        this.userPoints = num;
    }

    public String toString() {
        return "SkuItem(skuId=" + this.skuId + ", countryCode=" + this.countryCode + ", currency=" + this.currency + ", price=" + this.price + ", category=" + this.category + ", coin=" + this.coin + ", duration=" + this.duration + ", description=" + this.description + ", subDescription=" + this.subDescription + ", formattedPrice=" + this.formattedPrice + ", durationUnitDesc=" + this.durationUnitDesc + ", durationCount=" + this.durationCount + ", currencySymbol=" + this.currencySymbol + ", priceUnit=" + this.priceUnit + ", userPoints=" + this.userPoints + ", memberDetail=" + this.memberDetail + ")";
    }
}
