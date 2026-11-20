package com.cloud.tmc.fps;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static float f30364b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30363a = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f30365c = 200;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f30366d = 50;

    public final float a() {
        return f30364b;
    }

    public final long b() {
        return f30365c;
    }

    public final long c() {
        return f30366d;
    }

    public final void d(float f11) {
        f30364b = f11;
    }

    public final void e(long j11) {
        f30365c = j11;
    }

    public final void f(long j11) {
        f30366d = j11;
    }
}
