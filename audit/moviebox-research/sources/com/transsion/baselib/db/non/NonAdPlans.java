package com.transsion.baselib.db.non;

import androidx.annotation.Keep;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

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
/* JADX INFO: loaded from: classes.dex */
@Deprecated
@Keep
@Metadata
public final class NonAdPlans implements Serializable {
    private String adMaterialList;
    private String adPlanCreateTime;
    private String adPlanUpdateTime;
    private String adShowLevel;
    private String advertiserAvatar;
    private String advertiserAvatarPath;
    private String advertiserName;
    private String appSizeDesc;
    private String appStarDesc;
    private String brand;
    private String country;
    private String denyBrand;
    private String denyModel;
    private Integer displayTimes;
    private String endTime;
    private String extraConfig;
    private String filterClientVersion;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f51074id;
    private String model;
    private String name;
    private String scenes;
    private String showDate;
    private Integer showedTimes;
    private Integer sort;
    private String startTime;
    private String version;

    public NonAdPlans(String id2, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Integer num3, String str18, String str19, String str20, String str21, String str22) {
        Intrinsics.g(id2, "id");
        this.f51074id = id2;
        this.version = str;
        this.name = str2;
        this.startTime = str3;
        this.endTime = str4;
        this.extraConfig = str5;
        this.displayTimes = num;
        this.showedTimes = num2;
        this.showDate = str6;
        this.advertiserName = str7;
        this.advertiserAvatar = str8;
        this.advertiserAvatarPath = str9;
        this.brand = str10;
        this.denyBrand = str11;
        this.model = str12;
        this.denyModel = str13;
        this.country = str14;
        this.scenes = str15;
        this.adMaterialList = str16;
        this.adPlanUpdateTime = str17;
        this.sort = num3;
        this.adShowLevel = str18;
        this.filterClientVersion = str19;
        this.adPlanCreateTime = str20;
        this.appStarDesc = str21;
        this.appSizeDesc = str22;
    }

    public /* synthetic */ NonAdPlans(String str, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, Integer num3, String str19, String str20, String str21, String str22, String str23, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : num, (i11 & 128) != 0 ? null : num2, (i11 & 256) != 0 ? null : str7, (i11 & 512) != 0 ? null : str8, (i11 & 1024) != 0 ? null : str9, (i11 & 2048) != 0 ? null : str10, (i11 & 4096) != 0 ? null : str11, (i11 & 8192) != 0 ? null : str12, (i11 & 16384) != 0 ? null : str13, (i11 & 32768) != 0 ? null : str14, (i11 & 65536) != 0 ? null : str15, (i11 & 131072) != 0 ? null : str16, (i11 & 262144) != 0 ? null : str17, (i11 & 524288) != 0 ? null : str18, (i11 & 1048576) != 0 ? Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER) : num3, (i11 & 2097152) != 0 ? null : str19, (i11 & 4194304) != 0 ? null : str20, (i11 & 8388608) != 0 ? null : str21, (i11 & 16777216) != 0 ? null : str22, (i11 & ASTNode.PCTX_STORED) == 0 ? str23 : null);
    }

    public final String component1() {
        return this.f51074id;
    }

    public final String component10() {
        return this.advertiserName;
    }

    public final String component11() {
        return this.advertiserAvatar;
    }

    public final String component12() {
        return this.advertiserAvatarPath;
    }

    public final String component13() {
        return this.brand;
    }

    public final String component14() {
        return this.denyBrand;
    }

    public final String component15() {
        return this.model;
    }

    public final String component16() {
        return this.denyModel;
    }

    public final String component17() {
        return this.country;
    }

    public final String component18() {
        return this.scenes;
    }

    public final String component19() {
        return this.adMaterialList;
    }

    public final String component2() {
        return this.version;
    }

    public final String component20() {
        return this.adPlanUpdateTime;
    }

    public final Integer component21() {
        return this.sort;
    }

    public final String component22() {
        return this.adShowLevel;
    }

    public final String component23() {
        return this.filterClientVersion;
    }

    public final String component24() {
        return this.adPlanCreateTime;
    }

    public final String component25() {
        return this.appStarDesc;
    }

    public final String component26() {
        return this.appSizeDesc;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.startTime;
    }

    public final String component5() {
        return this.endTime;
    }

    public final String component6() {
        return this.extraConfig;
    }

    public final Integer component7() {
        return this.displayTimes;
    }

    public final Integer component8() {
        return this.showedTimes;
    }

    public final String component9() {
        return this.showDate;
    }

    public final NonAdPlans copy(String id2, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Integer num3, String str18, String str19, String str20, String str21, String str22) {
        Intrinsics.g(id2, "id");
        return new NonAdPlans(id2, str, str2, str3, str4, str5, num, num2, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, num3, str18, str19, str20, str21, str22);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NonAdPlans)) {
            return false;
        }
        NonAdPlans nonAdPlans = (NonAdPlans) obj;
        return Intrinsics.b(this.f51074id, nonAdPlans.f51074id) && Intrinsics.b(this.version, nonAdPlans.version) && Intrinsics.b(this.name, nonAdPlans.name) && Intrinsics.b(this.startTime, nonAdPlans.startTime) && Intrinsics.b(this.endTime, nonAdPlans.endTime) && Intrinsics.b(this.extraConfig, nonAdPlans.extraConfig) && Intrinsics.b(this.displayTimes, nonAdPlans.displayTimes) && Intrinsics.b(this.showedTimes, nonAdPlans.showedTimes) && Intrinsics.b(this.showDate, nonAdPlans.showDate) && Intrinsics.b(this.advertiserName, nonAdPlans.advertiserName) && Intrinsics.b(this.advertiserAvatar, nonAdPlans.advertiserAvatar) && Intrinsics.b(this.advertiserAvatarPath, nonAdPlans.advertiserAvatarPath) && Intrinsics.b(this.brand, nonAdPlans.brand) && Intrinsics.b(this.denyBrand, nonAdPlans.denyBrand) && Intrinsics.b(this.model, nonAdPlans.model) && Intrinsics.b(this.denyModel, nonAdPlans.denyModel) && Intrinsics.b(this.country, nonAdPlans.country) && Intrinsics.b(this.scenes, nonAdPlans.scenes) && Intrinsics.b(this.adMaterialList, nonAdPlans.adMaterialList) && Intrinsics.b(this.adPlanUpdateTime, nonAdPlans.adPlanUpdateTime) && Intrinsics.b(this.sort, nonAdPlans.sort) && Intrinsics.b(this.adShowLevel, nonAdPlans.adShowLevel) && Intrinsics.b(this.filterClientVersion, nonAdPlans.filterClientVersion) && Intrinsics.b(this.adPlanCreateTime, nonAdPlans.adPlanCreateTime) && Intrinsics.b(this.appStarDesc, nonAdPlans.appStarDesc) && Intrinsics.b(this.appSizeDesc, nonAdPlans.appSizeDesc);
    }

    public final String getAdMaterialList() {
        return this.adMaterialList;
    }

    public final String getAdPlanCreateTime() {
        return this.adPlanCreateTime;
    }

    public final String getAdPlanUpdateTime() {
        return this.adPlanUpdateTime;
    }

    public final String getAdShowLevel() {
        return this.adShowLevel;
    }

    public final String getAdvertiserAvatar() {
        return this.advertiserAvatar;
    }

    public final String getAdvertiserAvatarPath() {
        return this.advertiserAvatarPath;
    }

    public final String getAdvertiserName() {
        return this.advertiserName;
    }

    public final String getAppSizeDesc() {
        return this.appSizeDesc;
    }

    public final String getAppStarDesc() {
        return this.appStarDesc;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getDenyBrand() {
        return this.denyBrand;
    }

    public final String getDenyModel() {
        return this.denyModel;
    }

    public final Integer getDisplayTimes() {
        return this.displayTimes;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getExtraConfig() {
        return this.extraConfig;
    }

    public final String getFilterClientVersion() {
        return this.filterClientVersion;
    }

    public final String getId() {
        return this.f51074id;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public final String getScenes() {
        return this.scenes;
    }

    public final String getShowDate() {
        return this.showDate;
    }

    public final Integer getShowedTimes() {
        return this.showedTimes;
    }

    public final Integer getSort() {
        return this.sort;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = this.f51074id.hashCode() * 31;
        String str = this.version;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.startTime;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.endTime;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.extraConfig;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.displayTimes;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.showedTimes;
        int iHashCode8 = (iHashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.showDate;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.advertiserName;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.advertiserAvatar;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.advertiserAvatarPath;
        int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.brand;
        int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.denyBrand;
        int iHashCode14 = (iHashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.model;
        int iHashCode15 = (iHashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.denyModel;
        int iHashCode16 = (iHashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.country;
        int iHashCode17 = (iHashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.scenes;
        int iHashCode18 = (iHashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.adMaterialList;
        int iHashCode19 = (iHashCode18 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.adPlanUpdateTime;
        int iHashCode20 = (iHashCode19 + (str17 == null ? 0 : str17.hashCode())) * 31;
        Integer num3 = this.sort;
        int iHashCode21 = (iHashCode20 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str18 = this.adShowLevel;
        int iHashCode22 = (iHashCode21 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.filterClientVersion;
        int iHashCode23 = (iHashCode22 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.adPlanCreateTime;
        int iHashCode24 = (iHashCode23 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.appStarDesc;
        int iHashCode25 = (iHashCode24 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.appSizeDesc;
        return iHashCode25 + (str22 != null ? str22.hashCode() : 0);
    }

    public final void setAdMaterialList(String str) {
        this.adMaterialList = str;
    }

    public final void setAdPlanCreateTime(String str) {
        this.adPlanCreateTime = str;
    }

    public final void setAdPlanUpdateTime(String str) {
        this.adPlanUpdateTime = str;
    }

    public final void setAdShowLevel(String str) {
        this.adShowLevel = str;
    }

    public final void setAdvertiserAvatar(String str) {
        this.advertiserAvatar = str;
    }

    public final void setAdvertiserAvatarPath(String str) {
        this.advertiserAvatarPath = str;
    }

    public final void setAdvertiserName(String str) {
        this.advertiserName = str;
    }

    public final void setAppSizeDesc(String str) {
        this.appSizeDesc = str;
    }

    public final void setAppStarDesc(String str) {
        this.appStarDesc = str;
    }

    public final void setBrand(String str) {
        this.brand = str;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setDenyBrand(String str) {
        this.denyBrand = str;
    }

    public final void setDenyModel(String str) {
        this.denyModel = str;
    }

    public final void setDisplayTimes(Integer num) {
        this.displayTimes = num;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final void setExtraConfig(String str) {
        this.extraConfig = str;
    }

    public final void setFilterClientVersion(String str) {
        this.filterClientVersion = str;
    }

    public final void setId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f51074id = str;
    }

    public final void setModel(String str) {
        this.model = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setScenes(String str) {
        this.scenes = str;
    }

    public final void setShowDate(String str) {
        this.showDate = str;
    }

    public final void setShowedTimes(Integer num) {
        this.showedTimes = num;
    }

    public final void setSort(Integer num) {
        this.sort = num;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "NonAdPlans(id=" + this.f51074id + ", version=" + this.version + ", name=" + this.name + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", extraConfig=" + this.extraConfig + ", displayTimes=" + this.displayTimes + ", showedTimes=" + this.showedTimes + ", showDate=" + this.showDate + ", advertiserName=" + this.advertiserName + ", advertiserAvatar=" + this.advertiserAvatar + ", advertiserAvatarPath=" + this.advertiserAvatarPath + ", brand=" + this.brand + ", denyBrand=" + this.denyBrand + ", model=" + this.model + ", denyModel=" + this.denyModel + ", country=" + this.country + ", scenes=" + this.scenes + ", adMaterialList=" + this.adMaterialList + ", adPlanUpdateTime=" + this.adPlanUpdateTime + ", sort=" + this.sort + ", adShowLevel=" + this.adShowLevel + ", filterClientVersion=" + this.filterClientVersion + ", adPlanCreateTime=" + this.adPlanCreateTime + ", appStarDesc=" + this.appStarDesc + ", appSizeDesc=" + this.appSizeDesc + ")";
    }
}
