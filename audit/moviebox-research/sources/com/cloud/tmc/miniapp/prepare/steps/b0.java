package com.cloud.tmc.miniapp.prepare.steps;

import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b0 extends a {
    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, lb.g gVar, c0 c0Var) throws PrepareException {
        super.a(prepareController, gVar, c0Var);
        new HashMap();
        HashMap map = new HashMap();
        HashMap<String, String> map2 = new HashMap<>();
        IPackageResourceManager iPackageResourceManager = (IPackageResourceManager) tc.a.a(IPackageResourceManager.class);
        try {
            d(gVar.l(), this.f31603e.listFilesInDir(gVar.l()), map, map2, iPackageResourceManager, "");
        } catch (Exception unused) {
            i.a(PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION, "framework zip error", prepareController);
            TmcLogger.c(this.f31599a, "请先下载框架包资源文件：");
        }
        AppLoadResult appLoadResult = new AppLoadResult();
        appLoadResult.mainHtmlUrl = "https://100000.miniapp.transsion.com/index.html";
        try {
            String str = (String) map.get("appConfig.json");
            if (str != null) {
                appLoadResult.frameworkConfigModel = (MiniAppConfigModel) com.cloud.tmc.integration.utils.a0.f31025a.a(this.f31603e.readFile2String(iPackageResourceManager.getFilePath("100000", str)), MiniAppConfigModel.class);
            }
        } catch (Exception unused2) {
            i.a(PrepareException.ERROR_MANIFEST_INFO, "frameworkConfig.json error", prepareController);
            TmcLogger.c(this.f31599a, "frameworkConfig 不存在：");
        }
        appLoadResult.htmlMap = map2;
        appLoadResult.appType = "WEB_TINY";
        lb.f fVar = new lb.f(gVar);
        fVar.f70183d = appLoadResult;
        if (gVar.l() != null) {
            fVar.b(MiniAppLaunch.f31784a.O(gVar.l()));
        }
        c0Var.c(fVar, gVar.q().getInt("warmupType"));
        prepareController.finish();
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.WARMUP;
    }

    public final void d(AppModel appModel, List<File> list, Map<String, String> map, HashMap<String, String> map2, IPackageResourceManager iPackageResourceManager, String str) {
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    d(appModel, Arrays.asList(file.listFiles()), map, map2, iPackageResourceManager, str + "/" + file.getName());
                } else {
                    String strGenerateVUrl = iPackageResourceManager.generateVUrl(file.getAbsolutePath(), appModel.getAppId(), file.getName(), str);
                    StringBuilder sbA = hd.j.a("WarmupStep:absPath:");
                    sbA.append(file.getAbsolutePath());
                    sbA.append(";vUrl:");
                    sbA.append(strGenerateVUrl);
                    TmcLogger.c("Subpackage::", sbA.toString());
                    map.put(file.getName(), strGenerateVUrl);
                    if (file.getName().toLowerCase().contains(".html")) {
                        map2.put(file.getName(), strGenerateVUrl);
                    }
                    String str2 = this.f31599a;
                    StringBuilder sbA2 = hd.j.a("Step_WarmupStep: tar包结构: ");
                    sbA2.append(file.getName());
                    TmcLogger.c(str2, sbA2.toString());
                    hd.k.a("Step_WarmupStep: tar包结构: ", strGenerateVUrl, this.f31599a);
                }
            }
        }
    }
}
