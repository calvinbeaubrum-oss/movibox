package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final WifiManager f33701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public WifiManager.WifiLock f33702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f33703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f33704d;

    public q3(Context context) {
        this.f33701a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    public void a(boolean z11) {
        if (z11 && this.f33702b == null) {
            WifiManager wifiManager = this.f33701a;
            if (wifiManager == null) {
                com.google.android.exoplayer2.util.s.i("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.f33702b = wifiLockCreateWifiLock;
                wifiLockCreateWifiLock.setReferenceCounted(false);
            }
        }
        this.f33703c = z11;
        c();
    }

    public void b(boolean z11) {
        this.f33704d = z11;
        c();
    }

    public final void c() {
        WifiManager.WifiLock wifiLock = this.f33702b;
        if (wifiLock == null) {
            return;
        }
        if (this.f33703c && this.f33704d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
