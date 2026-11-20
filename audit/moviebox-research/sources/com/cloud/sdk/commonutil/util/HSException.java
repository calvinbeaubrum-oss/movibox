package com.cloud.sdk.commonutil.util;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class HSException extends Exception {
    public static final a Companion = new a(null);
    private static final long serialVersionUID = 1;
    private String description;
    private int errorCode;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HSException(int i11, String desc) {
        super(desc);
        Intrinsics.g(desc, "desc");
        this.errorCode = i11;
        this.description = desc;
    }

    public HSException(int i11, String str, Throwable th2) {
        super(str);
        this.description = "";
        this.errorCode = i11;
        super.initCause(th2);
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setDescription(String str) {
        Intrinsics.g(str, "<set-?>");
        this.description = str;
    }

    public final void setErrorCode(int i11) {
        this.errorCode = i11;
    }
}
