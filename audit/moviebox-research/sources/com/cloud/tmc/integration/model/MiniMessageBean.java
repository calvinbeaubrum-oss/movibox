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
public final class MiniMessageBean extends b {
    private final MiniMsgAppInfoBean miniAppInfo;

    public MiniMessageBean(MiniMsgAppInfoBean miniMsgAppInfoBean) {
        this.miniAppInfo = miniMsgAppInfoBean;
    }

    public static /* synthetic */ MiniMessageBean copy$default(MiniMessageBean miniMessageBean, MiniMsgAppInfoBean miniMsgAppInfoBean, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            miniMsgAppInfoBean = miniMessageBean.miniAppInfo;
        }
        return miniMessageBean.copy(miniMsgAppInfoBean);
    }

    public final MiniMsgAppInfoBean component1() {
        return this.miniAppInfo;
    }

    public final MiniMessageBean copy(MiniMsgAppInfoBean miniMsgAppInfoBean) {
        return new MiniMessageBean(miniMsgAppInfoBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MiniMessageBean) && Intrinsics.b(this.miniAppInfo, ((MiniMessageBean) obj).miniAppInfo);
    }

    public final MiniMsgAppInfoBean getMiniAppInfo() {
        return this.miniAppInfo;
    }

    public int hashCode() {
        MiniMsgAppInfoBean miniMsgAppInfoBean = this.miniAppInfo;
        if (miniMsgAppInfoBean == null) {
            return 0;
        }
        return miniMsgAppInfoBean.hashCode();
    }

    public String toString() {
        return "MiniMessageBean(miniAppInfo=" + this.miniAppInfo + ')';
    }
}
