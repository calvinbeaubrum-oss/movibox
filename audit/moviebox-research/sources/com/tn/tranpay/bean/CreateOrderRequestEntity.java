package com.tn.tranpay.bean;

import java.io.Serializable;
import kotlin.Metadata;
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
@Metadata
public final class CreateOrderRequestEntity implements Serializable {
    private String cnic;
    private String cpFrontPage;
    private String email;
    private String language;
    private String memo;
    private String palmAuthCode;
    private Boolean payByLocalCurrency;
    private String payMethod;
    private String phone;
    private String referenceNo;
    private String amount = "";
    private String countryCode = "";
    private String currency = "";
    private String orderId = "";
    private String orderDescription = "";

    public final String getAmount() {
        return this.amount;
    }

    public final String getCnic() {
        return this.cnic;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getMemo() {
        return this.memo;
    }

    public final String getOrderDescription() {
        return this.orderDescription;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPalmAuthCode() {
        return this.palmAuthCode;
    }

    public final Boolean getPayByLocalCurrency() {
        return this.payByLocalCurrency;
    }

    public final String getPayMethod() {
        return this.payMethod;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getReferenceNo() {
        return this.referenceNo;
    }

    public final void setAmount(String str) {
        Intrinsics.g(str, "<set-?>");
        this.amount = str;
    }

    public final void setCnic(String str) {
        this.cnic = str;
    }

    public final void setCountryCode(String str) {
        Intrinsics.g(str, "<set-?>");
        this.countryCode = str;
    }

    public final void setCpFrontPage(String str) {
        this.cpFrontPage = str;
    }

    public final void setCurrency(String str) {
        Intrinsics.g(str, "<set-?>");
        this.currency = str;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setMemo(String str) {
        this.memo = str;
    }

    public final void setOrderDescription(String str) {
        Intrinsics.g(str, "<set-?>");
        this.orderDescription = str;
    }

    public final void setOrderId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.orderId = str;
    }

    public final void setPalmAuthCode(String str) {
        this.palmAuthCode = str;
    }

    public final void setPayByLocalCurrency(Boolean bool) {
        this.payByLocalCurrency = bool;
    }

    public final void setPayMethod(String str) {
        this.payMethod = str;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final void setReferenceNo(String str) {
        this.referenceNo = str;
    }
}
