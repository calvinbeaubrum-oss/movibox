package z;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.utils.k0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import hd.j;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import ua.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends a0.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f81660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f81661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f81662k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f81663l;

    public d(String str, Integer num) {
        this.f81660i = str;
        this.f81661j = num;
        this.f81662k = new i();
    }

    public /* synthetic */ d(String str, Integer num, int i11) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 1 : null);
    }

    public static final void h(d this$0, PrepareController controller, lb.g context, AppModel appModel, String identificationEncryptionUrl, boolean z11, String str) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(controller, "$controller");
        Intrinsics.g(context, "$context");
        Intrinsics.g(appModel, "$appModel");
        Intrinsics.g(identificationEncryptionUrl, "$identificationEncryptionUrl");
        if (!z11) {
            this$0.e(context, appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "INSTALL_ZIP_FAIL");
            this$0.g(context, controller, appModel, "5", MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR + appModel.getPackageUrl());
            return;
        }
        TmcLogger.c(this$0.f31599a, "Step_LoadStep: zip 包解压完成");
        Context contextP = context.p();
        TmcLogger.c(this$0.f31599a, "Step_LoadStep: sha256 校验");
        k0 k0Var = k0.f31068a;
        if (k0Var.p(appModel, this$0.f81662k.e())) {
            TmcLogger.c(this$0.f31599a, "Step_LoadStep: sha256 校验正确，解压 tar 包");
            this$0.f31601c.installApp(appModel, false, this$0.f81662k.e(), new c(this$0, appModel, identificationEncryptionUrl, contextP, controller, context));
            return;
        }
        this$0.e(context, appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "SIGN_FAIL");
        TmcLogger.c(this$0.f31599a, "Step_LoadStep: sha256 校验不一致，删除所有缓存");
        k0Var.r(contextP, appModel, identificationEncryptionUrl);
        StringBuilder sbA = x.a.a(appModel, j.a("sign error"), "   ");
        sbA.append(appModel.getPackageUrl());
        controller.moveToError(new PrepareException("7", sbA.toString()));
    }

    @Override // a0.a
    public void d(PrepareController controller, lb.g context, c0 callback) {
        Intrinsics.g(controller, "controller");
        Intrinsics.g(context, "context");
        Intrinsics.g(callback, "callback");
        try {
            AppModel appModelE = context.e();
            this.f81662k.d(appModelE, this.f81660i, context, this.f81661j);
            String strB = this.f81662k.b(appModelE);
            this.f81663l = strB;
            if (appModelE != null && strB != null && strB.length() != 0) {
                k0 k0Var = k0.f31068a;
                if (!k0Var.q(context.p(), appModelE.getAppId(), strB)) {
                    TmcLogger.c(this.f31599a, "Step_LoadStep:删除旧的已解压文件");
                    this.f31603e.deleteFile(this.f31602d.getZipUnCompressPath(appModelE.getAppId(), strB));
                    TmcLogger.c(this.f31599a, "Step_LoadStep:解压 zip 包");
                    try {
                        f(context, controller, appModelE, strB);
                        callback.i(LoadStepAction.STEP_FINISH_DECOMPRESS);
                        return;
                    } catch (Throwable th2) {
                        TmcLogger.h(this.f31599a, th2);
                        g(context, controller, appModelE, "5", MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR + th2.getMessage());
                        return;
                    }
                }
                e(context, appModelE, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, null);
                try {
                    if ((!this.f81662k.f81688b) && k0Var.o(context.p(), appModelE.getAppId(), strB)) {
                        TmcLogger.c("Subpackage::", "delete latest download pkg,appVersion:" + appModelE.getDeployVersion());
                        this.f31600b.deleteOldVersionFiles(context.p(), appModelE, true);
                        k0Var.t(context.p(), appModelE.getAppId(), strB);
                    }
                } catch (Throwable th3) {
                    TmcLogger.g(this.f31599a, "", th3);
                }
                TmcLogger.c(this.f31599a, "Step_LoadStep:tar包已解压，跳转到 startStep");
                controller.unlock(controller);
                controller.moveToNext();
                return;
                TmcLogger.h(this.f31599a, th);
                g(context, controller, null, "5", MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR + th.getMessage());
            }
        } catch (Throwable th4) {
            TmcLogger.h(this.f31599a, th4);
            g(context, controller, null, "5", MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR + th4.getMessage());
        }
    }

    public final void e(lb.g gVar, AppModel appModel, PointAnalyseType pointAnalyseType, String str) {
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        String strO = miniAppLaunch.O(this.f31600b.getSubpackageAppModelFromUsed(gVar.p(), gVar.c()));
        String strO2 = miniAppLaunch.O(this.f31600b.getAppModelFromPre(gVar.p(), gVar.c()));
        if (strO2 == null || strO == null || TextUtils.isEmpty(strO) || TextUtils.isEmpty(strO2) || !miniAppLaunch.D(strO2, strO)) {
            return;
        }
        com.cloud.tmc.miniapp.prepare.steps.e.a(appModel, pointAnalyseType, "mpu_appId", "mpu_old_v", strO).putData("mpu_new_v", strO2);
        if (str != null && str.length() != 0) {
            pointAnalyseType.putData("mpu_result", str);
        }
        pointAnalyseType.putData("mpu_chain_uniqueId", gVar.q().getString("uniqueChainID", "-1"));
        this.f81662k.a(pointAnalyseType);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), pointAnalyseType, "");
    }

    public final void f(final lb.g gVar, final PrepareController prepareController, final AppModel appModel, final String str) {
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        com.cloud.tmc.miniapp.prepare.steps.b.a(gVar, "uniqueChainID", "-1", bundle, com.cloud.tmc.kernel.proxy.performanceanalyse.a.M);
        bundle.putInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31206d0, 2);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(gVar.c(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        this.f31601c.installZip(gVar.p(), appModel, false, this.f81662k.e(), new o() { // from class: z.b
            @Override // ua.o
            public final void a(boolean z11, String str2) {
                d.h(this.f81649a, prepareController, gVar, appModel, str, z11, str2);
            }
        });
    }

    public final void g(lb.g gVar, PrepareController prepareController, AppModel appModel, String str, String str2) {
        if (appModel != null) {
            try {
                if (this.f81662k.f81688b) {
                    KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                    Object[] objArr = new Object[1];
                    SubPackageInfo subPackageInfoE = this.f81662k.e();
                    objArr[0] = subPackageInfoE != null ? subPackageInfoE.getSubPackageUrlMD5() : null;
                    String str3 = String.format("subpackage_decompression_count_url_%s", Arrays.copyOf(objArr, 1));
                    Intrinsics.f(str3, "format(format, *args)");
                    int i11 = kVStorageProxy.getInt(gVar.p(), "miniapp_business_subpackage_record", str3);
                    TmcLogger.c(this.f31599a, "decompressionFailed,tryCount:" + i11);
                    if (i11 <= 1) {
                        kVStorageProxy.putInt(gVar.p(), "miniapp_business_subpackage_record", str3, i11 + 1);
                    } else {
                        kVStorageProxy.remove(gVar.p(), "miniapp_business_subpackage_record", str3);
                        k0.f31068a.r(gVar.p(), appModel, this.f81663l);
                        TmcLogger.c(this.f31599a, "decompressionFailed,clearAll");
                    }
                } else {
                    k0.f31068a.r(gVar.p(), appModel, this.f81663l);
                    TmcLogger.c(this.f31599a, "decompressionFailed,clearAll");
                }
            } catch (Throwable th2) {
                TmcLogger.g(this.f31599a, "", th2);
            }
        }
        com.cloud.tmc.miniapp.prepare.steps.i.a(str, str2, prepareController);
    }
}
