package com.tn.tranpay.bean;

import com.tn.tranpay.network.BaseContent;
import kotlin.Metadata;

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
public final class QueryOrderResultContent extends BaseContent {
    private String coins;
    private String completeTime;
    private String countryLogo;
    private String countryName;
    private String cpFrontPage;
    private String cpLogo;
    private String cpName;
    private String currency;
    private String orderDescription;
    private String orderId;
    private String payMethod;
    private String payMethodLogo;
    private String payMethodName;
    private String resultInterceptUrl;
    private String status;
    private String stepStatus;
    private String symbol;

    public final String getCoins() {
        return this.coins;
    }

    public final String getCompleteTime() {
        return this.completeTime;
    }

    public final String getCountryLogo() {
        return this.countryLogo;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    public final String getCpLogo() {
        return this.cpLogo;
    }

    public final String getCpName() {
        return this.cpName;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getOrderDescription() {
        return this.orderDescription;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPayMethod() {
        return this.payMethod;
    }

    public final String getPayMethodLogo() {
        return this.payMethodLogo;
    }

    public final String getPayMethodName() {
        return this.payMethodName;
    }

    public final String getResultInterceptUrl() {
        return this.resultInterceptUrl;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getStepStatus() {
        return this.stepStatus;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public final void setCoins(String str) {
        this.coins = str;
    }

    public final void setCompleteTime(String str) {
        this.completeTime = str;
    }

    public final void setCountryLogo(String str) {
        this.countryLogo = str;
    }

    public final void setCountryName(String str) {
        this.countryName = str;
    }

    public final void setCpFrontPage(String str) {
        this.cpFrontPage = str;
    }

    public final void setCpLogo(String str) {
        this.cpLogo = str;
    }

    public final void setCpName(String str) {
        this.cpName = str;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setOrderDescription(String str) {
        this.orderDescription = str;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void setPayMethod(String str) {
        this.payMethod = str;
    }

    public final void setPayMethodLogo(String str) {
        this.payMethodLogo = str;
    }

    public final void setPayMethodName(String str) {
        this.payMethodName = str;
    }

    public final void setResultInterceptUrl(String str) {
        this.resultInterceptUrl = str;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void setStepStatus(String str) {
        this.stepStatus = str;
    }

    public final void setSymbol(String str) {
        this.symbol = str;
    }
}
