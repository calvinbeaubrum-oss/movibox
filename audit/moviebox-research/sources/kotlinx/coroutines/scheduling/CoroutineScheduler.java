package kotlinx.coroutines.scheduling;

import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.m0;

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
public final class CoroutineScheduler implements Executor, Closeable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f69521i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f69522j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f69523k = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f69524l = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @JvmField
    public static final c0 f69525m = new c0("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final int f69526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final int f69527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final long f69528c;
    private volatile /* synthetic */ long controlState$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public final String f69529d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public final c f69530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public final c f69531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public final x<Worker> f69532h;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class Worker extends Thread {
        private static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        private volatile int indexInArray;

        @JvmField
        public final k localQueue;

        @JvmField
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;

        @JvmField
        public WorkerState state;
        private final Ref.ObjectRef<Task> stolenTask;
        private long terminationDeadline;
        private volatile /* synthetic */ int workerCtl$volatile;

        private Worker() {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            this.localQueue = new k();
            this.stolenTask = new Ref.ObjectRef<>();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f69525m;
            this.rngState = Random.Default.nextInt();
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i11) {
            this();
            setIndexInArray(i11);
        }

        private final void afterTask(int i11) {
            if (i11 == 0) {
                return;
            }
            CoroutineScheduler.i().addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.state != WorkerState.TERMINATED) {
                this.state = WorkerState.DORMANT;
            }
        }

        private final void beforeTask(int i11) {
            if (i11 != 0 && tryReleaseCpu(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.u();
            }
        }

        private final void executeTask(Task task) {
            int iB = task.taskContext.b();
            idleReset(iB);
            beforeTask(iB);
            CoroutineScheduler.this.q(task);
            afterTask(iB);
        }

        private final Task findAnyTask(boolean z11) {
            Task taskPollGlobalQueues;
            Task taskPollGlobalQueues2;
            if (z11) {
                boolean z12 = nextInt(CoroutineScheduler.this.f69526a * 2) == 0;
                if (z12 && (taskPollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues2;
                }
                Task taskK = this.localQueue.k();
                if (taskK != null) {
                    return taskK;
                }
                if (!z12 && (taskPollGlobalQueues = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues;
                }
            } else {
                Task taskPollGlobalQueues3 = pollGlobalQueues();
                if (taskPollGlobalQueues3 != null) {
                    return taskPollGlobalQueues3;
                }
            }
            return trySteal(3);
        }

        private final Task findBlockingTask() {
            Task taskL = this.localQueue.l();
            if (taskL != null) {
                return taskL;
            }
            Task taskE = CoroutineScheduler.this.f69531g.e();
            return taskE == null ? trySteal(1) : taskE;
        }

        private final Task findCpuTask() {
            Task taskN = this.localQueue.n();
            if (taskN != null) {
                return taskN;
            }
            Task taskE = CoroutineScheduler.this.f69531g.e();
            return taskE == null ? trySteal(2) : taskE;
        }

        private final /* synthetic */ int getWorkerCtl$volatile() {
            return this.workerCtl$volatile;
        }

        private final void idleReset(int i11) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                this.state = WorkerState.BLOCKING;
            }
        }

        private final boolean inStack() {
            return this.nextParkedWorker != CoroutineScheduler.f69525m;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.f69528c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f69528c);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                tryTerminateWorker();
            }
        }

        private final Task pollGlobalQueues() {
            if (nextInt(2) == 0) {
                Task taskE = CoroutineScheduler.this.f69530f.e();
                return taskE != null ? taskE : CoroutineScheduler.this.f69531g.e();
            }
            Task taskE2 = CoroutineScheduler.this.f69531g.e();
            return taskE2 != null ? taskE2 : CoroutineScheduler.this.f69530f.e();
        }

        private final void runWorker() {
            loop0: while (true) {
                boolean z11 = false;
                while (true) {
                    if (CoroutineScheduler.this.isTerminated() || this.state == WorkerState.TERMINATED) {
                        break loop0;
                    }
                    Task taskFindTask = findTask(this.mayHaveLocalTasks);
                    if (taskFindTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        executeTask(taskFindTask);
                        break;
                    }
                    this.mayHaveLocalTasks = false;
                    if (this.minDelayUntilStealableTaskNs == 0) {
                        tryPark();
                    } else {
                        if (z11) {
                            tryReleaseCpu(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                            break;
                        }
                        z11 = true;
                    }
                }
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        private final /* synthetic */ void setWorkerCtl$volatile(int i11) {
            this.workerCtl$volatile = i11;
        }

        private final boolean tryAcquireCpuPermit() {
            long j11;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater atomicLongFieldUpdaterI = CoroutineScheduler.i();
            do {
                j11 = atomicLongFieldUpdaterI.get(coroutineScheduler);
                if (((int) ((9223367638808264704L & j11) >> 42)) == 0) {
                    return false;
                }
            } while (!CoroutineScheduler.i().compareAndSet(coroutineScheduler, j11, j11 - 4398046511104L));
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.o(this);
                return;
            }
            workerCtl$volatile$FU.set(this, -1);
            while (inStack() && workerCtl$volatile$FU.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final Task trySteal(int i11) {
            int i12 = (int) (CoroutineScheduler.i().get(CoroutineScheduler.this) & 2097151);
            if (i12 < 2) {
                return null;
            }
            int iNextInt = nextInt(i12);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long jMin = Long.MAX_VALUE;
            for (int i13 = 0; i13 < i12; i13++) {
                iNextInt++;
                if (iNextInt > i12) {
                    iNextInt = 1;
                }
                Worker workerB = coroutineScheduler.f69532h.b(iNextInt);
                if (workerB != null && workerB != this) {
                    long jS = workerB.localQueue.s(i11, this.stolenTask);
                    if (jS == -1) {
                        Ref.ObjectRef<Task> objectRef = this.stolenTask;
                        Task task = objectRef.element;
                        objectRef.element = null;
                        return task;
                    }
                    if (jS > 0) {
                        jMin = Math.min(jMin, jS);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.minDelayUntilStealableTaskNs = jMin;
            return null;
        }

        private final void tryTerminateWorker() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f69532h) {
                try {
                    if (coroutineScheduler.isTerminated()) {
                        return;
                    }
                    if (((int) (CoroutineScheduler.i().get(coroutineScheduler) & 2097151)) <= coroutineScheduler.f69526a) {
                        return;
                    }
                    if (workerCtl$volatile$FU.compareAndSet(this, -1, 1)) {
                        int i11 = this.indexInArray;
                        setIndexInArray(0);
                        coroutineScheduler.p(this, i11, 0);
                        int andDecrement = (int) (CoroutineScheduler.i().getAndDecrement(coroutineScheduler) & 2097151);
                        if (andDecrement != i11) {
                            Worker workerB = coroutineScheduler.f69532h.b(andDecrement);
                            Intrinsics.d(workerB);
                            Worker worker = workerB;
                            coroutineScheduler.f69532h.c(i11, worker);
                            worker.setIndexInArray(i11);
                            coroutineScheduler.p(worker, andDecrement, i11);
                        }
                        coroutineScheduler.f69532h.c(andDecrement, null);
                        Unit unit = Unit.f68710a;
                        this.state = WorkerState.TERMINATED;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final Task findTask(boolean z11) {
            return tryAcquireCpuPermit() ? findAnyTask(z11) : findBlockingTask();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final boolean isIo() {
            return this.state == WorkerState.BLOCKING;
        }

        public final int nextInt(int i11) {
            int i12 = this.rngState;
            int i13 = i12 ^ (i12 << 13);
            int i14 = i13 ^ (i13 >> 17);
            int i15 = i14 ^ (i14 << 5);
            this.rngState = i15;
            int i16 = i11 - 1;
            return (i16 & i11) == 0 ? i15 & i16 : (i15 & Api.BaseClientBuilder.API_PRIORITY_OTHER) % i11;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        public final long runSingleTask() {
            boolean z11 = this.state == WorkerState.CPU_ACQUIRED;
            Task taskFindCpuTask = z11 ? findCpuTask() : findBlockingTask();
            if (taskFindCpuTask == null) {
                long j11 = this.minDelayUntilStealableTaskNs;
                if (j11 == 0) {
                    return -1L;
                }
                return j11;
            }
            CoroutineScheduler.this.q(taskFindCpuTask);
            if (!z11) {
                CoroutineScheduler.i().addAndGet(CoroutineScheduler.this, -2097152L);
            }
            return 0L;
        }

        public final void setIndexInArray(int i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CoroutineScheduler.this.f69529d);
            sb2.append("-worker-");
            sb2.append(i11 == 0 ? "TERMINATED" : String.valueOf(i11));
            setName(sb2.toString());
            this.indexInArray = i11;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(WorkerState workerState) {
            WorkerState workerState2 = this.state;
            boolean z11 = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z11) {
                CoroutineScheduler.i().addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.a(values());

        public static EnumEntries<WorkerState> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f69533a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f69533a = iArr;
        }
    }

    public CoroutineScheduler(int i11, int i12, long j11, String str) {
        this.f69526a = i11;
        this.f69527b = i12;
        this.f69528c = j11;
        this.f69529d = str;
        if (i11 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i11 + " should be at least 1").toString());
        }
        if (i12 < i11) {
            throw new IllegalArgumentException(("Max pool size " + i12 + " should be greater than or equals to core pool size " + i11).toString());
        }
        if (i12 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i12 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j11 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j11 + " must be positive").toString());
        }
        this.f69530f = new c();
        this.f69531g = new c();
        this.f69532h = new x<>((i11 + 1) * 2);
        this.controlState$volatile = ((long) i11) << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void h(CoroutineScheduler coroutineScheduler, Runnable runnable, g gVar, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            gVar = i.f69550g;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        coroutineScheduler.g(runnable, gVar, z11);
    }

    public static final /* synthetic */ AtomicLongFieldUpdater i() {
        return f69523k;
    }

    public static /* synthetic */ boolean y(CoroutineScheduler coroutineScheduler, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = f69523k.get(coroutineScheduler);
        }
        return coroutineScheduler.x(j11);
    }

    public final boolean U() {
        Worker workerN;
        do {
            workerN = n();
            if (workerN == null) {
                return false;
            }
        } while (!Worker.workerCtl$volatile$FU.compareAndSet(workerN, -1, 0));
        LockSupport.unpark(workerN);
        return true;
    }

    public final boolean b(Task task) {
        return task.taskContext.b() == 1 ? this.f69531g.a(task) : this.f69530f.a(task);
    }

    public final int c() {
        synchronized (this.f69532h) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long j11 = f69523k.get(this);
                int i11 = (int) (j11 & 2097151);
                int iD = kotlin.ranges.a.d(i11 - ((int) ((j11 & 4398044413952L) >> 21)), 0);
                if (iD >= this.f69526a) {
                    return 0;
                }
                if (i11 >= this.f69527b) {
                    return 0;
                }
                int i12 = ((int) (i().get(this) & 2097151)) + 1;
                if (i12 <= 0 || this.f69532h.b(i12) != null) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                Worker worker = new Worker(this, i12);
                this.f69532h.c(i12, worker);
                if (i12 != ((int) (2097151 & f69523k.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                int i13 = iD + 1;
                worker.start();
                return i13;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        r(10000L);
    }

    public final Task d(Runnable runnable, g gVar) {
        long jA = i.f69549f.a();
        if (!(runnable instanceof Task)) {
            return new TaskImpl(runnable, jA, gVar);
        }
        Task task = (Task) runnable;
        task.submissionTime = jA;
        task.taskContext = gVar;
        return task;
    }

    public final Worker e() {
        Thread threadCurrentThread = Thread.currentThread();
        Worker worker = threadCurrentThread instanceof Worker ? (Worker) threadCurrentThread : null;
        if (worker == null || !Intrinsics.b(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        h(this, runnable, null, false, 6, null);
    }

    public final void g(Runnable runnable, g gVar, boolean z11) {
        kotlinx.coroutines.c.a();
        Task taskD = d(runnable, gVar);
        boolean z12 = false;
        boolean z13 = taskD.taskContext.b() == 1;
        long jAddAndGet = z13 ? f69523k.addAndGet(this, 2097152L) : 0L;
        Worker workerE = e();
        Task taskW = w(workerE, taskD, z11);
        if (taskW != null && !b(taskW)) {
            throw new RejectedExecutionException(this.f69529d + " was terminated");
        }
        if (z11 && workerE != null) {
            z12 = true;
        }
        if (z13) {
            t(jAddAndGet, z12);
        } else {
            if (z12) {
                return;
            }
            u();
        }
    }

    public final boolean isTerminated() {
        return f69524l.get(this) != 0;
    }

    public final int l(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != f69525m) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    public final Worker n() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69522j;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            Worker workerB = this.f69532h.b((int) (2097151 & j11));
            if (workerB == null) {
                return null;
            }
            long j12 = (2097152 + j11) & (-2097152);
            int iL = l(workerB);
            if (iL >= 0 && f69522j.compareAndSet(this, j11, ((long) iL) | j12)) {
                workerB.setNextParkedWorker(f69525m);
                return workerB;
            }
        }
    }

    public final boolean o(Worker worker) {
        long j11;
        int indexInArray;
        if (worker.getNextParkedWorker() != f69525m) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69522j;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            indexInArray = worker.getIndexInArray();
            worker.setNextParkedWorker(this.f69532h.b((int) (2097151 & j11)));
        } while (!f69522j.compareAndSet(this, j11, ((2097152 + j11) & (-2097152)) | ((long) indexInArray)));
        return true;
    }

    public final void p(Worker worker, int i11, int i12) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69522j;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            int iL = (int) (2097151 & j11);
            long j12 = (2097152 + j11) & (-2097152);
            if (iL == i11) {
                iL = i12 == 0 ? l(worker) : i12;
            }
            if (iL >= 0 && f69522j.compareAndSet(this, j11, j12 | ((long) iL))) {
                return;
            }
        }
    }

    public final void q(Task task) {
        try {
            task.run();
        } catch (Throwable th2) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
            } finally {
                kotlinx.coroutines.c.a();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    public final void r(long j11) throws InterruptedException {
        int i11;
        Task taskE;
        if (f69524l.compareAndSet(this, 0, 1)) {
            Worker workerE = e();
            synchronized (this.f69532h) {
                i11 = (int) (i().get(this) & 2097151);
            }
            if (1 <= i11) {
                int i12 = 1;
                while (true) {
                    Worker workerB = this.f69532h.b(i12);
                    Intrinsics.d(workerB);
                    Worker worker = workerB;
                    if (worker != workerE) {
                        while (worker.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(worker);
                            worker.join(j11);
                        }
                        worker.localQueue.j(this.f69531g);
                    }
                    if (i12 == i11) {
                        break;
                    } else {
                        i12++;
                    }
                }
            }
            this.f69531g.b();
            this.f69530f.b();
            while (true) {
                if (workerE == null) {
                    taskE = this.f69530f.e();
                    if (taskE == null && (taskE = this.f69531g.e()) == null) {
                        break;
                    }
                } else {
                    taskE = workerE.findTask(true);
                    if (taskE == null) {
                        taskE = this.f69530f.e();
                        if (taskE == null) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                q(taskE);
            }
            if (workerE != null) {
                workerE.tryReleaseCpu(WorkerState.TERMINATED);
            }
            f69522j.set(this, 0L);
            f69523k.set(this, 0L);
        }
    }

    public final void t(long j11, boolean z11) {
        if (z11 || U() || x(j11)) {
            return;
        }
        U();
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f69532h.a();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 1; i16 < iA; i16++) {
            Worker workerB = this.f69532h.b(i16);
            if (workerB != null) {
                int i17 = workerB.localQueue.i();
                int i18 = b.f69533a[workerB.state.ordinal()];
                if (i18 == 1) {
                    i13++;
                } else if (i18 == 2) {
                    i12++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i17);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i18 == 3) {
                    i11++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i17);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i18 == 4) {
                    i14++;
                    if (i17 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(i17);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else if (i18 == 5) {
                    i15++;
                }
            }
        }
        long j11 = f69523k.get(this);
        return this.f69529d + '@' + m0.b(this) + "[Pool Size {core = " + this.f69526a + ", max = " + this.f69527b + "}, Worker States {CPU = " + i11 + ", blocking = " + i12 + ", parked = " + i13 + ", dormant = " + i14 + ", terminated = " + i15 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f69530f.c() + ", global blocking queue size = " + this.f69531g.c() + ", Control State {created workers= " + ((int) (2097151 & j11)) + ", blocking tasks = " + ((int) ((4398044413952L & j11) >> 21)) + ", CPUs acquired = " + (this.f69526a - ((int) ((9223367638808264704L & j11) >> 42))) + "}]";
    }

    public final void u() {
        if (U() || y(this, 0L, 1, null)) {
            return;
        }
        U();
    }

    public final Task w(Worker worker, Task task, boolean z11) {
        if (worker == null || worker.state == WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.b() == 0 && worker.state == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.a(task, z11);
    }

    public final boolean x(long j11) {
        if (kotlin.ranges.a.d(((int) (2097151 & j11)) - ((int) ((j11 & 4398044413952L) >> 21)), 0) < this.f69526a) {
            int iC = c();
            if (iC == 1 && this.f69526a > 1) {
                c();
            }
            if (iC > 0) {
                return true;
            }
        }
        return false;
    }
}
