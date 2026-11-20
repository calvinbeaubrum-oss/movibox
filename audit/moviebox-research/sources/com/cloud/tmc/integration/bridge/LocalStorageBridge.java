package com.cloud.tmc.integration.bridge;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.tmc.integration.point.IIDEDispatcherPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class LocalStorageBridge implements BridgeExtension {
    private JsonObject a(@NonNull String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data", str);
        return jsonObject;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void clearStorage(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        IIDEDispatcherPoint iIDEDispatcherPoint;
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            return;
        }
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).clear(app.getAppContext().getContext(), app.getAppId() + "_web");
        if (aVar != null) {
            aVar.g();
        }
        if (app.getAppModel() != null && app.getAppModel().getDevMode() == 2 && (iIDEDispatcherPoint = (IIDEDispatcherPoint) ib.a.b(IIDEDispatcherPoint.class).g(app).d()) != null) {
            iIDEDispatcherPoint.sendMsg("DOMStorage.domStorageItemsCleared", new JsonObject());
        }
        FileUtil.f31012a.k(app);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getStorage(@cc.g(name = {"key"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            aVar.b();
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            aVar.b();
            return;
        }
        if (appContext.getContext() == null) {
            aVar.b();
            return;
        }
        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(app.getAppContext().getContext(), app.getAppId() + "_web", str);
        if (aVar != null) {
            aVar.d(a(string));
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getStorageInfo(@cc.g(name = {"key"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
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

    @zb.a
    @zb.e(ExecutorType.IO)
    public void removeStorage(@cc.g(name = {"key"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        IIDEDispatcherPoint iIDEDispatcherPoint;
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            return;
        }
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(app.getAppContext().getContext(), app.getAppId() + "_web", str);
        if (aVar != null) {
            aVar.g();
        }
        if (app.getAppModel() != null && app.getAppModel().getDevMode() == 2 && (iIDEDispatcherPoint = (IIDEDispatcherPoint) ib.a.b(IIDEDispatcherPoint.class).g(app).d()) != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("key", str);
            iIDEDispatcherPoint.sendMsg("DOMStorage.domStorageItemRemoved", jsonObject);
        }
        FileUtil.f31012a.k(app);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void setStorage(@cc.g(name = {"key"}) String str, @cc.g(name = {"data"}) String str2, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        char c11;
        IIDEDispatcherPoint iIDEDispatcherPoint;
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            return;
        }
        FileUtil fileUtil = FileUtil.f31012a;
        if (fileUtil.N(app)) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Data storage failed because of insufficient storage space: S001").e());
            }
            fileUtil.k(app);
            return;
        }
        String str3 = "DOMStorage.domStorageItemAdded";
        if (app.getAppModel() == null || app.getAppModel().getDevMode() != 2) {
            c11 = 0;
        } else {
            KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
            Context context = app.getAppContext().getContext();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(app.getAppId());
            sb2.append("_web");
            str3 = TextUtils.isEmpty(kVStorageProxy.getString(context, sb2.toString(), str)) ? "DOMStorage.domStorageItemAdded" : "DOMStorage.domStorageItemUpdated";
            c11 = 2;
        }
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(app.getAppContext().getContext(), app.getAppId() + "_web", str, str2);
        if (aVar != null) {
            aVar.g();
        }
        if (c11 == 2 && (iIDEDispatcherPoint = (IIDEDispatcherPoint) ib.a.b(IIDEDispatcherPoint.class).g(app).d()) != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("key", str);
            jsonObject.addProperty(AppMeasurementSdk.ConditionalUserProperty.VALUE, str2);
            iIDEDispatcherPoint.sendMsg(str3, jsonObject);
        }
        fileUtil.k(app);
    }
}
