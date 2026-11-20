package com.tn.tranpay.network;

import com.applovin.sdk.AppLovinEventTypes;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tn.tranpay.helper.c;
import com.tn.tranpay.network.BaseContent;
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
public class BaseSignDto<T extends BaseContent> implements Serializable {

    @SerializedName(AppLovinEventTypes.USER_VIEWED_CONTENT)
    private String content;
    private T parseContent;

    @SerializedName("responseCode")
    private String responseCode;

    @SerializedName("responseMessage")
    private String responseMessage;

    @SerializedName("sign")
    private String sign;

    public BaseSignDto() {
        this.responseCode = "";
        this.responseMessage = "";
    }

    public BaseSignDto(String responseCode, String responseMessage, String str, String str2) {
        Intrinsics.g(responseCode, "responseCode");
        Intrinsics.g(responseMessage, "responseMessage");
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.content = str;
        this.sign = str2;
    }

    public final String getContent() {
        return this.content;
    }

    public final T getParseContent() {
        return this.parseContent;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final String getSign() {
        return this.sign;
    }

    public final T parseContent(Class<T> contentClass) {
        String strA;
        Intrinsics.g(contentClass, "contentClass");
        String str = this.content;
        if (str == null || (strA = c.a(str)) == null) {
            return null;
        }
        return (T) new Gson().fromJson(strA, (Class) contentClass);
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setParseContent(T t11) {
        this.parseContent = t11;
    }

    public final void setResponseCode(String str) {
        Intrinsics.g(str, "<set-?>");
        this.responseCode = str;
    }

    public final void setResponseMessage(String str) {
        Intrinsics.g(str, "<set-?>");
        this.responseMessage = str;
    }

    public final void setSign(String str) {
        this.sign = str;
    }

    public String toString() {
        return "BaseSignDto(code='" + this.responseCode + "', message=" + this.responseMessage + ", content=" + this.content + ")";
    }
}
