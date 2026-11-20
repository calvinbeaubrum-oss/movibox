package u;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.utils.a0;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prepare.steps.f;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.transsion.push.PushConstants;
import hd.j;
import lb.g;
import ua.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends a0.a {
    @Override // a0.a
    public void d(PrepareController prepareController, g gVar, c0 c0Var) {
        AppModel appModelE = gVar.e();
        if (h.f31061a.q(gVar.p(), appModelE)) {
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c()));
            String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), gVar.c()));
            if (!TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && miniAppLaunch.D(strO2, strO)) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", com.cloud.tmc.miniapp.prepare.steps.e.a(appModelE, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2), "mpu_chain_uniqueId"), "");
            }
            TmcLogger.c(this.f31599a, "Step_LoadStep:tar包已解压，跳转到 startStep");
            prepareController.unlock(prepareController);
            prepareController.moveToNext();
            return;
        }
        TmcLogger.c(this.f31599a, "Step_LoadStep:删除旧的已解压文件");
        this.f31603e.deleteFile(this.f31602d.getZipUnCompressPath(appModelE));
        TmcLogger.c(this.f31599a, "Step_LoadStep:解压 zip 包");
        try {
            j(gVar, prepareController, appModelE);
            c0Var.i(LoadStepAction.STEP_FINISH_DECOMPRESS);
        } catch (Throwable th2) {
            TmcLogger.h(this.f31599a, th2);
            StringBuilder sbA = j.a(MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
            sbA.append(th2.getMessage());
            prepareController.moveToError(new PrepareException("5", sbA.toString()));
        }
    }

    public final /* synthetic */ void g(AppModel appModel, Context context, PrepareController prepareController, g gVar, boolean z11, String str) {
        String str2;
        String str3;
        String str4 = "manifest error";
        String str5 = PrepareException.ERROR_MANIFEST_INFO;
        String str6 = "mpu_chain_uniqueId";
        if (!z11) {
            TmcLogger.c(this.f31599a, "Step_LoadStep: tar 包解压失败，删除数据");
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c()));
            String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), gVar.c()));
            if (!TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && miniAppLaunch.D(strO2, strO)) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", com.cloud.tmc.miniapp.prepare.steps.e.a(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2).putData("mpu_result", "INSTALL_APP_FAIL"), "mpu_chain_uniqueId"), "");
            }
            h.f31061a.s(context, appModel);
            StringBuilder sbA = j.a(MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
            sbA.append(appModel.getPackageUrl());
            prepareController.moveToError(new PrepareException("5", sbA.toString()));
            return;
        }
        TmcLogger.c(this.f31599a, "Step_LoadStep: tar 包解压完成");
        try {
            h hVar = h.f31061a;
            try {
                try {
                    if (a0.f31025a.b(hVar.t(appModel), PushConstants.PROVIDER_FIELD_APP_ID).equals(appModel.getAppId())) {
                        MiniAppLaunch miniAppLaunch2 = MiniAppLaunch.f31784a;
                        String strO3 = miniAppLaunch2.O(this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c()));
                        String strO4 = miniAppLaunch2.O(this.f31600b.getAppModelFromPre(gVar.p(), gVar.c()));
                        if (!TextUtils.isEmpty(strO3) && !TextUtils.isEmpty(strO4) && miniAppLaunch2.D(strO4, strO3)) {
                            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", com.cloud.tmc.miniapp.prepare.steps.e.a(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, "mpu_appId", "mpu_old_v", strO3).putData("mpu_new_v", strO4), "mpu_chain_uniqueId"), "");
                        }
                        TmcLogger.c(this.f31599a, "Step_LoadStep: manifest 内容校验成功");
                        hVar.m(context, appModel, true);
                        this.f31603e.delectDownloadFileForVersion(appModel);
                        this.f31600b.delectOldVersionFilesAndUpdate(context, appModel);
                        prepareController.unlock(prepareController);
                        prepareController.moveToNext();
                        return;
                    }
                    try {
                        hVar.s(context, appModel);
                        prepareController.moveToError(new PrepareException(PrepareException.ERROR_MANIFEST_INFO, "manifest error"));
                        MiniAppLaunch miniAppLaunch3 = MiniAppLaunch.f31784a;
                        String strO5 = miniAppLaunch3.O(this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c()));
                        str4 = "manifest error";
                        try {
                            String strO6 = miniAppLaunch3.O(this.f31600b.getAppModelFromPre(gVar.p(), gVar.c()));
                            if (TextUtils.isEmpty(strO5) || TextUtils.isEmpty(strO6) || !miniAppLaunch3.D(strO6, strO5)) {
                                return;
                            }
                            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                            String strC = gVar.c();
                            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL;
                            str5 = PrepareException.ERROR_MANIFEST_INFO;
                            try {
                                PointAnalyseType pointAnalyseTypePutData = pointAnalyseType.putData("mpu_appId", appModel.getAppId()).putData("mpu_old_v", strO5).putData("mpu_new_v", strO6).putData("mpu_result", "MANIFEST_FAIL");
                                str2 = "-1";
                                try {
                                    str6 = "mpu_chain_uniqueId";
                                    try {
                                        str3 = "";
                                        try {
                                            performanceAnalyseProxy.record(strC, pointAnalyseTypePutData.putData(str6, gVar.q().getString("uniqueChainID", str2)), str3);
                                            return;
                                        } catch (Throwable unused) {
                                        }
                                    } catch (Throwable unused2) {
                                        str3 = "";
                                    }
                                } catch (Throwable unused3) {
                                    str3 = "";
                                    str6 = "mpu_chain_uniqueId";
                                }
                            } catch (Throwable unused4) {
                                str3 = "";
                                str6 = "mpu_chain_uniqueId";
                                str2 = "-1";
                            }
                        } catch (Throwable unused5) {
                            str5 = PrepareException.ERROR_MANIFEST_INFO;
                            str6 = "mpu_chain_uniqueId";
                            str2 = "-1";
                        }
                    } catch (Throwable unused6) {
                        str4 = "manifest error";
                    }
                    str3 = "";
                    MiniAppLaunch miniAppLaunch4 = MiniAppLaunch.f31784a;
                    String strO7 = miniAppLaunch4.O(this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c()));
                    String strO8 = miniAppLaunch4.O(this.f31600b.getAppModelFromPre(gVar.p(), gVar.c()));
                    if (!TextUtils.isEmpty(strO7) && !TextUtils.isEmpty(strO8) && miniAppLaunch4.D(strO8, strO7)) {
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", str2, com.cloud.tmc.miniapp.prepare.steps.e.a(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "mpu_appId", "mpu_old_v", strO7).putData("mpu_new_v", strO8).putData("mpu_result", "MANIFEST_FAIL"), str6), str3);
                    }
                    h.f31061a.s(context, appModel);
                    prepareController.moveToError(new PrepareException(str5, str4));
                } catch (Throwable unused7) {
                    str6 = "mpu_chain_uniqueId";
                    str2 = "-1";
                    str3 = "";
                }
            } catch (Throwable unused8) {
                str2 = "-1";
                str6 = "mpu_chain_uniqueId";
            }
        } catch (Throwable unused9) {
            str2 = "-1";
        }
    }

    public final void h(final PrepareController prepareController, final g gVar, final AppModel appModel) {
        final Context contextP = gVar.p();
        TmcLogger.c(this.f31599a, "Step_LoadStep: sha256 校验");
        h hVar = h.f31061a;
        if (hVar.p(appModel)) {
            TmcLogger.c(this.f31599a, "Step_LoadStep: sha256 校验正确，解压 tar 包");
            this.f31601c.installApp(appModel, new o() { // from class: u.c
                @Override // ua.o
                public final void a(boolean z11, String str) {
                    this.f78099a.g(appModel, contextP, prepareController, gVar, z11, str);
                }
            });
            return;
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c()));
        String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), gVar.c()));
        if (!TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && miniAppLaunch.D(strO2, strO)) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", com.cloud.tmc.miniapp.prepare.steps.e.a(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2).putData("mpu_result", "SIGN_FAIL"), "mpu_chain_uniqueId"), "");
        }
        TmcLogger.c(this.f31599a, "Step_LoadStep: sha256 校验不一致，删除所有缓存");
        hVar.s(contextP, appModel);
        StringBuilder sbA = x.a.a(appModel, j.a("sign error"), "   ");
        sbA.append(appModel.getPackageUrl());
        prepareController.moveToError(new PrepareException("7", sbA.toString()));
    }

    public final /* synthetic */ void i(PrepareController prepareController, g gVar, AppModel appModel, boolean z11, String str) {
        if (z11) {
            TmcLogger.c(this.f31599a, "Step_LoadStep: zip 包解压完成");
            h(prepareController, gVar, appModel);
            return;
        }
        TmcLogger.c(this.f31599a, "Step_LoadStep: zip 包解压失败");
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), gVar.c()));
        String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), gVar.c()));
        if (!TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && miniAppLaunch.D(strO2, strO)) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", com.cloud.tmc.miniapp.prepare.steps.e.a(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2).putData("mpu_result", "INSTALL_ZIP_FAIL"), "mpu_chain_uniqueId"), "");
        }
        h.f31061a.s(gVar.p(), appModel);
        StringBuilder sbA = j.a(MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
        sbA.append(appModel.getPackageUrl());
        prepareController.moveToError(new PrepareException("5", sbA.toString()));
    }

    public final void j(final g gVar, final PrepareController prepareController, final AppModel appModel) {
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        com.cloud.tmc.miniapp.prepare.steps.b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
        bundle.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31206d0, 2);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        this.f31601c.installZip(gVar.p(), appModel, new o() { // from class: u.b
            @Override // ua.o
            public final void a(boolean z11, String str) {
                this.f78095a.i(prepareController, gVar, appModel, z11, str);
            }
        });
    }
}
