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
public final class LogEBean extends b {
    private float grayScale;

    public LogEBean() {
        this(0.0f, 1, null);
    }

    public LogEBean(float f11) {
        this.grayScale = f11;
    }

    public /* synthetic */ LogEBean(float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11);
    }

    public static /* synthetic */ LogEBean copy$default(LogEBean logEBean, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = logEBean.grayScale;
        }
        return logEBean.copy(f11);
    }

    public final float component1() {
        return this.grayScale;
    }

    public final LogEBean copy(float f11) {
        return new LogEBean(f11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LogEBean) && Float.compare(this.grayScale, ((LogEBean) obj).grayScale) == 0;
    }

    public final float getGrayScale() {
        return this.grayScale;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.grayScale);
    }

    public final void setGrayScale(float f11) {
        this.grayScale = f11;
    }

    public String toString() {
        return "LogEBean(grayScale=" + this.grayScale + ')';
    }
}
