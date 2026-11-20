package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CrashlyticsCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jj.e f40154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f40155c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f40158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f40159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f40160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CrashlyticsController f40161i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o f40162j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final nk.f f40163k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ik.b f40164l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final hk.a f40165m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ExecutorService f40166n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CrashlyticsBackgroundWorker f40167o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final gk.a f40168p;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f40157e = System.currentTimeMillis();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f40156d = new t();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class a implements Callable<Task<Void>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ok.g f40169a;

        public a(ok.g gVar) {
            this.f40169a = gVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task<Void> call() throws Exception {
            return CrashlyticsCore.this.i(this.f40169a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class b implements Callable<Boolean> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            try {
                boolean zD = CrashlyticsCore.this.f40158f.d();
                if (!zD) {
                    gk.f.f().k("Initialization marker file was not properly removed.");
                }
                return Boolean.valueOf(zD);
            } catch (Exception e11) {
                gk.f.f().e("Problem encountered deleting Crashlytics initialization marker.", e11);
                return Boolean.FALSE;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class c implements Callable<Boolean> {
        public c() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(CrashlyticsCore.this.f40161i.u());
        }
    }

    public CrashlyticsCore(jj.e eVar, o oVar, gk.a aVar, m mVar, ik.b bVar, hk.a aVar2, nk.f fVar, ExecutorService executorService) {
        this.f40154b = eVar;
        this.f40155c = mVar;
        this.f40153a = eVar.j();
        this.f40162j = oVar;
        this.f40168p = aVar;
        this.f40164l = bVar;
        this.f40165m = aVar2;
        this.f40166n = executorService;
        this.f40163k = fVar;
        this.f40167o = new CrashlyticsBackgroundWorker(executorService);
    }

    public static String l() {
        return "18.3.2";
    }

    public static boolean m(String str, boolean z11) {
        if (!z11) {
            gk.f.f().i("Configured not to require a build ID.");
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        Log.e("FirebaseCrashlytics", InstructionFileId.DOT);
        Log.e("FirebaseCrashlytics", ".     |  | ");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".   \\ |  | /");
        Log.e("FirebaseCrashlytics", ".    \\    /");
        Log.e("FirebaseCrashlytics", ".     \\  /");
        Log.e("FirebaseCrashlytics", ".      \\/");
        Log.e("FirebaseCrashlytics", InstructionFileId.DOT);
        Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
        Log.e("FirebaseCrashlytics", InstructionFileId.DOT);
        Log.e("FirebaseCrashlytics", ".      /\\");
        Log.e("FirebaseCrashlytics", ".     /  \\");
        Log.e("FirebaseCrashlytics", ".    /    \\");
        Log.e("FirebaseCrashlytics", ".   / |  | \\");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", InstructionFileId.DOT);
        return false;
    }

    public final void d() {
        try {
            this.f40160h = Boolean.TRUE.equals((Boolean) Utils.d(this.f40167o.h(new c())));
        } catch (Exception unused) {
            this.f40160h = false;
        }
    }

    @NonNull
    public Task<Boolean> e() {
        return this.f40161i.o();
    }

    public Task<Void> f() {
        return this.f40161i.t();
    }

    public boolean g() {
        return this.f40160h;
    }

    public boolean h() {
        return this.f40158f.c();
    }

    public final Task<Void> i(ok.g gVar) {
        q();
        try {
            this.f40164l.a(new ik.a() { // from class: com.google.firebase.crashlytics.internal.common.g
                @Override // ik.a
                public final void a(String str) {
                    this.f40201a.n(str);
                }
            });
            if (!gVar.b().f72457b.f72464a) {
                gk.f.f().b("Collection of crash reports disabled in Crashlytics settings.");
                return Tasks.forException(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f40161i.B(gVar)) {
                gk.f.f().k("Previous sessions could not be finalized.");
            }
            return this.f40161i.S(gVar.a());
        } catch (Exception e11) {
            gk.f.f().e("Crashlytics encountered a problem during asynchronous initialization.", e11);
            return Tasks.forException(e11);
        } finally {
            p();
        }
    }

    public Task<Void> j(ok.g gVar) {
        return Utils.f(this.f40166n, new a(gVar));
    }

    public final void k(final ok.g gVar) {
        Future<?> futureSubmit = this.f40166n.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.2
            @Override // java.lang.Runnable
            public void run() {
                CrashlyticsCore.this.i(gVar);
            }
        });
        gk.f.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e11) {
            gk.f.f().e("Crashlytics was interrupted during initialization.", e11);
        } catch (ExecutionException e12) {
            gk.f.f().e("Crashlytics encountered a problem during initialization.", e12);
        } catch (TimeoutException e13) {
            gk.f.f().e("Crashlytics timed out during initialization.", e13);
        }
    }

    public void n(String str) {
        this.f40161i.W(System.currentTimeMillis() - this.f40157e, str);
    }

    public void o(@NonNull Throwable th2) {
        this.f40161i.V(Thread.currentThread(), th2);
    }

    public void p() {
        this.f40167o.h(new b());
    }

    public void q() {
        this.f40167o.b();
        this.f40158f.a();
        gk.f.f().i("Initialization marker file was created.");
    }

    public boolean r(com.google.firebase.crashlytics.internal.common.a aVar, ok.g gVar) {
        if (!m(aVar.f40179b, CommonUtils.k(this.f40153a, "com.crashlytics.RequireBuildId", true))) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
        }
        String string = new e(this.f40162j).toString();
        try {
            this.f40159g = new h("crash_marker", this.f40163k);
            this.f40158f = new h("initialization_marker", this.f40163k);
            jk.i iVar = new jk.i(string, this.f40163k, this.f40167o);
            jk.c cVar = new jk.c(this.f40163k);
            this.f40161i = new CrashlyticsController(this.f40153a, this.f40167o, this.f40162j, this.f40155c, this.f40163k, this.f40159g, aVar, iVar, cVar, e0.g(this.f40153a, this.f40162j, this.f40163k, aVar, cVar, iVar, new pk.a(1024, new pk.c(10)), gVar, this.f40156d), this.f40168p, this.f40165m);
            boolean zH = h();
            d();
            this.f40161i.z(string, Thread.getDefaultUncaughtExceptionHandler(), gVar);
            if (!zH || !CommonUtils.c(this.f40153a)) {
                gk.f.f().b("Successfully configured exception handler.");
                return true;
            }
            gk.f.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            k(gVar);
            return false;
        } catch (Exception e11) {
            gk.f.f().e("Crashlytics was not started due to an exception during initialization", e11);
            this.f40161i = null;
            return false;
        }
    }

    public Task<Void> s() {
        return this.f40161i.P();
    }

    public void t(@Nullable Boolean bool) {
        this.f40155c.g(bool);
    }

    public void u(String str, String str2) {
        this.f40161i.Q(str, str2);
    }

    public void v(String str) {
        this.f40161i.R(str);
    }
}
