package o6;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.d0;
import androidx.work.impl.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import s6.m;
import s6.u;
import s6.v;
import s6.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
public class l implements s {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f72377f = androidx.work.j.i("SystemJobScheduler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f72378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JobScheduler f72379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f72380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f72381d;

    public l(@NonNull Context context, @NonNull d0 d0Var) {
        this(context, d0Var, (JobScheduler) context.getSystemService("jobscheduler"), new k(context));
    }

    public l(@NonNull Context context, @NonNull d0 d0Var, @NonNull JobScheduler jobScheduler, @NonNull k kVar) {
        this.f72378a = context;
        this.f72380c = d0Var;
        this.f72379b = jobScheduler;
        this.f72381d = kVar;
    }

    public static void b(@NonNull Context context) {
        List<JobInfo> listG;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (listG = g(context, jobScheduler)) == null || listG.isEmpty()) {
            return;
        }
        Iterator<JobInfo> it = listG.iterator();
        while (it.hasNext()) {
            c(jobScheduler, it.next().getId());
        }
    }

    public static void c(@NonNull JobScheduler jobScheduler, int i11) {
        try {
            jobScheduler.cancel(i11);
        } catch (Throwable th2) {
            androidx.work.j.e().d(f72377f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i11)), th2);
        }
    }

    @Nullable
    public static List<Integer> e(@NonNull Context context, @NonNull JobScheduler jobScheduler, @NonNull String str) {
        List<JobInfo> listG = g(context, jobScheduler);
        if (listG == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : listG) {
            m mVarH = h(jobInfo);
            if (mVarH != null && str.equals(mVarH.b())) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    @Nullable
    public static List<JobInfo> g(@NonNull Context context, @NonNull JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th2) {
            androidx.work.j.e().d(f72377f, "getAllPendingJobs() is not reliable on this device.", th2);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    @Nullable
    public static m h(@NonNull JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new m(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean i(@NonNull Context context, @NonNull d0 d0Var) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> listG = g(context, jobScheduler);
        List<String> listC = d0Var.u().K().c();
        boolean z11 = false;
        HashSet hashSet = new HashSet(listG != null ? listG.size() : 0);
        if (listG != null && !listG.isEmpty()) {
            for (JobInfo jobInfo : listG) {
                m mVarH = h(jobInfo);
                if (mVarH != null) {
                    hashSet.add(mVarH.b());
                } else {
                    c(jobScheduler, jobInfo.getId());
                }
            }
        }
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(it.next())) {
                androidx.work.j.e().a(f72377f, "Reconciling jobs");
                z11 = true;
                break;
            }
        }
        if (z11) {
            WorkDatabase workDatabaseU = d0Var.u();
            workDatabaseU.e();
            try {
                v vVarN = workDatabaseU.N();
                Iterator<String> it2 = listC.iterator();
                while (it2.hasNext()) {
                    vVarN.r(it2.next(), -1L);
                }
                workDatabaseU.E();
            } finally {
                workDatabaseU.i();
            }
        }
        return z11;
    }

    @Override // androidx.work.impl.s
    public void a(@NonNull String str) {
        List<Integer> listE = e(this.f72378a, this.f72379b, str);
        if (listE == null || listE.isEmpty()) {
            return;
        }
        Iterator<Integer> it = listE.iterator();
        while (it.hasNext()) {
            c(this.f72379b, it.next().intValue());
        }
        this.f72380c.u().K().g(str);
    }

    @Override // androidx.work.impl.s
    public boolean d() {
        return true;
    }

    @Override // androidx.work.impl.s
    public void f(@NonNull u... uVarArr) {
        List<Integer> listE;
        WorkDatabase workDatabaseU = this.f72380c.u();
        androidx.work.impl.utils.i iVar = new androidx.work.impl.utils.i(workDatabaseU);
        for (u uVar : uVarArr) {
            workDatabaseU.e();
            try {
                u uVarJ = workDatabaseU.N().j(uVar.f76199a);
                if (uVarJ == null) {
                    androidx.work.j.e().k(f72377f, "Skipping scheduling " + uVar.f76199a + " because it's no longer in the DB");
                    workDatabaseU.E();
                } else if (uVarJ.f76200b != WorkInfo.State.ENQUEUED) {
                    androidx.work.j.e().k(f72377f, "Skipping scheduling " + uVar.f76199a + " because it is no longer enqueued");
                    workDatabaseU.E();
                } else {
                    m mVarA = x.a(uVar);
                    s6.i iVarE = workDatabaseU.K().e(mVarA);
                    int iE = iVarE != null ? iVarE.f76172c : iVar.e(this.f72380c.n().i(), this.f72380c.n().g());
                    if (iVarE == null) {
                        this.f72380c.u().K().d(s6.l.a(mVarA, iE));
                    }
                    j(uVar, iE);
                    if (Build.VERSION.SDK_INT == 23 && (listE = e(this.f72378a, this.f72379b, uVar.f76199a)) != null) {
                        int iIndexOf = listE.indexOf(Integer.valueOf(iE));
                        if (iIndexOf >= 0) {
                            listE.remove(iIndexOf);
                        }
                        j(uVar, !listE.isEmpty() ? listE.get(0).intValue() : iVar.e(this.f72380c.n().i(), this.f72380c.n().g()));
                    }
                    workDatabaseU.E();
                }
                workDatabaseU.i();
            } catch (Throwable th2) {
                workDatabaseU.i();
                throw th2;
            }
        }
    }

    public void j(@NonNull u uVar, int i11) {
        JobInfo jobInfoA = this.f72381d.a(uVar, i11);
        androidx.work.j jVarE = androidx.work.j.e();
        String str = f72377f;
        jVarE.a(str, "Scheduling work ID " + uVar.f76199a + "Job ID " + i11);
        try {
            if (this.f72379b.schedule(jobInfoA) == 0) {
                androidx.work.j.e().k(str, "Unable to schedule work ID " + uVar.f76199a);
                if (uVar.f76215q && uVar.f76216r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    uVar.f76215q = false;
                    androidx.work.j.e().a(str, String.format("Scheduling a non-expedited job (work ID %s)", uVar.f76199a));
                    j(uVar, i11);
                }
            }
        } catch (IllegalStateException e11) {
            List<JobInfo> listG = g(this.f72378a, this.f72379b);
            String str2 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(listG != null ? listG.size() : 0), Integer.valueOf(this.f72380c.u().N().f().size()), Integer.valueOf(this.f72380c.n().h()));
            androidx.work.j.e().c(f72377f, str2);
            IllegalStateException illegalStateException = new IllegalStateException(str2, e11);
            androidx.core.util.a<Throwable> aVarL = this.f72380c.n().l();
            if (aVarL == null) {
                throw illegalStateException;
            }
            aVarL.accept(illegalStateException);
        } catch (Throwable th2) {
            androidx.work.j.e().d(f72377f, "Unable to schedule " + uVar, th2);
        }
    }
}
