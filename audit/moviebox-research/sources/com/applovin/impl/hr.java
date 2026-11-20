package com.applovin.impl;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class hr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set f19532f = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f19533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f19534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f19535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f19536d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Timer f19537e;

    /* JADX INFO: compiled from: source.java */
    public class a extends TimerTask {

        /* JADX INFO: renamed from: com.applovin.impl.hr$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0183a implements AppLovinBroadcastManager.Receiver {
            public C0183a() {
            }

            @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
            public void onReceive(Intent intent, Map map) {
                AppLovinBroadcastManager.unregisterReceiver(this);
                hr.this.c();
            }
        }

        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (!hr.this.f19534b.f0().isApplicationPaused() || hr.this.f19533a) {
                hr.this.c();
            } else {
                AppLovinBroadcastManager.registerReceiver(new C0183a(), new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
            }
        }
    }

    private hr(long j11, boolean z11, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        Timer timer = new Timer();
        this.f19537e = timer;
        if (j11 < 0) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Invalid timer length: " + j11);
        }
        if (jVar == null) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Sdk is null");
        }
        if (runnable == null) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Runnable is null.");
        }
        this.f19533a = z11;
        this.f19534b = jVar;
        this.f19535c = runnable;
        f19532f.add(this);
        timer.schedule(b(), j11);
    }

    public static hr a(long j11, boolean z11, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        return new hr(j11, z11, jVar, runnable);
    }

    private TimerTask b() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Runnable runnable = this.f19535c;
        if (runnable != null) {
            runnable.run();
            a();
        }
    }

    public void a() {
        synchronized (this.f19536d) {
            this.f19537e.cancel();
            this.f19535c = null;
            f19532f.remove(this);
        }
    }
}
