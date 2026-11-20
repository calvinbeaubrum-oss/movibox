package io;

import android.os.Build;
import androidx.media3.container.MdtaMetadataEntry;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f67262a = Pattern.compile("^(L[$_/a-zA-Z0-9]+)\\.([$_a-zA-Z0-9]+|<init>)(?:\\(((?:\\[*(?:Z|B|C|S|I|J|F|D|L[$_/a-zA-Z0-9]+;))*)\\)(\\[*(?:Z|B|C|S|I|J|F|D|V|L[$_/a-zA-Z0-9]+;)))?$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadWriteLock f67263b = d0.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHashMap f67264c = new WeakHashMap();

    public static /* synthetic */ Object f(Constructor constructor, Object[] objArr) {
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e11) {
            throw new RuntimeException(e11);
        }
    }

    public static /* synthetic */ Object g(Field field, androidx.core.util.l lVar) {
        try {
            return field.get(o(field) ? lVar.get() : field.getDeclaringClass());
        } catch (Exception e11) {
            throw new RuntimeException(e11);
        }
    }

    public static /* synthetic */ Object h(Method method, Object obj, Object[] objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e11) {
            throw new RuntimeException(e11);
        }
    }

    public static Member i(String str) throws NoSuchMethodException {
        Matcher matcher = f67262a.matcher(str);
        com.google.common.base.m.d(matcher.matches());
        String strGroup = matcher.group(1);
        Objects.requireNonNull(strGroup);
        Class clsM = m(strGroup.concat(";"));
        String strGroup2 = matcher.group(2);
        Objects.requireNonNull(strGroup2);
        String strGroup3 = matcher.group(3);
        String strGroup4 = matcher.group(4);
        if (strGroup3 == null) {
            return clsM.getField(strGroup2);
        }
        ArrayList arrayList = new ArrayList();
        while (!strGroup3.isEmpty()) {
            int iIndexOf = 0;
            while (strGroup3.charAt(iIndexOf) == '[') {
                iIndexOf++;
            }
            if (strGroup3.charAt(iIndexOf) == 'L') {
                iIndexOf = strGroup3.indexOf(59);
            }
            int i11 = iIndexOf + 1;
            arrayList.add(m(strGroup3.substring(0, i11)));
            strGroup3 = strGroup3.substring(i11);
        }
        Class<?>[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        if (strGroup2.equals("<init>")) {
            return clsM.getConstructor(clsArr);
        }
        Method method = clsM.getMethod(strGroup2, clsArr);
        Class<?> returnType = method.getReturnType();
        Objects.requireNonNull(strGroup4);
        com.google.common.base.m.d(returnType.equals(m(strGroup4)));
        return method;
    }

    public static /* synthetic */ void j(Field field, androidx.core.util.l lVar, Object obj) {
        try {
            field.set(o(field) ? lVar.get() : field.getDeclaringClass(), k(field.getType(), obj));
        } catch (Exception e11) {
            throw new RuntimeException(e11);
        }
    }

    public static Object k(Class<?> cls, Object obj) {
        if (cls.equals(Boolean.TYPE)) {
            if (obj instanceof Boolean) {
                return obj;
            }
            return Boolean.valueOf(((Number) obj).longValue() != 0);
        }
        if (cls.equals(Byte.TYPE)) {
            return Byte.valueOf((byte) ((Number) obj).longValue());
        }
        if (cls.equals(Short.TYPE)) {
            return Short.valueOf((short) ((Number) obj).longValue());
        }
        if (cls.equals(Character.TYPE)) {
            return obj instanceof Character ? obj : Character.valueOf((char) ((Number) obj).longValue());
        }
        if (cls.equals(Integer.TYPE)) {
            return Integer.valueOf((int) ((Number) obj).longValue());
        }
        if (cls.equals(Long.TYPE)) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (cls.equals(Float.TYPE)) {
            return Float.valueOf((float) ((Number) obj).doubleValue());
        }
        return cls.equals(Double.TYPE) ? Double.valueOf(((Number) obj).doubleValue()) : obj;
    }

    public static Class m(String str) {
        if (str.startsWith("[")) {
            return Class.forName(str.replace('/', '.'));
        }
        boolean z11 = false;
        if (str.length() != 1) {
            if (!str.isEmpty() && str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                z11 = true;
            }
            com.google.common.base.m.d(z11);
            return Class.forName(str.substring(1, str.length() - 1).replace('/', '.'));
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'V') {
            return Void.TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        switch (cCharAt) {
            case 'B':
                return Byte.TYPE;
            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static androidx.core.util.l<Object> n(Member member, androidx.core.util.l<Object> lVar) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            com.google.common.base.m.d(s.a(member));
        }
        final Method method = member instanceof Method ? (Method) member : null;
        final Constructor constructor = member instanceof Constructor ? (Constructor) member : null;
        com.google.common.base.m.d((method == null && constructor == null) ? false : true);
        Class<?>[] parameterTypes = i11 >= 26 ? t.a(member).getParameterTypes() : method != null ? method.getParameterTypes() : constructor.getParameterTypes();
        final Object[] objArr = new Object[parameterTypes.length];
        for (int i12 = r0 - 1; i12 >= 0; i12--) {
            objArr[i12] = k(parameterTypes[i12], lVar.get());
        }
        if (constructor != null) {
            return new androidx.core.util.l() { // from class: io.x
                @Override // androidx.core.util.l
                public final Object get() {
                    return a0.f(constructor, objArr);
                }
            };
        }
        final Object declaringClass = o(method) ? lVar.get() : method.getDeclaringClass();
        return new androidx.core.util.l() { // from class: io.y
            @Override // androidx.core.util.l
            public final Object get() {
                return a0.h(method, declaringClass, objArr);
            }
        };
    }

    public static boolean o(Member member) {
        return (member.getModifiers() & 8) == 0;
    }

    public static androidx.core.util.l<Object> p(final Field field, final androidx.core.util.l<Object> lVar) {
        return new androidx.core.util.l() { // from class: io.z
            @Override // androidx.core.util.l
            public final Object get() {
                return a0.g(field, lVar);
            }
        };
    }

    public static Member q(String str) {
        ReadWriteLock readWriteLock = f67263b;
        Lock lock = readWriteLock.readLock();
        lock.lock();
        try {
            WeakHashMap weakHashMap = f67264c;
            Member member = (Member) weakHashMap.get(str);
            if (member != null) {
                lock.unlock();
                return member;
            }
            lock.unlock();
            try {
                Member memberI = i(str);
                Lock lockWriteLock = readWriteLock.writeLock();
                lockWriteLock.lock();
                try {
                    weakHashMap.put(str, memberI);
                    return memberI;
                } finally {
                    lockWriteLock.unlock();
                }
            } catch (ClassNotFoundException e11) {
                e = e11;
                throw new RuntimeException(e);
            } catch (NoSuchFieldException e12) {
                e = e12;
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e13) {
                e = e13;
                throw new RuntimeException(e);
            }
        } catch (Throwable th2) {
            lock.unlock();
            throw th2;
        }
    }

    public static androidx.core.util.l<Member> r(final String str) {
        return new androidx.core.util.l() { // from class: io.v
            @Override // androidx.core.util.l
            public final Object get() {
                return a0.q(str);
            }
        };
    }

    public static androidx.core.util.a<Object> s(final Field field, final androidx.core.util.l<Object> lVar) {
        return new androidx.core.util.a() { // from class: io.w
            @Override // androidx.core.util.a
            public final void accept(Object obj) {
                a0.j(field, lVar, obj);
            }
        };
    }
}
