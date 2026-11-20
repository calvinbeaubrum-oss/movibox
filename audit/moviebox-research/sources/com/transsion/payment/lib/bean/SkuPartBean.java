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
public final class SkuPartBean implements Parcelable {
    public static final Parcelable.Creator<SkuPartBean> CREATOR = new a();
    private String coin;

    @SerializedName("sku_id")
    private String skuId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SkuPartBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SkuPartBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new SkuPartBean(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SkuPartBean[] newArray(int i11) {
            return new SkuPartBean[i11];
        }
    }

    public SkuPartBean(String str, String str2) {
        this.skuId = str;
        this.coin = str2;
    }

    public static /* synthetic */ SkuPartBean copy$default(SkuPartBean skuPartBean, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = skuPartBean.skuId;
        }
        if ((i11 & 2) != 0) {
            str2 = skuPartBean.coin;
        }
        return skuPartBean.copy(str, str2);
    }

    public final String component1() {
        return this.skuId;
    }

    public final String component2() {
        return this.coin;
    }

    public final SkuPartBean copy(String str, String str2) {
        return new SkuPartBean(str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuPartBean)) {
            return false;
        }
        SkuPartBean skuPartBean = (SkuPartBean) obj;
        return Intrinsics.b(this.skuId, skuPartBean.skuId) && Intrinsics.b(this.coin, skuPartBean.coin);
    }

    public final String getCoin() {
        return this.coin;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        String str = this.skuId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.coin;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setCoin(String str) {
        this.coin = str;
    }

    public final void setSkuId(String str) {
        this.skuId = str;
    }

    public String toString() {
        return "SkuPartBean(skuId=" + this.skuId + ", coin=" + this.coin + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.skuId);
        out.writeString(this.coin);
    }
}
