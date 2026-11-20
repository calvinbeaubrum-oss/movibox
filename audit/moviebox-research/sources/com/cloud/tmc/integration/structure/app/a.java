package com.cloud.tmc.integration.structure.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.e;
import lb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements tb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f30923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public App f30924b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f30926d = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.cloud.tmc.integration.ui.fragment.a f30925c = h();

    public a(App app, FragmentActivity fragmentActivity) {
        this.f30924b = app;
        this.f30923a = fragmentActivity;
    }

    @Override // tb.b
    public void a(@NonNull Page page) {
        if (!e.c()) {
            throw new IllegalStateException("switchTab can only invoked in main thread!");
        }
        TmcLogger.c("Tmcintegration:BaseAppContext", "switchTab with page: " + page);
        if (this.f30925c == null || page.isExited()) {
            TmcLogger.o("Tmcintegration:BaseAppContext", "pushPage but is exited!");
            return;
        }
        TmcFragment tmcFragmentF = this.f30925c.f(page.getPagePath());
        if (tmcFragmentF == null || !tmcFragmentF.isAdded()) {
            this.f30925c.k(page, tmcFragmentF, false, false);
        } else {
            this.f30925c.h(page, tmcFragmentF);
        }
    }

    @Override // tb.b
    public boolean b() {
        return false;
    }

    @Override // tb.b
    public boolean c() {
        return this.f30923a.isTaskRoot();
    }

    @Override // tb.b
    public void d(@NonNull Page page, boolean z11) {
        TmcLogger.c("Tmcintegration:BaseAppContext", "exitPage " + page);
        com.cloud.tmc.integration.ui.fragment.a aVar = this.f30925c;
        if (aVar == null) {
            TmcLogger.c("Tmcintegration:BaseAppContext", "exitPage but already exited");
            return;
        }
        boolean z12 = false;
        if (aVar.a(page) != null) {
            if (!this.f30924b.isExited() && !((Page.a) page.getData(Page.a.class, true)).f30918b) {
                z12 = true;
            }
            this.f30925c.c(page, z12, z11);
            return;
        }
        if (page.isTabPage() && this.f30925c.f(page.getPagePath()) != null) {
            this.f30925c.m(page, false);
        }
        TmcLogger.c("Tmcintegration:BaseAppContext", "exitPage but fragment already exited!");
        this.f30925c.b();
    }

    @Override // tb.b
    public synchronized void destroy() {
        if (this.f30926d) {
            return;
        }
        this.f30926d = true;
        m();
    }

    @Override // tb.b
    public void e(@NonNull Page page) {
        if (!e.c()) {
            throw new IllegalStateException("pushPage can only invoked in main thread!");
        }
        TmcLogger.c("Tmcintegration:BaseAppContext", "startPage with page: " + page);
        f(page);
    }

    @Override // tb.b
    public boolean f(@NonNull Page page) {
        if (!e.c()) {
            throw new IllegalStateException("pushPage can only invoked in main thread!");
        }
        TmcLogger.c("Tmcintegration:BaseAppContext", "pushPage with page: " + page + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        if (this.f30925c == null || page.isExited()) {
            TmcLogger.o("Tmcintegration:BaseAppContext", "pushPage but is exited!");
            return false;
        }
        page.getStartParams();
        TmcFragment tmcFragmentG = this.f30925c.g(page);
        if (tmcFragmentG.isAdded()) {
            tmcFragmentG.j0(page);
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("appInstanceId", this.f30924b.getNodeId());
            bundle.putLong("pageInstanceId", page.getNodeId());
            tmcFragmentG.setArguments(bundle);
        }
        this.f30925c.k(page, tmcFragmentG, !((Page.a) page.getData(Page.a.class, true)).f30917a, ((i) page.getData(i.class, true)).f70207a);
        return true;
    }

    @Override // tb.b
    public void g(@NonNull Page page) {
        if (!e.c()) {
            throw new IllegalStateException("pushWebViewPage can only invoked in main thread!");
        }
        TmcLogger.c("Tmcintegration:BaseAppContext", "pushWebViewPage with page: " + page + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        Bundle bundle = new Bundle();
        bundle.putLong("appInstanceId", this.f30924b.getNodeId());
        bundle.putLong("pageInstanceId", page.getNodeId());
        bundle.putString("pageUri", page.getPageURI());
        bundle.putBoolean("enableAdsense", true);
        Intent intent = new Intent(i(), ((StartActivityProxy) tc.a.a(StartActivityProxy.class)).getWebViewActivity());
        intent.putExtras(bundle);
        h.f31061a.a(intent, i());
        i().startActivity(intent);
    }

    @Override // tb.b
    public Context getContext() {
        return this.f30923a;
    }

    public abstract com.cloud.tmc.integration.ui.fragment.a h();

    public FragmentActivity i() {
        return this.f30923a;
    }

    public App j() {
        return this.f30924b;
    }

    public com.cloud.tmc.integration.ui.fragment.a k() {
        return this.f30925c;
    }

    public abstract ViewGroup l();

    public void m() {
        App app = this.f30924b;
        if (app == null || !app.getBooleanValue("miniAppReload")) {
            FragmentActivity fragmentActivity = this.f30923a;
            if (fragmentActivity == null || fragmentActivity.isFinishing() || this.f30923a.isDestroyed()) {
                FragmentActivity fragmentActivity2 = this.f30923a;
                if (fragmentActivity2 != null && fragmentActivity2.isFinishing() && this.f30923a.isDestroyed()) {
                    TmcLogger.c("Tmcintegration:BaseAppContext", "remove task by recent ");
                    ((StartActivityProxy) tc.a.a(StartActivityProxy.class)).removeMiniAppTaskByRecent(this.f30924b.getAppId());
                }
            } else {
                TmcLogger.o("Tmcintegration:BaseAppContext", "NebulaActivity finish by AppContext.destroy()");
                if (this.f30923a.isTaskRoot()) {
                    App app2 = this.f30924b;
                    if (app2 != null && app2.getAppId() != null) {
                        TmcLogger.c("Tmcintegration:BaseAppContext", "remove activity task");
                        ((StartActivityProxy) tc.a.a(StartActivityProxy.class)).removeMiniAppTask(this.f30924b.getAppId(), this.f30923a);
                    }
                } else {
                    TmcLogger.c("Tmcintegration:BaseAppContext", "activity is not task root");
                    this.f30923a.finish();
                }
                this.f30923a = null;
            }
        }
        com.cloud.tmc.integration.ui.fragment.a aVar = this.f30925c;
        if (aVar != null) {
            aVar.release();
            this.f30925c = null;
        }
        this.f30924b = null;
    }
}
