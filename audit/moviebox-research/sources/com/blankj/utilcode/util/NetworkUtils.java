package com.blankj.utilcode.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Utils.b<b>> f25233a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Timer f25234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f25235c;

    /* JADX INFO: renamed from: com.blankj.utilcode.util.NetworkUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass1 extends Utils.Task<Boolean> {
        public AnonymousClass1(Utils.b bVar) {
            super(bVar);
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission("android.permission.INTERNET")
        public Boolean doInBackground() {
            return Boolean.valueOf(NetworkUtils.n());
        }
    }

    /* JADX INFO: renamed from: com.blankj.utilcode.util.NetworkUtils$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass2 extends Utils.Task<Boolean> {
        final /* synthetic */ String val$ip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Utils.b bVar, String str) {
            super(bVar);
            this.val$ip = str;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission("android.permission.INTERNET")
        public Boolean doInBackground() {
            return Boolean.valueOf(NetworkUtils.q(this.val$ip));
        }
    }

    /* JADX INFO: renamed from: com.blankj.utilcode.util.NetworkUtils$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass3 extends Utils.Task<Boolean> {
        final /* synthetic */ String val$domain;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Utils.b bVar, String str) {
            super(bVar);
            this.val$domain = str;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission("android.permission.INTERNET")
        public Boolean doInBackground() {
            return Boolean.valueOf(NetworkUtils.p(this.val$domain));
        }
    }

    /* JADX INFO: renamed from: com.blankj.utilcode.util.NetworkUtils$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass4 extends Utils.Task<Boolean> {
        public AnonymousClass4(Utils.b bVar) {
            super(bVar);
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.INTERNET"})
        public Boolean doInBackground() {
            return Boolean.valueOf(NetworkUtils.v());
        }
    }

    /* JADX INFO: renamed from: com.blankj.utilcode.util.NetworkUtils$5, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass5 extends Utils.Task<String> {
        final /* synthetic */ boolean val$useIPv4;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Utils.b bVar, boolean z11) {
            super(bVar);
            this.val$useIPv4 = z11;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission("android.permission.INTERNET")
        public String doInBackground() {
            return NetworkUtils.j(this.val$useIPv4);
        }
    }

    /* JADX INFO: renamed from: com.blankj.utilcode.util.NetworkUtils$6, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass6 extends Utils.Task<String> {
        final /* synthetic */ String val$domain;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Utils.b bVar, String str) {
            super(bVar);
            this.val$domain = str;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission("android.permission.INTERNET")
        public String doInBackground() {
            return NetworkUtils.i(this.val$domain);
        }
    }

    /* JADX INFO: renamed from: com.blankj.utilcode.util.NetworkUtils$7, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ Utils.b val$consumer;

        public AnonymousClass7(Utils.b bVar) {
            this.val$consumer = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NetworkUtils.f25233a.isEmpty()) {
                NetworkUtils.f25233a.add(this.val$consumer);
                NetworkUtils.y();
            } else {
                this.val$consumer.accept(NetworkUtils.f25235c);
                NetworkUtils.f25233a.add(this.val$consumer);
            }
        }
    }

    /* JADX INFO: renamed from: com.blankj.utilcode.util.NetworkUtils$9, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ Utils.b val$consumer;

        public AnonymousClass9(Utils.b bVar) {
            this.val$consumer = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            NetworkUtils.f25233a.remove(this.val$consumer);
            if (NetworkUtils.f25233a.isEmpty()) {
                NetworkUtils.A();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class NetworkChangedReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NetworkType f25236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Set<a> f25237b = new HashSet();

        /* JADX INFO: compiled from: source.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final NetworkChangedReceiver f25238a = new NetworkChangedReceiver();
        }

        public static NetworkChangedReceiver e() {
            return a.f25238a;
        }

        @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
        public void f(final a aVar) {
            if (aVar == null) {
                return;
            }
            j0.H(new Runnable() { // from class: com.blankj.utilcode.util.NetworkUtils.NetworkChangedReceiver.1
                @Override // java.lang.Runnable
                @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
                public void run() {
                    int size = NetworkChangedReceiver.this.f25237b.size();
                    NetworkChangedReceiver.this.f25237b.add(aVar);
                    if (size == 0 && NetworkChangedReceiver.this.f25237b.size() == 1) {
                        NetworkChangedReceiver.this.f25236a = NetworkUtils.k();
                        Utils.a().registerReceiver(NetworkChangedReceiver.e(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    }
                }
            });
        }

        public void g(final a aVar) {
            if (aVar == null) {
                return;
            }
            j0.H(new Runnable() { // from class: com.blankj.utilcode.util.NetworkUtils.NetworkChangedReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    int size = NetworkChangedReceiver.this.f25237b.size();
                    NetworkChangedReceiver.this.f25237b.remove(aVar);
                    if (size == 1 && NetworkChangedReceiver.this.f25237b.size() == 0) {
                        Utils.a().unregisterReceiver(NetworkChangedReceiver.e());
                    }
                }
            });
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                j0.I(new Runnable() { // from class: com.blankj.utilcode.util.NetworkUtils.NetworkChangedReceiver.3
                    @Override // java.lang.Runnable
                    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
                    public void run() {
                        NetworkType networkTypeK = NetworkUtils.k();
                        if (NetworkChangedReceiver.this.f25236a == networkTypeK) {
                            return;
                        }
                        NetworkChangedReceiver.this.f25236a = networkTypeK;
                        if (networkTypeK == NetworkType.NETWORK_NO) {
                            Iterator it = NetworkChangedReceiver.this.f25237b.iterator();
                            while (it.hasNext()) {
                                ((a) it.next()).onDisconnected();
                            }
                        } else {
                            Iterator it2 = NetworkChangedReceiver.this.f25237b.iterator();
                            while (it2.hasNext()) {
                                ((a) it2.next()).k(networkTypeK);
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
    public interface a {
        void k(NetworkType networkType);

        void onDisconnected();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<ScanResult> f25239a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<ScanResult> f25240b = new ArrayList();

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
            this.f25239a = list;
            this.f25240b = b(list);
        }
    }

    public static void A() {
        Timer timer = f25234b;
        if (timer != null) {
            timer.cancel();
            f25234b = null;
        }
    }

    public static void B(a aVar) {
        NetworkChangedReceiver.e().g(aVar);
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static NetworkInfo h() {
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    @RequiresPermission("android.permission.INTERNET")
    public static String i(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public static String j(boolean z11) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            LinkedList<InetAddress> linkedList = new LinkedList();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        linkedList.addFirst(inetAddresses.nextElement());
                    }
                }
            }
            for (InetAddress inetAddress : linkedList) {
                if (!inetAddress.isLoopbackAddress()) {
                    String hostAddress = inetAddress.getHostAddress();
                    boolean z12 = hostAddress.indexOf(58) < 0;
                    if (z11) {
                        if (z12) {
                            return hostAddress;
                        }
                    } else if (!z12) {
                        int iIndexOf = hostAddress.indexOf(37);
                        return iIndexOf < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, iIndexOf).toUpperCase();
                    }
                }
            }
            return "";
        } catch (SocketException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static NetworkType k() {
        if (s()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo networkInfoH = h();
        if (networkInfoH == null || !networkInfoH.isAvailable()) {
            return NetworkType.NETWORK_NO;
        }
        if (networkInfoH.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (networkInfoH.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (networkInfoH.getSubtype()) {
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
                String subtypeName = networkInfoH.getSubtypeName();
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? NetworkType.NETWORK_3G : NetworkType.NETWORK_UNKNOWN;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    @RequiresPermission("android.permission.ACCESS_WIFI_STATE")
    public static boolean l() {
        WifiManager wifiManager = (WifiManager) Utils.a().getSystemService("wifi");
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    @RequiresPermission(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_COARSE_LOCATION"})
    public static b m() {
        List<ScanResult> scanResults;
        b bVar = new b();
        if (l() && (scanResults = ((WifiManager) Utils.a().getSystemService("wifi")).getScanResults()) != null) {
            bVar.c(scanResults);
        }
        return bVar;
    }

    @RequiresPermission("android.permission.INTERNET")
    public static boolean n() {
        return o() || q(null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static boolean o() {
        return p("");
    }

    @RequiresPermission("android.permission.INTERNET")
    public static boolean p(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "www.baidu.com";
        }
        try {
            return InetAddress.getByName(str) != null;
        } catch (UnknownHostException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public static boolean q(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "223.5.5.5";
        }
        return e0.a(String.format("ping -c 1 %s", str), false).f25325a == 0;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean r() {
        NetworkInfo networkInfoH = h();
        return networkInfoH != null && networkInfoH.isConnected();
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean s() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.a().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }

    public static boolean t(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult != null && scanResult2 != null && j0.e(scanResult.BSSID, scanResult2.BSSID) && j0.e(scanResult.SSID, scanResult2.SSID) && j0.e(scanResult.capabilities, scanResult2.capabilities) && scanResult.level == scanResult2.level;
    }

    public static boolean u(List<ScanResult> list, List<ScanResult> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (!t(list.get(i11), list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    @RequiresPermission(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.INTERNET"})
    public static boolean v() {
        return l() && n();
    }

    public static void w() {
        Utils.a().startActivity(new Intent("android.settings.WIRELESS_SETTINGS").setFlags(ASTNode.DEOP));
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static void x(a aVar) {
        NetworkChangedReceiver.e().f(aVar);
    }

    public static void y() {
        f25235c = new b();
        Timer timer = new Timer();
        f25234b = timer;
        timer.schedule(new TimerTask() { // from class: com.blankj.utilcode.util.NetworkUtils.8
            @Override // java.util.TimerTask, java.lang.Runnable
            @RequiresPermission(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_COARSE_LOCATION"})
            public void run() {
                NetworkUtils.z();
                b bVarM = NetworkUtils.m();
                if (NetworkUtils.u(NetworkUtils.f25235c.f25239a, bVarM.f25239a)) {
                    return;
                }
                b unused = NetworkUtils.f25235c = bVarM;
                j0.H(new Runnable() { // from class: com.blankj.utilcode.util.NetworkUtils.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = NetworkUtils.f25233a.iterator();
                        while (it.hasNext()) {
                            ((Utils.b) it.next()).accept(NetworkUtils.f25235c);
                        }
                    }
                });
            }
        }, 0L, 3000L);
    }

    @RequiresPermission(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE"})
    public static void z() {
        if (l()) {
            ((WifiManager) Utils.a().getSystemService("wifi")).startScan();
        }
    }
}
