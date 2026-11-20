package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Type> f39923a = Sets.d();

    public final void a(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.f39923a.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        e((TypeVariable) type);
                    } else if (type instanceof WildcardType) {
                        f((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        d((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        b((Class) type);
                    } else {
                        if (!(type instanceof GenericArrayType)) {
                            throw new AssertionError("Unknown type: " + type);
                        }
                        c((GenericArrayType) type);
                    }
                } catch (Throwable th2) {
                    this.f39923a.remove(type);
                    throw th2;
                }
            }
        }
    }

    public void b(Class<?> cls) {
    }

    public void c(GenericArrayType genericArrayType) {
    }

    public void d(ParameterizedType parameterizedType) {
    }

    public abstract void e(TypeVariable<?> typeVariable);

    public abstract void f(WildcardType wildcardType);
}
