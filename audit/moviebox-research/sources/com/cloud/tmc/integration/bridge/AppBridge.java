package com.cloud.tmc.integration.bridge;

import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.google.gson.JsonObject;
import com.transsion.push.PushConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AppBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void getAppInfo(@cc.f(App.class) App app, @cc.g({PushConstants.PROVIDER_FIELD_APP_ID}) String appId, @cc.c bc.a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(callback, "callback");
        try {
            JsonObject jsonObject = new JsonObject();
            tb.b appContext = app.getAppContext();
            if (appContext == null || (context = appContext.getContext()) == null) {
                unit = null;
            } else {
                if (appId.length() == 0) {
                    String appId2 = app.getAppId();
                    if (appId2 == null) {
                        appId2 = "";
                    } else {
                        Intrinsics.f(appId2, "app.appId ?: \"\"");
                    }
                    appId = appId2;
                }
                jsonObject.addProperty("appInfo", ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, appId, appId + "_used"));
                callback.d(jsonObject);
                unit = Unit.f68710a;
            }
            if (unit == null) {
                callback.f();
            }
        } catch (Throwable th2) {
            TmcLogger.h("getAppInfo error", th2);
            callback.b();
        }
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void getMiniAppInfo(@cc.f(App.class) App app, @cc.c bc.a callback) {
        String name;
        Integer popupStyle;
        Intrinsics.g(app, "app");
        Intrinsics.g(callback, "callback");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(PushConstants.PROVIDER_FIELD_APP_ID, app.getAppId());
        jsonObject.addProperty("appVersion", app.getAppVersion());
        AppModel appModel = app.getAppModel();
        if (appModel == null || (name = appModel.getName()) == null) {
            name = "";
        }
        jsonObject.addProperty("appName", name);
        AppModel appModel2 = app.getAppModel();
        jsonObject.addProperty("popupStyle", Integer.valueOf((appModel2 == null || (popupStyle = appModel2.getPopupStyle()) == null) ? 0 : popupStyle.intValue()));
        AppModel appModel3 = app.getAppModel();
        jsonObject.addProperty("appCategoryType", String.valueOf(appModel3 != null ? Integer.valueOf(appModel3.getAppinfoCategoryType()) : null));
        callback.d(jsonObject);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public /* bridge */ /* synthetic */ dd.f permit() {
        return (dd.f) m120permit();
    }

    /* JADX INFO: renamed from: permit, reason: collision with other method in class */
    public Void m120permit() {
        return null;
    }
}
