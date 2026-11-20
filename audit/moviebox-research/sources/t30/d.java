package t30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f76803a = new b();

    /* JADX INFO: compiled from: source.java */
    public interface a {
        boolean a(Class<?> cls, Class<?> cls2);

        boolean b(Class<?> cls, Class<?> cls2);
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements a {
        @Override // t30.d.a
        public boolean a(Class<?> cls, Class<?> cls2) {
            return b(cls, cls2);
        }

        @Override // t30.d.a
        public boolean b(Class<?> cls, Class<?> cls2) {
            if (cls == l.class || cls2 == l.class || cls.isAssignableFrom(cls2) || cls2.isAssignableFrom(cls)) {
                return true;
            }
            if (d(cls, false) && d(cls2, true)) {
                return true;
            }
            if (cls.isPrimitive()) {
                return cls2.isPrimitive() || c(cls, cls2, true);
            }
            if (cls2.isPrimitive()) {
                return c(cls2, cls, false);
            }
            return false;
        }

        public final boolean c(Class<?> cls, Class<?> cls2, boolean z11) {
            if (cls == Boolean.TYPE) {
                return cls2 == Boolean.class;
            }
            if (cls != Integer.TYPE && cls != Long.TYPE && cls != Double.TYPE && cls != Float.TYPE) {
                if (cls == Character.TYPE) {
                    return cls2 == Character.class;
                }
                if (cls == Byte.TYPE) {
                    return cls2 == Byte.class;
                }
                return cls == Short.TYPE && cls2 == Short.class;
            }
            return d(cls2, z11);
        }

        public final boolean d(Class<?> cls, boolean z11) {
            return Number.class.isAssignableFrom(cls) || (z11 && cls == String.class);
        }
    }

    public static boolean a(Class<?> cls, Class<?> cls2) {
        return f76803a.a(cls, cls2);
    }

    public static boolean b(Class<?> cls, Class<?> cls2) {
        return f76803a.b(cls, cls2);
    }
}
