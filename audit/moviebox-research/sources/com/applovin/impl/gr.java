package com.applovin.impl;

import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class gr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PowerManager f19296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PowerManager.WakeLock f19297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19299d;

    public gr(Context context) {
        this.f19296a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    private void a() {
        PowerManager.WakeLock wakeLock = this.f19297b;
        if (wakeLock == null) {
            return;
        }
        if (this.f19298c && this.f19299d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }

    public void a(boolean z11) {
        if (z11 && this.f19297b == null) {
            PowerManager powerManager = this.f19296a;
            if (powerManager == null) {
                pc.d("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.f19297b = wakeLockNewWakeLock;
                wakeLockNewWakeLock.setReferenceCounted(false);
            }
        }
        this.f19298c = z11;
        a();
    }

    public void b(boolean z11) {
        this.f19299d = z11;
        a();
    }
}
