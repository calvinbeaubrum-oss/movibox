package z;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.utils.k0;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.mbridge.msdk.MBridgeConstans;
import i0.m;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class f extends a0.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f81667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f81668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f81669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f81670l;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements wc.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f81671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f81672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppModel f81673c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f81674d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f81675e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ lb.g f81676f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f81677g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ PrepareController f81678h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ c0 f81679i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f81680j;

        public a(boolean z11, f fVar, AppModel appModel, String str, String str2, lb.g gVar, String str3, PrepareController prepareController, c0 c0Var, String str4) {
            this.f81671a = z11;
            this.f81672b = fVar;
            this.f81673c = appModel;
            this.f81674d = str;
            this.f81675e = str2;
            this.f81676f = gVar;
            this.f81677g = str3;
            this.f81678h = prepareController;
            this.f81679i = c0Var;
            this.f81680j = str4;
        }

        @Override // wc.f
        public /* synthetic */ void a(String str, int i11, String str2, long j11, long j12) {
            wc.e.a(this, str, i11, str2, j11, j12);
        }

        /* JADX WARN: Code duplicated, block: B:40:0x0121  */
        @Override // wc.f
        public void b(String str, String str2, String str3, IOException iOException, String str4) {
            String str5;
            String simpleName;
            String str6;
            try {
                k0.f31068a.c(this.f81676f.p(), this.f81673c.getAppId(), this.f81677g, false);
                PointAnalyseType pointAnalyseTypePutData = PointAnalyseType.POINT_PACKAGE_DOWNLOAD_FAILED.putData("mpu_download_type", this.f81671a ? "sync" : "async").putData("mpu_appId", this.f81673c.getAppId()).putData("mpu_old_v", this.f81674d).putData("mpu_new_v", this.f81675e);
                if (iOException != null) {
                    try {
                        simpleName = iOException.getClass().getSimpleName();
                    } catch (Throwable th2) {
                        th = th2;
                        str5 = "Tmc";
                    }
                } else {
                    simpleName = null;
                }
                PointAnalyseType pointAnalyseTypePutData2 = pointAnalyseTypePutData.putData("mpu_result", simpleName).putData("mpu_error_code", str2).putData("mpu_error_msg", iOException != null ? iOException.getMessage() : null).putData("mpu_chain_uniqueId", this.f81676f.q().getString("uniqueChainID", "-1"));
                Intrinsics.f(pointAnalyseTypePutData2, "POINT_PACKAGE_DOWNLOAD_F…                        )");
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f81676f.c(), this.f81672b.f81669k.a(pointAnalyseTypePutData2), "");
                try {
                    this.f81672b.f31601c.removeDownloadAppMap(this.f81677g);
                } catch (Throwable th3) {
                    TmcLogger.h("Tmc", th3);
                }
                try {
                    if (!this.f81671a) {
                        this.f81679i.g(this.f81673c, false);
                        return;
                    }
                    if (!TextUtils.isEmpty(this.f81674d) && !TextUtils.isEmpty(this.f81675e) && (str6 = this.f81675e) != null) {
                        String str7 = this.f81674d;
                        AppModel appModel = this.f81673c;
                        lb.g gVar = this.f81676f;
                        f fVar = this.f81672b;
                        if (str7 != null) {
                            if (MiniAppLaunch.f31784a.D(str6, str7)) {
                                PointAnalyseType pointAnalyseTypePutData3 = PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL.putData("mpu_appId", appModel.getAppId()).putData("mpu_old_v", str7).putData("mpu_new_v", str6).putData("mpu_result", "DOWNLOAD_FAIL").putData("mpu_chain_uniqueId", gVar.q().getString("uniqueChainID", "-1"));
                                Intrinsics.f(pointAnalyseTypePutData3, "POINT_PACKAGE_UPDATE_FAI…                        )");
                                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), fVar.f81669k.a(pointAnalyseTypePutData3), "");
                            }
                        }
                    }
                    TmcLogger.c(this.f81672b.f31599a, "Step_Download_资源包下载失败，" + str3);
                    this.f81678h.moveToError(new PrepareException("4", "download error:" + str3 + "   url:" + this.f81680j));
                    return;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
                str = "Tmc";
            }
            str5 = str;
            TmcLogger.h(str5, th);
            if (this.f81671a) {
                this.f81678h.moveToError(new PrepareException("download error"));
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // wc.f
        public void c(String str, String str2) {
            try {
                TmcLogger.c(this.f81672b.f31599a, "Step_Download_资源包下载完成，进行解压");
                k0.f31068a.c(this.f81676f.p(), this.f81673c.getAppId(), this.f81677g, true);
                PointAnalyseType pointAnalyseTypePutData = PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.putData("mpu_download_type", this.f81671a ? "sync" : "async").putData("mpu_appId", this.f81673c.getAppId()).putData("mpu_old_v", this.f81674d).putData("mpu_new_v", this.f81675e).putData("mpu_chain_uniqueId", this.f81676f.q().getString("uniqueChainID", "-1"));
                Intrinsics.f(pointAnalyseTypePutData, "POINT_PACKAGE_DOWNLOAD_S…                        )");
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f81676f.c(), this.f81672b.f81669k.a(pointAnalyseTypePutData), "");
                try {
                    this.f81672b.f31601c.removeDownloadAppMap(this.f81677g);
                } catch (Throwable th2) {
                    TmcLogger.h("Tmc", th2);
                }
                if (this.f81671a) {
                    PrepareController prepareController = this.f81678h;
                    prepareController.unlock(prepareController);
                    this.f81678h.moveToNext();
                } else {
                    try {
                        if (MiniAppLaunch.f31784a.s()) {
                            m.f66835a.e(this.f81676f.p(), this.f81673c, this.f81672b.f81669k.e(), false, true);
                        }
                    } catch (Throwable th3) {
                        TmcLogger.h("Tmc", th3);
                    }
                    this.f81679i.g(this.f81673c, true);
                }
            } catch (Throwable th4) {
                TmcLogger.h("Tmc", th4);
                if (this.f81671a) {
                    this.f81678h.moveToError(new PrepareException("download error"));
                }
            }
        }

        @Override // wc.f
        public void f(String str, int i11, String str2) {
            if (this.f81671a) {
                TmcLogger.c(this.f81672b.f31599a, "Step_Download_下载资源包" + i11);
            }
        }

        @Override // wc.f
        public void g(String str, String str2) {
            try {
                PointAnalyseType pointAnalyseTypePutData = PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.putData("mpu_download_type", this.f81671a ? "sync" : "async").putData("mpu_appId", this.f81673c.getAppId()).putData("mpu_old_v", this.f81674d).putData("mpu_new_v", this.f81675e).putData("mpu_result", "IOException").putData("mpu_error_code", "D006").putData("mpu_error_msg", "Canceled").putData("mpu_chain_uniqueId", this.f81676f.q().getString("uniqueChainID", "-1"));
                Intrinsics.f(pointAnalyseTypePutData, "POINT_PACKAGE_DOWNLOAD_U…                        )");
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f81676f.c(), this.f81672b.f81669k.a(pointAnalyseTypePutData), "");
                try {
                    this.f81672b.f31601c.removeDownloadAppMap(this.f81677g);
                } catch (Throwable th2) {
                    TmcLogger.h("Tmc", th2);
                }
            } catch (Throwable th3) {
                TmcLogger.h("Tmc", th3);
            }
        }
    }

    public f(String str, Integer num) {
        this.f81667i = str;
        this.f81668j = num;
        this.f81669k = new i();
        this.f81670l = true;
    }

    public /* synthetic */ f(String str, Integer num, int i11) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 1 : null);
    }

    public static final void g(f this$0, lb.g context, c0 callback) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(context, "$context");
        Intrinsics.g(callback, "$callback");
        this$0.getClass();
        try {
            ((IClientStarter) tc.a.a(IClientStarter.class)).createSubpackagePrepareController(context, callback, 2, this$0.f81669k.f81689c).start();
        } catch (Throwable th2) {
            TmcLogger.h(this$0.f31599a, th2);
        }
    }

    @Override // a0.b
    public void d(PrepareController controller, final lb.g context, final c0 callback) {
        lb.g gVar;
        String subPackageUrlMD5;
        AppModel subpackageAppModelFromUsed;
        Intrinsics.g(controller, "controller");
        Intrinsics.g(context, "context");
        Intrinsics.g(callback, "callback");
        try {
            AppModel appModelE = context.e();
            this.f81669k.d(appModelE, this.f81667i, context, this.f81668j);
            String strB = this.f81669k.b(appModelE);
            if (appModelE != null && strB != null && strB.length() != 0) {
                i iVar = this.f81669k;
                if (!iVar.f81688b && iVar.f81687a != null) {
                    com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: z.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g(this.f81664a, context, callback);
                        }
                    });
                }
                if (context.i()) {
                    this.f81670l = true;
                    this.f31603e.deleteAllFileForVersion(appModelE, strB);
                    this.f31603e.createBaseDirectory(appModelE);
                    k0 k0Var = k0.f31068a;
                    k0Var.c(context.p(), appModelE.getAppId(), strB, false);
                    k0Var.d(context.p(), appModelE.getAppId(), strB, false);
                    k0Var.b(context.p(), appModelE.getAppId(), strB, false);
                    controller.lock(controller);
                    e(controller, context, callback, appModelE, strB, this.f81670l);
                    if (context.r()) {
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 2);
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(context.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle);
                    return;
                }
                boolean zIsDownloaded = this.f31601c.isDownloaded(context.p(), appModelE.getAppId(), strB);
                AppModel appModelFromPre = this.f31600b.getAppModelFromPre(context.p(), context.c());
                String mainPackageUrl = appModelFromPre != null ? appModelFromPre.getMainPackageUrl() : null;
                if (mainPackageUrl == null || mainPackageUrl.length() == 0) {
                    TmcLogger.c("Subpackage::", "subpackageDownload Step 检查是 preAppinfo 否为全量包：true（appInfo主包地址为空），appVersion：" + appModelFromPre.getDeployVersion());
                    appModelFromPre = appModelE;
                }
                AppModel usedModel = this.f31600b.getSubpackageAppModelFromUsed(context.p(), context.c());
                if (!zIsDownloaded) {
                    Integer num = this.f81668j;
                    if (num != null && num.intValue() == 1) {
                        if (appModelE.getFromCacheType() == 3 || appModelE.getFromCacheType() == 4) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("删除子包");
                            sb2.append(strB);
                            sb2.append(",currentAppVersion:");
                            sb2.append(appModelE.getDeployVersion());
                            sb2.append("，preAppVersion：");
                            sb2.append(appModelFromPre != null ? appModelFromPre.getDeployVersion() : null);
                            sb2.append(",usedAppVersion:");
                            sb2.append(usedModel != null ? usedModel.getDeployVersion() : null);
                            TmcLogger.c("Subpackage::", sb2.toString());
                            this.f31603e.deleteAllFileForVersion(appModelE, strB);
                            this.f31603e.createBaseDirectory(appModelE);
                            boolean nativeCache = appModelE.getFromCacheType() == 3 ? this.f31601c.getNativeCache(context.p(), appModelE) : this.f31601c.getOfflineCache(context.p(), appModelE);
                            TmcLogger.c(this.f31599a, "Step_FW_Download_资源包已下载，跳转到解压步骤");
                            this.f81670l = !nativeCache;
                        }
                    }
                    controller.lock(controller);
                    Intrinsics.f(usedModel, "usedModel");
                    e(controller, context, callback, usedModel, strB, this.f81670l);
                    return;
                }
                TmcLogger.c(this.f31599a, "Step_FW_Download_资源包已下载，跳转到解压步骤");
                this.f81670l = false;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("appModelFromPre:");
                sb3.append(appModelFromPre != null ? appModelFromPre.getDeployVersion() : null);
                TmcLogger.c("Subpackage::", sb3.toString());
                if (appModelFromPre != null) {
                    TmcResourceManager tmcResourceManager = this.f31601c;
                    Context contextP = context.p();
                    String appId = appModelFromPre.getAppId();
                    i iVar2 = this.f81669k;
                    if (iVar2.f81688b) {
                        List<SubPackageInfo> subPackagePages = appModelFromPre.getSubPackagePages();
                        if (subPackagePages == null) {
                            subPackageUrlMD5 = null;
                            break;
                        }
                        Iterator<SubPackageInfo> it = subPackagePages.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                subPackageUrlMD5 = null;
                                break;
                            }
                            SubPackageInfo next = it.next();
                            String root = next.getRoot();
                            if (root != null && root.length() != 0) {
                                SubPackageInfo subPackageInfo = iVar2.f81687a;
                                if (TextUtils.equals(subPackageInfo != null ? subPackageInfo.getRoot() : null, next.getRoot())) {
                                    subPackageUrlMD5 = next.getSubPackageUrlMD5();
                                    break;
                                }
                            } else {
                                iVar2 = iVar2;
                            }
                            it = it;
                            iVar2 = iVar2;
                        }
                    } else {
                        subPackageUrlMD5 = appModelFromPre.getMainPackageUrlEncryption();
                    }
                    boolean zIsDownloaded2 = tmcResourceManager.isDownloaded(contextP, appId, subPackageUrlMD5);
                    TmcLogger.c("Subpackage::", "appModelFromPre preDownloaded:" + zIsDownloaded2);
                    if (zIsDownloaded2) {
                        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
                        String strO = miniAppLaunch.O(this.f31600b.getSubpackageAppModelFromUsed(context.p(), context.c()));
                        String strO2 = miniAppLaunch.O(appModelFromPre);
                        if (strO != null && strO.length() != 0 && strO2 != null && strO2.length() != 0 && miniAppLaunch.D(strO2, strO)) {
                            PointAnalyseType pointAnalyseTypePutData = PointAnalyseType.POINT_PACKAGE_UPDATE_START.putData("mpu_appId", appModelFromPre.getAppId()).putData("mpu_old_v", strO).putData("mpu_new_v", strO2).putData("mpu_chain_uniqueId", context.q().getString("uniqueChainID", "-1"));
                            Intrinsics.f(pointAnalyseTypePutData, "POINT_PACKAGE_UPDATE_STA…                        )");
                            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(context.c(), this.f81669k.a(pointAnalyseTypePutData), "");
                        }
                        TmcLogger.c(this.f31599a, "Download_step_当前版本已有缓存" + miniAppLaunch.O(appModelFromPre));
                        TmcLogger.c("Subpackage::", "appModelFromPre set:" + appModelFromPre.getDeployVersion());
                        context.u(appModelFromPre);
                        f(context, controller);
                        return;
                    }
                    gVar = context;
                    TmcLogger.c(this.f31599a, "Step_Download_删除当前所有缓存");
                    if (this.f81669k.f81688b) {
                        List<SubPackageInfo> subPackagePages2 = appModelFromPre.getSubPackagePages();
                        if (subPackagePages2 != null) {
                            for (SubPackageInfo subPackageInfo2 : subPackagePages2) {
                                if (TextUtils.equals(this.f81667i, subPackageInfo2.getRoot())) {
                                    this.f31603e.deleteAllFileForVersion(appModelFromPre, subPackageInfo2.getSubPackageUrlMD5());
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("删除子包");
                                    sb4.append(strB);
                                    sb4.append(",currentAppVersion:");
                                    sb4.append(subPackageInfo2.getSubPackageUrlMD5());
                                    sb4.append("，preAppVersion：");
                                    sb4.append(appModelFromPre.getDeployVersion());
                                    sb4.append(",usedAppVersion:");
                                    sb4.append(usedModel != null ? usedModel.getDeployVersion() : null);
                                    TmcLogger.c("Subpackage::", sb4.toString());
                                }
                            }
                        }
                    } else {
                        this.f31603e.deleteAllFileForVersion(appModelFromPre, appModelFromPre.getMainPackageUrlEncryption());
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("删除主包");
                        sb5.append(appModelFromPre.getMainPackageUrlEncryption());
                        sb5.append(",currentAppVersion:");
                        sb5.append(appModelE.getDeployVersion());
                        sb5.append("，preAppVersion：");
                        sb5.append(appModelFromPre.getDeployVersion());
                        sb5.append(",usedAppVersion:");
                        sb5.append(usedModel != null ? usedModel.getDeployVersion() : null);
                        TmcLogger.c("Subpackage::", sb5.toString());
                    }
                    this.f31603e.createBaseDirectory(appModelFromPre);
                    MiniAppLaunch miniAppLaunch2 = MiniAppLaunch.f31784a;
                    if (miniAppLaunch2.t(appModelFromPre, 2) && (subpackageAppModelFromUsed = this.f31600b.getSubpackageAppModelFromUsed(context.p(), context.c())) != null) {
                        String strO3 = miniAppLaunch2.O(subpackageAppModelFromUsed);
                        String lowestOpenedVersion = appModelFromPre.getLowestOpenedVersion();
                        if (lowestOpenedVersion == null || lowestOpenedVersion.length() == 0 || strO3 == null || strO3.length() == 0 || !miniAppLaunch2.D(lowestOpenedVersion, strO3)) {
                            this.f81670l = true;
                            TmcLogger.c(this.f31599a, "Download_step_当前版本缓存不符合可打开版本号，强制更新最低可打开版本:" + lowestOpenedVersion + "参与比对的版本号:" + strO3);
                        } else {
                            TmcLogger.c(this.f31599a, "Download_step_当前版本缓存符合可打开版本号" + miniAppLaunch2.O(subpackageAppModelFromUsed) + "最低可打开版本号:" + lowestOpenedVersion + "参与比对的版本号:" + strO3);
                            this.f81670l = false;
                            gVar.u(subpackageAppModelFromUsed);
                        }
                    }
                } else {
                    gVar = context;
                    if (!this.f81670l) {
                        f(gVar, controller);
                        return;
                    }
                }
                if (this.f81670l) {
                    controller.lock(controller);
                }
                TmcLogger.c(this.f31599a, "Step_Download_开始下载资源包");
                if (appModelFromPre != null) {
                    int i11 = this.f81670l ? 2 : 1;
                    if (!context.r()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, i11);
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(context.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle2);
                    }
                    e(controller, context, callback, appModelFromPre, strB, this.f81670l);
                } else if (this.f81670l) {
                    try {
                        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(context.p(), context.c(), context.c() + "_pre");
                        this.f31600b.refreshUpdateTime(context.p(), context.c(), 0L);
                    } catch (Throwable th2) {
                        TmcLogger.h(this.f31599a, th2);
                    }
                    controller.moveToError(new PrepareException("appModelFromPre is not exist"));
                    return;
                }
                if (this.f81670l) {
                    return;
                }
                f(gVar, controller);
            }
        } catch (Throwable th3) {
            TmcLogger.h(this.f31599a, th3);
            controller.moveToError(new PrepareException("download error"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:64:0x016d  */
    /* JADX WARN: Code duplicated, block: B:66:0x0173  */
    /* JADX WARN: Code duplicated, block: B:69:0x0192  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b0  */
    public final void e(PrepareController prepareController, lb.g gVar, c0 c0Var, AppModel appModel, String str, boolean z11) {
        String mainPackageUrl;
        String str2;
        i iVar;
        String mainPackageZipPath;
        String str3;
        SubPackageInfo subPackageInfo;
        KVStorageProxy kVStorageProxy;
        SubPackageInfo subPackageInfoE;
        String subPackageUrlMD5;
        String str4;
        if (!gVar.r()) {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            com.cloud.tmc.miniapp.prepare.steps.b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            bundle.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, z11 ? 2 : 1);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        }
        i iVar2 = this.f81669k;
        iVar2.getClass();
        String mainPackageUrl2 = appModel != null ? appModel.getMainPackageUrl() : null;
        if (mainPackageUrl2 == null || mainPackageUrl2.length() == 0) {
            SubPackageInfo subPackageInfo2 = iVar2.f81687a;
            String subPackageUrl = subPackageInfo2 != null ? subPackageInfo2.getSubPackageUrl() : null;
            if (subPackageUrl == null || subPackageUrl.length() == 0) {
                if (!z11) {
                    c0Var.g(appModel, false);
                }
                com.cloud.tmc.miniapp.prepare.steps.i.a(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY, "packageUrl is null or empty", prepareController);
                return;
            }
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        String strO = miniAppLaunch.O(this.f31600b.getSubpackageAppModelFromUsed(gVar.p(), gVar.c()));
        String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), gVar.c()));
        if (z11 && !TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && strO2 != null && strO != null && miniAppLaunch.D(strO2, strO)) {
            PointAnalyseType pointAnalyseTypeA = com.cloud.tmc.miniapp.prepare.steps.f.a(gVar, "uniqueChainID", "-1", com.cloud.tmc.miniapp.prepare.steps.e.a(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_START, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2), "mpu_chain_uniqueId");
            Intrinsics.f(pointAnalyseTypeA, "POINT_PACKAGE_UPDATE_STA…                        )");
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), this.f81669k.a(pointAnalyseTypeA), "");
        }
        PointAnalyseType pointAnalyseTypeA2 = com.cloud.tmc.miniapp.prepare.steps.f.a(gVar, "uniqueChainID", "-1", com.cloud.tmc.miniapp.prepare.steps.e.a(appModel, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_START.putData("mpu_download_type", z11 ? "sync" : "async"), "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2), "mpu_chain_uniqueId");
        Intrinsics.f(pointAnalyseTypeA2, "POINT_PACKAGE_DOWNLOAD_S…N_ID, \"-1\")\n            )");
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), this.f81669k.a(pointAnalyseTypeA2), "");
        int i11 = z11 ? 2 : 1;
        i iVar3 = this.f81669k;
        if (iVar3.f81688b) {
            SubPackageInfo subPackageInfo3 = iVar3.f81687a;
            if (subPackageInfo3 != null) {
                mainPackageUrl = subPackageInfo3.getSubPackageUrl();
            } else {
                str2 = null;
            }
            if (str2 != null && str2.length() != 0 && this.f81669k.f81688b && this.f31601c.isDownloaded(gVar.p(), appModel.getAppId(), str2) && !k0.f31068a.q(gVar.p(), appModel.getAppId(), str2)) {
                kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
                StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                Object[] objArr = new Object[1];
                subPackageInfoE = this.f81669k.e();
                if (subPackageInfoE != null) {
                    subPackageUrlMD5 = subPackageInfoE.getSubPackageUrlMD5();
                } else {
                    subPackageUrlMD5 = null;
                }
                objArr[0] = subPackageUrlMD5;
                str4 = String.format("subpackage_decompression_count_url_%s", Arrays.copyOf(objArr, 1));
                Intrinsics.f(str4, "format(format, *args)");
                if (kVStorageProxy.getInt(gVar.p(), "miniapp_business_subpackage_record", str4) <= 1) {
                    prepareController.moveToNext();
                    return;
                }
            }
            TmcResourceManager tmcResourceManager = this.f31601c;
            String appId = appModel.getAppId();
            iVar = this.f81669k;
            if (iVar.f81688b) {
                subPackageInfo = iVar.f81687a;
                if (subPackageInfo != null) {
                    mainPackageZipPath = subPackageInfo.getSubZipPath();
                } else {
                    str3 = null;
                }
                tmcResourceManager.downloadApp(appId, str2, str, str3, i11, true, new a(z11, this, appModel, strO, strO2, gVar, str, prepareController, c0Var, str2));
            }
            mainPackageZipPath = appModel.getMainPackageZipPath();
            str3 = mainPackageZipPath;
            tmcResourceManager.downloadApp(appId, str2, str, str3, i11, true, new a(z11, this, appModel, strO, strO2, gVar, str, prepareController, c0Var, str2));
        }
        mainPackageUrl = appModel.getMainPackageUrl();
        str2 = mainPackageUrl;
        if (str2 != null) {
            kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f68912a;
            Object[] objArr2 = new Object[1];
            subPackageInfoE = this.f81669k.e();
            if (subPackageInfoE != null) {
                subPackageUrlMD5 = subPackageInfoE.getSubPackageUrlMD5();
            } else {
                subPackageUrlMD5 = null;
            }
            objArr2[0] = subPackageUrlMD5;
            str4 = String.format("subpackage_decompression_count_url_%s", Arrays.copyOf(objArr2, 1));
            Intrinsics.f(str4, "format(format, *args)");
            if (kVStorageProxy.getInt(gVar.p(), "miniapp_business_subpackage_record", str4) <= 1) {
                prepareController.moveToNext();
                return;
            }
        }
        TmcResourceManager tmcResourceManager2 = this.f31601c;
        String appId2 = appModel.getAppId();
        iVar = this.f81669k;
        if (iVar.f81688b) {
            subPackageInfo = iVar.f81687a;
            if (subPackageInfo != null) {
                mainPackageZipPath = subPackageInfo.getSubZipPath();
            } else {
                str3 = null;
            }
            tmcResourceManager2.downloadApp(appId2, str2, str, str3, i11, true, new a(z11, this, appModel, strO, strO2, gVar, str, prepareController, c0Var, str2));
        }
        mainPackageZipPath = appModel.getMainPackageZipPath();
        str3 = mainPackageZipPath;
        tmcResourceManager2.downloadApp(appId2, str2, str, str3, i11, true, new a(z11, this, appModel, strO, strO2, gVar, str, prepareController, c0Var, str2));
    }

    public final void f(lb.g gVar, PrepareController prepareController) {
        if (!gVar.r()) {
            Bundle bundle = new Bundle();
            bundle.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 1);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle);
        }
        prepareController.moveToNext();
    }
}
