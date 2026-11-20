package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType;
import com.cloud.tmc.kernel.proxy.worker.IWorkerFactory;
import com.cloud.tmc.kernel.proxy.worker.JSAheadParamsProxy;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.worker.debug.WebviewWorker;
import gd.a;
import kotlin.TuplesKt;
import kotlin.collections.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class WorkerImp implements IWorkerFactory {
    /* JADX WARN: Code duplicated, block: B:16:0x004a A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:14:0x003e, B:16:0x004a, B:19:0x0056), top: B:23:0x003e }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [gd.a] */
    @Override // com.cloud.tmc.kernel.proxy.worker.IWorkerFactory
    public a createWorker(String str, Node node) {
        WebviewWorker webviewWorker;
        Object obj = null;
        try {
            int iWorkerType = workerType();
            try {
                if (iWorkerType != 2) {
                    if (iWorkerType == 3) {
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.CONSOLE, "worker from webview");
                        webviewWorker = new WebviewWorker(str, node, ByteAppManager.getSApplication(), null, 8, null);
                    }
                    ((JSAheadParamsProxy) tc.a.a(JSAheadParamsProxy.class)).setParams(r.f(TuplesKt.a("workerType", String.valueOf(webviewWorker != null ? Integer.valueOf(webviewWorker.type()) : null))));
                    return webviewWorker;
                }
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.CONSOLE, "worker from quickJS");
                ((JSAheadParamsProxy) tc.a.a(JSAheadParamsProxy.class)).setParams(r.f(TuplesKt.a("workerType", String.valueOf(webviewWorker != null ? Integer.valueOf(webviewWorker.type()) : null))));
                return webviewWorker;
            } catch (Throwable th2) {
                th = th2;
                obj = webviewWorker;
                TmcLogger.f("miniapp", "create worker fail : " + th + " ; workerType = " + workerType());
                return obj;
            }
            webviewWorker = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.worker.IWorkerFactory
    public int workerType() {
        return 3;
    }
}
