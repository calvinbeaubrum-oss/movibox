package ib;

import com.cloud.tmc.integration.invoke.ExtensionInvokerFactory;
import com.cloud.tmc.integration.invoke.action.ActionCallback;
import com.cloud.tmc.integration.invoke.d;
import com.cloud.tmc.integration.invoke.f;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.c;
import com.cloud.tmc.kernel.extension.e;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.utils.m;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a<T extends c> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static e f67173j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Map<Class<? extends c>, c> f67174k = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Node f67175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<T> f67176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f67177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ad.a f67178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f67179e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f67181g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExecutorType f67180f = ExecutorType.SYNC;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<com.cloud.tmc.integration.invoke.action.a, ExecutorType> f67182h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InvocationHandler f67183i = new C0708a();

    /* JADX INFO: renamed from: ib.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0708a implements InvocationHandler {
        public C0708a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2 = a.this.f67177c;
            return obj2 == null ? m.a(method.getReturnType()) : obj2;
        }
    }

    public a(Class<T> cls) {
        this.f67176b = cls;
    }

    public static <T extends c> a<T> b(Class<T> cls) {
        return new a<>(cls);
    }

    public static void c(e eVar) {
        f67173j = eVar;
    }

    public T d() {
        c cVarF;
        InvocationHandler invocationHandler;
        e eVar = this.f67181g;
        if (eVar == null) {
            eVar = f67173j;
        }
        List<c> listB = eVar.b(this.f67175a, this.f67176b);
        if ((listB == null || listB.size() == 0) && (cVarF = f()) != null) {
            listB = Collections.singletonList(cVarF);
        }
        if (listB == null || listB.isEmpty()) {
            TmcLogger.o("TmcKernel", "cannot find extension for " + this.f67176b);
            if (this.f67179e) {
                return null;
            }
            invocationHandler = this.f67183i;
        } else {
            d dVarCreateScheduleExtensionInvoker = ((ExtensionInvokerFactory) tc.a.a(ExtensionInvokerFactory.class)).createScheduleExtensionInvoker(new f(this.f67178d, new com.cloud.tmc.integration.invoke.a(this.f67175a, new ActionCallback(this.f67182h, this.f67177c))));
            dVarCreateScheduleExtensionInvoker.b(listB);
            invocationHandler = dVarCreateScheduleExtensionInvoker;
        }
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.f67176b}, invocationHandler);
    }

    public a<T> e(e eVar) {
        this.f67181g = eVar;
        return this;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final T f() {
        try {
            if (f67174k.containsKey(this.f67176b)) {
                return (T) f67174k.get(this.f67176b);
            }
            zb.c cVar = (zb.c) this.f67176b.getAnnotation(zb.c.class);
            if (cVar == null) {
                return null;
            }
            String strValue = cVar.value();
            TmcLogger.c("TmcKernel", "newInstance for " + this.f67176b + " to defaultImpl: " + strValue);
            T t11 = (T) Class.forName(strValue).newInstance();
            f67174k.put((Class<? extends c>) this.f67176b, t11);
            return t11;
        } catch (Throwable th2) {
            TmcLogger.g("TmcKernel", "getDefaultImpl exception!", th2);
            return null;
        }
    }

    public a<T> g(Node node) {
        this.f67175a = node;
        return this;
    }
}
