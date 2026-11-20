package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f75362c = e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f75363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Constructor<MethodHandles.Lookup> f75364b;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends y {

        /* JADX INFO: renamed from: retrofit2.y$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class ExecutorC0829a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Handler f75365a = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f75365a.post(runnable);
            }
        }

        public a() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // retrofit2.y
        public Executor b() {
            return new ExecutorC0829a();
        }

        @Override // retrofit2.y
        public Object g(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.g(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    public y(boolean z11) {
        this.f75363a = z11;
        Constructor<MethodHandles.Lookup> declaredConstructor = null;
        if (z11) {
            try {
                declaredConstructor = s.a().getDeclaredConstructor(Class.class, Integer.TYPE);
                declaredConstructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.f75364b = declaredConstructor;
    }

    public static y e() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new a() : new y(true);
    }

    public static y f() {
        return f75362c;
    }

    public List<? extends c.a> a(Executor executor) {
        j jVar = new j(executor);
        return this.f75363a ? Arrays.asList(h.f75268a, jVar) : Collections.singletonList(jVar);
    }

    public Executor b() {
        return null;
    }

    public List<? extends i.a> c() {
        return this.f75363a ? Collections.singletonList(q.f75315a) : Collections.emptyList();
    }

    public int d() {
        return this.f75363a ? 1 : 0;
    }

    @IgnoreJRERequirement
    public Object g(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        Constructor<MethodHandles.Lookup> constructor = this.f75364b;
        return (constructor != null ? u.a(constructor.newInstance(cls, -1)) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    @IgnoreJRERequirement
    public boolean h(Method method) {
        return this.f75363a && method.isDefault();
    }
}
