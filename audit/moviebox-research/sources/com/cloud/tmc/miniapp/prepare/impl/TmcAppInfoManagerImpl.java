package com.cloud.tmc.miniapp.prepare.impl;

import android.content.Context;
import b0.f;
import com.cloud.config.utils.XLogUtil;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.proxy.IAppInfoManagerProxy;
import com.cloud.tmc.integration.utils.a0;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.integration.utils.k0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.l;
import com.cloud.tmc.miniapp.GlobalPackageConfig;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.u;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflinePkgCachePath;
import com.cloud.tmc.offline.download.model.ZipFileInfo;
import com.cloud.tmc.offline.download.utils.g;
import hd.j;
import java.util.List;
import kd.k;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import p011Oooo00o.o00Ooo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class TmcAppInfoManagerImpl implements TmcAppInfoManager, IAppInfoManagerProxy {
    public static final a Companion = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    public final String OooO00o(Context context, String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, str, str2);
    }

    public final void OooO00o(AppModel appModel, AppModel appModel2, Context context, AppModel appModel3) {
        if (Intrinsics.b(appModel.getPackageUrl_MD5(), appModel2 != null ? appModel2.getPackageUrl_MD5() : null)) {
            TmcLogger.c("TmcAppInfoManagerImpl", "url 地址一致，不删除旧版本包");
            return;
        }
        StringBuilder sbA = j.a("packageUrl_MD5 old -> ");
        sbA.append(appModel.getPackageUrl_MD5());
        sbA.append(",current-> ");
        sbA.append(appModel3.getPackageUrl_MD5());
        sbA.append(",used -> ");
        sbA.append(appModel2 != null ? appModel2.getPackageUrl_MD5() : null);
        TmcLogger.c("TmcAppInfoManagerImpl", sbA.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("删除全部");
        sb2.append(appModel.getPackageUrl_MD5());
        sb2.append(",currentAppVersion:");
        sb2.append(appModel3.getDeployVersion());
        sb2.append("，oldAppVersion：");
        sb2.append(appModel.getDeployVersion());
        sb2.append(",usedAppVersion:");
        k.a(sb2, appModel2 != null ? appModel2.getDeployVersion() : null, "Subpackage::");
        k0.s(k0.f31068a, context, appModel, null, 4, null);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0117  */
    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void delectOldVersionFilesAndUpdate(Context context, AppModel appModel) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("当次->");
        String appId = appModel.getAppId();
        if (appId == null) {
            appId = "";
        }
        sb2.append(appId);
        sb2.append(',');
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        sb2.append(miniAppLaunch.O(appModel));
        TmcLogger.c("TmcAppInfoManagerImpl", sb2.toString());
        String appId2 = appModel.getAppId();
        if (appId2 == null) {
            appId2 = "";
        }
        AppModel appModelFromOld = getAppModelFromOld(context, appId2);
        if (appModelFromOld != null) {
            StringBuilder sbA = j.a("删除_");
            sbA.append(miniAppLaunch.O(appModelFromOld));
            TmcLogger.c("TmcAppInfoManagerImpl", sbA.toString());
            String appId3 = appModel.getAppId();
            if (appId3 == null) {
                appId3 = "";
            }
            AppModel appModelFromUsed = getAppModelFromUsed(context, appId3);
            StringBuilder sbA2 = j.a("delectOldVersionFilesAndUpdate,oldVersion:");
            sbA2.append(appModelFromOld.getDeployVersion());
            sbA2.append(",oldUrl:");
            sbA2.append(appModelFromOld.getPackageUrl_MD5());
            sbA2.append("，currentAppVersion：");
            sbA2.append(appModel.getDeployVersion());
            sbA2.append(",currentUrl:");
            sbA2.append(appModel.getPackageUrl_MD5());
            sbA2.append(",usedAppVersion:");
            sbA2.append(appModelFromUsed != null ? appModelFromUsed.getDeployVersion() : null);
            sbA2.append(",usedUrl:");
            sbA2.append(appModelFromUsed != null ? appModelFromUsed.getPackageUrl_MD5() : null);
            TmcLogger.c("Subpackage::", sbA2.toString());
            if (Intrinsics.b(appModelFromOld.getPackageUrl_MD5(), appModel.getPackageUrl_MD5())) {
                TmcLogger.c("TmcAppInfoManagerImpl", "全量包 url 版本一致,不删除");
            } else {
                if (Intrinsics.b(appModelFromOld.getPackageUrl_MD5(), appModelFromUsed != null ? appModelFromUsed.getPackageUrl_MD5() : null)) {
                    TmcLogger.c("TmcAppInfoManagerImpl", "全量包 url 版本一致,不删除");
                } else {
                    h.f31061a.s(context, appModelFromOld);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("删除旧版本全量包:");
                    sb3.append(appModelFromOld.getPackageUrl_MD5());
                    sb3.append("，currentAppVersion：");
                    sb3.append(appModel.getDeployVersion());
                    sb3.append(",oldAppVersion:");
                    sb3.append(appModelFromOld.getDeployVersion());
                    sb3.append(",usedAppVersion:");
                    k.a(sb3, appModelFromUsed != null ? appModelFromUsed.getDeployVersion() : null, "Subpackage::");
                }
            }
        }
        String appId4 = appModel.getAppId();
        AppModel appModelFromUsed2 = getAppModelFromUsed(context, appId4 != null ? appId4 : "");
        if (appModelFromUsed2 != null) {
            updateAppModel(context, appModelFromUsed2, appModelFromUsed2.getAppId() + "_old");
            StringBuilder sb4 = new StringBuilder();
            sb4.append("appID:");
            StringBuilder sbA3 = x.a.a(appModelFromUsed2, sb4, " updateAppModel version:");
            sbA3.append(miniAppLaunch.O(appModelFromUsed2));
            sbA3.append(" to old");
            TmcLogger.c("Subpackage::", sbA3.toString());
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void deleteOldVersionFiles(Context context, AppModel appModel, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("当次->");
        String appId = appModel.getAppId();
        if (appId == null) {
            appId = "";
        }
        sb2.append(appId);
        sb2.append(',');
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        sb2.append(miniAppLaunch.O(appModel));
        TmcLogger.c("TmcAppInfoManagerImpl", sb2.toString());
        String appId2 = appModel.getAppId();
        if (appId2 == null) {
            appId2 = "";
        }
        AppModel appModelFromOld = getAppModelFromOld(context, appId2);
        if (appModelFromOld != null) {
            StringBuilder sbA = j.a("删除_");
            sbA.append(miniAppLaunch.O(appModelFromOld));
            TmcLogger.c("TmcAppInfoManagerImpl", sbA.toString());
            String appId3 = appModel.getAppId();
            AppModel subpackageAppModelFromUsed = getSubpackageAppModelFromUsed(context, appId3 != null ? appId3 : "");
            OooO00o(appModelFromOld, subpackageAppModelFromUsed, context, appModel);
            String strO = miniAppLaunch.O(appModel);
            String strO2 = miniAppLaunch.O(subpackageAppModelFromUsed);
            if (subpackageAppModelFromUsed == null || strO == null || strO.length() == 0 || strO2 == null || strO2.length() == 0 || !z11 || !miniAppLaunch.D(strO, strO2)) {
                return;
            }
            OooO00o(subpackageAppModelFromUsed, appModel, context, appModel);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public String findUrlMappedAppId(Context context, String str) {
        Intrinsics.g(context, "context");
        return "";
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppInfoModel getAppInfoModel(Context context, lb.a query) {
        Intrinsics.g(context, "context");
        Intrinsics.g(query, "query");
        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, query.a(), "APP_INFO_MODEL");
        if (string == null || string.length() == 0) {
            return null;
        }
        return (AppInfoModel) a0.f31025a.a(string, AppInfoModel.class);
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0217  */
    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModel(Context context, lb.a query) {
        AppModel appModel;
        AppInfoModel appModelFromConfig;
        MiniAppLaunch miniAppLaunch;
        AppModel appModelG;
        AppInfoModel appModelFromCDN;
        MiniAppLaunch miniAppLaunch2;
        AppModel appModelG2;
        boolean zR;
        Intrinsics.g(context, "context");
        Intrinsics.g(query, "query");
        c0.a aVar = c0.a.f14531a;
        String appId = query.a();
        Intrinsics.g(appId, "appId");
        AppModel appModel2 = null;
        try {
            if (f.f13872a.d()) {
                appModel = null;
            } else {
                TmcLogger.c(c0.a.f14533c, "getPreAppinfoModel " + appId);
                appModel = c0.a.f14532b.get(appId);
            }
        } catch (Throwable th2) {
            TmcLogger.g(c0.a.f14533c, "getPreAppinfoModel", th2);
        }
        if (appModel != null) {
            TmcLogger.c("TmcAppInfoManagerImpl", "getPreAppinfoModel from memory");
            return appModel;
        }
        AppModel appModelFromPre = getAppModelFromPre(context, query.a());
        k.a(j.a("get preAppModel,appVersion:"), appModelFromPre != null ? appModelFromPre.getDeployVersion() : null, "Subpackage::");
        if (appModelFromPre != null) {
            h hVar = h.f31061a;
            if (!hVar.l(appModelFromPre) && !(zR = hVar.r(context, appModelFromPre))) {
                if (o00Ooo.e(appModelFromPre)) {
                    zR = hVar.e(context, appModelFromPre.getAppId(), appModelFromPre.getMainPackageUrlEncryption());
                    StringBuilder sbA = j.a("get preAppModel,appVersion:");
                    sbA.append(appModelFromPre.getDeployVersion());
                    sbA.append(",downloaded");
                    TmcLogger.c("Subpackage::", sbA.toString());
                }
                if (!zR) {
                    appModelFromPre = null;
                }
            }
        }
        if (appModelFromPre == null) {
            appModelFromPre = getAppModelFromUsed(context, query.a());
            k.a(j.a("get usedAppModel,appVersion:"), appModelFromPre != null ? appModelFromPre.getDeployVersion() : null, "Subpackage::");
        }
        if (appModelFromPre != null && appModelFromPre.isTestVersion()) {
            TmcLogger.f("TmcAppInfoManagerImpl", "当前使用的非正式版本，不启用替换内置和 cdn、config 能力");
            return appModelFromPre;
        }
        AppModel appModelFromPackage = getAppModelFromPackage(context, query.a());
        if (appModelFromPackage != null) {
            MiniAppLaunch miniAppLaunch3 = MiniAppLaunch.f31784a;
            String strO = miniAppLaunch3.O(appModelFromPackage);
            if (strO == null) {
                strO = "0";
            }
            String strO2 = miniAppLaunch3.O(appModelFromPre);
            if (strO2 == null) {
                strO2 = "0";
            }
            boolean zD = miniAppLaunch3.D(strO, strO2);
            if (appModelFromPre == null || zD) {
                resetAppPreModel(context, query.a());
                appModelFromPre = appModelFromPackage;
            }
        }
        if (!Intrinsics.b(query.a(), "100000")) {
            StringBuilder sbA2 = j.a("getAppModel,appVersion:");
            sbA2.append(appModelFromPre != null ? appModelFromPre.getDeployVersion() : null);
            TmcLogger.c("Subpackage::", sbA2.toString());
            String strA = query.a();
            String strO3 = MiniAppLaunch.f31784a.O(appModelFromPre);
            AppModel appModelFromOffline = getAppModelFromOffline(context, strA, strO3 != null ? strO3 : "0");
            if (appModelFromOffline != null) {
                appModelFromPre = appModelFromOffline;
            }
        }
        String strA2 = query.a();
        String str = "";
        if (strA2 != null) {
            try {
                if (strA2.length() == 0 || (appModelFromConfig = getAppModelFromConfig(context, strA2)) == null || (appModelG = (miniAppLaunch = MiniAppLaunch.f31784a).G(appModelFromConfig)) == null) {
                    appModelG = null;
                } else {
                    appModelG.setFromCacheType(5);
                    if (appModelFromPre == null || h.f31061a.l(appModelG)) {
                        TmcLogger.c("TmcAppInfoManagerImpl", "appmodel is null ,use config appinfo");
                        String strO4 = miniAppLaunch.O(appModelG);
                        if (strO4 == null) {
                            strO4 = "";
                        }
                        String strO5 = miniAppLaunch.O(appModelFromPre);
                        if (strO5 == null) {
                            strO5 = "";
                        }
                        boolean zD2 = miniAppLaunch.D(strO4, strO5);
                        TmcLogger.c("TmcAppInfoManagerImpl", "appmodel == null,appid ->" + strA2 + ",config appinfo compare result " + zD2);
                        if (zD2) {
                            updateAppModel(context, appModelG, strA2 + "_pre");
                            ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(strA2, XLogUtil.TAG);
                        }
                    } else {
                        String strO6 = miniAppLaunch.O(appModelG);
                        if (strO6 == null) {
                            strO6 = "";
                        }
                        String strO7 = miniAppLaunch.O(appModelFromPre);
                        if (strO7 == null) {
                            strO7 = "";
                        }
                        boolean zD3 = miniAppLaunch.D(strO6, strO7);
                        TmcLogger.c("TmcAppInfoManagerImpl", "appid ->" + strA2 + ",config appinfo compare result " + zD3);
                        if (zD3) {
                            if (appModelFromPre.getFromCacheType() != 1) {
                                TmcLogger.c("TmcAppInfoManagerImpl", "update pre appinfo use config");
                                updateAppModel(context, appModelG, strA2 + "_pre");
                            } else {
                                TmcLogger.c("TmcAppInfoManagerImpl", "current appinfo from pre,not update config");
                            }
                        }
                    }
                    appModelG = null;
                }
            } catch (Throwable th3) {
                TmcLogger.g("TmcAppInfoManagerImpl", "getAppModelFromConfig", th3);
            }
        } else {
            appModelG = null;
        }
        if (appModelG != null) {
            appModelFromPre = appModelG;
        }
        String strA3 = query.a();
        try {
            if (MiniAppConfigHelper.f30370a.b("enableAppinfoCdn", false) && strA3 != null) {
                try {
                    if (strA3.length() != 0 && (appModelFromCDN = getAppModelFromCDN(context, strA3)) != null && (appModelG2 = (miniAppLaunch2 = MiniAppLaunch.f31784a).G(appModelFromCDN)) != null) {
                        appModelG2.setFromCacheType(6);
                        if (appModelFromPre == null || h.f31061a.l(appModelG2)) {
                            String strO8 = miniAppLaunch2.O(appModelG2);
                            if (strO8 == null) {
                                strO8 = "";
                            }
                            String strO9 = miniAppLaunch2.O(appModelFromPre);
                            if (strO9 != null) {
                                str = strO9;
                            }
                            boolean zD4 = miniAppLaunch2.D(strO8, str);
                            TmcLogger.c("TmcAppInfoManagerImpl", "appModel is null,appId ->" + strA3 + ",cdn appinfo compare result " + zD4);
                            if (zD4) {
                                updateAppModel(context, appModelG2, strA3 + "_pre");
                                ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(strA3, "cdn");
                                appModel2 = appModelG2;
                            }
                        } else {
                            String strO10 = miniAppLaunch2.O(appModelG2);
                            if (strO10 == null) {
                                strO10 = "";
                            }
                            String strO11 = miniAppLaunch2.O(appModelFromPre);
                            if (strO11 != null) {
                                str = strO11;
                            }
                            boolean zD5 = miniAppLaunch2.D(strO10, str);
                            TmcLogger.c("TmcAppInfoManagerImpl", "appId ->" + strA3 + ",cdn appinfo compare result " + zD5);
                            if (zD5) {
                                if (appModelFromPre.getFromCacheType() != 1) {
                                    TmcLogger.c("TmcAppInfoManagerImpl", "update pre appinfo use cdn");
                                    updateAppModel(context, appModelG2, strA3 + "_pre");
                                } else {
                                    TmcLogger.c("TmcAppInfoManagerImpl", "current appinfo from pre,not update cdn appinfo ");
                                }
                            }
                        }
                    }
                } catch (Throwable th4) {
                    TmcLogger.h("TmcAppInfoManagerImpl", th4);
                }
            }
        } catch (Throwable unused) {
        }
        return appModel2 != null ? appModel2 : appModelFromPre;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppInfoModel getAppModelFromCDN(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        String strOooO00o = OooO00o(context, appId, appId + "_cdn");
        if (strOooO00o == null || strOooO00o.length() == 0) {
            return null;
        }
        try {
            return (AppInfoModel) a0.f31025a.a(strOooO00o, AppInfoModel.class);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppInfoModel getAppModelFromConfig(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        String strOooO00o = OooO00o(context, appId, appId + "_config");
        if (strOooO00o == null || strOooO00o.length() == 0) {
            return null;
        }
        try {
            return (AppInfoModel) a0.f31025a.a(strOooO00o, AppInfoModel.class);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromDev(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        if (!AppDynamicBuildConfig.k()) {
            return null;
        }
        String strOooO00o = OooO00o(context, appId, appId + "_dev");
        if (strOooO00o == null || strOooO00o.length() == 0) {
            return null;
        }
        try {
            AppModel appModel = (AppModel) a0.f31025a.a(strOooO00o, AppModel.class);
            appModel.setFromCacheType(1);
            return appModel;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromOffline(Context context, String appId, String currentVersion) {
        String strA;
        OffPkgConfig manifest;
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(currentVersion, "currentVersion");
        if (!l.e()) {
            TmcLogger.c("TmcAppInfoManagerImpl", "getAppModelFromOffline failed! current process is not miniProcess");
            return null;
        }
        TmcLogger.c("Subpackage::", "getAppModelFromOffline,appVersion:" + currentVersion);
        OfflinePkgCachePath offlinePkgCachePathJ = OfflineManager.J(appId);
        if (offlinePkgCachePathJ == null || (strA = g.f32096a.a(offlinePkgCachePathJ)) == null) {
            return null;
        }
        TmcLogger.c("Subpackage::", "getAppModelFromOffline,appVersion:" + currentVersion + ",offlineAppVersion:" + strA);
        if (Intrinsics.b(strA, currentVersion) || MiniAppLaunch.f31784a.D(strA, currentVersion)) {
            List<ZipFileInfo> zipFileInfo = offlinePkgCachePathJ.getZipFileInfo();
            ZipFileInfo zipFileInfo2 = zipFileInfo != null ? (ZipFileInfo) CollectionsKt___CollectionsKt.e0(zipFileInfo) : null;
            AppInfoModel appInfo = (zipFileInfo2 == null || (manifest = zipFileInfo2.getManifest()) == null) ? null : manifest.getAppInfo();
            AppModel appModelG = appInfo != null ? MiniAppLaunch.f31784a.G(appInfo) : null;
            if (appModelG != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(zipFileInfo2 != null ? zipFileInfo2.getZipUnCompressPath() : null);
                sb2.append('/');
                sb2.append(appId);
                sb2.append(".zip");
                appModelG.setZipPath(sb2.toString());
            }
            if (appModelG != null) {
                appModelG.setFromCacheType(4);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(appId);
                sb3.append(':');
                sb3.append(strA);
                k.a(sb3, " -> 命中离线包", "TmcAppInfoManagerImpl");
                return appModelG;
            }
            TmcLogger.c("TmcAppInfoManagerImpl", appId + ':' + strA + " -> offlineModel 为空,不使用离线包");
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(appId);
            sb4.append(':');
            sb4.append(strA);
            sb4.append(" 离线包版本号未大于或等于当前资源包 ");
            sb4.append(currentVersion);
            k.a(sb4, " ,不使用离线包", "TmcAppInfoManagerImpl");
        }
        return null;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromOld(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        if (appId.length() == 0) {
            return null;
        }
        String strOooO00o = OooO00o(context, appId, appId + "_old");
        if (strOooO00o == null || strOooO00o.length() == 0) {
            return null;
        }
        try {
            AppModel appModel = (AppModel) a0.f31025a.a(strOooO00o, AppModel.class);
            appModel.setFromCacheType(2);
            return appModel;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromPackage(Context context, String appId) {
        AppModel appModel;
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        String strB = "";
        try {
            strB = OooO00o(context, appId, appId + "_native_" + GlobalPackageConfig.Companion.b());
            if (strB == null || strB.length() <= 0) {
                appModel = null;
            } else {
                appModel = (AppModel) a0.f31025a.a(strB, AppModel.class);
                appModel.setFromCacheType(3);
            }
            if (appModel != null) {
                return appModel;
            }
        } catch (Throwable th2) {
            TmcLogger.g("TmcAppInfoManagerImpl", "getAppModelFromPackage", th2);
        }
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isReadAssets_");
        sb2.append(appId);
        sb2.append('_');
        GlobalPackageConfig.a aVar = GlobalPackageConfig.Companion;
        sb2.append(aVar.b());
        boolean z11 = false;
        if (kVStorageProxy.getBoolean(context, appId, sb2.toString(), false)) {
            return null;
        }
        if (strB == null || strB.length() == 0) {
            strB = u.b("mini_offline/" + appId + '/' + appId + ".json");
            z11 = true;
        }
        try {
            AppModel appModel2 = (AppModel) a0.f31025a.a(strB, AppModel.class);
            appModel2.setFromCacheType(3);
            if (z11) {
                updateAppModel(context, appModel2, appId + "_native_" + aVar.b());
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, appId, "isReadAssets_" + appId + '_' + aVar.b(), true);
            }
            return appModel2;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromPre(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        String strOooO00o = OooO00o(context, appId, appId + "_pre");
        if (strOooO00o == null || strOooO00o.length() == 0) {
            return null;
        }
        try {
            AppModel appModel = (AppModel) a0.f31025a.a(strOooO00o, AppModel.class);
            appModel.setFromCacheType(1);
            return appModel;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppModelFromUsed(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        if (appId.length() == 0) {
            return null;
        }
        String strOooO00o = OooO00o(context, appId, appId + "_used");
        if (strOooO00o == null || strOooO00o.length() == 0) {
            return null;
        }
        try {
            AppModel appModel = (AppModel) a0.f31025a.a(strOooO00o, AppModel.class);
            appModel.setFromCacheType(2);
            h hVar = h.f31061a;
            boolean zE = hVar.e(context, appId, appModel.getPackageUrl_MD5());
            if (!zE && o00Ooo.e(appModel)) {
                zE = hVar.e(context, appModel.getAppId(), appModel.getMainPackageUrlEncryption());
                TmcLogger.c("Subpackage::", "get AppModelFromUsed,appVersion:" + appModel.getDeployVersion() + ",downloaded:" + zE);
            }
            if (zE || hVar.l(appModel)) {
                return appModel;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.integration.proxy.IAppInfoManagerProxy
    public AppModel getAppModelHasNotOffline(Context context, lb.a query) {
        Intrinsics.g(context, "context");
        Intrinsics.g(query, "query");
        AppModel appModelFromPre = getAppModelFromPre(context, query.a());
        if (appModelFromPre != null) {
            h hVar = h.f31061a;
            if (!hVar.l(appModelFromPre) && !hVar.r(context, appModelFromPre)) {
                appModelFromPre = null;
            }
        }
        if (appModelFromPre == null) {
            appModelFromPre = getAppModelFromUsed(context, query.a());
        }
        AppModel appModelFromPackage = getAppModelFromPackage(context, query.a());
        if (appModelFromPackage == null) {
            return appModelFromPre;
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        String strO = miniAppLaunch.O(appModelFromPackage);
        if (strO == null) {
            strO = "0";
        }
        String strO2 = miniAppLaunch.O(appModelFromPre);
        boolean zD = miniAppLaunch.D(strO, strO2 != null ? strO2 : "0");
        if (appModelFromPre != null && !zD) {
            return appModelFromPre;
        }
        resetAppPreModel(context, query.a());
        return appModelFromPackage;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getAppWarmupModel(Context context, lb.a query) {
        Intrinsics.g(context, "context");
        Intrinsics.g(query, "query");
        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, query.a(), query.a() + "_warmup");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return (AppModel) a0.f31025a.a(string, AppModel.class);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public long getLastUpdateTime(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        StringBuilder sbA = j.a("APP_LAST_UPDATE_TIME_");
        sbA.append(GlobalPackageConfig.Companion.b());
        return kVStorageProxy.getLong(context, appId, sbA.toString());
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public boolean getPreUnzipStatus(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(context, appId, h.a.a(appId, "_preunzip"), false);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public AppModel getSubpackageAppModelFromUsed(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        if (appId.length() == 0) {
            return null;
        }
        String strOooO00o = OooO00o(context, appId, appId + "_used");
        if (strOooO00o == null || strOooO00o.length() == 0) {
            return null;
        }
        try {
            AppModel appModel = (AppModel) a0.f31025a.a(strOooO00o, AppModel.class);
            appModel.setFromCacheType(2);
            return appModel;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void refreshUpdateTime(Context context, String appId, long j11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
        StringBuilder sbA = j.a("APP_LAST_UPDATE_TIME_");
        sbA.append(GlobalPackageConfig.Companion.b());
        kVStorageProxy.putLong(context, appId, sbA.toString(), j11);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void resetAppPreModel(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, appId, h.a.a(appId, "_pre"), "");
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void updateAppModel(Context context, AppModel appModel, String key) {
        String appId;
        Intrinsics.g(context, "context");
        Intrinsics.g(key, "key");
        if (appModel == null || (appId = appModel.getAppId()) == null) {
            return;
        }
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, appId, key, a0.f31025a.c(appModel));
    }

    @Override // com.cloud.tmc.integration.proxy.IAppInfoManagerProxy
    public void updateAppModelByOffline(Context context, AppModel appModel, String key) {
        Intrinsics.g(context, "context");
        Intrinsics.g(key, "key");
        updateAppModel(context, appModel, key);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void updateAppWarmupModel(Context context, AppModel appModel) {
        String appId;
        Intrinsics.g(context, "context");
        if (appModel == null || (appId = appModel.getAppId()) == null) {
            return;
        }
        String strC = a0.f31025a.c(appModel);
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, appId, appModel.getAppId() + "_warmup", strC);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void updateOldVersion(Context context, AppModel appModel, String str) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appModel, "appModel");
        if (str == null || str.length() == 0) {
            String appId = appModel.getAppId();
            if (appId == null) {
                appId = "";
            }
            AppModel subpackageAppModelFromUsed = getSubpackageAppModelFromUsed(context, appId);
            if (subpackageAppModelFromUsed != null) {
                updateAppModel(context, subpackageAppModelFromUsed, subpackageAppModelFromUsed.getAppId() + "_old");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("appID:");
                StringBuilder sbA = x.a.a(subpackageAppModelFromUsed, sb2, " updateAppModel version:");
                MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
                sbA.append(miniAppLaunch.O(subpackageAppModelFromUsed));
                sbA.append(" to old");
                TmcLogger.c("TmcAppInfoManagerImpl", sbA.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("appID:");
                StringBuilder sbA2 = x.a.a(subpackageAppModelFromUsed, sb3, " updateAppModel version:");
                sbA2.append(miniAppLaunch.O(subpackageAppModelFromUsed));
                sbA2.append(" to old");
                TmcLogger.c("Subpackage::", sbA2.toString());
            }
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager
    public void updatePreUnzipStatus(Context context, String appId, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, appId, h.a.a(appId, "_preunzip"), z11);
    }
}
