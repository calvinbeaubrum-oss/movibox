package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final /* synthetic */ class v1 {
    public static final z a(q1 q1Var) {
        return new s1(q1Var);
    }

    public static /* synthetic */ z b(q1 q1Var, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            q1Var = null;
        }
        return t1.a(q1Var);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        q1 q1Var = (q1) coroutineContext.get(q1.f69514j8);
        if (q1Var != null) {
            q1Var.cancel(cancellationException);
        }
    }

    public static final void d(q1 q1Var, String str, Throwable th2) {
        q1Var.cancel(g1.a(str, th2));
    }

    public static /* synthetic */ void e(CoroutineContext coroutineContext, CancellationException cancellationException, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cancellationException = null;
        }
        t1.c(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void f(q1 q1Var, String str, Throwable th2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            th2 = null;
        }
        t1.d(q1Var, str, th2);
    }

    public static final Object g(q1 q1Var, Continuation<? super Unit> continuation) {
        q1.a.b(q1Var, null, 1, null);
        Object objJoin = q1Var.join(continuation);
        return objJoin == kotlin.coroutines.intrinsics.a.e() ? objJoin : Unit.f68710a;
    }

    public static final y0 h(q1 q1Var, y0 y0Var) {
        return q1Var.invokeOnCompletion(new a1(y0Var));
    }

    public static final void i(CoroutineContext coroutineContext) {
        q1 q1Var = (q1) coroutineContext.get(q1.f69514j8);
        if (q1Var != null) {
            t1.k(q1Var);
        }
    }

    public static final void j(q1 q1Var) {
        if (!q1Var.isActive()) {
            throw q1Var.getCancellationException();
        }
    }

    public static final q1 k(CoroutineContext coroutineContext) {
        q1 q1Var = (q1) coroutineContext.get(q1.f69514j8);
        if (q1Var != null) {
            return q1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final boolean l(CoroutineContext coroutineContext) {
        q1 q1Var = (q1) coroutineContext.get(q1.f69514j8);
        if (q1Var != null) {
            return q1Var.isActive();
        }
        return true;
    }
}
