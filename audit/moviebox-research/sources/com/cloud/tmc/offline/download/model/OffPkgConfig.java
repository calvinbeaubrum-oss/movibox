package com.cloud.tmc.offline.download.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import rc.b;

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
/* JADX INFO: loaded from: classes4.dex */
@kotlin.Metadata
@SourceDebugExtension
public final class OffPkgConfig extends b implements Parcelable {
    public static final a CREATOR = new a(null);
    private List<DeliveryDimensionData> allowDeliveryDimension;
    private final String app;
    private final AppInfoModel appInfo;
    private final String downloadModel;
    private HashMap<String, String> extInfo;
    private OffPkgConfigExtParams extParams;
    private String extraConfig;
    private String group;
    private final String language;
    private final String name;
    private final String nation;
    private final String networkType;
    private final String pkgEncrypted;
    private final String pkgUrl;
    private final int priority;
    private final HashMap<String, String> resMap;
    private String type;
    private String version;

    /* JADX INFO: compiled from: source.java */
    @kotlin.Metadata
    public static final class a implements Parcelable.Creator<OffPkgConfig> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OffPkgConfig createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new OffPkgConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public OffPkgConfig[] newArray(int i11) {
            return new OffPkgConfig[i11];
        }
    }

    public OffPkgConfig() {
        this(null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    public OffPkgConfig(Parcel parcel) {
        String str;
        HashMap map;
        HashMap map2;
        Intrinsics.g(parcel, "parcel");
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        String string6 = parcel.readString();
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        int i11 = parcel.readInt();
        String string9 = parcel.readString();
        String string10 = parcel.readString();
        HashMap hashMap = parcel.readHashMap(HashMap.class.getClassLoader());
        if (hashMap != null) {
            HashMap map3 = new HashMap();
            for (Object obj : hashMap.keySet()) {
                String str2 = string10;
                Object obj2 = hashMap.get(obj);
                if (obj2 == null || (obj2 instanceof String)) {
                    map3.put(obj.toString(), (String) hashMap.get(obj));
                }
                string10 = str2;
            }
            str = string10;
            map = map3;
        } else {
            str = string10;
            map = null;
        }
        HashMap hashMap2 = parcel.readHashMap(HashMap.class.getClassLoader());
        if (hashMap2 != null) {
            HashMap map4 = new HashMap();
            Iterator it = hashMap2.keySet().iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Iterator it2 = it;
                Object obj3 = hashMap2.get(next);
                if (obj3 == null || (obj3 instanceof String)) {
                    map4.put(next.toString(), (String) hashMap2.get(next));
                }
                it = it2;
            }
            map2 = map4;
        } else {
            map2 = null;
        }
        this(string, string2, string3, string4, string5, string6, string7, string8, i11, string9, str, map, map2, parcel.readString(), parcel.readString(), (AppInfoModel) parcel.readParcelable(AppModel.class.getClassLoader()), (OffPkgConfigExtParams) parcel.readParcelable(OffPkgConfigExtParams.class.getClassLoader()), parcel.createTypedArrayList(DeliveryDimensionData.CREATOR));
    }

    public OffPkgConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, String str9, String str10, HashMap<String, String> map, HashMap<String, String> map2, String str11, String str12, AppInfoModel appInfoModel, OffPkgConfigExtParams offPkgConfigExtParams, List<DeliveryDimensionData> list) {
        this.downloadModel = str;
        this.app = str2;
        this.group = str3;
        this.language = str4;
        this.name = str5;
        this.nation = str6;
        this.networkType = str7;
        this.pkgUrl = str8;
        this.priority = i11;
        this.version = str9;
        this.type = str10;
        this.resMap = map;
        this.extInfo = map2;
        this.extraConfig = str11;
        this.pkgEncrypted = str12;
        this.appInfo = appInfoModel;
        this.extParams = offPkgConfigExtParams;
        this.allowDeliveryDimension = list;
    }

    public /* synthetic */ OffPkgConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, String str9, String str10, HashMap map, HashMap map2, String str11, String str12, AppInfoModel appInfoModel, OffPkgConfigExtParams offPkgConfigExtParams, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? null : str3, (i12 & 8) != 0 ? null : str4, (i12 & 16) != 0 ? null : str5, (i12 & 32) != 0 ? null : str6, (i12 & 64) != 0 ? null : str7, (i12 & 128) != 0 ? null : str8, (i12 & 256) != 0 ? 5 : i11, (i12 & 512) != 0 ? null : str9, (i12 & 1024) != 0 ? null : str10, (i12 & 2048) != 0 ? null : map, (i12 & 4096) != 0 ? null : map2, (i12 & 8192) != 0 ? null : str11, (i12 & 16384) != 0 ? null : str12, (i12 & 32768) != 0 ? null : appInfoModel, (i12 & 65536) != 0 ? null : offPkgConfigExtParams, (i12 & 131072) != 0 ? null : list);
    }

    public final String component1() {
        return this.downloadModel;
    }

    public final String component10() {
        return this.version;
    }

    public final String component11() {
        return this.type;
    }

    public final HashMap<String, String> component12() {
        return this.resMap;
    }

    public final HashMap<String, String> component13() {
        return this.extInfo;
    }

    public final String component14() {
        return this.extraConfig;
    }

    public final String component15() {
        return this.pkgEncrypted;
    }

    public final AppInfoModel component16() {
        return this.appInfo;
    }

    public final OffPkgConfigExtParams component17() {
        return this.extParams;
    }

    public final List<DeliveryDimensionData> component18() {
        return this.allowDeliveryDimension;
    }

    public final String component2() {
        return this.app;
    }

    public final String component3() {
        return this.group;
    }

    public final String component4() {
        return this.language;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.nation;
    }

    public final String component7() {
        return this.networkType;
    }

    public final String component8() {
        return this.pkgUrl;
    }

    public final int component9() {
        return this.priority;
    }

    public final OffPkgConfig copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, String str9, String str10, HashMap<String, String> map, HashMap<String, String> map2, String str11, String str12, AppInfoModel appInfoModel, OffPkgConfigExtParams offPkgConfigExtParams, List<DeliveryDimensionData> list) {
        return new OffPkgConfig(str, str2, str3, str4, str5, str6, str7, str8, i11, str9, str10, map, map2, str11, str12, appInfoModel, offPkgConfigExtParams, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffPkgConfig)) {
            return false;
        }
        OffPkgConfig offPkgConfig = (OffPkgConfig) obj;
        return Intrinsics.b(this.downloadModel, offPkgConfig.downloadModel) && Intrinsics.b(this.app, offPkgConfig.app) && Intrinsics.b(this.group, offPkgConfig.group) && Intrinsics.b(this.language, offPkgConfig.language) && Intrinsics.b(this.name, offPkgConfig.name) && Intrinsics.b(this.nation, offPkgConfig.nation) && Intrinsics.b(this.networkType, offPkgConfig.networkType) && Intrinsics.b(this.pkgUrl, offPkgConfig.pkgUrl) && this.priority == offPkgConfig.priority && Intrinsics.b(this.version, offPkgConfig.version) && Intrinsics.b(this.type, offPkgConfig.type) && Intrinsics.b(this.resMap, offPkgConfig.resMap) && Intrinsics.b(this.extInfo, offPkgConfig.extInfo) && Intrinsics.b(this.extraConfig, offPkgConfig.extraConfig) && Intrinsics.b(this.pkgEncrypted, offPkgConfig.pkgEncrypted) && Intrinsics.b(this.appInfo, offPkgConfig.appInfo) && Intrinsics.b(this.extParams, offPkgConfig.extParams) && Intrinsics.b(this.allowDeliveryDimension, offPkgConfig.allowDeliveryDimension);
    }

    public final List<DeliveryDimensionData> getAllowDeliveryDimension() {
        return this.allowDeliveryDimension;
    }

    public final String getApp() {
        return this.app;
    }

    public final AppInfoModel getAppInfo() {
        return this.appInfo;
    }

    public final String getDownloadModel() {
        return this.downloadModel;
    }

    public final HashMap<String, String> getExtInfo() {
        return this.extInfo;
    }

    public final OffPkgConfigExtParams getExtParams() {
        return this.extParams;
    }

    public final String getExtraConfig() {
        return this.extraConfig;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNation() {
        return this.nation;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final String getPkgEncrypted() {
        return this.pkgEncrypted;
    }

    public final String getPkgUrl() {
        return this.pkgUrl;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final HashMap<String, String> getResMap() {
        return this.resMap;
    }

    public final String getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.downloadModel;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.app;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.group;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.language;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.name;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.nation;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.networkType;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.pkgUrl;
        int iHashCode8 = (((iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31) + this.priority) * 31;
        String str9 = this.version;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.type;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        HashMap<String, String> map = this.resMap;
        int iHashCode11 = (iHashCode10 + (map == null ? 0 : map.hashCode())) * 31;
        HashMap<String, String> map2 = this.extInfo;
        int iHashCode12 = (iHashCode11 + (map2 == null ? 0 : map2.hashCode())) * 31;
        String str11 = this.extraConfig;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.pkgEncrypted;
        int iHashCode14 = (iHashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        AppInfoModel appInfoModel = this.appInfo;
        int iHashCode15 = (iHashCode14 + (appInfoModel == null ? 0 : appInfoModel.hashCode())) * 31;
        OffPkgConfigExtParams offPkgConfigExtParams = this.extParams;
        int iHashCode16 = (iHashCode15 + (offPkgConfigExtParams == null ? 0 : offPkgConfigExtParams.hashCode())) * 31;
        List<DeliveryDimensionData> list = this.allowDeliveryDimension;
        return iHashCode16 + (list != null ? list.hashCode() : 0);
    }

    public final void setAllowDeliveryDimension(List<DeliveryDimensionData> list) {
        this.allowDeliveryDimension = list;
    }

    public final void setExtInfo(HashMap<String, String> map) {
        this.extInfo = map;
    }

    public final void setExtParams(OffPkgConfigExtParams offPkgConfigExtParams) {
        this.extParams = offPkgConfigExtParams;
    }

    public final void setExtraConfig(String str) {
        this.extraConfig = str;
    }

    public final void setGroup(String str) {
        this.group = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "OffPkgConfig(downloadModel=" + this.downloadModel + ", app=" + this.app + ", group=" + this.group + ", language=" + this.language + ", name=" + this.name + ", nation=" + this.nation + ", networkType=" + this.networkType + ", pkgUrl=" + this.pkgUrl + ", priority=" + this.priority + ", version=" + this.version + ", type=" + this.type + ", resMap=" + this.resMap + ", extInfo=" + this.extInfo + ", extraConfig=" + this.extraConfig + ", pkgEncrypted=" + this.pkgEncrypted + ", appInfo=" + this.appInfo + ", extParams=" + this.extParams + ", allowDeliveryDimension=" + this.allowDeliveryDimension + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.downloadModel);
        parcel.writeString(this.app);
        parcel.writeString(this.group);
        parcel.writeString(this.language);
        parcel.writeString(this.name);
        parcel.writeString(this.nation);
        parcel.writeString(this.networkType);
        parcel.writeString(this.pkgUrl);
        parcel.writeInt(this.priority);
        parcel.writeString(this.version);
        parcel.writeString(this.type);
        parcel.writeMap(this.resMap);
        parcel.writeMap(this.extInfo);
        parcel.writeString(this.extraConfig);
        parcel.writeString(this.pkgEncrypted);
        parcel.writeParcelable(this.appInfo, i11);
        parcel.writeParcelable(this.extParams, i11);
        parcel.writeTypedList(this.allowDeliveryDimension);
    }
}
