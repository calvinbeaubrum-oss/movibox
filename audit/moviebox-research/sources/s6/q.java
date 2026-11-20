package s6;

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
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f76187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.work.d f76188b;

    public q(String workSpecId, androidx.work.d progress) {
        Intrinsics.g(workSpecId, "workSpecId");
        Intrinsics.g(progress, "progress");
        this.f76187a = workSpecId;
        this.f76188b = progress;
    }

    public final androidx.work.d a() {
        return this.f76188b;
    }

    public final String b() {
        return this.f76187a;
    }
}
