package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.offlineapps.OfflineAppBean;
import com.cloud.tmc.miniapp.offlineapps.ScanScene;
import com.cloud.tmc.miniutils.util.k;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;
import n.c;
import p.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class OfflineAppProxyImp implements OfflineAppProxy {
    public ConcurrentLinkedQueue<OfflineAppProxy.b> OooO00o = new ConcurrentLinkedQueue<>();

    /* JADX INFO: compiled from: source.java */
    public static final class a implements p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfflineAppProxy.a f31519a;

        public a(OfflineAppProxy.a aVar) {
            this.f31519a = aVar;
        }

        @Override // p.a
        public void a(List<OfflineAppBean> offlineApps) {
            Intrinsics.g(offlineApps, "offlineApps");
            OfflineAppProxy.a aVar = this.f31519a;
            String strJ = k.j(offlineApps);
            Intrinsics.f(strJ, "toJson(offlineApps)");
            aVar.onSuccess(strJ);
        }
    }

    @Override // com.cloud.tmc.integration.proxy.OfflineAppProxy
    public void addShortCutListener(OfflineAppProxy.b listener) {
        Intrinsics.g(listener, "listener");
        try {
            this.OooO00o.add(listener);
            TmcLogger.f("sam", "addShortCutListener: " + this.OooO00o.size());
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.integration.proxy.OfflineAppProxy
    public void downloadIcon(String appId, String logoUrl) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(logoUrl, "logoUrl");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(logoUrl, "logoUrl");
        c.f71307a.a(appId, logoUrl);
    }

    @Override // com.cloud.tmc.integration.proxy.OfflineAppProxy
    public void getOfflineAppsForBridgeApi(boolean z11, OfflineAppProxy.a callback) {
        Intrinsics.g(callback, "callback");
        a aVar = new a(callback);
        ScanScene scanScene = ScanScene.SCAN_BRIDGEAPI;
        Intrinsics.g(scanScene, "scanScene");
        d.f73467a.g(z11, scanScene, aVar);
    }

    @Override // com.cloud.tmc.integration.proxy.OfflineAppProxy
    public void notifyCreateShortCutsSuccess(String appId) {
        Intrinsics.g(appId, "appId");
        try {
            Iterator<OfflineAppProxy.b> it = this.OooO00o.iterator();
            Intrinsics.f(it, "offlineAppsShortCutListeners.iterator()");
            TmcLogger.f("sam", "notifyCreateShortCutsSuccess:appId:" + appId + ", " + this.OooO00o.size());
            while (it.hasNext()) {
                it.next().m(appId);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.integration.proxy.OfflineAppProxy
    public void removeShortCutListener(OfflineAppProxy.b listener) {
        Intrinsics.g(listener, "listener");
        try {
            this.OooO00o.remove(listener);
            TmcLogger.f("sam", "removeShortCutListener: " + this.OooO00o.size());
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.integration.proxy.OfflineAppProxy
    public void scanForOfflineDownloadDelete() {
        ScanScene scanScene = ScanScene.SCAN_DELETE_OFFLINEDOWNLOAD_APP;
        Intrinsics.g(scanScene, "scanScene");
        d.f73467a.g(true, scanScene, null);
    }

    @Override // com.cloud.tmc.integration.proxy.OfflineAppProxy
    public void scanForOfflineDownloadSuccess() {
        ScanScene scanScene = ScanScene.SCAN_OFFLINEDOWNLOAD_APP;
        Intrinsics.g(scanScene, "scanScene");
        d.f73467a.g(true, scanScene, null);
    }

    @Override // com.cloud.tmc.integration.proxy.OfflineAppProxy
    public void scanForUsedAppDelete() {
        ScanScene scanScene = ScanScene.SCAN_DELETE_USED_APP;
        Intrinsics.g(scanScene, "scanScene");
        d.f73467a.g(true, scanScene, null);
    }
}
