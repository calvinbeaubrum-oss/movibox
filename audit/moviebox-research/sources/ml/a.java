package ml;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.metrics.h;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.e;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import vl.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ql.a f71113s = ql.a.e();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile a f71114t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<Activity, Boolean> f71115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<Activity, d> f71116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap<Activity, c> f71117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap<Activity, Trace> f71118d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Long> f71119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<WeakReference<b>> f71120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set<InterfaceC0760a> f71121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f71122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f71123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final nl.a f71124k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.google.firebase.perf.util.a f71125l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f71126m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Timer f71127n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Timer f71128o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ApplicationProcessState f71129p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f71130q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f71131r;

    /* JADX INFO: renamed from: ml.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0760a {
        void a();
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void onUpdateAppState(ApplicationProcessState applicationProcessState);
    }

    public a(k kVar, com.google.firebase.perf.util.a aVar) {
        this(kVar, aVar, nl.a.g(), g());
    }

    @VisibleForTesting
    public a(k kVar, com.google.firebase.perf.util.a aVar, nl.a aVar2, boolean z11) {
        this.f71115a = new WeakHashMap<>();
        this.f71116b = new WeakHashMap<>();
        this.f71117c = new WeakHashMap<>();
        this.f71118d = new WeakHashMap<>();
        this.f71119f = new HashMap();
        this.f71120g = new HashSet();
        this.f71121h = new HashSet();
        this.f71122i = new AtomicInteger(0);
        this.f71129p = ApplicationProcessState.BACKGROUND;
        this.f71130q = false;
        this.f71131r = true;
        this.f71123j = kVar;
        this.f71125l = aVar;
        this.f71124k = aVar2;
        this.f71126m = z11;
    }

    public static a b() {
        if (f71114t == null) {
            synchronized (a.class) {
                try {
                    if (f71114t == null) {
                        f71114t = new a(k.k(), new com.google.firebase.perf.util.a());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f71114t;
    }

    public static String c(Activity activity) {
        return "_st_" + activity.getClass().getSimpleName();
    }

    public static boolean g() {
        return d.a();
    }

    public ApplicationProcessState a() {
        return this.f71129p;
    }

    public void d(@NonNull String str, long j11) {
        synchronized (this.f71119f) {
            try {
                Long l11 = this.f71119f.get(str);
                if (l11 == null) {
                    this.f71119f.put(str, Long.valueOf(j11));
                } else {
                    this.f71119f.put(str, Long.valueOf(l11.longValue() + j11));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e(int i11) {
        this.f71122i.addAndGet(i11);
    }

    public boolean f() {
        return this.f71131r;
    }

    public boolean h() {
        return this.f71126m;
    }

    public synchronized void i(Context context) {
        if (this.f71130q) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
            this.f71130q = true;
        }
    }

    public void j(InterfaceC0760a interfaceC0760a) {
        synchronized (this.f71121h) {
            this.f71121h.add(interfaceC0760a);
        }
    }

    public void k(WeakReference<b> weakReference) {
        synchronized (this.f71120g) {
            this.f71120g.add(weakReference);
        }
    }

    public final void l() {
        synchronized (this.f71121h) {
            try {
                for (InterfaceC0760a interfaceC0760a : this.f71121h) {
                    if (interfaceC0760a != null) {
                        interfaceC0760a.a();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void m(Activity activity) {
        Trace trace = this.f71118d.get(activity);
        if (trace == null) {
            return;
        }
        this.f71118d.remove(activity);
        e<h.a> eVarE = this.f71116b.get(activity).e();
        if (!eVarE.d()) {
            f71113s.k("Failed to record frame data for %s.", activity.getClass().getSimpleName());
        } else {
            com.google.firebase.perf.util.h.a(trace, eVarE.c());
            trace.stop();
        }
    }

    public final void n(String str, Timer timer, Timer timer2) {
        if (this.f71124k.K()) {
            i.b bVarM = i.w0().T(str).R(timer.getMicros()).S(timer.getDurationMicros(timer2)).M(SessionManager.getInstance().perfSession().build());
            int andSet = this.f71122i.getAndSet(0);
            synchronized (this.f71119f) {
                try {
                    bVarM.O(this.f71119f);
                    if (andSet != 0) {
                        bVarM.Q(Constants$CounterNames.TRACE_STARTED_NOT_STOPPED.toString(), andSet);
                    }
                    this.f71119f.clear();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f71123j.C(bVarM.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
        }
    }

    public final void o(Activity activity) {
        if (h() && this.f71124k.K()) {
            d dVar = new d(activity);
            this.f71116b.put(activity, dVar);
            if (activity instanceof FragmentActivity) {
                c cVar = new c(this.f71125l, this.f71123j, this, dVar);
                this.f71117c.put(activity, cVar);
                ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(cVar, true);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        o(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.f71116b.remove(activity);
        if (this.f71117c.containsKey(activity)) {
            ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.f71117c.remove(activity));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        try {
            if (this.f71115a.isEmpty()) {
                this.f71127n = this.f71125l.a();
                this.f71115a.put(activity, Boolean.TRUE);
                if (this.f71131r) {
                    q(ApplicationProcessState.FOREGROUND);
                    l();
                    this.f71131r = false;
                } else {
                    n(Constants$TraceNames.BACKGROUND_TRACE_NAME.toString(), this.f71128o, this.f71127n);
                    q(ApplicationProcessState.FOREGROUND);
                }
            } else {
                this.f71115a.put(activity, Boolean.TRUE);
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
        try {
            if (h() && this.f71124k.K()) {
                if (!this.f71116b.containsKey(activity)) {
                    o(activity);
                }
                this.f71116b.get(activity).c();
                Trace trace = new Trace(c(activity), this.f71123j, this.f71125l, this);
                trace.start();
                this.f71118d.put(activity, trace);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity activity) {
        try {
            if (h()) {
                m(activity);
            }
            if (this.f71115a.containsKey(activity)) {
                this.f71115a.remove(activity);
                if (this.f71115a.isEmpty()) {
                    this.f71128o = this.f71125l.a();
                    n(Constants$TraceNames.FOREGROUND_TRACE_NAME.toString(), this.f71127n, this.f71128o);
                    q(ApplicationProcessState.BACKGROUND);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void p(WeakReference<b> weakReference) {
        synchronized (this.f71120g) {
            this.f71120g.remove(weakReference);
        }
    }

    public final void q(ApplicationProcessState applicationProcessState) {
        this.f71129p = applicationProcessState;
        synchronized (this.f71120g) {
            try {
                Iterator<WeakReference<b>> it = this.f71120g.iterator();
                while (it.hasNext()) {
                    b bVar = it.next().get();
                    if (bVar != null) {
                        bVar.onUpdateAppState(this.f71129p);
                    } else {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
