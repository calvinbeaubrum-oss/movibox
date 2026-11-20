package com.cloud.tmc.integration.invoke.action;

import com.cloud.tmc.integration.invoke.c;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.executor.IExecutorService;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ActionCallback<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<a, ExecutorType> f30789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IExecutorService f30790b = (IExecutorService) tc.a.a(IExecutorService.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f30791c;

    public ActionCallback(Map<a, ExecutorType> map, T t11) {
        this.f30789a = map;
        this.f30791c = t11;
    }

    @Override // com.cloud.tmc.integration.invoke.c
    public void a(final com.cloud.tmc.kernel.extension.c cVar) {
        for (final a aVar : this.f30789a.keySet()) {
            if (aVar instanceof a.c) {
                this.f30790b.getExecutor(this.f30789a.get(aVar)).execute(new Runnable() { // from class: com.cloud.tmc.integration.invoke.action.ActionCallback.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ((a.c) aVar).a(cVar);
                    }
                });
            }
        }
    }

    @Override // com.cloud.tmc.integration.invoke.c
    public void b(final com.cloud.tmc.kernel.extension.c cVar, final T t11) {
        for (final a aVar : this.f30789a.keySet()) {
            if (aVar instanceof a.d) {
                this.f30790b.getExecutor(this.f30789a.get(aVar)).execute(new Runnable() { // from class: com.cloud.tmc.integration.invoke.action.ActionCallback.2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        ((a.d) aVar).b(cVar, t11);
                    }
                });
            }
        }
    }

    @Override // com.cloud.tmc.integration.invoke.c
    public void c(final List<com.cloud.tmc.kernel.extension.c> list) {
        for (final a aVar : this.f30789a.keySet()) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            if (aVar instanceof a.e) {
                this.f30790b.getExecutor(this.f30789a.get(aVar)).execute(new Runnable() { // from class: com.cloud.tmc.integration.invoke.action.ActionCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TmcLogger.d("TmcKernel:ActionCallback", "onComplete for " + aVar.getClass().getName() + " schedule " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        ((a.e) aVar).c(list);
                    }
                });
            }
        }
    }

    @Override // com.cloud.tmc.integration.invoke.c
    public void d(final com.cloud.tmc.kernel.extension.c cVar, final Throwable th2) {
        for (final a aVar : this.f30789a.keySet()) {
            if (aVar instanceof a.b) {
                this.f30790b.getExecutor(this.f30789a.get(aVar)).execute(new Runnable() { // from class: com.cloud.tmc.integration.invoke.action.ActionCallback.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ((a.b) aVar).d(cVar, th2);
                    }
                });
            }
        }
    }

    @Override // com.cloud.tmc.integration.invoke.d.a
    public void e(T t11) {
        if (t11 == null) {
            t11 = this.f30791c;
        }
        for (final a aVar : this.f30789a.keySet()) {
            if (aVar instanceof a.InterfaceC0339a) {
                final long jCurrentTimeMillis = System.currentTimeMillis();
                final T t12 = t11;
                this.f30790b.getExecutor(this.f30789a.get(aVar)).execute(new Runnable() { // from class: com.cloud.tmc.integration.invoke.action.ActionCallback.5
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        TmcLogger.d("TmcKernel:ActionCallback", "onComplete for " + aVar.getClass().getName() + " schedule " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        ((a.InterfaceC0339a) aVar).e(t12);
                    }
                });
            }
        }
    }

    @Override // com.cloud.tmc.integration.invoke.d.a
    public void f(Throwable th2) {
    }
}
