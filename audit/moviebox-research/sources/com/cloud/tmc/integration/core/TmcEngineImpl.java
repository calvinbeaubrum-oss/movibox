package com.cloud.tmc.integration.core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.coreimpl.BaseEngineImpl;
import com.cloud.tmc.kernel.engine.EngineRouterManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.CreateParams;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.perf.IPerformanceAndErrorTracker;
import com.cloud.tmc.worker.WorkerManager;
import com.google.gson.JsonObject;
import ee.j;
import gd.b;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import rc.c;
import tc.a;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TmcEngineImpl extends BaseEngineImpl {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicInteger f30684i = new AtomicInteger(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f30685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HandlerThread f30686h;

    public TmcEngineImpl(String str, Node node) {
        super(str, node);
        this.f30685g = null;
        HandlerThread handlerThread = new HandlerThread("TmcRenderChannelThread");
        this.f30686h = handlerThread;
        handlerThread.start();
    }

    public static String generateWorkerId() {
        return f30684i.addAndGet(1) + "";
    }

    public final b a(App app, String str, String str2) {
        long startToken = app != null ? app.getStartToken() : -1L;
        WorkerManager workerManager = null;
        try {
            WorkerManager workerManager2 = new WorkerManager();
            try {
                workerManager2.o();
                workerManager2.r(str2);
                ((EngineRouterManager) a.a(EngineRouterManager.class)).get(startToken).registerWorker(str2, workerManager2);
                return workerManager2;
            } catch (Exception e11) {
                e = e11;
                workerManager = workerManager2;
                TmcLogger.h("TmcEngineImpl", e);
                new HashMap().put("errorMessage", e.getMessage());
                return workerManager;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public i createRender(Activity activity, Node node, CreateParams createParams) {
        ((IPerformanceAndErrorTracker) a.a(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "Start create render");
        new JsonObject();
        return new j(activity, this, node, createParams);
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public b createWorker(Context context, Node node, String str) {
        App app;
        ((IPerformanceAndErrorTracker) a.a(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "register worker");
        new JsonObject();
        String strGenerateWorkerId = generateWorkerId();
        if (node != null) {
            app = (App) node.bubbleFindNode(App.class);
            app.setData(lb.j.class, new lb.j(strGenerateWorkerId));
        } else {
            app = null;
        }
        b bVarA = a(app, str, strGenerateWorkerId);
        this.f30685g = bVarA;
        return bVarA;
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public String getInstanceId() {
        return null;
    }

    @Override // com.cloud.tmc.kernel.coreimpl.BaseEngineImpl, com.cloud.tmc.kernel.engine.IEngine
    public i getTopRender() {
        return null;
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public String getWorkerId() {
        b bVar = this.f30685g;
        return bVar == null ? "" : bVar.getWorkerId();
    }

    @Override // com.cloud.tmc.kernel.coreimpl.BaseEngineImpl, com.cloud.tmc.kernel.engine.IEngine
    public void init(c cVar, ic.a aVar) {
        super.init(cVar, aVar);
        new JsonObject();
        aVar.a(true, "uc init success");
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public boolean isReady() {
        return false;
    }

    @Override // com.cloud.tmc.kernel.coreimpl.BaseEngineImpl
    public void onDestroy() {
        b bVar = this.f30685g;
        if (bVar != null) {
            if (bVar.c().booleanValue()) {
                ((IInnerWorkerPool) a.a(IInnerWorkerPool.class)).removeWorker(this.f30685g.getWorkerId());
            } else {
                this.f30685g.destroy();
            }
        }
        super.onDestroy();
        try {
            this.f30686h.quitSafely();
        } catch (Throwable th2) {
            TmcLogger.h("mRenderChannelThread quit error", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public void setup(Bundle bundle, Bundle bundle2, ic.b bVar) {
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public void updateWorker(b bVar) {
        this.f30685g = bVar;
    }
}
