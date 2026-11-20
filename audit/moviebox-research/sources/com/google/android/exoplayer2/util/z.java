package com.google.android.exoplayer2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public static z f35685e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f35686a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<WeakReference<c>> f35687b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f35688c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f35689d = 0;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class b {

        /* JADX INFO: compiled from: source.java */
        public static final class a extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final z f35690a;

            public a(z zVar) {
                this.f35690a = zVar;
            }

            @Override // android.telephony.TelephonyCallback.DisplayInfoListener
            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.f35690a.k(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void a(Context context, z zVar) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) com.google.android.exoplayer2.util.a.e((TelephonyManager) context.getSystemService("phone"));
                a aVar = new a(zVar);
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), aVar);
                telephonyManager.unregisterTelephonyCallback(aVar);
            } catch (RuntimeException unused) {
                zVar.k(5);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public final class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int iG = z.g(context);
            if (o0.f35608a < 31 || iG != 5) {
                z.this.k(iG);
            } else {
                b.a(context, z.this);
            }
        }
    }

    public z(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new d(), intentFilter);
    }

    public static synchronized z d(Context context) {
        try {
            if (f35685e == null) {
                f35685e = new z(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f35685e;
    }

    public static int e(NetworkInfo networkInfo) {
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
                return o0.f35608a >= 29 ? 9 : 0;
        }
    }

    public static int g(Context context) {
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
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return e(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i11;
    }

    public int f() {
        int i11;
        synchronized (this.f35688c) {
            i11 = this.f35689d;
        }
        return i11;
    }

    public final /* synthetic */ void h(c cVar) {
        cVar.a(f());
    }

    public void i(final c cVar) {
        j();
        this.f35687b.add(new WeakReference<>(cVar));
        this.f35686a.post(new Runnable() { // from class: com.google.android.exoplayer2.util.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f35683a.h(cVar);
            }
        });
    }

    public final void j() {
        for (WeakReference<c> weakReference : this.f35687b) {
            if (weakReference.get() == null) {
                this.f35687b.remove(weakReference);
            }
        }
    }

    public final void k(int i11) {
        synchronized (this.f35688c) {
            try {
                if (this.f35689d == i11) {
                    return;
                }
                this.f35689d = i11;
                for (WeakReference<c> weakReference : this.f35687b) {
                    c cVar = weakReference.get();
                    if (cVar != null) {
                        cVar.a(i11);
                    } else {
                        this.f35687b.remove(weakReference);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
