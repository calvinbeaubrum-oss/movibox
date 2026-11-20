package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import android.os.Bundle;
import cc.c;
import cc.f;
import cc.g;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppUpdateMessageStore;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.MiniRequestUtils;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.prestrategy.PreStrategyManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.k;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import hd.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.l;
import p011Oooo00o.o00Ooo;
import zb.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class MiniAppUpdateBridge implements BridgeExtension {
    public static final a Companion = new a();
    public static final String ERROR_MSG_100010 = "Download failed: 100010";
    public static final String ERROR_MSG_100011 = "Decompression failed: 100011";
    public static final String ERROR_MSG_100012 = "Start failed: 100012";
    public static final String ERROR_MSG_100013 = "Preload failed: 100013";
    public static final String ERROR_MSG_100014 = "This root was not found: 100014";
    public static final String ERROR_MSG_10009 = "Preloading,please try later: MAU10009";

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function1<BaseResponse<? extends Object>, Unit> {
        public final /* synthetic */ App OooO0O0;
        public final /* synthetic */ String OooO0OO;

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public final /* synthetic */ long f31486OooO0Oo;

        /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
        public final /* synthetic */ bc.a f31487OooO0o0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO(App app, String str, long j11, bc.a aVar) {
            super(1);
            this.OooO0O0 = app;
            this.OooO0OO = str;
            this.f31486OooO0Oo = j11;
            this.f31487OooO0o0 = aVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(BaseResponse<? extends Object> baseResponse) {
            BaseResponse<? extends Object> it = baseResponse;
            Intrinsics.g(it, "it");
            MiniAppUpdateBridge miniAppUpdateBridge = MiniAppUpdateBridge.this;
            App app = this.OooO0O0;
            miniAppUpdateBridge.OooO00o(it, app, this.OooO0OO, this.f31486OooO0Oo, new com.cloud.tmc.miniapp.bridge.OooO0OO(app, this.f31487OooO0o0));
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ App OooO00o;
        public final /* synthetic */ bc.a OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(App app, bc.a aVar) {
            super(0);
            this.OooO00o = app;
            this.OooO0O0 = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.OooO00o.putBooleanValue("miniAppHasUpdateDownloading", false);
            this.OooO0O0.g();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function3<String, String, IOException, Unit> {
        public final /* synthetic */ App OooO00o;
        public final /* synthetic */ bc.a OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0OO(App app, bc.a aVar) {
            super(3);
            this.OooO00o = app;
            this.OooO0O0 = aVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public Unit invoke(String str, String str2, IOException iOException) {
            Intrinsics.g(str, "<anonymous parameter 0>");
            Intrinsics.g(iOException, "<anonymous parameter 2>");
            this.OooO00o.putBooleanValue("miniAppHasUpdateDownloading", false);
            f.a.a("errMsg", "Failed to download the applet package, please try later: MAU10007", this.OooO0O0);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function1<BaseResponse<? extends AppInfoModel>, Unit> {
        public final /* synthetic */ App OooO0O0;
        public final /* synthetic */ String OooO0OO;

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public final /* synthetic */ long f31488OooO0Oo;

        /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
        public final /* synthetic */ bc.a f31489OooO0o;

        /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
        public final /* synthetic */ boolean f31490OooO0o0;
        public final /* synthetic */ Context OooO0oO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0o(App app, String str, long j11, boolean z11, bc.a aVar, Context context) {
            super(1);
            this.OooO0O0 = app;
            this.OooO0OO = str;
            this.f31488OooO0Oo = j11;
            this.f31490OooO0o0 = z11;
            this.f31489OooO0o = aVar;
            this.OooO0oO = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(BaseResponse<? extends AppInfoModel> baseResponse) {
            BaseResponse<? extends AppInfoModel> it = baseResponse;
            Intrinsics.g(it, "it");
            try {
                MiniAppUpdateBridge miniAppUpdateBridge = MiniAppUpdateBridge.this;
                App app = this.OooO0O0;
                miniAppUpdateBridge.OooO00o(it, app, this.OooO0OO, this.f31488OooO0Oo, this.f31490OooO0o0, new OooO00o(app, this.OooO0oO, this.f31489OooO0o), new com.cloud.tmc.miniapp.bridge.OooO0O0(this.OooO0O0, this.f31489OooO0o));
            } catch (Throwable th2) {
                TmcLogger.h("MiniAppUpdateBridge", th2);
                this.OooO0O0.putBooleanValue("miniAppHasUpdateRequesting", false);
                f.a.a("errMsg", "AppInfo request failed, please try again later: MAU10004", this.f31489OooO0o);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements w.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f31491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JsonObject f31492b;

        public b(bc.a aVar, JsonObject jsonObject) {
            this.f31491a = aVar;
            this.f31492b = jsonObject;
        }

        @Override // w.b
        public void OooO00o() {
            bc.a aVar = this.f31491a;
            if (aVar != null) {
                aVar.g();
            }
        }

        @Override // w.b
        public void a(String errorMessage) {
            Intrinsics.g(errorMessage, "errorMessage");
            this.f31492b.addProperty("errMsg", errorMessage);
            bc.a aVar = this.f31491a;
            if (aVar != null) {
                aVar.e(this.f31492b);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestAppInfoFailed$default(MiniAppUpdateBridge miniAppUpdateBridge, BaseResponse baseResponse, App app, String str, long j11, Function0 function0, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            function0 = null;
        }
        miniAppUpdateBridge.OooO00o(baseResponse, app, str, j11, function0);
    }

    public final void OooO00o(BaseResponse<? extends Object> baseResponse, App app, String str, long j11, Function0<Unit> function0) {
        String appId = app.getAppId();
        Intrinsics.f(appId, "app.appId");
        OooO00o(appId, "server_api", false, str, j11, false);
        StringBuilder sbA = j.a("requestAppInfoFailed: ");
        sbA.append(baseResponse.getMessage());
        TmcLogger.c("MiniAppUpdateBridge", sbA.toString());
        if (baseResponse.getCode() == 30004) {
            try {
                FileUtil.f31012a.v(app.getAppId());
            } catch (Throwable th2) {
                TmcLogger.h("MiniAppUpdateBridge", th2);
            }
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void OooO00o(BaseResponse<AppInfoModel> baseResponse, App app, String str, long j11, boolean z11, Function0<Unit> function0, Function0<Unit> function1) {
        String appId;
        String appId2;
        AppInfoModel data = baseResponse.getData();
        if (data == null || (appId = data.getAppId()) == null || appId.length() == 0) {
            TmcLogger.c("MiniAppUpdateBridge", "requestAppInfoSuccess: appInfoModel or appId is null");
            OooO00o(new BaseResponse<>(0, null, null, null, 15, null), app, str, j11, function1);
            return;
        }
        String appId3 = app.getAppId();
        Intrinsics.f(appId3, "app.appId");
        OooO00o(appId3, "server_api", true, str, j11, false);
        AppModel appModelG = MiniAppLaunch.f31784a.G(data);
        appModelG.setDevMode(z11);
        tb.b appContext = app.getAppContext();
        Context context = appContext != null ? appContext.getContext() : null;
        if (context == null || (appId2 = app.getAppId()) == null) {
            return;
        }
        ((TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class)).updateAppModel(context, appModelG, appId2 + "_pre");
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void OooO00o(String str, String str2, boolean z11, String str3, long j11, boolean z12) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - j11;
            Bundle bundle = new Bundle();
            bundle.putString("request_channel", str2);
            bundle.putLong(TrackingKey.REQUEST_TIME, jCurrentTimeMillis);
            bundle.putBoolean("enable_cdn_request", z12);
            bundle.putString("request_token", str3);
            bundle.putBoolean("request_status", z11);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).recordForCommon(str, "miniapp_appinfo_network", bundle);
            TmcLogger.c("MiniAppUpdateBridge", "reportNetworkTrack->request_channel:" + str2 + ",request_time:" + jCurrentTimeMillis + ",enable_cdn_request:" + z12 + ",request_token:" + str3 + ",request_status:" + z11);
        } catch (Throwable th2) {
            TmcLogger.h("MiniAppUpdateBridge", th2);
        }
    }

    @zb.a("appUpdateApplyUpdate")
    @e(ExecutorType.UI)
    public final void applyUpdate(@f(App.class) App app, @c bc.a callback) {
        String appId;
        tb.b appContext;
        Intrinsics.g(callback, "callback");
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (app == null || context == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            f.a.a("errMsg", "Parameter error: MAU10001", callback);
            return;
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        String appId2 = app.getAppId();
        Intrinsics.f(appId2, "app.appId");
        if (!miniAppLaunch.U(context, appId2) || !(context instanceof com.cloud.tmc.miniapp.ui.OooO0OO)) {
            f.a.a("errMsg", "There is no latest applet package to upgrade: MAU10008", callback);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("miniAppId", app.getAppId());
        bundle.putString("mode", app.getStartParams().getString("mode"));
        bundle.putString("version", app.getStartParams().getString("version"));
        bundle.putString("sign", app.getStartParams().getString("sign"));
        Unit unit = Unit.f68710a;
        ((com.cloud.tmc.miniapp.ui.OooO0OO) context).j0(true, bundle);
        callback.g();
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a("appUpdateDownloadNew")
    @e(ExecutorType.NETWORK)
    public final void downloadNew(@f(App.class) App app, @c bc.a callback) {
        tb.b appContext;
        Intrinsics.g(callback, "callback");
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (app == null || context == null) {
            callback.b();
            return;
        }
        try {
            if (!app.getBooleanValue("miniAppHasUpdate")) {
                TmcLogger.c("MiniAppUpdateBridge", "has not app update");
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "There is no App update content, please use forceUpdateAppInfo to check first: MAU10005");
                callback.e(jsonObject);
                return;
            }
            AppModel appModelFromPre = ((TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class)).getAppModelFromPre(context, app.getAppId());
            if (appModelFromPre == null) {
                TmcLogger.c("MiniAppUpdateBridge", "appModelNew not found");
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", "There is no App update content, please use forceUpdateAppInfo to check first: MAU10005");
                callback.e(jsonObject2);
                return;
            }
            if (!NetworkUtils.r()) {
                TmcLogger.c("MiniAppUpdateBridge", "network is not connect");
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("errMsg", "The network is abnormal, please check the network: MAU10003");
                callback.e(jsonObject3);
                return;
            }
            if (app.getBooleanValue("miniAppHasUpdateDownloading")) {
                TmcLogger.c("MiniAppUpdateBridge", "miniapp package downloading");
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.addProperty("errMsg", "Downloading, please try later: MAU10006");
                callback.e(jsonObject4);
                return;
            }
            if (((TmcResourceManager) tc.a.a(TmcResourceManager.class)).isDownloaded(context, appModelFromPre)) {
                callback.g();
            } else {
                app.putBooleanValue("miniAppHasUpdateDownloading", true);
                MiniAppLaunch.f31784a.j(context, appModelFromPre, 3, (32 & 8) != 0 ? null : new OooO0O0(app, callback), (32 & 16) != 0 ? null : new OooO0OO(app, callback), (32 & 32) != 0 ? null : null);
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniAppUpdateBridge", th2);
            callback.b();
        }
    }

    @zb.a("appUpdateForceUpdateAppInfo")
    @e(ExecutorType.NETWORK)
    public final void forceUpdateAppInfo(@f(App.class) App app, @c bc.a callback) {
        tb.b appContext;
        Intrinsics.g(callback, "callback");
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (app == null || context == null) {
            f.a.a("errMsg", "Parameter error: MAU10001", callback);
            return;
        }
        try {
            String str = System.currentTimeMillis() + '_' + app.getAppId() + '_' + Math.random();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String string = app.getStartParams().getString("mode");
            if (string == null) {
                string = "";
            }
            boolean z11 = l.v("debug", string, true) || l.v("dev", string, true);
            if (!NetworkUtils.r()) {
                TmcLogger.c("MiniAppUpdateBridge", "network is not connect");
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "The network is abnormal, please check the network: MAU10003");
                callback.e(jsonObject);
                return;
            }
            if (!app.getBooleanValue("miniAppHasUpdateRequesting")) {
                app.putBooleanValue("miniAppHasUpdateRequesting", true);
                MiniRequestUtils.c(app, new OooO0o(app, str, jCurrentTimeMillis, z11, callback, context), new OooO(app, str, jCurrentTimeMillis, callback));
            } else {
                TmcLogger.c("MiniAppUpdateBridge", "appInfo requesting");
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", "Requesting, please try later: MAU10002");
                callback.e(jsonObject2);
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniAppUpdateBridge", th2);
            callback.b();
        }
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void loadSubPackage(@f(App.class) App app, @g({"root"}) String str, @c bc.a aVar) {
        Intrinsics.g(app, "app");
        try {
            tb.b appContext = app.getAppContext();
            Context context = appContext != null ? appContext.getContext() : null;
            String appId = app.getAppId();
            JsonObject jsonObject = new JsonObject();
            if (str != null && str.length() != 0 && context != null && appId != null && appId.length() != 0) {
                Intrinsics.f(appId, "appId");
                Bundle startParams = app.getStartParams();
                Intrinsics.f(startParams, "app.startParams");
                Bundle sceneParams = app.getSceneParams();
                Intrinsics.f(sceneParams, "app.sceneParams");
                o00Ooo.c(appId, str, startParams, sceneParams, context, new b(aVar, jsonObject));
                return;
            }
            jsonObject.addProperty("errMsg", "param is invalid: 10001");
            if (aVar != null) {
                aVar.e(jsonObject);
            }
        } catch (Throwable th2) {
            TmcLogger.h("AppBridge", th2);
        }
    }

    @zb.a("appUpdateOnCheckForUpdate")
    @e(ExecutorType.UI)
    public final void onCheckForUpdate(@f(App.class) App app, @c bc.a callback) {
        String appId;
        Intrinsics.g(callback, "callback");
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            f.a.a("errMsg", "Parameter error: MAU10001", callback);
        } else {
            ((MiniAppUpdateMessageStore) app.getData(MiniAppUpdateMessageStore.class, true)).getOnCheckForUpdate().put(app.getAppId(), callback);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("MiniAppUpdateBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("MiniAppUpdateBridge", "onInitialized");
    }

    @zb.a("appUpdateOnUpdateFailed")
    @e(ExecutorType.UI)
    public final void onUpdateFailed(@f(App.class) App app, @c bc.a callback) {
        String appId;
        Intrinsics.g(callback, "callback");
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            f.a.a("errMsg", "Parameter error: MAU10001", callback);
        } else {
            ((MiniAppUpdateMessageStore) app.getData(MiniAppUpdateMessageStore.class, true)).getOnUpdateFailed().put(app.getAppId(), callback);
        }
    }

    @zb.a("appUpdateOnUpdateReady")
    @e(ExecutorType.UI)
    public final void onUpdateReady(@f(App.class) App app, @c bc.a callback) {
        String appId;
        Intrinsics.g(callback, "callback");
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            f.a.a("errMsg", "Parameter error: MAU10001", callback);
        } else {
            ((MiniAppUpdateMessageStore) app.getData(MiniAppUpdateMessageStore.class, true)).getOnUpdateReady().put(app.getAppId(), callback);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void preStrategy(@f(App.class) App app, @g({"preList"}) String str, @g({"scene"}) String str2, @c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        Context context = appContext != null ? appContext.getContext() : null;
        if (context == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            Object objD = k.d(str, List.class);
            List<String> arrayList = objD instanceof List ? (List) objD : null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            PreStrategyManager.f31651a.b(context, arrayList, str2);
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniAppUpdateBridge", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
