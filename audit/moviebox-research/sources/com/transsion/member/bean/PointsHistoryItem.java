package com.transsion.member.bean;

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
public final class PointsHistoryItem implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<PointsHistoryItem> CREATOR = new a();
    private final String coin;
    private final String createTime;
    private final String moneyAccountId;
    private final String moneyFlowId;
    private final String operation;
    private final String operationId;
    private final String orderId;
    private final String remarks;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PointsHistoryItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PointsHistoryItem createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PointsHistoryItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PointsHistoryItem[] newArray(int i11) {
            return new PointsHistoryItem[i11];
        }
    }

    public PointsHistoryItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.moneyFlowId = str;
        this.moneyAccountId = str2;
        this.coin = str3;
        this.orderId = str4;
        this.operation = str5;
        this.operationId = str6;
        this.remarks = str7;
        this.createTime = str8;
    }

    public /* synthetic */ PointsHistoryItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, str7, str8);
    }

    public final String component1() {
        return this.moneyFlowId;
    }

    public final String component2() {
        return this.moneyAccountId;
    }

    public final String component3() {
        return this.coin;
    }

    public final String component4() {
        return this.orderId;
    }

    public final String component5() {
        return this.operation;
    }

    public final String component6() {
        return this.operationId;
    }

    public final String component7() {
        return this.remarks;
    }

    public final String component8() {
        return this.createTime;
    }

    public final PointsHistoryItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new PointsHistoryItem(str, str2, str3, str4, str5, str6, str7, str8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointsHistoryItem)) {
            return false;
        }
        PointsHistoryItem pointsHistoryItem = (PointsHistoryItem) obj;
        return Intrinsics.b(this.moneyFlowId, pointsHistoryItem.moneyFlowId) && Intrinsics.b(this.moneyAccountId, pointsHistoryItem.moneyAccountId) && Intrinsics.b(this.coin, pointsHistoryItem.coin) && Intrinsics.b(this.orderId, pointsHistoryItem.orderId) && Intrinsics.b(this.operation, pointsHistoryItem.operation) && Intrinsics.b(this.operationId, pointsHistoryItem.operationId) && Intrinsics.b(this.remarks, pointsHistoryItem.remarks) && Intrinsics.b(this.createTime, pointsHistoryItem.createTime);
    }

    public final String getCoin() {
        return this.coin;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getMoneyAccountId() {
        return this.moneyAccountId;
    }

    public final String getMoneyFlowId() {
        return this.moneyFlowId;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public int hashCode() {
        String str = this.moneyFlowId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.moneyAccountId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.coin;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.orderId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.operation;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.operationId;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.remarks;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.createTime;
        return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "PointsHistoryItem(moneyFlowId=" + this.moneyFlowId + ", moneyAccountId=" + this.moneyAccountId + ", coin=" + this.coin + ", orderId=" + this.orderId + ", operation=" + this.operation + ", operationId=" + this.operationId + ", remarks=" + this.remarks + ", createTime=" + this.createTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.moneyFlowId);
        out.writeString(this.moneyAccountId);
        out.writeString(this.coin);
        out.writeString(this.orderId);
        out.writeString(this.operation);
        out.writeString(this.operationId);
        out.writeString(this.remarks);
        out.writeString(this.createTime);
    }
}
