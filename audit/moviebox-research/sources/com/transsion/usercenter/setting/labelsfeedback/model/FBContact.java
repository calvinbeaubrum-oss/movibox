package com.transsion.usercenter.setting.labelsfeedback.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.transsnet.loginapi.bean.Country;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class FBContact implements Parcelable {
    public static final Parcelable.Creator<FBContact> CREATOR = new a();
    private Country country;
    private String phone;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<FBContact> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FBContact createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new FBContact((Country) parcel.readSerializable(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FBContact[] newArray(int i11) {
            return new FBContact[i11];
        }
    }

    public FBContact(Country country, String phone) {
        Intrinsics.g(phone, "phone");
        this.country = country;
        this.phone = phone;
    }

    public /* synthetic */ FBContact(Country country, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(country, (i11 & 2) != 0 ? "" : str);
    }

    public static /* synthetic */ FBContact copy$default(FBContact fBContact, Country country, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            country = fBContact.country;
        }
        if ((i11 & 2) != 0) {
            str = fBContact.phone;
        }
        return fBContact.copy(country, str);
    }

    public final Country component1() {
        return this.country;
    }

    public final String component2() {
        return this.phone;
    }

    public final FBContact copy(Country country, String phone) {
        Intrinsics.g(phone, "phone");
        return new FBContact(country, phone);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FBContact)) {
            return false;
        }
        FBContact fBContact = (FBContact) obj;
        return Intrinsics.b(this.country, fBContact.country) && Intrinsics.b(this.phone, fBContact.phone);
    }

    public final Country getCountry() {
        return this.country;
    }

    public final boolean getNeedCountry() {
        return this.phone.length() > 0 && this.country == null;
    }

    public final boolean getNeedPhone() {
        return this.country != null && this.phone.length() == 0;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getWhole() {
        Country country = this.country;
        if (country == null || this.phone.length() <= 0) {
            return null;
        }
        return country.getCountry_s() + " +" + country.getCode() + " " + this.phone;
    }

    public int hashCode() {
        Country country = this.country;
        return ((country == null ? 0 : country.hashCode()) * 31) + this.phone.hashCode();
    }

    public final void setCountry(Country country) {
        this.country = country;
    }

    public final void setPhone(String str) {
        Intrinsics.g(str, "<set-?>");
        this.phone = str;
    }

    public String toString() {
        return "FBContact(country=" + this.country + ", phone=" + this.phone + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeSerializable(this.country);
        out.writeString(this.phone);
    }
}
