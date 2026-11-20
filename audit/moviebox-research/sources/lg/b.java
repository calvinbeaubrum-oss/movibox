package lg;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.hisavana.common.tracking.TrackingKey;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(api = 21)
public class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f70224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mg.d f70225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SchedulerConfig f70226c;

    public b(Context context, mg.d dVar, SchedulerConfig schedulerConfig) {
        this.f70224a = context;
        this.f70225b = dVar;
        this.f70226c = schedulerConfig;
    }

    @Override // lg.u
    public void a(com.google.android.datatransport.runtime.o oVar, int i11) {
        b(oVar, i11, false);
    }

    @Override // lg.u
    public void b(com.google.android.datatransport.runtime.o oVar, int i11, boolean z11) {
        ComponentName componentName = new ComponentName(this.f70224a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f70224a.getSystemService("jobscheduler");
        int iC = c(oVar);
        if (!z11 && d(jobScheduler, iC, i11)) {
            ig.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", oVar);
            return;
        }
        long jO = this.f70225b.O(oVar);
        JobInfo.Builder builderC = this.f70226c.c(new JobInfo.Builder(iC, componentName), oVar.d(), jO, i11);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i11);
        persistableBundle.putString("backendName", oVar.b());
        persistableBundle.putInt(TrackingKey.PRIORITY, pg.a.a(oVar.d()));
        if (oVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(oVar.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        ig.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", oVar, Integer.valueOf(iC), Long.valueOf(this.f70226c.g(oVar.d(), jO, i11)), Long.valueOf(jO), Integer.valueOf(i11));
        jobScheduler.schedule(builderC.build());
    }

    public int c(com.google.android.datatransport.runtime.o oVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f70224a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(oVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(pg.a.a(oVar.d())).array());
        if (oVar.c() != null) {
            adler32.update(oVar.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean d(JobScheduler jobScheduler, int i11, int i12) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i13 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i11) {
                return i13 >= i12;
            }
        }
        return false;
    }
}
