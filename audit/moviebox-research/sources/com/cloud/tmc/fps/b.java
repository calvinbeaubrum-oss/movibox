package com.cloud.tmc.fps;

import com.cloud.tmc.fps.data.ConfigData;
import java.security.SecureRandom;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f30367a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f30368b;

    public final void a() {
        if (f30368b) {
            return;
        }
        f30368b = true;
        ra.b bVar = ra.b.f75170a;
        bVar.d(new ReportManager());
        bVar.e(true);
    }

    public final void b(ConfigData config) {
        Intrinsics.g(config, "config");
        a aVar = a.f30363a;
        aVar.d(config.getGrayScale());
        aVar.e(config.getJankThreshold());
        aVar.f(config.getTraceInterval());
        double dNextDouble = new SecureRandom().nextDouble();
        if (aVar.a() != 0.0f && dNextDouble <= aVar.a()) {
            a();
        } else {
            c();
        }
    }

    public final void c() {
        if (f30368b) {
            f30368b = false;
            ra.b.f75170a.e(false);
        }
    }
}
