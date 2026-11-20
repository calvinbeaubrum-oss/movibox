package com.transsion.transfer.impl.entity;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class TransferResponse<T> {
    private final int code;
    private final T data;
    private final String errorMsg;

    public TransferResponse(int i11, String errorMsg, T t11) {
        Intrinsics.g(errorMsg, "errorMsg");
        this.code = i11;
        this.errorMsg = errorMsg;
        this.data = t11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransferResponse copy$default(TransferResponse transferResponse, int i11, String str, Object obj, int i12, Object obj2) {
        if ((i12 & 1) != 0) {
            i11 = transferResponse.code;
        }
        if ((i12 & 2) != 0) {
            str = transferResponse.errorMsg;
        }
        if ((i12 & 4) != 0) {
            obj = transferResponse.data;
        }
        return transferResponse.copy(i11, str, obj);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final T component3() {
        return this.data;
    }

    public final TransferResponse<T> copy(int i11, String errorMsg, T t11) {
        Intrinsics.g(errorMsg, "errorMsg");
        return new TransferResponse<>(i11, errorMsg, t11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferResponse)) {
            return false;
        }
        TransferResponse transferResponse = (TransferResponse) obj;
        return this.code == transferResponse.code && Intrinsics.b(this.errorMsg, transferResponse.errorMsg) && Intrinsics.b(this.data, transferResponse.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public int hashCode() {
        int iHashCode = ((this.code * 31) + this.errorMsg.hashCode()) * 31;
        T t11 = this.data;
        return iHashCode + (t11 == null ? 0 : t11.hashCode());
    }

    public String toString() {
        return "TransferResponse(code=" + this.code + ", errorMsg=" + this.errorMsg + ", data=" + this.data + ")";
    }
}
