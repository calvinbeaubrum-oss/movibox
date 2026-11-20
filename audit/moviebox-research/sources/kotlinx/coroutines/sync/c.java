package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.f0;

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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f69598a = f0.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f69599b = new c0("PERMIT");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f69600c = new c0("TAKEN");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c0 f69601d = new c0("BROKEN");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0 f69602e = new c0("CANCELLED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f69603f = f0.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final d h(long j11, d dVar) {
        return new d(j11, dVar, 0);
    }
}
