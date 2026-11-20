package com.transsion.transfer.wifi.connect.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.R$string;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.c;
import com.transsion.transfer.wifi.util.g;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.l;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;

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
@SuppressLint({"MissingPermission"})
public final class AddNetWorkConnectAdapter extends BaseWifiConnectAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f59132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f59134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Network f59135i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<ScanResult> f59139m;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f59131e = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f59136j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f59137k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f59138l = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f59140n = 1000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f59141o = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f59142p = 5;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f59143q = 15;

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    public void c() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            if (this.f59135i != null) {
                this.f59135i = null;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
                Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                ((ConnectivityManager) systemService).bindProcessToNetwork(null);
            } else {
                ConnectivityManager.setProcessDefaultNetwork(null);
            }
            g.b(g.f59252a, e() + " --> releaseDefaultNetwork() --> end", false, 2, null);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f59252a, e() + " --> releaseDefaultNetwork() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
    }

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    public void d() {
        this.f59133g = 0;
        this.f59134h = false;
        g.b(g.f59252a, e() + " --> connect() --> 系统级接入方开始添加网络 = " + i(), false, 2, null);
        k0 k0VarG = g();
        if (k0VarG != null) {
            j.d(k0VarG, null, null, new AddNetWorkConnectAdapter$doConnect$1(this, null), 3, null);
        }
    }

    public final int m(int i11, String str, String str2) {
        g.b(g.f59252a, e() + " --> blindConnect() --> Connect Step 4 No Need Scan Result,Force Connect ", false, 2, null);
        if (i11 != -1) {
            return i11;
        }
        String string = Utils.a().getApplicationContext().getString(R$string.wifi_direct_prefix);
        Intrinsics.f(string, "getApp().applicationCont…tring.wifi_direct_prefix)");
        if (l.L(str, string, false, 2, null)) {
            int iV = v(str, str2, "PSK");
            if (iV == -1) {
                iV = v(str, str2, "EAP");
            }
            return iV == -1 ? v(str, str2, "WEP") : iV;
        }
        if (TextUtils.isEmpty(str2)) {
            return v(str, str2, "OPEN");
        }
        int iV2 = v(str, str2, "PSK");
        if (iV2 == -1) {
            iV2 = v(str, str2, "EAP");
        }
        return iV2 == -1 ? v(str, str2, "WEP") : iV2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object n(Continuation<? super Unit> continuation) throws Throwable {
        AddNetWorkConnectAdapter$connectNetWork$1 addNetWorkConnectAdapter$connectNetWork$1;
        AddNetWorkConnectAdapter addNetWorkConnectAdapter;
        Object objM163constructorimpl;
        Object objM163constructorimpl2;
        if (continuation instanceof AddNetWorkConnectAdapter$connectNetWork$1) {
            addNetWorkConnectAdapter$connectNetWork$1 = (AddNetWorkConnectAdapter$connectNetWork$1) continuation;
            int i11 = addNetWorkConnectAdapter$connectNetWork$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                addNetWorkConnectAdapter$connectNetWork$1.label = i11 - Integer.MIN_VALUE;
            } else {
                addNetWorkConnectAdapter$connectNetWork$1 = new AddNetWorkConnectAdapter$connectNetWork$1(this, continuation);
            }
        } else {
            addNetWorkConnectAdapter$connectNetWork$1 = new AddNetWorkConnectAdapter$connectNetWork$1(this, continuation);
        }
        Object obj = addNetWorkConnectAdapter$connectNetWork$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = addNetWorkConnectAdapter$connectNetWork$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            addNetWorkConnectAdapter$connectNetWork$1.L$0 = this;
            addNetWorkConnectAdapter$connectNetWork$1.label = 1;
            if (r0.a(500L, addNetWorkConnectAdapter$connectNetWork$1) == objE) {
                return objE;
            }
            addNetWorkConnectAdapter = this;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            addNetWorkConnectAdapter = (AddNetWorkConnectAdapter) addNetWorkConnectAdapter$connectNetWork$1.L$0;
            ResultKt.b(obj);
        }
        addNetWorkConnectAdapter.s();
        try {
            Result.Companion companion = Result.Companion;
            Ref.IntRef intRef = new Ref.IntRef();
            addNetWorkConnectAdapter.f59131e = -1;
            addNetWorkConnectAdapter.f59132f = false;
            g gVar = g.f59252a;
            String strE = addNetWorkConnectAdapter.e();
            qy.a aVarI = addNetWorkConnectAdapter.i();
            g.b(gVar, strE + " --> connectNetWork() --> 连接网络 --> Connect Step 1 START_CONNECT --> Target SSID = " + (aVarI != null ? aVarI.p() : null), false, 2, null);
            while (true) {
                WifiUtils wifiUtils = WifiUtils.f59242a;
                if (wifiUtils.l().getWifiState() == 3 || intRef.element >= addNetWorkConnectAdapter.f59136j * 2 || addNetWorkConnectAdapter.f59134h) {
                    break;
                }
                try {
                    Result.Companion companion2 = Result.Companion;
                    g.b(g.f59252a, addNetWorkConnectAdapter.e() + " --> connectNetWork() --> wait wifi open, time = " + intRef.element, false, 2, null);
                    wifiUtils.l().setWifiEnabled(true);
                    Thread.sleep(350L);
                    objM163constructorimpl2 = Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.Companion;
                    objM163constructorimpl2 = Result.m163constructorimpl(ResultKt.a(th2));
                }
                if (Result.m166exceptionOrNullimpl(objM163constructorimpl2) != null) {
                    return Unit.f68710a;
                }
                intRef.element++;
            }
            addNetWorkConnectAdapter.t();
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th3));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            g.d(g.f59252a, addNetWorkConnectAdapter.e() + " --> connectNetWork() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
            com.transsion.transfer.wifi.connect.b bVarH = addNetWorkConnectAdapter.h();
            if (bVarH != null) {
                bVarH.b(2030);
            }
        }
        return Unit.f68710a;
    }

    public final int o(String str, String str2, String str3) throws Throwable {
        int i11 = -1;
        try {
            synchronized (this.f59141o) {
                try {
                    WifiUtils wifiUtils = WifiUtils.f59242a;
                    if (wifiUtils.i().equals(str)) {
                        g.b(g.f59252a, "Current MB SSID had Connected. current SSID = " + wifiUtils.i(), false, 2, null);
                        return 0;
                    }
                    this.f59138l = this.f59137k;
                    WifiConfiguration wifiConfiguration = new WifiConfiguration();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                    String str4 = String.format("\"%s\"", Arrays.copyOf(new Object[]{str}, 1));
                    Intrinsics.f(str4, "format(...)");
                    wifiConfiguration.SSID = str4;
                    wifiConfiguration.priority = 1000000;
                    com.transsion.transfer.wifi.util.a.f59244a.f(wifiConfiguration, str3, str2);
                    int i12 = 0;
                    int iAddNetwork = -1;
                    while (i12 < this.f59142p && !this.f59134h && (iAddNetwork = WifiUtils.f59242a.l().addNetwork(wifiConfiguration)) == -1) {
                        try {
                            i12++;
                            try {
                                Thread.sleep(350L);
                            } catch (InterruptedException e11) {
                                g.d(g.f59252a, e() + " --> connectToWifi() --> addNetwork Interrupt = " + e11, false, 2, null);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    g gVar = g.f59252a;
                    g.h(gVar, e() + " --> connectToWifi() --> new network id:" + iAddNetwork, false, 2, null);
                    try {
                        if (iAddNetwork == -1) {
                            g.h(gVar, e() + " --> connectToWifi() --> add ssid to network failure!", false, 2, null);
                            return iAddNetwork;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            com.transsion.transfer.wifi.util.a.f59244a.g(WifiUtils.f59242a.l(), wifiConfiguration);
                        }
                        WifiUtils wifiUtils2 = WifiUtils.f59242a;
                        if (wifiUtils2.l() != null) {
                            wifiUtils2.l().disconnect();
                        }
                        this.f59137k = iAddNetwork;
                        int i13 = this.f59138l;
                        if (i13 != -1 && i13 != iAddNetwork) {
                            wifiUtils2.l().disableNetwork(this.f59138l);
                        }
                        if (wifiUtils2.l() == null || !wifiUtils2.l().enableNetwork(iAddNetwork, true)) {
                            wifiUtils2.l().reassociate();
                        }
                        x();
                        Unit unit = Unit.f68710a;
                        return iAddNetwork;
                    } catch (Exception e12) {
                        e = e12;
                        i11 = iAddNetwork;
                        e.printStackTrace();
                        return i11;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Exception e13) {
            e = e13;
        }
    }

    public final Method p(int i11) {
        Class<?>[] parameterTypes;
        WifiUtils wifiUtils = WifiUtils.f59242a;
        if (wifiUtils.l() == null) {
            return null;
        }
        Method[] declaredMethods = wifiUtils.l().getClass().getDeclaredMethods();
        Intrinsics.f(declaredMethods, "WifiUtils.mWifiManager.javaClass.declaredMethods");
        Method method = null;
        for (Method method2 : declaredMethods) {
            if (l.v("connect", method2.getName(), true) && (parameterTypes = method2.getParameterTypes()) != null && parameterTypes.length > 0 && l.v("int", parameterTypes[0].getName(), true)) {
                method = method2;
            }
        }
        if (method != null) {
            try {
                method.invoke(WifiUtils.f59242a.l(), Integer.valueOf(i11), null);
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        }
        return method;
    }

    public final void q() {
        String strP;
        String strO;
        int i11 = this.f59131e;
        qy.a aVarI = i();
        String str = "";
        if (aVarI == null || (strP = aVarI.p()) == null) {
            strP = "";
        }
        qy.a aVarI2 = i();
        if (aVarI2 != null && (strO = aVarI2.o()) != null) {
            str = strO;
        }
        this.f59131e = m(i11, strP, str);
        g gVar = g.f59252a;
        g.b(gVar, e() + " --> doBlindConnect() --> Connect Step 5 No Need Scan Result,Force Connect Result=" + this.f59131e, false, 2, null);
        if (this.f59131e != -1) {
            String strI = WifiUtils.f59242a.i();
            qy.a aVarI3 = i();
            if (Intrinsics.b(strI, aVarI3 != null ? aVarI3.p() : null)) {
                String strE = e();
                qy.a aVarI4 = i();
                String strP2 = aVarI4 != null ? aVarI4.p() : null;
                g.b(gVar, strE + " --> doBlindConnect() --> Connect Step 6.0 connected wifi = " + strP2 + " -- netId = " + this.f59131e + "  --  isOkRetryConnect:", false, 2, null);
            } else {
                try {
                    Thread.sleep(350L);
                    String strE2 = e();
                    qy.a aVarI5 = i();
                    String strP3 = aVarI5 != null ? aVarI5.p() : null;
                    g.b(gVar, strE2 + " --> doBlindConnect() --> Connect Step 6.1 didn't connect wifi，reEnableNetWork ssid: " + strP3 + " -- netId = " + this.f59131e + " ", false, 2, null);
                    w(this.f59131e);
                } catch (InterruptedException e11) {
                    e11.printStackTrace();
                    return;
                }
            }
        } else {
            this.f59139m = null;
        }
        NetworkInfo.DetailedState detailedStateR = r();
        boolean z11 = detailedStateR == null || detailedStateR == NetworkInfo.DetailedState.CONNECTING || detailedStateR == NetworkInfo.DetailedState.AUTHENTICATING;
        for (int i12 = 0; z11 && i12 < this.f59143q && !this.f59134h; i12++) {
            try {
                Thread.sleep(350L);
                NetworkInfo.DetailedState detailedStateR2 = r();
                if (detailedStateR2 != null) {
                    z11 = detailedStateR2 == NetworkInfo.DetailedState.CONNECTING || detailedStateR2 == NetworkInfo.DetailedState.AUTHENTICATING;
                }
            } catch (InterruptedException e12) {
                e12.printStackTrace();
            }
        }
        WifiUtils wifiUtils = WifiUtils.f59242a;
        String strI2 = wifiUtils.i();
        if (!TextUtils.isEmpty(strI2)) {
            qy.a aVarI6 = i();
            if (Intrinsics.b(strI2, aVarI6 != null ? aVarI6.p() : null)) {
                if (this.f59131e != -1) {
                    g.b(g.f59252a, e() + " --> doBlindConnect() --> Connect Step 9 addNetSucceed", false, 2, null);
                    com.transsion.transfer.wifi.connect.b bVarH = h();
                    if (bVarH != null) {
                        bVarH.d(this.f59131e);
                        return;
                    }
                    return;
                }
                g.b(g.f59252a, e() + " --> doBlindConnect() --> Connect Step 9 SHOW_RETRY", false, 2, null);
                com.transsion.transfer.wifi.connect.b bVarH2 = h();
                if (bVarH2 != null) {
                    bVarH2.b(2033);
                    return;
                }
                return;
            }
        }
        g gVar2 = g.f59252a;
        g.b(gVar2, e() + " --> doBlindConnect() --> Connect Step 9.1 blindConnectCounts：" + this.f59133g, false, 2, null);
        if (this.f59133g >= this.f59142p) {
            g.d(gVar2, e() + " --> doBlindConnect() --> Connect Step 9.1 SHOW_RETRY", false, 2, null);
            com.transsion.transfer.wifi.connect.b bVarH3 = h();
            if (bVarH3 != null) {
                bVarH3.b(2033);
                return;
            }
            return;
        }
        wifiUtils.l().startScan();
        try {
            Thread.sleep(this.f59140n);
        } catch (InterruptedException e13) {
            g.b(g.f59252a, e() + " --> doBlindConnect() --> blindConnectCounts InterruptedException: " + e13, false, 2, null);
        }
        this.f59131e = -1;
        this.f59132f = false;
        this.f59133g++;
        t();
    }

    @SuppressLint({"MissingPermission"})
    public final NetworkInfo.DetailedState r() {
        Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getDetailedState();
        }
        return null;
    }

    public final void s() {
        c cVar = c.f59246a;
        if (cVar.e()) {
            Context applicationContext = Utils.a().getApplicationContext();
            Intrinsics.f(applicationContext, "getApp().applicationContext");
            if (cVar.d(applicationContext) < 2097152) {
                g.b(g.f59252a, e() + " --> initParameter() --> Transsion Phone lowMemLimit", false, 2, null);
                this.f59140n = 1500L;
                this.f59143q = 30;
                this.f59136j = 20;
                this.f59142p = 8;
            }
        }
    }

    public final void t() {
        Object objM163constructorimpl;
        g gVar = g.f59252a;
        String strE = e();
        qy.a aVarI = i();
        g.b(gVar, strE + " --> processWifiConnect() --> Connect Step 2 CONNECTION_INITIALIZED --> ssid = " + (aVarI != null ? aVarI.p() : null) + " --> startScan()", false, 2, null);
        WifiUtils wifiUtils = WifiUtils.f59242a;
        wifiUtils.l().startScan();
        int networkId = wifiUtils.l().getConnectionInfo().getNetworkId();
        List<WifiConfiguration> configuredNetworks = wifiUtils.l().getConfiguredNetworks();
        Intrinsics.f(configuredNetworks, "WifiUtils.mWifiManager.configuredNetworks");
        g.b(gVar, e() + " --> processWifiConnect() --> Connect Step 2.1  --> currentConnectId = " + networkId + " --> existingConfigs.size = " + configuredNetworks.size(), false, 2, null);
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            String str = wifiConfiguration.SSID;
            Intrinsics.f(str, "existingConfig.SSID");
            String strF = l.F(str, "\"", "", false, 4, null);
            String str2 = wifiConfiguration.preSharedKey;
            if (!TextUtils.isEmpty(strF)) {
                qy.a aVarI2 = i();
                if (l.w(aVarI2 != null ? aVarI2.p() : null, strF, false, 2, null)) {
                    this.f59131e = wifiConfiguration.networkId;
                    g gVar2 = g.f59252a;
                    g.b(gVar2, e() + " --> processWifiConnect() --> Connect Step 2.2  currentConnectId = " + networkId + " -- netId = " + this.f59131e + " -- pwd = " + str2, false, 2, null);
                    String string = Utils.a().getApplicationContext().getString(R$string.wifi_direct_prefix);
                    Intrinsics.f(string, "getApp().applicationCont…tring.wifi_direct_prefix)");
                    if (!l.L(strF, string, false, 2, null) || !TextUtils.isEmpty(str2)) {
                        g.b(gVar2, e() + " --> processWifiConnect() --> Connect Step 2.4  reEnableNetWork WifiConfiguration SSID = " + strF + ", netId = " + this.f59131e, false, 2, null);
                        this.f59138l = networkId;
                        WifiUtils.f59242a.l().disconnect();
                        w(this.f59131e);
                        this.f59132f = true;
                        break;
                    }
                    g.b(gVar2, e() + " --> processWifiConnect() --> Connect Step 2.3  error pwd type save WifiConfiguration SSID = " + strF + ", netId = " + this.f59131e, false, 2, null);
                    this.f59131e = -1;
                    this.f59132f = false;
                    break;
                }
            }
        }
        g.b(g.f59252a, e() + " --> processWifiConnect() --> Connect Step 2.4-1  列表遍历结束 --> netId = " + this.f59131e + " -- findOldConfig = " + this.f59132f, false, 2, null);
        if (!this.f59132f) {
            int i11 = this.f59136j;
            for (int i12 = 0; i12 < i11; i12++) {
                List<ScanResult> scanResults = WifiUtils.f59242a.l().getScanResults();
                this.f59139m = scanResults;
                if (scanResults != null) {
                    g gVar3 = g.f59252a;
                    String strE2 = e();
                    List<ScanResult> list = this.f59139m;
                    g.b(gVar3, strE2 + " --> processWifiConnect() --> Connect Step 2.5  Start WifiScan Retry counts:+ i +, ScanResultList Size: " + (list != null ? Integer.valueOf(list.size()) : null), false, 2, null);
                    for (ScanResult scanResult : scanResults) {
                        qy.a aVarI3 = i();
                        if (l.w(aVarI3 != null ? aVarI3.p() : null, scanResult.SSID, false, 2, null)) {
                            g gVar4 = g.f59252a;
                            g.b(gVar4, e() + " --> processWifiConnect() --> Connect Step 3 Find XShare HotSpot , Start Connect to Target WIFI , SSID = " + scanResult.SSID + " +  capabilities =  " + scanResult.capabilities, false, 2, null);
                            qy.a aVarI4 = i();
                            String strP = aVarI4 != null ? aVarI4.p() : null;
                            qy.a aVarI5 = i();
                            this.f59131e = o(strP, aVarI5 != null ? aVarI5.o() : null, scanResult.capabilities);
                            g.d(gVar4, e() + " --> processWifiConnect() --> Connect Step 3.1 Connect to Target WIFI Finished -- netId = " + this.f59131e, false, 2, null);
                            if (this.f59131e != -1) {
                                break;
                            }
                        }
                    }
                }
                if (this.f59131e != -1) {
                    break;
                }
                try {
                    Result.Companion companion = Result.Companion;
                    Thread.sleep(this.f59140n);
                    if (i12 % 3 == 0) {
                        WifiUtils.f59242a.l().startScan();
                    }
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
                }
                Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    g.d(g.f59252a, e() + " --> processWifiConnect() --> CONFIGURED_WIFI InterruptedException --> it = " + thM166exceptionOrNullimpl, false, 2, null);
                    com.transsion.transfer.wifi.connect.b bVarH = h();
                    if (bVarH != null) {
                        bVarH.b(2031);
                        return;
                    }
                    return;
                }
            }
        }
        u();
    }

    public final void u() {
        g.b(g.f59252a, e() + " --> processWifiScanResult() --> Connect Step 4 processWifiScanResult findOldConfig = " + this.f59132f, false, 2, null);
        if (!this.f59132f) {
            q();
            return;
        }
        NetworkInfo.DetailedState detailedStateR = r();
        boolean z11 = detailedStateR == null || detailedStateR == NetworkInfo.DetailedState.CONNECTING || detailedStateR == NetworkInfo.DetailedState.AUTHENTICATING;
        for (int i11 = 0; z11 && i11 < this.f59143q && !this.f59134h; i11++) {
            try {
                Thread.sleep(350L);
                NetworkInfo.DetailedState detailedStateR2 = r();
                if (detailedStateR2 != null) {
                    z11 = detailedStateR2 == NetworkInfo.DetailedState.CONNECTING || detailedStateR2 == NetworkInfo.DetailedState.AUTHENTICATING;
                }
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
        }
        WifiUtils wifiUtils = WifiUtils.f59242a;
        String strI = wifiUtils.i();
        if (!TextUtils.isEmpty(strI)) {
            qy.a aVarI = i();
            if (Intrinsics.b(strI, aVarI != null ? aVarI.p() : null)) {
                if (this.f59131e != -1) {
                    g.b(g.f59252a, e() + " --> processWifiScanResult() --> Connect Step 7 addNetSucceed", false, 2, null);
                    com.transsion.transfer.wifi.connect.b bVarH = h();
                    if (bVarH != null) {
                        bVarH.d(this.f59131e);
                        return;
                    }
                    return;
                }
                g.b(g.f59252a, e() + " --> processWifiScanResult() --> Connect Step 7 SHOW_RETRY", false, 2, null);
                com.transsion.transfer.wifi.connect.b bVarH2 = h();
                if (bVarH2 != null) {
                    bVarH2.b(2032);
                    return;
                }
                return;
            }
        }
        g gVar = g.f59252a;
        g.b(gVar, e() + " --> processWifiScanResult() --> Connect Step 7.1 blindConnectCounts = " + this.f59133g, false, 2, null);
        if (this.f59133g >= this.f59142p) {
            g.d(gVar, e() + " --> processWifiScanResult() --> Connect Step 7.1 SHOW_RETRY", false, 2, null);
            com.transsion.transfer.wifi.connect.b bVarH3 = h();
            if (bVarH3 != null) {
                bVarH3.b(2032);
                return;
            }
            return;
        }
        wifiUtils.l().startScan();
        try {
            Thread.sleep(this.f59140n);
        } catch (InterruptedException e12) {
            g.d(g.f59252a, e() + " --> processWifiScanResult() --> blindConnectCounts InterruptedException: " + e12, false, 2, null);
        }
        this.f59131e = -1;
        this.f59132f = false;
        this.f59133g++;
        q();
    }

    public final int v(String str, String str2, String str3) {
        try {
            g.b(g.f59252a, e() + " --> reConnect() --> ssid:" + str + ", pass:" + str2 + ", type:" + str3, false, 2, null);
            Thread.sleep(300L);
            return o(str, str2, str3);
        } catch (InterruptedException e11) {
            g.d(g.f59252a, e() + " --> reConnect() --> reConnect InterruptedException: " + e11, false, 2, null);
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0051 A[Catch: Exception -> 0x002b, TryCatch #0 {Exception -> 0x002b, blocks: (B:2:0x0000, B:4:0x001b, B:6:0x001f, B:9:0x002d, B:11:0x0034, B:13:0x003a, B:17:0x005a, B:16:0x0051, B:14:0x0045), top: B:21:0x0000 }] */
    public final void w(int i11) {
        try {
            this.f59137k = i11;
            j("reEnableNetWork() --> set network id = " + i11);
            int i12 = this.f59138l;
            if (i12 != -1 && i12 != this.f59137k) {
                WifiUtils.f59242a.l().disableNetwork(this.f59138l);
            }
            if (Build.VERSION.SDK_INT > 23 || p(i11) == null) {
                boolean zEnableNetwork = WifiUtils.f59242a.l().enableNetwork(i11, true);
                if (!zEnableNetwork) {
                    WifiUtils.f59242a.l().reassociate();
                }
            } else {
                WifiUtils.f59242a.l().reassociate();
            }
            x();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void x() {
        synchronized (this.f59141o) {
            j("removeOldNetwork() --> removeOldNetwork mLastNetworkId = " + this.f59138l + " --> mCurrentNetworkId = " + this.f59137k);
            int i11 = this.f59138l;
            if (i11 != -1 && i11 != this.f59137k) {
                j("removeOldNetwork() --> remove network id:" + i11);
                boolean zRemoveNetwork = false;
                for (int i12 = 0; i12 < 10 && !zRemoveNetwork; i12++) {
                    try {
                        zRemoveNetwork = WifiUtils.f59242a.l().removeNetwork(this.f59138l);
                        j("removeOldNetwork() --> removeNetwork Result = " + zRemoveNetwork);
                    } catch (Exception unused) {
                    }
                }
                WifiUtils.f59242a.l().saveConfiguration();
            }
            Unit unit = Unit.f68710a;
        }
    }
}
