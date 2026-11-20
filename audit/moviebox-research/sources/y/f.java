package y;

import android.content.Context;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.a0;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.StepType;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prepare.steps.i;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.transsion.push.PushConstants;
import hd.j;
import kotlin.jvm.internal.Intrinsics;
import lb.g;
import ua.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.cloud.tmc.miniapp.prepare.steps.a {
    public static final void f(f this$0, AppModel commonResModel, Context context, PrepareController prepareController, boolean z11, String str) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(commonResModel, "$commonResModel");
        Intrinsics.g(context, "$context");
        if (!z11) {
            TmcLogger.c(this$0.f31599a, "Step_LoadStep: tar 包解压失败，删除数据");
            h.f31061a.s(context, commonResModel);
            if (prepareController != null) {
                StringBuilder sbA = j.a(MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
                sbA.append(commonResModel.getPackageUrl());
                prepareController.moveToError(new PrepareException("5", sbA.toString()));
                return;
            }
            return;
        }
        TmcLogger.c(this$0.f31599a, "Step_LoadStep: tar 包解压完成");
        try {
            h hVar = h.f31061a;
            if (!Intrinsics.b(a0.f31025a.b(hVar.t(commonResModel), PushConstants.PROVIDER_FIELD_APP_ID), commonResModel.getAppId())) {
                hVar.s(context, commonResModel);
                if (prepareController != null) {
                    prepareController.moveToError(new PrepareException(PrepareException.ERROR_MANIFEST_INFO, "manifest error"));
                    return;
                }
                return;
            }
            TmcLogger.c(this$0.f31599a, "Step_LoadStep: manifest 内容校验成功");
            hVar.m(context, commonResModel, true);
            this$0.f31603e.delectDownloadFileForVersion(commonResModel);
            this$0.f31600b.delectOldVersionFilesAndUpdate(context, commonResModel);
            if (prepareController != null) {
                prepareController.unlock(prepareController);
            }
            if (prepareController != null) {
                prepareController.moveToNext();
            }
        } catch (Throwable unused) {
            h.f31061a.s(context, commonResModel);
            if (prepareController != null) {
                i.a(PrepareException.ERROR_MANIFEST_INFO, "manifest error", prepareController);
            }
        }
    }

    public static final void g(f this$0, PrepareController prepareController, g context, AppModel commonResModel, boolean z11, String str) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(context, "$context");
        Intrinsics.g(commonResModel, "$commonResModel");
        if (z11) {
            TmcLogger.c(this$0.f31599a, "Step_LoadStep: zip 包解压完成");
            this$0.d(prepareController, context, commonResModel);
            return;
        }
        TmcLogger.c(this$0.f31599a, "Step_LoadStep: zip 包解压失败");
        h.f31061a.s(context.p(), commonResModel);
        if (prepareController != null) {
            StringBuilder sbA = j.a(MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
            sbA.append(commonResModel.getPackageUrl());
            prepareController.moveToError(new PrepareException("5", sbA.toString()));
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, g gVar, c0 c0Var) throws PrepareException {
        String appId;
        super.a(prepareController, gVar, c0Var);
        AppModel appModelE = gVar.e();
        if (!AppUtils.f31011a.g(appModelE != null ? appModelE.getMiniappSubtype() : null)) {
            if (prepareController != null) {
                prepareController.moveToNext();
                return;
            }
            return;
        }
        Context contextP = gVar.p();
        if (contextP == null) {
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("context is null"));
                return;
            }
            return;
        }
        AppModel appModelH = gVar.h();
        if (appModelH == null) {
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("commonResModel is null"));
                return;
            }
            return;
        }
        if (appModelE != null && (appId = appModelE.getAppId()) != null) {
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            miniAppLaunch.C(appId, "d_e");
            miniAppLaunch.C(appId, "l_s");
        }
        if (h.f31061a.q(contextP, appModelH)) {
            TmcLogger.c(this.f31599a, "Step_LoadStep:tar包已解压，跳转到 startStep");
            if (prepareController != null) {
                prepareController.unlock(prepareController);
            }
            if (prepareController != null) {
                prepareController.moveToNext();
                return;
            }
            return;
        }
        this.f31603e.deleteFile(this.f31602d.getZipUnCompressPath(appModelH));
        try {
            e(gVar, prepareController, appModelH);
            if (c0Var != null) {
                c0Var.i(LoadStepAction.STEP_FINISH_DECOMPRESS);
            }
        } catch (Throwable th2) {
            TmcLogger.h(this.f31599a, th2);
            if (prepareController != null) {
                StringBuilder sbA = j.a(MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
                sbA.append(th2.getMessage());
                prepareController.moveToError(new PrepareException("5", sbA.toString()));
            }
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.COMMON_RES_LOAD;
    }

    public final void d(final PrepareController prepareController, g gVar, final AppModel appModel) {
        final Context contextP = gVar.p();
        TmcLogger.c(this.f31599a, "Step_LoadStep: sha256 校验");
        h hVar = h.f31061a;
        if (hVar.p(appModel)) {
            TmcLogger.c(this.f31599a, "Step_LoadStep: sha256 校验正确，解压 tar 包");
            this.f31601c.installApp(appModel, new o() { // from class: y.e
                @Override // ua.o
                public final void a(boolean z11, String str) {
                    f.f(this.f81021a, appModel, contextP, prepareController, z11, str);
                }
            });
            return;
        }
        TmcLogger.c(this.f31599a, "Step_LoadStep: sha256 校验不一致，删除所有缓存");
        hVar.s(contextP, appModel);
        if (prepareController != null) {
            StringBuilder sbA = x.a.a(appModel, j.a("sign error"), "   ");
            sbA.append(appModel.getPackageUrl());
            prepareController.moveToError(new PrepareException("7", sbA.toString()));
        }
    }

    public final void e(final g gVar, final PrepareController prepareController, final AppModel appModel) {
        this.f31601c.installZip(gVar.p(), appModel, new o() { // from class: y.d
            @Override // ua.o
            public final void a(boolean z11, String str) {
                f.g(this.f81017a, prepareController, gVar, appModel, z11, str);
            }
        });
    }
}
