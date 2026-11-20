package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.transsion.gslb.Utils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WP {
    private static Map<String, Method> pFF = new HashMap();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final Class<?>[] f27033sc;
    private static final HashMap<Class<?>, Class<?>> zY;

    static {
        HashMap<Class<?>, Class<?>> map = new HashMap<>();
        zY = map;
        map.put(Boolean.TYPE, Boolean.class);
        map.put(Byte.TYPE, Byte.class);
        map.put(Character.TYPE, Character.class);
        map.put(Short.TYPE, Short.class);
        map.put(Integer.TYPE, Integer.class);
        map.put(Long.TYPE, Long.class);
        map.put(Double.TYPE, Double.class);
        map.put(Float.TYPE, Float.class);
        map.put(Void.TYPE, Void.class);
        f27033sc = new Class[0];
    }

    private static String pFF(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cls.toString());
        sb2.append(Utils.SEPARATOR);
        sb2.append(str);
        sb2.append(Utils.SEPARATOR);
        sb2.append(cls.getClassLoader() != null ? Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        if (clsArr == null || clsArr.length <= 0) {
            sb2.append(Void.class.toString());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb2.append(cls2.toString());
                sb2.append(Utils.SEPARATOR);
            }
        }
        return sb2.toString();
    }

    public static int sc(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int sc(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Object sc(Object obj, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return sc(obj, str, objArr, sc(objArr));
    }

    public static Object sc(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method methodSc = sc(obj.getClass(), str, clsArr);
        if (methodSc != null) {
            return methodSc.invoke(obj, objArr);
        }
        throw new NoSuchMethodException(str);
    }

    public static Method sc(Class<?> cls, String str, Class<?>... clsArr) {
        Method declaredMethod;
        String strPFF = pFF(cls, str, clsArr);
        synchronized (pFF) {
            declaredMethod = pFF.get(strPFF);
        }
        if (declaredMethod != null) {
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return declaredMethod;
        }
        while (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (declaredMethod == null) {
                try {
                    for (Method method : cls.getDeclaredMethods()) {
                        if (method != null && TextUtils.equals(method.getName(), str)) {
                            Class<?>[] parameterTypes = method.getParameterTypes();
                            if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                                boolean z11 = true;
                                for (int i11 = 0; i11 < clsArr.length; i11++) {
                                    if (!sc(clsArr[i11], parameterTypes[i11])) {
                                        z11 = false;
                                    }
                                }
                                if (z11) {
                                    declaredMethod = method;
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                synchronized (pFF) {
                    pFF.put(strPFF, declaredMethod);
                }
                return declaredMethod;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static boolean sc(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = zY.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = zY.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    public static Class<?>[] sc(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return f27033sc;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Object obj = objArr[i11];
            clsArr[i11] = obj == null ? null : obj.getClass();
        }
        return clsArr;
    }
}
