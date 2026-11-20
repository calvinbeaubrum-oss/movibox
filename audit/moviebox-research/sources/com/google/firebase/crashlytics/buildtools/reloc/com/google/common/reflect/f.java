package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f39910a;

    /* JADX INFO: compiled from: source.java */
    public static class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f39911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Type f39912c;

        public a(Map map, Type type) {
            this.f39911b = map;
            this.f39912c = type;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void b(Class<?> cls) {
            if (this.f39912c instanceof WildcardType) {
                return;
            }
            throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.f39912c);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void c(GenericArrayType genericArrayType) {
            Type type = this.f39912c;
            if (type instanceof WildcardType) {
                return;
            }
            Type typeJ = Types.j(type);
            l.j(typeJ != null, "%s is not an array type.", this.f39912c);
            f.g(this.f39911b, genericArrayType.getGenericComponentType(), typeJ);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            Type type = this.f39912c;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) f.e(ParameterizedType.class, type);
            if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                f.g(this.f39911b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            l.k(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f39912c);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            l.k(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
                f.g(this.f39911b, actualTypeArguments[i11], actualTypeArguments2[i11]);
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            this.f39911b.put(new d(typeVariable), this.f39912c);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            Type type = this.f39912c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                l.k(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f39912c);
                for (int i11 = 0; i11 < upperBounds.length; i11++) {
                    f.g(this.f39911b, upperBounds[i11], upperBounds2[i11]);
                }
                for (int i12 = 0; i12 < lowerBounds.length; i12++) {
                    f.g(this.f39911b, lowerBounds[i12], lowerBounds2[i12]);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<d, Type> f39913b = Maps.m();

        public static ImmutableMap<d, Type> g(Type type) {
            l.n(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf((Map) bVar.f39913b);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            l.t(typeParameters.length == actualTypeArguments.length);
            for (int i11 = 0; i11 < typeParameters.length; i11++) {
                h(new d(typeParameters[i11]), actualTypeArguments[i11]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }

        public final void h(d dVar, Type type) {
            if (this.f39913b.containsKey(dVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (dVar.a(type2)) {
                    while (type != null) {
                        type = this.f39913b.remove(d.c(type));
                    }
                    return;
                }
                type2 = this.f39913b.get(d.c(type2));
            }
            this.f39913b.put(dVar, type);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<d, Type> f39914a;

        /* JADX INFO: compiled from: source.java */
        public class a extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TypeVariable f39915b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f39916c;

            public a(TypeVariable typeVariable, c cVar) {
                this.f39915b = typeVariable;
                this.f39916c = cVar;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.f.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.f39915b.getGenericDeclaration()) ? typeVariable : this.f39916c.b(typeVariable, cVar);
            }
        }

        public c() {
            this.f39914a = ImmutableMap.of();
        }

        public c(ImmutableMap<d, Type> immutableMap) {
            this.f39914a = immutableMap;
        }

        public final Type a(TypeVariable<?> typeVariable) {
            return b(typeVariable, new a(typeVariable, this));
        }

        public Type b(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.f39914a.get(new d(typeVariable));
            a aVar = null;
            if (type != null) {
                return new f(cVar, aVar).j(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] typeArrK = new f(cVar, aVar).k(bounds);
            return (Types.c.f39900a && Arrays.equals(bounds, typeArrK)) ? typeVariable : Types.l(typeVariable.getGenericDeclaration(), typeVariable.getName(), typeArrK);
        }

        public final c c(Map<d, ? extends Type> map) {
            ImmutableMap.b bVarBuilder = ImmutableMap.builder();
            bVarBuilder.g(this.f39914a);
            for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
                d key = entry.getKey();
                Type value = entry.getValue();
                l.j(!key.a(value), "Type variable %s bound to itself", key);
                bVarBuilder.d(key, value);
            }
            return new c(bVarBuilder.a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TypeVariable<?> f39918a;

        public d(TypeVariable<?> typeVariable) {
            this.f39918a = (TypeVariable) l.n(typeVariable);
        }

        public static d c(Type type) {
            if (type instanceof TypeVariable) {
                return new d((TypeVariable) type);
            }
            return null;
        }

        public boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public final boolean b(TypeVariable<?> typeVariable) {
            return this.f39918a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f39918a.getName().equals(typeVariable.getName());
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).f39918a);
            }
            return false;
        }

        public int hashCode() {
            return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.b(this.f39918a.getGenericDeclaration(), this.f39918a.getName());
        }

        public String toString() {
            return this.f39918a.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f39919b = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f39920a;

        /* JADX INFO: compiled from: source.java */
        public class a extends e {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ TypeVariable f39921c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.f39921c = typeVariable;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.f.e
            public TypeVariable<?> b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.f39921c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        public e() {
            this(new AtomicInteger());
        }

        public e(AtomicInteger atomicInteger) {
            this.f39920a = atomicInteger;
        }

        public /* synthetic */ e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        public final Type a(Type type) {
            l.n(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.k(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (!(type instanceof ParameterizedType)) {
                if (!(type instanceof WildcardType)) {
                    throw new AssertionError("must have been one of the known types");
                }
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable<?>[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
                actualTypeArguments[i11] = d(typeParameters[i11]).a(actualTypeArguments[i11]);
            }
            return Types.n(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
        }

        public TypeVariable<?> b(Type[] typeArr) {
            return Types.l(e.class, "capture#" + this.f39920a.incrementAndGet() + "-of ? extends " + com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.e.f('&').e(typeArr), typeArr);
        }

        public final Type c(Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        public final e d(TypeVariable<?> typeVariable) {
            return new a(this.f39920a, typeVariable);
        }

        public final e e() {
            return new e(this.f39920a);
        }
    }

    public f() {
        this.f39910a = new c();
    }

    public f(c cVar) {
        this.f39910a = cVar;
    }

    public /* synthetic */ f(c cVar, a aVar) {
        this(cVar);
    }

    public static f d(Type type) {
        return new f().o(b.g(type));
    }

    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    public static f f(Type type) {
        return new f().o(b.g(e.f39919b.a(type)));
    }

    public static void g(Map<d, Type> map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new a(map, type2).a(type);
    }

    public final Type h(GenericArrayType genericArrayType) {
        return Types.k(j(genericArrayType.getGenericComponentType()));
    }

    public final ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.n(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    public Type j(Type type) {
        l.n(type);
        if (type instanceof TypeVariable) {
            return this.f39910a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        return type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    public final Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i11 = 0; i11 < typeArr.length; i11++) {
            typeArr2[i11] = j(typeArr[i11]);
        }
        return typeArr2;
    }

    public Type[] l(Type[] typeArr) {
        for (int i11 = 0; i11 < typeArr.length; i11++) {
            typeArr[i11] = j(typeArr[i11]);
        }
        return typeArr;
    }

    public final WildcardType m(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public f n(Type type, Type type2) {
        HashMap mapM = Maps.m();
        g(mapM, (Type) l.n(type), (Type) l.n(type2));
        return o(mapM);
    }

    public f o(Map<d, ? extends Type> map) {
        return new f(this.f39910a.c(map));
    }
}
