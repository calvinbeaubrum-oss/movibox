package com.cloud.tmc.integration.structure.node;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.model.TabBarManualConfigStore;
import com.cloud.tmc.integration.point.OnDestroyPagePoint;
import com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.EmbedType;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.d0;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.integration.utils.x;
import com.cloud.tmc.kernel.engine.EngineRouterManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.CreateParams;
import com.cloud.tmc.kernel.node.DataNode;
import com.cloud.tmc.kernel.node.NodeInstance;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.render.IRenderFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import lb.j;
import zc.i;
import zc.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PageNode extends NodeInstance implements Page {
    private static final String TAG = "TmcApp:Page";
    private PageNode embedPage;
    private boolean isHomePage;
    private boolean isTabPage;
    private boolean mAlreadyPerformBack;
    private Page.c mExitListener;
    private boolean mIsDestroyed;
    private boolean mIsExited;
    private boolean mIsHide;
    protected tb.d mPageContext;
    private final String mPageId;
    private boolean mPageLoaded;
    private String mPagePath;
    private String mPageRandomIdByGAId;
    private String mPageURI;
    private i mRender;
    private boolean mRenderReady;
    private final List<Page.d> mRenderReadyListeners;
    private Bundle mSceneParams;
    private Bundle mStartParams;
    private PageChainContext pageChainContext;
    private String screenOrientation;
    private static final AtomicInteger sPageIdCounter = new AtomicInteger(0);
    public static final Parcelable.Creator<PageNode> CREATOR = new c();

    /* JADX INFO: compiled from: source.java */
    public class a implements IRenderFactory.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f30939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Page.b f30940b;

        public a(Bundle bundle, Page.b bVar) {
            this.f30939a = bundle;
            this.f30940b = bVar;
        }

        @Override // com.cloud.tmc.render.IRenderFactory.a
        public void a(@NonNull i iVar) {
            PageNode.this.mRender = iVar;
            if (PageNode.this.getApp() != null) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(PageNode.this.getApp() == null ? null : PageNode.this.getApp().getAppId(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31221l, this.f30939a);
                ((IUpdateLoadingStepProxy) tc.a.a(IUpdateLoadingStepProxy.class)).notifyUpdateLoadingStep(PageNode.this.getApp().getAppId(), LoadStepAction.STEP_FINISH_CREAT_RENDER);
                ((EngineRouterManager) tc.a.a(EngineRouterManager.class)).get(PageNode.this.getApp().getStartToken()).registerRender(PageNode.this.mRender.b(), PageNode.this.mRender);
                this.f30940b.success();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements zc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f30942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Page.e f30943b;

        public b(boolean z11, Page.e eVar) {
            this.f30942a = z11;
            this.f30943b = eVar;
        }

        @Override // zc.b
        public void a(boolean z11) {
            PageNode.this.doExit(this.f30942a, this.f30943b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Parcelable.Creator<PageNode> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PageNode createFromParcel(Parcel parcel) {
            return new PageNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PageNode[] newArray(int i11) {
            return new PageNode[i11];
        }
    }

    public PageNode(Parcel parcel) {
        super(parcel);
        this.mIsDestroyed = false;
        this.mIsExited = false;
        this.mIsHide = false;
        this.mPageLoaded = false;
        this.mAlreadyPerformBack = false;
        this.isTabPage = false;
        this.isHomePage = false;
        this.mPageId = sPageIdCounter.addAndGet(1) + "";
        this.mRenderReadyListeners = new ArrayList();
        this.mPageURI = parcel.readString();
        this.mPagePath = parcel.readString();
        this.mStartParams = parcel.readBundle(Page.class.getClassLoader());
        this.mSceneParams = parcel.readBundle(Page.class.getClassLoader());
    }

    public PageNode(App app, String str, String str2, Bundle bundle, Bundle bundle2) {
        this(app, str, str2, bundle, bundle2, EmbedType.NO);
    }

    public PageNode(App app, String str, String str2, Bundle bundle, Bundle bundle2, EmbedType embedType) {
        super(app);
        this.mIsDestroyed = false;
        this.mIsExited = false;
        this.mIsHide = false;
        this.mPageLoaded = false;
        this.mAlreadyPerformBack = false;
        this.isTabPage = false;
        this.isHomePage = false;
        this.mPageId = sPageIdCounter.addAndGet(1) + "";
        this.mRenderReadyListeners = new ArrayList();
        init(str, str2, bundle, bundle2);
    }

    @Deprecated
    public PageNode(App app, String str, String str2, Bundle bundle, Bundle bundle2, boolean z11) {
        this(app, str, str2, bundle, bundle2, z11 ? EmbedType.FULL : EmbedType.NO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doExit(boolean z11, Page.e eVar) {
        TmcLogger.c(TAG, "PageNode " + this + " doExit!");
        TmcLogger.c(TAG, "PageNode " + this + " doExit onComplete");
        if (isUseForEmbed()) {
            destroy();
            onFinalized();
        } else if (getApp() != null) {
            getApp().removePage(this, z11, eVar);
        }
    }

    private String getWorkerId() {
        j jVar = (j) getData(j.class);
        return jVar != null ? jVar.f70208a : "";
    }

    private void initCheckHomePage() {
        try {
            App app = getApp();
            if (app == null) {
                return;
            }
            String homePagePath = app.getHomePagePath();
            if (!TextUtils.isEmpty(homePagePath) && TextUtils.equals(Uri.parse(getPagePath()).getPath(), homePagePath)) {
                this.isHomePage = true;
            }
        } catch (Exception e11) {
            TmcLogger.h(TAG, e11);
        }
    }

    private void initCheckTabPage() {
        List<MiniAppConfigModel.TabBarBean.ListBean> list;
        try {
            MiniAppConfigModel.TabBarBean tabBarConfig = getTabBarConfig();
            if (tabBarConfig == null || (list = tabBarConfig.list) == null) {
                return;
            }
            Iterator<MiniAppConfigModel.TabBarBean.ListBean> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().pagePath, Uri.parse(getPagePath()).getPath())) {
                    this.isTabPage = true;
                    return;
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g(TAG, "initCheckTabPage", th2);
        }
    }

    private void initGeneralRandomId() {
        String strB = x.b();
        this.mPageRandomIdByGAId = strB;
        TmcLogger.c(TAG, String.format("initGeneralRandomId: %s pagePath: %s", strB, getPagePath()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$backPressed$1(boolean z11) {
        if (getApp() == null) {
            TmcLogger.c(TAG, "goBack afterProcess but app is null!");
            return;
        }
        TmcLogger.c(TAG, "goBack afterProcess intercept: " + z11);
        if (!z11) {
            tb.b appContext = getApp().getAppContext();
            boolean zIsRootFragment = isRootFragment();
            if ((getApp().getChildCount() == 1 || isTabPage() || zIsRootFragment) && appContext != null && appContext.getContext() != null && appContext.c()) {
                if (getApp().getBackPressedProcessor().startBackPressedInterceptorChain(new qb.a.c(appContext.getContext(), getApp().getAppId(), (AppNode) getApp(), false, 1)).a()) {
                    return;
                }
                if (getApp().getAppId().equals("1000550440273772544")) {
                    getApp().exit();
                    TmcLogger.c(TAG, "goBack and removeTask");
                    return;
                } else if (appContext.b()) {
                    TmcLogger.c(TAG, "goBack keep alive intercept");
                    return;
                }
            }
        }
        if (z11 || this.mAlreadyPerformBack) {
            return;
        }
        performBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$backPressed$2(final boolean z11) {
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: com.cloud.tmc.integration.structure.node.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f30951a.lambda$backPressed$1(z11);
            }
        });
    }

    private static /* synthetic */ DataNode lambda$bindContext$0(String str) {
        TmcLogger.c(TAG, "onVisitStart:" + str);
        return null;
    }

    @Override // com.cloud.tmc.kernel.node.NodeInstance, com.cloud.tmc.kernel.node.Node
    public void addFixedView(@NonNull View view) {
        Object objU = this.mPageContext.u();
        if (objU instanceof ViewGroup) {
            TmcLogger.e("addFixedView success. parent " + objU);
            ((ViewGroup) objU).addView(view);
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page, com.cloud.tmc.kernel.node.a
    public void addOnKeyboardListener(@NonNull nc.a aVar) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.a) {
            ((vb.a) dVar).addOnKeyboardListener(aVar);
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void addRenderReadyListener(Page.d dVar) {
        synchronized (this.mRenderReadyListeners) {
            try {
                if (this.mRenderReady) {
                    dVar.a();
                }
                this.mRenderReadyListeners.add(dVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean backPressed() {
        i iVar = this.mRender;
        if (iVar == null) {
            return true;
        }
        iVar.l(new zc.c() { // from class: com.cloud.tmc.integration.structure.node.d
            @Override // zc.c
            public final void a(boolean z11) {
                this.f30953a.lambda$backPressed$2(z11);
            }
        });
        return true;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void bindContext(tb.d dVar, Boolean bool, Page.b bVar) {
        this.mPageContext = dVar;
        CreateParams createParams = new CreateParams();
        createParams.startParams = getStartParams();
        createParams.useForEmbed = isUseForEmbed();
        createParams.urlVisitListener = new sc.a() { // from class: com.cloud.tmc.integration.structure.node.e
        };
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, getApp().getStartParams().getString("uniqueChainID", "-1"));
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, getPagePath());
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.X, getPageId());
        Bundle bundle2 = new Bundle();
        bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, getPagePath());
        bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, getPageId());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(getApp() == null ? null : getApp().getAppId(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31221l, bundle);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(getApp() == null ? null : getApp().getAppId(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.G, bundle2);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(getApp() != null ? getApp().getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.G, bundle2);
        new db.d(bundle2).f(getPageChainContext());
        ((IRenderFactory) tc.a.a(IRenderFactory.class)).getRender(dVar.getActivity(), getApp().getEngineProxy(), this, createParams, this.mPageId, dVar, bundle2, bool.booleanValue(), new a(bundle, bVar));
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void changeNavigationBarProgress(int i11, int i12, long j11) {
        tb.d dVar = this.mPageContext;
        if (!(dVar instanceof vb.c) || ((vb.c) dVar).C()) {
            return;
        }
        ((vb.c) this.mPageContext).changeNavigationBarProgress(i11, i12, j11);
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public String createPageRandomIdByGAID() {
        return x.b();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public final void destroy() {
        if (this.mIsDestroyed) {
            return;
        }
        this.mIsDestroyed = true;
        if (this.mRender != null && getApp().getEngineProxy() != null) {
            getApp().getEngineProxy().getEngineRouter().unRegisterRender(this.mRender.b());
        }
        i iVar = this.mRender;
        if (iVar != null) {
            iVar.destroy();
        }
        tb.d dVar = this.mPageContext;
        if (dVar != null) {
            dVar.destroy();
        }
        ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).clearEventCenterInstance(this);
        onDestroy();
        onFinalized();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public final void enter() {
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public final synchronized void exit(boolean z11) {
        exit(z11, null);
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public final synchronized void exit(boolean z11, Page.e eVar) {
        if (this.mIsExited) {
            TmcLogger.o(TAG, "already exited!");
            return;
        }
        TmcLogger.c(TAG, "exit " + toString() + " by stack " + Log.getStackTraceString(new Throwable("Just Print")));
        this.mIsExited = true;
        i iVar = this.mRender;
        if (iVar != null) {
            iVar.s(new b(z11, eVar));
        } else {
            doExit(z11, eVar);
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean getAddScreenVisibleStatus() {
        try {
            tb.d dVar = this.mPageContext;
            if (dVar == null || dVar.x() == null) {
                return false;
            }
            return this.mPageContext.x().getAddScreenVisibility();
        } catch (Throwable th2) {
            TmcLogger.h("hide->error", th2);
            return false;
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public App getApp() {
        return (App) getParentNode();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    @Nullable
    public AppLoadResult getAppLoadResult() {
        return (AppLoadResult) com.cloud.tmc.kernel.utils.a.d(getSceneParams(), "appLoadResult");
    }

    public PageNode getEmbedPage() {
        return this.embedPage;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public com.cloud.tmc.kernel.extension.e getExtensionManager() {
        return NodeInstance.sExtensionManager;
    }

    @Override // com.cloud.tmc.kernel.node.NodeInstance, com.cloud.tmc.kernel.node.DataNode, com.cloud.tmc.kernel.node.Node
    public dd.d getGroup() {
        return getApp().getGroup();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public String getOriginalURI() {
        return this.mPageURI;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public PageChainContext getPageChainContext() {
        return this.pageChainContext;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    @Nullable
    public tb.d getPageContext() {
        return this.mPageContext;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public String getPageId() {
        return this.mPageId;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public String getPagePath() {
        return this.mPagePath;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    @Nullable
    public String getPageRandomIdByGAId() {
        if (TextUtils.isEmpty(this.mPageRandomIdByGAId)) {
            initGeneralRandomId();
        }
        return this.mPageRandomIdByGAId;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public String getPageURI() {
        return this.mPageURI;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public i getRender() {
        return this.mRender;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public Bundle getSceneParams() {
        return this.mSceneParams;
    }

    @Override // com.cloud.tmc.integration.structure.Page, com.cloud.tmc.kernel.node.d
    public Class<? extends com.cloud.tmc.kernel.node.d> getScopeType() {
        return Page.class;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public Bundle getStartParams() {
        return this.mStartParams;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    @Nullable
    public MiniAppConfigModel.TabBarBean getTabBarConfig() {
        MiniAppConfigModel miniAppConfigModel;
        TabBarManualConfigStore tabBarManualConfigStore;
        AppLoadResult appLoadResult = getAppLoadResult();
        if (appLoadResult == null || (miniAppConfigModel = appLoadResult.appConfigModel) == null) {
            return null;
        }
        if (!miniAppConfigModel.tabBarManual()) {
            return miniAppConfigModel.tabBar;
        }
        App app = getApp();
        if (app == null || (tabBarManualConfigStore = (TabBarManualConfigStore) app.getData(TabBarManualConfigStore.class)) == null) {
            return null;
        }
        return tabBarManualConfigStore.getTabBarConfig();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public MiniAppConfigModel.WindowBean getWindow() {
        return d0.f(getAppLoadResult(), getPagePath());
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public final void hide() {
        if (this.mIsHide) {
            TmcLogger.o(TAG, "already hide! " + this);
            return;
        }
        this.mIsHide = true;
        TmcLogger.o(TAG, "hide! " + this);
        TmcLogger.c(TAG, "sendToView page event pagePause");
        onHide();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void hideAddScreenButton() {
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void hideHomeButton() {
        tb.d dVar = this.mPageContext;
        if (dVar == null || dVar.x() == null) {
            return;
        }
        this.mPageContext.x().setHomeVisibility(false);
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void hideNavigationBarLoading() {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.c) {
            ((vb.c) dVar).hideNavigationBarLoading();
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean hideTabBar(boolean z11) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.b) {
            return ((vb.b) dVar).hideTabBar(z11);
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean hideTabBarRedDot(int i11) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.b) {
            return ((vb.b) dVar).hideTabBarRedDot(i11);
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean hideTabBarUnreadIcon(int i11) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.b) {
            return ((vb.b) dVar).hideTabBarUnreadIcon(i11);
        }
        return false;
    }

    public void init(String str, String str2, Bundle bundle, Bundle bundle2) {
        TmcLogger.c(TAG, "init Page with url: " + str + ", pagePath: " + str2 + ", startParams: " + bundle);
        this.mPageURI = str;
        this.mPagePath = str2;
        this.mStartParams = bundle;
        this.mSceneParams = bundle2;
        initCheckTabPage();
        initCheckHomePage();
        initGeneralRandomId();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean isExited() {
        return this.mIsExited;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean isHide() {
        return this.mIsHide;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean isHomePage() {
        return this.isHomePage;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean isPageLoaded() {
        return this.mPageLoaded;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean isRenderReady() {
        boolean z11;
        synchronized (this.mRenderReadyListeners) {
            z11 = this.mRenderReady;
        }
        return z11;
    }

    public boolean isRootFragment() {
        com.cloud.tmc.integration.ui.fragment.a aVarK;
        try {
            App app = getApp();
            if (app == null) {
                return false;
            }
            tb.b appContext = app.getAppContext();
            if (!(appContext instanceof com.cloud.tmc.integration.structure.app.b) || (aVarK = ((com.cloud.tmc.integration.structure.app.b) appContext).k()) == null) {
                return false;
            }
            return aVarK.i(this);
        } catch (Throwable th2) {
            TmcLogger.g(TAG, "Failed to isRootFragment", th2);
            return false;
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean isShow() {
        return !isHide();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean isTabPage() {
        return this.isTabPage;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean isTransparent() {
        tb.d dVar = this.mPageContext;
        if (dVar == null || dVar.x() == null) {
            return false;
        }
        return this.mPageContext.x().isTransparent();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean isUseForEmbed() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    @Override // com.cloud.tmc.integration.structure.Page
    public boolean loadTabBar(@NonNull MiniAppConfigModel.TabBarBean tabBarBean) {
        String templateMiniappId;
        AppModel appModel;
        if (!(this.mPageContext instanceof vb.b)) {
            return false;
        }
        App app = getApp();
        if (app == null || (appModel = app.getAppModel()) == null) {
            templateMiniappId = "";
        } else if (AppUtils.f31011a.g(Integer.valueOf(appModel.getMiniappSubtype().intValue()))) {
            templateMiniappId = appModel.getTemplateMiniappId();
        } else {
            templateMiniappId = "";
        }
        return ((vb.b) this.mPageContext).n(tabBarBean, templateMiniappId);
    }

    public void onDestroy() {
        ((OnDestroyPagePoint) ib.a.b(OnDestroyPagePoint.class).g(this).e(getExtensionManager()).d()).onDestroy(getApp(), this, getExtensionManager());
    }

    public void onEnter() {
        TmcLogger.c(TAG, "onEnter " + this.mPageURI);
        l lVar = new l();
        lVar.f81893a = this.mPageURI;
        this.mRender.k(lVar);
    }

    public void onHide() {
    }

    public void onPause() {
        this.mRender.onPause();
    }

    public void onResume() {
        this.mRender.onResume();
    }

    public void onShow() {
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public final void pause() {
        onPause();
    }

    public synchronized void performBack() {
        this.mAlreadyPerformBack = true;
        getApp().performBack();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void refreshApp() {
        tb.d dVar = this.mPageContext;
        if (dVar != null) {
            dVar.refreshApp();
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void reload() {
        i iVar = this.mRender;
        if (iVar != null) {
            iVar.reload();
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page, com.cloud.tmc.kernel.node.a
    public void removeOnKeyboardListener(@NonNull nc.a aVar) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.a) {
            ((vb.a) dVar).removeOnKeyboardListener(aVar);
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean removeTabBarBadge(int i11) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.b) {
            return ((vb.b) dVar).removeTabBarBadge(i11);
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public String resetPageRandomIdByGAID() {
        initGeneralRandomId();
        return this.mPageRandomIdByGAId;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public final void resume() {
        App.PopParams popParams = (App.PopParams) getApp().getData(App.PopParams.class);
        if (popParams != null) {
            new JsonObject().add("data", popParams.data);
            getApp().setData(App.PopParams.class, null);
        }
        onResume();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setCapsuleStyle(boolean z11) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.c) {
            ((vb.c) dVar).setCapsuleStyle(z11);
        }
    }

    public void setEmbedPage(PageNode pageNode) {
        this.embedPage = pageNode;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setExitListener(Page.c cVar) {
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setHomeAction(int i11, boolean z11) {
        tb.d dVar = this.mPageContext;
        if (dVar == null || dVar.x() == null) {
            return;
        }
        this.mPageContext.x().setHomeAction(i11, z11);
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setNavigationBarBackgroundColor(String str) {
        tb.d dVar = this.mPageContext;
        if (dVar == null || dVar.x() == null) {
            return;
        }
        try {
            if (!(this.mPageContext.x() instanceof View) || TextUtils.isEmpty(str)) {
                return;
            }
            ((View) this.mPageContext.x()).setBackgroundColor(Color.parseColor(str));
        } catch (Exception e11) {
            TmcLogger.h("[PageNode]: set navigation bar color error", e11);
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setNavigationBarIconStyle(boolean z11) {
        setCapsuleStyle(z11);
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.c) {
            ((vb.c) dVar).setNavigationBarIconStyle(z11);
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setNavigationBarTitle(String str) {
        tb.d dVar = this.mPageContext;
        if (dVar == null || dVar.x() == null) {
            return;
        }
        this.mPageContext.x().setTitle(str);
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setNavigationBarTitleColor(boolean z11) {
        setStatusBar(z11);
        tb.d dVar = this.mPageContext;
        if (dVar == null || dVar.x() == null) {
            return;
        }
        this.mPageContext.x().setTitleColor(z11);
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setNavigationBarTitleVisible(boolean z11) {
        tb.d dVar = this.mPageContext;
        if (dVar == null || dVar.x() == null) {
            return;
        }
        this.mPageContext.x().setTitleVisible(z11);
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setNavigationBarTransparent(boolean z11) {
        tb.d dVar = this.mPageContext;
        if (dVar == null || dVar.x() == null) {
            return;
        }
        this.mPageContext.x().setTransparent(z11);
        ViewGroup viewGroupV = this.mPageContext.v();
        Object objU = this.mPageContext.u();
        ProgressBar progressBarS = this.mPageContext.S();
        if ((viewGroupV instanceof ConstraintLayout) && (objU instanceof FrameLayout)) {
            androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
            ConstraintLayout constraintLayout = (ConstraintLayout) viewGroupV;
            bVar.p(constraintLayout);
            if (Boolean.TRUE.equals(Boolean.valueOf(z11))) {
                bVar.s(((FrameLayout) objU).getId(), 3, 0, 3);
            } else if (progressBarS != null) {
                bVar.s(((FrameLayout) objU).getId(), 3, progressBarS.getId(), 4);
            }
            bVar.i(constraintLayout);
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setPageChainContext(PageChainContext pageChainContext) {
        this.pageChainContext = pageChainContext;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setPageLoaded() {
        this.mPageLoaded = true;
    }

    public void setPageURI(String str) {
        this.mPageURI = str;
    }

    public void setRender(i iVar) {
        this.mRender = iVar;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setStatusBar(boolean z11) {
        Activity activity = this.mPageContext.getActivity();
        if (activity == null) {
            return;
        }
        if (z11) {
            e0.c(activity);
        } else {
            e0.b(activity);
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean setTabBarBadge(int i11, @Nullable String str) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.b) {
            return ((vb.b) dVar).setTabBarBadge(i11, str);
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean setTabBarItem(int i11, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        List<MiniAppConfigModel.TabBarBean.ListBean> list;
        MiniAppConfigModel miniAppConfigModel;
        if (this.mPageContext instanceof vb.b) {
            AppLoadResult appLoadResult = getAppLoadResult();
            boolean zTabBarManual = (appLoadResult == null || (miniAppConfigModel = appLoadResult.appConfigModel) == null) ? false : miniAppConfigModel.tabBarManual();
            MiniAppConfigModel.TabBarBean.ListBean listBean = new MiniAppConfigModel.TabBarBean.ListBean();
            MiniAppConfigModel.TabBarBean tabBarConfig = getTabBarConfig();
            if (tabBarConfig != null && (list = tabBarConfig.list) != null && !list.isEmpty()) {
                List<MiniAppConfigModel.TabBarBean.ListBean> list2 = tabBarConfig.list;
                if (i11 >= list2.size() || i11 < 0) {
                    TmcLogger.c(TAG, "Index out of tab list range: " + i11 + " , page: " + this);
                    return false;
                }
                MiniAppConfigModel.TabBarBean.ListBean listBean2 = list2.get(i11);
                if (listBean2 == null) {
                    TmcLogger.c(TAG, "Tab bar's list is null");
                    return false;
                }
                if (zTabBarManual) {
                    listBean = listBean2;
                } else {
                    listBean.pagePath = listBean2.pagePath;
                    listBean.text = listBean2.text;
                    listBean.iconPath = listBean2.iconPath;
                    listBean.selectedIconPath = listBean2.selectedIconPath;
                }
                if (str != null) {
                    listBean.text = str;
                }
                if (str2 != null) {
                    listBean.iconPath = str2;
                }
                if (str3 != null) {
                    listBean.selectedIconPath = str3;
                }
                return ((vb.b) this.mPageContext).X(i11, listBean);
            }
            TmcLogger.c(TAG, "It's not tab bar page:" + this);
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean setTabBarItems(@NonNull JsonArray jsonArray) {
        List<MiniAppConfigModel.TabBarBean.ListBean> list;
        MiniAppConfigModel miniAppConfigModel;
        ArrayList<MiniAppConfigModel.TabBarBean.ListBean> arrayList = new ArrayList<>();
        try {
            AppLoadResult appLoadResult = getAppLoadResult();
            boolean zTabBarManual = (appLoadResult == null || (miniAppConfigModel = appLoadResult.appConfigModel) == null) ? false : miniAppConfigModel.tabBarManual();
            MiniAppConfigModel.TabBarBean tabBarConfig = getTabBarConfig();
            if (tabBarConfig != null && (list = tabBarConfig.list) != null && !list.isEmpty()) {
                if (jsonArray.size() != tabBarConfig.list.size()) {
                    TmcLogger.c(TAG, "set tab size mismatch with tab list count");
                    return false;
                }
                for (int i11 = 0; i11 < jsonArray.size(); i11++) {
                    MiniAppConfigModel.TabBarBean.ListBean listBean = new MiniAppConfigModel.TabBarBean.ListBean();
                    JsonObject asJsonObject = jsonArray.get(i11).getAsJsonObject();
                    MiniAppConfigModel.TabBarBean.ListBean listBean2 = tabBarConfig.list.get(i11);
                    if (listBean2 == null) {
                        TmcLogger.c(TAG, "Tab bar's list is null, i: " + i11);
                        return false;
                    }
                    if (zTabBarManual) {
                        listBean = listBean2;
                    } else {
                        listBean.pagePath = listBean2.pagePath;
                        listBean.text = listBean2.text;
                        listBean.iconPath = listBean2.iconPath;
                        listBean.selectedIconPath = listBean2.selectedIconPath;
                    }
                    JsonElement jsonElement = asJsonObject.get(MimeTypes.BASE_TYPE_TEXT);
                    JsonElement jsonElement2 = asJsonObject.get("iconPath");
                    JsonElement jsonElement3 = asJsonObject.get("selectedIconPath");
                    if (jsonElement != null) {
                        listBean.text = jsonElement.getAsString();
                    }
                    if (jsonElement2 != null) {
                        listBean.iconPath = jsonElement2.getAsString();
                    }
                    if (jsonElement3 != null) {
                        listBean.selectedIconPath = jsonElement3.getAsString();
                    }
                    arrayList.add(listBean);
                }
                if (arrayList.isEmpty()) {
                    TmcLogger.c(TAG, "tempTabs is empty");
                    return false;
                }
                tb.d dVar = this.mPageContext;
                if (dVar instanceof vb.b) {
                    return ((vb.b) dVar).j(arrayList);
                }
                TmcLogger.c(TAG, "mPageContext is not TabBarAction, returning false");
                return false;
            }
            TmcLogger.c(TAG, "It's not tab bar page:" + this);
            return false;
        } catch (Throwable th2) {
            TmcLogger.g(TAG, "setTabBarItems json parse is error", th2);
            return false;
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean setTabBarStyle(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.b) {
            return ((vb.b) dVar).setTabBarStyle(str, str2, str3, str4);
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setTabPage(boolean z11) {
        this.isTabPage = z11;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void setTitleBarVisible(boolean z11) {
        tb.d dVar = this.mPageContext;
        if (dVar == null || dVar.x() == null) {
            return;
        }
        this.mPageContext.x().setTitleBarVisible(z11);
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public final void show() {
        if (!this.mIsHide) {
            TmcLogger.o(TAG, "already show! " + this);
            return;
        }
        this.mIsHide = false;
        TmcLogger.o(TAG, "show! " + this);
        if (!isUseForEmbed()) {
            TmcLogger.c(TAG, "sendToView page event pageResume");
        }
        onShow();
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void showAddScreenButton() {
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void showHomeButton() {
        tb.d dVar = this.mPageContext;
        if (dVar == null || dVar.x() == null) {
            return;
        }
        this.mPageContext.x().setHomeVisibility(true);
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public void showNavigationBarLoading() {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.c) {
            ((vb.c) dVar).showNavigationBarLoading();
        }
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean showTabBar(boolean z11) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.b) {
            return ((vb.b) dVar).showTabBar(z11);
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.structure.Page
    public boolean showTabBarRedDot(int i11) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.b) {
            return ((vb.b) dVar).showTabBarRedDot(i11);
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.structure.Page, com.cloud.tmc.kernel.node.e
    public void showTabBarUnreadIcon(int i11, @NonNull String str, @Nullable Function1<? super Boolean, Unit> function1) {
        tb.d dVar = this.mPageContext;
        if (dVar instanceof vb.b) {
            ((vb.b) dVar).showTabBarUnreadIcon(i11, str, function1);
        }
    }

    @NonNull
    public String toString() {
        return getClass().getSimpleName() + "@" + hashCode() + "@uri=" + getPageURI() + "?path=" + getPagePath();
    }

    @Override // com.cloud.tmc.kernel.node.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        super.writeToParcel(parcel, i11);
        parcel.writeString(this.mPageURI);
        parcel.writeString(this.mPagePath);
        parcel.writeBundle(this.mStartParams);
        parcel.writeBundle(this.mSceneParams);
    }
}
