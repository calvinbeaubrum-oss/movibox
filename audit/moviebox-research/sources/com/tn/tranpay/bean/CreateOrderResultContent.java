package com.tn.tranpay.bean;

import com.tn.tranpay.network.BaseContent;
import dq.a;
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
public final class CreateOrderResultContent extends BaseContent {
    private a payInstruction;
    private String rnUrl;
    private String status;
    private String txnId;
    private String webUrl;

    public final a getPayInstruction() {
        return null;
    }

    public final String getRnUrl() {
        return this.rnUrl;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public final void setPayInstruction(a aVar) {
    }

    public final void setRnUrl(String str) {
        this.rnUrl = str;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void setTxnId(String str) {
        this.txnId = str;
    }

    public final void setWebUrl(String str) {
        this.webUrl = str;
    }
}
