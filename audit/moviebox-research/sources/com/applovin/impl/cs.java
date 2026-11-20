package com.applovin.impl;

import android.content.Context;
import android.net.wifi.WifiManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class cs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WifiManager f18306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WifiManager.WifiLock f18307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18309d;

    public cs(Context context) {
        this.f18306a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    private void a() {
        WifiManager.WifiLock wifiLock = this.f18307b;
        if (wifiLock == null) {
            return;
        }
        if (this.f18308c && this.f18309d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }

    public void a(boolean z11) {
        if (z11 && this.f18307b == null) {
            WifiManager wifiManager = this.f18306a;
            if (wifiManager == null) {
                pc.d("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.f18307b = wifiLockCreateWifiLock;
                wifiLockCreateWifiLock.setReferenceCounted(false);
            }
        }
        this.f18308c = z11;
        a();
    }

    public void b(boolean z11) {
        this.f18309d = z11;
        a();
    }
}
