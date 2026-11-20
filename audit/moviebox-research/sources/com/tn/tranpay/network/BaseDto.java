package com.tn.tranpay.network;

import com.google.gson.annotations.SerializedName;
import com.hisavana.common.tracking.TrackingKey;
import java.io.Serializable;
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
public class BaseDto<T> implements Serializable {

    @SerializedName(TrackingKey.CODE)
    private int code;

    @SerializedName("data")
    private T data;

    public BaseDto() {
    }

    public BaseDto(int i11, T t11) {
        this.code = i11;
        this.data = t11;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final void setCode(int i11) {
        this.code = i11;
    }

    public final void setData(T t11) {
        this.data = t11;
    }

    public String toString() {
        return "BaseDto(code='" + this.code + "', data=" + this.data + ")";
    }
}
