package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;

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
public final class c1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final a<T> f69379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final int f69380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final BufferOverflow f69381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public final CoroutineContext f69382d;

    /* JADX WARN: Multi-variable type inference failed */
    public c1(a<? extends T> aVar, int i11, BufferOverflow bufferOverflow, CoroutineContext coroutineContext) {
        this.f69379a = aVar;
        this.f69380b = i11;
        this.f69381c = bufferOverflow;
        this.f69382d = coroutineContext;
    }
}
