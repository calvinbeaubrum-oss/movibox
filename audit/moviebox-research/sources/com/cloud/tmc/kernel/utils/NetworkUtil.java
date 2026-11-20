package com.cloud.tmc.kernel.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.e0;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class NetworkUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Network f31274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<d> f31275b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f31276c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static BroadcastReceiver f31277d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e0.c f31278e = new a();

    /* JADX INFO: compiled from: source.java */
    public enum Network {
        NETWORK_WIFI,
        NETWORK_MOBILE_FAST,
        NETWORK_MOBILE_VERY_FAST,
        NETWORK_MOBILE_MIDDLE,
        NETWORK_MOBILE_SLOW,
        NETWORK_NO_CONNECTION,
        NETWORK_TYPE_UNKNOWN
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements e0.c {
        @Override // com.cloud.tmc.miniutils.util.e0.c
        public void a(Activity activity) {
            NetworkUtil.i(activity.getApplicationContext());
        }

        @Override // com.cloud.tmc.miniutils.util.e0.c
        public void b(Activity activity) {
            NetworkUtil.l(activity.getApplicationContext());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31279a;

        static {
            int[] iArr = new int[Network.values().length];
            f31279a = iArr;
            try {
                iArr[Network.NETWORK_NO_CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31279a[Network.NETWORK_MOBILE_SLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31279a[Network.NETWORK_MOBILE_MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31279a[Network.NETWORK_MOBILE_FAST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31279a[Network.NETWORK_MOBILE_VERY_FAST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31279a[Network.NETWORK_WIFI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends BroadcastReceiver {
        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkUtil.m(context);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(Network network, Network network2);
    }

    public static void d(Context context, d dVar) {
        if (dVar != null) {
            List<d> list = f31275b;
            if (list.contains(dVar)) {
                return;
            }
            list.add(dVar);
            i(context.getApplicationContext());
        }
    }

    public static Network e(NetworkInfo networkInfo) {
        try {
            if (networkInfo != null && networkInfo.isConnected()) {
                int type = networkInfo.getType();
                int subtype = networkInfo.getSubtype();
                TmcLogger.c("NetworkUtil", "type: " + type + " subType: " + subtype);
                if (type != 1 && type != 9) {
                    if (type == 0 && subtype != 0) {
                        if (subtype != 1 && subtype != 2 && subtype != 4 && subtype != 7 && subtype != 11) {
                            if (subtype != 13) {
                                if (subtype != 16) {
                                    switch (subtype) {
                                        case 18:
                                        case 19:
                                            break;
                                        case 20:
                                            return Network.NETWORK_MOBILE_VERY_FAST;
                                        default:
                                            return Network.NETWORK_MOBILE_MIDDLE;
                                    }
                                }
                            }
                            return Network.NETWORK_MOBILE_FAST;
                        }
                        return Network.NETWORK_MOBILE_SLOW;
                    }
                    return Network.NETWORK_TYPE_UNKNOWN;
                }
                return Network.NETWORK_WIFI;
            }
            return Network.NETWORK_NO_CONNECTION;
        } catch (Exception e11) {
            TmcLogger.g("NetworkUtil", "detectNetwork error!", e11);
            return Network.NETWORK_TYPE_UNKNOWN;
        }
    }

    public static Network f(Context context, boolean z11) {
        Network network = f31274a;
        if (network != null && z11) {
            return network;
        }
        m(context);
        return f31274a;
    }

    @NonNull
    public static String g(Context context) {
        NetworkInfo.State state;
        NetworkInfo.State state2;
        NetworkInfo.State state3;
        if (context == null) {
            return "UNKNOWN";
        }
        NetworkInfo activeNetworkInfo = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            state = connectivityManager.getNetworkInfo(0).getState();
            try {
                state2 = connectivityManager.getNetworkInfo(1).getState();
                try {
                    NetworkInfo.State state4 = NetworkInfo.State.CONNECTED;
                    if (state != state4 && state != (state3 = NetworkInfo.State.CONNECTING)) {
                        return (state2 == state4 || state2 == state3) ? "WIFI" : "UNKNOWN";
                    }
                    activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return "2G";
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
                            return "3G";
                        case 13:
                        case 18:
                        case 19:
                            return "4G";
                        case 20:
                            return "5G";
                        default:
                            String subtypeName = activeNetworkInfo.getSubtypeName();
                            if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName)) {
                                Log.e("NetworkUtil", "network unknown, type: " + activeNetworkInfo.getSubtype() + " , mobile: " + state);
                                return "UNKNOWN";
                            }
                            return "3G";
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                th = th2;
            } catch (Throwable th3) {
                th = th3;
                state2 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            state = null;
            state2 = null;
        }
        TmcLogger.h("NetworkUtil", th);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("network unknown, type: ");
        sb2.append(activeNetworkInfo == null ? "null" : Integer.valueOf(activeNetworkInfo.getSubtype()));
        sb2.append(" , mobile: ");
        sb2.append(state);
        sb2.append(", wifi: ");
        sb2.append(state2);
        Log.e("NetworkUtil", sb2.toString());
        return "UNKNOWN";
    }

    public static String h(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return "fail";
        }
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e11) {
            TmcLogger.g("NetworkUtil", "Exception", e11);
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null) {
            return "fail";
        }
        int type = activeNetworkInfo.getType();
        return (type == 1 || type == 9) ? "wifi" : "wwan";
    }

    public static synchronized void i(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f31276c) {
                return;
            }
            f31276c = true;
            try {
                if (f31277d == null) {
                    f31277d = new c(null);
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.getApplicationContext().registerReceiver(f31277d, intentFilter);
            } catch (Exception e11) {
                TmcLogger.g("NetworkUtil", "registerReceiver error", e11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void j(Context context, d dVar) {
        if (dVar == null) {
            return;
        }
        List<d> list = f31275b;
        list.remove(dVar);
        if (list.isEmpty()) {
            l(context);
        }
    }

    public static String k(Network network) {
        switch (b.f31279a[network.ordinal()]) {
            case 1:
                return DevicePublicKeyStringDef.NONE;
            case 2:
                return "2G";
            case 3:
                return "3G";
            case 4:
                return "4G";
            case 5:
                return "5G";
            case 6:
                return "WIFI";
            default:
                return "UNKNOWN";
        }
    }

    public static synchronized void l(Context context) {
        f31276c = false;
        if (f31277d == null || context == null) {
            return;
        }
        try {
            context.getApplicationContext().unregisterReceiver(f31277d);
            f31277d = null;
        } catch (Exception e11) {
            TmcLogger.g("NetworkUtil", "unRegisterReceiver error", e11);
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void m(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return;
        }
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e11) {
            TmcLogger.g("NetworkUtil", "exception detail", e11);
            activeNetworkInfo = null;
        }
        Network network = f31274a;
        Network networkE = e(activeNetworkInfo);
        f31274a = networkE;
        if (network == null || networkE == network) {
            return;
        }
        TmcLogger.c("NetworkUtil", "onNetworkChanged");
        List<d> list = f31275b;
        synchronized (list) {
            try {
                for (d dVar : list) {
                    if (dVar != null) {
                        dVar.a(network, f31274a);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
