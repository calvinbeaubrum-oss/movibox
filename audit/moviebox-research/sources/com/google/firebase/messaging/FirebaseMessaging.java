package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessaging {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f40740o = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static t0 f40741p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    @SuppressLint({"FirebaseUnknownNullness"})
    public static cg.h f40742q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static ScheduledExecutorService f40743r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.e f40744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final al.a f40745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cl.g f40746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f40747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0 f40748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p0 f40749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f40750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f40751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f40752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Executor f40753j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Task<x0> f40754k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f0 f40755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f40756m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f40757n;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final yk.d f40758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f40759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public yk.b<jj.b> f40760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Boolean f40761d;

        public a(yk.d dVar) {
            this.f40758a = dVar;
        }

        public synchronized void b() {
            try {
                if (this.f40759b) {
                    return;
                }
                Boolean boolE = e();
                this.f40761d = boolE;
                if (boolE == null) {
                    yk.b<jj.b> bVar = new yk.b() { // from class: com.google.firebase.messaging.x
                        @Override // yk.b
                        public final void a(yk.a aVar) {
                            this.f40951a.d(aVar);
                        }
                    };
                    this.f40760c = bVar;
                    this.f40758a.a(jj.b.class, bVar);
                }
                this.f40759b = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }

        public synchronized boolean c() {
            Boolean bool;
            try {
                b();
                bool = this.f40761d;
            } catch (Throwable th2) {
                throw th2;
            }
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.f40744a.s();
        }

        public final /* synthetic */ void d(yk.a aVar) {
            if (c()) {
                FirebaseMessaging.this.E();
            }
        }

        @Nullable
        public final Boolean e() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context contextJ = FirebaseMessaging.this.f40744a.j();
            SharedPreferences sharedPreferences = contextJ.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = contextJ.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(contextJ.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }

    public FirebaseMessaging(jj.e eVar, @Nullable al.a aVar, bl.b<xl.i> bVar, bl.b<HeartBeatInfo> bVar2, cl.g gVar, @Nullable cg.h hVar, yk.d dVar) {
        this(eVar, aVar, bVar, bVar2, gVar, hVar, dVar, new f0(eVar.j()));
    }

    public FirebaseMessaging(jj.e eVar, @Nullable al.a aVar, bl.b<xl.i> bVar, bl.b<HeartBeatInfo> bVar2, cl.g gVar, @Nullable cg.h hVar, yk.d dVar, f0 f0Var) {
        this(eVar, aVar, gVar, hVar, dVar, f0Var, new a0(eVar, f0Var, bVar, bVar2, gVar), n.f(), n.c(), n.b());
    }

    public FirebaseMessaging(jj.e eVar, @Nullable al.a aVar, cl.g gVar, @Nullable cg.h hVar, yk.d dVar, f0 f0Var, a0 a0Var, Executor executor, Executor executor2, Executor executor3) {
        this.f40756m = false;
        f40742q = hVar;
        this.f40744a = eVar;
        this.f40745b = aVar;
        this.f40746c = gVar;
        this.f40750g = new a(dVar);
        Context contextJ = eVar.j();
        this.f40747d = contextJ;
        p pVar = new p();
        this.f40757n = pVar;
        this.f40755l = f0Var;
        this.f40752i = executor;
        this.f40748e = a0Var;
        this.f40749f = new p0(executor);
        this.f40751h = executor2;
        this.f40753j = executor3;
        Context contextJ2 = eVar.j();
        if (contextJ2 instanceof Application) {
            ((Application) contextJ2).registerActivityLifecycleCallbacks(pVar);
        } else {
            Log.w("FirebaseMessaging", "Context " + contextJ2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (aVar != null) {
            aVar.b(new al.a.InterfaceC0026a() { // from class: com.google.firebase.messaging.q
                @Override // al.a.InterfaceC0026a
                public final void a(String str) {
                    this.f40878a.y(str);
                }
            });
        }
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f40884a.z();
            }
        });
        Task<x0> taskE = x0.e(this, f0Var, a0Var, contextJ, n.g());
        this.f40754k = taskE;
        taskE.addOnSuccessListener(executor2, new OnSuccessListener() { // from class: com.google.firebase.messaging.s
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f40917a.A((x0) obj);
            }
        });
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f40924a.B();
            }
        });
    }

    @NonNull
    @Keep
    public static synchronized FirebaseMessaging getInstance(@NonNull jj.e eVar) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) eVar.i(FirebaseMessaging.class);
        Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    @NonNull
    public static synchronized FirebaseMessaging m() {
        return getInstance(jj.e.k());
    }

    @NonNull
    public static synchronized t0 n(Context context) {
        try {
            if (f40741p == null) {
                f40741p = new t0(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f40741p;
    }

    @Nullable
    public static cg.h r() {
        return f40742q;
    }

    public final /* synthetic */ void A(x0 x0Var) {
        if (t()) {
            x0Var.o();
        }
    }

    public final /* synthetic */ void B() {
        l0.c(this.f40747d);
    }

    public synchronized void C(boolean z11) {
        this.f40756m = z11;
    }

    public final synchronized void D() {
        if (!this.f40756m) {
            F(0L);
        }
    }

    public final void E() {
        al.a aVar = this.f40745b;
        if (aVar != null) {
            aVar.a();
        } else if (G(q())) {
            D();
        }
    }

    public synchronized void F(long j11) {
        k(new SyncTask(this, Math.min(Math.max(30L, 2 * j11), f40740o)), j11);
        this.f40756m = true;
    }

    public boolean G(@Nullable t0.a aVar) {
        return aVar == null || aVar.b(this.f40755l.a());
    }

    public String j() throws IOException {
        al.a aVar = this.f40745b;
        if (aVar != null) {
            try {
                return (String) Tasks.await(aVar.c());
            } catch (InterruptedException | ExecutionException e11) {
                throw new IOException(e11);
            }
        }
        final t0.a aVarQ = q();
        if (!G(aVarQ)) {
            return aVarQ.f40927a;
        }
        final String strC = f0.c(this.f40744a);
        try {
            return (String) Tasks.await(this.f40749f.b(strC, new p0.a() { // from class: com.google.firebase.messaging.u
                @Override // com.google.firebase.messaging.p0.a
                public final Task start() {
                    return this.f40930a.v(strC, aVarQ);
                }
            }));
        } catch (InterruptedException | ExecutionException e12) {
            throw new IOException(e12);
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    public void k(Runnable runnable, long j11) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f40743r == null) {
                    f40743r = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
                }
                f40743r.schedule(runnable, j11, TimeUnit.SECONDS);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Context l() {
        return this.f40747d;
    }

    public final String o() {
        return "[DEFAULT]".equals(this.f40744a.l()) ? "" : this.f40744a.n();
    }

    @NonNull
    public Task<String> p() {
        al.a aVar = this.f40745b;
        if (aVar != null) {
            return aVar.c();
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f40751h.execute(new Runnable() { // from class: com.google.firebase.messaging.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f40937a.x(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Nullable
    public t0.a q() {
        return n(this.f40747d).d(o(), f0.c(this.f40744a));
    }

    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void y(String str) {
        if ("[DEFAULT]".equals(this.f40744a.l())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invoking onNewToken for app: ");
                sb2.append(this.f40744a.l());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new m(this.f40747d).k(intent);
        }
    }

    public boolean t() {
        return this.f40750g.c();
    }

    public boolean u() {
        return this.f40755l.g();
    }

    public final /* synthetic */ Task v(final String str, final t0.a aVar) {
        return this.f40748e.e().onSuccessTask(this.f40753j, new SuccessContinuation() { // from class: com.google.firebase.messaging.w
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.f40943a.w(str, aVar, (String) obj);
            }
        });
    }

    public final /* synthetic */ Task w(String str, t0.a aVar, String str2) throws Exception {
        n(this.f40747d).f(o(), str, str2, this.f40755l.a());
        if (aVar == null || !str2.equals(aVar.f40927a)) {
            y(str2);
        }
        return Tasks.forResult(str2);
    }

    public final /* synthetic */ void x(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(j());
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    public final /* synthetic */ void z() {
        if (t()) {
            E();
        }
    }
}
