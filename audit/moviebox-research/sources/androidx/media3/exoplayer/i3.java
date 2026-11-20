package androidx.media3.exoplayer;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final WifiManager f10636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public WifiManager.WifiLock f10637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10639d;

    public i3(Context context) {
        this.f10636a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    public void a(boolean z11) {
        if (z11 && this.f10637b == null) {
            WifiManager wifiManager = this.f10636a;
            if (wifiManager == null) {
                z3.o.h("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.f10637b = wifiLockCreateWifiLock;
                wifiLockCreateWifiLock.setReferenceCounted(false);
            }
        }
        this.f10638c = z11;
        c();
    }

    public void b(boolean z11) {
        this.f10639d = z11;
        c();
    }

    public final void c() {
        WifiManager.WifiLock wifiLock = this.f10637b;
        if (wifiLock == null) {
            return;
        }
        if (this.f10638c && this.f10639d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
