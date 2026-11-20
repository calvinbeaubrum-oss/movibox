package androidx.room;

import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class a0 implements g6.h.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f12812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<InputStream> f12813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g6.h.c f12814d;

    public a0(String str, File file, Callable<InputStream> callable, g6.h.c mDelegate) {
        Intrinsics.g(mDelegate, "mDelegate");
        this.f12811a = str;
        this.f12812b = file;
        this.f12813c = callable;
        this.f12814d = mDelegate;
    }

    @Override // g6.h.c
    public g6.h a(g6.h.b configuration) {
        Intrinsics.g(configuration, "configuration");
        return new z(configuration.f65420a, this.f12811a, this.f12812b, this.f12813c, configuration.f65422c.f65418a, this.f12814d.a(configuration));
    }
}
