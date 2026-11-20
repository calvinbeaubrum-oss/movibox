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
public final class InnerWebviewWarmup extends b {
    private boolean innerWarmUpWebviewEnable;
    private int webviewMaxWarmupSize;

    public InnerWebviewWarmup(boolean z11, int i11) {
        this.innerWarmUpWebviewEnable = z11;
        this.webviewMaxWarmupSize = i11;
    }

    public static /* synthetic */ InnerWebviewWarmup copy$default(InnerWebviewWarmup innerWebviewWarmup, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z11 = innerWebviewWarmup.innerWarmUpWebviewEnable;
        }
        if ((i12 & 2) != 0) {
            i11 = innerWebviewWarmup.webviewMaxWarmupSize;
        }
        return innerWebviewWarmup.copy(z11, i11);
    }

    public final boolean component1() {
        return this.innerWarmUpWebviewEnable;
    }

    public final int component2() {
        return this.webviewMaxWarmupSize;
    }

    public final InnerWebviewWarmup copy(boolean z11, int i11) {
        return new InnerWebviewWarmup(z11, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InnerWebviewWarmup)) {
            return false;
        }
        InnerWebviewWarmup innerWebviewWarmup = (InnerWebviewWarmup) obj;
        return this.innerWarmUpWebviewEnable == innerWebviewWarmup.innerWarmUpWebviewEnable && this.webviewMaxWarmupSize == innerWebviewWarmup.webviewMaxWarmupSize;
    }

    public final boolean getInnerWarmUpWebviewEnable() {
        return this.innerWarmUpWebviewEnable;
    }

    public final int getWebviewMaxWarmupSize() {
        return this.webviewMaxWarmupSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z11 = this.innerWarmUpWebviewEnable;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (r11 * 31) + this.webviewMaxWarmupSize;
    }

    public final void setInnerWarmUpWebviewEnable(boolean z11) {
        this.innerWarmUpWebviewEnable = z11;
    }

    public final void setWebviewMaxWarmupSize(int i11) {
        this.webviewMaxWarmupSize = i11;
    }

    public String toString() {
        return "InnerWebviewWarmup(innerWarmUpWebviewEnable=" + this.innerWarmUpWebviewEnable + ", webviewMaxWarmupSize=" + this.webviewMaxWarmupSize + ')';
    }
}
