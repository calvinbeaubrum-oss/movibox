package com.applovin.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class fg {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static fg f18990e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f18991a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f18992b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f18993c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18994d = 0;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile boolean f18995a;
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public final class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int iC = fg.c(context);
            int i11 = xp.f24372a;
            if (i11 >= 29 && !b.f18995a && iC == 5) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) b1.a((TelephonyManager) context.getSystemService("phone"));
                    e eVar = new e();
                    if (i11 < 31) {
                        telephonyManager.listen(eVar, 1);
                    } else {
                        telephonyManager.listen(eVar, 1048576);
                    }
                    telephonyManager.listen(eVar, 0);
                    return;
                } catch (RuntimeException unused) {
                }
            }
            fg.this.a(iC);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends PhoneStateListener {
        private e() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
            fg.this.a(overrideNetworkType == 3 || overrideNetworkType == 4 ? 10 : 5);
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            String string = serviceState == null ? "" : serviceState.toString();
            fg.this.a(string.contains("nrState=CONNECTED") || string.contains("nrState=NOT_RESTRICTED") ? 10 : 5);
        }
    }

    private fg(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new d(), intentFilter);
    }

    private static int a(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return xp.f24372a >= 29 ? 9 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11) {
        synchronized (this.f18993c) {
            try {
                if (this.f18994d == i11) {
                    return;
                }
                this.f18994d = i11;
                for (WeakReference weakReference : this.f18992b) {
                    c cVar = (c) weakReference.get();
                    if (cVar != null) {
                        cVar.a(i11);
                    } else {
                        this.f18992b.remove(weakReference);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(c cVar) {
        cVar.a(a());
    }

    public static synchronized fg b(Context context) {
        try {
            if (f18990e == null) {
                f18990e = new fg(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f18990e;
    }

    private void b() {
        for (WeakReference weakReference : this.f18992b) {
            if (weakReference.get() == null) {
                this.f18992b.remove(weakReference);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i11 = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i11 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type == 9) {
                        return 7;
                    }
                    if (type != 4 && type != 5) {
                        return type != 6 ? 8 : 5;
                    }
                }
                return a(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i11;
    }

    public int a() {
        int i11;
        synchronized (this.f18993c) {
            i11 = this.f18994d;
        }
        return i11;
    }

    public void b(final c cVar) {
        b();
        this.f18992b.add(new WeakReference(cVar));
        this.f18991a.post(new Runnable() { // from class: com.applovin.impl.pv
            @Override // java.lang.Runnable
            public final void run() {
                this.f21856a.a(cVar);
            }
        });
    }
}
