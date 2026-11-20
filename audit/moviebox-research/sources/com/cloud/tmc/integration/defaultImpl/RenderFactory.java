package com.cloud.tmc.integration.defaultImpl;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.defaultImpl.RenderFactory;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.CreateParams;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.render.IRenderFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import db.l;
import ee.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import xa.d;
import zc.h;
import zc.i;

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
@SourceDebugExtension
public final class RenderFactory implements IRenderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30708a = "RenderFactory";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements com.cloud.tmc.integration.performance.innerrender.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f30709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f30710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IEngine f30711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f30712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Node f30713e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ RenderFactory f30714f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Activity f30715g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ CreateParams f30716h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f30717i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Object f30718j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ IRenderFactory.a f30719k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Bundle f30720l;

        public a(Ref.LongRef longRef, Ref.LongRef longRef2, IEngine iEngine, Ref.LongRef longRef3, Node node, RenderFactory renderFactory, Activity activity, CreateParams createParams, String str, Object obj, IRenderFactory.a aVar, Bundle bundle) {
            this.f30709a = longRef;
            this.f30710b = longRef2;
            this.f30711c = iEngine;
            this.f30712d = longRef3;
            this.f30713e = node;
            this.f30714f = renderFactory;
            this.f30715g = activity;
            this.f30716h = createParams;
            this.f30717i = str;
            this.f30718j = obj;
            this.f30719k = aVar;
            this.f30720l = bundle;
        }

        public static final void h(Node node, RenderFactory this$0, Activity activity, IEngine iEngine, CreateParams createParams, String pageId, Object context, IRenderFactory.a listener, Ref.LongRef createRenderEndTime, Ref.LongRef loadRenderFrameworkStartTime, Ref.LongRef loadRenderFrameworkEndTime, Bundle data) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(pageId, "$pageId");
            Intrinsics.g(context, "$context");
            Intrinsics.g(listener, "$listener");
            Intrinsics.g(createRenderEndTime, "$createRenderEndTime");
            Intrinsics.g(loadRenderFrameworkStartTime, "$loadRenderFrameworkStartTime");
            Intrinsics.g(loadRenderFrameworkEndTime, "$loadRenderFrameworkEndTime");
            Intrinsics.g(data, "$data");
            PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
            if ((pageNode != null ? pageNode.getApp() : null) == null) {
                TmcLogger.c("InnerWarmup", "app已摧毁，不再继续执行Render");
            } else {
                this$0.d(activity, iEngine, node, createParams, pageId, context, this$0.b(activity, iEngine, node, createParams), listener, createRenderEndTime.element, loadRenderFrameworkStartTime.element, loadRenderFrameworkEndTime.element, data);
            }
        }

        public static final void i(Node node, RenderFactory this$0, Activity activity, IEngine iEngine, CreateParams createParams, String pageId, Object context, IRenderFactory.a listener, Ref.LongRef createRenderEndTime, Ref.LongRef loadRenderFrameworkStartTime, Ref.LongRef loadRenderFrameworkEndTime, Bundle data) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(pageId, "$pageId");
            Intrinsics.g(context, "$context");
            Intrinsics.g(listener, "$listener");
            Intrinsics.g(createRenderEndTime, "$createRenderEndTime");
            Intrinsics.g(loadRenderFrameworkStartTime, "$loadRenderFrameworkStartTime");
            Intrinsics.g(loadRenderFrameworkEndTime, "$loadRenderFrameworkEndTime");
            Intrinsics.g(data, "$data");
            PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
            if ((pageNode != null ? pageNode.getApp() : null) == null) {
                TmcLogger.c("InnerWarmup", "app已摧毁，不再继续执行Render");
            } else {
                this$0.d(activity, iEngine, node, createParams, pageId, context, this$0.b(activity, iEngine, node, createParams), listener, createRenderEndTime.element, loadRenderFrameworkStartTime.element, loadRenderFrameworkEndTime.element, data);
            }
        }

        public static final void j(Node node, RenderFactory this$0, Activity activity, IEngine iEngine, CreateParams createParams, String pageId, Object context, IRenderFactory.a listener, Ref.LongRef createRenderEndTime, Ref.LongRef loadRenderFrameworkStartTime, Ref.LongRef loadRenderFrameworkEndTime, Bundle data) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(pageId, "$pageId");
            Intrinsics.g(context, "$context");
            Intrinsics.g(listener, "$listener");
            Intrinsics.g(createRenderEndTime, "$createRenderEndTime");
            Intrinsics.g(loadRenderFrameworkStartTime, "$loadRenderFrameworkStartTime");
            Intrinsics.g(loadRenderFrameworkEndTime, "$loadRenderFrameworkEndTime");
            Intrinsics.g(data, "$data");
            PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
            if ((pageNode != null ? pageNode.getApp() : null) == null) {
                TmcLogger.c("InnerWarmup", "app已摧毁，不再继续执行Render");
            } else {
                this$0.d(activity, iEngine, node, createParams, pageId, context, this$0.b(activity, iEngine, node, createParams), listener, createRenderEndTime.element, loadRenderFrameworkStartTime.element, loadRenderFrameworkEndTime.element, data);
            }
        }

        @Override // com.cloud.tmc.integration.performance.innerrender.a
        public void a() {
            TmcLogger.c("InnerWarmup", "listener callback => render warmupSuccess");
            PerformanceImprovesProxy performanceImprovesProxy = (PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class);
            IEngine iEngine = this.f30711c;
            performanceImprovesProxy.addPeroformanceImprove(iEngine != null ? iEngine.getAppId() : null, "render");
            this.f30709a.element = System.currentTimeMillis();
            this.f30710b.element = System.currentTimeMillis();
            this.f30712d.element = System.currentTimeMillis();
            final Node node = this.f30713e;
            final RenderFactory renderFactory = this.f30714f;
            final Activity activity = this.f30715g;
            final IEngine iEngine2 = this.f30711c;
            final CreateParams createParams = this.f30716h;
            final String str = this.f30717i;
            final Object obj = this.f30718j;
            final IRenderFactory.a aVar = this.f30719k;
            final Ref.LongRef longRef = this.f30709a;
            final Ref.LongRef longRef2 = this.f30710b;
            final Ref.LongRef longRef3 = this.f30712d;
            final Bundle bundle = this.f30720l;
            e.f(new Runnable() { // from class: fb.g
                @Override // java.lang.Runnable
                public final void run() {
                    RenderFactory.a.j(node, renderFactory, activity, iEngine2, createParams, str, obj, aVar, longRef, longRef2, longRef3, bundle);
                }
            });
        }

        @Override // com.cloud.tmc.integration.performance.innerrender.a
        public void b(int i11) {
            TmcLogger.c("InnerWarmup", "listener callback => render warmupFail:" + i11);
            final Ref.LongRef longRef = this.f30709a;
            longRef.element = 0L;
            final Ref.LongRef longRef2 = this.f30710b;
            longRef2.element = 0L;
            final Ref.LongRef longRef3 = this.f30712d;
            longRef3.element = 0L;
            final Node node = this.f30713e;
            final RenderFactory renderFactory = this.f30714f;
            final Activity activity = this.f30715g;
            final IEngine iEngine = this.f30711c;
            final CreateParams createParams = this.f30716h;
            final String str = this.f30717i;
            final Object obj = this.f30718j;
            final IRenderFactory.a aVar = this.f30719k;
            final Bundle bundle = this.f30720l;
            e.f(new Runnable() { // from class: fb.f
                @Override // java.lang.Runnable
                public final void run() {
                    RenderFactory.a.i(node, renderFactory, activity, iEngine, createParams, str, obj, aVar, longRef, longRef2, longRef3, bundle);
                }
            });
        }

        @Override // com.cloud.tmc.integration.performance.innerrender.a
        public void c() {
            TmcLogger.c("InnerWarmup", "listener callback => createRenderSuccess");
            this.f30709a.element = System.currentTimeMillis();
            this.f30710b.element = System.currentTimeMillis();
        }

        @Override // com.cloud.tmc.integration.performance.innerrender.a
        public void d() {
            TmcLogger.c("InnerWarmup", "listener callback => loadRenderFrameworkSuccess");
            PerformanceImprovesProxy performanceImprovesProxy = (PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class);
            IEngine iEngine = this.f30711c;
            performanceImprovesProxy.addPeroformanceImprove(iEngine != null ? iEngine.getAppId() : null, "render");
            this.f30712d.element = System.currentTimeMillis();
            final Node node = this.f30713e;
            final RenderFactory renderFactory = this.f30714f;
            final Activity activity = this.f30715g;
            final IEngine iEngine2 = this.f30711c;
            final CreateParams createParams = this.f30716h;
            final String str = this.f30717i;
            final Object obj = this.f30718j;
            final IRenderFactory.a aVar = this.f30719k;
            final Ref.LongRef longRef = this.f30709a;
            final Ref.LongRef longRef2 = this.f30710b;
            final Ref.LongRef longRef3 = this.f30712d;
            final Bundle bundle = this.f30720l;
            e.f(new Runnable() { // from class: fb.h
                @Override // java.lang.Runnable
                public final void run() {
                    RenderFactory.a.h(node, renderFactory, activity, iEngine2, createParams, str, obj, aVar, longRef, longRef2, longRef3, bundle);
                }
            });
        }
    }

    public static final void c(Node node, RenderFactory this$0, Activity activity, IEngine iEngine, CreateParams createParams, String pageId, Object context, Ref.ObjectRef mRender, IRenderFactory.a listener, Ref.LongRef createRenderEndTime, Ref.LongRef loadRenderFrameworkStartTime, Ref.LongRef loadRenderFrameworkEndTime, Bundle data) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(pageId, "$pageId");
        Intrinsics.g(context, "$context");
        Intrinsics.g(mRender, "$mRender");
        Intrinsics.g(listener, "$listener");
        Intrinsics.g(createRenderEndTime, "$createRenderEndTime");
        Intrinsics.g(loadRenderFrameworkStartTime, "$loadRenderFrameworkStartTime");
        Intrinsics.g(loadRenderFrameworkEndTime, "$loadRenderFrameworkEndTime");
        Intrinsics.g(data, "$data");
        PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
        if ((pageNode != null ? pageNode.getApp() : null) == null) {
            TmcLogger.c("InnerWarmup", "app已摧毁，不再继续执行Render");
        } else {
            this$0.d(activity, iEngine, node, createParams, pageId, context, (i) mRender.element, listener, createRenderEndTime.element, loadRenderFrameworkStartTime.element, loadRenderFrameworkEndTime.element, data);
        }
    }

    public final i b(Activity activity, IEngine iEngine, Node node, CreateParams createParams) {
        i render = activity != null ? ((IInnerRenderPool) tc.a.a(IInnerRenderPool.class)).getRender(activity, ((IPackageConfig) tc.a.a(IPackageConfig.class)).getFrameworkVersion()) : null;
        return render == null ? new j(activity, iEngine, node, createParams, 0, 16, null) : render;
    }

    public final void d(Activity activity, IEngine iEngine, Node node, CreateParams createParams, String str, Object obj, i iVar, IRenderFactory.a aVar, long j11, long j12, long j13, Bundle bundle) {
        App app;
        App app2;
        App app3;
        App app4;
        App app5;
        App app6;
        App app7;
        AppModel appModel;
        App app8;
        App app9;
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        boolean z11 = node instanceof Page;
        Page page = z11 ? (Page) node : null;
        String appId = (page == null || (app9 = page.getApp()) == null) ? null : app9.getAppId();
        performanceAnalyseProxy.record(appId, RenderAnalyseType.CONSOLE, "render fromWarmup : " + iVar.c());
        if (obj instanceof h) {
            iVar.f((h) obj);
        }
        if (iVar.c()) {
            iVar.j(iEngine != null ? iEngine.getAppId() : null);
            iVar.x(str);
            iVar.r(iEngine);
            iVar.p(node);
            iVar.w(createParams);
        } else {
            iVar.p(node);
            iVar.init(str);
        }
        com.cloud.tmc.integration.utils.h hVar = com.cloud.tmc.integration.utils.h.f31061a;
        Page page2 = z11 ? (Page) node : null;
        if (hVar.l((page2 == null || (app8 = page2.getApp()) == null) ? null : app8.getAppModel())) {
            Page page3 = z11 ? (Page) node : null;
            if (page3 != null && (app7 = page3.getApp()) != null && (appModel = app7.getAppModel()) != null) {
                iVar.setMiniAppType(appModel.getAppinfoCategoryType());
            }
        }
        ((IScreenInspectProxy) tc.a.a(IScreenInspectProxy.class)).registerRender(iVar);
        Bundle bundle2 = new Bundle();
        if (j11 != 0) {
            bundle2.putLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P, j11);
        } else {
            bundle2.putLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P, System.currentTimeMillis());
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if (node != null) {
        }
        PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Page page4 = z11 ? (Page) node : null;
        String appId2 = (page4 == null || (app6 = page4.getApp()) == null) ? null : app6.getAppId();
        PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_APP_CHAIN_END;
        performanceAnalyseProxy2.record(appId2, pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.G, bundle2);
        PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        Page page5 = z11 ? (Page) node : null;
        String appId3 = (page5 == null || (app5 = page5.getApp()) == null) ? null : app5.getAppId();
        PointAnalyseType pointAnalyseType2 = PointAnalyseType.POINT_PAGE_CHAIN_END;
        performanceAnalyseProxy3.record(appId3, pointAnalyseType2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.G, bundle2);
        new d(bundle2).f(pageNode != null ? pageNode.getPageChainContext() : null);
        if (j12 != 0) {
            PageNode pageNode2 = pageNode;
            if (j13 != 0) {
                Bundle bundle3 = new Bundle();
                bundle3.putLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P, j12);
                if (bundle != null) {
                    bundle3.putAll(bundle);
                }
                Bundle bundle4 = new Bundle();
                bundle4.putLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P, j13);
                if (bundle != null) {
                    bundle4.putAll(bundle);
                }
                PerformanceAnalyseProxy performanceAnalyseProxy4 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                Page page6 = z11 ? (Page) node : null;
                performanceAnalyseProxy4.record((page6 == null || (app4 = page6.getApp()) == null) ? null : app4.getAppId(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle3);
                PerformanceAnalyseProxy performanceAnalyseProxy5 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                Page page7 = z11 ? (Page) node : null;
                performanceAnalyseProxy5.record((page7 == null || (app3 = page7.getApp()) == null) ? null : app3.getAppId(), PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle3);
                PerformanceAnalyseProxy performanceAnalyseProxy6 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                Page page8 = z11 ? (Page) node : null;
                performanceAnalyseProxy6.record((page8 == null || (app2 = page8.getApp()) == null) ? null : app2.getAppId(), pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle4);
                PerformanceAnalyseProxy performanceAnalyseProxy7 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                Page page9 = z11 ? (Page) node : null;
                performanceAnalyseProxy7.record((page9 == null || (app = page9.getApp()) == null) ? null : app.getAppId(), pointAnalyseType2, com.cloud.tmc.kernel.proxy.performanceanalyse.a.H, bundle4);
                new l(bundle3).f(pageNode2 != null ? pageNode2.getPageChainContext() : null);
                new xa.l(bundle4).f(pageNode2 != null ? pageNode2.getPageChainContext() : null);
            }
        }
        aVar.a(iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [T, zc.i] */
    /* JADX WARN: Type inference failed for: r0v72, types: [T, zc.i] */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, ee.j] */
    /* JADX WARN: Type inference failed for: r9v3, types: [T, ee.j] */
    @Override // com.cloud.tmc.render.IRenderFactory
    public void getRender(final Activity activity, final IEngine iEngine, final Node node, final CreateParams createParams, final String pageId, final Object context, final Bundle data, boolean z11, final IRenderFactory.a listener) {
        Object obj;
        App app;
        App app2;
        App app3;
        App app4;
        AppModel appModel;
        App app5;
        AppModel appModel2;
        App app6;
        App app7;
        AppModel appModel3;
        ExtendModel extend;
        App app8;
        Intrinsics.g(pageId, "pageId");
        Intrinsics.g(context, "context");
        Intrinsics.g(data, "data");
        Intrinsics.g(listener, "listener");
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = System.currentTimeMillis();
        final Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = System.currentTimeMillis();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        com.cloud.tmc.integration.utils.h hVar = com.cloud.tmc.integration.utils.h.f31061a;
        boolean z12 = node instanceof Page;
        Page page = z12 ? (Page) node : null;
        if (hVar.l((page == null || (app8 = page.getApp()) == null) ? null : app8.getAppModel())) {
            Page page2 = z12 ? (Page) node : null;
            String strValueOf = String.valueOf((page2 == null || (app7 = page2.getApp()) == null || (appModel3 = app7.getAppModel()) == null || (extend = appModel3.getExtend()) == null) ? null : extend.getH5Url());
            Page page3 = z12 ? (Page) node : null;
            Bundle startParams = (page3 == null || (app6 = page3.getApp()) == null) ? null : app6.getStartParams();
            if (activity != null && !TextUtils.isEmpty(strValueOf) && startParams != null) {
                Bundle bundleA = com.cloud.tmc.kernel.utils.a.a(startParams);
                if (bundleA != null) {
                    if (TextUtils.isEmpty(bundleA.getString("h5Path")) && !TextUtils.isEmpty(bundleA.getString("h5PathCopy"))) {
                        bundleA.putString("h5Path", bundleA.getString("h5PathCopy"));
                    }
                    if (TextUtils.isEmpty(bundleA.getString("query")) && !TextUtils.isEmpty(bundleA.getString("queryCopy"))) {
                        bundleA.putString("query", bundleA.getString("queryCopy"));
                    }
                } else {
                    bundleA = null;
                }
                objectRef.element = OffScreenWebviewPool.f30871a.i(com.cloud.tmc.kernel.utils.i.b(strValueOf, bundleA));
            }
            if (objectRef.element == 0) {
                objectRef.element = activity != null ? ((IInnerH5WebviewPool) tc.a.a(IInnerH5WebviewPool.class)).getWebview(activity) : 0;
            }
            T t11 = objectRef.element;
            if (t11 == 0) {
                Page page4 = z12 ? (Page) node : null;
                objectRef.element = new j(activity, iEngine, node, createParams, (page4 == null || (app5 = page4.getApp()) == null || (appModel2 = app5.getAppModel()) == null) ? MiniAppType.NORMAL.ordinal() : appModel2.getAppinfoCategoryType());
            } else {
                i iVar = (i) t11;
                Page page5 = z12 ? (Page) node : null;
                iVar.setMiniAppType((page5 == null || (app4 = page5.getApp()) == null || (appModel = app4.getAppModel()) == null) ? MiniAppType.NORMAL.ordinal() : appModel.getAppinfoCategoryType());
            }
        } else {
            Page page6 = z12 ? (Page) node : null;
            Integer numValueOf = (page6 == null || (app3 = page6.getApp()) == null) ? null : Integer.valueOf(app3.getPageType(page6.getPagePath()));
            if (numValueOf != null && numValueOf.intValue() == 2) {
                Page page7 = z12 ? (Page) node : null;
                Bundle startParams2 = (page7 == null || (app2 = page7.getApp()) == null) ? null : app2.getStartParams();
                Page page8 = z12 ? (Page) node : null;
                Bundle sceneParams = (page8 == null || (app = page8.getApp()) == null) ? null : app.getSceneParams();
                String string = startParams2 != null ? startParams2.getString("pageCopy") : null;
                if (TextUtils.isEmpty(string) || string == null) {
                    obj = null;
                } else {
                    obj = null;
                    if (kotlin.text.l.L(string, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null) && AppUtils.t(sceneParams, string)) {
                        objectRef.element = OffScreenWebviewPool.f30871a.i(string);
                    }
                }
                if (objectRef.element == 0) {
                    objectRef.element = activity != null ? ((IInnerH5WebviewPool) tc.a.a(IInnerH5WebviewPool.class)).getWebview(activity) : obj;
                }
                T t12 = objectRef.element;
                if (t12 == 0) {
                    objectRef.element = new j(activity, iEngine, node, createParams, MiniAppType.SHELL.ordinal());
                } else {
                    ((i) t12).setMiniAppType(MiniAppType.SHELL.ordinal());
                }
            }
        }
        if (node instanceof PageNode) {
        }
        if (objectRef.element == 0) {
            ((IInnerRenderPool) tc.a.a(IInnerRenderPool.class)).registerListener(new a(longRef, longRef2, iEngine, longRef3, node, this, activity, createParams, pageId, context, listener, data), z11, ((IPackageConfig) tc.a.a(IPackageConfig.class)).getFrameworkVersion());
        } else {
            longRef.element = 0L;
            e.f(new Runnable() { // from class: fb.e
                @Override // java.lang.Runnable
                public final void run() {
                    RenderFactory.c(node, this, activity, iEngine, createParams, pageId, context, objectRef, listener, longRef, longRef2, longRef3, data);
                }
            });
        }
    }

    public final String getTAG() {
        return this.f30708a;
    }
}
