package com.transsion.baselib.db.place;

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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class PlaceDBBean {
    private String address;
    private String distance;
    private double latitude;
    private double longitude;
    private String name;

    public PlaceDBBean() {
        this(0.0d, 0.0d, null, null, null, 31, null);
    }

    public PlaceDBBean(double d11, double d12, String str, String str2, String str3) {
        this.latitude = d11;
        this.longitude = d12;
        this.name = str;
        this.address = str2;
        this.distance = str3;
    }

    public /* synthetic */ PlaceDBBean(double d11, double d12, String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? -1.0d : d11, (i11 & 2) == 0 ? d12 : -1.0d, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3);
    }

    public final double component1() {
        return this.latitude;
    }

    public final double component2() {
        return this.longitude;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.address;
    }

    public final String component5() {
        return this.distance;
    }

    public final PlaceDBBean copy(double d11, double d12, String str, String str2, String str3) {
        return new PlaceDBBean(d11, d12, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceDBBean)) {
            return false;
        }
        PlaceDBBean placeDBBean = (PlaceDBBean) obj;
        return Double.compare(this.latitude, placeDBBean.latitude) == 0 && Double.compare(this.longitude, placeDBBean.longitude) == 0 && Intrinsics.b(this.name, placeDBBean.name) && Intrinsics.b(this.address, placeDBBean.address) && Intrinsics.b(this.distance, placeDBBean.distance);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getDistance() {
        return this.distance;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iA = ((r.a(this.latitude) * 31) + r.a(this.longitude)) * 31;
        String str = this.name;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.address;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.distance;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setDistance(String str) {
        this.distance = str;
    }

    public final void setLatitude(double d11) {
        this.latitude = d11;
    }

    public final void setLongitude(double d11) {
        this.longitude = d11;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "PlaceDBBean(latitude=" + this.latitude + ", longitude=" + this.longitude + ", name=" + this.name + ", address=" + this.address + ", distance=" + this.distance + ")";
    }
}
