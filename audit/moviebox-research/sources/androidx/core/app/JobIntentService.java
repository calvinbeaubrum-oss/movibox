package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class JobIntentService extends Service {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f7558i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap<ComponentName, h> f7559j = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f7560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f7561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f7562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7563d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7564f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7565g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<d> f7566h;

    /* JADX INFO: compiled from: source.java */
    public final class a extends AsyncTask<Void, Void, Void> {
        public a() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e eVarA = JobIntentService.this.a();
                if (eVarA == null) {
                    return null;
                }
                JobIntentService.this.e(eVarA.getIntent());
                eVarA.a();
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r11) {
            JobIntentService.this.g();
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r11) {
            JobIntentService.this.g();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        IBinder a();

        e b();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f7568d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PowerManager.WakeLock f7569e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final PowerManager.WakeLock f7570f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f7571g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f7572h;

        public c(Context context, ComponentName componentName) {
            super(componentName);
            this.f7568d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f7569e = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f7570f = wakeLockNewWakeLock2;
            wakeLockNewWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.h
        public void b() {
            synchronized (this) {
                try {
                    if (this.f7572h) {
                        if (this.f7571g) {
                            this.f7569e.acquire(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
                        }
                        this.f7572h = false;
                        this.f7570f.release();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void c() {
            synchronized (this) {
                try {
                    if (!this.f7572h) {
                        this.f7572h = true;
                        this.f7570f.acquire(TTAdConstant.AD_MAX_EVENT_TIME);
                        this.f7569e.release();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void d() {
            synchronized (this) {
                this.f7571g = false;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f7573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7574b;

        public d(Intent intent, int i11) {
            this.f7573a = intent;
            this.f7574b = i11;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void a() {
            JobIntentService.this.stopSelf(this.f7574b);
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.f7573a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void a();

        Intent getIntent();
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static final class f extends JobServiceEngine implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JobIntentService f7576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f7577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JobParameters f7578c;

        /* JADX INFO: compiled from: source.java */
        public final class a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final JobWorkItem f7579a;

            public a(JobWorkItem jobWorkItem) {
                this.f7579a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public void a() {
                synchronized (f.this.f7577b) {
                    try {
                        JobParameters jobParameters = f.this.f7578c;
                        if (jobParameters != null) {
                            jobParameters.completeWork(this.f7579a);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.e
            public Intent getIntent() {
                return this.f7579a.getIntent();
            }
        }

        public f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f7577b = new Object();
            this.f7576a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder a() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.b
        public e b() {
            synchronized (this.f7577b) {
                try {
                    JobParameters jobParameters = this.f7578c;
                    if (jobParameters == null) {
                        return null;
                    }
                    JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                    if (jobWorkItemDequeueWork == null) {
                        return null;
                    }
                    jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f7576a.getClassLoader());
                    return new a(jobWorkItemDequeueWork);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f7578c = jobParameters;
            this.f7576a.c(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zB = this.f7576a.b();
            synchronized (this.f7577b) {
                this.f7578c = null;
            }
            return zB;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static final class g extends h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JobInfo f7581d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final JobScheduler f7582e;

        public g(Context context, ComponentName componentName, int i11) {
            super(componentName);
            a(i11);
            this.f7581d = new JobInfo.Builder(i11, this.f7583a).setOverrideDeadline(0L).build();
            this.f7582e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f7583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7585c;

        public h(ComponentName componentName) {
            this.f7583a = componentName;
        }

        public void a(int i11) {
            if (!this.f7584b) {
                this.f7584b = true;
                this.f7585c = i11;
            } else {
                if (this.f7585c == i11) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i11 + " is different than previous " + this.f7585c);
            }
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f7566h = null;
        } else {
            this.f7566h = new ArrayList<>();
        }
    }

    public static h d(Context context, ComponentName componentName, boolean z11, int i11) {
        h cVar;
        HashMap<ComponentName, h> map = f7559j;
        h hVar = map.get(componentName);
        if (hVar == null) {
            if (Build.VERSION.SDK_INT < 26) {
                cVar = new c(context, componentName);
            } else {
                if (!z11) {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
                cVar = new g(context, componentName, i11);
            }
            hVar = cVar;
            map.put(componentName, hVar);
        }
        return hVar;
    }

    public e a() {
        b bVar = this.f7560a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f7566h) {
            try {
                if (this.f7566h.size() <= 0) {
                    return null;
                }
                return this.f7566h.remove(0);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean b() {
        a aVar = this.f7562c;
        if (aVar != null) {
            aVar.cancel(this.f7563d);
        }
        this.f7564f = true;
        return f();
    }

    public void c(boolean z11) {
        if (this.f7562c == null) {
            this.f7562c = new a();
            h hVar = this.f7561b;
            if (hVar != null && z11) {
                hVar.c();
            }
            this.f7562c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public abstract void e(@NonNull Intent intent);

    public boolean f() {
        return true;
    }

    public void g() {
        ArrayList<d> arrayList = this.f7566h;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f7562c = null;
                    ArrayList<d> arrayList2 = this.f7566h;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        c(false);
                    } else if (!this.f7565g) {
                        this.f7561b.b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        b bVar = this.f7560a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f7560a = new f(this);
            this.f7561b = null;
        } else {
            this.f7560a = null;
            this.f7561b = d(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.f7566h;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f7565g = true;
                this.f7561b.b();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i11, int i12) {
        if (this.f7566h == null) {
            return 2;
        }
        this.f7561b.d();
        synchronized (this.f7566h) {
            ArrayList<d> arrayList = this.f7566h;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i12));
            c(true);
        }
        return 3;
    }
}
