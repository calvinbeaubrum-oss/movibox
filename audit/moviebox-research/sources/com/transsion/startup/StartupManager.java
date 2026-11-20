package com.transsion.startup;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;
import com.blankj.utilcode.util.n;
import com.bumptech.glide.Glide;
import com.cloud.tupdate.TUpdate;
import com.mbridge.msdk.MBridgeConstans;
import com.tencent.mmkv.MMKV;
import com.tn.lib.logger.LogType;
import com.tn.lib.net.cons.PrefetchDnsUrls;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.util.device.TNDeviceHelper;
import com.tn.lib.util.networkinfo.g;
import com.transsion.api.gateway.GateWaySdk;
import com.transsion.api.gateway.config.WorkMode;
import com.transsion.baselib.config.CrashHandler;
import com.transsion.baselib.config.FirebaseConfigManager;
import com.transsion.baselib.helper.UserPreferHelper;
import com.transsion.baselib.locale.LocaleChangedHelper;
import com.transsion.baselib.locale.LocaleManager;
import com.transsion.baselib.report.AppPeriodReport;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.p;
import com.transsion.baselib.utils.PlayMode;
import com.transsion.baselib.utils.m;
import com.transsion.baseui.widget.BaseLoadMoreView;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.mb.config.download.RequestConfig;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.push.tpush.PushRegisterManager;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.upload.log.UploadLoggerManager;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import h9.k;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.json.JSONArray;
import yl.f;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class StartupManager implements r00.a, g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f57960d = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<StartupManager> f57961f = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<StartupManager>() { // from class: com.transsion.startup.StartupManager$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StartupManager invoke() {
            return new StartupManager();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f57962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f57963b = LazyKt__LazyJVMKt.b(new Function0<com.transsion.startup.pref.al.a>() { // from class: com.transsion.startup.StartupManager$keepAliveHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsion.startup.pref.al.a invoke() {
            return new com.transsion.startup.pref.al.a();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f57964c = LazyKt__LazyJVMKt.b(new Function0<com.transsion.startup.a>() { // from class: com.transsion.startup.StartupManager$configApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StartupManager a() {
            return (StartupManager) StartupManager.f57961f.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b implements RoomActivityLifecycleCallbacks.a {
        public b() {
        }

        @Override // com.transsion.baselib.report.RoomActivityLifecycleCallbacks.a
        public void onBackgroundStatusChange(boolean z11) {
            if (z11) {
                com.transsion.startup.pref.al.a aVarV = StartupManager.this.v();
                Application application = StartupManager.this.f57962a;
                if (application == null) {
                    Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                    application = null;
                }
                aVarV.b(application);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class c implements mu.b {
        @Override // mu.b
        public void a() {
        }

        @Override // mu.b
        public void b() {
            IFissionProvider iFissionProvider = (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class);
            if (iFissionProvider != null) {
                IFissionProvider.a.a(iFissionProvider, false, 1, null);
            }
            UploadLoggerManager.f59261a.i();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class d implements com.transsion.player.utils.c {
        @Override // com.transsion.player.utils.c
        public void a(String tag, String msg, boolean z11) {
            Intrinsics.g(tag, "tag");
            Intrinsics.g(msg, "msg");
            uo.b.f78622a.n(tag, new String[]{msg}, z11);
        }

        @Override // com.transsion.player.utils.c
        public void b(String tag, String msg, boolean z11) {
            Intrinsics.g(tag, "tag");
            Intrinsics.g(msg, "msg");
            uo.b.f78622a.c(tag, msg, z11);
        }

        @Override // com.transsion.player.utils.c
        public void c(String tag, String msg, boolean z11) {
            Intrinsics.g(tag, "tag");
            Intrinsics.g(msg, "msg");
            uo.b.f78622a.r(tag, msg, z11);
        }

        @Override // com.transsion.player.utils.c
        public void d(String tag, String msg, boolean z11) {
            Intrinsics.g(tag, "tag");
            Intrinsics.g(msg, "msg");
            uo.b.f78622a.h(tag, msg, z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class e extends zo.a<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f57966d;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Function1<? super Boolean, Unit> function1) {
            this.f57966d = function1;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            this.f57966d.invoke(Boolean.FALSE);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            super.c(str);
            this.f57966d.invoke(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        com.transsion.player.utils.b.f54866a.g(new d());
    }

    private final void q() {
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        String string = roomAppMMKV.a().getString("current_env", "release");
        boolean z11 = !Intrinsics.b(string, "release");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("env=");
        sb2.append(string);
        sb2.append("  ");
        sb2.append(z11);
        if (!Intrinsics.b(string, "release")) {
            Application application = this.f57962a;
            if (application == null) {
                Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                application = null;
            }
            r(application);
        }
        roomAppMMKV.a().putString("current_env", "release");
    }

    public final void A() {
        com.transsnet.flow.event.a aVar = com.transsnet.flow.event.a.f61410a;
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        aVar.c(application);
    }

    public final void B() {
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        GateWaySdk.init(application, "4U01pxRu278GqCZKY9", WorkMode.MODE_ONLINE);
    }

    public final void C() {
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        Glide.with(application);
    }

    public final void D(boolean z11) {
        com.transsion.startup.pref.al.a aVarV = v();
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        aVarV.a(application, z11);
    }

    public final void E() {
        uo.d.a aVar = uo.d.f78625a;
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        uo.d.a.g(aVar, application, LogType.TYPE_XLOG, false, null, 0L, 24, null);
    }

    public final void F() {
        cs.a aVar = cs.a.f62808a;
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        aVar.a(application);
    }

    public final void G() throws PackageManager.NameNotFoundException {
        wo.b bVar = new wo.b();
        Application application = this.f57962a;
        Application application2 = null;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        PackageManager packageManager = application.getPackageManager();
        Application application3 = this.f57962a;
        if (application3 == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application3 = null;
        }
        PackageInfo packageInfo = packageManager.getPackageInfo(application3.getPackageName(), 0);
        Intrinsics.f(packageInfo, "app.packageManager.getPa…eInfo(app.packageName, 0)");
        bVar.g(packageInfo.firstInstallTime);
        bVar.e(false);
        bVar.f(false);
        String str = packageInfo.versionName;
        Intrinsics.f(str, "packageInfo.versionName");
        bVar.h(str);
        wo.a.C0894a c0894a = wo.a.f79569a;
        Application application4 = this.f57962a;
        if (application4 == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        } else {
            application2 = application4;
        }
        c0894a.f(application2, bVar);
        c0894a.h(false);
        B();
        fp.b.f65208a.b("X-Play-Mode", (m.f51320a.b() ? PlayMode.STREAM : PlayMode.DOWNLOAD).getValue());
        T(NetServiceGenerator.f49399d.a().g());
        RequestConfig requestConfig = RequestConfig.f53099a;
        requestConfig.m(new c());
        requestConfig.l();
        RoomAppMMKV.f51271a.a().putLong("app_config_fetch_time", System.currentTimeMillis());
        ILoginApi iLoginApi = (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        if (iLoginApi != null) {
            iLoginApi.F(this);
        }
    }

    public final void H(Application application) {
        Intrinsics.g(application, "application");
        this.f57962a = application;
        jj.e.p(application);
        z();
        D(false);
        F();
    }

    public final void J() {
        PushRegisterManager pushRegisterManager = PushRegisterManager.f57004a;
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        pushRegisterManager.i(application, false);
    }

    public final void K() {
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        com.alibaba.android.arouter.launcher.a.e(application);
    }

    public final void L() {
        TUpdate tUpdateF = TUpdate.f32174c.b().f(false);
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        tUpdateF.c(application, true);
    }

    public final void M() {
        com.tn.lib.util.a.C0539a c0539a = com.tn.lib.util.a.f49452a;
        Application application = this.f57962a;
        Application application2 = null;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        c0539a.b(application);
        zp.b.a aVar = zp.b.f82110a;
        Application application3 = this.f57962a;
        if (application3 == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        } else {
            application2 = application3;
        }
        aVar.c(application2);
    }

    public final void N(Application application) {
        Intrinsics.g(application, "application");
        this.f57962a = application;
        s();
    }

    public final void O() {
        RoomAppMMKV.f51271a.a().getString("current_env", "release");
        MMKV mmkvL = TNDeviceHelper.f49455a.l();
        if (mmkvL != null) {
            mmkvL.getString("apkgaid", "");
        }
    }

    public final void P() {
        k.b(new BaseLoadMoreView());
    }

    public final void Q() {
        ILoginApi iLoginApi = (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        iLoginApi.H0(application);
    }

    public final void R(int i11, boolean z11) {
        uo.b.a.f(uo.b.f78622a, "StartupManager", "onTrimMemory " + i11, false, 4, null);
        if (i11 == 5 || i11 == 40) {
            v().c();
        }
    }

    public final void S(f fVar) {
        com.transsion.startup.pref.anr.d dVar = com.transsion.startup.pref.anr.d.f57973a;
        dVar.a("firebase --> the remote configuration is obtained");
        ConfigManager.f53111c.a().f(fVar);
        com.transsion.startup.pref.anr.a.f57972a.a(fVar.n("watch_dog_timeout"));
        String strO = fVar.o("endpoints");
        Intrinsics.f(strO, "remoteConfig.getString(RoomAppMMKV.K_ENDPOINTS)");
        CacheIpPool.f49384a.i(strO);
        dVar.a("firebase --> endpoints " + strO);
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "StartupManager", "remoteConfig " + fVar.n("key_total_show_times"), false, 4, null);
        uo.b.a.f(aVar, "download_notify", "isOpenDownloadForegroundService = " + fVar + ".getBoolean(RoomAppMMKV.DOWNLOAD_FOREGROUND_SERVICE)", false, 4, null);
        String strO2 = fVar.o("prefetch_dns_hosts");
        Intrinsics.f(strO2, "remoteConfig.getString(R…MKV.K_PREFETCH_DNS_HOSTS)");
        if (strO2.length() <= 0) {
            try {
                uo.b.a.f(aVar, "prefetchDns", "has no config~ prefetch def dns", false, 4, null);
                Dns dns = Dns.SYSTEM;
                dns.lookup("vgorigin.hakunaymatata.com");
                dns.lookup("vacdn.hakunaymatata.com");
                return;
            } catch (Throwable th2) {
                uo.b.a.f(uo.b.f78622a, "prefetchDns", "prefetch error = " + th2, false, 4, null);
                return;
            }
        }
        try {
            PrefetchDnsUrls prefetchDnsUrls = (PrefetchDnsUrls) n.d(strO2, PrefetchDnsUrls.class);
            uo.b.a.f(aVar, "prefetchDns", "prefetch dns config = " + strO2 + ", data = " + prefetchDnsUrls, false, 4, null);
            for (String str : prefetchDnsUrls.getHosts()) {
                try {
                    uo.b.a.f(uo.b.f78622a, "prefetchDns", "prefetch dns hots = " + str, false, 4, null);
                    Dns.SYSTEM.lookup(str);
                } catch (Throwable th3) {
                    uo.b.a.f(uo.b.f78622a, "prefetchDns", "1 prefetch error = " + th3, false, 4, null);
                }
            }
        } catch (Throwable th4) {
            uo.b.a.f(uo.b.f78622a, "prefetchDns", "prefetch error = " + th4, false, 4, null);
        }
    }

    public final void T(OkHttpClient okHttpClient) {
        GateWaySdk.setOkHttpClient(okHttpClient);
    }

    public final void U(List<String> ids, Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(ids, "ids");
        Intrinsics.g(callback, "callback");
        String strT = t(ids);
        if (strT != null) {
            UserPreferHelper.f51180b.a().b(strT);
        }
        uo.b.a.f(uo.b.f78622a, "UserPrefer-tag", "userPrefer = " + strT, false, 4, null);
        StringBuilder body = new StringBuilder("{\"ids\":");
        body.append(new JSONArray((Collection) ids));
        body.append("}");
        ip.b.a aVar = ip.b.f67591a;
        Intrinsics.f(body, "body");
        RequestBody requestBodyA = aVar.a(body);
        if (requestBodyA != null) {
            u().a(cp.a.f62775a.a(), requestBodyA).e(zo.d.f82109a.c()).subscribe(new e(callback));
        }
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        IFissionProvider iFissionProvider = (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class);
        if (iFissionProvider != null) {
            iFissionProvider.l0(false);
        }
        if (iFissionProvider != null) {
            iFissionProvider.r1(false);
        }
        RequestConfig.f53099a.j(network, networkCapabilities);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
        RequestConfig.f53099a.k();
    }

    @Override // r00.a
    public void onLogin(UserInfo user) {
        Intrinsics.g(user, "user");
        r00.a.C0822a.a(this, user);
        RequestConfig.f53099a.l();
    }

    @Override // r00.a
    public void onLogout() {
        r00.a.C0822a.b(this);
    }

    @Override // r00.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        r00.a.C0822a.c(this, userInfo);
    }

    public final void p(Context context) {
        AppStartReport.f57974a.d(new AppStartDotState(AppStartDotState.APP_START, 0L, 2, null));
        MMKV.t(context);
        com.transsion.startup.b.c(context);
    }

    public final void r(Context context) {
        com.blankj.utilcode.util.f.a();
        com.blankj.utilcode.util.f.b();
        com.blankj.utilcode.util.f.c();
        com.blankj.utilcode.util.f.d();
        com.blankj.utilcode.util.m.d(context != null ? context.getFilesDir() : null);
        Log.e("StartupManager", "clear");
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public final void s() {
        K();
        E();
        M();
        F();
        A();
        AppPeriodReport appPeriodReport = AppPeriodReport.f51227a;
        appPeriodReport.b();
        LocaleManager.f51198f.e();
        LocaleChangedHelper localeChangedHelper = LocaleChangedHelper.f51197a;
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        localeChangedHelper.b(application);
        j.d(l0.a(w0.a()), null, null, new StartupManager$coldBootStage$1(this, null), 3, null);
        j.d(l0.a(w0.b()), null, null, new StartupManager$coldBootStage$2(this, null), 3, null);
        j.d(l0.a(w0.b()), null, null, new StartupManager$coldBootStage$3(this, null), 3, null);
        q();
        appPeriodReport.b();
        x();
        com.tn.lib.util.networkinfo.f.f49475a.l(this);
    }

    public final String t(List<String> list) {
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        for (Object obj : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            sb2.append((String) obj);
            sb2.append(i11 == list.size() + (-1) ? "" : ",");
            i11 = i12;
        }
        return sb2.toString();
    }

    public final com.transsion.startup.a u() {
        return (com.transsion.startup.a) this.f57964c.getValue();
    }

    public final com.transsion.startup.pref.al.a v() {
        return (com.transsion.startup.pref.al.a) this.f57963b.getValue();
    }

    public final Object w(Continuation<? super Unit> continuation) {
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        mVar.i(application, false, new p(), false);
        return Unit.f68710a;
    }

    public final void x() {
        RoomActivityLifecycleCallbacks.f51239a.b(new b());
    }

    public final void y() {
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        jj.e.p(application);
        FirebaseAnalyticsManager firebaseAnalyticsManager = FirebaseAnalyticsManager.f51235a;
        firebaseAnalyticsManager.q();
        firebaseAnalyticsManager.p(true);
        z();
    }

    public final void z() {
        FirebaseConfigManager.f51018c.a().c(new Function2<Boolean, f, Unit>() { // from class: com.transsion.startup.StartupManager$initFirebaseConfig$1

            /* JADX INFO: renamed from: com.transsion.startup.StartupManager$initFirebaseConfig$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsion.startup.StartupManager$initFirebaseConfig$1$1", f = "StartupManager.kt", l = {}, m = "invokeSuspend")
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                final /* synthetic */ f $remoteConfig;
                int label;
                final /* synthetic */ StartupManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(StartupManager startupManager, f fVar, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = startupManager;
                    this.$remoteConfig = fVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$remoteConfig, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    kotlin.coroutines.intrinsics.a.e();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    this.this$0.S(this.$remoteConfig);
                    return Unit.f68710a;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, f fVar) {
                invoke(bool.booleanValue(), fVar);
                return Unit.f68710a;
            }

            public final void invoke(boolean z11, f remoteConfig) {
                Intrinsics.g(remoteConfig, "remoteConfig");
                if (z11) {
                    j.d(l0.a(w0.b()), null, null, new AnonymousClass1(this.this$0, remoteConfig, null), 3, null);
                }
            }
        });
        CrashHandler crashHandlerA = CrashHandler.f51014c.a();
        Application application = this.f57962a;
        if (application == null) {
            Intrinsics.y(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            application = null;
        }
        crashHandlerA.d(application);
    }
}
