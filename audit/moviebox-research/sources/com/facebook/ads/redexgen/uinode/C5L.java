package com.facebook.ads.redexgen.uinode;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5L, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C5L<T> implements InvocationHandler {
    public static byte[] A02;
    public static String[] A03 = {"HJBbstbFgkhP2Es2YC6tj0WPrL", "4IOUVAMDExjQBHSpAfoXSYCtPyIaCI88", "z5PEOWpVsYBM96D6", "SPmK69spxohqfCa0SsQ", "2TZuMIK", "01EkjjI8QhZqdiHuXsMGI", "efeA7FnPjHODjVcAjRmk7", "pSZyNCg"};
    public ClassLoader A00;
    public T A01;

    static {
        A03();
    }

    public C5L(T t11, ClassLoader classLoader) {
        this.A01 = t11;
        this.A00 = classLoader;
    }

    public static Object A00(final ClassLoader classLoader, Method method) {
        Class<?> returnType = method.getReturnType();
        if (returnType.equals(Void.TYPE)) {
            return null;
        }
        if (returnType.isPrimitive()) {
            return Array.get(Array.newInstance(method.getReturnType(), 1), 0);
        }
        if (returnType.equals(String.class)) {
            return A02(0, 0, 23);
        }
        if (returnType.isInterface()) {
            return Proxy.newProxyInstance(classLoader, new Class[]{returnType}, new InvocationHandler() { // from class: com.facebook.ads.redexgen.X.5K
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method2, Object[] objArr) {
                    return C5L.A00(classLoader, method2);
                }
            });
        }
        return null;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[2].length() != 16) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[6] = "7LVLxstLm7VGVuwpoPddR";
            strArr[5] = "O4Ajby3FQpCfAUdim7NmB";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 40);
            i14++;
        }
    }

    public static void A03() {
        A02 = new byte[]{-20, -5, -12};
    }

    public final T A04() {
        return this.A01;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            return method.invoke(this.A01, objArr);
        } catch (Throwable th2) {
            if (th2 instanceof InvocationTargetException) {
                Throwable targetException = th2.getTargetException();
                if (targetException instanceof AnonymousClass22) {
                    throw new IllegalStateException(targetException.getMessage());
                }
            }
            Object objA00 = A00(this.A00, method);
            C1794Ym c1794YmA00 = AbstractC11227e.A00();
            if (c1794YmA00 == null) {
                return objA00;
            }
            c1794YmA00.A07().A9a(A02(0, 3, 99), C8A.A0O, new C8B(th2));
            return objA00;
        }
    }
}
