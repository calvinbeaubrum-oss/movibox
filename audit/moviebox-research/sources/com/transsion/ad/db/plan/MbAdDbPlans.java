package com.transsion.ad.db.plan;

import androidx.annotation.Keep;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class MbAdDbPlans implements Serializable {
    private String adMaterialList;
    private String adPlanCreateTime;
    private String adPlanUpdateTime;
    private String adShowLevel;
    private String adSource;
    private String advertiserAvatar;
    private String advertiserAvatarPath;
    private String advertiserName;
    private String appSizeDesc;
    private String appStarDesc;
    private Double bidEcpmCent;
    private String brand;
    private String country;
    private String ctxAttributeConfig;
    private String ctxDisableExpr;
    private String ctxEnableExpr;
    private String denyBrand;
    private String denyModel;
    private String dispatchTimeEnd;
    private String dispatchTimeStart;
    private Integer displayTimes;
    private Long ecpmCent;
    private String endTime;
    private String extAdSlot;
    private String extImage;
    private String extraConfig;
    private String filterClientVersion;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f50398id;
    private String model;
    private String name;
    private String scenes;
    private String showDate;
    private Integer showedTimes;
    private Integer sort;
    private String startTime;
    private String version;

    public MbAdDbPlans(String id2, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, Integer num3, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, Double d11, Long l11) {
        Intrinsics.g(id2, "id");
        this.f50398id = id2;
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
        this.adSource = str16;
        this.extAdSlot = str17;
        this.adMaterialList = str18;
        this.adPlanUpdateTime = str19;
        this.sort = num3;
        this.adShowLevel = str20;
        this.filterClientVersion = str21;
        this.adPlanCreateTime = str22;
        this.appStarDesc = str23;
        this.appSizeDesc = str24;
        this.ctxEnableExpr = str25;
        this.ctxDisableExpr = str26;
        this.ctxAttributeConfig = str27;
        this.dispatchTimeStart = str28;
        this.dispatchTimeEnd = str29;
        this.extImage = str30;
        this.bidEcpmCent = d11;
        this.ecpmCent = l11;
    }

    public /* synthetic */ MbAdDbPlans(String str, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, Integer num3, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, Double d11, Long l11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : num, (i11 & 128) != 0 ? null : num2, (i11 & 256) != 0 ? null : str7, (i11 & 512) != 0 ? null : str8, (i11 & 1024) != 0 ? null : str9, (i11 & 2048) != 0 ? null : str10, (i11 & 4096) != 0 ? null : str11, (i11 & 8192) != 0 ? null : str12, (i11 & 16384) != 0 ? null : str13, (i11 & 32768) != 0 ? null : str14, (i11 & 65536) != 0 ? null : str15, (i11 & 131072) != 0 ? null : str16, (i11 & 262144) != 0 ? null : str17, (i11 & 524288) != 0 ? null : str18, (i11 & 1048576) != 0 ? null : str19, (i11 & 2097152) != 0 ? null : str20, (i11 & 4194304) != 0 ? Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER) : num3, (i11 & 8388608) != 0 ? null : str21, (i11 & 16777216) != 0 ? null : str22, (i11 & ASTNode.PCTX_STORED) != 0 ? null : str23, (i11 & 67108864) != 0 ? null : str24, (i11 & ASTNode.NOJIT) != 0 ? null : str25, (i11 & ASTNode.DEOP) != 0 ? null : str26, (i11 & ASTNode.DISCARD) != 0 ? null : str27, (i11 & 1073741824) != 0 ? null : str28, (i11 & Integer.MIN_VALUE) != 0 ? null : str29, (i12 & 1) != 0 ? null : str30, (i12 & 2) != 0 ? null : str31, (i12 & 4) != 0 ? null : d11, (i12 & 8) == 0 ? l11 : null);
    }

    public final String component1() {
        return this.f50398id;
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
        return this.adSource;
    }

    public final String component2() {
        return this.version;
    }

    public final String component20() {
        return this.extAdSlot;
    }

    public final String component21() {
        return this.adMaterialList;
    }

    public final String component22() {
        return this.adPlanUpdateTime;
    }

    public final Integer component23() {
        return this.sort;
    }

    public final String component24() {
        return this.adShowLevel;
    }

    public final String component25() {
        return this.filterClientVersion;
    }

    public final String component26() {
        return this.adPlanCreateTime;
    }

    public final String component27() {
        return this.appStarDesc;
    }

    public final String component28() {
        return this.appSizeDesc;
    }

    public final String component29() {
        return this.ctxEnableExpr;
    }

    public final String component3() {
        return this.name;
    }

    public final String component30() {
        return this.ctxDisableExpr;
    }

    public final String component31() {
        return this.ctxAttributeConfig;
    }

    public final String component32() {
        return this.dispatchTimeStart;
    }

    public final String component33() {
        return this.dispatchTimeEnd;
    }

    public final String component34() {
        return this.extImage;
    }

    public final Double component35() {
        return this.bidEcpmCent;
    }

    public final Long component36() {
        return this.ecpmCent;
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

    public final MbAdDbPlans copy(String id2, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, Integer num3, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, Double d11, Long l11) {
        Intrinsics.g(id2, "id");
        return new MbAdDbPlans(id2, str, str2, str3, str4, str5, num, num2, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, num3, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, d11, l11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MbAdDbPlans)) {
            return false;
        }
        MbAdDbPlans mbAdDbPlans = (MbAdDbPlans) obj;
        return Intrinsics.b(this.f50398id, mbAdDbPlans.f50398id) && Intrinsics.b(this.version, mbAdDbPlans.version) && Intrinsics.b(this.name, mbAdDbPlans.name) && Intrinsics.b(this.startTime, mbAdDbPlans.startTime) && Intrinsics.b(this.endTime, mbAdDbPlans.endTime) && Intrinsics.b(this.extraConfig, mbAdDbPlans.extraConfig) && Intrinsics.b(this.displayTimes, mbAdDbPlans.displayTimes) && Intrinsics.b(this.showedTimes, mbAdDbPlans.showedTimes) && Intrinsics.b(this.showDate, mbAdDbPlans.showDate) && Intrinsics.b(this.advertiserName, mbAdDbPlans.advertiserName) && Intrinsics.b(this.advertiserAvatar, mbAdDbPlans.advertiserAvatar) && Intrinsics.b(this.advertiserAvatarPath, mbAdDbPlans.advertiserAvatarPath) && Intrinsics.b(this.brand, mbAdDbPlans.brand) && Intrinsics.b(this.denyBrand, mbAdDbPlans.denyBrand) && Intrinsics.b(this.model, mbAdDbPlans.model) && Intrinsics.b(this.denyModel, mbAdDbPlans.denyModel) && Intrinsics.b(this.country, mbAdDbPlans.country) && Intrinsics.b(this.scenes, mbAdDbPlans.scenes) && Intrinsics.b(this.adSource, mbAdDbPlans.adSource) && Intrinsics.b(this.extAdSlot, mbAdDbPlans.extAdSlot) && Intrinsics.b(this.adMaterialList, mbAdDbPlans.adMaterialList) && Intrinsics.b(this.adPlanUpdateTime, mbAdDbPlans.adPlanUpdateTime) && Intrinsics.b(this.sort, mbAdDbPlans.sort) && Intrinsics.b(this.adShowLevel, mbAdDbPlans.adShowLevel) && Intrinsics.b(this.filterClientVersion, mbAdDbPlans.filterClientVersion) && Intrinsics.b(this.adPlanCreateTime, mbAdDbPlans.adPlanCreateTime) && Intrinsics.b(this.appStarDesc, mbAdDbPlans.appStarDesc) && Intrinsics.b(this.appSizeDesc, mbAdDbPlans.appSizeDesc) && Intrinsics.b(this.ctxEnableExpr, mbAdDbPlans.ctxEnableExpr) && Intrinsics.b(this.ctxDisableExpr, mbAdDbPlans.ctxDisableExpr) && Intrinsics.b(this.ctxAttributeConfig, mbAdDbPlans.ctxAttributeConfig) && Intrinsics.b(this.dispatchTimeStart, mbAdDbPlans.dispatchTimeStart) && Intrinsics.b(this.dispatchTimeEnd, mbAdDbPlans.dispatchTimeEnd) && Intrinsics.b(this.extImage, mbAdDbPlans.extImage) && Intrinsics.b(this.bidEcpmCent, mbAdDbPlans.bidEcpmCent) && Intrinsics.b(this.ecpmCent, mbAdDbPlans.ecpmCent);
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

    public final String getAdSource() {
        return this.adSource;
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

    public final Double getBidEcpmCent() {
        return this.bidEcpmCent;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getCtxAttributeConfig() {
        return this.ctxAttributeConfig;
    }

    public final String getCtxDisableExpr() {
        return this.ctxDisableExpr;
    }

    public final String getCtxEnableExpr() {
        return this.ctxEnableExpr;
    }

    public final String getDenyBrand() {
        return this.denyBrand;
    }

    public final String getDenyModel() {
        return this.denyModel;
    }

    public final String getDispatchTimeEnd() {
        return this.dispatchTimeEnd;
    }

    public final String getDispatchTimeStart() {
        return this.dispatchTimeStart;
    }

    public final Integer getDisplayTimes() {
        return this.displayTimes;
    }

    public final Long getEcpmCent() {
        return this.ecpmCent;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getExtAdSlot() {
        return this.extAdSlot;
    }

    public final String getExtImage() {
        return this.extImage;
    }

    public final String getExtraConfig() {
        return this.extraConfig;
    }

    public final String getFilterClientVersion() {
        return this.filterClientVersion;
    }

    public final String getId() {
        return this.f50398id;
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
        int iHashCode = this.f50398id.hashCode() * 31;
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
        String str16 = this.adSource;
        int iHashCode19 = (iHashCode18 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.extAdSlot;
        int iHashCode20 = (iHashCode19 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.adMaterialList;
        int iHashCode21 = (iHashCode20 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.adPlanUpdateTime;
        int iHashCode22 = (iHashCode21 + (str19 == null ? 0 : str19.hashCode())) * 31;
        Integer num3 = this.sort;
        int iHashCode23 = (iHashCode22 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str20 = this.adShowLevel;
        int iHashCode24 = (iHashCode23 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.filterClientVersion;
        int iHashCode25 = (iHashCode24 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.adPlanCreateTime;
        int iHashCode26 = (iHashCode25 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.appStarDesc;
        int iHashCode27 = (iHashCode26 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.appSizeDesc;
        int iHashCode28 = (iHashCode27 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.ctxEnableExpr;
        int iHashCode29 = (iHashCode28 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.ctxDisableExpr;
        int iHashCode30 = (iHashCode29 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.ctxAttributeConfig;
        int iHashCode31 = (iHashCode30 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.dispatchTimeStart;
        int iHashCode32 = (iHashCode31 + (str28 == null ? 0 : str28.hashCode())) * 31;
        String str29 = this.dispatchTimeEnd;
        int iHashCode33 = (iHashCode32 + (str29 == null ? 0 : str29.hashCode())) * 31;
        String str30 = this.extImage;
        int iHashCode34 = (iHashCode33 + (str30 == null ? 0 : str30.hashCode())) * 31;
        Double d11 = this.bidEcpmCent;
        int iHashCode35 = (iHashCode34 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Long l11 = this.ecpmCent;
        return iHashCode35 + (l11 != null ? l11.hashCode() : 0);
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

    public final void setAdSource(String str) {
        this.adSource = str;
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

    public final void setBidEcpmCent(Double d11) {
        this.bidEcpmCent = d11;
    }

    public final void setBrand(String str) {
        this.brand = str;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setCtxAttributeConfig(String str) {
        this.ctxAttributeConfig = str;
    }

    public final void setCtxDisableExpr(String str) {
        this.ctxDisableExpr = str;
    }

    public final void setCtxEnableExpr(String str) {
        this.ctxEnableExpr = str;
    }

    public final void setDenyBrand(String str) {
        this.denyBrand = str;
    }

    public final void setDenyModel(String str) {
        this.denyModel = str;
    }

    public final void setDispatchTimeEnd(String str) {
        this.dispatchTimeEnd = str;
    }

    public final void setDispatchTimeStart(String str) {
        this.dispatchTimeStart = str;
    }

    public final void setDisplayTimes(Integer num) {
        this.displayTimes = num;
    }

    public final void setEcpmCent(Long l11) {
        this.ecpmCent = l11;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final void setExtAdSlot(String str) {
        this.extAdSlot = str;
    }

    public final void setExtImage(String str) {
        this.extImage = str;
    }

    public final void setExtraConfig(String str) {
        this.extraConfig = str;
    }

    public final void setFilterClientVersion(String str) {
        this.filterClientVersion = str;
    }

    public final void setId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f50398id = str;
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
        return "MbAdDbPlans(id=" + this.f50398id + ", version=" + this.version + ", name=" + this.name + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", extraConfig=" + this.extraConfig + ", displayTimes=" + this.displayTimes + ", showedTimes=" + this.showedTimes + ", showDate=" + this.showDate + ", advertiserName=" + this.advertiserName + ", advertiserAvatar=" + this.advertiserAvatar + ", advertiserAvatarPath=" + this.advertiserAvatarPath + ", brand=" + this.brand + ", denyBrand=" + this.denyBrand + ", model=" + this.model + ", denyModel=" + this.denyModel + ", country=" + this.country + ", scenes=" + this.scenes + ", adSource=" + this.adSource + ", extAdSlot=" + this.extAdSlot + ", adMaterialList=" + this.adMaterialList + ", adPlanUpdateTime=" + this.adPlanUpdateTime + ", sort=" + this.sort + ", adShowLevel=" + this.adShowLevel + ", filterClientVersion=" + this.filterClientVersion + ", adPlanCreateTime=" + this.adPlanCreateTime + ", appStarDesc=" + this.appStarDesc + ", appSizeDesc=" + this.appSizeDesc + ", ctxEnableExpr=" + this.ctxEnableExpr + ", ctxDisableExpr=" + this.ctxDisableExpr + ", ctxAttributeConfig=" + this.ctxAttributeConfig + ", dispatchTimeStart=" + this.dispatchTimeStart + ", dispatchTimeEnd=" + this.dispatchTimeEnd + ", extImage=" + this.extImage + ", bidEcpmCent=" + this.bidEcpmCent + ", ecpmCent=" + this.ecpmCent + ")";
    }
}
