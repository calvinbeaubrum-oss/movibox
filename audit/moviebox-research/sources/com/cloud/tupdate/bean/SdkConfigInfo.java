package com.cloud.tupdate.bean;

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
public final class SdkConfigInfo {
    private final String closeVersions;
    private final Boolean openSdkCache;

    /* JADX WARN: Multi-variable type inference failed */
    public SdkConfigInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public SdkConfigInfo(Boolean bool, String str) {
        this.openSdkCache = bool;
        this.closeVersions = str;
    }

    public /* synthetic */ SdkConfigInfo(Boolean bool, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : str);
    }

    public static /* synthetic */ SdkConfigInfo copy$default(SdkConfigInfo sdkConfigInfo, Boolean bool, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = sdkConfigInfo.openSdkCache;
        }
        if ((i11 & 2) != 0) {
            str = sdkConfigInfo.closeVersions;
        }
        return sdkConfigInfo.copy(bool, str);
    }

    public final Boolean component1() {
        return this.openSdkCache;
    }

    public final String component2() {
        return this.closeVersions;
    }

    public final SdkConfigInfo copy(Boolean bool, String str) {
        return new SdkConfigInfo(bool, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SdkConfigInfo)) {
            return false;
        }
        SdkConfigInfo sdkConfigInfo = (SdkConfigInfo) obj;
        return Intrinsics.b(this.openSdkCache, sdkConfigInfo.openSdkCache) && Intrinsics.b(this.closeVersions, sdkConfigInfo.closeVersions);
    }

    public final String getCloseVersions() {
        return this.closeVersions;
    }

    public final Boolean getOpenSdkCache() {
        return this.openSdkCache;
    }

    public int hashCode() {
        Boolean bool = this.openSdkCache;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.closeVersions;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SdkConfigInfo(openSdkCache=" + this.openSdkCache + ", closeVersions=" + ((Object) this.closeVersions) + ')';
    }
}
