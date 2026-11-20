package com.cloud.tmc.kernel.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Method> f31291a = new ConcurrentHashMap();

    public static Object a(Class<?> cls) {
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return Boolean.FALSE;
        }
        if (cls == Void.TYPE) {
            return null;
        }
        return (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) ? 0 : null;
    }

    public static Method b(Class<?> cls, String str, Class[] clsArr) throws NoSuchMethodException {
        String strConcat = cls.getName().concat(InstructionFileId.DOT).concat(str);
        if (clsArr != null && clsArr.length > 0) {
            String strConcat2 = strConcat.concat("(");
            for (Class cls2 : clsArr) {
                strConcat2 = strConcat2.concat(cls2.getName()).concat(",");
            }
            strConcat = strConcat2.substring(0, strConcat2.length() - 1).concat(")");
        }
        Method declaredMethod = null;
        try {
            Map<String, Method> map = f31291a;
            if (map.containsKey(strConcat)) {
                declaredMethod = map.get(strConcat);
            }
        } catch (Throwable unused) {
        }
        if (declaredMethod == null) {
            declaredMethod = clsArr == null ? cls.getDeclaredMethod(str, new Class[0]) : cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            f31291a.put(strConcat, declaredMethod);
        }
        return declaredMethod;
    }

    public static Object c(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Method methodB = b(cls, str, clsArr);
        return objArr == null ? methodB.invoke(obj, new Object[0]) : methodB.invoke(obj, objArr);
    }

    public static Object d(Object obj, String str) throws Exception {
        return c(obj.getClass(), obj, str, null, null);
    }

    public static Object e(String str, String str2) throws Exception {
        return c(Class.forName(str), null, str2, null, null);
    }
}
