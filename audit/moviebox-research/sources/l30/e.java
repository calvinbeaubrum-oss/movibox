package l30;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<Class, d> f69774a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f69775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f69776c;

    public static d a() {
        return f69776c;
    }

    public static d b() {
        return f69775b;
    }

    public static d c(Class cls) {
        return f69774a.get(cls);
    }

    public static boolean d() {
        return f69776c != null;
    }

    public static boolean e() {
        return f69775b != null;
    }

    public static boolean f(Class cls) {
        if (cls == null) {
            return false;
        }
        if (f69774a.containsKey(cls)) {
            return true;
        }
        Class superclass = cls;
        do {
            if (cls != superclass && f69774a.containsKey(superclass)) {
                Map<Class, d> map = f69774a;
                map.put(cls, map.get(superclass));
                return true;
            }
            for (Class<?> cls2 : superclass.getInterfaces()) {
                if (f69774a.containsKey(cls2)) {
                    Map<Class, d> map2 = f69774a;
                    map2.put(cls, map2.get(cls2));
                    return true;
                }
            }
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                break;
            }
        } while (superclass != Object.class);
        return false;
    }
}
