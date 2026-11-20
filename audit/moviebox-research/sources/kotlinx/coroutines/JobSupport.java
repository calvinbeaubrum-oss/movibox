package kotlinx.coroutines;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
@Metadata
@SourceDebugExtension
public class JobSupport implements q1, v, f2 {
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        public AwaitContinuation(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable getContinuationCancellationCause(q1 q1Var) {
            Throwable thE;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof b) || (thE = ((b) state$kotlinx_coroutines_core).e()) == null) {
                return state$kotlinx_coroutines_core instanceof b0 ? ((b0) state$kotlinx_coroutines_core).f69208a : q1Var.getCancellationException();
            }
            return thE;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public String nameString() {
            return "AwaitContinuation";
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a extends w1 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final JobSupport f69179f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final b f69180g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final u f69181h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Object f69182i;

        public a(JobSupport jobSupport, b bVar, u uVar, Object obj) {
            this.f69179f = jobSupport;
            this.f69180g = bVar;
            this.f69181h = uVar;
            this.f69182i = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
            t(th2);
            return Unit.f68710a;
        }

        @Override // kotlinx.coroutines.d0
        public void t(Throwable th2) {
            this.f69179f.continueCompleting(this.f69180g, this.f69181h, this.f69182i);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    @SourceDebugExtension
    public static final class b implements l1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f69183b = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isCompleting$volatile");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f69184c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_rootCause$volatile");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f69185d = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_exceptionsHolder$volatile");
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b2 f69186a;

        public b(b2 b2Var, boolean z11, Throwable th2) {
            this.f69186a = b2Var;
            this._isCompleting$volatile = z11 ? 1 : 0;
            this._rootCause$volatile = th2;
        }

        public final void a(Throwable th2) {
            Throwable thE = e();
            if (thE == null) {
                o(th2);
                return;
            }
            if (th2 == thE) {
                return;
            }
            Object objD = d();
            if (objD == null) {
                n(th2);
                return;
            }
            if (objD instanceof Throwable) {
                if (th2 == objD) {
                    return;
                }
                ArrayList<Throwable> arrayListC = c();
                arrayListC.add(objD);
                arrayListC.add(th2);
                n(arrayListC);
                return;
            }
            if (objD instanceof ArrayList) {
                ((ArrayList) objD).add(th2);
                return;
            }
            throw new IllegalStateException(("State is " + objD).toString());
        }

        @Override // kotlinx.coroutines.l1
        public b2 b() {
            return this.f69186a;
        }

        public final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        public final Object d() {
            return f69185d.get(this);
        }

        public final Throwable e() {
            return (Throwable) f69184c.get(this);
        }

        public final boolean i() {
            return e() != null;
        }

        @Override // kotlinx.coroutines.l1
        public boolean isActive() {
            return e() == null;
        }

        public final boolean j() {
            return f69183b.get(this) != 0;
        }

        public final boolean k() {
            return d() == x1.f69620e;
        }

        public final List<Throwable> l(Throwable th2) {
            ArrayList<Throwable> arrayListC;
            Object objD = d();
            if (objD == null) {
                arrayListC = c();
            } else if (objD instanceof Throwable) {
                ArrayList<Throwable> arrayListC2 = c();
                arrayListC2.add(objD);
                arrayListC = arrayListC2;
            } else {
                if (!(objD instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objD).toString());
                }
                arrayListC = (ArrayList) objD;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListC.add(0, thE);
            }
            if (th2 != null && !Intrinsics.b(th2, thE)) {
                arrayListC.add(th2);
            }
            n(x1.f69620e);
            return arrayListC;
        }

        public final void m(boolean z11) {
            f69183b.set(this, z11 ? 1 : 0);
        }

        public final void n(Object obj) {
            f69185d.set(this, obj);
        }

        public final void o(Throwable th2) {
            f69184c.set(this, th2);
        }

        public String toString() {
            return "Finishing[cancelling=" + i() + ", completing=" + j() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + b() + ']';
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public final class c extends w1 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final kotlinx.coroutines.selects.g<?> f69187f;

        public c(kotlinx.coroutines.selects.g<?> gVar) {
            this.f69187f = gVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
            t(th2);
            return Unit.f68710a;
        }

        @Override // kotlinx.coroutines.d0
        public void t(Throwable th2) {
            Object state$kotlinx_coroutines_core = JobSupport.this.getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof b0)) {
                state$kotlinx_coroutines_core = x1.h(state$kotlinx_coroutines_core);
            }
            this.f69187f.c(JobSupport.this, state$kotlinx_coroutines_core);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public final class d extends w1 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final kotlinx.coroutines.selects.g<?> f69189f;

        public d(kotlinx.coroutines.selects.g<?> gVar) {
            this.f69189f = gVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
            t(th2);
            return Unit.f68710a;
        }

        @Override // kotlinx.coroutines.d0
        public void t(Throwable th2) {
            this.f69189f.c(JobSupport.this, Unit.f68710a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    @SourceDebugExtension
    public static final class e extends LockFreeLinkedListNode.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JobSupport f69191d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f69192e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(LockFreeLinkedListNode lockFreeLinkedListNode, JobSupport jobSupport, Object obj) {
            super(lockFreeLinkedListNode);
            this.f69191d = jobSupport;
            this.f69192e = obj;
        }

        @Override // kotlinx.coroutines.internal.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object e(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f69191d.getState$kotlinx_coroutines_core() == this.f69192e) {
                return null;
            }
            return kotlinx.coroutines.internal.o.a();
        }
    }

    public JobSupport(boolean z11) {
        this._state$volatile = z11 ? x1.f69622g : x1.f69621f;
    }

    private final boolean addLastAtomic(Object obj, b2 b2Var, w1 w1Var) {
        int iS;
        e eVar = new e(w1Var, this, obj);
        do {
            iS = b2Var.k().s(w1Var, b2Var, eVar);
            if (iS == 1) {
                return true;
            }
        } while (iS != 2);
        return false;
    }

    private final void addSuppressedExceptions(Throwable th2, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th3 : list) {
            if (th3 != th2 && th3 != th2 && !(th3 instanceof CancellationException) && setNewSetFromMap.add(th3)) {
                v10.b.a(th2, th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitSuspend(Continuation<Object> continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), this);
        awaitContinuation.initCancellability();
        q.a(awaitContinuation, invokeOnCompletion(new g2(awaitContinuation)));
        Object result = awaitContinuation.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    private final Object cancelMakeCompleting(Object obj) {
        Object objTryMakeCompleting;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof l1) || ((state$kotlinx_coroutines_core instanceof b) && ((b) state$kotlinx_coroutines_core).j())) {
                return x1.f69616a;
            }
            objTryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new b0(createCauseException(obj), false, 2, null));
        } while (objTryMakeCompleting == x1.f69618c);
        return objTryMakeCompleting;
    }

    private final boolean cancelParent(Throwable th2) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z11 = th2 instanceof CancellationException;
        t parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == d2.f69264a) {
            return z11;
        }
        return parentHandle$kotlinx_coroutines_core.a(th2) || z11;
    }

    private final void completeStateFinalization(l1 l1Var, Object obj) throws Throwable {
        t parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(d2.f69264a);
        }
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        Throwable th2 = b0Var != null ? b0Var.f69208a : null;
        if (!(l1Var instanceof w1)) {
            b2 b2VarB = l1Var.b();
            if (b2VarB != null) {
                notifyCompletion(b2VarB, th2);
                return;
            }
            return;
        }
        try {
            ((w1) l1Var).t(th2);
        } catch (Throwable th3) {
            handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + l1Var + " for " + this, th3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void continueCompleting(b bVar, u uVar, Object obj) {
        u uVarNextChild = nextChild(uVar);
        if (uVarNextChild == null || !tryWaitForChild(bVar, uVarNextChild, obj)) {
            afterCompletion(finalizeFinishingState(bVar, obj));
        }
    }

    private final Throwable createCauseException(Object obj) {
        if (obj == null || (obj instanceof Throwable)) {
            Throwable th2 = (Throwable) obj;
            return th2 == null ? new JobCancellationException(cancellationExceptionMessage(), null, this) : th2;
        }
        Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((f2) obj).getChildJobCancellationCause();
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport jobSupport, String str, Throwable th2, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            th2 = null;
        }
        if (str == null) {
            str = jobSupport.cancellationExceptionMessage();
        }
        return new JobCancellationException(str, th2, jobSupport);
    }

    private final Object finalizeFinishingState(b bVar, Object obj) throws Throwable {
        boolean zI;
        Throwable finalRootCause;
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        Throwable th2 = b0Var != null ? b0Var.f69208a : null;
        synchronized (bVar) {
            zI = bVar.i();
            List<Throwable> listL = bVar.l(th2);
            finalRootCause = getFinalRootCause(bVar, listL);
            if (finalRootCause != null) {
                addSuppressedExceptions(finalRootCause, listL);
            }
        }
        if (finalRootCause != null && finalRootCause != th2) {
            obj = new b0(finalRootCause, false, 2, null);
        }
        if (finalRootCause != null && (cancelParent(finalRootCause) || handleJobException(finalRootCause))) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((b0) obj).c();
        }
        if (!zI) {
            onCancelling(finalRootCause);
        }
        onCompletionInternal(obj);
        o.a(_state$volatile$FU, this, bVar, x1.g(obj));
        completeStateFinalization(bVar, obj);
        return obj;
    }

    private final u firstChild(l1 l1Var) {
        u uVar = l1Var instanceof u ? (u) l1Var : null;
        if (uVar != null) {
            return uVar;
        }
        b2 b2VarB = l1Var.b();
        if (b2VarB != null) {
            return nextChild(b2VarB);
        }
        return null;
    }

    private final Throwable getExceptionOrNull(Object obj) {
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        if (b0Var != null) {
            return b0Var.f69208a;
        }
        return null;
    }

    private final Throwable getFinalRootCause(b bVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.i()) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        List<? extends Throwable> list2 = list;
        Iterator<T> it = list2.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(!(((Throwable) next) instanceof CancellationException)));
        Throwable th2 = (Throwable) next;
        if (th2 != null) {
            return th2;
        }
        Throwable th3 = list.get(0);
        if (th3 instanceof TimeoutCancellationException) {
            for (Object obj2 : list2) {
                Throwable th4 = (Throwable) obj2;
                if (th4 != th3 && (th4 instanceof TimeoutCancellationException)) {
                    obj = obj2;
                    break;
                }
            }
            Throwable th5 = (Throwable) obj;
            if (th5 != null) {
                return th5;
            }
        }
        return th3;
    }

    public static /* synthetic */ void getOnAwaitInternal$annotations() {
    }

    public static /* synthetic */ void getOnJoin$annotations() {
    }

    private final b2 getOrPromoteCancellingList(l1 l1Var) {
        b2 b2VarB = l1Var.b();
        if (b2VarB != null) {
            return b2VarB;
        }
        if (l1Var instanceof b1) {
            return new b2();
        }
        if (l1Var instanceof w1) {
            promoteSingleToNodeList((w1) l1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + l1Var).toString());
    }

    private final /* synthetic */ Object get_parentHandle$volatile() {
        return this._parentHandle$volatile;
    }

    private final /* synthetic */ Object get_state$volatile() {
        return this._state$volatile;
    }

    private final boolean isCancelling(l1 l1Var) {
        return (l1Var instanceof b) && ((b) l1Var).i();
    }

    private final boolean joinInternal() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof l1)) {
                return false;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object joinSuspend(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        q.a(cancellableContinuationImpl, invokeOnCompletion(new h2(cancellableContinuationImpl)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final Void loopOnState(Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(getState$kotlinx_coroutines_core());
        }
    }

    private final Object makeCancelling(Object obj) throws Throwable {
        Throwable thCreateCauseException = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof b) {
                synchronized (state$kotlinx_coroutines_core) {
                    if (((b) state$kotlinx_coroutines_core).k()) {
                        return x1.f69619d;
                    }
                    boolean zI = ((b) state$kotlinx_coroutines_core).i();
                    if (obj != null || !zI) {
                        if (thCreateCauseException == null) {
                            thCreateCauseException = createCauseException(obj);
                        }
                        ((b) state$kotlinx_coroutines_core).a(thCreateCauseException);
                    }
                    Throwable thE = zI ^ true ? ((b) state$kotlinx_coroutines_core).e() : null;
                    if (thE != null) {
                        notifyCancelling(((b) state$kotlinx_coroutines_core).b(), thE);
                    }
                    return x1.f69616a;
                }
            }
            if (!(state$kotlinx_coroutines_core instanceof l1)) {
                return x1.f69619d;
            }
            if (thCreateCauseException == null) {
                thCreateCauseException = createCauseException(obj);
            }
            l1 l1Var = (l1) state$kotlinx_coroutines_core;
            if (!l1Var.isActive()) {
                Object objTryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new b0(thCreateCauseException, false, 2, null));
                if (objTryMakeCompleting == x1.f69616a) {
                    throw new IllegalStateException(("Cannot happen in " + state$kotlinx_coroutines_core).toString());
                }
                if (objTryMakeCompleting != x1.f69618c) {
                    return objTryMakeCompleting;
                }
            } else if (tryMakeCancelling(l1Var, thCreateCauseException)) {
                return x1.f69616a;
            }
        }
    }

    private final w1 makeNode(Function1<? super Throwable, Unit> function1, boolean z11) {
        w1 p1Var;
        if (z11) {
            p1Var = function1 instanceof r1 ? (r1) function1 : null;
            if (p1Var == null) {
                p1Var = new o1(function1);
            }
        } else {
            p1Var = function1 instanceof w1 ? (w1) function1 : null;
            if (p1Var == null) {
                p1Var = new p1(function1);
            }
        }
        p1Var.v(this);
        return p1Var;
    }

    private final u nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.o()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.k();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.j();
            if (!lockFreeLinkedListNode.o()) {
                if (lockFreeLinkedListNode instanceof u) {
                    return (u) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof b2) {
                    return null;
                }
            }
        }
    }

    private final void notifyCancelling(b2 b2Var, Throwable th2) throws Throwable {
        onCancelling(th2);
        Object objI = b2Var.i();
        Intrinsics.e(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeJ = (LockFreeLinkedListNode) objI; !Intrinsics.b(lockFreeLinkedListNodeJ, b2Var); lockFreeLinkedListNodeJ = lockFreeLinkedListNodeJ.j()) {
            if (lockFreeLinkedListNodeJ instanceof r1) {
                w1 w1Var = (w1) lockFreeLinkedListNodeJ;
                try {
                    w1Var.t(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        v10.b.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + w1Var + " for " + this, th3);
                        Unit unit = Unit.f68710a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
        cancelParent(th2);
    }

    private final void notifyCompletion(b2 b2Var, Throwable th2) throws Throwable {
        Object objI = b2Var.i();
        Intrinsics.e(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeJ = (LockFreeLinkedListNode) objI; !Intrinsics.b(lockFreeLinkedListNodeJ, b2Var); lockFreeLinkedListNodeJ = lockFreeLinkedListNodeJ.j()) {
            if (lockFreeLinkedListNodeJ instanceof w1) {
                w1 w1Var = (w1) lockFreeLinkedListNodeJ;
                try {
                    w1Var.t(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        v10.b.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + w1Var + " for " + this, th3);
                        Unit unit = Unit.f68710a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
    }

    private final /* synthetic */ <T extends w1> void notifyHandlers(b2 b2Var, Throwable th2) throws Throwable {
        Object objI = b2Var.i();
        Intrinsics.e(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeJ = (LockFreeLinkedListNode) objI; !Intrinsics.b(lockFreeLinkedListNodeJ, b2Var); lockFreeLinkedListNodeJ = lockFreeLinkedListNodeJ.j()) {
            Intrinsics.m(3, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
            if (lockFreeLinkedListNodeJ instanceof LockFreeLinkedListNode) {
                w1 w1Var = (w1) lockFreeLinkedListNodeJ;
                try {
                    w1Var.t(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        v10.b.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + w1Var + " for " + this, th3);
                        Unit unit = Unit.f68710a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onAwaitInternalProcessResFunc(Object obj, Object obj2) throws Throwable {
        if (obj2 instanceof b0) {
            throw ((b0) obj2).f69208a;
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAwaitInternalRegFunc(kotlinx.coroutines.selects.g<?> gVar, Object obj) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof l1)) {
                if (!(state$kotlinx_coroutines_core instanceof b0)) {
                    state$kotlinx_coroutines_core = x1.h(state$kotlinx_coroutines_core);
                }
                gVar.a(state$kotlinx_coroutines_core);
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        gVar.b(invokeOnCompletion(new c(gVar)));
    }

    private final void promoteEmptyToNodeList(b1 b1Var) {
        b2 b2Var = new b2();
        Object k1Var = b2Var;
        if (!b1Var.isActive()) {
            k1Var = new k1(b2Var);
        }
        o.a(_state$volatile$FU, this, b1Var, k1Var);
    }

    private final void promoteSingleToNodeList(w1 w1Var) {
        w1Var.e(new b2());
        o.a(_state$volatile$FU, this, w1Var, w1Var.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForOnJoin(kotlinx.coroutines.selects.g<?> gVar, Object obj) {
        if (joinInternal()) {
            gVar.b(invokeOnCompletion(new d(gVar)));
        } else {
            gVar.a(Unit.f68710a);
        }
    }

    private final /* synthetic */ void set_parentHandle$volatile(Object obj) {
        this._parentHandle$volatile = obj;
    }

    private final /* synthetic */ void set_state$volatile(Object obj) {
        this._state$volatile = obj;
    }

    private final int startInternal(Object obj) {
        if (obj instanceof b1) {
            if (((b1) obj).isActive()) {
                return 0;
            }
            if (!o.a(_state$volatile$FU, this, obj, x1.f69622g)) {
                return -1;
            }
            onStart();
            return 1;
        }
        if (!(obj instanceof k1)) {
            return 0;
        }
        if (!o.a(_state$volatile$FU, this, obj, ((k1) obj).b())) {
            return -1;
        }
        onStart();
        return 1;
    }

    private final String stateString(Object obj) {
        if (!(obj instanceof b)) {
            if (obj instanceof l1) {
                return ((l1) obj).isActive() ? "Active" : "New";
            }
            return obj instanceof b0 ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        if (bVar.i()) {
            return "Cancelling";
        }
        return bVar.j() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th2, String str, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i11 & 1) != 0) {
            str = null;
        }
        return jobSupport.toCancellationException(th2, str);
    }

    private final boolean tryFinalizeSimpleState(l1 l1Var, Object obj) throws Throwable {
        if (!o.a(_state$volatile$FU, this, l1Var, x1.g(obj))) {
            return false;
        }
        onCancelling(null);
        onCompletionInternal(obj);
        completeStateFinalization(l1Var, obj);
        return true;
    }

    private final boolean tryMakeCancelling(l1 l1Var, Throwable th2) throws Throwable {
        b2 orPromoteCancellingList = getOrPromoteCancellingList(l1Var);
        if (orPromoteCancellingList == null) {
            return false;
        }
        if (!o.a(_state$volatile$FU, this, l1Var, new b(orPromoteCancellingList, false, th2))) {
            return false;
        }
        notifyCancelling(orPromoteCancellingList, th2);
        return true;
    }

    private final Object tryMakeCompleting(Object obj, Object obj2) {
        if (!(obj instanceof l1)) {
            return x1.f69616a;
        }
        if ((!(obj instanceof b1) && !(obj instanceof w1)) || (obj instanceof u) || (obj2 instanceof b0)) {
            return tryMakeCompletingSlowPath((l1) obj, obj2);
        }
        return tryFinalizeSimpleState((l1) obj, obj2) ? obj2 : x1.f69618c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object tryMakeCompletingSlowPath(l1 l1Var, Object obj) throws Throwable {
        b2 orPromoteCancellingList = getOrPromoteCancellingList(l1Var);
        if (orPromoteCancellingList == null) {
            return x1.f69618c;
        }
        b bVar = l1Var instanceof b ? (b) l1Var : null;
        if (bVar == null) {
            bVar = new b(orPromoteCancellingList, false, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (bVar) {
            if (bVar.j()) {
                return x1.f69616a;
            }
            bVar.m(true);
            if (bVar != l1Var && !o.a(_state$volatile$FU, this, l1Var, bVar)) {
                return x1.f69618c;
            }
            boolean zI = bVar.i();
            b0 b0Var = obj instanceof b0 ? (b0) obj : null;
            if (b0Var != null) {
                bVar.a(b0Var.f69208a);
            }
            ?? E = Boolean.valueOf(true ^ zI).booleanValue() ? bVar.e() : 0;
            objectRef.element = E;
            Unit unit = Unit.f68710a;
            if (E != 0) {
                notifyCancelling(orPromoteCancellingList, E);
            }
            u uVarFirstChild = firstChild(l1Var);
            return (uVarFirstChild == null || !tryWaitForChild(bVar, uVarFirstChild, obj)) ? finalizeFinishingState(bVar, obj) : x1.f69617b;
        }
    }

    private final boolean tryWaitForChild(b bVar, u uVar, Object obj) {
        while (q1.a.e(uVar.f69608f, false, false, new a(this, bVar, uVar, obj), 1, null) == d2.f69264a) {
            uVar = nextChild(uVar);
            if (uVar == null) {
                return false;
            }
        }
        return true;
    }

    public void afterCompletion(Object obj) {
    }

    @Override // kotlinx.coroutines.q1
    public final t attachChild(v vVar) {
        y0 y0VarE = q1.a.e(this, true, false, new u(vVar), 2, null);
        Intrinsics.e(y0VarE, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (t) y0VarE;
    }

    public final Object awaitInternal(Continuation<Object> continuation) throws Throwable {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof l1)) {
                if (state$kotlinx_coroutines_core instanceof b0) {
                    throw ((b0) state$kotlinx_coroutines_core).f69208a;
                }
                return x1.h(state$kotlinx_coroutines_core);
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return awaitSuspend(continuation);
    }

    @Deprecated
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    @Override // kotlinx.coroutines.q1
    public void cancel(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Deprecated
    public /* synthetic */ boolean cancel(Throwable th2) throws Throwable {
        Throwable jobCancellationException;
        if (th2 == null || (jobCancellationException = toCancellationException$default(this, th2, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(jobCancellationException);
        return true;
    }

    public final boolean cancelCoroutine(Throwable th2) {
        return cancelImpl$kotlinx_coroutines_core(th2);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object obj) throws Throwable {
        Object objMakeCancelling = x1.f69616a;
        if (getOnCancelComplete$kotlinx_coroutines_core() && (objMakeCancelling = cancelMakeCompleting(obj)) == x1.f69617b) {
            return true;
        }
        if (objMakeCancelling == x1.f69616a) {
            objMakeCancelling = makeCancelling(obj);
        }
        if (objMakeCancelling == x1.f69616a || objMakeCancelling == x1.f69617b) {
            return true;
        }
        if (objMakeCancelling == x1.f69619d) {
            return false;
        }
        afterCompletion(objMakeCancelling);
        return true;
    }

    public void cancelInternal(Throwable th2) throws Throwable {
        cancelImpl$kotlinx_coroutines_core(th2);
    }

    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th2) && getHandlesException$kotlinx_coroutines_core();
    }

    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(String str, Throwable th2) {
        if (str == null) {
            str = cancellationExceptionMessage();
        }
        return new JobCancellationException(str, th2, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r11, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) q1.a.c(this, r11, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) q1.a.d(this, key);
    }

    @Override // kotlinx.coroutines.q1
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof b)) {
            if (state$kotlinx_coroutines_core instanceof l1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (state$kotlinx_coroutines_core instanceof b0) {
                return toCancellationException$default(this, ((b0) state$kotlinx_coroutines_core).f69208a, null, 1, null);
            }
            return new JobCancellationException(m0.a(this) + " has completed normally", null, this);
        }
        Throwable thE = ((b) state$kotlinx_coroutines_core).e();
        if (thE != null) {
            CancellationException cancellationException = toCancellationException(thE, m0.a(this) + " is cancelling");
            if (cancellationException != null) {
                return cancellationException;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // kotlinx.coroutines.f2
    public CancellationException getChildJobCancellationCause() {
        Throwable thE;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b) {
            thE = ((b) state$kotlinx_coroutines_core).e();
        } else if (state$kotlinx_coroutines_core instanceof b0) {
            thE = ((b0) state$kotlinx_coroutines_core).f69208a;
        } else {
            if (state$kotlinx_coroutines_core instanceof l1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + stateString(state$kotlinx_coroutines_core), thE, this);
    }

    @Override // kotlinx.coroutines.q1
    public final Sequence<q1> getChildren() {
        return SequencesKt__SequenceBuilderKt.b(new JobSupport$children$1(this, null));
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() throws Throwable {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof l1))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (state$kotlinx_coroutines_core instanceof b0) {
            throw ((b0) state$kotlinx_coroutines_core).f69208a;
        }
        return x1.h(state$kotlinx_coroutines_core);
    }

    public final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b) {
            Throwable thE = ((b) state$kotlinx_coroutines_core).e();
            if (thE != null) {
                return thE;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(state$kotlinx_coroutines_core instanceof l1)) {
            if (state$kotlinx_coroutines_core instanceof b0) {
                return ((b0) state$kotlinx_coroutines_core).f69208a;
            }
            return null;
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final boolean getCompletionCauseHandled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof b0) && ((b0) state$kotlinx_coroutines_core).a();
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof l1)) {
            return getExceptionOrNull(state$kotlinx_coroutines_core);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return q1.f69514j8;
    }

    public final kotlinx.coroutines.selects.d<?> getOnAwaitInternal() {
        JobSupport$onAwaitInternal$1 jobSupport$onAwaitInternal$1 = JobSupport$onAwaitInternal$1.INSTANCE;
        Intrinsics.e(jobSupport$onAwaitInternal$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.e(jobSupport$onAwaitInternal$1, 3);
        JobSupport$onAwaitInternal$2 jobSupport$onAwaitInternal$2 = JobSupport$onAwaitInternal$2.INSTANCE;
        Intrinsics.e(jobSupport$onAwaitInternal$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.e(this, function3, (Function3) TypeIntrinsics.e(jobSupport$onAwaitInternal$2, 3), null, 8, null);
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    public final kotlinx.coroutines.selects.b getOnJoin() {
        JobSupport$onJoin$1 jobSupport$onJoin$1 = JobSupport$onJoin$1.INSTANCE;
        Intrinsics.e(jobSupport$onJoin$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.c(this, (Function3) TypeIntrinsics.e(jobSupport$onJoin$1, 3), null, 4, null);
    }

    @Override // kotlinx.coroutines.q1
    public q1 getParent() {
        t parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            return parentHandle$kotlinx_coroutines_core.getParent();
        }
        return null;
    }

    public final t getParentHandle$kotlinx_coroutines_core() {
        return (t) _parentHandle$volatile$FU.get(this);
    }

    public final Object getState$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof kotlinx.coroutines.internal.v)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.v) obj).a(this);
        }
    }

    public boolean handleJobException(Throwable th2) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable th2) throws Throwable {
        throw th2;
    }

    public final void initParentJob(q1 q1Var) {
        if (q1Var == null) {
            setParentHandle$kotlinx_coroutines_core(d2.f69264a);
            return;
        }
        q1Var.start();
        t tVarAttachChild = q1Var.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(tVarAttachChild);
        if (isCompleted()) {
            tVarAttachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(d2.f69264a);
        }
    }

    @Override // kotlinx.coroutines.q1
    public final y0 invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        return invokeOnCompletion(false, true, function1);
    }

    @Override // kotlinx.coroutines.q1
    public final y0 invokeOnCompletion(boolean z11, boolean z12, Function1<? super Throwable, Unit> function1) {
        w1 w1VarMakeNode = makeNode(function1, z11);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof b1) {
                b1 b1Var = (b1) state$kotlinx_coroutines_core;
                if (!b1Var.isActive()) {
                    promoteEmptyToNodeList(b1Var);
                } else if (o.a(_state$volatile$FU, this, state$kotlinx_coroutines_core, w1VarMakeNode)) {
                    return w1VarMakeNode;
                }
            } else {
                Throwable thE = null;
                if (!(state$kotlinx_coroutines_core instanceof l1)) {
                    if (z12) {
                        b0 b0Var = state$kotlinx_coroutines_core instanceof b0 ? (b0) state$kotlinx_coroutines_core : null;
                        function1.invoke(b0Var != null ? b0Var.f69208a : null);
                    }
                    return d2.f69264a;
                }
                b2 b2VarB = ((l1) state$kotlinx_coroutines_core).b();
                if (b2VarB == null) {
                    Intrinsics.e(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    promoteSingleToNodeList((w1) state$kotlinx_coroutines_core);
                } else {
                    y0 y0Var = d2.f69264a;
                    if (z11 && (state$kotlinx_coroutines_core instanceof b)) {
                        synchronized (state$kotlinx_coroutines_core) {
                            try {
                                thE = ((b) state$kotlinx_coroutines_core).e();
                                if (thE == null || ((function1 instanceof u) && !((b) state$kotlinx_coroutines_core).j())) {
                                    if (addLastAtomic(state$kotlinx_coroutines_core, b2VarB, w1VarMakeNode)) {
                                        if (thE == null) {
                                            return w1VarMakeNode;
                                        }
                                        y0Var = w1VarMakeNode;
                                    }
                                }
                                Unit unit = Unit.f68710a;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                    if (thE != null) {
                        if (z12) {
                            function1.invoke(thE);
                        }
                        return y0Var;
                    }
                    if (addLastAtomic(state$kotlinx_coroutines_core, b2VarB, w1VarMakeNode)) {
                        return w1VarMakeNode;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.q1
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof l1) && ((l1) state$kotlinx_coroutines_core).isActive();
    }

    @Override // kotlinx.coroutines.q1
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof b0) || ((state$kotlinx_coroutines_core instanceof b) && ((b) state$kotlinx_coroutines_core).i());
    }

    @Override // kotlinx.coroutines.q1
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof l1);
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof b0;
    }

    public boolean isScopedCoroutine() {
        return false;
    }

    @Override // kotlinx.coroutines.q1
    public final Object join(Continuation<? super Unit> continuation) {
        if (joinInternal()) {
            Object objJoinSuspend = joinSuspend(continuation);
            return objJoinSuspend == kotlin.coroutines.intrinsics.a.e() ? objJoinSuspend : Unit.f68710a;
        }
        t1.j(continuation.getContext());
        return Unit.f68710a;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object obj) {
        Object objTryMakeCompleting;
        do {
            objTryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (objTryMakeCompleting == x1.f69616a) {
                return false;
            }
            if (objTryMakeCompleting == x1.f69617b) {
                return true;
            }
        } while (objTryMakeCompleting == x1.f69618c);
        afterCompletion(objTryMakeCompleting);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object obj) {
        Object objTryMakeCompleting;
        do {
            objTryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (objTryMakeCompleting == x1.f69616a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, getExceptionOrNull(obj));
            }
        } while (objTryMakeCompleting == x1.f69618c);
        return objTryMakeCompleting;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return q1.a.f(this, key);
    }

    public String nameString$kotlinx_coroutines_core() {
        return m0.a(this);
    }

    public void onCancelling(Throwable th2) {
    }

    public void onCompletionInternal(Object obj) {
    }

    public void onStart() {
    }

    @Override // kotlinx.coroutines.v
    public final void parentCancelled(f2 f2Var) throws Throwable {
        cancelImpl$kotlinx_coroutines_core(f2Var);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return q1.a.g(this, coroutineContext);
    }

    @Deprecated
    public q1 plus(q1 q1Var) {
        return q1.a.h(this, q1Var);
    }

    public final void removeNode$kotlinx_coroutines_core(w1 w1Var) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof w1)) {
                if (!(state$kotlinx_coroutines_core instanceof l1) || ((l1) state$kotlinx_coroutines_core).b() == null) {
                    return;
                }
                w1Var.p();
                return;
            }
            if (state$kotlinx_coroutines_core != w1Var) {
                return;
            }
        } while (!o.a(_state$volatile$FU, this, state$kotlinx_coroutines_core, x1.f69622g));
    }

    public final void setParentHandle$kotlinx_coroutines_core(t tVar) {
        _parentHandle$volatile$FU.set(this, tVar);
    }

    @Override // kotlinx.coroutines.q1
    public final boolean start() {
        int iStartInternal;
        do {
            iStartInternal = startInternal(getState$kotlinx_coroutines_core());
            if (iStartInternal == 0) {
                return false;
            }
        } while (iStartInternal != 1);
        return true;
    }

    public final CancellationException toCancellationException(Throwable th2, String str) {
        CancellationException jobCancellationException = th2 instanceof CancellationException ? (CancellationException) th2 : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            jobCancellationException = new JobCancellationException(str, th2, this);
        }
        return jobCancellationException;
    }

    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}';
    }

    public String toString() {
        return toDebugString() + '@' + m0.b(this);
    }
}
