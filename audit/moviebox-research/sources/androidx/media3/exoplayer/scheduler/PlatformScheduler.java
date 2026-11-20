package androidx.media3.exoplayer.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import o4.h;
import z3.a;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public final class PlatformScheduler implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11084d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ComponentName f11086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JobScheduler f11087c;

    /* JADX INFO: compiled from: source.java */
    public static final class PlatformSchedulerService extends JobService {
        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            int notMetRequirements = new Requirements(extras.getInt("requirements")).getNotMetRequirements(this);
            if (notMetRequirements == 0) {
                u0.r1(this, new Intent((String) a.e(extras.getString("service_action"))).setPackage((String) a.e(extras.getString("service_package"))));
                return false;
            }
            o.h("PlatformScheduler", "Requirements not met: " + notMetRequirements);
            jobFinished(jobParameters, true);
            return false;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    static {
        f11084d = (u0.f81838a >= 26 ? 16 : 0) | 15;
    }

    @RequiresPermission("android.permission.RECEIVE_BOOT_COMPLETED")
    public PlatformScheduler(Context context, int i11) {
        Context applicationContext = context.getApplicationContext();
        this.f11085a = i11;
        this.f11086b = new ComponentName(applicationContext, (Class<?>) PlatformSchedulerService.class);
        this.f11087c = (JobScheduler) a.e((JobScheduler) applicationContext.getSystemService("jobscheduler"));
    }

    public static JobInfo c(int i11, ComponentName componentName, Requirements requirements, String str, String str2) {
        Requirements requirementsFilterRequirements = requirements.filterRequirements(f11084d);
        if (!requirementsFilterRequirements.equals(requirements)) {
            o.h("PlatformScheduler", "Ignoring unsupported requirements: " + (requirementsFilterRequirements.getRequirements() ^ requirements.getRequirements()));
        }
        JobInfo.Builder builder = new JobInfo.Builder(i11, componentName);
        if (requirements.isUnmeteredNetworkRequired()) {
            builder.setRequiredNetworkType(2);
        } else if (requirements.isNetworkRequired()) {
            builder.setRequiredNetworkType(1);
        }
        builder.setRequiresDeviceIdle(requirements.isIdleRequired());
        builder.setRequiresCharging(requirements.isChargingRequired());
        if (u0.f81838a >= 26 && requirements.isStorageNotLowRequired()) {
            builder.setRequiresStorageNotLow(true);
        }
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("service_action", str);
        persistableBundle.putString("service_package", str2);
        persistableBundle.putInt("requirements", requirements.getRequirements());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    @Override // o4.h
    public boolean a(Requirements requirements, String str, String str2) {
        return this.f11087c.schedule(c(this.f11085a, this.f11086b, requirements, str2, str)) == 1;
    }

    @Override // o4.h
    public Requirements b(Requirements requirements) {
        return requirements.filterRequirements(f11084d);
    }

    @Override // o4.h
    public boolean cancel() {
        this.f11087c.cancel(this.f11085a);
        return true;
    }
}
