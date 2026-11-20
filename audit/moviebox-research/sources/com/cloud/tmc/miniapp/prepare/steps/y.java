package com.cloud.tmc.miniapp.prepare.steps;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.offline.download.OfflineManager;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class y extends a {
    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, lb.g gVar, c0 c0Var) throws PrepareException {
        if (!gVar.r()) {
            ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).resetPerformanceImproves(gVar.c());
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31199a, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31233u, new Bundle());
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Q, gVar.c());
            b.a(gVar, TrackingKey.SCENE_ID, "100000", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.S);
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T, "0");
            new db.p(bundle).f(gVar.b());
            OfflineManager.g0();
        }
        super.a(prepareController, gVar, c0Var);
        if (!gVar.r()) {
            ((IInnerRenderPool) tc.a.a(IInnerRenderPool.class)).createRender(false);
            ((IInnerWorkerPool) tc.a.a(IInnerWorkerPool.class)).createWorker(false);
        }
        try {
            TmcLogger.c(this.f31599a, "Step_SETUP");
            c0Var.i(LoadStepAction.STEP_START_LOADING);
            String strC = gVar.c();
            TmcLogger.c(this.f31599a, "Step_SETUP_获取APPID:" + strC);
            gVar.t(new lb.a(strC));
            TmcLogger.c(this.f31599a, "Step_SETUP_设置AppInfoQuery");
            try {
                OfflineManager.s(gVar.p().getPackageName());
            } catch (Throwable th2) {
                TmcLogger.g(this.f31599a, "", th2);
            }
            TmcLogger.c(this.f31599a, "Step_SETUP：获取 appmodel");
            if (gVar.i()) {
                TmcLogger.c(this.f31599a, "Step_SETUP：debug 模式");
                c0Var.OooO00o(true);
                prepareController.moveToNext();
                return;
            }
            AppModel appModelD = d(gVar);
            if (appModelD == null) {
                TmcLogger.c(this.f31599a, "Step_SETUP：appmodel 为空");
                c0Var.OooO00o(true);
                prepareController.moveToNext();
            } else {
                c0Var.d(appModelD.getName(), appModelD.getLogo());
                c0Var.OooO00o(true);
                e(gVar, c0Var, appModelD);
                prepareController.moveToNext();
            }
        } catch (Exception e11) {
            prepareController.moveToError(new PrepareException("1", e11.getMessage()));
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.SETUP;
    }

    @Nullable
    public final AppModel d(lb.g gVar) {
        AppModel appModel = this.f31600b.getAppModel(gVar.p(), gVar.d());
        if (appModel == null) {
            return null;
        }
        String str = this.f31599a;
        StringBuilder sbA = hd.j.a("Step_SETUP_获取AppModel");
        sbA.append(appModel.getFromCacheType());
        TmcLogger.c(str, sbA.toString());
        if (appModel.getFromCacheType() == 3 || appModel.getFromCacheType() == 5 || appModel.getFromCacheType() == 6) {
            MiniAppLaunch.f31784a.o(appModel);
        }
        gVar.u(appModel);
        return appModel;
    }

    public final void e(lb.g gVar, c0 c0Var, AppModel appModel) {
        EntryInfo entryInfo = new EntryInfo();
        entryInfo.appId = appModel.getAppId();
        entryInfo.desc = appModel.getDesc();
        entryInfo.iconUrl = appModel.getLogo();
        entryInfo.title = appModel.getName();
        entryInfo.desc = appModel.getDesc();
        entryInfo.slogan = appModel.getSlogan();
        entryInfo.developer = appModel.getDeveloper();
        c0Var.h(entryInfo);
        gVar.z(entryInfo);
    }
}
