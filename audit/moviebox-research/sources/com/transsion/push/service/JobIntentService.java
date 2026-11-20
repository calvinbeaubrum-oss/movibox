package com.transsion.push.service;

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
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f56976i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap<ComponentName, h> f56977j = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f56978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f56979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f56980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f56981d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f56982f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f56983g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<d> f56984h;

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
                try {
                    JobIntentService.this.c(eVarA.getIntent());
                    eVarA.a();
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r11) {
            JobIntentService.this.f();
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r11) {
            JobIntentService.this.f();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        e a();

        IBinder b();
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public static final class c extends h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f56986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PowerManager.WakeLock f56987e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final PowerManager.WakeLock f56988f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f56989g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f56990h;

        public c(Context context, ComponentName componentName) {
            super(componentName);
            this.f56986d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f56987e = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f56988f = wakeLockNewWakeLock2;
            wakeLockNewWakeLock2.setReferenceCounted(false);
        }

        @Override // com.transsion.push.service.JobIntentService.h
        public void a() {
            synchronized (this) {
                try {
                    if (this.f56990h) {
                        if (this.f56989g) {
                            this.f56987e.acquire(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
                        }
                        this.f56990h = false;
                        this.f56988f.release();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.transsion.push.service.JobIntentService.h
        public void c(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f57001a);
            if (this.f56986d.startService(intent2) != null) {
                synchronized (this) {
                    try {
                        if (!this.f56989g) {
                            this.f56989g = true;
                            if (!this.f56990h) {
                                this.f56987e.acquire(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        @Override // com.transsion.push.service.JobIntentService.h
        public void d() {
            synchronized (this) {
                try {
                    if (!this.f56990h) {
                        this.f56990h = true;
                        this.f56988f.acquire(TTAdConstant.AD_MAX_EVENT_TIME);
                        this.f56987e.release();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.transsion.push.service.JobIntentService.h
        public void e() {
            synchronized (this) {
                this.f56989g = false;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    public final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f56991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f56992b;

        public d(Intent intent, int i11) {
            this.f56991a = intent;
            this.f56992b = i11;
        }

        @Override // com.transsion.push.service.JobIntentService.e
        public void a() {
            JobIntentService.this.stopSelf(this.f56992b);
        }

        @Override // com.transsion.push.service.JobIntentService.e
        public Intent getIntent() {
            return this.f56991a;
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
        public final JobIntentService f56994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f56995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JobParameters f56996c;

        /* JADX INFO: compiled from: source.java */
        public final class a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final JobWorkItem f56997a;

            public a(JobWorkItem jobWorkItem) {
                this.f56997a = jobWorkItem;
            }

            @Override // com.transsion.push.service.JobIntentService.e
            public void a() {
                String str;
                String str2;
                synchronized (f.this.f56995b) {
                    JobParameters jobParameters = f.this.f56996c;
                    if (jobParameters != null) {
                        try {
                            jobParameters.completeWork(this.f56997a);
                        } catch (IllegalArgumentException e11) {
                            e = e11;
                            str = "JobServiceEngineImpl";
                            str2 = "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!";
                            Log.e(str, str2, e);
                        } catch (SecurityException e12) {
                            e = e12;
                            str = "JobServiceEngineImpl";
                            str2 = "SecurityException: Failed to run mParams.completeWork(mJobWork)!";
                            Log.e(str, str2, e);
                        }
                    }
                }
            }

            @Override // com.transsion.push.service.JobIntentService.e
            public Intent getIntent() {
                return this.f56997a.getIntent();
            }
        }

        public f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f56995b = new Object();
            this.f56994a = jobIntentService;
        }

        @Override // com.transsion.push.service.JobIntentService.b
        public e a() {
            synchronized (this.f56995b) {
                JobParameters jobParameters = this.f56996c;
                if (jobParameters == null) {
                    return null;
                }
                try {
                    JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                    if (jobWorkItemDequeueWork == null) {
                        return null;
                    }
                    jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f56994a.getClassLoader());
                    return new a(jobWorkItemDequeueWork);
                } catch (SecurityException e11) {
                    Log.e("JobServiceEngineImpl", "Failed to run mParams.dequeueWork()!", e11);
                    return null;
                }
            }
        }

        @Override // com.transsion.push.service.JobIntentService.b
        public IBinder b() {
            return getBinder();
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f56996c = jobParameters;
            this.f56994a.d(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zE = this.f56994a.e();
            synchronized (this.f56995b) {
                this.f56996c = null;
            }
            return zE;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static final class g extends h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JobInfo f56999d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final JobScheduler f57000e;

        public g(Context context, ComponentName componentName, int i11) {
            super(componentName);
            b(i11);
            this.f56999d = new JobInfo.Builder(i11, this.f57001a).setOverrideDeadline(0L).build();
            this.f57000e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // com.transsion.push.service.JobIntentService.h
        public void c(Intent intent) {
            this.f57000e.enqueue(this.f56999d, nw.f.a(intent));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f57001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f57002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f57003c;

        public h(ComponentName componentName) {
            this.f57001a = componentName;
        }

        public void a() {
        }

        public void b(int i11) {
            if (!this.f57002b) {
                this.f57002b = true;
                this.f57003c = i11;
            } else {
                if (this.f57003c == i11) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i11 + " is different than previous " + this.f57003c);
            }
        }

        public abstract void c(Intent intent);

        public void d() {
        }

        public void e() {
        }
    }

    public JobIntentService() {
        this.f56984h = Build.VERSION.SDK_INT >= 26 ? null : new ArrayList<>();
    }

    public static h b(Context context, ComponentName componentName, boolean z11, int i11) {
        h cVar;
        HashMap<ComponentName, h> map = f56977j;
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

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i11, @NonNull Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f56976i) {
            h hVarB = b(context, componentName, true, i11);
            hVarB.b(i11);
            try {
                hVarB.c(intent);
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class cls, int i11, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, (Class<?>) cls), i11, intent);
    }

    public e a() {
        b bVar = this.f56978a;
        if (bVar != null) {
            return bVar.a();
        }
        synchronized (this.f56984h) {
            try {
                if (this.f56984h.size() <= 0) {
                    return null;
                }
                return this.f56984h.remove(0);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract void c(@NonNull Intent intent);

    public void d(boolean z11) {
        if (this.f56980c == null) {
            this.f56980c = new a();
            h hVar = this.f56979b;
            if (hVar != null && z11) {
                hVar.d();
            }
            try {
                this.f56980c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } catch (Exception e11) {
                Log.e("JobIntentService", "RejectedExecutionException: rejected from java.util.concurrent.ThreadPoolExecutor", e11);
            }
        }
    }

    public boolean e() {
        a aVar = this.f56980c;
        if (aVar != null) {
            aVar.cancel(this.f56981d);
        }
        this.f56982f = true;
        return onStopCurrentWork();
    }

    public void f() {
        ArrayList<d> arrayList = this.f56984h;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f56980c = null;
                    ArrayList<d> arrayList2 = this.f56984h;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        d(false);
                    } else if (!this.f56983g) {
                        this.f56979b.a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public boolean isStopped() {
        return this.f56982f;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        b bVar = this.f56978a;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f56978a = new f(this);
            this.f56979b = null;
        } else {
            this.f56978a = null;
            this.f56979b = b(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.f56984h;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f56983g = true;
                this.f56979b.a();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i11, int i12) {
        if (this.f56984h == null) {
            return 2;
        }
        this.f56979b.e();
        synchronized (this.f56984h) {
            ArrayList<d> arrayList = this.f56984h;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i12));
            d(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z11) {
        this.f56981d = z11;
    }
}
