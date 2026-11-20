package com.cloud.tmc.integration.model;

import java.io.Serializable;
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
public final class UniqueIdBean extends b implements Serializable {
    private final String uniqueId;

    public UniqueIdBean(String uniqueId) {
        Intrinsics.g(uniqueId, "uniqueId");
        this.uniqueId = uniqueId;
    }

    public static /* synthetic */ UniqueIdBean copy$default(UniqueIdBean uniqueIdBean, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = uniqueIdBean.uniqueId;
        }
        return uniqueIdBean.copy(str);
    }

    public final String component1() {
        return this.uniqueId;
    }

    public final UniqueIdBean copy(String uniqueId) {
        Intrinsics.g(uniqueId, "uniqueId");
        return new UniqueIdBean(uniqueId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UniqueIdBean) && Intrinsics.b(this.uniqueId, ((UniqueIdBean) obj).uniqueId);
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public int hashCode() {
        return this.uniqueId.hashCode();
    }

    public String toString() {
        return "UniqueIdBean(uniqueId=" + this.uniqueId + ')';
    }
}
