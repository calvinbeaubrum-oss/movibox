package ho;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.ProxyInfo;
import android.net.TransportInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class r implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f66750a;

    public r(d dVar) {
        dVar.getClass();
        this.f66750a = dVar;
    }

    public static void a(e.a aVar, LinkProperties linkProperties) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) q.a(linkProperties.getLinkAddresses(), Collections.emptyList())).iterator();
        while (it.hasNext()) {
            arrayList.add(((LinkAddress) it.next()).getAddress());
        }
        boolean zIsEmpty = arrayList.isEmpty();
        List<InetAddress> listEmptyList = arrayList;
        if (zIsEmpty) {
            listEmptyList = Collections.emptyList();
        }
        aVar.m(listEmptyList);
        if (!com.google.common.base.p.b(linkProperties.getInterfaceName())) {
            aVar.l(linkProperties.getInterfaceName());
        }
        ProxyInfo httpProxy = linkProperties.getHttpProxy();
        if (httpProxy == null || com.google.common.base.p.b(httpProxy.getHost())) {
            return;
        }
        String host = httpProxy.getHost();
        if (httpProxy.getPort() > 0) {
            host = host + ":" + httpProxy.getPort();
        }
        aVar.j(host);
    }

    public static void b(e.a aVar, NetworkCapabilities networkCapabilities) {
        e.a aVarG = aVar.g(1, networkCapabilities.hasCapability(12)).g(2, networkCapabilities.hasCapability(0));
        int i11 = Build.VERSION.SDK_INT;
        aVarG.g(3, i11 >= 28 && networkCapabilities.hasCapability(18)).g(0, i11 >= 23 && networkCapabilities.hasCapability(16)).g(4, networkCapabilities.hasCapability(11));
        aVar.h(3, networkCapabilities.hasTransport(0)).h(1, networkCapabilities.hasTransport(3)).h(2, networkCapabilities.hasTransport(1)).h(501, i11 >= 26 && networkCapabilities.hasTransport(5)).h(500, networkCapabilities.hasTransport(4));
        aVar.i(networkCapabilities.getLinkDownstreamBandwidthKbps()).n(networkCapabilities.getLinkUpstreamBandwidthKbps());
        if (i11 >= 29) {
            TransportInfo transportInfo = networkCapabilities.getTransportInfo();
            if (transportInfo instanceof WifiInfo) {
                WifiInfo wifiInfo = (WifiInfo) transportInfo;
                try {
                    String str = (String) com.google.common.base.h.a(wifiInfo.getBSSID(), "02:00:00:00:00:00");
                    if (!str.equals("02:00:00:00:00:00")) {
                        aVar.e(str);
                    }
                } catch (Throwable unused) {
                }
                try {
                    String str2 = (String) com.google.common.base.h.a(wifiInfo.getMacAddress(), "02:00:00:00:00:00");
                    if (str2.equals("02:00:00:00:00:00")) {
                        return;
                    }
                    aVar.k(str2);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0087  */
    @Override // ho.o
    public boolean v(a.AbstractC0700a abstractC0700a, Context context) {
        e eVarF;
        int i11;
        if (!io.a.c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            eVarF = null;
        } else if (Build.VERSION.SDK_INT >= 23) {
            ConnectivityManager connectivityManagerH = this.f66750a.h();
            Network activeNetwork = connectivityManagerH.getActiveNetwork();
            if (activeNetwork == null) {
                eVarF = null;
            } else {
                NetworkCapabilities networkCapabilities = connectivityManagerH.getNetworkCapabilities(activeNetwork);
                LinkProperties linkProperties = connectivityManagerH.getLinkProperties(activeNetwork);
                if (networkCapabilities == null && linkProperties == null) {
                    eVarF = null;
                } else {
                    e.a aVarL = e.l();
                    if (networkCapabilities != null) {
                        b(aVarL, networkCapabilities);
                    }
                    if (linkProperties != null) {
                        a(aVarL, linkProperties);
                    }
                    eVarF = aVarL.f();
                }
            }
        } else {
            NetworkInfo activeNetworkInfo = this.f66750a.h().getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                eVarF = null;
            } else {
                e.a aVarL2 = e.l();
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype != 20) {
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            i11 = 4;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            i11 = 5;
                            break;
                        case 13:
                            i11 = 6;
                            break;
                        default:
                            i11 = 0;
                            break;
                    }
                } else {
                    i11 = 7;
                }
                if (i11 == 0) {
                    int type = activeNetworkInfo.getType();
                    if (type == 9) {
                        i11 = 1;
                    } else if (type == 17) {
                        i11 = 500;
                    } else if (type == 0) {
                        i11 = 3;
                    } else if (type == 1) {
                        i11 = 2;
                    } else if (type == 2 || type == 3 || type == 4 || type == 5) {
                        i11 = 3;
                    } else {
                        i11 = 0;
                    }
                }
                if (i11 != 0) {
                    aVarL2.h(i11, true);
                }
                eVarF = aVarL2.g(1, activeNetworkInfo.isAvailable()).g(0, activeNetworkInfo.isConnectedOrConnecting()).f();
            }
        }
        if (eVarF == null) {
            abstractC0700a.j(Collections.emptyList()).b(-1);
        } else {
            abstractC0700a.j(Collections.singletonList(eVarF)).b(0);
        }
        return false;
    }
}
