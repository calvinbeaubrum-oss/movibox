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
public final class MiniAddHomeModel extends b {
    private final String location;
    private boolean showSuccessToast;
    private final int sourceType;

    public MiniAddHomeModel(String location, int i11, boolean z11) {
        Intrinsics.g(location, "location");
        this.location = location;
        this.sourceType = i11;
        this.showSuccessToast = z11;
    }

    public static /* synthetic */ MiniAddHomeModel copy$default(MiniAddHomeModel miniAddHomeModel, String str, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = miniAddHomeModel.location;
        }
        if ((i12 & 2) != 0) {
            i11 = miniAddHomeModel.sourceType;
        }
        if ((i12 & 4) != 0) {
            z11 = miniAddHomeModel.showSuccessToast;
        }
        return miniAddHomeModel.copy(str, i11, z11);
    }

    public final String component1() {
        return this.location;
    }

    public final int component2() {
        return this.sourceType;
    }

    public final boolean component3() {
        return this.showSuccessToast;
    }

    public final MiniAddHomeModel copy(String location, int i11, boolean z11) {
        Intrinsics.g(location, "location");
        return new MiniAddHomeModel(location, i11, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniAddHomeModel)) {
            return false;
        }
        MiniAddHomeModel miniAddHomeModel = (MiniAddHomeModel) obj;
        return Intrinsics.b(this.location, miniAddHomeModel.location) && this.sourceType == miniAddHomeModel.sourceType && this.showSuccessToast == miniAddHomeModel.showSuccessToast;
    }

    public final String getLocation() {
        return this.location;
    }

    public final boolean getShowSuccessToast() {
        return this.showSuccessToast;
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        int iHashCode = ((this.location.hashCode() * 31) + this.sourceType) * 31;
        boolean z11 = this.showSuccessToast;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode + r11;
    }

    public final void setShowSuccessToast(boolean z11) {
        this.showSuccessToast = z11;
    }

    public String toString() {
        return "MiniAddHomeModel(location=" + this.location + ", sourceType=" + this.sourceType + ", showSuccessToast=" + this.showSuccessToast + ')';
    }
}
