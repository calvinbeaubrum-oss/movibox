package com.cloud.tmc.integration.model;

import kotlin.Metadata;
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
public final class CDNConfigBean extends b {
    private String cdnConfigToken;
    private Boolean enableCdnRequest;
    private Float grayScale;

    public CDNConfigBean(Boolean bool, String str, Float f11) {
        this.enableCdnRequest = bool;
        this.cdnConfigToken = str;
        this.grayScale = f11;
    }

    public static /* synthetic */ CDNConfigBean copy$default(CDNConfigBean cDNConfigBean, Boolean bool, String str, Float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = cDNConfigBean.enableCdnRequest;
        }
        if ((i11 & 2) != 0) {
            str = cDNConfigBean.cdnConfigToken;
        }
        if ((i11 & 4) != 0) {
            f11 = cDNConfigBean.grayScale;
        }
        return cDNConfigBean.copy(bool, str, f11);
    }

    public final Boolean component1() {
        return this.enableCdnRequest;
    }

    public final String component2() {
        return this.cdnConfigToken;
    }

    public final Float component3() {
        return this.grayScale;
    }

    public final CDNConfigBean copy(Boolean bool, String str, Float f11) {
        return new CDNConfigBean(bool, str, f11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CDNConfigBean)) {
            return false;
        }
        CDNConfigBean cDNConfigBean = (CDNConfigBean) obj;
        return Intrinsics.b(this.enableCdnRequest, cDNConfigBean.enableCdnRequest) && Intrinsics.b(this.cdnConfigToken, cDNConfigBean.cdnConfigToken) && Intrinsics.b(this.grayScale, cDNConfigBean.grayScale);
    }

    public final String getCdnConfigToken() {
        return this.cdnConfigToken;
    }

    public final Boolean getEnableCdnRequest() {
        return this.enableCdnRequest;
    }

    public final Float getGrayScale() {
        return this.grayScale;
    }

    public int hashCode() {
        Boolean bool = this.enableCdnRequest;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.cdnConfigToken;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Float f11 = this.grayScale;
        return iHashCode2 + (f11 != null ? f11.hashCode() : 0);
    }

    public final void setCdnConfigToken(String str) {
        this.cdnConfigToken = str;
    }

    public final void setEnableCdnRequest(Boolean bool) {
        this.enableCdnRequest = bool;
    }

    public final void setGrayScale(Float f11) {
        this.grayScale = f11;
    }

    public String toString() {
        return "CDNConfigBean(enableCdnRequest=" + this.enableCdnRequest + ", cdnConfigToken=" + this.cdnConfigToken + ", grayScale=" + this.grayScale + ')';
    }
}
