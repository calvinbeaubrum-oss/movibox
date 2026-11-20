package com.cloud.tmc.ad.bean;

import java.io.Serializable;
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
public final class FormBean implements Serializable {
    private int advertiserId;
    private List<FormCustomInfosDTO> formCustomInfos;
    private String formEmail;
    private int formId;
    private String formName;
    private String formPhone;
    private String gaid;
    private String ipAddress;

    public FormBean() {
        this(0, null, null, 0, null, null, null, null, 255, null);
    }

    public FormBean(int i11, List<FormCustomInfosDTO> list, String str, int i12, String str2, String str3, String str4, String str5) {
        this.advertiserId = i11;
        this.formCustomInfos = list;
        this.formEmail = str;
        this.formId = i12;
        this.formName = str2;
        this.formPhone = str3;
        this.gaid = str4;
        this.ipAddress = str5;
    }

    public /* synthetic */ FormBean(int i11, List list, String str, int i12, String str2, String str3, String str4, String str5, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? null : list, (i13 & 4) != 0 ? null : str, (i13 & 8) == 0 ? i12 : 0, (i13 & 16) != 0 ? null : str2, (i13 & 32) != 0 ? null : str3, (i13 & 64) != 0 ? null : str4, (i13 & 128) == 0 ? str5 : null);
    }

    public final int component1() {
        return this.advertiserId;
    }

    public final List<FormCustomInfosDTO> component2() {
        return this.formCustomInfos;
    }

    public final String component3() {
        return this.formEmail;
    }

    public final int component4() {
        return this.formId;
    }

    public final String component5() {
        return this.formName;
    }

    public final String component6() {
        return this.formPhone;
    }

    public final String component7() {
        return this.gaid;
    }

    public final String component8() {
        return this.ipAddress;
    }

    public final FormBean copy(int i11, List<FormCustomInfosDTO> list, String str, int i12, String str2, String str3, String str4, String str5) {
        return new FormBean(i11, list, str, i12, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormBean)) {
            return false;
        }
        FormBean formBean = (FormBean) obj;
        return this.advertiserId == formBean.advertiserId && Intrinsics.b(this.formCustomInfos, formBean.formCustomInfos) && Intrinsics.b(this.formEmail, formBean.formEmail) && this.formId == formBean.formId && Intrinsics.b(this.formName, formBean.formName) && Intrinsics.b(this.formPhone, formBean.formPhone) && Intrinsics.b(this.gaid, formBean.gaid) && Intrinsics.b(this.ipAddress, formBean.ipAddress);
    }

    public final int getAdvertiserId() {
        return this.advertiserId;
    }

    public final List<FormCustomInfosDTO> getFormCustomInfos() {
        return this.formCustomInfos;
    }

    public final String getFormEmail() {
        return this.formEmail;
    }

    public final int getFormId() {
        return this.formId;
    }

    public final String getFormName() {
        return this.formName;
    }

    public final String getFormPhone() {
        return this.formPhone;
    }

    public final String getGaid() {
        return this.gaid;
    }

    public final String getIpAddress() {
        return this.ipAddress;
    }

    public int hashCode() {
        int i11 = this.advertiserId * 31;
        List<FormCustomInfosDTO> list = this.formCustomInfos;
        int iHashCode = (i11 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.formEmail;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.formId) * 31;
        String str2 = this.formName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.formPhone;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.gaid;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.ipAddress;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setAdvertiserId(int i11) {
        this.advertiserId = i11;
    }

    public final void setFormCustomInfos(List<FormCustomInfosDTO> list) {
        this.formCustomInfos = list;
    }

    public final void setFormEmail(String str) {
        this.formEmail = str;
    }

    public final void setFormId(int i11) {
        this.formId = i11;
    }

    public final void setFormName(String str) {
        this.formName = str;
    }

    public final void setFormPhone(String str) {
        this.formPhone = str;
    }

    public final void setGaid(String str) {
        this.gaid = str;
    }

    public final void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public String toString() {
        return "FormBean(advertiserId=" + this.advertiserId + ", formCustomInfos=" + this.formCustomInfos + ", formEmail=" + this.formEmail + ", formId=" + this.formId + ", formName=" + this.formName + ", formPhone=" + this.formPhone + ", gaid=" + this.gaid + ", ipAddress=" + this.ipAddress + ')';
    }
}
