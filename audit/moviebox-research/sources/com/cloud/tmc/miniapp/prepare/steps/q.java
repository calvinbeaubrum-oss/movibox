package com.cloud.tmc.miniapp.prepare.steps;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.mbridge.msdk.MBridgeConstans;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class q extends a {
    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, lb.g gVar, c0 c0Var) throws PrepareException {
        if (!gVar.r()) {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31209f, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31211g, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31238z, new Bundle());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.A, new Bundle());
            new xa.j(new Bundle()).f(gVar.b());
            new db.k(new Bundle()).f(gVar.b());
        }
        if (com.cloud.tmc.integration.utils.h.f31061a.l(gVar.e())) {
            prepareController.moveToNext();
            return;
        }
        super.a(prepareController, gVar, c0Var);
        AppModel appModelL = gVar.l();
        this.f31600b.updateAppModel(gVar.p(), appModelL, appModelL.getAppId() + "_used");
        if (this.f31600b.getPreUnzipStatus(gVar.p(), appModelL.getAppId())) {
            ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(appModelL.getAppId(), "preunzip");
            this.f31600b.updatePreUnzipStatus(gVar.p(), appModelL.getAppId(), false);
        }
        TmcLogger.c(this.f31599a, "Step_FW_LoadStep: manifest 内容校验成功");
        if (!AppDynamicBuildConfig.k()) {
            ((IPackageConfig) tc.a.a(IPackageConfig.class)).setFrameworkVersion(MiniAppLaunch.f31784a.O(appModelL));
        } else if (!TextUtils.isEmpty(appModelL.getDeveloperVersion())) {
            ((IPackageConfig) tc.a.a(IPackageConfig.class)).setFrameworkVersion(appModelL.getDeveloperVersion());
        } else if (!TextUtils.isEmpty(appModelL.getDeployVersion())) {
            ((IPackageConfig) tc.a.a(IPackageConfig.class)).setFrameworkVersion(appModelL.getDeployVersion());
        }
        prepareController.moveToNext();
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.FW_START;
    }
}
