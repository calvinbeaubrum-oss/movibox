package com.cloud.tmc.integration.internalBridge;

import bc.a;
import cc.c;
import cc.f;
import cc.g;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import java.util.HashMap;
import zb.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class GetAppConfigBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @e(ExecutorType.NORMAL)
    public void getAppJson(@c a aVar, @f(Page.class) Page page, @f(App.class) App app) {
        AppLoadResult appLoadResult = (AppLoadResult) app.getData(AppLoadResult.class);
        if (appLoadResult == null) {
            aVar.b();
        } else {
            aVar.d(JsonParser.parseString(new Gson().toJson(appLoadResult.appConfigModel)).getAsJsonObject());
        }
    }

    @zb.a
    @e(ExecutorType.NORMAL)
    public void getPageJson(@g(name = {"pagePath"}) String str, @c a aVar, @f(Page.class) Page page, @f(App.class) App app) {
        AppLoadResult appLoadResult = (AppLoadResult) app.getData(AppLoadResult.class);
        if (appLoadResult == null) {
            aVar.b();
            return;
        }
        HashMap<String, MiniAppConfigModel.PagesBean> map = appLoadResult.appConfigModel.launchParams;
        for (String str2 : map.keySet()) {
            if (str.equals(str2)) {
                aVar.d(JsonParser.parseString(new Gson().toJson(map.get(str2))).getAsJsonObject());
                return;
            }
        }
        aVar.b();
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
