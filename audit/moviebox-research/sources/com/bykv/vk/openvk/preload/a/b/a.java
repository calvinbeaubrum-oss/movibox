package com.bykv.vk.openvk.preload.a.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Type[] f25371a = new Type[0];

    /* JADX INFO: renamed from: com.bykv.vk.openvk.preload.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0213a implements Serializable, GenericArrayType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f25372a;

        public C0213a(Type type) {
            this.f25372a = a.a(type);
        }

        public final boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && a.a(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.f25372a;
        }

        public final int hashCode() {
            return this.f25372a.hashCode();
        }

        public final String toString() {
            return a.c(this.f25372a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements Serializable, ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f25373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Type f25374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Type[] f25375c;

        public b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z11 = true;
                boolean z12 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z12) {
                    z11 = false;
                }
                com.bykv.vk.openvk.preload.falconx.a.a.a(z11);
            }
            this.f25373a = type == null ? null : a.a(type);
            this.f25374b = a.a(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.f25375c = typeArr2;
            int length = typeArr2.length;
            for (int i11 = 0; i11 < length; i11++) {
                com.bykv.vk.openvk.preload.falconx.a.a.a(this.f25375c[i11]);
                a.e(this.f25375c[i11]);
                Type[] typeArr3 = this.f25375c;
                typeArr3[i11] = a.a(typeArr3[i11]);
            }
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && a.a(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return (Type[]) this.f25375c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return this.f25373a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.f25374b;
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.f25375c) ^ this.f25374b.hashCode()) ^ a.a((Object) this.f25373a);
        }

        public final String toString() {
            int length = this.f25375c.length;
            if (length == 0) {
                return a.c(this.f25374b);
            }
            StringBuilder sb2 = new StringBuilder((length + 1) * 30);
            sb2.append(a.c(this.f25374b));
            sb2.append("<");
            sb2.append(a.c(this.f25375c[0]));
            for (int i11 = 1; i11 < length; i11++) {
                sb2.append(", ");
                sb2.append(a.c(this.f25375c[i11]));
            }
            sb2.append(">");
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements Serializable, WildcardType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f25376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Type f25377b;

        public c(Type[] typeArr, Type[] typeArr2) {
            com.bykv.vk.openvk.preload.falconx.a.a.a(typeArr2.length <= 1);
            com.bykv.vk.openvk.preload.falconx.a.a.a(typeArr.length == 1);
            if (typeArr2.length != 1) {
                com.bykv.vk.openvk.preload.falconx.a.a.a(typeArr[0]);
                a.e(typeArr[0]);
                this.f25377b = null;
                this.f25376a = a.a(typeArr[0]);
                return;
            }
            com.bykv.vk.openvk.preload.falconx.a.a.a(typeArr2[0]);
            a.e(typeArr2[0]);
            com.bykv.vk.openvk.preload.falconx.a.a.a(typeArr[0] == Object.class);
            this.f25377b = a.a(typeArr2[0]);
            this.f25376a = Object.class;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof WildcardType) && a.a(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            Type type = this.f25377b;
            return type != null ? new Type[]{type} : a.f25371a;
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            return new Type[]{this.f25376a};
        }

        public final int hashCode() {
            Type type = this.f25377b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f25376a.hashCode() + 31);
        }

        public final String toString() {
            if (this.f25377b != null) {
                return "? super " + a.c(this.f25377b);
            }
            if (this.f25376a == Object.class) {
                return "?";
            }
            return "? extends " + a.c(this.f25376a);
        }
    }

    public static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static Type a(Type type) {
        Type c0213a;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                c0213a = cls;
                c0213a = new C0213a(a((Type) cls.getComponentType()));
            }
            c0213a = cls;
            return c0213a;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new C0213a(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static Type a(Type type, Class<?> cls) {
        Type typeB = b(type, cls, Collection.class);
        if (typeB instanceof WildcardType) {
            typeB = ((WildcardType) typeB).getUpperBounds()[0];
        }
        return typeB instanceof ParameterizedType ? ((ParameterizedType) typeB).getActualTypeArguments()[0] : Object.class;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0037 A[LOOP:2: B:19:0x0037->B:28:0x0051, LOOP_START, PHI: r5
  0x0037: PHI (r5v2 java.lang.Class<?>) = (r5v1 java.lang.Class<?>), (r5v4 java.lang.Class<?>) binds: [B:18:0x0035, B:28:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:21:0x003b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051 A[LOOP:2: B:19:0x0037->B:28:0x0051, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0041 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x004c A[SYNTHETIC] */
    private static Type a(Type type, Class<?> cls, Class<?> cls2) {
        Class<?> superclass;
        Type genericSuperclass;
        while (cls2 != cls) {
            if (!cls2.isInterface()) {
                if (!cls.isInterface()) {
                    while (cls != Object.class) {
                        superclass = cls.getSuperclass();
                        if (superclass == cls2) {
                            return cls.getGenericSuperclass();
                        }
                        if (cls2.isAssignableFrom(superclass)) {
                            genericSuperclass = cls.getGenericSuperclass();
                        } else {
                            cls = superclass;
                        }
                    }
                }
                return cls2;
            }
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    if (!cls.isInterface()) {
                        while (cls != Object.class) {
                            superclass = cls.getSuperclass();
                            if (superclass == cls2) {
                                return cls.getGenericSuperclass();
                            }
                            if (cls2.isAssignableFrom(superclass)) {
                                genericSuperclass = cls.getGenericSuperclass();
                            } else {
                                cls = superclass;
                            }
                        }
                    }
                    return cls2;
                }
                Class<?> cls3 = interfaces[i11];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i11];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    genericSuperclass = cls.getGenericInterfaces()[i11];
                    superclass = interfaces[i11];
                } else {
                    i11++;
                }
            }
            Type type2 = genericSuperclass;
            cls = superclass;
            type = type2;
        }
        return type;
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        return a(type, cls, type2, new HashSet());
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0049  */
    private static Type a(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        Type type3;
        WildcardType wildcardType;
        Type[] lowerBounds;
        TypeVariable typeVariable;
        do {
            int i11 = 0;
            if (!(type2 instanceof TypeVariable)) {
                if (type2 instanceof Class) {
                    Class cls2 = (Class) type2;
                    if (cls2.isArray()) {
                        Class<?> componentType = cls2.getComponentType();
                        Type typeA = a(type, cls, componentType, collection);
                        return componentType == typeA ? cls2 : f(typeA);
                    }
                }
                if (type2 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type2;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type typeA2 = a(type, cls, genericComponentType, collection);
                    return genericComponentType == typeA2 ? genericArrayType : f(typeA2);
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type2;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type typeA3 = a(type, cls, ownerType, collection);
                    boolean z11 = typeA3 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length = actualTypeArguments.length;
                    while (i11 < length) {
                        Type typeA4 = a(type, cls, actualTypeArguments[i11], collection);
                        if (typeA4 != actualTypeArguments[i11]) {
                            if (!z11) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z11 = true;
                            }
                            actualTypeArguments[i11] = typeA4;
                        }
                        i11++;
                    }
                    return z11 ? new b(typeA3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
                }
                if (type2 instanceof WildcardType) {
                    wildcardType = (WildcardType) type2;
                    Type[] lowerBounds2 = wildcardType.getLowerBounds();
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    if (lowerBounds2.length == 1) {
                        Type typeA5 = a(type, cls, lowerBounds2[0], collection);
                        if (typeA5 != lowerBounds2[0]) {
                            if (typeA5 instanceof WildcardType) {
                                type3 = type2;
                                type3 = wildcardType;
                                lowerBounds = ((WildcardType) typeA5).getLowerBounds();
                            } else {
                                type3 = type2;
                                type3 = wildcardType;
                                lowerBounds = new Type[]{typeA5};
                            }
                            return new c(new Type[]{Object.class}, lowerBounds);
                        }
                    } else if (upperBounds.length == 1) {
                        type3 = type2;
                        type3 = wildcardType;
                        Type typeA6 = a(type, cls, upperBounds[0], collection);
                        type3 = wildcardType;
                        if (typeA6 != upperBounds[0]) {
                            return new c(typeA6 instanceof WildcardType ? ((WildcardType) typeA6).getUpperBounds() : new Type[]{typeA6}, f25371a);
                        }
                    }
                }
                type3 = type2;
                type3 = wildcardType;
                type3 = type2;
                type3 = wildcardType;
                type3 = type2;
                return type3;
            }
            typeVariable = (TypeVariable) type2;
            if (collection.contains(typeVariable)) {
                return type2;
            }
            collection.add(typeVariable);
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            Class cls3 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
            if (cls3 != null) {
                Type typeA7 = a(type, cls, (Class<?>) cls3);
                if (typeA7 instanceof ParameterizedType) {
                    TypeVariable[] typeParameters = cls3.getTypeParameters();
                    int length2 = typeParameters.length;
                    while (true) {
                        if (i11 >= length2) {
                            throw new NoSuchElementException();
                        }
                        if (typeVariable.equals(typeParameters[i11])) {
                            type2 = ((ParameterizedType) typeA7).getActualTypeArguments()[i11];
                            break;
                        }
                        i11++;
                    }
                } else {
                    type2 = typeVariable;
                }
            } else {
                type2 = typeVariable;
            }
        } while (type2 != typeVariable);
        return type2;
    }

    public static boolean a(Type type, Type type2) {
        while (type != type2) {
            if (type instanceof Class) {
                return type.equals(type2);
            }
            if (type instanceof ParameterizedType) {
                if (!(type2 instanceof ParameterizedType)) {
                    return false;
                }
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type ownerType = parameterizedType.getOwnerType();
                Type ownerType2 = parameterizedType2.getOwnerType();
                return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            }
            if (!(type instanceof GenericArrayType)) {
                if (type instanceof WildcardType) {
                    if (!(type2 instanceof WildcardType)) {
                        return false;
                    }
                    WildcardType wildcardType = (WildcardType) type;
                    WildcardType wildcardType2 = (WildcardType) type2;
                    return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
                }
                if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) type;
                TypeVariable typeVariable2 = (TypeVariable) type2;
                return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
            }
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            type = ((GenericArrayType) type).getGenericComponentType();
            type2 = ((GenericArrayType) type2).getGenericComponentType();
        }
        return true;
    }

    public static Class<?> b(Type type) {
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                com.bykv.vk.openvk.preload.falconx.a.a.a(rawType instanceof Class);
                return (Class) rawType;
            }
            if (type instanceof GenericArrayType) {
                return Array.newInstance(b(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            }
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (!(type instanceof WildcardType)) {
                throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
            }
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        return (Class) type;
    }

    private static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        com.bykv.vk.openvk.preload.falconx.a.a.a(cls2.isAssignableFrom(cls));
        return a(type, cls, a(type, cls, cls2));
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type typeB = b(type, cls, Map.class);
        return typeB instanceof ParameterizedType ? ((ParameterizedType) typeB).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    public static String c(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type d(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static void e(Type type) {
        com.bykv.vk.openvk.preload.falconx.a.a.a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    private static GenericArrayType f(Type type) {
        return new C0213a(type);
    }
}
