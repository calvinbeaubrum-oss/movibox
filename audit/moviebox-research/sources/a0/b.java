package a0;

import android.os.Bundle;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.StepType;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.offline.download.OfflineManager;
import com.mbridge.msdk.MBridgeConstans;
import db.f;
import lb.g;
import xa.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends com.cloud.tmc.miniapp.prepare.steps.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final StepType f353h = StepType.OFFLINE;

    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, g gVar, c0 c0Var) throws PrepareException {
        if (!gVar.r()) {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            com.cloud.tmc.miniapp.prepare.steps.b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31211g, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31213h, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.A, new Bundle());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.B, new Bundle());
            new k(new Bundle()).f(gVar.b());
            new f(new Bundle()).f(gVar.b());
            if (gVar.a() != null) {
                OffScreenWebviewPool.f30871a.l(gVar.a(), this, gVar);
            }
        }
        try {
            OfflineManager.t(gVar.c(), !OfflineManager.k(gVar.c()));
        } catch (Throwable th2) {
            TmcLogger.h(this.f31599a, th2);
        }
        if ("2".equals(gVar.j())) {
            AppModel appModelE = gVar.e();
            if (appModelE != null) {
                appModelE.setDevMode(2);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle2);
            }
            prepareController.moveToNext();
            return;
        }
        if (!h.f31061a.l(gVar.e())) {
            super.a(prepareController, gVar, c0Var);
            d(prepareController, gVar, c0Var);
            TmcLogger.c(this.f31599a, "Step_Download");
        } else {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle3);
            }
            prepareController.moveToNext();
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return f353h;
    }

    public abstract void d(PrepareController prepareController, g gVar, c0 c0Var);
}
