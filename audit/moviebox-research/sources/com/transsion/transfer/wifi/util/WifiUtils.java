package com.transsion.transfer.wifi.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.R$string;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WifiUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WifiUtils f59242a = new WifiUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f59243b = LazyKt__LazyJVMKt.b(new Function0<WifiManager>() { // from class: com.transsion.transfer.wifi.util.WifiUtils$mWifiManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WifiManager invoke() {
            Object systemService = Utils.a().getApplicationContext().getSystemService("wifi");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            return (WifiManager) systemService;
        }
    });

    public final String c(String ssid) {
        Intrinsics.g(ssid, "ssid");
        if (TextUtils.isEmpty(ssid)) {
            return "";
        }
        int length = ssid.length() - 1;
        if (length < 0) {
            return ssid;
        }
        if (ssid.charAt(0) == '\"' && ssid.charAt(length) == '\"') {
            return ssid;
        }
        return "\"" + ssid + "\"";
    }

    public final String d() {
        String simpleName = WifiUtils.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final WifiP2pConfig e(qy.a aVar, WifiP2pDevice wifiP2pDevice) {
        WifiP2pConfig wifiP2pConfigBuild;
        String strP;
        String strO;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                j.a();
                WifiP2pConfig.Builder builderA = com.transsion.transfer.wifi.create.adapter.d.a();
                String str = "";
                if (aVar == null || (strP = aVar.p()) == null) {
                    strP = "";
                }
                WifiP2pConfig.Builder networkName = builderA.setNetworkName(strP);
                if (aVar != null && (strO = aVar.o()) != null) {
                    str = strO;
                }
                wifiP2pConfigBuild = networkName.setPassphrase(str).build();
            } catch (Exception e11) {
                e11.printStackTrace();
                wifiP2pConfigBuild = null;
            }
        } else {
            wifiP2pConfigBuild = new WifiP2pConfig();
            wifiP2pConfigBuild.deviceAddress = wifiP2pDevice != null ? wifiP2pDevice.deviceAddress : null;
        }
        WpsInfo wpsInfo = wifiP2pConfigBuild != null ? wifiP2pConfigBuild.wps : null;
        if (wpsInfo != null) {
            wpsInfo.setup = 0;
        }
        return wifiP2pConfigBuild;
    }

    public final String f(InetAddress inetAddress) {
        String hostAddress;
        if (inetAddress == null || inetAddress.isLoopbackAddress() || (hostAddress = inetAddress.getHostAddress()) == null || !l.L(hostAddress, "192.168", false, 2, null)) {
            return "";
        }
        Intrinsics.f(hostAddress, "hostAddress");
        return hostAddress;
    }

    public final Object g(Continuation<? super String> continuation) {
        return kotlinx.coroutines.h.g(w0.b(), new WifiUtils$getCorrectP2pAddress$2(null), continuation);
    }

    @SuppressLint({"MissingPermission"})
    public final NetworkInfo.DetailedState h() {
        Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getDetailedState();
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public final synchronized String i() {
        try {
            String ssidWithQuote = l().getConnectionInfo().getSSID();
            if (ssidWithQuote.length() < 3 || l().getConnectionInfo().getSupplicantState() == SupplicantState.DISCONNECTED) {
                return "";
            }
            Intrinsics.f(ssidWithQuote, "ssidWithQuote");
            String strSubstring = ssidWithQuote.substring(1, ssidWithQuote.length() - 1);
            Intrinsics.f(strSubstring, "substring(...)");
            if (StringsKt__StringsKt.Q(strSubstring, "unknown ssid", false, 2, null)) {
                try {
                    Object systemService = Utils.a().getSystemService("connectivity");
                    Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        Intrinsics.f(extraInfo, "networkInfo.extraInfo");
                        strSubstring = extraInfo;
                    }
                } catch (Exception unused) {
                    g.d(g.f59252a, d() + " --> getCurrentSSID() --> getCurrentSSID->Current SSID:" + strSubstring, false, 2, null);
                }
            }
            return strSubstring;
        } catch (Exception e11) {
            g.d(g.f59252a, d() + " --> getCurrentSSID() --> getCurrentSSID Exception = " + e11, false, 2, null);
            return "";
        }
    }

    public final long j() {
        try {
            DhcpInfo dhcpInfo = l().getDhcpInfo();
            Intrinsics.f(dhcpInfo, "mWifiManager.dhcpInfo");
            long j11 = dhcpInfo.gateway;
            if (j11 != 0) {
                return j11;
            }
            return 0L;
        } catch (Exception e11) {
            g.d(g.f59252a, d() + " --> getGateway() --> 获取ip异常 it = :" + e11, false, 2, null);
        }
    }

    public final String k() {
        Object objM163constructorimpl;
        String hostAddress;
        Object obj = "";
        try {
            Result.Companion companion = Result.Companion;
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (hostAddress = inetAddressNextElement.getHostAddress()) != null) {
                        Intrinsics.f(hostAddress, "hostAddress");
                        if (l.L(hostAddress, "192.168", false, 2, null)) {
                            String hostAddress2 = inetAddressNextElement.getHostAddress();
                            if (hostAddress2 == null) {
                                return "";
                            }
                            Intrinsics.f(hostAddress2, "inetAddress.hostAddress ?: \"\"");
                            return hostAddress2;
                        }
                    }
                }
            }
            objM163constructorimpl = Result.m163constructorimpl("");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            obj = objM163constructorimpl;
        } else {
            g.d(g.f59252a, "WifiUtils --> getLocalIP() --> 获取IP异常 -- it = " + thM166exceptionOrNullimpl, false, 2, null);
        }
        return (String) obj;
    }

    public final WifiManager l() {
        return (WifiManager) f59243b.getValue();
    }

    public final boolean m() {
        return l().is5GHzBandSupported();
    }

    public final boolean n(String str) {
        return o(Utils.a(), str);
    }

    public final boolean o(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strReplace = new Regex("\"").replace(str, "");
        if (context == null) {
            return false;
        }
        String string = context.getString(R$string.wifi_ap_prefix);
        Intrinsics.f(string, "context.getString(R.string.wifi_ap_prefix)");
        if (!l.L(strReplace, string, false, 2, null)) {
            String string2 = context.getString(R$string.wifi_direct_prefix);
            Intrinsics.f(string2, "context.getString(R.string.wifi_direct_prefix)");
            if (!l.L(strReplace, string2, false, 2, null)) {
                String string3 = context.getString(R$string.wifi_ap_prefix_old);
                Intrinsics.f(string3, "context.getString(R.string.wifi_ap_prefix_old)");
                if (!l.L(strReplace, string3, false, 2, null)) {
                    String string4 = context.getString(R$string.wifi_local_ap_prefix);
                    Intrinsics.f(string4, "context.getString(R.string.wifi_local_ap_prefix)");
                    if (!l.L(strReplace, string4, false, 2, null)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean p() {
        return l().isP2pSupported();
    }

    public final boolean q(Context context) {
        Intrinsics.g(context, "context");
        return Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29;
    }

    public final boolean r() {
        return Build.VERSION.SDK_INT < 29;
    }

    public final String s(long j11) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((int) (j11 & 255));
        stringBuffer.append('.');
        stringBuffer.append((int) ((j11 >> 8) & 255));
        stringBuffer.append('.');
        stringBuffer.append((int) ((j11 >> 16) & 255));
        stringBuffer.append('.');
        stringBuffer.append((int) ((j11 >> 24) & 255));
        String string = stringBuffer.toString();
        Intrinsics.f(string, "sb.toString()");
        return string;
    }

    @RequiresApi(23)
    public final void t(AppCompatActivity appCompatActivity) {
        Object objM163constructorimpl;
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + (appCompatActivity != null ? appCompatActivity.getPackageName() : null)));
            if (appCompatActivity != null) {
                appCompatActivity.startActivity(intent);
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            objM163constructorimpl = Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f59252a, f59242a.d() + " --> openManageWriteSetting() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
    }

    public final void u(AppCompatActivity appCompatActivity) {
        Intent intent = new Intent("android.settings.WIFI_SETTINGS");
        if (appCompatActivity != null) {
            appCompatActivity.startActivity(intent);
        }
    }

    public final void v() {
        Object objM163constructorimpl;
        NetworkInfo activeNetworkInfo;
        try {
            Result.Companion companion = Result.Companion;
            Object systemService = Utils.a().getApplicationContext().getApplicationContext().getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                WifiUtils wifiUtils = f59242a;
                WifiInfo connectionInfo = wifiUtils.l().getConnectionInfo();
                Intrinsics.f(connectionInfo, "mWifiManager.connectionInfo");
                String ssid = connectionInfo.getSSID();
                Intrinsics.f(ssid, "wifiInfo.ssid");
                if (wifiUtils.n(ssid)) {
                    wifiUtils.l().removeNetwork(connectionInfo.getNetworkId());
                    g.b(g.f59252a, wifiUtils.d() + " --> removeMbNet() --> success", false, 2, null);
                }
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        g.b(g.f59252a, f59242a.d() + " --> removeMbNet() --> 异常 it = " + thM166exceptionOrNullimpl, false, 2, null);
    }
}
