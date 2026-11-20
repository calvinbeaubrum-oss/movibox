package u;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prepare.steps.i;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.mbridge.msdk.MBridgeConstans;
import hd.j;
import hd.k;
import i0.q;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import lb.g;
import wc.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends a0.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f78086i = true;

    /* JADX INFO: renamed from: u.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0858a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f78087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f78088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppModel f78089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f78090d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f78091e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ PrepareController f78092f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ c0 f78093g;

        public C0858a(boolean z11, g gVar, AppModel appModel, String str, String str2, PrepareController prepareController, c0 c0Var) {
            this.f78087a = z11;
            this.f78088b = gVar;
            this.f78089c = appModel;
            this.f78090d = str;
            this.f78091e = str2;
            this.f78092f = prepareController;
            this.f78093g = c0Var;
        }

        @Override // wc.f
        public /* synthetic */ void a(String str, int i11, String str2, long j11, long j12) {
            wc.e.a(this, str, i11, str2, j11, j12);
        }

        @Override // wc.f
        public void b(String str, String str2, String str3, IOException iOException, String str4) {
            h.f31061a.n(this.f78088b.p(), this.f78089c, false);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f78088b.c(), com.cloud.tmc.miniapp.prepare.steps.f.a(this.f78088b, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_DOWNLOAD_FAILED.putData("mpu_download_type", this.f78087a ? "sync" : "async").putData("mpu_appId", this.f78089c.getAppId()).putData("mpu_old_v", this.f78090d).putData("mpu_new_v", this.f78091e).putData("mpu_result", iOException.getClass().getSimpleName()).putData("mpu_error_code", str2).putData("mpu_error_msg", iOException.getMessage()), "mpu_chain_uniqueId"), "");
            try {
                a.this.f31601c.removeDownloadAppMap(this.f78089c.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.h("Tmc", th2);
            }
            if (!this.f78087a) {
                this.f78093g.g(this.f78089c, false);
                return;
            }
            if (!TextUtils.isEmpty(this.f78090d) && !TextUtils.isEmpty(this.f78091e) && MiniAppLaunch.f31784a.D(this.f78091e, this.f78090d)) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f78088b.c(), com.cloud.tmc.miniapp.prepare.steps.f.a(this.f78088b, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL.putData("mpu_appId", this.f78089c.getAppId()).putData("mpu_old_v", this.f78090d).putData("mpu_new_v", this.f78091e).putData("mpu_result", "DOWNLOAD_FAIL"), "mpu_chain_uniqueId"), "");
            }
            k.a("Step_Download_资源包下载失败，", str3, a.this.f31599a);
            this.f78092f.moveToError(new PrepareException("4", "download error:" + str3 + "   url:" + this.f78089c.getPackageUrl()));
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
        public void c(@Nullable String str, String str2) {
            TmcLogger.c(a.this.f31599a, "Step_Download_资源包下载完成，进行解压");
            h.f31061a.n(this.f78088b.p(), this.f78089c, true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SinglePkgDownloadStep Finish:changeZipDownloadStatus true:downloadUrl:");
            sb2.append(str);
            sb2.append(";appInfo:appId:");
            StringBuilder sbA = x.a.a(this.f78089c, sb2, ";deployVersion:");
            sbA.append(this.f78089c.getDeployVersion());
            sbA.append(";mainPkgUrl:");
            sbA.append(this.f78089c.getMainPackageUrl());
            sbA.append(";fullPkgUrl:");
            sbA.append(this.f78089c.getPackageUrl());
            TmcLogger.c("Subpackage::", sbA.toString());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f78088b.c(), com.cloud.tmc.miniapp.prepare.steps.f.a(this.f78088b, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.putData("mpu_download_type", this.f78087a ? "sync" : "async").putData("mpu_appId", this.f78089c.getAppId()).putData("mpu_old_v", this.f78090d).putData("mpu_new_v", this.f78091e), "mpu_chain_uniqueId"), "");
            try {
                a.this.f31601c.removeDownloadAppMap(this.f78089c.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.h("Tmc", th2);
            }
            if (this.f78087a) {
                PrepareController prepareController = this.f78092f;
                prepareController.unlock(prepareController);
                this.f78092f.moveToNext();
                return;
            }
            try {
                if (MiniAppLaunch.f31784a.s()) {
                    q qVar = q.f66855a;
                    Context context = this.f78088b.p();
                    AppModel appModel = this.f78089c;
                    Intrinsics.g(context, "context");
                    Intrinsics.g(appModel, "appModel");
                    q.e(qVar, context, appModel, false, false, 12);
                }
            } catch (Throwable th3) {
                TmcLogger.h("Tmc", th3);
            }
            this.f78093g.g(this.f78089c, true);
        }

        @Override // wc.f
        public void f(String str, int i11, String str2) {
            if (this.f78087a) {
                TmcLogger.c(a.this.f31599a, "Step_Download_下载资源包" + i11);
            }
        }

        @Override // wc.f
        public void g(String str, String str2) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f78088b.c(), com.cloud.tmc.miniapp.prepare.steps.f.a(this.f78088b, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.putData("mpu_download_type", this.f78087a ? "sync" : "async").putData("mpu_appId", this.f78089c.getAppId()).putData("mpu_old_v", this.f78090d).putData("mpu_new_v", this.f78091e).putData("mpu_result", "IOException").putData("mpu_error_code", "D006").putData("mpu_error_msg", "Canceled"), "mpu_chain_uniqueId"), "");
            try {
                a.this.f31601c.removeDownloadAppMap(this.f78089c.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.h("Tmc", th2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0103  */
    /* JADX WARN: Code duplicated, block: B:35:0x0120  */
    /* JADX WARN: Code duplicated, block: B:37:0x0123  */
    /* JADX WARN: Code duplicated, block: B:39:0x012f  */
    /* JADX WARN: Code duplicated, block: B:48:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:51:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:57:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:58:0x021f  */
    /* JADX WARN: Code duplicated, block: B:59:0x023e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0242  */
    /* JADX WARN: Code duplicated, block: B:63:0x0259  */
    /* JADX WARN: Code duplicated, block: B:68:0x0270  */
    /* JADX WARN: Code duplicated, block: B:71:0x0283  */
    /* JADX WARN: Code duplicated, block: B:74:0x0288  */
    /* JADX WARN: Code duplicated, block: B:77:0x0299  */
    /* JADX WARN: Code duplicated, block: B:79:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:89:0x0307  */
    /* JADX WARN: Code duplicated, block: B:91:0x0317  */
    /* JADX WARN: Code duplicated, block: B:94:0x02ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x021f, please report this as an issue */
    @Override // a0.b
    public void d(PrepareController prepareController, g gVar, c0 c0Var) {
        boolean offlineCache;
        boolean z11;
        AppModel appModelFromPre;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        MiniAppLaunch miniAppLaunch;
        AppModel appModelFromUsed;
        String strO;
        String lowestOpenedVersion;
        String strO2;
        String strO3;
        Bundle bundle4;
        String strO4;
        AppModel appModelE = gVar.e();
        if (gVar.i()) {
            this.f78086i = true;
            this.f31603e.deleteAllFileForVersion(appModelE);
            this.f31603e.createBaseDirectory(appModelE);
            h hVar = h.f31061a;
            hVar.n(gVar.p(), appModelE, false);
            hVar.o(gVar.p(), appModelE, false);
            hVar.m(gVar.p(), appModelE, false);
            prepareController.lock(prepareController);
            e(prepareController, gVar, c0Var, appModelE, this.f78086i);
            Bundle bundle5 = new Bundle();
            bundle5.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 2);
            if (gVar.r()) {
                return;
            }
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle5);
            return;
        }
        if (!this.f31601c.isDownloaded(gVar.p(), appModelE)) {
            if (appModelE.getFromCacheType() == 3 || appModelE.getFromCacheType() == 4) {
                this.f31603e.deleteAllFileForVersion(appModelE);
                this.f31603e.createBaseDirectory(appModelE);
                if (appModelE.getFromCacheType() == 3) {
                    offlineCache = this.f31601c.getNativeCache(gVar.p(), appModelE);
                    TmcLogger.c(this.f31599a, "use native pkg resource");
                    z11 = false;
                } else {
                    offlineCache = this.f31601c.getOfflineCache(gVar.p(), appModelE);
                    TmcLogger.c(this.f31599a, "use offline pkg resource");
                    z11 = true;
                }
                TmcLogger.c(this.f31599a, "Step_FW_Download_资源包已下载，跳转到解压步骤->" + offlineCache);
                this.f78086i = offlineCache ^ true;
            }
            appModelFromPre = this.f31600b.getAppModelFromPre(gVar.p(), gVar.c());
            if (appModelFromPre != null && !TextUtils.isEmpty(appModelFromPre.getMainPackageUrl())) {
                TmcLogger.c(this.f31599a, "DownloadStep preAppinfo is  subpackage,not use");
                appModelFromPre = appModelE;
            }
            if (z11) {
                MiniAppLaunch miniAppLaunch2 = MiniAppLaunch.f31784a;
                strO4 = miniAppLaunch2.O(appModelFromPre);
                String strO5 = miniAppLaunch2.O(appModelE);
                if (TextUtils.isEmpty(strO4) || TextUtils.isEmpty(strO5) || !miniAppLaunch2.D(strO5, strO4)) {
                    appModelE = appModelFromPre;
                }
            } else {
                appModelE = appModelFromPre;
            }
            if (appModelE != null) {
                if (this.f31601c.isDownloaded(gVar.p(), appModelE)) {
                    MiniAppLaunch miniAppLaunch3 = MiniAppLaunch.f31784a;
                    strO2 = miniAppLaunch3.O(this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c()));
                    strO3 = miniAppLaunch3.O(appModelE);
                    if (!TextUtils.isEmpty(strO2) && !TextUtils.isEmpty(strO3) && miniAppLaunch3.D(strO3, strO2)) {
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), com.cloud.tmc.miniapp.prepare.steps.f.a(gVar, "uniqueChainID", "-1", com.cloud.tmc.miniapp.prepare.steps.e.a(appModelE, PointAnalyseType.POINT_PACKAGE_UPDATE_START, "mpu_appId", "mpu_old_v", strO2).putData("mpu_new_v", strO3), "mpu_chain_uniqueId"), "");
                    }
                    String str = this.f31599a;
                    StringBuilder sbA = j.a("appModelFromPre is not null,Download_step_当前版本已有缓存");
                    sbA.append(miniAppLaunch3.O(appModelE));
                    TmcLogger.c(str, sbA.toString());
                    gVar.u(appModelE);
                    bundle4 = new Bundle();
                    bundle4.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 1);
                    if (!gVar.r()) {
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle4);
                    }
                    prepareController.moveToNext();
                    return;
                }
                TmcLogger.c(this.f31599a, "appModelFromPre is not null,Step_Download_删除当前所有缓存");
                this.f31603e.deleteAllFileForVersion(appModelE);
                this.f31603e.createBaseDirectory(appModelE);
                miniAppLaunch = MiniAppLaunch.f31784a;
                if (miniAppLaunch.t(appModelE, 2) && (appModelFromUsed = this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c())) != null) {
                    strO = miniAppLaunch.O(appModelFromUsed);
                    lowestOpenedVersion = appModelE.getLowestOpenedVersion();
                    if (miniAppLaunch.D(lowestOpenedVersion, strO)) {
                        this.f78086i = true;
                        TmcLogger.c(this.f31599a, "Download_step_当前版本缓存不符合可打开版本号，强制更新最低可打开版本:" + lowestOpenedVersion + "参与比对的版本号:" + strO);
                    } else {
                        String str2 = this.f31599a;
                        StringBuilder sbA2 = j.a("Download_step_当前版本缓存符合可打开版本号");
                        sbA2.append(miniAppLaunch.O(appModelFromUsed));
                        sbA2.append("最低可打开版本号:");
                        sbA2.append(lowestOpenedVersion);
                        sbA2.append("参与比对的版本号:");
                        sbA2.append(strO);
                        TmcLogger.c(str2, sbA2.toString());
                        this.f78086i = false;
                        gVar.u(appModelFromUsed);
                    }
                }
            } else if (!this.f78086i) {
                TmcLogger.c(this.f31599a, "not need download resource pkg");
                bundle = new Bundle();
                bundle.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 1);
                if (!gVar.r()) {
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle);
                }
                prepareController.moveToNext();
                return;
            }
            if (this.f78086i) {
                TmcLogger.c(this.f31599a, "need download resource pkg");
                prepareController.lock(prepareController);
            }
            TmcLogger.c(this.f31599a, "Step_Download_开始下载资源包");
            if (appModelE != null) {
                int i11 = this.f78086i ? 2 : 1;
                bundle3 = new Bundle();
                bundle3.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, i11);
                if (!gVar.r()) {
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle3);
                }
                e(prepareController, gVar, c0Var, appModelE, this.f78086i);
            } else if (this.f78086i) {
                try {
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(gVar.p(), gVar.c(), gVar.c() + "_pre");
                    this.f31600b.refreshUpdateTime(gVar.p(), gVar.c(), 0L);
                } catch (Throwable th2) {
                    TmcLogger.h(this.f31599a, th2);
                }
                prepareController.moveToError(new PrepareException("appModelFromPre is not exist"));
                return;
            }
            if (this.f78086i) {
            }
            bundle2 = new Bundle();
            bundle2.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle2);
            }
            prepareController.moveToNext();
        }
        TmcLogger.c(this.f31599a, "Step_FW_Download_资源包已下载，跳转到解压步骤");
        this.f78086i = false;
        z11 = false;
        appModelFromPre = this.f31600b.getAppModelFromPre(gVar.p(), gVar.c());
        if (appModelFromPre != null) {
            TmcLogger.c(this.f31599a, "DownloadStep preAppinfo is  subpackage,not use");
            appModelFromPre = appModelE;
        }
        if (z11) {
            MiniAppLaunch miniAppLaunch4 = MiniAppLaunch.f31784a;
            strO4 = miniAppLaunch4.O(appModelFromPre);
            String strO6 = miniAppLaunch4.O(appModelE);
            if (TextUtils.isEmpty(strO4)) {
                appModelE = appModelFromPre;
            } else {
                appModelE = appModelFromPre;
            }
        } else {
            appModelE = appModelFromPre;
        }
        if (appModelE != null) {
            if (this.f31601c.isDownloaded(gVar.p(), appModelE)) {
                MiniAppLaunch miniAppLaunch5 = MiniAppLaunch.f31784a;
                strO2 = miniAppLaunch5.O(this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c()));
                strO3 = miniAppLaunch5.O(appModelE);
                if (!TextUtils.isEmpty(strO2)) {
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), com.cloud.tmc.miniapp.prepare.steps.f.a(gVar, "uniqueChainID", "-1", com.cloud.tmc.miniapp.prepare.steps.e.a(appModelE, PointAnalyseType.POINT_PACKAGE_UPDATE_START, "mpu_appId", "mpu_old_v", strO2).putData("mpu_new_v", strO3), "mpu_chain_uniqueId"), "");
                }
                String str3 = this.f31599a;
                StringBuilder sbA3 = j.a("appModelFromPre is not null,Download_step_当前版本已有缓存");
                sbA3.append(miniAppLaunch5.O(appModelE));
                TmcLogger.c(str3, sbA3.toString());
                gVar.u(appModelE);
                bundle4 = new Bundle();
                bundle4.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 1);
                if (!gVar.r()) {
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle4);
                }
                prepareController.moveToNext();
                return;
            }
            TmcLogger.c(this.f31599a, "appModelFromPre is not null,Step_Download_删除当前所有缓存");
            this.f31603e.deleteAllFileForVersion(appModelE);
            this.f31603e.createBaseDirectory(appModelE);
            miniAppLaunch = MiniAppLaunch.f31784a;
            if (miniAppLaunch.t(appModelE, 2)) {
                strO = miniAppLaunch.O(appModelFromUsed);
                lowestOpenedVersion = appModelE.getLowestOpenedVersion();
                if (miniAppLaunch.D(lowestOpenedVersion, strO)) {
                    String str4 = this.f31599a;
                    StringBuilder sbA4 = j.a("Download_step_当前版本缓存符合可打开版本号");
                    sbA4.append(miniAppLaunch.O(appModelFromUsed));
                    sbA4.append("最低可打开版本号:");
                    sbA4.append(lowestOpenedVersion);
                    sbA4.append("参与比对的版本号:");
                    sbA4.append(strO);
                    TmcLogger.c(str4, sbA4.toString());
                    this.f78086i = false;
                    gVar.u(appModelFromUsed);
                } else {
                    this.f78086i = true;
                    TmcLogger.c(this.f31599a, "Download_step_当前版本缓存不符合可打开版本号，强制更新最低可打开版本:" + lowestOpenedVersion + "参与比对的版本号:" + strO);
                }
            }
        } else if (!this.f78086i) {
            TmcLogger.c(this.f31599a, "not need download resource pkg");
            bundle = new Bundle();
            bundle.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle);
            }
            prepareController.moveToNext();
            return;
        }
        if (this.f78086i) {
            TmcLogger.c(this.f31599a, "need download resource pkg");
            prepareController.lock(prepareController);
        }
        TmcLogger.c(this.f31599a, "Step_Download_开始下载资源包");
        if (appModelE != null) {
            if (this.f78086i) {
            }
            bundle3 = new Bundle();
            bundle3.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, i11);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle3);
            }
            e(prepareController, gVar, c0Var, appModelE, this.f78086i);
        } else if (this.f78086i) {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(gVar.p(), gVar.c(), gVar.c() + "_pre");
            this.f31600b.refreshUpdateTime(gVar.p(), gVar.c(), 0L);
            prepareController.moveToError(new PrepareException("appModelFromPre is not exist"));
            return;
        }
        if (this.f78086i) {
            bundle2 = new Bundle();
            bundle2.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle2);
            }
            prepareController.moveToNext();
        }
    }

    public final void e(PrepareController prepareController, g gVar, c0 c0Var, AppModel appModel, boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        com.cloud.tmc.miniapp.prepare.steps.b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
        bundle.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, z11 ? 2 : 1);
        if (!gVar.r()) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        }
        String packageUrl = appModel.getPackageUrl();
        if (packageUrl == null || packageUrl.isEmpty()) {
            if (!z11) {
                c0Var.g(appModel, false);
            }
            i.a(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY, "packageUrl is null or empty", prepareController);
            return;
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c()));
        String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), gVar.c()));
        if (z11 && !TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && miniAppLaunch.D(strO2, strO)) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), com.cloud.tmc.miniapp.prepare.steps.f.a(gVar, "uniqueChainID", "-1", com.cloud.tmc.miniapp.prepare.steps.e.a(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_START, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2), "mpu_chain_uniqueId"), "");
        }
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), com.cloud.tmc.miniapp.prepare.steps.f.a(gVar, "uniqueChainID", "-1", com.cloud.tmc.miniapp.prepare.steps.e.a(appModel, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_START.putData("mpu_download_type", z11 ? "sync" : "async"), "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2), "mpu_chain_uniqueId"), "");
        int i11 = z11 ? 2 : 1;
        StringBuilder sbA = j.a("SinglePkgDownloadStep startDownload:downloadUrl:");
        sbA.append(appModel.getPackageUrl());
        sbA.append(";appInfo:appId:");
        StringBuilder sbA2 = x.a.a(appModel, sbA, ";deployVersion:");
        sbA2.append(appModel.getDeployVersion());
        TmcLogger.c("Subpackage::", sbA2.toString());
        this.f31601c.downloadApp(appModel, i11, true, new C0858a(z11, gVar, appModel, strO, strO2, prepareController, c0Var));
    }
}
