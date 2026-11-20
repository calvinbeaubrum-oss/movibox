package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;

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
@SourceDebugExtension
public abstract class DispatchedTask<T> extends Task {

    @JvmField
    public int resumeMode;

    public DispatchedTask(int i11) {
        this.resumeMode = i11;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th2) {
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        if (b0Var != null) {
            return b0Var.f69208a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th2, Throwable th3) {
        if (th2 == null && th3 == null) {
            return;
        }
        if (th2 != null && th3 != null) {
            v10.b.a(th2, th3);
        }
        if (th2 == null) {
            th2 = th3;
        }
        Intrinsics.d(th2);
        h0.a(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th2));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objM163constructorimpl;
        Object objM163constructorimpl2;
        kotlinx.coroutines.scheduling.g gVar = this.taskContext;
        try {
            Continuation<T> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            Intrinsics.e(delegate$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
            Continuation<T> continuation = dispatchedContinuation.continuation;
            Object obj = dispatchedContinuation.countOrElement;
            CoroutineContext context = continuation.getContext();
            Object objC = ThreadContextKt.c(context, obj);
            q2<?> q2VarG = objC != ThreadContextKt.f69447a ? CoroutineContextKt.g(continuation, context, objC) : null;
            try {
                CoroutineContext context2 = continuation.getContext();
                Object objTakeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
                q1 q1Var = (exceptionalResult$kotlinx_coroutines_core == null && u0.b(this.resumeMode)) ? (q1) context2.get(q1.f69514j8) : null;
                if (q1Var != null && !q1Var.isActive()) {
                    CancellationException cancellationException = q1Var.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core, cancellationException);
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.m163constructorimpl(ResultKt.a(cancellationException)));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    Result.Companion companion2 = Result.Companion;
                    continuation.resumeWith(Result.m163constructorimpl(ResultKt.a(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    Result.Companion companion3 = Result.Companion;
                    continuation.resumeWith(Result.m163constructorimpl(getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core)));
                }
                Unit unit = Unit.f68710a;
                if (q2VarG == null || q2VarG.s()) {
                    ThreadContextKt.a(context, objC);
                }
                try {
                    gVar.a();
                    objM163constructorimpl2 = Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    objM163constructorimpl2 = Result.m163constructorimpl(ResultKt.a(th2));
                }
                handleFatalException$kotlinx_coroutines_core(null, Result.m166exceptionOrNullimpl(objM163constructorimpl2));
            } catch (Throwable th3) {
                if (q2VarG == null || q2VarG.s()) {
                    ThreadContextKt.a(context, objC);
                }
                throw th3;
            }
        } catch (Throwable th4) {
            try {
                Result.Companion companion5 = Result.Companion;
                gVar.a();
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th5) {
                Result.Companion companion6 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th5));
            }
            handleFatalException$kotlinx_coroutines_core(th4, Result.m166exceptionOrNullimpl(objM163constructorimpl));
        }
    }

    public abstract Object takeState$kotlinx_coroutines_core();
}
