package com.cloud.tmc.integration.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class MiniAppAutoOperationConfig extends b {
    private final MiniAppAutoPopover bottomPopover;
    private final MiniAppAutoPopover exitReminder;
    private final MiniAppAutoPopover topPopover;

    public MiniAppAutoOperationConfig(MiniAppAutoPopover miniAppAutoPopover, MiniAppAutoPopover miniAppAutoPopover2, MiniAppAutoPopover miniAppAutoPopover3) {
        this.topPopover = miniAppAutoPopover;
        this.bottomPopover = miniAppAutoPopover2;
        this.exitReminder = miniAppAutoPopover3;
    }

    public static /* synthetic */ MiniAppAutoOperationConfig copy$default(MiniAppAutoOperationConfig miniAppAutoOperationConfig, MiniAppAutoPopover miniAppAutoPopover, MiniAppAutoPopover miniAppAutoPopover2, MiniAppAutoPopover miniAppAutoPopover3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            miniAppAutoPopover = miniAppAutoOperationConfig.topPopover;
        }
        if ((i11 & 2) != 0) {
            miniAppAutoPopover2 = miniAppAutoOperationConfig.bottomPopover;
        }
        if ((i11 & 4) != 0) {
            miniAppAutoPopover3 = miniAppAutoOperationConfig.exitReminder;
        }
        return miniAppAutoOperationConfig.copy(miniAppAutoPopover, miniAppAutoPopover2, miniAppAutoPopover3);
    }

    public final MiniAppAutoPopover component1() {
        return this.topPopover;
    }

    public final MiniAppAutoPopover component2() {
        return this.bottomPopover;
    }

    public final MiniAppAutoPopover component3() {
        return this.exitReminder;
    }

    public final MiniAppAutoOperationConfig copy(MiniAppAutoPopover miniAppAutoPopover, MiniAppAutoPopover miniAppAutoPopover2, MiniAppAutoPopover miniAppAutoPopover3) {
        return new MiniAppAutoOperationConfig(miniAppAutoPopover, miniAppAutoPopover2, miniAppAutoPopover3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniAppAutoOperationConfig)) {
            return false;
        }
        MiniAppAutoOperationConfig miniAppAutoOperationConfig = (MiniAppAutoOperationConfig) obj;
        return Intrinsics.b(this.topPopover, miniAppAutoOperationConfig.topPopover) && Intrinsics.b(this.bottomPopover, miniAppAutoOperationConfig.bottomPopover) && Intrinsics.b(this.exitReminder, miniAppAutoOperationConfig.exitReminder);
    }

    public final MiniAppAutoPopover getBottomPopover() {
        return this.bottomPopover;
    }

    public final MiniAppAutoPopover getExitReminder() {
        return this.exitReminder;
    }

    public final MiniAppAutoPopover getTopPopover() {
        return this.topPopover;
    }

    public int hashCode() {
        MiniAppAutoPopover miniAppAutoPopover = this.topPopover;
        int iHashCode = (miniAppAutoPopover == null ? 0 : miniAppAutoPopover.hashCode()) * 31;
        MiniAppAutoPopover miniAppAutoPopover2 = this.bottomPopover;
        int iHashCode2 = (iHashCode + (miniAppAutoPopover2 == null ? 0 : miniAppAutoPopover2.hashCode())) * 31;
        MiniAppAutoPopover miniAppAutoPopover3 = this.exitReminder;
        return iHashCode2 + (miniAppAutoPopover3 != null ? miniAppAutoPopover3.hashCode() : 0);
    }

    public String toString() {
        return "MiniAppAutoOperationConfig(topPopover=" + this.topPopover + ", bottomPopover=" + this.bottomPopover + ", exitReminder=" + this.exitReminder + ')';
    }
}
