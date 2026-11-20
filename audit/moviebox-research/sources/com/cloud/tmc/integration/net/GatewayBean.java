package com.cloud.tmc.integration.net;

import com.google.gson.annotations.SerializedName;
import com.hisavana.common.tracking.TrackingKey;
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
public final class GatewayBean extends b {

    @SerializedName("callbackId")
    private String callbackId;

    @SerializedName(TrackingKey.ERROR_CODE)
    private final String errorCode;

    @SerializedName(TrackingKey.ERROR_MESSAGE)
    private final String errorMessage;

    public GatewayBean() {
        this(null, null, null, 7, null);
    }

    public GatewayBean(String errorCode, String errorMessage, String str) {
        Intrinsics.g(errorCode, "errorCode");
        Intrinsics.g(errorMessage, "errorMessage");
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.callbackId = str;
    }

    public /* synthetic */ GatewayBean(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3);
    }

    public static /* synthetic */ GatewayBean copy$default(GatewayBean gatewayBean, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gatewayBean.errorCode;
        }
        if ((i11 & 2) != 0) {
            str2 = gatewayBean.errorMessage;
        }
        if ((i11 & 4) != 0) {
            str3 = gatewayBean.callbackId;
        }
        return gatewayBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final String component3() {
        return this.callbackId;
    }

    public final GatewayBean copy(String errorCode, String errorMessage, String str) {
        Intrinsics.g(errorCode, "errorCode");
        Intrinsics.g(errorMessage, "errorMessage");
        return new GatewayBean(errorCode, errorMessage, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GatewayBean)) {
            return false;
        }
        GatewayBean gatewayBean = (GatewayBean) obj;
        return Intrinsics.b(this.errorCode, gatewayBean.errorCode) && Intrinsics.b(this.errorMessage, gatewayBean.errorMessage) && Intrinsics.b(this.callbackId, gatewayBean.callbackId);
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        int iHashCode = ((this.errorCode.hashCode() * 31) + this.errorMessage.hashCode()) * 31;
        String str = this.callbackId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setCallbackId(String str) {
        this.callbackId = str;
    }

    public String toString() {
        return "GatewayBean(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", callbackId=" + this.callbackId + ')';
    }
}
