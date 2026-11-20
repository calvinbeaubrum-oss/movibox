package ho;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class u extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReadWriteLock f66754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f66755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap f66756d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap f66757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashSet f66758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Network f66759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t[] f66760i;

    public u(d dVar) {
        super(dVar);
        this.f66754b = io.d0.d();
        this.f66755c = new HashMap();
        this.f66756d = new HashMap();
        this.f66757f = new HashMap();
        this.f66758g = new HashSet();
    }

    @Override // ho.r, java.lang.AutoCloseable
    public final void close() {
        t[] tVarArr = this.f66760i;
        if (tVarArr != null) {
            try {
                for (t tVar : tVarArr) {
                    this.f66750a.h().unregisterNetworkCallback(tVar);
                }
            } catch (Throwable th2) {
                this.f66760i = null;
                throw th2;
            }
        }
        this.f66760i = null;
    }

    @Override // ho.r, ho.o
    public final boolean v(a.AbstractC0700a abstractC0700a, Context context) {
        s sVar;
        t tVar;
        if (this.f66760i != null) {
            Lock lock = this.f66754b.readLock();
            lock.lock();
            try {
                HashMap map = this.f66756d;
                HashMap map2 = this.f66757f;
                HashSet hashSet = this.f66758g;
                this.f66756d = new HashMap();
                this.f66757f = new HashMap();
                this.f66758g = new HashSet();
                lock.unlock();
                HashMap map3 = this.f66755c;
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    map3.remove((Network) it.next());
                }
                ArrayList<Network> arrayList = new ArrayList(map.size());
                arrayList.addAll(map.keySet());
                arrayList.addAll(map2.keySet());
                for (Network network : arrayList) {
                    e eVar = (e) map3.get(network);
                    e.a aVarL = eVar == null ? e.l() : eVar.m();
                    LinkProperties linkProperties = (LinkProperties) map.get(network);
                    NetworkCapabilities networkCapabilities = (NetworkCapabilities) map2.get(network);
                    if (linkProperties != null) {
                        r.a(aVarL, linkProperties);
                    }
                    if (networkCapabilities != null) {
                        r.b(aVarL, networkCapabilities);
                    }
                    map3.put(network, aVarL.f());
                }
                ArrayList arrayList2 = new ArrayList(this.f66755c.size());
                Network network2 = this.f66759h;
                int size = -1;
                for (Map.Entry entry : this.f66755c.entrySet()) {
                    if (network2 != null && ((Network) entry.getKey()).equals(network2)) {
                        size = arrayList2.size();
                    }
                    arrayList2.add((e) entry.getValue());
                }
                abstractC0700a.j(arrayList2).b(size);
                return true;
            } catch (Throwable th2) {
                lock.unlock();
                throw th2;
            }
        }
        super.v(abstractC0700a, context);
        if (!io.a.c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return false;
        }
        ConnectivityManager connectivityManagerH = this.f66750a.h();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 31 || !io.a.c(context, "android.permission.ACCESS_FINE_LOCATION")) {
            sVar = new s(this, 0);
            tVar = new t(this, 0);
        } else {
            sVar = new s(this);
            tVar = new t(this);
        }
        try {
            connectivityManagerH.registerDefaultNetworkCallback(sVar);
            try {
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addTransportType(0).addTransportType(1).addTransportType(3).addTransportType(4);
                if (i11 >= 26) {
                    builder.addTransportType(5);
                }
                connectivityManagerH.registerNetworkCallback(builder.build(), tVar);
                this.f66760i = new t[]{sVar, tVar};
                return true;
            } catch (Throwable unused) {
                connectivityManagerH.unregisterNetworkCallback(sVar);
                return false;
            }
        } catch (Throwable unused2) {
        }
    }
}
