package com.cloud.tmc.integration.invoke;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.utils.m;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Node f30795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f30796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f30797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gc.c<com.cloud.tmc.kernel.extension.c> f30798d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AtomicBoolean f30799f;

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        void e(T t11);

        void f(Throwable th2);
    }

    /* JADX INFO: compiled from: source.java */
    public static class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f30800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public T f30801b;

        public b(boolean z11, T t11) {
            this.f30800a = z11;
            this.f30801b = t11;
        }

        public static b d(Object obj) {
            return new b(false, obj);
        }

        public static b e() {
            return new b(true, null);
        }

        public static b f() {
            return null;
        }
    }

    public d(d dVar) {
        this.f30799f = new AtomicBoolean(false);
        this.f30797c = dVar;
        if (dVar != null) {
            this.f30796b = dVar.f30796b;
            this.f30795a = dVar.f30795a;
        } else {
            this.f30796b = null;
            this.f30795a = null;
        }
    }

    public d(Node node, a aVar) {
        this.f30799f = new AtomicBoolean(false);
        this.f30795a = node;
        this.f30796b = aVar;
        this.f30797c = null;
    }

    public void a(com.cloud.tmc.kernel.extension.c cVar) {
        this.f30798d = new gc.c<>(cVar);
        this.f30799f.set(true);
    }

    public void b(List<com.cloud.tmc.kernel.extension.c> list) {
        this.f30798d = new gc.c<>((List) list);
        this.f30799f.set(true);
    }

    public final boolean c() {
        return this.f30797c != null;
    }

    public abstract b d(Object obj, Method method, Object[] objArr) throws Throwable;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    public final Object e(gc.c<com.cloud.tmc.kernel.extension.c> cVar, Object obj, Method method, Object[] objArr) throws InvokeException {
        gc.c<com.cloud.tmc.kernel.extension.c> cVar2 = cVar;
        if (!c()) {
            try {
                if (cVar.size() != 1) {
                    throw new IllegalStateException("only single extension is accepted in last invoker");
                }
                try {
                    try {
                        cVar = method.invoke(cVar.get(0), objArr);
                        return cVar;
                    } catch (Throwable th2) {
                        throw new InvokeException(th2);
                    }
                } catch (InvocationTargetException e11) {
                    throw new InvokeException(e11.getCause());
                }
            } catch (Throwable th3) {
                TmcLogger.h("TmcKernel:ExtensionInvoker", th3);
                cVar2 = cVar;
            }
        }
        if (this.f30799f.compareAndSet(true, false)) {
            this.f30797c.f30799f.set(true);
        }
        try {
            d dVar = this.f30797c;
            dVar.f30798d = cVar2;
            return dVar.invoke(obj, method, objArr);
        } catch (InvokeException e12) {
            throw e12;
        } catch (Throwable th4) {
            throw new InvokeException(th4);
        }
    }

    public final Object f(gc.c<com.cloud.tmc.kernel.extension.c> cVar, Object obj, Method method, Object[] objArr) {
        try {
            return e(cVar, obj, method, objArr);
        } catch (Throwable th2) {
            TmcLogger.g("TmcKernel:ExtensionInvoker", "extension invoke exception!", th2);
            return m.a(method.getReturnType());
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        a aVar;
        a aVar2;
        try {
            b bVarD = d(obj, method, objArr);
            if (bVarD == null) {
                return e(this.f30798d, obj, method, objArr);
            }
            if (bVarD.f30800a) {
                if (bVarD.f30801b == null) {
                    bVarD.f30801b = m.a(method.getReturnType());
                }
            } else if (this.f30799f.get() && (aVar2 = this.f30796b) != null) {
                aVar2.e(bVarD.f30801b);
            }
            return bVarD.f30801b;
        } catch (Throwable th2) {
            TmcLogger.g("TmcKernel:ExtensionInvoker", "Java exception happened!\nExtension: " + this.f30798d.get(0) + "\nMethod: " + method, th2);
            if (this.f30799f.get() && (aVar = this.f30796b) != null) {
                aVar.f(th2);
            }
            throw th2;
        }
    }
}
