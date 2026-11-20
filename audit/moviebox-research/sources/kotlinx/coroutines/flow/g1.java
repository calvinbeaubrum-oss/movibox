package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.c0 f69387a = new kotlinx.coroutines.internal.c0("NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.c0 f69388b = new kotlinx.coroutines.internal.c0("PENDING");

    public static final <T> v0<T> a(T t11) {
        if (t11 == null) {
            t11 = (T) kotlinx.coroutines.flow.internal.m.f69416a;
        }
        return new StateFlowImpl(t11);
    }

    public static final <T> a<T> d(f1<? extends T> f1Var, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return (((i11 < 0 || i11 >= 2) && i11 != -2) || bufferOverflow != BufferOverflow.DROP_OLDEST) ? a1.e(f1Var, coroutineContext, i11, bufferOverflow) : f1Var;
    }
}
