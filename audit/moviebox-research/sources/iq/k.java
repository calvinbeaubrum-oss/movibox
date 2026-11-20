package iq;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.transsion.ga.AthenaAnalytics;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f67654a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f67655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f67656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f67657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f67658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f67659f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Intrinsics.g(network, "network");
            super.onAvailable(network);
            o.f67667a.h("NetworkMonitor", "onAvailable : " + network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z11) {
            Intrinsics.g(network, "network");
            super.onBlockedStatusChanged(network, z11);
            o.f67667a.h("NetworkMonitor", "onBlockedStatusChanged");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            super.onCapabilitiesChanged(network, networkCapabilities);
            boolean zHasCapability = networkCapabilities.hasCapability(16);
            k kVar = k.f67654a;
            kVar.k(networkCapabilities.hasCapability(12));
            kVar.i(kVar.g() && !zHasCapability);
            kVar.j(true);
            o.f67667a.h("NetworkMonitor", "isNetworkConnected : " + kVar.g() + ",  isFakeNetwork : " + kVar.e());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i11) {
            Intrinsics.g(network, "network");
            super.onLosing(network, i11);
            o.f67667a.h("NetworkMonitor", "onLosing");
            k.f67654a.k(false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Intrinsics.g(network, "network");
            super.onLost(network);
            o.f67667a.h("NetworkMonitor", "onLost");
            k.f67654a.k(false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            o.f67667a.h("NetworkMonitor", "onUnavailable");
        }
    }

    @JvmStatic
    public static final void c(Application application, boolean z11) {
        Intrinsics.g(application, "application");
        d(application, new String[0], z11);
    }

    @JvmStatic
    public static final void d(Application application, String[] hosts, boolean z11) {
        Intrinsics.g(application, "application");
        Intrinsics.g(hosts, "hosts");
        f67655b = z11;
        AthenaAnalytics.F(application, "NetworkMonitor", 1814, z11, false);
        d.f67594a.e(hosts);
        k kVar = f67654a;
        kVar.h(application);
        f67659f = SystemClock.uptimeMillis();
        kVar.l();
    }

    public static final void m() {
        String str = f67656c ? "0" : "1";
        if (f67657d) {
            str = "2";
        }
        new dr.a("monitor_init", 1814).c(androidx.core.os.c.b(TuplesKt.a("net_status", str)), null).b();
    }

    public final long b() {
        return f67659f;
    }

    public final boolean e() {
        return f67657d;
    }

    public final boolean f() {
        return f67658e;
    }

    public final boolean g() {
        return f67656c;
    }

    public final void h(Context context) {
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager != null && Build.VERSION.SDK_INT >= 23) {
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), new a());
        }
    }

    public final void i(boolean z11) {
        f67657d = z11;
    }

    public final void j(boolean z11) {
        f67658e = z11;
    }

    public final void k(boolean z11) {
        f67656c = z11;
    }

    public final void l() {
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: iq.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.m();
                }
            }, 5000L);
        } catch (Exception e11) {
            o.f67667a.j("NetworkMonitor", Log.getStackTraceString(e11));
        }
    }
}
