package com.cloud.tmc.miniapp.prepare.steps;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.miniapp.GlobalPackageConfig;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.google.gson.reflect.TypeToken;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.transsion.push.PushConstants;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class m extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f31625h = false;

    public static /* synthetic */ Unit d(lb.g gVar, String str, String str2) {
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.putData("mpu_download_type", "async").putData("mpu_appId", "100000").putData("mpu_old_v", str).putData("mpu_new_v", str2), "mpu_chain_uniqueId"), "");
        return null;
    }

    public static /* synthetic */ Unit e(lb.g gVar, String str, String str2, String str3, String str4, IOException iOException) {
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_DOWNLOAD_FAILED.putData("mpu_download_type", "async").putData("mpu_appId", "100000").putData("mpu_old_v", str).putData("mpu_new_v", str2).putData("mpu_result", iOException.getClass().getSimpleName()).putData("mpu_error_code", str3).putData("mpu_error_msg", iOException.getMessage()), "mpu_chain_uniqueId"), "");
        return null;
    }

    public static /* synthetic */ Unit g(lb.g gVar, String str, String str2) {
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.putData("mpu_download_type", "async").putData("mpu_appId", "100000").putData("mpu_old_v", str).putData("mpu_new_v", str2).putData("mpu_result", "IOException").putData("mpu_error_code", "D006").putData("mpu_error_msg", "Canceled"), "mpu_chain_uniqueId"), "");
        return null;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(final PrepareController prepareController, final lb.g gVar, final c0 c0Var) throws PrepareException {
        boolean z11;
        int i11;
        AppModel appModelFromDev;
        if (!gVar.r()) {
            Bundle bundle = new Bundle();
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31203c, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31205d, bundle);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31235w, new Bundle());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31236x, new Bundle());
            new xa.r(new Bundle()).f(gVar.b());
            new db.i(new Bundle()).f(gVar.b());
            if (gVar.a() != null) {
                OffScreenWebviewPool.f30871a.l(gVar.a(), this, gVar);
            }
        }
        if (com.cloud.tmc.integration.utils.h.f31061a.l(gVar.e())) {
            prepareController.moveToNext();
            Bundle bundle2 = new Bundle();
            bundle2.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Y, 1);
            if (gVar.r()) {
                return;
            }
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle2);
            return;
        }
        super.a(prepareController, gVar, c0Var);
        TmcLogger.c(this.f31599a, "Step_FW_UPDATE");
        gVar.t(new lb.a("100000"));
        if (AppDynamicBuildConfig.k() && (appModelFromDev = this.f31600b.getAppModelFromDev(gVar.p(), "100000")) != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Y, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle3);
            }
            gVar.A(appModelFromDev);
            prepareController.moveToNext();
            return;
        }
        long lastUpdateTime = this.f31600b.getLastUpdateTime(gVar.p(), "100000");
        TmcLogger.c(this.f31599a, "Step_FW_UPDATE_获取最近的更新时间:" + lastUpdateTime);
        long jCurrentTimeMillis = System.currentTimeMillis();
        final AppModel appModel = this.f31600b.getAppModel(gVar.p(), gVar.d());
        if (appModel == null) {
            this.f31625h = true;
        } else {
            if (appModel.getFromCacheType() == 3 || appModel.getFromCacheType() == 4) {
                MiniAppLaunch.f31784a.o(appModel);
            }
            gVar.A(appModel);
        }
        TmcLogger.c(this.f31599a, "Step_FW_UPDATE:检查fwModel" + appModel);
        String lowestSupportVersion = gVar.e().getLowestSupportVersion();
        if (appModel != null) {
            if (TextUtils.isEmpty(lowestSupportVersion)) {
                lowestSupportVersion = "";
            }
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            String strO = miniAppLaunch.O(appModel);
            if (TextUtils.isEmpty(strO)) {
                strO = "";
            }
            boolean zD = miniAppLaunch.D(lowestSupportVersion, strO);
            if (zD) {
                TmcLogger.c(this.f31599a, "focuseUpdate->" + lowestSupportVersion + "deployVersion->" + strO);
                c0Var.OooO00o(true);
                this.f31625h = true;
            }
            z11 = zD;
        } else {
            z11 = false;
        }
        int configInt = ((ConfigService) tc.a.a(ConfigService.class)).getConfigInt("fwRefreshInterval", 3600) * 1000;
        if (appModel != null && jCurrentTimeMillis - lastUpdateTime <= configInt && lastUpdateTime != 0 && !z11) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Y, 1);
            if (!gVar.r()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle4);
            }
            gVar.A(appModel);
            TmcLogger.c(this.f31599a, "STEP_FRAMEWORK_UPDATE_数据在有效期内");
            prepareController.moveToNext();
            return;
        }
        Bundle bundle5 = new Bundle();
        TmcLogger.c(this.f31599a, "Step_FW_UPDATE: updateFrameWorkInfo 更新数据");
        if (this.f31625h) {
            TmcLogger.c(this.f31599a, "Step_FW_UPDATE:LOCK");
            prepareController.lock(prepareController);
            i11 = 2;
        } else {
            i11 = 1;
        }
        bundle5.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Y, i11);
        if (!gVar.r()) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle5);
        }
        if (NetworkUtils.r()) {
            HashMap map = new HashMap();
            map.put(PushConstants.PROVIDER_FIELD_APP_ID, "100000");
            map.put("frameVersionPrefix", MiniAppLaunch.f31784a.T(GlobalPackageConfig.Companion.b()));
            ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).postJson(mb.d.e(), new HashMap(), null, map, Boolean.TRUE, new mb.c<AppInfoModel>() { // from class: com.cloud.tmc.miniapp.prepare.steps.FwResInfoUpdateStep$1
                @Override // mb.c
                @NonNull
                public Type d() {
                    return new TypeToken<BaseResponse<AppInfoModel>>(this) { // from class: com.cloud.tmc.miniapp.prepare.steps.FwResInfoUpdateStep$1.1
                    }.getType();
                }

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
                @Override // mb.c
                public void e(@NonNull BaseResponse<?> baseResponse, @Nullable Map<String, String> map2) {
                    TmcLogger.c(this.f31572e.f31599a, "Step_FRAMEWORK_UPDATE_数据更新失败");
                    if (this.f31572e.f31625h) {
                        PrepareController prepareController2 = prepareController;
                        prepareController2.unlock(prepareController2);
                    }
                    AppModel appModel2 = appModel;
                    if (appModel2 == null) {
                        prepareController.moveToError(MiniAppLaunch.m0("100000", baseResponse.getCode(), baseResponse.getMessage()));
                        return;
                    }
                    gVar.A(appModel2);
                    m mVar = this.f31572e;
                    if (mVar.f31625h) {
                        TmcLogger.c(mVar.f31599a, "Step_FRAMEWORK_UPDATE_同步跳转");
                        prepareController.moveToNext();
                    }
                }

                @Override // mb.c
                public void g(@NonNull BaseResponse<? extends AppInfoModel> baseResponse, @Nullable Map<String, String> map2) {
                    AppInfoModel data = baseResponse.getData();
                    if (data == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(data.getAppId())) {
                        e(new BaseResponse<>(), null);
                    } else {
                        this.f31572e.f(data, appModel, gVar, prepareController);
                    }
                }
            });
        } else if (this.f31625h) {
            i.a("3", MBridgeError.ERROR_MESSAGE_DOWNLOAD_NETWORK_ERROR, prepareController);
            return;
        }
        if (this.f31625h) {
            return;
        }
        TmcLogger.c(this.f31599a, "Step_FW_UPDATE:UNLOCK 跳转到下一流程");
        prepareController.moveToNext();
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.FW_UPDATE;
    }

    public final void f(AppInfoModel appInfoModel, AppModel appModel, final lb.g gVar, PrepareController prepareController) {
        boolean zU;
        if (appModel != null) {
            zU = MiniAppLaunch.f31784a.u(appModel.getDeployVersion(), appInfoModel.getDeployVersion());
        } else {
            zU = true;
        }
        AppModel appModelG = MiniAppLaunch.f31784a.G(appInfoModel);
        if (this.f31625h) {
            TmcLogger.c(this.f31599a, "Step_FRAMEWORK_UPDATE_网络请求刷新FrameWorkModel");
            gVar.A(appModelG);
        }
        if (this.f31625h || zU) {
            this.f31600b.updateAppModel(gVar.p(), appModelG, appModelG.getAppId() + "_pre");
        }
        this.f31600b.refreshUpdateTime(gVar.p(), "100000", System.currentTimeMillis());
        if (this.f31625h) {
            TmcLogger.c(this.f31599a, "Step_FRAMEWORK_UPDATE_网络请求刷新同步解锁");
            prepareController.unlock(prepareController);
        }
        TmcLogger.c(this.f31599a, "STEP_FRAMEWORK_UPDATE_数据更新成功");
        String str = this.f31599a;
        StringBuilder sbA = hd.j.a("STEP_FRAMEWORK_UPDATE_");
        sbA.append(this.f31625h);
        TmcLogger.c(str, sbA.toString());
        if (this.f31625h) {
            TmcLogger.c(this.f31599a, "Step_FRAMEWORK_UPDATE_网络请求刷新同步跳转");
            prepareController.moveToNext();
            return;
        }
        if (zU && !this.f31601c.isDownloaded(gVar.p(), appModelG)) {
            try {
                if (MiniAppConfigHelper.f30370a.b("enableAppinfoDownload", true)) {
                    TmcAppInfoManager tmcAppInfoManager = this.f31600b;
                    if (tmcAppInfoManager != null) {
                        if (tmcAppInfoManager.getAppModelFromUsed(gVar.p(), "100000") == null) {
                        }
                    }
                    TmcLogger.c(this.f31599a, "no native used version,not background download");
                    return;
                }
            } catch (Throwable unused) {
            }
            TmcLogger.c(this.f31599a, "Step_FRAMEWORK_UPDATE_后台下载新的 fw 包");
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            if (miniAppLaunch.z(appModelG.getPackageSize())) {
                return;
            }
            final String strO = miniAppLaunch.O(this.f31600b.getAppModelFromUsed(gVar.p(), "100000"));
            final String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), "100000"));
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), f.a(gVar, "uniqueChainID", "-1", PointAnalyseType.POINT_PACKAGE_DOWNLOAD_START.putData("mpu_download_type", "async").putData("mpu_appId", "100000").putData("mpu_old_v", strO).putData("mpu_new_v", strO2), "mpu_chain_uniqueId"), "");
            miniAppLaunch.j(gVar.p().getApplicationContext(), appModelG, 1, new Function0() { // from class: com.cloud.tmc.miniapp.prepare.steps.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return m.d(gVar, strO, strO2);
                }
            }, new Function3() { // from class: com.cloud.tmc.miniapp.prepare.steps.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return m.e(gVar, strO, strO2, (String) obj, (String) obj2, (IOException) obj3);
                }
            }, new Function0() { // from class: com.cloud.tmc.miniapp.prepare.steps.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return m.g(gVar, strO, strO2);
                }
            });
        }
    }
}
