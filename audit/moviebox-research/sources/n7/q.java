package n7;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<o0> f71719a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<Character> f71720b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Character f71721c = ',';

    public final char f(o0 o0Var, Object obj, char c11) {
        ThreadLocal<o0> threadLocal = f71719a;
        o0 o0Var2 = threadLocal.get();
        threadLocal.set(o0Var);
        ThreadLocal<Character> threadLocal2 = f71720b;
        threadLocal2.set(Character.valueOf(c11));
        g(obj);
        threadLocal.set(o0Var2);
        return threadLocal2.get().charValue();
    }

    public abstract void g(Object obj);
}
