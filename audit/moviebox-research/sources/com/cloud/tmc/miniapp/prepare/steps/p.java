package com.cloud.tmc.miniapp.prepare.steps;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class p extends a {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(PrepareController prepareController, lb.g gVar, AppModel appModel, boolean z11, String str) {
        if (z11) {
            TmcLogger.c(this.f31599a, "Step_FW_LoadStep: zip 包解压完成");
            g(prepareController, gVar, appModel);
            return;
        }
        TmcLogger.c(this.f31599a, "zip 包解压失败，删除已下载数据");
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), "100000"));
        String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), "100000"));
        if (!TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && miniAppLaunch.u(strO, strO2)) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2).putData("mpu_result", "INSTALL_ZIP_FAIL"), "mpu_chain_uniqueId"), "");
        }
        com.cloud.tmc.integration.utils.h.f31061a.s(gVar.p(), appModel);
        StringBuilder sbA = hd.j.a(MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
        sbA.append(appModel.getPackageUrl());
        prepareController.moveToError(new PrepareException("5", sbA.toString()));
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, lb.g gVar, c0 c0Var) throws PrepareException {
        if (!gVar.r()) {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31207e, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31209f, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31237y, new Bundle());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31238z, new Bundle());
            new xa.h(new Bundle()).f(gVar.b());
            new db.j(new Bundle()).f(gVar.b());
        }
        com.cloud.tmc.integration.utils.h hVar = com.cloud.tmc.integration.utils.h.f31061a;
        if (hVar.l(gVar.e())) {
            prepareController.moveToNext();
            return;
        }
        super.a(prepareController, gVar, c0Var);
        prepareController.lock(prepareController);
        TmcLogger.c(this.f31599a, "Step_FW_进度:LoadStep");
        AppModel appModelL = gVar.l();
        if (hVar.q(gVar.p(), appModelL)) {
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), "100000"));
            String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), "100000"));
            if (!TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && miniAppLaunch.u(strO, strO2)) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModelL, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2), "mpu_chain_uniqueId"), "");
            }
            TmcLogger.c(this.f31599a, "Step_FW_LoadStep:tar包已解压，跳转到 startStep");
            prepareController.unlock(prepareController);
            prepareController.moveToNext();
            return;
        }
        TmcLogger.c(this.f31599a, "Step_FW_LoadStep:删除旧的已解压文件");
        this.f31603e.deleteFile(this.f31602d.getZipUnCompressPath(appModelL));
        TmcLogger.c(this.f31599a, "Step_FW_LoadStep:解压 zip 包");
        try {
            i(gVar, prepareController, appModelL);
        } catch (Throwable th2) {
            TmcLogger.h(this.f31599a, th2);
            StringBuilder sbA = hd.j.a("unzip error ");
            sbA.append(th2.getMessage());
            prepareController.moveToError(new PrepareException("5", sbA.toString()));
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.FW_LOAD;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00be  */
    /* JADX WARN: Code duplicated, block: B:60:0x01b1  */
    public final /* synthetic */ void f(AppModel appModel, lb.g gVar, Context context, PrepareController prepareController, boolean z11, String str) {
        String str2;
        String str3;
        Exception exc;
        String strO;
        String strO2;
        this = this;
        AppModel appModel2 = appModel;
        String str4 = "mpu_appId";
        String str5 = "100000";
        if (!z11) {
            TmcLogger.c(this.f31599a, "Step_FW_LoadStep: tar 包解压失败");
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            String strO3 = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), "100000"));
            String strO4 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), "100000"));
            if (!TextUtils.isEmpty(strO3) && !TextUtils.isEmpty(strO4) && miniAppLaunch.u(strO3, strO4)) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel2, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "mpu_appId", "mpu_old_v", strO3).putData("mpu_new_v", strO4).putData("mpu_result", "INSTALL_APP_FAIL"), "mpu_chain_uniqueId"), "");
            }
            com.cloud.tmc.integration.utils.h.f31061a.s(context, appModel2);
            prepareController.moveToError(new PrepareException("5", h.a.a(MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR, str)));
            return;
        }
        try {
            com.cloud.tmc.integration.utils.h hVar = com.cloud.tmc.integration.utils.h.f31061a;
            str3 = "manifest error";
            try {
                String strT = hVar.t(appModel2);
                str2 = PrepareException.ERROR_MANIFEST_INFO;
                try {
                    if (com.cloud.tmc.integration.utils.a0.f31025a.b(strT, PushConstants.PROVIDER_FIELD_APP_ID).equals(appModel.getAppId())) {
                        TmcLogger.c(this.f31599a, "Step_FW_LoadStep: tar 包解压完成");
                        hVar.m(context, appModel2, true);
                        this.f31603e.delectDownloadFileForVersion(appModel2);
                        this.f31600b.delectOldVersionFilesAndUpdate(context, appModel2);
                        MiniAppLaunch miniAppLaunch2 = MiniAppLaunch.f31784a;
                        String strO5 = miniAppLaunch2.O(this.f31600b.getAppModelFromUsed(gVar.p(), "100000"));
                        String strO6 = miniAppLaunch2.O(this.f31600b.getAppModelFromPre(gVar.p(), "100000"));
                        if (!TextUtils.isEmpty(strO5) && !TextUtils.isEmpty(strO6) && miniAppLaunch2.u(strO5, strO6)) {
                            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel2, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, "mpu_appId", "mpu_old_v", strO5).putData("mpu_new_v", strO6), "mpu_chain_uniqueId"), "");
                        }
                        prepareController.unlock(prepareController);
                        prepareController.moveToNext();
                        return;
                    }
                    try {
                        MiniAppLaunch miniAppLaunch3 = MiniAppLaunch.f31784a;
                        String strO7 = miniAppLaunch3.O(this.f31600b.getAppModelFromUsed(gVar.p(), "100000"));
                        String strO8 = miniAppLaunch3.O(this.f31600b.getAppModelFromPre(gVar.p(), "100000"));
                        if (TextUtils.isEmpty(strO7)) {
                            str5 = "100000";
                        } else {
                            try {
                                if (TextUtils.isEmpty(strO8) || !miniAppLaunch3.u(strO7, strO8)) {
                                    str5 = "100000";
                                } else {
                                    str5 = "100000";
                                    try {
                                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL.putData("mpu_appId", appModel.getAppId()).putData("mpu_old_v", strO7).putData("mpu_new_v", strO8).putData("mpu_result", "MANIFEST_FAIL").putData("mpu_chain_uniqueId", gVar.q().getString("uniqueChainID", "-1")), "");
                                    } catch (Exception e11) {
                                        e = e11;
                                        appModel2 = appModel;
                                        exc = e;
                                        str4 = "mpu_appId";
                                        str3 = str3;
                                        str5 = str5;
                                        gVar = gVar;
                                        MiniAppLaunch miniAppLaunch4 = MiniAppLaunch.f31784a;
                                        String str6 = str3;
                                        strO = miniAppLaunch4.O(this.f31600b.getAppModelFromUsed(gVar.p(), str5));
                                        strO2 = miniAppLaunch4.O(this.f31600b.getAppModelFromPre(gVar.p(), str5));
                                        if (!TextUtils.isEmpty(strO)) {
                                            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel2, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, str4, "mpu_old_v", strO).putData("mpu_new_v", strO2).putData("mpu_result", "MANIFEST_FAIL"), "mpu_chain_uniqueId"), "");
                                        }
                                        com.cloud.tmc.integration.utils.h.f31061a.s(context, appModel2);
                                        StringBuilder sbA = hd.j.a(str6);
                                        sbA.append(exc.getMessage());
                                        prepareController.moveToError(new PrepareException(str2, sbA.toString()));
                                    }
                                }
                            } catch (Exception e12) {
                                e = e12;
                                str5 = "100000";
                            }
                        }
                        appModel2 = appModel;
                        try {
                            hVar.s(context, appModel2);
                            str3 = str3;
                            try {
                                try {
                                    prepareController.moveToError(new PrepareException(str2, str3));
                                } catch (Exception e13) {
                                    e = e13;
                                    exc = e;
                                    str2 = str2;
                                    gVar = gVar;
                                    MiniAppLaunch miniAppLaunch5 = MiniAppLaunch.f31784a;
                                    String str7 = str3;
                                    strO = miniAppLaunch5.O(this.f31600b.getAppModelFromUsed(gVar.p(), str5));
                                    strO2 = miniAppLaunch5.O(this.f31600b.getAppModelFromPre(gVar.p(), str5));
                                    if (!TextUtils.isEmpty(strO)) {
                                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel2, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, str4, "mpu_old_v", strO).putData("mpu_new_v", strO2).putData("mpu_result", "MANIFEST_FAIL"), "mpu_chain_uniqueId"), "");
                                    }
                                    com.cloud.tmc.integration.utils.h.f31061a.s(context, appModel2);
                                    StringBuilder sbA2 = hd.j.a(str7);
                                    sbA2.append(exc.getMessage());
                                    prepareController.moveToError(new PrepareException(str2, sbA2.toString()));
                                }
                            } catch (Exception e14) {
                                e = e14;
                            }
                        } catch (Exception e15) {
                            e = e15;
                            str5 = str5;
                            exc = e;
                            gVar = gVar;
                            MiniAppLaunch miniAppLaunch6 = MiniAppLaunch.f31784a;
                            String str8 = str3;
                            strO = miniAppLaunch6.O(this.f31600b.getAppModelFromUsed(gVar.p(), str5));
                            strO2 = miniAppLaunch6.O(this.f31600b.getAppModelFromPre(gVar.p(), str5));
                            if (!TextUtils.isEmpty(strO)) {
                                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel2, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, str4, "mpu_old_v", strO).putData("mpu_new_v", strO2).putData("mpu_result", "MANIFEST_FAIL"), "mpu_chain_uniqueId"), "");
                            }
                            com.cloud.tmc.integration.utils.h.f31061a.s(context, appModel2);
                            StringBuilder sbA3 = hd.j.a(str8);
                            sbA3.append(exc.getMessage());
                            prepareController.moveToError(new PrepareException(str2, sbA3.toString()));
                        }
                    } catch (Exception e16) {
                        e = e16;
                        appModel2 = appModel2;
                        str5 = "100000";
                    }
                } catch (Exception e17) {
                    e = e17;
                    str3 = str3;
                    exc = e;
                    MiniAppLaunch miniAppLaunch7 = MiniAppLaunch.f31784a;
                    String str9 = str3;
                    strO = miniAppLaunch7.O(this.f31600b.getAppModelFromUsed(gVar.p(), str5));
                    strO2 = miniAppLaunch7.O(this.f31600b.getAppModelFromPre(gVar.p(), str5));
                    if (!TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && miniAppLaunch7.u(strO, strO2)) {
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel2, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, str4, "mpu_old_v", strO).putData("mpu_new_v", strO2).putData("mpu_result", "MANIFEST_FAIL"), "mpu_chain_uniqueId"), "");
                    }
                    com.cloud.tmc.integration.utils.h.f31061a.s(context, appModel2);
                    StringBuilder sbA4 = hd.j.a(str9);
                    sbA4.append(exc.getMessage());
                    prepareController.moveToError(new PrepareException(str2, sbA4.toString()));
                }
            } catch (Exception e18) {
                e = e18;
                str2 = PrepareException.ERROR_MANIFEST_INFO;
            }
        } catch (Exception e19) {
            e = e19;
            str2 = PrepareException.ERROR_MANIFEST_INFO;
            str5 = "100000";
            str3 = "manifest error";
            str4 = "mpu_appId";
            gVar = gVar;
        }
    }

    public final void g(final PrepareController prepareController, final lb.g gVar, final AppModel appModel) {
        final Context contextP = gVar.p();
        TmcLogger.c(this.f31599a, "Step_FW_LoadStep: sha256 校验");
        com.cloud.tmc.integration.utils.h hVar = com.cloud.tmc.integration.utils.h.f31061a;
        if (hVar.p(appModel)) {
            TmcLogger.c(this.f31599a, "Step_FW_LoadStep: sha256 校验正确，解压 tar 包");
            this.f31601c.installApp(appModel, new ua.o() { // from class: com.cloud.tmc.miniapp.prepare.steps.o
                @Override // ua.o
                public final void a(boolean z11, String str) {
                    this.f31630a.f(appModel, gVar, contextP, prepareController, z11, str);
                }
            });
            return;
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), "100000"));
        String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), "100000"));
        if (!TextUtils.isEmpty(strO) && !TextUtils.isEmpty(strO2) && miniAppLaunch.u(strO, strO2)) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", e.a(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2).putData("mpu_result", "SIGN_FAIL"), "mpu_chain_uniqueId"), "");
        }
        TmcLogger.c(this.f31599a, "Step_FW_LoadStep: sha256 校验不一致，删除所有缓存");
        hVar.s(contextP, appModel);
        StringBuilder sbA = x.a.a(appModel, hd.j.a("sign error"), "   ");
        sbA.append(appModel.getPackageUrl());
        prepareController.moveToError(new PrepareException("7", sbA.toString()));
    }

    public final void i(final lb.g gVar, final PrepareController prepareController, final AppModel appModel) {
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
        bundle.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31202b0, 2);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        this.f31601c.installZip(gVar.p(), appModel, new ua.o() { // from class: com.cloud.tmc.miniapp.prepare.steps.n
            @Override // ua.o
            public final void a(boolean z11, String str) {
                this.f31626a.h(prepareController, gVar, appModel, z11, str);
            }
        });
    }
}
