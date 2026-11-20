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
public final class WarmUpEntranceConfigBean extends b {
    private String configToken;
    private Boolean enableWarmUp;
    private Float grayScale;

    public WarmUpEntranceConfigBean(Boolean bool, String str, Float f11) {
        this.enableWarmUp = bool;
        this.configToken = str;
        this.grayScale = f11;
    }

    public static /* synthetic */ WarmUpEntranceConfigBean copy$default(WarmUpEntranceConfigBean warmUpEntranceConfigBean, Boolean bool, String str, Float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = warmUpEntranceConfigBean.enableWarmUp;
        }
        if ((i11 & 2) != 0) {
            str = warmUpEntranceConfigBean.configToken;
        }
        if ((i11 & 4) != 0) {
            f11 = warmUpEntranceConfigBean.grayScale;
        }
        return warmUpEntranceConfigBean.copy(bool, str, f11);
    }

    public final Boolean component1() {
        return this.enableWarmUp;
    }

    public final String component2() {
        return this.configToken;
    }

    public final Float component3() {
        return this.grayScale;
    }

    public final WarmUpEntranceConfigBean copy(Boolean bool, String str, Float f11) {
        return new WarmUpEntranceConfigBean(bool, str, f11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WarmUpEntranceConfigBean)) {
            return false;
        }
        WarmUpEntranceConfigBean warmUpEntranceConfigBean = (WarmUpEntranceConfigBean) obj;
        return Intrinsics.b(this.enableWarmUp, warmUpEntranceConfigBean.enableWarmUp) && Intrinsics.b(this.configToken, warmUpEntranceConfigBean.configToken) && Intrinsics.b(this.grayScale, warmUpEntranceConfigBean.grayScale);
    }

    public final String getConfigToken() {
        return this.configToken;
    }

    public final Boolean getEnableWarmUp() {
        return this.enableWarmUp;
    }

    public final Float getGrayScale() {
        return this.grayScale;
    }

    public int hashCode() {
        Boolean bool = this.enableWarmUp;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.configToken;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Float f11 = this.grayScale;
        return iHashCode2 + (f11 != null ? f11.hashCode() : 0);
    }

    public final void setConfigToken(String str) {
        this.configToken = str;
    }

    public final void setEnableWarmUp(Boolean bool) {
        this.enableWarmUp = bool;
    }

    public final void setGrayScale(Float f11) {
        this.grayScale = f11;
    }

    public String toString() {
        return "WarmUpEntranceConfigBean(enableWarmUp=" + this.enableWarmUp + ", configToken=" + this.configToken + ", grayScale=" + this.grayScale + ')';
    }
}
