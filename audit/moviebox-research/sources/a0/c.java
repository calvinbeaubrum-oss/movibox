package a0;

import android.os.Bundle;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.offlineapps.ScanScene;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.StepType;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prepare.steps.i;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.mbridge.msdk.MBridgeConstans;
import db.q;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import lb.f;
import lb.g;
import p.d;
import xa.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends com.cloud.tmc.miniapp.prepare.steps.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final StepType f354h = StepType.START;

    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, g gVar, c0 c0Var) throws PrepareException {
        f fVarE;
        if (!gVar.r()) {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            com.cloud.tmc.miniapp.prepare.steps.b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31217j, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31219k, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.D, new Bundle());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.E, new Bundle());
            new o(new Bundle()).f(gVar.b());
            new q(new Bundle()).f(gVar.b());
            if (gVar.a() != null) {
                OffScreenWebviewPool.f30871a.l(gVar.a(), this, gVar);
            }
        }
        super.a(prepareController, gVar, c0Var);
        if (h.f31061a.l(gVar.e())) {
            p.e(this.f31599a, "startStep 创建minishell app config");
            try {
                AppModel appModelE = gVar.e();
                this.f31600b.updateAppModel(gVar.p(), appModelE, appModelE.getAppId() + "_used");
                if (appModelE.getPermissions() != null) {
                    try {
                        ((AuthenticationProxy) tc.a.a(AuthenticationProxy.class)).setPermissionModel(appModelE.getAppId(), appModelE.getPermissions());
                    } catch (Throwable unused) {
                    }
                }
                AppLoadResult appLoadResult = new AppLoadResult();
                MiniAppConfigModel miniAppConfigModel = new MiniAppConfigModel();
                miniAppConfigModel.launchParams = new HashMap<>();
                ArrayList arrayList = new ArrayList();
                arrayList.add(appModelE.getExtend().getH5Url());
                miniAppConfigModel.pages = arrayList;
                appLoadResult.appConfigModel = miniAppConfigModel;
                appLoadResult.appType = "WEB_TINY";
                appLoadResult.appVersion = MiniAppLaunch.f31784a.O(appModelE);
                AppModel appModel = new AppModel();
                appModel.setAppId("100000");
                appModel.setDeployVersion("0.0.0");
                appModel.setDeveloper("0");
                appModel.setPackageSize("0");
                appModel.setPackageUrl("");
                appModel.setPackageUrl_MD5("");
                appLoadResult.frameWorkModel = appModel;
                appLoadResult.frameworkConfigModel = miniAppConfigModel;
                appLoadResult.htmlMap = new HashMap<>();
                appLoadResult.mainHtmlUrl = appModelE.getExtend().getH5Url();
                fVarE = new f(gVar);
                fVarE.f70183d = appLoadResult;
            } catch (Throwable unused2) {
                fVarE = null;
            }
        } else {
            fVarE = e(prepareController, gVar, c0Var);
        }
        if (fVarE == null) {
            i.a(PrepareException.ERROR_MANIFEST_INFO, "create PrepareCallbackParam fail", prepareController);
            return;
        }
        if (!gVar.r()) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            com.cloud.tmc.miniapp.prepare.steps.b.a(gVar, "uniqueChainID", "-1", bundle2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31219k, bundle2);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.E, new Bundle());
            new xa.q(new Bundle()).f(gVar.b());
        }
        d(prepareController, gVar, c0Var, fVarE);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return f354h;
    }

    public void d(PrepareController prepareController, g gVar, c0 c0Var, f fVar) {
        if (gVar.n()) {
            c0Var.l(fVar, prepareController);
        } else {
            c0Var.k(fVar, prepareController);
            try {
                if (gVar.e() != null && gVar.e().getLogo() != null) {
                    ((OfflineAppProxy) tc.a.a(OfflineAppProxy.class)).downloadIcon(gVar.c(), gVar.e().getLogo());
                }
                ScanScene scanScene = ScanScene.SCAN_OPEN_APP;
                Intrinsics.g(scanScene, "scanScene");
                d.f73467a.g(false, scanScene, null);
            } catch (Throwable unused) {
            }
        }
        prepareController.finish();
    }

    public abstract f e(PrepareController prepareController, g gVar, c0 c0Var);
}
