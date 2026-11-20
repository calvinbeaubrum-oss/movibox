package com.cloud.tmc.integration.structure.node;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.tmc.integration.bridge.NetworkBridge;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.MiniAppAutoPopover;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.model.TabReSelectedStore;
import com.cloud.tmc.integration.point.OnDestroyAppPoint;
import com.cloud.tmc.integration.point.OnPauseAppPoint;
import com.cloud.tmc.integration.point.OnResumeAppPoint;
import com.cloud.tmc.integration.point.OnStopAppPoint;
import com.cloud.tmc.integration.processor.BackPressedProcessor;
import com.cloud.tmc.integration.processor.IBackPressedProcessor;
import com.cloud.tmc.integration.proxy.PageFactory;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.LatestUseUtils;
import com.cloud.tmc.integration.utils.f0;
import com.cloud.tmc.integration.utils.m0;
import com.cloud.tmc.integration.utils.n0;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.NodeInstance;
import com.cloud.tmc.kernel.proxy.core.IEngineFactory;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.cloud.tmc.kernel.security.DefaultGroup;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import lb.h;
import lb.j;
import ua.f;
import ua.g;
import ua.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AppNode extends NodeInstance implements App {
    public static final Parcelable.Creator<AppNode> CREATOR = new e();
    private static final String TAG = "TmcApp:App";
    private boolean APIAddhomeShowStatus;
    private boolean MFAHShowStatus;
    private ua.d appCallback;
    private wa.a appChainContext;
    protected String appId;
    private boolean asyncLaunchStatus;
    private IBackPressedProcessor backPressedProcessor;
    private String backToPagePath;
    private f checkMiniAppLifecycleCallback;
    private String currentInterectCallbackId;
    private Boolean currentMFAHStatus;
    private boolean guideBackAddhomeShowStatus;
    private boolean guideBottomAddhomeShowStatus;
    private boolean guideTopAddhomeShowStatus;
    private ua.e iAsyncStartLoadingCallback;
    private boolean isHideMiniAppLoaingStatus;
    private g loadHtmlDataCallback;
    private boolean mAlreadyStarted;
    protected tb.b mAppContext;
    private AppLoadResult mAppLoadResult;
    protected AppManager mAppManager;
    private AppModel mAppModel;
    protected String mAppType;
    protected String mAppVersion;
    private IEngine mEngineProxy;
    private boolean mHasPaused;
    protected gc.a mImmutableStartParams;
    private final AtomicBoolean mIsDestroyed;
    private boolean mIsExited;
    private String mMainJSUrl;
    private NetworkUtil.d mNetworkListener;
    private final List<App.a> mPageReadyListeners;
    private HashMap<String, Integer> mPagesType;
    private boolean mPendingOnStart;
    private LinkedHashMap<String, Runnable> mPermissionDialogMap;
    private final HashMap<String, String> mRouteType;
    protected Bundle mSceneParams;
    private boolean mSendResumeInRestart;
    protected Bundle mStartParams;
    protected long mStartToken;
    private String mStartUrl;
    private Future<Boolean> mWaitLoadFuture;
    private MiniAppAutoPopover miniAppAutoPopover;
    private boolean miniappLoadSuccess;
    private boolean restarting;
    private i showAddhomeCallback;
    private long startTime;
    private Page targetPageOnProcess;

    /* JADX INFO: compiled from: source.java */
    public class a implements ic.a {
        public a() {
        }

        @Override // ic.a
        public void a(boolean z11, @Nullable String str) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ic.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f30935a;

        public b(long j11) {
            this.f30935a = j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ic.a {
        public c() {
        }

        @Override // ic.a
        public void a(boolean z11, String str) {
            TmcLogger.c(AppNode.TAG, "EngineInitCallback initResult success: " + z11);
            if (z11) {
                AppNode.this.onEngineInitSuccess();
            } else {
                AppNode.this.onEngineInitFailed();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements NetworkUtil.d {
        public d() {
        }

        @Override // com.cloud.tmc.kernel.utils.NetworkUtil.d
        public void a(NetworkUtil.Network network, NetworkUtil.Network network2) {
            AppNode.this.sendNetworkChangeEvent(network2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Parcelable.Creator<AppNode> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppNode createFromParcel(Parcel parcel) {
            return new AppNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppNode[] newArray(int i11) {
            return new AppNode[i11];
        }
    }

    public AppNode(Parcel parcel) {
        super(parcel);
        this.mWaitLoadFuture = null;
        this.mHasPaused = false;
        this.mSendResumeInRestart = false;
        this.mAlreadyStarted = false;
        this.mIsExited = false;
        this.mPendingOnStart = false;
        this.mIsDestroyed = new AtomicBoolean(false);
        this.miniappLoadSuccess = false;
        this.targetPageOnProcess = null;
        this.mPagesType = new HashMap<>();
        this.mRouteType = new HashMap<>();
        this.backPressedProcessor = new BackPressedProcessor();
        this.mPermissionDialogMap = new LinkedHashMap<>();
        this.currentInterectCallbackId = null;
        this.currentMFAHStatus = Boolean.FALSE;
        this.startTime = 0L;
        this.asyncLaunchStatus = false;
        this.backToPagePath = "";
        this.iAsyncStartLoadingCallback = null;
        this.miniAppAutoPopover = null;
        this.isHideMiniAppLoaingStatus = false;
        this.restarting = false;
        this.mPageReadyListeners = new ArrayList();
        this.MFAHShowStatus = false;
        this.APIAddhomeShowStatus = false;
        this.guideBottomAddhomeShowStatus = false;
        this.guideTopAddhomeShowStatus = false;
        this.guideBackAddhomeShowStatus = false;
        this.appId = parcel.readString();
        this.mStartToken = parcel.readLong();
        this.mAppType = parcel.readString();
        this.mAppVersion = parcel.readString();
        this.mStartParams = parcel.readBundle(AppNode.class.getClassLoader());
        this.mSceneParams = parcel.readBundle(AppNode.class.getClassLoader());
        this.mStartUrl = parcel.readString();
    }

    public AppNode(AppManager appManager) {
        super(appManager);
        this.mWaitLoadFuture = null;
        this.mHasPaused = false;
        this.mSendResumeInRestart = false;
        this.mAlreadyStarted = false;
        this.mIsExited = false;
        this.mPendingOnStart = false;
        this.mIsDestroyed = new AtomicBoolean(false);
        this.miniappLoadSuccess = false;
        this.targetPageOnProcess = null;
        this.mPagesType = new HashMap<>();
        this.mRouteType = new HashMap<>();
        this.backPressedProcessor = new BackPressedProcessor();
        this.mPermissionDialogMap = new LinkedHashMap<>();
        this.currentInterectCallbackId = null;
        this.currentMFAHStatus = Boolean.FALSE;
        this.startTime = 0L;
        this.asyncLaunchStatus = false;
        this.backToPagePath = "";
        this.iAsyncStartLoadingCallback = null;
        this.miniAppAutoPopover = null;
        this.isHideMiniAppLoaingStatus = false;
        this.restarting = false;
        this.mPageReadyListeners = new ArrayList();
        this.MFAHShowStatus = false;
        this.APIAddhomeShowStatus = false;
        this.guideBottomAddhomeShowStatus = false;
        this.guideTopAddhomeShowStatus = false;
        this.guideBackAddhomeShowStatus = false;
        this.mAppManager = appManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doPushPage, reason: merged with bridge method [inline-methods] */
    public void lambda$pushPage$1(String str, Bundle bundle, Bundle bundle2) {
        Page activePage = getActivePage();
        if (activePage != null) {
            activePage.hide();
        }
        boolean z11 = AppUtils.q(bundle) || AppUtils.q(bundle2);
        PageNode pageNodeCreatePage = ((PageFactory) tc.a.a(PageFactory.class)).createPage(this, "https://100000.miniapp.transsion.com/index.html", str, bundle, bundle2);
        String string = bundle2.getString("navigationType");
        if (!TextUtils.isEmpty(string)) {
            m0.f(pageNodeCreatePage, string);
        }
        IEngine iEngine = this.mEngineProxy;
        if (iEngine == null) {
            pageNodeCreatePage.setData(j.class, new j(""));
        } else {
            pageNodeCreatePage.setData(j.class, new j(iEngine.getWorkerId()));
        }
        if (z11) {
            pageNodeCreatePage.setData(Page.a.class, new Page.a(true, false));
            pageNodeCreatePage.setData(lb.i.class, new lb.i(true));
        }
        pageNodeCreatePage.putStringValue("prePageId", activePage != null ? activePage.getPageId() : null);
        pushChild(pageNodeCreatePage);
        tb.b bVar = this.mAppContext;
        if (bVar != null) {
            bVar.f(pageNodeCreatePage);
        }
    }

    private void doRedirectTo(String str, PageNode pageNode) {
        String routeType = getRouteType(str, false);
        Page activePage = getActivePage();
        if (activePage != null) {
            activePage.hide();
            if (activePage.isTabPage()) {
                TmcLogger.c(TAG, "active page is tab page, path: " + activePage.getPagePath());
            } else {
                ((Page.a) activePage.getData(Page.a.class, true)).f30918b = false;
                activePage.putBooleanValue("exitPage", true);
                activePage.exit(false, new Page.e(0, pageNode, Page.SOURCE_NAVIGATE_BACK, routeType));
                pageNode.setData(Page.a.class, new Page.a(true, false));
                pageNode.setData(lb.i.class, new lb.i(true));
            }
        }
        pageNode.putStringValue("prePageId", activePage != null ? activePage.getPageId() : null);
        pushChild(pageNode);
        tb.b bVar = this.mAppContext;
        if (bVar != null) {
            bVar.f(pageNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$redirectTo$0(String str, PageNode pageNode, String str2) {
        doRedirectTo(str, pageNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEngineInitFailed() {
        TmcLogger.c(TAG, "onEngineInitFailed! type: " + getAppType());
        this.mAlreadyStarted = false;
        ((ToastProxy) tc.a.a(ToastProxy.class)).toast("Engine init failed!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEngineInitSuccess() {
        Runnable runnable = new Runnable() { // from class: com.cloud.tmc.integration.structure.node.AppNode.5
            @Override // java.lang.Runnable
            public void run() {
                AppModel appModel;
                TmcLogger.c(AppNode.TAG, "createPage " + AppNode.this.mStartUrl);
                Bundle bundleA = com.cloud.tmc.kernel.utils.a.a(AppNode.this.mStartParams);
                Bundle bundleA2 = com.cloud.tmc.kernel.utils.a.a(AppNode.this.mSceneParams);
                String str = (AppNode.this.mAppLoadResult == null || AppNode.this.mAppLoadResult.appConfigModel == null || AppNode.this.mAppLoadResult.appConfigModel.pages == null || AppNode.this.mAppLoadResult.appConfigModel.pages.isEmpty()) ? null : AppNode.this.mAppLoadResult.appConfigModel.pages.get(0);
                String string = bundleA.getString("page", str);
                if (AppUtils.t(bundleA2, string)) {
                    str = string;
                } else {
                    TmcLogger.c(AppNode.TAG, "Page invalid, use default page");
                }
                if (TextUtils.isEmpty(str)) {
                    TmcLogger.c(AppNode.TAG, "targetPagePath is null, app cannot start");
                    return;
                }
                AppNode.this.putStringValue("firstStartedPagePath", str);
                PageFactory pageFactory = (PageFactory) tc.a.a(PageFactory.class);
                AppNode appNode = AppNode.this;
                PageNode pageNodeCreatePage = pageFactory.createPage(appNode, appNode.mStartUrl, str, bundleA, bundleA2);
                if (AppNode.this.mEngineProxy == null) {
                    pageNodeCreatePage.setData(j.class, new j(""));
                } else {
                    pageNodeCreatePage.setData(j.class, new j(AppNode.this.mEngineProxy.getWorkerId()));
                }
                m0.f(pageNodeCreatePage, "onStart");
                App app = pageNodeCreatePage.getApp();
                if (app != null && (appModel = app.getAppModel()) != null && appModel.getAppinfoCategoryType() == MiniAppType.NORMAL.getType() && n0.h(str)) {
                    app.putPageType(str, 2);
                }
                AppNode appNode2 = AppNode.this;
                AppUtils.a(appNode2.mStartParams, appNode2.mSceneParams);
                AppNode.this.pushChild(pageNodeCreatePage);
                AppNode.this.mAppContext.e(pageNodeCreatePage);
                AppNode.this.onPageStarted(pageNodeCreatePage);
            }
        };
        Future<Boolean> future = this.mWaitLoadFuture;
        boolean z11 = future != null ? !future.isDone() : false;
        TmcLogger.c(TAG, "onEngineInitSuccess startPageAsync: " + z11);
        if (z11) {
            com.cloud.tmc.kernel.utils.e.a(ExecutorType.URGENT_DISPLAY, runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadResult(AppLoadResult appLoadResult, long j11) {
        if (!TextUtils.equals(appLoadResult.appType, this.mAppType)) {
            this.mEngineProxy = null;
            this.mAppType = appLoadResult.appType;
        }
        trySetupEngineProxy(appLoadResult.appType);
        this.mMainJSUrl = appLoadResult.mainJsUrl;
        this.mStartUrl = appLoadResult.mainHtmlUrl;
        this.mAppVersion = appLoadResult.appVersion;
        if (this.mAppContext == null) {
            TmcLogger.c(TAG, "onStart but appContext == null! move to pending!");
            this.mPendingOnStart = true;
        } else {
            setData(h.class, new h(j11));
            onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNetworkChangeEvent(NetworkUtil.Network network) {
        Page activePage = getActivePage();
        if (activePage == null || activePage.getRender() == null) {
            return;
        }
        String strK = NetworkUtil.k(network);
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.addProperty("isConnected", Boolean.valueOf(!DevicePublicKeyStringDef.NONE.equals(strK)));
        jsonObject.addProperty(NetworkBridge.KEY_NETWORK_TYPE, strK);
        jsonObject2.add("data", jsonObject);
    }

    private void sendPageBackToWorker(Page page, Page page2, Page.e eVar) {
        if (page == null) {
            return;
        }
        String pagePath = page2 != null ? page2.getPagePath() : "";
        int pageType = !TextUtils.isEmpty(pagePath) ? getPageType(pagePath) : 1;
        HashMap map = new HashMap();
        map.put("url", page.getPagePath());
        map.put("renderId", page.getPageId());
        map.put("exitedRenderId", page2 != null ? page2.getPageId() : "");
        map.put("needToExitNum", Integer.valueOf(eVar == null ? 0 : eVar.f30919a));
        String str = Page.SOURCE_NAVIGATE_BACK;
        map.put("scene", eVar == null ? Page.SOURCE_NAVIGATE_BACK : eVar.f30921c);
        if (eVar != null) {
            str = eVar.f30922d;
        }
        map.put("routeType", str);
        map.put("delta", 1);
        map.put("isMixedPage", Boolean.valueOf(pageType != 1));
        AppUtils.y(page, "pageBack", false, map);
    }

    private synchronized void trySetupEngineProxy(String str) {
        if (this.mEngineProxy != null && TextUtils.equals(str, this.mAppType)) {
            TmcLogger.c(TAG, "trySetupEngineProxy already setup with " + str);
            return;
        }
        TmcLogger.c(TAG, "trySetupEngineProxy with appType: " + str);
        String engineType = ((IEngineFactory) tc.a.a(IEngineFactory.class)).getEngineType(str);
        putStringValue("appEngineType", engineType);
        if (this.mAppContext == null) {
            TmcLogger.c(TAG, "trySetupEngineProxy cannot init without appContext!");
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mEngineProxy = ((IEngineFactory) tc.a.a(IEngineFactory.class)).createEngine(engineType, this, this.appId);
        rc.c cVar = new rc.c();
        cVar.f75177c = getStartToken();
        this.mEngineProxy.init(cVar, new a());
        if (!this.mEngineProxy.isReady()) {
            TmcLogger.c(TAG, "showLoading because engine not ready");
        }
        this.mEngineProxy.setup(this.mStartParams, this.mSceneParams, new b(jElapsedRealtime));
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void addPageReadyListener(App.a aVar) {
        synchronized (this.mPageReadyListeners) {
            try {
                TmcLogger.c(TAG, "addPageReadyListener");
                Page activePage = getActivePage();
                if (activePage != null) {
                    aVar.a(activePage);
                } else {
                    this.mPageReadyListeners.add(aVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    public final boolean backPressed() {
        Page activePage = getActivePage();
        if (activePage != null) {
            return activePage.backPressed();
        }
        destroy();
        return true;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void backToHeaderPage() {
        Page pageH0;
        tb.b bVar = this.mAppContext;
        TmcFragment tmcFragmentL = bVar instanceof com.cloud.tmc.integration.structure.app.b ? ((com.cloud.tmc.integration.structure.app.b) bVar).k().l() : null;
        if (tmcFragmentL == null || (pageH0 = tmcFragmentL.h0()) == null) {
            return;
        }
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            Page pageByIndex = getPageByIndex(i11);
            if (TextUtils.equals(pageByIndex.getPageId(), pageH0.getPageId()) || pageByIndex.isTabPage()) {
                break;
            }
            ((Page.a) pageByIndex.getData(Page.a.class, true)).f30918b = true;
            arrayList.add(pageByIndex);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Page) it.next()).exit(false);
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void bindContext(@NonNull tb.b bVar) {
        TmcLogger.c(TAG, "bindContext.....");
        this.mAppContext = bVar;
        if (isExited()) {
            TmcLogger.o(TAG, "bindContext but already exit in AppMsgReceiver!");
            return;
        }
        trySetupEngineProxy(this.mAppType);
        if (this.mPendingOnStart) {
            TmcLogger.c(TAG, "bindContext with pendingOnStart, now trigger onStart!");
            onStart();
        }
    }

    public final synchronized void destroy() {
        TmcLogger.c(TAG, "destroy " + this + " with stack " + Log.getStackTraceString(new Throwable("Just Print")));
        onDestroy();
        this.mIsDestroyed.set(true);
    }

    @Override // com.cloud.tmc.integration.structure.App
    public final synchronized void exit() {
        if (this.mIsExited) {
            return;
        }
        TmcLogger.c(TAG, "exitApp with stack " + Log.getStackTraceString(new Throwable("Just Print")));
        this.mIsExited = true;
        onExit();
    }

    public void exitAllPages(boolean z11) {
        TmcLogger.o(TAG, "exitAllPages: " + z11);
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            Page pageByIndex = getPageByIndex(childCount);
            if (pageByIndex != null) {
                ((Page.a) pageByIndex.getData(Page.a.class, true)).f30918b = true;
                pageByIndex.exit(z11);
            }
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void exitAllThenPushPage(String str, Bundle bundle, Bundle bundle2) {
        TmcLogger.c(TAG, "exitAllThenPushPage " + str + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        PageNode pageNodeCreatePage = ((PageFactory) tc.a.a(PageFactory.class)).createPage(this, "https://100000.miniapp.transsion.com/index.html", str, bundle, bundle2);
        String string = bundle2.getString("navigationType");
        if (!TextUtils.isEmpty(string)) {
            m0.f(pageNodeCreatePage, string);
        }
        IEngine iEngine = this.mEngineProxy;
        if (iEngine == null) {
            pageNodeCreatePage.setData(j.class, new j(""));
        } else {
            pageNodeCreatePage.setData(j.class, new j(iEngine.getWorkerId()));
        }
        String routeType = getRouteType(str, false);
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            Page pageByIndex = getPageByIndex(childCount);
            if (pageByIndex != null) {
                ((Page.a) pageByIndex.getData(Page.a.class, true)).f30918b = true;
                pageByIndex.exit(false, new Page.e(childCount, pageNodeCreatePage, Page.SOURCE_RELAUNCH, routeType));
            }
        }
        pushChild(pageNodeCreatePage);
        tb.b bVar = this.mAppContext;
        if (bVar != null) {
            bVar.f(pageNodeCreatePage);
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void exitToHomePage() {
        TmcLogger.c(TAG, "exitToHomePage: with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        try {
            boolean zHasHomePage = hasHomePage();
            TmcLogger.c(TAG, "exitToHomePage: 检查是否有首页(true 有，false，没有): " + zHasHomePage);
            if (!zHasHomePage) {
                String homePagePath = getHomePagePath();
                if (TextUtils.isEmpty(homePagePath)) {
                    return;
                }
                putRouteType(homePagePath, Page.SOURCE_RELAUNCH);
                Bundle sceneParams = getSceneParams();
                sceneParams.putString("navigationType", "exitToHomePage");
                relaunchToUrl(homePagePath, getStartParams(), sceneParams);
                return;
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                Page pageByIndex = getPageByIndex(childCount);
                if (pageByIndex != null) {
                    if (pageByIndex.isExited() || (!pageByIndex.isHomePage() && !pageByIndex.isTabPage())) {
                        ((Page.a) pageByIndex.getData(Page.a.class, true)).f30918b = true;
                        pageByIndex.exit(false);
                    }
                    if (AppUtils.f31011a.c(this.appId)) {
                        if (pageByIndex.isHomePage()) {
                            TmcLogger.c(TAG, "exitToHomePage: 当前页面为首页，停止弹出。" + pageByIndex);
                            return;
                        }
                        if (pageByIndex.isTabPage()) {
                            TmcLogger.c(TAG, "exitToHomePage: 当前是 tab 页，切换到首页，。" + pageByIndex);
                            switchTab(getHomePagePath(), getStartParams(), getmSceneParams());
                            return;
                        }
                    }
                    TmcLogger.c(TAG, "exitToHomePage: 当前页面为首页，停止弹出。" + pageByIndex);
                    return;
                }
            }
        } catch (Exception e11) {
            TmcLogger.g(TAG, "", e11);
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    @Nullable
    public Page getActivePage() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            Page pageByIndex = getPageByIndex(childCount);
            if (pageByIndex != null && !pageByIndex.isUseForEmbed() && !pageByIndex.isExited() && (!pageByIndex.isTabPage() || !pageByIndex.isHide())) {
                return pageByIndex;
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public int getActivePageIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            Page pageByIndex = getPageByIndex(childCount);
            if (pageByIndex != null && !pageByIndex.isUseForEmbed() && !pageByIndex.isExited() && (!pageByIndex.isTabPage() || !pageByIndex.isHide())) {
                return childCount;
            }
        }
        return -1;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public boolean getAddHomeShowStatus(int i11) {
        if (i11 == 100) {
            return this.MFAHShowStatus;
        }
        if (i11 == 90) {
            return this.APIAddhomeShowStatus;
        }
        if (i11 == 81) {
            return this.guideTopAddhomeShowStatus;
        }
        if (i11 == 82) {
            return this.guideBottomAddhomeShowStatus;
        }
        if (i11 == 83) {
            return this.guideBackAddhomeShowStatus;
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public int getAlivePageCount() {
        int childCount = getChildCount();
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            Page pageByIndex = getPageByIndex(i11);
            if (pageByIndex != null && pageByIndex.isExited()) {
                childCount--;
            }
        }
        return childCount;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public wa.a getAppChainContext() {
        return this.appChainContext;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public tb.b getAppContext() {
        return this.mAppContext;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public String getAppId() {
        return this.appId;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public f getAppLifecycleCallback() {
        return this.checkMiniAppLifecycleCallback;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public AppManager getAppManager() {
        return this.mAppManager;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public AppModel getAppModel() {
        return this.mAppModel;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public String getAppType() {
        return this.mAppType;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public String getAppVersion() {
        return this.mAppVersion;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public ua.e getAsyncStartLoadingCallback() {
        return this.iAsyncStartLoadingCallback;
    }

    @Override // com.cloud.tmc.integration.structure.App
    @NonNull
    public IBackPressedProcessor getBackPressedProcessor() {
        return this.backPressedProcessor;
    }

    public String getBackToPagePath() {
        return this.backToPagePath;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public IEngine getEngineProxy() {
        return this.mEngineProxy;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public com.cloud.tmc.kernel.extension.e getExtensionManager() {
        return NodeInstance.sExtensionManager;
    }

    @Override // com.cloud.tmc.integration.structure.App
    @Nullable
    public Page getFirstPage() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            Page pageByIndex = getPageByIndex(i11);
            if (pageByIndex != null && !pageByIndex.isUseForEmbed() && !pageByIndex.isExited()) {
                return pageByIndex;
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.kernel.node.NodeInstance, com.cloud.tmc.kernel.node.DataNode, com.cloud.tmc.kernel.node.Node
    public dd.d getGroup() {
        AppModel appModel = this.mAppModel;
        return appModel == null ? DefaultGroup.EXTERNAL : DefaultGroup.valueOf(appModel.getPermissions().getGroup());
    }

    @Override // com.cloud.tmc.integration.structure.App
    public boolean getHideMiniAppLoadingStatus() {
        return this.isHideMiniAppLoaingStatus;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public String getHomePagePath() {
        MiniAppConfigModel miniAppConfigModel;
        List<String> list;
        AppLoadResult appLoadResult = this.mAppLoadResult;
        return (appLoadResult == null || (miniAppConfigModel = appLoadResult.appConfigModel) == null || (list = miniAppConfigModel.pages) == null || list.size() <= 0) ? "" : this.mAppLoadResult.appConfigModel.pages.get(0);
    }

    @Override // com.cloud.tmc.integration.structure.App
    public IFileResourceManager getIFileResourceManager() {
        return (IFileResourceManager) tc.a.a(IFileResourceManager.class);
    }

    @Override // com.cloud.tmc.integration.structure.App
    public IImageResourceManager getImageResourceManagerProxy() {
        return (IImageResourceManager) tc.a.a(IImageResourceManager.class);
    }

    @Override // com.cloud.tmc.integration.structure.App
    public String getInterectCallbackId() {
        return this.currentInterectCallbackId;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public g getLoadHtmlDataCallback() {
        return this.loadHtmlDataCallback;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public boolean getMFAHStatus() {
        return this.currentMFAHStatus.booleanValue();
    }

    @Override // com.cloud.tmc.integration.structure.App
    @Nullable
    public MiniAppAutoPopover getMiniAppAutoPopover() {
        return this.miniAppAutoPopover;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public boolean getMiniAppLoadStatus() {
        return this.miniappLoadSuccess;
    }

    public gc.a getOriginalStartParams() {
        return this.mImmutableStartParams;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public Page getPageByIndex(int i11) {
        return (Page) getChildAt(i11);
    }

    @Override // com.cloud.tmc.integration.structure.App
    public Page getPageByNodeId(long j11) {
        return (Page) getChild(j11);
    }

    @Override // com.cloud.tmc.integration.structure.App
    public int getPageType(@NonNull String str) {
        Integer num = this.mPagesType.get(str);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.cloud.tmc.integration.structure.App
    public LinkedHashMap<String, Runnable> getPermissionInterectMap() {
        return this.mPermissionDialogMap;
    }

    @Override // com.cloud.tmc.integration.structure.App
    @Nullable
    public Page getPrePage() {
        Page activePage = getActivePage();
        if (activePage == null) {
            return null;
        }
        String stringValue = activePage.getStringValue("prePageId");
        if (TextUtils.isEmpty(stringValue)) {
            return null;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            Page pageByIndex = getPageByIndex(childCount);
            if (pageByIndex != null && !pageByIndex.isUseForEmbed() && !pageByIndex.isExited() && TextUtils.equals(pageByIndex.getPageId(), stringValue)) {
                return pageByIndex;
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.integration.structure.App
    @NonNull
    public String getRouteType(@NonNull String str) {
        return getRouteType(str, true);
    }

    @Override // com.cloud.tmc.integration.structure.App
    @NonNull
    public String getRouteType(@NonNull String str, boolean z11) {
        String strRemove = z11 ? this.mRouteType.remove(str) : this.mRouteType.get(str);
        return strRemove != null ? strRemove : AppLovinMediationProvider.UNKNOWN;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public Bundle getSceneParams() {
        return this.mSceneParams;
    }

    @Override // com.cloud.tmc.integration.structure.App, com.cloud.tmc.kernel.node.d
    public Class<? extends com.cloud.tmc.kernel.node.d> getScopeType() {
        return App.class;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public Bundle getStartParams() {
        return this.mStartParams;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public long getStartToken() {
        return this.mStartToken;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public String getStartUrl() {
        return this.mStartUrl;
    }

    public AppLoadResult getmAppLoadResult() {
        return this.mAppLoadResult;
    }

    public Bundle getmSceneParams() {
        return this.mSceneParams;
    }

    public Bundle getmStartParams() {
        return this.mStartParams;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public boolean hasHomePage() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            Page pageByIndex = getPageByIndex(childCount);
            if (pageByIndex != null && !pageByIndex.isExited() && (pageByIndex.isHomePage() || pageByIndex.isTabPage())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void hideMiniAppAddHomeBar() {
        try {
            Page activePage = getActivePage();
            if (activePage != null) {
                activePage.hideAddScreenButton();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void init(String str, Bundle bundle, Bundle bundle2) {
        this.appId = str;
        getImageResourceManagerProxy().init(str);
        getIFileResourceManager().init(str);
        this.mStartParams = bundle;
        this.mSceneParams = bundle2;
        this.mStartToken = com.cloud.tmc.kernel.utils.a.c(bundle2, "startToken", 0L);
        this.mImmutableStartParams = new gc.a(this.mStartParams);
        this.mAppType = bundle2.getString("appType", "WEB_TINY");
        EntryInfo entryInfo = (EntryInfo) com.cloud.tmc.kernel.utils.a.d(this.mSceneParams, "entryInfo");
        this.mAppModel = (AppModel) com.cloud.tmc.kernel.utils.a.d(this.mSceneParams, "appInfo");
        this.mAppLoadResult = (AppLoadResult) com.cloud.tmc.kernel.utils.a.d(this.mSceneParams, "appLoadResult");
        if (entryInfo != null) {
            setData(EntryInfo.class, entryInfo);
        }
        TmcLogger.c(TAG, "init with appType: " + this.mAppType);
    }

    public boolean isAsyncLaunchStatus() {
        return this.asyncLaunchStatus;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public final boolean isDestroyed() {
        return this.mIsDestroyed.get();
    }

    @Override // com.cloud.tmc.integration.structure.App
    public boolean isExited() {
        return this.mIsExited;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public boolean isFirstPage() {
        return getAlivePageCount() == 1;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public boolean isTinyApp() {
        return true;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void notifyAddHomeShow(int i11) {
        i iVar = this.showAddhomeCallback;
        if (iVar != null) {
            iVar.l(i11);
        }
    }

    public void onDestroy() {
        tb.b bVar;
        TmcLogger.c(TAG, "onDestroy " + this);
        ((OnDestroyAppPoint) ib.a.b(OnDestroyAppPoint.class).g(this).e(getExtensionManager()).d()).onDestroy(this, getExtensionManager());
        if (this.mNetworkListener != null && (bVar = this.mAppContext) != null) {
            NetworkUtil.j(bVar.getContext(), this.mNetworkListener);
        }
        IEngine iEngine = this.mEngineProxy;
        if (iEngine != null) {
            iEngine.destroy();
            this.mEngineProxy = null;
        }
        tb.b bVar2 = this.mAppContext;
        if (bVar2 != null) {
            bVar2.destroy();
            this.mAppContext = null;
        }
        onFinalized();
        try {
            ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).clearEventCenterInstance(this);
        } catch (Throwable th2) {
            TmcLogger.h("AppNode", th2);
        }
    }

    public synchronized void onExit() {
        exitAllPages(!getBooleanValue("miniAppReload"));
        destroy();
    }

    public void onPageStarted(Page page) {
        if (this.mAppContext == null) {
            return;
        }
        TmcLogger.c(TAG, "onPageStarted");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (this.mPageReadyListeners) {
            try {
                Iterator<App.a> it = this.mPageReadyListeners.iterator();
                while (it.hasNext()) {
                    it.next().a(page);
                }
                TmcLogger.c(TAG, "onPageStarted flush pageReadyListener size: " + this.mPageReadyListeners.size() + " cost: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                this.mPageReadyListeners.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.mNetworkListener = new d();
        NetworkUtil.d(this.mAppContext.getContext(), this.mNetworkListener);
    }

    public void onPause() {
        TmcLogger.c(TAG, "onPause " + this);
        ((OnPauseAppPoint) ib.a.b(OnPauseAppPoint.class).g(this).e(getExtensionManager()).d()).onPause(this, getExtensionManager());
    }

    public void onResume() {
        TmcLogger.c(TAG, "onResume " + this);
        ((OnResumeAppPoint) ib.a.b(OnResumeAppPoint.class).g(this).e(getExtensionManager()).d()).onResume(this, getExtensionManager());
        AppModel appModel = this.mAppModel;
        if (appModel != null) {
            String exclusiveLogoUrl = appModel.getExtend() != null ? this.mAppModel.getExtend().getExclusiveLogoUrl() : null;
            if (f0.f31050a.e(this.appId)) {
                return;
            }
            LatestUseUtils.a(this.appId, this.mAppModel.getName(), this.mAppModel.getLogo(), this.mAppModel.getDesc(), this.mAppModel.getClassificationNames(), exclusiveLogoUrl, 0);
        }
    }

    public void onStart() {
        IEngine iEngine = this.mEngineProxy;
        TmcLogger.c(TAG, "onStart:" + this.mStartUrl);
        preProcessStartParams();
        rc.c cVar = new rc.c();
        cVar.f75177c = this.mStartToken;
        cVar.f75176b = this.mMainJSUrl;
        Bundle bundle = this.mStartParams;
        cVar.f75175a = bundle;
        bundle.putString("enablePolyfillWorker", "true");
        TmcLogger.m("App", "End create app");
        if (iEngine == null || iEngine.isDestroyed()) {
            TmcLogger.f(TAG, "engine is null or isDestroyed!");
        } else {
            this.mEngineProxy.init(cVar, new c());
        }
    }

    public void onStop() {
        TmcLogger.c(TAG, "onStop " + this);
        ((OnStopAppPoint) ib.a.b(OnStopAppPoint.class).g(this).e(getExtensionManager()).d()).onStop(this, getExtensionManager());
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void pause() {
        AppUtils.z(this, "onAppHide");
        this.mHasPaused = true;
        try {
            if (this.mAppModel.getDevMode() == 2 && !((BuildConfigProxy) tc.a.a(BuildConfigProxy.class)).isDebug().booleanValue() && !AppUtils.h()) {
                WebView.setWebContentsDebuggingEnabled(false);
            }
        } catch (Throwable unused) {
        }
        onPause();
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void performBack() {
        if (isFirstPage()) {
            TmcLogger.c(TAG, "performBack with firstPage, direct exit!");
            exit();
            return;
        }
        TmcLogger.c(TAG, "performBack just exit active page");
        Page activePage = getActivePage();
        if (activePage != null) {
            activePage.exit(true);
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    public synchronized void popPage(@Nullable JsonObject jsonObject) {
        if (jsonObject != null) {
            try {
                TmcLogger.c(TAG, "popPage with param " + jsonObject);
                setData(App.PopParams.class, new App.PopParams(jsonObject));
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Page activePage = getActivePage();
        if (activePage != null) {
            activePage.exit(true);
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void popTo(int i11, boolean z11, JsonObject jsonObject) {
        if (jsonObject != null) {
            setData(App.PopParams.class, new App.PopParams(jsonObject));
        }
        int childCount = getChildCount();
        int i12 = childCount + i11;
        TmcLogger.c(TAG, "popTo " + i11 + " to minIndex " + i12);
        ArrayList arrayList = new ArrayList();
        for (int i13 = childCount + (-1); i13 >= i12; i13--) {
            Page pageByIndex = getPageByIndex(i13);
            if (pageByIndex != null) {
                if (pageByIndex.isUseForEmbed() && i12 > 0) {
                    i12--;
                }
                if (!pageByIndex.isTabPage()) {
                    arrayList.add(pageByIndex);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Page) it.next()).exit(z11);
        }
    }

    public void preProcessStartParams() {
        if (getStartParams().containsKey("backBehavior")) {
            return;
        }
        getStartParams().putString("backBehavior", "pop");
    }

    @Override // com.cloud.tmc.integration.structure.App
    public synchronized void pushPage(String str, final Bundle bundle, final Bundle bundle2) {
        AppModel appModel;
        tb.b bVar;
        try {
            TmcLogger.c(TAG, "pushPage " + str + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
            ua.d dVar = this.appCallback;
            if (dVar == null || (appModel = this.mAppModel) == null || (bVar = this.mAppContext) == null || !dVar.a(str, appModel, bVar.getContext(), bundle, bundle2, new ua.j() { // from class: com.cloud.tmc.integration.structure.node.a
                @Override // ua.j
                public final void a(String str2) {
                    this.f30945a.lambda$pushPage$1(bundle, bundle2, str2);
                }
            })) {
                lambda$pushPage$1(str, bundle, bundle2);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void pushWebViewPage(String str, Bundle bundle, Bundle bundle2) {
        TmcLogger.c(TAG, "pushWebViewPage " + str + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        PageNode pageNodeCreatePage = ((PageFactory) tc.a.a(PageFactory.class)).createPage(this, str, "todo", bundle, bundle2);
        IEngine iEngine = this.mEngineProxy;
        if (iEngine == null) {
            pageNodeCreatePage.setData(j.class, new j(""));
        } else {
            pageNodeCreatePage.setData(j.class, new j(iEngine.getWorkerId()));
        }
        tb.b bVar = this.mAppContext;
        if (bVar != null) {
            bVar.g(pageNodeCreatePage);
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void putPageType(@NonNull String str, int i11) {
        this.mPagesType.put(str, Integer.valueOf(i11));
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void putRouteType(@NonNull String str, @NonNull String str2) {
        this.mRouteType.put(str, str2);
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void redirectTo(final String str, Bundle bundle, Bundle bundle2) {
        tb.b bVar;
        ua.d dVar;
        TmcLogger.c(TAG, "redirectTo " + str + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        bundle2.putString("navigationType", "redirectTo");
        final PageNode pageNodeCreatePage = ((PageFactory) tc.a.a(PageFactory.class)).createPage(this, "https://100000.miniapp.transsion.com/index.html", str, bundle, bundle2);
        IEngine iEngine = this.mEngineProxy;
        pageNodeCreatePage.setData(j.class, new j(iEngine == null ? "" : iEngine.getWorkerId()));
        if (pageNodeCreatePage.isTabPage()) {
            TmcLogger.c(TAG, "不支持 redirectTo " + str + " is tab page");
            return;
        }
        AppModel appModel = this.mAppModel;
        if (appModel == null || (bVar = this.mAppContext) == null || (dVar = this.appCallback) == null) {
            doRedirectTo(str, pageNodeCreatePage);
        } else {
            if (dVar.a(str, appModel, bVar.getContext(), bundle, bundle2, new ua.j() { // from class: com.cloud.tmc.integration.structure.node.b
                @Override // ua.j
                public final void a(String str2) {
                    this.f30948a.lambda$redirectTo$0(str, pageNodeCreatePage, str2);
                }
            })) {
                return;
            }
            doRedirectTo(str, pageNodeCreatePage);
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void relaunchToUrl(String str, Bundle bundle, Bundle bundle2) {
        TmcLogger.c(TAG, "relaunchToUrl " + str + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        exitAllThenPushPage(str, bundle, bundle2);
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void removePage(@NonNull Page page, boolean z11, Page.e eVar) {
        TmcLogger.c(TAG, "exitPage: " + page);
        if (page.isDestroyed()) {
            TmcLogger.o(TAG, "exitPage but already destroyed! " + page);
            return;
        }
        if (getChild(page.getNodeId()) != null) {
            TmcLogger.o(TAG, "exitPage but not a child! " + page);
            removeChild(page);
        }
        tb.b bVar = this.mAppContext;
        if (bVar != null) {
            bVar.d(page, z11);
        }
        page.destroy();
        Page activePage = getActivePage();
        try {
            tb.b bVar2 = this.mAppContext;
            if ((bVar2 instanceof com.cloud.tmc.integration.structure.app.b) && activePage != null && ((com.cloud.tmc.integration.structure.app.b) bVar2).k().a(activePage) == null) {
                activePage = null;
            }
        } catch (Exception e11) {
            TmcLogger.g(TAG, e11.getMessage(), e11);
        }
        if (activePage != null) {
            sendPageBackToWorker(activePage, page, eVar);
        } else if (eVar != null) {
            sendPageBackToWorker(eVar.f30920b, page, eVar);
        }
        if (activePage == null && z11) {
            this.mAppManager.exitApp(this);
        }
    }

    @Override // com.cloud.tmc.integration.structure.App
    public final void restart(Bundle bundle, Bundle bundle2) {
        if (this.restarting) {
            TmcLogger.o(TAG, "cannot restart during restarting");
            return;
        }
        this.restarting = true;
        tb.c cVar = new tb.c();
        cVar.f76934c = com.cloud.tmc.kernel.utils.a.e(bundle, "url");
        cVar.f76933b = false;
        cVar.f76932a = true;
        cVar.f76935d = bundle;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003e A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #0 {all -> 0x0036, blocks: (B:3:0x0018, B:5:0x001c, B:7:0x0023, B:13:0x003e, B:11:0x0038), top: B:21:0x0018 }] */
    @Override // com.cloud.tmc.integration.structure.App
    public void resume() {
        TmcLogger.c(TAG, "resume with mSendResumeInRestart: " + this.mSendResumeInRestart);
        try {
            AppModel appModel = this.mAppModel;
            if (appModel != null && appModel.getDevMode() == 2 && !((BuildConfigProxy) tc.a.a(BuildConfigProxy.class)).isDebug().booleanValue()) {
                WebView.setWebContentsDebuggingEnabled(true);
            } else if (AppUtils.h()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        } catch (Throwable unused) {
        }
        if (this.mHasPaused && !this.mSendResumeInRestart) {
            AppUtils.z(this, "onAppShow");
        }
        this.mSendResumeInRestart = false;
        onResume();
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void setAddhomeShowCallback(i iVar) {
        this.showAddhomeCallback = iVar;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void setAppCallback(ua.d dVar) {
        this.appCallback = dVar;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void setAppChainContext(wa.a aVar) {
        this.appChainContext = aVar;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void setAppStartTime(long j11) {
        this.startTime = j11;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void setAppType(String str) {
        this.mAppType = str;
    }

    public void setAsyncLaunchStatus(boolean z11) {
        this.asyncLaunchStatus = z11;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void setAsyncStartLoadingCallback(ua.e eVar) {
        this.iAsyncStartLoadingCallback = eVar;
    }

    public void setBackToPagePath(String str) {
        this.backToPagePath = str;
    }

    public void setEngineProxy(IEngine iEngine) {
        this.mEngineProxy = iEngine;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void setLoadHtmlDataCallback(g gVar) {
        this.loadHtmlDataCallback = gVar;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void setMiniAppAutoPopover(MiniAppAutoPopover miniAppAutoPopover) {
        this.miniAppAutoPopover = miniAppAutoPopover;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void setMiniAppLoadStatus(boolean z11) {
        this.miniappLoadSuccess = z11;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void setMiniappLifecycleCallback(f fVar) {
        this.checkMiniAppLifecycleCallback = fVar;
    }

    public void setmAppLoadResult(AppLoadResult appLoadResult) {
        this.mAppLoadResult = appLoadResult;
    }

    public void setmSceneParams(Bundle bundle) {
        this.mSceneParams = bundle;
    }

    public void setmStartParams(Bundle bundle) {
        this.mStartParams = bundle;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public final synchronized void start() {
        if (this.mAlreadyStarted) {
            TmcLogger.c(TAG, "try start but mAlreadyStarted true!");
            return;
        }
        this.mAlreadyStarted = true;
        TmcLogger.c(TAG, "start " + this.appId);
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        getStartParams();
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: com.cloud.tmc.integration.structure.node.AppNode.3
            @Override // java.lang.Runnable
            public void run() {
                AppNode appNode = AppNode.this;
                appNode.onLoadResult(appNode.mAppLoadResult, jElapsedRealtime);
            }
        });
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void stop() {
        onStop();
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void switchTab(String str, Bundle bundle, Bundle bundle2) {
        TmcFragment tmcFragmentF;
        bc.a aVar;
        TmcLogger.c(TAG, "switchTab " + str + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        Page activePage = getActivePage();
        if (activePage != null && activePage.isTabPage() && activePage.getPagePath().equals(str)) {
            if (TextUtils.equals(getStringValue("switcherTabFromScene"), "fromTabReselected")) {
                TmcLogger.c(TAG, "重复 switchTab path: " + str);
                TabReSelectedStore tabReSelectedStore = (TabReSelectedStore) getData(TabReSelectedStore.class);
                if (tabReSelectedStore == null || (aVar = tabReSelectedStore.getPageCache().get(activePage.getPageId())) == null) {
                    return;
                }
                aVar.d(z.a().d("url", activePage.getPagePath()).e());
                return;
            }
            return;
        }
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        ArrayList<Page> arrayList2 = new ArrayList();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            Page pageByIndex = getPageByIndex(i11);
            if (pageByIndex != null) {
                if ((activePage != null && activePage.isTabPage() && activePage.getPageId().equals(pageByIndex.getPageId())) || pageByIndex.isTabPage()) {
                    arrayList2.add(pageByIndex);
                } else {
                    ((Page.a) pageByIndex.getData(Page.a.class, true)).f30918b = true;
                    arrayList.add(pageByIndex);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Page) it.next()).exit(false);
        }
        for (Page page : arrayList2) {
            if (!page.getPagePath().equals(str) && !page.isHide()) {
                page.hide();
            }
        }
        tb.b bVar = this.mAppContext;
        if (bVar instanceof com.cloud.tmc.integration.structure.app.b) {
            ((com.cloud.tmc.integration.structure.app.b) bVar).k().e(arrayList2);
            tmcFragmentF = ((com.cloud.tmc.integration.structure.app.b) this.mAppContext).k().f(str);
        } else {
            tmcFragmentF = null;
        }
        if (tmcFragmentF == null) {
            PageNode pageNodeCreatePage = ((PageFactory) tc.a.a(PageFactory.class)).createPage(this, "https://100000.miniapp.transsion.com/index.html", str, bundle, bundle2);
            m0.f(pageNodeCreatePage, "switchTab");
            Page.a aVar2 = new Page.a();
            aVar2.f30917a = true;
            pageNodeCreatePage.setData(Page.a.class, aVar2);
            IEngine iEngine = this.mEngineProxy;
            if (iEngine == null) {
                pageNodeCreatePage.setData(j.class, new j(""));
            } else {
                pageNodeCreatePage.setData(j.class, new j(iEngine.getWorkerId()));
            }
            pageNodeCreatePage.putStringValue("prePageId", activePage != null ? activePage.getPageId() : null);
            pushChild(pageNodeCreatePage);
            tb.b bVar2 = this.mAppContext;
            if (bVar2 != null) {
                bVar2.f(pageNodeCreatePage);
                return;
            }
            return;
        }
        TmcLogger.c(TAG, "switchTab: " + str + " found in fragment manager");
        Page pageH0 = tmcFragmentF.h0();
        if (pageH0 == null) {
            return;
        }
        pageH0.show();
        tb.b bVar3 = this.mAppContext;
        if (bVar3 != null) {
            bVar3.a(pageH0);
        }
        uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(pageH0);
        if (eventCenterInstance != null) {
            uc.a aVar3 = new fc.a("SwitchTab");
            HashMap map = new HashMap();
            map.put("tabCreated", Boolean.TRUE);
            map.put("preRenderId", activePage != null ? activePage.getPageId() : "");
            aVar3.c(map);
            eventCenterInstance.d("onSwitchTab", aVar3);
        }
    }

    @NonNull
    public String toString() {
        return getClass().getSimpleName() + "@" + this.mStartToken + "@appid=" + getAppId();
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void updateAddHomeShowStatus(int i11) {
        if (i11 == 100) {
            this.MFAHShowStatus = true;
        } else if (i11 == 90) {
            this.APIAddhomeShowStatus = true;
        } else if (i11 == 81) {
            this.guideTopAddhomeShowStatus = true;
        } else if (i11 == 82) {
            this.guideBottomAddhomeShowStatus = true;
        } else if (i11 == 83) {
            this.guideBackAddhomeShowStatus = true;
        }
        notifyAddHomeShow(i11);
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void updateAppModel(AppModel appModel) {
        this.mAppModel = appModel;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void updateHideMiniappLoadingStatus(boolean z11) {
        this.isHideMiniAppLoaingStatus = z11;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void updateInterectCallbackId(String str) {
        this.currentInterectCallbackId = str;
    }

    @Override // com.cloud.tmc.integration.structure.App
    public void updateMFAHStatus(boolean z11) {
        this.currentMFAHStatus = Boolean.valueOf(z11);
    }

    @Override // com.cloud.tmc.kernel.node.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        super.writeToParcel(parcel, i11);
        parcel.writeString(this.appId);
        parcel.writeLong(this.mStartToken);
        parcel.writeString(this.mAppType);
        String str = this.mAppVersion;
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        parcel.writeBundle(this.mStartParams);
        parcel.writeBundle(this.mSceneParams);
        String str2 = this.mStartUrl;
        parcel.writeString(str2 != null ? str2 : "");
    }
}
