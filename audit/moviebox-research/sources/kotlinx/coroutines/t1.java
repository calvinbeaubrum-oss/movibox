package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

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
public final class t1 {
    public static final z a(q1 q1Var) {
        return v1.a(q1Var);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        v1.c(coroutineContext, cancellationException);
    }

    public static final void d(q1 q1Var, String str, Throwable th2) {
        v1.d(q1Var, str, th2);
    }

    public static final Object g(q1 q1Var, Continuation<? super Unit> continuation) {
        return v1.g(q1Var, continuation);
    }

    public static final void h(n<?> nVar, Future<?> future) {
        u1.a(nVar, future);
    }

    public static final y0 i(q1 q1Var, y0 y0Var) {
        return v1.h(q1Var, y0Var);
    }

    public static final void j(CoroutineContext coroutineContext) {
        v1.i(coroutineContext);
    }

    public static final void k(q1 q1Var) {
        v1.j(q1Var);
    }

    public static final q1 l(CoroutineContext coroutineContext) {
        return v1.k(coroutineContext);
    }

    public static final boolean m(CoroutineContext coroutineContext) {
        return v1.l(coroutineContext);
    }
}
