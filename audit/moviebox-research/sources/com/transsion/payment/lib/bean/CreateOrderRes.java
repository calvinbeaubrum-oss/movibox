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
public final class CreateOrderRes implements Parcelable {
    public static final Parcelable.Creator<CreateOrderRes> CREATOR = new a();
    private PrePayInfo prePayInfo;
    private String tradingOrderId;
    private String txnId;
    private String webUrl;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CreateOrderRes> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CreateOrderRes createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CreateOrderRes(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : PrePayInfo.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CreateOrderRes[] newArray(int i11) {
            return new CreateOrderRes[i11];
        }
    }

    public CreateOrderRes(String str, String txnId, String str2, PrePayInfo prePayInfo) {
        Intrinsics.g(txnId, "txnId");
        this.tradingOrderId = str;
        this.txnId = txnId;
        this.webUrl = str2;
        this.prePayInfo = prePayInfo;
    }

    public static /* synthetic */ CreateOrderRes copy$default(CreateOrderRes createOrderRes, String str, String str2, String str3, PrePayInfo prePayInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = createOrderRes.tradingOrderId;
        }
        if ((i11 & 2) != 0) {
            str2 = createOrderRes.txnId;
        }
        if ((i11 & 4) != 0) {
            str3 = createOrderRes.webUrl;
        }
        if ((i11 & 8) != 0) {
            prePayInfo = createOrderRes.prePayInfo;
        }
        return createOrderRes.copy(str, str2, str3, prePayInfo);
    }

    public final String component1() {
        return this.tradingOrderId;
    }

    public final String component2() {
        return this.txnId;
    }

    public final String component3() {
        return this.webUrl;
    }

    public final PrePayInfo component4() {
        return this.prePayInfo;
    }

    public final CreateOrderRes copy(String str, String txnId, String str2, PrePayInfo prePayInfo) {
        Intrinsics.g(txnId, "txnId");
        return new CreateOrderRes(str, txnId, str2, prePayInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateOrderRes)) {
            return false;
        }
        CreateOrderRes createOrderRes = (CreateOrderRes) obj;
        return Intrinsics.b(this.tradingOrderId, createOrderRes.tradingOrderId) && Intrinsics.b(this.txnId, createOrderRes.txnId) && Intrinsics.b(this.webUrl, createOrderRes.webUrl) && Intrinsics.b(this.prePayInfo, createOrderRes.prePayInfo);
    }

    public final PrePayInfo getPrePayInfo() {
        return this.prePayInfo;
    }

    public final String getTradingOrderId() {
        return this.tradingOrderId;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public int hashCode() {
        String str = this.tradingOrderId;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.txnId.hashCode()) * 31;
        String str2 = this.webUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        PrePayInfo prePayInfo = this.prePayInfo;
        return iHashCode2 + (prePayInfo != null ? prePayInfo.hashCode() : 0);
    }

    public final void setPrePayInfo(PrePayInfo prePayInfo) {
        this.prePayInfo = prePayInfo;
    }

    public final void setTradingOrderId(String str) {
        this.tradingOrderId = str;
    }

    public final void setTxnId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.txnId = str;
    }

    public final void setWebUrl(String str) {
        this.webUrl = str;
    }

    public String toString() {
        return "CreateOrderRes(tradingOrderId=" + this.tradingOrderId + ", txnId=" + this.txnId + ", webUrl=" + this.webUrl + ", prePayInfo=" + this.prePayInfo + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.tradingOrderId);
        out.writeString(this.txnId);
        out.writeString(this.webUrl);
        PrePayInfo prePayInfo = this.prePayInfo;
        if (prePayInfo == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            prePayInfo.writeToParcel(out, i11);
        }
    }
}
