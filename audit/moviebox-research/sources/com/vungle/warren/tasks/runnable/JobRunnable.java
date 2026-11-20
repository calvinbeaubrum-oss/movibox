package com.vungle.warren.tasks.runnable;

import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.tasks.UnknownTagException;
import com.vungle.warren.utility.PriorityRunnable;
import y00.f;
import y00.g;
import y00.h;
import z00.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class JobRunnable extends PriorityRunnable {
    private static final String TAG = "JobRunnable";
    private final f creator;
    private final h jobRunner;
    private final g jobinfo;
    private final b threadPriorityHelper;

    public JobRunnable(@NonNull g gVar, @NonNull f fVar, @NonNull h hVar, @Nullable b bVar) {
        this.jobinfo = gVar;
        this.creator = fVar;
        this.jobRunner = hVar;
        this.threadPriorityHelper = bVar;
    }

    @Override // com.vungle.warren.utility.PriorityRunnable
    public Integer getPriority() {
        return Integer.valueOf(this.jobinfo.f());
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar = this.threadPriorityHelper;
        if (bVar != null) {
            try {
                int iA = bVar.a(this.jobinfo);
                Process.setThreadPriority(iA);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting process thread prio = ");
                sb2.append(iA);
                sb2.append(" for ");
                sb2.append(this.jobinfo.d());
            } catch (Throwable unused) {
                Log.e(TAG, "Error on setting process thread priority");
            }
        }
        try {
            String strD = this.jobinfo.d();
            Bundle bundleC = this.jobinfo.c();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Start job ");
            sb3.append(strD);
            sb3.append("Thread ");
            sb3.append(Thread.currentThread().getName());
            int iA2 = this.creator.a(strD).a(bundleC, this.jobRunner);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("On job finished ");
            sb4.append(strD);
            sb4.append(" with result ");
            sb4.append(iA2);
            if (iA2 == 2) {
                long j11 = this.jobinfo.j();
                if (j11 > 0) {
                    this.jobinfo.k(j11);
                    this.jobRunner.a(this.jobinfo);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Rescheduling ");
                    sb5.append(strD);
                    sb5.append(" in ");
                    sb5.append(j11);
                }
            }
        } catch (UnknownTagException e11) {
            Log.e(TAG, "Cannot create job" + e11.getLocalizedMessage());
        } catch (Throwable th2) {
            Log.e(TAG, "Can't start job", th2);
        }
    }
}
