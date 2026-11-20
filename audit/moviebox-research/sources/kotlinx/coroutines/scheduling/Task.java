package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@PublishedApi
public abstract class Task implements Runnable {

    @JvmField
    public long submissionTime;

    @JvmField
    public g taskContext;

    public Task() {
        this(0L, i.f69550g);
    }

    public Task(long j11, g gVar) {
        this.submissionTime = j11;
        this.taskContext = gVar;
    }

    public final int getMode$kotlinx_coroutines_core() {
        return this.taskContext.b();
    }
}
