package com.cloud.tmc.integration.model;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class LauncherPreStrategyModel extends b {
    private final String appId;
    private ArrayList<String> blackCountryList;
    private ArrayList<String> blackModelList;
    private JsonObject commonConfig;
    private JsonObject config;
    private String highestFrameworkVersion;
    private String highestSDKVersion;
    private String lowestFrameworkVersion;
    private String lowestSDKVersion;
    private Integer netType;
    private Long openBrowserTime;
    private Long validTime;
    private ArrayList<String> whiteCountryList;
    private ArrayList<String> whiteModelList;

    public LauncherPreStrategyModel(String str, JsonObject jsonObject, JsonObject jsonObject2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, Integer num, String str2, String str3, String str4, String str5, Long l11, Long l12) {
        this.appId = str;
        this.commonConfig = jsonObject;
        this.config = jsonObject2;
        this.blackCountryList = arrayList;
        this.whiteCountryList = arrayList2;
        this.blackModelList = arrayList3;
        this.whiteModelList = arrayList4;
        this.netType = num;
        this.lowestSDKVersion = str2;
        this.highestSDKVersion = str3;
        this.lowestFrameworkVersion = str4;
        this.highestFrameworkVersion = str5;
        this.validTime = l11;
        this.openBrowserTime = l12;
    }

    public /* synthetic */ LauncherPreStrategyModel(String str, JsonObject jsonObject, JsonObject jsonObject2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, Integer num, String str2, String str3, String str4, String str5, Long l11, Long l12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, jsonObject, jsonObject2, arrayList, arrayList2, arrayList3, arrayList4, (i11 & 128) != 0 ? 3 : num, str2, str3, str4, str5, (i11 & 4096) != 0 ? -1L : l11, (i11 & 8192) != 0 ? -1L : l12);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component10() {
        return this.highestSDKVersion;
    }

    public final String component11() {
        return this.lowestFrameworkVersion;
    }

    public final String component12() {
        return this.highestFrameworkVersion;
    }

    public final Long component13() {
        return this.validTime;
    }

    public final Long component14() {
        return this.openBrowserTime;
    }

    public final JsonObject component2() {
        return this.commonConfig;
    }

    public final JsonObject component3() {
        return this.config;
    }

    public final ArrayList<String> component4() {
        return this.blackCountryList;
    }

    public final ArrayList<String> component5() {
        return this.whiteCountryList;
    }

    public final ArrayList<String> component6() {
        return this.blackModelList;
    }

    public final ArrayList<String> component7() {
        return this.whiteModelList;
    }

    public final Integer component8() {
        return this.netType;
    }

    public final String component9() {
        return this.lowestSDKVersion;
    }

    public final LauncherPreStrategyModel copy(String str, JsonObject jsonObject, JsonObject jsonObject2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, Integer num, String str2, String str3, String str4, String str5, Long l11, Long l12) {
        return new LauncherPreStrategyModel(str, jsonObject, jsonObject2, arrayList, arrayList2, arrayList3, arrayList4, num, str2, str3, str4, str5, l11, l12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LauncherPreStrategyModel)) {
            return false;
        }
        LauncherPreStrategyModel launcherPreStrategyModel = (LauncherPreStrategyModel) obj;
        return Intrinsics.b(this.appId, launcherPreStrategyModel.appId) && Intrinsics.b(this.commonConfig, launcherPreStrategyModel.commonConfig) && Intrinsics.b(this.config, launcherPreStrategyModel.config) && Intrinsics.b(this.blackCountryList, launcherPreStrategyModel.blackCountryList) && Intrinsics.b(this.whiteCountryList, launcherPreStrategyModel.whiteCountryList) && Intrinsics.b(this.blackModelList, launcherPreStrategyModel.blackModelList) && Intrinsics.b(this.whiteModelList, launcherPreStrategyModel.whiteModelList) && Intrinsics.b(this.netType, launcherPreStrategyModel.netType) && Intrinsics.b(this.lowestSDKVersion, launcherPreStrategyModel.lowestSDKVersion) && Intrinsics.b(this.highestSDKVersion, launcherPreStrategyModel.highestSDKVersion) && Intrinsics.b(this.lowestFrameworkVersion, launcherPreStrategyModel.lowestFrameworkVersion) && Intrinsics.b(this.highestFrameworkVersion, launcherPreStrategyModel.highestFrameworkVersion) && Intrinsics.b(this.validTime, launcherPreStrategyModel.validTime) && Intrinsics.b(this.openBrowserTime, launcherPreStrategyModel.openBrowserTime);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final ArrayList<String> getBlackCountryList() {
        return this.blackCountryList;
    }

    public final ArrayList<String> getBlackModelList() {
        return this.blackModelList;
    }

    public final JsonObject getCommonConfig() {
        return this.commonConfig;
    }

    public final JsonObject getConfig() {
        return this.config;
    }

    public final String getHighestFrameworkVersion() {
        return this.highestFrameworkVersion;
    }

    public final String getHighestSDKVersion() {
        return this.highestSDKVersion;
    }

    public final String getLowestFrameworkVersion() {
        return this.lowestFrameworkVersion;
    }

    public final String getLowestSDKVersion() {
        return this.lowestSDKVersion;
    }

    public final Integer getNetType() {
        return this.netType;
    }

    public final Long getOpenBrowserTime() {
        return this.openBrowserTime;
    }

    public final Long getValidTime() {
        return this.validTime;
    }

    public final ArrayList<String> getWhiteCountryList() {
        return this.whiteCountryList;
    }

    public final ArrayList<String> getWhiteModelList() {
        return this.whiteModelList;
    }

    public int hashCode() {
        String str = this.appId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        JsonObject jsonObject = this.commonConfig;
        int iHashCode2 = (iHashCode + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        JsonObject jsonObject2 = this.config;
        int iHashCode3 = (iHashCode2 + (jsonObject2 == null ? 0 : jsonObject2.hashCode())) * 31;
        ArrayList<String> arrayList = this.blackCountryList;
        int iHashCode4 = (iHashCode3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<String> arrayList2 = this.whiteCountryList;
        int iHashCode5 = (iHashCode4 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        ArrayList<String> arrayList3 = this.blackModelList;
        int iHashCode6 = (iHashCode5 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
        ArrayList<String> arrayList4 = this.whiteModelList;
        int iHashCode7 = (iHashCode6 + (arrayList4 == null ? 0 : arrayList4.hashCode())) * 31;
        Integer num = this.netType;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.lowestSDKVersion;
        int iHashCode9 = (iHashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.highestSDKVersion;
        int iHashCode10 = (iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.lowestFrameworkVersion;
        int iHashCode11 = (iHashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.highestFrameworkVersion;
        int iHashCode12 = (iHashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l11 = this.validTime;
        int iHashCode13 = (iHashCode12 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.openBrowserTime;
        return iHashCode13 + (l12 != null ? l12.hashCode() : 0);
    }

    public final void setBlackCountryList(ArrayList<String> arrayList) {
        this.blackCountryList = arrayList;
    }

    public final void setBlackModelList(ArrayList<String> arrayList) {
        this.blackModelList = arrayList;
    }

    public final void setCommonConfig(JsonObject jsonObject) {
        this.commonConfig = jsonObject;
    }

    public final void setConfig(JsonObject jsonObject) {
        this.config = jsonObject;
    }

    public final void setHighestFrameworkVersion(String str) {
        this.highestFrameworkVersion = str;
    }

    public final void setHighestSDKVersion(String str) {
        this.highestSDKVersion = str;
    }

    public final void setLowestFrameworkVersion(String str) {
        this.lowestFrameworkVersion = str;
    }

    public final void setLowestSDKVersion(String str) {
        this.lowestSDKVersion = str;
    }

    public final void setNetType(Integer num) {
        this.netType = num;
    }

    public final void setOpenBrowserTime(Long l11) {
        this.openBrowserTime = l11;
    }

    public final void setValidTime(Long l11) {
        this.validTime = l11;
    }

    public final void setWhiteCountryList(ArrayList<String> arrayList) {
        this.whiteCountryList = arrayList;
    }

    public final void setWhiteModelList(ArrayList<String> arrayList) {
        this.whiteModelList = arrayList;
    }

    public String toString() {
        return "LauncherPreStrategyModel(appId=" + this.appId + ", commonConfig=" + this.commonConfig + ", config=" + this.config + ", blackCountryList=" + this.blackCountryList + ", whiteCountryList=" + this.whiteCountryList + ", blackModelList=" + this.blackModelList + ", whiteModelList=" + this.whiteModelList + ", netType=" + this.netType + ", lowestSDKVersion=" + this.lowestSDKVersion + ", highestSDKVersion=" + this.highestSDKVersion + ", lowestFrameworkVersion=" + this.lowestFrameworkVersion + ", highestFrameworkVersion=" + this.highestFrameworkVersion + ", validTime=" + this.validTime + ", openBrowserTime=" + this.openBrowserTime + ')';
    }
}
