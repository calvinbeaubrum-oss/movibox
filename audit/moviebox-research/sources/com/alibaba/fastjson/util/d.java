package com.alibaba.fastjson.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements Comparable<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f15533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Field f15534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15535d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<?> f15536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Type f15537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class<?> f15538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f15539i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f15540j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f15541k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f15542l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j7.b f15543m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j7.b f15544n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f15545o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f15546p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final char[] f15547q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f15548r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f15549s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f15550t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f15551u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String[] f15552v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f15553w;

    public d(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i11, int i12, int i13) {
        this.f15535d = 0;
        i11 = i11 < 0 ? 0 : i11;
        this.f15532a = str;
        this.f15538h = cls;
        this.f15536f = cls2;
        this.f15537g = type;
        this.f15533b = null;
        this.f15534c = field;
        this.f15535d = i11;
        this.f15540j = i12;
        this.f15541k = i13;
        this.f15548r = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f15545o = true;
            this.f15546p = Modifier.isTransient(modifiers);
        } else {
            this.f15546p = false;
            this.f15545o = false;
        }
        this.f15547q = b();
        if (field != null) {
            TypeUtils.M0(field);
        }
        this.f15542l = "";
        j7.b bVar = field == null ? null : (j7.b) TypeUtils.O(field, j7.b.class);
        this.f15543m = bVar;
        this.f15544n = null;
        this.f15539i = false;
        this.f15549s = false;
        this.f15550t = false;
        this.f15551u = null;
        this.f15552v = new String[0];
        this.f15553w = o(str, bVar);
    }

    public d(String str, Method method, Field field, Class<?> cls, Type type, int i11, int i12, int i13, j7.b bVar, j7.b bVar2, String str2) {
        this(str, method, field, cls, type, i11, i12, i13, bVar, bVar2, str2, null);
    }

    public d(String str, Method method, Field field, Class<?> cls, Type type, int i11, int i12, int i13, j7.b bVar, j7.b bVar2, String str2, Map<TypeVariable, Type> map) {
        boolean zJsonDirect;
        boolean zIsFinal;
        Class<?> cls2;
        Type type2;
        Type typeM;
        Class<?> cls3;
        Class<?> cls4;
        Type genericReturnType;
        Class<?> returnType;
        Type type3;
        boolean z11 = false;
        this.f15535d = 0;
        if (field != null) {
            String name = field.getName();
            if (name.equals(str)) {
                str = name;
            }
        }
        i11 = i11 < 0 ? 0 : i11;
        this.f15532a = str;
        this.f15533b = method;
        this.f15534c = field;
        this.f15535d = i11;
        this.f15540j = i12;
        this.f15541k = i13;
        this.f15543m = bVar;
        this.f15544n = bVar2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f15545o = (modifiers & 1) != 0 || method == null;
            this.f15546p = Modifier.isTransient(modifiers) || TypeUtils.y0(method);
        } else {
            this.f15545o = false;
            this.f15546p = TypeUtils.y0(method);
        }
        if (str2 == null || str2.length() <= 0) {
            this.f15542l = "";
        } else {
            this.f15542l = str2;
        }
        j7.b bVarD = d();
        this.f15553w = o(str, bVarD);
        String str3 = null;
        if (bVarD != null) {
            String str4 = bVarD.format();
            str3 = str4.trim().length() != 0 ? str4 : null;
            zJsonDirect = bVarD.jsonDirect();
            this.f15550t = bVarD.unwrapped();
            this.f15552v = bVarD.alternateNames();
        } else {
            this.f15550t = false;
            this.f15552v = new String[0];
            zJsonDirect = false;
        }
        this.f15551u = str3;
        this.f15547q = b();
        if (method != null) {
            TypeUtils.M0(method);
        }
        if (field != null) {
            TypeUtils.M0(field);
        }
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls4 = parameterTypes[0];
                type3 = method.getGenericParameterTypes()[0];
            } else {
                if (parameterTypes.length == 2 && (cls3 = parameterTypes[0]) == String.class && parameterTypes[1] == Object.class) {
                    cls4 = cls3;
                    type3 = cls3;
                } else {
                    zIsFinal = true;
                    returnType = method.getReturnType();
                    genericReturnType = method.getGenericReturnType();
                }
                this.f15538h = method.getDeclaringClass();
                cls2 = returnType;
                type2 = genericReturnType;
            }
            zIsFinal = false;
            returnType = cls4;
            genericReturnType = type3;
            this.f15538h = method.getDeclaringClass();
            cls2 = returnType;
            type2 = genericReturnType;
        } else {
            Class<?> type4 = field.getType();
            Type genericType = field.getGenericType();
            this.f15538h = field.getDeclaringClass();
            zIsFinal = Modifier.isFinal(field.getModifiers());
            cls2 = type4;
            type2 = genericType;
        }
        this.f15539i = zIsFinal;
        if (zJsonDirect && cls2 == String.class) {
            z11 = true;
        }
        this.f15549s = z11;
        if (cls != null && cls2 == Object.class && (type2 instanceof TypeVariable) && (typeM = m(cls, type, (TypeVariable) type2)) != null) {
            this.f15536f = TypeUtils.Q(typeM);
            this.f15537g = typeM;
            this.f15548r = cls2.isEnum();
            return;
        }
        boolean z12 = type2 instanceof Class;
        Class<?> cls5 = cls2;
        Type type5 = type2;
        if (!z12) {
            Type typeK = k(cls, type == null ? cls : type, type2, map);
            Class<?> clsQ = cls2;
            if (typeK != type2) {
                if (typeK instanceof ParameterizedType) {
                    clsQ = TypeUtils.Q(typeK);
                } else if (typeK instanceof Class) {
                    clsQ = cls2;
                    clsQ = TypeUtils.Q(typeK);
                }
            }
            clsQ = cls2;
            type5 = typeK;
            cls5 = clsQ;
        }
        this.f15537g = type5;
        this.f15536f = cls5;
        this.f15548r = cls5.isEnum();
    }

    public static boolean e(Type[] typeArr, Map<TypeVariable, Type> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        boolean z11 = false;
        for (int i11 = 0; i11 < typeArr.length; i11++) {
            Type type = typeArr[i11];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (e(actualTypeArguments, map)) {
                    typeArr[i11] = com.alibaba.fastjson.g.b(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z11 = true;
                }
            } else if ((type instanceof TypeVariable) && map.containsKey(type)) {
                typeArr[i11] = map.get(type);
                z11 = true;
            }
        }
        return z11;
    }

    public static boolean h(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z11 = false;
        for (int i11 = 0; i11 < typeArr.length; i11++) {
            Type type = typeArr[i11];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (h(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i11] = com.alibaba.fastjson.g.b(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z11 = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i12 = 0; i12 < typeVariableArr.length; i12++) {
                    if (type.equals(typeVariableArr[i12])) {
                        typeArr[i11] = typeArr2[i12];
                        z11 = true;
                    }
                }
            }
        }
        return z11;
    }

    public static Type j(Class<?> cls, Type type, Type type2) {
        return k(cls, type, type2, null);
    }

    public static Type k(Class<?> cls, Type type, Type type2, Map<TypeVariable, Type> map) {
        TypeVariable<Class<?>>[] typeParameters;
        ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type typeK = k(cls, type, genericComponentType, map);
                return genericComponentType != typeK ? Array.newInstance(TypeUtils.Q(typeK), 0).getClass() : type2;
            }
            if (!TypeUtils.p0(type)) {
                return type2;
            }
            if (type2 instanceof TypeVariable) {
                ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.Z(type);
                TypeVariable typeVariable = (TypeVariable) type2;
                TypeVariable<Class<?>>[] typeParameters2 = TypeUtils.Q(parameterizedType2).getTypeParameters();
                for (int i11 = 0; i11 < typeParameters2.length; i11++) {
                    if (typeParameters2[i11].getName().equals(typeVariable.getName())) {
                        return parameterizedType2.getActualTypeArguments()[i11];
                    }
                }
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                boolean zE = e(actualTypeArguments, map);
                if (!zE) {
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeParameters = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeParameters = cls.getSuperclass().getTypeParameters();
                    } else {
                        typeParameters = type.getClass().getTypeParameters();
                        parameterizedType = parameterizedType3;
                    }
                    zE = h(actualTypeArguments, typeParameters, parameterizedType.getActualTypeArguments());
                }
                if (zE) {
                    return com.alibaba.fastjson.g.b(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType()));
                }
            }
        }
        return type2;
    }

    public static Type m(Class<?> cls, Type type, TypeVariable<?> typeVariable) {
        Type[] actualTypeArguments;
        Class<?> cls2 = typeVariable.getGenericDeclaration() instanceof Class ? (Class) typeVariable.getGenericDeclaration() : null;
        if (cls2 == cls) {
            actualTypeArguments = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
        } else {
            Type[] typeArr = null;
            while (cls != null && cls != Object.class && cls != cls2) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    h(actualTypeArguments2, cls.getTypeParameters(), typeArr);
                    typeArr = actualTypeArguments2;
                }
                cls = cls.getSuperclass();
            }
            actualTypeArguments = typeArr;
        }
        if (actualTypeArguments == null || cls2 == null) {
            return null;
        }
        TypeVariable<Class<?>>[] typeParameters = cls2.getTypeParameters();
        for (int i11 = 0; i11 < typeParameters.length; i11++) {
            if (typeVariable.equals(typeParameters[i11])) {
                return actualTypeArguments[i11];
            }
        }
        return null;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        Method method = dVar.f15533b;
        if (method != null && this.f15533b != null && method.isBridge() && !this.f15533b.isBridge() && dVar.f15533b.getName().equals(this.f15533b.getName())) {
            return 1;
        }
        int i11 = this.f15535d;
        int i12 = dVar.f15535d;
        if (i11 < i12) {
            return -1;
        }
        if (i11 > i12) {
            return 1;
        }
        int iCompareTo = this.f15532a.compareTo(dVar.f15532a);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        Class<?> clsI = i();
        Class<?> clsI2 = dVar.i();
        if (clsI != null && clsI2 != null && clsI != clsI2) {
            if (clsI.isAssignableFrom(clsI2)) {
                return -1;
            }
            if (clsI2.isAssignableFrom(clsI)) {
                return 1;
            }
        }
        Field field = this.f15534c;
        boolean z11 = false;
        boolean z12 = field != null && field.getType() == this.f15536f;
        Field field2 = dVar.f15534c;
        if (field2 != null && field2.getType() == dVar.f15536f) {
            z11 = true;
        }
        if (z12 && !z11) {
            return 1;
        }
        if (z11 && !z12) {
            return -1;
        }
        if (dVar.f15536f.isPrimitive() && !this.f15536f.isPrimitive()) {
            return 1;
        }
        if (this.f15536f.isPrimitive() && !dVar.f15536f.isPrimitive()) {
            return -1;
        }
        if (dVar.f15536f.getName().startsWith("java.") && !this.f15536f.getName().startsWith("java.")) {
            return 1;
        }
        if (!this.f15536f.getName().startsWith("java.") || dVar.f15536f.getName().startsWith("java.")) {
            return this.f15536f.getName().compareTo(dVar.f15536f.getName());
        }
        return -1;
    }

    public char[] b() {
        int length = this.f15532a.length();
        char[] cArr = new char[length + 3];
        String str = this.f15532a;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    public Object c(Object obj) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f15533b;
        return method != null ? method.invoke(obj, new Object[0]) : this.f15534c.get(obj);
    }

    public j7.b d() {
        j7.b bVar = this.f15543m;
        return bVar != null ? bVar : this.f15544n;
    }

    public Class<?> i() {
        Method method = this.f15533b;
        if (method != null) {
            return method.getDeclaringClass();
        }
        Field field = this.f15534c;
        if (field != null) {
            return field.getDeclaringClass();
        }
        return null;
    }

    public String l() {
        return this.f15551u;
    }

    public Member n() {
        Method method = this.f15533b;
        return method != null ? method : this.f15534c;
    }

    public final long o(String str, j7.b bVar) {
        return (bVar == null || bVar.name().length() == 0) ? TypeUtils.K(str) : TypeUtils.L(str);
    }

    public void p(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f15533b;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.f15534c.set(obj, obj2);
        }
    }

    public void q() throws SecurityException {
        Method method = this.f15533b;
        if (method != null) {
            TypeUtils.M0(method);
        } else {
            TypeUtils.M0(this.f15534c);
        }
    }

    public String toString() {
        return this.f15532a;
    }
}
