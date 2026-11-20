package com.tn.lib.util.networkinfo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f49475a = new f();

    public final NetworkInfo a() {
        Object systemService = Utils.a().getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public final int b() {
        return NetWorkCallback.f49460g.a().w();
    }

    public final NetworkType c() {
        return NetWorkCallback.f49460g.a().y();
    }

    public final NetworkType d() {
        if (g()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo networkInfoA = a();
        if (networkInfoA == null) {
            return NetworkType.NETWORK_NO;
        }
        int type = networkInfoA.getType();
        if (type != 0) {
            return type != 1 ? NetworkType.NETWORK_UNKNOWN : NetworkType.NETWORK_WIFI;
        }
        switch (networkInfoA.getSubtype()) {
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
                String subtypeName = networkInfoA.getSubtypeName();
                return (l.v(subtypeName, "TD-SCDMA", true) || l.v(subtypeName, "WCDMA", true) || l.v(subtypeName, "CDMA2000", true)) ? NetworkType.NETWORK_3G : NetworkType.NETWORK_UNKNOWN;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    public final boolean e() {
        return NetWorkCallback.f49460g.a().z();
    }

    public final void f() {
        NetWorkCallback.f49460g.a().B();
    }

    public final boolean g() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        Object systemService = Utils.a().getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }

    public final boolean h(Context context) {
        Intrinsics.g(context, "context");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return false;
            }
        } else {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasTransport(0)) {
                return false;
            }
        }
        return true;
    }

    public final boolean i(Context context) {
        Intrinsics.g(context, "context");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
        } else {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.g(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
        } else {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasCapability(12)) {
                return true;
            }
        }
        return false;
    }

    public final boolean k(Context context) {
        Intrinsics.g(context, "context");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return false;
            }
        } else {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasTransport(1)) {
                return false;
            }
        }
        return true;
    }

    public final void l(g gVar) {
        NetWorkCallback.f49460g.a().C(gVar);
    }

    public final void m(g gVar) {
        NetWorkCallback.f49460g.a().G(gVar);
    }
}
