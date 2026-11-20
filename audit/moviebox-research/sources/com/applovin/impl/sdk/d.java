package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.go;
import com.applovin.impl.ve;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private go f22480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f22481b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f22482c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f22483d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j f22484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference f22485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f22486h;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onAdRefresh();
    }

    public d(j jVar, a aVar) {
        this.f22485g = new WeakReference(aVar);
        this.f22484f = jVar;
    }

    private void e() {
        if (((Boolean) this.f22484f.a(ve.X6)).booleanValue()) {
            k();
        }
    }

    private void f() {
        if (((Boolean) this.f22484f.a(ve.X6)).booleanValue()) {
            synchronized (this.f22481b) {
                try {
                    if (this.f22483d) {
                        this.f22484f.J();
                        if (n.a()) {
                            this.f22484f.J().a("AdRefreshManager", "Fullscreen ad dismissed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh.");
                        }
                    } else if (this.f22484f.f0().isApplicationPaused()) {
                        this.f22484f.J();
                        if (n.a()) {
                            this.f22484f.J().a("AdRefreshManager", "Waiting for the application to enter foreground to resume the timer.");
                        }
                    } else {
                        go goVar = this.f22480a;
                        if (goVar != null) {
                            goVar.e();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        l();
        a aVar = (a) this.f22485g.get();
        if (aVar != null) {
            aVar.onAdRefresh();
        }
    }

    private void k() {
        synchronized (this.f22481b) {
            try {
                go goVar = this.f22480a;
                if (goVar != null) {
                    goVar.d();
                } else {
                    this.f22484f.J();
                    if (n.a()) {
                        this.f22484f.J().a("AdRefreshManager", "An ad load is in progress. Will pause refresh once the ad finishes loading.");
                    }
                    this.f22482c.set(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void l() {
        synchronized (this.f22481b) {
            try {
                this.f22480a = null;
                if (!((Boolean) this.f22484f.a(ve.Y6)).booleanValue()) {
                    AppLovinBroadcastManager.unregisterReceiver(this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void n() {
        synchronized (this.f22481b) {
            try {
                go goVar = this.f22480a;
                if (goVar != null) {
                    goVar.e();
                } else {
                    this.f22482c.set(false);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a() {
        synchronized (this.f22481b) {
            try {
                go goVar = this.f22480a;
                if (goVar != null) {
                    goVar.a();
                    l();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(long j11) {
        synchronized (this.f22481b) {
            try {
                a();
                this.f22486h = j11;
                this.f22480a = go.a(j11, this.f22484f, new Runnable() { // from class: com.applovin.impl.sdk.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22472a.i();
                    }
                });
                if (!((Boolean) this.f22484f.a(ve.Y6)).booleanValue()) {
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_displayed"));
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_hidden"));
                }
                if (((Boolean) this.f22484f.a(ve.X6)).booleanValue() && (this.f22484f.C().c() || this.f22484f.f0().isApplicationPaused())) {
                    this.f22480a.d();
                }
                if (this.f22482c.compareAndSet(true, false) && ((Boolean) this.f22484f.a(ve.Z6)).booleanValue()) {
                    this.f22484f.J();
                    if (n.a()) {
                        this.f22484f.J().a("AdRefreshManager", "Pausing refresh for a previous request.");
                    }
                    this.f22480a.d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public long b() {
        long jC;
        synchronized (this.f22481b) {
            try {
                go goVar = this.f22480a;
                jC = goVar != null ? goVar.c() : -1L;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jC;
    }

    public void c() {
        if (((Boolean) this.f22484f.a(ve.W6)).booleanValue()) {
            k();
        }
    }

    public void d() {
        boolean z11;
        a aVar;
        if (((Boolean) this.f22484f.a(ve.W6)).booleanValue()) {
            synchronized (this.f22481b) {
                try {
                    if (this.f22483d) {
                        this.f22484f.J();
                        if (n.a()) {
                            this.f22484f.J().a("AdRefreshManager", "Application resumed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh.");
                        }
                        return;
                    }
                    if (this.f22484f.C().c()) {
                        this.f22484f.J();
                        if (n.a()) {
                            this.f22484f.J().a("AdRefreshManager", "Waiting for the full screen ad to be dismissed to resume the timer.");
                        }
                        return;
                    }
                    if (this.f22480a != null) {
                        long jB = this.f22486h - b();
                        long jLongValue = ((Long) this.f22484f.a(ve.V6)).longValue();
                        if (jLongValue < 0 || jB <= jLongValue) {
                            this.f22480a.e();
                            z11 = false;
                        } else {
                            a();
                            z11 = true;
                        }
                    } else {
                        z11 = false;
                    }
                    if (!z11 || (aVar = (a) this.f22485g.get()) == null) {
                        return;
                    }
                    aVar.onAdRefresh();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public boolean g() {
        return this.f22483d;
    }

    public boolean h() {
        boolean z11;
        synchronized (this.f22481b) {
            z11 = this.f22480a != null;
        }
        return z11;
    }

    public void j() {
        synchronized (this.f22481b) {
            k();
            this.f22483d = true;
        }
    }

    public void m() {
        synchronized (this.f22481b) {
            n();
            this.f22483d = false;
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            c();
            return;
        }
        if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            d();
        } else if ("com.applovin.fullscreen_ad_displayed".equals(action)) {
            e();
        } else if ("com.applovin.fullscreen_ad_hidden".equals(action)) {
            f();
        }
    }
}
