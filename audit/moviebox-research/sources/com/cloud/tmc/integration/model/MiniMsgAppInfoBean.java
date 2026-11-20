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
public final class MiniMsgAppInfoBean extends b {
    private final String miniappId;
    private final String miniappName;

    public MiniMsgAppInfoBean(String str, String str2) {
        this.miniappId = str;
        this.miniappName = str2;
    }

    public static /* synthetic */ MiniMsgAppInfoBean copy$default(MiniMsgAppInfoBean miniMsgAppInfoBean, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = miniMsgAppInfoBean.miniappId;
        }
        if ((i11 & 2) != 0) {
            str2 = miniMsgAppInfoBean.miniappName;
        }
        return miniMsgAppInfoBean.copy(str, str2);
    }

    public final String component1() {
        return this.miniappId;
    }

    public final String component2() {
        return this.miniappName;
    }

    public final MiniMsgAppInfoBean copy(String str, String str2) {
        return new MiniMsgAppInfoBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniMsgAppInfoBean)) {
            return false;
        }
        MiniMsgAppInfoBean miniMsgAppInfoBean = (MiniMsgAppInfoBean) obj;
        return Intrinsics.b(this.miniappId, miniMsgAppInfoBean.miniappId) && Intrinsics.b(this.miniappName, miniMsgAppInfoBean.miniappName);
    }

    public final String getMiniappId() {
        return this.miniappId;
    }

    public final String getMiniappName() {
        return this.miniappName;
    }

    public int hashCode() {
        String str = this.miniappId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.miniappName;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "MiniMsgAppInfoBean(miniappId=" + this.miniappId + ", miniappName=" + this.miniappName + ')';
    }
}
