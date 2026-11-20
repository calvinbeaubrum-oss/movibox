package com.cloud.tmc.integration.invoke;

import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.executor.IExecutorService;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ScheduleExtensionInvoker extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IExecutorService f30787g;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30788a;

        static {
            int[] iArr = new int[ExecutorType.values().length];
            f30788a = iArr;
            try {
                iArr[ExecutorType.SYNC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30788a[ExecutorType.UI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30788a[ExecutorType.URGENT_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ScheduleExtensionInvoker(d dVar) {
        super(dVar);
        this.f30787g = (IExecutorService) tc.a.a(IExecutorService.class);
    }

    @Override // com.cloud.tmc.integration.invoke.d
    public d.b d(final Object obj, final Method method, final Object[] objArr) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        zb.e eVar = (zb.e) method.getAnnotation(zb.e.class);
        ExecutorType executorTypeValue = eVar != null ? eVar.value() : ExecutorType.SYNC;
        int i11 = a.f30788a[executorTypeValue.ordinal()];
        if (i11 == 1) {
            TmcLogger.d("TmcKernel:ExtensionInvoker:Schedule", "method " + method + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return d.b.f();
        }
        if (i11 == 2) {
            com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: com.cloud.tmc.integration.invoke.ScheduleExtensionInvoker.1
                @Override // java.lang.Runnable
                public void run() {
                    TmcLogger.d("TmcKernel:ExtensionInvoker:Schedule", "method " + method + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    ScheduleExtensionInvoker scheduleExtensionInvoker = ScheduleExtensionInvoker.this;
                    scheduleExtensionInvoker.f(scheduleExtensionInvoker.f30798d, obj, method, objArr);
                }
            });
            return d.b.e();
        }
        if (i11 == 3) {
            if ((obj.getClass().getInterfaces().length > 0 ? obj.getClass().getInterfaces()[0] : null) == null) {
                TmcLogger.o("TmcKernel:ExtensionInvoker:Schedule", "extension " + obj + " want to execute on URGENT_DISPLAY but not nebulax class!");
                executorTypeValue = ExecutorType.URGENT;
            }
        }
        this.f30787g.getExecutor(executorTypeValue).execute(new Runnable() { // from class: com.cloud.tmc.integration.invoke.ScheduleExtensionInvoker.2
            @Override // java.lang.Runnable
            public void run() {
                TmcLogger.d("TmcKernel:ExtensionInvoker:Schedule", "method " + method + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
                ScheduleExtensionInvoker scheduleExtensionInvoker = ScheduleExtensionInvoker.this;
                scheduleExtensionInvoker.f(scheduleExtensionInvoker.f30798d, obj, method, objArr);
            }
        });
        return d.b.e();
    }
}
