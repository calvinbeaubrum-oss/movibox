package com.transsion.web.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.hisavana.common.tracking.TrackingKey;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class JsCallbackData implements Serializable {

    @SerializedName(TrackingKey.CODE)
    private String code;

    @SerializedName("message")
    private String msg;

    /* JADX WARN: Multi-variable type inference failed */
    public JsCallbackData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public JsCallbackData(String msg, String code) {
        Intrinsics.g(msg, "msg");
        Intrinsics.g(code, "code");
        this.msg = msg;
        this.code = code;
    }

    public /* synthetic */ JsCallbackData(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2);
    }

    public static /* synthetic */ JsCallbackData copy$default(JsCallbackData jsCallbackData, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = jsCallbackData.msg;
        }
        if ((i11 & 2) != 0) {
            str2 = jsCallbackData.code;
        }
        return jsCallbackData.copy(str, str2);
    }

    public final String component1() {
        return this.msg;
    }

    public final String component2() {
        return this.code;
    }

    public final JsCallbackData copy(String msg, String code) {
        Intrinsics.g(msg, "msg");
        Intrinsics.g(code, "code");
        return new JsCallbackData(msg, code);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JsCallbackData)) {
            return false;
        }
        JsCallbackData jsCallbackData = (JsCallbackData) obj;
        return Intrinsics.b(this.msg, jsCallbackData.msg) && Intrinsics.b(this.code, jsCallbackData.code);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return (this.msg.hashCode() * 31) + this.code.hashCode();
    }

    public final void setCode(String str) {
        Intrinsics.g(str, "<set-?>");
        this.code = str;
    }

    public final void setMsg(String str) {
        Intrinsics.g(str, "<set-?>");
        this.msg = str;
    }

    public String toString() {
        return "JsCallbackData(msg=" + this.msg + ", code=" + this.code + ")";
    }
}
