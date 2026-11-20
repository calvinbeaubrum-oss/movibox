package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.mvel2.ast.ASTNode;

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
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements n<T>, CoroutineStackFrame, s2 {
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    private final CoroutineContext context;
    private final Continuation<T> delegate;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _decisionAndIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle$volatile");

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> continuation, int i11) {
        super(i11);
        this.delegate = continuation;
        this.context = continuation.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = d.f69263a;
    }

    private final Void alreadyResumedError(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void callCancelHandler(Function1<? super Throwable, Unit> function1, Throwable th2) {
        try {
            function1.invoke(th2);
        } catch (Throwable th3) {
            h0.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    private final void callCancelHandlerSafely(Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Throwable th2) {
            h0.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final void callSegmentOnCancellation(kotlinx.coroutines.internal.z<?> zVar, Throwable th2) {
        int i11 = _decisionAndIndex$volatile$FU.get(this) & 536870911;
        if (i11 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
        try {
            zVar.r(i11, th2, getContext());
        } catch (Throwable th3) {
            h0.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    private final boolean cancelLater(Throwable th2) {
        if (!isReusable()) {
            return false;
        }
        Continuation<T> continuation = this.delegate;
        Intrinsics.e(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) continuation).postponeCancellation$kotlinx_coroutines_core(th2);
    }

    private final void detachChildIfNonResuable() {
        if (isReusable()) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
    }

    private final void dispatchResume(int i11) {
        if (tryResume()) {
            return;
        }
        u0.a(this, i11);
    }

    private final y0 getParentHandle() {
        return (y0) _parentHandle$volatile$FU.get(this);
    }

    private final String getStateDebugRepresentation() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof e2) {
            return "Active";
        }
        return state$kotlinx_coroutines_core instanceof r ? "Cancelled" : "Completed";
    }

    private final /* synthetic */ int get_decisionAndIndex$volatile() {
        return this._decisionAndIndex$volatile;
    }

    private final /* synthetic */ Object get_parentHandle$volatile() {
        return this._parentHandle$volatile;
    }

    private final /* synthetic */ Object get_state$volatile() {
        return this._state$volatile;
    }

    private final y0 installParentHandle() {
        q1 q1Var = (q1) getContext().get(q1.f69514j8);
        if (q1Var == null) {
            return null;
        }
        y0 y0VarE = q1.a.e(q1Var, true, false, new s(this), 2, null);
        o.a(_parentHandle$volatile$FU, this, null, y0VarE);
        return y0VarE;
    }

    private final void invokeOnCancellationImpl(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof d) {
                if (o.a(_state$volatile$FU, this, obj2, obj)) {
                    return;
                }
            } else if ((obj2 instanceof l) || (obj2 instanceof kotlinx.coroutines.internal.z)) {
                multipleHandlersError(obj, obj2);
            } else {
                boolean z11 = obj2 instanceof b0;
                if (z11) {
                    b0 b0Var = (b0) obj2;
                    if (!b0Var.c()) {
                        multipleHandlersError(obj, obj2);
                    }
                    if (obj2 instanceof r) {
                        if (!z11) {
                            b0Var = null;
                        }
                        Throwable th2 = b0Var != null ? b0Var.f69208a : null;
                        if (obj instanceof l) {
                            callCancelHandler((l) obj, th2);
                            return;
                        } else {
                            Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            callSegmentOnCancellation((kotlinx.coroutines.internal.z) obj, th2);
                            return;
                        }
                    }
                    return;
                }
                if (obj2 instanceof a0) {
                    a0 a0Var = (a0) obj2;
                    if (a0Var.f69194b != null) {
                        multipleHandlersError(obj, obj2);
                    }
                    if (obj instanceof kotlinx.coroutines.internal.z) {
                        return;
                    }
                    Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    l lVar = (l) obj;
                    if (a0Var.c()) {
                        callCancelHandler(lVar, a0Var.f69197e);
                        return;
                    } else {
                        if (o.a(_state$volatile$FU, this, obj2, a0.b(a0Var, null, lVar, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (obj instanceof kotlinx.coroutines.internal.z) {
                        return;
                    }
                    Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    if (o.a(_state$volatile$FU, this, obj2, new a0(obj2, (l) obj, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    private final boolean isReusable() {
        if (u0.c(this.resumeMode)) {
            Continuation<T> continuation = this.delegate;
            Intrinsics.e(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((DispatchedContinuation) continuation).isReusable$kotlinx_coroutines_core()) {
                return true;
            }
        }
        return false;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function1) {
        while (true) {
            function1.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final l makeCancelHandler(Function1<? super Throwable, Unit> function1) {
        return function1 instanceof l ? (l) function1 : new n1(function1);
    }

    private final void multipleHandlersError(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    private final void resumeImpl(Object obj, int i11, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof e2)) {
                if (obj2 instanceof r) {
                    r rVar = (r) obj2;
                    if (rVar.e()) {
                        if (function1 != null) {
                            callOnCancellation(function1, rVar.f69208a);
                            return;
                        }
                        return;
                    }
                }
                alreadyResumedError(obj);
                throw new KotlinNothingValueException();
            }
        } while (!o.a(_state$volatile$FU, this, obj2, resumedState((e2) obj2, obj, i11, function1, null)));
        detachChildIfNonResuable();
        dispatchResume(i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void resumeImpl$default(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i11, Function1 function1, int i12, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i12 & 4) != 0) {
            function1 = null;
        }
        cancellableContinuationImpl.resumeImpl(obj, i11, function1);
    }

    private final Object resumedState(e2 e2Var, Object obj, int i11, Function1<? super Throwable, Unit> function1, Object obj2) {
        if (obj instanceof b0) {
            return obj;
        }
        if (!u0.b(i11) && obj2 == null) {
            return obj;
        }
        if (function1 == null && !(e2Var instanceof l) && obj2 == null) {
            return obj;
        }
        return new a0(obj, e2Var instanceof l ? (l) e2Var : null, function1, obj2, null, 16, null);
    }

    private final /* synthetic */ void set_decisionAndIndex$volatile(int i11) {
        this._decisionAndIndex$volatile = i11;
    }

    private final /* synthetic */ void set_parentHandle$volatile(Object obj) {
        this._parentHandle$volatile = obj;
    }

    private final /* synthetic */ void set_state$volatile(Object obj) {
        this._state$volatile = obj;
    }

    private final boolean tryResume() {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$volatile$FU;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            int i12 = i11 >> 29;
            if (i12 != 0) {
                if (i12 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decisionAndIndex$volatile$FU.compareAndSet(this, i11, 1073741824 + (536870911 & i11)));
        return true;
    }

    private final kotlinx.coroutines.internal.c0 tryResumeImpl(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof e2)) {
                if ((obj3 instanceof a0) && obj2 != null && ((a0) obj3).f69196d == obj2) {
                    return p.f69511a;
                }
                return null;
            }
        } while (!o.a(_state$volatile$FU, this, obj3, resumedState((e2) obj3, obj, this.resumeMode, function1, obj2)));
        detachChildIfNonResuable();
        return p.f69511a;
    }

    private final boolean trySuspend() {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$volatile$FU;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            int i12 = i11 >> 29;
            if (i12 != 0) {
                if (i12 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decisionAndIndex$volatile$FU.compareAndSet(this, i11, ASTNode.DISCARD + (536870911 & i11)));
        return true;
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Integer> function1) {
        int i11;
        do {
            i11 = atomicIntegerFieldUpdater.get(obj);
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i11, function1.invoke(Integer.valueOf(i11)).intValue()));
    }

    public final void callCancelHandler(l lVar, Throwable th2) {
        try {
            lVar.d(th2);
        } catch (Throwable th3) {
            h0.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public final void callOnCancellation(Function1<? super Throwable, Unit> function1, Throwable th2) {
        try {
            function1.invoke(th2);
        } catch (Throwable th3) {
            h0.a(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th3));
        }
    }

    @Override // kotlinx.coroutines.n
    public boolean cancel(Throwable th2) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof e2)) {
                return false;
            }
        } while (!o.a(_state$volatile$FU, this, obj, new r(this, th2, (obj instanceof l) || (obj instanceof kotlinx.coroutines.internal.z))));
        e2 e2Var = (e2) obj;
        if (e2Var instanceof l) {
            callCancelHandler((l) obj, th2);
        } else if (e2Var instanceof kotlinx.coroutines.internal.z) {
            callSegmentOnCancellation((kotlinx.coroutines.internal.z) obj, th2);
        }
        detachChildIfNonResuable();
        dispatchResume(this.resumeMode);
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof e2) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof b0) {
                return;
            }
            if (obj2 instanceof a0) {
                a0 a0Var = (a0) obj2;
                if (!(!a0Var.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (o.a(_state$volatile$FU, this, obj2, a0.b(a0Var, null, null, null, null, th2, 15, null))) {
                    a0Var.d(this, th2);
                    return;
                }
            } else if (o.a(_state$volatile$FU, this, obj2, new a0(obj2, null, null, null, th2, 14, null))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.n
    public void completeResume(Object obj) {
        dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        y0 parentHandle = getParentHandle();
        if (parentHandle == null) {
            return;
        }
        parentHandle.dispose();
        _parentHandle$volatile$FU.set(this, d2.f69264a);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    public Throwable getContinuationCancellationCause(q1 q1Var) {
        return q1Var.getCancellationException();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            return exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    @PublishedApi
    public final Object getResult() {
        q1 q1Var;
        boolean zIsReusable = isReusable();
        if (trySuspend()) {
            if (getParentHandle() == null) {
                installParentHandle();
            }
            if (zIsReusable) {
                releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }
            return kotlin.coroutines.intrinsics.a.e();
        }
        if (zIsReusable) {
            releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b0) {
            throw ((b0) state$kotlinx_coroutines_core).f69208a;
        }
        if (!u0.b(this.resumeMode) || (q1Var = (q1) getContext().get(q1.f69514j8)) == null || q1Var.isActive()) {
            return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
        }
        CancellationException cancellationException = q1Var.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
        throw cancellationException;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return _state$volatile$FU.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj instanceof a0 ? (T) ((a0) obj).f69193a : obj;
    }

    public void initCancellability() {
        y0 y0VarInstallParentHandle = installParentHandle();
        if (y0VarInstallParentHandle != null && isCompleted()) {
            y0VarInstallParentHandle.dispose();
            _parentHandle$volatile$FU.set(this, d2.f69264a);
        }
    }

    @Override // kotlinx.coroutines.n
    public void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
        invokeOnCancellationImpl(makeCancelHandler(function1));
    }

    @Override // kotlinx.coroutines.s2
    public void invokeOnCancellation(kotlinx.coroutines.internal.z<?> zVar, int i11) {
        int i12;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$volatile$FU;
        do {
            i12 = atomicIntegerFieldUpdater.get(this);
            if ((i12 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i12, ((i12 >> 29) << 29) + i11));
        invokeOnCancellationImpl(zVar);
    }

    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof e2;
    }

    public boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof r;
    }

    @Override // kotlinx.coroutines.n
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof e2);
    }

    public String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable th2) {
        if (cancelLater(th2)) {
            return;
        }
        cancel(th2);
        detachChildIfNonResuable();
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        Throwable thTryReleaseClaimedContinuation$kotlinx_coroutines_core;
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation == null || (thTryReleaseClaimedContinuation$kotlinx_coroutines_core = dispatchedContinuation.tryReleaseClaimedContinuation$kotlinx_coroutines_core(this)) == null) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
        cancel(thTryReleaseClaimedContinuation$kotlinx_coroutines_core);
    }

    @JvmName
    public final boolean resetStateReusable() {
        Object obj = _state$volatile$FU.get(this);
        if ((obj instanceof a0) && ((a0) obj).f69196d != null) {
            detachChild$kotlinx_coroutines_core();
            return false;
        }
        _decisionAndIndex$volatile$FU.set(this, 536870911);
        _state$volatile$FU.set(this, d.f69263a);
        return true;
    }

    @Override // kotlinx.coroutines.n
    public void resume(T t11, Function1<? super Throwable, Unit> function1) {
        resumeImpl(t11, this.resumeMode, function1);
    }

    @Override // kotlinx.coroutines.n
    public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t11) {
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        resumeImpl$default(this, t11, (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    public void resumeUndispatchedWithException(CoroutineDispatcher coroutineDispatcher, Throwable th2) {
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        resumeImpl$default(this, new b0(th2, false, 2, null), (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        resumeImpl$default(this, e0.c(obj, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    public String toString() {
        return nameString() + '(' + m0.c(this.delegate) + "){" + getStateDebugRepresentation() + "}@" + m0.b(this);
    }

    public Object tryResume(T t11, Object obj) {
        return tryResumeImpl(t11, obj, null);
    }

    @Override // kotlinx.coroutines.n
    public Object tryResume(T t11, Object obj, Function1<? super Throwable, Unit> function1) {
        return tryResumeImpl(t11, obj, function1);
    }

    @Override // kotlinx.coroutines.n
    public Object tryResumeWithException(Throwable th2) {
        return tryResumeImpl(new b0(th2, false, 2, null), null, null);
    }
}
