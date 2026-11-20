package com.applovin.impl;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class x1 implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set f24200c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final go f24201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f24202b;

    private x1(long j11, com.applovin.impl.sdk.j jVar, final Runnable runnable) {
        this.f24201a = go.a(j11, jVar, new Runnable() { // from class: com.applovin.impl.u80
            @Override // java.lang.Runnable
            public final void run() {
                this.f23533a.a(runnable);
            }
        });
        this.f24202b = jVar;
        f24200c.add(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    public static x1 a(long j11, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        return new x1(j11, jVar, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Runnable runnable) {
        a();
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a() {
        this.f24201a.a();
        AppLovinBroadcastManager.unregisterReceiver(this);
        f24200c.remove(this);
    }

    public long b() {
        return this.f24201a.c();
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f24201a.d();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.f24201a.e();
        }
    }
}
