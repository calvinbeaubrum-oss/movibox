package com.cloud.tmc.integration.bridge;

import androidx.annotation.NonNull;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.h0;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class FrameworkStorageBridge implements BridgeExtension {
    public static final String FRAMEWORK_STORAGE_KEY = "100000_web";

    public final JsonObject a(@NonNull String str) {
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
    public void clearFrameworkStorage(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            return;
        }
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).clear(app.getAppContext().getContext(), FRAMEWORK_STORAGE_KEY);
        if (aVar != null) {
            aVar.g();
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getFrameworkStorage(@cc.g(name = {"key"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
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
        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(app.getAppContext().getContext(), FRAMEWORK_STORAGE_KEY, str);
        if (aVar != null) {
            aVar.d(a(string));
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

    @zb.a
    @zb.e(ExecutorType.IO)
    public void removeFrameworkStorage(@cc.g(name = {"key"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            return;
        }
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(app.getAppContext().getContext(), FRAMEWORK_STORAGE_KEY, str);
        if (aVar != null) {
            aVar.g();
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void setFrameworkStorage(@cc.g(name = {"key"}) String str, @cc.g(name = {"data"}) String str2, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            return;
        }
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(app.getAppContext().getContext(), FRAMEWORK_STORAGE_KEY, str, str2);
        if ("dlt-privacy-aggrement".equals(str) && "true".equals(str2)) {
            h0.f31062a.a(app.getAppContext().getContext());
        }
        if (aVar != null) {
            aVar.g();
        }
    }
}
