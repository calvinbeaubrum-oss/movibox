package com.cloud.tmc.miniapp.prepare.steps;

import android.os.Bundle;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.mbridge.msdk.MBridgeConstans;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class x extends a {
    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, lb.g gVar, c0 c0Var) throws PrepareException {
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String strC = gVar.c();
        PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_END;
        performanceAnalyseProxy.record(strC, pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31203c, bundle);
        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String strC2 = gVar.c();
        PointAnalyseType pointAnalyseType2 = PointAnalyseType.POINT_APP_CHAIN_END;
        performanceAnalyseProxy2.record(strC2, pointAnalyseType2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31235w, new Bundle());
        new xa.r(bundle).f(gVar.b());
        PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String strC3 = gVar.c();
        PointAnalyseType pointAnalyseType3 = PointAnalyseType.POINT_CHAIN_START;
        performanceAnalyseProxy3.record(strC3, pointAnalyseType3, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31205d, bundle);
        PerformanceAnalyseProxy performanceAnalyseProxy4 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String strC4 = gVar.c();
        PointAnalyseType pointAnalyseType4 = PointAnalyseType.POINT_APP_CHAIN_START;
        performanceAnalyseProxy4.record(strC4, pointAnalyseType4, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31236x, new Bundle());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31205d, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31236x, new Bundle());
        new db.i(bundle).f(gVar.b());
        new xa.i(bundle).f(gVar.b());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType3, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31207e, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType4, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31237y, new Bundle());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31207e, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31237y, new Bundle());
        new db.h(bundle).f(gVar.b());
        new xa.h(bundle).f(gVar.b());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType3, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31209f, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType4, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31238z, new Bundle());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31209f, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31238z, new Bundle());
        new db.j(bundle).f(gVar.b());
        new xa.j(bundle).f(gVar.b());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType3, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31211g, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType4, com.cloud.tmc.kernel.proxy.performanceanalyse.a.A, new Bundle());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31211g, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.A, new Bundle());
        new db.k(bundle).f(gVar.b());
        new xa.k(bundle).f(gVar.b());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType3, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31213h, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType4, com.cloud.tmc.kernel.proxy.performanceanalyse.a.B, new Bundle());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31213h, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.B, new Bundle());
        new db.f(bundle).f(gVar.b());
        new xa.f(bundle).f(gVar.b());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType3, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31215i, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType4, com.cloud.tmc.kernel.proxy.performanceanalyse.a.C, new Bundle());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31215i, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.C, new Bundle());
        new db.m(bundle).f(gVar.b());
        new xa.m(bundle).f(gVar.b());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType3, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31217j, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType4, com.cloud.tmc.kernel.proxy.performanceanalyse.a.D, new Bundle());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31217j, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.D, new Bundle());
        new db.o(bundle).f(gVar.b());
        new xa.o(bundle).f(gVar.b());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType3, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31219k, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType4, com.cloud.tmc.kernel.proxy.performanceanalyse.a.E, new Bundle());
        new db.q(bundle).f(gVar.b());
        super.a(prepareController, gVar, c0Var);
        AppLoadResult appLoadResult = new AppLoadResult();
        appLoadResult.appVersion = MiniAppLaunch.f31784a.O(gVar.e());
        appLoadResult.mainHtmlUrl = "https://100000.miniapp.transsion.com/index.html";
        appLoadResult.appType = "WEB_TINY";
        lb.f fVar = new lb.f(gVar);
        fVar.f70183d = appLoadResult;
        new lb.f(gVar).f70183d = appLoadResult;
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31219k, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.E, new Bundle());
        new xa.q(bundle).f(gVar.b());
        c0Var.k(fVar, prepareController);
        prepareController.finish();
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.START;
    }
}
