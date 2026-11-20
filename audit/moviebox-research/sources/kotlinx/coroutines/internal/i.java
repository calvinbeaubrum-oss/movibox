package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.q2;

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
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f69468a = new c0("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final c0 f69469b = new c0("REUSABLE_CLAIMED");

    public static final <T> void b(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, Unit> function1) {
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation.resumeWith(obj);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Object objB = kotlinx.coroutines.e0.b(obj, function1);
        if (dispatchedContinuation.dispatcher.isDispatchNeeded(dispatchedContinuation.getContext())) {
            dispatchedContinuation._state = objB;
            dispatchedContinuation.resumeMode = 1;
            dispatchedContinuation.dispatcher.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
            return;
        }
        c1 c1VarB = o2.f69509a.b();
        if (c1VarB.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = objB;
            dispatchedContinuation.resumeMode = 1;
            c1VarB.dispatchUnconfined(dispatchedContinuation);
            return;
        }
        c1VarB.incrementUseCount(true);
        try {
            q1 q1Var = (q1) dispatchedContinuation.getContext().get(q1.f69514j8);
            if (q1Var == null || q1Var.isActive()) {
                Continuation<T> continuation2 = dispatchedContinuation.continuation;
                Object obj2 = dispatchedContinuation.countOrElement;
                CoroutineContext context = continuation2.getContext();
                Object objC = ThreadContextKt.c(context, obj2);
                q2<?> q2VarG = objC != ThreadContextKt.f69447a ? CoroutineContextKt.g(continuation2, context, objC) : null;
                try {
                    dispatchedContinuation.continuation.resumeWith(obj);
                    Unit unit = Unit.f68710a;
                    if (q2VarG == null || q2VarG.s()) {
                        ThreadContextKt.a(context, objC);
                    }
                } catch (Throwable th2) {
                    if (q2VarG == null || q2VarG.s()) {
                        ThreadContextKt.a(context, objC);
                    }
                    throw th2;
                }
            } else {
                CancellationException cancellationException = q1Var.getCancellationException();
                dispatchedContinuation.cancelCompletedResult$kotlinx_coroutines_core(objB, cancellationException);
                Result.Companion companion = Result.Companion;
                dispatchedContinuation.resumeWith(Result.m163constructorimpl(ResultKt.a(cancellationException)));
            }
            while (c1VarB.processUnconfinedEvent()) {
            }
        } catch (Throwable th3) {
            try {
                dispatchedContinuation.handleFatalException$kotlinx_coroutines_core(th3, null);
            } finally {
                c1VarB.decrementUseCount(true);
            }
        }
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, Function1 function1, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        b(continuation, obj, function1);
    }

    public static final boolean d(DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Unit unit = Unit.f68710a;
        c1 c1VarB = o2.f69509a.b();
        if (c1VarB.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (c1VarB.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = unit;
            dispatchedContinuation.resumeMode = 1;
            c1VarB.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        c1VarB.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (c1VarB.processUnconfinedEvent());
        } catch (Throwable th2) {
            try {
                dispatchedContinuation.handleFatalException$kotlinx_coroutines_core(th2, null);
            } finally {
                c1VarB.decrementUseCount(true);
            }
        }
        return false;
    }
}
