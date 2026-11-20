package com.cloud.tmc.integration.defaultImpl;

import android.content.Context;
import android.os.Bundle;
import com.cloud.tmc.integration.defaultImpl.WorkerManagerFactory;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.engine.EngineRouterManager;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.worker.IWorkerManagerFactory;
import db.n;
import gd.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import lb.j;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class WorkerManagerFactory implements IWorkerManagerFactory {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements com.cloud.tmc.integration.performance.innerworker.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f30750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f30751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f30752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WorkerManagerFactory f30753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ IEngine f30754e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Context f30755f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Node f30756g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f30757h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f30758i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ IWorkerManagerFactory.a f30759j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f30760k;

        public a(Ref.LongRef longRef, Ref.LongRef longRef2, Ref.LongRef longRef3, WorkerManagerFactory workerManagerFactory, IEngine iEngine, Context context, Node node, String str, String str2, IWorkerManagerFactory.a aVar, Ref.LongRef longRef4) {
            this.f30750a = longRef;
            this.f30751b = longRef2;
            this.f30752c = longRef3;
            this.f30753d = workerManagerFactory;
            this.f30754e = iEngine;
            this.f30755f = context;
            this.f30756g = node;
            this.f30757h = str;
            this.f30758i = str2;
            this.f30759j = aVar;
            this.f30760k = longRef4;
        }

        public static final void h(WorkerManagerFactory this$0, IEngine engine, Context context, Node node, String userAgent, String workerId, IWorkerManagerFactory.a listener, Ref.LongRef createWorkerStartTime, Ref.LongRef createWorkerEndTime, Ref.LongRef loadWorkerFrameworkStartTime, Ref.LongRef loadWorkerFrameworkEndTime) throws Throwable {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(engine, "$engine");
            Intrinsics.g(context, "$context");
            Intrinsics.g(node, "$node");
            Intrinsics.g(userAgent, "$userAgent");
            Intrinsics.g(workerId, "$workerId");
            Intrinsics.g(listener, "$listener");
            Intrinsics.g(createWorkerStartTime, "$createWorkerStartTime");
            Intrinsics.g(createWorkerEndTime, "$createWorkerEndTime");
            Intrinsics.g(loadWorkerFrameworkStartTime, "$loadWorkerFrameworkStartTime");
            Intrinsics.g(loadWorkerFrameworkEndTime, "$loadWorkerFrameworkEndTime");
            this$0.a(engine, context, node, userAgent, workerId, listener, createWorkerStartTime.element, createWorkerEndTime.element, loadWorkerFrameworkStartTime.element, loadWorkerFrameworkEndTime.element);
        }

        public static final void i(WorkerManagerFactory this$0, IEngine engine, Context context, Node node, String userAgent, String workerId, IWorkerManagerFactory.a listener, Ref.LongRef createWorkerStartTime, Ref.LongRef createWorkerEndTime, Ref.LongRef loadWorkerFrameworkStartTime, Ref.LongRef loadWorkerFrameworkEndTime) throws Throwable {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(engine, "$engine");
            Intrinsics.g(context, "$context");
            Intrinsics.g(node, "$node");
            Intrinsics.g(userAgent, "$userAgent");
            Intrinsics.g(workerId, "$workerId");
            Intrinsics.g(listener, "$listener");
            Intrinsics.g(createWorkerStartTime, "$createWorkerStartTime");
            Intrinsics.g(createWorkerEndTime, "$createWorkerEndTime");
            Intrinsics.g(loadWorkerFrameworkStartTime, "$loadWorkerFrameworkStartTime");
            Intrinsics.g(loadWorkerFrameworkEndTime, "$loadWorkerFrameworkEndTime");
            this$0.a(engine, context, node, userAgent, workerId, listener, createWorkerStartTime.element, createWorkerEndTime.element, loadWorkerFrameworkStartTime.element, loadWorkerFrameworkEndTime.element);
        }

        public static final void j(WorkerManagerFactory this$0, IEngine engine, Context context, Node node, String userAgent, String workerId, IWorkerManagerFactory.a listener, Ref.LongRef createWorkerStartTime, Ref.LongRef createWorkerEndTime, Ref.LongRef loadWorkerFrameworkStartTime, Ref.LongRef loadWorkerFrameworkEndTime) throws Throwable {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(engine, "$engine");
            Intrinsics.g(context, "$context");
            Intrinsics.g(node, "$node");
            Intrinsics.g(userAgent, "$userAgent");
            Intrinsics.g(workerId, "$workerId");
            Intrinsics.g(listener, "$listener");
            Intrinsics.g(createWorkerStartTime, "$createWorkerStartTime");
            Intrinsics.g(createWorkerEndTime, "$createWorkerEndTime");
            Intrinsics.g(loadWorkerFrameworkStartTime, "$loadWorkerFrameworkStartTime");
            Intrinsics.g(loadWorkerFrameworkEndTime, "$loadWorkerFrameworkEndTime");
            this$0.a(engine, context, node, userAgent, workerId, listener, createWorkerStartTime.element, createWorkerEndTime.element, loadWorkerFrameworkStartTime.element, loadWorkerFrameworkEndTime.element);
        }

        @Override // com.cloud.tmc.integration.performance.innerworker.a
        public void a() {
            TmcLogger.c("InnerWarmup", "listener callback => worker warmupSuccess");
            this.f30760k.element = System.currentTimeMillis();
            this.f30750a.element = System.currentTimeMillis();
            this.f30751b.element = System.currentTimeMillis();
            this.f30752c.element = System.currentTimeMillis();
            final WorkerManagerFactory workerManagerFactory = this.f30753d;
            final IEngine iEngine = this.f30754e;
            final Context context = this.f30755f;
            final Node node = this.f30756g;
            final String str = this.f30757h;
            final String str2 = this.f30758i;
            final IWorkerManagerFactory.a aVar = this.f30759j;
            final Ref.LongRef longRef = this.f30760k;
            final Ref.LongRef longRef2 = this.f30750a;
            final Ref.LongRef longRef3 = this.f30751b;
            final Ref.LongRef longRef4 = this.f30752c;
            e.f(new Runnable() { // from class: fb.j
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    WorkerManagerFactory.a.j(workerManagerFactory, iEngine, context, node, str, str2, aVar, longRef, longRef2, longRef3, longRef4);
                }
            });
        }

        @Override // com.cloud.tmc.integration.performance.innerworker.a
        public void b(int i11) {
            TmcLogger.c("InnerWarmup", "listener callback => worker warmupFail:" + i11);
            final Ref.LongRef longRef = this.f30760k;
            longRef.element = 0L;
            final Ref.LongRef longRef2 = this.f30750a;
            longRef2.element = 0L;
            final Ref.LongRef longRef3 = this.f30751b;
            longRef3.element = 0L;
            final Ref.LongRef longRef4 = this.f30752c;
            longRef4.element = 0L;
            final WorkerManagerFactory workerManagerFactory = this.f30753d;
            final IEngine iEngine = this.f30754e;
            final Context context = this.f30755f;
            final Node node = this.f30756g;
            final String str = this.f30757h;
            final String str2 = this.f30758i;
            final IWorkerManagerFactory.a aVar = this.f30759j;
            e.f(new Runnable() { // from class: fb.k
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    WorkerManagerFactory.a.i(workerManagerFactory, iEngine, context, node, str, str2, aVar, longRef, longRef2, longRef3, longRef4);
                }
            });
        }

        @Override // com.cloud.tmc.integration.performance.innerworker.a
        public void c() {
            TmcLogger.c("InnerWarmup", "listener callback => loadWorkerFrameworkSuccess");
            this.f30752c.element = System.currentTimeMillis();
            final WorkerManagerFactory workerManagerFactory = this.f30753d;
            final IEngine iEngine = this.f30754e;
            final Context context = this.f30755f;
            final Node node = this.f30756g;
            final String str = this.f30757h;
            final String str2 = this.f30758i;
            final IWorkerManagerFactory.a aVar = this.f30759j;
            final Ref.LongRef longRef = this.f30760k;
            final Ref.LongRef longRef2 = this.f30750a;
            final Ref.LongRef longRef3 = this.f30751b;
            final Ref.LongRef longRef4 = this.f30752c;
            e.f(new Runnable() { // from class: fb.l
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    WorkerManagerFactory.a.h(workerManagerFactory, iEngine, context, node, str, str2, aVar, longRef, longRef2, longRef3, longRef4);
                }
            });
        }

        @Override // com.cloud.tmc.integration.performance.innerworker.a
        public void d() {
            TmcLogger.c("InnerWarmup", "listener callback => createWorkerSuccess");
            this.f30750a.element = System.currentTimeMillis();
            this.f30751b.element = System.currentTimeMillis();
        }
    }

    public final void a(IEngine iEngine, Context context, Node node, String str, String str2, IWorkerManagerFactory.a aVar, long j11, long j12, long j13, long j14) throws Throwable {
        App app;
        AppModel appModel;
        AppModel appModel2;
        boolean z11 = node instanceof Page;
        Page page = z11 ? (Page) node : null;
        if ((page != null ? page.getApp() : null) == null) {
            TmcLogger.c("InnerWarmup", "app已摧毁，不再继续执行Worker");
            return;
        }
        b worker = ((IInnerWorkerPool) tc.a.a(IInnerWorkerPool.class)).getWorker(((IPackageConfig) tc.a.a(IPackageConfig.class)).getFrameworkVersion());
        if (worker == null) {
            worker = iEngine.createWorker(context, node, "");
        } else {
            iEngine.updateWorker(worker);
        }
        if (node != null) {
            app = (App) node.bubbleFindNode(App.class);
            if (app != null) {
                app.setData(j.class, new j(str2));
            }
        } else {
            app = null;
        }
        PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String appId = app != null ? app.getAppId() : null;
        RenderAnalyseType renderAnalyseType = RenderAnalyseType.CONSOLE;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("worker fromWarmup : ");
        sb2.append(worker != null ? worker.c() : null);
        performanceAnalyseProxy.record(appId, renderAnalyseType, sb2.toString());
        long startToken = app != null ? app.getStartToken() : -1L;
        if (worker != null) {
            worker.r(str2);
        }
        if (worker != null) {
            worker.setAppId("100000");
        }
        if (worker != null) {
            worker.setNode(app);
        }
        if (AppUtils.f31011a.g((app == null || (appModel2 = app.getAppModel()) == null) ? null : appModel2.getMiniappSubtype()) && worker != null) {
            worker.s((app == null || (appModel = app.getAppModel()) == null) ? null : appModel.getTemplateMiniappId());
        }
        ((EngineRouterManager) tc.a.a(EngineRouterManager.class)).get(startToken).registerWorker(str2, worker);
        ((IScreenInspectProxy) tc.a.a(IScreenInspectProxy.class)).registerWorker(app, worker);
        if (j12 != 0 && j11 != 0) {
            ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(app != null ? app.getAppId() : null, "worker");
            Bundle bundle = new Bundle();
            bundle.putLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P, j11);
            String str3 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
            Page page2 = z11 ? (Page) node : null;
            bundle.putString(str3, page2 != null ? page2.getPagePath() : null);
            String str4 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
            Page page3 = z11 ? (Page) node : null;
            bundle.putString(str4, page3 != null ? page3.getPageId() : null);
            Bundle bundle2 = new Bundle();
            bundle2.putLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P, j12);
            String str5 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
            Page page4 = z11 ? (Page) node : null;
            bundle2.putString(str5, page4 != null ? page4.getPagePath() : null);
            String str6 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
            Page page5 = z11 ? (Page) node : null;
            bundle2.putString(str6, page5 != null ? page5.getPageId() : null);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, bundle2);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.I, bundle2);
            new db.e(bundle).f(pageNode != null ? pageNode.getPageChainContext() : null);
            new xa.e(bundle2).f(pageNode != null ? pageNode.getPageChainContext() : null);
        }
        if (j14 != 0 && j13 != 0) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P, j13);
            String str7 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
            Page page6 = z11 ? (Page) node : null;
            bundle3.putString(str7, page6 != null ? page6.getPagePath() : null);
            String str8 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
            Page page7 = z11 ? (Page) node : null;
            bundle3.putString(str8, page7 != null ? page7.getPageId() : null);
            Bundle bundle4 = new Bundle();
            bundle4.putLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P, j14);
            String str9 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.N;
            Page page8 = z11 ? (Page) node : null;
            bundle4.putString(str9, page8 != null ? page8.getPagePath() : null);
            String str10 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.W;
            Page page9 = z11 ? (Page) node : null;
            bundle4.putString(str10, page9 != null ? page9.getPageId() : null);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, bundle3);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, bundle3);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, bundle4);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.J, bundle4);
            new n(bundle3).f(pageNode != null ? pageNode.getPageChainContext() : null);
            new xa.n(bundle4).f(pageNode != null ? pageNode.getPageChainContext() : null);
            new db.a(bundle4).f(pageNode != null ? pageNode.getPageChainContext() : null);
        }
        aVar.a(worker);
    }

    @Override // com.cloud.tmc.worker.IWorkerManagerFactory
    public void createWorker(IEngine engine, Context context, Node node, String userAgent, String workerId, IWorkerManagerFactory.a listener) {
        Intrinsics.g(engine, "engine");
        Intrinsics.g(context, "context");
        Intrinsics.g(node, "node");
        Intrinsics.g(userAgent, "userAgent");
        Intrinsics.g(workerId, "workerId");
        Intrinsics.g(listener, "listener");
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = System.currentTimeMillis();
        Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = System.currentTimeMillis();
        Ref.LongRef longRef4 = new Ref.LongRef();
        longRef4.element = System.currentTimeMillis();
        ((IInnerWorkerPool) tc.a.a(IInnerWorkerPool.class)).registerListener(new a(longRef2, longRef3, longRef4, this, engine, context, node, userAgent, workerId, listener, longRef), ((IPackageConfig) tc.a.a(IPackageConfig.class)).getFrameworkVersion());
    }
}
