package com.transsion.home.bean;

import java.io.Serializable;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RangeValue implements Serializable {
    public static final int $stable = 0;
    private final float maxVal;
    private final float minVal;

    public RangeValue(float f11, float f12) {
        this.minVal = f11;
        this.maxVal = f12;
    }

    public static /* synthetic */ RangeValue copy$default(RangeValue rangeValue, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = rangeValue.minVal;
        }
        if ((i11 & 2) != 0) {
            f12 = rangeValue.maxVal;
        }
        return rangeValue.copy(f11, f12);
    }

    public final float component1() {
        return this.minVal;
    }

    public final float component2() {
        return this.maxVal;
    }

    public final RangeValue copy(float f11, float f12) {
        return new RangeValue(f11, f12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RangeValue)) {
            return false;
        }
        RangeValue rangeValue = (RangeValue) obj;
        return Float.compare(this.minVal, rangeValue.minVal) == 0 && Float.compare(this.maxVal, rangeValue.maxVal) == 0;
    }

    public final float getMaxVal() {
        return this.maxVal;
    }

    public final float getMinVal() {
        return this.minVal;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.minVal) * 31) + Float.floatToIntBits(this.maxVal);
    }

    public String toString() {
        return "RangeValue(minVal=" + this.minVal + ", maxVal=" + this.maxVal + ")";
    }
}
