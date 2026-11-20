package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@Metadata
@SourceDebugExtension
public abstract class EventLoopImplBase extends d1 implements q0 {
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _queue$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _delayed$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _isCompleted$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, "_isCompleted$volatile");

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class DelayedResumeTask extends DelayedTask {
        private final n<Unit> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public DelayedResumeTask(long j11, n<? super Unit> nVar) {
            super(j11);
            this.cont = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, Unit.f68710a);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;

        public DelayedRunnableTask(long j11, Runnable runnable) {
            super(j11);
            this.block = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.block;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, y0, kotlinx.coroutines.internal.k0 {
        private volatile Object _heap;
        private int index = -1;

        @JvmField
        public long nanoTime;

        public DelayedTask(long j11) {
            this.nanoTime = j11;
        }

        @Override // java.lang.Comparable
        public int compareTo(DelayedTask delayedTask) {
            long j11 = this.nanoTime - delayedTask.nanoTime;
            if (j11 > 0) {
                return 1;
            }
            return j11 < 0 ? -1 : 0;
        }

        @Override // kotlinx.coroutines.y0
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == f1.f69322a) {
                        return;
                    }
                    a aVar = obj instanceof a ? (a) obj : null;
                    if (aVar != null) {
                        aVar.h(this);
                    }
                    this._heap = f1.f69322a;
                    Unit unit = Unit.f68710a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.k0
        public kotlinx.coroutines.internal.j0<?> getHeap() {
            Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.j0) {
                return (kotlinx.coroutines.internal.j0) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.k0
        public int getIndex() {
            return this.index;
        }

        public final int scheduleTask(long j11, a aVar, EventLoopImplBase eventLoopImplBase) {
            synchronized (this) {
                if (this._heap == f1.f69322a) {
                    return 2;
                }
                synchronized (aVar) {
                    try {
                        DelayedTask delayedTaskB = aVar.b();
                        if (eventLoopImplBase.isCompleted()) {
                            return 1;
                        }
                        if (delayedTaskB == null) {
                            aVar.f69177c = j11;
                        } else {
                            long j12 = delayedTaskB.nanoTime;
                            if (j12 - j11 < 0) {
                                j11 = j12;
                            }
                            if (j11 - aVar.f69177c > 0) {
                                aVar.f69177c = j11;
                            }
                        }
                        long j13 = this.nanoTime;
                        long j14 = aVar.f69177c;
                        if (j13 - j14 < 0) {
                            this.nanoTime = j14;
                        }
                        aVar.a(this);
                        return 0;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        @Override // kotlinx.coroutines.internal.k0
        public void setHeap(kotlinx.coroutines.internal.j0<?> j0Var) {
            if (this._heap == f1.f69322a) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = j0Var;
        }

        @Override // kotlinx.coroutines.internal.k0
        public void setIndex(int i11) {
            this.index = i11;
        }

        public final boolean timeToExecute(long j11) {
            return j11 - this.nanoTime >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a extends kotlinx.coroutines.internal.j0<DelayedTask> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public long f69177c;

        public a(long j11) {
            this.f69177c = j11;
        }
    }

    private final void closeQueue() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (o.a(_queue$volatile$FU, this, null, f1.f69323b)) {
                    return;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.q) {
                ((kotlinx.coroutines.internal.q) obj).d();
                return;
            } else {
                if (obj == f1.f69323b) {
                    return;
                }
                kotlinx.coroutines.internal.q qVar = new kotlinx.coroutines.internal.q(8, true);
                Intrinsics.e(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                qVar.a((Runnable) obj);
                if (o.a(_queue$volatile$FU, this, obj, qVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable dequeue() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.q) {
                Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.q qVar = (kotlinx.coroutines.internal.q) obj;
                Object objM = qVar.m();
                if (objM != kotlinx.coroutines.internal.q.f69483h) {
                    return (Runnable) objM;
                }
                o.a(_queue$volatile$FU, this, obj, qVar.l());
            } else {
                if (obj == f1.f69323b) {
                    return null;
                }
                if (o.a(_queue$volatile$FU, this, obj, null)) {
                    Intrinsics.e(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean enqueueImpl(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (o.a(_queue$volatile$FU, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.q) {
                Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.q qVar = (kotlinx.coroutines.internal.q) obj;
                int iA = qVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    o.a(_queue$volatile$FU, this, obj, qVar.l());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == f1.f69323b) {
                    return false;
                }
                kotlinx.coroutines.internal.q qVar2 = new kotlinx.coroutines.internal.q(8, true);
                Intrinsics.e(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                qVar2.a((Runnable) obj);
                qVar2.a(runnable);
                if (o.a(_queue$volatile$FU, this, obj, qVar2)) {
                    return true;
                }
            }
        }
    }

    private final /* synthetic */ Object get_delayed$volatile() {
        return this._delayed$volatile;
    }

    private final /* synthetic */ int get_isCompleted$volatile() {
        return this._isCompleted$volatile;
    }

    private final /* synthetic */ Object get_queue$volatile() {
        return this._queue$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        return _isCompleted$volatile$FU.get(this) != 0;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final void rescheduleAllDelayed() {
        DelayedTask delayedTaskJ;
        c.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            a aVar = (a) _delayed$volatile$FU.get(this);
            if (aVar == null || (delayedTaskJ = aVar.j()) == null) {
                return;
            } else {
                reschedule(jNanoTime, delayedTaskJ);
            }
        }
    }

    private final int scheduleImpl(long j11, DelayedTask delayedTask) {
        if (isCompleted()) {
            return 1;
        }
        a aVar = (a) _delayed$volatile$FU.get(this);
        if (aVar == null) {
            o.a(_delayed$volatile$FU, this, null, new a(j11));
            Object obj = _delayed$volatile$FU.get(this);
            Intrinsics.d(obj);
            aVar = (a) obj;
        }
        return delayedTask.scheduleTask(j11, aVar, this);
    }

    private final void setCompleted(boolean z11) {
        _isCompleted$volatile$FU.set(this, z11 ? 1 : 0);
    }

    private final /* synthetic */ void set_delayed$volatile(Object obj) {
        this._delayed$volatile = obj;
    }

    private final /* synthetic */ void set_isCompleted$volatile(int i11) {
        this._isCompleted$volatile = i11;
    }

    private final /* synthetic */ void set_queue$volatile(Object obj) {
        this._queue$volatile = obj;
    }

    private final boolean shouldUnpark(DelayedTask delayedTask) {
        a aVar = (a) _delayed$volatile$FU.get(this);
        return (aVar != null ? aVar.f() : null) == delayedTask;
    }

    @Deprecated
    public Object delay(long j11, Continuation<? super Unit> continuation) {
        return q0.a.a(this, j11, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueue(Runnable runnable) {
        if (enqueueImpl(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    @Override // kotlinx.coroutines.c1
    public long getNextTime() {
        DelayedTask delayedTaskF;
        if (super.getNextTime() == 0) {
            return 0L;
        }
        Object obj = _queue$volatile$FU.get(this);
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.q)) {
                return obj == f1.f69323b ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.q) obj).j()) {
                return 0L;
            }
        }
        a aVar = (a) _delayed$volatile$FU.get(this);
        if (aVar == null || (delayedTaskF = aVar.f()) == null) {
            return Long.MAX_VALUE;
        }
        long j11 = delayedTaskF.nanoTime;
        c.a();
        return kotlin.ranges.a.e(j11 - System.nanoTime(), 0L);
    }

    public y0 invokeOnTimeout(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        return q0.a.b(this, j11, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.c1
    public boolean isEmpty() {
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        a aVar = (a) _delayed$volatile$FU.get(this);
        if (aVar != null && !aVar.e()) {
            return false;
        }
        Object obj = _queue$volatile$FU.get(this);
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.q) {
                return ((kotlinx.coroutines.internal.q) obj).j();
            }
            if (obj != f1.f69323b) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.c1
    public long processNextEvent() {
        DelayedTask delayedTaskI;
        if (processUnconfinedEvent()) {
            return 0L;
        }
        a aVar = (a) _delayed$volatile$FU.get(this);
        if (aVar != null && !aVar.e()) {
            c.a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (aVar) {
                    DelayedTask delayedTaskB = aVar.b();
                    delayedTaskI = null;
                    if (delayedTaskB != null) {
                        DelayedTask delayedTask = delayedTaskB;
                        if (delayedTask.timeToExecute(jNanoTime) && enqueueImpl(delayedTask)) {
                            delayedTaskI = aVar.i(0);
                        }
                    }
                }
            } while (delayedTaskI != null);
        }
        Runnable runnableDequeue = dequeue();
        if (runnableDequeue == null) {
            return getNextTime();
        }
        runnableDequeue.run();
        return 0L;
    }

    public final void resetAll() {
        _queue$volatile$FU.set(this, null);
        _delayed$volatile$FU.set(this, null);
    }

    public final void schedule(long j11, DelayedTask delayedTask) {
        int iScheduleImpl = scheduleImpl(j11, delayedTask);
        if (iScheduleImpl == 0) {
            if (shouldUnpark(delayedTask)) {
                unpark();
            }
        } else if (iScheduleImpl == 1) {
            reschedule(j11, delayedTask);
        } else if (iScheduleImpl != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final y0 scheduleInvokeOnTimeout(long j11, Runnable runnable) {
        long jC = f1.c(j11);
        if (jC >= 4611686018427387903L) {
            return d2.f69264a;
        }
        c.a();
        long jNanoTime = System.nanoTime();
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(jC + jNanoTime, runnable);
        schedule(jNanoTime, delayedRunnableTask);
        return delayedRunnableTask;
    }

    @Override // kotlinx.coroutines.q0
    public void scheduleResumeAfterDelay(long j11, n<? super Unit> nVar) {
        long jC = f1.c(j11);
        if (jC < 4611686018427387903L) {
            c.a();
            long jNanoTime = System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(jC + jNanoTime, nVar);
            schedule(jNanoTime, delayedResumeTask);
            q.a(nVar, delayedResumeTask);
        }
    }

    @Override // kotlinx.coroutines.c1
    public void shutdown() {
        o2.f69509a.c();
        setCompleted(true);
        closeQueue();
        while (processNextEvent() <= 0) {
        }
        rescheduleAllDelayed();
    }
}
