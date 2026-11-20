package com.transsion.member.bean;

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
public final class RedeemResult implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<RedeemResult> CREATOR = new a();
    private String orderId;
    private int vipDurationDays;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<RedeemResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RedeemResult createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new RedeemResult(parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RedeemResult[] newArray(int i11) {
            return new RedeemResult[i11];
        }
    }

    public RedeemResult(int i11, String orderId) {
        Intrinsics.g(orderId, "orderId");
        this.vipDurationDays = i11;
        this.orderId = orderId;
    }

    public static /* synthetic */ RedeemResult copy$default(RedeemResult redeemResult, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = redeemResult.vipDurationDays;
        }
        if ((i12 & 2) != 0) {
            str = redeemResult.orderId;
        }
        return redeemResult.copy(i11, str);
    }

    public final int component1() {
        return this.vipDurationDays;
    }

    public final String component2() {
        return this.orderId;
    }

    public final RedeemResult copy(int i11, String orderId) {
        Intrinsics.g(orderId, "orderId");
        return new RedeemResult(i11, orderId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemResult)) {
            return false;
        }
        RedeemResult redeemResult = (RedeemResult) obj;
        return this.vipDurationDays == redeemResult.vipDurationDays && Intrinsics.b(this.orderId, redeemResult.orderId);
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final int getVipDurationDays() {
        return this.vipDurationDays;
    }

    public int hashCode() {
        return (this.vipDurationDays * 31) + this.orderId.hashCode();
    }

    public final void setOrderId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.orderId = str;
    }

    public final void setVipDurationDays(int i11) {
        this.vipDurationDays = i11;
    }

    public String toString() {
        return "RedeemResult(vipDurationDays=" + this.vipDurationDays + ", orderId=" + this.orderId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.vipDurationDays);
        out.writeString(this.orderId);
    }
}
