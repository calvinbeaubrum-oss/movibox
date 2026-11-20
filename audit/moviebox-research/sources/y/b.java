package y;

import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.StepType;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prepare.steps.i;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import hd.j;
import lb.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.cloud.tmc.miniapp.prepare.steps.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f81016h = true;

    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, g gVar, c0 c0Var) throws PrepareException {
        String appId;
        boolean offlineCache;
        String templateMiniappId;
        String lowestSupportTemplateVersion;
        String appId2;
        super.a(prepareController, gVar, c0Var);
        AppModel appModelE = gVar.e();
        if (!AppUtils.f31011a.g(appModelE != null ? appModelE.getMiniappSubtype() : null)) {
            if (prepareController != null) {
                prepareController.moveToNext();
                return;
            }
            return;
        }
        AppModel appModelH = gVar.h();
        if (appModelH == null) {
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("commonResModel is null"));
                return;
            }
            return;
        }
        AppModel appModelH2 = gVar.h();
        if (appModelH2 == null || (appId = appModelH2.getAppId()) == null) {
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("commonResId is null or empty"));
                return;
            }
            return;
        }
        if (appModelE != null && (appId2 = appModelE.getAppId()) != null) {
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            miniAppLaunch.C(appId2, "u_e");
            miniAppLaunch.C(appId2, "d_s");
        }
        if (this.f31601c.isDownloaded(gVar.p(), appModelH)) {
            TmcLogger.c(this.f31599a, "CommonResDownloadStep_公共资源包已下载，跳转到解压步骤");
            this.f81016h = false;
        } else if (appModelH.getFromCacheType() == 3 || appModelH.getFromCacheType() == 4) {
            this.f31603e.deleteAllFileForVersion(appModelH);
            this.f31603e.createBaseDirectory(appModelH);
            if (appModelH.getFromCacheType() == 3) {
                offlineCache = this.f31601c.getNativeCache(gVar.p(), appModelH);
                TmcLogger.c(this.f31599a, "use native pkg resource");
            } else {
                offlineCache = this.f31601c.getOfflineCache(gVar.p(), appModelH);
                TmcLogger.c(this.f31599a, "use offline pkg resource");
            }
            TmcLogger.c(this.f31599a, "Step_FW_Download_资源包已下载，跳转到解压步骤->" + offlineCache);
            this.f81016h = offlineCache ^ true;
        }
        AppModel appModelFromPre = this.f31600b.getAppModelFromPre(gVar.p(), appId);
        if (appModelFromPre != null) {
            if (this.f31601c.isDownloaded(gVar.p(), appModelFromPre)) {
                gVar.y(appModelFromPre);
                if (prepareController != null) {
                    prepareController.moveToNext();
                    return;
                }
                return;
            }
            this.f31603e.deleteAllFileForVersion(appModelFromPre);
            this.f31603e.createBaseDirectory(appModelFromPre);
        } else if (!this.f81016h) {
            if (prepareController != null) {
                prepareController.moveToNext();
                return;
            }
            return;
        }
        if (!this.f81016h) {
            AppModel appModelE2 = gVar.e();
            if (appModelE2 == null || (lowestSupportTemplateVersion = appModelE2.getLowestSupportTemplateVersion()) == null) {
                lowestSupportTemplateVersion = "";
            }
            MiniAppLaunch miniAppLaunch2 = MiniAppLaunch.f31784a;
            String deployVersion = appModelH.getDeployVersion();
            if (miniAppLaunch2.D(lowestSupportTemplateVersion, deployVersion != null ? deployVersion : "") && NetworkUtils.r() && appModelFromPre != null) {
                gVar.y(appModelFromPre);
                this.f81016h = true;
            }
        }
        if (this.f81016h) {
            TmcLogger.c(this.f31599a, "need download resource pkg");
            if (prepareController != null) {
                prepareController.lock(prepareController);
            }
        }
        if (appModelFromPre != null) {
            if (c0Var != null) {
                boolean z11 = this.f81016h;
                String packageUrl = appModelFromPre.getPackageUrl();
                if (packageUrl == null || packageUrl.length() == 0) {
                    if (!z11) {
                        c0Var.g(appModelFromPre, false);
                    }
                    if (prepareController != null) {
                        i.a(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY, "packageUrl is null or empty", prepareController);
                    }
                } else {
                    int i11 = z11 ? 2 : 1;
                    StringBuilder sbA = j.a("SinglePkgDownloadStep startDownload:downloadUrl:");
                    sbA.append(appModelFromPre.getPackageUrl());
                    sbA.append(";appInfo:appId:");
                    StringBuilder sbA2 = x.a.a(appModelFromPre, sbA, ";deployVersion:");
                    sbA2.append(appModelFromPre.getDeployVersion());
                    TmcLogger.c("Subpackage::", sbA2.toString());
                    this.f31601c.downloadApp(appModelFromPre, i11, true, new a(z11, this, appModelFromPre, gVar, prepareController, c0Var));
                }
            }
        } else if (this.f81016h) {
            try {
                AppModel appModelH3 = gVar.h();
                if (appModelH3 != null && (templateMiniappId = appModelH3.getTemplateMiniappId()) != null) {
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(gVar.p(), templateMiniappId, templateMiniappId + "_pre");
                    this.f31600b.refreshUpdateTime(gVar.p(), gVar.c(), 0L);
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.f31599a, th2);
            }
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("preCommonresModel is not exist"));
                return;
            }
            return;
        }
        if (this.f81016h || prepareController == null) {
            return;
        }
        prepareController.moveToNext();
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.COMMON_RES_DOWNLOAD;
    }
}
