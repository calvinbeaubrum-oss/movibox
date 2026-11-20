package com.transsion.room.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.animation.core.r;
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
@Keep
@Metadata
public final class RoomGeo implements Parcelable {
    public static final Parcelable.Creator<RoomGeo> CREATOR = new a();
    private String address;
    private String city;
    private String countryCode;
    private double lat;
    private double lon;
    private String poi;
    private String province;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<RoomGeo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RoomGeo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new RoomGeo(parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RoomGeo[] newArray(int i11) {
            return new RoomGeo[i11];
        }
    }

    public RoomGeo(double d11, double d12, String str, String str2, String str3, String str4, String str5) {
        this.lon = d11;
        this.lat = d12;
        this.countryCode = str;
        this.province = str2;
        this.city = str3;
        this.address = str4;
        this.poi = str5;
    }

    public /* synthetic */ RoomGeo(double d11, double d12, String str, String str2, String str3, String str4, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(d11, d12, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? null : str4, (i11 & 64) != 0 ? null : str5);
    }

    public final double component1() {
        return this.lon;
    }

    public final double component2() {
        return this.lat;
    }

    public final String component3() {
        return this.countryCode;
    }

    public final String component4() {
        return this.province;
    }

    public final String component5() {
        return this.city;
    }

    public final String component6() {
        return this.address;
    }

    public final String component7() {
        return this.poi;
    }

    public final RoomGeo copy(double d11, double d12, String str, String str2, String str3, String str4, String str5) {
        return new RoomGeo(d11, d12, str, str2, str3, str4, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoomGeo)) {
            return false;
        }
        RoomGeo roomGeo = (RoomGeo) obj;
        return Double.compare(this.lon, roomGeo.lon) == 0 && Double.compare(this.lat, roomGeo.lat) == 0 && Intrinsics.b(this.countryCode, roomGeo.countryCode) && Intrinsics.b(this.province, roomGeo.province) && Intrinsics.b(this.city, roomGeo.city) && Intrinsics.b(this.address, roomGeo.address) && Intrinsics.b(this.poi, roomGeo.poi);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLon() {
        return this.lon;
    }

    public final String getPoi() {
        return this.poi;
    }

    public final String getProvince() {
        return this.province;
    }

    public int hashCode() {
        int iA = ((r.a(this.lon) * 31) + r.a(this.lat)) * 31;
        String str = this.countryCode;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.province;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.city;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.address;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.poi;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final void setCountryCode(String str) {
        this.countryCode = str;
    }

    public final void setLat(double d11) {
        this.lat = d11;
    }

    public final void setLon(double d11) {
        this.lon = d11;
    }

    public final void setPoi(String str) {
        this.poi = str;
    }

    public final void setProvince(String str) {
        this.province = str;
    }

    public String toString() {
        return "RoomGeo(lon=" + this.lon + ", lat=" + this.lat + ", countryCode=" + this.countryCode + ", province=" + this.province + ", city=" + this.city + ", address=" + this.address + ", poi=" + this.poi + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeDouble(this.lon);
        out.writeDouble(this.lat);
        out.writeString(this.countryCode);
        out.writeString(this.province);
        out.writeString(this.city);
        out.writeString(this.address);
        out.writeString(this.poi);
    }
}
