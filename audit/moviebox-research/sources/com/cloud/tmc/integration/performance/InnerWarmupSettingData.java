package com.cloud.tmc.integration.performance;

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
public final class InnerWarmupSettingData extends b {
    private final long renderWaitTime;
    private final long workerWaitTime;

    public InnerWarmupSettingData() {
        this(0L, 0L, 3, null);
    }

    public InnerWarmupSettingData(long j11, long j12) {
        this.renderWaitTime = j11;
        this.workerWaitTime = j12;
    }

    public /* synthetic */ InnerWarmupSettingData(long j11, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0L : j11, (i11 & 2) != 0 ? 0L : j12);
    }

    public static /* synthetic */ InnerWarmupSettingData copy$default(InnerWarmupSettingData innerWarmupSettingData, long j11, long j12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = innerWarmupSettingData.renderWaitTime;
        }
        if ((i11 & 2) != 0) {
            j12 = innerWarmupSettingData.workerWaitTime;
        }
        return innerWarmupSettingData.copy(j11, j12);
    }

    public final long component1() {
        return this.renderWaitTime;
    }

    public final long component2() {
        return this.workerWaitTime;
    }

    public final InnerWarmupSettingData copy(long j11, long j12) {
        return new InnerWarmupSettingData(j11, j12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InnerWarmupSettingData)) {
            return false;
        }
        InnerWarmupSettingData innerWarmupSettingData = (InnerWarmupSettingData) obj;
        return this.renderWaitTime == innerWarmupSettingData.renderWaitTime && this.workerWaitTime == innerWarmupSettingData.workerWaitTime;
    }

    public final long getRenderWaitTime() {
        return this.renderWaitTime;
    }

    public final long getWorkerWaitTime() {
        return this.workerWaitTime;
    }

    public int hashCode() {
        return (p.a(this.renderWaitTime) * 31) + p.a(this.workerWaitTime);
    }

    public String toString() {
        return "InnerWarmupSettingData(renderWaitTime=" + this.renderWaitTime + ", workerWaitTime=" + this.workerWaitTime + ')';
    }
}
