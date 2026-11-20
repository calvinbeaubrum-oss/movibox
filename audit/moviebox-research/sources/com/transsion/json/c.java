package com.transsion.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<Map<Class, c>> f52929d = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f52930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f52931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, d> f52932c;

    public c(Class cls) {
        this.f52930a = cls;
        this.f52931b = a(cls.getSuperclass());
        g();
    }

    public static c a(Class cls) {
        ThreadLocal<Map<Class, c>> threadLocal = f52929d;
        if (threadLocal.get() == null) {
            threadLocal.set(new HashMap());
        }
        if (cls == null) {
            return null;
        }
        if (!threadLocal.get().containsKey(cls)) {
            threadLocal.get().put(cls, new c(cls));
        }
        return threadLocal.get().get(cls);
    }

    public Field b(String str) {
        try {
            return this.f52930a.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public Collection<d> c() {
        TreeMap treeMap = new TreeMap(this.f52932c);
        for (c cVar = this.f52931b; cVar != null; cVar = cVar.f52931b) {
            d(treeMap, cVar.f52932c);
        }
        return treeMap.values();
    }

    public final void d(Map<String, d> map, Map<String, d> map2) {
        for (String str : map2.keySet()) {
            if (!map.containsKey(str)) {
                map.put(str, map2.get(str));
            }
        }
    }

    public c e() {
        return this.f52931b;
    }

    public d f(String str) {
        for (c cVar = this; cVar != null; cVar = cVar.f52931b) {
            d dVar = cVar.f52932c.get(str);
            if (dVar != null) {
                return dVar;
            }
        }
        return null;
    }

    public final void g() {
        this.f52932c = new TreeMap();
        for (Field field : this.f52930a.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers()) && !this.f52932c.containsKey(field.getName())) {
                this.f52932c.put(field.getName(), new d(field, this));
            }
        }
        for (Method method : this.f52930a.getDeclaredMethods()) {
            if (!Modifier.isStatic(method.getModifiers())) {
                int length = method.getParameterTypes().length;
                String name = method.getName();
                if (name.length() > 3 || name.startsWith("is")) {
                    if (length == 0) {
                        if (name.startsWith("get")) {
                            String strI = i(name.substring(3));
                            if (!this.f52932c.containsKey(strI)) {
                                this.f52932c.put(strI, new d(strI, this));
                            }
                            this.f52932c.get(strI).f(method);
                        } else if (name.startsWith("is")) {
                            String strI2 = i(name.substring(2));
                            if (!this.f52932c.containsKey(strI2)) {
                                this.f52932c.put(strI2, new d(strI2, this));
                            }
                            this.f52932c.get(strI2).f(method);
                        }
                    } else if (length == 1 && name.startsWith("set")) {
                        String strI3 = i(name.substring(3));
                        if (!this.f52932c.containsKey(strI3)) {
                            this.f52932c.put(strI3, new d(strI3, this));
                        }
                        this.f52932c.get(strI3).d(method);
                    }
                }
            }
        }
        Iterator<d> it = this.f52932c.values().iterator();
        while (it.hasNext()) {
            if (it.next().m()) {
                it.remove();
            }
        }
    }

    public boolean h(String str) {
        c cVar;
        return this.f52932c.containsKey(str) || ((cVar = this.f52931b) != null && cVar.h(str));
    }

    public final String i(String str) {
        if (str.length() < 2) {
            return str.toLowerCase();
        }
        if (Character.isUpperCase(str.charAt(0)) && Character.isUpperCase(str.charAt(1))) {
            return str;
        }
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }
}
