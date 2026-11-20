package v;

import androidx.annotation.NonNull;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.miniapp.prepare.controller.BasePrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import lb.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends BasePrepareController {
    public b(g gVar, c0 c0Var) {
        new AtomicBoolean(true);
        bindContext(gVar, c0Var);
        setInterceptors(new ArrayList());
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.BasePrepareController, com.cloud.tmc.miniapp.prepare.controller.PrepareController
    public void moveToError(PrepareException prepareException) {
        super.moveToError(prepareException);
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.BasePrepareController
    public void onGetAppInfo(@NonNull AppModel appModel) {
        super.onGetAppInfo(appModel);
    }
}
