package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class ZeroBody implements Serializable {
    private String countryIso;
    private String gaid;
    private int limit;
    private String mobile;
    private String mvboxId;
    private String timezone;
    private String utmSource;

    public ZeroBody(String countryIso, String str, String str2, String str3, String str4, int i11, String utmSource) {
        Intrinsics.g(countryIso, "countryIso");
        Intrinsics.g(utmSource, "utmSource");
        this.countryIso = countryIso;
        this.mobile = str;
        this.mvboxId = str2;
        this.gaid = str3;
        this.timezone = str4;
        this.limit = i11;
        this.utmSource = utmSource;
    }

    public /* synthetic */ ZeroBody(String str, String str2, String str3, String str4, String str5, int i11, String str6, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i12 & 32) != 0 ? 1 : i11, (i12 & 64) != 0 ? "mb" : str6);
    }

    public static /* synthetic */ ZeroBody copy$default(ZeroBody zeroBody, String str, String str2, String str3, String str4, String str5, int i11, String str6, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = zeroBody.countryIso;
        }
        if ((i12 & 2) != 0) {
            str2 = zeroBody.mobile;
        }
        String str7 = str2;
        if ((i12 & 4) != 0) {
            str3 = zeroBody.mvboxId;
        }
        String str8 = str3;
        if ((i12 & 8) != 0) {
            str4 = zeroBody.gaid;
        }
        String str9 = str4;
        if ((i12 & 16) != 0) {
            str5 = zeroBody.timezone;
        }
        String str10 = str5;
        if ((i12 & 32) != 0) {
            i11 = zeroBody.limit;
        }
        int i13 = i11;
        if ((i12 & 64) != 0) {
            str6 = zeroBody.utmSource;
        }
        return zeroBody.copy(str, str7, str8, str9, str10, i13, str6);
    }

    public final String component1() {
        return this.countryIso;
    }

    public final String component2() {
        return this.mobile;
    }

    public final String component3() {
        return this.mvboxId;
    }

    public final String component4() {
        return this.gaid;
    }

    public final String component5() {
        return this.timezone;
    }

    public final int component6() {
        return this.limit;
    }

    public final String component7() {
        return this.utmSource;
    }

    public final ZeroBody copy(String countryIso, String str, String str2, String str3, String str4, int i11, String utmSource) {
        Intrinsics.g(countryIso, "countryIso");
        Intrinsics.g(utmSource, "utmSource");
        return new ZeroBody(countryIso, str, str2, str3, str4, i11, utmSource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZeroBody)) {
            return false;
        }
        ZeroBody zeroBody = (ZeroBody) obj;
        return Intrinsics.b(this.countryIso, zeroBody.countryIso) && Intrinsics.b(this.mobile, zeroBody.mobile) && Intrinsics.b(this.mvboxId, zeroBody.mvboxId) && Intrinsics.b(this.gaid, zeroBody.gaid) && Intrinsics.b(this.timezone, zeroBody.timezone) && this.limit == zeroBody.limit && Intrinsics.b(this.utmSource, zeroBody.utmSource);
    }

    public final String getCountryIso() {
        return this.countryIso;
    }

    public final String getGaid() {
        return this.gaid;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final String getMvboxId() {
        return this.mvboxId;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final String getUtmSource() {
        return this.utmSource;
    }

    public int hashCode() {
        int iHashCode = this.countryIso.hashCode() * 31;
        String str = this.mobile;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mvboxId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.gaid;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.timezone;
        return ((((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.limit) * 31) + this.utmSource.hashCode();
    }

    public final void setCountryIso(String str) {
        Intrinsics.g(str, "<set-?>");
        this.countryIso = str;
    }

    public final void setGaid(String str) {
        this.gaid = str;
    }

    public final void setLimit(int i11) {
        this.limit = i11;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }

    public final void setMvboxId(String str) {
        this.mvboxId = str;
    }

    public final void setTimezone(String str) {
        this.timezone = str;
    }

    public final void setUtmSource(String str) {
        Intrinsics.g(str, "<set-?>");
        this.utmSource = str;
    }

    public String toString() {
        return "ZeroBody(countryIso=" + this.countryIso + ", mobile=" + this.mobile + ", mvboxId=" + this.mvboxId + ", gaid=" + this.gaid + ", timezone=" + this.timezone + ", limit=" + this.limit + ", utmSource=" + this.utmSource + ")";
    }
}
