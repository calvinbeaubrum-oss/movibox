package com.cloud.tmc.miniapp.prepare.impl;

import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.proxy.FileProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.j;
import com.cloud.tmc.miniutils.util.u;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import tc.a;
import ua.o;
import wc.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class TmcResourceManagerImpl implements TmcResourceManager {
    public final String OooO00o = "TmcResourceManagerImpl";
    public final ConcurrentHashMap<String, Integer> OooO0O0 = new ConcurrentHashMap<>();

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void clearDownloadAppMap() {
        try {
            this.OooO0O0.clear();
        } catch (Throwable th2) {
            TmcLogger.h(this.OooO00o, th2);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void creatBaseDirectory(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        ((FileProxy) a.a(FileProxy.class)).createBaseDirectory(appModel);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void createSoDirectory() {
        ((FileProxy) a.a(FileProxy.class)).createSoDirectory();
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void deleteDownloadPackage(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        ((FileProxy) a.a(FileProxy.class)).deleteFile(((PathProxy) a.a(PathProxy.class)).getZipPath(appModel));
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void deleteInstallStatus(String appId) {
        Intrinsics.g(appId, "appId");
        TmcLogger.b("deleteInstallStatus Not yet implemented");
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void downloadApp(AppModel appModel, int i11, boolean z11, f fVar) {
        Intrinsics.g(appModel, "appModel");
        downloadApp(appModel.getAppId(), AppUtils.f31011a.n(appModel), appModel.getPackageUrl_MD5(), appModel.getZipPath(), i11, z11, fVar);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void downloadApp(String str, String str2, String str3, String str4, int i11, boolean z11, f fVar) {
        try {
            if (MiniAppLaunch.f31784a.E() && i11 != 3) {
                if (this.OooO0O0.containsKey(str3)) {
                    Integer num = this.OooO0O0.get(str3);
                    if (num != null && num.intValue() == 2) {
                        TmcLogger.c(this.OooO00o, "[TYPE_DOWNLOAD_SOURCE_TYPE_SYNC downloading] appdownload sourcetype " + i11 + ",appModel -> " + str + ",appMD5 ->" + str3);
                        return;
                    }
                    if (num != null && num.intValue() == 1) {
                        if (i11 != 2) {
                            TmcLogger.c(this.OooO00o, "[TYPE_DOWNLOAD_SOURCE_TYPE_ASYNC downloading]  appModel -> " + str + ",appMD5 ->" + str3 + " is downloading");
                            return;
                        }
                        TmcLogger.c(this.OooO00o, "cancel " + str3);
                        ((INetWorkProxy) a.a(INetWorkProxy.class)).cancelDownloadCall(str, null);
                    }
                }
                if (str3 != null) {
                    this.OooO0O0.put(str3, Integer.valueOf(i11));
                }
            }
            TmcLogger.c(this.OooO00o, "addDownload " + str + ',' + str3);
        } catch (Throwable th2) {
            TmcLogger.g(this.OooO00o, "downloadApp->", th2);
        }
        ((INetWorkProxy) a.a(INetWorkProxy.class)).downloadPackage(str, str2, str4, new HashMap(), null, fVar);
    }

    public final ConcurrentHashMap<String, Integer> getDownloadAppMap() {
        return this.OooO0O0;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public String getInstallPath(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        TmcLogger.b("getInstallPath Not yet implemented");
        return "";
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public String getInstalledAppVersion(String appId) {
        Intrinsics.g(appId, "appId");
        TmcLogger.b("getInstalledAppVersion Not yet implemented");
        return "";
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public boolean getNativeCache(Context context, AppModel appModel) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        boolean zA = u.a("mini_offline/" + appModel.getAppId() + '/' + appModel.getAppId() + ".zip", appModel.getZipPath());
        if (zA) {
            h.f31061a.n(context, appModel, true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getNativeCache:changeZipDownloadStatus true:appInfo:appId:");
            StringBuilder sbA = x.a.a(appModel, sb2, ";deployVersion:");
            sbA.append(appModel.getDeployVersion());
            sbA.append(";mainPkgUrl:");
            sbA.append(appModel.getMainPackageUrl());
            sbA.append(";fullPkgUrl:");
            sbA.append(appModel.getPackageUrl());
            TmcLogger.c("Subpackage::", sbA.toString());
        }
        return zA;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public boolean getOfflineCache(Context context, AppModel appModel) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        boolean zB = j.b(appModel.getZipPath(), ((PathProxy) a.a(PathProxy.class)).getZipPath(appModel));
        if (zB) {
            h.f31061a.n(context, appModel, true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getOfflineCache:changeZipDownloadStatus true:appInfo:appId:");
            StringBuilder sbA = x.a.a(appModel, sb2, ";deployVersion:");
            sbA.append(appModel.getDeployVersion());
            sbA.append(";mainPkgUrl:");
            sbA.append(appModel.getMainPackageUrl());
            sbA.append(";fullPkgUrl:");
            sbA.append(appModel.getPackageUrl());
            TmcLogger.c("Subpackage::", sbA.toString());
        }
        return zB;
    }

    public final String getTAG() {
        return this.OooO00o;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void installApp(AppModel appModel, o oVar) {
        Intrinsics.g(appModel, "appModel");
        installApp(appModel, true, null, oVar);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void installApp(AppModel appModel, boolean z11, SubPackageInfo subPackageInfo, o oVar) {
        Intrinsics.g(appModel, "appModel");
        try {
            PathProxy pathProxy = (PathProxy) a.a(PathProxy.class);
            AppUtils appUtils = AppUtils.f31011a;
            String strJ = appUtils.j(appModel, subPackageInfo, Boolean.valueOf(z11));
            String strL = appUtils.l(appModel, subPackageInfo, Boolean.valueOf(z11));
            String tarUnCompressPath = pathProxy.getTarUnCompressPath(appModel, strJ);
            String tarPath = pathProxy.getTarPath(appModel.getAppId(), strJ, strL);
            try {
                try {
                    wb.a.a(new File(tarPath), tarUnCompressPath);
                    if (oVar != null) {
                        oVar.a(true, tarUnCompressPath);
                    }
                } catch (FileNotFoundException e11) {
                    if (oVar != null) {
                        oVar.a(false, "error:" + e11.getMessage() + "   path:   " + tarUnCompressPath);
                    }
                    TmcLogger.f(this.OooO00o, "Step_LoadStep:  tar 包文件未找到" + tarPath);
                }
            } catch (IOException e12) {
                if (oVar != null) {
                    oVar.a(false, "error:" + e12.getMessage() + "   path:   " + tarUnCompressPath);
                }
                TmcLogger.g(this.OooO00o, "Step_LoadStep:  tar解压 IOException", e12);
            }
        } catch (Throwable th2) {
            TmcLogger.g(this.OooO00o, "TmcResourceManagerImpl", th2);
            if (oVar != null) {
                oVar.a(false, th2.getMessage());
            }
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void installZip(Context context, AppModel appModel, o oVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        installZip(context, appModel, true, null, oVar);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void installZip(Context context, AppModel appModel, boolean z11, SubPackageInfo subPackageInfo, o oVar) {
        String mainPackageUrlEncryption;
        String mainPackageZipPath;
        String mainPackageUnZipFilePath;
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        if (z11) {
            mainPackageUrlEncryption = appModel.getPackageUrl_MD5();
            mainPackageZipPath = appModel.getZipPath();
            mainPackageUnZipFilePath = appModel.getUnzipFilePath();
        } else if (subPackageInfo != null) {
            mainPackageUrlEncryption = subPackageInfo.getSubPackageUrlMD5();
            String subZipPath = subPackageInfo.getSubZipPath();
            mainPackageUnZipFilePath = subPackageInfo.getSubUnzipFilePath();
            mainPackageZipPath = subZipPath;
        } else {
            mainPackageUrlEncryption = appModel.getMainPackageUrlEncryption();
            mainPackageZipPath = appModel.getMainPackageZipPath();
            mainPackageUnZipFilePath = appModel.getMainPackageUnZipFilePath();
        }
        PathProxy pathProxy = (PathProxy) a.a(PathProxy.class);
        if (h.f31061a.f(context, appModel.getAppId(), mainPackageUrlEncryption)) {
            if (oVar != null) {
                oVar.a(true, pathProxy.getTarUnCompressPath(appModel, mainPackageUrlEncryption));
                return;
            }
            return;
        }
        try {
            wb.a.b(new File(mainPackageZipPath), mainPackageUnZipFilePath);
            if (oVar != null) {
                oVar.a(true, mainPackageUnZipFilePath);
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            TmcLogger.g(this.OooO00o, "Step_LoadStep: zip 包解压失败", e11);
            if (oVar != null) {
                StringBuilder sbA = hd.j.a("error:");
                sbA.append(e11.getMessage());
                sbA.append("   path:   ");
                sbA.append(mainPackageUnZipFilePath);
                oVar.a(false, sbA.toString());
            }
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public boolean isAvailable(Context context, AppModel appModel) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        return false;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public boolean isDownloaded(Context context, AppModel appModel) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        return h.f31061a.r(context, appModel);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public boolean isDownloaded(Context context, String str, String str2) {
        Intrinsics.g(context, "context");
        return h.f31061a.e(context, str, str2);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void removeDownloadAppMap(String str) {
        try {
            TmcLogger.c(this.OooO00o, "remove download key " + str);
            TypeIntrinsics.d(this.OooO0O0).remove(str);
        } catch (Throwable th2) {
            TmcLogger.h(this.OooO00o, th2);
        }
    }
}
