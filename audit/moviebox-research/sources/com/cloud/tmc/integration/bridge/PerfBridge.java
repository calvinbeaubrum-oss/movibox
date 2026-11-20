package com.cloud.tmc.integration.bridge;

import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PerfBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a("")
    @zb.e(ExecutorType.NETWORK)
    public void record(@cc.f(App.class) App app, @cc.g(name = {"module"}) String str, @cc.g(name = {"enumType"}) String str2, @cc.g(name = {NotificationCompat.CATEGORY_MESSAGE}) String str3) {
        try {
            if ("point".equals(str)) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app == null ? null : app.getAppId(), (com.cloud.tmc.kernel.proxy.performanceanalyse.c) Enum.valueOf(PointAnalyseType.class, str2), str3);
            }
        } catch (Exception e11) {
            TmcLogger.h("record error", e11);
        }
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public void reportEvent(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.g(name = {"eventName"}) String str, @cc.g(name = {"data"}) JsonObject jsonObject, @cc.c bc.a aVar) {
        if (page == null || str == null || str.isEmpty()) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app == null ? null : app.getAppId(), new com.cloud.tmc.kernel.proxy.performanceanalyse.d(str, page.getPagePath(), jsonObject), "");
            if (aVar != null) {
                aVar.d(new JsonObject());
            }
        }
    }
}
