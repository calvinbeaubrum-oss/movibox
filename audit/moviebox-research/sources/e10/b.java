package e10;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static <T> void a(T t11, Class<T> cls) {
        if (t11 != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    public static <T> T b(T t11) {
        t11.getClass();
        return t11;
    }

    public static <T> T c(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }
}
