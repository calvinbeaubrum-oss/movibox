package com.cloud.tmc.integration.bridge;

import com.cloud.tmc.integration.proxy.IRefreshProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PullRefreshBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void enableLoadMore(@cc.f(App.class) App app, @cc.g(name = {"enable"}) Boolean bool, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        TmcFragment tmcFragmentA = ((com.cloud.tmc.integration.structure.app.b) app.getAppContext()).k().a(app.getActivePage());
        if (tmcFragmentA == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            ((IRefreshProxy) tc.a.a(IRefreshProxy.class)).enableLoadMore(tmcFragmentA, bool.booleanValue());
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void enableRefresh(@cc.f(App.class) App app, @cc.g(name = {"enable"}) Boolean bool, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        TmcFragment tmcFragmentA = ((com.cloud.tmc.integration.structure.app.b) app.getAppContext()).k().a(app.getActivePage());
        if (tmcFragmentA == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            ((IRefreshProxy) tc.a.a(IRefreshProxy.class)).enableRefresh(tmcFragmentA, bool.booleanValue());
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("PullRefreshBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("PullRefreshBridge", "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void startPullDownRefresh(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        TmcFragment tmcFragmentA = ((com.cloud.tmc.integration.structure.app.b) app.getAppContext()).k().a(app.getActivePage());
        if (tmcFragmentA == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        boolean zStartPullDownRefresh = ((IRefreshProxy) tc.a.a(IRefreshProxy.class)).startPullDownRefresh(tmcFragmentA);
        if (aVar != null) {
            if (zStartPullDownRefresh) {
                aVar.g();
            } else {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void stopPullDownRefresh(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        TmcFragment tmcFragmentA = ((com.cloud.tmc.integration.structure.app.b) app.getAppContext()).k().a(app.getActivePage());
        if (tmcFragmentA == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        boolean zStopPullDownRefresh = ((IRefreshProxy) tc.a.a(IRefreshProxy.class)).stopPullDownRefresh(tmcFragmentA);
        if (aVar != null) {
            if (zStopPullDownRefresh) {
                aVar.g();
            } else {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void stopPullUpRefresh(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        TmcFragment tmcFragmentA = ((com.cloud.tmc.integration.structure.app.b) app.getAppContext()).k().a(app.getActivePage());
        if (tmcFragmentA == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        boolean zStopPullUpRefresh = ((IRefreshProxy) tc.a.a(IRefreshProxy.class)).stopPullUpRefresh(tmcFragmentA);
        if (aVar != null) {
            if (zStopPullUpRefresh) {
                aVar.g();
            } else {
                aVar.b();
            }
        }
    }
}
