package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f15577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f15578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Constructor<?> f15579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Constructor<?> f15580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f15581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Method f15582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f15583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d[] f15584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d[] f15585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f15586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j7.d f15587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f15588l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f15589m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String[] f15590n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Type[] f15591o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String[] f15592p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f15593q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Constructor<?> f15594r;

    public h(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, j7.d dVar, List<d> list) {
        j7.b bVar;
        this.f15577a = cls;
        this.f15578b = cls2;
        this.f15579c = constructor;
        this.f15580d = constructor2;
        this.f15581e = method;
        this.f15586j = TypeUtils.f0(cls);
        this.f15582f = method2;
        this.f15587k = dVar;
        if (dVar != null) {
            String strTypeName = dVar.typeName();
            String strTypeKey = dVar.typeKey();
            this.f15589m = strTypeKey.length() <= 0 ? null : strTypeKey;
            if (strTypeName.length() != 0) {
                this.f15588l = strTypeName;
            } else {
                this.f15588l = cls.getName();
            }
            String[] strArrOrders = dVar.orders();
            this.f15590n = strArrOrders.length == 0 ? null : strArrOrders;
        } else {
            this.f15588l = cls.getName();
            this.f15589m = null;
            this.f15590n = null;
        }
        d[] dVarArr = new d[list.size()];
        this.f15584h = dVarArr;
        list.toArray(dVarArr);
        d[] dVarArr2 = new d[dVarArr.length];
        int i11 = 0;
        if (this.f15590n != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (d dVar2 : dVarArr) {
                linkedHashMap.put(dVar2.f15532a, dVar2);
            }
            int i12 = 0;
            for (String str : this.f15590n) {
                d dVar3 = (d) linkedHashMap.get(str);
                if (dVar3 != null) {
                    dVarArr2[i12] = dVar3;
                    linkedHashMap.remove(str);
                    i12++;
                }
            }
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                dVarArr2[i12] = (d) it.next();
                i12++;
            }
        } else {
            System.arraycopy(dVarArr, 0, dVarArr2, 0, dVarArr.length);
            Arrays.sort(dVarArr2);
        }
        this.f15585i = Arrays.equals(this.f15584h, dVarArr2) ? this.f15584h : dVarArr2;
        if (constructor != null) {
            this.f15583g = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.f15583g = method.getParameterTypes().length;
        } else {
            this.f15583g = 0;
        }
        if (constructor2 != null) {
            this.f15591o = constructor2.getParameterTypes();
            boolean zT0 = TypeUtils.t0(cls);
            this.f15593q = zT0;
            if (!zT0) {
                if (this.f15591o.length == this.f15584h.length) {
                    while (true) {
                        Type[] typeArr = this.f15591o;
                        if (i11 >= typeArr.length) {
                            return;
                        }
                        if (typeArr[i11] == this.f15584h[i11].f15536f) {
                            i11++;
                        }
                    }
                }
                this.f15592p = b.f(constructor2);
                return;
            }
            this.f15592p = TypeUtils.a0(cls);
            try {
                this.f15594r = cls.getConstructor(new Class[0]);
            } catch (Throwable unused) {
            }
            Annotation[][] annotationArrD0 = TypeUtils.d0(constructor2);
            for (int i13 = 0; i13 < this.f15592p.length && i13 < annotationArrD0.length; i13++) {
                Annotation[] annotationArr = annotationArrD0[i13];
                int length = annotationArr.length;
                int i14 = 0;
                while (true) {
                    if (i14 >= length) {
                        bVar = null;
                        break;
                    }
                    Annotation annotation = annotationArr[i14];
                    if (annotation instanceof j7.b) {
                        bVar = (j7.b) annotation;
                        break;
                    }
                    i14++;
                }
                if (bVar != null) {
                    String strName = bVar.name();
                    if (strName.length() > 0) {
                        this.f15592p[i13] = strName;
                    }
                }
            }
        }
    }

    public static boolean a(List<d> list, d dVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            d dVar2 = list.get(size);
            if (dVar2.f15532a.equals(dVar.f15532a) && (!dVar2.f15539i || dVar.f15539i)) {
                if (dVar2.f15536f.isAssignableFrom(dVar.f15536f)) {
                    list.set(size, dVar);
                    return true;
                }
                if (dVar2.compareTo(dVar) >= 0) {
                    return false;
                }
                list.set(size, dVar);
                return true;
            }
        }
        list.add(dVar);
        return true;
    }

    public static h b(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return c(cls, type, propertyNamingStrategy, false, TypeUtils.f15503b, false);
    }

    /* JADX WARN: Code duplicated, block: B:185:0x039d  */
    /* JADX WARN: Code duplicated, block: B:186:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:241:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:310:0x06ec  */
    /* JADX WARN: Code duplicated, block: B:335:0x0780 A[PHI: r14 r27 r29 r32 r35 r46
  0x0780: PHI (r14v12 java.lang.reflect.Method[]) = 
  (r14v6 java.lang.reflect.Method[])
  (r14v6 java.lang.reflect.Method[])
  (r14v6 java.lang.reflect.Method[])
  (r14v6 java.lang.reflect.Method[])
  (r14v13 java.lang.reflect.Method[])
 binds: [B:341:0x07a9, B:352:0x07c6, B:356:0x07e7, B:348:0x07bd, B:334:0x074e] A[DONT_GENERATE, DONT_INLINE]
  0x0780: PHI (r27v6 java.lang.Class<java.lang.String>) = 
  (r27v4 java.lang.Class<java.lang.String>)
  (r27v4 java.lang.Class<java.lang.String>)
  (r27v4 java.lang.Class<java.lang.String>)
  (r27v4 java.lang.Class<java.lang.String>)
  (r27v9 java.lang.Class<java.lang.String>)
 binds: [B:341:0x07a9, B:352:0x07c6, B:356:0x07e7, B:348:0x07bd, B:334:0x074e] A[DONT_GENERATE, DONT_INLINE]
  0x0780: PHI (r29v4 int) = (r29v2 int), (r29v2 int), (r29v2 int), (r29v2 int), (r29v7 int) binds: [B:341:0x07a9, B:352:0x07c6, B:356:0x07e7, B:348:0x07bd, B:334:0x074e] A[DONT_GENERATE, DONT_INLINE]
  0x0780: PHI (r32v3 int) = (r10v4 int), (r10v4 int), (r10v4 int), (r10v4 int), (r32v5 int) binds: [B:341:0x07a9, B:352:0x07c6, B:356:0x07e7, B:348:0x07bd, B:334:0x074e] A[DONT_GENERATE, DONT_INLINE]
  0x0780: PHI (r35v3 java.lang.Class<?>) = 
  (r14v4 java.lang.Class<?>)
  (r14v4 java.lang.Class<?>)
  (r14v4 java.lang.Class<?>)
  (r14v4 java.lang.Class<?>)
  (r35v5 java.lang.Class<?>)
 binds: [B:341:0x07a9, B:352:0x07c6, B:356:0x07e7, B:348:0x07bd, B:334:0x074e] A[DONT_GENERATE, DONT_INLINE]
  0x0780: PHI (r46v3 java.lang.Class<j7.b>) = 
  (r4v7 java.lang.Class<j7.b>)
  (r4v7 java.lang.Class<j7.b>)
  (r4v7 java.lang.Class<j7.b>)
  (r4v7 java.lang.Class<j7.b>)
  (r46v5 java.lang.Class<j7.b>)
 binds: [B:341:0x07a9, B:352:0x07c6, B:356:0x07e7, B:348:0x07bd, B:334:0x074e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:417:0x092f  */
    /* JADX WARN: Code duplicated, block: B:426:0x0968  */
    /* JADX WARN: Code duplicated, block: B:428:0x0974  */
    /* JADX WARN: Code duplicated, block: B:430:0x097a  */
    /* JADX WARN: Code duplicated, block: B:431:0x0986  */
    /* JADX WARN: Code duplicated, block: B:433:0x09a4  */
    /* JADX WARN: Code duplicated, block: B:435:0x09e8  */
    /* JADX WARN: Code duplicated, block: B:438:0x09fb  */
    /* JADX WARN: Code duplicated, block: B:492:0x0b45  */
    public static h c(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z11, boolean z12, boolean z13) {
        Class<String> cls2;
        Class<Collection> cls3;
        ArrayList arrayList;
        Method[] methodArr;
        Field[] fieldArr;
        Class<j7.b> cls4;
        Class<?> cls5;
        Constructor<?> constructor;
        String str;
        Class<j7.b> cls6;
        Class<?> cls7;
        Class<Collection> cls8;
        Field[] fieldArr2;
        j7.d dVar;
        ArrayList arrayList2;
        String str2;
        int i11;
        String strH0;
        Field[] fieldArr3;
        Field field;
        Class<j7.b> cls9;
        Class<Collection> cls10;
        int i12;
        Class<String> cls11;
        Method[] methodArr2;
        String str3;
        ArrayList arrayList3;
        Class<?> cls12;
        Field[] fieldArr4;
        String strH1;
        Field fieldX;
        Field fieldX2;
        Class<j7.b> cls13;
        j7.b bVar;
        int i13;
        PropertyNamingStrategy propertyNamingStrategy2;
        PropertyNamingStrategy propertyNamingStrategy3;
        j7.b bVar2;
        Field[] fieldArr5;
        int i14;
        int i15;
        int i16;
        int i17;
        String str4;
        StringBuilder sb2;
        String str5;
        String str6;
        char cCharAt;
        Constructor<?> constructorG;
        Class<String> cls14;
        Class<?> cls15;
        Class<Collection> cls16;
        Class<j7.b> cls17;
        Class<Collection> cls18;
        Class<String> cls19;
        Class<?> cls20;
        String[] strArr;
        Constructor<?>[] constructorArr;
        String[] strArrF;
        String[] strArrF2;
        Class<?>[] parameterTypes;
        Class<Collection> cls21;
        j7.b bVar3;
        Class<j7.b> cls22;
        int iOrdinal;
        int iOf;
        int iOf2;
        j7.b bVar4;
        String strName;
        int i18;
        int i19;
        int iOf3;
        Class<?> cls23;
        j7.b bVar5;
        Field fieldX3;
        String strName2;
        int i21;
        int i22;
        int i23;
        String str7;
        Constructor<?> constructorG2;
        PropertyNamingStrategy propertyNamingStrategyNaming;
        Class<?> cls24 = cls;
        boolean z14 = z13;
        j7.d dVar2 = (j7.d) TypeUtils.N(cls24, j7.d.class);
        PropertyNamingStrategy propertyNamingStrategy4 = (dVar2 == null || (propertyNamingStrategyNaming = dVar2.naming()) == null || propertyNamingStrategyNaming == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : propertyNamingStrategyNaming;
        Class<?> clsF = f(cls24, dVar2);
        Field[] declaredFields = cls.getDeclaredFields();
        Method[] methods = cls.getMethods();
        Map<TypeVariable, Type> mapD = d(cls);
        boolean zT0 = TypeUtils.t0(cls);
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        Constructor<?> constructorH = (!zT0 || declaredConstructors.length == 1) ? clsF == null ? h(cls24, declaredConstructors) : h(clsF, clsF.getDeclaredConstructors()) : null;
        Method method = null;
        Method methodI = null;
        ArrayList arrayList4 = new ArrayList();
        if (z11) {
            for (Class<?> superclass = cls24; superclass != null; superclass = superclass.getSuperclass()) {
                e(cls24, type, propertyNamingStrategy4, arrayList4, superclass.getDeclaredFields());
            }
            if (constructorH != null) {
                TypeUtils.M0(constructorH);
            }
            return new h(cls, clsF, constructorH, null, null, null, dVar2, arrayList4);
        }
        boolean z15 = cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
        Class<Collection> cls25 = Collection.class;
        Class<?> cls26 = Object.class;
        Class<String> cls27 = String.class;
        Class<j7.b> cls28 = j7.b.class;
        PropertyNamingStrategy propertyNamingStrategy5 = propertyNamingStrategy4;
        if ((constructorH == null && clsF == null) || z15) {
            Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(cls);
            if (!(mixInAnnotations instanceof Class) || (constructorG2 = g(((Class) mixInAnnotations).getConstructors())) == null) {
                constructorG = null;
            } else {
                try {
                    constructorG = cls24.getConstructor(constructorG2.getParameterTypes());
                } catch (NoSuchMethodException unused) {
                    constructorG = null;
                }
            }
            if (constructorG == null) {
                constructorG = g(declaredConstructors);
            }
            constructor = constructorG;
            if (constructor == null || z15) {
                cls14 = cls27;
                cls15 = cls26;
                cls16 = cls25;
                arrayList = arrayList4;
                cls17 = cls28;
                methodArr = methods;
                methodI = i(cls24, methodArr, z14);
                if (methodI != null) {
                    TypeUtils.M0(methodI);
                    Class<?>[] parameterTypes2 = methodI.getParameterTypes();
                    if (parameterTypes2.length > 0) {
                        Annotation[][] annotationArrE0 = TypeUtils.e0(methodI);
                        String[] strArrF3 = null;
                        int i24 = 0;
                        while (i24 < parameterTypes2.length) {
                            Annotation[] annotationArr = annotationArrE0[i24];
                            int length = annotationArr.length;
                            int i25 = 0;
                            while (true) {
                                if (i25 >= length) {
                                    bVar4 = null;
                                    break;
                                }
                                Annotation annotation = annotationArr[i25];
                                if (annotation instanceof j7.b) {
                                    bVar4 = (j7.b) annotation;
                                    break;
                                }
                                i25++;
                            }
                            if (bVar4 == null && (!z14 || !TypeUtils.s0(methodI))) {
                                throw new JSONException("illegal json creator");
                            }
                            if (bVar4 != null) {
                                strName = bVar4.name();
                                int iOrdinal2 = bVar4.ordinal();
                                int iOf4 = SerializerFeature.of(bVar4.serialzeFeatures());
                                i18 = iOrdinal2;
                                iOf3 = Feature.of(bVar4.parseFeatures());
                                i19 = iOf4;
                            } else {
                                strName = null;
                                i18 = 0;
                                i19 = 0;
                                iOf3 = 0;
                            }
                            if (strName == null || strName.length() == 0) {
                                if (strArrF3 == null) {
                                    strArrF3 = b.f(methodI);
                                }
                                strName = strArrF3[i24];
                            }
                            String[] strArr2 = strArrF3;
                            a(arrayList, new d(strName, cls, parameterTypes2[i24], methodI.getGenericParameterTypes()[i24], TypeUtils.X(cls24, strName, declaredFields), i18, i19, iOf3));
                            i24++;
                            z14 = z13;
                            parameterTypes2 = parameterTypes2;
                            strArrF3 = strArr2;
                        }
                        return new h(cls, clsF, null, null, methodI, null, dVar2, arrayList);
                    }
                } else if (!z15) {
                    String name = cls.getName();
                    if (!zT0 || declaredConstructors.length <= 0) {
                        int length2 = declaredConstructors.length;
                        String[] strArr3 = null;
                        int i26 = 0;
                        while (true) {
                            if (i26 < length2) {
                                Constructor<?> constructor2 = declaredConstructors[i26];
                                Class<?>[] parameterTypes3 = constructor2.getParameterTypes();
                                if (name.equals("org.springframework.security.web.authentication.WebAuthenticationDetails")) {
                                    if (parameterTypes3.length == 2) {
                                        cls19 = cls14;
                                        if (parameterTypes3[0] == cls19 && parameterTypes3[1] == cls19) {
                                            constructor2.setAccessible(true);
                                            strArrF2 = b.f(constructor2);
                                            constructor = constructor2;
                                            methodArr = methodArr;
                                            cls18 = cls16;
                                        }
                                    } else {
                                        cls19 = cls14;
                                    }
                                    constructorArr = declaredConstructors;
                                    cls18 = cls16;
                                    cls20 = cls15;
                                } else {
                                    cls19 = cls14;
                                    if (!name.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken")) {
                                        constructorArr = declaredConstructors;
                                        cls18 = cls16;
                                        cls20 = cls15;
                                        if (name.equals("org.springframework.security.core.authority.SimpleGrantedAuthority")) {
                                            methodArr = methodArr;
                                            if (parameterTypes3.length == 1 && parameterTypes3[0] == cls19) {
                                                strArr = new String[]{"authority"};
                                                constructor = constructor2;
                                            }
                                        } else {
                                            methodArr = methodArr;
                                            if ((constructor2.getModifiers() & 1) != 0 && (strArrF = b.f(constructor2)) != null && strArrF.length != 0 && (constructor == null || strArr3 == null || strArrF.length > strArr3.length)) {
                                                constructor = constructor2;
                                                strArr3 = strArrF;
                                            }
                                        }
                                        i26++;
                                        cls16 = cls18;
                                        cls15 = cls20;
                                        cls14 = cls19;
                                        declaredConstructors = constructorArr;
                                        methodArr = methodArr;
                                    } else if (parameterTypes3.length == 3) {
                                        cls20 = cls15;
                                        constructorArr = declaredConstructors;
                                        if (parameterTypes3[0] == cls20 && parameterTypes3[1] == cls20) {
                                            cls18 = cls16;
                                            if (parameterTypes3[2] == cls18) {
                                                constructor2.setAccessible(true);
                                                strArrF2 = new String[]{"principal", "credentials", "authorities"};
                                                constructor = constructor2;
                                                methodArr = methodArr;
                                                strArr = strArrF2;
                                            }
                                        } else {
                                            cls18 = cls16;
                                        }
                                    } else {
                                        constructorArr = declaredConstructors;
                                        cls18 = cls16;
                                        cls20 = cls15;
                                    }
                                }
                                i26++;
                                cls16 = cls18;
                                cls15 = cls20;
                                cls14 = cls19;
                                declaredConstructors = constructorArr;
                                methodArr = methodArr;
                            } else {
                                methodArr = methodArr;
                                cls18 = cls16;
                                cls19 = cls14;
                                cls20 = cls15;
                                strArr = strArr3;
                            }
                            if (strArr != null) {
                                parameterTypes = constructor.getParameterTypes();
                            } else {
                                parameterTypes = null;
                            }
                            if (strArr != null || parameterTypes.length != strArr.length) {
                                throw new JSONException("default constructor not found. " + cls24);
                            }
                            Annotation[][] annotationArrD0 = TypeUtils.d0(constructor);
                            int i27 = 0;
                            while (i27 < parameterTypes.length) {
                                Annotation[] annotationArr2 = annotationArrD0[i27];
                                String str8 = strArr[i27];
                                int length3 = annotationArr2.length;
                                int i28 = 0;
                                while (true) {
                                    cls21 = cls18;
                                    if (i28 >= length3) {
                                        bVar3 = null;
                                        break;
                                    }
                                    Annotation annotation2 = annotationArr2[i28];
                                    Annotation[] annotationArr3 = annotationArr2;
                                    if (annotation2 instanceof j7.b) {
                                        bVar3 = (j7.b) annotation2;
                                        break;
                                    }
                                    i28++;
                                    annotationArr2 = annotationArr3;
                                    cls18 = cls21;
                                }
                                Class<?> cls29 = parameterTypes[i27];
                                Type type2 = constructor.getGenericParameterTypes()[i27];
                                Field fieldX4 = TypeUtils.X(cls24, str8, declaredFields);
                                if (fieldX4 == null || bVar3 != null) {
                                    cls22 = cls17;
                                } else {
                                    cls22 = cls17;
                                    bVar3 = (j7.b) TypeUtils.O(fieldX4, cls22);
                                }
                                if (bVar3 != null) {
                                    String strName3 = bVar3.name();
                                    if (strName3.length() != 0) {
                                        str8 = strName3;
                                    }
                                    iOrdinal = bVar3.ordinal();
                                    iOf = SerializerFeature.of(bVar3.serialzeFeatures());
                                    iOf2 = Feature.of(bVar3.parseFeatures());
                                } else if ("org.springframework.security.core.userdetails.User".equals(name) && "password".equals(str8)) {
                                    iOf2 = Feature.InitStringFieldAsEmpty.mask;
                                    iOrdinal = 0;
                                    iOf = 0;
                                } else {
                                    iOrdinal = 0;
                                    iOf = 0;
                                    iOf2 = 0;
                                }
                                a(arrayList, new d(str8, cls, cls29, type2, fieldX4, iOrdinal, iOf, iOf2));
                                i27++;
                                cls17 = cls22;
                                cls20 = cls20;
                                cls18 = cls21;
                                declaredFields = declaredFields;
                                parameterTypes = parameterTypes;
                                strArr = strArr;
                                cls19 = cls19;
                            }
                            cls3 = cls18;
                            cls5 = cls20;
                            cls2 = cls19;
                            fieldArr = declaredFields;
                            cls4 = cls17;
                            if (!zT0 && !cls.getName().equals("javax.servlet.http.Cookie")) {
                                return new h(cls, clsF, null, constructor, null, null, dVar2, arrayList);
                            }
                        }
                    } else {
                        strArrF2 = TypeUtils.a0(cls);
                        Constructor<?> constructorC0 = TypeUtils.c0(declaredConstructors, strArrF2);
                        TypeUtils.M0(constructorC0);
                        constructor = constructorC0;
                        methodArr = methodArr;
                        cls18 = cls16;
                        cls19 = cls14;
                    }
                    cls20 = cls15;
                    strArr = strArrF2;
                    if (strArr != null) {
                        parameterTypes = constructor.getParameterTypes();
                    } else {
                        parameterTypes = null;
                    }
                    if (strArr != null) {
                    }
                    throw new JSONException("default constructor not found. " + cls24);
                }
            } else {
                TypeUtils.M0(constructor);
                Class<?>[] parameterTypes4 = constructor.getParameterTypes();
                if (parameterTypes4.length > 0) {
                    Annotation[][] annotationArrD1 = TypeUtils.d0(constructor);
                    String[] strArrF4 = null;
                    int i29 = 0;
                    while (i29 < parameterTypes4.length && i29 < annotationArrD1.length) {
                        Annotation[] annotationArr4 = annotationArrD1[i29];
                        int length4 = annotationArr4.length;
                        Class<String> cls30 = cls27;
                        int i31 = 0;
                        while (true) {
                            cls23 = cls26;
                            if (i31 >= length4) {
                                bVar5 = null;
                                break;
                            }
                            Annotation annotation3 = annotationArr4[i31];
                            Annotation[] annotationArr5 = annotationArr4;
                            if (annotation3 instanceof j7.b) {
                                bVar5 = (j7.b) annotation3;
                                break;
                            }
                            i31++;
                            annotationArr4 = annotationArr5;
                            cls26 = cls23;
                        }
                        Class<?> cls31 = parameterTypes4[i29];
                        Type type3 = constructor.getGenericParameterTypes()[i29];
                        if (bVar5 != null) {
                            fieldX3 = TypeUtils.X(cls24, bVar5.name(), declaredFields);
                            int iOrdinal3 = bVar5.ordinal();
                            int iOf5 = SerializerFeature.of(bVar5.serialzeFeatures());
                            int iOf6 = Feature.of(bVar5.parseFeatures());
                            strName2 = bVar5.name();
                            i23 = iOf6;
                            i22 = iOf5;
                            i21 = iOrdinal3;
                        } else {
                            fieldX3 = null;
                            strName2 = null;
                            i21 = 0;
                            i22 = 0;
                            i23 = 0;
                        }
                        if (strName2 == null || strName2.length() == 0) {
                            if (strArrF4 == null) {
                                strArrF4 = b.f(constructor);
                            }
                            str7 = strArrF4[i29];
                        } else {
                            str7 = strName2;
                        }
                        if (fieldX3 == null) {
                            if (strArrF4 == null) {
                                strArrF4 = zT0 ? TypeUtils.a0(cls) : b.f(constructor);
                            }
                            if (strArrF4.length > i29) {
                                fieldX3 = TypeUtils.X(cls24, strArrF4[i29], declaredFields);
                            }
                        }
                        ArrayList arrayList5 = arrayList4;
                        a(arrayList5, new d(str7, cls, cls31, type3, fieldX3, i21, i22, i23));
                        i29++;
                        parameterTypes4 = parameterTypes4;
                        arrayList4 = arrayList5;
                        methods = methods;
                        annotationArrD1 = annotationArrD1;
                        cls25 = cls25;
                        cls27 = cls30;
                        strArrF4 = strArrF4;
                        cls28 = cls28;
                        cls26 = cls23;
                    }
                }
                cls14 = cls27;
                cls15 = cls26;
                cls16 = cls25;
                arrayList = arrayList4;
                cls17 = cls28;
                methodArr = methods;
            }
            methodArr = methodArr;
            cls3 = cls16;
            cls2 = cls14;
            cls5 = cls15;
            fieldArr = declaredFields;
            cls4 = cls17;
        } else {
            cls2 = cls27;
            cls3 = cls25;
            arrayList = arrayList4;
            methodArr = methods;
            fieldArr = declaredFields;
            cls4 = cls28;
            cls5 = cls26;
            constructor = null;
        }
        if (constructorH != null) {
            TypeUtils.M0(constructorH);
        }
        String str9 = "set";
        if (clsF != null) {
            Class<j7.c> cls32 = j7.c.class;
            j7.c cVar = (j7.c) TypeUtils.N(clsF, cls32);
            String strWithPrefix = cVar != null ? cVar.withPrefix() : null;
            if (strWithPrefix == null) {
                strWithPrefix = "with";
            }
            String str10 = strWithPrefix;
            Method[] methods2 = clsF.getMethods();
            int length5 = methods2.length;
            int i32 = 0;
            while (i32 < length5) {
                Method method2 = methods2[i32];
                if (!Modifier.isStatic(method2.getModifiers()) && method2.getReturnType().equals(clsF)) {
                    j7.b bVarJ0 = (j7.b) TypeUtils.P(method2, cls4);
                    if (bVarJ0 == null) {
                        bVarJ0 = TypeUtils.j0(cls24, method2);
                    }
                    j7.b bVar6 = bVarJ0;
                    if (bVar6 == null) {
                        i14 = 3;
                        i15 = 0;
                        i16 = 0;
                        i17 = 0;
                    } else if (bVar6.deserialize()) {
                        int iOrdinal4 = bVar6.ordinal();
                        int iOf7 = SerializerFeature.of(bVar6.serialzeFeatures());
                        int iOf8 = Feature.of(bVar6.parseFeatures());
                        if (bVar6.name().length() != 0) {
                            i32 = i32;
                            length5 = length5;
                            methods2 = methods2;
                            cls32 = cls32;
                            cls4 = cls4;
                            fieldArr = fieldArr;
                            clsF = clsF;
                            dVar2 = dVar2;
                            cls3 = cls3;
                            arrayList = arrayList;
                            a(arrayList, new d(bVar6.name(), method2, null, cls, type, iOrdinal4, iOf7, iOf8, bVar6, null, null, mapD));
                            str5 = str10;
                            str6 = str9;
                        } else {
                            i14 = 3;
                            i15 = iOrdinal4;
                            i16 = iOf7;
                            i17 = iOf8;
                        }
                    } else {
                        i32 = i32;
                        length5 = length5;
                        methods2 = methods2;
                        str5 = str10;
                        cls32 = cls32;
                        str6 = str9;
                        cls4 = cls4;
                        clsF = clsF;
                        cls3 = cls3;
                        fieldArr = fieldArr;
                        dVar2 = dVar2;
                        arrayList = arrayList;
                    }
                    String name2 = method2.getName();
                    String str11 = str9;
                    if (!name2.startsWith(str11) || name2.length() <= i14) {
                        if (str10.length() == 0) {
                            sb2 = new StringBuilder(name2);
                        } else {
                            str4 = str10;
                            if (name2.startsWith(str4) && name2.length() > str4.length()) {
                                sb2 = new StringBuilder(name2.substring(str4.length()));
                                cCharAt = sb2.charAt(0);
                                if (str4.length() != 0 || Character.isUpperCase(cCharAt)) {
                                    sb2.setCharAt(0, Character.toLowerCase(cCharAt));
                                    str5 = str4;
                                    str6 = str11;
                                    a(arrayList, new d(sb2.toString(), method2, null, cls, type, i15, i16, i17, bVar6, null, null, mapD));
                                }
                            }
                        }
                        str5 = str4;
                        str6 = str11;
                    } else {
                        sb2 = new StringBuilder(name2.substring(i14));
                    }
                    str4 = str10;
                    cCharAt = sb2.charAt(0);
                    if (str4.length() != 0) {
                    }
                    sb2.setCharAt(0, Character.toLowerCase(cCharAt));
                    str5 = str4;
                    str6 = str11;
                    a(arrayList, new d(sb2.toString(), method2, null, cls, type, i15, i16, i17, bVar6, null, null, mapD));
                } else {
                    i32 = i32;
                    length5 = length5;
                    methods2 = methods2;
                    str5 = str10;
                    cls32 = cls32;
                    str6 = str9;
                    cls4 = cls4;
                    clsF = clsF;
                    cls3 = cls3;
                    fieldArr = fieldArr;
                    dVar2 = dVar2;
                    arrayList = arrayList;
                }
                i32++;
                cls24 = cls;
                arrayList = arrayList;
                str10 = str5;
                dVar2 = dVar2;
                length5 = length5;
                methods2 = methods2;
                cls32 = cls32;
                fieldArr = fieldArr;
                cls4 = cls4;
                clsF = clsF;
                cls3 = cls3;
                str9 = str6;
            }
            str = str9;
            cls6 = cls4;
            cls7 = clsF;
            cls8 = cls3;
            fieldArr2 = fieldArr;
            dVar = dVar2;
            arrayList2 = arrayList;
            j7.c cVar2 = (j7.c) TypeUtils.N(cls7, cls32);
            String strBuildMethod = cVar2 != null ? cVar2.buildMethod() : null;
            if (strBuildMethod == null || strBuildMethod.length() == 0) {
                strBuildMethod = "build";
            }
            try {
                method = cls7.getMethod(strBuildMethod, new Class[0]);
            } catch (NoSuchMethodException | SecurityException unused2) {
            }
            if (method == null) {
                try {
                    method = cls7.getMethod("create", new Class[0]);
                } catch (NoSuchMethodException | SecurityException unused3) {
                }
            }
            if (method == null) {
                throw new JSONException("buildMethod not found.");
            }
            TypeUtils.M0(method);
        } else {
            str = "set";
            cls6 = cls4;
            cls7 = clsF;
            cls8 = cls3;
            fieldArr2 = fieldArr;
            dVar = dVar2;
            arrayList2 = arrayList;
        }
        Method[] methodArr3 = methodArr;
        int length6 = methodArr3.length;
        int i33 = 0;
        while (true) {
            str2 = "get";
            i11 = 4;
            if (i33 >= length6) {
                break;
            }
            Method method3 = methodArr3[i33];
            int iOrdinal5 = 0;
            int iOf9 = 0;
            int iOf10 = 0;
            String name3 = method3.getName();
            if (Modifier.isStatic(method3.getModifiers())) {
                i33 = i33;
                i12 = length6;
                methodArr2 = methodArr3;
                cls7 = cls7;
                cls5 = cls5;
                cls11 = cls2;
                cls13 = cls6;
                str3 = str;
                propertyNamingStrategy3 = propertyNamingStrategy5;
            } else {
                Class<?> returnType = method3.getReturnType();
                if ((returnType.equals(Void.TYPE) || returnType.equals(method3.getDeclaringClass())) && method3.getDeclaringClass() != cls5) {
                    Class<?>[] parameterTypes5 = method3.getParameterTypes();
                    if (parameterTypes5.length == 0 || parameterTypes5.length > 2) {
                        i33 = i33;
                        i12 = length6;
                        methodArr2 = methodArr3;
                        cls7 = cls7;
                        cls5 = cls5;
                        cls11 = cls2;
                        cls13 = cls6;
                        str3 = str;
                    } else {
                        Class<j7.b> cls33 = cls6;
                        j7.b bVarJ1 = (j7.b) TypeUtils.P(method3, cls33);
                        if (bVarJ1 == null || parameterTypes5.length != 2) {
                            i12 = length6;
                            cls11 = cls2;
                        } else {
                            int i34 = length6;
                            Class<String> cls34 = cls2;
                            if (parameterTypes5[0] == cls34 && parameterTypes5[1] == cls5) {
                                cls33 = cls33;
                                i33 = i33;
                                i12 = i34;
                                cls11 = cls34;
                                cls5 = cls5;
                                methodArr2 = methodArr3;
                                a(arrayList2, new d("", method3, null, cls, type, 0, 0, 0, bVarJ1, null, null, mapD));
                            } else {
                                i12 = i34;
                                cls11 = cls34;
                            }
                            methodArr2 = methodArr2;
                            str3 = str;
                            cls13 = cls33;
                        }
                        methodArr2 = methodArr3;
                        if (parameterTypes5.length == 1) {
                            if (bVarJ1 == null) {
                                bVarJ1 = TypeUtils.j0(cls, method3);
                            }
                            if (bVarJ1 != null || name3.length() >= 4) {
                                if (bVarJ1 != null) {
                                    if (bVarJ1.deserialize()) {
                                        iOrdinal5 = bVarJ1.ordinal();
                                        iOf9 = SerializerFeature.of(bVarJ1.serialzeFeatures());
                                        iOf10 = Feature.of(bVarJ1.parseFeatures());
                                        if (bVarJ1.name().length() != 0) {
                                            a(arrayList2, new d(bVarJ1.name(), method3, null, cls, type, iOrdinal5, iOf9, iOf10, bVarJ1, null, null, mapD));
                                        }
                                    }
                                    methodArr2 = methodArr2;
                                    str3 = str;
                                    cls13 = cls33;
                                }
                                str3 = str;
                                if ((bVarJ1 != null || name3.startsWith(str3)) && cls7 == null) {
                                    char cCharAt2 = name3.charAt(3);
                                    if (zT0) {
                                        arrayList3 = new ArrayList();
                                        for (int i35 = 0; i35 < methodArr2.length; i35++) {
                                            if (methodArr2[i35].getName().startsWith("get")) {
                                                arrayList3.add(methodArr2[i35].getName());
                                            }
                                        }
                                    } else {
                                        arrayList3 = null;
                                    }
                                    if (Character.isUpperCase(cCharAt2) || cCharAt2 > 512) {
                                        cls12 = cls;
                                        fieldArr4 = fieldArr2;
                                        strH1 = zT0 ? TypeUtils.h0("g" + name3.substring(1)) : TypeUtils.f15503b ? TypeUtils.I(name3.substring(3)) : TypeUtils.h0(name3);
                                    } else {
                                        if (cCharAt2 != '_') {
                                            cls12 = cls;
                                            fieldArr5 = fieldArr2;
                                            if (cCharAt2 == 'f') {
                                                strH1 = name3.substring(3);
                                            } else if (name3.length() < 5 || !Character.isUpperCase(name3.charAt(4))) {
                                                strH1 = name3.substring(3);
                                                fieldX = TypeUtils.X(cls12, strH1, fieldArr5);
                                                if (fieldX == null) {
                                                    fieldArr2 = fieldArr5;
                                                }
                                            } else {
                                                strH1 = TypeUtils.I(name3.substring(3));
                                            }
                                            fieldArr4 = fieldArr5;
                                        } else if (zT0) {
                                            strH1 = arrayList3.contains("g" + name3.substring(1)) ? name3.substring(3) : "is" + name3.substring(3);
                                            cls12 = cls;
                                            fieldArr5 = fieldArr2;
                                            fieldX = TypeUtils.X(cls12, strH1, fieldArr5);
                                        } else {
                                            cls12 = cls;
                                            fieldArr5 = fieldArr2;
                                            String strSubstring = name3.substring(4);
                                            Field fieldX5 = TypeUtils.X(cls12, strSubstring, fieldArr5);
                                            if (fieldX5 != null || (fieldX5 = TypeUtils.X(cls12, (strH1 = name3.substring(3)), fieldArr5)) == null) {
                                                strH1 = strSubstring;
                                            }
                                            fieldX = fieldX5;
                                        }
                                        fieldArr4 = fieldArr5;
                                        if (fieldX == null) {
                                            fieldX = TypeUtils.X(cls12, strH1, fieldArr4);
                                        }
                                        fieldX2 = (fieldX == null || parameterTypes5[0] != Boolean.TYPE) ? fieldX : TypeUtils.X(cls12, "is" + Character.toUpperCase(strH1.charAt(0)) + strH1.substring(1), fieldArr4);
                                        if (fieldX2 != null) {
                                            bVar2 = (j7.b) TypeUtils.O(fieldX2, cls33);
                                            if (bVar2 != null) {
                                                if (bVar2.deserialize()) {
                                                    iOrdinal5 = bVar2.ordinal();
                                                    iOf9 = SerializerFeature.of(bVar2.serialzeFeatures());
                                                    iOf10 = Feature.of(bVar2.parseFeatures());
                                                    if (bVar2.name().length() != 0) {
                                                        cls13 = cls33;
                                                        methodArr2 = methodArr2;
                                                        str3 = str3;
                                                        a(arrayList2, new d(bVar2.name(), method3, fieldX2, cls, type, iOrdinal5, iOf9, iOf10, bVarJ1, bVar2, null, mapD));
                                                        cls7 = cls7;
                                                        fieldArr2 = fieldArr4;
                                                    }
                                                } else {
                                                    cls13 = cls33;
                                                    fieldArr2 = fieldArr4;
                                                    str3 = str3;
                                                    cls7 = cls7;
                                                    methodArr2 = methodArr2;
                                                }
                                                propertyNamingStrategy3 = propertyNamingStrategy5;
                                            }
                                            cls13 = cls33;
                                            i13 = iOf10;
                                            bVar = bVar2;
                                        } else {
                                            cls13 = cls33;
                                            bVar = null;
                                            i13 = iOf10;
                                        }
                                        propertyNamingStrategy2 = propertyNamingStrategy5;
                                        if (propertyNamingStrategy5 != null) {
                                            strH1 = propertyNamingStrategy2.translate(strH1);
                                        }
                                        fieldArr2 = fieldArr4;
                                        cls7 = cls7;
                                        propertyNamingStrategy3 = propertyNamingStrategy2;
                                        a(arrayList2, new d(strH1, method3, fieldX2, cls, type, iOrdinal5, iOf9, i13, bVarJ1, bVar, null, mapD));
                                    }
                                    fieldX = null;
                                    if (fieldX == null) {
                                        fieldX = TypeUtils.X(cls12, strH1, fieldArr4);
                                    }
                                    if (fieldX == null) {
                                    }
                                    if (fieldX2 != null) {
                                        bVar2 = (j7.b) TypeUtils.O(fieldX2, cls33);
                                        if (bVar2 != null) {
                                            if (bVar2.deserialize()) {
                                                cls13 = cls33;
                                                fieldArr2 = fieldArr4;
                                                str3 = str3;
                                                cls7 = cls7;
                                                methodArr2 = methodArr2;
                                            } else {
                                                iOrdinal5 = bVar2.ordinal();
                                                iOf9 = SerializerFeature.of(bVar2.serialzeFeatures());
                                                iOf10 = Feature.of(bVar2.parseFeatures());
                                                if (bVar2.name().length() != 0) {
                                                    cls13 = cls33;
                                                    methodArr2 = methodArr2;
                                                    str3 = str3;
                                                    a(arrayList2, new d(bVar2.name(), method3, fieldX2, cls, type, iOrdinal5, iOf9, iOf10, bVarJ1, bVar2, null, mapD));
                                                    cls7 = cls7;
                                                    fieldArr2 = fieldArr4;
                                                }
                                            }
                                            propertyNamingStrategy3 = propertyNamingStrategy5;
                                        }
                                        cls13 = cls33;
                                        i13 = iOf10;
                                        bVar = bVar2;
                                    } else {
                                        cls13 = cls33;
                                        bVar = null;
                                        i13 = iOf10;
                                    }
                                    propertyNamingStrategy2 = propertyNamingStrategy5;
                                    if (propertyNamingStrategy5 != null) {
                                        strH1 = propertyNamingStrategy2.translate(strH1);
                                    }
                                    fieldArr2 = fieldArr4;
                                    cls7 = cls7;
                                    propertyNamingStrategy3 = propertyNamingStrategy2;
                                    a(arrayList2, new d(strH1, method3, fieldX2, cls, type, iOrdinal5, iOf9, i13, bVarJ1, bVar, null, mapD));
                                }
                                str3 = str3;
                                methodArr2 = methodArr2;
                                cls13 = cls33;
                            } else {
                                methodArr2 = methodArr2;
                                str3 = str;
                                cls13 = cls33;
                            }
                        } else {
                            methodArr2 = methodArr2;
                            str3 = str;
                            cls13 = cls33;
                        }
                    }
                    propertyNamingStrategy3 = propertyNamingStrategy5;
                } else {
                    i33 = i33;
                    i12 = length6;
                    methodArr2 = methodArr3;
                    cls7 = cls7;
                    cls5 = cls5;
                    cls11 = cls2;
                    cls13 = cls6;
                    str3 = str;
                    propertyNamingStrategy3 = propertyNamingStrategy5;
                }
            }
            i33++;
            propertyNamingStrategy5 = propertyNamingStrategy3;
            cls2 = cls11;
            length6 = i12;
            str = str3;
            methodArr3 = methodArr2;
            cls5 = cls5;
            cls7 = cls7;
            cls6 = cls13;
        }
        Class<?> cls35 = cls7;
        Class<j7.b> cls36 = cls6;
        PropertyNamingStrategy propertyNamingStrategy6 = propertyNamingStrategy5;
        e(cls, type, propertyNamingStrategy6, arrayList2, cls.getFields());
        Method[] methods3 = cls.getMethods();
        int length7 = methods3.length;
        int i36 = 0;
        while (i36 < length7) {
            Method method4 = methods3[i36];
            String name4 = method4.getName();
            if (name4.length() >= i11 && !Modifier.isStatic(method4.getModifiers()) && cls35 == null && name4.startsWith(str2) && Character.isUpperCase(name4.charAt(3)) && method4.getParameterTypes().length == 0) {
                Class<Collection> cls37 = cls8;
                if (cls37.isAssignableFrom(method4.getReturnType()) || Map.class.isAssignableFrom(method4.getReturnType()) || AtomicBoolean.class == method4.getReturnType() || AtomicInteger.class == method4.getReturnType() || AtomicLong.class == method4.getReturnType()) {
                    Class<j7.b> cls38 = cls36;
                    j7.b bVar7 = (j7.b) TypeUtils.P(method4, cls38);
                    if (bVar7 == null || !bVar7.deserialize()) {
                        if (bVar7 == null || bVar7.name().length() <= 0) {
                            strH0 = TypeUtils.h0(name4);
                            fieldArr3 = fieldArr2;
                            Field fieldX6 = TypeUtils.X(cls, strH0, fieldArr3);
                            if (fieldX6 == null) {
                                field = null;
                            } else {
                                j7.b bVar8 = (j7.b) TypeUtils.O(fieldX6, cls38);
                                if (bVar8 == null || bVar8.deserialize()) {
                                    if (cls37.isAssignableFrom(method4.getReturnType()) || Map.class.isAssignableFrom(method4.getReturnType())) {
                                        field = fieldX6;
                                    } else {
                                        field = null;
                                    }
                                }
                            }
                            fieldArr2 = fieldArr3;
                            cls9 = cls38;
                            cls10 = cls37;
                            i36 = i36;
                            str2 = str2;
                            length7 = length7;
                            methods3 = methods3;
                        } else {
                            strH0 = bVar7.name();
                            field = null;
                            fieldArr3 = fieldArr2;
                        }
                        if (propertyNamingStrategy6 != null) {
                            strH0 = propertyNamingStrategy6.translate(strH0);
                        }
                        String str12 = strH0;
                        if (j(arrayList2, str12) != null) {
                            fieldArr2 = fieldArr3;
                            cls9 = cls38;
                            cls10 = cls37;
                            i36 = i36;
                            str2 = str2;
                            length7 = length7;
                            methods3 = methods3;
                        } else {
                            fieldArr2 = fieldArr3;
                            cls9 = cls38;
                            cls10 = cls37;
                            i36 = i36;
                            str2 = str2;
                            length7 = length7;
                            methods3 = methods3;
                            a(arrayList2, new d(str12, method4, field, cls, type, 0, 0, 0, bVar7, null, null, mapD));
                        }
                    } else {
                        cls9 = cls38;
                        cls10 = cls37;
                        i36 = i36;
                        str2 = str2;
                        length7 = length7;
                        methods3 = methods3;
                        fieldArr2 = fieldArr2;
                    }
                } else {
                    cls10 = cls37;
                }
                i36++;
                length7 = length7;
                str2 = str2;
                methods3 = methods3;
                cls36 = cls9;
                cls8 = cls10;
                fieldArr2 = fieldArr2;
                i11 = 4;
            } else {
                cls10 = cls8;
            }
            cls9 = cls36;
            i36++;
            length7 = length7;
            str2 = str2;
            methods3 = methods3;
            cls36 = cls9;
            cls8 = cls10;
            fieldArr2 = fieldArr2;
            i11 = 4;
        }
        Field[] fieldArr6 = fieldArr2;
        if (arrayList2.size() == 0 && (TypeUtils.z0(cls) || z11)) {
            for (Class<?> superclass2 = cls; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
                e(cls, type, propertyNamingStrategy6, arrayList2, fieldArr6);
            }
        }
        return new h(cls, cls35, constructorH, constructor, methodI, method, dVar, arrayList2);
    }

    public static Map<TypeVariable, Type> d(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            Class<? super Object> cls2 = superclass;
            Class<?> cls3 = cls;
            cls = cls2;
            if (cls == null || cls == Object.class) {
                break;
            }
            if (cls3.getGenericSuperclass() instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) cls3.getGenericSuperclass()).getActualTypeArguments();
                TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
                for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    if (map.containsKey(actualTypeArguments[i11])) {
                        map.put(typeParameters[i11], map.get(actualTypeArguments[i11]));
                    } else {
                        map.put(typeParameters[i11], actualTypeArguments[i11]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0050  */
    /* JADX WARN: Code duplicated, block: B:22:0x005a  */
    /* JADX WARN: Code duplicated, block: B:27:0x007c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0083  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:43:0x006d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0018 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[LOOP:1: B:20:0x0054->B:45:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x0018  */
    public static void e(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, List<d> list, Field[] fieldArr) {
        Iterator<d> it;
        String name;
        j7.b bVar;
        int i11;
        int i12;
        int i13;
        Map<TypeVariable, Type> mapD = d(cls);
        int i14 = 0;
        for (int length = fieldArr.length; i14 < length; length = length) {
            Field field = fieldArr[i14];
            int modifiers = field.getModifiers();
            if ((modifiers & 8) != 0) {
                break;
                break;
            }
            if ((modifiers & 16) == 0) {
                it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        name = field.getName();
                        bVar = (j7.b) TypeUtils.O(field, j7.b.class);
                        if (bVar != null) {
                            i11 = 0;
                            i12 = 0;
                            i13 = 0;
                        } else if (!bVar.deserialize()) {
                            int iOrdinal = bVar.ordinal();
                            int iOf = SerializerFeature.of(bVar.serialzeFeatures());
                            int iOf2 = Feature.of(bVar.parseFeatures());
                            if (bVar.name().length() != 0) {
                                name = bVar.name();
                            }
                            i11 = iOrdinal;
                            i12 = iOf;
                            i13 = iOf2;
                        }
                        if (propertyNamingStrategy != null) {
                            name = propertyNamingStrategy.translate(name);
                        }
                        a(list, new d(name, null, field, cls, type, i11, i12, i13, null, bVar, null, mapD));
                        break;
                        break;
                    }
                    if (it.next().f15532a.equals(field.getName())) {
                    }
                    break;
                    break;
                }
            }
            Class<?> type2 = field.getType();
            if (!Map.class.isAssignableFrom(type2) && !Collection.class.isAssignableFrom(type2) && !AtomicLong.class.equals(type2) && !AtomicInteger.class.equals(type2) && !AtomicBoolean.class.equals(type2)) {
                break;
                break;
            }
            it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    name = field.getName();
                    bVar = (j7.b) TypeUtils.O(field, j7.b.class);
                    if (bVar != null) {
                        i11 = 0;
                        i12 = 0;
                        i13 = 0;
                    } else if (!bVar.deserialize()) {
                        int iOrdinal2 = bVar.ordinal();
                        int iOf3 = SerializerFeature.of(bVar.serialzeFeatures());
                        int iOf4 = Feature.of(bVar.parseFeatures());
                        if (bVar.name().length() != 0) {
                            name = bVar.name();
                        }
                        i11 = iOrdinal2;
                        i12 = iOf3;
                        i13 = iOf4;
                    }
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    a(list, new d(name, null, field, cls, type, i11, i12, i13, null, bVar, null, mapD));
                    break;
                }
                if (it.next().f15532a.equals(field.getName())) {
                }
                break;
            }
            i14++;
        }
    }

    public static Class<?> f(Class<?> cls, j7.d dVar) {
        Class<?> clsBuilder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return TypeUtils.A0("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (dVar == null || (clsBuilder = dVar.builder()) == Void.class) {
            return null;
        }
        return clsBuilder;
    }

    public static Constructor<?> g(Constructor[] constructorArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            if (((j7.a) constructor2.getAnnotation(j7.a.class)) != null) {
                if (constructor != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor constructor3 : constructorArr) {
            Annotation[][] annotationArrD0 = TypeUtils.d0(constructor3);
            if (annotationArrD0.length != 0) {
                int length = annotationArrD0.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        if (constructor != null) {
                            throw new JSONException("multi-JSONCreator");
                        }
                        constructor = constructor3;
                        break;
                    }
                    Annotation[] annotationArr = annotationArrD0[i11];
                    int length2 = annotationArr.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length2) {
                            break;
                        }
                        if (annotationArr[i12] instanceof j7.b) {
                            break;
                        }
                        i12++;
                    }
                    i11++;
                }
            }
        }
        return constructor;
    }

    public static Constructor<?> h(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        for (Constructor<?> constructor2 : constructorArr) {
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Class<?>[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    public static Method i(Class<?> cls, Method[] methodArr, boolean z11) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((j7.a) TypeUtils.P(method2, j7.a.class)) != null) {
                if (method != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                method = method2;
            }
        }
        if (method != null || !z11) {
            return method;
        }
        for (Method method3 : methodArr) {
            if (TypeUtils.s0(method3)) {
                return method3;
            }
        }
        return method;
    }

    public static d j(List<d> list, String str) {
        for (d dVar : list) {
            if (dVar.f15532a.equals(str)) {
                return dVar;
            }
            Field field = dVar.f15534c;
            if (field != null && dVar.d() != null && field.getName().equals(str)) {
                return dVar;
            }
        }
        return null;
    }
}
