package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class uEA {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Object f27040sc = new Object();
    private static final Map<sc, Object> pFF = new ConcurrentHashMap();
    private static AtomicBoolean zY = new AtomicBoolean(false);
    private static volatile int We = -1;
    private static volatile long ExN = 0;
    private static volatile int TRI = 60000;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static dE f27039qr = null;
    private static final AtomicBoolean Qj = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    public static class pFF extends BroadcastReceiver {
        private pFF() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z11 = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (uEA.pFF != null && uEA.pFF.size() > 0) {
                z11 = true;
            }
            uEA.pFF(context, intent, z11, booleanExtra);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(Context context, Intent intent, boolean z11, int i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int pFF(Context context) {
        We = zY(context);
        ExN = SystemClock.elapsedRealtime();
        return We;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(Context context, Intent intent, int i11, boolean z11) {
        Map<sc, Object> map = pFF;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (sc scVar : map.keySet()) {
            if (scVar != null) {
                scVar.sc(context, intent, !z11, i11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(final Context context, final Intent intent, final boolean z11, final boolean z12) {
        if (!z11 && z12) {
            We = 0;
        } else if (Qj.compareAndSet(false, true)) {
            com.bytedance.sdk.component.Qj.TRI.pFF(new com.bytedance.sdk.component.Qj.Qj("getNetworkType") { // from class: com.bytedance.sdk.component.utils.uEA.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = uEA.We = z12 ? 0 : uEA.pFF(context);
                    uEA.Qj.set(false);
                    if (z11) {
                        uEA.pFF(context, intent, uEA.We, z12);
                    }
                }
            });
        }
    }

    public static int sc(Context context, long j11) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (ExN + j11 > jElapsedRealtime && We != -1) {
            if (jElapsedRealtime - ExN >= TRI) {
                pFF(context, (Intent) null, false, false);
            }
            return We;
        }
        return pFF(context);
    }

    public static void sc(sc scVar) {
        if (scVar == null) {
            return;
        }
        pFF.remove(scVar);
    }

    public static void sc(sc scVar, Context context) {
        if (scVar == null) {
            return;
        }
        if (!zY.get()) {
            try {
                context.registerReceiver(new pFF(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                zY.set(true);
            } catch (Throwable unused) {
            }
        }
        pFF.put(scVar, f27040sc);
    }

    private static int zY(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        dE dEVar = f27039qr;
                        return (dEVar == null || !dEVar.sc(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }
}
