package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.j5;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t7;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Types {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<Type, String> f39897a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.e f39898b = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.e.g(", ").i("null");

    /* JADX INFO: compiled from: source.java */
    public enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.ClassOwnership.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.ClassOwnership
            public Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.ClassOwnership.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.ClassOwnership
            public Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };

        static final ClassOwnership JVM_BEHAVIOR = detectJvmBehavior();

        /* JADX INFO: compiled from: source.java */
        public class a<T> {
        }

        /* JADX INFO: compiled from: source.java */
        public static class b extends a<String> {
        }

        /* synthetic */ ClassOwnership(a aVar) {
            this();
        }

        private static ClassOwnership detectJvmBehavior() {
            new b();
            ParameterizedType parameterizedType = (ParameterizedType) b.class.getGenericSuperclass();
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(a.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }

        public abstract Class<?> getOwnerType(Class<?> cls);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Types.t(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum JavaVersion {
        JAVA6 { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion
            public GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                l.n(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
            }
        },
        JAVA7 { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return type instanceof Class ? Types.i((Class) type) : new GenericArrayTypeImpl(type);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return (Type) l.n(type);
            }
        },
        JAVA8 { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return JavaVersion.JAVA7.newArrayType(type);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e11) {
                    e = e11;
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e12) {
                    e = e12;
                    throw new RuntimeException(e);
                }
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return JavaVersion.JAVA7.usedInGenericType(type);
            }
        },
        JAVA9 { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion.4
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion
            public boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return JavaVersion.JAVA8.newArrayType(type);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                return JavaVersion.JAVA8.typeName(type);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return JavaVersion.JAVA8.usedInGenericType(type);
            }
        };

        static final JavaVersion CURRENT;

        /* JADX INFO: compiled from: source.java */
        public static class a extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.d<Map.Entry<String, int[][]>> {
        }

        /* JADX INFO: compiled from: source.java */
        public static class b extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.d<int[]> {
        }

        static {
            JavaVersion javaVersion = JAVA6;
            JavaVersion javaVersion2 = JAVA7;
            JavaVersion javaVersion3 = JAVA8;
            JavaVersion javaVersion4 = JAVA9;
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new a().capture().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = javaVersion3;
                    return;
                } else {
                    CURRENT = javaVersion4;
                    return;
                }
            }
            if (new b().capture() instanceof Class) {
                CURRENT = javaVersion2;
            } else {
                CURRENT = javaVersion;
            }
        }

        /* synthetic */ JavaVersion(a aVar) {
            this();
        }

        public boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        public abstract Type newArrayType(Type type);

        public String typeName(Type type) {
            return Types.t(type);
        }

        public final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList.b bVarBuilder = ImmutableList.builder();
            for (Type type : typeArr) {
                bVarBuilder.a(usedInGenericType(type));
            }
            return bVarBuilder.h();
        }

        public abstract Type usedInGenericType(Type type);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        private final Type ownerType;
        private final Class<?> rawType;

        public ParameterizedTypeImpl(Type type, Class<?> cls, Type[] typeArr) {
            l.n(cls);
            l.d(typeArr.length == cls.getTypeParameters().length);
            Types.g(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.s(this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type type = this.ownerType;
            return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.ownerType != null) {
                JavaVersion javaVersion = JavaVersion.CURRENT;
                if (javaVersion.jdkTypeDuplicatesOwnerName()) {
                    sb2.append(javaVersion.typeName(this.ownerType));
                    sb2.append('.');
                }
            }
            sb2.append(this.rawType.getName());
            sb2.append('<');
            sb2.append(Types.f39898b.c(j5.n(this.argumentsList, Types.f39897a)));
            sb2.append('>');
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.g(typeArr, "lower bound for wildcard");
            Types.g(typeArr2, "upper bound for wildcard");
            JavaVersion javaVersion = JavaVersion.CURRENT;
            this.lowerBounds = javaVersion.usedInGenericType(typeArr);
            this.upperBounds = javaVersion.usedInGenericType(typeArr2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.s(this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.s(this.upperBounds);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("?");
            t7<Type> it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                Type next = it.next();
                sb2.append(" super ");
                sb2.append(JavaVersion.CURRENT.typeName(next));
            }
            for (Type type : Types.h(this.upperBounds)) {
                sb2.append(" extends ");
                sb2.append(JavaVersion.CURRENT.typeName(type));
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<Type, String> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(Type type) {
            return JavaVersion.CURRENT.typeName(type);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f39899b;

        public b(AtomicReference atomicReference) {
            this.f39899b = atomicReference;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void b(Class<?> cls) {
            this.f39899b.set(cls.getComponentType());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void c(GenericArrayType genericArrayType) {
            this.f39899b.set(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            this.f39899b.set(Types.q(typeVariable.getBounds()));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            this.f39899b.set(Types.q(wildcardType.getUpperBounds()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final boolean f39900a = !c.class.getTypeParameters()[0].equals(Types.l(c.class, "X", new Type[0]));
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d<D extends GenericDeclaration> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final D f39901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f39902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImmutableList<Type> f39903c;

        public d(D d11, String str, Type[] typeArr) {
            Types.g(typeArr, "bound for type variable");
            this.f39901a = (D) l.n(d11);
            this.f39902b = (String) l.n(str);
            this.f39903c = ImmutableList.copyOf(typeArr);
        }

        public D a() {
            return this.f39901a;
        }

        public String b() {
            return this.f39902b;
        }

        public boolean equals(Object obj) {
            if (!c.f39900a) {
                if (!(obj instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.f39902b.equals(typeVariable.getName()) && this.f39901a.equals(typeVariable.getGenericDeclaration());
            }
            if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof e)) {
                return false;
            }
            d dVar = ((e) Proxy.getInvocationHandler(obj)).f39905a;
            return this.f39902b.equals(dVar.b()) && this.f39901a.equals(dVar.a()) && this.f39903c.equals(dVar.f39903c);
        }

        public int hashCode() {
            return this.f39901a.hashCode() ^ this.f39902b.hashCode();
        }

        public String toString() {
            return this.f39902b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements InvocationHandler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ImmutableMap<String, Method> f39904b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<?> f39905a;

        static {
            ImmutableMap.b bVarBuilder = ImmutableMap.builder();
            for (Method method : d.class.getMethods()) {
                if (method.getDeclaringClass().equals(d.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    bVarBuilder.d(method.getName(), method);
                }
            }
            f39904b = bVarBuilder.a();
        }

        public e(d<?> dVar) {
            this.f39905a = dVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = f39904b.get(name);
            if (method2 == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.f39905a, objArr);
            } catch (InvocationTargetException e11) {
                throw e11.getCause();
            }
        }
    }

    public static void g(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                l.k(!cls.isPrimitive(), "Primitive type '%s' used as %s", cls, str);
            }
        }
    }

    public static Iterable<Type> h(Iterable<Type> iterable) {
        return j5.d(iterable, Predicates.f(Predicates.c(Object.class)));
    }

    public static Class<?> i(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    public static Type j(Type type) {
        l.n(type);
        AtomicReference atomicReference = new AtomicReference();
        new b(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    public static Type k(Type type) {
        if (!(type instanceof WildcardType)) {
            return JavaVersion.CURRENT.newArrayType(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        l.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return r(k(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        l.e(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return p(k(upperBounds[0]));
    }

    public static <D extends GenericDeclaration> TypeVariable<D> l(D d11, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return o(d11, str, typeArr);
    }

    public static ParameterizedType m(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    public static ParameterizedType n(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return m(cls, typeArr);
        }
        l.n(typeArr);
        l.j(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    public static <D extends GenericDeclaration> TypeVariable<D> o(D d11, String str, Type[] typeArr) {
        return (TypeVariable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.c.a(TypeVariable.class, new e(new d(d11, str, typeArr)));
    }

    public static WildcardType p(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    public static Type q(Type[] typeArr) {
        for (Type type : typeArr) {
            Type typeJ = j(type);
            if (typeJ != null) {
                if (typeJ instanceof Class) {
                    Class cls = (Class) typeJ;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return p(typeJ);
            }
        }
        return null;
    }

    public static WildcardType r(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    public static Type[] s(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    public static String t(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
