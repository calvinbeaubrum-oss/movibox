package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.Processor;
import androidx.work.impl.d0;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.s;
import androidx.work.impl.v;
import androidx.work.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import s6.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class SystemAlarmDispatcher implements androidx.work.impl.e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13367l = j.i("SystemAlarmDispatcher");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t6.c f13369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WorkTimer f13370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Processor f13371d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d0 f13372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f13373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Intent> f13374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Intent f13375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public a f13376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public v f13377k;

    /* JADX INFO: compiled from: source.java */
    public static class AddRunnable implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;
        private final Intent mIntent;
        private final int mStartId;

        public AddRunnable(@NonNull SystemAlarmDispatcher systemAlarmDispatcher, @NonNull Intent intent, int i11) {
            this.mDispatcher = systemAlarmDispatcher;
            this.mIntent = intent;
            this.mStartId = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mDispatcher.a(this.mIntent, this.mStartId);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class DequeueAndCheckForCompletion implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;

        public DequeueAndCheckForCompletion(@NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
            this.mDispatcher = systemAlarmDispatcher;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mDispatcher.d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void b();
    }

    public SystemAlarmDispatcher(@NonNull Context context) {
        this(context, null, null);
    }

    public SystemAlarmDispatcher(@NonNull Context context, @Nullable Processor processor, @Nullable d0 d0Var) {
        Context applicationContext = context.getApplicationContext();
        this.f13368a = applicationContext;
        this.f13377k = new v();
        this.f13373g = new b(applicationContext, this.f13377k);
        d0Var = d0Var == null ? d0.p(context) : d0Var;
        this.f13372f = d0Var;
        this.f13370c = new WorkTimer(d0Var.n().k());
        processor = processor == null ? d0Var.r() : processor;
        this.f13371d = processor;
        this.f13369b = d0Var.v();
        processor.g(this);
        this.f13374h = new ArrayList();
        this.f13375i = null;
    }

    public boolean a(@NonNull Intent intent, int i11) {
        j jVarE = j.e();
        String str = f13367l;
        jVarE.a(str, "Adding command " + intent + " (" + i11 + ")");
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            j.e().k(str, "Unknown command. Ignoring");
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra("KEY_START_ID", i11);
        synchronized (this.f13374h) {
            try {
                boolean z11 = !this.f13374h.isEmpty();
                this.f13374h.add(intent);
                if (!z11) {
                    k();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }

    public final void b() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    @Override // androidx.work.impl.e
    /* JADX INFO: renamed from: c */
    public void l(@NonNull m mVar, boolean z11) {
        this.f13369b.a().execute(new AddRunnable(this, b.d(this.f13368a, mVar, z11), 0));
    }

    public void d() {
        j jVarE = j.e();
        String str = f13367l;
        jVarE.a(str, "Checking if commands are complete.");
        b();
        synchronized (this.f13374h) {
            try {
                if (this.f13375i != null) {
                    j.e().a(str, "Removing command " + this.f13375i);
                    if (!this.f13374h.remove(0).equals(this.f13375i)) {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                    this.f13375i = null;
                }
                t6.a aVarB = this.f13369b.b();
                if (!this.f13373g.p() && this.f13374h.isEmpty() && !aVarB.m()) {
                    j.e().a(str, "No more commands & intents.");
                    a aVar = this.f13376j;
                    if (aVar != null) {
                        aVar.b();
                    }
                } else if (!this.f13374h.isEmpty()) {
                    k();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Processor e() {
        return this.f13371d;
    }

    public t6.c f() {
        return this.f13369b;
    }

    public d0 g() {
        return this.f13372f;
    }

    public WorkTimer h() {
        return this.f13370c;
    }

    public final boolean i(@NonNull String str) {
        b();
        synchronized (this.f13374h) {
            try {
                Iterator<Intent> it = this.f13374h.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void j() {
        j.e().a(f13367l, "Destroying SystemAlarmDispatcher");
        this.f13371d.n(this);
        this.f13376j = null;
    }

    public final void k() {
        b();
        PowerManager.WakeLock wakeLockB = s.b(this.f13368a, "ProcessCommand");
        try {
            wakeLockB.acquire();
            this.f13372f.v().c(new Runnable() { // from class: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    Executor executorA;
                    DequeueAndCheckForCompletion dequeueAndCheckForCompletion;
                    synchronized (SystemAlarmDispatcher.this.f13374h) {
                        SystemAlarmDispatcher systemAlarmDispatcher = SystemAlarmDispatcher.this;
                        systemAlarmDispatcher.f13375i = systemAlarmDispatcher.f13374h.get(0);
                    }
                    Intent intent = SystemAlarmDispatcher.this.f13375i;
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = SystemAlarmDispatcher.this.f13375i.getIntExtra("KEY_START_ID", 0);
                        j jVarE = j.e();
                        String str = SystemAlarmDispatcher.f13367l;
                        jVarE.a(str, "Processing command " + SystemAlarmDispatcher.this.f13375i + ", " + intExtra);
                        PowerManager.WakeLock wakeLockB2 = s.b(SystemAlarmDispatcher.this.f13368a, action + " (" + intExtra + ")");
                        try {
                            j.e().a(str, "Acquiring operation wake lock (" + action + ") " + wakeLockB2);
                            wakeLockB2.acquire();
                            SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher2.f13373g.q(systemAlarmDispatcher2.f13375i, intExtra, systemAlarmDispatcher2);
                            j.e().a(str, "Releasing operation wake lock (" + action + ") " + wakeLockB2);
                            wakeLockB2.release();
                            executorA = SystemAlarmDispatcher.this.f13369b.a();
                            dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(SystemAlarmDispatcher.this);
                        } catch (Throwable th2) {
                            try {
                                j jVarE2 = j.e();
                                String str2 = SystemAlarmDispatcher.f13367l;
                                jVarE2.d(str2, "Unexpected error in onHandleIntent", th2);
                                j.e().a(str2, "Releasing operation wake lock (" + action + ") " + wakeLockB2);
                                wakeLockB2.release();
                                executorA = SystemAlarmDispatcher.this.f13369b.a();
                                dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(SystemAlarmDispatcher.this);
                            } catch (Throwable th3) {
                                j.e().a(SystemAlarmDispatcher.f13367l, "Releasing operation wake lock (" + action + ") " + wakeLockB2);
                                wakeLockB2.release();
                                SystemAlarmDispatcher.this.f13369b.a().execute(new DequeueAndCheckForCompletion(SystemAlarmDispatcher.this));
                                throw th3;
                            }
                        }
                        executorA.execute(dequeueAndCheckForCompletion);
                    }
                }
            });
        } finally {
            wakeLockB.release();
        }
    }

    public void l(@NonNull a aVar) {
        if (this.f13376j != null) {
            j.e().c(f13367l, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            this.f13376j = aVar;
        }
    }
}
