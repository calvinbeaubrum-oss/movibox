package com.tn.tranpay.bean;

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
public final class PrePayInfoBean implements Parcelable {
    public static final Parcelable.Creator<PrePayInfoBean> CREATOR = new a();
    private String amount;
    private String amountFormatPattern;
    private String applicationIcon;
    private String companyName;
    private String currencySymbol;
    private String orderDescription;
    private String orderId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PrePayInfoBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PrePayInfoBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PrePayInfoBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PrePayInfoBean[] newArray(int i11) {
            return new PrePayInfoBean[i11];
        }
    }

    public PrePayInfoBean(String companyName, String applicationIcon, String amount, String orderId, String orderDescription, String currencySymbol, String amountFormatPattern) {
        Intrinsics.g(companyName, "companyName");
        Intrinsics.g(applicationIcon, "applicationIcon");
        Intrinsics.g(amount, "amount");
        Intrinsics.g(orderId, "orderId");
        Intrinsics.g(orderDescription, "orderDescription");
        Intrinsics.g(currencySymbol, "currencySymbol");
        Intrinsics.g(amountFormatPattern, "amountFormatPattern");
        this.companyName = companyName;
        this.applicationIcon = applicationIcon;
        this.amount = amount;
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.currencySymbol = currencySymbol;
        this.amountFormatPattern = amountFormatPattern;
    }

    public static /* synthetic */ PrePayInfoBean copy$default(PrePayInfoBean prePayInfoBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = prePayInfoBean.companyName;
        }
        if ((i11 & 2) != 0) {
            str2 = prePayInfoBean.applicationIcon;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = prePayInfoBean.amount;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = prePayInfoBean.orderId;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = prePayInfoBean.orderDescription;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = prePayInfoBean.currencySymbol;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = prePayInfoBean.amountFormatPattern;
        }
        return prePayInfoBean.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.companyName;
    }

    public final String component2() {
        return this.applicationIcon;
    }

    public final String component3() {
        return this.amount;
    }

    public final String component4() {
        return this.orderId;
    }

    public final String component5() {
        return this.orderDescription;
    }

    public final String component6() {
        return this.currencySymbol;
    }

    public final String component7() {
        return this.amountFormatPattern;
    }

    public final PrePayInfoBean copy(String companyName, String applicationIcon, String amount, String orderId, String orderDescription, String currencySymbol, String amountFormatPattern) {
        Intrinsics.g(companyName, "companyName");
        Intrinsics.g(applicationIcon, "applicationIcon");
        Intrinsics.g(amount, "amount");
        Intrinsics.g(orderId, "orderId");
        Intrinsics.g(orderDescription, "orderDescription");
        Intrinsics.g(currencySymbol, "currencySymbol");
        Intrinsics.g(amountFormatPattern, "amountFormatPattern");
        return new PrePayInfoBean(companyName, applicationIcon, amount, orderId, orderDescription, currencySymbol, amountFormatPattern);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrePayInfoBean)) {
            return false;
        }
        PrePayInfoBean prePayInfoBean = (PrePayInfoBean) obj;
        return Intrinsics.b(this.companyName, prePayInfoBean.companyName) && Intrinsics.b(this.applicationIcon, prePayInfoBean.applicationIcon) && Intrinsics.b(this.amount, prePayInfoBean.amount) && Intrinsics.b(this.orderId, prePayInfoBean.orderId) && Intrinsics.b(this.orderDescription, prePayInfoBean.orderDescription) && Intrinsics.b(this.currencySymbol, prePayInfoBean.currencySymbol) && Intrinsics.b(this.amountFormatPattern, prePayInfoBean.amountFormatPattern);
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getAmountFormatPattern() {
        return this.amountFormatPattern;
    }

    public final String getApplicationIcon() {
        return this.applicationIcon;
    }

    public final String getCompanyName() {
        return this.companyName;
    }

    public final String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public final String getOrderDescription() {
        return this.orderDescription;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public int hashCode() {
        return (((((((((((this.companyName.hashCode() * 31) + this.applicationIcon.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.orderId.hashCode()) * 31) + this.orderDescription.hashCode()) * 31) + this.currencySymbol.hashCode()) * 31) + this.amountFormatPattern.hashCode();
    }

    public final void setAmount(String str) {
        Intrinsics.g(str, "<set-?>");
        this.amount = str;
    }

    public final void setAmountFormatPattern(String str) {
        Intrinsics.g(str, "<set-?>");
        this.amountFormatPattern = str;
    }

    public final void setApplicationIcon(String str) {
        Intrinsics.g(str, "<set-?>");
        this.applicationIcon = str;
    }

    public final void setCompanyName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.companyName = str;
    }

    public final void setCurrencySymbol(String str) {
        Intrinsics.g(str, "<set-?>");
        this.currencySymbol = str;
    }

    public final void setOrderDescription(String str) {
        Intrinsics.g(str, "<set-?>");
        this.orderDescription = str;
    }

    public final void setOrderId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.orderId = str;
    }

    public String toString() {
        return "PrePayInfoBean(companyName=" + this.companyName + ", applicationIcon=" + this.applicationIcon + ", amount=" + this.amount + ", orderId=" + this.orderId + ", orderDescription=" + this.orderDescription + ", currencySymbol=" + this.currencySymbol + ", amountFormatPattern=" + this.amountFormatPattern + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.companyName);
        out.writeString(this.applicationIcon);
        out.writeString(this.amount);
        out.writeString(this.orderId);
        out.writeString(this.orderDescription);
        out.writeString(this.currencySymbol);
        out.writeString(this.amountFormatPattern);
    }
}
