package com.google.firebase.perf.metrics;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class AppStartTrace implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f40972s = TimeUnit.MINUTES.toMicros(1);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile AppStartTrace f40973t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static ExecutorService f40974u;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vl.k f40976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.firebase.perf.util.a f40977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nl.a f40978d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.google.firebase.perf.v1.i.b f40979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f40980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<Activity> f40981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<Activity> f40982i;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PerfSession f40990q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f40975a = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f40983j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Timer f40984k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Timer f40985l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Timer f40986m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Timer f40987n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Timer f40988o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Timer f40989p = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f40991r = false;

    /* JADX INFO: compiled from: source.java */
    public static class StartFromBackgroundRunnable implements Runnable {
        private final AppStartTrace trace;

        public StartFromBackgroundRunnable(AppStartTrace appStartTrace) {
            this.trace = appStartTrace;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.trace.f40985l == null) {
                this.trace.f40991r = true;
            }
        }
    }

    public AppStartTrace(@NonNull vl.k kVar, @NonNull com.google.firebase.perf.util.a aVar, @NonNull nl.a aVar2, @NonNull ExecutorService executorService) {
        this.f40976b = kVar;
        this.f40977c = aVar;
        this.f40978d = aVar2;
        f40974u = executorService;
        this.f40979f = com.google.firebase.perf.v1.i.w0().T("_experiment_app_start_ttid");
    }

    public static AppStartTrace h() {
        return f40973t != null ? f40973t : i(vl.k.k(), new com.google.firebase.perf.util.a());
    }

    public static AppStartTrace i(vl.k kVar, com.google.firebase.perf.util.a aVar) {
        if (f40973t == null) {
            synchronized (AppStartTrace.class) {
                try {
                    if (f40973t == null) {
                        f40973t = new AppStartTrace(kVar, aVar, nl.a.g(), new ThreadPoolExecutor(0, 1, f40972s + 10, TimeUnit.SECONDS, new LinkedBlockingQueue()));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f40973t;
    }

    public static Timer j() {
        return Build.VERSION.SDK_INT >= 24 ? Timer.ofElapsedRealtime(Process.getStartElapsedRealtime(), Process.getStartUptimeMillis()) : FirebasePerfProvider.getAppStartTime();
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    @VisibleForTesting
    public Timer k() {
        return this.f40984k;
    }

    public final boolean l() {
        return (this.f40989p == null || this.f40988o == null) ? false : true;
    }

    public final /* synthetic */ void m() {
        p(this.f40979f);
    }

    public final /* synthetic */ void n() {
        p(this.f40979f);
    }

    public final void o() {
        com.google.firebase.perf.v1.i.b bVarS = com.google.firebase.perf.v1.i.w0().T(Constants$TraceNames.APP_START_TRACE_NAME.toString()).R(k().getMicros()).S(k().getDurationMicros(this.f40987n));
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(com.google.firebase.perf.v1.i.w0().T(Constants$TraceNames.ON_CREATE_TRACE_NAME.toString()).R(k().getMicros()).S(k().getDurationMicros(this.f40985l)).build());
        com.google.firebase.perf.v1.i.b bVarW0 = com.google.firebase.perf.v1.i.w0();
        bVarW0.T(Constants$TraceNames.ON_START_TRACE_NAME.toString()).R(this.f40985l.getMicros()).S(this.f40985l.getDurationMicros(this.f40986m));
        arrayList.add(bVarW0.build());
        com.google.firebase.perf.v1.i.b bVarW1 = com.google.firebase.perf.v1.i.w0();
        bVarW1.T(Constants$TraceNames.ON_RESUME_TRACE_NAME.toString()).R(this.f40986m.getMicros()).S(this.f40986m.getDurationMicros(this.f40987n));
        arrayList.add(bVarW1.build());
        bVarS.L(arrayList).M(this.f40990q.build());
        this.f40976b.C((com.google.firebase.perf.v1.i) bVarS.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f40991r && this.f40985l == null) {
            this.f40981h = new WeakReference<>(activity);
            this.f40985l = this.f40977c.a();
            if (FirebasePerfProvider.getAppStartTime().getDurationMicros(this.f40985l) > f40972s) {
                this.f40983j = true;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (l()) {
            return;
        }
        Timer timerA = this.f40977c.a();
        this.f40979f.N(com.google.firebase.perf.v1.i.w0().T("_experiment_onPause").R(timerA.getMicros()).S(j().getDurationMicros(timerA)).build());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        try {
            if (!this.f40991r && !this.f40983j) {
                boolean zH = this.f40978d.h();
                if (zH) {
                    View viewFindViewById = activity.findViewById(R.id.content);
                    com.google.firebase.perf.util.c.e(viewFindViewById, new Runnable() { // from class: com.google.firebase.perf.metrics.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f40992a.q();
                        }
                    });
                    com.google.firebase.perf.util.f.a(viewFindViewById, new Runnable() { // from class: com.google.firebase.perf.metrics.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f40993a.r();
                        }
                    });
                }
                if (this.f40987n != null) {
                    return;
                }
                this.f40982i = new WeakReference<>(activity);
                this.f40987n = this.f40977c.a();
                this.f40984k = FirebasePerfProvider.getAppStartTime();
                this.f40990q = SessionManager.getInstance().perfSession();
                ql.a.e().a("onResume(): " + activity.getClass().getName() + ": " + this.f40984k.getDurationMicros(this.f40987n) + " microseconds");
                f40974u.execute(new Runnable() { // from class: com.google.firebase.perf.metrics.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f40994a.o();
                    }
                });
                if (!zH && this.f40975a) {
                    t();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        if (!this.f40991r && this.f40986m == null && !this.f40983j) {
            this.f40986m = this.f40977c.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (l()) {
            return;
        }
        Timer timerA = this.f40977c.a();
        this.f40979f.N(com.google.firebase.perf.v1.i.w0().T("_experiment_onStop").R(timerA.getMicros()).S(j().getDurationMicros(timerA)).build());
    }

    public final void p(com.google.firebase.perf.v1.i.b bVar) {
        this.f40976b.C(bVar.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    public final void q() {
        if (this.f40988o != null) {
            return;
        }
        Timer timerJ = j();
        this.f40988o = this.f40977c.a();
        this.f40979f.R(timerJ.getMicros()).S(timerJ.getDurationMicros(this.f40988o));
        this.f40979f.N(com.google.firebase.perf.v1.i.w0().T("_experiment_classLoadTime").R(FirebasePerfProvider.getAppStartTime().getMicros()).S(FirebasePerfProvider.getAppStartTime().getDurationMicros(this.f40988o)).build());
        com.google.firebase.perf.v1.i.b bVarW0 = com.google.firebase.perf.v1.i.w0();
        bVarW0.T("_experiment_uptimeMillis").R(timerJ.getMicros()).S(timerJ.getDurationUptimeMicros(this.f40988o));
        this.f40979f.N(bVarW0.build());
        this.f40979f.M(this.f40990q.build());
        if (l()) {
            f40974u.execute(new Runnable() { // from class: com.google.firebase.perf.metrics.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40995a.m();
                }
            });
            if (this.f40975a) {
                t();
            }
        }
    }

    public final void r() {
        if (this.f40989p != null) {
            return;
        }
        Timer timerJ = j();
        this.f40989p = this.f40977c.a();
        this.f40979f.N(com.google.firebase.perf.v1.i.w0().T("_experiment_preDraw").R(timerJ.getMicros()).S(timerJ.getDurationMicros(this.f40989p)).build());
        com.google.firebase.perf.v1.i.b bVarW0 = com.google.firebase.perf.v1.i.w0();
        bVarW0.T("_experiment_preDraw_uptimeMillis").R(timerJ.getMicros()).S(timerJ.getDurationUptimeMicros(this.f40989p));
        this.f40979f.N(bVarW0.build());
        if (l()) {
            f40974u.execute(new Runnable() { // from class: com.google.firebase.perf.metrics.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40996a.n();
                }
            });
            if (this.f40975a) {
                t();
            }
        }
    }

    public synchronized void s(@NonNull Context context) {
        if (this.f40975a) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
            this.f40975a = true;
            this.f40980g = applicationContext;
        }
    }

    public synchronized void t() {
        if (this.f40975a) {
            ((Application) this.f40980g).unregisterActivityLifecycleCallbacks(this);
            this.f40975a = false;
        }
    }
}
