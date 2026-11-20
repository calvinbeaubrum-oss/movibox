package e0;

import android.os.Bundle;
import android.view.View;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.render.system.SystemWebView;
import p010OooOooo.o0000;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u implements uc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o0000 f63614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ uc.b f63615b;

    public u(o0000 o0000Var, uc.b bVar) {
        this.f63614a = o0000Var;
        this.f63615b = bVar;
    }

    @Override // uc.c
    public boolean O(uc.a aVar) {
        fe.f webviewBridgeHelper;
        zc.i render;
        App app;
        String appId;
        App app2;
        App app3;
        App app4;
        App app5;
        Bundle startParams;
        zc.i render2;
        Page page = this.f63614a.f30954a;
        if (!kotlin.text.l.w((page == null || (render2 = page.getRender()) == null) ? null : render2.b(), aVar != null ? aVar.b() : null, false, 2, null)) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
        String str = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
        Page page2 = this.f63614a.f30954a;
        bundle.putString(str, String.valueOf((page2 == null || (app5 = page2.getApp()) == null || (startParams = app5.getStartParams()) == null) ? null : startParams.getString("uniqueChainID", "-1")));
        String str2 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
        Page page3 = this.f63614a.f30954a;
        bundle.putString(str2, String.valueOf(page3 != null ? page3.getPagePath() : null));
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Page page4 = this.f63614a.f30954a;
        performanceAnalyseProxy.record((page4 == null || (app4 = page4.getApp()) == null) ? null : app4.getAppId(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31223m, bundle);
        Bundle bundle2 = new Bundle();
        o0000 o0000Var = this.f63614a;
        String str3 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
        Page page5 = o0000Var.f30954a;
        bundle2.putString(str3, String.valueOf(page5 != null ? page5.getPagePath() : null));
        String str4 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
        Page page6 = o0000Var.f30954a;
        bundle2.putString(str4, String.valueOf(page6 != null ? page6.getPageId() : null));
        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Page page7 = this.f63614a.f30954a;
        performanceAnalyseProxy2.record((page7 == null || (app3 = page7.getApp()) == null) ? null : app3.getAppId(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle2);
        PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Page page8 = this.f63614a.f30954a;
        performanceAnalyseProxy3.record((page8 == null || (app2 = page8.getApp()) == null) ? null : app2.getAppId(), PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle2);
        xa.l lVar = new xa.l(bundle2);
        Page page9 = this.f63614a.f30954a;
        lVar.f(page9 != null ? page9.getPageChainContext() : null);
        Page page10 = this.f63614a.f30954a;
        if (page10 != null && (app = page10.getApp()) != null && (appId = app.getAppId()) != null) {
            ((IUpdateLoadingStepProxy) tc.a.a(IUpdateLoadingStepProxy.class)).notifyUpdateLoadingStep(appId, LoadStepAction.STEP_FINISH_LOAD_RENDER);
        }
        Page page11 = this.f63614a.f30954a;
        View view = (page11 == null || (render = page11.getRender()) == null) ? null : render.getView();
        SystemWebView systemWebView = view instanceof SystemWebView ? (SystemWebView) view : null;
        if (systemWebView != null && (webviewBridgeHelper = systemWebView.getWebviewBridgeHelper()) != null) {
            webviewBridgeHelper.b();
        }
        this.f63614a.H1();
        uc.b bVar = this.f63615b;
        if (bVar != null) {
            bVar.c("renderOnMessageReady", this);
        }
        return true;
    }
}
