package com.cloud.tmc.integration.bridge;

import com.cloud.tmc.integration.model.WebViewStore;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonObject;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class WebViewAbilityBridge implements BridgeExtension {
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void offWebViewDownloadUrl(@cc.f(App.class) App app, @cc.c bc.a callback) {
        HashMap<String, bc.a> onDownloads;
        bc.a aVarRemove;
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: W10001");
            callback.e(jsonObject);
        } else {
            WebViewStore webViewStore = (WebViewStore) app.getData(WebViewStore.class);
            if (webViewStore != null && (onDownloads = webViewStore.getOnDownloads()) != null && (aVarRemove = onDownloads.remove(app.getAppId())) != null) {
                aVarRemove.close();
            }
            callback.g();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("WebViewAbilityBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("WebViewAbilityBridge", "onInitialized");
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void onWebViewDownloadUrl(@cc.f(App.class) App app, @cc.c(isSticky = true) bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: W10001");
            callback.e(jsonObject);
            return;
        }
        WebViewStore webViewStore = (WebViewStore) app.getData(WebViewStore.class, true);
        bc.a aVar = webViewStore.getOnDownloads().get(app.getAppId());
        if (aVar != null) {
            aVar.close();
        }
        HashMap<String, bc.a> onDownloads = webViewStore.getOnDownloads();
        String appId = app.getAppId();
        Intrinsics.f(appId, "app.appId");
        onDownloads.put(appId, callback);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }
}
