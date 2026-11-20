package com.transsion.json;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class, p> f52984d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<Object> f52981a = new LinkedList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<Object> f52982b = new LinkedList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f52983c = new r();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<r, p> f52985e = new HashMap();

    public o() {
        HashMap map = new HashMap();
        this.f52984d = map;
        map.put(Object.class, new du.b());
        map.put(Collection.class, new du.l());
        map.put(List.class, new du.l());
        map.put(Set.class, new du.o());
        map.put(Map.class, new du.n());
        map.put(Integer.class, new du.j());
        map.put(Integer.TYPE, new du.j());
        map.put(Float.class, new du.i());
        map.put(Float.TYPE, new du.i());
        map.put(Double.class, new du.g());
        map.put(Double.TYPE, new du.g());
        map.put(Long.class, new du.m());
        map.put(Long.TYPE, new du.m());
        map.put(Byte.class, new du.d());
        map.put(Byte.TYPE, new du.d());
        map.put(Boolean.class, new du.c());
        map.put(Boolean.TYPE, new du.c());
        map.put(Character.class, new du.e());
        map.put(Character.TYPE, new du.e());
        map.put(Enum.class, new du.h());
        map.put(String.class, new du.p());
        map.put(Array.class, new du.a());
        map.put(n.class, new du.k());
    }

    public o a(r rVar, p pVar) {
        this.f52985e.put(rVar, pVar);
        return this;
    }

    public o b(Class cls, p pVar) {
        this.f52984d.put(cls, pVar);
        return this;
    }

    public final p c(Class cls) {
        p pVar = this.f52984d.get(cls);
        if (pVar != null || cls == null) {
            return pVar;
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            p pVarC = c(cls2);
            if (pVarC != null) {
                return pVarC;
            }
        }
        if (cls.getSuperclass() != null) {
            return c(cls.getSuperclass());
        }
        return null;
    }

    public r d() {
        return this.f52983c;
    }

    public Class e(r rVar) throws ClassNotFoundException {
        p pVar = this.f52985e.get(rVar);
        if (!(pVar instanceof du.f)) {
            return null;
        }
        ((du.f) pVar).b();
        throw null;
    }

    public Class f(Class cls, Class cls2) {
        if (cls != null && cls2 != null) {
            return cls2.isAssignableFrom(cls) ? cls : cls2;
        }
        if (cls2 != null) {
            return cls2;
        }
        if (cls != null) {
            return cls;
        }
        return null;
    }

    public final Class g(Type type) {
        if (type == null) {
            return null;
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.class;
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable)) {
            return null;
        }
        throw new k(this.f52983c + ":  Unknown type " + type);
    }

    public Class h(Map map, Class cls) {
        if (cls != null) {
            return cls;
        }
        String str = (String) map.get("class");
        if (str == null) {
            return null;
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader != null ? contextClassLoader.loadClass(str) : Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new k(String.format("%s:  Could not load %s", this.f52983c, str), e11);
        }
    }

    public Object i(Object obj) {
        return j(obj, null);
    }

    public Object j(Object obj, Type type) {
        this.f52982b.add(obj);
        if (obj == null) {
            this.f52982b.removeLast();
            return null;
        }
        try {
            Class clsT = t(obj, g(type));
            p pVarR = r(clsT);
            if (pVarR != null) {
                Object objA = pVarR.a(this, obj, type, clsT);
                this.f52982b.removeLast();
                return objA;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f52983c);
            sb2.append(": + Could not find a suitable ObjectFactory for ");
            sb2.append(clsT);
            throw new k(sb2.toString());
        } catch (Throwable th2) {
            this.f52982b.removeLast();
            throw th2;
        }
    }

    public Object k(Map map, Object obj, Type type) {
        try {
            this.f52981a.add(obj);
            c cVarA = c.a(obj.getClass());
            for (d dVar : cVarA != null ? cVarA.c() : null) {
                if (p(map, dVar)) {
                    Object objS = s(map, dVar);
                    if (dVar.p().booleanValue()) {
                        this.f52983c.a(dVar.e());
                        Method methodK = dVar.k();
                        if (methodK != null) {
                            Type[] genericParameterTypes = methodK.getGenericParameterTypes();
                            if (genericParameterTypes.length != 1) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(this.f52983c);
                                sb2.append(":  Expected a single parameter for method ");
                                sb2.append(obj.getClass().getName());
                                sb2.append(InstructionFileId.DOT);
                                sb2.append(methodK.getName());
                                sb2.append(" but got ");
                                sb2.append(genericParameterTypes.length);
                                throw new k(sb2.toString());
                            }
                            methodK.invoke(this.f52981a.getLast(), j(objS, n(genericParameterTypes[0], type)));
                        } else {
                            Field fieldG = dVar.g();
                            if (fieldG != null) {
                                fieldG.setAccessible(true);
                                fieldG.set(obj, j(objS, fieldG.getGenericType()));
                            }
                        }
                        this.f52983c.d();
                    } else {
                        continue;
                    }
                }
            }
            return this.f52981a.removeLast();
        } catch (IllegalAccessException e11) {
            throw new k(this.f52983c + ":  Could not access the no-arg constructor for " + obj.getClass().getName(), e11);
        } catch (InvocationTargetException e12) {
            throw new k(this.f52983c + ":  Exception while trying to invoke setter method.", e12);
        }
    }

    public Object l(Map map, Map<Object, Object> map2, Type type, Type type2) {
        this.f52982b.add(map);
        this.f52981a.add(map2);
        for (Object obj : map.keySet()) {
            this.f52983c.a("keys");
            Object objJ = j(obj, type);
            this.f52983c.d();
            this.f52983c.a("values");
            Object objJ2 = j(map.get(obj), type2);
            this.f52983c.d();
            map2.put(objJ, objJ2);
        }
        this.f52981a.removeLast();
        this.f52982b.removeLast();
        return map2;
    }

    public final String m(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public final Type n(Type type, Type type2) {
        if ((type instanceof Class) || (type instanceof ParameterizedType)) {
            return type;
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return type2;
        }
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        throw new k(this.f52983c + ":  Unknown generic type " + type + InstructionFileId.DOT);
    }

    public <T extends Collection<Object>> T o(Collection collection, T t11, Type type) {
        Type type2 = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        this.f52982b.add(collection);
        this.f52981a.add(t11);
        d().a("values");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            t11.add(j(it.next(), type2));
        }
        d().d();
        this.f52981a.removeLast();
        this.f52982b.removeLast();
        return t11;
    }

    public final boolean p(Map map, d dVar) {
        return map.containsKey(dVar.b()) || map.containsKey(m(dVar.b()));
    }

    public k q(Object obj, Class cls) {
        return new k(String.format("%s:  Can not convert %s into %s", this.f52983c, obj.getClass().getName(), cls.getName()));
    }

    public final p r(Class cls) {
        p pVar = this.f52985e.get(this.f52983c);
        if (pVar == null) {
            return (cls == null || !cls.isArray()) ? c(cls) : this.f52984d.get(Array.class);
        }
        return pVar;
    }

    public final Object s(Map map, d dVar) {
        Object obj = map.get(dVar.b());
        return obj == null ? map.get(m(dVar.b())) : obj;
    }

    public final Class t(Object obj, Class cls) throws k {
        if (this.f52985e.containsKey(this.f52983c)) {
            return null;
        }
        Class clsF = f(obj instanceof Map ? h((Map) obj, null) : null, cls);
        return clsF == null ? obj.getClass() : clsF;
    }
}
