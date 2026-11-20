package com.cloud.tmc.integration.net;

import kotlin.Metadata;
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
public final class RenderWarmupMode extends b {
    private final int cacheSize;
    private final boolean open;

    public RenderWarmupMode(boolean z11, int i11) {
        this.open = z11;
        this.cacheSize = i11;
    }

    public static /* synthetic */ RenderWarmupMode copy$default(RenderWarmupMode renderWarmupMode, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z11 = renderWarmupMode.open;
        }
        if ((i12 & 2) != 0) {
            i11 = renderWarmupMode.cacheSize;
        }
        return renderWarmupMode.copy(z11, i11);
    }

    public final boolean component1() {
        return this.open;
    }

    public final int component2() {
        return this.cacheSize;
    }

    public final RenderWarmupMode copy(boolean z11, int i11) {
        return new RenderWarmupMode(z11, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RenderWarmupMode)) {
            return false;
        }
        RenderWarmupMode renderWarmupMode = (RenderWarmupMode) obj;
        return this.open == renderWarmupMode.open && this.cacheSize == renderWarmupMode.cacheSize;
    }

    public final int getCacheSize() {
        return this.cacheSize;
    }

    public final boolean getOpen() {
        return this.open;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z11 = this.open;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (r11 * 31) + this.cacheSize;
    }

    public String toString() {
        return "RenderWarmupMode(open=" + this.open + ", cacheSize=" + this.cacheSize + ')';
    }
}
