package com.cloud.tmc.miniapp;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.ad.IAdManagerProxy;
import com.cloud.tmc.ad.bridge.AdAthenaBridge;
import com.cloud.tmc.ad.bridge.AdBridge;
import com.cloud.tmc.integration.MsgDispatcher;
import com.cloud.tmc.integration.bridge.AppBridge;
import com.cloud.tmc.integration.bridge.AppOptionsBridge;
import com.cloud.tmc.integration.bridge.AudioEffectBridge;
import com.cloud.tmc.integration.bridge.AudioRecordBridge;
import com.cloud.tmc.integration.bridge.BatteryBridge;
import com.cloud.tmc.integration.bridge.CommunicationBridge;
import com.cloud.tmc.integration.bridge.FileBridge;
import com.cloud.tmc.integration.bridge.ForegroundAudioBridge;
import com.cloud.tmc.integration.bridge.FrameworkStorageBridge;
import com.cloud.tmc.integration.bridge.GetClipboardBridge;
import com.cloud.tmc.integration.bridge.GetSdkVersionBridge;
import com.cloud.tmc.integration.bridge.GetSystemInfoBridge;
import com.cloud.tmc.integration.bridge.GlobalStorageBridge;
import com.cloud.tmc.integration.bridge.HardwareBridge;
import com.cloud.tmc.integration.bridge.ImageSelectBridge;
import com.cloud.tmc.integration.bridge.InnerWarmupBridge;
import com.cloud.tmc.integration.bridge.KeyboardBridge;
import com.cloud.tmc.integration.bridge.LatestUseBridge;
import com.cloud.tmc.integration.bridge.LocalStorageBridge;
import com.cloud.tmc.integration.bridge.LocationBridge;
import com.cloud.tmc.integration.bridge.MakePhoneCallBridge;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import com.cloud.tmc.integration.bridge.NavigateBridge;
import com.cloud.tmc.integration.bridge.NavigationBarBridge;
import com.cloud.tmc.integration.bridge.NetworkBridge;
import com.cloud.tmc.integration.bridge.OfflineAppBridge;
import com.cloud.tmc.integration.bridge.PayBridge;
import com.cloud.tmc.integration.bridge.PerfBridge;
import com.cloud.tmc.integration.bridge.PrefetchDataBridge;
import com.cloud.tmc.integration.bridge.PullRefreshBridge;
import com.cloud.tmc.integration.bridge.ReportBridge;
import com.cloud.tmc.integration.bridge.ScreenBridge;
import com.cloud.tmc.integration.bridge.ScreenShotBridge;
import com.cloud.tmc.integration.bridge.SendToSmsBridge;
import com.cloud.tmc.integration.bridge.SetClipboardBridge;
import com.cloud.tmc.integration.bridge.ShareBridge;
import com.cloud.tmc.integration.bridge.SystemAbilityBridge;
import com.cloud.tmc.integration.bridge.TouchEventBridge;
import com.cloud.tmc.integration.bridge.VibrateBridge;
import com.cloud.tmc.integration.bridge.WebViewAbilityBridge;
import com.cloud.tmc.integration.bridge.WifiBridge;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.cloud.tmc.integration.defaultImpl.AdsenseManager;
import com.cloud.tmc.integration.defaultImpl.ConfigServiceImpl;
import com.cloud.tmc.integration.defaultImpl.DefaultBridgeFactory;
import com.cloud.tmc.integration.defaultImpl.DefaultImageLoaderImpl;
import com.cloud.tmc.integration.defaultImpl.DefaultWebViewDownloadImpl;
import com.cloud.tmc.integration.defaultImpl.InjectJSProxyImp;
import com.cloud.tmc.integration.defaultImpl.LocalChannelImp;
import com.cloud.tmc.integration.defaultImpl.NativePermissionImpl;
import com.cloud.tmc.integration.defaultImpl.OnRenderProcessGoneManager;
import com.cloud.tmc.integration.defaultImpl.RenderFactory;
import com.cloud.tmc.integration.defaultImpl.RenderWebviewStrategyCache;
import com.cloud.tmc.integration.defaultImpl.RequestConfigManager;
import com.cloud.tmc.integration.defaultImpl.TmcFileImpl;
import com.cloud.tmc.integration.defaultImpl.TmcKVStorageImpl;
import com.cloud.tmc.integration.defaultImpl.TmcPathImpl;
import com.cloud.tmc.integration.defaultImpl.TmcPerformanceAndErrorTracker;
import com.cloud.tmc.integration.defaultImpl.VibrateProxyImpl;
import com.cloud.tmc.integration.defaultImpl.WorkerManagerFactory;
import com.cloud.tmc.integration.internalBridge.GetAppConfigBridge;
import com.cloud.tmc.integration.internalBridge.GetPackageFileBridge;
import com.cloud.tmc.integration.internalBridge.NativeLogBridge;
import com.cloud.tmc.integration.internalBridge.OfflineDownloadBridge;
import com.cloud.tmc.integration.internalBridge.RegisterWorkerBridge;
import com.cloud.tmc.integration.invoke.DefaultExtensionInvokerFactory;
import com.cloud.tmc.integration.invoke.ExtensionInvokerFactory;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerrender.InnerRenderPool;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.integration.performance.innerwebview.InnerH5WebviewPool;
import com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool;
import com.cloud.tmc.integration.performance.innerworker.InnerWorkerPool;
import com.cloud.tmc.integration.performance.render.IRenderPool;
import com.cloud.tmc.integration.performance.render.RenderPool;
import com.cloud.tmc.integration.performance.worker.IWorkerPool;
import com.cloud.tmc.integration.performance.worker.WorkerPool;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.proxy.AnimtionProxy;
import com.cloud.tmc.integration.proxy.AuthorityProxy;
import com.cloud.tmc.integration.proxy.DialogProxy;
import com.cloud.tmc.integration.proxy.FileProxy;
import com.cloud.tmc.integration.proxy.IAdActivityGetProxy;
import com.cloud.tmc.integration.proxy.IAdsenseProxy;
import com.cloud.tmc.integration.proxy.IAppInfoManagerProxy;
import com.cloud.tmc.integration.proxy.IFragmentManagerFactory;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.integration.proxy.IRefreshProxy;
import com.cloud.tmc.integration.proxy.IRequestConfigProxy;
import com.cloud.tmc.integration.proxy.ITaskQueueProxy;
import com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy;
import com.cloud.tmc.integration.proxy.ImageSelectProxy;
import com.cloud.tmc.integration.proxy.LauncherReportProxy;
import com.cloud.tmc.integration.proxy.NativePermissionProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.proxy.ReportFactoryProxy;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.proxy.VibrateProxy;
import com.cloud.tmc.integration.resource.BaseResourceProcessor;
import com.cloud.tmc.integration.resource.FileResourceManager;
import com.cloud.tmc.integration.resource.ImageResourceManager;
import com.cloud.tmc.integration.resource.PackageResourceManager;
import com.cloud.tmc.integration.structure.VirtualAppManager;
import com.cloud.tmc.integration.structure.impl.VirtualAppManagerImpl;
import com.cloud.tmc.kernel.bridge.IMsgDispatcher;
import com.cloud.tmc.kernel.coreimpl.DefaultEngineRouterManager;
import com.cloud.tmc.kernel.coreimpl.DefaultExecutorService;
import com.cloud.tmc.kernel.coreimpl.eventcenter.DefaultEventCenterFactory;
import com.cloud.tmc.kernel.engine.EngineRouterManager;
import com.cloud.tmc.kernel.executor.IExecutorService;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.DefaultExtensionManager;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.minicover.NativeComponentProxy;
import com.cloud.tmc.kernel.node.IGetNodeSource;
import com.cloud.tmc.kernel.node.NodeInstance;
import com.cloud.tmc.kernel.proxy.IBridgeFactory;
import com.cloud.tmc.kernel.proxy.core.IEngineFactory;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy;
import com.cloud.tmc.kernel.proxy.perf.IPerformanceAndErrorTracker;
import com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ICommunicationTimeProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.LogEProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.render.IWebViewDownloadProxy;
import com.cloud.tmc.kernel.proxy.render.IWebViewFactory;
import com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.proxy.worker.IWorkerFactory;
import com.cloud.tmc.kernel.proxy.worker.JSAheadParamsProxy;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.miniapp.ad.AdActivityGetImp;
import com.cloud.tmc.miniapp.ad.AdManager;
import com.cloud.tmc.miniapp.bluetooth.BluetoothImp;
import com.cloud.tmc.miniapp.bluetooth.IBluetooth;
import com.cloud.tmc.miniapp.bridge.AppManagerDataProviderBridge;
import com.cloud.tmc.miniapp.bridge.MiniAppUpdateBridge;
import com.cloud.tmc.miniapp.bridge.NavigateMiniAppBridge;
import com.cloud.tmc.miniapp.bridge.NotifyMessageBridge;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import com.cloud.tmc.miniapp.bridge.PrefetchStrategyBridge;
import com.cloud.tmc.miniapp.bridge.PrivacyBridge;
import com.cloud.tmc.miniapp.bridge.ShowToastBridge;
import com.cloud.tmc.miniapp.bridge.TabBarBridge;
import com.cloud.tmc.miniapp.defaultimpl.AnimtionProxyImpl;
import com.cloud.tmc.miniapp.defaultimpl.AthenaReport;
import com.cloud.tmc.miniapp.defaultimpl.AuthorityProxyImpl;
import com.cloud.tmc.miniapp.defaultimpl.BuildConfigProxyImp;
import com.cloud.tmc.miniapp.defaultimpl.DefaultAuthenticationProxyImpl;
import com.cloud.tmc.miniapp.defaultimpl.DefaultClientStarter;
import com.cloud.tmc.miniapp.defaultimpl.DefaultDialogProxy;
import com.cloud.tmc.miniapp.defaultimpl.DefaultLauncherMiniActivityProxy;
import com.cloud.tmc.miniapp.defaultimpl.GetNodeSourceImpl;
import com.cloud.tmc.miniapp.defaultimpl.JSAheadParamsProxyImp;
import com.cloud.tmc.miniapp.defaultimpl.KeyboardImpl;
import com.cloud.tmc.miniapp.defaultimpl.LauncherReportImpl;
import com.cloud.tmc.miniapp.defaultimpl.MonitorWebviewManagerImp;
import com.cloud.tmc.miniapp.defaultimpl.NativeComponentProxyImp;
import com.cloud.tmc.miniapp.defaultimpl.RefreshProxyImpl;
import com.cloud.tmc.miniapp.defaultimpl.ReportFactory;
import com.cloud.tmc.miniapp.defaultimpl.TaskQueueProxyImpl;
import com.cloud.tmc.miniapp.defaultimpl.TmcApplicationContextGetter;
import com.cloud.tmc.miniapp.defaultimpl.TmcFragmentManagerFactory;
import com.cloud.tmc.miniapp.defaultimpl.TmcImageSelectImpl;
import com.cloud.tmc.miniapp.defaultimpl.TmcOfflineManagerProxyImpl;
import com.cloud.tmc.miniapp.defaultimpl.ToastImp;
import com.cloud.tmc.miniapp.defaultimpl.UpdateLoadingStepProxyImpl;
import com.cloud.tmc.miniapp.defaultimpl.WebViewImp;
import com.cloud.tmc.miniapp.defaultimpl.WorkerImp;
import com.cloud.tmc.miniapp.performanceanalyse.CommunicationTime;
import com.cloud.tmc.miniapp.performanceanalyse.LogEReportManager;
import com.cloud.tmc.miniapp.performanceanalyse.PerformanceTrack;
import com.cloud.tmc.miniapp.performanceanalyse.PerformanceUtils;
import com.cloud.tmc.miniapp.performanceanalyse.screen.ScreenInspectHelper;
import com.cloud.tmc.miniapp.prepare.impl.TmcAppInfoManagerImpl;
import com.cloud.tmc.miniapp.prepare.impl.TmcResourceManagerImpl;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import com.cloud.tmc.render.ILocalChannelProxy;
import com.cloud.tmc.render.IMonitorWebviewManagerProxy;
import com.cloud.tmc.render.IRenderFactory;
import com.cloud.tmc.render.IRenderWebivewStrategyCache;
import com.cloud.tmc.render.proxy.InjectJSProxy;
import com.cloud.tmc.worker.IWorkerManagerFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class TmcInitializer {
    private static final String TAG = "TmcInitializer";
    private static boolean alreadyInited = false;
    private static boolean alreadySetupProxy = false;
    private static com.cloud.tmc.kernel.extension.e sExtensionManager;

    /* JADX INFO: compiled from: source.java */
    public class a implements tc.a.b<IRenderWebivewStrategyCache> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IRenderWebivewStrategyCache get() {
            return new RenderWebviewStrategyCache();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements tc.a.b<VibrateProxy> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VibrateProxy get() {
            return new VibrateProxyImpl();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements tc.a.b<ImageSelectProxy> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImageSelectProxy get() {
            return new TmcImageSelectImpl();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements tc.a.b<NativeComponentProxy> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NativeComponentProxy get() {
            return new NativeComponentProxyImp();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements tc.a.b<ICommunicationTimeProxy> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ICommunicationTimeProxy get() {
            return new CommunicationTime();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements tc.a.b<IScreenInspectProxy> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IScreenInspectProxy get() {
            return new ScreenInspectHelper();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements tc.a.b<LogEProxy> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LogEProxy get() {
            return new LogEReportManager();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements tc.a.b<ILocalChannelProxy> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ILocalChannelProxy get() {
            return new LocalChannelImp();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements tc.a.b<IMonitorWebviewManagerProxy> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IMonitorWebviewManagerProxy get() {
            return new MonitorWebviewManagerImp();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j implements tc.a.b<IPerformanceAndErrorTracker> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPerformanceAndErrorTracker get() {
            return new TmcPerformanceAndErrorTracker();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k implements tc.a.b<IEngineFactory> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IEngineFactory get() {
            return new TmcEngineFactory();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l implements tc.a.b<AuthenticationProxy> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f31325a;

        public l(Context context) {
            this.f31325a = context;
        }

        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthenticationProxy get() {
            return new DefaultAuthenticationProxyImpl(this.f31325a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class m implements tc.a.b<IBluetooth> {
        @Override // tc.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IBluetooth get() {
            return new BluetoothImp();
        }
    }

    public static com.cloud.tmc.kernel.extension.e getExtensionManager() {
        return sExtensionManager;
    }

    public static synchronized void init(Context context) {
        init(context, null);
    }

    public static synchronized void init(Context context, @Nullable com.cloud.tmc.kernel.extension.e eVar) {
        com.cloud.tmc.kernel.extension.f fVarE;
        if (alreadyInited) {
            return;
        }
        alreadyInited = true;
        setupProxy(context);
        if (eVar != null) {
            try {
                fVarE = eVar.e();
            } catch (Throwable th2) {
                hd.j.a("setup ExtensionManager exception!").append(Log.getStackTraceString(th2));
                throw new IllegalStateException("setup ExtensionManager exception!", th2);
            }
        } else {
            fVarE = null;
        }
        if (fVarE == null) {
            fVarE = new lc.b();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(AppOptionsBridge.class);
        arrayList.add(FileBridge.class);
        arrayList.add(GetClipboardBridge.class);
        arrayList.add(GetSdkVersionBridge.class);
        arrayList.add(GetSystemInfoBridge.class);
        arrayList.add(ImageSelectBridge.class);
        arrayList.add(KeyboardBridge.class);
        arrayList.add(LocalStorageBridge.class);
        arrayList.add(FrameworkStorageBridge.class);
        arrayList.add(MakePhoneCallBridge.class);
        arrayList.add(NativeRequestBridge.class);
        arrayList.add(AppBridge.class);
        arrayList.add(NavigateBridge.class);
        arrayList.add(NavigationBarBridge.class);
        arrayList.add(PerfBridge.class);
        arrayList.add(PullRefreshBridge.class);
        arrayList.add(SendToSmsBridge.class);
        arrayList.add(SetClipboardBridge.class);
        arrayList.add(ShareBridge.class);
        arrayList.add(VibrateBridge.class);
        arrayList.add(NetworkBridge.class);
        arrayList.add(BatteryBridge.class);
        arrayList.add(ScreenBridge.class);
        arrayList.add(PayBridge.class);
        arrayList.add(ForegroundAudioBridge.class);
        arrayList.add(AudioEffectBridge.class);
        arrayList.add(LatestUseBridge.class);
        arrayList.add(InnerWarmupBridge.class);
        arrayList.add(CommunicationBridge.class);
        arrayList.add(WifiBridge.class);
        arrayList.add(ReportBridge.class);
        arrayList.add(ScreenShotBridge.class);
        arrayList.add(TouchEventBridge.class);
        arrayList.add(AudioRecordBridge.class);
        arrayList.add(PrefetchDataBridge.class);
        arrayList.add(SystemAbilityBridge.class);
        arrayList.add(HardwareBridge.class);
        arrayList.add(WebViewAbilityBridge.class);
        arrayList.add(AdBridge.class);
        arrayList.add(AdAthenaBridge.class);
        arrayList.add(GetAppConfigBridge.class);
        arrayList.add(GetPackageFileBridge.class);
        arrayList.add(NativeLogBridge.class);
        arrayList.add(RegisterWorkerBridge.class);
        arrayList.add(OfflineDownloadBridge.class);
        arrayList.add(PermissionScopeBridge.class);
        arrayList.add(NavigateMiniAppBridge.class);
        arrayList.add(TabBarBridge.class);
        arrayList.add(ShowToastBridge.class);
        arrayList.add(PrivacyBridge.class);
        arrayList.add(GlobalStorageBridge.class);
        arrayList.add(NotifyMessageBridge.class);
        arrayList.add(MiniAppUpdateBridge.class);
        arrayList.add(AppManagerDataProviderBridge.class);
        arrayList.add(LocationBridge.class);
        arrayList.add(PrefetchStrategyBridge.class);
        arrayList.add(OfflineAppBridge.class);
        registerBridge(fVarE, arrayList);
        if (eVar == null) {
            eVar = new DefaultExtensionManager(fVarE);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("register bridge done with jsapi count: ");
        sb2.append(fVarE.d());
        gb.a.f().a(eVar);
        ib.a.c(eVar);
        NodeInstance.bindExtensionManager(eVar);
        sExtensionManager = eVar;
    }

    private static void registerBridge(@NonNull com.cloud.tmc.kernel.extension.f fVar, @NonNull List<Class<? extends BridgeExtension>> list) {
        Iterator<Class<? extends BridgeExtension>> it = list.iterator();
        while (it.hasNext()) {
            Class<? extends BridgeExtension> next = it.next();
            it.remove();
            try {
                com.cloud.tmc.kernel.extension.i iVarA = com.cloud.tmc.kernel.extension.i.a(next);
                fVar.b(iVarA.f31195a, iVarA.f31196b);
            } catch (Throwable th2) {
                hd.j.a("Failed to register bridge!").append(Log.getStackTraceString(th2));
            }
        }
    }

    public static synchronized void reset() {
        alreadyInited = false;
        alreadySetupProxy = false;
    }

    public static synchronized void setupProxy(Context context) {
        if (alreadySetupProxy) {
            return;
        }
        alreadySetupProxy = true;
        try {
            tc.a.f76937b = new WeakReference<>(context.getApplicationContext());
            tc.a.b(IApplicationContextGetter.class, new TmcApplicationContextGetter());
            tc.a.b(PerformanceAnalyseProxy.class, new PerformanceTrack());
            tc.a.b(BuildConfigProxy.class, new BuildConfigProxyImp());
            tc.a.b(IPackageConfig.class, new GlobalPackageConfig());
            tc.a.b(IWorkerFactory.class, new WorkerImp());
            tc.a.b(IWebViewFactory.class, new WebViewImp());
            tc.a.b(ToastProxy.class, new ToastImp());
            tc.a.b(IRefreshProxy.class, new RefreshProxyImpl());
            tc.a.b(JSAheadParamsProxy.class, new JSAheadParamsProxyImp());
            tc.a.b(IRenderPool.class, new RenderPool());
            tc.a.b(IRenderFactory.class, new RenderFactory());
            tc.a.b(IWorkerManagerFactory.class, new WorkerManagerFactory());
            tc.a.b(IWorkerPool.class, new WorkerPool());
            tc.a.b(IKeyboardProxy.class, new KeyboardImpl());
            tc.a.d(ICommunicationTimeProxy.class, new e());
            tc.a.d(IScreenInspectProxy.class, new f());
            tc.a.b(IOfflineManagerProxy.class, new TmcOfflineManagerProxyImpl());
            tc.a.b(IAdActivityGetProxy.class, new AdActivityGetImp());
            tc.a.b(ReportFactoryProxy.class, new ReportFactory());
            tc.a.b(IOnRenderProcessGoneProxy.class, new OnRenderProcessGoneManager());
            tc.a.b(IAdManagerProxy.class, new AdManager());
            tc.a.d(LogEProxy.class, new g());
            tc.a.b(IAdsenseProxy.class, new AdsenseManager());
            tc.a.b(IRequestConfigProxy.class, new RequestConfigManager());
            tc.a.b(IInnerRenderPool.class, new InnerRenderPool());
            tc.a.b(IInnerWorkerPool.class, new InnerWorkerPool());
            tc.a.b(IInnerH5WebviewPool.class, new InnerH5WebviewPool());
            tc.a.b(PerformanceImprovesProxy.class, new PerformanceUtils());
            tc.a.d(ILocalChannelProxy.class, new h());
            tc.a.d(IMonitorWebviewManagerProxy.class, new i());
            tc.a.b(KVStorageProxy.class, new TmcKVStorageImpl());
            tc.a.b(IEventCenterFactory.class, new DefaultEventCenterFactory());
            tc.a.b(IFileResourceManager.class, new FileResourceManager());
            tc.a.b(IImageResourceManager.class, new ImageResourceManager());
            tc.a.b(IPackageResourceManager.class, new PackageResourceManager());
            tc.a.b(IResourceProcessor.class, new BaseResourceProcessor());
            tc.a.d(IPerformanceAndErrorTracker.class, new j());
            tc.a.d(IEngineFactory.class, new k());
            tc.a.b(IBridgeFactory.class, new DefaultBridgeFactory());
            tc.a.b(EngineRouterManager.class, new DefaultEngineRouterManager());
            tc.a.b(IMsgDispatcher.class, new MsgDispatcher());
            tc.a.b(IClientStarter.class, new DefaultClientStarter());
            tc.a.b(IFragmentManagerFactory.class, new TmcFragmentManagerFactory());
            tc.a.b(ExtensionInvokerFactory.class, new DefaultExtensionInvokerFactory());
            tc.a.b(IExecutorService.class, new DefaultExecutorService());
            tc.a.b(InjectJSProxy.class, new InjectJSProxyImp());
            tc.a.d(AuthenticationProxy.class, new l(context));
            tc.a.d(IBluetooth.class, new m());
            tc.a.d(IRenderWebivewStrategyCache.class, new a());
            tc.a.b(DialogProxy.class, new DefaultDialogProxy());
            tc.a.b(ReportProxy.class, new AthenaReport());
            tc.a.b(StartActivityProxy.class, new DefaultLauncherMiniActivityProxy());
            tc.a.b(ConfigService.class, new ConfigServiceImpl());
            tc.a.d(VibrateProxy.class, new b());
            tc.a.b(NativePermissionProxy.class, new NativePermissionImpl());
            tc.a.b(ImageLoaderProxy.class, new DefaultImageLoaderImpl());
            tc.a.b(PathProxy.class, new TmcPathImpl());
            tc.a.b(FileProxy.class, new TmcFileImpl());
            TmcAppInfoManagerImpl tmcAppInfoManagerImpl = new TmcAppInfoManagerImpl();
            tc.a.b(IAppInfoManagerProxy.class, tmcAppInfoManagerImpl);
            tc.a.b(TmcAppInfoManager.class, tmcAppInfoManagerImpl);
            tc.a.b(TmcResourceManager.class, new TmcResourceManagerImpl());
            tc.a.b(AnimtionProxy.class, new AnimtionProxyImpl());
            tc.a.d(ImageSelectProxy.class, new c());
            tc.a.b(IUpdateLoadingStepProxy.class, new UpdateLoadingStepProxyImpl());
            tc.a.b(LauncherReportProxy.class, new LauncherReportImpl());
            tc.a.b(VirtualAppManager.class, new VirtualAppManagerImpl());
            tc.a.d(NativeComponentProxy.class, new d());
            tc.a.d(IGetNodeSource.class, new tc.a.b() { // from class: hd.l
                @Override // tc.a.b
                public final Object get() {
                    return new GetNodeSourceImpl();
                }
            });
            tc.a.d(ITaskQueueProxy.class, new tc.a.b() { // from class: hd.m
                @Override // tc.a.b
                public final Object get() {
                    return new TaskQueueProxyImpl();
                }
            });
            tc.a.d(AuthorityProxy.class, new tc.a.b() { // from class: hd.n
                @Override // tc.a.b
                public final Object get() {
                    return new AuthorityProxyImpl();
                }
            });
            tc.a.b(IWebViewDownloadProxy.class, new DefaultWebViewDownloadImpl());
        } catch (Throwable th2) {
            hd.j.a("setupProxy error!").append(Log.getStackTraceString(th2));
        }
    }
}
