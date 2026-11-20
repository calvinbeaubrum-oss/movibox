package com.cloud.tmc.miniapp.utils;

import OooO0o0.Oooo0;
import OooO0o0.o000oOoO;
import OooO0o0.o0OoOo0;
import Oooo00O.OooOOO;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.activity.StartClientBundle;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.CDNConfigBean;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.model.ForceUpdateModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.integration.utils.n0;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.intf.ISDKConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.i;
import com.cloud.tmc.kernel.utils.l;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.kernel.utils.r;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.GlobalPackageConfig;
import com.cloud.tmc.miniapp.R$anim;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.ipc.IpcMiniLauncherService;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prestrategy.PreStrategyManager;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import com.cloud.tmc.miniapp.proxy.platform.IUpgradeProxy;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniAppMiniProcessActivity;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.e0;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.OfflinePkgCachePath;
import com.cloud.tmc.offline.download.model.ZipFileInfo;
import com.cloud.tmc.offline.download.utils.g;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import hd.j;
import hd.k;
import i0.m;
import i0.q;
import j.y;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.HttpUrl;
import org.mvel2.ast.ASTNode;
import p011Oooo00o.o00Ooo;
import wc.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class MiniAppLaunch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MiniAppLaunch f31784a = new MiniAppLaunch();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31785b = "MiniAppLaunch";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Map<String, Long>> f31786c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Boolean> f31787d = new LinkedHashMap();

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<Unit> {
        public static final OooO0OO OooO00o = new OooO0OO();

        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ByteAppManager.setAppId("launcher");
            tc.a.b(ISDKConfig.class, new ISDKConfig() { // from class: com.cloud.tmc.miniapp.utils.MiniAppLaunch$byteAppInit$1$1
                @Override // com.cloud.tmc.kernel.intf.ISDKConfig
                public String getAppVersion() {
                    return "0.0.0";
                }

                @Override // com.cloud.tmc.kernel.intf.ISDKConfig
                public boolean openShareTarget() {
                    return false;
                }
            });
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f31788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TmcResourceManager f31789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppModel f31790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f31791d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f31792e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function3<String, String, IOException, Unit> f31793f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<Unit> function0, TmcResourceManager tmcResourceManager, AppModel appModel, Context context, Function0<Unit> function1, Function3<? super String, ? super String, ? super IOException, Unit> function3) {
            this.f31788a = function0;
            this.f31789b = tmcResourceManager;
            this.f31790c = appModel;
            this.f31791d = context;
            this.f31792e = function1;
            this.f31793f = function3;
        }

        @Override // wc.f
        public /* synthetic */ void a(String str, int i11, String str2, long j11, long j12) {
            wc.e.a(this, str, i11, str2, j11, j12);
        }

        @Override // wc.f
        public void b(String str, String errorCode, String str2, IOException e11, String str3) {
            Intrinsics.g(errorCode, "errorCode");
            Intrinsics.g(e11, "e");
            k.a("Step_APP_Download_资源包后台下载失败，", str2, MiniAppLaunch.f31785b);
            Function3<String, String, IOException, Unit> function3 = this.f31793f;
            if (function3 != null) {
                function3.invoke(errorCode, str2, e11);
            }
            try {
                this.f31789b.removeDownloadAppMap(this.f31790c.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.h(MiniAppLaunch.f31785b, th2);
            }
        }

        @Override // wc.f
        public void c(String str, String str2) {
            TmcLogger.c(MiniAppLaunch.f31785b, "Step_APP_Download_资源包后台下载完成，进行解压");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("backgroundDownFullPkgZip Finish:changeZipDownloadStatus:true downloadUrl:");
            sb2.append(str);
            sb2.append(";appInfo:appId:");
            StringBuilder sbA = x.a.a(this.f31790c, sb2, ";deployVersion:");
            sbA.append(this.f31790c.getDeployVersion());
            sbA.append(";mainPkgUrl:");
            sbA.append(this.f31790c.getMainPackageUrl());
            sbA.append(";fullPkgUrl:");
            sbA.append(this.f31790c.getPackageUrl());
            TmcLogger.c("Subpackage::", sbA.toString());
            h.f31061a.n(this.f31791d, this.f31790c, true);
            Function0<Unit> function0 = this.f31792e;
            if (function0 != null) {
                function0.invoke();
            }
            if (MiniAppLaunch.f31784a.s()) {
                q.e(q.f66855a, this.f31791d, this.f31790c, false, false, 8);
            }
            try {
                this.f31789b.removeDownloadAppMap(this.f31790c.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.h(MiniAppLaunch.f31785b, th2);
            }
        }

        @Override // wc.f
        public void f(String str, int i11, String str2) {
        }

        @Override // wc.f
        public void g(String str, String str2) {
            Function0<Unit> function0 = this.f31788a;
            if (function0 != null) {
                function0.invoke();
            }
            try {
                this.f31789b.removeDownloadAppMap(this.f31790c.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.h(MiniAppLaunch.f31785b, th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f31794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TmcResourceManager f31795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f31796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AppModel f31797d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f31798e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f31799f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Function3<String, String, IOException, Unit> f31800g;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function0<Unit> function0, TmcResourceManager tmcResourceManager, String str, AppModel appModel, Context context, Function0<Unit> function1, Function3<? super String, ? super String, ? super IOException, Unit> function3) {
            this.f31794a = function0;
            this.f31795b = tmcResourceManager;
            this.f31796c = str;
            this.f31797d = appModel;
            this.f31798e = context;
            this.f31799f = function1;
            this.f31800g = function3;
        }

        @Override // wc.f
        public /* synthetic */ void a(String str, int i11, String str2, long j11, long j12) {
            wc.e.a(this, str, i11, str2, j11, j12);
        }

        @Override // wc.f
        public void b(String str, String errorCode, String str2, IOException e11, String str3) {
            Intrinsics.g(errorCode, "errorCode");
            Intrinsics.g(e11, "e");
            k.a("Step_APP_Download_资源包后台下载失败，", str2, MiniAppLaunch.f31785b);
            Function3<String, String, IOException, Unit> function3 = this.f31800g;
            if (function3 != null) {
                function3.invoke(errorCode, str2, e11);
            }
            try {
                this.f31795b.removeDownloadAppMap(this.f31796c);
            } catch (Throwable th2) {
                TmcLogger.h(MiniAppLaunch.f31785b, th2);
            }
        }

        @Override // wc.f
        public void c(String str, String str2) {
            TmcLogger.c(MiniAppLaunch.f31785b, "Step_APP_Download_资源包后台下载完成，进行解压");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("backgroundDownSubPkgZip Finish:downloadUrl:");
            sb2.append(str);
            sb2.append(";appInfo:appId:");
            StringBuilder sbA = x.a.a(this.f31797d, sb2, ";deployVersion:");
            sbA.append(this.f31797d.getDeployVersion());
            sbA.append(";mainPkgUrl:");
            sbA.append(this.f31797d.getMainPackageUrl());
            sbA.append(";fullPkgUrl:");
            sbA.append(this.f31797d.getPackageUrl());
            TmcLogger.c("Subpackage::", sbA.toString());
            try {
                h.f31061a.c(this.f31798e, this.f31797d.getAppId(), this.f31796c, true);
            } catch (Throwable th2) {
                TmcLogger.g(MiniAppLaunch.f31785b, "", th2);
            }
            Function0<Unit> function0 = this.f31799f;
            if (function0 != null) {
                function0.invoke();
            }
            if (MiniAppLaunch.f31784a.s()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("backgroundDownSubPkgZip startUnZip:downloadUrl:");
                sb3.append(str);
                sb3.append(";appInfo:appId:");
                StringBuilder sbA2 = x.a.a(this.f31797d, sb3, ";deployVersion:");
                sbA2.append(this.f31797d.getDeployVersion());
                sbA2.append(";mainPkgUrl:");
                sbA2.append(this.f31797d.getMainPackageUrl());
                sbA2.append(";fullPkgUrl:");
                sbA2.append(this.f31797d.getPackageUrl());
                TmcLogger.c("Subpackage::", sbA2.toString());
                m.f66835a.h(this.f31798e, this.f31797d, null, false, true);
            }
            try {
                this.f31795b.removeDownloadAppMap(this.f31796c);
            } catch (Throwable th3) {
                TmcLogger.h(MiniAppLaunch.f31785b, th3);
            }
        }

        @Override // wc.f
        public void f(String str, int i11, String str2) {
        }

        @Override // wc.f
        public void g(String str, String str2) {
            Function0<Unit> function0 = this.f31794a;
            if (function0 != null) {
                function0.invoke();
            }
            try {
                this.f31795b.removeDownloadAppMap(this.f31796c);
            } catch (Throwable th2) {
                TmcLogger.h(MiniAppLaunch.f31785b, th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f31801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f31802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Bundle f31803c;

        public c(Context context, String str, Bundle bundle) {
            this.f31801a = context;
            this.f31802b = str;
            this.f31803c = bundle;
        }

        @Override // i.a
        public void a(Integer num, Throwable th2) {
            TmcLogger.h(MiniAppLaunch.f31785b, th2);
            ByteAppManager.INSTANCE.setSchemeInitStatus(false);
        }

        public void b(boolean z11) {
            if (z11) {
                return;
            }
            boolean configBoolean = ((ConfigService) tc.a.a(ConfigService.class)).getConfigBoolean("closeMiniAppSDK", false);
            TmcLogger.e("app will launch mini app, closeSDK = " + configBoolean);
            if (configBoolean) {
                ByteAppManager.INSTANCE.preLoadConfig$com_cloud_tmc_miniapp_sdk(ByteAppManager.getSApplication());
                return;
            }
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            if (miniAppLaunch.y(this.f31801a, this.f31802b, this.f31803c)) {
                return;
            }
            miniAppLaunch.a0(this.f31803c, this.f31802b, this.f31801a);
            ByteAppManager.INSTANCE.setSchemeInitStatus(false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f31804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o0OoOo0 f31805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w.a f31806c;

        public d(Context context, o0OoOo0 o0oooo0, w.a aVar) {
            this.f31804a = context;
            this.f31805b = o0oooo0;
            this.f31806c = aVar;
        }

        @Override // j.y
        public void a(View view) {
            Intrinsics.g(view, "view");
            Context context = this.f31804a;
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (oooO0OO != null) {
                oooO0OO.b();
            }
        }

        @Override // j.y
        public void b(View view) {
            Intrinsics.g(view, "view");
            this.f31805b.l();
            MiniAppLaunch.f31784a.i0(this.f31804a, this.f31806c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f31807a;

        public e(boolean z11) {
            this.f31807a = z11;
        }

        public static final void c(boolean z11) {
            if (z11) {
                try {
                    TmcLogger.c(MiniAppLaunch.f31785b, "warmupWebView");
                    ((IInnerH5WebviewPool) tc.a.a(IInnerH5WebviewPool.class)).createWebview();
                } catch (Throwable th2) {
                    TmcLogger.h(MiniAppLaunch.f31785b, th2);
                    return;
                }
            }
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            miniAppLaunch.q0();
            miniAppLaunch.s0();
        }

        @Override // i.a
        public void a(Integer num, Throwable th2) {
            TmcLogger.h(MiniAppLaunch.f31785b, th2);
        }

        public void b(boolean z11) {
            if (z11) {
                return;
            }
            try {
                final boolean z12 = this.f31807a;
                com.cloud.tmc.kernel.utils.e.d(new Runnable() { // from class: sd.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppLaunch.e.c(z12);
                    }
                });
            } catch (Throwable th2) {
                TmcLogger.h(MiniAppLaunch.f31785b, th2);
            }
        }
    }

    @JvmStatic
    public static final boolean J() {
        try {
            ConfigService configService = (ConfigService) tc.a.a(ConfigService.class);
            if (configService != null) {
                return configService.getConfigBoolean("closeMiniAppSDK", false);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @JvmStatic
    public static final Class<? extends Activity> N(Intent intent) {
        Intrinsics.g(intent, "intent");
        Bundle bundle = ((StartClientBundle) com.cloud.tmc.kernel.utils.a.d(intent.getExtras(), "startBundle")).startParams;
        String string = bundle != null ? bundle.getString("targetProcess") : null;
        MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.f30370a;
        if (!Intrinsics.b(string, miniAppConfigHelper.h()) && !l.e() && ByteAppManager.isPreInit()) {
            ByteAppManager.otherProcessInit();
        }
        return Intrinsics.b(string, miniAppConfigHelper.h()) ? MiniAppMiniProcessActivity.class : OooOOO.class;
    }

    @JvmStatic
    public static final String S() {
        return ":mini";
    }

    public static final void W(Context context) {
        Intrinsics.g(context, "$context");
        StringBuilder sbA = j.a(MiniAppConfigHelper.f30370a.e("jumpStoreDeeplink", "market://details?id="));
        sbA.append(context.getPackageName());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sbA.toString()));
        intent.addFlags(ASTNode.DEOP);
        context.startActivity(intent);
    }

    public static final void Y(Context context) {
        Intrinsics.g(context, "$context");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("palmplay://thirdlauncher.com/?entryType=AppDetail&detailType=SOFT&utm_source=pushsdk&_source=miniApp&packageName=" + context.getPackageName() + "&name=" + com.cloud.tmc.miniutils.util.b.a()));
        intent.addFlags(ASTNode.DEOP);
        context.startActivity(intent);
    }

    @JvmStatic
    public static final void Z(Context context) {
        try {
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (oooO0OO != null) {
                oooO0OO.b();
            }
        } catch (Exception e11) {
            TmcLogger.e(e11.getMessage());
        }
    }

    public static /* synthetic */ void c0(MiniAppLaunch miniAppLaunch, Context context, String str, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        miniAppLaunch.b0(context, str, str2);
    }

    @JvmStatic
    public static final void d0(Context context, String str, Bundle bundle) {
        Intrinsics.g(context, "context");
        k.a("launchMiniAppForId:appid:", str, f31785b);
        if (bundle == null) {
            bundle = new Bundle();
        }
        String strB = xb.e.b(bundle.getString("massid"), String.valueOf(System.currentTimeMillis()));
        if (strB.length() == 0) {
            bundle.putString("massid", strB);
        }
        try {
            if (l.e()) {
                if (bundle.getLong("start_main_first_time", 0L) == 0) {
                    bundle.putLong("start_main_first_time", 0L);
                }
                bundle.putLong("start_mini_first_time", System.currentTimeMillis());
                if (System.currentTimeMillis() - ByteAppManager.INSTANCE.getMiniProcessTimeStamp() > 15000) {
                    bundle.putBoolean("mini_process_alive", true);
                }
                g0.e eVar = g0.e.f65310a;
                Bundle bundle2 = new Bundle();
                bundle2.putString("massid", strB);
                bundle2.putString("miniappId", str);
                Unit unit = Unit.f68710a;
                eVar.g("miniapp_mini_start", 3755, bundle2);
            } else {
                bundle.putLong("start_main_first_time", System.currentTimeMillis());
                g0.e eVar2 = g0.e.f65310a;
                Bundle bundle3 = new Bundle();
                bundle3.putString("massid", strB);
                bundle3.putString("miniappId", str);
                Unit unit2 = Unit.f68710a;
                eVar2.g("miniapp_main_start", 3755, bundle3);
            }
        } catch (Throwable unused) {
        }
        IpcMiniLauncherService.f31538a.a(context, str, bundle, new c(context, str, bundle));
    }

    public static final void g0(Context context) {
        new Oooo0(context).q();
    }

    public static final void j0(o000oOoO dialog) {
        Intrinsics.g(dialog, "$dialog");
        dialog.q();
    }

    public static final void l0(Context context, String str, w.a aVar) {
        Long lValueOf;
        TextView textView;
        o0OoOo0 o0oooo0 = new o0OoOo0(context);
        TextView textViewV = o0oooo0.v();
        if (textViewV != null) {
            textViewV.setText(id.h.a.d(o0oooo0, R$string.mini_dialog_update_title));
        }
        TextView textViewB = o0oooo0.B();
        if (textViewB != null) {
            textViewB.setText(id.h.a.d(o0oooo0, R$string.mini_dialog_fw_update_content));
        }
        TextView textViewZ = o0oooo0.z();
        if (textViewZ != null) {
            textViewZ.setText(id.h.a.d(o0oooo0, R$string.mini_dialog_update_cancel));
        }
        TextView textViewA = o0oooo0.A();
        if (textViewA != null) {
            textViewA.setText(id.h.a.d(o0oooo0, R$string.mini_dialog_fw_update_now));
        }
        if (str != null) {
            try {
                lValueOf = Long.valueOf(Long.parseLong(str));
            } catch (Exception e11) {
                TmcLogger.e(e11.getMessage());
            }
        } else {
            lValueOf = null;
        }
        TextView textView2 = (TextView) o0oooo0.f153x.getValue();
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if (lValueOf != null) {
            lValueOf.longValue();
            String strD = id.h.a.d(o0oooo0, R$string.mini_dialog_download_size);
            if (strD != null && (textView = (TextView) o0oooo0.f153x.getValue()) != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                String str2 = String.format(strD, Arrays.copyOf(new Object[]{o0oooo0.w(lValueOf.longValue())}, 1));
                Intrinsics.f(str2, "format(format, *args)");
                textView.setText(str2);
            }
        }
        d listener = new d(context, o0oooo0, aVar);
        Intrinsics.g(listener, "listener");
        o0oooo0.f154y = listener;
        o0oooo0.q();
    }

    @JvmStatic
    public static final PrepareException m0(String str, int i11, String str2) {
        if (i11 == 30004) {
            return new PrepareException("30004", "appid:" + str + ", AppInfo not exist");
        }
        if (i11 == 30005) {
            return new PrepareException("30005", "appid:" + str + ",  AppInfo Version not exist");
        }
        if (i11 == 30009) {
            return new PrepareException("30009", "appid:" + str + ", The byteapp version has expired");
        }
        if (i11 == 30022) {
            return new PrepareException("30022", "appid:" + str + ", Version error");
        }
        return new PrepareException("4", "appid:" + str + ", " + str2);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0052  */
    @JvmStatic
    public static final boolean x(AppModel appModel) {
        String appId;
        OfflinePkgCachePath offlinePkgCachePathJ;
        String strA;
        boolean z11;
        List<ZipFileInfo> zipFileInfo;
        Intrinsics.g(appModel, "appModel");
        if (!OfflineManager.Y() || !l.e() || (appId = appModel.getAppId()) == null || Intrinsics.b(appId, "100000") || (offlinePkgCachePathJ = OfflineManager.J(appId)) == null || (strA = g.f32096a.a(offlinePkgCachePathJ)) == null) {
            return false;
        }
        MiniAppLaunch miniAppLaunch = f31784a;
        if (Intrinsics.b(miniAppLaunch.O(appModel), strA)) {
            z11 = true;
        } else {
            String strO = miniAppLaunch.O(appModel);
            if (strO == null) {
                strO = "0";
            }
            if (miniAppLaunch.D(strA, strO)) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        TmcLogger.c(f31785b, "isUpdate->" + z11 + ",offlineVersion-> " + strA + ",appVersion:" + miniAppLaunch.O(appModel));
        if (z11 && (zipFileInfo = offlinePkgCachePathJ.getZipFileInfo()) != null && (!zipFileInfo.isEmpty())) {
            String str = ((ZipFileInfo) CollectionsKt___CollectionsKt.e0(zipFileInfo)).getZipUnCompressPath() + '/' + appModel.getAppId() + ".zip";
            if (com.cloud.tmc.miniutils.util.j.A(str)) {
                appModel.setZipPath(str);
                return true;
            }
        }
        return false;
    }

    public final boolean A(Uri uri, String str) {
        String queryParameter;
        if (uri != null && (queryParameter = uri.getQueryParameter("target")) != null) {
            if (queryParameter.length() <= 0) {
                queryParameter = null;
            }
            if (queryParameter != null) {
                HashMap<String, String> mapP = P();
                String str2 = mapP != null ? mapP.get(e0.a().getPackageName()) : null;
                if (Intrinsics.b(str2, queryParameter) || str2 == null) {
                    return false;
                }
                try {
                    String query = uri.getQuery();
                    String queryParameter2 = uri.getQueryParameter("supportVersion");
                    String str3 = "dlt";
                    if (!Intrinsics.b(queryParameter2, "0") && queryParameter2 != null) {
                        str3 = "dlt" + queryParameter2;
                    }
                    String strM = M(mapP, queryParameter);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.addFlags(ASTNode.DEOP);
                    intent.setData(Uri.parse(str3 + "://miniapp?" + query));
                    intent.setPackage(strM);
                    e0.a().startActivity(intent);
                    return true;
                } catch (Exception e11) {
                    TmcLogger.e(e11.getMessage());
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.addFlags(ASTNode.DEOP);
                    intent2.setData(Uri.parse(str));
                    intent2.addCategory("android.intent.category.BROWSABLE");
                    e0.a().startActivity(intent2);
                    return true;
                }
            }
        }
        return false;
    }

    public final void B(String str) {
        try {
            TypeIntrinsics.d(f31786c).remove(str);
            TypeIntrinsics.d(f31787d).remove(str);
        } catch (Throwable unused) {
        }
    }

    public final void C(String str, String type) {
        Intrinsics.g(type, "type");
        if (str != null) {
            try {
                if (type.equals("u_s")) {
                    f31787d.put(str, Boolean.TRUE);
                }
                Map<String, Long> mapK = f31784a.K(str);
                if (mapK != null) {
                    mapK.put(type, Long.valueOf(System.currentTimeMillis()));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final boolean D(String nativePackageVersion, String networkVersion) {
        int iCharAt;
        int iCharAt2;
        Intrinsics.g(nativePackageVersion, "nativePackageVersion");
        Intrinsics.g(networkVersion, "networkVersion");
        try {
            if (TextUtils.isEmpty(networkVersion)) {
                return true;
            }
            String miniAppVersion = ((IConfigStrategyProxy) tc.a.a(IConfigStrategyProxy.class)).getMiniAppVersion(nativePackageVersion);
            String miniAppVersion2 = ((IConfigStrategyProxy) tc.a.a(IConfigStrategyProxy.class)).getMiniAppVersion(networkVersion);
            int length = miniAppVersion.length();
            int length2 = miniAppVersion2.length();
            int i11 = 0;
            int i12 = 0;
            do {
                if (i11 < length || i12 < length2) {
                    iCharAt = 0;
                    while (i11 < length && miniAppVersion.charAt(i11) != '.') {
                        iCharAt = ((iCharAt * 10) + miniAppVersion.charAt(i11)) - 48;
                        i11++;
                    }
                    i11++;
                    iCharAt2 = 0;
                    while (i12 < length2 && miniAppVersion2.charAt(i12) != '.') {
                        iCharAt2 = ((iCharAt2 * 10) + miniAppVersion2.charAt(i12)) - 48;
                        i12++;
                    }
                    i12++;
                }
            } while (iCharAt == iCharAt2);
            return iCharAt > iCharAt2;
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
        }
        return false;
    }

    public final boolean E() {
        try {
            return MiniAppConfigHelper.f30370a.b("enableCheckDownloadZip", true);
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
            return false;
        }
    }

    public final boolean F() {
        try {
            return MiniAppConfigHelper.f30370a.b("enableWebViewMask", true);
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
            return false;
        }
    }

    public final AppModel G(AppInfoModel appInfoModel) {
        Intrinsics.g(appInfoModel, "appInfoModel");
        AppModel appModel = new AppModel();
        appModel.setAppId(appInfoModel.getAppId());
        appModel.setLogo(appInfoModel.getLogo());
        appModel.setDesc(appInfoModel.getDesc());
        appModel.setName(appInfoModel.getName());
        appModel.setDeveloper(appInfoModel.getDeveloper());
        appModel.setPackageUrl(appInfoModel.getPackageUrl());
        appModel.setDeployVersion(appInfoModel.getDeployVersion());
        appModel.setDeveloperVersion(appInfoModel.getDeveloperVersion());
        appModel.setMiniappSubtype(appInfoModel.getMiniappSubtype());
        appModel.setTemplateMiniappId(appInfoModel.getTemplateMiniappId());
        appModel.setTemplatePackageUrl(appInfoModel.getTemplatePackageUrl());
        appModel.setTemplateDeployVersion(appInfoModel.getTemplateDeployVersion());
        appModel.setLowestSupportTemplateVersion(appInfoModel.getLowestSupportTemplateVersion());
        appModel.setCompatiblePackageUrl(appInfoModel.getCompatiblePackageUrl());
        appModel.setPermissions(appInfoModel.getPermissions());
        appModel.setExpiresTime(appInfoModel.getExpiresTime());
        appModel.setReleaseTime(appInfoModel.getReleaseTime());
        appModel.setLowestSupportVersion(appInfoModel.getLowestSupportVersion());
        appModel.setPackageSize(appInfoModel.getPackageSize());
        appModel.setClassificationNames(appInfoModel.getClassificationNames());
        appModel.setRegisterType(appInfoModel.getRegisterType());
        appModel.setExtend(appInfoModel.getExtend());
        appModel.setAppinfoCategoryType(appInfoModel.getAppinfoCategoryType());
        appModel.setLowestOpenedVersion(appInfoModel.getLowestOpenedVersion());
        appModel.setForceUpdate(appInfoModel.getForceUpdate());
        appModel.setTestVersion(appInfoModel.isTestVersion());
        appModel.setMainPackageUrl(appInfoModel.getMainPackageUrl());
        appModel.setSubPackageUrls(appInfoModel.getSubPackageUrls());
        appModel.setSubPackagePages(appInfoModel.getSubPackagePages());
        appModel.setMainPackagePages(appInfoModel.getMainPackagePages());
        appModel.setClassification(appInfoModel.getClassification());
        appModel.setUserAgreement(appInfoModel.getUserAgreement());
        appModel.setUserAgreementVersion(appInfoModel.getUserAgreementVersion());
        appModel.setUserAgreementUrl(appInfoModel.getUserAgreementUrl());
        appModel.setPrivacyPolicyUrl(appInfoModel.getPrivacyPolicyUrl());
        appModel.setLinkAndButtonColor(appInfoModel.getLinkAndButtonColor());
        appModel.setProcessingMethod(appInfoModel.getProcessingMethod());
        appModel.setPopupStyle(appInfoModel.getPopupStyle());
        PathProxy pathProxy = (PathProxy) tc.a.a(PathProxy.class);
        String mainPackageUrl = appModel.getMainPackageUrl();
        if (mainPackageUrl != null && mainPackageUrl.length() != 0) {
            appModel.setMainPackageUrlEncryption(h.f31061a.v(appModel.getMainPackageUrl() + ""));
            appModel.setMainPackageZipPath(pathProxy.getAppBaseDownloadPath(appModel.getAppId()) + '/' + appModel.getMainPackageUrlEncryption() + '/' + appModel.getMainPackageUrlEncryption() + ".zip");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(pathProxy.getAppBaseDownloadPath(appModel.getAppId()));
            sb2.append('/');
            sb2.append(appModel.getMainPackageUrlEncryption());
            sb2.append("/unzip");
            appModel.setMainPackageUnZipFilePath(sb2.toString());
        }
        List<SubPackageInfo> subPackagePages = appModel.getSubPackagePages();
        if (subPackagePages != null) {
            for (SubPackageInfo subPackageInfo : subPackagePages) {
                HashMap<String, String> subPackageUrls = appModel.getSubPackageUrls();
                String str = subPackageUrls != null ? subPackageUrls.get(subPackageInfo.getRoot()) : null;
                if (str != null && str.length() != 0) {
                    subPackageInfo.setSubPackageUrl(str);
                    subPackageInfo.setSubPackageUrlMD5(h.f31061a.v(str));
                    TmcLogger.c("Subpackage::", "root:" + subPackageInfo.getRoot() + ",encUrl:" + subPackageInfo.getSubPackageUrlMD5());
                    subPackageInfo.setSubZipPath(pathProxy.getAppBaseDownloadPath(appModel.getAppId()) + '/' + subPackageInfo.getSubPackageUrlMD5() + '/' + subPackageInfo.getSubPackageUrlMD5() + ".zip");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(pathProxy.getAppBaseDownloadPath(appModel.getAppId()));
                    sb3.append('/');
                    sb3.append(subPackageInfo.getSubPackageUrlMD5());
                    sb3.append("/unzip");
                    subPackageInfo.setSubUnzipFilePath(sb3.toString());
                }
            }
        }
        f31784a.o(appModel);
        return appModel;
    }

    public final EntryInfo H(AppInfoModel appInfoModel) {
        Intrinsics.g(appInfoModel, "appInfoModel");
        EntryInfo entryInfo = new EntryInfo();
        entryInfo.appId = appInfoModel.getAppId();
        entryInfo.desc = appInfoModel.getDesc();
        entryInfo.iconUrl = appInfoModel.getLogo();
        entryInfo.title = appInfoModel.getName();
        entryInfo.desc = appInfoModel.getDesc();
        entryInfo.slogan = appInfoModel.getSlogan();
        entryInfo.developer = appInfoModel.getDeveloper();
        entryInfo.setClassificationNames(appInfoModel.getClassificationNames());
        ExtendModel extend = appInfoModel.getExtend();
        entryInfo.setExclusiveLogoUrl(extend != null ? extend.getExclusiveLogoUrl() : null);
        return entryInfo;
    }

    public final String I(String str) {
        return AppDynamicBuildConfig.m() + "platform/appinfo/releaseInfo/" + str + ".json";
    }

    public final Map<String, Long> K(String appId) {
        Intrinsics.g(appId, "appId");
        try {
            Map<String, Map<String, Long>> map = f31786c;
            Map<String, Long> map2 = map.get(appId);
            if (map2 != null) {
                return map2;
            }
            HashMap map3 = new HashMap();
            map.put(appId, map3);
            return map3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String L(String defaultUrl) {
        Intrinsics.g(defaultUrl, "defaultUrl");
        return MiniAppConfigHelper.f30370a.e("preManagerConfigUrl", defaultUrl);
    }

    public final String M(HashMap<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (Intrinsics.b(entry.getValue(), str)) {
                return key;
            }
        }
        return null;
    }

    public final String O(AppModel appModel) {
        if (appModel == null) {
            return "";
        }
        String developerVersion = appModel.getDeveloperVersion();
        return !TextUtils.isEmpty(developerVersion) ? developerVersion : appModel.getDeployVersion();
    }

    public final HashMap<String, String> P() {
        try {
            return (HashMap) com.cloud.tmc.miniutils.util.k.e(((ConfigService) tc.a.a(ConfigService.class)).getConfigString("shareTarget", "{\"com.cloud.tmc.miniapp\":\"byte\",\"com.talpa.image.encryption\":\"ms\",\"com.transsion.hilauncher\":\"hi\"}"), HashMap.class);
        } catch (Exception e11) {
            TmcLogger.e(e11.getMessage());
            return null;
        }
    }

    public final long Q() {
        try {
            return MiniAppConfigHelper.f30370a.c("hideLoadingH5Time", 5000);
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
            return 5000L;
        }
    }

    public final long R() {
        try {
            return MiniAppConfigHelper.f30370a.c("hideLoadingNativeTime", 5000);
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
            return 5000L;
        }
    }

    public final String T(String str) {
        String strV0;
        return (str == null || (strV0 = StringsKt__StringsKt.V0(str, InstructionFileId.DOT, null, 2, null)) == null) ? "" : strV0;
    }

    public final boolean U(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            TmcAppInfoManager tmcAppInfoManager = (TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class);
            String strO = O(tmcAppInfoManager.getAppModelFromUsed(context, appId));
            String strO2 = O(tmcAppInfoManager.getAppModelFromPre(context, appId));
            if (strO != null && strO.length() != 0 && strO2 != null && strO2.length() != 0) {
                boolean zD = D(strO2, strO);
                TmcLogger.c(f31785b, "It's need update? update: " + zD);
                return zD;
            }
            return false;
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
            return false;
        }
    }

    public final void V(final Context context, String str) {
        Intrinsics.g(context, "context");
        try {
            com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: sd.a
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppLaunch.W(context);
                }
            });
        } catch (Exception unused) {
            TmcLogger.e("jump GooglePlay failed");
            X(context, str);
        }
    }

    public final void X(final Context context, String str) {
        Intrinsics.g(context, "context");
        try {
            com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: sd.b
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppLaunch.Y(context);
                }
            });
        } catch (Exception unused) {
            TmcLogger.e("jump jumpPalmStore failed");
        }
    }

    public final void a0(Bundle bundle, String str, Context context) {
        String string;
        String string2;
        String string3;
        String string4;
        if (!l.e()) {
            String str2 = f31785b;
            StringBuilder sbA = j.a("current process not allowed to start! processName:");
            sbA.append(l.c());
            TmcLogger.c(str2, sbA.toString());
            return;
        }
        Intent intent = new Intent();
        boolean z11 = bundle != null ? bundle.getBoolean("quickMode") : false;
        String str3 = "";
        if (bundle == null || (string = bundle.getString("page")) == null) {
            string = "";
        }
        boolean zR = r(z11, string);
        intent.putExtra("enableQuickMode", zR);
        StartClientBundle startClientBundleCreateFastStartClient = ActivityHelper.createFastStartClient(new lb.f(), 0);
        Bundle bundle2 = startClientBundleCreateFastStartClient.startParams;
        if (bundle2 != null) {
            bundle2.putBoolean("enableQuickMode", zR);
        }
        Bundle bundle3 = startClientBundleCreateFastStartClient.sceneParams;
        if (bundle3 != null) {
            bundle3.putBoolean("enableQuickMode", zR);
        }
        String strS = S();
        Bundle bundle4 = startClientBundleCreateFastStartClient.startParams;
        if (bundle4 != null) {
            bundle4.putString("targetProcess", strS);
        }
        Bundle bundle5 = startClientBundleCreateFastStartClient.sceneParams;
        if (bundle5 != null) {
            bundle5.putString("targetProcess", strS);
        }
        if (bundle != null) {
            Bundle bundle6 = startClientBundleCreateFastStartClient.startParams;
            if (bundle6 != null) {
                bundle6.putAll(bundle);
            }
            Bundle bundle7 = startClientBundleCreateFastStartClient.sceneParams;
            if (bundle7 != null) {
                bundle7.putAll(bundle);
            }
        }
        Unit unit = Unit.f68710a;
        intent.putExtra("startBundle", startClientBundleCreateFastStartClient);
        intent.putExtra("miniAppId", str);
        if (bundle == null || (string2 = bundle.getString("mode")) == null) {
            string2 = "";
        }
        intent.putExtra("mode", string2);
        if (bundle == null || (string3 = bundle.getString("sign")) == null) {
            string3 = "";
        }
        intent.putExtra("sign", string3);
        if (bundle != null && (string4 = bundle.getString("version")) != null) {
            str3 = string4;
        }
        intent.putExtra("version", str3);
        boolean z12 = context instanceof Activity;
        if (!z12) {
            intent.addFlags(ASTNode.DEOP);
        }
        ((IClientStarter) tc.a.a(IClientStarter.class)).startClient(context, intent, bundle);
        if (z12) {
            ((Activity) context).overridePendingTransition(R$anim.activity_bottom_in, R$anim.activity_scale_out);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ed A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x01f6 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x01ff A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0208 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x020d A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x021b A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0229 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0230 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0241 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0186  */
    /* JADX WARN: Code duplicated, block: B:87:0x0191 A[Catch: all -> 0x019a, TRY_LEAVE, TryCatch #2 {all -> 0x019a, blocks: (B:85:0x018b, B:87:0x0191), top: B:130:0x018b }] */
    /* JADX WARN: Code duplicated, block: B:89:0x019a  */
    /* JADX WARN: Code duplicated, block: B:92:0x01cd A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01d2 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01db A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01e4 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:13:0x007f, B:16:0x00a1, B:22:0x00b5, B:24:0x00bf, B:28:0x00d0, B:30:0x00de, B:34:0x00e7, B:37:0x00ef, B:39:0x00f5, B:51:0x0120, B:53:0x0126, B:55:0x0132, B:68:0x0158, B:70:0x015e, B:72:0x0168, B:90:0x019b, B:92:0x01cd, B:94:0x01d2, B:96:0x01db, B:98:0x01e4, B:100:0x01ed, B:102:0x01f6, B:104:0x01ff, B:106:0x0208, B:108:0x020d, B:109:0x0210, B:111:0x021b, B:112:0x0220, B:114:0x0229, B:116:0x0230, B:117:0x0237, B:119:0x0241, B:120:0x0246, B:74:0x016e, B:81:0x0183, B:57:0x0138, B:64:0x014d, B:46:0x010a, B:75:0x0172, B:77:0x0178, B:79:0x017e, B:40:0x00f9, B:42:0x00ff, B:44:0x0105, B:58:0x013c, B:60:0x0142, B:62:0x0148), top: B:126:0x0035, inners: #1, #3, #4 }] */
    public final void b0(Context context, String url, String from) {
        String queryParameter;
        String strD;
        String strV;
        Boolean bool;
        String str;
        String str2;
        Boolean boolValueOf;
        Boolean bool2;
        Boolean boolValueOf2;
        Boolean boolValueOf3;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        Bundle bundle;
        String queryParameter7;
        Boolean boolValueOf4;
        String strD2;
        String strD3;
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        Intrinsics.g(from, "from");
        try {
            TmcLogger.c(f31785b, "Step_解析url->" + url);
            boolean zB = MiniAppConfigHelper.f30370a.b("fixEncodeUrl", true);
            String strC = n0.f31078a.c(url, zB);
            Uri uri = Uri.parse(strC);
            if (A(uri, strC)) {
                return;
            }
            if (uri != null) {
                try {
                    queryParameter = uri.getQueryParameter("miniapp_deeplink");
                } catch (Throwable unused) {
                }
            } else {
                queryParameter = null;
            }
            if (queryParameter != null && queryParameter.length() > 0) {
                uri = Uri.parse(r.d(queryParameter));
            }
            String queryParameter8 = uri.getQueryParameter(PushConstants.PROVIDER_FIELD_APP_ID);
            String queryParameter9 = uri.getQueryParameter("version");
            String queryParameter10 = uri.getQueryParameter("page");
            String queryParameter11 = uri.getQueryParameter("mode");
            n0 n0Var = n0.f31078a;
            String queryParameter12 = uri.getQueryParameter("query");
            String strD4 = n0Var.d((queryParameter12 == null || (strD3 = r.d(queryParameter12)) == null) ? "" : strD3, zB);
            String queryParameter13 = uri.getQueryParameter("h5Path");
            String strD5 = n0Var.d((queryParameter13 == null || (strD2 = r.d(queryParameter13)) == null) ? "" : strD2, zB);
            String queryParameter14 = uri.getQueryParameter("hybridPath");
            if (queryParameter14 == null || (strD = r.d(queryParameter14)) == null) {
                strD = "";
            }
            String strD6 = n0Var.d(strD, zB);
            if (strD6 == null || strD6.length() <= 0) {
                strV = queryParameter10;
                bool = null;
            } else {
                String strV2 = v(strD6);
                try {
                    String queryParameter15 = uri.getQueryParameter("quickMode");
                    boolValueOf4 = Boolean.valueOf(queryParameter15 != null ? Boolean.parseBoolean(queryParameter15) : true);
                } catch (Throwable unused2) {
                    boolValueOf4 = Boolean.TRUE;
                }
                strV = strV2;
                bool = boolValueOf4;
            }
            try {
                if (strV != null && strV.length() > 0) {
                    str = queryParameter11;
                    str2 = "mode";
                    if (kotlin.text.l.L(strV, AgentPageJsBridge.HTTPS, false, 2, null) || kotlin.text.l.L(strV, "http://", false, 2, null)) {
                        strV = v(strV);
                        try {
                            String queryParameter16 = uri.getQueryParameter("quickMode");
                            boolValueOf = Boolean.valueOf(queryParameter16 != null ? Boolean.parseBoolean(queryParameter16) : true);
                        } catch (Throwable unused3) {
                            boolValueOf = Boolean.TRUE;
                        }
                    }
                    if (strV == null && strV.length() > 0) {
                        bool2 = null;
                        if (kotlin.text.l.L(strV, AgentPageJsBridge.HTTPS, false, 2, null) || kotlin.text.l.L(strV, "http://", false, 2, null)) {
                            strV = v(strV);
                            try {
                                String queryParameter17 = uri.getQueryParameter("quickMode");
                                boolValueOf2 = Boolean.valueOf(queryParameter17 != null ? Boolean.parseBoolean(queryParameter17) : true);
                            } catch (Throwable unused4) {
                                boolValueOf2 = Boolean.TRUE;
                            }
                        }
                        queryParameter7 = uri.getQueryParameter("extraMiniClearAllPages");
                        if (queryParameter7 != null) {
                            boolValueOf3 = Boolean.valueOf(Boolean.parseBoolean(queryParameter7));
                        } else {
                            boolValueOf3 = bool2;
                        }
                        queryParameter2 = uri.getQueryParameter("extraMiniBackToUrl");
                        queryParameter3 = uri.getQueryParameter("sign");
                        String queryParameter18 = uri.getQueryParameter(TrackingKey.SCENE_ID);
                        queryParameter4 = uri.getQueryParameter("fis_type");
                        queryParameter5 = uri.getQueryParameter("mfah");
                        queryParameter6 = uri.getQueryParameter("massid");
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.f(applicationContext, "context.applicationContext");
                        bundle = new Bundle();
                        if (strV != null) {
                            bundle.putString("page", strV);
                        }
                        if (str != null) {
                            bundle.putString(str2, str);
                        }
                        if (strD4 != null) {
                            bundle.putString("query", strD4);
                        }
                        if (strD5 != null) {
                            bundle.putString("h5Path", strD5);
                        }
                        if (boolValueOf2 != null) {
                            bundle.putBoolean("quickMode", boolValueOf2.booleanValue());
                        }
                        if (queryParameter9 != 0) {
                            bundle.putString("version", queryParameter9);
                        }
                        if (boolValueOf3 != null) {
                            bundle.putBoolean("extraMiniClearAllPages", boolValueOf3.booleanValue());
                        }
                        if (queryParameter2 != null) {
                            bundle.putString("extraMiniBackToUrl", queryParameter2);
                        }
                        if (queryParameter3 != null) {
                            bundle.putString("sign", queryParameter3);
                        }
                        bundle.putString(TrackingKey.SCENE_ID, xb.e.a(queryParameter18, "100000"));
                        if (queryParameter4 != null) {
                            bundle.putString("fis_type", queryParameter4);
                        }
                        bundle.putString("entranceUrl", strC);
                        if (queryParameter5 != null) {
                            bundle.putString("mfah", queryParameter5);
                        }
                        if (queryParameter6 != null) {
                            bundle.putString("massid", queryParameter6);
                        }
                        if (Intrinsics.b(from, "ps")) {
                            bundle.putString("miniapp_frm_start", "ps");
                        }
                        Unit unit = Unit.f68710a;
                        d0(applicationContext, queryParameter8, bundle);
                    }
                    bool2 = null;
                    boolValueOf2 = boolValueOf;
                    queryParameter7 = uri.getQueryParameter("extraMiniClearAllPages");
                    if (queryParameter7 != null) {
                        boolValueOf3 = Boolean.valueOf(Boolean.parseBoolean(queryParameter7));
                    } else {
                        boolValueOf3 = bool2;
                    }
                    queryParameter2 = uri.getQueryParameter("extraMiniBackToUrl");
                    queryParameter3 = uri.getQueryParameter("sign");
                    String queryParameter19 = uri.getQueryParameter(TrackingKey.SCENE_ID);
                    queryParameter4 = uri.getQueryParameter("fis_type");
                    queryParameter5 = uri.getQueryParameter("mfah");
                    queryParameter6 = uri.getQueryParameter("massid");
                    Context applicationContext2 = context.getApplicationContext();
                    Intrinsics.f(applicationContext2, "context.applicationContext");
                    bundle = new Bundle();
                    if (strV != null) {
                        bundle.putString("page", strV);
                    }
                    if (str != null) {
                        bundle.putString(str2, str);
                    }
                    if (strD4 != null) {
                        bundle.putString("query", strD4);
                    }
                    if (strD5 != null) {
                        bundle.putString("h5Path", strD5);
                    }
                    if (boolValueOf2 != null) {
                        bundle.putBoolean("quickMode", boolValueOf2.booleanValue());
                    }
                    if (queryParameter9 != 0) {
                        bundle.putString("version", queryParameter9);
                    }
                    if (boolValueOf3 != null) {
                        bundle.putBoolean("extraMiniClearAllPages", boolValueOf3.booleanValue());
                    }
                    if (queryParameter2 != null) {
                        bundle.putString("extraMiniBackToUrl", queryParameter2);
                    }
                    if (queryParameter3 != null) {
                        bundle.putString("sign", queryParameter3);
                    }
                    bundle.putString(TrackingKey.SCENE_ID, xb.e.a(queryParameter19, "100000"));
                    if (queryParameter4 != null) {
                        bundle.putString("fis_type", queryParameter4);
                    }
                    bundle.putString("entranceUrl", strC);
                    if (queryParameter5 != null) {
                        bundle.putString("mfah", queryParameter5);
                    }
                    if (queryParameter6 != null) {
                        bundle.putString("massid", queryParameter6);
                    }
                    if (Intrinsics.b(from, "ps")) {
                        bundle.putString("miniapp_frm_start", "ps");
                    }
                    Unit unit2 = Unit.f68710a;
                    d0(applicationContext2, queryParameter8, bundle);
                }
                str = queryParameter11;
                str2 = "mode";
                queryParameter7 = uri.getQueryParameter("extraMiniClearAllPages");
                if (queryParameter7 != null) {
                    boolValueOf3 = Boolean.valueOf(Boolean.parseBoolean(queryParameter7));
                } else {
                    boolValueOf3 = bool2;
                }
            } catch (Throwable unused5) {
            }
            boolValueOf = bool;
            if (strV == null) {
                bool2 = null;
                boolValueOf2 = boolValueOf;
            } else {
                bool2 = null;
                boolValueOf2 = boolValueOf;
            }
            queryParameter2 = uri.getQueryParameter("extraMiniBackToUrl");
            queryParameter3 = uri.getQueryParameter("sign");
            String queryParameter110 = uri.getQueryParameter(TrackingKey.SCENE_ID);
            queryParameter4 = uri.getQueryParameter("fis_type");
            queryParameter5 = uri.getQueryParameter("mfah");
            queryParameter6 = uri.getQueryParameter("massid");
            Context applicationContext3 = context.getApplicationContext();
            Intrinsics.f(applicationContext3, "context.applicationContext");
            bundle = new Bundle();
            if (strV != null) {
                bundle.putString("page", strV);
            }
            if (str != null) {
                bundle.putString(str2, str);
            }
            if (strD4 != null) {
                bundle.putString("query", strD4);
            }
            if (strD5 != null) {
                bundle.putString("h5Path", strD5);
            }
            if (boolValueOf2 != null) {
                bundle.putBoolean("quickMode", boolValueOf2.booleanValue());
            }
            if (queryParameter9 != 0) {
                bundle.putString("version", queryParameter9);
            }
            if (boolValueOf3 != null) {
                bundle.putBoolean("extraMiniClearAllPages", boolValueOf3.booleanValue());
            }
            if (queryParameter2 != null) {
                bundle.putString("extraMiniBackToUrl", queryParameter2);
            }
            if (queryParameter3 != null) {
                bundle.putString("sign", queryParameter3);
            }
            bundle.putString(TrackingKey.SCENE_ID, xb.e.a(queryParameter110, "100000"));
            if (queryParameter4 != null) {
                bundle.putString("fis_type", queryParameter4);
            }
            bundle.putString("entranceUrl", strC);
            if (queryParameter5 != null) {
                bundle.putString("mfah", queryParameter5);
            }
            if (queryParameter6 != null) {
                bundle.putString("massid", queryParameter6);
            }
            if (Intrinsics.b(from, "ps")) {
                bundle.putString("miniapp_frm_start", "ps");
            }
            Unit unit3 = Unit.f68710a;
            d0(applicationContext3, queryParameter8, bundle);
        } catch (Exception e11) {
            TmcLogger.e(e11.getMessage());
        }
    }

    public final void e0(String str, String type) {
        Intrinsics.g(type, "type");
        try {
            Bundle bundle = new Bundle();
            bundle.putString("close_type", type);
            bundle.putBoolean("auto_close_app_status", s.b.f75901a.c(str));
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).recordForCommon(str, "miniapp_auto_close_record", bundle);
            TmcLogger.c(f31785b, "miniappLauncherFailed->" + type);
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
        }
    }

    public final void f0(final Context context) {
        if (context == null) {
            return;
        }
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: sd.d
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppLaunch.g0(context);
            }
        });
    }

    public final void h0(Context context, String str, c0 prepareCallback) {
        Intrinsics.g(prepareCallback, "prepareCallback");
        ((IUpgradeProxy) tc.a.a(IUpgradeProxy.class)).showFwUpdateTipsDialog(context, str, prepareCallback);
    }

    public final void i0(Context context, w.a aVar) {
        if (context == null) {
            return;
        }
        final o000oOoO o000oooo = new o000oOoO(context);
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: sd.e
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppLaunch.j0(o000oooo);
            }
        });
        if (aVar != null) {
            aVar.a(o000oooo);
        }
    }

    @JvmOverloads
    public final void j(Context context, AppModel appModel, int i11, Function0<Unit> function0, Function3<? super String, ? super String, ? super IOException, Unit> function3, Function0<Unit> function1) {
        Intrinsics.g(appModel, "appModel");
        if (context == null) {
            return;
        }
        if (o00Ooo.e(appModel)) {
            n(context, appModel, i11, function0, function3, function1);
            StringBuilder sbA = x.a.a(appModel, j.a("backgroundDownSubPkgZip:appInfo:appId:"), ";deployVersion:");
            sbA.append(appModel.getDeployVersion());
            TmcLogger.c("Subpackage::", sbA.toString());
            return;
        }
        m(context, appModel, i11, function0, function3, function1);
        StringBuilder sbA2 = x.a.a(appModel, j.a("backgroundDownWholePkgZip:appInfo:appId:"), ";deployVersion:");
        sbA2.append(appModel.getDeployVersion());
        TmcLogger.c("Subpackage::", sbA2.toString());
    }

    public final void k0(final Context context, final String str, final w.a aVar) {
        if (context == null) {
            return;
        }
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: sd.c
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppLaunch.l0(context, str, aVar);
            }
        });
    }

    public final boolean l(AppModel appModel, Context context, Function0<Unit> function0) {
        if (!x(appModel)) {
            return false;
        }
        ((TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class)).updateAppModel(context, appModel, appModel.getAppId() + "_pre");
        TmcLogger.c(f31785b, "Step_APP_Download_资源包后台从离线框架获取成功，进行解压");
        h.f31061a.n(context, appModel, true);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("backgroundDownloadOfflineCheck:changeZipDownloadStatus true:appInfo:appId:");
        StringBuilder sbA = x.a.a(appModel, sb2, ";deployVersion:");
        sbA.append(appModel.getDeployVersion());
        sbA.append(";mainPkgUrl:");
        sbA.append(appModel.getMainPackageUrl());
        sbA.append(";fullPkgUrl:");
        sbA.append(appModel.getPackageUrl());
        TmcLogger.c("Subpackage::", sbA.toString());
        if (function0 != null) {
            function0.invoke();
        }
        return true;
    }

    @JvmOverloads
    public final void m(Context context, AppModel appModel, int i11, Function0<Unit> function0, Function3<? super String, ? super String, ? super IOException, Unit> function3, Function0<Unit> function1) {
        Intrinsics.g(appModel, "appModel");
        if (context == null || l(appModel, context, function0)) {
            return;
        }
        TmcResourceManager tmcResourceManager = (TmcResourceManager) tc.a.a(TmcResourceManager.class);
        tmcResourceManager.downloadApp(appModel, i11, true, new a(function1, tmcResourceManager, appModel, context, function0, function3));
    }

    @JvmOverloads
    public final void n(Context context, AppModel appModel, int i11, Function0<Unit> function0, Function3<? super String, ? super String, ? super IOException, Unit> function3, Function0<Unit> function1) {
        Intrinsics.g(appModel, "appModel");
        if (context == null) {
            return;
        }
        try {
            if (l(appModel, context, function0)) {
                return;
            }
            TmcResourceManager tmcResourceManager = (TmcResourceManager) tc.a.a(TmcResourceManager.class);
            String mainPackageUrlEncryption = appModel.getMainPackageUrlEncryption();
            tmcResourceManager.downloadApp(appModel.getAppId(), appModel.getMainPackageUrl(), mainPackageUrlEncryption, appModel.getMainPackageZipPath(), i11, true, new b(function1, tmcResourceManager, mainPackageUrlEncryption, appModel, context, function0, function3));
        } catch (Throwable th2) {
            TmcLogger.g(f31785b, "", th2);
        }
    }

    public final void n0(String str, Bundle bundle) {
        Long l11;
        Long l12;
        Long l13;
        Long l14;
        Long l15;
        Long l16;
        try {
            if (Intrinsics.b(f31787d.get(str), Boolean.TRUE)) {
                Map<String, Long> map = f31786c.get(str);
                long jLongValue = ((map == null || (l16 = map.get("u_e")) == null) ? 0L : l16.longValue()) - ((map == null || (l15 = map.get("u_s")) == null) ? 0L : l15.longValue());
                long j11 = -1;
                if (jLongValue < 0) {
                    jLongValue = -1;
                }
                long jLongValue2 = ((map == null || (l14 = map.get("d_e")) == null) ? 0L : l14.longValue()) - ((map == null || (l13 = map.get("d_s")) == null) ? 0L : l13.longValue());
                if (jLongValue2 < 0) {
                    jLongValue2 = -1;
                }
                long jLongValue3 = ((map == null || (l12 = map.get("l_e")) == null) ? 0L : l12.longValue()) - ((map == null || (l11 = map.get("l_s")) == null) ? 0L : l11.longValue());
                if (jLongValue3 >= 0) {
                    j11 = jLongValue3;
                }
                JsonObject jsonObjectE = z.a().c("u_t", Long.valueOf(jLongValue)).c("d_t", Long.valueOf(jLongValue2)).c("l_t", Long.valueOf(j11)).e();
                Intrinsics.f(jsonObjectE, "create().addProperty(\"u_…rty(\"l_t\", step3).build()");
                String strA = o.a(jsonObjectE);
                if (bundle != null) {
                    bundle.putString("m_c_p", strA);
                }
                B(str);
            }
        } catch (Throwable unused) {
        }
    }

    public final void o(AppModel appmodel) {
        Intrinsics.g(appmodel, "appmodel");
        PathProxy pathProxy = (PathProxy) tc.a.a(PathProxy.class);
        TmcResourceManager tmcResourceManager = (TmcResourceManager) tc.a.a(TmcResourceManager.class);
        appmodel.setPackageUrl_MD5(h.f31061a.v(AppUtils.f31011a.n(appmodel) + ""));
        tmcResourceManager.creatBaseDirectory(appmodel);
        appmodel.setZipPath(pathProxy.getZipPath(appmodel));
        appmodel.setUnzipFilePath(pathProxy.getZipUnCompressPath(appmodel));
    }

    public final void o0(CDNConfigBean cDNConfigBean, Context context) {
        try {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, "minisdk_storage", "appInfoCDNConfig", com.cloud.tmc.miniutils.util.k.j(cDNConfigBean));
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
        }
    }

    public final void p(Application application) {
        Intrinsics.g(application, "application");
        ByteAppManager.init(application, OooO0OO.OooO00o);
    }

    public final boolean p0(CDNConfigBean cDNConfigBean, Context context) {
        Float grayScale;
        Boolean enableCdnRequest = cDNConfigBean != null ? cDNConfigBean.getEnableCdnRequest() : null;
        Boolean bool = Boolean.FALSE;
        if (Intrinsics.b(bool, enableCdnRequest)) {
            TmcLogger.c(f31785b, "cdn request is closed");
            return false;
        }
        float fNextFloat = new SecureRandom().nextFloat();
        float fFloatValue = (cDNConfigBean == null || (grayScale = cDNConfigBean.getGrayScale()) == null) ? 1.0f : grayScale.floatValue();
        if (fFloatValue < fNextFloat) {
            TmcLogger.c(f31785b, "not in the gray range: [grayScale]->" + fFloatValue + ",[randomFloat]->" + fNextFloat);
            if (cDNConfigBean != null) {
                cDNConfigBean.setEnableCdnRequest(bool);
            }
            o0(cDNConfigBean, context);
            return false;
        }
        TmcLogger.c(f31785b, "in the gray range: [grayScale]->" + fFloatValue + ",[randomFloat]->" + fNextFloat);
        if (cDNConfigBean != null) {
            cDNConfigBean.setEnableCdnRequest(Boolean.TRUE);
        }
        o0(cDNConfigBean, context);
        return true;
    }

    public final boolean q(Context context) {
        CDNConfigBean cDNConfigBean;
        CDNConfigBean cDNConfigBean2;
        Intrinsics.g(context, "context");
        try {
            cDNConfigBean = (CDNConfigBean) com.cloud.tmc.miniutils.util.k.f().fromJson(((ConfigService) tc.a.a(ConfigService.class)).getConfigString("appInfoCDNConfig", "{\"enableCdnRequest\":true,\"cdnConfigToken\":\"1\",\"grayScale\":0.5}"), CDNConfigBean.class);
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
            cDNConfigBean = null;
        }
        try {
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "minisdk_storage", "appInfoCDNConfig");
            cDNConfigBean2 = string != null ? (CDNConfigBean) com.cloud.tmc.miniutils.util.k.f().fromJson(string, CDNConfigBean.class) : null;
        } catch (Throwable th3) {
            TmcLogger.h(f31785b, th3);
        }
        if (cDNConfigBean2 == null) {
            return f31784a.p0(cDNConfigBean, context);
        }
        if (!Intrinsics.b(cDNConfigBean2.getCdnConfigToken(), cDNConfigBean != null ? cDNConfigBean.getCdnConfigToken() : null)) {
            String str = f31785b;
            StringBuilder sbA = j.a("cdn request token changed:[nativeToken]->");
            sbA.append(cDNConfigBean2.getCdnConfigToken());
            sbA.append(",[cloudToken]->");
            kd.k.a(sbA, cDNConfigBean != null ? cDNConfigBean.getCdnConfigToken() : null, str);
            return f31784a.p0(cDNConfigBean, context);
        }
        String str2 = f31785b;
        StringBuilder sbA2 = j.a("storage cdn request status:");
        sbA2.append(cDNConfigBean2.getEnableCdnRequest());
        TmcLogger.c(str2, sbA2.toString());
        Boolean enableCdnRequest = cDNConfigBean2.getEnableCdnRequest();
        if (enableCdnRequest != null) {
            return enableCdnRequest.booleanValue();
        }
        return true;
    }

    public final void q0() {
        TmcLogger.c(f31785b, "warmUpWorker");
        ((IInnerWorkerPool) tc.a.a(IInnerWorkerPool.class)).createWorker(false);
    }

    public final boolean r(boolean z11, String str) {
        boolean configBoolean = ((ConfigService) tc.a.a(ConfigService.class)).getConfigBoolean("miniEnableQuickModeLaunch", true);
        if (!configBoolean) {
            TmcLogger.c(f31785b, "checkEnableAppQuickModel->" + configBoolean);
            return false;
        }
        if ((!kotlin.text.l.L(str, AgentPageJsBridge.HTTPS, false, 2, null) && !kotlin.text.l.L(str, "http://", false, 2, null)) || !z11) {
            return false;
        }
        TmcLogger.c(f31785b, "checkEnableAppQuickModel extQuickMode->" + z11);
        return true;
    }

    public final void r0(Context context, boolean z11) {
        Intrinsics.g(context, "context");
        try {
            IpcMiniLauncherService.f31538a.b(context.getApplicationContext(), z11, new e(z11));
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
        }
    }

    public final boolean s() {
        try {
            return MiniAppConfigHelper.f30370a.b("enableBackgroundUnzipV3", true);
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
            return false;
        }
    }

    public final void s0() {
        TmcLogger.c(f31785b, "warmupRender");
        ((IInnerRenderPool) tc.a.a(IInnerRenderPool.class)).createRender(false);
    }

    public final boolean t(AppModel appModel, int i11) {
        List arrayList;
        Intrinsics.g(appModel, "appModel");
        try {
            String appId = appModel.getAppId();
            if (appId == null) {
                return false;
            }
            String configString = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("miniEnableForceUpdateModelList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            Object obj = null;
            if (configString != null) {
                Object objE = com.cloud.tmc.miniutils.util.k.e(configString, new TypeToken<ArrayList<ForceUpdateModel>>() { // from class: com.cloud.tmc.miniapp.utils.MiniAppLaunch$checkFocusUpdateMyByteApp$enableForceUpdateList$1$1
                }.getType());
                arrayList = objE instanceof List ? (List) objE : null;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
            } else {
                arrayList = new ArrayList();
            }
            for (Object obj2 : arrayList) {
                if (Intrinsics.b(appId, ((ForceUpdateModel) obj2).getAppId())) {
                    obj = obj2;
                    break;
                }
            }
            ForceUpdateModel forceUpdateModel = (ForceUpdateModel) obj;
            if (forceUpdateModel == null) {
                return false;
            }
            if (i11 != 1) {
                return i11 == 2;
            }
            MiniAppLaunch miniAppLaunch = f31784a;
            String version = forceUpdateModel.getVersion();
            String str = "";
            if (version == null) {
                version = "";
            }
            String strO = miniAppLaunch.O(appModel);
            if (strO != null) {
                str = strO;
            }
            boolean zD = miniAppLaunch.D(version, str);
            TmcLogger.c(f31785b, "appinfo 需要强制更新" + zD);
            return zD;
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
            return false;
        }
    }

    public final boolean u(String oldFwVersion, String newFwVersion) {
        Intrinsics.g(oldFwVersion, "oldFwVersion");
        Intrinsics.g(newFwVersion, "newFwVersion");
        if (!((ConfigService) tc.a.a(ConfigService.class)).getConfigBoolean("updateCompareVersion", true)) {
            return true;
        }
        try {
            List listE0 = StringsKt__StringsKt.E0(oldFwVersion, new String[]{InstructionFileId.DOT}, false, 0, 6, null);
            Intrinsics.e(listE0, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
            List listC = TypeIntrinsics.c(listE0);
            List listE1 = StringsKt__StringsKt.E0(newFwVersion, new String[]{InstructionFileId.DOT}, false, 0, 6, null);
            Intrinsics.e(listE1, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
            List listC2 = TypeIntrinsics.c(listE1);
            if (listC.size() > 3) {
                kotlin.collections.k.H(listC);
            }
            if (listC2.size() > 3) {
                kotlin.collections.k.H(listC2);
            }
            return Integer.parseInt((String) listC2.get(0)) > Integer.parseInt((String) listC.get(0)) || Integer.parseInt((String) listC2.get(1)) > Integer.parseInt((String) listC.get(1));
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
            return true;
        }
    }

    public final String v(String url) {
        Intrinsics.g(url, "url");
        try {
            Object objE = com.cloud.tmc.miniutils.util.k.e(l.e() ? MiniAppConfigHelper.f30370a.e("hybridUrlBlackList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) : MiniAppConfigHelper.f30370a.e("hybridUrlBlackList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.utils.MiniAppLaunch$checkH5UrlInBlackList$blackList$1
            }.getType());
            List<String> arrayList = objE instanceof List ? (List) objE : null;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            String host = r.g(url);
            for (String str : arrayList) {
                Intrinsics.f(host, "host");
                if (StringsKt__StringsKt.Q(host, str, false, 2, null)) {
                    TmcLogger.f(f31785b, "url in blackList return " + url);
                    return null;
                }
            }
            return url;
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
            return url;
        }
    }

    public final boolean w(String str) {
        return str == null || str.length() == 0 || T(GlobalPackageConfig.Companion.b()).compareTo(T(str)) >= 0;
    }

    public final boolean y(Context context, String str, Bundle bundle) {
        AppModel appModel;
        if (str == null || str.length() == 0) {
            TmcLogger.f(f31785b, "checkOpenBrowser failed. appId is null.");
            return false;
        }
        try {
            if (!l.e() || (appModel = ((TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class)).getAppModel(context, lb.a.f70163b.a(str))) == null) {
                return false;
            }
            if (!PreStrategyManager.f31651a.g(context, str, bundle != null ? bundle.getString(TrackingKey.SCENE_ID) : null)) {
                TmcLogger.f(f31785b, "checkOpenBrowser failed. PreStrategyManager.checkEnableOpenBrowser is false.");
                return false;
            }
            ExtendModel extend = appModel.getExtend();
            String strB = i.b(extend != null ? extend.getH5Url() : null, bundle);
            if (strB.length() == 0) {
                TmcLogger.f(f31785b, "checkOpenBrowser failed. url is null.");
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strB));
            intent.addFlags(ASTNode.DEOP);
            context.startActivity(intent);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(str, PointAnalyseType.POINT_OPEN_BROWSER, "");
            return true;
        } catch (Throwable th2) {
            TmcLogger.h(f31785b, th2);
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final boolean z(String str) {
        Long lN;
        if (str == null || str.length() == 0 || (lN = kotlin.text.k.n(str)) == null) {
            return false;
        }
        return !NetworkUtils.w() && lN.longValue() / ((long) 1000) > ((long) ((ConfigService) tc.a.a(ConfigService.class)).getConfigInt("packageSize", 550));
    }
}
