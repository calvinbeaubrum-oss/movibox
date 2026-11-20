package com.google.common.reflect;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.common.base.m;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.g1;
import com.google.common.collect.q;
import com.google.common.collect.z;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TypeToken<T> extends com.google.common.reflect.c<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    private transient com.google.common.reflect.e covariantTypeResolver;
    private transient com.google.common.reflect.e invariantTypeResolver;
    private final Type runtimeType;

    /* JADX INFO: compiled from: source.java */
    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient ImmutableSet<TypeToken<? super T>> f38812a;

        public ClassSet() {
            super();
        }

        public /* synthetic */ ClassSet(TypeToken typeToken, a aVar) {
            this();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.z, com.google.common.collect.r, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public Set<TypeToken<? super T>> u() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f38812a;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetI = q.f(TypeCollector.f38815a.a().d(TypeToken.this)).e(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).i();
            this.f38812a = immutableSetI;
            return immutableSetI;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) TypeCollector.f38816b.a().c(TypeToken.this.getRawTypes()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient TypeToken<T>.TypeSet f38813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient ImmutableSet<TypeToken<? super T>> f38814b;

        public InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.f38813a = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.z, com.google.common.collect.r, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public Set<TypeToken<? super T>> u() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f38814b;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetI = q.f(this.f38813a).e(TypeFilter.INTERFACE_ONLY).i();
            this.f38814b = immutableSetI;
            return immutableSetI;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return q.f(TypeCollector.f38816b.c(TypeToken.this.getRawTypes())).e(new n() { // from class: com.google.common.reflect.f
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    return ((Class) obj).isInterface();
                }
            }).i();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        public SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class TypeCollector<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TypeCollector<TypeToken<?>> f38815a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeCollector<Class<?>> f38816b = new b();

        /* JADX INFO: compiled from: source.java */
        public class a extends TypeCollector<TypeToken<?>> {
            public a() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends TypeCollector<Class<?>> {
            public b() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(Class<?> cls) {
                return cls;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class c extends d<K> {
            public c(TypeCollector typeCollector, TypeCollector typeCollector2) {
                super(typeCollector2);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public ImmutableList<K> c(Iterable<? extends K> iterable) {
                ImmutableList.a aVarBuilder = ImmutableList.builder();
                for (K k11 : iterable) {
                    if (!f(k11).isInterface()) {
                        aVarBuilder.a(k11);
                    }
                }
                return super.c(aVarBuilder.m());
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public Iterable<? extends K> e(K k11) {
                return ImmutableSet.of();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static class d<K> extends TypeCollector<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final TypeCollector<K> f38817c;

            public d(TypeCollector<K> typeCollector) {
                super(null);
                this.f38817c = typeCollector;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public Class<?> f(K k11) {
                return this.f38817c.f(k11);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public K g(K k11) {
                return this.f38817c.g(k11);
            }
        }

        public TypeCollector() {
        }

        public /* synthetic */ TypeCollector(a aVar) {
            this();
        }

        public static <K, V> ImmutableList<K> h(final Map<K, V> map, final Comparator<? super V> comparator) {
            return (ImmutableList<K>) new Ordering<K>() { // from class: com.google.common.reflect.TypeToken.TypeCollector.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.Ordering, java.util.Comparator
                public int compare(K k11, K k12) {
                    Comparator comparator2 = comparator;
                    Object obj = map.get(k11);
                    Objects.requireNonNull(obj);
                    Object obj2 = map.get(k12);
                    Objects.requireNonNull(obj2);
                    return comparator2.compare(obj, obj2);
                }
            }.immutableSortedCopy(map.keySet());
        }

        public final TypeCollector<K> a() {
            return new c(this, this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int b(K k11, Map<? super K, Integer> map) {
            Integer num = map.get(k11);
            if (num != null) {
                return num.intValue();
            }
            boolean zIsInterface = f(k11).isInterface();
            Iterator<? extends K> it = e(k11).iterator();
            int iMax = zIsInterface;
            while (it.hasNext()) {
                iMax = Math.max(iMax, b(it.next(), map));
            }
            K kG = g(k11);
            int iMax2 = iMax;
            if (kG != null) {
                iMax2 = Math.max(iMax, b(kG, map));
            }
            int i11 = iMax2 + 1;
            map.put(k11, Integer.valueOf(i11));
            return i11;
        }

        public ImmutableList<K> c(Iterable<? extends K> iterable) {
            HashMap mapO = Maps.o();
            Iterator<? extends K> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next(), mapO);
            }
            return h(mapO, Ordering.natural().reverse());
        }

        public final ImmutableList<K> d(K k11) {
            return c(ImmutableList.of(k11));
        }

        public abstract Iterable<? extends K> e(K k11);

        public abstract Class<?> f(K k11);

        public abstract K g(K k11);
    }

    /* JADX INFO: compiled from: source.java */
    public enum TypeFilter implements n<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
            @Override // com.google.common.reflect.TypeToken.TypeFilter, com.google.common.base.n
            public boolean apply(TypeToken<?> typeToken) {
                return ((((TypeToken) typeToken).runtimeType instanceof TypeVariable) || (((TypeToken) typeToken).runtimeType instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
            @Override // com.google.common.reflect.TypeToken.TypeFilter, com.google.common.base.n
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        };

        /* synthetic */ TypeFilter(a aVar) {
            this();
        }

        @Override // com.google.common.base.n
        public abstract /* synthetic */ boolean apply(TypeToken<?> typeToken);
    }

    /* JADX INFO: compiled from: source.java */
    public class TypeSet extends z<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> types;

        public TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(TypeToken.this, null);
        }

        @Override // com.google.common.collect.z, com.google.common.collect.r, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public Set<TypeToken<? super T>> u() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetI = q.f(TypeCollector.f38815a.d(TypeToken.this)).e(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).i();
            this.types = immutableSetI;
            return immutableSetI;
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) TypeCollector.f38816b.c(TypeToken.this.getRawTypes()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends com.google.common.reflect.a.b<T> {
        public a(Method method) {
            super(method);
        }

        @Override // com.google.common.reflect.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.a
        public String toString() {
            return a() + InstructionFileId.DOT + super.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends com.google.common.reflect.a.C0401a<T> {
        public b(Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.common.reflect.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.a.C0401a
        public Type[] c() {
            return TypeToken.this.getInvariantTypeResolver().l(super.c());
        }

        @Override // com.google.common.reflect.a
        public String toString() {
            return a() + "(" + com.google.common.base.g.h(", ").f(c()) + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends g {
        public c() {
        }

        @Override // com.google.common.reflect.g
        public void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            throw new IllegalArgumentException(TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
        }

        @Override // com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImmutableSet.a f38821b;

        public d(TypeToken typeToken, ImmutableSet.a aVar) {
            this.f38821b = aVar;
        }

        @Override // com.google.common.reflect.g
        public void b(Class<?> cls) {
            this.f38821b.a(cls);
        }

        @Override // com.google.common.reflect.g
        public void c(GenericArrayType genericArrayType) {
            this.f38821b.a(Types.h(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        @Override // com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            this.f38821b.a((Class) parameterizedType.getRawType());
        }

        @Override // com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type[] f38822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f38823b;

        public e(Type[] typeArr, boolean z11) {
            this.f38822a = typeArr;
            this.f38823b = z11;
        }

        public boolean a(Type type) {
            for (Type type2 : this.f38822a) {
                boolean zIsSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z11 = this.f38823b;
                if (zIsSubtypeOf == z11) {
                    return z11;
                }
            }
            return !this.f38823b;
        }

        public boolean b(Type type) {
            TypeToken<?> typeTokenOf = TypeToken.of(type);
            for (Type type2 : this.f38822a) {
                boolean zIsSubtypeOf = typeTokenOf.isSubtypeOf(type2);
                boolean z11 = this.f38823b;
                if (zIsSubtypeOf == z11) {
                    return z11;
                }
            }
            return !this.f38823b;
        }
    }

    public TypeToken() {
        Type typeCapture = capture();
        this.runtimeType = typeCapture;
        m.z(!(typeCapture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", typeCapture);
    }

    public TypeToken(Class<?> cls) {
        Type typeCapture = super.capture();
        if (typeCapture instanceof Class) {
            this.runtimeType = typeCapture;
        } else {
            this.runtimeType = com.google.common.reflect.e.d(cls).j(typeCapture);
        }
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) m.p(type);
    }

    public /* synthetic */ TypeToken(Type type, a aVar) {
        this(type);
    }

    private static e any(Type[] typeArr) {
        return new e(typeArr, true);
    }

    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> typeTokenOf = of(type);
            if (typeTokenOf.getRawType().isInterface()) {
                aVarBuilder.a(typeTokenOf);
            }
        }
        return aVarBuilder.m();
    }

    private static Type canonicalizeTypeArg(TypeVariable<?> typeVariable, Type type) {
        return type instanceof WildcardType ? canonicalizeWildcardType(typeVariable, (WildcardType) type) : canonicalizeWildcardsInType(type);
    }

    private static WildcardType canonicalizeWildcardType(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!any(bounds).a(type)) {
                arrayList.add(canonicalizeWildcardsInType(type));
            }
        }
        return new Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
            actualTypeArguments[i11] = canonicalizeTypeArg(typeParameters[i11], actualTypeArguments[i11]);
        }
        return Types.m(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type canonicalizeWildcardsInType(Type type) {
        if (type instanceof ParameterizedType) {
            return canonicalizeWildcardsInParameterizedType((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? Types.j(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static e every(Type[] typeArr) {
        return new e(typeArr, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType != null) {
            TypeToken<?> componentType2 = getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(componentType2.getSubtype(componentType).runtimeType));
        }
        throw new IllegalArgumentException(cls + " does not appear to be a subtype of " + this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        TypeToken<?> componentType = getComponentType();
        if (componentType != 0) {
            Class<?> componentType2 = cls.getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(componentType.getSupertype(componentType2).runtimeType));
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.reflect.e getCovariantTypeResolver() {
        com.google.common.reflect.e eVar = this.covariantTypeResolver;
        if (eVar != null) {
            return eVar;
        }
        com.google.common.reflect.e eVarD = com.google.common.reflect.e.d(this.runtimeType);
        this.covariantTypeResolver = eVarD;
        return eVarD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.reflect.e getInvariantTypeResolver() {
        com.google.common.reflect.e eVar = this.invariantTypeResolver;
        if (eVar != null) {
            return eVar;
        }
        com.google.common.reflect.e eVarF = com.google.common.reflect.e.f(this.runtimeType);
        this.invariantTypeResolver = eVarF;
        return eVarF;
    }

    private Type getOwnerTypeIfPresent() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getRawTypes() {
        ImmutableSet.a aVarBuilder = ImmutableSet.builder();
        new d(this, aVarBuilder).a(this.runtimeType);
        return aVarBuilder.n();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> typeTokenOf = of(type);
            if (typeTokenOf.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) typeTokenOf.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private boolean is(Type type, TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(type));
        }
        WildcardType wildcardTypeCanonicalizeWildcardType = canonicalizeWildcardType(typeVariable, (WildcardType) type);
        return every(wildcardTypeCanonicalizeWildcardType.getUpperBounds()).b(this.runtimeType) && every(wildcardTypeCanonicalizeWildcardType.getLowerBounds()).a(this.runtimeType);
    }

    private boolean isOwnedBySubtypeOf(Type type) {
        Iterator<TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type ownerTypeIfPresent = it.next().getOwnerTypeIfPresent();
            if (ownerTypeIfPresent != null && of(ownerTypeIfPresent).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (!(type instanceof Class)) {
            if (type instanceof GenericArrayType) {
                return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        }
        return false;
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (!someRawTypeIsSubclassOf(rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i11 = 0; i11 < typeParameters.length; i11++) {
            if (!of(getCovariantTypeResolver().j(typeParameters[i11])).is(actualTypeArguments[i11], typeParameters[i11])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(parameterizedType.getOwnerType());
    }

    private boolean isSupertypeOfArray(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            return !cls.isArray() ? cls.isAssignableFrom(Object[].class) : of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        }
        if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        }
        return false;
    }

    private boolean isWrapper() {
        return com.google.common.primitives.e.b().contains(this.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type type) {
        return Types.JavaVersion.JAVA7.newArrayType(type);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> typeTokenOf = of(getCovariantTypeResolver().j(type));
        typeTokenOf.covariantTypeResolver = this.covariantTypeResolver;
        typeTokenOf.invariantTypeResolver = this.invariantTypeResolver;
        return typeTokenOf;
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if ((this.runtimeType instanceof Class) && (cls.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return cls;
        }
        TypeToken genericType = toGenericType(cls);
        return new com.google.common.reflect.e().n(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).j(genericType.runtimeType);
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        g1<Class<? super T>> it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.j(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        return (typeParameters.length > 0 || !(type == null || type == cls.getEnclosingClass())) ? (TypeToken<? extends T>) of(Types.m(type, cls, typeParameters)) : of((Class) cls);
    }

    public final com.google.common.reflect.a<T, T> constructor(Constructor<?> constructor) {
        m.l(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new b(constructor);
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    public final TypeToken<?> getComponentType() {
        Type typeI = Types.i(this.runtimeType);
        if (typeI == null) {
            return null;
        }
        return of(typeI);
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            aVarBuilder.a(resolveSupertype(type2));
        }
        return aVarBuilder.m();
    }

    public final TypeToken<? super T> getGenericSuperclass() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) resolveSupertype(genericSuperclass);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        m.k(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        m.l(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(cls));
        m.l(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        m.l(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return getSupertypeFromUpperBounds(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return getSupertypeFromUpperBounds(cls, ((WildcardType) type).getUpperBounds());
        }
        return cls.isArray() ? getArraySupertype(cls) : (TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSubtypeOf(Type type) {
        m.p(type);
        if (type instanceof WildcardType) {
            return any(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return any(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).a(type);
        }
        if (type2 instanceof GenericArrayType) {
            return of(type).isSupertypeOfArray((GenericArrayType) this.runtimeType);
        }
        if (type instanceof Class) {
            return someRawTypeIsSubclassOf((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return isSubtypeOfParameterizedType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return isSubtypeOfArrayType((GenericArrayType) type);
        }
        return false;
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public final com.google.common.reflect.a<T, Object> method(Method method) {
        m.l(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    public final TypeToken<T> rejectTypeVariables() {
        new c().a(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        m.p(type);
        return of(getInvariantTypeResolver().j(type));
    }

    public String toString() {
        return Types.s(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? of(com.google.common.primitives.e.c((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(com.google.common.reflect.d<X> dVar, TypeToken<X> typeToken) {
        new com.google.common.reflect.e();
        throw null;
    }

    public final <X> TypeToken<T> where(com.google.common.reflect.d<X> dVar, Class<X> cls) {
        return where(dVar, of((Class) cls));
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(com.google.common.primitives.e.d((Class) this.runtimeType)) : this;
    }

    public Object writeReplace() {
        return of(new com.google.common.reflect.e().j(this.runtimeType));
    }
}
