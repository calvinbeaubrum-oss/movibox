package com.vungle.warren.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class NetworkProvider {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f62579i = "NetworkProvider";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static NetworkProvider f62580j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f62581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final ConnectivityManager f62582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f62583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f62584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<b> f62585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f62586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f62587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f62588h;

    /* JADX INFO: compiled from: source.java */
    public class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        @RequiresApi(api = 21)
        public void onAvailable(Network network) {
            super.onAvailable(network);
            NetworkProvider.this.h();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        @RequiresApi(api = 21)
        public void onLost(Network network) {
            super.onLost(network);
            NetworkProvider.this.h();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(int i11);
    }

    public NetworkProvider(Context context) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.f62583c = atomicInteger;
        this.f62585e = new CopyOnWriteArraySet();
        this.f62587g = new Handler(Looper.getMainLooper());
        this.f62588h = new Runnable() { // from class: com.vungle.warren.utility.NetworkProvider.3
            @Override // java.lang.Runnable
            public void run() {
                if (NetworkProvider.this.f62585e.isEmpty()) {
                    return;
                }
                NetworkProvider.this.h();
                NetworkProvider.this.f62587g.postDelayed(NetworkProvider.this.f62588h, 30000L);
            }
        };
        Context applicationContext = context.getApplicationContext();
        this.f62581a = applicationContext;
        this.f62582b = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        atomicInteger.set(e());
    }

    public static synchronized NetworkProvider f(Context context) {
        try {
            if (f62580j == null) {
                f62580j = new NetworkProvider(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f62580j;
    }

    public void d(b bVar) {
        this.f62585e.add(bVar);
        k(true);
    }

    public int e() {
        int type = -1;
        if (this.f62582b == null || z2.f.a(this.f62581a, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            this.f62583c.set(-1);
            return -1;
        }
        NetworkInfo activeNetworkInfo = this.f62582b.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            type = activeNetworkInfo.getType();
        }
        int andSet = this.f62583c.getAndSet(type);
        if (type != andSet) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("on network changed: ");
            sb2.append(andSet);
            sb2.append("->");
            sb2.append(type);
            i(type);
        }
        k(!this.f62585e.isEmpty());
        return type;
    }

    @SuppressLint({"newApi"})
    public final ConnectivityManager.NetworkCallback g() {
        ConnectivityManager.NetworkCallback networkCallback = this.f62584d;
        if (networkCallback != null) {
            return networkCallback;
        }
        a aVar = new a();
        this.f62584d = aVar;
        return aVar;
    }

    public void h() {
        e();
    }

    public final void i(final int i11) {
        this.f62587g.post(new Runnable() { // from class: com.vungle.warren.utility.NetworkProvider.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NetworkProvider.this.f62585e.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).a(i11);
                }
            }
        });
    }

    public void j(b bVar) {
        this.f62585e.remove(bVar);
        k(!this.f62585e.isEmpty());
    }

    public final synchronized void k(boolean z11) {
        try {
            if (this.f62586f != z11) {
                this.f62586f = z11;
                ConnectivityManager connectivityManager = this.f62582b;
                if (connectivityManager != null) {
                    try {
                        if (z11) {
                            NetworkRequest.Builder builder = new NetworkRequest.Builder();
                            builder.addCapability(12);
                            this.f62582b.registerNetworkCallback(builder.build(), g());
                        } else {
                            connectivityManager.unregisterNetworkCallback(g());
                        }
                    } catch (Exception e11) {
                        if (!TextUtils.isEmpty(e11.getMessage())) {
                            Log.e(f62579i, e11.getMessage());
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
