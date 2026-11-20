package com.cloud.hisavana.sdk.common.tranmeasure;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.cloud.hisavana.sdk.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BroadcastReceiver f29496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f29497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f29498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f29499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f29500e;

    /* JADX INFO: compiled from: source.java */
    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.tranmeasure.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class RunnableC0326a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f29502a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f29503b;

            public RunnableC0326a(String str, Context context) {
                this.f29502a = str;
                this.f29503b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if ("android.intent.action.SCREEN_OFF".equals(this.f29502a)) {
                    z.a().i("ScreenStateManager", "SCREEN_OFF");
                    f.this.e(true);
                    return;
                }
                if ("android.intent.action.USER_PRESENT".equals(this.f29502a)) {
                    z.a().i("ScreenStateManager", "USER_PRESENT");
                } else {
                    if (!"android.intent.action.SCREEN_ON".equals(this.f29502a)) {
                        return;
                    }
                    z.a().i("ScreenStateManager", "SCREEN_ON");
                    KeyguardManager keyguardManager = (KeyguardManager) this.f29503b.getSystemService("keyguard");
                    if (keyguardManager == null || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return;
                    }
                }
                f.this.e(false);
            }
        }

        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = f.this.f29500e;
            if (intent == null || context == null || handler == null) {
                return;
            }
            handler.post(new RunnableC0326a(intent.getAction(), context));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(boolean z11);
    }

    public f() {
        if (Looper.myLooper() != null) {
            this.f29500e = new Handler(Looper.myLooper());
        }
    }

    public void b() {
        if (this.f29496a != null) {
            try {
                com.cloud.sdk.commonutil.util.f.a().unregisterReceiver(this.f29496a);
            } catch (Throwable unused) {
            }
            this.f29496a = null;
        }
        this.f29498c = false;
        this.f29497b = false;
        this.f29499d = null;
    }

    public void c(b bVar) {
        this.f29499d = bVar;
    }

    public final void e(boolean z11) {
        b bVar;
        if (this.f29497b != z11) {
            this.f29497b = z11;
            if (!this.f29498c || (bVar = this.f29499d) == null) {
                return;
            }
            bVar.a(f());
        }
    }

    public final boolean f() {
        return !this.f29497b;
    }

    public final void g() {
        this.f29496a = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                com.cloud.sdk.commonutil.util.f.a().registerReceiver(this.f29496a, intentFilter, 2);
            } else {
                com.cloud.sdk.commonutil.util.f.a().registerReceiver(this.f29496a, intentFilter);
            }
        } catch (Throwable unused) {
        }
    }

    public void h() {
        g();
        this.f29498c = true;
    }
}
