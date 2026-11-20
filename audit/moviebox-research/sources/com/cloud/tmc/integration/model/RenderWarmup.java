package com.cloud.tmc.integration.model;

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
public final class RenderWarmup extends b {
    private int cacheSize;
    private boolean lazyLoad;
    private boolean open;

    public RenderWarmup(boolean z11, boolean z12, int i11) {
        this.open = z11;
        this.lazyLoad = z12;
        this.cacheSize = i11;
    }

    public static /* synthetic */ RenderWarmup copy$default(RenderWarmup renderWarmup, boolean z11, boolean z12, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z11 = renderWarmup.open;
        }
        if ((i12 & 2) != 0) {
            z12 = renderWarmup.lazyLoad;
        }
        if ((i12 & 4) != 0) {
            i11 = renderWarmup.cacheSize;
        }
        return renderWarmup.copy(z11, z12, i11);
    }

    public final boolean component1() {
        return this.open;
    }

    public final boolean component2() {
        return this.lazyLoad;
    }

    public final int component3() {
        return this.cacheSize;
    }

    public final RenderWarmup copy(boolean z11, boolean z12, int i11) {
        return new RenderWarmup(z11, z12, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RenderWarmup)) {
            return false;
        }
        RenderWarmup renderWarmup = (RenderWarmup) obj;
        return this.open == renderWarmup.open && this.lazyLoad == renderWarmup.lazyLoad && this.cacheSize == renderWarmup.cacheSize;
    }

    public final int getCacheSize() {
        return this.cacheSize;
    }

    public final boolean getLazyLoad() {
        return this.lazyLoad;
    }

    public final boolean getOpen() {
        return this.open;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        boolean z11 = this.open;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        boolean z12 = this.lazyLoad;
        return ((i11 + (z12 ? 1 : z12)) * 31) + this.cacheSize;
    }

    public final void setCacheSize(int i11) {
        this.cacheSize = i11;
    }

    public final void setLazyLoad(boolean z11) {
        this.lazyLoad = z11;
    }

    public final void setOpen(boolean z11) {
        this.open = z11;
    }

    public String toString() {
        return "RenderWarmup(open=" + this.open + ", lazyLoad=" + this.lazyLoad + ", cacheSize=" + this.cacheSize + ')';
    }
}
