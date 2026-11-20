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
public final class CurrencyInfoBean implements Parcelable {
    public static final Parcelable.Creator<CurrencyInfoBean> CREATOR = new a();
    private final String countryCode;
    private final String currency;
    private final String mobileCode;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CurrencyInfoBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CurrencyInfoBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CurrencyInfoBean(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CurrencyInfoBean[] newArray(int i11) {
            return new CurrencyInfoBean[i11];
        }
    }

    public CurrencyInfoBean(String countryCode, String currency, String mobileCode) {
        Intrinsics.g(countryCode, "countryCode");
        Intrinsics.g(currency, "currency");
        Intrinsics.g(mobileCode, "mobileCode");
        this.countryCode = countryCode;
        this.currency = currency;
        this.mobileCode = mobileCode;
    }

    public static /* synthetic */ CurrencyInfoBean copy$default(CurrencyInfoBean currencyInfoBean, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = currencyInfoBean.countryCode;
        }
        if ((i11 & 2) != 0) {
            str2 = currencyInfoBean.currency;
        }
        if ((i11 & 4) != 0) {
            str3 = currencyInfoBean.mobileCode;
        }
        return currencyInfoBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.countryCode;
    }

    public final String component2() {
        return this.currency;
    }

    public final String component3() {
        return this.mobileCode;
    }

    public final CurrencyInfoBean copy(String countryCode, String currency, String mobileCode) {
        Intrinsics.g(countryCode, "countryCode");
        Intrinsics.g(currency, "currency");
        Intrinsics.g(mobileCode, "mobileCode");
        return new CurrencyInfoBean(countryCode, currency, mobileCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CurrencyInfoBean)) {
            return false;
        }
        CurrencyInfoBean currencyInfoBean = (CurrencyInfoBean) obj;
        return Intrinsics.b(this.countryCode, currencyInfoBean.countryCode) && Intrinsics.b(this.currency, currencyInfoBean.currency) && Intrinsics.b(this.mobileCode, currencyInfoBean.mobileCode);
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getMobileCode() {
        return this.mobileCode;
    }

    public int hashCode() {
        return (((this.countryCode.hashCode() * 31) + this.currency.hashCode()) * 31) + this.mobileCode.hashCode();
    }

    public String toString() {
        return "CurrencyInfoBean(countryCode=" + this.countryCode + ", currency=" + this.currency + ", mobileCode=" + this.mobileCode + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.countryCode);
        out.writeString(this.currency);
        out.writeString(this.mobileCode);
    }
}
