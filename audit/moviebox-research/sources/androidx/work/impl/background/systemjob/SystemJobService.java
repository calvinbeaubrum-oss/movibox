package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.work.WorkerParameters;
import androidx.work.impl.d0;
import androidx.work.impl.e;
import androidx.work.impl.u;
import androidx.work.impl.v;
import androidx.work.j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import s6.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class SystemJobService extends JobService implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13409d = j.i("SystemJobService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f13410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<m, JobParameters> f13411b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f13412c = new v();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(24)
    public static class a {
        public static String[] a(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }

        public static Uri[] b(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(28)
    public static class b {
        public static Network a(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }

    @Nullable
    public static m a(@NonNull JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new m(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // androidx.work.impl.e
    /* JADX INFO: renamed from: c */
    public void l(@NonNull m mVar, boolean z11) {
        JobParameters jobParametersRemove;
        j.e().a(f13409d, mVar.b() + " executed on JobScheduler");
        synchronized (this.f13411b) {
            jobParametersRemove = this.f13411b.remove(mVar);
        }
        this.f13412c.b(mVar);
        if (jobParametersRemove != null) {
            jobFinished(jobParametersRemove, z11);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            d0 d0VarP = d0.p(getApplicationContext());
            this.f13410a = d0VarP;
            d0VarP.r().g(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            j.e().k(f13409d, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d0 d0Var = this.f13410a;
        if (d0Var != null) {
            d0Var.r().n(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(@NonNull JobParameters jobParameters) {
        WorkerParameters.a aVar;
        if (this.f13410a == null) {
            j.e().a(f13409d, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        m mVarA = a(jobParameters);
        if (mVarA == null) {
            j.e().c(f13409d, "WorkSpec id not found!");
            return false;
        }
        synchronized (this.f13411b) {
            try {
                if (this.f13411b.containsKey(mVarA)) {
                    j.e().a(f13409d, "Job is already being executed by SystemJobService: " + mVarA);
                    return false;
                }
                j.e().a(f13409d, "onStartJob for " + mVarA);
                this.f13411b.put(mVarA, jobParameters);
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 24) {
                    aVar = new WorkerParameters.a();
                    if (a.b(jobParameters) != null) {
                        aVar.f13253b = Arrays.asList(a.b(jobParameters));
                    }
                    if (a.a(jobParameters) != null) {
                        aVar.f13252a = Arrays.asList(a.a(jobParameters));
                    }
                    if (i11 >= 28) {
                        aVar.f13254c = b.a(jobParameters);
                    }
                } else {
                    aVar = null;
                }
                this.f13410a.B(this.f13412c.d(mVarA), aVar);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(@NonNull JobParameters jobParameters) {
        if (this.f13410a == null) {
            j.e().a(f13409d, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        m mVarA = a(jobParameters);
        if (mVarA == null) {
            j.e().c(f13409d, "WorkSpec id not found!");
            return false;
        }
        j.e().a(f13409d, "onStopJob for " + mVarA);
        synchronized (this.f13411b) {
            this.f13411b.remove(mVarA);
        }
        u uVarB = this.f13412c.b(mVarA);
        if (uVarB != null) {
            this.f13410a.D(uVarB);
        }
        return !this.f13410a.r().j(mVarA.b());
    }
}
