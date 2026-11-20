package com.cloud.hisavana.sdk.manager;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cloud.hisavana.sdk.v;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import com.cloud.sdk.commonutil.util.i;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class NetStateManager {
    private static final int PROTECTION_TIME = 10000;
    private static final String TAG = "NetStateManager";
    private static AtomicBoolean isNetAvailable = new AtomicBoolean(false);
    private static AtomicBoolean isInitSuccessful = new AtomicBoolean(false);
    private static long lastRequestTime = 0;

    /* JADX INFO: compiled from: source.java */
    public class a extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network network) {
            super.onAvailable(network);
            NetStateManager.isInitSuccessful.set(true);
            NetStateManager.isNetAvailable.set(true);
            z.a().d(NetStateManager.TAG, "onAvailable isNetAvailable " + NetStateManager.isNetAvailable);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - NetStateManager.lastRequestTime) > 10000) {
                long unused = NetStateManager.lastRequestTime = jCurrentTimeMillis;
                v.p().g(2);
                g.f29881d.a().l();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(@NonNull Network network, boolean z11) {
            super.onBlockedStatusChanged(network, z11);
            NetStateManager.isInitSuccessful.set(true);
            NetStateManager.isNetAvailable.set(!z11);
            z.a().d(NetStateManager.TAG, "onBlockedStatusChanged isNetAvailable " + NetStateManager.isNetAvailable);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(@NonNull Network network, int i11) {
            super.onLosing(network, i11);
            NetStateManager.isInitSuccessful.set(true);
            NetStateManager.isNetAvailable.set(false);
            z.a().d(NetStateManager.TAG, "onLosing isNetAvailable " + NetStateManager.isNetAvailable);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            super.onLost(network);
            NetStateManager.isInitSuccessful.set(true);
            NetStateManager.isNetAvailable.set(false);
            NetStateManager.updateNetStatus(1000);
            z.a().d(NetStateManager.TAG, "onLost isNetAvailable " + NetStateManager.isNetAvailable);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            NetStateManager.isInitSuccessful.set(true);
            NetStateManager.isNetAvailable.set(false);
            z.a().d(NetStateManager.TAG, "onUnavailable isNetAvailable " + NetStateManager.isNetAvailable);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            NetStateManager.isNetAvailable.set(MitNetUtil.c(com.cloud.sdk.commonutil.util.f.a()));
        }
    }

    public static boolean checkNetworkState() {
        if (Build.VERSION.SDK_INT < 24) {
            return MitNetUtil.c(com.cloud.sdk.commonutil.util.f.a());
        }
        z.a().d(TAG, "checkNetworkState " + isNetAvailable + " isInitSuccessful " + isInitSuccessful);
        return isNetAvailable.get();
    }

    public static void registerMonitorBroadcast() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                ((ConnectivityManager) com.cloud.sdk.commonutil.util.f.a().getSystemService("connectivity")).registerDefaultNetworkCallback(new a());
            } catch (Exception e11) {
                z.a().e(TAG, "registerMonitorBroadcast " + Log.getStackTraceString(e11));
            }
        }
        updateNetStatus(0);
    }

    public static void setIsNetAvailable(boolean z11) {
        isNetAvailable.set(z11);
    }

    public static void updateNetStatus(int i11) {
        i.f30292a.f(new b(), i11);
    }
}
