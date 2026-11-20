package com.alibaba.android.arouter.core;

import android.content.Context;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.ILogger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Route(path = "/arouter/service/interceptor")
public class InterceptorServiceImpl implements InterceptorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f15343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f15344b = new Object();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements InterceptorCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i7.a f15345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Postcard f15347c;

        public a(i7.a aVar, int i11, Postcard postcard) {
            this.f15345a = aVar;
            this.f15346b = i11;
            this.f15347c = postcard;
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onContinue(Postcard postcard) {
            this.f15345a.countDown();
            InterceptorServiceImpl.z1(this.f15346b + 1, this.f15345a, postcard);
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onInterrupt(Throwable th2) {
            Postcard postcard = this.f15347c;
            if (th2 == null) {
                th2 = new HandlerException("No message.");
            }
            postcard.setTag(th2);
            this.f15345a.a();
        }
    }

    public static void D1() {
        synchronized (f15344b) {
            while (!f15343a) {
                try {
                    f15344b.wait(10000L);
                } catch (InterruptedException e11) {
                    throw new HandlerException("ARouter::Interceptor init cost too much time error! reason = [" + e11.getMessage() + "]");
                }
            }
        }
    }

    public static void z1(int i11, i7.a aVar, Postcard postcard) {
        if (i11 < b.f15357f.size()) {
            b.f15357f.get(i11).process(postcard, new a(aVar, i11, postcard));
        }
    }

    @Override // com.alibaba.android.arouter.facade.service.InterceptorService
    public void doInterceptions(final Postcard postcard, final InterceptorCallback interceptorCallback) {
        if (!com.alibaba.android.arouter.utils.b.b(b.f15356e)) {
            interceptorCallback.onContinue(postcard);
            return;
        }
        D1();
        if (f15343a) {
            com.alibaba.android.arouter.core.a.f15349b.execute(new Runnable() { // from class: com.alibaba.android.arouter.core.InterceptorServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    i7.a aVar = new i7.a(b.f15357f.size());
                    try {
                        InterceptorServiceImpl.z1(0, aVar, postcard);
                        aVar.await(postcard.getTimeout(), TimeUnit.SECONDS);
                        if (aVar.getCount() > 0) {
                            interceptorCallback.onInterrupt(new HandlerException("The interceptor processing timed out."));
                        } else if (postcard.getTag() != null) {
                            interceptorCallback.onInterrupt((Throwable) postcard.getTag());
                        } else {
                            interceptorCallback.onContinue(postcard);
                        }
                    } catch (Exception e11) {
                        interceptorCallback.onInterrupt(e11);
                    }
                }
            });
        } else {
            interceptorCallback.onInterrupt(new HandlerException("Interceptors initialization takes too much time."));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(final Context context) {
        com.alibaba.android.arouter.core.a.f15349b.execute(new Runnable() { // from class: com.alibaba.android.arouter.core.InterceptorServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.alibaba.android.arouter.utils.b.b(b.f15356e)) {
                    Iterator<Map.Entry<Integer, Class<? extends IInterceptor>>> it = b.f15356e.entrySet().iterator();
                    while (it.hasNext()) {
                        Class<? extends IInterceptor> value = it.next().getValue();
                        try {
                            IInterceptor iInterceptorNewInstance = value.getConstructor(new Class[0]).newInstance(new Object[0]);
                            iInterceptorNewInstance.init(context);
                            b.f15357f.add(iInterceptorNewInstance);
                        } catch (Exception e11) {
                            throw new HandlerException("ARouter::ARouter init interceptor error! name = [" + value.getName() + "], reason = [" + e11.getMessage() + "]");
                        }
                    }
                    boolean unused = InterceptorServiceImpl.f15343a = true;
                    com.alibaba.android.arouter.launcher.a.f15376c.info(ILogger.defaultTag, "ARouter interceptors init over.");
                    synchronized (InterceptorServiceImpl.f15344b) {
                        InterceptorServiceImpl.f15344b.notifyAll();
                    }
                }
            }
        });
    }
}
