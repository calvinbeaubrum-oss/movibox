package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
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
public final class ZeroConfig implements Serializable {
    private boolean enable;
    private String urlPath;

    public ZeroConfig(boolean z11, String str) {
        this.enable = z11;
        this.urlPath = str;
    }

    public /* synthetic */ ZeroConfig(boolean z11, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, str);
    }

    public static /* synthetic */ ZeroConfig copy$default(ZeroConfig zeroConfig, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = zeroConfig.enable;
        }
        if ((i11 & 2) != 0) {
            str = zeroConfig.urlPath;
        }
        return zeroConfig.copy(z11, str);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final String component2() {
        return this.urlPath;
    }

    public final ZeroConfig copy(boolean z11, String str) {
        return new ZeroConfig(z11, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZeroConfig)) {
            return false;
        }
        ZeroConfig zeroConfig = (ZeroConfig) obj;
        return this.enable == zeroConfig.enable && Intrinsics.b(this.urlPath, zeroConfig.urlPath);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getUrlPath() {
        return this.urlPath;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z11 = this.enable;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        String str = this.urlPath;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    public final void setEnable(boolean z11) {
        this.enable = z11;
    }

    public final void setUrlPath(String str) {
        this.urlPath = str;
    }

    public String toString() {
        return "ZeroConfig(enable=" + this.enable + ", urlPath=" + this.urlPath + ")";
    }
}
