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
public final class SharpNewsPreRequestModel extends b {
    private String contentUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f30828id;

    public SharpNewsPreRequestModel(String str, String contentUrl) {
        Intrinsics.g(contentUrl, "contentUrl");
        this.f30828id = str;
        this.contentUrl = contentUrl;
    }

    public static /* synthetic */ SharpNewsPreRequestModel copy$default(SharpNewsPreRequestModel sharpNewsPreRequestModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sharpNewsPreRequestModel.f30828id;
        }
        if ((i11 & 2) != 0) {
            str2 = sharpNewsPreRequestModel.contentUrl;
        }
        return sharpNewsPreRequestModel.copy(str, str2);
    }

    public final String component1() {
        return this.f30828id;
    }

    public final String component2() {
        return this.contentUrl;
    }

    public final SharpNewsPreRequestModel copy(String str, String contentUrl) {
        Intrinsics.g(contentUrl, "contentUrl");
        return new SharpNewsPreRequestModel(str, contentUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SharpNewsPreRequestModel)) {
            return false;
        }
        SharpNewsPreRequestModel sharpNewsPreRequestModel = (SharpNewsPreRequestModel) obj;
        return Intrinsics.b(this.f30828id, sharpNewsPreRequestModel.f30828id) && Intrinsics.b(this.contentUrl, sharpNewsPreRequestModel.contentUrl);
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final String getId() {
        return this.f30828id;
    }

    public int hashCode() {
        String str = this.f30828id;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.contentUrl.hashCode();
    }

    public final void setContentUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.contentUrl = str;
    }

    public final void setId(String str) {
        this.f30828id = str;
    }

    public String toString() {
        return "SharpNewsPreRequestModel(id=" + this.f30828id + ", contentUrl=" + this.contentUrl + ')';
    }
}
