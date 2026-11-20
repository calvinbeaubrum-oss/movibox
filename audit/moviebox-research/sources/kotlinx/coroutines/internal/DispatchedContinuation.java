package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.m0;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@PublishedApi
@SourceDebugExtension
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _reusableCancellableContinuation$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    @JvmField
    public Object _state;

    @JvmField
    public final Continuation<T> continuation;

    @JvmField
    public final Object countOrElement;

    @JvmField
    public final CoroutineDispatcher dispatcher;

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.dispatcher = coroutineDispatcher;
        this.continuation = continuation;
        this._state = i.f69468a;
        this.countOrElement = ThreadContextKt.b(getContext());
    }

    private final CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        Object obj = _reusableCancellableContinuation$volatile$FU.get(this);
        if (obj instanceof CancellableContinuationImpl) {
            return (CancellableContinuationImpl) obj;
        }
        return null;
    }

    private final /* synthetic */ Object get_reusableCancellableContinuation$volatile() {
        return this._reusableCancellableContinuation$volatile;
    }

    public static /* synthetic */ void get_state$kotlinx_coroutines_core$annotations() {
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ void set_reusableCancellableContinuation$volatile(Object obj) {
        this._reusableCancellableContinuation$volatile = obj;
    }

    public final void awaitReusability$kotlinx_coroutines_core() {
        while (_reusableCancellableContinuation$volatile$FU.get(this) == i.f69469b) {
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th2) {
        if (obj instanceof kotlinx.coroutines.c0) {
            ((kotlinx.coroutines.c0) obj).f69211b.invoke(th2);
        }
    }

    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _reusableCancellableContinuation$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                _reusableCancellableContinuation$volatile$FU.set(this, i.f69469b);
                return null;
            }
            if (obj instanceof CancellableContinuationImpl) {
                if (kotlinx.coroutines.o.a(_reusableCancellableContinuation$volatile$FU, this, obj, i.f69469b)) {
                    return (CancellableContinuationImpl) obj;
                }
            } else if (obj != i.f69469b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(CoroutineContext coroutineContext, T t11) {
        this._state = t11;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(coroutineContext, this);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.continuation;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final boolean isReusable$kotlinx_coroutines_core() {
        return _reusableCancellableContinuation$volatile$FU.get(this) != null;
    }

    public final boolean postponeCancellation$kotlinx_coroutines_core(Throwable th2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _reusableCancellableContinuation$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            c0 c0Var = i.f69469b;
            if (Intrinsics.b(obj, c0Var)) {
                if (kotlinx.coroutines.o.a(_reusableCancellableContinuation$volatile$FU, this, c0Var, th2)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (kotlinx.coroutines.o.a(_reusableCancellableContinuation$volatile$FU, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void release$kotlinx_coroutines_core() {
        awaitReusability$kotlinx_coroutines_core();
        CancellableContinuationImpl<?> reusableCancellableContinuation = getReusableCancellableContinuation();
        if (reusableCancellableContinuation != null) {
            reusableCancellableContinuation.detachChild$kotlinx_coroutines_core();
        }
    }

    public final void resumeCancellableWith$kotlinx_coroutines_core(Object obj, Function1<? super Throwable, Unit> function1) {
        Object objB = kotlinx.coroutines.e0.b(obj, function1);
        if (this.dispatcher.isDispatchNeeded(getContext())) {
            this._state = objB;
            this.resumeMode = 1;
            this.dispatcher.dispatch(getContext(), this);
            return;
        }
        c1 c1VarB = o2.f69509a.b();
        if (c1VarB.isUnconfinedLoopActive()) {
            this._state = objB;
            this.resumeMode = 1;
            c1VarB.dispatchUnconfined(this);
            return;
        }
        c1VarB.incrementUseCount(true);
        try {
            q1 q1Var = (q1) getContext().get(q1.f69514j8);
            if (q1Var == null || q1Var.isActive()) {
                Continuation<T> continuation = this.continuation;
                Object obj2 = this.countOrElement;
                CoroutineContext context = continuation.getContext();
                Object objC = ThreadContextKt.c(context, obj2);
                q2<?> q2VarG = objC != ThreadContextKt.f69447a ? CoroutineContextKt.g(continuation, context, objC) : null;
                try {
                    this.continuation.resumeWith(obj);
                    Unit unit = Unit.f68710a;
                    InlineMarker.b(1);
                    if (q2VarG == null || q2VarG.s()) {
                        ThreadContextKt.a(context, objC);
                    }
                    InlineMarker.a(1);
                } finally {
                    InlineMarker.b(1);
                    if (q2VarG == null || q2VarG.s()) {
                        ThreadContextKt.a(context, objC);
                    }
                    InlineMarker.a(1);
                }
            } else {
                CancellationException cancellationException = q1Var.getCancellationException();
                cancelCompletedResult$kotlinx_coroutines_core(objB, cancellationException);
                Result.Companion companion = Result.Companion;
                resumeWith(Result.m163constructorimpl(ResultKt.a(cancellationException)));
            }
            while (c1VarB.processUnconfinedEvent()) {
            }
            InlineMarker.b(1);
        } catch (Throwable th2) {
            try {
                handleFatalException$kotlinx_coroutines_core(th2, null);
                InlineMarker.b(1);
            } finally {
                InlineMarker.b(1);
                c1VarB.decrementUseCount(true);
                InlineMarker.a(1);
            }
        }
    }

    public final boolean resumeCancelled$kotlinx_coroutines_core(Object obj) {
        q1 q1Var = (q1) getContext().get(q1.f69514j8);
        if (q1Var == null || q1Var.isActive()) {
            return false;
        }
        CancellationException cancellationException = q1Var.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(obj, cancellationException);
        Result.Companion companion = Result.Companion;
        resumeWith(Result.m163constructorimpl(ResultKt.a(cancellationException)));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0029 A[DONT_GENERATE] */
    public final void resumeUndispatchedWith$kotlinx_coroutines_core(Object obj) {
        Continuation<T> continuation = this.continuation;
        Object obj2 = this.countOrElement;
        CoroutineContext context = continuation.getContext();
        Object objC = ThreadContextKt.c(context, obj2);
        q2<?> q2VarG = objC != ThreadContextKt.f69447a ? CoroutineContextKt.g(continuation, context, objC) : null;
        try {
            this.continuation.resumeWith(obj);
            Unit unit = Unit.f68710a;
        } finally {
            InlineMarker.b(1);
            if (q2VarG == null || q2VarG.s()) {
                ThreadContextKt.a(context, objC);
            }
            InlineMarker.a(1);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        CoroutineContext context = this.continuation.getContext();
        Object objD = kotlinx.coroutines.e0.d(obj, null, 1, null);
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = objD;
            this.resumeMode = 0;
            this.dispatcher.dispatch(context, this);
            return;
        }
        c1 c1VarB = o2.f69509a.b();
        if (c1VarB.isUnconfinedLoopActive()) {
            this._state = objD;
            this.resumeMode = 0;
            c1VarB.dispatchUnconfined(this);
            return;
        }
        c1VarB.incrementUseCount(true);
        try {
            CoroutineContext context2 = getContext();
            Object objC = ThreadContextKt.c(context2, this.countOrElement);
            try {
                this.continuation.resumeWith(obj);
                Unit unit = Unit.f68710a;
                ThreadContextKt.a(context2, objC);
                while (c1VarB.processUnconfinedEvent()) {
                }
            } catch (Throwable th2) {
                ThreadContextKt.a(context2, objC);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                handleFatalException$kotlinx_coroutines_core(th3, null);
            } finally {
                c1VarB.decrementUseCount(true);
            }
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        Object obj = this._state;
        this._state = i.f69468a;
        return obj;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + m0.c(this.continuation) + ']';
    }

    public final Throwable tryReleaseClaimedContinuation$kotlinx_coroutines_core(kotlinx.coroutines.n<?> nVar) {
        c0 c0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _reusableCancellableContinuation$volatile$FU;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            c0Var = i.f69469b;
            if (obj != c0Var) {
                if (obj instanceof Throwable) {
                    if (kotlinx.coroutines.o.a(_reusableCancellableContinuation$volatile$FU, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!kotlinx.coroutines.o.a(_reusableCancellableContinuation$volatile$FU, this, c0Var, nVar));
        return null;
    }
}
