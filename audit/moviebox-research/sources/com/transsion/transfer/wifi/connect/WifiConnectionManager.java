package com.transsion.transfer.wifi.connect;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.R$string;
import com.transsion.transfer.wifi.connect.adapter.AddNetWorkConnectAdapter;
import com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter;
import com.transsion.transfer.wifi.connect.adapter.DirectConnectAdapter;
import com.transsion.transfer.wifi.connect.adapter.WifiNetworkSpecifierAdapter;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.f;
import com.transsion.transfer.wifi.util.g;
import java.net.InetAddress;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import kotlinx.coroutines.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import py.c;

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
public final class WifiConnectionManager implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WifiConnectionManager f59120a = new WifiConnectionManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AppCompatActivity f59121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static k0 f59122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static qy.a f59123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f59124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static DirectConnectAdapter f59125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static WifiNetworkSpecifierAdapter f59126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static AddNetWorkConnectAdapter f59127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f59128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f59129j;

    @Override // com.transsion.transfer.wifi.connect.b
    public void a(Network network) {
        b.a.b(this, network);
    }

    @Override // com.transsion.transfer.wifi.connect.b
    public void b(int i11) {
        g.d(g.f59252a, o() + " --> onFail() --> code = " + i11, false, 2, null);
        if (i11 == 2001 || i11 == 2012) {
            c.f74067a.d();
        } else {
            c.f74067a.e(i11);
        }
        k0 k0Var = f59122c;
        if (k0Var != null) {
            j.d(k0Var, null, null, new WifiConnectionManager$onFail$1(i11, null), 3, null);
        }
    }

    @Override // com.transsion.transfer.wifi.connect.b
    public void c(InetAddress inetAddress) {
        v(inetAddress);
    }

    @Override // com.transsion.transfer.wifi.connect.b
    public void d(int i11) {
        u(i11);
    }

    @Override // com.transsion.transfer.wifi.connect.b
    public void e(String ip2) {
        Intrinsics.g(ip2, "ip");
        b.a.c(this, ip2);
        c.f74067a.f(System.currentTimeMillis() - f59128i);
        f59129j = false;
        b bVar = f59124e;
        if (bVar != null) {
            bVar.e(ip2);
        }
    }

    public final void m() {
        g.b(g.f59252a, o() + " --> connect() --> SDK_INT或targetSdkVersion版本 < (Q = 29) Android 10", false, 2, null);
        if (f59127h == null) {
            f59127h = new AddNetWorkConnectAdapter();
        }
        AddNetWorkConnectAdapter addNetWorkConnectAdapter = f59127h;
        if (addNetWorkConnectAdapter != null) {
            BaseWifiConnectAdapter.b(addNetWorkConnectAdapter, null, f59123d, f59122c, this, 1, null);
        }
    }

    public final void n(AppCompatActivity appCompatActivity, qy.a aVar, k0 k0Var, b bVar) {
        if (f59129j) {
            ToastUtils.r(Utils.a().getResources().getString(R$string.transfer_wifi_connect_error_tip), new Object[0]);
            g.b(g.f59252a, o() + " --> connectWifi() --> 已经有一个任务在连接了，请稍后", false, 2, null);
            return;
        }
        f59129j = true;
        f59128i = System.currentTimeMillis();
        f59122c = k0Var;
        f59123d = aVar;
        f59121b = appCompatActivity;
        f59124e = bVar;
        onStart();
        k0 k0Var2 = f59122c;
        if (k0Var2 != null) {
            j.d(k0Var2, null, null, new WifiConnectionManager$connect$1(null), 3, null);
        }
    }

    public final String o() {
        String simpleName = WifiConnectionManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // com.transsion.transfer.wifi.connect.b
    public void onStart() {
        c.f74067a.g();
        b bVar = f59124e;
        if (bVar != null) {
            bVar.onStart();
        }
    }

    public final Object p(Continuation<? super String> continuation) {
        return h.g(w0.b(), new WifiConnectionManager$getCorrectAddNetAddress$2(null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0039  */
    public final void q() {
        boolean z11;
        String strP;
        g gVar = g.f59252a;
        g.b(gVar, o() + " --> innerConnect() --> 建立 Wi-Fi 连接 --> start ....", false, 2, null);
        qy.a aVar = f59123d;
        if (aVar != null && (strP = aVar.p()) != null) {
            z11 = l.L(strP, "DIRECT-", false, 2, null) && WifiUtils.f59242a.p();
        }
        qy.a aVar2 = f59123d;
        if (TextUtils.isEmpty(aVar2 != null ? aVar2.p() : null)) {
            g.d(gVar, o() + " --> innerConnect() --> wifiInfoModel.wifiSsid is empty --> return", false, 2, null);
            b(2000);
            return;
        }
        WifiUtils wifiUtils = WifiUtils.f59242a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        boolean zQ = wifiUtils.q(applicationA);
        if (z11 && !zQ) {
            r();
        } else if (zQ) {
            m();
        } else {
            w();
        }
    }

    public final void r() {
        g.b(g.f59252a, o() + " --> connect() --> 支持(Wi-Fi P2P) 且SDK_INT或targetSdkVersion版本 >= (Q = 29) -- Android 10", false, 2, null);
        if (Build.VERSION.SDK_INT >= 23) {
            Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ((ConnectivityManager) systemService).bindProcessToNetwork(null);
        } else {
            ConnectivityManager.setProcessDefaultNetwork(null);
        }
        if (f59125f == null) {
            f59125f = new DirectConnectAdapter();
        }
        DirectConnectAdapter directConnectAdapter = f59125f;
        if (directConnectAdapter != null) {
            BaseWifiConnectAdapter.b(directConnectAdapter, null, f59123d, f59122c, this, 1, null);
        }
    }

    public final void s() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            g gVar = g.f59252a;
            WifiConnectionManager wifiConnectionManager = f59120a;
            g.h(gVar, wifiConnectionManager.o() + " --> release() --> 接收端开始释放资源", false, 2, null);
            f59124e = null;
            f59122c = null;
            f59129j = false;
            f59128i = 0L;
            wifiConnectionManager.t();
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f59252a, f59120a.o() + " --> release() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
    }

    public final void t() {
        f.f59249a.c();
        WifiUtils.f59242a.v();
        DirectConnectAdapter directConnectAdapter = f59125f;
        if (directConnectAdapter != null) {
            directConnectAdapter.k();
        }
        f59125f = null;
        AddNetWorkConnectAdapter addNetWorkConnectAdapter = f59127h;
        if (addNetWorkConnectAdapter != null) {
            addNetWorkConnectAdapter.k();
        }
        f59127h = null;
        if (Build.VERSION.SDK_INT >= 23) {
            WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter = f59126g;
            if (wifiNetworkSpecifierAdapter != null) {
                wifiNetworkSpecifierAdapter.k();
            }
            f59126g = null;
        }
    }

    public final void u(int i11) {
        g.b(g.f59252a, o() + " --> resolveIP(netId: Int) --> 成功建立连接 --> 开始解析IP地址 -- netId = " + i11, false, 2, null);
        k0 k0Var = f59122c;
        if (k0Var != null) {
            j.d(k0Var, w0.c(), null, new WifiConnectionManager$resolveIP$2(null), 2, null);
        }
    }

    public final void v(InetAddress inetAddress) {
        g gVar = g.f59252a;
        g.b(gVar, o() + " --> resolveIP(address: InetAddress?) --> 成功建立连接 --> 开始解析IP地址", false, 2, null);
        if (TextUtils.isEmpty(inetAddress != null ? inetAddress.getHostAddress() : null)) {
            k0 k0Var = f59122c;
            if (k0Var != null) {
                j.d(k0Var, w0.c(), null, new WifiConnectionManager$resolveIP$1(null), 2, null);
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - f59128i;
        g.b(gVar, o() + " --> resolveIP(address: InetAddress?) --> 非系统级应用P2P连接成功耗时 = " + jCurrentTimeMillis + " -- ip = " + (inetAddress != null ? inetAddress.getHostAddress() : null), false, 2, null);
        String hostAddress = inetAddress != null ? inetAddress.getHostAddress() : null;
        if (hostAddress == null) {
            hostAddress = "";
        }
        e(hostAddress);
    }

    public final void w() {
        if (Build.VERSION.SDK_INT >= 29) {
            g.b(g.f59252a, o() + " --> connect() --> 不支持(Wi-Fi P2P) 且SDK_INT或targetSdkVersion版本 >= (Q = 29) -- Android 10", false, 2, null);
            if (f59126g == null) {
                f59126g = new WifiNetworkSpecifierAdapter();
            }
            WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter = f59126g;
            if (wifiNetworkSpecifierAdapter != null) {
                wifiNetworkSpecifierAdapter.a(f59121b, f59123d, f59122c, this);
            }
        }
    }
}
