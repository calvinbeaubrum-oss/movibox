package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

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
public final class h1 extends ExecutorCoroutineDispatcher implements q0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f69432b;

    public h1(Executor executor) {
        this.f69432b = executor;
        kotlinx.coroutines.internal.c.a(p());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorP = p();
        ExecutorService executorService = executorP instanceof ExecutorService ? (ExecutorService) executorP : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor executorP = p();
            c.a();
            executorP.execute(runnable);
        } catch (RejectedExecutionException e11) {
            c.a();
            o(coroutineContext, e11);
            w0.b().dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof h1) && ((h1) obj).p() == p();
    }

    public int hashCode() {
        return System.identityHashCode(p());
    }

    @Override // kotlinx.coroutines.q0
    public y0 invokeOnTimeout(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        Executor executorP = p();
        ScheduledExecutorService scheduledExecutorService = executorP instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorP : null;
        ScheduledFuture<?> scheduledFutureQ = scheduledExecutorService != null ? q(scheduledExecutorService, runnable, coroutineContext, j11) : null;
        return scheduledFutureQ != null ? new x0(scheduledFutureQ) : DefaultExecutor.INSTANCE.invokeOnTimeout(j11, runnable, coroutineContext);
    }

    public final void o(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        t1.c(coroutineContext, g1.a("The task was rejected", rejectedExecutionException));
    }

    public Executor p() {
        return this.f69432b;
    }

    public final ScheduledFuture<?> q(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j11) {
        try {
            return scheduledExecutorService.schedule(runnable, j11, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e11) {
            o(coroutineContext, e11);
            return null;
        }
    }

    @Override // kotlinx.coroutines.q0
    public void scheduleResumeAfterDelay(long j11, n<? super Unit> nVar) {
        Executor executorP = p();
        ScheduledExecutorService scheduledExecutorService = executorP instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorP : null;
        ScheduledFuture<?> scheduledFutureQ = scheduledExecutorService != null ? q(scheduledExecutorService, new ResumeUndispatchedRunnable(this, nVar), nVar.getContext(), j11) : null;
        if (scheduledFutureQ != null) {
            t1.h(nVar, scheduledFutureQ);
        } else {
            DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(j11, nVar);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return p().toString();
    }
}
