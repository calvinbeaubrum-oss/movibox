package dc;

import com.cloud.tmc.kernel.bridge.extension.bind.BindException;
import com.cloud.tmc.kernel.executor.IExecutorService;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements b<cc.d, Executor> {
    @Override // dc.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Executor a(Class<Executor> cls, cc.d dVar) throws BindException {
        return ((IExecutorService) tc.a.a(IExecutorService.class)).getExecutor(dVar.value());
    }
}
