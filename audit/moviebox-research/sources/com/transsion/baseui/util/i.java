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
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f51465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f51466c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f51464a = new i();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f51467d = 8;

    public final String a(long j11) {
        long jCurrentTimeMillis = (System.currentTimeMillis() - f51466c) / ((long) 1000);
        if (jCurrentTimeMillis <= 0) {
            jCurrentTimeMillis = 1;
        }
        f51466c = System.currentTimeMillis();
        long j12 = (j11 - f51465b) / jCurrentTimeMillis;
        f51465b = j11;
        if (j12 <= 0) {
            return "0KB/s";
        }
        return tp.a.a(j12, 1) + "/s";
    }
}
