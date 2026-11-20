package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.m;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.m2;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t7;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v2;
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
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class TypeToken<T> extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.d<T> implements Serializable {
    private transient f covariantTypeResolver;
    private transient f invariantTypeResolver;
    private final Type runtimeType;

    /* JADX INFO: compiled from: source.java */
    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient ImmutableSet<TypeToken<? super T>> f39882a;

        public ClassSet() {
            super();
        }

        public /* synthetic */ ClassSet(TypeToken typeToken, a aVar) {
            this();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f39882a;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetI = m2.f(TypeCollector.f39886a.a().d(TypeToken.this)).e(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).i();
            this.f39882a = immutableSetI;
            return immutableSetI;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) TypeCollector.f39887b.a().c(TypeToken.this.getRawTypes()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient TypeToken<T>.TypeSet f39883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient ImmutableSet<TypeToken<? super T>> f39884b;

        /* JADX INFO: compiled from: source.java */
        public class a implements n<Class<?>> {
            public a() {
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(Class<?> cls) {
                return cls.isInterface();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
            public /* synthetic */ boolean test(Object obj) {
                return m.a(this, obj);
            }
        }

        public InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.f39883a = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f39884b;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetI = m2.f(this.f39883a).e(TypeFilter.INTERFACE_ONLY).i();
            this.f39884b = immutableSetI;
            return immutableSetI;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return m2.f(TypeCollector.f39887b.c(TypeToken.this.getRawTypes())).e(new a()).i();
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
        public static final TypeCollector<TypeToken<?>> f39886a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeCollector<Class<?>> f39887b = new b();

        /* JADX INFO: compiled from: source.java */
        public static class a extends TypeCollector<TypeToken<?>> {
            public a() {
                super(null);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static class b extends TypeCollector<Class<?>> {
            public b() {
                super(null);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(Class<?> cls) {
                return cls;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class c extends d<K> {
            public c(TypeCollector typeCollector) {
                super(typeCollector);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeCollector
            public ImmutableList<K> c(Iterable<? extends K> iterable) {
                ImmutableList.b bVarBuilder = ImmutableList.builder();
                for (K k11 : iterable) {
                    if (!f(k11).isInterface()) {
                        bVarBuilder.a(k11);
                    }
                }
                return super.c(bVarBuilder.h());
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeCollector
            public Iterable<? extends K> e(K k11) {
                return ImmutableSet.of();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static class d<K> extends TypeCollector<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final TypeCollector<K> f39889c;

            public d(TypeCollector<K> typeCollector) {
                super(null);
                this.f39889c = typeCollector;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeCollector
            public Class<?> f(K k11) {
                return this.f39889c.f(k11);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeCollector
            public K g(K k11) {
                return this.f39889c.g(k11);
            }
        }

        public TypeCollector() {
        }

        public /* synthetic */ TypeCollector(a aVar) {
            this();
        }

        public static <K, V> ImmutableList<K> h(final Map<K, V> map, final Comparator<? super V> comparator) {
            return (ImmutableList<K>) new Ordering<K>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeCollector.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering, java.util.Comparator
                public int compare(K k11, K k12) {
                    return comparator.compare(map.get(k11), map.get(k12));
                }
            }.immutableSortedCopy(map.keySet());
        }

        public final TypeCollector<K> a() {
            return new c(this);
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
            HashMap mapM = Maps.m();
            Iterator<? extends K> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next(), mapM);
            }
            return h(mapM, Ordering.natural().reverse());
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
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeFilter.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeFilter, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
            public boolean apply(TypeToken<?> typeToken) {
                return ((((TypeToken) typeToken).runtimeType instanceof TypeVariable) || (((TypeToken) typeToken).runtimeType instanceof WildcardType)) ? false : true;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeFilter, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return m.a(this, obj);
            }
        },
        INTERFACE_ONLY { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeFilter.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeFilter, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken.TypeFilter, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return m.a(this, obj);
            }
        };

        /* synthetic */ TypeFilter(a aVar) {
            this();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        public abstract /* synthetic */ boolean apply(TypeToken<?> typeToken);

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Object obj) {
            return m.a(this, obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class TypeSet extends v2<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> types;

        public TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(TypeToken.this, null);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetI = m2.f(TypeCollector.f39886a.d(TypeToken.this)).e(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).i();
            this.types = immutableSetI;
            return immutableSetI;
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) TypeCollector.f39887b.c(TypeToken.this.getRawTypes()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.b.C0420b<T> {
        public a(Method method) {
            super(method);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.a
        public String toString() {
            return a() + InstructionFileId.DOT + super.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.b.a<T> {
        public b(Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.b.a
        public Type[] b() {
            return TypeToken.this.getInvariantTypeResolver().l(super.b());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.a
        public String toString() {
            return a() + "(" + com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.e.g(", ").e(b()) + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends g {
        public c() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            throw new IllegalArgumentException(TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImmutableSet.a f39893b;

        public d(ImmutableSet.a aVar) {
            this.f39893b = aVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void b(Class<?> cls) {
            this.f39893b.a(cls);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void c(GenericArrayType genericArrayType) {
            this.f39893b.a(Types.i(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            this.f39893b.a((Class) parameterizedType.getRawType());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type[] f39895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f39896b;

        public e(Type[] typeArr, boolean z11) {
            this.f39895a = typeArr;
            this.f39896b = z11;
        }

        public boolean a(Type type) {
            for (Type type2 : this.f39895a) {
                boolean zIsSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z11 = this.f39896b;
                if (zIsSubtypeOf == z11) {
                    return z11;
                }
            }
            return !this.f39896b;
        }

        public boolean b(Type type) {
            TypeToken<?> typeTokenOf = TypeToken.of(type);
            for (Type type2 : this.f39895a) {
                boolean zIsSubtypeOf = typeTokenOf.isSubtypeOf(type2);
                boolean z11 = this.f39896b;
                if (zIsSubtypeOf == z11) {
                    return z11;
                }
            }
            return !this.f39896b;
        }
    }

    public TypeToken() {
        Type typeCapture = capture();
        this.runtimeType = typeCapture;
        l.w(!(typeCapture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", typeCapture);
    }

    public TypeToken(Class<?> cls) {
        Type typeCapture = super.capture();
        if (typeCapture instanceof Class) {
            this.runtimeType = typeCapture;
        } else {
            this.runtimeType = f.d(cls).j(typeCapture);
        }
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) l.n(type);
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
        ImmutableList.b bVarBuilder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> typeTokenOf = of(type);
            if (typeTokenOf.getRawType().isInterface()) {
                bVarBuilder.a(typeTokenOf);
            }
        }
        return bVarBuilder.h();
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
        return Types.n(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type canonicalizeWildcardsInType(Type type) {
        if (type instanceof ParameterizedType) {
            return canonicalizeWildcardsInParameterizedType((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? Types.k(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static e every(Type[] typeArr) {
        return new e(typeArr, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(((TypeToken) l.p(getComponentType(), "%s isn't a super type of %s", cls, this)).getSupertype(cls.getComponentType()).runtimeType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f getCovariantTypeResolver() {
        f fVar = this.covariantTypeResolver;
        if (fVar != null) {
            return fVar;
        }
        f fVarD = f.d(this.runtimeType);
        this.covariantTypeResolver = fVarD;
        return fVarD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f getInvariantTypeResolver() {
        f fVar = this.invariantTypeResolver;
        if (fVar != null) {
            return fVar;
        }
        f fVarF = f.f(this.runtimeType);
        this.invariantTypeResolver = fVarF;
        return fVarF;
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
        new d(aVarBuilder).a(this.runtimeType);
        return aVarBuilder.g();
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
        return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.m.b().contains(this.runtimeType);
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
        return new f().n(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).j(genericType.runtimeType);
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        t7<Class<? super T>> it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.k(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        return (typeParameters.length > 0 || !(type == null || type == cls.getEnclosingClass())) ? (TypeToken<? extends T>) of(Types.n(type, cls, typeParameters)) : of((Class) cls);
    }

    public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.b<T, T> constructor(Constructor<?> constructor) {
        l.k(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new b(constructor);
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    public final TypeToken<?> getComponentType() {
        Type typeJ = Types.j(this.runtimeType);
        if (typeJ == null) {
            return null;
        }
        return of(typeJ);
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.b bVarBuilder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            bVarBuilder.a(resolveSupertype(type2));
        }
        return bVarBuilder.h();
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
        l.j(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        l.k(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(cls));
        l.k(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        l.k(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
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
        l.n(type);
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

    public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.b<T, Object> method(Method method) {
        l.k(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    public final TypeToken<T> rejectTypeVariables() {
        new c().a(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        l.n(type);
        return of(getInvariantTypeResolver().j(type));
    }

    public String toString() {
        return Types.t(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? of(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.m.c((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.e<X> eVar, TypeToken<X> typeToken) {
        new f();
        throw null;
    }

    public final <X> TypeToken<T> where(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.e<X> eVar, Class<X> cls) {
        return where(eVar, of((Class) cls));
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.m.d((Class) this.runtimeType)) : this;
    }

    public Object writeReplace() {
        return of(new f().j(this.runtimeType));
    }
}
