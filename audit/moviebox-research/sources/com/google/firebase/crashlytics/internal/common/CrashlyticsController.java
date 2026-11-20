package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CrashlyticsController {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final FilenameFilter f40110s = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.common.f
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return CrashlyticsController.K(file, str);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f40112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f40113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jk.i f40114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CrashlyticsBackgroundWorker f40115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f40116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final nk.f f40117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.firebase.crashlytics.internal.common.a f40118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final jk.c f40119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final gk.a f40120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final hk.a f40121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e0 f40122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k f40123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ok.g f40124n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TaskCompletionSource<Boolean> f40125o = new TaskCompletionSource<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TaskCompletionSource<Boolean> f40126p = new TaskCompletionSource<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TaskCompletionSource<Void> f40127q = new TaskCompletionSource<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f40128r = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class a implements k.a {
        public a() {
        }

        @Override // com.google.firebase.crashlytics.internal.common.k.a
        public void a(@NonNull ok.g gVar, @NonNull Thread thread, @NonNull Throwable th2) {
            CrashlyticsController.this.H(gVar, thread, th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class b implements Callable<Task<Void>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f40130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f40131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Thread f40132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ok.g f40133d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f40134f;

        /* JADX INFO: compiled from: source.java */
        public class a implements SuccessContinuation<ok.d, Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Executor f40136a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f40137b;

            public a(Executor executor, String str) {
                this.f40136a = executor;
                this.f40137b = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            @NonNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task<Void> then(@Nullable ok.d dVar) throws Exception {
                if (dVar == null) {
                    gk.f.f().k("Received null app settings, cannot send reports at crash time.");
                    return Tasks.forResult(null);
                }
                Task[] taskArr = new Task[2];
                taskArr[0] = CrashlyticsController.this.N();
                taskArr[1] = CrashlyticsController.this.f40122l.w(this.f40136a, b.this.f40134f ? this.f40137b : null);
                return Tasks.whenAll((Task<?>[]) taskArr);
            }
        }

        public b(long j11, Throwable th2, Thread thread, ok.g gVar, boolean z11) {
            this.f40130a = j11;
            this.f40131b = th2;
            this.f40132c = thread;
            this.f40133d = gVar;
            this.f40134f = z11;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task<Void> call() throws Exception {
            long jG = CrashlyticsController.G(this.f40130a);
            String strD = CrashlyticsController.this.D();
            if (strD == null) {
                gk.f.f().d("Tried to write a fatal exception while no session was open.");
                return Tasks.forResult(null);
            }
            CrashlyticsController.this.f40113c.a();
            CrashlyticsController.this.f40122l.r(this.f40131b, this.f40132c, strD, jG);
            CrashlyticsController.this.y(this.f40130a);
            CrashlyticsController.this.v(this.f40133d);
            CrashlyticsController.this.x(new com.google.firebase.crashlytics.internal.common.e(CrashlyticsController.this.f40116f).toString());
            if (!CrashlyticsController.this.f40112b.d()) {
                return Tasks.forResult(null);
            }
            Executor executorC = CrashlyticsController.this.f40115e.c();
            return this.f40133d.a().onSuccessTask(executorC, new a(executorC, strD));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class c implements SuccessContinuation<Void, Boolean> {
        public c() {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task<Boolean> then(@Nullable Void r11) throws Exception {
            return Tasks.forResult(Boolean.TRUE);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class d implements SuccessContinuation<Boolean, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f40140a;

        /* JADX INFO: compiled from: source.java */
        public class a implements Callable<Task<Void>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Boolean f40142a;

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0423a implements SuccessContinuation<ok.d, Void> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Executor f40144a;

                public C0423a(Executor executor) {
                    this.f40144a = executor;
                }

                @Override // com.google.android.gms.tasks.SuccessContinuation
                @NonNull
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Task<Void> then(@Nullable ok.d dVar) throws Exception {
                    if (dVar == null) {
                        gk.f.f().k("Received null app settings at app startup. Cannot send cached reports");
                        return Tasks.forResult(null);
                    }
                    CrashlyticsController.this.N();
                    CrashlyticsController.this.f40122l.v(this.f40144a);
                    CrashlyticsController.this.f40127q.trySetResult(null);
                    return Tasks.forResult(null);
                }
            }

            public a(Boolean bool) {
                this.f40142a = bool;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task<Void> call() throws Exception {
                if (this.f40142a.booleanValue()) {
                    gk.f.f().b("Sending cached crash reports...");
                    CrashlyticsController.this.f40112b.c(this.f40142a.booleanValue());
                    Executor executorC = CrashlyticsController.this.f40115e.c();
                    return d.this.f40140a.onSuccessTask(executorC, new C0423a(executorC));
                }
                gk.f.f().i("Deleting cached crash reports...");
                CrashlyticsController.s(CrashlyticsController.this.L());
                CrashlyticsController.this.f40122l.u();
                CrashlyticsController.this.f40127q.trySetResult(null);
                return Tasks.forResult(null);
            }
        }

        public d(Task task) {
            this.f40140a = task;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task<Void> then(@Nullable Boolean bool) throws Exception {
            return CrashlyticsController.this.f40115e.i(new a(bool));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class e implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f40146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f40147b;

        public e(long j11, String str) {
            this.f40146a = j11;
            this.f40147b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            if (CrashlyticsController.this.J()) {
                return null;
            }
            CrashlyticsController.this.f40119i.g(this.f40146a, this.f40147b);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class f implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f40149a;

        public f(String str) {
            this.f40149a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            CrashlyticsController.this.x(this.f40149a);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class g implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f40151a;

        public g(long j11) {
            this.f40151a = j11;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong(CampaignEx.JSON_KEY_TIMESTAMP, this.f40151a);
            CrashlyticsController.this.f40121k.a("_ae", bundle);
            return null;
        }
    }

    public CrashlyticsController(Context context, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, o oVar, m mVar, nk.f fVar, h hVar, com.google.firebase.crashlytics.internal.common.a aVar, jk.i iVar, jk.c cVar, e0 e0Var, gk.a aVar2, hk.a aVar3) {
        this.f40111a = context;
        this.f40115e = crashlyticsBackgroundWorker;
        this.f40116f = oVar;
        this.f40112b = mVar;
        this.f40117g = fVar;
        this.f40113c = hVar;
        this.f40118h = aVar;
        this.f40114d = iVar;
        this.f40119i = cVar;
        this.f40120j = aVar2;
        this.f40121k = aVar3;
        this.f40122l = e0Var;
    }

    public static boolean C() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static long E() {
        return G(System.currentTimeMillis());
    }

    @NonNull
    public static List<r> F(gk.g gVar, String str, nk.f fVar, byte[] bArr) {
        File fileO = fVar.o(str, "user-data");
        File fileO2 = fVar.o(str, "keys");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.google.firebase.crashlytics.internal.common.d("logs_file", "logs", bArr));
        arrayList.add(new n("crash_meta_file", TtmlNode.TAG_METADATA, gVar.c()));
        arrayList.add(new n("session_meta_file", "session", gVar.f()));
        arrayList.add(new n("app_meta_file", MBridgeConstans.DYNAMIC_VIEW_WX_APP, gVar.d()));
        arrayList.add(new n("device_meta_file", "device", gVar.a()));
        arrayList.add(new n("os_meta_file", "os", gVar.e()));
        arrayList.add(new n("minidump_file", "minidump", gVar.b()));
        arrayList.add(new n("user_meta_file", "user", fileO));
        arrayList.add(new n("keys_file", "keys", fileO2));
        return arrayList;
    }

    public static long G(long j11) {
        return j11 / 1000;
    }

    public static /* synthetic */ boolean K(File file, String str) {
        return str.startsWith(".ae");
    }

    public static kk.f.a p(o oVar, com.google.firebase.crashlytics.internal.common.a aVar) {
        return kk.f.a.b(oVar.f(), aVar.f40182e, aVar.f40183f, oVar.a(), DeliveryMechanism.determineFrom(aVar.f40180c).getId(), aVar.f40184g);
    }

    public static kk.f.b q() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return kk.f.b.c(CommonUtils.l(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.s(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), CommonUtils.y(), CommonUtils.m(), Build.MANUFACTURER, Build.PRODUCT);
    }

    public static kk.f.c r() {
        return kk.f.c.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.z());
    }

    public static void s(List<File> list) {
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    public final void A(String str) {
        gk.f.f().i("Finalizing native report for session " + str);
        gk.g gVarA = this.f40120j.a(str);
        File fileB = gVarA.b();
        if (fileB == null || !fileB.exists()) {
            gk.f.f().k("No minidump data found for session " + str);
            return;
        }
        long jLastModified = fileB.lastModified();
        jk.c cVar = new jk.c(this.f40117g, str);
        File fileI = this.f40117g.i(str);
        if (!fileI.isDirectory()) {
            gk.f.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        y(jLastModified);
        List<r> listF = F(gVarA, str, this.f40117g, cVar.b());
        s.b(fileI, listF);
        gk.f.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.f40122l.h(str, listF);
        cVar.a();
    }

    public boolean B(ok.g gVar) {
        this.f40115e.b();
        if (J()) {
            gk.f.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        gk.f.f().i("Finalizing previously open sessions.");
        try {
            w(true, gVar);
            gk.f.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e11) {
            gk.f.f().e("Unable to finalize previously open sessions.", e11);
            return false;
        }
    }

    @Nullable
    public final String D() {
        SortedSet<String> sortedSetN = this.f40122l.n();
        if (sortedSetN.isEmpty()) {
            return null;
        }
        return sortedSetN.first();
    }

    public void H(@NonNull ok.g gVar, @NonNull Thread thread, @NonNull Throwable th2) {
        I(gVar, thread, th2, false);
    }

    public synchronized void I(@NonNull ok.g gVar, @NonNull Thread thread, @NonNull Throwable th2, boolean z11) {
        try {
            gk.f.f().b("Handling uncaught exception \"" + th2 + "\" from thread " + thread.getName());
            try {
                Utils.d(this.f40115e.i(new b(System.currentTimeMillis(), th2, thread, gVar, z11)));
            } catch (TimeoutException unused) {
                gk.f.f().d("Cannot send reports. Timed out while fetching settings.");
            } catch (Exception e11) {
                gk.f.f().e("Error handling uncaught exception", e11);
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public boolean J() {
        k kVar = this.f40123m;
        return kVar != null && kVar.a();
    }

    public List<File> L() {
        return this.f40117g.f(f40110s);
    }

    public final Task<Void> M(long j11) {
        if (C()) {
            gk.f.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult(null);
        }
        gk.f.f().b("Logging app exception event to Firebase Analytics");
        return Tasks.call(new ScheduledThreadPoolExecutor(1), new g(j11));
    }

    public final Task<Void> N() {
        ArrayList arrayList = new ArrayList();
        for (File file : L()) {
            try {
                arrayList.add(M(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                gk.f.f().k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    public void O(String str) {
        this.f40115e.h(new f(str));
    }

    public Task<Void> P() {
        this.f40126p.trySetResult(Boolean.TRUE);
        return this.f40127q.getTask();
    }

    public void Q(String str, String str2) {
        try {
            this.f40114d.l(str, str2);
        } catch (IllegalArgumentException e11) {
            Context context = this.f40111a;
            if (context != null && CommonUtils.w(context)) {
                throw e11;
            }
            gk.f.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    public void R(String str) {
        this.f40114d.m(str);
    }

    public Task<Void> S(Task<ok.d> task) {
        if (this.f40122l.l()) {
            gk.f.f().i("Crash reports are available to be sent.");
            return T().onSuccessTask(new d(task));
        }
        gk.f.f().i("No crash reports are available to be sent.");
        this.f40125o.trySetResult(Boolean.FALSE);
        return Tasks.forResult(null);
    }

    public final Task<Boolean> T() {
        if (this.f40112b.d()) {
            gk.f.f().b("Automatic data collection is enabled. Allowing upload.");
            this.f40125o.trySetResult(Boolean.FALSE);
            return Tasks.forResult(Boolean.TRUE);
        }
        gk.f.f().b("Automatic data collection is disabled.");
        gk.f.f().i("Notifying that unsent reports are available.");
        this.f40125o.trySetResult(Boolean.TRUE);
        Task<TContinuationResult> taskOnSuccessTask = this.f40112b.i().onSuccessTask(new c());
        gk.f.f().b("Waiting for send/deleteUnsentReports to be called.");
        return Utils.j(taskOnSuccessTask, this.f40126p.getTask());
    }

    public final void U(String str) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 30) {
            gk.f.f().i("ANR feature enabled, but device is API " + i11);
            return;
        }
        List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.f40111a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
        if (historicalProcessExitReasons.size() != 0) {
            this.f40122l.t(str, historicalProcessExitReasons, new jk.c(this.f40117g, str), jk.i.i(str, this.f40117g, this.f40115e));
        } else {
            gk.f.f().i("No ApplicationExitInfo available. Session: " + str);
        }
    }

    public void V(@NonNull final Thread thread, @NonNull final Throwable th2) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.f40115e.g(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.6
            @Override // java.lang.Runnable
            public void run() {
                if (CrashlyticsController.this.J()) {
                    return;
                }
                long jG = CrashlyticsController.G(jCurrentTimeMillis);
                String strD = CrashlyticsController.this.D();
                if (strD == null) {
                    gk.f.f().k("Tried to write a non-fatal exception while no session was open.");
                } else {
                    CrashlyticsController.this.f40122l.s(th2, thread, strD, jG);
                }
            }
        });
    }

    public void W(long j11, String str) {
        this.f40115e.h(new e(j11, str));
    }

    @NonNull
    public Task<Boolean> o() {
        if (this.f40128r.compareAndSet(false, true)) {
            return this.f40125o.getTask();
        }
        gk.f.f().k("checkForUnsentReports should only be called once per execution.");
        return Tasks.forResult(Boolean.FALSE);
    }

    public Task<Void> t() {
        this.f40126p.trySetResult(Boolean.FALSE);
        return this.f40127q.getTask();
    }

    public boolean u() {
        if (!this.f40113c.c()) {
            String strD = D();
            return strD != null && this.f40120j.d(strD);
        }
        gk.f.f().i("Found previous crash marker.");
        this.f40113c.d();
        return true;
    }

    public void v(ok.g gVar) {
        w(false, gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(boolean z11, ok.g gVar) {
        ArrayList arrayList = new ArrayList(this.f40122l.n());
        if (arrayList.size() <= z11) {
            gk.f.f().i("No open sessions to be closed.");
            return;
        }
        String str = (String) arrayList.get(z11 ? 1 : 0);
        if (gVar.b().f72457b.f72465b) {
            U(str);
        } else {
            gk.f.f().i("ANR feature disabled.");
        }
        if (this.f40120j.d(str)) {
            A(str);
        }
        this.f40122l.i(E(), z11 != 0 ? (String) arrayList.get(0) : null);
    }

    public final void x(String str) {
        long jE = E();
        gk.f.f().b("Opening a new session with ID " + str);
        this.f40120j.c(str, String.format(Locale.US, "Crashlytics Android SDK/%s", CrashlyticsCore.l()), jE, kk.f.b(p(this.f40116f, this.f40118h), r(), q()));
        this.f40119i.e(str);
        this.f40122l.o(str, jE);
    }

    public final void y(long j11) {
        try {
            if (this.f40117g.e(".ae" + j11).createNewFile()) {
            } else {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e11) {
            gk.f.f().l("Could not create app exception marker file.", e11);
        }
    }

    public void z(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, ok.g gVar) {
        this.f40124n = gVar;
        O(str);
        k kVar = new k(new a(), gVar, uncaughtExceptionHandler, this.f40120j);
        this.f40123m = kVar;
        Thread.setDefaultUncaughtExceptionHandler(kVar);
    }
}
