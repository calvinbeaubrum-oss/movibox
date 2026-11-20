package y;

import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.StepType;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lb.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class c extends com.cloud.tmc.miniapp.prepare.steps.a {
    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, g gVar, c0 c0Var) throws PrepareException {
        super.a(prepareController, gVar, c0Var);
        AppModel appModelE = gVar.e();
        if (appModelE == null) {
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("appModel is null"));
                return;
            }
            return;
        }
        if (!AppUtils.f31011a.g(appModelE.getMiniappSubtype())) {
            if (prepareController != null) {
                prepareController.moveToNext();
                return;
            }
            return;
        }
        String templateMiniappId = appModelE.getTemplateMiniappId();
        if (templateMiniappId == null) {
            templateMiniappId = "";
        }
        if (templateMiniappId.length() == 0) {
            if (prepareController != null) {
                prepareController.moveToNext();
                return;
            }
            return;
        }
        String appId = appModelE.getAppId();
        if (appId != null) {
            MiniAppLaunch.f31784a.C(appId, "u_s");
        }
        AppModel appModel = this.f31600b.getAppModel(gVar.p(), lb.a.f70163b.a(templateMiniappId));
        if (appModel == null) {
            appModel = d(templateMiniappId, appModelE, gVar);
        } else {
            if (appModel.getFromCacheType() == 3 || appModel.getFromCacheType() == 5 || appModel.getFromCacheType() == 6) {
                MiniAppLaunch.f31784a.o(appModel);
            }
            if (!Intrinsics.b(appModel.getPackageUrl(), appModelE.getTemplatePackageUrl())) {
                MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
                String templateDeployVersion = appModelE.getTemplateDeployVersion();
                if (templateDeployVersion == null) {
                    templateDeployVersion = "";
                }
                String deployVersion = appModel.getDeployVersion();
                if (miniAppLaunch.D(templateDeployVersion, deployVersion != null ? deployVersion : "")) {
                    AppModel appModelD = d(templateMiniappId, appModelE, gVar);
                    Boolean boolValueOf = Boolean.valueOf(this.f31601c.isDownloaded(gVar.p(), appModel));
                    if (boolValueOf.booleanValue()) {
                        boolValueOf = null;
                    }
                    if (boolValueOf != null) {
                        boolValueOf.booleanValue();
                        if (appModel.getFromCacheType() != 3 && appModel.getFromCacheType() != 4) {
                            appModel = appModelD;
                        }
                    }
                }
            }
        }
        gVar.y(appModel);
        if (prepareController != null) {
            prepareController.moveToNext();
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.COMMON_RES_INFO_UPDATE;
    }

    public final AppModel d(String str, AppModel appModel, g gVar) {
        AppInfoModel appInfoModel = new AppInfoModel();
        appInfoModel.setAppId(str);
        appInfoModel.setDeployVersion(appModel.getTemplateDeployVersion());
        appInfoModel.setPackageUrl(appModel.getTemplatePackageUrl());
        AppModel appModelG = MiniAppLaunch.f31784a.G(appInfoModel);
        this.f31600b.updateAppModel(gVar.p(), appModelG, str + "_pre");
        return appModelG;
    }
}
