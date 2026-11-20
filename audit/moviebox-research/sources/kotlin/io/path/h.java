package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f68886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f68887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f68888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Iterator<h> f68889d;

    public h(Path path, Object obj, h hVar) {
        Intrinsics.g(path, "path");
        this.f68886a = path;
        this.f68887b = obj;
        this.f68888c = hVar;
    }

    public final Iterator<h> a() {
        return this.f68889d;
    }

    public final Object b() {
        return this.f68887b;
    }

    public final h c() {
        return this.f68888c;
    }

    public final Path d() {
        return this.f68886a;
    }

    public final void e(Iterator<h> it) {
        this.f68889d = it;
    }
}
