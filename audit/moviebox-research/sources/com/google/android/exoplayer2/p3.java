package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final PowerManager f33692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public PowerManager.WakeLock f33693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f33694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f33695d;

    public p3(Context context) {
        this.f33692a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public void a(boolean z11) {
        if (z11 && this.f33693b == null) {
            PowerManager powerManager = this.f33692a;
            if (powerManager == null) {
                com.google.android.exoplayer2.util.s.i("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.f33693b = wakeLockNewWakeLock;
                wakeLockNewWakeLock.setReferenceCounted(false);
            }
        }
        this.f33694c = z11;
        c();
    }

    public void b(boolean z11) {
        this.f33695d = z11;
        c();
    }

    @SuppressLint({"WakelockTimeout"})
    public final void c() {
        PowerManager.WakeLock wakeLock = this.f33693b;
        if (wakeLock == null) {
            return;
        }
        if (this.f33694c && this.f33695d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
