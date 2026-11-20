package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class WorkForegroundRunnable implements Runnable {
    static final String TAG = androidx.work.j.i("WorkForegroundRunnable");
    final Context mContext;
    final androidx.work.f mForegroundUpdater;
    final androidx.work.impl.utils.futures.a<Void> mFuture = androidx.work.impl.utils.futures.a.x();
    final t6.c mTaskExecutor;
    final s6.u mWorkSpec;
    final androidx.work.i mWorker;

    @SuppressLint({"LambdaLast"})
    public WorkForegroundRunnable(@NonNull Context context, @NonNull s6.u uVar, @NonNull androidx.work.i iVar, @NonNull androidx.work.f fVar, @NonNull t6.c cVar) {
        this.mContext = context;
        this.mWorkSpec = uVar;
        this.mWorker = iVar;
        this.mForegroundUpdater = fVar;
        this.mTaskExecutor = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$run$0(androidx.work.impl.utils.futures.a aVar) {
        if (this.mFuture.isCancelled()) {
            aVar.cancel(true);
        } else {
            aVar.v(this.mWorker.getForegroundInfoAsync());
        }
    }

    @NonNull
    public com.google.common.util.concurrent.s<Void> getFuture() {
        return this.mFuture;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (!this.mWorkSpec.f76215q || Build.VERSION.SDK_INT >= 31) {
            this.mFuture.t(null);
            return;
        }
        final androidx.work.impl.utils.futures.a aVarX = androidx.work.impl.utils.futures.a.x();
        this.mTaskExecutor.a().execute(new Runnable() { // from class: androidx.work.impl.utils.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f13545a.lambda$run$0(aVarX);
            }
        });
        aVarX.addListener(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundRunnable.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (WorkForegroundRunnable.this.mFuture.isCancelled()) {
                    return;
                }
                try {
                    androidx.work.e eVar = (androidx.work.e) aVarX.get();
                    if (eVar == null) {
                        throw new IllegalStateException("Worker was marked important (" + WorkForegroundRunnable.this.mWorkSpec.f76201c + ") but did not provide ForegroundInfo");
                    }
                    androidx.work.j.e().a(WorkForegroundRunnable.TAG, "Updating notification for " + WorkForegroundRunnable.this.mWorkSpec.f76201c);
                    WorkForegroundRunnable workForegroundRunnable = WorkForegroundRunnable.this;
                    workForegroundRunnable.mFuture.v(workForegroundRunnable.mForegroundUpdater.a(workForegroundRunnable.mContext, workForegroundRunnable.mWorker.getId(), eVar));
                } catch (Throwable th2) {
                    WorkForegroundRunnable.this.mFuture.u(th2);
                }
            }
        }, this.mTaskExecutor.a());
    }
}
