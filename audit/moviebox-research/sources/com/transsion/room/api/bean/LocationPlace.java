package com.transsion.room.api.bean;

import android.location.Address;
import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xu.a;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class LocationPlace extends a implements Serializable {
    private String address;
    private transient String countryCode;
    private transient String distance;
    private Double lat;
    private transient Address locationAddress;
    private Double lon;
    private String name;

    public LocationPlace() {
        this(null, null, null, null, 15, null);
    }

    public LocationPlace(String str, String str2, Double d11, Double d12) {
        this.name = str;
        this.address = str2;
        this.lat = d11;
        this.lon = d12;
    }

    public /* synthetic */ LocationPlace(String str, String str2, Double d11, Double d12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : d11, (i11 & 8) != 0 ? null : d12);
    }

    public static /* synthetic */ LocationPlace copy$default(LocationPlace locationPlace, String str, String str2, Double d11, Double d12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = locationPlace.name;
        }
        if ((i11 & 2) != 0) {
            str2 = locationPlace.address;
        }
        if ((i11 & 4) != 0) {
            d11 = locationPlace.lat;
        }
        if ((i11 & 8) != 0) {
            d12 = locationPlace.lon;
        }
        return locationPlace.copy(str, str2, d11, d12);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.address;
    }

    public final Double component3() {
        return this.lat;
    }

    public final Double component4() {
        return this.lon;
    }

    public final LocationPlace copy(String str, String str2, Double d11, Double d12) {
        return new LocationPlace(str, str2, d11, d12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationPlace)) {
            return false;
        }
        LocationPlace locationPlace = (LocationPlace) obj;
        return Intrinsics.b(this.name, locationPlace.name) && Intrinsics.b(this.address, locationPlace.address) && Intrinsics.b(this.lat, locationPlace.lat) && Intrinsics.b(this.lon, locationPlace.lon);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getDistance() {
        return this.distance;
    }

    public final Double getLat() {
        return this.lat;
    }

    public final Address getLocationAddress() {
        return this.locationAddress;
    }

    public final Double getLon() {
        return this.lon;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.address;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d11 = this.lat;
        int iHashCode3 = (iHashCode2 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Double d12 = this.lon;
        return iHashCode3 + (d12 != null ? d12.hashCode() : 0);
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setCountryCode(String str) {
        this.countryCode = str;
    }

    public final void setDistance(String str) {
        this.distance = str;
    }

    public final void setLat(Double d11) {
        this.lat = d11;
    }

    public final void setLocationAddress(Address address) {
        this.locationAddress = address;
    }

    public final void setLon(Double d11) {
        this.lon = d11;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "LocationPlace(name=" + this.name + ", address=" + this.address + ", lat=" + this.lat + ", lon=" + this.lon + ")";
    }
}
