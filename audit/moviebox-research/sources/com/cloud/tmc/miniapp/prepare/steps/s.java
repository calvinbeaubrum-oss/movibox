package com.cloud.tmc.miniapp.prepare.steps;

import android.os.Bundle;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.integration.proxy.FileProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class s extends a {
    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, lb.g gVar, c0 c0Var) throws PrepareException {
        if (!gVar.r()) {
            try {
                MiniAppLaunch.f31784a.C(gVar.c(), "l_e");
            } catch (Throwable unused) {
            }
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31215i, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31217j, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.C, new Bundle());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.D, new Bundle());
            new xa.m(new Bundle()).f(gVar.b());
            new db.o(new Bundle()).f(gVar.b());
            if (gVar.a() != null) {
                OffScreenWebviewPool.f30871a.l(gVar.a(), this, gVar);
            }
        }
        if (com.cloud.tmc.integration.utils.h.f31061a.l(gVar.e())) {
            prepareController.moveToNext();
            return;
        }
        super.a(prepareController, gVar, c0Var);
        TmcLogger.c(this.f31599a, "Step_进度:LocalDataFileScanStep");
        String appBaseFilePath = ((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(gVar.c());
        File file = new File(appBaseFilePath, "local_data");
        File file2 = new File(appBaseFilePath, "temp_data");
        FileProxy fileProxy = (FileProxy) tc.a.a(FileProxy.class);
        try {
            boolean zI = com.cloud.tmc.miniutils.util.j.i(file);
            boolean zI2 = com.cloud.tmc.miniutils.util.j.i(file2);
            String str = this.f31599a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Creating local_data directory ");
            sb2.append(zI ? "successful" : "failed");
            TmcLogger.c(str, sb2.toString());
            String str2 = this.f31599a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Creating temp_data directory ");
            sb3.append(zI2 ? "successful" : "failed");
            TmcLogger.c(str2, sb3.toString());
            String strC = gVar.c();
            boolean zC = com.cloud.tmc.integration.utils.v.f31133a.c();
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(gVar.p(), strC, strC + "_scan_downgrade", zC);
            TmcLogger.f(this.f31599a, "LocalDataFileScanStep downgrade status = " + zC);
            if (!zC) {
                TmcLogger.f(this.f31599a, "skip LocalDataFileScanStep");
                prepareController.moveToNext();
                return;
            }
            List<File> listListFilesInDir = fileProxy.listFilesInDir(file.getAbsolutePath());
            List<File> listListFilesInDir2 = fileProxy.listFilesInDir(file2.getAbsolutePath());
            if (!listListFilesInDir.isEmpty() || !listListFilesInDir2.isEmpty()) {
                IFileResourceManager iFileResourceManager = (IFileResourceManager) tc.a.a(IFileResourceManager.class);
                d(gVar, fileProxy, iFileResourceManager, listListFilesInDir, "local_data");
                d(gVar, fileProxy, iFileResourceManager, listListFilesInDir2, "temp_data");
            }
            if (c0Var != null) {
                c0Var.j(gVar.m(), gVar.e(), gVar.q(), gVar.o());
            }
            prepareController.moveToNext();
        } catch (Exception e11) {
            prepareController.moveToError(new PrepareException(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN, "Resource file error: " + e11, e11));
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.FILE_SCAN;
    }

    public final void d(lb.g gVar, FileProxy fileProxy, IFileResourceManager iFileResourceManager, List<File> list, String str) {
        for (File file : list) {
            if (file.isDirectory()) {
                d(gVar, fileProxy, iFileResourceManager, fileProxy.listFilesInDir(file.getAbsolutePath()), str + "/" + file.getName());
            } else {
                String strGenerateVUrl = iFileResourceManager.generateVUrl(file.getAbsolutePath(), gVar.c(), file.getName(), str);
                String str2 = this.f31599a;
                StringBuilder sbA = hd.j.a("Step_LocalDataFileScanStep: fileName: ");
                sbA.append(file.getName());
                sbA.append(", vUrl: ");
                sbA.append(strGenerateVUrl);
                TmcLogger.c(str2, sbA.toString());
            }
        }
    }
}
