package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class WorkerWrapper implements Runnable {
    static final String TAG = androidx.work.j.i("WorkerWrapper");
    Context mAppContext;
    private androidx.work.a mConfiguration;
    private s6.b mDependencyDao;
    private androidx.work.impl.foreground.a mForegroundProcessor;
    private volatile boolean mInterrupted;
    private WorkerParameters.a mRuntimeExtras;
    private List<s> mSchedulers;
    private List<String> mTags;
    private WorkDatabase mWorkDatabase;
    private String mWorkDescription;
    s6.u mWorkSpec;
    private s6.v mWorkSpecDao;
    private final String mWorkSpecId;
    t6.c mWorkTaskExecutor;
    androidx.work.i mWorker;

    @NonNull
    androidx.work.i.a mResult = androidx.work.i.a.a();

    @NonNull
    androidx.work.impl.utils.futures.a<Boolean> mFuture = androidx.work.impl.utils.futures.a.x();

    @NonNull
    final androidx.work.impl.utils.futures.a<androidx.work.i.a> mWorkerResultFuture = androidx.work.impl.utils.futures.a.x();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public Context f13337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public androidx.work.i f13338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public androidx.work.impl.foreground.a f13339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        public t6.c f13340d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NonNull
        public androidx.work.a f13341e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NonNull
        public WorkDatabase f13342f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NonNull
        public s6.u f13343g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<s> f13344h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List<String> f13345i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @NonNull
        public WorkerParameters.a f13346j = new WorkerParameters.a();

        public a(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull t6.c cVar, @NonNull androidx.work.impl.foreground.a aVar2, @NonNull WorkDatabase workDatabase, @NonNull s6.u uVar, @NonNull List<String> list) {
            this.f13337a = context.getApplicationContext();
            this.f13340d = cVar;
            this.f13339c = aVar2;
            this.f13341e = aVar;
            this.f13342f = workDatabase;
            this.f13343g = uVar;
            this.f13345i = list;
        }

        @NonNull
        public WorkerWrapper b() {
            return new WorkerWrapper(this);
        }

        @NonNull
        public a c(@Nullable WorkerParameters.a aVar) {
            if (aVar != null) {
                this.f13346j = aVar;
            }
            return this;
        }

        @NonNull
        public a d(@NonNull List<s> list) {
            this.f13344h = list;
            return this;
        }
    }

    public WorkerWrapper(@NonNull a aVar) {
        this.mAppContext = aVar.f13337a;
        this.mWorkTaskExecutor = aVar.f13340d;
        this.mForegroundProcessor = aVar.f13339c;
        s6.u uVar = aVar.f13343g;
        this.mWorkSpec = uVar;
        this.mWorkSpecId = uVar.f76199a;
        this.mSchedulers = aVar.f13344h;
        this.mRuntimeExtras = aVar.f13346j;
        this.mWorker = aVar.f13338b;
        this.mConfiguration = aVar.f13341e;
        WorkDatabase workDatabase = aVar.f13342f;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecDao = workDatabase.N();
        this.mDependencyDao = this.mWorkDatabase.H();
        this.mTags = aVar.f13345i;
    }

    private String createWorkDescription(List<String> list) {
        StringBuilder sb2 = new StringBuilder("Work [ id=");
        sb2.append(this.mWorkSpecId);
        sb2.append(", tags={ ");
        boolean z11 = true;
        for (String str : list) {
            if (z11) {
                z11 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(str);
        }
        sb2.append(" } ]");
        return sb2.toString();
    }

    private void handleResult(androidx.work.i.a aVar) {
        if (aVar instanceof androidx.work.i.a.c) {
            androidx.work.j.e().f(TAG, "Worker result SUCCESS for " + this.mWorkDescription);
            if (this.mWorkSpec.j()) {
                resetPeriodicAndResolve();
                return;
            } else {
                setSucceededAndResolve();
                return;
            }
        }
        if (aVar instanceof androidx.work.i.a.b) {
            androidx.work.j.e().f(TAG, "Worker result RETRY for " + this.mWorkDescription);
            rescheduleAndResolve();
            return;
        }
        androidx.work.j.e().f(TAG, "Worker result FAILURE for " + this.mWorkDescription);
        if (this.mWorkSpec.j()) {
            resetPeriodicAndResolve();
        } else {
            setFailedAndResolve();
        }
    }

    private void iterativelyFailWorkAndDependents(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.mWorkSpecDao.i(str2) != WorkInfo.State.CANCELLED) {
                this.mWorkSpecDao.u(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.mDependencyDao.a(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runWorker$0(com.google.common.util.concurrent.s sVar) {
        if (this.mWorkerResultFuture.isCancelled()) {
            sVar.cancel(true);
        }
    }

    private void rescheduleAndResolve() {
        this.mWorkDatabase.e();
        try {
            this.mWorkSpecDao.u(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.k(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.r(this.mWorkSpecId, -1L);
            this.mWorkDatabase.E();
        } finally {
            this.mWorkDatabase.i();
            resolve(true);
        }
    }

    private void resetPeriodicAndResolve() {
        this.mWorkDatabase.e();
        try {
            this.mWorkSpecDao.k(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.u(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.z(this.mWorkSpecId);
            this.mWorkSpecDao.c(this.mWorkSpecId);
            this.mWorkSpecDao.r(this.mWorkSpecId, -1L);
            this.mWorkDatabase.E();
        } finally {
            this.mWorkDatabase.i();
            resolve(false);
        }
    }

    private void resolve(boolean z11) {
        this.mWorkDatabase.e();
        try {
            if (!this.mWorkDatabase.N().y()) {
                androidx.work.impl.utils.n.a(this.mAppContext, RescheduleReceiver.class, false);
            }
            if (z11) {
                this.mWorkSpecDao.u(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
                this.mWorkSpecDao.r(this.mWorkSpecId, -1L);
            }
            if (this.mWorkSpec != null && this.mWorker != null && this.mForegroundProcessor.b(this.mWorkSpecId)) {
                this.mForegroundProcessor.a(this.mWorkSpecId);
            }
            this.mWorkDatabase.E();
            this.mWorkDatabase.i();
            this.mFuture.t(Boolean.valueOf(z11));
        } catch (Throwable th2) {
            this.mWorkDatabase.i();
            throw th2;
        }
    }

    private void resolveIncorrectStatus() {
        WorkInfo.State stateI = this.mWorkSpecDao.i(this.mWorkSpecId);
        if (stateI == WorkInfo.State.RUNNING) {
            androidx.work.j.e().a(TAG, "Status for " + this.mWorkSpecId + " is RUNNING; not doing any work and rescheduling for later execution");
            resolve(true);
            return;
        }
        androidx.work.j.e().a(TAG, "Status for " + this.mWorkSpecId + " is " + stateI + " ; not doing any work");
        resolve(false);
    }

    private void runWorker() {
        androidx.work.d dVarB;
        if (tryCheckForInterruptionAndResolve()) {
            return;
        }
        this.mWorkDatabase.e();
        try {
            s6.u uVar = this.mWorkSpec;
            if (uVar.f76200b != WorkInfo.State.ENQUEUED) {
                resolveIncorrectStatus();
                this.mWorkDatabase.E();
                androidx.work.j.e().a(TAG, this.mWorkSpec.f76201c + " is not in ENQUEUED state. Nothing more to do");
                this.mWorkDatabase.i();
                return;
            }
            if ((uVar.j() || this.mWorkSpec.i()) && System.currentTimeMillis() < this.mWorkSpec.c()) {
                androidx.work.j.e().a(TAG, String.format("Delaying execution for %s because it is being executed before schedule.", this.mWorkSpec.f76201c));
                resolve(true);
                this.mWorkDatabase.E();
                this.mWorkDatabase.i();
                return;
            }
            this.mWorkDatabase.E();
            this.mWorkDatabase.i();
            if (this.mWorkSpec.j()) {
                dVarB = this.mWorkSpec.f76203e;
            } else {
                androidx.work.g gVarB = this.mConfiguration.f().b(this.mWorkSpec.f76202d);
                if (gVarB == null) {
                    androidx.work.j.e().c(TAG, "Could not create Input Merger " + this.mWorkSpec.f76202d);
                    setFailedAndResolve();
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.mWorkSpec.f76203e);
                arrayList.addAll(this.mWorkSpecDao.m(this.mWorkSpecId));
                dVarB = gVarB.b(arrayList);
            }
            androidx.work.d dVar = dVarB;
            UUID uuidFromString = UUID.fromString(this.mWorkSpecId);
            List<String> list = this.mTags;
            WorkerParameters.a aVar = this.mRuntimeExtras;
            s6.u uVar2 = this.mWorkSpec;
            WorkerParameters workerParameters = new WorkerParameters(uuidFromString, dVar, list, aVar, uVar2.f76209k, uVar2.f(), this.mConfiguration.d(), this.mWorkTaskExecutor, this.mConfiguration.n(), new WorkProgressUpdater(this.mWorkDatabase, this.mWorkTaskExecutor), new WorkForegroundUpdater(this.mWorkDatabase, this.mForegroundProcessor, this.mWorkTaskExecutor));
            if (this.mWorker == null) {
                this.mWorker = this.mConfiguration.n().b(this.mAppContext, this.mWorkSpec.f76201c, workerParameters);
            }
            androidx.work.i iVar = this.mWorker;
            if (iVar == null) {
                androidx.work.j.e().c(TAG, "Could not create Worker " + this.mWorkSpec.f76201c);
                setFailedAndResolve();
                return;
            }
            if (iVar.isUsed()) {
                androidx.work.j.e().c(TAG, "Received an already-used Worker " + this.mWorkSpec.f76201c + "; Worker Factory should return new instances");
                setFailedAndResolve();
                return;
            }
            this.mWorker.setUsed();
            if (!trySetRunning()) {
                resolveIncorrectStatus();
                return;
            }
            if (tryCheckForInterruptionAndResolve()) {
                return;
            }
            WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.mAppContext, this.mWorkSpec, this.mWorker, workerParameters.b(), this.mWorkTaskExecutor);
            this.mWorkTaskExecutor.a().execute(workForegroundRunnable);
            final com.google.common.util.concurrent.s<Void> future = workForegroundRunnable.getFuture();
            this.mWorkerResultFuture.addListener(new Runnable() { // from class: androidx.work.impl.i0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13468a.lambda$runWorker$0(future);
                }
            }, new androidx.work.impl.utils.r());
            future.addListener(new Runnable() { // from class: androidx.work.impl.WorkerWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (WorkerWrapper.this.mWorkerResultFuture.isCancelled()) {
                        return;
                    }
                    try {
                        future.get();
                        androidx.work.j.e().a(WorkerWrapper.TAG, "Starting work for " + WorkerWrapper.this.mWorkSpec.f76201c);
                        WorkerWrapper workerWrapper = WorkerWrapper.this;
                        workerWrapper.mWorkerResultFuture.v(workerWrapper.mWorker.startWork());
                    } catch (Throwable th2) {
                        WorkerWrapper.this.mWorkerResultFuture.u(th2);
                    }
                }
            }, this.mWorkTaskExecutor.a());
            final String str = this.mWorkDescription;
            this.mWorkerResultFuture.addListener(new Runnable() { // from class: androidx.work.impl.WorkerWrapper.2
                @Override // java.lang.Runnable
                @SuppressLint({"SyntheticAccessor"})
                public void run() {
                    try {
                        try {
                            androidx.work.i.a aVar2 = WorkerWrapper.this.mWorkerResultFuture.get();
                            if (aVar2 == null) {
                                androidx.work.j.e().c(WorkerWrapper.TAG, WorkerWrapper.this.mWorkSpec.f76201c + " returned a null result. Treating it as a failure.");
                            } else {
                                androidx.work.j.e().a(WorkerWrapper.TAG, WorkerWrapper.this.mWorkSpec.f76201c + " returned a " + aVar2 + InstructionFileId.DOT);
                                WorkerWrapper.this.mResult = aVar2;
                            }
                        } catch (InterruptedException e11) {
                            e = e11;
                            androidx.work.j.e().d(WorkerWrapper.TAG, str + " failed because it threw an exception/error", e);
                        } catch (CancellationException e12) {
                            androidx.work.j.e().g(WorkerWrapper.TAG, str + " was cancelled", e12);
                        } catch (ExecutionException e13) {
                            e = e13;
                            androidx.work.j.e().d(WorkerWrapper.TAG, str + " failed because it threw an exception/error", e);
                        }
                        WorkerWrapper.this.onWorkFinished();
                    } catch (Throwable th2) {
                        WorkerWrapper.this.onWorkFinished();
                        throw th2;
                    }
                }
            }, this.mWorkTaskExecutor.b());
        } catch (Throwable th2) {
            this.mWorkDatabase.i();
            throw th2;
        }
    }

    private void setSucceededAndResolve() {
        this.mWorkDatabase.e();
        try {
            this.mWorkSpecDao.u(WorkInfo.State.SUCCEEDED, this.mWorkSpecId);
            this.mWorkSpecDao.v(this.mWorkSpecId, ((androidx.work.i.a.c) this.mResult).e());
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (String str : this.mDependencyDao.a(this.mWorkSpecId)) {
                if (this.mWorkSpecDao.i(str) == WorkInfo.State.BLOCKED && this.mDependencyDao.b(str)) {
                    androidx.work.j.e().f(TAG, "Setting status to enqueued for " + str);
                    this.mWorkSpecDao.u(WorkInfo.State.ENQUEUED, str);
                    this.mWorkSpecDao.k(str, jCurrentTimeMillis);
                }
            }
            this.mWorkDatabase.E();
        } finally {
            this.mWorkDatabase.i();
            resolve(false);
        }
    }

    private boolean tryCheckForInterruptionAndResolve() {
        if (!this.mInterrupted) {
            return false;
        }
        androidx.work.j.e().a(TAG, "Work interrupted for " + this.mWorkDescription);
        WorkInfo.State stateI = this.mWorkSpecDao.i(this.mWorkSpecId);
        if (stateI == null) {
            resolve(false);
        } else {
            resolve(!stateI.isFinished());
        }
        return true;
    }

    private boolean trySetRunning() {
        boolean z11;
        this.mWorkDatabase.e();
        try {
            if (this.mWorkSpecDao.i(this.mWorkSpecId) == WorkInfo.State.ENQUEUED) {
                this.mWorkSpecDao.u(WorkInfo.State.RUNNING, this.mWorkSpecId);
                this.mWorkSpecDao.C(this.mWorkSpecId);
                z11 = true;
            } else {
                z11 = false;
            }
            this.mWorkDatabase.E();
            return z11;
        } finally {
            this.mWorkDatabase.i();
        }
    }

    @NonNull
    public com.google.common.util.concurrent.s<Boolean> getFuture() {
        return this.mFuture;
    }

    @NonNull
    public s6.m getWorkGenerationalId() {
        return s6.x.a(this.mWorkSpec);
    }

    @NonNull
    public s6.u getWorkSpec() {
        return this.mWorkSpec;
    }

    public void interrupt() {
        this.mInterrupted = true;
        tryCheckForInterruptionAndResolve();
        this.mWorkerResultFuture.cancel(true);
        if (this.mWorker != null && this.mWorkerResultFuture.isCancelled()) {
            this.mWorker.stop();
            return;
        }
        androidx.work.j.e().a(TAG, "WorkSpec " + this.mWorkSpec + " is already done. Not interrupting.");
    }

    public void onWorkFinished() {
        if (!tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.e();
            try {
                WorkInfo.State stateI = this.mWorkSpecDao.i(this.mWorkSpecId);
                this.mWorkDatabase.M().a(this.mWorkSpecId);
                if (stateI == null) {
                    resolve(false);
                } else if (stateI == WorkInfo.State.RUNNING) {
                    handleResult(this.mResult);
                } else if (!stateI.isFinished()) {
                    rescheduleAndResolve();
                }
                this.mWorkDatabase.E();
                this.mWorkDatabase.i();
            } catch (Throwable th2) {
                this.mWorkDatabase.i();
                throw th2;
            }
        }
        List<s> list = this.mSchedulers;
        if (list != null) {
            Iterator<s> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(this.mWorkSpecId);
            }
            t.b(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mWorkDescription = createWorkDescription(this.mTags);
        runWorker();
    }

    public void setFailedAndResolve() {
        this.mWorkDatabase.e();
        try {
            iterativelyFailWorkAndDependents(this.mWorkSpecId);
            this.mWorkSpecDao.v(this.mWorkSpecId, ((androidx.work.i.a.C0125a) this.mResult).e());
            this.mWorkDatabase.E();
        } finally {
            this.mWorkDatabase.i();
            resolve(false);
        }
    }
}
