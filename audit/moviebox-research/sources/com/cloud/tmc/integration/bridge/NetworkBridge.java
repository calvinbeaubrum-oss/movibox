package com.cloud.tmc.integration.bridge;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.service.EnvironmentService;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class NetworkBridge implements BridgeExtension {
    public static final String KEY_NETWORK_TYPE = "networkType";
    public static final String KEY_WEAK_NET = "weakNet";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NetworkReceiver f30555a = null;

    /* JADX INFO: compiled from: source.java */
    public static class NetworkReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static long f30556c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static long f30557d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static long f30558e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f30559f = -3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f30560a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NetworkTaskModelList f30561b;

        public NetworkReceiver(NetworkTaskModelList networkTaskModelList) {
            NetworkTaskModelList networkTaskModelList2 = new NetworkTaskModelList();
            this.f30561b = networkTaskModelList2;
            networkTaskModelList2.addAll(networkTaskModelList);
        }

        public static int d(Context context) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return 0;
                }
                if (activeNetworkInfo.getType() == 0) {
                    return 1;
                }
            }
            return -1;
        }

        public void a(NetworkTaskModelList networkTaskModelList) {
            if (networkTaskModelList == null) {
                return;
            }
            if (this.f30561b == null) {
                this.f30561b = new NetworkTaskModelList();
            }
            this.f30561b.addAll(networkTaskModelList);
        }

        public final JsonObject b(String str, boolean z11) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(NetworkBridge.KEY_NETWORK_TYPE, str);
            jsonObject.addProperty(NetworkBridge.KEY_WEAK_NET, Boolean.valueOf(z11));
            return jsonObject;
        }

        public void c(App app) {
            if (this.f30561b == null || app == null) {
                return;
            }
            long nodeId = app.getNodeId();
            Iterator<a> it = this.f30561b.iterator();
            while (it.hasNext()) {
                if (nodeId == it.next().f30562a) {
                    it.remove();
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis == f30556c || jCurrentTimeMillis == f30557d || jCurrentTimeMillis == f30558e) {
                        return;
                    }
                    int iD = d(context);
                    if (iD == 0 && f30559f != 0) {
                        f30556c = jCurrentTimeMillis;
                        f30559f = iD;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("wifi：");
                        sb2.append(jCurrentTimeMillis);
                        this.f30560a = "WIFI";
                        for (a aVar : this.f30561b) {
                            bc.a aVar2 = aVar.f30564c;
                            WeakReference<Page> weakReference = aVar.f30563b;
                            if (weakReference != null && weakReference.get() != null && !aVar.f30563b.get().isDestroyed() && aVar2 != null) {
                                aVar2.d(b("WIFI", false));
                            }
                        }
                        return;
                    }
                    if (iD != 1) {
                        if (iD != -1 || f30559f == -1) {
                            return;
                        }
                        f30558e = jCurrentTimeMillis;
                        f30559f = iD;
                        this.f30560a = DevicePublicKeyStringDef.NONE;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("无网络：");
                        sb3.append(jCurrentTimeMillis);
                        for (a aVar3 : this.f30561b) {
                            bc.a aVar4 = aVar3.f30564c;
                            WeakReference<Page> weakReference2 = aVar3.f30563b;
                            if (weakReference2 != null && weakReference2.get() != null && !aVar3.f30563b.get().isDestroyed() && aVar4 != null) {
                                aVar4.d(b(DevicePublicKeyStringDef.NONE, true));
                            }
                        }
                        return;
                    }
                    f30557d = jCurrentTimeMillis;
                    f30559f = iD;
                    String strG = NetworkUtil.g(context);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("数据网络：");
                    sb4.append(strG);
                    sb4.append("：");
                    sb4.append(jCurrentTimeMillis);
                    if (this.f30560a.equals(strG)) {
                        return;
                    }
                    this.f30560a = strG;
                    boolean zEquals = "2G".equals(strG);
                    for (a aVar5 : this.f30561b) {
                        bc.a aVar6 = aVar5.f30564c;
                        WeakReference<Page> weakReference3 = aVar5.f30563b;
                        if (weakReference3 != null && weakReference3.get() != null && !aVar5.f30563b.get().isDestroyed() && aVar6 != null) {
                            aVar6.d(b(strG, zEquals));
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class NetworkTaskModelList extends ArrayList<a> {
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<Page> f30563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bc.a f30564c;

        public a(Page page, bc.a aVar) {
            this.f30562a = page.getApp() == null ? 0L : page.getApp().getNodeId();
            this.f30563b = new WeakReference<>(page);
            this.f30564c = aVar;
        }
    }

    public final JsonObject a(String str, boolean z11) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(KEY_NETWORK_TYPE, str);
        jsonObject.addProperty(KEY_WEAK_NET, Boolean.valueOf(z11));
        return jsonObject;
    }

    public final String b(short s11) {
        int i11 = (-1) << (32 - s11);
        int[] iArr = new int[4];
        for (int i12 = 0; i12 < 4; i12++) {
            iArr[3 - i12] = (i11 >> (i12 * 8)) & 255;
        }
        String str = "" + iArr[0];
        for (int i13 = 1; i13 < 4; i13++) {
            str = str + InstructionFileId.DOT + iArr[i13];
        }
        return str;
    }

    public final void c(Page page, bc.a aVar) {
        try {
            boolean z11 = true;
            String strG = "fail".equals(NetworkUtil.h(page.getPageContext().getActivity().getApplicationContext())) ^ true ? NetworkUtil.g(page.getPageContext().getActivity().getApplicationContext()) : DevicePublicKeyStringDef.NONE;
            if (!DevicePublicKeyStringDef.NONE.equals(strG) && !"2G".equals(strG)) {
                z11 = false;
            }
            if (aVar != null) {
                aVar.d(a(strG, z11));
            }
        } catch (Throwable th2) {
            TmcLogger.g("NetworkUtil", "sendCurrentNetworkResult failed: ", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    public void clearNetworkChangeListenModel(App app) {
        NetworkReceiver networkReceiver = this.f30555a;
        if (networkReceiver != null) {
            networkReceiver.c(app);
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public void getLocalIpAddress(@cc.f(Page.class) Page page, @cc.c bc.a aVar) {
        String displayName;
        if (page == null || page.getPageContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        String hostAddress = "0.0.0.0";
        String strB = "";
        try {
            if ("wifi".equals(NetworkUtil.h(page.getPageContext().getActivity().getApplicationContext()))) {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    List<InterfaceAddress> interfaceAddresses = networkInterface.getInterfaceAddresses();
                    if (interfaceAddresses != null && interfaceAddresses.size() > 0 && (displayName = networkInterface.getDisplayName()) != null && displayName.startsWith("wlan0")) {
                        for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                            InetAddress address = interfaceAddress.getAddress();
                            if (address instanceof Inet4Address) {
                                hostAddress = address.getHostAddress();
                                strB = b(interfaceAddress.getNetworkPrefixLength());
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h("NetworkBridge", th2);
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("localip", hostAddress);
        jsonObject.addProperty("netmask", strB);
        if (aVar != null) {
            aVar.d(jsonObject);
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public void getNetworkType(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        try {
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
            Context context = appContext.getContext();
            if (context == null) {
                if (aVar != null) {
                    aVar.b();
                }
            } else {
                String strH = NetworkUtil.h(context);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(KEY_NETWORK_TYPE, "fail".equals(strH) ^ true ? NetworkUtil.g(context) : DevicePublicKeyStringDef.NONE);
                if (aVar != null) {
                    aVar.d(jsonObject);
                }
            }
        } catch (Exception e11) {
            TmcLogger.g("NetworkUtil", e11.getMessage(), e11);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public void offNetworkStatusChange(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.c bc.a aVar) {
        NetworkTaskModelList networkTaskModelList = (NetworkTaskModelList) app.getData(NetworkTaskModelList.class);
        if (networkTaskModelList == null) {
            return;
        }
        Iterator<a> it = networkTaskModelList.iterator();
        while (it.hasNext()) {
            if (it.next().f30563b.get() == page) {
                it.remove();
            }
        }
        aVar.d(new JsonObject());
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        EnvironmentService environmentService;
        Application applicationContext;
        if (this.f30555a == null || (environmentService = (EnvironmentService) tc.a.a(EnvironmentService.class)) == null || (applicationContext = environmentService.getApplicationContext()) == null) {
            return;
        }
        applicationContext.unregisterReceiver(this.f30555a);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public void onNetworkStatusChange(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.c(isSticky = true) bc.a aVar) {
        if (page == null || aVar == null) {
            return;
        }
        NetworkTaskModelList networkTaskModelList = (NetworkTaskModelList) app.getData(NetworkTaskModelList.class);
        if (networkTaskModelList == null) {
            networkTaskModelList = new NetworkTaskModelList();
            app.setData(NetworkTaskModelList.class, networkTaskModelList);
        }
        boolean z11 = false;
        for (a aVar2 : networkTaskModelList) {
            if (aVar2.f30563b.get() == page && !page.isDestroyed()) {
                aVar2.f30564c = aVar;
                z11 = true;
            }
        }
        if (z11) {
            this.f30555a.a(networkTaskModelList);
            c(page, aVar);
            return;
        }
        networkTaskModelList.add(new a(page, aVar));
        NetworkReceiver networkReceiver = this.f30555a;
        if (networkReceiver != null) {
            networkReceiver.a(networkTaskModelList);
            c(page, aVar);
            return;
        }
        this.f30555a = new NetworkReceiver(networkTaskModelList);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            app.getAppContext().getContext().getApplicationContext().registerReceiver(this.f30555a, intentFilter);
        } catch (Throwable th2) {
            TmcLogger.g("NetworkUtil", "registerReceiver failed: ", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public void startPreConnect(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        try {
            ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).startPreConnect();
            aVar.g();
        } catch (Throwable th2) {
            TmcLogger.h("NetworkBridge", th2);
            aVar.b();
        }
    }
}
