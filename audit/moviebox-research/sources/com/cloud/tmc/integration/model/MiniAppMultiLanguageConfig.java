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
public final class MiniAppMultiLanguageConfig extends b {

    /* JADX INFO: renamed from: ar, reason: collision with root package name */
    private final MiniAppMultiLanguageModel f30821ar;

    /* JADX INFO: renamed from: en, reason: collision with root package name */
    private final MiniAppMultiLanguageModel f30822en;

    /* JADX INFO: renamed from: fr, reason: collision with root package name */
    private final MiniAppMultiLanguageModel f30823fr;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final MiniAppMultiLanguageModel f30824id;

    /* JADX INFO: renamed from: ru, reason: collision with root package name */
    private final MiniAppMultiLanguageModel f30825ru;

    /* JADX INFO: renamed from: zh, reason: collision with root package name */
    private final MiniAppMultiLanguageModel f30826zh;

    public MiniAppMultiLanguageConfig(MiniAppMultiLanguageModel miniAppMultiLanguageModel, MiniAppMultiLanguageModel miniAppMultiLanguageModel2, MiniAppMultiLanguageModel miniAppMultiLanguageModel3, MiniAppMultiLanguageModel miniAppMultiLanguageModel4, MiniAppMultiLanguageModel miniAppMultiLanguageModel5, MiniAppMultiLanguageModel miniAppMultiLanguageModel6) {
        this.f30822en = miniAppMultiLanguageModel;
        this.f30826zh = miniAppMultiLanguageModel2;
        this.f30821ar = miniAppMultiLanguageModel3;
        this.f30823fr = miniAppMultiLanguageModel4;
        this.f30825ru = miniAppMultiLanguageModel5;
        this.f30824id = miniAppMultiLanguageModel6;
    }

    public static /* synthetic */ MiniAppMultiLanguageConfig copy$default(MiniAppMultiLanguageConfig miniAppMultiLanguageConfig, MiniAppMultiLanguageModel miniAppMultiLanguageModel, MiniAppMultiLanguageModel miniAppMultiLanguageModel2, MiniAppMultiLanguageModel miniAppMultiLanguageModel3, MiniAppMultiLanguageModel miniAppMultiLanguageModel4, MiniAppMultiLanguageModel miniAppMultiLanguageModel5, MiniAppMultiLanguageModel miniAppMultiLanguageModel6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            miniAppMultiLanguageModel = miniAppMultiLanguageConfig.f30822en;
        }
        if ((i11 & 2) != 0) {
            miniAppMultiLanguageModel2 = miniAppMultiLanguageConfig.f30826zh;
        }
        MiniAppMultiLanguageModel miniAppMultiLanguageModel7 = miniAppMultiLanguageModel2;
        if ((i11 & 4) != 0) {
            miniAppMultiLanguageModel3 = miniAppMultiLanguageConfig.f30821ar;
        }
        MiniAppMultiLanguageModel miniAppMultiLanguageModel8 = miniAppMultiLanguageModel3;
        if ((i11 & 8) != 0) {
            miniAppMultiLanguageModel4 = miniAppMultiLanguageConfig.f30823fr;
        }
        MiniAppMultiLanguageModel miniAppMultiLanguageModel9 = miniAppMultiLanguageModel4;
        if ((i11 & 16) != 0) {
            miniAppMultiLanguageModel5 = miniAppMultiLanguageConfig.f30825ru;
        }
        MiniAppMultiLanguageModel miniAppMultiLanguageModel10 = miniAppMultiLanguageModel5;
        if ((i11 & 32) != 0) {
            miniAppMultiLanguageModel6 = miniAppMultiLanguageConfig.f30824id;
        }
        return miniAppMultiLanguageConfig.copy(miniAppMultiLanguageModel, miniAppMultiLanguageModel7, miniAppMultiLanguageModel8, miniAppMultiLanguageModel9, miniAppMultiLanguageModel10, miniAppMultiLanguageModel6);
    }

    public final MiniAppMultiLanguageModel component1() {
        return this.f30822en;
    }

    public final MiniAppMultiLanguageModel component2() {
        return this.f30826zh;
    }

    public final MiniAppMultiLanguageModel component3() {
        return this.f30821ar;
    }

    public final MiniAppMultiLanguageModel component4() {
        return this.f30823fr;
    }

    public final MiniAppMultiLanguageModel component5() {
        return this.f30825ru;
    }

    public final MiniAppMultiLanguageModel component6() {
        return this.f30824id;
    }

    public final MiniAppMultiLanguageConfig copy(MiniAppMultiLanguageModel miniAppMultiLanguageModel, MiniAppMultiLanguageModel miniAppMultiLanguageModel2, MiniAppMultiLanguageModel miniAppMultiLanguageModel3, MiniAppMultiLanguageModel miniAppMultiLanguageModel4, MiniAppMultiLanguageModel miniAppMultiLanguageModel5, MiniAppMultiLanguageModel miniAppMultiLanguageModel6) {
        return new MiniAppMultiLanguageConfig(miniAppMultiLanguageModel, miniAppMultiLanguageModel2, miniAppMultiLanguageModel3, miniAppMultiLanguageModel4, miniAppMultiLanguageModel5, miniAppMultiLanguageModel6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniAppMultiLanguageConfig)) {
            return false;
        }
        MiniAppMultiLanguageConfig miniAppMultiLanguageConfig = (MiniAppMultiLanguageConfig) obj;
        return Intrinsics.b(this.f30822en, miniAppMultiLanguageConfig.f30822en) && Intrinsics.b(this.f30826zh, miniAppMultiLanguageConfig.f30826zh) && Intrinsics.b(this.f30821ar, miniAppMultiLanguageConfig.f30821ar) && Intrinsics.b(this.f30823fr, miniAppMultiLanguageConfig.f30823fr) && Intrinsics.b(this.f30825ru, miniAppMultiLanguageConfig.f30825ru) && Intrinsics.b(this.f30824id, miniAppMultiLanguageConfig.f30824id);
    }

    public final MiniAppMultiLanguageModel getAr() {
        return this.f30821ar;
    }

    public final MiniAppMultiLanguageModel getEn() {
        return this.f30822en;
    }

    public final MiniAppMultiLanguageModel getFr() {
        return this.f30823fr;
    }

    public final MiniAppMultiLanguageModel getId() {
        return this.f30824id;
    }

    public final MiniAppMultiLanguageModel getRu() {
        return this.f30825ru;
    }

    public final MiniAppMultiLanguageModel getZh() {
        return this.f30826zh;
    }

    public int hashCode() {
        MiniAppMultiLanguageModel miniAppMultiLanguageModel = this.f30822en;
        int iHashCode = (miniAppMultiLanguageModel == null ? 0 : miniAppMultiLanguageModel.hashCode()) * 31;
        MiniAppMultiLanguageModel miniAppMultiLanguageModel2 = this.f30826zh;
        int iHashCode2 = (iHashCode + (miniAppMultiLanguageModel2 == null ? 0 : miniAppMultiLanguageModel2.hashCode())) * 31;
        MiniAppMultiLanguageModel miniAppMultiLanguageModel3 = this.f30821ar;
        int iHashCode3 = (iHashCode2 + (miniAppMultiLanguageModel3 == null ? 0 : miniAppMultiLanguageModel3.hashCode())) * 31;
        MiniAppMultiLanguageModel miniAppMultiLanguageModel4 = this.f30823fr;
        int iHashCode4 = (iHashCode3 + (miniAppMultiLanguageModel4 == null ? 0 : miniAppMultiLanguageModel4.hashCode())) * 31;
        MiniAppMultiLanguageModel miniAppMultiLanguageModel5 = this.f30825ru;
        int iHashCode5 = (iHashCode4 + (miniAppMultiLanguageModel5 == null ? 0 : miniAppMultiLanguageModel5.hashCode())) * 31;
        MiniAppMultiLanguageModel miniAppMultiLanguageModel6 = this.f30824id;
        return iHashCode5 + (miniAppMultiLanguageModel6 != null ? miniAppMultiLanguageModel6.hashCode() : 0);
    }

    public String toString() {
        return "MiniAppMultiLanguageConfig(en=" + this.f30822en + ", zh=" + this.f30826zh + ", ar=" + this.f30821ar + ", fr=" + this.f30823fr + ", ru=" + this.f30825ru + ", id=" + this.f30824id + ')';
    }
}
