package com.cloud.tmc.integration;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.activity.StartAction;
import com.cloud.tmc.integration.activity.StartClientBundle;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.VirtualAppManager;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.MiniShellUtils;
import com.cloud.tmc.integration.utils.d0;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.integration.utils.m0;
import com.cloud.tmc.integration.utils.n0;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import lb.f;
import ua.g;
import zc.i;
import zc.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class ActivityHelper {
    private static final String LOG_TAG = "TmcApp:ActivityHelper";
    private wa.a appChainContext;
    private String appId;
    private final FragmentActivity mActivity;
    private AppNode mApp;
    private tb.b mAppContext;
    private StartClientBundle mStartClientBundle;
    private long mStartToken;
    private b onSetHostActivityStatusBackgroundCallback;
    public String sceneId;
    Bundle tempStartParams = null;
    Bundle tempSceneParams = null;
    private boolean mAlreadyDoDestroyed = false;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30369a;

        static {
            int[] iArr = new int[StartAction.values().length];
            f30369a = iArr;
            try {
                iArr[StartAction.SHOW_LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30369a[StartAction.SHOW_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30369a[StartAction.DIRECT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(int i11);
    }

    public ActivityHelper(FragmentActivity fragmentActivity, wa.a aVar) {
        this.mActivity = fragmentActivity;
        this.appChainContext = aVar;
    }

    private void checkBackToUrlParam(App app) {
        try {
            Bundle startParams = app.getStartParams();
            Bundle sceneParams = app.getSceneParams();
            if (startParams != null) {
                String string = startParams.getString("extraMiniBackToUrl");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                pb.c cVar = new pb.c();
                cVar.d(string);
                app.getBackPressedProcessor().addInterceptors(cVar);
                startParams.remove("extraMiniBackToUrl");
                if (sceneParams != null) {
                    sceneParams.remove("extraMiniBackToUrl");
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h("checkBackToUrlParam", th2);
        }
    }

    private boolean checkHotStartToOpenSpecifyPage(Intent intent, StartClientBundle startClientBundle) {
        if (this.mApp != null && startClientBundle.startAction == StartAction.SHOW_LOADING) {
            String strE = com.cloud.tmc.kernel.utils.a.e(intent.getExtras(), "miniAppId");
            if (TextUtils.equals(this.mApp.getAppId(), strE)) {
                Bundle bundle = new Bundle();
                Bundle startParams = this.mApp.getStartParams();
                Bundle sceneParams = this.mApp.getSceneParams();
                if (startParams != null && sceneParams != null) {
                    if (h.f31061a.l(this.mApp.getAppModel())) {
                        return miniShellAppHotStart();
                    }
                    String string = startParams.getString("page");
                    if (TextUtils.isEmpty(string)) {
                        bundle.putString("hot_open_type", "normal_1");
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.mApp.getAppId(), PointAnalyseType.POINT_HOT_RELOAD, "", bundle);
                        TmcLogger.c(LOG_TAG, "page not is empty");
                        hotOpen(intent, "normal_1");
                        m0.a(this.mApp.getActivePage(), "hotStart", null, this.mApp.getActivePage() != null ? this.mApp.getActivePage().getPageId() : null);
                        return false;
                    }
                    AppUtils.a(startParams, sceneParams);
                    boolean zT = AppUtils.t(sceneParams, string);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("路径合法性：");
                    sb2.append(zT ? "合法" : "非法");
                    sb2.append("，page=");
                    sb2.append(string);
                    TmcLogger.c(LOG_TAG, sb2.toString());
                    if (zT && !this.mApp.isExited()) {
                        Page activePage = this.mApp.getActivePage();
                        if (activePage != null && TextUtils.equals(activePage.getPagePath(), string)) {
                            bundle.putString("hot_open_type", "normal_2");
                            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.mApp.getAppId(), PointAnalyseType.POINT_HOT_RELOAD, "", bundle);
                            hotOpen(intent, "normal_2");
                            m0.a(activePage, "hotStartSelf", null, this.mApp.getActivePage() != null ? this.mApp.getActivePage().getPageId() : null);
                            return true;
                        }
                        AppModel appModel = this.mApp.getAppModel();
                        if (appModel != null && appModel.getAppinfoCategoryType() == MiniAppType.NORMAL.getType() && n0.h(string)) {
                            this.mApp.putPageType(string, 2);
                        }
                        checkBackToUrlParam(this.mApp);
                        if (!startParams.getBoolean("extraMiniClearAllPages")) {
                            setHostActivityStatusBackground(string);
                            bundle.putString("hot_open_type", "normal_4");
                            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.mApp.getAppId(), PointAnalyseType.POINT_HOT_RELOAD, "", bundle);
                            this.mApp.putRouteType(string, "navigateTo");
                            sceneParams.putString("navigationType", "hotNavigateTo");
                            hotOpen(intent, "normal_4");
                            this.mApp.pushPage(string, startParams, sceneParams);
                            return true;
                        }
                        hotOpen(intent, "normal_3");
                        setHostActivityStatusBackground(string);
                        startParams.remove("extraMiniClearAllPages");
                        sceneParams.putString("navigationType", "hotReLaunch");
                        this.mApp.putRouteType(string, Page.SOURCE_RELAUNCH);
                        this.mApp.relaunchToUrl(string, startParams, sceneParams);
                        bundle.putString("hot_open_type", "normal_3");
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.mApp.getAppId(), PointAnalyseType.POINT_HOT_RELOAD, "", bundle);
                        return true;
                    }
                    TmcLogger.c(LOG_TAG, "目标小程序已退出，无法满足拉起要求。");
                }
            } else {
                TmcLogger.c(LOG_TAG, "当前 App 不是目标小程序，当前AppId:" + this.mApp.getAppId() + " 目标AppId:" + strE);
            }
        }
        if (this.mApp == null && startClientBundle.startAction == StartAction.SHOW_LOADING) {
            TmcLogger.c(LOG_TAG, "app == null, action:" + startClientBundle.startAction + ", 打开失败的场景下又触发热启动");
            hotOpen(intent, "0");
        }
        return false;
    }

    public static StartClientBundle createFastStartClient(f fVar, int i11) {
        fVar.f70181b = StartAction.SHOW_LOADING;
        StartClientBundle startClientBundle = new StartClientBundle();
        startClientBundle.sceneParams = new Bundle();
        startClientBundle.startParams = new Bundle();
        startClientBundle.startToken = i11;
        StartAction startAction = fVar.f70181b;
        if (startAction != null) {
            startClientBundle.startAction = startAction;
        } else {
            startClientBundle.startAction = StartAction.DIRECT_START;
        }
        return startClientBundle;
    }

    private void handleStartParams() {
        TmcLogger.c(LOG_TAG, "NebulaActivity.onCreate handleStartParams start");
        try {
            this.mActivity.requestWindowFeature(1);
        } catch (Throwable th2) {
            TmcLogger.p(LOG_TAG, "requestWindowFeature error: ", th2);
        }
        String strE = com.cloud.tmc.kernel.utils.a.e(this.mStartClientBundle.startParams, "snapshot");
        if ("NO".equalsIgnoreCase(strE)) {
            TmcLogger.c(LOG_TAG, "not allowed to task snapshot " + strE);
            this.mActivity.getWindow().addFlags(8192);
        }
        if (com.cloud.tmc.kernel.utils.a.b(this.mStartClientBundle.startParams, "fullscreen", false)) {
            this.mActivity.getWindow().setFlags(1024, 1024);
        }
        String strE2 = com.cloud.tmc.kernel.utils.a.e(this.mStartClientBundle.startParams, "landscape");
        if (strE2.equals("landscape")) {
            if (this.mActivity.getRequestedOrientation() != 0) {
                this.mActivity.setRequestedOrientation(0);
            }
        } else if (strE2.equals("auto") && this.mActivity.getRequestedOrientation() != -1) {
            this.mActivity.setRequestedOrientation(-1);
        }
        com.cloud.tmc.kernel.utils.a.b(this.mStartClientBundle.startParams, "isRestart", false);
        TmcLogger.c(LOG_TAG, "onCreate handleStartParams done.");
    }

    private void hotOpen(Intent intent, String str) {
        TmcLogger.c(LOG_TAG, "hotOpen->hotOpenType:" + str);
        if (intent != null) {
            try {
                if ("launchModeHot".equals(intent.getStringExtra("launchMode"))) {
                    Bundle bundle = new Bundle();
                    bundle.putString("miniapp_id", this.appId);
                    bundle.putString("scene", this.mStartClientBundle.startParams.getString(TrackingKey.SCENE_ID, "100000"));
                    bundle.putString("fis_type", this.mStartClientBundle.startParams.getString("fis_type", "0"));
                    bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S, this.mStartClientBundle.startParams.getString(TrackingKey.SCENE_ID, "100000"));
                    bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T, "3");
                    bundle.putString("hot_open_type", str);
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.appId, PointAnalyseType.POINT_LAUNCH_MINIAPP_HOT_OPEN, "", bundle);
                    wa.a aVar = this.appChainContext;
                    if (aVar != null) {
                        aVar.z(bundle);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void hotOpenShell(String str) {
        TmcLogger.c(LOG_TAG, "hotOpenShell->hotOpenType:" + str);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("miniapp_id", this.appId);
            bundle.putString("scene", this.mStartClientBundle.startParams.getString(TrackingKey.SCENE_ID, "100000"));
            bundle.putString("fis_type", this.mStartClientBundle.startParams.getString("fis_type", "0"));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S, this.mStartClientBundle.startParams.getString(TrackingKey.SCENE_ID, "100000"));
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T, "3");
            bundle.putString("hot_open_type", str);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.appId, PointAnalyseType.POINT_LAUNCH_MINIAPP_HOT_OPEN, "", bundle);
            wa.a aVar = this.appChainContext;
            if (aVar != null) {
                aVar.z(bundle);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setHostActivityStatusBackground$0(int i11) {
        try {
            this.onSetHostActivityStatusBackgroundCallback.a(i11);
        } catch (Throwable th2) {
            TmcLogger.g(LOG_TAG, "setHostActivityStatusBackground failed", th2);
        }
    }

    private boolean miniShellAppHotStart() {
        i render;
        if (this.mApp == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        try {
            Bundle startParams = this.mApp.getStartParams();
            String string = startParams.getString("h5Path");
            TmcLogger.c(LOG_TAG, "包壳小程序热启动，h5Path=" + string);
            if (this.mApp.isExited() || TextUtils.isEmpty(string)) {
                TmcLogger.c(LOG_TAG, "目标小程序已退出或者h5Path为空，无法满足拉起要求。");
            } else {
                Page activePage = this.mApp.getActivePage();
                if (activePage != null && (render = activePage.getRender()) != null) {
                    hotOpenShell("shell_0");
                    l lVar = new l();
                    m0.a(activePage, "hotShellStart", lVar.f81893a, activePage.resetPageRandomIdByGAID());
                    lVar.f81895c = this.mApp.getAppId();
                    lVar.f81894b = activePage.getPagePath();
                    lVar.f81893a = com.cloud.tmc.kernel.utils.i.b(MiniShellUtils.b(this.mApp, activePage.getPageURI()), startParams);
                    g loadHtmlDataCallback = this.mApp.getLoadHtmlDataCallback();
                    if (loadHtmlDataCallback == null || !loadHtmlDataCallback.p(render, lVar)) {
                        loadHtmlDataCallback.Q(render, lVar);
                    }
                    bundle.putString("hot_open_type", "shell_0");
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.mApp.getAppId(), PointAnalyseType.POINT_HOT_RELOAD, "", bundle);
                    return true;
                }
            }
        } catch (Exception e11) {
            TmcLogger.g(LOG_TAG, "miniShellAppHotStart failed!", e11);
        }
        hotOpenShell("shell_1");
        bundle.putString("hot_open_type", "shell_1");
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.mApp.getAppId(), PointAnalyseType.POINT_HOT_RELOAD, "", bundle);
        m0.a(this.mApp.getActivePage(), "hotShellStartSelf", null, this.mApp.getActivePage() != null ? this.mApp.getActivePage().getPageRandomIdByGAId() : null);
        return false;
    }

    private void setHostActivityStatusBackground(@Nullable String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                TmcLogger.c(LOG_TAG, "setHostActivityStatusBackground page empty");
                return;
            }
            TmcLogger.c(LOG_TAG, "setHostActivityStatusBackground page: " + str);
            AppLoadResult appLoadResult = this.mApp.getmAppLoadResult();
            if (appLoadResult == null) {
                TmcLogger.c(LOG_TAG, "setHostActivityStatusBackground: appLoadResult is null");
                return;
            }
            MiniAppConfigModel.WindowBean windowBeanF = d0.f(appLoadResult, str);
            if (windowBeanF == null) {
                TmcLogger.c(LOG_TAG, "setHostActivityStatusBackground: window is null");
                return;
            }
            String contentBgColor = windowBeanF.getContentBgColor();
            if (TextUtils.isEmpty(contentBgColor)) {
                TmcLogger.c(LOG_TAG, "setHostActivityStatusBackground: contentBackgroundColor is empty");
                return;
            }
            TmcLogger.c(LOG_TAG, "setHostActivityStatusBackground: contentBackground: " + contentBgColor);
            final int color = Color.parseColor(contentBgColor);
            if (this.onSetHostActivityStatusBackgroundCallback != null) {
                com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: com.cloud.tmc.integration.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30394a.lambda$setHostActivityStatusBackground$0(color);
                    }
                });
            }
        } catch (Throwable th2) {
            TmcLogger.g(LOG_TAG, "setHostActivityStatusBackground parse color failed!", th2);
        }
    }

    public tb.b createAppContext(App app, FragmentActivity fragmentActivity) {
        return new com.cloud.tmc.integration.structure.app.b(getApp(), (ViewGroup) fragmentActivity.findViewById(R$id.trv_fragment_container), (ViewGroup) fragmentActivity.findViewById(R$id.trv_tab_container), fragmentActivity);
    }

    public synchronized void doCommonDestroy() {
        try {
            if (this.mAlreadyDoDestroyed) {
                return;
            }
            this.mAlreadyDoDestroyed = true;
            uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(this.mApp);
            if (eventCenterInstance != null) {
                eventCenterInstance.destroy();
            }
            AppNode appNode = this.mApp;
            if (appNode == null || appNode.isDestroyed()) {
                tb.b bVar = this.mAppContext;
                if (bVar != null) {
                    bVar.destroy();
                }
            } else {
                TmcLogger.o(LOG_TAG, "doCommonDestroy force mApp.destroy with count: " + this.mApp.getChildCount());
                this.mApp.exit();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void finish() {
        doCommonDestroy();
    }

    public void finishAndRemoveTask() {
        doCommonDestroy();
    }

    @Nullable
    public App getApp() {
        return this.mApp;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
    }

    public void onCreate() {
        StartAction startAction;
        StartClientBundle startClientBundle = this.mStartClientBundle;
        if (startClientBundle == null || (startAction = startClientBundle.startAction) == null) {
            return;
        }
        int i11 = a.f30369a[startAction.ordinal()];
        if (i11 == 2) {
            TmcLogger.c(LOG_TAG, "errorCode: " + com.cloud.tmc.kernel.utils.a.e(this.mApp.getSceneParams(), "prepareExceptionCode") + " errorMessage: " + com.cloud.tmc.kernel.utils.a.e(this.mApp.getSceneParams(), "prepareExceptionMessage"));
            return;
        }
        if (i11 != 3) {
            return;
        }
        AppNode appNode = (AppNode) ((AppManager) tc.a.a(AppManager.class)).findAppByToken(this.mStartToken);
        this.mApp = appNode;
        if (appNode != null) {
            TmcLogger.c(LOG_TAG, "onCreate find quickStarted app! " + this.mApp + " appId from Param: " + com.cloud.tmc.kernel.utils.a.e(this.mApp.getStartParams(), PushConstants.PROVIDER_FIELD_APP_ID));
        } else {
            AppManager appManager = (AppManager) tc.a.a(AppManager.class);
            StartClientBundle startClientBundle2 = this.mStartClientBundle;
            this.mApp = (AppNode) appManager.startApp(startClientBundle2.appId, startClientBundle2.startParams, startClientBundle2.sceneParams);
            ((VirtualAppManager) tc.a.a(VirtualAppManager.class)).updateAppInfo(this.mApp);
        }
        this.mApp.setAppChainContext(this.appChainContext);
        tb.b bVarCreateAppContext = createAppContext(this.mApp, this.mActivity);
        this.mAppContext = bVarCreateAppContext;
        this.mApp.bindContext(bVarCreateAppContext);
        checkBackToUrlParam(this.mApp);
        this.mApp.start();
    }

    public void onDestroy() {
        doCommonDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:45:0x00c0 */
    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        TmcFragment tmcFragmentA;
        TmcLogger.c(LOG_TAG, "onKeyUp " + i11);
        boolean z11 = keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0;
        TmcLogger.c(LOG_TAG, "isBackPressed:   " + z11);
        if (z11) {
            tb.b bVar = this.mAppContext;
            if (bVar != null && (bVar instanceof com.cloud.tmc.integration.structure.app.a) && this.mApp.getActivePage() != null && (tmcFragmentA = ((com.cloud.tmc.integration.structure.app.a) this.mAppContext).k().a(this.mApp.getActivePage())) != null && tmcFragmentA.g0().booleanValue()) {
                return true;
            }
            AppNode appNode = this.mApp;
            if (appNode != null) {
                return appNode.backPressed();
            }
            if (this.mActivity != null) {
                try {
                    if (((StartActivityProxy) tc.a.a(StartActivityProxy.class)).checkOpenMutipleTask(this.appId).booleanValue()) {
                        try {
                            if (TextUtils.isEmpty(this.appId)) {
                                this.mActivity.finishAndRemoveTask();
                            } else {
                                ((StartActivityProxy) tc.a.a(StartActivityProxy.class)).removeMiniAppTask(this.appId, this.mActivity);
                            }
                        } catch (Throwable unused) {
                            this.mActivity.finishAndRemoveTask();
                        }
                    } else {
                        this.mActivity.finish();
                    }
                } catch (Throwable th2) {
                    TmcLogger.h(LOG_TAG, th2);
                    this.mActivity.finish();
                }
                return true;
            }
        }
        return false;
    }

    public void onNewIntent(Intent intent) {
        StartClientBundle startClientBundle;
        TmcLogger.c(LOG_TAG, "onNewIntent with intent: " + intent);
        if (intent == null || intent.getExtras() == null || intent.getBooleanExtra("IS_LITE_MOVE_TASK", false) || (startClientBundle = setupParams(intent)) == null) {
            return;
        }
        Bundle bundle = startClientBundle.sceneParams;
        if (bundle != null && bundle.containsKey(TrackingKey.SCENE_ID)) {
            this.sceneId = startClientBundle.sceneParams.getString(TrackingKey.SCENE_ID);
        }
        if (checkHotStartToOpenSpecifyPage(intent, startClientBundle)) {
            TmcLogger.c(LOG_TAG, "小程序在后台且拉起指定页面成功！");
            return;
        }
        try {
            Bundle bundle2 = startClientBundle.startParams;
            if (bundle2 != null && bundle2.getBoolean("extraMiniClearAllPages")) {
                bundle2.remove("extraMiniClearAllPages");
            }
        } catch (Throwable th2) {
            TmcLogger.h(LOG_TAG, th2);
        }
        onCreate();
    }

    public void onPause() {
        TmcLogger.c(LOG_TAG, "onPause");
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.pause();
        }
    }

    public void onRequestPermissionResult(int i11, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        TmcLogger.c(LOG_TAG, "onResume");
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.resume();
        }
    }

    public void onStop() {
        TmcLogger.c(LOG_TAG, "onStop");
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.stop();
        }
    }

    public void reportFailureClickReloadButton() {
        if (this.mApp == null) {
            TmcLogger.c("Tmc", "mApp is null,reportFailureClickReloadButton");
            this.appChainContext.L();
        }
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setOnSetHostActivityStatusBackgroundCallback(b bVar) {
        this.onSetHostActivityStatusBackgroundCallback = bVar;
    }

    @Nullable
    public StartClientBundle setupParams(Intent intent) {
        if (intent != null) {
            try {
                if (intent.getExtras() != null) {
                    intent.getExtras().setClassLoader(ActivityHelper.class.getClassLoader());
                    StartClientBundle startClientBundle = (StartClientBundle) com.cloud.tmc.kernel.utils.a.d(intent.getExtras(), "startBundle");
                    this.mStartClientBundle = startClientBundle;
                    if (startClientBundle != null) {
                        TmcLogger.c(LOG_TAG, "onCreate " + this.mActivity.getClass().getName() + " with " + this.mStartClientBundle);
                        handleStartParams();
                        StartClientBundle startClientBundle2 = this.mStartClientBundle;
                        this.mStartToken = startClientBundle2.startToken;
                        AppNode appNode = this.mApp;
                        if (appNode != null) {
                            Bundle bundle = startClientBundle2.startParams;
                            if (bundle != null && appNode.getStartParams() != null) {
                                this.mApp.getStartParams().putAll(bundle);
                            }
                            Bundle bundle2 = this.mStartClientBundle.sceneParams;
                            if (bundle2 != null && this.mApp.getSceneParams() != null) {
                                this.mApp.getSceneParams().putAll(bundle2);
                            }
                        } else if (MiniAppConfigHelper.f30370a.b("enableFixMiniHotOpen", true)) {
                            TmcLogger.c("Tmc", "修复后台回收后的");
                            Bundle bundle3 = this.tempStartParams;
                            if (bundle3 == null || this.tempSceneParams == null) {
                                StartClientBundle startClientBundle3 = this.mStartClientBundle;
                                this.tempStartParams = startClientBundle3.startParams;
                                this.tempSceneParams = startClientBundle3.sceneParams;
                            } else {
                                this.mStartClientBundle.startParams.putAll(bundle3);
                                this.mStartClientBundle.sceneParams.putAll(this.tempSceneParams);
                                this.tempStartParams = null;
                                this.tempSceneParams = null;
                            }
                        }
                    }
                    return this.mStartClientBundle;
                }
            } catch (Throwable th2) {
                TmcLogger.h(LOG_TAG, th2);
            }
        }
        throw new IllegalStateException("onCreate intent null!!");
    }
}
