package com.cloud.tmc.integration.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class RequestConfigBean extends b {
    private boolean repairIntToFloat;

    public RequestConfigBean() {
        this(false, 1, null);
    }

    public RequestConfigBean(boolean z11) {
        this.repairIntToFloat = z11;
    }

    public /* synthetic */ RequestConfigBean(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11);
    }

    public static /* synthetic */ RequestConfigBean copy$default(RequestConfigBean requestConfigBean, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = requestConfigBean.repairIntToFloat;
        }
        return requestConfigBean.copy(z11);
    }

    public final boolean component1() {
        return this.repairIntToFloat;
    }

    public final RequestConfigBean copy(boolean z11) {
        return new RequestConfigBean(z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RequestConfigBean) && this.repairIntToFloat == ((RequestConfigBean) obj).repairIntToFloat;
    }

    public final boolean getRepairIntToFloat() {
        return this.repairIntToFloat;
    }

    public int hashCode() {
        boolean z11 = this.repairIntToFloat;
        if (z11) {
            return 1;
        }
        return z11 ? 1 : 0;
    }

    public final void setRepairIntToFloat(boolean z11) {
        this.repairIntToFloat = z11;
    }

    public String toString() {
        return "RequestConfigBean(repairIntToFloat=" + this.repairIntToFloat + ')';
    }
}
