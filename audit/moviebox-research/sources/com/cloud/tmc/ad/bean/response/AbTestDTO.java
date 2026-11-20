package com.cloud.tmc.ad.bean.response;

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
public final class AbTestDTO extends b {
    private final Integer expId;
    private final Integer layerId;
    private final Integer varId;

    public final int getExpId() {
        Integer num = this.expId;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final int getLayerId() {
        Integer num = this.layerId;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final int getVarId() {
        Integer num = this.varId;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public String toString() {
        return "AbTestDTO{varId=" + this.varId + ", expId=" + this.expId + ", layerId=" + this.layerId + '}';
    }
}
