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
public final class MiniAppMultiLanguageModel extends b {
    private final String buttonText;
    private final String title;

    public MiniAppMultiLanguageModel(String str, String str2) {
        this.title = str;
        this.buttonText = str2;
    }

    public static /* synthetic */ MiniAppMultiLanguageModel copy$default(MiniAppMultiLanguageModel miniAppMultiLanguageModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = miniAppMultiLanguageModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = miniAppMultiLanguageModel.buttonText;
        }
        return miniAppMultiLanguageModel.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.buttonText;
    }

    public final MiniAppMultiLanguageModel copy(String str, String str2) {
        return new MiniAppMultiLanguageModel(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniAppMultiLanguageModel)) {
            return false;
        }
        MiniAppMultiLanguageModel miniAppMultiLanguageModel = (MiniAppMultiLanguageModel) obj;
        return Intrinsics.b(this.title, miniAppMultiLanguageModel.title) && Intrinsics.b(this.buttonText, miniAppMultiLanguageModel.buttonText);
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.buttonText;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "MiniAppMultiLanguageModel(title=" + this.title + ", buttonText=" + this.buttonText + ')';
    }
}
