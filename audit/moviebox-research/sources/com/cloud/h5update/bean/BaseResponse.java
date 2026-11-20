package com.cloud.h5update.bean;

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
public final class BaseResponse<T> {
    private final int code;
    private final T data;
    private final String message;

    public BaseResponse() {
        this(0, null, null, 7, null);
    }

    public BaseResponse(int i11, String str, T t11) {
        this.code = i11;
        this.message = str;
        this.data = t11;
    }

    public /* synthetic */ BaseResponse(int i11, String str, Object obj, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? -1 : i11, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? null : obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResponse copy$default(BaseResponse baseResponse, int i11, String str, Object obj, int i12, Object obj2) {
        if ((i12 & 1) != 0) {
            i11 = baseResponse.code;
        }
        if ((i12 & 2) != 0) {
            str = baseResponse.message;
        }
        if ((i12 & 4) != 0) {
            obj = baseResponse.data;
        }
        return baseResponse.copy(i11, str, obj);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final T component3() {
        return this.data;
    }

    public final BaseResponse<T> copy(int i11, String str, T t11) {
        return new BaseResponse<>(i11, str, t11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseResponse)) {
            return false;
        }
        BaseResponse baseResponse = (BaseResponse) obj;
        return this.code == baseResponse.code && Intrinsics.b(this.message, baseResponse.message) && Intrinsics.b(this.data, baseResponse.data);
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
        String str = this.message;
        int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        T t11 = this.data;
        return iHashCode + (t11 != null ? t11.hashCode() : 0);
    }

    public String toString() {
        return "BaseResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }
}
