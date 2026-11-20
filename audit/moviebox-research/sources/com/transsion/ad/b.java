package com.transsion.ad;

import com.blankj.utilcode.util.Utils;
import java.io.File;
import kotlin.Metadata;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f50277a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f50278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f50279c;

    static {
        File externalFilesDir = Utils.a().getExternalFilesDir("mb");
        String absolutePath = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
        char c11 = File.separatorChar;
        f50278b = absolutePath + c11 + "non_ad";
        File externalFilesDir2 = Utils.a().getExternalFilesDir("ps");
        f50279c = (externalFilesDir2 != null ? externalFilesDir2.getAbsolutePath() : null) + c11 + "non_ad";
    }

    public final String a() {
        return f50279c;
    }

    public final String b() {
        return f50278b;
    }
}
