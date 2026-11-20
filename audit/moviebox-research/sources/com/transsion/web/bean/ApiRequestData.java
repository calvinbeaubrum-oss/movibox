package com.transsion.web.bean;

import androidx.annotation.Keep;
import java.util.Map;
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
public final class ApiRequestData {
    private final String api;
    private final Map<String, String> headers;
    private final String host;
    private final String methods;
    private final Map<String, Object> queryParams;

    public ApiRequestData() {
        this(null, null, null, null, null, 31, null);
    }

    public ApiRequestData(String str, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
        this.host = str;
        this.api = str2;
        this.methods = str3;
        this.headers = map;
        this.queryParams = map2;
    }

    public /* synthetic */ ApiRequestData(String str, String str2, String str3, Map map, Map map2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : map, (i11 & 16) != 0 ? null : map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiRequestData copy$default(ApiRequestData apiRequestData, String str, String str2, String str3, Map map, Map map2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = apiRequestData.host;
        }
        if ((i11 & 2) != 0) {
            str2 = apiRequestData.api;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            str3 = apiRequestData.methods;
        }
        String str5 = str3;
        if ((i11 & 8) != 0) {
            map = apiRequestData.headers;
        }
        Map map3 = map;
        if ((i11 & 16) != 0) {
            map2 = apiRequestData.queryParams;
        }
        return apiRequestData.copy(str, str4, str5, map3, map2);
    }

    public final String component1() {
        return this.host;
    }

    public final String component2() {
        return this.api;
    }

    public final String component3() {
        return this.methods;
    }

    public final Map<String, String> component4() {
        return this.headers;
    }

    public final Map<String, Object> component5() {
        return this.queryParams;
    }

    public final ApiRequestData copy(String str, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
        return new ApiRequestData(str, str2, str3, map, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiRequestData)) {
            return false;
        }
        ApiRequestData apiRequestData = (ApiRequestData) obj;
        return Intrinsics.b(this.host, apiRequestData.host) && Intrinsics.b(this.api, apiRequestData.api) && Intrinsics.b(this.methods, apiRequestData.methods) && Intrinsics.b(this.headers, apiRequestData.headers) && Intrinsics.b(this.queryParams, apiRequestData.queryParams);
    }

    public final String getApi() {
        return this.api;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getMethods() {
        return this.methods;
    }

    public final Map<String, Object> getQueryParams() {
        return this.queryParams;
    }

    public int hashCode() {
        String str = this.host;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.api;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.methods;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map<String, String> map = this.headers;
        int iHashCode4 = (iHashCode3 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Object> map2 = this.queryParams;
        return iHashCode4 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        return "ApiRequestData(host=" + this.host + ", api=" + this.api + ", methods=" + this.methods + ", headers=" + this.headers + ", queryParams=" + this.queryParams + ")";
    }
}
