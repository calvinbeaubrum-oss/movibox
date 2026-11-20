package com.transsion.baselib.utils;

import android.annotation.SuppressLint;
import android.os.StatFs;
import android.util.Log;
import java.io.File;
import kotlin.Metadata;
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
public final class n {
    @SuppressLint({"NewApi"})
    public static final long a(File file) {
        Intrinsics.g(file, "<this>");
        String absolutePath = file.getAbsolutePath();
        Intrinsics.f(absolutePath, "this.absolutePath");
        try {
            StatFs statFs = new StatFs(absolutePath);
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (IllegalArgumentException unused) {
            Log.e("qqqq", "hasEnoughSpace, sdcard may be unmounted:" + absolutePath);
            return 0L;
        } catch (Exception e11) {
            Log.e("qqqq", "hasEnoughSpace, Exception:" + e11.getMessage());
            return 0L;
        }
    }
}
