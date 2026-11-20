package com.cloud.tmc.integration.bridge;

import android.os.Bundle;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.push.PushConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class AppOptionsBridge implements BridgeExtension {
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
    @zb.e(ExecutorType.IO)
    public final void getEntranceUrl(@cc.f(App.class) App app, @cc.c bc.a callback) {
        String string;
        Intrinsics.g(callback, "callback");
        if (app == null) {
            callback.b();
            return;
        }
        Bundle startParams = app.getStartParams();
        Bundle sceneParams = app.getSceneParams();
        JsonObject jsonObject = new JsonObject();
        if (startParams == null || (string = startParams.getString("entranceUrl")) == null) {
            string = sceneParams != null ? sceneParams.getString("entranceUrl") : null;
            if (string == null) {
                string = "";
            }
        }
        jsonObject.addProperty("entranceUrl", string);
        callback.d(jsonObject);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getFeedBackAppInfo(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Bundle startParams = app.getStartParams();
        String strA = xb.e.a(startParams != null ? startParams.getString("feedback_miniappId") : null, "");
        String strA2 = xb.e.a(startParams != null ? startParams.getString("feedback_miniappVersion") : null, "");
        z.a aVarA = z.a();
        Intrinsics.f(aVarA, "create()");
        aVarA.d("feedback_miniappId", strA);
        aVarA.d("feedback_miniappVersion", strA2);
        if (aVar != null) {
            aVar.d(aVarA.e());
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getLaunchOptions(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.c bc.a aVar) {
        getLaunchOptionsSync(app, page, aVar);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getLaunchOptionsSync(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.c bc.a aVar) {
        String string;
        if (app == null || page == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Bundle startParams = app.getStartParams();
        Bundle sceneParams = app.getSceneParams();
        z.a aVarA = z.a();
        Intrinsics.f(aVarA, "create()");
        aVarA.d("query", xb.e.a(startParams != null ? startParams.getString("query") : null, ""));
        aVarA.d(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, page.getPagePath());
        aVarA.d(TrackingKey.SCENE_ID, xb.e.a(sceneParams != null ? sceneParams.getString(TrackingKey.SCENE_ID) : null, "100000"));
        aVarA.d("mfah", xb.e.a(startParams != null ? startParams.getString("mfah") : null, ""));
        aVarA.d("massid", xb.e.a(sceneParams != null ? sceneParams.getString("massid") : null, ""));
        z.a aVarA2 = z.a();
        Intrinsics.f(aVarA2, "create()");
        aVarA2.d(PushConstants.PROVIDER_FIELD_APP_ID, app.getAppId());
        z.a aVarA3 = z.a();
        Intrinsics.f(aVarA3, "create()");
        if (startParams != null) {
            try {
                string = startParams.getString("extraData");
            } catch (Throwable th2) {
                TmcLogger.h("AppOptionsBridge", th2);
            }
        } else {
            string = null;
        }
        Map mapG = TmcGsonUtils.g(string);
        if (mapG != null) {
            for (Map.Entry entry : mapG.entrySet()) {
                aVarA3.d((String) entry.getKey(), (String) entry.getValue());
            }
        }
        String string2 = startParams != null ? startParams.getString("usedPage") : null;
        String string3 = startParams != null ? startParams.getString("page") : null;
        if (string3 == null) {
            string3 = "";
        }
        aVarA3.d("page", xb.e.a(string2, string3));
        aVarA3.d("mode", xb.e.a(startParams != null ? startParams.getString("mode") : null, ""));
        aVarA3.d("query", xb.e.a(startParams != null ? startParams.getString("query") : null, ""));
        aVarA3.d("openMCScene", xb.e.a(startParams != null ? startParams.getString("openMCScene") : null, ""));
        aVarA2.a("extraData", aVarA3.e());
        aVarA.a("referrerInfo", aVarA2.e());
        if (aVar != null) {
            aVar.d(aVarA.e());
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("AppOptionsBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("AppOptionsBridge", "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }
}
