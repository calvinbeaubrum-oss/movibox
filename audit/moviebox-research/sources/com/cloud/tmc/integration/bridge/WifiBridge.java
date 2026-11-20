package com.cloud.tmc.integration.bridge;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.RequiresApi;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.cloud.tmc.miniutils.util.e0;
import com.google.android.gms.stats.CodePackage;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vungle.warren.error.VungleException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class WifiBridge implements BridgeExtension {
    public static final a Companion = new a(null);
    public static final String ERROR_CONNECT_TIMEOUT = "connection timeout: W12003";
    public static final String ERROR_INVALID_SSID = "invalid ssid: W12008";
    public static final String ERROR_LOCATION_CLOSED = "gps not turned on: W12006";
    public static final String ERROR_LOCATION_PERMISSION = "not have location permission: W12007";
    public static final String ERROR_MULTI_LISTENER = "this app already has listener: W12004";
    public static final String ERROR_NO_INIT = "not init: W12000";
    public static final String ERROR_PASSWORD_INVALID = "password error Wi-Fi: W12002";
    public static final String ERROR_SYSTEM_ERROR = "system internal error: W12010";
    public static final String ERROR_WIFI_CLOSED = "wifi not turned on: W12005";
    public static final int SECURITY_EAP = 3;
    public static final int SECURITY_NONE = 0;
    public static final int SECURITY_PSK = 2;
    public static final int SECURITY_WEP = 1;
    public static final String TAG = "WifiBridge";
    public static final long WIFI_CONNECT_TIMEOUT = 30;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f30589a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f30590b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, WifiReceiver> f30591c = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class ConnectingEventReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CountDownLatch f30593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f30594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WifiBridge f30595d;

        public ConnectingEventReceiver(WifiBridge wifiBridge, int i11, CountDownLatch countDownLatch) {
            Intrinsics.g(countDownLatch, "countDownLatch");
            this.f30595d = wifiBridge;
            this.f30592a = i11;
            this.f30593b = countDownLatch;
            this.f30594c = -1;
        }

        public final int a() {
            return this.f30594c;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.g(context, "context");
            Intrinsics.g(intent, "intent");
            try {
                if (this.f30593b.getCount() < 1) {
                    return;
                }
                if (intent.getIntExtra("supplicantError", -1) == 1) {
                    this.f30594c = 1;
                    this.f30593b.countDown();
                    return;
                }
                Object systemService = context.getApplicationContext().getSystemService("wifi");
                Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                WifiManager wifiManager = (WifiManager) systemService;
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if ((networkInfo != null ? networkInfo.getState() : null) == NetworkInfo.State.CONNECTED) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo.getNetworkId() == this.f30592a && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        this.f30593b.countDown();
                        this.f30594c = 0;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(WifiBridge.TAG, th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class WifiReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f30596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final bc.a f30597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WifiBridge f30598c;

        public WifiReceiver(WifiBridge wifiBridge, String appId, bc.a aVar) {
            Intrinsics.g(appId, "appId");
            this.f30598c = wifiBridge;
            this.f30596a = appId;
            this.f30597b = aVar;
        }

        public final bc.a a() {
            return this.f30597b;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void b(List<ScanResult> list) {
            bc.a aVar;
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            for (ScanResult scanResult : list) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("frequency", Integer.valueOf(scanResult.frequency));
                jsonObject2.addProperty("SSID", scanResult.SSID);
                jsonObject2.addProperty("BSSID", scanResult.BSSID);
                jsonObject2.addProperty("secure", Boolean.valueOf(this.f30598c.d(scanResult.capabilities) != 0));
                jsonObject2.addProperty("signalStrength", Integer.valueOf(WifiManager.calculateSignalLevel(scanResult.level, 100)));
                jsonArray.add(jsonObject2);
            }
            jsonObject.add("wifiList", jsonArray);
            if (((WifiReceiver) this.f30598c.f30591c.get(this.f30596a)) == null || (aVar = this.f30597b) == null) {
                return;
            }
            aVar.d(jsonObject);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.g(context, "context");
            Intrinsics.g(intent, "intent");
            try {
                Object systemService = context.getApplicationContext().getSystemService("wifi");
                Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                List<ScanResult> scanResults = ((WifiManager) systemService).getScanResults();
                context.unregisterReceiver(this);
                Intrinsics.f(scanResults, "scanResults");
                b(scanResults);
            } catch (Throwable th2) {
                TmcLogger.h(WifiBridge.TAG, th2);
                List<ScanResult> listEmptyList = Collections.emptyList();
                Intrinsics.f(listEmptyList, "emptyList()");
                b(listEmptyList);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class b implements NetworkUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WifiManager f30599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f30600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final bc.a f30601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WifiBridge f30602d;

        public b(WifiBridge wifiBridge, WifiManager wifiManager, String appId, bc.a aVar) {
            Intrinsics.g(wifiManager, "wifiManager");
            Intrinsics.g(appId, "appId");
            this.f30602d = wifiBridge;
            this.f30599a = wifiManager;
            this.f30600b = appId;
            this.f30601c = aVar;
        }

        @Override // com.cloud.tmc.miniutils.util.NetworkUtils.b
        @SuppressLint({"MissingPermission"})
        public void a(NetworkUtils.NetworkType networkType) {
            int iD;
            if (networkType == NetworkUtils.NetworkType.NETWORK_WIFI) {
                try {
                    if (((AppManager) tc.a.a(AppManager.class)).findApp(this.f30600b) != null) {
                        WifiBridge wifiBridge = this.f30602d;
                        JsonObject jsonObject = new JsonObject();
                        WifiInfo wifiInfo = this.f30599a.getConnectionInfo();
                        Iterator<ScanResult> it = this.f30599a.getScanResults().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                iD = 0;
                                break;
                            }
                            ScanResult next = it.next();
                            if (Intrinsics.b('\"' + next.SSID + '\"', wifiInfo.getSSID()) && Intrinsics.b(next.BSSID, wifiInfo.getBSSID())) {
                                iD = wifiBridge.d(next.capabilities);
                                break;
                            }
                        }
                        Intrinsics.f(wifiInfo, "wifiInfo");
                        jsonObject.add("wifiInfo", wifiBridge.f(wifiInfo, iD));
                        bc.a aVar = this.f30601c;
                        if (aVar != null) {
                            aVar.d(jsonObject);
                        }
                    }
                } catch (Throwable th2) {
                    TmcLogger.h(WifiBridge.TAG, th2);
                }
            }
        }

        public final bc.a b() {
            return this.f30601c;
        }

        @Override // com.cloud.tmc.miniutils.util.NetworkUtils.b
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WifiManager f30603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WifiBridge f30604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30607e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Context f30608f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ bc.a f30609g;

        public c(WifiManager wifiManager, WifiBridge wifiBridge, String str, String str2, String str3, Context context, bc.a aVar) {
            this.f30603a = wifiManager;
            this.f30604b = wifiBridge;
            this.f30605c = str;
            this.f30606d = str2;
            this.f30607e = str3;
            this.f30608f = context;
            this.f30609g = aVar;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            bc.a aVar = this.f30609g;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errCode", (Number) 12007);
                jsonObject.addProperty("errMsg", WifiBridge.ERROR_LOCATION_PERMISSION);
                aVar.e(jsonObject);
            }
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        @SuppressLint({"MissingPermission"})
        public void onGranted() throws InterruptedException {
            WifiInfo connectionInfo = this.f30603a.getConnectionInfo();
            if (connectionInfo != null) {
                String str = this.f30605c;
                String str2 = this.f30606d;
                bc.a aVar = this.f30609g;
                String ssid = connectionInfo.getSSID();
                String bssid = connectionInfo.getBSSID();
                if (Intrinsics.b(str, ssid) && (str2 == null || str2.length() == 0 || Intrinsics.b(str2, bssid))) {
                    if (aVar != null) {
                        aVar.g();
                        return;
                    }
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.f30604b.b(this.f30605c, this.f30606d, this.f30607e, this.f30608f, this.f30609g);
            } else {
                this.f30604b.a(this.f30608f, this.f30605c, this.f30606d, this.f30607e, this.f30609g);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f30610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConnectivityManager f30611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ bc.a f30612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f30613d;

        public d(Ref.BooleanRef booleanRef, ConnectivityManager connectivityManager, bc.a aVar, CountDownLatch countDownLatch) {
            this.f30610a = booleanRef;
            this.f30611b = connectivityManager;
            this.f30612c = aVar;
            this.f30613d = countDownLatch;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Intrinsics.g(network, "network");
            super.onAvailable(network);
            this.f30610a.element = true;
            this.f30611b.bindProcessToNetwork(network);
            bc.a aVar = this.f30612c;
            if (aVar != null) {
                aVar.g();
            }
            if (this.f30613d.getCount() > 0) {
                this.f30613d.countDown();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            this.f30610a.element = true;
            bc.a aVar = this.f30612c;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errCode", (Number) 12010);
                jsonObject.addProperty("errMsg", WifiBridge.ERROR_SYSTEM_ERROR);
                aVar.e(jsonObject);
            }
            if (this.f30613d.getCount() > 0) {
                this.f30613d.countDown();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements PermissionUtils.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ bc.a f30616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WifiManager f30617d;

        public e(Context context, bc.a aVar, WifiManager wifiManager) {
            this.f30615b = context;
            this.f30616c = aVar;
            this.f30617d = wifiManager;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            bc.a aVar = this.f30616c;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errCode", (Number) 12007);
                jsonObject.addProperty("errMsg", WifiBridge.ERROR_LOCATION_PERMISSION);
                aVar.e(jsonObject);
            }
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        @SuppressLint({"MissingPermission"})
        public void onGranted() {
            int iD;
            WifiBridge wifiBridge = WifiBridge.this;
            Context context = this.f30615b;
            Intrinsics.f(context, "context");
            if (!wifiBridge.e(context)) {
                bc.a aVar = this.f30616c;
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errCode", (Number) 12006);
                    jsonObject.addProperty("errMsg", WifiBridge.ERROR_LOCATION_CLOSED);
                    aVar.e(jsonObject);
                    return;
                }
                return;
            }
            JsonObject jsonObject2 = new JsonObject();
            WifiInfo wifiInfo = this.f30617d.getConnectionInfo();
            Iterator<ScanResult> it = this.f30617d.getScanResults().iterator();
            while (true) {
                if (!it.hasNext()) {
                    iD = 0;
                    break;
                }
                ScanResult next = it.next();
                if (Intrinsics.b('\"' + next.SSID + '\"', wifiInfo.getSSID()) && Intrinsics.b(next.BSSID, wifiInfo.getBSSID())) {
                    iD = WifiBridge.this.d(next.capabilities);
                    break;
                }
            }
            WifiBridge wifiBridge2 = WifiBridge.this;
            Intrinsics.f(wifiInfo, "wifiInfo");
            jsonObject2.add("wifi", wifiBridge2.f(wifiInfo, iD));
            TmcLogger.f(WifiBridge.TAG, "get connect info = " + jsonObject2);
            bc.a aVar2 = this.f30616c;
            if (aVar2 != null) {
                aVar2.d(jsonObject2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements PermissionUtils.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ bc.a f30620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WifiReceiver f30621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ WifiManager f30622e;

        public f(Context context, bc.a aVar, WifiReceiver wifiReceiver, WifiManager wifiManager) {
            this.f30619b = context;
            this.f30620c = aVar;
            this.f30621d = wifiReceiver;
            this.f30622e = wifiManager;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            bc.a aVar = this.f30620c;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errCode", (Number) 12007);
                jsonObject.addProperty("errMsg", WifiBridge.ERROR_LOCATION_PERMISSION);
                aVar.e(jsonObject);
            }
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            WifiBridge wifiBridge = WifiBridge.this;
            Context context = this.f30619b;
            Intrinsics.f(context, "context");
            if (!wifiBridge.e(context)) {
                bc.a aVar = this.f30620c;
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errCode", (Number) 12006);
                    jsonObject.addProperty("errMsg", WifiBridge.ERROR_LOCATION_CLOSED);
                    aVar.e(jsonObject);
                    return;
                }
                return;
            }
            WifiBridge wifiBridge2 = WifiBridge.this;
            Context context2 = this.f30619b;
            Intrinsics.f(context2, "context");
            wifiBridge2.g(context2, this.f30621d);
            if (this.f30622e.startScan()) {
                bc.a aVar2 = this.f30620c;
                if (aVar2 != null) {
                    aVar2.g();
                    return;
                }
                return;
            }
            bc.a aVar3 = this.f30620c;
            if (aVar3 != null) {
                aVar3.b();
            }
        }
    }

    public static /* synthetic */ void connectWifi$default(WifiBridge wifiBridge, App app, String str, String str2, String str3, Boolean bool, bc.a aVar, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            bool = Boolean.FALSE;
        }
        wifiBridge.connectWifi(app, str, str2, str3, bool, aVar);
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public final void a(Context context, String str, String str2, String str3, bc.a aVar) throws InterruptedException {
        boolean z11;
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiManager wifiManager = (WifiManager) systemService;
        int iC = c(wifiManager.getConfiguredNetworks(), str, str2);
        boolean zEnableNetwork = false;
        if (iC < 0) {
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.SSID = '\"' + str + '\"';
            wifiConfiguration.BSSID = str2;
            wifiConfiguration.status = 2;
            if (str3 == null || str3.length() == 0) {
                wifiConfiguration.allowedKeyManagement.set(0);
            } else {
                wifiConfiguration.preSharedKey = '\"' + str3 + '\"';
                wifiConfiguration.hiddenSSID = true;
                wifiConfiguration.allowedAuthAlgorithms.set(0);
                wifiConfiguration.allowedGroupCiphers.set(2);
                wifiConfiguration.allowedKeyManagement.set(1);
                wifiConfiguration.allowedPairwiseCiphers.set(1);
                wifiConfiguration.allowedGroupCiphers.set(3);
                wifiConfiguration.allowedPairwiseCiphers.set(2);
            }
            iC = wifiManager.addNetwork(wifiConfiguration);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ConnectingEventReceiver connectingEventReceiver = new ConnectingEventReceiver(this, iC, countDownLatch);
        if (iC >= 0) {
            context.registerReceiver(connectingEventReceiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
            zEnableNetwork = wifiManager.enableNetwork(iC, true);
            z11 = true;
        } else {
            z11 = false;
        }
        if (!zEnableNetwork) {
            if (z11) {
                h(context, connectingEventReceiver);
            }
            TmcLogger.f(TAG, "connect wifi failed!");
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errCode", (Number) 12010);
                jsonObject.addProperty("errMsg", ERROR_SYSTEM_ERROR);
                aVar.e(jsonObject);
                return;
            }
            return;
        }
        countDownLatch.await(30L, TimeUnit.SECONDS);
        int iA = connectingEventReceiver.a();
        if (iA != 0) {
            if (iA != 1) {
                if (aVar != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("errCode", (Number) 12010);
                    jsonObject2.addProperty("errMsg", ERROR_SYSTEM_ERROR);
                    aVar.e(jsonObject2);
                }
            } else if (aVar != null) {
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("errCode", (Number) 12002);
                jsonObject3.addProperty("errMsg", ERROR_PASSWORD_INVALID);
                aVar.e(jsonObject3);
            }
        } else if (aVar != null) {
            aVar.g();
        }
        h(context, connectingEventReceiver);
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final void b(String str, String str2, String str3, Context context, bc.a aVar) {
        WifiNetworkSpecifier.Builder ssid = w.a().setSsid(str);
        Intrinsics.f(ssid, "Builder().setSsid(ssid)");
        if (str2 != null && str2.length() != 0) {
            ssid.setBssid(MacAddress.fromString(str2));
        }
        if (str3 != null && str3.length() != 0) {
            ssid.setWpa2Passphrase(str3);
        }
        WifiNetworkSpecifier wifiNetworkSpecifierBuild = ssid.build();
        Intrinsics.f(wifiNetworkSpecifierBuild, "specifierBuilder.build()");
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(1).removeCapability(12).setNetworkSpecifier(u.a(wifiNetworkSpecifierBuild)).build();
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        try {
            connectivityManager.requestNetwork(networkRequestBuild, new d(booleanRef, connectivityManager, aVar, countDownLatch));
            countDownLatch.await(30L, TimeUnit.SECONDS);
            if (booleanRef.element || aVar == null) {
                return;
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errCode", (Number) 12003);
            jsonObject.addProperty("errMsg", ERROR_CONNECT_TIMEOUT);
            aVar.e(jsonObject);
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.b();
            }
            TmcLogger.h(TAG, th2);
        }
    }

    public final int c(List<? extends WifiConfiguration> list, String str, String str2) {
        List<? extends WifiConfiguration> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            String str3 = '\"' + str + '\"';
            for (WifiConfiguration wifiConfiguration : list) {
                if (Intrinsics.b(wifiConfiguration.SSID, str3) && (str2 == null || str2.length() == 0 || Intrinsics.b(str2, wifiConfiguration.BSSID))) {
                    return wifiConfiguration.networkId;
                }
            }
        }
        return -1;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void connectWifi(@cc.f(App.class) App app, @cc.g({"SSID"}) String str, @cc.g({"BSSID"}) String str2, @cc.g({"password"}) String str3, @cc.g({"maunal"}) Boolean bool, @cc.c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        Context context = appContext != null ? appContext.getContext() : null;
        if (context == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            if (str != null) {
                try {
                    if (str.length() != 0) {
                        Boolean bool2 = this.f30590b.get(app.getAppId());
                        Boolean bool3 = Boolean.TRUE;
                        if (!Intrinsics.b(bool2, bool3)) {
                            if (aVar != null) {
                                JsonObject jsonObject = new JsonObject();
                                jsonObject.addProperty("errCode", (Number) 12000);
                                jsonObject.addProperty("errMsg", ERROR_NO_INIT);
                                aVar.e(jsonObject);
                                return;
                            }
                            return;
                        }
                        Object systemService = context.getApplicationContext().getSystemService("wifi");
                        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                        WifiManager wifiManager = (WifiManager) systemService;
                        if (!wifiManager.isWifiEnabled()) {
                            if (aVar != null) {
                                JsonObject jsonObject2 = new JsonObject();
                                jsonObject2.addProperty("errCode", (Number) 12005);
                                jsonObject2.addProperty("errMsg", ERROR_WIFI_CLOSED);
                                aVar.e(jsonObject2);
                                return;
                            }
                            return;
                        }
                        if (!Intrinsics.b(bool, bool3)) {
                            PermissionUtils.y(CodePackage.LOCATION).m(new c(wifiManager, this, str, str2, str3, context, aVar)).z();
                            return;
                        }
                        context.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                        if (aVar != null) {
                            aVar.g();
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    TmcLogger.h(TAG, th);
                    if (aVar != null) {
                        JsonObject jsonObject3 = new JsonObject();
                        jsonObject3.addProperty("errCode", (Number) 12010);
                        jsonObject3.addProperty("errMsg", ERROR_SYSTEM_ERROR);
                        aVar.e(jsonObject3);
                        return;
                    }
                    return;
                }
            }
            if (aVar != null) {
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.addProperty("errCode", (Number) 12008);
                jsonObject4.addProperty("errMsg", ERROR_INVALID_SSID);
                aVar.e(jsonObject4);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final int d(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (StringsKt__StringsKt.O(str, "WPA", true)) {
            return 2;
        }
        if (StringsKt__StringsKt.O(str, "WEP", true)) {
            return 1;
        }
        return StringsKt__StringsKt.O(str, "EAP", true) ? 3 : 0;
    }

    @zb.a
    public final void destroyAppWifi(@cc.f(App.class) App app) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            return;
        }
        try {
            this.f30590b.remove(app.getAppId());
            b bVarRemove = this.f30589a.remove(app.getAppId());
            if (bVarRemove != null) {
                TmcLogger.f(TAG, "unregisterNetworkStatusChangedListener = " + app.getAppId());
                bc.a aVarB = bVarRemove.b();
                if (aVarB != null) {
                    aVarB.close();
                }
                NetworkUtils.C(bVarRemove);
            }
            WifiReceiver wifiReceiverRemove = this.f30591c.remove(app.getAppId());
            if (wifiReceiverRemove != null) {
                TmcLogger.f(TAG, "unRegisterWifiReceiver = " + app.getAppId());
                Context applicationContext = e0.a().getApplicationContext();
                Intrinsics.f(applicationContext, "getApp().applicationContext");
                h(applicationContext, wifiReceiverRemove);
                bc.a aVarA = wifiReceiverRemove.a();
                if (aVarA != null) {
                    aVarA.close();
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
        }
    }

    public final boolean e(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0;
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            return false;
        }
    }

    public final JsonObject f(WifiInfo wifiInfo, int i11) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("frequency", Integer.valueOf(wifiInfo.getFrequency()));
        String ssid = wifiInfo.getSSID();
        Intrinsics.f(ssid, "wifiInfo.ssid");
        String strSubstring = ssid.substring(1, wifiInfo.getSSID().length() - 1);
        Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        jsonObject.addProperty("SSID", strSubstring);
        jsonObject.addProperty("BSSID", wifiInfo.getBSSID());
        jsonObject.addProperty("security", Boolean.valueOf(i11 != 0));
        jsonObject.addProperty("signalStrength", Integer.valueOf(WifiManager.calculateSignalLevel(wifiInfo.getRssi(), 100)));
        return jsonObject;
    }

    public final void g(Context context, WifiReceiver wifiReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        context.registerReceiver(wifiReceiver, intentFilter);
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void getConnectedWifi(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Context context = appContext.getContext();
        if (context == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            if (!Intrinsics.b(this.f30590b.get(app.getAppId()), Boolean.TRUE)) {
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errCode", (Number) 12000);
                    jsonObject.addProperty("errMsg", ERROR_NO_INIT);
                    aVar.e(jsonObject);
                    return;
                }
                return;
            }
            Object systemService = context.getApplicationContext().getSystemService("wifi");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager wifiManager = (WifiManager) systemService;
            if (wifiManager.isWifiEnabled()) {
                PermissionUtils.y(CodePackage.LOCATION).m(new e(context, aVar, wifiManager)).z();
            } else if (aVar != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errCode", (Number) 12005);
                jsonObject2.addProperty("errMsg", ERROR_WIFI_CLOSED);
                aVar.e(jsonObject2);
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void getWifiList(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Context context = appContext.getContext();
        if (context == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            if (!Intrinsics.b(this.f30590b.get(app.getAppId()), Boolean.TRUE)) {
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errCode", (Number) 12000);
                    jsonObject.addProperty("errMsg", ERROR_NO_INIT);
                    aVar.e(jsonObject);
                    return;
                }
                return;
            }
            WifiReceiver wifiReceiver = this.f30591c.get(app.getAppId());
            if (wifiReceiver == null) {
                TmcLogger.f(TAG, "please onGetList before this function!");
                return;
            }
            Object systemService = context.getApplicationContext().getSystemService("wifi");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager wifiManager = (WifiManager) systemService;
            if (wifiManager.isWifiEnabled()) {
                PermissionUtils.y(CodePackage.LOCATION).m(new f(context, aVar, wifiReceiver, wifiManager)).z();
            } else if (aVar != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errCode", (Number) 12005);
                jsonObject2.addProperty("errMsg", ERROR_WIFI_CLOSED);
                aVar.e(jsonObject2);
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public final void h(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void offGetWifiList(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Context context = appContext.getContext();
        if (context == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            WifiReceiver wifiReceiverRemove = this.f30591c.remove(app.getAppId());
            if (wifiReceiverRemove != null) {
                h(context, wifiReceiverRemove);
                bc.a aVarA = wifiReceiverRemove.a();
                if (aVarA != null) {
                    aVarA.close();
                }
            }
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void offWifiConnected(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (appContext.getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            if (!Intrinsics.b(this.f30590b.get(app.getAppId()), Boolean.TRUE)) {
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errCode", (Number) 12000);
                    jsonObject.addProperty("errMsg", ERROR_NO_INIT);
                    aVar.e(jsonObject);
                    return;
                }
                return;
            }
            b bVarRemove = this.f30589a.remove(app.getAppId());
            if (bVarRemove != null) {
                bc.a aVarB = bVarRemove.b();
                if (aVarB != null) {
                    aVarB.close();
                }
                NetworkUtils.C(bVarRemove);
            }
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void onGetWifiList(@cc.f(App.class) App app, @cc.c(isSticky = true) bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (appContext.getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            if (this.f30591c.get(app.getAppId()) != null) {
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errCode", (Number) 12004);
                    jsonObject.addProperty("errMsg", ERROR_MULTI_LISTENER);
                    aVar.e(jsonObject);
                    return;
                }
                return;
            }
            String appId2 = app.getAppId();
            Intrinsics.f(appId2, "app.appId");
            WifiReceiver wifiReceiver = new WifiReceiver(this, appId2, aVar);
            ConcurrentHashMap<String, WifiReceiver> concurrentHashMap = this.f30591c;
            String appId3 = app.getAppId();
            Intrinsics.f(appId3, "app.appId");
            concurrentHashMap.put(appId3, wifiReceiver);
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void onWifiConnected(@cc.f(App.class) App app, @cc.c(isSticky = true) bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Context context = appContext.getContext();
        if (context == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            if (!Intrinsics.b(this.f30590b.get(app.getAppId()), Boolean.TRUE)) {
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errCode", (Number) 12000);
                    jsonObject.addProperty("errMsg", ERROR_NO_INIT);
                    aVar.e(jsonObject);
                    return;
                }
                return;
            }
            if (this.f30589a.get(app.getAppId()) != null) {
                if (aVar != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("errCode", (Number) 12004);
                    jsonObject2.addProperty("errMsg", ERROR_MULTI_LISTENER);
                    aVar.e(jsonObject2);
                    return;
                }
                return;
            }
            Object systemService = context.getApplicationContext().getSystemService("wifi");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager wifiManager = (WifiManager) systemService;
            if (!wifiManager.isWifiEnabled()) {
                if (aVar != null) {
                    JsonObject jsonObject3 = new JsonObject();
                    jsonObject3.addProperty("errCode", (Number) 12005);
                    jsonObject3.addProperty("errMsg", ERROR_WIFI_CLOSED);
                    aVar.e(jsonObject3);
                    return;
                }
                return;
            }
            String appId2 = app.getAppId();
            Intrinsics.f(appId2, "app.appId");
            b bVar = new b(this, wifiManager, appId2, aVar);
            ConcurrentHashMap<String, b> concurrentHashMap = this.f30589a;
            String appId3 = app.getAppId();
            Intrinsics.f(appId3, "app.appId");
            concurrentHashMap.put(appId3, bVar);
            NetworkUtils.y(bVar);
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void startWifi(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (appContext.getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            ConcurrentHashMap<String, Boolean> concurrentHashMap = this.f30590b;
            String appId = app.getAppId();
            Intrinsics.f(appId, "app.appId");
            concurrentHashMap.put(appId, Boolean.TRUE);
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void stopWifi(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Context context = appContext.getContext();
        if (context == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            this.f30590b.remove(app.getAppId());
            b bVarRemove = this.f30589a.remove(app.getAppId());
            if (bVarRemove != null) {
                NetworkUtils.C(bVarRemove);
                bc.a aVarB = bVarRemove.b();
                if (aVarB != null) {
                    aVarB.close();
                }
            }
            WifiReceiver wifiReceiverRemove = this.f30591c.remove(app.getAppId());
            if (wifiReceiverRemove != null) {
                h(context, wifiReceiverRemove);
                bc.a aVarA = wifiReceiverRemove.a();
                if (aVarA != null) {
                    aVarA.close();
                }
            }
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
