package org.mvel2.optimizers;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;
import org.mvel2.optimizers.impl.asm.ASMAccessorOptimizer;
import org.mvel2.optimizers.impl.refl.ReflectiveAccessorOptimizer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f73334a = "dynamic";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f73335b = "reflective";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f73336c = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f73337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, a> f73338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ThreadLocal<Class<? extends a>> f73339f;

    static {
        HashMap map = new HashMap();
        f73338e = map;
        f73339f = new ThreadLocal<>();
        map.put(f73335b, new ReflectiveAccessorOptimizer());
        map.put(f73334a, new DynamicOptimizer());
        try {
            if (b.class.getClassLoader() != null) {
                b.class.getClassLoader().loadClass("org.mvel2.asm.ClassWriter");
            } else {
                ClassLoader.getSystemClassLoader().loadClass("org.mvel2.asm.ClassWriter");
            }
            map.put("ASM", new ASMAccessorOptimizer());
        } catch (ClassNotFoundException unused) {
            f73337d = f73335b;
        } catch (Throwable th2) {
            f73336c.log(Level.WARNING, "[MVEL] Notice: Possible incorrect version of ASM present (3.0 required).  Disabling JIT compiler.  Reflective Optimizer will be used.", th2);
            f73337d = f73335b;
        }
        if (Boolean.getBoolean("mvel2.disable.jit")) {
            e(f73335b);
        } else {
            e(f73334a);
        }
    }

    public static void a() {
        f73339f.set(null);
        f73339f.remove();
    }

    public static a b(String str) {
        try {
            return (a) f73338e.get(str).getClass().newInstance();
        } catch (Exception e11) {
            throw new RuntimeException("unable to instantiate accessor compiler", e11);
        }
    }

    public static a c() {
        try {
            return (a) f73338e.get(f73337d).getClass().newInstance();
        } catch (Exception e11) {
            throw new RuntimeException("unable to instantiate accessor compiler", e11);
        }
    }

    public static a d() {
        if (f73339f.get() == null) {
            f73339f.set((Class<? extends a>) c().getClass());
        }
        try {
            return f73339f.get().newInstance();
        } catch (Exception e11) {
            throw new RuntimeException("unable to instantiate accessor compiler", e11);
        }
    }

    public static void e(String str) {
        try {
            Map<String, a> map = f73338e;
            f73337d = str;
            map.get(str).init();
            f73339f.set(null);
        } catch (Exception e11) {
            throw new RuntimeException("unable to instantiate accessor compiler", e11);
        }
    }

    public static void f(Class<? extends a> cls) {
        if (cls == null) {
            throw new RuntimeException("null optimizer");
        }
        f73339f.set(cls);
    }
}
