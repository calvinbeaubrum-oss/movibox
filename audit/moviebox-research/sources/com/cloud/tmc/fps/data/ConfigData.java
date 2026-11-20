package com.cloud.tmc.fps.data;

import kotlin.Metadata;
import l.p;
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
public final class ConfigData extends b {
    private float grayScale;
    private long jankThreshold;
    private long traceInterval;

    public ConfigData(float f11, long j11, long j12) {
        this.grayScale = f11;
        this.jankThreshold = j11;
        this.traceInterval = j12;
    }

    public static /* synthetic */ ConfigData copy$default(ConfigData configData, float f11, long j11, long j12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = configData.grayScale;
        }
        if ((i11 & 2) != 0) {
            j11 = configData.jankThreshold;
        }
        long j13 = j11;
        if ((i11 & 4) != 0) {
            j12 = configData.traceInterval;
        }
        return configData.copy(f11, j13, j12);
    }

    public final float component1() {
        return this.grayScale;
    }

    public final long component2() {
        return this.jankThreshold;
    }

    public final long component3() {
        return this.traceInterval;
    }

    public final ConfigData copy(float f11, long j11, long j12) {
        return new ConfigData(f11, j11, j12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigData)) {
            return false;
        }
        ConfigData configData = (ConfigData) obj;
        return Float.compare(this.grayScale, configData.grayScale) == 0 && this.jankThreshold == configData.jankThreshold && this.traceInterval == configData.traceInterval;
    }

    public final float getGrayScale() {
        return this.grayScale;
    }

    public final long getJankThreshold() {
        return this.jankThreshold;
    }

    public final long getTraceInterval() {
        return this.traceInterval;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.grayScale) * 31) + p.a(this.jankThreshold)) * 31) + p.a(this.traceInterval);
    }

    public final void setGrayScale(float f11) {
        this.grayScale = f11;
    }

    public final void setJankThreshold(long j11) {
        this.jankThreshold = j11;
    }

    public final void setTraceInterval(long j11) {
        this.traceInterval = j11;
    }

    public String toString() {
        return "ConfigData(grayScale=" + this.grayScale + ", jankThreshold=" + this.jankThreshold + ", traceInterval=" + this.traceInterval + ')';
    }
}
