package com.transsion.shorttv.utils;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class c {
    public static final String a(int i11) {
        Object objValueOf;
        Object objValueOf2;
        int i12 = i11 / 1000;
        int i13 = i12 % 60;
        int i14 = (i12 / 60) % 60;
        int i15 = i12 / 3600;
        if (i15 <= 0) {
            Object objValueOf3 = i14 > 0 ? Integer.valueOf(i14) : "0";
            if (i13 < 10) {
                objValueOf = "0" + i13;
            } else {
                objValueOf = Integer.valueOf(i13);
            }
            return objValueOf3 + ":" + objValueOf;
        }
        if (i13 < 10) {
            objValueOf2 = "0" + i13;
        } else {
            objValueOf2 = Integer.valueOf(i13);
        }
        return i15 + ":" + i14 + ":" + objValueOf2;
    }
}
