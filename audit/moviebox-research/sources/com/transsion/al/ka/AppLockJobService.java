package com.transsion.al.ka;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.tn.lib.thread.ThreadPool;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class AppLockJobService extends JobService {
    private static final String TAG = "AppLockJobService";
    private int kJobId = 2;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartJob$0() {
        JobUtils.startAppLockJobService(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStopJob$1() {
        JobUtils.startAppLockJobService(this);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        ThreadPool.c().b(new Runnable() { // from class: com.transsion.al.ka.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f50681a.lambda$onStartJob$0();
            }
        });
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        ThreadPool.c().b(new Runnable() { // from class: com.transsion.al.ka.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f50680a.lambda$onStopJob$1();
            }
        });
        return true;
    }
}
