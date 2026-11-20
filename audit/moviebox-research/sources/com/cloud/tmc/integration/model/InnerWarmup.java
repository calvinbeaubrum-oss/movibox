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
public final class InnerWarmup extends b {
    private boolean innerWarmUpRenderEnable;
    private boolean innerWarmUpWorkerEnable;
    private int renderMaxWarmupSize;
    private int workerMaxWarmupSize;

    public InnerWarmup(boolean z11, boolean z12, int i11, int i12) {
        this.innerWarmUpRenderEnable = z11;
        this.innerWarmUpWorkerEnable = z12;
        this.renderMaxWarmupSize = i11;
        this.workerMaxWarmupSize = i12;
    }

    public static /* synthetic */ InnerWarmup copy$default(InnerWarmup innerWarmup, boolean z11, boolean z12, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            z11 = innerWarmup.innerWarmUpRenderEnable;
        }
        if ((i13 & 2) != 0) {
            z12 = innerWarmup.innerWarmUpWorkerEnable;
        }
        if ((i13 & 4) != 0) {
            i11 = innerWarmup.renderMaxWarmupSize;
        }
        if ((i13 & 8) != 0) {
            i12 = innerWarmup.workerMaxWarmupSize;
        }
        return innerWarmup.copy(z11, z12, i11, i12);
    }

    public final boolean component1() {
        return this.innerWarmUpRenderEnable;
    }

    public final boolean component2() {
        return this.innerWarmUpWorkerEnable;
    }

    public final int component3() {
        return this.renderMaxWarmupSize;
    }

    public final int component4() {
        return this.workerMaxWarmupSize;
    }

    public final InnerWarmup copy(boolean z11, boolean z12, int i11, int i12) {
        return new InnerWarmup(z11, z12, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InnerWarmup)) {
            return false;
        }
        InnerWarmup innerWarmup = (InnerWarmup) obj;
        return this.innerWarmUpRenderEnable == innerWarmup.innerWarmUpRenderEnable && this.innerWarmUpWorkerEnable == innerWarmup.innerWarmUpWorkerEnable && this.renderMaxWarmupSize == innerWarmup.renderMaxWarmupSize && this.workerMaxWarmupSize == innerWarmup.workerMaxWarmupSize;
    }

    public final boolean getInnerWarmUpRenderEnable() {
        return this.innerWarmUpRenderEnable;
    }

    public final boolean getInnerWarmUpWorkerEnable() {
        return this.innerWarmUpWorkerEnable;
    }

    public final int getRenderMaxWarmupSize() {
        return this.renderMaxWarmupSize;
    }

    public final int getWorkerMaxWarmupSize() {
        return this.workerMaxWarmupSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        boolean z11 = this.innerWarmUpRenderEnable;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        boolean z12 = this.innerWarmUpWorkerEnable;
        return ((((i11 + (z12 ? 1 : z12)) * 31) + this.renderMaxWarmupSize) * 31) + this.workerMaxWarmupSize;
    }

    public final void setInnerWarmUpRenderEnable(boolean z11) {
        this.innerWarmUpRenderEnable = z11;
    }

    public final void setInnerWarmUpWorkerEnable(boolean z11) {
        this.innerWarmUpWorkerEnable = z11;
    }

    public final void setRenderMaxWarmupSize(int i11) {
        this.renderMaxWarmupSize = i11;
    }

    public final void setWorkerMaxWarmupSize(int i11) {
        this.workerMaxWarmupSize = i11;
    }

    public String toString() {
        return "InnerWarmup(innerWarmUpRenderEnable=" + this.innerWarmUpRenderEnable + ", innerWarmUpWorkerEnable=" + this.innerWarmUpWorkerEnable + ", renderMaxWarmupSize=" + this.renderMaxWarmupSize + ", workerMaxWarmupSize=" + this.workerMaxWarmupSize + ')';
    }
}
