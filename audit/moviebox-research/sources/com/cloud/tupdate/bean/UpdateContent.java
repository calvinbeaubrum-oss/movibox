package com.cloud.tupdate.bean;

import java.util.List;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class UpdateContent {
    private final String cancelUpdateButton;
    private final String criteriaResult;
    private final String encryptedPackage;
    private final Boolean force;
    private final Boolean googlePlayUpdate;
    private final String ignoreUpdateTips;
    private final Boolean showDialog;
    private final String updateButton;
    private final String updateContent;
    private final List<Float> updateInterval;
    private final String updateTitle;
    private final String updateUrl;
    private final String updateVersion;

    public UpdateContent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public UpdateContent(Boolean bool, Boolean bool2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool3, List<Float> list, String str9) {
        this.showDialog = bool;
        this.force = bool2;
        this.updateTitle = str;
        this.updateVersion = str2;
        this.updateContent = str3;
        this.updateButton = str4;
        this.cancelUpdateButton = str5;
        this.ignoreUpdateTips = str6;
        this.encryptedPackage = str7;
        this.updateUrl = str8;
        this.googlePlayUpdate = bool3;
        this.updateInterval = list;
        this.criteriaResult = str9;
    }

    public /* synthetic */ UpdateContent(Boolean bool, Boolean bool2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool3, List list, String str9, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : bool2, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? null : str4, (i11 & 64) != 0 ? null : str5, (i11 & 128) != 0 ? null : str6, (i11 & 256) != 0 ? null : str7, (i11 & 512) != 0 ? null : str8, (i11 & 1024) != 0 ? null : bool3, (i11 & 2048) != 0 ? null : list, (i11 & 4096) == 0 ? str9 : null);
    }

    public final Boolean component1() {
        return this.showDialog;
    }

    public final String component10() {
        return this.updateUrl;
    }

    public final Boolean component11() {
        return this.googlePlayUpdate;
    }

    public final List<Float> component12() {
        return this.updateInterval;
    }

    public final String component13() {
        return this.criteriaResult;
    }

    public final Boolean component2() {
        return this.force;
    }

    public final String component3() {
        return this.updateTitle;
    }

    public final String component4() {
        return this.updateVersion;
    }

    public final String component5() {
        return this.updateContent;
    }

    public final String component6() {
        return this.updateButton;
    }

    public final String component7() {
        return this.cancelUpdateButton;
    }

    public final String component8() {
        return this.ignoreUpdateTips;
    }

    public final String component9() {
        return this.encryptedPackage;
    }

    public final UpdateContent copy(Boolean bool, Boolean bool2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool3, List<Float> list, String str9) {
        return new UpdateContent(bool, bool2, str, str2, str3, str4, str5, str6, str7, str8, bool3, list, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateContent)) {
            return false;
        }
        UpdateContent updateContent = (UpdateContent) obj;
        return Intrinsics.b(this.showDialog, updateContent.showDialog) && Intrinsics.b(this.force, updateContent.force) && Intrinsics.b(this.updateTitle, updateContent.updateTitle) && Intrinsics.b(this.updateVersion, updateContent.updateVersion) && Intrinsics.b(this.updateContent, updateContent.updateContent) && Intrinsics.b(this.updateButton, updateContent.updateButton) && Intrinsics.b(this.cancelUpdateButton, updateContent.cancelUpdateButton) && Intrinsics.b(this.ignoreUpdateTips, updateContent.ignoreUpdateTips) && Intrinsics.b(this.encryptedPackage, updateContent.encryptedPackage) && Intrinsics.b(this.updateUrl, updateContent.updateUrl) && Intrinsics.b(this.googlePlayUpdate, updateContent.googlePlayUpdate) && Intrinsics.b(this.updateInterval, updateContent.updateInterval) && Intrinsics.b(this.criteriaResult, updateContent.criteriaResult);
    }

    public final String getCancelUpdateButton() {
        return this.cancelUpdateButton;
    }

    public final String getCriteriaResult() {
        return this.criteriaResult;
    }

    public final String getEncryptedPackage() {
        return this.encryptedPackage;
    }

    public final Boolean getForce() {
        return this.force;
    }

    public final Boolean getGooglePlayUpdate() {
        return this.googlePlayUpdate;
    }

    public final String getIgnoreUpdateTips() {
        return this.ignoreUpdateTips;
    }

    public final Boolean getShowDialog() {
        return this.showDialog;
    }

    public final String getUpdateButton() {
        return this.updateButton;
    }

    public final String getUpdateContent() {
        return this.updateContent;
    }

    public final List<Float> getUpdateInterval() {
        return this.updateInterval;
    }

    public final String getUpdateTitle() {
        return this.updateTitle;
    }

    public final String getUpdateUrl() {
        return this.updateUrl;
    }

    public final String getUpdateVersion() {
        return this.updateVersion;
    }

    public int hashCode() {
        Boolean bool = this.showDialog;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.force;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.updateTitle;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.updateVersion;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.updateContent;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.updateButton;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cancelUpdateButton;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.ignoreUpdateTips;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.encryptedPackage;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.updateUrl;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool3 = this.googlePlayUpdate;
        int iHashCode11 = (iHashCode10 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        List<Float> list = this.updateInterval;
        int iHashCode12 = (iHashCode11 + (list == null ? 0 : list.hashCode())) * 31;
        String str9 = this.criteriaResult;
        return iHashCode12 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        return "UpdateContent(showDialog=" + this.showDialog + ", force=" + this.force + ", updateTitle=" + ((Object) this.updateTitle) + ", updateVersion=" + ((Object) this.updateVersion) + ", updateContent=" + ((Object) this.updateContent) + ", updateButton=" + ((Object) this.updateButton) + ", cancelUpdateButton=" + ((Object) this.cancelUpdateButton) + ", ignoreUpdateTips=" + ((Object) this.ignoreUpdateTips) + ", encryptedPackage=" + ((Object) this.encryptedPackage) + ", updateUrl=" + ((Object) this.updateUrl) + ", googlePlayUpdate=" + this.googlePlayUpdate + ", updateInterval=" + this.updateInterval + ", criteriaResult=" + ((Object) this.criteriaResult) + ')';
    }
}
