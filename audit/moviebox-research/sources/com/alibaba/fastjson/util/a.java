package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;
import m7.b2;
import m7.o;
import n7.a0;
import n7.b0;
import n7.b1;
import n7.c1;
import n7.e1;
import n7.f1;
import n7.g1;
import n7.h1;
import n7.i1;
import n7.j1;
import n7.m1;
import n7.o0;
import n7.p;
import n7.p0;
import n7.q;
import n7.r0;
import n7.s0;
import n7.x0;
import n7.z0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends ClassLoader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, Class<?>> f15529b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ProtectionDomain f15528a = (ProtectionDomain) AccessController.doPrivileged(new C0161a());

    /* JADX INFO: renamed from: com.alibaba.fastjson.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0161a implements PrivilegedAction<Object> {
        @Override // java.security.PrivilegedAction
        public Object run() {
            return a.class.getProtectionDomain();
        }
    }

    static {
        Class<?>[] clsArr = {com.alibaba.fastjson.a.class, JSONObject.class, JSONArray.class, JSONPath.class, com.alibaba.fastjson.b.class, JSONException.class, JSONPathException.class, com.alibaba.fastjson.d.class, com.alibaba.fastjson.e.class, com.alibaba.fastjson.f.class, com.alibaba.fastjson.g.class, d.class, TypeUtils.class, f.class, g.class, ParameterizedTypeImpl.class, h.class, z0.class, p0.class, i1.class, f1.class, o0.class, j1.class, h1.class, s0.class, r0.class, b0.class, n7.i.class, q.class, x0.class, b1.class, c1.class, m1.class, SerializerFeature.class, a0.class, e1.class, g1.class, o.class, l7.h.class, l7.a.class, l7.b.class, l7.c.class, l7.g.class, l7.f.class, l7.i.class, Feature.class, l7.e.class, l7.d.class, m7.d.class, b2.class, m7.j.class, m7.i.class, m7.k.class, p.class, m7.l.class, m7.f.class};
        for (int i11 = 0; i11 < 56; i11++) {
            Class<?> cls = clsArr[i11];
            f15529b.put(cls.getName(), cls);
        }
    }

    public a() {
        super(b());
    }

    public a(ClassLoader classLoader) {
        super(classLoader);
    }

    public static ClassLoader b() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                contextClassLoader.loadClass(com.alibaba.fastjson.a.class.getName());
                return contextClassLoader;
            } catch (ClassNotFoundException unused) {
            }
        }
        return com.alibaba.fastjson.a.class.getClassLoader();
    }

    public Class<?> a(String str, byte[] bArr, int i11, int i12) throws ClassFormatError {
        return defineClass(str, bArr, i11, i12, f15528a);
    }

    public boolean c(Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        for (ClassLoader parent = this; parent != null; parent = parent.getParent()) {
            if (parent == classLoader) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z11) throws ClassNotFoundException {
        Class<?> cls = f15529b.get(str);
        return cls != null ? cls : super.loadClass(str, z11);
    }
}
