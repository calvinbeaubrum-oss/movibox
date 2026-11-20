package com.cloud.tmc.integration.internalBridge;

import android.text.TextUtils;
import bc.a;
import cc.c;
import cc.f;
import cc.g;
import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.google.gson.JsonObject;
import com.transsion.push.PushConstants;
import gd.b;
import java.io.File;
import zb.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class GetPackageFileBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @e(ExecutorType.NORMAL)
    public void getCommonResPackageFile(@g(name = {NativeRequestBridge.KEY_FILE_PATH}) String str, @c a aVar, @f(Page.class) Page page, @f(App.class) App app) {
        try {
            getPackageFile(str, app.getAppModel().getTemplateMiniappId(), aVar, page, app);
        } catch (Throwable th2) {
            TmcLogger.h("GetPackageFileBridge", th2);
        }
    }

    @zb.a
    @e(ExecutorType.NORMAL)
    public void getPackageFile(@g(name = {NativeRequestBridge.KEY_FILE_PATH}) String str, @g(name = {PushConstants.PROVIDER_FIELD_APP_ID}) String str2, @c a aVar, @f(Page.class) Page page, @f(App.class) App app) {
        String strH;
        File offlineResources;
        if (app == null || app.getAppContext().getContext() == null) {
            return;
        }
        if (((AppLoadResult) app.getData(AppLoadResult.class)) == null) {
            aVar.b();
            return;
        }
        try {
            String str3 = "0";
            if (TextUtils.isEmpty(str2)) {
                str2 = app.getAppId();
            }
            String filePath = ((IPackageResourceManager) tc.a.a(IPackageResourceManager.class)).getFilePath(str2, ((IPackageResourceManager) tc.a.a(IPackageResourceManager.class)).getVhost(str2) + str);
            if (TextUtils.isEmpty(filePath) && (offlineResources = ((IOfflineManagerProxy) tc.a.a(IOfflineManagerProxy.class)).getOfflineResources(str2, str)) != null && offlineResources.exists() && offlineResources.isFile()) {
                filePath = offlineResources.getAbsolutePath();
                str3 = "1";
            }
            if (TextUtils.isEmpty(filePath)) {
                strH = "";
            } else {
                File file = new File(filePath);
                if (!file.exists() || !file.isFile()) {
                    TmcLogger.f("GetPackageFileBridge", "Miniapp Start Error! file not exist or not a file");
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "Miniapp Start Error! file not exist or not a file");
                    aVar.e(jsonObject);
                    return;
                }
                strH = oe.a.h(file);
            }
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty(AppLovinEventTypes.USER_VIEWED_CONTENT, strH);
            aVar.d(jsonObject2);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_GET_PACKAGE_FILE.putData("gpf_appId", str2).putData("gpf_filePath", str).putData("gpf_source", str3), "");
        } catch (Throwable th2) {
            TmcLogger.h("GetPackageFileBridge", th2);
            aVar.b();
        }
        IEngine engineProxy = app.getEngineProxy();
        if (engineProxy != null) {
            b workerById = engineProxy.getEngineRouter().getWorkerById(engineProxy.getWorkerId());
            if (workerById != null) {
                workerById.p(app.getAppId());
            }
        }
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
}
