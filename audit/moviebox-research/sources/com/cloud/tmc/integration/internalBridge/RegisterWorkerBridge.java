package com.cloud.tmc.integration.internalBridge;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.core.TmcEngineImpl;
import com.cloud.tmc.integration.point.IIDEDispatcherPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.worker.IWorkerManagerFactory;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dd.f;
import lb.j;
import uc.c;
import xa.e;
import xa.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class RegisterWorkerBridge implements BridgeExtension {

    /* JADX INFO: compiled from: source.java */
    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gd.b f30768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ App f30769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JsonObject f30770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ uc.b f30771d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ gd.b f30772f;

        public a(gd.b bVar, App app, JsonObject jsonObject, uc.b bVar2, gd.b bVar3) {
            this.f30768a = bVar;
            this.f30769b = app;
            this.f30770c = jsonObject;
            this.f30771d = bVar2;
            this.f30772f = bVar3;
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            this.f30768a.q();
            if (h.f31061a.l(this.f30769b.getAppModel()) || this.f30769b.getAppModel().getDevMode() != 2) {
                hb.a.b(this.f30772f, "workerInit", this.f30770c);
                this.f30771d.c("workerOnMessageReady", this);
                return true;
            }
            IIDEDispatcherPoint iIDEDispatcherPoint = (IIDEDispatcherPoint) ib.a.b(IIDEDispatcherPoint.class).g(this.f30769b).d();
            if (iIDEDispatcherPoint != null) {
                iIDEDispatcherPoint.sendMsg("miniapp.workerInit", this.f30770c);
            }
            this.f30771d.c("workerOnMessageReady", this);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements IWorkerManagerFactory.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ App f30774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Page f30775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppLoadResult f30776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ bc.a f30777d;

        /* JADX INFO: compiled from: source.java */
        public class a implements gd.b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Bundle f30779a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Bundle f30780b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ gd.b f30781c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ JsonObject f30782d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ gd.b f30783e;

            /* JADX INFO: renamed from: com.cloud.tmc.integration.internalBridge.RegisterWorkerBridge$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0338a implements c {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ uc.b f30785a;

                public C0338a(uc.b bVar) {
                    this.f30785a = bVar;
                }

                @Override // uc.c
                public boolean O(uc.a aVar) {
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(b.this.f30774a.getAppId(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31227o, a.this.f30779a);
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(b.this.f30774a.getAppId(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, a.this.f30780b);
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(b.this.f30774a.getAppId(), PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, a.this.f30780b);
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(b.this.f30774a.getAppId(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, a.this.f30780b);
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(b.this.f30774a.getAppId(), PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, a.this.f30780b);
                    n nVar = new n(a.this.f30780b);
                    Page page = b.this.f30775b;
                    nVar.f(page == null ? null : page.getPageChainContext());
                    db.a aVar2 = new db.a(a.this.f30780b);
                    Page page2 = b.this.f30775b;
                    aVar2.f(page2 != null ? page2.getPageChainContext() : null);
                    a.this.f30781c.q();
                    if (h.f31061a.l(b.this.f30774a.getAppModel()) || b.this.f30774a.getAppModel().getDevMode() != 2) {
                        a aVar3 = a.this;
                        hb.a.b(aVar3.f30783e, "workerInit", aVar3.f30782d);
                        this.f30785a.c("workerOnMessageReady", this);
                        return true;
                    }
                    IIDEDispatcherPoint iIDEDispatcherPoint = (IIDEDispatcherPoint) ib.a.b(IIDEDispatcherPoint.class).g(b.this.f30774a).d();
                    if (iIDEDispatcherPoint != null) {
                        iIDEDispatcherPoint.sendMsg("miniapp.workerInit", a.this.f30782d);
                    }
                    this.f30785a.c("workerOnMessageReady", this);
                    return true;
                }
            }

            public a(Bundle bundle, Bundle bundle2, gd.b bVar, JsonObject jsonObject, gd.b bVar2) {
                this.f30779a = bundle;
                this.f30780b = bundle2;
                this.f30781c = bVar;
                this.f30782d = jsonObject;
                this.f30783e = bVar2;
            }

            @Override // gd.b.a
            public void a() {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(b.this.f30774a.getAppId(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31225n, this.f30779a);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(b.this.f30774a.getAppId(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, this.f30780b);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(b.this.f30774a.getAppId(), PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, this.f30780b);
                e eVar = new e(this.f30780b);
                Page page = b.this.f30775b;
                eVar.f(page == null ? null : page.getPageChainContext());
                uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(b.this.f30774a);
                if (eventCenterInstance != null) {
                    eventCenterInstance.b("workerOnMessageReady", new C0338a(eventCenterInstance));
                }
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(b.this.f30774a.getAppId(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31227o, this.f30779a);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(b.this.f30774a.getAppId(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, this.f30780b);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(b.this.f30774a.getAppId(), PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, this.f30780b);
                db.n nVar = new db.n(this.f30780b);
                Page page2 = b.this.f30775b;
                nVar.f(page2 != null ? page2.getPageChainContext() : null);
                this.f30783e.g("100000", "https://100000.miniapp.transsion.com/master.js");
                b.this.f30777d.d(new JsonObject());
                this.f30783e.o();
            }
        }

        public b(App app, Page page, AppLoadResult appLoadResult, bc.a aVar) {
            this.f30774a = app;
            this.f30775b = page;
            this.f30776c = appLoadResult;
            this.f30777d = aVar;
        }

        @Override // com.cloud.tmc.worker.IWorkerManagerFactory.a
        public void a(@Nullable gd.b bVar) {
            this.f30774a.getEngineProxy().getEngineRouter().registerWorker(bVar);
            this.f30775b.setData(j.class, new j(bVar.getWorkerId()));
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("homepageUrl", this.f30775b.getPagePath());
            String pageId = this.f30774a.getPageByIndex(0).getPageId();
            int childCount = this.f30774a.getChildCount();
            if (childCount > 0) {
                for (int i11 = 0; i11 < childCount; i11++) {
                    if (this.f30774a.getPageByIndex(i11).getPagePath() != null) {
                        App app = this.f30774a;
                        if (app.getPageType(app.getPageByIndex(i11).getPagePath()) == 1) {
                            pageId = this.f30774a.getPageByIndex(i11).getPageId();
                            break;
                        }
                    }
                }
            }
            jsonObject.addProperty("homepageRenderId", pageId);
            jsonObject.addProperty("appJson", new Gson().toJson(this.f30776c.appConfigModel));
            try {
                jsonObject.addProperty("miniappId", this.f30774a.getAppId());
                if (AppUtils.f31011a.g(this.f30774a.getAppModel().getMiniappSubtype())) {
                    jsonObject.addProperty("commonresId", this.f30774a.getAppModel().getTemplateMiniappId());
                }
            } catch (Throwable th2) {
                TmcLogger.g("RegisterWorkerBridge", "", th2);
            }
            if (!bVar.c().booleanValue()) {
                Bundle bundle = new Bundle();
                bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
                bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, this.f30774a.getStartParams().getString("uniqueChainID", "-1"));
                bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, this.f30775b.getPagePath());
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f30774a.getAppId(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31225n, bundle);
                Bundle bundle2 = new Bundle();
                bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, this.f30775b.getPagePath());
                bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, this.f30775b.getPageId());
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f30774a.getAppId(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, bundle2);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f30774a.getAppId(), PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, bundle2);
                db.e eVar = new db.e(bundle2);
                Page page = this.f30775b;
                eVar.f(page == null ? null : page.getPageChainContext());
                bVar.l(new a(bundle, bundle2, bVar, jsonObject, bVar));
                return;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, this.f30775b.getPagePath());
            bundle3.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, this.f30775b.getPageId());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f30774a.getAppId(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, bundle3);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f30774a.getAppId(), PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, bundle3);
            if (h.f31061a.l(this.f30774a.getAppModel()) || this.f30774a.getAppModel().getDevMode() != 2) {
                hb.a.b(bVar, "workerInit", jsonObject);
                this.f30777d.d(new JsonObject());
                bVar.o();
            } else {
                IIDEDispatcherPoint iIDEDispatcherPoint = (IIDEDispatcherPoint) ib.a.b(IIDEDispatcherPoint.class).g(this.f30774a).d();
                if (iIDEDispatcherPoint != null) {
                    iIDEDispatcherPoint.sendMsg("miniapp.workerInit", jsonObject);
                }
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void registerWorker(@cc.c bc.a aVar, @cc.f(Page.class) Page page, @cc.f(App.class) App app) {
        Context context = app.getAppContext().getContext();
        if (context == null) {
            aVar.b();
            return;
        }
        AppLoadResult appLoadResult = (AppLoadResult) app.getData(AppLoadResult.class);
        if (appLoadResult == null) {
            TmcLogger.f("RegisterWorkerBridge", "loadJS failed, appLoadResult is null");
            aVar.b();
            return;
        }
        IEngine engineProxy = app.getEngineProxy();
        try {
            try {
                if (hc.b.f66421b) {
                    hc.b.f66421b = false;
                    gd.b workerById = app.getEngineProxy().getEngineRouter().getWorkerById(app.getEngineProxy().getWorkerId());
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("homepageUrl", page.getPagePath());
                    String pageId = app.getPageByIndex(0).getPageId();
                    int childCount = app.getChildCount();
                    if (childCount > 0) {
                        for (int i11 = 0; i11 < childCount; i11++) {
                            if (app.getPageByIndex(i11).getPagePath() != null && app.getPageType(app.getPageByIndex(i11).getPagePath()) == 1) {
                                pageId = app.getPageByIndex(i11).getPageId();
                                break;
                            }
                        }
                    }
                    jsonObject.addProperty("homepageRenderId", pageId);
                    jsonObject.addProperty("appJson", new Gson().toJson(appLoadResult.appConfigModel));
                    try {
                        jsonObject.addProperty("miniappId", app.getAppId());
                        if (AppUtils.f31011a.g(app.getAppModel().getMiniappSubtype())) {
                            jsonObject.addProperty("commonresId", app.getAppModel().getTemplateMiniappId());
                        }
                    } catch (Throwable unused) {
                    }
                    uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(app);
                    if (eventCenterInstance != null) {
                        eventCenterInstance.b("workerOnMessageReady", new a(workerById, app, jsonObject, eventCenterInstance, workerById));
                    }
                    workerById.g("100000", "https://100000.miniapp.transsion.com/master.js");
                    aVar.d(new JsonObject());
                    workerById.o();
                } else {
                    ((IWorkerManagerFactory) tc.a.a(IWorkerManagerFactory.class)).createWorker(engineProxy, context, page, "", TmcEngineImpl.generateWorkerId(), new b(app, page, appLoadResult, aVar));
                }
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                aVar.b();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
