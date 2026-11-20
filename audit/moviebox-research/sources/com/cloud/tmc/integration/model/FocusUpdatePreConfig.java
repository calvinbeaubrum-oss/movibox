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
public final class FocusUpdatePreConfig extends b {
    private final boolean enable;
    private final String version;

    public FocusUpdatePreConfig(boolean z11, String version) {
        Intrinsics.g(version, "version");
        this.enable = z11;
        this.version = version;
    }

    public static /* synthetic */ FocusUpdatePreConfig copy$default(FocusUpdatePreConfig focusUpdatePreConfig, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = focusUpdatePreConfig.enable;
        }
        if ((i11 & 2) != 0) {
            str = focusUpdatePreConfig.version;
        }
        return focusUpdatePreConfig.copy(z11, str);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final String component2() {
        return this.version;
    }

    public final FocusUpdatePreConfig copy(boolean z11, String version) {
        Intrinsics.g(version, "version");
        return new FocusUpdatePreConfig(z11, version);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FocusUpdatePreConfig)) {
            return false;
        }
        FocusUpdatePreConfig focusUpdatePreConfig = (FocusUpdatePreConfig) obj;
        return this.enable == focusUpdatePreConfig.enable && Intrinsics.b(this.version, focusUpdatePreConfig.version);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getVersion() {
        return this.version;
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
        return (r11 * 31) + this.version.hashCode();
    }

    public String toString() {
        return "FocusUpdatePreConfig(enable=" + this.enable + ", version=" + this.version + ')';
    }
}
