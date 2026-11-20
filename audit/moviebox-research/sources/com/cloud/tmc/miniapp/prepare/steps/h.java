package com.cloud.tmc.miniapp.prepare.steps;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.mbridge.msdk.MBridgeConstans;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f31615h = true;

    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(final PrepareController prepareController, final lb.g gVar, final c0 c0Var) throws PrepareException {
        boolean offlineCache;
        if (!gVar.r()) {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31205d, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31207e, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31236x, new Bundle());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31237y, new Bundle());
            new xa.i(new Bundle()).f(gVar.b());
            new db.h(new Bundle()).f(gVar.b());
            if (gVar.a() != null) {
                OffScreenWebviewPool.f30871a.l(gVar.a(), this, gVar);
            }
        }
        if (com.cloud.tmc.integration.utils.h.f31061a.l(gVar.e())) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31200a0, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle2);
            }
            prepareController.moveToNext();
            return;
        }
        super.a(prepareController, gVar, c0Var);
        TmcLogger.c(this.f31599a, "Step_FW_DOWNLOAD");
        if (AppDynamicBuildConfig.k() && this.f31600b.getAppModelFromDev(gVar.p(), "100000") != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31200a0, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle3);
            }
            prepareController.moveToNext();
            return;
        }
        AppModel appModelL = gVar.l();
        if (this.f31601c.isDownloaded(gVar.p(), appModelL)) {
            TmcLogger.c(this.f31599a, "Step_FW_Download_资源包已下载，跳转到解压步骤");
            this.f31615h = false;
        } else if (appModelL.getFromCacheType() == 3 || appModelL.getFromCacheType() == 4) {
            TmcLogger.c(this.f31599a, "use native or offline resource");
            this.f31603e.deleteAllFileForVersion(appModelL);
            this.f31603e.createBaseDirectory(appModelL);
            if (appModelL.getFromCacheType() == 3) {
                TmcLogger.c(this.f31599a, "use native resource");
                offlineCache = this.f31601c.getNativeCache(gVar.p(), appModelL);
            } else {
                TmcLogger.c(this.f31599a, "use offline resource");
                offlineCache = this.f31601c.getOfflineCache(gVar.p(), appModelL);
            }
            TmcLogger.c(this.f31599a, "Step_FW_DOWNLOAD：本地是否有内置包：" + offlineCache);
            this.f31615h = offlineCache ^ true;
        }
        final AppModel appModelFromPre = this.f31600b.getAppModelFromPre(gVar.p(), appModelL.getAppId());
        if (appModelFromPre != null) {
            if (this.f31601c.isDownloaded(gVar.p(), appModelFromPre)) {
                MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
                String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), "100000"));
                String strO2 = miniAppLaunch.O(appModelFromPre);
                if (!TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && miniAppLaunch.u(strO, strO2)) {
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModelFromPre, PointAnalyseType.POINT_PACKAGE_UPDATE_START, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2), "mpu_chain_uniqueId"), "");
                }
                c0Var.i(LoadStepAction.STEP_FINISH_DOWNLOAD);
                gVar.A(appModelFromPre);
                Bundle bundle4 = new Bundle();
                bundle4.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31200a0, 1);
                if (!gVar.r()) {
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle4);
                }
                prepareController.moveToNext();
                return;
            }
            if (appModelFromPre.isForceUpdate()) {
                this.f31615h = true;
            }
            TmcLogger.c(this.f31599a, "Step_FW_Download_删除当前所有缓存");
            this.f31603e.deleteAllFileForVersion(appModelFromPre);
            this.f31603e.createBaseDirectory(appModelFromPre);
        } else if (!this.f31615h) {
            TmcLogger.c(this.f31599a, "not need download fw resource pkg");
            c0Var.i(LoadStepAction.STEP_FINISH_DOWNLOAD);
            Bundle bundle5 = new Bundle();
            bundle5.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31200a0, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle5);
            }
            prepareController.moveToNext();
            return;
        }
        if (this.f31615h) {
            prepareController.lock(prepareController);
        }
        if (appModelFromPre != null) {
            MiniAppLaunch miniAppLaunch2 = MiniAppLaunch.f31784a;
            if (miniAppLaunch2.z(appModelFromPre.getPackageSize()) && NetworkUtils.r()) {
                Bundle bundle6 = new Bundle();
                bundle6.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31200a0, 2);
                if (!gVar.r()) {
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle6);
                }
                TmcLogger.c(this.f31599a, "show downlaod tips");
                this.f31615h = true;
                prepareController.lock(prepareController);
                miniAppLaunch2.k0(gVar.p(), appModelFromPre.getPackageSize(), new w.a() { // from class: com.cloud.tmc.miniapp.prepare.steps.g
                    @Override // w.a
                    public final void a(OooO0o0.o000oOoO o000oooo) {
                        this.f31610a.f(appModelFromPre, prepareController, gVar, c0Var, o000oooo);
                    }
                });
                return;
            }
            int i11 = this.f31615h ? 2 : 1;
            Bundle bundle7 = new Bundle();
            bundle7.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31200a0, i11);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle7);
            }
            TmcLogger.c(this.f31599a, "Step_FW_Download_开始下载资源包");
            e(appModelFromPre, prepareController, gVar, null);
        } else if (this.f31615h) {
            try {
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(gVar.p(), "100000", "100000_pre");
                this.f31600b.refreshUpdateTime(gVar.p(), "100000", 0L);
            } catch (Throwable th2) {
                TmcLogger.h(this.f31599a, th2);
            }
            prepareController.moveToError(new PrepareException("fwAppModelFromPre is not exist"));
            return;
        }
        if (this.f31615h) {
            return;
        }
        TmcLogger.c(this.f31599a, "Step_FW_Download异步下载，跳转下一步");
        Bundle bundle8 = new Bundle();
        bundle8.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31200a0, 1);
        if (!gVar.r()) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle8);
        }
        c0Var.i(LoadStepAction.STEP_FINISH_DOWNLOAD);
        prepareController.unlock(prepareController);
        prepareController.moveToNext();
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.FW_DOWNLOAD;
    }

    public final void e(AppModel appModel, PrepareController prepareController, lb.g gVar, @Nullable OooO0o0.o000oOoO o000oooo) {
        if (appModel == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
        bundle.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31200a0, this.f31615h ? 2 : 1);
        if (!gVar.r()) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), "100000"));
        String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), "100000"));
        if (this.f31615h && !TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && miniAppLaunch.u(strO, strO2)) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_START, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2), "mpu_chain_uniqueId"), "");
        }
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_DOWNLOAD_START.putData("mpu_download_type", this.f31615h ? "sync" : "async").putData("mpu_appId", "100000").putData("mpu_old_v", strO).putData("mpu_new_v", strO2), "mpu_chain_uniqueId"), "");
        int i11 = this.f31615h ? 2 : 1;
        String str = this.f31599a;
        StringBuilder sbA = hd.j.a("downloadpkg enableLock = ");
        sbA.append(this.f31615h);
        TmcLogger.c(str, sbA.toString());
        this.f31601c.downloadApp(appModel, i11, true, new OooOO0O(this, o000oooo, gVar, strO, strO2, appModel, prepareController));
    }

    public final /* synthetic */ void f(AppModel appModel, PrepareController prepareController, lb.g gVar, c0 c0Var, OooO0o0.o000oOoO o000oooo) {
        e(appModel, prepareController, gVar, o000oooo);
    }
}
