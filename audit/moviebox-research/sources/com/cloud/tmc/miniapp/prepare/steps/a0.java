package com.cloud.tmc.miniapp.prepare.steps;

import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a0 extends a {
    @Override // com.cloud.tmc.miniapp.prepare.steps.a, com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, lb.g gVar, c0 c0Var) throws PrepareException {
        super.a(prepareController, gVar, c0Var);
        gVar.t(new lb.a("100000"));
        TmcAppInfoManager tmcAppInfoManager = this.f31600b;
        if (tmcAppInfoManager == null) {
            d(prepareController, "appInfoManager不能为空");
            return;
        }
        AppModel appModelFromUsed = tmcAppInfoManager.getAppModelFromUsed(gVar.p(), "100000");
        if (appModelFromUsed == null) {
            d(prepareController, "框架包AppModel不能为空");
            return;
        }
        gVar.A(appModelFromUsed);
        if (com.cloud.tmc.miniutils.util.j.A(this.f31602d.getTarUnCompressPath(appModelFromUsed))) {
            prepareController.moveToNext();
        } else {
            d(prepareController, "本地不存在框架包文件");
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return StepType.WARMUP_CHECK;
    }

    public final void d(PrepareController prepareController, String str) {
        if (prepareController != null) {
            prepareController.moveToError(new PrepareException(str));
        }
    }
}
