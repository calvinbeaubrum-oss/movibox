package o4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.exoplayer.scheduler.Requirements;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f72312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f72313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Requirements f72314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f72315d = u0.C();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public b f72316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f72317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public d f72318g;

    /* JADX INFO: compiled from: source.java */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            e.this.e();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(e eVar, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public final class d extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f72320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f72321b;

        public d() {
        }

        public final /* synthetic */ void c() {
            if (e.this.f72318g != null) {
                e.this.e();
            }
        }

        public final /* synthetic */ void d() {
            if (e.this.f72318g != null) {
                e.this.g();
            }
        }

        public final void e() {
            e.this.f72315d.post(new Runnable() { // from class: o4.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f72324a.c();
                }
            });
        }

        public final void f() {
            e.this.f72315d.post(new Runnable() { // from class: o4.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f72323a.d();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            e();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z11) {
            if (z11) {
                return;
            }
            f();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean zHasCapability = networkCapabilities.hasCapability(16);
            if (this.f72320a && this.f72321b == zHasCapability) {
                if (zHasCapability) {
                    f();
                }
            } else {
                this.f72320a = true;
                this.f72321b = zHasCapability;
                e();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            e();
        }
    }

    public e(Context context, c cVar, Requirements requirements) {
        this.f72312a = context.getApplicationContext();
        this.f72313b = cVar;
        this.f72314c = requirements;
    }

    public final void e() {
        int notMetRequirements = this.f72314c.getNotMetRequirements(this.f72312a);
        if (this.f72317f != notMetRequirements) {
            this.f72317f = notMetRequirements;
            this.f72313b.a(this, notMetRequirements);
        }
    }

    public Requirements f() {
        return this.f72314c;
    }

    public final void g() {
        if ((this.f72317f & 3) == 0) {
            return;
        }
        e();
    }

    @RequiresApi(24)
    public final void h() {
        ConnectivityManager connectivityManager = (ConnectivityManager) z3.a.e((ConnectivityManager) this.f72312a.getSystemService("connectivity"));
        d dVar = new d();
        this.f72318g = dVar;
        connectivityManager.registerDefaultNetworkCallback(dVar);
    }

    public int i() {
        this.f72317f = this.f72314c.getNotMetRequirements(this.f72312a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.f72314c.isNetworkRequired()) {
            if (u0.f81838a >= 24) {
                h();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.f72314c.isChargingRequired()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.f72314c.isIdleRequired()) {
            if (u0.f81838a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.f72314c.isStorageNotLowRequired()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        b bVar = new b();
        this.f72316e = bVar;
        this.f72312a.registerReceiver(bVar, intentFilter, null, this.f72315d);
        return this.f72317f;
    }

    public void j() {
        this.f72312a.unregisterReceiver((BroadcastReceiver) z3.a.e(this.f72316e));
        this.f72316e = null;
        if (u0.f81838a < 24 || this.f72318g == null) {
            return;
        }
        k();
    }

    @RequiresApi(24)
    public final void k() {
        ((ConnectivityManager) z3.a.e((ConnectivityManager) this.f72312a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) z3.a.e(this.f72318g));
        this.f72318g = null;
    }
}
