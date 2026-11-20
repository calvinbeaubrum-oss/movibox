package vo;

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
public final class c implements pf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f79028a = 5242880;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f79029b = 86400000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f79030c = System.currentTimeMillis();

    @Override // pf.a
    public boolean a(File file) {
        if (file == null || !file.isFile()) {
            return false;
        }
        return b(file) || file.length() > this.f79028a;
    }

    public final boolean b(File file) {
        if (file == null) {
            return false;
        }
        return (this.f79030c - file.lastModified()) / ((long) this.f79029b) >= 15;
    }
}
