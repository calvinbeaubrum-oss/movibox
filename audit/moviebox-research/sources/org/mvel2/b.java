package org.mvel2;

import j30.j;
import j30.k;
import j30.l;
import j30.m;
import j30.n;
import j30.o;
import j30.p;
import j30.q;
import j30.r;
import j30.s;
import j30.t;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.mvel2.util.FastList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, a> f73293a;

    static {
        HashMap map = new HashMap(76, 0.5f);
        f73293a = map;
        m mVar = new m();
        map.put(Integer.class, mVar);
        map.put(Integer.TYPE, mVar);
        r rVar = new r();
        map.put(Short.class, rVar);
        map.put(Short.TYPE, rVar);
        o oVar = new o();
        map.put(Long.class, oVar);
        map.put(Long.TYPE, oVar);
        j30.g gVar = new j30.g();
        map.put(Character.class, gVar);
        map.put(Character.TYPE, gVar);
        j30.e eVar = new j30.e();
        map.put(Byte.class, eVar);
        map.put(Byte.TYPE, eVar);
        k kVar = new k();
        map.put(Float.class, kVar);
        map.put(Float.TYPE, kVar);
        j jVar = new j();
        map.put(Double.class, jVar);
        map.put(Double.TYPE, jVar);
        j30.d dVar = new j30.d();
        map.put(Boolean.class, dVar);
        map.put(Boolean.TYPE, dVar);
        map.put(String.class, new t());
        map.put(Object.class, new p());
        j30.f fVar = new j30.f();
        map.put(Character[].class, fVar);
        map.put(char[].class, new j30.h(fVar, new j30.a(char[].class)));
        map.put(String[].class, new s());
        map.put(Integer[].class, new l());
        map.put(int[].class, new j30.a(int[].class));
        map.put(long[].class, new j30.a(long[].class));
        map.put(double[].class, new j30.a(double[].class));
        map.put(float[].class, new j30.a(float[].class));
        map.put(short[].class, new j30.a(short[].class));
        map.put(boolean[].class, new j30.a(boolean[].class));
        map.put(byte[].class, new j30.a(byte[].class));
        map.put(BigDecimal.class, new j30.b());
        map.put(BigInteger.class, new j30.c());
        n nVar = new n();
        map.put(List.class, nVar);
        map.put(FastList.class, nVar);
        map.put(ArrayList.class, nVar);
        map.put(LinkedList.class, nVar);
        q qVar = new q();
        map.put(Set.class, qVar);
        map.put(HashSet.class, qVar);
        map.put(LinkedHashSet.class, qVar);
        map.put(TreeSet.class, qVar);
    }

    public static boolean a(Class cls, Class cls2) {
        if (t30.p.f(cls, cls2)) {
            return true;
        }
        Map<Class, a> map = f73293a;
        if (map.containsKey(cls)) {
            return map.get(cls).a(t30.p.i(cls2));
        }
        return cls.isArray() && a(cls.getComponentType(), cls2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T b(Object obj, Class<T> cls) {
        if (obj == 0) {
            return null;
        }
        if (cls == obj.getClass() || cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        Map<Class, a> map = f73293a;
        a aVar = map.get(cls);
        if (aVar != null || !cls.isArray()) {
            return (T) aVar.b(obj);
        }
        j30.a aVar2 = new j30.a(cls);
        map.put(cls, aVar2);
        return (T) aVar2.b(obj);
    }
}
