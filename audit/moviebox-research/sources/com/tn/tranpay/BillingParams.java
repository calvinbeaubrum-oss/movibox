package com.tn.tranpay;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class BillingParams implements Parcelable {
    public static final a CREATOR = new a(null);
    private String amount;
    private String cpFrontPage;
    private String currency;
    private String language;
    private String memo;
    private String orderDesc;
    private String orderId;
    private boolean payByLocalCurrency;
    private String referenceNo;
    private boolean shouldOpenCpFrontPage;
    private String txnId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<BillingParams> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BillingParams createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new BillingParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BillingParams[] newArray(int i11) {
            return new BillingParams[i11];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BillingParams(Parcel parcel) {
        Intrinsics.g(parcel, "parcel");
        String string = parcel.readString();
        if (string == null) {
            throw new IllegalArgumentException("amount cannot be null".toString());
        }
        Intrinsics.f(string, "requireNotNull(parcel.re…\"amount cannot be null\" }");
        String string2 = parcel.readString();
        if (string2 == null) {
            throw new IllegalArgumentException("orderId cannot be null".toString());
        }
        Intrinsics.f(string2, "requireNotNull(parcel.re…orderId cannot be null\" }");
        String string3 = parcel.readString();
        if (string3 == null) {
            throw new IllegalArgumentException("orderId cannot be null".toString());
        }
        Intrinsics.f(string3, "requireNotNull(parcel.re…orderId cannot be null\" }");
        String string4 = parcel.readString();
        if (string4 == null) {
            throw new IllegalArgumentException("orderId cannot be null".toString());
        }
        Intrinsics.f(string4, "requireNotNull(parcel.re…orderId cannot be null\" }");
        this(string, string2, string3, string4, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readByte() != 0, parcel.readByte() != 0);
    }

    public BillingParams(String amount, String orderId, String orderDesc, String txnId, String str, String str2, String str3, String str4, String str5, boolean z11, boolean z12) {
        Intrinsics.g(amount, "amount");
        Intrinsics.g(orderId, "orderId");
        Intrinsics.g(orderDesc, "orderDesc");
        Intrinsics.g(txnId, "txnId");
        this.amount = amount;
        this.orderId = orderId;
        this.orderDesc = orderDesc;
        this.txnId = txnId;
        this.currency = str;
        this.referenceNo = str2;
        this.memo = str3;
        this.language = str4;
        this.cpFrontPage = str5;
        this.shouldOpenCpFrontPage = z11;
        this.payByLocalCurrency = z12;
    }

    public /* synthetic */ BillingParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7, (i11 & 128) != 0 ? null : str8, (i11 & 256) != 0 ? null : str9, (i11 & 512) != 0 ? true : z11, (i11 & 1024) != 0 ? false : z12);
    }

    public final String component1() {
        return this.amount;
    }

    public final boolean component10() {
        return this.shouldOpenCpFrontPage;
    }

    public final boolean component11() {
        return this.payByLocalCurrency;
    }

    public final String component2() {
        return this.orderId;
    }

    public final String component3() {
        return this.orderDesc;
    }

    public final String component4() {
        return this.txnId;
    }

    public final String component5() {
        return this.currency;
    }

    public final String component6() {
        return this.referenceNo;
    }

    public final String component7() {
        return this.memo;
    }

    public final String component8() {
        return this.language;
    }

    public final String component9() {
        return this.cpFrontPage;
    }

    public final BillingParams copy(String amount, String orderId, String orderDesc, String txnId, String str, String str2, String str3, String str4, String str5, boolean z11, boolean z12) {
        Intrinsics.g(amount, "amount");
        Intrinsics.g(orderId, "orderId");
        Intrinsics.g(orderDesc, "orderDesc");
        Intrinsics.g(txnId, "txnId");
        return new BillingParams(amount, orderId, orderDesc, txnId, str, str2, str3, str4, str5, z11, z12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BillingParams)) {
            return false;
        }
        BillingParams billingParams = (BillingParams) obj;
        return Intrinsics.b(this.amount, billingParams.amount) && Intrinsics.b(this.orderId, billingParams.orderId) && Intrinsics.b(this.orderDesc, billingParams.orderDesc) && Intrinsics.b(this.txnId, billingParams.txnId) && Intrinsics.b(this.currency, billingParams.currency) && Intrinsics.b(this.referenceNo, billingParams.referenceNo) && Intrinsics.b(this.memo, billingParams.memo) && Intrinsics.b(this.language, billingParams.language) && Intrinsics.b(this.cpFrontPage, billingParams.cpFrontPage) && this.shouldOpenCpFrontPage == billingParams.shouldOpenCpFrontPage && this.payByLocalCurrency == billingParams.payByLocalCurrency;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getMemo() {
        return this.memo;
    }

    public final String getOrderDesc() {
        return this.orderDesc;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final boolean getPayByLocalCurrency() {
        return this.payByLocalCurrency;
    }

    public final String getReferenceNo() {
        return this.referenceNo;
    }

    public final boolean getShouldOpenCpFrontPage() {
        return this.shouldOpenCpFrontPage;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iHashCode = ((((((this.amount.hashCode() * 31) + this.orderId.hashCode()) * 31) + this.orderDesc.hashCode()) * 31) + this.txnId.hashCode()) * 31;
        String str = this.currency;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.referenceNo;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.memo;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.language;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cpFrontPage;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z11 = this.shouldOpenCpFrontPage;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode6 + r11) * 31;
        boolean z12 = this.payByLocalCurrency;
        return i11 + (z12 ? 1 : z12);
    }

    public final void setAmount(String str) {
        Intrinsics.g(str, "<set-?>");
        this.amount = str;
    }

    public final void setCpFrontPage(String str) {
        this.cpFrontPage = str;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setMemo(String str) {
        this.memo = str;
    }

    public final void setOrderDesc(String str) {
        Intrinsics.g(str, "<set-?>");
        this.orderDesc = str;
    }

    public final void setOrderId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.orderId = str;
    }

    public final void setPayByLocalCurrency(boolean z11) {
        this.payByLocalCurrency = z11;
    }

    public final void setReferenceNo(String str) {
        this.referenceNo = str;
    }

    public final void setShouldOpenCpFrontPage(boolean z11) {
        this.shouldOpenCpFrontPage = z11;
    }

    public final void setTxnId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.txnId = str;
    }

    public String toString() {
        return "BillingParams(amount=" + this.amount + ", orderId=" + this.orderId + ", orderDesc=" + this.orderDesc + ", txnId=" + this.txnId + ", currency=" + this.currency + ", referenceNo=" + this.referenceNo + ", memo=" + this.memo + ", language=" + this.language + ", cpFrontPage=" + this.cpFrontPage + ", shouldOpenCpFrontPage=" + this.shouldOpenCpFrontPage + ", payByLocalCurrency=" + this.payByLocalCurrency + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.amount);
        parcel.writeString(this.orderId);
        parcel.writeString(this.orderDesc);
        parcel.writeString(this.txnId);
        parcel.writeString(this.referenceNo);
        parcel.writeString(this.currency);
        parcel.writeString(this.memo);
        parcel.writeString(this.language);
        parcel.writeString(this.cpFrontPage);
        parcel.writeByte(this.shouldOpenCpFrontPage ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.payByLocalCurrency ? (byte) 1 : (byte) 0);
    }
}
