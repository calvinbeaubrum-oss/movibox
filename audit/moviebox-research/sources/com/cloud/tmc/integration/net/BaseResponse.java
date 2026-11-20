package com.cloud.tmc.integration.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
public final class BaseResponse<T> extends b {
    private String callbackId;
    private int code;
    private final T data;
    private final String message;

    public BaseResponse() {
        this(0, null, null, null, 15, null);
    }

    public BaseResponse(int i11, T t11, String str, String str2) {
        this.code = i11;
        this.data = t11;
        this.message = str;
        this.callbackId = str2;
    }

    public /* synthetic */ BaseResponse(int i11, Object obj, String str, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? -1 : i11, (i12 & 2) != 0 ? null : obj, (i12 & 4) != 0 ? "" : str, (i12 & 8) != 0 ? "" : str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResponse copy$default(BaseResponse baseResponse, int i11, Object obj, String str, String str2, int i12, Object obj2) {
        if ((i12 & 1) != 0) {
            i11 = baseResponse.code;
        }
        if ((i12 & 2) != 0) {
            obj = baseResponse.data;
        }
        if ((i12 & 4) != 0) {
            str = baseResponse.message;
        }
        if ((i12 & 8) != 0) {
            str2 = baseResponse.callbackId;
        }
        return baseResponse.copy(i11, obj, str, str2);
    }

    public final int component1() {
        return this.code;
    }

    public final T component2() {
        return this.data;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.callbackId;
    }

    public final BaseResponse<T> copy(int i11, T t11, String str, String str2) {
        return new BaseResponse<>(i11, t11, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseResponse)) {
            return false;
        }
        BaseResponse baseResponse = (BaseResponse) obj;
        return this.code == baseResponse.code && Intrinsics.b(this.data, baseResponse.data) && Intrinsics.b(this.message, baseResponse.message) && Intrinsics.b(this.callbackId, baseResponse.callbackId);
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int i11 = this.code * 31;
        T t11 = this.data;
        int iHashCode = (i11 + (t11 == null ? 0 : t11.hashCode())) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.callbackId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setCallbackId(String str) {
        this.callbackId = str;
    }

    public final void setCode(int i11) {
        this.code = i11;
    }

    public String toString() {
        return "BaseResponse(code=" + this.code + ", data=" + this.data + ", message=" + this.message + ", callbackId=" + this.callbackId + ')';
    }
}
