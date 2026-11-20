package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class BlockInfo implements Serializable {
    private boolean block;
    private boolean blocked;

    public BlockInfo(boolean z11, boolean z12) {
        this.block = z11;
        this.blocked = z12;
    }

    public static /* synthetic */ BlockInfo copy$default(BlockInfo blockInfo, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = blockInfo.block;
        }
        if ((i11 & 2) != 0) {
            z12 = blockInfo.blocked;
        }
        return blockInfo.copy(z11, z12);
    }

    public final boolean component1() {
        return this.block;
    }

    public final boolean component2() {
        return this.blocked;
    }

    public final BlockInfo copy(boolean z11, boolean z12) {
        return new BlockInfo(z11, z12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockInfo)) {
            return false;
        }
        BlockInfo blockInfo = (BlockInfo) obj;
        return this.block == blockInfo.block && this.blocked == blockInfo.blocked;
    }

    public final boolean getBlock() {
        return this.block;
    }

    public final boolean getBlocked() {
        return this.blocked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z11 = this.block;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        boolean z12 = this.blocked;
        return i11 + (z12 ? 1 : z12);
    }

    public final void setBlock(boolean z11) {
        this.block = z11;
    }

    public final void setBlocked(boolean z11) {
        this.blocked = z11;
    }

    public String toString() {
        return "BlockInfo(block=" + this.block + ", blocked=" + this.blocked + ")";
    }
}
