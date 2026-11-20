package com.transsion.baselib.utils;

import java.text.DecimalFormat;
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
public final class h {
    public static final String a(int i11) {
        return "E" + new DecimalFormat("00").format(Integer.valueOf(i11));
    }

    public static final String b(int i11, int i12, Integer num) {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        boolean z11 = (num != null && num.intValue() == 2) || (num != null && num.intValue() == 3) || (num != null && num.intValue() == 6);
        if (num != null && num.intValue() == 5) {
            return "Lesson " + i11;
        }
        if (i12 <= 0) {
            return (z11 ? "E" : "Ch") + decimalFormat.format(Integer.valueOf(i11));
        }
        return "S" + decimalFormat.format(Integer.valueOf(i12)) + (z11 ? " E" : " Ch") + decimalFormat.format(Integer.valueOf(i11));
    }

    public static final String c(int i11, boolean z11) {
        return (z11 ? " E" : " Ch") + new DecimalFormat("00").format(Integer.valueOf(i11));
    }

    public static final String d(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return " · " + str;
    }
}
