package v;

import com.cloud.tmc.miniapp.prepare.controller.BasePrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.UpdateStep;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prepare.steps.x;
import com.cloud.tmc.miniapp.prepare.steps.y;
import com.cloud.tmc.miniapp.prepare.steps.z;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import lb.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends BasePrepareController {
    public c(g gVar, c0 c0Var) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5);
        this.steps = arrayBlockingQueue;
        arrayBlockingQueue.add(new y());
        this.steps.add(new com.cloud.tmc.miniapp.prepare.steps.d());
        this.steps.add(new UpdateStep());
        this.steps.add(new z());
        this.steps.add(new x());
        bindContext(gVar, c0Var);
        setInterceptors(new ArrayList());
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.BasePrepareController, com.cloud.tmc.miniapp.prepare.controller.PrepareController
    public void moveToError(PrepareException prepareException) {
        super.moveToError(prepareException);
    }
}
