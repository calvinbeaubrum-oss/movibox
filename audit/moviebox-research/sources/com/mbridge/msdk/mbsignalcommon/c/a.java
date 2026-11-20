package com.mbridge.msdk.mbsignalcommon.c;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InterfaceC0499a f45674a;

    /* JADX INFO: renamed from: com.mbridge.msdk.mbsignalcommon.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0499a {
        boolean a(b.C0500a c0500a);
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {

        /* JADX INFO: renamed from: com.mbridge.msdk.mbsignalcommon.c.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0500a extends Throwable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Class<?> f45675a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f45676b;

            public C0500a(Exception exc) {
                super(exc);
            }

            public C0500a(String str) {
                super(str);
            }

            public final void a(Class<?> cls) {
                this.f45675a = cls;
            }

            public final void a(String str) {
                this.f45676b = str;
            }

            @Override // java.lang.Throwable
            public final String toString() {
                if (getCause() == null) {
                    return super.toString();
                }
                return C0500a.class.getName() + ": " + getCause();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c<C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected Class<C> f45677a;

        public c(Class<C> cls) {
            this.f45677a = cls;
        }

        public final d a(String str, Class<?>... clsArr) throws b.C0500a {
            return new d(this.f45677a, str, clsArr, 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Method f45678a;

        public d(Class<?> cls, String str, Class<?>[] clsArr, int i11) throws b.C0500a {
            Method declaredMethod = null;
            if (cls == null) {
                this.f45678a = null;
                return;
            }
            while (cls != Object.class && cls != null) {
                try {
                    declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    break;
                } catch (NoSuchMethodException e11) {
                    if (MBridgeConstans.DEBUG && cls.getSuperclass() == Object.class) {
                        e11.printStackTrace();
                    }
                    cls = cls.getSuperclass();
                } catch (SecurityException e12) {
                    try {
                        try {
                            if (MBridgeConstans.DEBUG && cls.getSuperclass() == Object.class) {
                                e12.printStackTrace();
                            }
                            cls = cls.getSuperclass();
                        } catch (Exception e13) {
                            b.C0500a c0500a = new b.C0500a(e13);
                            c0500a.a(cls);
                            c0500a.a(str);
                            a.b(c0500a);
                        }
                    } catch (Throwable th2) {
                        this.f45678a = declaredMethod;
                        throw th2;
                    }
                }
            }
            if (declaredMethod != null) {
                if (i11 > 0 && (declaredMethod.getModifiers() & i11) != i11) {
                    a.b(new b.C0500a(declaredMethod + " does not match modifiers: " + i11));
                }
                declaredMethod.setAccessible(true);
            }
            this.f45678a = declaredMethod;
        }

        public final Object a(Object obj, Object... objArr) throws IllegalArgumentException, InvocationTargetException {
            Method method = this.f45678a;
            if (method == null) {
                return null;
            }
            try {
                return method.invoke(obj, objArr);
            } catch (Exception e11) {
                ad.a("MappingedMethod", "invoke error:" + e11.getMessage());
                return null;
            }
        }

        public final Method a() {
            return this.f45678a;
        }
    }

    public static <T> c<T> a(ClassLoader classLoader, String str) throws b.C0500a {
        try {
            return new c<>(classLoader.loadClass(str));
        } catch (Exception e11) {
            b(new b.C0500a(e11));
            return new c<>(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(b.C0500a c0500a) throws b.C0500a {
        InterfaceC0499a interfaceC0499a = f45674a;
        if (interfaceC0499a == null || !interfaceC0499a.a(c0500a)) {
            throw c0500a;
        }
    }
}
