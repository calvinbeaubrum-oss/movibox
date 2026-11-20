package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.DispatchedContinuation;

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
public final class u2 {
    public static final Object a(Continuation<? super Unit> continuation) {
        Object objE;
        CoroutineContext context = continuation.getContext();
        t1.j(context);
        Continuation continuationC = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        DispatchedContinuation dispatchedContinuation = continuationC instanceof DispatchedContinuation ? (DispatchedContinuation) continuationC : null;
        if (dispatchedContinuation == null) {
            objE = Unit.f68710a;
        } else {
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(context, Unit.f68710a);
            } else {
                t2 t2Var = new t2();
                CoroutineContext coroutineContextPlus = context.plus(t2Var);
                Unit unit = Unit.f68710a;
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(coroutineContextPlus, unit);
                objE = (!t2Var.f69607a || kotlinx.coroutines.internal.i.d(dispatchedContinuation)) ? kotlin.coroutines.intrinsics.a.e() : unit;
            }
            objE = kotlin.coroutines.intrinsics.a.e();
        }
        if (objE == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }
}
