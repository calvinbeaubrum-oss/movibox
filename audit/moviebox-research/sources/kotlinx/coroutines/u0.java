package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;

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
public final class u0 {
    public static final <T> void a(DispatchedTask<? super T> dispatchedTask, int i11) {
        Continuation<? super T> delegate$kotlinx_coroutines_core = dispatchedTask.getDelegate$kotlinx_coroutines_core();
        boolean z11 = i11 == 4;
        if (z11 || !(delegate$kotlinx_coroutines_core instanceof DispatchedContinuation) || b(i11) != b(dispatchedTask.resumeMode)) {
            d(dispatchedTask, delegate$kotlinx_coroutines_core, z11);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) delegate$kotlinx_coroutines_core).dispatcher;
        CoroutineContext context = delegate$kotlinx_coroutines_core.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, dispatchedTask);
        } else {
            e(dispatchedTask);
        }
    }

    public static final boolean b(int i11) {
        return i11 == 1 || i11 == 2;
    }

    public static final boolean c(int i11) {
        return i11 == 2;
    }

    public static final <T> void d(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z11) {
        Object successfulResult$kotlinx_coroutines_core;
        Object objTakeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            Result.Companion companion = Result.Companion;
            successfulResult$kotlinx_coroutines_core = ResultKt.a(exceptionalResult$kotlinx_coroutines_core);
        } else {
            Result.Companion companion2 = Result.Companion;
            successfulResult$kotlinx_coroutines_core = dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
        }
        Object objM163constructorimpl = Result.m163constructorimpl(successfulResult$kotlinx_coroutines_core);
        if (!z11) {
            continuation.resumeWith(objM163constructorimpl);
            return;
        }
        Intrinsics.e(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Continuation<T> continuation2 = dispatchedContinuation.continuation;
        Object obj = dispatchedContinuation.countOrElement;
        CoroutineContext context = continuation2.getContext();
        Object objC = ThreadContextKt.c(context, obj);
        q2<?> q2VarG = objC != ThreadContextKt.f69447a ? CoroutineContextKt.g(continuation2, context, objC) : null;
        try {
            dispatchedContinuation.continuation.resumeWith(objM163constructorimpl);
            Unit unit = Unit.f68710a;
        } finally {
            if (q2VarG == null || q2VarG.s()) {
                ThreadContextKt.a(context, objC);
            }
        }
    }

    public static final void e(DispatchedTask<?> dispatchedTask) {
        c1 c1VarB = o2.f69509a.b();
        if (c1VarB.isUnconfinedLoopActive()) {
            c1VarB.dispatchUnconfined(dispatchedTask);
            return;
        }
        c1VarB.incrementUseCount(true);
        try {
            d(dispatchedTask, dispatchedTask.getDelegate$kotlinx_coroutines_core(), true);
            do {
            } while (c1VarB.processUnconfinedEvent());
        } catch (Throwable th2) {
            try {
                dispatchedTask.handleFatalException$kotlinx_coroutines_core(th2, null);
            } finally {
                c1VarB.decrementUseCount(true);
            }
        }
    }
}
