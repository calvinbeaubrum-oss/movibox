package com.tmc.network;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Base64;
import com.applovin.sdk.AppLovinMediationProvider;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

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
@SuppressLint({"StaticFieldLeak"})
public final class NetworkMonitor {
    private static NetworkStatus currentStatus;
    private static boolean isNetworkConnected;
    private static NetworkStatus lastStatus;
    private static ConnectivityManager mConnectivityManager;
    private static Context mContext;
    private static final BroadcastReceiver mReceiver;
    private static int netStatus;
    private static CopyOnWriteArrayList<INetworkChangeListener> networkListeners;
    public static final NetworkMonitor INSTANCE = new NetworkMonitor();
    private static final AtomicBoolean isInited = new AtomicBoolean(false);
    private static String mNetworkType = AppLovinMediationProvider.UNKNOWN;
    private static String apn = AppLovinMediationProvider.UNKNOWN;
    private static String bssid = AppLovinMediationProvider.UNKNOWN;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface INetworkChangeListener {
        void onNetworkChanged(NetworkStatus networkStatus);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum NetworkStatus {
        NONE(AppLovinMediationProvider.UNKNOWN),
        G2("G2"),
        G3("G3"),
        G4("G4"),
        WIFI("WIFI"),
        G5("G5");

        private final String type;

        NetworkStatus(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }

    static {
        NetworkStatus networkStatus = NetworkStatus.NONE;
        currentStatus = networkStatus;
        lastStatus = networkStatus;
        networkListeners = new CopyOnWriteArrayList<>();
        mReceiver = new NetworkMonitor$mReceiver$1();
    }

    private NetworkMonitor() {
    }

    private final String base64Str(String str) {
        if (Intrinsics.b(str, AppLovinMediationProvider.UNKNOWN)) {
            return AppLovinMediationProvider.UNKNOWN;
        }
        try {
            Charset charset = Charsets.f69091b;
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str.getBytes(charset);
            Intrinsics.f(bytes, "(this as java.lang.String).getBytes(charset)");
            String strEncodeToString = Base64.encodeToString(bytes, 0);
            Intrinsics.f(strEncodeToString, "encodeToString(str.toByteArray(), Base64.DEFAULT)");
            return strEncodeToString;
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
            return AppLovinMediationProvider.UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkNetworkStatus(Context context) {
        String string;
        WifiInfo connectionInfo;
        String bssid2;
        try {
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo == null || !networkInfo.isConnected()) {
                currentStatus = NetworkStatus.NONE;
                mNetworkType = AppLovinMediationProvider.UNKNOWN;
                bssid = AppLovinMediationProvider.UNKNOWN;
                apn = AppLovinMediationProvider.UNKNOWN;
            } else {
                if (networkInfo.getType() == 1) {
                    mNetworkType = "WIFI";
                    Object systemService = context.getApplicationContext().getSystemService("wifi");
                    WifiManager wifiManager = systemService instanceof WifiManager ? (WifiManager) systemService : null;
                    if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || (bssid2 = connectionInfo.getBSSID()) == null) {
                        bssid2 = AppLovinMediationProvider.UNKNOWN;
                    }
                    bssid = bssid2;
                    if (Intrinsics.b(bssid2, "02:00:00:00:00:00") || l.v(bssid, AppLovinMediationProvider.UNKNOWN, true)) {
                        bssid = AppLovinMediationProvider.UNKNOWN;
                    }
                    currentStatus = NetworkStatus.WIFI;
                } else if (networkInfo.getType() == 0) {
                    int subtype = networkInfo.getSubtype();
                    String subtypeName = networkInfo.getSubtypeName();
                    Intrinsics.f(subtypeName, "networkInfo.subtypeName");
                    NetworkStatus networkStatus = parseNetworkStatus(subtype, subtypeName);
                    currentStatus = networkStatus;
                    mNetworkType = networkStatus.getType();
                    String extraInfo = networkInfo.getExtraInfo();
                    if (extraInfo != null && (string = StringsKt__StringsKt.Z0(extraInfo).toString()) != null) {
                        apn = string;
                    }
                } else {
                    currentStatus = NetworkStatus.NONE;
                    mNetworkType = AppLovinMediationProvider.UNKNOWN;
                    bssid = AppLovinMediationProvider.UNKNOWN;
                    apn = AppLovinMediationProvider.UNKNOWN;
                }
                mNetworkType = currentStatus.getType();
            }
            NetworkStatus networkStatus2 = lastStatus;
            NetworkStatus networkStatus3 = currentStatus;
            if (networkStatus2 != networkStatus3) {
                lastStatus = networkStatus3;
                notifyNetworkChanged(networkStatus3);
            }
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
        }
    }

    private final NetworkInfo getNetworkInfo() {
        Context applicationContext;
        if (mConnectivityManager == null) {
            Context context = mContext;
            Object systemService = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getSystemService("connectivity");
            mConnectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        }
        ConnectivityManager connectivityManager = mConnectivityManager;
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    private final boolean isMobile() {
        return currentStatus == NetworkStatus.G2 || currentStatus == NetworkStatus.G3 || currentStatus == NetworkStatus.G4 || currentStatus == NetworkStatus.G5;
    }

    private final NetworkStatus parseNetworkStatus(int i11, String str) {
        switch (i11) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkStatus.G2;
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
                return NetworkStatus.G3;
            case 13:
            case 18:
            case 19:
                return NetworkStatus.G4;
            case 20:
                return NetworkStatus.G5;
            default:
                int iHashCode = str.hashCode();
                return (iHashCode == -1004072973 ? str.equals("CDMA2000") : iHashCode == 82410124 ? str.equals("WCDMA") : iHashCode == 1954916075 && str.equals("TD-SCDMA")) ? NetworkStatus.G3 : NetworkStatus.NONE;
        }
    }

    private final void registerNetworkCallback(Context context) {
        Context applicationContext = context.getApplicationContext();
        Object systemService = applicationContext == null ? null : applicationContext.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return;
        }
        NetworkInfo networkInfo = getNetworkInfo();
        isNetworkConnected = networkInfo != null && networkInfo.isConnected();
        checkNetworkStatus(context);
        if (Build.VERSION.SDK_INT >= 24) {
            connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback() { // from class: com.tmc.network.NetworkMonitor.registerNetworkCallback.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    Intrinsics.g(network, "network");
                    super.onAvailable(network);
                    NetworkMonitor.isNetworkConnected = true;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                    Intrinsics.g(network, "network");
                    Intrinsics.g(networkCapabilities, "networkCapabilities");
                    super.onCapabilitiesChanged(network, networkCapabilities);
                    NetworkMonitor networkMonitor = NetworkMonitor.INSTANCE;
                    NetworkMonitor.netStatus = networkCapabilities.hasCapability(16) ? 1 : -1;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    Intrinsics.g(network, "network");
                    super.onLost(network);
                    NetworkMonitor.isNetworkConnected = false;
                    NetworkMonitor.netStatus = -1;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onUnavailable() {
                    super.onUnavailable();
                    NetworkMonitor.isNetworkConnected = false;
                }
            });
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                netStatus = networkCapabilities.hasCapability(16) ? 1 : -1;
            }
        }
    }

    private final void registerNetworkReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(mReceiver, intentFilter);
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
        }
    }

    public final String getNetworkId() {
        if (Intrinsics.b(mNetworkType, "WIFI")) {
            return mNetworkType + '#' + base64Str(bssid);
        }
        if (!isMobile()) {
            return AppLovinMediationProvider.UNKNOWN;
        }
        return mNetworkType + '#' + apn;
    }

    public final int getNetworkStatus() {
        return netStatus;
    }

    public final String getNetworkType() {
        return mNetworkType;
    }

    public final void init(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (isInited.compareAndSet(false, true)) {
                po.b.f73956a.d("NetworkMonitor", "NetworkMonitor.init");
                mContext = context;
                registerNetworkCallback(context);
                registerNetworkReceiver(context);
                NetworkConfig.INSTANCE.setPackageName(context.getPackageName());
            }
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
        }
    }

    public final boolean isConnected() {
        try {
            if (Build.VERSION.SDK_INT >= 24 && isNetworkConnected) {
                return true;
            }
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo == null) {
                return false;
            }
            return networkInfo.isConnected();
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
            return false;
        }
    }

    public final void notifyNetworkChanged(NetworkStatus status) {
        Intrinsics.g(status, "status");
        Iterator<T> it = networkListeners.iterator();
        while (it.hasNext()) {
            ((INetworkChangeListener) it.next()).onNetworkChanged(status);
        }
    }

    public final void registerListener(INetworkChangeListener listener) {
        Intrinsics.g(listener, "listener");
        po.b.f73956a.c(Intrinsics.p("register listener ", listener));
        networkListeners.add(listener);
    }

    public final void unregisterListener(INetworkChangeListener listener) {
        Intrinsics.g(listener, "listener");
        networkListeners.remove(listener);
    }
}
