package com.cloud.tmc.miniutils.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f31950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static NetworkType f31951b = NetworkType.NETWORK_NO;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AtomicBoolean f31952c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f31953d = "NetworkUtils";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<e0.b<c>> f31954e = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Timer f31955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c f31956g;

    /* JADX INFO: renamed from: com.cloud.tmc.miniutils.util.NetworkUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ e0.b val$consumer;

        public AnonymousClass1(e0.b bVar) {
            this.val$consumer = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NetworkUtils.f31954e.isEmpty()) {
                NetworkUtils.f31954e.add(this.val$consumer);
                NetworkUtils.z();
            } else {
                this.val$consumer.accept(NetworkUtils.f31956g);
                NetworkUtils.f31954e.add(this.val$consumer);
            }
        }
    }

    /* JADX INFO: renamed from: com.cloud.tmc.miniutils.util.NetworkUtils$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ e0.b val$consumer;

        public AnonymousClass3(e0.b bVar) {
            this.val$consumer = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            NetworkUtils.f31954e.remove(this.val$consumer);
            if (NetworkUtils.f31954e.isEmpty()) {
                NetworkUtils.B();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class NetworkChangedReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NetworkType f31957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Set<b> f31958b = new HashSet();

        /* JADX INFO: compiled from: source.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final NetworkChangedReceiver f31959a = new NetworkChangedReceiver();
        }

        public static NetworkChangedReceiver e() {
            return a.f31959a;
        }

        @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
        public void f(final b bVar) {
            if (bVar == null) {
                return;
            }
            h0.x(new Runnable() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.NetworkChangedReceiver.1
                @Override // java.lang.Runnable
                @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
                public void run() {
                    int size = NetworkChangedReceiver.this.f31958b.size();
                    NetworkChangedReceiver.this.f31958b.add(bVar);
                    if (size == 0 && NetworkChangedReceiver.this.f31958b.size() == 1) {
                        NetworkChangedReceiver.this.f31957a = NetworkUtils.o();
                        e0.a().registerReceiver(NetworkChangedReceiver.e(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    }
                }
            });
        }

        public void g(final b bVar) {
            if (bVar == null) {
                return;
            }
            h0.x(new Runnable() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.NetworkChangedReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    int size = NetworkChangedReceiver.this.f31958b.size();
                    NetworkChangedReceiver.this.f31958b.remove(bVar);
                    if (size == 1 && NetworkChangedReceiver.this.f31958b.size() == 0) {
                        e0.a().unregisterReceiver(NetworkChangedReceiver.e());
                    }
                }
            });
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                h0.y(new Runnable() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.NetworkChangedReceiver.3
                    @Override // java.lang.Runnable
                    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
                    public void run() {
                        NetworkType networkTypeO = NetworkUtils.o();
                        if (NetworkChangedReceiver.this.f31957a == networkTypeO) {
                            return;
                        }
                        NetworkChangedReceiver.this.f31957a = networkTypeO;
                        if (networkTypeO == NetworkType.NETWORK_NO) {
                            Iterator it = NetworkChangedReceiver.this.f31958b.iterator();
                            while (it.hasNext()) {
                                ((b) it.next()).onDisconnected();
                            }
                        } else {
                            Iterator it2 = NetworkChangedReceiver.this.f31958b.iterator();
                            while (it2.hasNext()) {
                                ((b) it2.next()).a(networkTypeO);
                            }
                        }
                    }
                }, 1000L);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum NetworkType {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network network) {
            try {
                super.onAvailable(network);
                NetworkType unused = NetworkUtils.f31951b = NetworkUtils.o();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onAvailable,  networkType:");
                sb2.append(NetworkUtils.f31951b);
            } catch (Throwable th2) {
                Log.e(NetworkUtils.f31953d, "onAvailable: ", th2);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            try {
                super.onCapabilitiesChanged(network, networkCapabilities);
                if (networkCapabilities.hasCapability(16)) {
                    int unused = NetworkUtils.f31950a = 1;
                } else {
                    int unused2 = NetworkUtils.f31950a = -1;
                }
            } catch (Throwable th2) {
                Log.e(NetworkUtils.f31953d, "onCapabilitiesChanged: ", th2);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            try {
                int unused = NetworkUtils.f31950a = -1;
                super.onLost(network);
                NetworkType unused2 = NetworkUtils.f31951b = NetworkUtils.o();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onLost,  networkType:");
                sb2.append(NetworkUtils.f31951b);
            } catch (Throwable th2) {
                Log.e("onCapabilitiesChanged", "onLost:", th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(NetworkType networkType);

        void onDisconnected();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<ScanResult> f31960a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<ScanResult> f31961b = new ArrayList();

        public static List<ScanResult> b(List<ScanResult> list) {
            ScanResult scanResult;
            if (list == null || list.isEmpty()) {
                return new ArrayList();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (ScanResult scanResult2 : list) {
                if (!TextUtils.isEmpty(scanResult2.SSID) && ((scanResult = (ScanResult) linkedHashMap.get(scanResult2.SSID)) == null || scanResult.level < scanResult2.level)) {
                    linkedHashMap.put(scanResult2.SSID, scanResult2);
                }
            }
            return new ArrayList(linkedHashMap.values());
        }

        public void c(List<ScanResult> list) {
            this.f31960a = list;
            this.f31961b = b(list);
        }
    }

    @RequiresPermission(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE"})
    public static void A() {
        if (p()) {
            ((WifiManager) e0.a().getSystemService("wifi")).startScan();
        }
    }

    public static void B() {
        Timer timer = f31955f;
        if (timer != null) {
            timer.cancel();
            f31955f = null;
        }
    }

    public static void C(b bVar) {
        NetworkChangedReceiver.e().g(bVar);
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static NetworkInfo l() {
        ConnectivityManager connectivityManager = (ConnectivityManager) e0.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static NetworkType m() {
        return f31951b;
    }

    public static int n() {
        return f31950a;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static NetworkType o() {
        if (s()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo networkInfoL = l();
        if (networkInfoL == null || !networkInfoL.isAvailable()) {
            return NetworkType.NETWORK_NO;
        }
        if (networkInfoL.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (networkInfoL.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (networkInfoL.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
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
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
                return NetworkType.NETWORK_4G;
            case 19:
            default:
                String subtypeName = networkInfoL.getSubtypeName();
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? NetworkType.NETWORK_3G : NetworkType.NETWORK_UNKNOWN;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    @RequiresPermission("android.permission.ACCESS_WIFI_STATE")
    public static boolean p() {
        WifiManager wifiManager = (WifiManager) e0.a().getSystemService("wifi");
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    @RequiresPermission(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_COARSE_LOCATION"})
    public static c q() {
        List<ScanResult> scanResults;
        c cVar = new c();
        if (p() && (scanResults = ((WifiManager) e0.a().getSystemService("wifi")).getScanResults()) != null) {
            cVar.c(scanResults);
        }
        return cVar;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean r() {
        NetworkInfo networkInfoL = l();
        return networkInfoL != null && networkInfoL.isConnected();
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean s() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) e0.a().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean t() {
        NetworkInfo networkInfoL = l();
        return networkInfoL != null && networkInfoL.isAvailable() && networkInfoL.getType() == 0;
    }

    public static boolean u(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult != null && scanResult2 != null && h0.e(scanResult.BSSID, scanResult2.BSSID) && h0.e(scanResult.SSID, scanResult2.SSID) && h0.e(scanResult.capabilities, scanResult2.capabilities) && scanResult.level == scanResult2.level;
    }

    public static boolean v(List<ScanResult> list, List<ScanResult> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (!u(list.get(i11), list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean w() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) e0.a().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) ? false : true;
    }

    public static void x(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f31952c.compareAndSet(false, true)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (Build.VERSION.SDK_INT >= 24) {
                    connectivityManager.registerDefaultNetworkCallback(new a());
                }
            }
        } catch (Throwable th2) {
            Log.e(f31953d, "registerNetworkCallback: ", th2);
        }
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static void y(b bVar) {
        NetworkChangedReceiver.e().f(bVar);
    }

    public static void z() {
        f31956g = new c();
        Timer timer = new Timer();
        f31955f = timer;
        timer.schedule(new TimerTask() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.2
            @Override // java.util.TimerTask, java.lang.Runnable
            @RequiresPermission(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_COARSE_LOCATION"})
            public void run() {
                NetworkUtils.A();
                c cVarQ = NetworkUtils.q();
                if (NetworkUtils.v(NetworkUtils.f31956g.f31960a, cVarQ.f31960a)) {
                    return;
                }
                c unused = NetworkUtils.f31956g = cVarQ;
                h0.x(new Runnable() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = NetworkUtils.f31954e.iterator();
                        while (it.hasNext()) {
                            ((e0.b) it.next()).accept(NetworkUtils.f31956g);
                        }
                    }
                });
            }
        }, 0L, 3000L);
    }
}
