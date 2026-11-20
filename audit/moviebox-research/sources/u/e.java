package u;

import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.a0;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prepare.steps.i;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import hd.j;
import hd.k;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lb.f;
import lb.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends a0.c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.cloud.tmc.integration.proxy.FileProxy] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.cloud.tmc.integration.utils.h] */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.cloud.tmc.integration.model.AppModel] */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.cloud.tmc.integration.model.AppModel] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.util.HashMap<?, ?>] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.cloud.tmc.miniapp.utils.MiniAppLaunch] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.cloud.tmc.miniapp.prepare.steps.a, u.e] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.cloud.tmc.integration.model.AppModel] */
    /* JADX WARN: Type inference failed for: r30v10 */
    /* JADX WARN: Type inference failed for: r30v3 */
    /* JADX WARN: Type inference failed for: r30v4 */
    /* JADX WARN: Type inference failed for: r30v5 */
    /* JADX WARN: Type inference failed for: r30v6 */
    /* JADX WARN: Type inference failed for: r30v7 */
    /* JADX WARN: Type inference failed for: r30v8 */
    /* JADX WARN: Type inference failed for: r30v9 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
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
    @Override // a0.c
    public f e(PrepareController prepareController, g gVar, c0 c0Var) {
        Object obj;
        ?? ListFilesInDir;
        ?? r31;
        ?? r32;
        ?? r22;
        ?? r21;
        Object obj2;
        ?? r17;
        ?? r11;
        String appId;
        Class<MiniAppConfigModel> cls;
        String str;
        ?? r12;
        ?? r13;
        Object obj3 = "frameworkConfig 不存在：";
        String str2 = "frameworkConfig.json error";
        String str3 = PrepareException.ERROR_MANIFEST_INFO;
        Class<MiniAppConfigModel> cls2 = MiniAppConfigModel.class;
        p.e(this.f31599a, "startStep 创建normal app config");
        AppModel appModelE = gVar.e();
        if (appModelE.getPermissions() != null) {
            ((AuthenticationProxy) tc.a.a(AuthenticationProxy.class)).setPermissionModel(appModelE.getAppId(), appModelE.getPermissions());
        }
        TmcAppInfoManager tmcAppInfoManager = this.f31600b;
        Context contextP = gVar.p();
        StringBuilder sb2 = new StringBuilder();
        Object obj4 = "appConfig.json";
        sb2.append(appModelE.getAppId());
        String str4 = "_used";
        sb2.append("_used");
        tmcAppInfoManager.updateAppModel(contextP, appModelE, sb2.toString());
        if (this.f31600b.getPreUnzipStatus(gVar.p(), appModelE.getAppId())) {
            TmcLogger.c("Tmc", "startStep_使用了预先解压的包");
            ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(appModelE.getAppId(), "preunzip");
            this.f31600b.updatePreUnzipStatus(gVar.p(), appModelE.getAppId(), false);
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        IPackageResourceManager iPackageResourceManager = (IPackageResourceManager) tc.a.a(IPackageResourceManager.class);
        Object obj5 = map4;
        try {
            obj = map3;
            try {
                ListFilesInDir = this.f31603e.listFilesInDir(gVar.l());
                try {
                    if (ListFilesInDir == 0 || ListFilesInDir.isEmpty()) {
                        str4 = "_used";
                        cls2 = cls2;
                        str3 = PrepareException.ERROR_MANIFEST_INFO;
                        r21 = "frameworkConfig.json error";
                        obj4 = obj4;
                        r22 = obj5;
                        obj2 = obj;
                        r32 = map;
                        obj = "frameworkConfig 不存在：";
                        r11 = appModelE;
                        r17 = map2;
                        h.f31061a.s(gVar.p(), gVar.l());
                        prepareController.moveToError(new PrepareException(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION, "frameworkzip error"));
                    } else {
                        AppModel appModelL = gVar.l();
                        ?? r23 = obj5;
                        obj2 = obj;
                        obj = "frameworkConfig 不存在：";
                        r11 = appModelE;
                        HashMap map5 = map2;
                        r21 = "frameworkConfig.json error";
                        str2 = r31;
                        r32 = map;
                        str4 = "_used";
                        obj4 = obj4;
                        cls2 = cls2;
                        str3 = PrepareException.ERROR_MANIFEST_INFO;
                        f(appModelL, ListFilesInDir, map5, r23, iPackageResourceManager, "");
                        r17 = map5;
                        r22 = r23;
                        try {
                            List<File> listListFilesInDir = this.f31603e.listFilesInDir(r11);
                            if (listListFilesInDir == null || listListFilesInDir.isEmpty()) {
                                h.f31061a.s(gVar.p(), r11);
                                prepareController.moveToError(new PrepareException(str2, "miniappzip error"));
                            } else {
                                f(r11, listListFilesInDir, r32, r22, iPackageResourceManager, "");
                                if (AppUtils.f31011a.g(r11.getMiniappSubtype())) {
                                    try {
                                        AppModel appModelH = gVar.h();
                                        if (appModelH != null) {
                                            List<File> listListFilesInDir2 = this.f31603e.listFilesInDir(appModelH);
                                            if (listListFilesInDir2 == null || listListFilesInDir2.isEmpty()) {
                                                h.f31061a.s(gVar.p(), appModelH);
                                                prepareController.moveToError(new PrepareException(str2, "miniappzip error"));
                                            } else {
                                                f(appModelH, listListFilesInDir2, obj2, r22, iPackageResourceManager, "");
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        prepareController.moveToError(new PrepareException(str2, th2.getMessage()));
                                        TmcLogger.c(this.f31599a, "资源文件出错");
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            prepareController.moveToError(new PrepareException(str2, th3.getMessage()));
                            TmcLogger.c(this.f31599a, "资源文件出错");
                        }
                    }
                } catch (Throwable unused) {
                    i.a(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION, "frameworkzip error", prepareController);
                    TmcLogger.c(this.f31599a, "请先下载框架包资源文件：");
                    r11 = obj3;
                    r17 = appModelE;
                    obj2 = obj5;
                    r21 = ListFilesInDir;
                    r22 = obj5;
                    r32 = r31;
                }
            } catch (Throwable unused2) {
                ListFilesInDir = "frameworkConfig.json error";
                obj5 = obj;
                str2 = r31;
                r31 = map;
                obj = "frameworkConfig 不存在：";
                obj3 = appModelE;
                appModelE = map2;
            }
        } catch (Throwable unused3) {
            obj = "frameworkConfig 不存在：";
            ListFilesInDir = "frameworkConfig.json error";
            obj3 = appModelE;
            str2 = r31;
            obj5 = map3;
            appModelE = map2;
            r31 = map;
        }
        AppLoadResult appLoadResult = new AppLoadResult();
        appLoadResult.appVersion = MiniAppLaunch.f31784a.O(r11);
        appLoadResult.mainHtmlUrl = "https://100000.miniapp.transsion.com/index.html";
        AppModel appModelH2 = gVar.h();
        if (appModelH2 != null) {
            appId = appModelH2.getAppId();
            if (appId != null && !appId.isEmpty()) {
                this.f31600b.updateAppModel(gVar.p(), appModelH2, appId + str4);
                try {
                    gVar.e().setCurrentUseCommonResVersion(appModelH2.getDeployVersion());
                } catch (Throwable unused4) {
                }
            }
        } else {
            appId = "";
        }
        String appId2 = r11.getAppId();
        Object obj6 = obj4;
        try {
            String str5 = (String) r32.get(obj6);
            if (str5 != null) {
                cls = cls2;
                try {
                    appLoadResult.appConfigModel = (MiniAppConfigModel) a0.f31025a.a(this.f31603e.readFile2String(iPackageResourceManager.getFilePath(appId2, str5)), cls);
                } catch (Throwable unused5) {
                    TmcLogger.c(this.f31599a, "appConfig不存在：");
                    str = str3;
                    prepareController.moveToError(new PrepareException(str, "appConfig.json error"));
                }
            } else {
                cls = cls2;
            }
            str = str3;
        } catch (Throwable unused6) {
            cls = cls2;
        }
        try {
            String str6 = (String) r17.get(obj6);
            if (str6 != null) {
                appLoadResult.frameworkConfigModel = (MiniAppConfigModel) a0.f31025a.a(this.f31603e.readFile2String(iPackageResourceManager.getFilePath("100000", str6)), cls);
            }
            r12 = obj;
            r13 = r21;
        } catch (Throwable unused7) {
            ?? r14 = r21;
            i.a(str, r14, prepareController);
            ?? r15 = obj;
            TmcLogger.c(this.f31599a, r15);
            r13 = r14;
            r12 = r15;
        }
        if (appId != null && !appId.isEmpty()) {
            try {
                String str7 = (String) obj2.get(obj6);
                if (str7 != null) {
                    appLoadResult.commonResAppConfigModel = (MiniAppConfigModel) a0.f31025a.a(this.f31603e.readFile2String(iPackageResourceManager.getFilePath(appId, str7)), cls);
                }
            } catch (Throwable unused8) {
                i.a(str, r13, prepareController);
                TmcLogger.c(this.f31599a, r12);
            }
        }
        appLoadResult.htmlMap = r22;
        appLoadResult.appType = "WEB_TINY";
        appLoadResult.frameWorkModel = gVar.l();
        new f(gVar).f70183d = appLoadResult;
        f fVar = new f(gVar);
        fVar.f70183d = appLoadResult;
        return fVar;
    }

    public final void f(AppModel appModel, List<File> list, Map<String, String> map, HashMap<String, String> map2, IPackageResourceManager iPackageResourceManager, String str) {
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    f(appModel, Arrays.asList(file.listFiles()), map, map2, iPackageResourceManager, str + "/" + file.getName());
                } else {
                    String strGenerateVUrl = iPackageResourceManager.generateVUrl(file.getAbsolutePath(), appModel.getAppId(), file.getName(), str);
                    StringBuilder sbA = j.a("StartStep:absPath:");
                    sbA.append(file.getAbsolutePath());
                    sbA.append(";vUrl:");
                    sbA.append(strGenerateVUrl);
                    TmcLogger.c("Subpackage::", sbA.toString());
                    map.put(file.getName(), strGenerateVUrl);
                    if (file.getName().toLowerCase().contains(".html")) {
                        map2.put(file.getName(), strGenerateVUrl);
                    }
                    String str2 = this.f31599a;
                    StringBuilder sbA2 = j.a("Step_LoadStep: tar包结构: ");
                    sbA2.append(file.getName());
                    TmcLogger.c(str2, sbA2.toString());
                    k.a("Step_LoadStep: tar包结构: ", strGenerateVUrl, this.f31599a);
                }
            }
        }
    }
}
