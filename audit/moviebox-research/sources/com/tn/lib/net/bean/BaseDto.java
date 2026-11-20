package com.tn.lib.net.bean;

import com.google.gson.annotations.SerializedName;
import com.hisavana.common.tracking.TrackingKey;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class BaseDto<T> implements Serializable {

    @SerializedName(TrackingKey.CODE)
    private String code;

    @SerializedName("data")
    private T data;

    @SerializedName("message")
    private String msg;

    @SerializedName("reason")
    private String reason;

    public BaseDto() {
        this.msg = "";
        this.code = "";
        this.reason = "";
    }

    public BaseDto(String msg, String code, T t11, String reason) {
        Intrinsics.g(msg, "msg");
        Intrinsics.g(code, "code");
        Intrinsics.g(reason, "reason");
        this.msg = msg;
        this.code = code;
        this.data = t11;
        this.reason = reason;
    }

    public final String getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setCode(String str) {
        Intrinsics.g(str, "<set-?>");
        this.code = str;
    }

    public final void setData(T t11) {
        this.data = t11;
    }

    public final void setMsg(String str) {
        Intrinsics.g(str, "<set-?>");
        this.msg = str;
    }

    public final void setReason(String str) {
        Intrinsics.g(str, "<set-?>");
        this.reason = str;
    }

    public String toString() {
        return "BaseDto(msg='" + this.msg + "', code='" + this.code + "', data=" + this.data + ", reason=" + this.reason + ")";
    }
}
