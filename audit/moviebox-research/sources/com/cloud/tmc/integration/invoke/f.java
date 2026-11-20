package com.cloud.tmc.integration.invoke;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.m;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ad.a f30810h = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ad.a f30811g;

    /* JADX INFO: compiled from: source.java */
    public class a implements ad.a {
        @Override // ad.a
        public Object a(List list) {
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) != null) {
                    return list.get(size);
                }
            }
            return null;
        }
    }

    public f(ad.a aVar, d dVar) {
        super(dVar);
        this.f30811g = aVar;
        if (aVar == null) {
            TmcLogger.c("TmcKernel:ExtensionInvoker:Resolve", "use default resolver!");
            this.f30811g = f30810h;
        }
    }

    @Override // com.cloud.tmc.integration.invoke.d
    public d.b d(Object obj, Method method, Object[] objArr) {
        if (!c()) {
            return d.b.d(m.a(method.getReturnType()));
        }
        ArrayList arrayList = new ArrayList();
        d.a aVar = this.f30796b;
        Throwable th2 = null;
        c cVar = aVar instanceof c ? (c) aVar : null;
        if (cVar != null) {
            cVar.c(this.f30798d.a());
        }
        cd.a aVar2 = null;
        Object objA = null;
        for (com.cloud.tmc.kernel.extension.c cVar2 : this.f30798d) {
            if (cVar2 instanceof bd.a) {
                if (aVar2 == null) {
                    aVar2 = new cd.a();
                } else {
                    aVar2.b(false);
                }
                ((bd.a) cVar2).a(aVar2);
            }
            try {
                this.f30797c.f30798d = new gc.c<>(cVar2);
                objA = this.f30797c.invoke(obj, method, objArr);
                arrayList.add(objA);
                if (cVar != null) {
                    cVar.b(cVar2, objA);
                }
                if (aVar2 != null && aVar2.a()) {
                    if (cVar == null) {
                        break;
                    }
                    cVar.a(cVar2);
                    break;
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (cVar != null) {
                    cVar.d(cVar2, th2);
                }
            }
        }
        cVar2 = null;
        ad.a aVar3 = this.f30811g;
        if (aVar3 != null) {
            objA = aVar3.a(arrayList);
        }
        if (th2 != null) {
            TmcLogger.f("TmcKernel:ExtensionInvoker:Resolve", "return defaultValue due to exception " + th2 + " in ext: " + cVar2);
            objA = m.a(method.getReturnType());
        }
        return d.b.d(objA);
    }
}
