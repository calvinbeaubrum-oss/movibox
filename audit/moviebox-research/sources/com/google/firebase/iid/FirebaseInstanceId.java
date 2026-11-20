package com.google.firebase.iid;

import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FirebaseInstanceId {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static u f40612j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @VisibleForTesting
    public static ScheduledExecutorService f40614l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final Executor f40615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jj.e f40616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f40617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f40618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f40619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final cl.g f40620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f40621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<al.a.InterfaceC0026a> f40622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f40611i = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f40613k = Pattern.compile("\\AA[\\w-]{38}\\z");

    public FirebaseInstanceId(jj.e eVar, bl.b<xl.i> bVar, bl.b<HeartBeatInfo> bVar2, cl.g gVar) {
        this(eVar, new n(eVar.j()), b.b(), b.b(), bVar, bVar2, gVar);
    }

    public FirebaseInstanceId(jj.e eVar, n nVar, Executor executor, Executor executor2, bl.b<xl.i> bVar, bl.b<HeartBeatInfo> bVar2, cl.g gVar) {
        this.f40621g = false;
        this.f40622h = new ArrayList();
        if (n.c(eVar) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        synchronized (FirebaseInstanceId.class) {
            try {
                if (f40612j == null) {
                    f40612j = new u(eVar.j());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f40616b = eVar;
        this.f40617c = nVar;
        this.f40618d = new k(eVar, nVar, bVar, bVar2, gVar);
        this.f40615a = executor2;
        this.f40619e = new s(executor);
        this.f40620f = gVar;
    }

    public static <T> T c(@NonNull Task<T> task) throws InterruptedException {
        Preconditions.checkNotNull(task, "Task must not be null");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.addOnCompleteListener(d.f40630a, new OnCompleteListener(countDownLatch) { // from class: com.google.firebase.iid.e

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CountDownLatch f40631a;

            {
                this.f40631a = countDownLatch;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task task2) {
                this.f40631a.countDown();
            }
        });
        countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
        return (T) k(task);
    }

    public static void e(@NonNull jj.e eVar) {
        Preconditions.checkNotEmpty(eVar.m().e(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        Preconditions.checkNotEmpty(eVar.m().c(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        Preconditions.checkNotEmpty(eVar.m().b(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        Preconditions.checkArgument(t(eVar.m().c()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(s(eVar.m().b()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull jj.e eVar) {
        e(eVar);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) eVar.i(FirebaseInstanceId.class);
        Preconditions.checkNotNull(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    public static <T> T k(@NonNull Task<T> task) {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        }
        throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
    }

    public static boolean q() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
    }

    public static boolean s(String str) {
        return f40613k.matcher(str).matches();
    }

    public static boolean t(String str) {
        return str.contains(":");
    }

    public static String z(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase(AppMeasurement.FCM_ORIGIN) || str.equalsIgnoreCase(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) ? "*" : str;
    }

    public synchronized void A() {
        f40612j.d();
    }

    public synchronized void B(boolean z11) {
        this.f40621g = z11;
    }

    public synchronized void C() {
        if (this.f40621g) {
            return;
        }
        D(0L);
    }

    public synchronized void D(long j11) {
        f(new SyncTask(this, Math.min(Math.max(30L, j11 + j11), f40611i)), j11);
        this.f40621g = true;
    }

    public boolean E(@Nullable u.a aVar) {
        return aVar == null || aVar.c(this.f40617c.a());
    }

    public void a(al.a.InterfaceC0026a interfaceC0026a) {
        this.f40622h.add(interfaceC0026a);
    }

    public final <T> T b(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    A();
                }
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e11);
        }
    }

    public String d() throws IOException {
        return n(n.c(this.f40616b), "*");
    }

    public void f(Runnable runnable, long j11) {
        synchronized (FirebaseInstanceId.class) {
            try {
                if (f40614l == null) {
                    f40614l = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
                }
                f40614l.schedule(runnable, j11, TimeUnit.SECONDS);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public jj.e g() {
        return this.f40616b;
    }

    public String h() {
        try {
            f40612j.i(this.f40616b.n());
            return (String) c(this.f40620f.getId());
        } catch (InterruptedException e11) {
            throw new IllegalStateException(e11);
        }
    }

    @NonNull
    @Deprecated
    public Task<l> i() {
        e(this.f40616b);
        return j(n.c(this.f40616b), "*");
    }

    public final Task<l> j(final String str, String str2) {
        final String strZ = z(str2);
        return Tasks.forResult(null).continueWithTask(this.f40615a, new Continuation(this, str, strZ) { // from class: com.google.firebase.iid.c

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final FirebaseInstanceId f40627a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f40628b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f40629c;

            {
                this.f40627a = this;
                this.f40628b = str;
                this.f40629c = strZ;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task) {
                return this.f40627a.y(this.f40628b, this.f40629c, task);
            }
        });
    }

    public final String l() {
        return "[DEFAULT]".equals(this.f40616b.l()) ? "" : this.f40616b.n();
    }

    @Nullable
    @Deprecated
    public String m() {
        e(this.f40616b);
        u.a aVarO = o();
        if (E(aVarO)) {
            C();
        }
        return u.a.b(aVarO);
    }

    @Nullable
    @Deprecated
    public String n(@NonNull String str, @NonNull String str2) throws IOException {
        e(this.f40616b);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((l) b(j(str, str2))).a();
        }
        throw new IOException("MAIN_THREAD");
    }

    @Nullable
    public u.a o() {
        return p(n.c(this.f40616b), "*");
    }

    @Nullable
    @VisibleForTesting
    public u.a p(String str, String str2) {
        return f40612j.f(l(), str, str2);
    }

    @VisibleForTesting
    public boolean r() {
        return this.f40617c.g();
    }

    public final /* synthetic */ Task v(String str, String str2, String str3, String str4) throws Exception {
        f40612j.h(l(), str, str2, str4, this.f40617c.a());
        return Tasks.forResult(new m(str3, str4));
    }

    public final /* synthetic */ void w(u.a aVar, l lVar) {
        String strA = lVar.a();
        if (aVar == null || !strA.equals(aVar.f40672a)) {
            Iterator<al.a.InterfaceC0026a> it = this.f40622h.iterator();
            while (it.hasNext()) {
                it.next().a(strA);
            }
        }
    }

    public final /* synthetic */ Task x(final String str, final String str2, final String str3, final u.a aVar) {
        return this.f40618d.d(str, str2, str3).onSuccessTask(this.f40615a, new SuccessContinuation(this, str2, str3, str) { // from class: com.google.firebase.iid.g

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final FirebaseInstanceId f40637a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f40638b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f40639c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f40640d;

            {
                this.f40637a = this;
                this.f40638b = str2;
                this.f40639c = str3;
                this.f40640d = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public Task then(Object obj) {
                return this.f40637a.v(this.f40638b, this.f40639c, this.f40640d, (String) obj);
            }
        }).addOnSuccessListener(h.f40641a, (OnSuccessListener<? super TContinuationResult>) new OnSuccessListener(this, aVar) { // from class: com.google.firebase.iid.i

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final FirebaseInstanceId f40642a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final u.a f40643b;

            {
                this.f40642a = this;
                this.f40643b = aVar;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Object obj) {
                this.f40642a.w(this.f40643b, (l) obj);
            }
        });
    }

    public final /* synthetic */ Task y(final String str, final String str2, Task task) throws Exception {
        final String strH = h();
        final u.a aVarP = p(str, str2);
        return !E(aVarP) ? Tasks.forResult(new m(strH, aVarP.f40672a)) : this.f40619e.a(str, str2, new s.a(this, strH, str, str2, aVarP) { // from class: com.google.firebase.iid.f

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final FirebaseInstanceId f40632a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f40633b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f40634c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f40635d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final u.a f40636e;

            {
                this.f40632a = this;
                this.f40633b = strH;
                this.f40634c = str;
                this.f40635d = str2;
                this.f40636e = aVarP;
            }

            @Override // com.google.firebase.iid.s.a
            public Task start() {
                return this.f40632a.x(this.f40633b, this.f40634c, this.f40635d, this.f40636e);
            }
        });
    }
}
