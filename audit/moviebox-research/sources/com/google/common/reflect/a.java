package com.google.common.reflect;

import com.google.common.base.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T, R> implements AnnotatedElement, Member {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f38832c = b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibleObject f38833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Member f38834b;

    /* JADX INFO: renamed from: com.google.common.reflect.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0401a<T> extends a<T, T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Constructor<?> f38835d;

        public C0401a(Constructor<?> constructor) {
            super(constructor);
            this.f38835d = constructor;
        }

        public Type[] c() {
            Type[] genericParameterTypes = this.f38835d.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !d()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f38835d.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        public final boolean d() {
            Class<?> declaringClass = this.f38835d.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            return (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b<T> extends a<T, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f38836d;

        public b(Method method) {
            super(method);
            this.f38836d = method;
        }
    }

    public <M extends AccessibleObject & Member> a(M m11) {
        m.p(m11);
        this.f38833a = m11;
        this.f38834b = m11;
    }

    public static boolean b() {
        try {
            Class.forName("java.lang.reflect.AnnotatedType");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public TypeToken<T> a() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a().equals(aVar.a()) && this.f38834b.equals(aVar.f38834b);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f38833a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f38833a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f38833a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) this.f38834b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f38834b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f38834b.getName();
    }

    public int hashCode() {
        return this.f38834b.hashCode();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f38833a.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f38834b.isSynthetic();
    }

    public String toString() {
        return this.f38834b.toString();
    }
}
