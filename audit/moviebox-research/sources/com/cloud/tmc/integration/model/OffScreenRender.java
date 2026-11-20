package com.cloud.tmc.integration.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class OffScreenRender extends b {
    private boolean enable;
    private float grayScale;
    private int maxSize;

    public OffScreenRender(boolean z11, int i11, float f11) {
        this.enable = z11;
        this.maxSize = i11;
        this.grayScale = f11;
    }

    public /* synthetic */ OffScreenRender(boolean z11, int i11, float f11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, i11, (i12 & 4) != 0 ? 0.0f : f11);
    }

    public static /* synthetic */ OffScreenRender copy$default(OffScreenRender offScreenRender, boolean z11, int i11, float f11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z11 = offScreenRender.enable;
        }
        if ((i12 & 2) != 0) {
            i11 = offScreenRender.maxSize;
        }
        if ((i12 & 4) != 0) {
            f11 = offScreenRender.grayScale;
        }
        return offScreenRender.copy(z11, i11, f11);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final int component2() {
        return this.maxSize;
    }

    public final float component3() {
        return this.grayScale;
    }

    public final OffScreenRender copy(boolean z11, int i11, float f11) {
        return new OffScreenRender(z11, i11, f11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffScreenRender)) {
            return false;
        }
        OffScreenRender offScreenRender = (OffScreenRender) obj;
        return this.enable == offScreenRender.enable && this.maxSize == offScreenRender.maxSize && Float.compare(this.grayScale, offScreenRender.grayScale) == 0;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final float getGrayScale() {
        return this.grayScale;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z11 = this.enable;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (((r11 * 31) + this.maxSize) * 31) + Float.floatToIntBits(this.grayScale);
    }

    public final void setEnable(boolean z11) {
        this.enable = z11;
    }

    public final void setGrayScale(float f11) {
        this.grayScale = f11;
    }

    public final void setMaxSize(int i11) {
        this.maxSize = i11;
    }

    public String toString() {
        return "OffScreenRender(enable=" + this.enable + ", maxSize=" + this.maxSize + ", grayScale=" + this.grayScale + ')';
    }
}
