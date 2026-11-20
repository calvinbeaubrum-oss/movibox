package com.transsion.lib.diffupdate.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class UpdateException extends Exception {
    private final int errorCode;
    private final String errorSimpleInfo;

    public UpdateException() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateException(int i11, String errorSimpleInfo, Throwable th2) {
        super(th2);
        Intrinsics.g(errorSimpleInfo, "errorSimpleInfo");
        this.errorCode = i11;
        this.errorSimpleInfo = errorSimpleInfo;
    }

    public /* synthetic */ UpdateException(int i11, String str, Throwable th2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, (i12 & 2) != 0 ? "" : str, (i12 & 4) != 0 ? null : th2);
    }

    public final String getErrorSimpleInfo() {
        return this.errorSimpleInfo;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("message:");
        sb2.append(getMessage());
        sb2.append(", errorCode:");
        sb2.append(this.errorCode);
        sb2.append(", errorSimpleInfo:");
        sb2.append(this.errorSimpleInfo);
        sb2.append(", cause: ");
        Throwable cause = getCause();
        sb2.append(cause != null ? cause.getMessage() : null);
        return sb2.toString();
    }
}
