package com.transsion.payment.lib.bean;

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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class PrePayInfo implements Parcelable {
    public static final Parcelable.Creator<PrePayInfo> CREATOR = new a();
    private String cpFrontPage;
    private String currency;
    private String description;
    private String memo;
    private String orderId;
    private Boolean payByLocalCurrency;
    private String price;
    private String referenceNo;
    private String skuId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PrePayInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PrePayInfo createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new PrePayInfo(string, string2, string3, string4, string5, string6, string7, string8, boolValueOf);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PrePayInfo[] newArray(int i11) {
            return new PrePayInfo[i11];
        }
    }

    public PrePayInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool) {
        this.orderId = str;
        this.skuId = str2;
        this.currency = str3;
        this.price = str4;
        this.description = str5;
        this.referenceNo = str6;
        this.memo = str7;
        this.cpFrontPage = str8;
        this.payByLocalCurrency = bool;
    }

    public final String component1() {
        return this.orderId;
    }

    public final String component2() {
        return this.skuId;
    }

    public final String component3() {
        return this.currency;
    }

    public final String component4() {
        return this.price;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.referenceNo;
    }

    public final String component7() {
        return this.memo;
    }

    public final String component8() {
        return this.cpFrontPage;
    }

    public final Boolean component9() {
        return this.payByLocalCurrency;
    }

    public final PrePayInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool) {
        return new PrePayInfo(str, str2, str3, str4, str5, str6, str7, str8, bool);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrePayInfo)) {
            return false;
        }
        PrePayInfo prePayInfo = (PrePayInfo) obj;
        return Intrinsics.b(this.orderId, prePayInfo.orderId) && Intrinsics.b(this.skuId, prePayInfo.skuId) && Intrinsics.b(this.currency, prePayInfo.currency) && Intrinsics.b(this.price, prePayInfo.price) && Intrinsics.b(this.description, prePayInfo.description) && Intrinsics.b(this.referenceNo, prePayInfo.referenceNo) && Intrinsics.b(this.memo, prePayInfo.memo) && Intrinsics.b(this.cpFrontPage, prePayInfo.cpFrontPage) && Intrinsics.b(this.payByLocalCurrency, prePayInfo.payByLocalCurrency);
    }

    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getMemo() {
        return this.memo;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final Boolean getPayByLocalCurrency() {
        return this.payByLocalCurrency;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getReferenceNo() {
        return this.referenceNo;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        String str = this.orderId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.skuId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.currency;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.price;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.description;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.referenceNo;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.memo;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.cpFrontPage;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool = this.payByLocalCurrency;
        return iHashCode8 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setCpFrontPage(String str) {
        this.cpFrontPage = str;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setMemo(String str) {
        this.memo = str;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void setPayByLocalCurrency(Boolean bool) {
        this.payByLocalCurrency = bool;
    }

    public final void setPrice(String str) {
        this.price = str;
    }

    public final void setReferenceNo(String str) {
        this.referenceNo = str;
    }

    public final void setSkuId(String str) {
        this.skuId = str;
    }

    public String toString() {
        return "PrePayInfo(orderId=" + this.orderId + ", skuId=" + this.skuId + ", currency=" + this.currency + ", price=" + this.price + ", description=" + this.description + ", referenceNo=" + this.referenceNo + ", memo=" + this.memo + ", cpFrontPage=" + this.cpFrontPage + ", payByLocalCurrency=" + this.payByLocalCurrency + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        ?? BooleanValue;
        Intrinsics.g(out, "out");
        out.writeString(this.orderId);
        out.writeString(this.skuId);
        out.writeString(this.currency);
        out.writeString(this.price);
        out.writeString(this.description);
        out.writeString(this.referenceNo);
        out.writeString(this.memo);
        out.writeString(this.cpFrontPage);
        Boolean bool = this.payByLocalCurrency;
        if (bool == null) {
            BooleanValue = 0;
        } else {
            out.writeInt(1);
            BooleanValue = bool.booleanValue();
        }
        out.writeInt(BooleanValue);
    }
}
