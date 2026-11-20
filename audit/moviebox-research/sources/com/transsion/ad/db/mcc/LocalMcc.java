package com.transsion.ad.db.mcc;

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
public final class LocalMcc implements Parcelable {
    public static final Parcelable.Creator<LocalMcc> CREATOR = new a();
    private String Country;
    private String CountryCode;
    private String Iso;
    private String Mcc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f50397id;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<LocalMcc> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LocalMcc createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new LocalMcc(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final LocalMcc[] newArray(int i11) {
            return new LocalMcc[i11];
        }
    }

    public LocalMcc(int i11, String Country, String Mcc, String Iso, String CountryCode) {
        Intrinsics.g(Country, "Country");
        Intrinsics.g(Mcc, "Mcc");
        Intrinsics.g(Iso, "Iso");
        Intrinsics.g(CountryCode, "CountryCode");
        this.f50397id = i11;
        this.Country = Country;
        this.Mcc = Mcc;
        this.Iso = Iso;
        this.CountryCode = CountryCode;
    }

    public /* synthetic */ LocalMcc(int i11, String str, String str2, String str3, String str4, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, str, str2, str3, str4);
    }

    public static /* synthetic */ LocalMcc copy$default(LocalMcc localMcc, int i11, String str, String str2, String str3, String str4, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = localMcc.f50397id;
        }
        if ((i12 & 2) != 0) {
            str = localMcc.Country;
        }
        String str5 = str;
        if ((i12 & 4) != 0) {
            str2 = localMcc.Mcc;
        }
        String str6 = str2;
        if ((i12 & 8) != 0) {
            str3 = localMcc.Iso;
        }
        String str7 = str3;
        if ((i12 & 16) != 0) {
            str4 = localMcc.CountryCode;
        }
        return localMcc.copy(i11, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.f50397id;
    }

    public final String component2() {
        return this.Country;
    }

    public final String component3() {
        return this.Mcc;
    }

    public final String component4() {
        return this.Iso;
    }

    public final String component5() {
        return this.CountryCode;
    }

    public final LocalMcc copy(int i11, String Country, String Mcc, String Iso, String CountryCode) {
        Intrinsics.g(Country, "Country");
        Intrinsics.g(Mcc, "Mcc");
        Intrinsics.g(Iso, "Iso");
        Intrinsics.g(CountryCode, "CountryCode");
        return new LocalMcc(i11, Country, Mcc, Iso, CountryCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalMcc)) {
            return false;
        }
        LocalMcc localMcc = (LocalMcc) obj;
        return this.f50397id == localMcc.f50397id && Intrinsics.b(this.Country, localMcc.Country) && Intrinsics.b(this.Mcc, localMcc.Mcc) && Intrinsics.b(this.Iso, localMcc.Iso) && Intrinsics.b(this.CountryCode, localMcc.CountryCode);
    }

    public final String getCountry() {
        return this.Country;
    }

    public final String getCountryCode() {
        return this.CountryCode;
    }

    public final int getId() {
        return this.f50397id;
    }

    public final String getIso() {
        return this.Iso;
    }

    public final String getMcc() {
        return this.Mcc;
    }

    public int hashCode() {
        return (((((((this.f50397id * 31) + this.Country.hashCode()) * 31) + this.Mcc.hashCode()) * 31) + this.Iso.hashCode()) * 31) + this.CountryCode.hashCode();
    }

    public final void setCountry(String str) {
        Intrinsics.g(str, "<set-?>");
        this.Country = str;
    }

    public final void setCountryCode(String str) {
        Intrinsics.g(str, "<set-?>");
        this.CountryCode = str;
    }

    public final void setId(int i11) {
        this.f50397id = i11;
    }

    public final void setIso(String str) {
        Intrinsics.g(str, "<set-?>");
        this.Iso = str;
    }

    public final void setMcc(String str) {
        Intrinsics.g(str, "<set-?>");
        this.Mcc = str;
    }

    public String toString() {
        return "LocalMcc(id=" + this.f50397id + ", Country=" + this.Country + ", Mcc=" + this.Mcc + ", Iso=" + this.Iso + ", CountryCode=" + this.CountryCode + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.f50397id);
        out.writeString(this.Country);
        out.writeString(this.Mcc);
        out.writeString(this.Iso);
        out.writeString(this.CountryCode);
    }
}
