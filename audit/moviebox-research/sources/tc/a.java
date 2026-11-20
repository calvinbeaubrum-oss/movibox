package tc;

import android.content.Context;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Object> f76936a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<Context> f76937b;

    /* JADX INFO: renamed from: tc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0851a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f76938a;

        public C0851a(Class cls) {
            this.f76938a = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Class<?> returnType = method.getReturnType();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("unimplemented proxy:");
            sb2.append(this.f76938a.getSimpleName());
            sb2.append(InstructionFileId.DOT);
            sb2.append(method.getName());
            if (!returnType.isPrimitive()) {
                return null;
            }
            Class<?> cls = Boolean.TYPE;
            if (returnType == cls || returnType == cls) {
                return Boolean.FALSE;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T> {
        T get();
    }

    public static <T> T a(Class<T> cls) {
        boolean z11;
        if (!cls.isInterface()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("got proxy clazz must a Interface:");
            sb2.append(cls.getSimpleName());
        }
        Map<Class<?>, Object> map = f76936a;
        T t11 = (T) map.get(cls);
        if (t11 != null && !(t11 instanceof b)) {
            return t11;
        }
        synchronized (map) {
            try {
                b bVar = (T) map.get(cls);
                if (bVar != null) {
                    if (bVar instanceof b) {
                        bVar = (T) bVar.get();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Lazy initialize of ");
                        sb3.append(cls);
                        sb3.append(" to ");
                        sb3.append(bVar);
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (bVar != null) {
                        if (z11) {
                            map.put((Class<?>) cls, bVar);
                        }
                        return (T) bVar;
                    }
                }
                c cVar = (c) cls.getAnnotation(c.class);
                if (cVar != null) {
                    try {
                        Class<?> cls2 = Class.forName(cVar.value());
                        if (cls.isAssignableFrom(cls2)) {
                            T t12 = (T) cls2.newInstance();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Default initialize of ");
                            sb4.append(cls);
                            sb4.append(" to ");
                            sb4.append(t12);
                            b(cls, t12);
                            return t12;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Default impl ");
                        sb5.append(cVar.value());
                        sb5.append(" is not instance of ");
                        sb5.append(cls);
                    } catch (Throwable th2) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("DefaultImpl instantiate exception!");
                        sb6.append(th2.getMessage());
                    }
                }
                T t13 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C0851a(cls));
                b(cls, t13);
                return t13;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static <T> void b(Class<? super T> cls, T t11) {
        c(cls, t11);
    }

    public static <T> void c(Class<? extends T> cls, Object obj) {
        if (cls == null) {
            return;
        }
        Map<Class<?>, Object> map = f76936a;
        if (map.containsKey(cls)) {
            return;
        }
        if (obj == null) {
            map.remove(cls);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cls.getSimpleName());
        sb2.append(" >>> ");
        sb2.append(obj.getClass());
        map.put(cls, obj);
    }

    public static <T> void d(Class<T> cls, b<T> bVar) {
        c(cls, bVar);
    }
}
