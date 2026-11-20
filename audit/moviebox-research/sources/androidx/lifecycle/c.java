package androidx.lifecycle;

import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f8708c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a> f8709a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Boolean> f8710b = new HashMap();

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Lifecycle.Event, List<b>> f8711a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<b, Lifecycle.Event> f8712b;

        public a(Map<b, Lifecycle.Event> map) {
            this.f8712b = map;
            for (Map.Entry<b, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<b> arrayList = this.f8711a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f8711a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        public static void b(List<b> list, u uVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(uVar, event, obj);
                }
            }
        }

        public void a(u uVar, Lifecycle.Event event, Object obj) {
            b(this.f8711a.get(event), uVar, event, obj);
            b(this.f8711a.get(Lifecycle.Event.ON_ANY), uVar, event, obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f8714b;

        public b(int i11, Method method) {
            this.f8713a = i11;
            this.f8714b = method;
            method.setAccessible(true);
        }

        public void a(u uVar, Lifecycle.Event event, Object obj) {
            try {
                int i11 = this.f8713a;
                if (i11 == 0) {
                    this.f8714b.invoke(obj, new Object[0]);
                } else if (i11 == 1) {
                    this.f8714b.invoke(obj, uVar);
                } else {
                    if (i11 != 2) {
                        return;
                    }
                    this.f8714b.invoke(obj, uVar, event);
                }
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to call observer method", e12.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f8713a == bVar.f8713a && this.f8714b.getName().equals(bVar.f8714b.getName());
        }

        public int hashCode() {
            return (this.f8713a * 31) + this.f8714b.getName().hashCode();
        }
    }

    public final a a(Class<?> cls, @Nullable Method[] methodArr) {
        int i11;
        a aVarC;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f8712b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, Lifecycle.Event> entry : c(cls2).f8712b.entrySet()) {
                e(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z11 = false;
        for (Method method : methodArr) {
            e0 e0Var = (e0) method.getAnnotation(e0.class);
            if (e0Var != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i11 = 0;
                } else {
                    if (!u.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i11 = 1;
                }
                Lifecycle.Event eventValue = e0Var.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (eventValue != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i11 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new b(i11, method), eventValue, cls);
                z11 = true;
            }
        }
        a aVar = new a(map);
        this.f8709a.put(cls, aVar);
        this.f8710b.put(cls, Boolean.valueOf(z11));
        return aVar;
    }

    public final Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e11) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e11);
        }
    }

    public a c(Class<?> cls) {
        a aVar = this.f8709a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class<?> cls) {
        Boolean bool = this.f8710b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((e0) method.getAnnotation(e0.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f8710b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map<b, Lifecycle.Event> map, b bVar, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(bVar);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(bVar, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f8714b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }
}
