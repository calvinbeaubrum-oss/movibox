package com.alibaba.fastjson;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ConcurrentMap<Type, Type> f15480b = new ConcurrentHashMap(16, 0.75f, 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Type f15481c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f15482a;

    /* JADX INFO: compiled from: source.java */
    public static class a extends g<List<String>> {
    }

    public g() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type type2 = f15480b.get(type);
        if (type2 == null) {
            f15480b.putIfAbsent(type, type);
            type2 = f15480b.get(type);
        }
        this.f15482a = type2;
    }

    public static Type b(ParameterizedTypeImpl parameterizedTypeImpl) {
        Type type = f15480b.get(parameterizedTypeImpl);
        if (type != null) {
            return type;
        }
        f15480b.putIfAbsent(parameterizedTypeImpl, parameterizedTypeImpl);
        return f15480b.get(parameterizedTypeImpl);
    }

    public Type a() {
        return this.f15482a;
    }
}
