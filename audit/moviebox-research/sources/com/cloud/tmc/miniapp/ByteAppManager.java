package com.cloud.tmc.miniapp;

import OooO0o.OooO00o;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.cloud.tmc.component_api_ps.async.MiniAppIpcAsyncManager;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.defaultImpl.ConfigServiceImpl;
import com.cloud.tmc.integration.defaultImpl.TmcKVStorageImpl;
import com.cloud.tmc.integration.defaultImpl.TmcNetworkImpl;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool;
import com.cloud.tmc.integration.proxy.IRequestConfigProxy;
import com.cloud.tmc.integration.utils.MiniRequestUtils;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.IChangeUrlProxy;
import com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.service.EnvironmentService;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.l;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.defaultimpl.EnvironmentServiceImpl;
import com.cloud.tmc.miniapp.ipc.multiprogress.IpcMiniProcessClientService;
import com.cloud.tmc.miniapp.ui.OooO0OO;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.utils.athena.AthenaConstants;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.e0;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.offline.download.OfflineManager;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.ga.AthenaAnalytics;
import f0.b;
import hd.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n.c;
import p.d;
import p009OooO0oo.OooOo00;
import p012Oooo0oO.o0OO00O;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public final class ByteAppManager {
    public static final String BYTEAPP_PKG_NAME = "com.cloud.tmc.byteapp";
    private static final String TAG = "TmcApp:ByteAppManager";
    private static Function0<Unit> complete;
    private static boolean isConfigInit;
    private static boolean isInit;
    private static boolean isMainProcessPreInit;
    private static boolean isPreInit;
    private static OooOo00 miniBroadcastReceiver;
    private static long miniProcessTimeStamp;
    public static Application sApplication;
    private static boolean schemeInitStatus;
    private static Boolean tctpStatus;
    public static final ByteAppManager INSTANCE = new ByteAppManager();
    private static final LinkedHashMap<Integer, Activity> activityStack = new LinkedHashMap<>();
    private static AtomicBoolean isMainProcessGetInitAthenaStatus = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.g(activity, "activity");
            ByteAppManager.activityStack.put(Integer.valueOf(activity.hashCode()), activity);
            TmcLogger.c(ByteAppManager.TAG, "onActivityCreated: " + activity.getClass().getSimpleName() + ", processName: " + l.c());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.g(activity, "activity");
            ByteAppManager.activityStack.remove(Integer.valueOf(activity.hashCode()));
            TmcLogger.c(ByteAppManager.TAG, "onActivityDestroyed: " + activity.getClass().getSimpleName() + ", processName: " + l.c());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.g(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.g(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Intrinsics.g(activity, "activity");
            Intrinsics.g(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.g(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.g(activity, "activity");
        }
    }

    private ByteAppManager() {
    }

    private final void checkIsPreInit(Context context) {
        Context applicationContext;
        Application sApplication2 = null;
        if (context != null) {
            try {
                applicationContext = context.getApplicationContext();
            } catch (Throwable th2) {
                TmcLogger.h(TAG, th2);
            }
        } else {
            applicationContext = null;
        }
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application != null) {
            sApplication2 = application;
        } else if (sApplication != null) {
            sApplication2 = getSApplication();
        }
        if (sApplication2 != null) {
            try {
                preInit(sApplication2);
            } catch (Throwable th3) {
                TmcLogger.h(TAG, th3);
            }
        }
    }

    @JvmStatic
    public static /* synthetic */ void getComplete$com_cloud_tmc_miniapp_sdk$annotations() {
    }

    public static final Application getSApplication() {
        Application application = sApplication;
        if (application != null) {
            return application;
        }
        Intrinsics.y("sApplication");
        return null;
    }

    @JvmStatic
    public static /* synthetic */ void getSApplication$annotations() {
    }

    @JvmStatic
    public static final String getSDKVersion() {
        return GlobalPackageConfig.Companion.a();
    }

    @JvmStatic
    @JvmOverloads
    public static final int init(Application application) {
        Intrinsics.g(application, "application");
        return init$default(application, false, null, 6, null);
    }

    @JvmStatic
    public static final int init(Application application, Function0<Unit> function0) {
        Intrinsics.g(application, "application");
        return init(application, true, function0);
    }

    @JvmStatic
    @JvmOverloads
    public static final int init(Application application, boolean z11) {
        Intrinsics.g(application, "application");
        return init$default(application, z11, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final int init(final Application application, boolean z11, final Function0<Unit> function0) {
        Intrinsics.g(application, "application");
        ByteAppManager byteAppManager = INSTANCE;
        complete = function0;
        setSApplication(application);
        e0.c(application);
        preInit(application);
        if (z11 && !l.e()) {
            StringBuilder sbA = j.a("current process not allowed to start! processName:");
            sbA.append(l.c());
            TmcLogger.c(TAG, sbA.toString());
            return -1;
        }
        boolean zJ = MiniAppLaunch.J();
        TmcLogger.f(TAG, "app  init, closeSDK = " + zJ);
        if (zJ) {
            return -1;
        }
        if (isInit) {
            TmcLogger.c(TAG, "already init finished");
            return -1;
        }
        isInit = true;
        if (Build.VERSION.SDK_INT >= 28 && l.e()) {
            StringBuilder sbA2 = j.a("_miniapp_");
            String strC = l.c();
            if (strC == null) {
                strC = String.valueOf(System.currentTimeMillis());
            }
            sbA2.append(strC);
            WebView.setDataDirectorySuffix(sbA2.toString());
        }
        NetworkUtils.x(application);
        byteAppManager.injectActivities();
        ws.a.b(application);
        Intrinsics.g(application, "application");
        n0.j.f71356a = application;
        o0OO00O strategy = new o0OO00O(0);
        Intrinsics.g(strategy, "strategy");
        strategy.c(n0.j.f71356a);
        n0.j.f71357b = strategy;
        b style = new b();
        Intrinsics.g(style, "style");
        n0.j.f71358c = style;
        byteAppManager.intDebugMonitor();
        byteAppManager.initVaid();
        byteAppManager.initInnerWarmup(application);
        byteAppManager.initWebviewWarmup(application);
        Intrinsics.g(application, "application");
        c cVar = c.f71307a;
        Intrinsics.g(application, "application");
        d dVar = d.f73467a;
        TmcLogger.c("OooO0O0", "[IconDownloadManager] init");
        c.f71308b = application;
        dVar.d(application);
        if (l.e()) {
            MiniRequestUtils.b();
        }
        try {
            q.d();
        } catch (Throwable unused) {
            q.d();
        }
        ((ConfigService) tc.a.a(ConfigService.class)).loadService(application, "", new Function1<Boolean, Unit>() { // from class: com.cloud.tmc.miniapp.ByteAppManager.init.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                OfflineManager.O(application);
            }
        });
        TmcLogger.c(TAG, "init finished! processName:" + l.c());
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", PointAnalyseType.POINT_SDK_PV, "");
        try {
            e.a(ExecutorType.IO, new Runnable() { // from class: hd.a
                @Override // java.lang.Runnable
                public final void run() {
                    ByteAppManager.init$lambda$2(function0);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
        }
        return 0;
    }

    public static /* synthetic */ int init$default(Application application, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        return init(application, (Function0<Unit>) function0);
    }

    public static /* synthetic */ int init$default(Application application, boolean z11, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        return init(application, z11, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(Function0 function0) {
        if (function0 != null) {
            try {
                function0.invoke();
            } catch (Throwable th2) {
                TmcLogger.h(TAG, th2);
            }
        }
    }

    private final void initAthena(Application context) {
        g0.e eVar = g0.e.f65310a;
        Intrinsics.g(context, "context");
        AthenaConstants.delay.set(false);
        g0.e.f65312c = context;
        boolean zV = AppDynamicBuildConfig.v();
        AthenaAnalytics.F(context, context.getPackageName(), 3755, zV, Intrinsics.b(context.getPackageName(), BYTEAPP_PKG_NAME));
        AthenaAnalytics.N(zV);
        AthenaAnalytics.L(zV);
        AthenaConstants.currentProcessIsInitAthena.set(true);
    }

    private final void initInnerWarmup(Application application) {
        try {
            if (l.e()) {
                ((IInnerRenderPool) tc.a.a(IInnerRenderPool.class)).init(application);
                ((IInnerWorkerPool) tc.a.a(IInnerWorkerPool.class)).init(application);
            }
        } catch (Throwable unused) {
        }
    }

    private final void initVaid() {
        try {
            if (l.e()) {
                e.a(ExecutorType.IO, new Runnable() { // from class: hd.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ByteAppManager.initVaid$lambda$6();
                    }
                });
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initVaid$lambda$6() {
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(getSApplication(), "miniLauncherGlobal", "athenaVaid", AthenaAnalytics.x(getSApplication(), true));
    }

    private final void initWebviewWarmup(Application application) {
        try {
            if (l.e()) {
                ((IInnerH5WebviewPool) tc.a.a(IInnerH5WebviewPool.class)).init(application);
            }
        } catch (Throwable unused) {
        }
    }

    private final void injectActivities() {
        getSApplication().registerActivityLifecycleCallbacks(new a());
    }

    private final void intDebugMonitor() {
        qa.a.f74484a.a(getSApplication(), OooO0OO.class);
    }

    @JvmStatic
    public static /* synthetic */ void isConfigInit$com_cloud_tmc_miniapp_sdk$annotations() {
    }

    @JvmStatic
    public static final boolean isDev() {
        return AppDynamicBuildConfig.j();
    }

    public static final boolean isInit() {
        return isInit;
    }

    @JvmStatic
    public static /* synthetic */ void isInit$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isMainProcessGetInitAthenaStatus$com_cloud_tmc_miniapp_sdk$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isMainProcessPreInit$com_cloud_tmc_miniapp_sdk$annotations() {
    }

    public static final boolean isPreInit() {
        return isPreInit;
    }

    @JvmStatic
    public static /* synthetic */ void isPreInit$annotations() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void launchMiniAppDeeplink(Context context, String str) {
        if (context != null) {
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.f(applicationContext, "it.applicationContext");
            if (str == null) {
                str = "";
            }
            miniAppLaunch.b0(applicationContext, str, "mb");
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void launchMiniAppForId(Context context, String str) {
        launchMiniAppForId$default(context, str, null, null, 12, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void launchMiniAppForId(Context context, String str, String str2) {
        launchMiniAppForId$default(context, str, str2, null, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void launchMiniAppForId(Context context, String str, String str2, Bundle bundle) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.f(applicationContext, "it.applicationContext");
            Bundle bundle2 = new Bundle();
            bundle2.putString(TrackingKey.SCENE_ID, xb.e.a(str2, "100000"));
            bundle2.putString("miniapp_frm_start", "mb");
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            Unit unit = Unit.f68710a;
            MiniAppLaunch.d0(applicationContext, str, bundle2);
        }
    }

    public static /* synthetic */ void launchMiniAppForId$default(Context context, String str, String str2, Bundle bundle, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        if ((i11 & 8) != 0) {
            bundle = null;
        }
        launchMiniAppForId(context, str, str2, bundle);
    }

    @Deprecated
    @JvmStatic
    public static final void onDestroy() {
        onWarmupPoolDestroy();
    }

    @JvmStatic
    public static final void onWarmupPoolDestroy() {
        com.cloud.tmc.fps.b.f30367a.c();
    }

    @JvmStatic
    public static final void otherProcessInit() {
        if (isInit) {
            return;
        }
        init(getSApplication(), false, complete);
        TmcLogger.c(TAG, "other process init finished! processName:" + l.c());
    }

    @JvmStatic
    public static final void preInit(final Application application) {
        Intrinsics.g(application, "application");
        ByteAppManager byteAppManager = INSTANCE;
        setSApplication(application);
        e0.c(application);
        if (!l.e() && !isMainProcessPreInit) {
            try {
                byteAppManager.initAthena(application);
            } catch (Throwable th2) {
                TmcLogger.h(TAG, th2);
            }
            ByteAppManager byteAppManager2 = INSTANCE;
            Context applicationContext = application.getApplicationContext();
            Intrinsics.f(applicationContext, "application.applicationContext");
            byteAppManager2.registerMiniReceiver(applicationContext);
            isMainProcessPreInit = true;
        }
        if (!l.e()) {
            StringBuilder sbA = j.a("current process not allowed to preInit! processName:");
            sbA.append(l.c());
            TmcLogger.c(TAG, sbA.toString());
            return;
        }
        ByteAppManager byteAppManager3 = INSTANCE;
        if (isPreInit) {
            return;
        }
        e.a(ExecutorType.IO, new Runnable() { // from class: hd.b
            @Override // java.lang.Runnable
            public final void run() {
                ByteAppManager.preInit$lambda$8(application);
            }
        });
        byteAppManager3.configInit(application);
        boolean zJ = MiniAppLaunch.J();
        TmcLogger.f(TAG, "app fresh config, preInit closeSDK = " + zJ);
        if (zJ) {
            return;
        }
        byteAppManager3.initAthena(application);
        oe.b.f72413a = application;
        GsonBuilder gsonBuilderDisableHtmlEscaping = new GsonBuilder().disableHtmlEscaping();
        ((IRequestConfigProxy) tc.a.a(IRequestConfigProxy.class)).preLoadConfig();
        if (((IRequestConfigProxy) tc.a.a(IRequestConfigProxy.class)).repairIntToFloat()) {
            gsonBuilderDisableHtmlEscaping.registerTypeAdapter(new TypeToken<Map<String, ? extends String>>() { // from class: com.cloud.tmc.miniapp.ByteAppManager.preInit.2
            }.getType(), new com.cloud.tmc.kernel.utils.d());
        }
        try {
            miniProcessTimeStamp = System.currentTimeMillis();
            k.g(gsonBuilderDisableHtmlEscaping.create());
            TmcInitializer.init(application);
            isPreInit = true;
        } catch (Throwable th3) {
            TmcLogger.h(TAG, th3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preInit$lambda$8(Application application) {
        Intrinsics.g(application, "$application");
        try {
            MiniAppConfigHelper.f30370a.k();
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).warmUpMMKVFile(application, "miniLauncherGlobal");
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preUnzip$lambda$5(Application application) {
        List arrayList;
        Intrinsics.g(application, "$application");
        try {
            Object objD = k.d(MiniAppConfigHelper.f30370a.e("preUnZipIdList", "[\"100000\"]"), List.class);
            arrayList = objD instanceof List ? (List) objD : null;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
        } catch (Throwable th2) {
            TmcLogger.g(TAG, "preUnzipList eror", th2);
            arrayList = new ArrayList();
        }
        try {
            i0.q qVar = i0.q.f66855a;
            i0.q.f66856b.clear();
            qVar.a(application, arrayList);
        } catch (Throwable th3) {
            TmcLogger.h(TAG, th3);
        }
        try {
            ConfigService configService = (ConfigService) tc.a.a(ConfigService.class);
            if (configService == null || configService.getConfigBoolean("enablePreUnZipRetry", true)) {
                i0.q.f66855a.a(application, i0.q.f66856b);
            }
        } catch (Throwable unused) {
        }
    }

    @JvmStatic
    public static final void renderWarmup(boolean z11, boolean z12, int i11) {
    }

    @JvmStatic
    @JvmOverloads
    public static final void reportForExternal(String target) {
        Intrinsics.g(target, "target");
        reportForExternal$default(target, null, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void reportForExternal(String target, Bundle bundle) {
        Intrinsics.g(target, "target");
        he.c.f66433a.e(target, bundle);
    }

    public static /* synthetic */ void reportForExternal$default(String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bundle = null;
        }
        reportForExternal(str, bundle);
    }

    @JvmStatic
    public static final void setAppId(String appId) {
        Intrinsics.g(appId, "appId");
        IPackageConfig iPackageConfig = (IPackageConfig) tc.a.a(IPackageConfig.class);
        if (iPackageConfig == null) {
            return;
        }
        iPackageConfig.setAppId(appId);
    }

    @JvmStatic
    public static final void setDataSyncCallback(oa.a aVar) {
        la.b.a(TAG, "setDataSyncCallback");
        na.a.b(aVar);
    }

    @JvmStatic
    public static final void setDebugLogMode(boolean z11) {
        TmcLogger.i(z11);
    }

    @JvmStatic
    public static final void setLoginHostInfo(String str, int i11) {
    }

    public static final void setMainProcessGetInitAthenaStatus$com_cloud_tmc_miniapp_sdk(AtomicBoolean atomicBoolean) {
        Intrinsics.g(atomicBoolean, "<set-?>");
        isMainProcessGetInitAthenaStatus = atomicBoolean;
    }

    @JvmStatic
    public static final void setOpenMutipleTask(Boolean bool) {
        IPackageConfig iPackageConfig = (IPackageConfig) tc.a.a(IPackageConfig.class);
        if (iPackageConfig != null) {
            iPackageConfig.setOpenMutipleTask(bool != null ? bool.booleanValue() : true);
        }
    }

    public static final void setSApplication(Application application) {
        Intrinsics.g(application, "<set-?>");
        sApplication = application;
    }

    @JvmStatic
    public static final void startUpMiniService() {
        if (Intrinsics.b(MiniAppLaunch.S(), MiniAppConfigHelper.f30370a.h())) {
            OooO00o.a aVar = OooO00o.f5a;
            Context context = getSApplication().getApplicationContext();
            Intrinsics.f(context, "sApplication.applicationContext");
            Intrinsics.g(context, "context");
            TmcLogger.c("Tmcintegration:IpcMiniClientService", "startService: " + Log.getStackTraceString(new Throwable("Just print")));
            try {
                Intent intent = new Intent(context, (Class<?>) IpcMiniProcessClientService.class);
                h.f31061a.a(intent, context);
                context.startService(intent);
            } catch (Throwable th2) {
                TmcLogger.g("Tmcintegration:IpcMiniClientService", "Exception startService", th2);
            }
        }
    }

    @JvmStatic
    public static final void warmupMiniapp(final Context context) {
        if (context != null) {
            try {
                MiniAppIpcAsyncManager.f30347a.d(new Runnable() { // from class: hd.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ByteAppManager.warmupMiniapp$lambda$1$lambda$0(context);
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void warmupMiniapp$lambda$1$lambda$0(Context context) {
        try {
            MiniAppLaunch.f31784a.r0(context, false);
        } catch (Throwable unused) {
        }
    }

    @JvmStatic
    public static final void workerWarmup(boolean z11, boolean z12, int i11) {
    }

    public final boolean checkPreInitConfig(Context context) {
        if (context == null) {
            return true;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            e0.c(applicationContext instanceof Application ? (Application) applicationContext : null);
            return MiniAppConfigHelper.f30370a.b("enablePreInitV2", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    public final void configInit(Application application) {
        Intrinsics.g(application, "application");
        try {
            setSApplication(application);
            if (isConfigInit) {
                preLoadConfig$com_cloud_tmc_miniapp_sdk(application);
                return;
            }
            tc.a.b(IChangeUrlProxy.class, new DynamicChangeUrlImpl());
            tc.a.b(IConfigStrategyProxy.class, new ConfigImpl());
            tc.a.b(KVStorageProxy.class, new TmcKVStorageImpl());
            tc.a.b(EnvironmentService.class, new EnvironmentServiceImpl());
            tc.a.b(INetWorkProxy.class, new TmcNetworkImpl(application));
            tc.a.b(ConfigService.class, new ConfigServiceImpl());
            isConfigInit = true;
            preLoadConfig$com_cloud_tmc_miniapp_sdk(application);
            TmcLogger.c(TAG, "pre config init");
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.app.Application] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final Application getApplication$com_cloud_tmc_miniapp_sdk() {
        String strA = TAG;
        try {
            if (sApplication != null) {
                TmcLogger.c(TAG, "getapplication: sApplication");
                strA = getSApplication();
            } else {
                TmcLogger.c(TAG, "Utils.getApp()");
                strA = e0.a();
            }
            return strA;
        } catch (Throwable th2) {
            TmcLogger.h(strA, th2);
            return null;
        }
    }

    public final long getMiniProcessTimeStamp() {
        return miniProcessTimeStamp;
    }

    public final boolean getSchemeInitStatus() {
        return schemeInitStatus;
    }

    public final Boolean getTctpStatus() {
        return tctpStatus;
    }

    public final void preLoadConfig$com_cloud_tmc_miniapp_sdk(Application application) {
        Intrinsics.g(application, "application");
        try {
            ((ConfigService) tc.a.a(ConfigService.class)).loadPreService(application);
        } catch (Exception e11) {
            TmcLogger.h(TAG, e11);
        }
    }

    public final void preUnzip(final Application application) {
        Intrinsics.g(application, "application");
        if (l.e()) {
            try {
                ConfigService configService = (ConfigService) tc.a.a(ConfigService.class);
                if (configService == null || configService.getConfigBoolean("enablePreUnZipV3", true)) {
                    e.a(ExecutorType.IO, new Runnable() { // from class: hd.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            ByteAppManager.preUnzip$lambda$5(application);
                        }
                    });
                    return;
                }
            } catch (Throwable unused) {
            }
            TmcLogger.c(TAG, "Disable preZip");
        }
    }

    public final void registerMiniReceiver(Context context) {
        Intrinsics.g(context, "context");
        try {
            if (miniBroadcastReceiver != null) {
                la.b.b(TAG, "registerMiniReceiver: miniBroadcastReceiver is not null");
                return;
            }
            if (!l.d()) {
                TmcLogger.f(TAG, "registerMiniReceiver: not main process");
                return;
            }
            miniBroadcastReceiver = new OooOo00();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.cloud.tmc.miniapp.process_id");
            intentFilter.addAction("com.cloud.tmc.miniapp.addhome_success");
            intentFilter.addAction("com.cloud.tmc.miniapp.start_time");
            intentFilter.addAction("com.cloud.tmc.miniapp.use_time");
            intentFilter.addAction("com.cloud.tmc.miniapp.report_cache");
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(miniBroadcastReceiver, intentFilter, 4);
            } else {
                context.registerReceiver(miniBroadcastReceiver, intentFilter);
            }
            TmcLogger.c(TAG, "registerMiniReceiver:success");
        } catch (Throwable th2) {
            TmcLogger.g(TAG, "registerMiniReceiver Error:", th2);
        }
    }

    public final void setMiniProcessTimeStamp(long j11) {
        miniProcessTimeStamp = j11;
    }

    public final void setSchemeInitStatus(boolean z11) {
        schemeInitStatus = z11;
    }

    public final void setTctpStatus(Boolean bool) {
        tctpStatus = bool;
    }
}
