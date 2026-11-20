package a0;

import android.os.Bundle;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.StepType;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.mbridge.msdk.MBridgeConstans;
import db.m;
import lb.g;
import xa.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.cloud.tmc.miniapp.prepare.steps.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final StepType f352h = StepType.LOAD;

    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, g gVar, c0 c0Var) throws PrepareException {
        if (!gVar.r()) {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            com.cloud.tmc.miniapp.prepare.steps.b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31213h, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31215i, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.B, new Bundle());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.C, new Bundle());
            new f(new Bundle()).f(gVar.b());
            new m(new Bundle()).f(gVar.b());
        }
        if ("2".equals(gVar.j())) {
            prepareController.moveToNext();
            return;
        }
        if (h.f31061a.l(gVar.e())) {
            prepareController.moveToNext();
            return;
        }
        super.a(prepareController, gVar, c0Var);
        prepareController.lock(prepareController);
        TmcLogger.c(this.f31599a, "Step_进度:LoadStep");
        d(prepareController, gVar, c0Var);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return f352h;
    }

    public abstract void d(PrepareController prepareController, g gVar, c0 c0Var);
}
