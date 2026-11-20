package com.cloud.tmc.fps.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class FpsData extends b {
    private final long frameCostMillis;
    private final long frameTimeMillis;

    public FpsData() {
        this(0L, 0L, 3, null);
    }

    public FpsData(long j11, long j12) {
        this.frameTimeMillis = j11;
        this.frameCostMillis = j12;
    }

    public /* synthetic */ FpsData(long j11, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0L : j11, (i11 & 2) != 0 ? 0L : j12);
    }

    public static /* synthetic */ FpsData copy$default(FpsData fpsData, long j11, long j12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = fpsData.frameTimeMillis;
        }
        if ((i11 & 2) != 0) {
            j12 = fpsData.frameCostMillis;
        }
        return fpsData.copy(j11, j12);
    }

    public final long component1() {
        return this.frameTimeMillis;
    }

    public final long component2() {
        return this.frameCostMillis;
    }

    public final FpsData copy(long j11, long j12) {
        return new FpsData(j11, j12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FpsData)) {
            return false;
        }
        FpsData fpsData = (FpsData) obj;
        return this.frameTimeMillis == fpsData.frameTimeMillis && this.frameCostMillis == fpsData.frameCostMillis;
    }

    public final long getFrameCostMillis() {
        return this.frameCostMillis;
    }

    public final long getFrameTimeMillis() {
        return this.frameTimeMillis;
    }

    public int hashCode() {
        return (p.a(this.frameTimeMillis) * 31) + p.a(this.frameCostMillis);
    }

    public String toString() {
        return "FpsData(frameTimeMillis=" + this.frameTimeMillis + ", frameCostMillis=" + this.frameCostMillis + ')';
    }
}
