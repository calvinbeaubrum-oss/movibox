package v;

import androidx.annotation.NonNull;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.performance.WarmupType;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool;
import com.cloud.tmc.miniapp.prepare.controller.BasePrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.a0;
import com.cloud.tmc.miniapp.prepare.steps.b0;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import lb.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends BasePrepareController {
    public a(g gVar, c0 c0Var) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        this.steps = arrayBlockingQueue;
        arrayBlockingQueue.add(new a0());
        this.steps.add(new b0());
        bindContext(gVar, c0Var);
        setInterceptors(new ArrayList());
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.BasePrepareController, com.cloud.tmc.miniapp.prepare.controller.PrepareController
    public void moveToError(PrepareException prepareException) {
        super.moveToError(prepareException);
        int i11 = this.context.q().getInt("warmupType");
        if (i11 != WarmupType.NORMAL_WORKER.getType() && i11 != WarmupType.NORMAL_RENDER.getType()) {
            if (i11 == WarmupType.INNER_WORKER.getType()) {
                ((IInnerWorkerPool) tc.a.a(IInnerWorkerPool.class)).preWarmupWorkerFail();
            } else if (i11 == WarmupType.INNER_RENNDER.getType()) {
                ((IInnerRenderPool) tc.a.a(IInnerRenderPool.class)).preWarmupRenderFail();
            }
        }
        c0 c0Var = this.callback;
        if (c0Var != null) {
            c0Var.f(this.context.m(), prepareException);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.BasePrepareController
    public void onGetAppInfo(@NonNull AppModel appModel) {
        super.onGetAppInfo(appModel);
    }
}
