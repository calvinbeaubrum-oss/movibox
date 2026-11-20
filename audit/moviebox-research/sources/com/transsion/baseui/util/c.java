package com.transsion.baseui.util;

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
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f51453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f51454c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f51452a = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f51455d = 8;

    public final boolean a(int i11, long j11) {
        if (f51454c != i11) {
            f51454c = i11;
            f51453b = System.currentTimeMillis();
            return false;
        }
        if (System.currentTimeMillis() - f51453b <= j11) {
            return true;
        }
        f51454c = i11;
        f51453b = System.currentTimeMillis();
        return false;
    }
}
