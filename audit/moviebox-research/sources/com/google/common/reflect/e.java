package com.google.common.reflect;

import com.google.common.base.j;
import com.google.common.base.m;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
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
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f38837a;

    /* JADX INFO: compiled from: source.java */
    public class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f38838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Type f38839c;

        public a(Map map, Type type) {
            this.f38838b = map;
            this.f38839c = type;
        }

        @Override // com.google.common.reflect.g
        public void b(Class<?> cls) {
            if (this.f38839c instanceof WildcardType) {
                return;
            }
            throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.f38839c);
        }

        @Override // com.google.common.reflect.g
        public void c(GenericArrayType genericArrayType) {
            Type type = this.f38839c;
            if (type instanceof WildcardType) {
                return;
            }
            Type typeI = Types.i(type);
            m.k(typeI != null, "%s is not an array type.", this.f38839c);
            e.g(this.f38838b, genericArrayType.getGenericComponentType(), typeI);
        }

        @Override // com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            Type type = this.f38839c;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) e.e(ParameterizedType.class, type);
            if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                e.g(this.f38838b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            m.l(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f38839c);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            m.l(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
                e.g(this.f38838b, actualTypeArguments[i11], actualTypeArguments2[i11]);
            }
        }

        @Override // com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            this.f38838b.put(new d(typeVariable), this.f38839c);
        }

        @Override // com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            Type type = this.f38839c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                m.l(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f38839c);
                for (int i11 = 0; i11 < upperBounds.length; i11++) {
                    e.g(this.f38838b, upperBounds[i11], upperBounds2[i11]);
                }
                for (int i12 = 0; i12 < lowerBounds.length; i12++) {
                    e.g(this.f38838b, lowerBounds[i12], lowerBounds2[i12]);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<d, Type> f38840b = Maps.o();

        public static ImmutableMap<d, Type> g(Type type) {
            m.p(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf((Map) bVar.f38840b);
        }

        @Override // com.google.common.reflect.g
        public void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            m.v(typeParameters.length == actualTypeArguments.length);
            for (int i11 = 0; i11 < typeParameters.length; i11++) {
                h(new d(typeParameters[i11]), actualTypeArguments[i11]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }

        public final void h(d dVar, Type type) {
            if (this.f38840b.containsKey(dVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (dVar.a(type2)) {
                    while (type != null) {
                        type = this.f38840b.remove(d.c(type));
                    }
                    return;
                }
                type2 = this.f38840b.get(d.c(type2));
            }
            this.f38840b.put(dVar, type);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<d, Type> f38841a;

        /* JADX INFO: compiled from: source.java */
        public class a extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TypeVariable f38842b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f38843c;

            public a(c cVar, TypeVariable typeVariable, c cVar2) {
                this.f38842b = typeVariable;
                this.f38843c = cVar2;
            }

            @Override // com.google.common.reflect.e.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.f38842b.getGenericDeclaration()) ? typeVariable : this.f38843c.b(typeVariable, cVar);
            }
        }

        public c() {
            this.f38841a = ImmutableMap.of();
        }

        public c(ImmutableMap<d, Type> immutableMap) {
            this.f38841a = immutableMap;
        }

        public final Type a(TypeVariable<?> typeVariable) {
            return b(typeVariable, new a(this, typeVariable, this));
        }

        public Type b(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.f38841a.get(new d(typeVariable));
            a aVar = null;
            if (type != null) {
                return new e(cVar, aVar).j(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] typeArrK = new e(cVar, aVar).k(bounds);
            return (Types.b.f38826a && Arrays.equals(bounds, typeArrK)) ? typeVariable : Types.k(typeVariable.getGenericDeclaration(), typeVariable.getName(), typeArrK);
        }

        public final c c(Map<d, ? extends Type> map) {
            ImmutableMap.b bVarBuilder = ImmutableMap.builder();
            bVarBuilder.j(this.f38841a);
            for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
                d key = entry.getKey();
                Type value = entry.getValue();
                m.k(!key.a(value), "Type variable %s bound to itself", key);
                bVarBuilder.g(key, value);
            }
            return new c(bVarBuilder.d());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TypeVariable<?> f38844a;

        public d(TypeVariable<?> typeVariable) {
            this.f38844a = (TypeVariable) m.p(typeVariable);
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
            return this.f38844a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f38844a.getName().equals(typeVariable.getName());
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).f38844a);
            }
            return false;
        }

        public int hashCode() {
            return j.b(this.f38844a.getGenericDeclaration(), this.f38844a.getName());
        }

        public String toString() {
            return this.f38844a.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.reflect.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0402e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0402e f38845b = new C0402e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f38846a;

        /* JADX INFO: renamed from: com.google.common.reflect.e$e$a */
        /* JADX INFO: compiled from: source.java */
        public class a extends C0402e {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ TypeVariable f38847c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(C0402e c0402e, AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.f38847c = typeVariable;
            }

            @Override // com.google.common.reflect.e.C0402e
            public TypeVariable<?> b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.f38847c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        public C0402e() {
            this(new AtomicInteger());
        }

        public C0402e(AtomicInteger atomicInteger) {
            this.f38846a = atomicInteger;
        }

        public /* synthetic */ C0402e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        public final Type a(Type type) {
            m.p(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.j(e().a(((GenericArrayType) type).getGenericComponentType()));
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
            return Types.m(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
        }

        public TypeVariable<?> b(Type[] typeArr) {
            return Types.k(C0402e.class, "capture#" + this.f38846a.incrementAndGet() + "-of ? extends " + com.google.common.base.g.g('&').f(typeArr), typeArr);
        }

        public final Type c(Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        public final C0402e d(TypeVariable<?> typeVariable) {
            return new a(this, this.f38846a, typeVariable);
        }

        public final C0402e e() {
            return new C0402e(this.f38846a);
        }
    }

    public e() {
        this.f38837a = new c();
    }

    public e(c cVar) {
        this.f38837a = cVar;
    }

    public /* synthetic */ e(c cVar, a aVar) {
        this(cVar);
    }

    public static e d(Type type) {
        return new e().o(b.g(type));
    }

    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    public static e f(Type type) {
        return new e().o(b.g(C0402e.f38845b.a(type)));
    }

    public static void g(Map<d, Type> map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new a(map, type2).a(type);
    }

    public final Type h(GenericArrayType genericArrayType) {
        return Types.j(j(genericArrayType.getGenericComponentType()));
    }

    public final ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.m(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    public Type j(Type type) {
        m.p(type);
        if (type instanceof TypeVariable) {
            return this.f38837a.a((TypeVariable) type);
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

    public e n(Type type, Type type2) {
        HashMap mapO = Maps.o();
        g(mapO, (Type) m.p(type), (Type) m.p(type2));
        return o(mapO);
    }

    public e o(Map<d, ? extends Type> map) {
        return new e(this.f38837a.c(map));
    }
}
