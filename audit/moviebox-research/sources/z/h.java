package z;

import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.resource.ISubPackageResourceManager;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.utils.a0;
import com.cloud.tmc.integration.utils.k0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import hd.j;
import hd.k;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class h extends a0.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f81684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f81685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f81686k;

    public h(String str, Integer num) {
        this.f81684i = str;
        this.f81685j = num;
        this.f81686k = new i();
    }

    public /* synthetic */ h(String str, Integer num, int i11) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 1 : null);
    }

    @Override // a0.c
    public void d(PrepareController prepareController, lb.g gVar, c0 c0Var, lb.f fVar) {
        String str;
        Integer num = this.f81686k.f81691e;
        if (num != null && 1 == num.intValue() && (str = this.f81686k.f81689c) != null && str.length() != 0) {
            AppModel appModelE = gVar.e();
            String appId = appModelE != null ? appModelE.getAppId() : null;
            if (appId != null && appId.length() != 0) {
                Context contextP = gVar.p();
                if (contextP == null) {
                    super.d(prepareController, gVar, c0Var, fVar);
                    return;
                }
                KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
                StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                Object[] objArr = new Object[1];
                AppModel appModelE2 = gVar.e();
                objArr[0] = appModelE2 != null ? appModelE2.getMainPackageUrlEncryption() : null;
                String str2 = String.format("subpackage_sync_lock_status_%s", Arrays.copyOf(objArr, 1));
                Intrinsics.f(str2, "format(format, *args)");
                int i11 = kVStorageProxy.getInt(contextP, "miniapp_business_subpackage_record", str2) + 1;
                if (i11 >= 2) {
                    kVStorageProxy.remove(contextP, "miniapp_business_subpackage_record", str2);
                    super.d(prepareController, gVar, c0Var, fVar);
                    return;
                } else {
                    kVStorageProxy.putInt(contextP, "miniapp_business_subpackage_record", str2, i11);
                    if (prepareController != null) {
                        prepareController.finish();
                        return;
                    }
                    return;
                }
            }
        }
        super.d(prepareController, gVar, c0Var, fVar);
    }

    @Override // a0.c
    public lb.f e(PrepareController prepareController, lb.g gVar, c0 c0Var) {
        try {
            p.e(this.f31599a, "startStep 创建normal app config");
            AppModel appModelE = gVar.e();
            this.f81686k.d(appModelE, this.f81684i, gVar, this.f81685j);
            String strB = this.f81686k.b(appModelE);
            if ((appModelE != null ? appModelE.getPermissions() : null) != null) {
                ((AuthenticationProxy) tc.a.a(AuthenticationProxy.class)).setPermissionModel(appModelE.getAppId(), appModelE.getPermissions());
            }
            TmcAppInfoManager tmcAppInfoManager = this.f31600b;
            Context contextP = gVar.p();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(appModelE != null ? appModelE.getAppId() : null);
            sb2.append("_used");
            tmcAppInfoManager.updateAppModel(contextP, appModelE, sb2.toString());
            if (this.f31600b.getPreUnzipStatus(gVar.p(), appModelE != null ? appModelE.getAppId() : null)) {
                TmcLogger.c("Tmc", "startStep_使用了预先解压的包");
                ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(appModelE != null ? appModelE.getAppId() : null, "preunzip");
                this.f31600b.updatePreUnzipStatus(gVar.p(), appModelE != null ? appModelE.getAppId() : null, false);
            }
            HashMap<String, String> map = new HashMap<>();
            HashMap<String, String> map2 = new HashMap<>();
            HashMap<String, String> map3 = new HashMap<>();
            IPackageResourceManager manager = (IPackageResourceManager) tc.a.a(IPackageResourceManager.class);
            if (strB != null) {
                Intrinsics.f(manager, "manager");
                h(prepareController, gVar, appModelE, map, map2, map3, manager, strB);
            }
            AppLoadResult appLoadResult = new AppLoadResult();
            appLoadResult.appVersion = MiniAppLaunch.f31784a.O(appModelE);
            appLoadResult.mainHtmlUrl = "https://100000.miniapp.transsion.com/index.html";
            Intrinsics.f(manager, "manager");
            Object objA = tc.a.a(ISubPackageResourceManager.class);
            Intrinsics.f(objA, "get(ISubPackageResourceManager::class.java)");
            f(appModelE, prepareController, map, map2, manager, appLoadResult);
            appLoadResult.htmlMap = map3;
            appLoadResult.appType = "WEB_TINY";
            appLoadResult.frameWorkModel = gVar.l();
            new lb.f(gVar).f70183d = appLoadResult;
            lb.f fVar = new lb.f(gVar);
            fVar.f70183d = appLoadResult;
            return fVar;
        } catch (Throwable th2) {
            TmcLogger.h(this.f31599a, th2);
            return null;
        }
    }

    public final void f(AppModel appModel, PrepareController prepareController, Map map, Map map2, IPackageResourceManager iPackageResourceManager, AppLoadResult appLoadResult) {
        String filePath;
        String mainPackageUrlEncryption;
        try {
            if (!this.f81686k.f81688b) {
                filePath = iPackageResourceManager.getFilePath(appModel != null ? appModel.getAppId() : null, (String) map.get("appConfig.json"));
            } else if (appModel == null || (mainPackageUrlEncryption = appModel.getMainPackageUrlEncryption()) == null || mainPackageUrlEncryption.length() == 0) {
                filePath = null;
            } else {
                filePath = ((PathProxy) tc.a.a(PathProxy.class)).getTarUnCompressPath(appModel, appModel.getMainPackageUrlEncryption()) + File.separator + "appConfig.json";
            }
            TmcLogger.c(this.f31599a, "appConfigFilePath:" + filePath);
            String file2String = filePath != null ? this.f31603e.readFile2String(filePath) : null;
            if (file2String == null || file2String.length() == 0) {
                TmcLogger.c(this.f31599a, (char) 22312 + filePath + "里读到的内容为空");
            } else {
                appLoadResult.appConfigModel = (MiniAppConfigModel) a0.f31025a.a(file2String, MiniAppConfigModel.class);
                String str = this.f31599a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setAppConfig finish,isEmpty:");
                sb2.append(appLoadResult.appConfigModel != null);
                TmcLogger.c(str, sb2.toString());
            }
        } catch (Throwable unused) {
            TmcLogger.c(this.f31599a, "appConfig不存在：");
            if (prepareController != null) {
                com.cloud.tmc.miniapp.prepare.steps.i.a(PrepareException.ERROR_MANIFEST_INFO, "appConfig.json error", prepareController);
            }
        }
        try {
            String str2 = (String) map2.get("appConfig.json");
            if (str2 != null) {
                String filePath2 = iPackageResourceManager.getFilePath("100000", str2);
                appLoadResult.frameworkConfigModel = (MiniAppConfigModel) a0.f31025a.a(filePath2 != null ? this.f31603e.readFile2String(filePath2) : null, MiniAppConfigModel.class);
            }
        } catch (Throwable unused2) {
            if (prepareController != null) {
                com.cloud.tmc.miniapp.prepare.steps.i.a(PrepareException.ERROR_MANIFEST_INFO, "frameworkConfig.json error", prepareController);
            }
            TmcLogger.c(this.f31599a, "frameworkConfig 不存在：");
        }
    }

    public final void g(AppModel appModel, List<? extends File> list, HashMap<String, String> map, HashMap<String, String> map2, IPackageResourceManager iPackageResourceManager, String str) {
        for (File file : list) {
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    g(appModel, kotlin.collections.d.A0(fileArrListFiles), map, map2, iPackageResourceManager, str + '/' + file.getName());
                }
            } else {
                String vUrl = iPackageResourceManager.generateVUrl(file.getAbsolutePath(), appModel.getAppId(), file.getName(), str);
                StringBuilder sbA = j.a("SubpackageStartStep:absPath:");
                sbA.append(file.getAbsolutePath());
                sbA.append(";vUrl:");
                sbA.append(vUrl);
                TmcLogger.c("Subpackage::", sbA.toString());
                String name = file.getName();
                Intrinsics.f(name, "f.name");
                Intrinsics.f(vUrl, "vUrl");
                map.put(name, vUrl);
                String name2 = file.getName();
                Intrinsics.f(name2, "f.name");
                Locale locale = Locale.getDefault();
                Intrinsics.f(locale, "getDefault()");
                String lowerCase = name2.toLowerCase(locale);
                Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (StringsKt__StringsKt.Q(lowerCase, ".html", false, 2, null)) {
                    map2.put(file.getName(), vUrl);
                }
                String str2 = this.f31599a;
                StringBuilder sbA2 = j.a("Step_LoadStep: tar包结构: ");
                sbA2.append(file.getName());
                TmcLogger.c(str2, sbA2.toString());
                k.a("Step_LoadStep: tar包结构: ", vUrl, this.f31599a);
            }
        }
    }

    public final void h(PrepareController prepareController, lb.g gVar, AppModel appModel, HashMap<String, String> map, HashMap<String, String> map2, HashMap<String, String> map3, IPackageResourceManager iPackageResourceManager, String str) {
        try {
            AppModel appModelL = gVar.l();
            if (appModelL != null) {
                List<File> listListFilesInDir = this.f31603e.listFilesInDir(appModelL);
                if (listListFilesInDir != null && !listListFilesInDir.isEmpty()) {
                    g(appModelL, listListFilesInDir, map2, map3, iPackageResourceManager, "");
                }
                com.cloud.tmc.integration.utils.h.f31061a.s(gVar.p(), appModelL);
                if (prepareController != null) {
                    prepareController.moveToError(new PrepareException(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION, "frameworkzip error"));
                    return;
                }
                return;
            }
        } catch (Throwable unused) {
            if (prepareController != null) {
                com.cloud.tmc.miniapp.prepare.steps.i.a(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION, "frameworkzip error", prepareController);
            }
            TmcLogger.c(this.f31599a, "请先下载框架包资源文件：");
        }
        try {
            Context contextP = gVar.p();
            if (appModel != null && contextP != null) {
                List<File> listListFilesInDir2 = this.f31603e.listFilesInDir(appModel, str);
                if (listListFilesInDir2 != null && !listListFilesInDir2.isEmpty()) {
                    this.f81686k.c();
                    if (this.f81686k.f81688b) {
                        return;
                    }
                    g(appModel, listListFilesInDir2, map, map3, iPackageResourceManager, "");
                    return;
                }
                k0.f31068a.r(contextP, appModel, str);
                if (prepareController != null) {
                    prepareController.moveToError(new PrepareException(PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION, "miniappzip error"));
                }
            }
        } catch (Throwable th2) {
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException(PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION, th2.getMessage()));
            }
            TmcLogger.c(this.f31599a, "资源文件出错");
        }
    }
}
