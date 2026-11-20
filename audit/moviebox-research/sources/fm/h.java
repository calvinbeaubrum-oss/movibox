package fm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f65136a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f65140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f65141f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f65138c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BroadcastReceiver f65137b = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f65139d = new Handler();

    /* JADX INFO: compiled from: source.java */
    public final class b extends BroadcastReceiver {
        public b() {
        }

        public final /* synthetic */ void b(boolean z11) {
            h.this.f(z11);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z11 = intent.getIntExtra("plugged", -1) <= 0;
                h.this.f65139d.post(new Runnable() { // from class: fm.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f65143a.b(z11);
                    }
                });
            }
        }
    }

    public h(Context context, Runnable runnable) {
        this.f65136a = context;
        this.f65140e = runnable;
    }

    public void c() {
        e();
        if (this.f65141f) {
            this.f65139d.postDelayed(this.f65140e, 300000L);
        }
    }

    public void d() {
        e();
        i();
    }

    public final void e() {
        this.f65139d.removeCallbacksAndMessages(null);
    }

    public final void f(boolean z11) {
        this.f65141f = z11;
        if (this.f65138c) {
            c();
        }
    }

    public final void g() {
        if (this.f65138c) {
            return;
        }
        this.f65136a.registerReceiver(this.f65137b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f65138c = true;
    }

    public void h() {
        g();
        c();
    }

    public final void i() {
        if (this.f65138c) {
            this.f65136a.unregisterReceiver(this.f65137b);
            this.f65138c = false;
        }
    }
}
