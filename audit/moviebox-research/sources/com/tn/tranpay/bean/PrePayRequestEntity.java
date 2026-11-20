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
public final class PrePayRequestEntity implements Serializable {
    private String language;
    private boolean payByLocalCurrency;
    private String payMethod;
    private String appKey = "";
    private String amount = "";
    private String countryCode = "";
    private String orderId = "";
    private String orderDescription = "";
    private String currency = "";

    public final String getAmount() {
        return this.amount;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getOrderDescription() {
        return this.orderDescription;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final boolean getPayByLocalCurrency() {
        return this.payByLocalCurrency;
    }

    public final String getPayMethod() {
        return this.payMethod;
    }

    public final void setAmount(String str) {
        Intrinsics.g(str, "<set-?>");
        this.amount = str;
    }

    public final void setAppKey(String str) {
        Intrinsics.g(str, "<set-?>");
        this.appKey = str;
    }

    public final void setCountryCode(String str) {
        Intrinsics.g(str, "<set-?>");
        this.countryCode = str;
    }

    public final void setCurrency(String str) {
        Intrinsics.g(str, "<set-?>");
        this.currency = str;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setOrderDescription(String str) {
        Intrinsics.g(str, "<set-?>");
        this.orderDescription = str;
    }

    public final void setOrderId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.orderId = str;
    }

    public final void setPayByLocalCurrency(boolean z11) {
        this.payByLocalCurrency = z11;
    }

    public final void setPayMethod(String str) {
        this.payMethod = str;
    }
}
