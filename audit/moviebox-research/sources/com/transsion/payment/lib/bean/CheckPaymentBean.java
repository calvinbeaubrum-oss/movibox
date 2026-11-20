package com.transsion.payment.lib.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
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
public final class CheckPaymentBean implements Parcelable {
    public static final Parcelable.Creator<CheckPaymentBean> CREATOR = new a();

    @SerializedName("addCoin")
    private String addCoin;

    @SerializedName("balanceCoin")
    private String balanceCoin;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CheckPaymentBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CheckPaymentBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CheckPaymentBean(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CheckPaymentBean[] newArray(int i11) {
            return new CheckPaymentBean[i11];
        }
    }

    public CheckPaymentBean(String str, String str2) {
        this.addCoin = str;
        this.balanceCoin = str2;
    }

    public static /* synthetic */ CheckPaymentBean copy$default(CheckPaymentBean checkPaymentBean, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = checkPaymentBean.addCoin;
        }
        if ((i11 & 2) != 0) {
            str2 = checkPaymentBean.balanceCoin;
        }
        return checkPaymentBean.copy(str, str2);
    }

    public final String component1() {
        return this.addCoin;
    }

    public final String component2() {
        return this.balanceCoin;
    }

    public final CheckPaymentBean copy(String str, String str2) {
        return new CheckPaymentBean(str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckPaymentBean)) {
            return false;
        }
        CheckPaymentBean checkPaymentBean = (CheckPaymentBean) obj;
        return Intrinsics.b(this.addCoin, checkPaymentBean.addCoin) && Intrinsics.b(this.balanceCoin, checkPaymentBean.balanceCoin);
    }

    public final String getAddCoin() {
        return this.addCoin;
    }

    public final String getBalanceCoin() {
        return this.balanceCoin;
    }

    public int hashCode() {
        String str = this.addCoin;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.balanceCoin;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setAddCoin(String str) {
        this.addCoin = str;
    }

    public final void setBalanceCoin(String str) {
        this.balanceCoin = str;
    }

    public String toString() {
        return "CheckPaymentBean(addCoin=" + this.addCoin + ", balanceCoin=" + this.balanceCoin + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.addCoin);
        out.writeString(this.balanceCoin);
    }
}
