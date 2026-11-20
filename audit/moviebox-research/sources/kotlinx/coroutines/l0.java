package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;

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
public final class l0 {
    public static final k0 a(CoroutineContext coroutineContext) {
        if (coroutineContext.get(q1.f69514j8) == null) {
            coroutineContext = coroutineContext.plus(v1.b(null, 1, null));
        }
        return new kotlinx.coroutines.internal.f(coroutineContext);
    }

    public static final k0 b() {
        return new kotlinx.coroutines.internal.f(l2.b(null, 1, null).plus(w0.c()));
    }

    public static final void c(k0 k0Var, CancellationException cancellationException) {
        q1 q1Var = (q1) k0Var.getCoroutineContext().get(q1.f69514j8);
        if (q1Var != null) {
            q1Var.cancel(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + k0Var).toString());
    }

    public static /* synthetic */ void d(k0 k0Var, CancellationException cancellationException, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cancellationException = null;
        }
        c(k0Var, cancellationException);
    }

    public static final <R> Object e(Function2<? super k0, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        kotlinx.coroutines.internal.y yVar = new kotlinx.coroutines.internal.y(continuation.getContext(), continuation);
        Object objB = d20.b.b(yVar, yVar, function2);
        if (objB == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return objB;
    }

    public static final boolean f(k0 k0Var) {
        q1 q1Var = (q1) k0Var.getCoroutineContext().get(q1.f69514j8);
        if (q1Var != null) {
            return q1Var.isActive();
        }
        return true;
    }

    public static final k0 g(k0 k0Var, CoroutineContext coroutineContext) {
        return new kotlinx.coroutines.internal.f(k0Var.getCoroutineContext().plus(coroutineContext));
    }
}
