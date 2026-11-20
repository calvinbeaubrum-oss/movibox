package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.R$bool;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d0 extends WorkManager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13418k = androidx.work.j.i("WorkManagerImpl");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static d0 f13419l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static d0 f13420m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f13421n = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.work.a f13423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WorkDatabase f13424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t6.c f13425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<s> f13426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Processor f13427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.work.impl.utils.o f13428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f13430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r6.n f13431j;

    /* JADX INFO: compiled from: source.java */
    public class a implements j1.a<List<s6.u.c>, WorkInfo> {
        public a() {
        }

        @Override // j1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WorkInfo apply(List<s6.u.c> list) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            return list.get(0).a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class b {
        public static boolean a(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    public d0(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull t6.c cVar) {
        this(context, aVar, cVar, context.getResources().getBoolean(R$bool.workmanager_test_configuration));
    }

    public d0(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull t6.c cVar, @NonNull WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        androidx.work.j.h(new androidx.work.j.a(aVar.j()));
        r6.n nVar = new r6.n(applicationContext, cVar);
        this.f13431j = nVar;
        List<s> listK = k(applicationContext, aVar, nVar);
        w(context, aVar, cVar, workDatabase, listK, new Processor(context, aVar, cVar, workDatabase, listK));
    }

    public d0(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull t6.c cVar, boolean z11) {
        this(context, aVar, cVar, WorkDatabase.G(context.getApplicationContext(), cVar.b(), z11));
    }

    public static void i(@NonNull Context context, @NonNull androidx.work.a aVar) {
        synchronized (f13421n) {
            try {
                d0 d0Var = f13419l;
                if (d0Var != null && f13420m != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (d0Var == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (f13420m == null) {
                        f13420m = new d0(applicationContext, aVar, new t6.d(aVar.m()));
                    }
                    f13419l = f13420m;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    @Deprecated
    public static d0 o() {
        synchronized (f13421n) {
            try {
                d0 d0Var = f13419l;
                if (d0Var != null) {
                    return d0Var;
                }
                return f13420m;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static d0 p(@NonNull Context context) {
        d0 d0VarO;
        synchronized (f13421n) {
            try {
                d0VarO = o();
                if (d0VarO == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (!(applicationContext instanceof androidx.work.a.c)) {
                        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                    }
                    i(applicationContext, ((androidx.work.a.c) applicationContext).a());
                    d0VarO = p(applicationContext);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return d0VarO;
    }

    public void A(@NonNull u uVar) {
        B(uVar, null);
    }

    public void B(@NonNull u uVar, @Nullable WorkerParameters.a aVar) {
        this.f13425d.c(new StartWorkRunnable(this, uVar, aVar));
    }

    public void C(@NonNull s6.m mVar) {
        this.f13425d.c(new StopWorkRunnable(this, new u(mVar), true));
    }

    public void D(@NonNull u uVar) {
        this.f13425d.c(new StopWorkRunnable(this, uVar, false));
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public androidx.work.p b(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<androidx.work.k> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
        }
        return new w(this, str, existingWorkPolicy, list);
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public androidx.work.l c(@NonNull String str) {
        CancelWorkRunnable cancelWorkRunnableForTag = CancelWorkRunnable.forTag(str, this);
        this.f13425d.c(cancelWorkRunnableForTag);
        return cancelWorkRunnableForTag.getOperation();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public androidx.work.l e(@NonNull List<? extends androidx.work.r> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new w(this, list).a();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public androidx.work.l f(@NonNull String str, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull androidx.work.m mVar) {
        return existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.UPDATE ? WorkerUpdater.c(this, str, mVar) : l(str, existingPeriodicWorkPolicy, mVar).a();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public LiveData<WorkInfo> h(@NonNull UUID uuid) {
        return LiveDataUtils.a(this.f13424c.N().B(Collections.singletonList(uuid.toString())), new a(), this.f13425d);
    }

    @NonNull
    public androidx.work.l j(@NonNull UUID uuid) {
        CancelWorkRunnable cancelWorkRunnableForId = CancelWorkRunnable.forId(uuid, this);
        this.f13425d.c(cancelWorkRunnableForId);
        return cancelWorkRunnableForId.getOperation();
    }

    @NonNull
    public List<s> k(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull r6.n nVar) {
        return Arrays.asList(t.a(context, this), new androidx.work.impl.background.greedy.a(context, aVar, nVar, this));
    }

    @NonNull
    public w l(@NonNull String str, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull androidx.work.m mVar) {
        return new w(this, str, existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP ? ExistingWorkPolicy.KEEP : ExistingWorkPolicy.REPLACE, Collections.singletonList(mVar));
    }

    @NonNull
    public Context m() {
        return this.f13422a;
    }

    @NonNull
    public androidx.work.a n() {
        return this.f13423b;
    }

    @NonNull
    public androidx.work.impl.utils.o q() {
        return this.f13428g;
    }

    @NonNull
    public Processor r() {
        return this.f13427f;
    }

    @NonNull
    public List<s> s() {
        return this.f13426e;
    }

    @NonNull
    public r6.n t() {
        return this.f13431j;
    }

    @NonNull
    public WorkDatabase u() {
        return this.f13424c;
    }

    @NonNull
    public t6.c v() {
        return this.f13425d;
    }

    public final void w(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull t6.c cVar, @NonNull WorkDatabase workDatabase, @NonNull List<s> list, @NonNull Processor processor) {
        Context applicationContext = context.getApplicationContext();
        this.f13422a = applicationContext;
        this.f13423b = aVar;
        this.f13425d = cVar;
        this.f13424c = workDatabase;
        this.f13426e = list;
        this.f13427f = processor;
        this.f13428g = new androidx.work.impl.utils.o(workDatabase);
        this.f13429h = false;
        if (Build.VERSION.SDK_INT >= 24 && b.a(applicationContext)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        this.f13425d.c(new ForceStopRunnable(applicationContext, this));
    }

    public void x() {
        synchronized (f13421n) {
            try {
                this.f13429h = true;
                BroadcastReceiver.PendingResult pendingResult = this.f13430i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.f13430i = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void y() {
        if (Build.VERSION.SDK_INT >= 23) {
            o6.l.b(m());
        }
        u().N().p();
        t.b(n(), u(), s());
    }

    public void z(@NonNull BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f13421n) {
            try {
                this.f13430i = pendingResult;
                if (this.f13429h) {
                    pendingResult.finish();
                    this.f13430i = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
