package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.ca;
import com.applovin.impl.sj;
import com.applovin.impl.yp;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SessionTracker {
    public static final String ACTION_APPLICATION_PAUSED = "com.applovin.application_paused";
    public static final String ACTION_APPLICATION_RESUMED = "com.applovin.application_resumed";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final j f22389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f22390b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f22391c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f22392d = new AtomicInteger();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicLong f22393e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicLong f22394f = new AtomicLong();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Date f22395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Date f22396h;

    /* JADX INFO: compiled from: source.java */
    public class a extends com.applovin.impl.p {
        public a() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            SessionTracker.this.b();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ComponentCallbacks2 {
        public b() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i11) {
            SessionTracker.this.f22392d.set(i11);
            if (i11 == 20) {
                SessionTracker.this.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                if (yp.g()) {
                    SessionTracker.this.b();
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                SessionTracker.this.a();
            }
        }
    }

    public SessionTracker(j jVar) {
        this.f22389a = jVar;
        Application application = (Application) j.l();
        application.registerActivityLifecycleCallbacks(new a());
        application.registerComponentCallbacks(new b());
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new c(), intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f22391c.compareAndSet(false, true)) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f22391c.compareAndSet(true, false)) {
            d();
        }
    }

    private void c() {
        this.f22389a.J();
        if (n.a()) {
            this.f22389a.J().a("SessionTracker", "Application Paused");
        }
        this.f22393e.set(System.currentTimeMillis());
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_PAUSED), null);
        if (this.f22390b.get()) {
            return;
        }
        boolean zBooleanValue = ((Boolean) this.f22389a.a(sj.E3)).booleanValue();
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.f22389a.a(sj.G3)).longValue());
        if (this.f22395g == null || System.currentTimeMillis() - this.f22395g.getTime() >= millis) {
            this.f22389a.A().trackEvent("paused");
            if (zBooleanValue) {
                this.f22395g = new Date();
            }
        }
        if (zBooleanValue) {
            return;
        }
        this.f22395g = new Date();
    }

    private void d() {
        this.f22389a.J();
        if (n.a()) {
            this.f22389a.J().a("SessionTracker", "Application Resumed");
        }
        this.f22394f.set(System.currentTimeMillis());
        boolean zBooleanValue = ((Boolean) this.f22389a.a(sj.E3)).booleanValue();
        long jLongValue = ((Long) this.f22389a.a(sj.F3)).longValue();
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_RESUMED), null);
        if (this.f22390b.getAndSet(false)) {
            return;
        }
        long millis = TimeUnit.MINUTES.toMillis(jLongValue);
        if (this.f22396h == null || System.currentTimeMillis() - this.f22396h.getTime() >= millis) {
            this.f22389a.A().trackEvent("resumed");
            if (zBooleanValue) {
                this.f22396h = new Date();
            }
        }
        if (!zBooleanValue) {
            this.f22396h = new Date();
        }
        this.f22389a.D().c(ca.f18159p);
    }

    public long getAppEnteredBackgroundTimeMillis() {
        return this.f22393e.get();
    }

    public long getAppEnteredForegroundTimeMillis() {
        return this.f22394f.get();
    }

    public int getLastTrimMemoryLevel() {
        return this.f22392d.get();
    }

    public boolean isApplicationPaused() {
        return this.f22391c.get();
    }

    public void pauseForClick() {
        this.f22390b.set(true);
    }

    public void resumeForClick() {
        this.f22390b.set(false);
    }
}
