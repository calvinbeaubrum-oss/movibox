package com.cloud.tmc.integration.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.cloud.tmc.kernel.model.permission.PermissionModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
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
@Metadata
@SourceDebugExtension
public final class AppInfoModel extends b implements Serializable, Parcelable {
    public static final a CREATOR = new a(null);
    private String appId;
    private int appinfoCategoryType;
    private List<ClassificationInfo> classification;
    private List<String> classificationNames;
    private String compatiblePackageUrl;
    private String deployVersion;
    private String desc;
    private String developer;
    private String developerVersion;
    private long expiresTime;
    private ExtendModel extend;
    private int forceUpdate;
    private boolean isTestVersion;
    private String linkAndButtonColor;
    private String logo;
    private String lowestOpenedVersion;
    private String lowestSupportTemplateVersion;
    private String lowestSupportVersion;
    private List<String> mainPackagePages;
    private String mainPackageUrl;
    private String mainUrl;
    private Integer miniappSubtype;
    private String name;
    private String packageSize;
    private String packageUrl;
    private PermissionModel permissions;
    private Integer popupStyle;
    private String privacyPolicyUrl;
    private String processingMethod;
    private String registerType;
    private long releaseTime;
    private String slogan;
    private List<SubPackageInfo> subPackagePages;
    private HashMap<String, String> subPackageUrls;
    private String templateDeployVersion;
    private String templateMiniappId;
    private String templatePackageUrl;
    private String userAgreement;
    private String userAgreementUrl;
    private String userAgreementVersion;
    private String vhost;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<AppInfoModel> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppInfoModel createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new AppInfoModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppInfoModel[] newArray(int i11) {
            return new AppInfoModel[i11];
        }
    }

    public AppInfoModel() {
        this.popupStyle = 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppInfoModel(Parcel parcel) {
        HashMap<String, String> map;
        this();
        Intrinsics.g(parcel, "parcel");
        this.appId = parcel.readString();
        this.deployVersion = parcel.readString();
        this.desc = parcel.readString();
        this.slogan = parcel.readString();
        this.developerVersion = parcel.readString();
        this.logo = parcel.readString();
        this.mainUrl = parcel.readString();
        this.name = parcel.readString();
        this.packageUrl = parcel.readString();
        this.vhost = parcel.readString();
        this.developer = parcel.readString();
        this.permissions = (PermissionModel) parcel.readParcelable(PermissionModel.class.getClassLoader());
        this.expiresTime = parcel.readLong();
        this.releaseTime = parcel.readLong();
        this.lowestSupportVersion = parcel.readString();
        this.packageSize = parcel.readString();
        this.classificationNames = parcel.createStringArrayList();
        this.registerType = parcel.readString();
        this.appinfoCategoryType = parcel.readInt();
        this.extend = (ExtendModel) parcel.readParcelable(ExtendModel.class.getClassLoader());
        this.lowestOpenedVersion = parcel.readString();
        this.forceUpdate = parcel.readInt();
        this.isTestVersion = parcel.readByte() != 0;
        this.mainPackageUrl = parcel.readString();
        HashMap hashMap = parcel.readHashMap(HashMap.class.getClassLoader());
        if (hashMap != null) {
            map = new HashMap<>();
            for (Object obj : hashMap.keySet()) {
                if (hashMap.get(obj) instanceof String) {
                    String string = obj.toString();
                    Object obj2 = hashMap.get(obj);
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    map.put(string, (String) obj2);
                }
            }
        } else {
            map = null;
        }
        this.subPackageUrls = map;
        this.subPackagePages = parcel.createTypedArrayList(SubPackageInfo.CREATOR);
        this.mainPackagePages = parcel.createStringArrayList();
        this.classification = parcel.createTypedArrayList(ClassificationInfo.CREATOR);
        this.userAgreement = parcel.readString();
        this.userAgreementVersion = parcel.readString();
        this.userAgreementUrl = parcel.readString();
        this.privacyPolicyUrl = parcel.readString();
        this.linkAndButtonColor = parcel.readString();
        this.processingMethod = parcel.readString();
        this.popupStyle = Integer.valueOf(parcel.readInt());
        this.miniappSubtype = Integer.valueOf(parcel.readInt());
        this.templateMiniappId = parcel.readString();
        this.templatePackageUrl = parcel.readString();
        this.templateDeployVersion = parcel.readString();
        this.lowestSupportTemplateVersion = parcel.readString();
        this.compatiblePackageUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final int getAppinfoCategoryType() {
        return this.appinfoCategoryType;
    }

    public final List<ClassificationInfo> getClassification() {
        return this.classification;
    }

    public final List<String> getClassificationNames() {
        return this.classificationNames;
    }

    public final String getCompatiblePackageUrl() {
        return this.compatiblePackageUrl;
    }

    public final String getDeployVersion() {
        return this.deployVersion;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDeveloper() {
        return this.developer;
    }

    public final String getDeveloperVersion() {
        return this.developerVersion;
    }

    public final long getExpiresTime() {
        return this.expiresTime;
    }

    public final ExtendModel getExtend() {
        return this.extend;
    }

    public final int getForceUpdate() {
        return this.forceUpdate;
    }

    public final String getLinkAndButtonColor() {
        return this.linkAndButtonColor;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getLowestOpenedVersion() {
        return this.lowestOpenedVersion;
    }

    public final String getLowestSupportTemplateVersion() {
        return this.lowestSupportTemplateVersion;
    }

    public final String getLowestSupportVersion() {
        return this.lowestSupportVersion;
    }

    public final List<String> getMainPackagePages() {
        return this.mainPackagePages;
    }

    public final String getMainPackageUrl() {
        return this.mainPackageUrl;
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final Integer getMiniappSubtype() {
        return this.miniappSubtype;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageSize() {
        return this.packageSize;
    }

    public final String getPackageUrl() {
        return this.packageUrl;
    }

    public final PermissionModel getPermissions() {
        return this.permissions;
    }

    public final Integer getPopupStyle() {
        return this.popupStyle;
    }

    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public final String getProcessingMethod() {
        return this.processingMethod;
    }

    public final String getRegisterType() {
        return this.registerType;
    }

    public final long getReleaseTime() {
        return this.releaseTime;
    }

    public final String getSlogan() {
        return this.slogan;
    }

    public final List<SubPackageInfo> getSubPackagePages() {
        return this.subPackagePages;
    }

    public final HashMap<String, String> getSubPackageUrls() {
        return this.subPackageUrls;
    }

    public final String getTemplateDeployVersion() {
        return this.templateDeployVersion;
    }

    public final String getTemplateMiniappId() {
        return this.templateMiniappId;
    }

    public final String getTemplatePackageUrl() {
        return this.templatePackageUrl;
    }

    public final String getUserAgreement() {
        return this.userAgreement;
    }

    public final String getUserAgreementUrl() {
        return this.userAgreementUrl;
    }

    public final String getUserAgreementVersion() {
        return this.userAgreementVersion;
    }

    public final String getVhost() {
        return this.vhost;
    }

    public final boolean isTestVersion() {
        return this.isTestVersion;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setAppinfoCategoryType(int i11) {
        this.appinfoCategoryType = i11;
    }

    public final void setClassification(List<ClassificationInfo> list) {
        this.classification = list;
    }

    public final void setClassificationNames(List<String> list) {
        this.classificationNames = list;
    }

    public final void setCompatiblePackageUrl(String str) {
        this.compatiblePackageUrl = str;
    }

    public final void setDeployVersion(String str) {
        this.deployVersion = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setDeveloper(String str) {
        this.developer = str;
    }

    public final void setDeveloperVersion(String str) {
        this.developerVersion = str;
    }

    public final void setExpiresTime(long j11) {
        this.expiresTime = j11;
    }

    public final void setExtend(ExtendModel extendModel) {
        this.extend = extendModel;
    }

    public final void setForceUpdate(int i11) {
        this.forceUpdate = i11;
    }

    public final void setLinkAndButtonColor(String str) {
        this.linkAndButtonColor = str;
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final void setLowestOpenedVersion(String str) {
        this.lowestOpenedVersion = str;
    }

    public final void setLowestSupportTemplateVersion(String str) {
        this.lowestSupportTemplateVersion = str;
    }

    public final void setLowestSupportVersion(String str) {
        this.lowestSupportVersion = str;
    }

    public final void setMainPackagePages(List<String> list) {
        this.mainPackagePages = list;
    }

    public final void setMainPackageUrl(String str) {
        this.mainPackageUrl = str;
    }

    public final void setMainUrl(String str) {
        this.mainUrl = str;
    }

    public final void setMiniappSubtype(Integer num) {
        this.miniappSubtype = num;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPackageSize(String str) {
        this.packageSize = str;
    }

    public final void setPackageUrl(String str) {
        this.packageUrl = str;
    }

    public final void setPermissions(PermissionModel permissionModel) {
        this.permissions = permissionModel;
    }

    public final void setPopupStyle(Integer num) {
        this.popupStyle = num;
    }

    public final void setPrivacyPolicyUrl(String str) {
        this.privacyPolicyUrl = str;
    }

    public final void setProcessingMethod(String str) {
        this.processingMethod = str;
    }

    public final void setRegisterType(String str) {
        this.registerType = str;
    }

    public final void setReleaseTime(long j11) {
        this.releaseTime = j11;
    }

    public final void setSlogan(String str) {
        this.slogan = str;
    }

    public final void setSubPackagePages(List<SubPackageInfo> list) {
        this.subPackagePages = list;
    }

    public final void setSubPackageUrls(HashMap<String, String> map) {
        this.subPackageUrls = map;
    }

    public final void setTemplateDeployVersion(String str) {
        this.templateDeployVersion = str;
    }

    public final void setTemplateMiniappId(String str) {
        this.templateMiniappId = str;
    }

    public final void setTemplatePackageUrl(String str) {
        this.templatePackageUrl = str;
    }

    public final void setTestVersion(boolean z11) {
        this.isTestVersion = z11;
    }

    public final void setUserAgreement(String str) {
        this.userAgreement = str;
    }

    public final void setUserAgreementUrl(String str) {
        this.userAgreementUrl = str;
    }

    public final void setUserAgreementVersion(String str) {
        this.userAgreementVersion = str;
    }

    public final void setVhost(String str) {
        this.vhost = str;
    }

    public String toString() {
        return "AppInfoModel(appId=" + this.appId + ", deployVersion=" + this.deployVersion + ", desc=" + this.desc + ", slogan=" + this.slogan + ", developerVersion=" + this.developerVersion + ", logo=" + this.logo + ", mainUrl=" + this.mainUrl + ", name=" + this.name + ", packageUrl=" + this.packageUrl + ", vhost=" + this.vhost + ", developer=" + this.developer + ", permissions=" + this.permissions + ", expiresTime=" + this.expiresTime + ", releaseTime=" + this.releaseTime + ", lowestSupportVersion=" + this.lowestSupportVersion + ", lowestOpenedVersion=" + this.lowestOpenedVersion + ", forceUpdate=" + this.forceUpdate + ", packageSize=" + this.packageSize + ", classificationNames=" + this.classificationNames + ", registerType=" + this.registerType + ", appinfoCategoryType=" + this.appinfoCategoryType + ", extend=" + this.extend + ", mainPackageUrl=" + this.mainPackageUrl + ", userAgreement=" + this.userAgreement + ", privacyPolicyUrl=" + this.privacyPolicyUrl + ", linkAndButtonColor=" + this.linkAndButtonColor + ", processingMethod=" + this.processingMethod + ",popupStyle=" + this.popupStyle + ",miniappSubtype=" + this.miniappSubtype + ",templateMiniappId=" + this.templateMiniappId + ",templatePackageUrl=" + this.templatePackageUrl + ",templateDeployVersion=" + this.templateDeployVersion + ",lowestSupportTemplateVersion=" + this.lowestSupportTemplateVersion + ",compatiblePackageUrl=" + this.compatiblePackageUrl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeString(this.deployVersion);
        parcel.writeString(this.desc);
        parcel.writeString(this.slogan);
        parcel.writeString(this.developerVersion);
        parcel.writeString(this.logo);
        parcel.writeString(this.mainUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.packageUrl);
        parcel.writeString(this.vhost);
        parcel.writeString(this.developer);
        parcel.writeParcelable(this.permissions, i11);
        parcel.writeLong(this.expiresTime);
        parcel.writeLong(this.releaseTime);
        parcel.writeString(this.lowestSupportVersion);
        parcel.writeString(this.packageSize);
        parcel.writeStringList(this.classificationNames);
        parcel.writeString(this.registerType);
        parcel.writeInt(this.appinfoCategoryType);
        parcel.writeParcelable(this.extend, i11);
        parcel.writeString(this.lowestOpenedVersion);
        parcel.writeInt(this.forceUpdate);
        parcel.writeByte(this.isTestVersion ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mainPackageUrl);
        parcel.writeMap(this.subPackageUrls);
        parcel.writeTypedList(this.subPackagePages);
        parcel.writeStringList(this.mainPackagePages);
        parcel.writeTypedList(this.classification);
        parcel.writeString(this.userAgreement);
        parcel.writeString(this.userAgreementVersion);
        parcel.writeString(this.userAgreementUrl);
        parcel.writeString(this.privacyPolicyUrl);
        parcel.writeString(this.linkAndButtonColor);
        parcel.writeString(this.processingMethod);
        Integer num = this.popupStyle;
        parcel.writeInt(num != null ? num.intValue() : 0);
        Integer num2 = this.miniappSubtype;
        parcel.writeInt(num2 != null ? num2.intValue() : 0);
        parcel.writeString(this.templateMiniappId);
        parcel.writeString(this.templatePackageUrl);
        parcel.writeString(this.templateDeployVersion);
        parcel.writeString(this.lowestSupportTemplateVersion);
        parcel.writeString(this.compatiblePackageUrl);
    }
}
