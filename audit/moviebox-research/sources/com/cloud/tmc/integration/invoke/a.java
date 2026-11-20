package com.cloud.tmc.integration.invoke;

import com.cloud.tmc.kernel.executor.IExecutorService;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.utils.k;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends d {
    public a(Node node, d.a aVar) {
        super(node, aVar);
    }

    @Override // com.cloud.tmc.integration.invoke.d
    public d.b d(Object obj, Method method, Object[] objArr) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.cloud.tmc.kernel.extension.c cVar = this.f30798d.get(0);
        k.a(this.f30795a, cVar);
        if (cVar instanceof bd.c) {
            ((bd.c) cVar).a((IExecutorService) tc.a.a(IExecutorService.class));
        }
        TmcLogger.d("TmcKernel:ExtensionInvoker:Aware", "extension " + cVar.getClass() + " method " + method + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return d.b.f();
    }
}
