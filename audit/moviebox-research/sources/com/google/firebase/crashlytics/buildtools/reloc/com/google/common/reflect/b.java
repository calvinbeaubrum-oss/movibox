package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b<T, R> extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.a implements GenericDeclaration {

    /* JADX INFO: compiled from: source.java */
    public static class a<T> extends b<T, T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Constructor<?> f39908c;

        public a(Constructor<?> constructor) {
            super(constructor);
            this.f39908c = constructor;
        }

        public Type[] b() {
            Type[] genericParameterTypes = this.f39908c.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !c()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f39908c.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        public final boolean c() {
            Class<?> declaringClass = this.f39908c.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            return (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.f39908c.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0420b<T> extends b<T, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f39909c;

        public C0420b(Method method) {
            super(method);
            this.f39909c = method;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.f39909c.getTypeParameters();
        }
    }

    public <M extends AccessibleObject & Member> b(M m11) {
        super(m11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.a
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.a, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.a
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.a
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
