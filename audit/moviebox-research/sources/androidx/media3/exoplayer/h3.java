package androidx.media3.exoplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final PowerManager f10333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public PowerManager.WakeLock f10334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10336d;

    public h3(Context context) {
        this.f10333a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public void a(boolean z11) {
        if (z11 && this.f10334b == null) {
            PowerManager powerManager = this.f10333a;
            if (powerManager == null) {
                z3.o.h("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.f10334b = wakeLockNewWakeLock;
                wakeLockNewWakeLock.setReferenceCounted(false);
            }
        }
        this.f10335c = z11;
        c();
    }

    public void b(boolean z11) {
        this.f10336d = z11;
        c();
    }

    @SuppressLint({"WakelockTimeout"})
    public final void c() {
        PowerManager.WakeLock wakeLock = this.f10334b;
        if (wakeLock == null) {
            return;
        }
        if (this.f10335c && this.f10336d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
