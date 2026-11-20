package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Worker extends i {
    androidx.work.impl.utils.futures.a<i.a> mFuture;

    public Worker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    public abstract i.a doWork();

    @NonNull
    public e getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }

    @Override // androidx.work.i
    @NonNull
    public com.google.common.util.concurrent.s<e> getForegroundInfoAsync() {
        final androidx.work.impl.utils.futures.a aVarX = androidx.work.impl.utils.futures.a.x();
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.Worker.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    aVarX.t(Worker.this.getForegroundInfo());
                } catch (Throwable th2) {
                    aVarX.u(th2);
                }
            }
        });
        return aVarX;
    }

    @Override // androidx.work.i
    @NonNull
    public final com.google.common.util.concurrent.s<i.a> startWork() {
        this.mFuture = androidx.work.impl.utils.futures.a.x();
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.Worker.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Worker.this.mFuture.t(Worker.this.doWork());
                } catch (Throwable th2) {
                    Worker.this.mFuture.u(th2);
                }
            }
        });
        return this.mFuture;
    }
}
