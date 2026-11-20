package com.cloud.tmc.miniapp.prepare.steps;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.transsion.push.PushConstants;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import p011Oooo00o.o00Ooo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UpdateStep extends a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BaseResponse<?> f31584l;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f31580h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f31581i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f31582j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f31583k = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f31585m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f31586n = 0;

    public static /* synthetic */ Unit d(lb.g gVar, AppModel appModel, String str, String str2) {
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.putData("mpu_download_type", "async"), "mpu_appId", "mpu_old_v", str).putData("mpu_new_v", str2).putData("mpu_result", "IOException").putData("mpu_error_code", "D006").putData("mpu_error_msg", "Canceled"), "mpu_chain_uniqueId"), "");
        return null;
    }

    public static /* synthetic */ Unit e(lb.g gVar, AppModel appModel, String str, String str2, c0 c0Var) {
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.putData("mpu_download_type", "async"), "mpu_appId", "mpu_old_v", str).putData("mpu_new_v", str2), "mpu_chain_uniqueId"), "");
        c0Var.g(appModel, true);
        return null;
    }

    public static /* synthetic */ Unit f(lb.g gVar, AppModel appModel, String str, String str2, c0 c0Var, String str3, String str4, IOException iOException) {
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_FAILED.putData("mpu_download_type", "async"), "mpu_appId", "mpu_old_v", str).putData("mpu_new_v", str2).putData("mpu_result", iOException.getClass().getSimpleName()).putData("mpu_error_code", str3).putData("mpu_error_msg", iOException.getMessage()), "mpu_chain_uniqueId"), "");
        c0Var.g(appModel, false);
        return null;
    }

    public static void i(UpdateStep updateStep, BaseResponse baseResponse, c0 c0Var, PrepareController prepareController, lb.g gVar, String str, AppModel appModel, String str2, Map map) {
        synchronized (updateStep) {
            try {
                if (updateStep.f31581i) {
                    TmcLogger.c(updateStep.f31599a, "return  " + str2);
                } else {
                    updateStep.f31581i = true;
                    updateStep.k(gVar.c(), str2, true, map);
                    AppInfoModel appInfoModel = (AppInfoModel) baseResponse.getData();
                    if (TextUtils.isEmpty(appInfoModel.getAppId())) {
                        updateStep.g(new BaseResponse<>(), prepareController, appModel, gVar, str, str2, map);
                    } else {
                        c0Var.d(appInfoModel.getName(), appInfoModel.getLogo());
                        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
                        if (miniAppLaunch.w(appInfoModel.getLowestSupportVersion())) {
                            updateStep.j(str, appInfoModel, c0Var, gVar);
                            if (updateStep.f31580h) {
                                if ("cdn".equals(str2) && !gVar.r()) {
                                    ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(str, "cdn");
                                }
                                prepareController.unlock(prepareController);
                            }
                            TmcLogger.c(updateStep.f31599a, "Step_UPDATE_数据更新成功");
                            if (updateStep.f31580h) {
                                c0Var.i(LoadStepAction.STEP_UPDATE_APP_INFO);
                                prepareController.moveToNext();
                            }
                            return;
                        }
                        updateStep.f31580h = true;
                        prepareController.lock(prepareController);
                        TmcLogger.c(updateStep.f31599a, "showFwUpdateTipsDialog->" + str);
                        miniAppLaunch.h0(gVar.p(), str, c0Var);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x01f1  */
    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, lb.g gVar, c0 c0Var) throws PrepareException {
        boolean z11;
        int i11;
        if (!gVar.r()) {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31201b, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31203c, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31234v, new Bundle());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31235w, new Bundle());
            new xa.b(new Bundle()).f(gVar.b());
            new db.r(new Bundle()).f(gVar.b());
            if (gVar.a() != null) {
                OffScreenWebviewPool.f30871a.l(gVar.a(), this, gVar);
            }
        }
        super.a(prepareController, gVar, c0Var);
        this.f31581i = false;
        TmcLogger.c(this.f31599a, "Step_UPDATE");
        String strC = gVar.c();
        if ("2".equals(gVar.j())) {
            AppModel appModel = new AppModel();
            try {
                appModel.setAppId(strC);
                String str = ((PathProxy) tc.a.a(PathProxy.class)).getIDEDevelopPath(appModel) + "/appInfo.json";
                if (str != null) {
                    appModel = MiniAppLaunch.f31784a.G((AppInfoModel) com.cloud.tmc.integration.utils.a0.f31025a.a(this.f31603e.readFile2String(str), AppInfoModel.class));
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.f31599a, th2);
                appModel = null;
            }
            if (appModel == null) {
                prepareController.moveToError(new PrepareException("develop appModel is null"));
                return;
            }
            appModel.setDevMode(2);
            gVar.u(appModel);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Z, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle2);
            }
            prepareController.moveToNext();
            return;
        }
        if (gVar.i()) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Z, 2);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle3);
            }
            this.f31580h = true;
            prepareController.lock(prepareController);
            h(prepareController, gVar, c0Var, null, strC);
            return;
        }
        long lastUpdateTime = strC != null ? this.f31600b.getLastUpdateTime(gVar.p(), strC) : 0L;
        TmcLogger.c(this.f31599a, "Step_UPDATE_获取最近的更新时间:" + lastUpdateTime);
        long jCurrentTimeMillis = System.currentTimeMillis();
        AppModel appModelE = gVar.e();
        if (appModelE == null) {
            this.f31580h = true;
        } else {
            c0Var.i(LoadStepAction.STEP_UPDATE_APP_INFO);
        }
        String str2 = this.f31599a;
        StringBuilder sbA = hd.j.a("Step_UPDATE enableLock 状态");
        sbA.append(this.f31580h);
        TmcLogger.c(str2, sbA.toString());
        int configInt = ((ConfigService) tc.a.a(ConfigService.class)).getConfigInt("appinfoRefreshInterval", 3600) * 1000;
        if (appModelE == null || !MiniAppLaunch.f31784a.t(appModelE, 1)) {
            z11 = false;
        } else {
            TmcLogger.c(this.f31599a, "UpdateStep_需强制更新");
            if (NetworkUtils.r()) {
                this.f31580h = true;
                z11 = true;
            } else {
                z11 = false;
            }
        }
        if (appModelE != null && !z11 && jCurrentTimeMillis - lastUpdateTime <= configInt && lastUpdateTime != 0) {
            StringBuilder sbA2 = hd.j.a("Step_UPDATE_数据在有效期内，appVersion：");
            sbA2.append(appModelE.getDeployVersion());
            TmcLogger.c("Subpackage::", sbA2.toString());
            TmcLogger.c(this.f31599a, "Step_UPDATE_数据在有效期内");
            Bundle bundle4 = new Bundle();
            bundle4.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Z, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle4);
            }
            prepareController.moveToNext();
            return;
        }
        TmcLogger.c(this.f31599a, "Step_UPDATE_过期了:更新下");
        Bundle bundle5 = new Bundle();
        if (this.f31580h) {
            TmcLogger.c(this.f31599a, "Step_UPDATE: LOCK");
            prepareController.lock(prepareController);
            i11 = 2;
        } else {
            i11 = 1;
        }
        bundle5.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Z, i11);
        if (!gVar.r()) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle5);
        }
        if (NetworkUtils.r()) {
            TmcLogger.c(this.f31599a, "Step_UPDATE: Network");
            if (gVar.p() == null || strC == null) {
                MiniAppLaunch.f31784a.e0(strC, "1");
                c0Var.b();
            } else {
                if (this.f31580h && gVar.n()) {
                    c0Var.OooO00o(true);
                }
                String str3 = this.f31599a;
                StringBuilder sbA3 = hd.j.a("Step_UPDATE ->是否同步加载");
                sbA3.append(this.f31580h);
                TmcLogger.c(str3, sbA3.toString());
                h(prepareController, gVar, c0Var, appModelE, strC);
            }
        } else if (this.f31580h) {
            i.a("3", MBridgeError.ERROR_MESSAGE_DOWNLOAD_NETWORK_ERROR, prepareController);
            return;
        }
        if (this.f31580h) {
            return;
        }
        prepareController.moveToNext();
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.UPDATE;
    }

    public final synchronized void g(@NonNull BaseResponse<?> baseResponse, PrepareController prepareController, AppModel appModel, lb.g gVar, String str, String str2, Map<String, String> map) {
        if (this.f31581i) {
            return;
        }
        if (this.f31582j) {
            TmcLogger.c(this.f31599a, "Step_UPDATE_requestAppInfoFailed->" + str + str2);
            int i11 = this.f31583k + 1;
            this.f31583k = i11;
            if (i11 < 2) {
                if ("server".equals(str2)) {
                    this.f31584l = baseResponse;
                }
                return;
            } else {
                BaseResponse<?> baseResponse2 = this.f31584l;
                if (baseResponse2 != null) {
                    this.f31583k = 0;
                    baseResponse = baseResponse2;
                }
            }
        }
        k(gVar.c(), str2, false, map);
        String str3 = this.f31599a;
        StringBuilder sbA = hd.j.a("Step_UPDATE_数据更新失败");
        sbA.append(baseResponse.getMessage());
        TmcLogger.c(str3, sbA.toString());
        if (this.f31580h) {
            prepareController.unlock(prepareController);
        }
        if (appModel == null) {
            prepareController.moveToError(MiniAppLaunch.m0(gVar.c(), baseResponse.getCode(), baseResponse.getMessage()));
        } else {
            if (baseResponse.getCode() == 30004) {
                if (prepareController != null) {
                    try {
                        prepareController.moveToError(MiniAppLaunch.m0(str, TAdErrorCode.CODE_MATERIEL_OBTAIN_FAILED, ""));
                    } catch (Throwable th2) {
                        TmcLogger.h(this.f31599a, th2);
                    }
                }
                FileUtil.f31012a.v(str);
                return;
            }
            if (this.f31580h) {
                prepareController.moveToNext();
            }
        }
    }

    public final void h(final PrepareController prepareController, final lb.g gVar, final c0 c0Var, final AppModel appModel, final String str) {
        String str2;
        boolean zI = gVar.i();
        try {
            this.f31585m = System.currentTimeMillis() + "_" + str + "_" + Math.random();
            this.f31586n = System.currentTimeMillis();
        } catch (Throwable th2) {
            TmcLogger.h(this.f31599a, th2);
        }
        if (!zI) {
            try {
                boolean zQ = MiniAppLaunch.f31784a.q(gVar.p());
                this.f31582j = zQ;
                if (zQ) {
                    l(prepareController, gVar, c0Var, appModel, str);
                }
            } catch (Throwable th3) {
                TmcLogger.h(this.f31599a, th3);
            }
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("requestChannel", "server");
        boolean zI2 = gVar.i();
        map.put(PushConstants.PROVIDER_FIELD_APP_ID, str);
        map.put("needClassification", "1");
        String strC = mb.d.c();
        String strD = com.cloud.tmc.integration.utils.q.d();
        if (!TextUtils.isEmpty(strD)) {
            map2.put("gaid", strD);
        }
        if (zI2) {
            map.put("version", gVar.g());
            map.put("typeCode", gVar.j());
            String strB = mb.d.b();
            if (!TextUtils.isEmpty(gVar.f())) {
                map2.put("miniapp-token", gVar.f());
            }
            str2 = strB;
        } else {
            str2 = strC;
        }
        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).postJson(str2, map2, null, map, Boolean.TRUE, new mb.c<AppInfoModel>() { // from class: com.cloud.tmc.miniapp.prepare.steps.UpdateStep.2
            @Override // mb.c
            @NonNull
            public Type d() {
                return new TypeToken<BaseResponse<AppInfoModel>>(this) { // from class: com.cloud.tmc.miniapp.prepare.steps.UpdateStep.2.1
                }.getType();
            }

            @Override // mb.c
            public void e(@NonNull BaseResponse<?> baseResponse, @Nullable Map<String, String> map3) {
                TmcLogger.c(UpdateStep.this.f31599a, "Step_UPDATE_server failed");
                UpdateStep.this.g(baseResponse, prepareController, appModel, gVar, str, "server", map3);
            }

            @Override // mb.c
            public void g(@NonNull BaseResponse<? extends AppInfoModel> baseResponse, @Nullable Map<String, String> map3) {
                TmcLogger.c(UpdateStep.this.f31599a, "Step_UPDATE_server success");
                UpdateStep.i(UpdateStep.this, baseResponse, c0Var, prepareController, gVar, str, appModel, "server", map3);
            }
        });
    }

    public final void j(String str, AppInfoModel appInfoModel, final c0 c0Var, final lb.g gVar) {
        TmcAppInfoManager tmcAppInfoManager;
        if (this.f31580h) {
            EntryInfo entryInfoH = MiniAppLaunch.f31784a.H(appInfoModel);
            c0Var.h(entryInfoH);
            gVar.z(entryInfoH);
        }
        final AppModel appModelG = MiniAppLaunch.f31784a.G(appInfoModel);
        appModelG.setDevMode(gVar.i());
        this.f31600b.updateAppModel(gVar.p(), appModelG, str + "_pre");
        this.f31600b.refreshUpdateTime(gVar.p(), str, System.currentTimeMillis());
        c0Var.e(appModelG);
        if (this.f31580h) {
            TmcLogger.c(this.f31599a, "appmodel 同步更新成功");
            TmcLogger.c("Subpackage::", "UpdateStep，enableLocked，currentAppVersion:" + appModelG.getDeployVersion());
            gVar.u(appModelG);
            return;
        }
        try {
            if (MiniAppConfigHelper.f30370a.b("enableAppinfoDownload", true) && ((tmcAppInfoManager = this.f31600b) == null || tmcAppInfoManager.getAppModelFromUsed(gVar.p(), str) == null)) {
                TmcLogger.c(this.f31599a, "no native used version,not background download");
                return;
            }
        } catch (Throwable unused) {
        }
        TmcLogger.c(this.f31599a, "Step_appinfo_UPDATE_后台下载新的 appinfo 包");
        Context contextP = gVar.p();
        try {
            if (this.f31601c.isDownloaded(contextP, appModelG)) {
                return;
            }
            if (o00Ooo.e(appModelG) && this.f31601c.isDownloaded(contextP, appModelG.getAppId(), appModelG.getMainPackageUrlEncryption())) {
                return;
            }
        } catch (Throwable th2) {
            TmcLogger.g("UpdateStep", "", th2);
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        final String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c()));
        final String strO2 = miniAppLaunch.O(appModelG);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModelG, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_START.putData("mpu_download_type", "async"), "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2), "mpu_chain_uniqueId"), "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UpdateStep:backgroundDownload:appInfo:appId:");
        StringBuilder sbA = x.a.a(appModelG, sb2, ";deployVersion:");
        sbA.append(appModelG.getDeployVersion());
        sbA.append(";mainPkgUrl:");
        sbA.append(appModelG.getMainPackageUrl());
        TmcLogger.c("Subpackage::", sbA.toString());
        miniAppLaunch.j(gVar.p().getApplicationContext(), appModelG, 1, new Function0() { // from class: com.cloud.tmc.miniapp.prepare.steps.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateStep.e(gVar, appModelG, strO, strO2, c0Var);
            }
        }, new Function3() { // from class: com.cloud.tmc.miniapp.prepare.steps.u
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return UpdateStep.f(gVar, appModelG, strO, strO2, c0Var, (String) obj, (String) obj2, (IOException) obj3);
            }
        }, new Function0() { // from class: com.cloud.tmc.miniapp.prepare.steps.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateStep.d(gVar, appModelG, strO, strO2);
            }
        });
    }

    public final void k(String str, String str2, boolean z11, Map<String, String> map) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f31586n;
            Bundle bundle = new Bundle();
            bundle.putString("request_channel", str2);
            bundle.putLong(TrackingKey.REQUEST_TIME, jCurrentTimeMillis);
            bundle.putBoolean("enable_cdn_request", this.f31582j);
            bundle.putString("request_token", this.f31585m);
            bundle.putBoolean("request_status", z11);
            if (map != null) {
                String str3 = map.get("x-request-cdn");
                String str4 = map.get("x-cache");
                String str5 = map.get("x-llid");
                bundle.putString("x-request-cdn", str3);
                bundle.putString("x-cache", str4);
                bundle.putString("x-llid", str5);
                TmcLogger.c(this.f31599a, "reportNetworkTrack->x-request-cdn:" + str3 + ",X-Cache:" + str4 + ",X-LLID:" + str5);
            }
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).recordForCommon(str, "miniapp_appinfo_network", bundle);
            TmcLogger.c(this.f31599a, "reportNetworkTrack->request_channel:" + str2 + ",request_time:" + jCurrentTimeMillis + ",enable_cdn_request:" + this.f31582j + ",request_token:" + this.f31585m + ",request_status:" + z11);
        } catch (Throwable th2) {
            TmcLogger.h(this.f31599a, th2);
        }
    }

    public final void l(final PrepareController prepareController, final lb.g gVar, final c0 c0Var, final AppModel appModel, final String str) {
        TmcLogger.c(this.f31599a, "Step_UPDATE_通过CDN拉取 appinfo->" + str);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("requestChannel", "cdn");
        map2.put("X-Ldebug", "1");
        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).get(MiniAppLaunch.f31784a.I(str), map2, map, Boolean.FALSE, new mb.c<AppInfoModel>() { // from class: com.cloud.tmc.miniapp.prepare.steps.UpdateStep.1
            @Override // mb.c
            @NonNull
            public Type d() {
                return new TypeToken<BaseResponse<AppInfoModel>>(this) { // from class: com.cloud.tmc.miniapp.prepare.steps.UpdateStep.1.1
                }.getType();
            }

            @Override // mb.c
            public void e(@NonNull BaseResponse<?> baseResponse, @Nullable Map<String, String> map3) {
                TmcLogger.c(UpdateStep.this.f31599a, "Step_UPDATE_cdn failed");
                UpdateStep.this.g(baseResponse, prepareController, appModel, gVar, str, "cdn", map3);
            }

            @Override // mb.c
            public void g(@NonNull BaseResponse<? extends AppInfoModel> baseResponse, @Nullable Map<String, String> map3) {
                TmcLogger.c(UpdateStep.this.f31599a, "Step_UPDATE_cdn success");
                UpdateStep.i(UpdateStep.this, baseResponse, c0Var, prepareController, gVar, str, appModel, "cdn", map3);
            }
        });
    }
}
